package com.tencent.mm.plugin.cdndownloader.c;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.f;
import com.tencent.mm.i.b.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements b.a
{
  private static a tLi = null;
  Queue<String> lHQ;
  Map<String, g> lHR;
  Map<String, g> lHS;
  private Map<String, Integer> lHT;
  private String lHU;
  private long lHV;
  public HashSet<String> lHW;
  private MMHandler tLh;
  private com.tencent.mm.aq.a tLj;
  
  public a()
  {
    AppMethodBeat.i(120711);
    this.lHQ = new LinkedList();
    this.lHR = new ConcurrentHashMap();
    this.lHS = new ConcurrentHashMap();
    this.lHT = new ConcurrentHashMap();
    this.tLh = new MMHandler("CdnDownloadNativeService#" + hashCode());
    this.tLj = null;
    this.lHU = "";
    this.lHV = 0L;
    this.lHW = new HashSet();
    AppMethodBeat.o(120711);
  }
  
  public static a cMu()
  {
    try
    {
      AppMethodBeat.i(120712);
      if (tLi == null) {
        tLi = new a();
      }
      a locala = tLi;
      AppMethodBeat.o(120712);
      return locala;
    }
    finally {}
  }
  
  public final boolean Vz(String paramString)
  {
    AppMethodBeat.i(120715);
    g localg = (g)this.lHS.remove(paramString);
    if (localg != null)
    {
      if ((localg.field_fileType != com.tencent.mm.i.a.iUi) && (localg.field_fileType != com.tencent.mm.i.a.iUk)) {
        break label154;
      }
      bkh();
      com.tencent.mm.aq.a.Vv(paramString);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(10769, new Object[] { Integer.valueOf(com.tencent.mm.aq.c.lIt), Integer.valueOf(localg.field_fileType), Long.valueOf(Util.nowMilliSecond() - localg.field_startTime) });
      this.lHR.remove(paramString);
      this.lHT.remove(paramString);
      Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
      AppMethodBeat.o(120715);
      return true;
      label154:
      if (localg.iUP)
      {
        bkh();
        com.tencent.mm.aq.a.Vw(paramString);
      }
      else
      {
        bkh();
        com.tencent.mm.aq.a.Vr(paramString);
      }
    }
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.c paramc, final d paramd)
  {
    AppMethodBeat.i(120718);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.CdnDownloadNativeService", "cdn callback mediaid is null");
      AppMethodBeat.o(120718);
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      Log.e("MicroMsg.CdnDownloadNativeService", "cdn callback info all null");
      AppMethodBeat.o(120718);
      return -2;
    }
    if (paramc != null) {
      Log.d("MicroMsg.CdnDownloadNativeService", "CDN progress. total:%d, cur:%d, canshow:%b, isUploadTask:%b", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify), Boolean.valueOf(paramc.field_isUploadTask) });
    }
    if (paramc != null) {}
    for (final boolean bool = paramc.field_isUploadTask;; bool = false)
    {
      this.lHV = Util.nowMilliSecond();
      this.lHU = paramString;
      this.tLh.postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(120708);
          g localg = (g)a.d(a.this).get(paramString);
          if (localg == null)
          {
            Log.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
            AppMethodBeat.o(120708);
            return;
          }
          if (paramc != null)
          {
            paramc.mediaId = paramString;
            Log.i("MicroMsg.CdnDownloadNativeService", "MTL: total:%d, cur:%d, mtl:%b, isSend:%b, isUploadTask:%b(%b)", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify), Boolean.valueOf(localg.gbt), Boolean.valueOf(paramc.field_isUploadTask), Boolean.valueOf(bool) });
            if (bool != localg.gbt)
            {
              AppMethodBeat.o(120708);
              return;
            }
          }
          if (paramd != null) {
            paramd.mediaId = paramString;
          }
          if (localg.iUG != null)
          {
            long l = Util.nowMilliSecond();
            if ((paramd == null) && (paramc != null) && (!paramc.field_mtlnotify) && (NetStatusUtil.getNetWorkType(MMApplicationContext.getContext()) == -1))
            {
              AppMethodBeat.o(120708);
              return;
            }
            localg.field_lastProgressCallbackTime = l;
            localg.iUG.a(paramString, 0, paramc, paramd, localg.field_onlycheckexist);
          }
          if (a.b(paramc)) {
            a.a(a.this).remove(paramString);
          }
          if (paramd != null)
          {
            a.d(a.this).remove(paramString);
            if (paramd.field_retCode == -5103011)
            {
              Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn ERR_VALIDATE_AUTHKEY");
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(546L, 4L, 1L, true);
              a.this.bkh().keep_OnRequestDoGetCdnDnsInfo(999);
            }
          }
          AppMethodBeat.o(120708);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(120709);
          String str = super.toString() + "|callback";
          AppMethodBeat.o(120709);
          return str;
        }
      });
      AppMethodBeat.o(120718);
      return 0;
    }
  }
  
  public final int a(final String paramString, final d paramd)
  {
    AppMethodBeat.i(216524);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(216524);
      return 0;
    }
    this.tLh.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(120710);
        g localg = (g)a.d(a.this).get(paramString);
        if (localg == null)
        {
          Log.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
          AppMethodBeat.o(120710);
          return;
        }
        if (localg.iUY != null) {
          localg.iUY.b(paramString, paramd);
        }
        AppMethodBeat.o(120710);
      }
    });
    AppMethodBeat.o(216524);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(120719);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.CdnDownloadNativeService", "cdn callback getauthbuf mediaid is null");
      AppMethodBeat.o(120719);
      return;
    }
    g localg = (g)this.lHS.get(paramString);
    if (localg == null)
    {
      Log.e("MicroMsg.CdnDownloadNativeService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(120719);
      return;
    }
    if (localg.iUG != null)
    {
      localg.iUG.a(paramString, paramByteArrayOutputStream);
      AppMethodBeat.o(120719);
      return;
    }
    Log.e("MicroMsg.CdnDownloadNativeService", "getCdnAuthInfo fail, null taskcallback.");
    AppMethodBeat.o(120719);
  }
  
  public final boolean asi(String paramString)
  {
    AppMethodBeat.i(216520);
    g localg = (g)this.lHS.get(paramString);
    Vz(paramString);
    if ((localg != null) && (localg.field_fullpath != null))
    {
      Log.i("MicroMsg.CdnDownloadNativeService", "cancelGameRecvTask, delete file:" + localg.field_fullpath);
      u.deleteFile(localg.field_fullpath);
    }
    AppMethodBeat.o(216520);
    return true;
  }
  
  public final com.tencent.mm.aq.a bkh()
  {
    AppMethodBeat.i(120713);
    if (this.tLj == null)
    {
      if (!MMApplicationContext.isMMProcess()) {
        break label47;
      }
      Log.i("MicroMsg.CdnDownloadNativeService", "use mm process cdn engine.");
    }
    for (this.tLj = f.bkh();; this.tLj = new com.tencent.mm.aq.a(MMApplicationContext.getContext().getFilesDir() + "/NativeCDNInfo", this))
    {
      com.tencent.mm.aq.a locala = this.tLj;
      AppMethodBeat.o(120713);
      return locala;
      label47:
      Log.i("MicroMsg.CdnDownloadNativeService", "use new cdn engine.");
    }
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(120720);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.CdnDownloadNativeService", "cdn callback decodePrepareResponse mediaid is null");
      AppMethodBeat.o(120720);
      return null;
    }
    g localg = (g)this.lHS.get(paramString);
    if (localg == null)
    {
      Log.e("MicroMsg.CdnDownloadNativeService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(120720);
      return null;
    }
    if (localg.iUG != null)
    {
      paramString = localg.iUG.f(paramString, paramArrayOfByte);
      AppMethodBeat.o(120720);
      return paramString;
    }
    Log.e("MicroMsg.CdnDownloadNativeService", "decodePrepareResponse fail, null taskcallback.");
    AppMethodBeat.o(120720);
    return null;
  }
  
  public final int h(final g paramg)
  {
    AppMethodBeat.i(120714);
    if (paramg == null)
    {
      Log.e("MicroMsg.CdnDownloadNativeService", "addRecvTask task info is null");
      AppMethodBeat.o(120714);
      return -1;
    }
    if (Util.isNullOrNil(paramg.field_mediaId))
    {
      Log.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId is null");
      AppMethodBeat.o(120714);
      return -1;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    if (this.lHQ.contains(paramg.field_fileId))
    {
      Log.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in queueTask");
      AppMethodBeat.o(120714);
      return -2;
    }
    if (this.lHR.containsKey(paramg.field_fileId))
    {
      Log.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapWaitTask");
      AppMethodBeat.o(120714);
      return -2;
    }
    if (this.lHS.containsKey(paramg.field_fileId))
    {
      Log.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapTaskInJni");
      AppMethodBeat.o(120714);
      return -2;
    }
    paramg.gbt = false;
    this.tLh.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(120706);
        if (this.lIe != -1) {
          a.a(a.this).put(paramg.field_mediaId, Integer.valueOf(this.lIe));
        }
        a.b(a.this).add(paramg.field_mediaId);
        a.c(a.this).put(paramg.field_mediaId, paramg);
        a locala = a.this;
        Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(locala.lHQ.size()) });
        Object localObject;
        g localg;
        label247:
        int j;
        for (;;)
        {
          if (!locala.lHQ.isEmpty())
          {
            localObject = (String)locala.lHQ.poll();
            localg = (g)locala.lHR.remove(localObject);
            if (localg == null)
            {
              Log.e("MicroMsg.CdnDownloadNativeService", "summersafecdn task queue is empty , maybe bug here");
              AppMethodBeat.o(120706);
              return;
            }
            Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { localg.field_mediaId, Boolean.valueOf(localg.field_autostart), Integer.valueOf(localg.field_chattype) });
            localg.field_startTime = Util.nowMilliSecond();
            if (localg.gbt)
            {
              if (localg.field_fullpath == null)
              {
                i = -1;
                if (localg.field_thumbpath != null) {
                  break label454;
                }
              }
              label454:
              for (j = -1;; j = localg.field_thumbpath.length())
              {
                Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Util.secPrint(localg.field_svr_signature), Util.secPrint(localg.field_aesKey), Integer.valueOf(localg.field_fileType), localg.field_mediaId, Boolean.valueOf(localg.field_onlycheckexist) });
                if (localg.field_fullpath == null) {
                  localg.field_fullpath = "";
                }
                if (localg.field_thumbpath == null) {
                  localg.field_thumbpath = "";
                }
                i = locala.bkh().b(localg);
                if (i == 0) {
                  break label466;
                }
                Log.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), localg.field_mediaId });
                if (localg.iUG == null) {
                  break;
                }
                localg.iUG.a(localg.field_mediaId, i, null, null, localg.field_onlycheckexist);
                break;
                i = localg.field_fullpath.length();
                break label247;
              }
              label466:
              Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia ok, field_mediaId[%s]", new Object[] { localg.field_mediaId });
              locala.lHS.put(localg.field_mediaId, localg);
            }
            else
            {
              j = -1;
              if ((localg.field_fileType == com.tencent.mm.i.a.iUi) || (localg.field_fileType == com.tencent.mm.i.a.iUk) || (localg.field_fileType == com.tencent.mm.i.a.iUl) || (localg.field_fileType == com.tencent.mm.i.a.iUm) || (localg.field_fileType == com.tencent.mm.i.a.iUn) || (localg.field_fileType == com.tencent.mm.i.a.iUp)) {
                if ((localg.field_fullpath == null) || (localg.field_fullpath.isEmpty())) {
                  break label1219;
                }
              }
            }
          }
        }
        label662:
        label962:
        label1219:
        for (int i = locala.bkh().a(localg.field_mediaId, localg.iUJ, localg.field_fullpath, localg.field_fileType, localg.iUK, localg.iUL, localg.iUM, localg.iUN, localg.iUU, localg.iUV);; i = -1)
        {
          if (localg.field_fullpath == null)
          {
            j = -1;
            Log.i("MicroMsg.CdnDownloadNativeService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d], ret:%d", new Object[] { Integer.valueOf(j), localg.field_mediaId, localg.iUJ, Integer.valueOf(localg.field_fileType), Integer.valueOf(i) });
          }
          for (;;)
          {
            if (i != 0)
            {
              Log.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), localg.field_mediaId });
              if (localg.iUG == null) {
                break;
              }
              localg.iUG.a(localg.field_mediaId, i, null, null, localg.field_onlycheckexist);
              break;
              j = localg.field_fullpath.length();
              break label662;
              if (localg.iUP)
              {
                i = j;
                if (localg.field_fullpath != null)
                {
                  i = j;
                  if (!localg.field_fullpath.isEmpty()) {
                    i = locala.bkh().a(localg.field_mediaId, localg.field_fullpath, localg.iUJ, localg.iUQ, localg.iUR, localg.allow_mobile_net_download, localg.iUK, localg.iUL, localg.is_resume_task, localg.iUO, localg.iUM);
                  }
                }
                if (localg.field_fullpath == null) {}
                for (localObject = "";; localObject = localg.field_fullpath)
                {
                  Log.i("MicroMsg.CdnDownloadNativeService", "game package download tryStart recv file:%s field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { localObject, localg.field_mediaId, localg.iUJ, localg.iUQ });
                  break;
                }
              }
              if (localg.field_fullpath == null)
              {
                i = -1;
                if (localg.field_thumbpath != null) {
                  break label1105;
                }
              }
              label1105:
              for (int k = -1;; k = localg.field_thumbpath.length())
              {
                Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), localg.field_svr_signature, localg.field_aesKey, Integer.valueOf(localg.field_fileType), localg.field_mediaId, Boolean.valueOf(localg.field_onlycheckexist) });
                if (localg.iUW != 2) {
                  break label1153;
                }
                if (!(localg instanceof com.tencent.mm.i.h)) {
                  break label1214;
                }
                localObject = (com.tencent.mm.i.h)localg;
                if (!((com.tencent.mm.i.h)localObject).arP()) {
                  break label1117;
                }
                i = locala.bkh().a(localg, 2);
                break;
                i = localg.field_fullpath.length();
                break label962;
              }
              label1117:
              i = j;
              if (((com.tencent.mm.i.h)localObject).arN())
              {
                ((com.tencent.mm.i.h)localObject).connectionCount = 1;
                ((com.tencent.mm.i.h)localObject).concurrentCount = 1;
                i = locala.bkh().a((com.tencent.mm.i.h)localObject);
              }
              continue;
              i = locala.bkh().c(localg);
              continue;
            }
            Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s]", new Object[] { localg.field_mediaId });
            locala.lHS.put(localg.field_mediaId, localg);
            break;
            AppMethodBeat.o(120706);
            return;
            i = -1;
          }
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(120707);
        String str = super.toString() + "|addRecvTask";
        AppMethodBeat.o(120707);
        return str;
      }
    });
    AppMethodBeat.o(120714);
    return 0;
  }
  
  public final int i(g paramg)
  {
    AppMethodBeat.i(120716);
    if (this.lHS.containsKey(paramg.field_mediaId))
    {
      i = CdnLogic.resumeHttpMultiSocketDownloadTask(paramg.field_mediaId);
      Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task resume mediaid:%s, ret:%d", new Object[] { paramg.field_mediaId, Integer.valueOf(i) });
      AppMethodBeat.o(120716);
      return i;
    }
    Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task add new mediaid:%s", new Object[] { paramg.field_mediaId });
    int i = h(paramg);
    AppMethodBeat.o(120716);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.c.a
 * JD-Core Version:    0.7.0.1
 */