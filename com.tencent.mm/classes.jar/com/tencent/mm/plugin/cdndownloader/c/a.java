package com.tencent.mm.plugin.cdndownloader.c;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.b.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements b.a
{
  private static a onx = null;
  Queue<String> hBj;
  Map<String, g> hBk;
  Map<String, g> hBl;
  private Map<String, Integer> hBm;
  private String hBn;
  private long hBo;
  public HashSet<String> hBp;
  private ao onw;
  private com.tencent.mm.an.a ony;
  
  public a()
  {
    AppMethodBeat.i(120711);
    this.hBj = new LinkedList();
    this.hBk = new ConcurrentHashMap();
    this.hBl = new ConcurrentHashMap();
    this.hBm = new ConcurrentHashMap();
    this.onw = new ao("CdnDownloadNativeService#" + hashCode());
    this.ony = null;
    this.hBn = "";
    this.hBo = 0L;
    this.hBp = new HashSet();
    AppMethodBeat.o(120711);
  }
  
  public static boolean VO(String paramString)
  {
    AppMethodBeat.i(120717);
    int i = CdnLogic.pauseHttpMultiSocketDownloadTask(paramString);
    ac.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra pauseRecvTask mediaid:%s, ret:%d", new Object[] { paramString, Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(120717);
      return true;
    }
    AppMethodBeat.o(120717);
    return false;
  }
  
  public static a bUo()
  {
    try
    {
      AppMethodBeat.i(120712);
      if (onx == null) {
        onx = new a();
      }
      a locala = onx;
      AppMethodBeat.o(120712);
      return locala;
    }
    finally {}
  }
  
  public final boolean BR(String paramString)
  {
    AppMethodBeat.i(120715);
    g localg = (g)this.hBl.remove(paramString);
    if (localg != null)
    {
      if ((localg.field_fileType != com.tencent.mm.i.a.fqD) && (localg.field_fileType != com.tencent.mm.i.a.fqF)) {
        break label154;
      }
      aDE();
      com.tencent.mm.an.a.BN(paramString);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(10769, new Object[] { Integer.valueOf(com.tencent.mm.an.c.hBF), Integer.valueOf(localg.field_fileType), Long.valueOf(bs.eWj() - localg.field_startTime) });
      this.hBk.remove(paramString);
      this.hBm.remove(paramString);
      ac.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
      AppMethodBeat.o(120715);
      return true;
      label154:
      if (localg.frk)
      {
        aDE();
        com.tencent.mm.an.a.BO(paramString);
      }
      else
      {
        aDE();
        com.tencent.mm.an.a.BJ(paramString);
      }
    }
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.c paramc, final d paramd)
  {
    AppMethodBeat.i(120718);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.CdnDownloadNativeService", "cdn callback mediaid is null");
      AppMethodBeat.o(120718);
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      ac.e("MicroMsg.CdnDownloadNativeService", "cdn callback info all null");
      AppMethodBeat.o(120718);
      return -2;
    }
    if (paramc != null) {
      ac.d("MicroMsg.CdnDownloadNativeService", "CDN progress. total:%d, cur:%d, canshow:%b, isUploadTask:%b", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify), Boolean.valueOf(paramc.field_isUploadTask) });
    }
    if (paramc != null) {}
    for (final boolean bool = paramc.field_isUploadTask;; bool = false)
    {
      this.hBo = bs.eWj();
      this.hBn = paramString;
      this.onw.postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(120708);
          g localg = (g)a.d(a.this).get(paramString);
          if (localg == null)
          {
            ac.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
            AppMethodBeat.o(120708);
            return;
          }
          if (paramc != null)
          {
            paramc.mediaId = paramString;
            ac.i("MicroMsg.CdnDownloadNativeService", "MTL: total:%d, cur:%d, mtl:%b, isSend:%b, isUploadTask:%b(%b)", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify), Boolean.valueOf(localg.dBE), Boolean.valueOf(paramc.field_isUploadTask), Boolean.valueOf(bool) });
            if (bool != localg.dBE)
            {
              AppMethodBeat.o(120708);
              return;
            }
          }
          if (paramd != null) {
            paramd.mediaId = paramString;
          }
          if (localg.frb != null)
          {
            long l = bs.eWj();
            if ((paramd == null) && (paramc != null) && (!paramc.field_mtlnotify) && (ax.getNetWorkType(ai.getContext()) == -1))
            {
              AppMethodBeat.o(120708);
              return;
            }
            localg.field_lastProgressCallbackTime = l;
            localg.frb.a(paramString, 0, paramc, paramd, localg.field_onlycheckexist);
          }
          if (a.a(paramc)) {
            a.a(a.this).remove(paramString);
          }
          if (paramd != null)
          {
            a.d(a.this).remove(paramString);
            if (paramd.field_retCode == -5103011)
            {
              ac.i("MicroMsg.CdnDownloadNativeService", "summersafecdn ERR_VALIDATE_AUTHKEY");
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(546L, 4L, 1L, true);
              a.e(a.this).keep_OnRequestDoGetCdnDnsInfo(999);
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
    AppMethodBeat.i(193260);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(193260);
      return 0;
    }
    this.onw.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(120710);
        g localg = (g)a.d(a.this).get(paramString);
        if (localg == null)
        {
          ac.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
          AppMethodBeat.o(120710);
          return;
        }
        if (localg.frs != null) {
          localg.frs.b(paramString, paramd);
        }
        AppMethodBeat.o(120710);
      }
    });
    AppMethodBeat.o(193260);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(120719);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.CdnDownloadNativeService", "cdn callback getauthbuf mediaid is null");
      AppMethodBeat.o(120719);
      return;
    }
    g localg = (g)this.hBl.get(paramString);
    if (localg == null)
    {
      ac.e("MicroMsg.CdnDownloadNativeService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(120719);
      return;
    }
    if (localg.frb != null)
    {
      localg.frb.a(paramString, paramByteArrayOutputStream);
      AppMethodBeat.o(120719);
      return;
    }
    ac.e("MicroMsg.CdnDownloadNativeService", "getCdnAuthInfo fail, null taskcallback.");
    AppMethodBeat.o(120719);
  }
  
  final com.tencent.mm.an.a aDE()
  {
    AppMethodBeat.i(120713);
    if (this.ony == null)
    {
      if (!ai.ciE()) {
        break label47;
      }
      ac.i("MicroMsg.CdnDownloadNativeService", "use mm process cdn engine.");
    }
    for (this.ony = f.aDE();; this.ony = new com.tencent.mm.an.a(ai.getContext().getFilesDir() + "/NativeCDNInfo", this))
    {
      com.tencent.mm.an.a locala = this.ony;
      AppMethodBeat.o(120713);
      return locala;
      label47:
      ac.i("MicroMsg.CdnDownloadNativeService", "use new cdn engine.");
    }
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(120720);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.CdnDownloadNativeService", "cdn callback decodePrepareResponse mediaid is null");
      AppMethodBeat.o(120720);
      return null;
    }
    g localg = (g)this.hBl.get(paramString);
    if (localg == null)
    {
      ac.e("MicroMsg.CdnDownloadNativeService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(120720);
      return null;
    }
    if (localg.frb != null)
    {
      paramString = localg.frb.f(paramString, paramArrayOfByte);
      AppMethodBeat.o(120720);
      return paramString;
    }
    ac.e("MicroMsg.CdnDownloadNativeService", "decodePrepareResponse fail, null taskcallback.");
    AppMethodBeat.o(120720);
    return null;
  }
  
  public final int g(final g paramg)
  {
    AppMethodBeat.i(120714);
    if (paramg == null)
    {
      ac.e("MicroMsg.CdnDownloadNativeService", "addRecvTask task info is null");
      AppMethodBeat.o(120714);
      return -1;
    }
    if (bs.isNullOrNil(paramg.field_mediaId))
    {
      ac.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId is null");
      AppMethodBeat.o(120714);
      return -1;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    if (this.hBj.contains(paramg.field_fileId))
    {
      ac.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in queueTask");
      AppMethodBeat.o(120714);
      return -2;
    }
    if (this.hBk.containsKey(paramg.field_fileId))
    {
      ac.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapWaitTask");
      AppMethodBeat.o(120714);
      return -2;
    }
    if (this.hBl.containsKey(paramg.field_fileId))
    {
      ac.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapTaskInJni");
      AppMethodBeat.o(120714);
      return -2;
    }
    paramg.dBE = false;
    this.onw.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(120706);
        if (this.hBr != -1) {
          a.a(a.this).put(paramg.field_mediaId, Integer.valueOf(this.hBr));
        }
        a.b(a.this).add(paramg.field_mediaId);
        a.c(a.this).put(paramg.field_mediaId, paramg);
        a locala = a.this;
        ac.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(locala.hBj.size()) });
        Object localObject;
        g localg;
        label247:
        int j;
        for (;;)
        {
          if (!locala.hBj.isEmpty())
          {
            localObject = (String)locala.hBj.poll();
            localg = (g)locala.hBk.remove(localObject);
            if (localg == null)
            {
              ac.e("MicroMsg.CdnDownloadNativeService", "summersafecdn task queue is empty , maybe bug here");
              AppMethodBeat.o(120706);
              return;
            }
            ac.i("MicroMsg.CdnDownloadNativeService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { localg.field_mediaId, Boolean.valueOf(localg.field_autostart), Integer.valueOf(localg.field_chattype) });
            localg.field_startTime = bs.eWj();
            if (localg.dBE)
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
                ac.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), bs.aLJ(localg.field_svr_signature), bs.aLJ(localg.field_aesKey), Integer.valueOf(localg.field_fileType), localg.field_mediaId, Boolean.valueOf(localg.field_onlycheckexist) });
                if (localg.field_fullpath == null) {
                  localg.field_fullpath = "";
                }
                if (localg.field_thumbpath == null) {
                  localg.field_thumbpath = "";
                }
                i = locala.aDE().b(localg);
                if (i == 0) {
                  break label466;
                }
                ac.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), localg.field_mediaId });
                if (localg.frb == null) {
                  break;
                }
                localg.frb.a(localg.field_mediaId, i, null, null, localg.field_onlycheckexist);
                break;
                i = localg.field_fullpath.length();
                break label247;
              }
              label466:
              ac.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia ok, field_mediaId[%s]", new Object[] { localg.field_mediaId });
              locala.hBl.put(localg.field_mediaId, localg);
            }
            else
            {
              j = -1;
              if ((localg.field_fileType == com.tencent.mm.i.a.fqD) || (localg.field_fileType == com.tencent.mm.i.a.fqF) || (localg.field_fileType == com.tencent.mm.i.a.fqG) || (localg.field_fileType == com.tencent.mm.i.a.fqH) || (localg.field_fileType == com.tencent.mm.i.a.fqI) || (localg.field_fileType == com.tencent.mm.i.a.fqJ)) {
                if ((localg.field_fullpath == null) || (localg.field_fullpath.isEmpty())) {
                  break label1262;
                }
              }
            }
          }
        }
        label657:
        label957:
        label1100:
        label1112:
        label1257:
        label1262:
        for (int i = locala.aDE().a(localg.field_mediaId, localg.fre, localg.field_fullpath, localg.field_fileType, localg.frf, localg.frg, localg.frh, localg.fri, localg.frp);; i = -1)
        {
          if (localg.field_fullpath == null)
          {
            j = -1;
            ac.i("MicroMsg.CdnDownloadNativeService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d], ret:%d", new Object[] { Integer.valueOf(j), localg.field_mediaId, localg.fre, Integer.valueOf(localg.field_fileType), Integer.valueOf(i) });
          }
          for (;;)
          {
            if (i != 0)
            {
              ac.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), localg.field_mediaId });
              if (localg.frb == null) {
                break;
              }
              localg.frb.a(localg.field_mediaId, i, null, null, localg.field_onlycheckexist);
              break;
              j = localg.field_fullpath.length();
              break label657;
              if (localg.frk)
              {
                i = j;
                if (localg.field_fullpath != null)
                {
                  i = j;
                  if (!localg.field_fullpath.isEmpty()) {
                    i = locala.aDE().a(localg.field_mediaId, localg.field_fullpath, localg.fre, localg.frl, localg.frm, localg.allow_mobile_net_download, localg.frf, localg.frg, localg.is_resume_task, localg.frj, localg.frh);
                  }
                }
                if (localg.field_fullpath == null) {}
                for (localObject = "";; localObject = localg.field_fullpath)
                {
                  ac.i("MicroMsg.CdnDownloadNativeService", "game package download tryStart recv file:%s field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { localObject, localg.field_mediaId, localg.fre, localg.frl });
                  break;
                }
              }
              if (localg.field_fullpath == null)
              {
                i = -1;
                if (localg.field_thumbpath != null) {
                  break label1100;
                }
              }
              for (int k = -1;; k = localg.field_thumbpath.length())
              {
                ac.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), localg.field_svr_signature, localg.field_aesKey, Integer.valueOf(localg.field_fileType), localg.field_mediaId, Boolean.valueOf(localg.field_onlycheckexist) });
                if (localg.frq != 2) {
                  break label1196;
                }
                if (!(localg instanceof com.tencent.mm.i.h)) {
                  break label1257;
                }
                localObject = (com.tencent.mm.i.h)localg;
                if (!((com.tencent.mm.i.h)localObject).VC()) {
                  break label1112;
                }
                i = locala.aDE().a(localg, 2);
                break;
                i = localg.field_fullpath.length();
                break label957;
              }
              i = j;
              if (((com.tencent.mm.i.h)localObject).VA()) {
                i = locala.aDE().a(((com.tencent.mm.i.h)localObject).field_mediaId, ((com.tencent.mm.i.h)localObject).url, ((com.tencent.mm.i.h)localObject).referer, ((com.tencent.mm.i.h)localObject).field_fullpath, ((com.tencent.mm.i.h)localObject).frw, ((com.tencent.mm.i.h)localObject).fqT, ((com.tencent.mm.i.h)localObject).isColdSnsData, ((com.tencent.mm.i.h)localObject).signalQuality, ((com.tencent.mm.i.h)localObject).snsScene, ((com.tencent.mm.i.h)localObject).field_preloadRatio, ((com.tencent.mm.i.h)localObject).preloadMinSize, ((com.tencent.mm.i.h)localObject).field_requestVideoFormat, 1, 1);
              }
              continue;
              i = locala.aDE().c(localg);
              continue;
            }
            ac.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s]", new Object[] { localg.field_mediaId });
            locala.hBl.put(localg.field_mediaId, localg);
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
  
  public final int h(g paramg)
  {
    AppMethodBeat.i(120716);
    if (this.hBl.containsKey(paramg.field_mediaId))
    {
      i = CdnLogic.resumeHttpMultiSocketDownloadTask(paramg.field_mediaId);
      ac.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task resume mediaid:%s, ret:%d", new Object[] { paramg.field_mediaId, Integer.valueOf(i) });
      AppMethodBeat.o(120716);
      return i;
    }
    ac.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task add new mediaid:%s", new Object[] { paramg.field_mediaId });
    int i = g(paramg);
    AppMethodBeat.o(120716);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.c.a
 * JD-Core Version:    0.7.0.1
 */