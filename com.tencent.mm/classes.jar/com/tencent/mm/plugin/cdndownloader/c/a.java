package com.tencent.mm.plugin.cdndownloader.c;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a;
import com.tencent.mm.g.c;
import com.tencent.mm.g.g;
import com.tencent.mm.g.g.a;
import com.tencent.mm.g.g.b;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements b.a
{
  private static a wOx = null;
  Queue<String> oAp;
  Map<String, g> oAq;
  Map<String, g> oAr;
  private Map<String, Integer> oAs;
  private String oAt;
  private long oAu;
  public HashSet<String> oAv;
  private MMHandler wOw;
  private com.tencent.mm.modelcdntran.d wOy;
  
  public a()
  {
    AppMethodBeat.i(120711);
    this.oAp = new LinkedList();
    this.oAq = new ConcurrentHashMap();
    this.oAr = new ConcurrentHashMap();
    this.oAs = new ConcurrentHashMap();
    this.wOw = new MMHandler("CdnDownloadNativeService#" + hashCode());
    this.wOy = null;
    this.oAt = "";
    this.oAu = 0L;
    this.oAv = new HashSet();
    AppMethodBeat.o(120711);
  }
  
  public static a dpY()
  {
    try
    {
      AppMethodBeat.i(120712);
      if (wOx == null) {
        wOx = new a();
      }
      a locala = wOx;
      AppMethodBeat.o(120712);
      return locala;
    }
    finally {}
  }
  
  public final boolean Nz(String paramString)
  {
    AppMethodBeat.i(120715);
    g localg = (g)this.oAr.remove(paramString);
    int i;
    if (localg != null) {
      if ((localg.field_fileType == com.tencent.mm.g.a.lwn) || (localg.field_fileType == com.tencent.mm.g.a.lwp))
      {
        bHX();
        i = com.tencent.mm.modelcdntran.d.Nv(paramString);
        com.tencent.mm.plugin.report.service.h.OAn.b(10769, new Object[] { Integer.valueOf(com.tencent.mm.modelcdntran.h.oAS), Integer.valueOf(localg.field_fileType), Long.valueOf(Util.nowMilliSecond() - localg.field_startTime) });
      }
    }
    for (;;)
    {
      this.oAq.remove(paramString);
      this.oAs.remove(paramString);
      Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(i) });
      AppMethodBeat.o(120715);
      return true;
      if (localg.lwU)
      {
        bHX();
        i = com.tencent.mm.modelcdntran.d.Nw(paramString);
        break;
      }
      bHX();
      i = com.tencent.mm.modelcdntran.d.Nr(paramString);
      break;
      i = 0;
    }
  }
  
  public final int a(final String paramString, final c paramc, final com.tencent.mm.g.d paramd)
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
      this.oAu = Util.nowMilliSecond();
      this.oAt = paramString;
      this.wOw.postToWorker(new Runnable()
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
            Log.i("MicroMsg.CdnDownloadNativeService", "MTL: total:%d, cur:%d, mtl:%b, isSend:%b, isUploadTask:%b(%b)", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify), Boolean.valueOf(localg.ihD), Boolean.valueOf(paramc.field_isUploadTask), Boolean.valueOf(bool) });
            if (bool != localg.ihD)
            {
              AppMethodBeat.o(120708);
              return;
            }
          }
          if (paramd != null) {
            paramd.mediaId = paramString;
          }
          if (localg.lwL != null)
          {
            long l = Util.nowMilliSecond();
            if ((paramd == null) && (paramc != null) && (!paramc.field_mtlnotify) && (NetStatusUtil.getNetWorkType(MMApplicationContext.getContext()) == -1))
            {
              AppMethodBeat.o(120708);
              return;
            }
            localg.field_lastProgressCallbackTime = l;
            localg.lwL.a(paramString, 0, paramc, paramd, localg.field_onlycheckexist);
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
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(546L, 4L, 1L, true);
              a.this.bHX().keep_OnRequestDoGetCdnDnsInfo(999);
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
  
  public final int a(final String paramString, final com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(261605);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(261605);
      return 0;
    }
    this.wOw.postToWorker(new Runnable()
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
        if (localg.lxd != null) {
          localg.lxd.b(paramString, paramd);
        }
        AppMethodBeat.o(120710);
      }
    });
    AppMethodBeat.o(261605);
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
    g localg = (g)this.oAr.get(paramString);
    if (localg == null)
    {
      Log.e("MicroMsg.CdnDownloadNativeService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(120719);
      return;
    }
    if (localg.lwL != null)
    {
      localg.lwL.a(paramString, paramByteArrayOutputStream);
      AppMethodBeat.o(120719);
      return;
    }
    Log.e("MicroMsg.CdnDownloadNativeService", "getCdnAuthInfo fail, null taskcallback.");
    AppMethodBeat.o(120719);
  }
  
  public final boolean alM(String paramString)
  {
    AppMethodBeat.i(261601);
    g localg = (g)this.oAr.get(paramString);
    Nz(paramString);
    if ((localg != null) && (localg.field_fullpath != null))
    {
      Log.i("MicroMsg.CdnDownloadNativeService", "cancelGameRecvTask, delete file:" + localg.field_fullpath);
      y.deleteFile(localg.field_fullpath);
    }
    AppMethodBeat.o(261601);
    return true;
  }
  
  public final com.tencent.mm.modelcdntran.d bHX()
  {
    AppMethodBeat.i(120713);
    if (this.wOy == null)
    {
      if (!MMApplicationContext.isMMProcess()) {
        break label47;
      }
      Log.i("MicroMsg.CdnDownloadNativeService", "use mm process cdn engine.");
    }
    for (this.wOy = k.bHX();; this.wOy = new com.tencent.mm.modelcdntran.d(MMApplicationContext.getContext().getFilesDir() + "/NativeCDNInfo", this))
    {
      com.tencent.mm.modelcdntran.d locald = this.wOy;
      AppMethodBeat.o(120713);
      return locald;
      label47:
      Log.i("MicroMsg.CdnDownloadNativeService", "use new cdn engine.");
    }
  }
  
  public final byte[] h(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(120720);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.CdnDownloadNativeService", "cdn callback decodePrepareResponse mediaid is null");
      AppMethodBeat.o(120720);
      return null;
    }
    g localg = (g)this.oAr.get(paramString);
    if (localg == null)
    {
      Log.e("MicroMsg.CdnDownloadNativeService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(120720);
      return null;
    }
    if (localg.lwL != null)
    {
      paramString = localg.lwL.h(paramString, paramArrayOfByte);
      AppMethodBeat.o(120720);
      return paramString;
    }
    Log.e("MicroMsg.CdnDownloadNativeService", "decodePrepareResponse fail, null taskcallback.");
    AppMethodBeat.o(120720);
    return null;
  }
  
  public final int i(final g paramg)
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
    if (this.oAp.contains(paramg.field_fileId))
    {
      Log.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in queueTask");
      AppMethodBeat.o(120714);
      return -2;
    }
    if (this.oAq.containsKey(paramg.field_fileId))
    {
      Log.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapWaitTask");
      AppMethodBeat.o(120714);
      return -2;
    }
    if (this.oAr.containsKey(paramg.field_fileId))
    {
      Log.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapTaskInJni");
      AppMethodBeat.o(120714);
      return -2;
    }
    paramg.ihD = false;
    this.wOw.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(120706);
        if (this.oAD != -1) {
          a.a(a.this).put(paramg.field_mediaId, Integer.valueOf(this.oAD));
        }
        a.b(a.this).add(paramg.field_mediaId);
        a.c(a.this).put(paramg.field_mediaId, paramg);
        a locala = a.this;
        Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(locala.oAp.size()) });
        Object localObject;
        g localg;
        label247:
        int j;
        for (;;)
        {
          if (!locala.oAp.isEmpty())
          {
            localObject = (String)locala.oAp.poll();
            localg = (g)locala.oAq.remove(localObject);
            if (localg == null)
            {
              Log.e("MicroMsg.CdnDownloadNativeService", "summersafecdn task queue is empty , maybe bug here");
              AppMethodBeat.o(120706);
              return;
            }
            Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { localg.field_mediaId, Boolean.valueOf(localg.field_autostart), Integer.valueOf(localg.field_chattype) });
            localg.field_startTime = Util.nowMilliSecond();
            if (localg.ihD)
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
                i = locala.bHX().d(localg);
                if (i == 0) {
                  break label466;
                }
                Log.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), localg.field_mediaId });
                if (localg.lwL == null) {
                  break;
                }
                localg.lwL.a(localg.field_mediaId, i, null, null, localg.field_onlycheckexist);
                break;
                i = localg.field_fullpath.length();
                break label247;
              }
              label466:
              Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia ok, field_mediaId[%s]", new Object[] { localg.field_mediaId });
              locala.oAr.put(localg.field_mediaId, localg);
            }
            else
            {
              j = -1;
              if ((localg.field_fileType == com.tencent.mm.g.a.lwn) || (localg.field_fileType == com.tencent.mm.g.a.lwp) || (localg.field_fileType == com.tencent.mm.g.a.lwq) || (localg.field_fileType == com.tencent.mm.g.a.lwr) || (localg.field_fileType == com.tencent.mm.g.a.lws) || (localg.field_fileType == com.tencent.mm.g.a.lwu)) {
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
        for (int i = locala.bHX().a(localg.field_mediaId, localg.lwO, localg.field_fullpath, localg.field_fileType, localg.lwP, localg.lwQ, localg.lwR, localg.lwS, localg.lwZ, localg.lxa);; i = -1)
        {
          if (localg.field_fullpath == null)
          {
            j = -1;
            Log.i("MicroMsg.CdnDownloadNativeService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d], ret:%d", new Object[] { Integer.valueOf(j), localg.field_mediaId, localg.lwO, Integer.valueOf(localg.field_fileType), Integer.valueOf(i) });
          }
          for (;;)
          {
            if (i != 0)
            {
              Log.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), localg.field_mediaId });
              if (localg.lwL == null) {
                break;
              }
              localg.lwL.a(localg.field_mediaId, i, null, null, localg.field_onlycheckexist);
              break;
              j = localg.field_fullpath.length();
              break label662;
              if (localg.lwU)
              {
                i = j;
                if (localg.field_fullpath != null)
                {
                  i = j;
                  if (!localg.field_fullpath.isEmpty()) {
                    i = locala.bHX().a(localg.field_mediaId, localg.field_fullpath, localg.lwO, localg.lwV, localg.lwW, localg.allow_mobile_net_download, localg.lwP, localg.lwQ, localg.is_resume_task, localg.lwT, localg.lwR);
                  }
                }
                if (localg.field_fullpath == null) {}
                for (localObject = "";; localObject = localg.field_fullpath)
                {
                  Log.i("MicroMsg.CdnDownloadNativeService", "game package download tryStart recv file:%s field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { localObject, localg.field_mediaId, localg.lwO, localg.lwV });
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
                if (localg.lxb != 2) {
                  break label1153;
                }
                if (!(localg instanceof com.tencent.mm.g.h)) {
                  break label1214;
                }
                localObject = (com.tencent.mm.g.h)localg;
                if (!((com.tencent.mm.g.h)localObject).aLL()) {
                  break label1117;
                }
                i = locala.bHX().a(localg, 2);
                break;
                i = localg.field_fullpath.length();
                break label962;
              }
              label1117:
              i = j;
              if (((com.tencent.mm.g.h)localObject).aLJ())
              {
                ((com.tencent.mm.g.h)localObject).connectionCount = 1;
                ((com.tencent.mm.g.h)localObject).concurrentCount = 1;
                i = locala.bHX().a((com.tencent.mm.g.h)localObject);
              }
              continue;
              i = locala.bHX().e(localg);
              continue;
            }
            Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s]", new Object[] { localg.field_mediaId });
            locala.oAr.put(localg.field_mediaId, localg);
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
  
  public final int j(g paramg)
  {
    AppMethodBeat.i(120716);
    if (this.oAr.containsKey(paramg.field_mediaId))
    {
      i = CdnLogic.resumeHttpMultiSocketDownloadTask(paramg.field_mediaId);
      Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task resume mediaid:%s, ret:%d", new Object[] { paramg.field_mediaId, Integer.valueOf(i) });
      AppMethodBeat.o(120716);
      return i;
    }
    Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task add new mediaid:%s", new Object[] { paramg.field_mediaId });
    int i = i(paramg);
    AppMethodBeat.o(120716);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.c.a
 * JD-Core Version:    0.7.0.1
 */