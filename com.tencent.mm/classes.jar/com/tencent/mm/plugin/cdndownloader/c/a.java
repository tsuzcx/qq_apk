package com.tencent.mm.plugin.cdndownloader.c;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.i.b.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements b.a
{
  private static a nKx = null;
  Queue<String> haI;
  Map<String, g> haJ;
  Map<String, g> haK;
  private Map<String, Integer> haL;
  private String haM;
  private long haN;
  public HashSet<String> haO;
  private ap nKw;
  private com.tencent.mm.ao.a nKy;
  
  public a()
  {
    AppMethodBeat.i(120711);
    this.haI = new LinkedList();
    this.haJ = new ConcurrentHashMap();
    this.haK = new ConcurrentHashMap();
    this.haL = new ConcurrentHashMap();
    this.nKw = new ap("CdnDownloadNativeService#" + hashCode());
    this.nKy = null;
    this.haM = "";
    this.haN = 0L;
    this.haO = new HashSet();
    AppMethodBeat.o(120711);
  }
  
  public static boolean RC(String paramString)
  {
    AppMethodBeat.i(120717);
    int i = CdnLogic.pauseHttpMultiSocketDownloadTask(paramString);
    ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra pauseRecvTask mediaid:%s, ret:%d", new Object[] { paramString, Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(120717);
      return true;
    }
    AppMethodBeat.o(120717);
    return false;
  }
  
  public static a bNd()
  {
    try
    {
      AppMethodBeat.i(120712);
      if (nKx == null) {
        nKx = new a();
      }
      a locala = nKx;
      AppMethodBeat.o(120712);
      return locala;
    }
    finally {}
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.c paramc, final d paramd)
  {
    AppMethodBeat.i(120718);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.CdnDownloadNativeService", "cdn callback mediaid is null");
      AppMethodBeat.o(120718);
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      ad.e("MicroMsg.CdnDownloadNativeService", "cdn callback info all null");
      AppMethodBeat.o(120718);
      return -2;
    }
    if (paramc != null) {
      ad.d("MicroMsg.CdnDownloadNativeService", "CDN progress. total:%d, cur:%d, canshow:%b, isUploadTask:%b", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify), Boolean.valueOf(paramc.field_isUploadTask) });
    }
    if (paramc != null) {}
    for (final boolean bool = paramc.field_isUploadTask;; bool = false)
    {
      this.haN = bt.eGO();
      this.haM = paramString;
      this.nKw.postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(120708);
          g localg = (g)a.d(a.this).get(paramString);
          if (localg == null)
          {
            ad.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
            AppMethodBeat.o(120708);
            return;
          }
          if (paramc != null)
          {
            paramc.mediaId = paramString;
            ad.i("MicroMsg.CdnDownloadNativeService", "MTL: total:%d, cur:%d, mtl:%b, isSend:%b, isUploadTask:%b(%b)", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify), Boolean.valueOf(localg.dDS), Boolean.valueOf(paramc.field_isUploadTask), Boolean.valueOf(bool) });
            if (bool != localg.dDS)
            {
              AppMethodBeat.o(120708);
              return;
            }
          }
          if (paramd != null) {
            paramd.mediaId = paramString;
          }
          if (localg.fnH != null)
          {
            long l = bt.eGO();
            if ((paramd == null) && (paramc != null) && (!paramc.field_mtlnotify) && (ay.getNetWorkType(aj.getContext()) == -1))
            {
              AppMethodBeat.o(120708);
              return;
            }
            localg.field_lastProgressCallbackTime = l;
            localg.fnH.a(paramString, 0, paramc, paramd, localg.field_onlycheckexist);
          }
          if (a.a(paramc)) {
            a.a(a.this).remove(paramString);
          }
          if (paramd != null)
          {
            a.d(a.this).remove(paramString);
            if (paramd.field_retCode == -5103011)
            {
              ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn ERR_VALIDATE_AUTHKEY");
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(546L, 4L, 1L, true);
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
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(120719);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.CdnDownloadNativeService", "cdn callback getauthbuf mediaid is null");
      AppMethodBeat.o(120719);
      return;
    }
    g localg = (g)this.haK.get(paramString);
    if (localg == null)
    {
      ad.e("MicroMsg.CdnDownloadNativeService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(120719);
      return;
    }
    if (localg.fnH != null)
    {
      localg.fnH.a(paramString, paramByteArrayOutputStream);
      AppMethodBeat.o(120719);
      return;
    }
    ad.e("MicroMsg.CdnDownloadNativeService", "getCdnAuthInfo fail, null taskcallback.");
    AppMethodBeat.o(120719);
  }
  
  final com.tencent.mm.ao.a awM()
  {
    AppMethodBeat.i(120713);
    if (this.nKy == null)
    {
      if (!aj.cbv()) {
        break label44;
      }
      ad.i("MicroMsg.CdnDownloadNativeService", "use mm process cdn engine.");
    }
    for (this.nKy = f.awM();; this.nKy = new com.tencent.mm.ao.a(aj.getContext().getFilesDir() + "/NativeCDNInfo", this))
    {
      com.tencent.mm.ao.a locala = this.nKy;
      AppMethodBeat.o(120713);
      return locala;
      label44:
      ad.i("MicroMsg.CdnDownloadNativeService", "use new cdn engine.");
    }
  }
  
  public final int c(final String paramString, final d paramd)
  {
    AppMethodBeat.i(202381);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(202381);
      return 0;
    }
    this.nKw.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(120710);
        g localg = (g)a.d(a.this).get(paramString);
        if (localg == null)
        {
          ad.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
          AppMethodBeat.o(120710);
          return;
        }
        if (localg.fnY != null) {
          localg.fnY.a(paramString, paramd);
        }
        AppMethodBeat.o(120710);
      }
    });
    AppMethodBeat.o(202381);
    return 0;
  }
  
  public final int f(final g paramg)
  {
    AppMethodBeat.i(120714);
    if (paramg == null)
    {
      ad.e("MicroMsg.CdnDownloadNativeService", "addRecvTask task info is null");
      AppMethodBeat.o(120714);
      return -1;
    }
    if (bt.isNullOrNil(paramg.field_mediaId))
    {
      ad.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId is null");
      AppMethodBeat.o(120714);
      return -1;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    if (this.haI.contains(paramg.field_fileId))
    {
      ad.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in queueTask");
      AppMethodBeat.o(120714);
      return -2;
    }
    if (this.haJ.containsKey(paramg.field_fileId))
    {
      ad.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapWaitTask");
      AppMethodBeat.o(120714);
      return -2;
    }
    if (this.haK.containsKey(paramg.field_fileId))
    {
      ad.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapTaskInJni");
      AppMethodBeat.o(120714);
      return -2;
    }
    paramg.dDS = false;
    this.nKw.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(120706);
        if (this.haQ != -1) {
          a.a(a.this).put(paramg.field_mediaId, Integer.valueOf(this.haQ));
        }
        a.b(a.this).add(paramg.field_mediaId);
        a.c(a.this).put(paramg.field_mediaId, paramg);
        a locala = a.this;
        ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(locala.haI.size()) });
        Object localObject;
        g localg;
        label247:
        int j;
        for (;;)
        {
          if (!locala.haI.isEmpty())
          {
            localObject = (String)locala.haI.poll();
            localg = (g)locala.haJ.remove(localObject);
            if (localg == null)
            {
              ad.e("MicroMsg.CdnDownloadNativeService", "summersafecdn task queue is empty , maybe bug here");
              AppMethodBeat.o(120706);
              return;
            }
            ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { localg.field_mediaId, Boolean.valueOf(localg.field_autostart), Integer.valueOf(localg.field_chattype) });
            localg.field_startTime = bt.eGO();
            if (localg.dDS)
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
                ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), bt.aGs(localg.field_svr_signature), bt.aGs(localg.field_aesKey), Integer.valueOf(localg.field_fileType), localg.field_mediaId, Boolean.valueOf(localg.field_onlycheckexist) });
                if (localg.field_fullpath == null) {
                  localg.field_fullpath = "";
                }
                if (localg.field_thumbpath == null) {
                  localg.field_thumbpath = "";
                }
                i = locala.awM().b(localg);
                if (i == 0) {
                  break label466;
                }
                ad.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), localg.field_mediaId });
                if (localg.fnH == null) {
                  break;
                }
                localg.fnH.a(localg.field_mediaId, i, null, null, localg.field_onlycheckexist);
                break;
                i = localg.field_fullpath.length();
                break label247;
              }
              label466:
              ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia ok, field_mediaId[%s]", new Object[] { localg.field_mediaId });
              locala.haK.put(localg.field_mediaId, localg);
            }
            else
            {
              j = -1;
              if ((localg.field_fileType == com.tencent.mm.i.a.fnj) || (localg.field_fileType == com.tencent.mm.i.a.fnl) || (localg.field_fileType == com.tencent.mm.i.a.fnm) || (localg.field_fileType == com.tencent.mm.i.a.fnn) || (localg.field_fileType == com.tencent.mm.i.a.fno) || (localg.field_fileType == com.tencent.mm.i.a.fnp)) {
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
        for (int i = locala.awM().a(localg.field_mediaId, localg.fnK, localg.field_fullpath, localg.field_fileType, localg.fnL, localg.fnM, localg.fnN, localg.fnO, localg.fnV);; i = -1)
        {
          if (localg.field_fullpath == null)
          {
            j = -1;
            ad.i("MicroMsg.CdnDownloadNativeService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d], ret:%d", new Object[] { Integer.valueOf(j), localg.field_mediaId, localg.fnK, Integer.valueOf(localg.field_fileType), Integer.valueOf(i) });
          }
          for (;;)
          {
            if (i != 0)
            {
              ad.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), localg.field_mediaId });
              if (localg.fnH == null) {
                break;
              }
              localg.fnH.a(localg.field_mediaId, i, null, null, localg.field_onlycheckexist);
              break;
              j = localg.field_fullpath.length();
              break label657;
              if (localg.fnQ)
              {
                i = j;
                if (localg.field_fullpath != null)
                {
                  i = j;
                  if (!localg.field_fullpath.isEmpty()) {
                    i = locala.awM().a(localg.field_mediaId, localg.field_fullpath, localg.fnK, localg.fnR, localg.fnS, localg.allow_mobile_net_download, localg.fnL, localg.fnM, localg.is_resume_task, localg.fnP, localg.fnN);
                  }
                }
                if (localg.field_fullpath == null) {}
                for (localObject = "";; localObject = localg.field_fullpath)
                {
                  ad.i("MicroMsg.CdnDownloadNativeService", "game package download tryStart recv file:%s field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { localObject, localg.field_mediaId, localg.fnK, localg.fnR });
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
                ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), localg.field_svr_signature, localg.field_aesKey, Integer.valueOf(localg.field_fileType), localg.field_mediaId, Boolean.valueOf(localg.field_onlycheckexist) });
                if (localg.fnW != 2) {
                  break label1196;
                }
                if (!(localg instanceof com.tencent.mm.i.h)) {
                  break label1257;
                }
                localObject = (com.tencent.mm.i.h)localg;
                if (!((com.tencent.mm.i.h)localObject).UH()) {
                  break label1112;
                }
                i = locala.awM().a(localg, 2);
                break;
                i = localg.field_fullpath.length();
                break label957;
              }
              i = j;
              if (((com.tencent.mm.i.h)localObject).UF()) {
                i = locala.awM().a(((com.tencent.mm.i.h)localObject).field_mediaId, ((com.tencent.mm.i.h)localObject).url, ((com.tencent.mm.i.h)localObject).referer, ((com.tencent.mm.i.h)localObject).field_fullpath, ((com.tencent.mm.i.h)localObject).foc, ((com.tencent.mm.i.h)localObject).fnz, ((com.tencent.mm.i.h)localObject).isColdSnsData, ((com.tencent.mm.i.h)localObject).signalQuality, ((com.tencent.mm.i.h)localObject).snsScene, ((com.tencent.mm.i.h)localObject).field_preloadRatio, ((com.tencent.mm.i.h)localObject).preloadMinSize, ((com.tencent.mm.i.h)localObject).field_requestVideoFormat, 1, 1);
              }
              continue;
              i = locala.awM().c(localg);
              continue;
            }
            ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s]", new Object[] { localg.field_mediaId });
            locala.haK.put(localg.field_mediaId, localg);
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
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(120720);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.CdnDownloadNativeService", "cdn callback decodePrepareResponse mediaid is null");
      AppMethodBeat.o(120720);
      return null;
    }
    g localg = (g)this.haK.get(paramString);
    if (localg == null)
    {
      ad.e("MicroMsg.CdnDownloadNativeService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(120720);
      return null;
    }
    if (localg.fnH != null)
    {
      paramString = localg.fnH.f(paramString, paramArrayOfByte);
      AppMethodBeat.o(120720);
      return paramString;
    }
    ad.e("MicroMsg.CdnDownloadNativeService", "decodePrepareResponse fail, null taskcallback.");
    AppMethodBeat.o(120720);
    return null;
  }
  
  public final int g(g paramg)
  {
    AppMethodBeat.i(120716);
    if (this.haK.containsKey(paramg.field_mediaId))
    {
      i = CdnLogic.resumeHttpMultiSocketDownloadTask(paramg.field_mediaId);
      ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task resume mediaid:%s, ret:%d", new Object[] { paramg.field_mediaId, Integer.valueOf(i) });
      AppMethodBeat.o(120716);
      return i;
    }
    ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task add new mediaid:%s", new Object[] { paramg.field_mediaId });
    int i = f(paramg);
    AppMethodBeat.o(120716);
    return i;
  }
  
  public final boolean xL(String paramString)
  {
    AppMethodBeat.i(120715);
    g localg = (g)this.haK.remove(paramString);
    if (localg != null)
    {
      if ((localg.field_fileType != com.tencent.mm.i.a.fnj) && (localg.field_fileType != com.tencent.mm.i.a.fnl)) {
        break label157;
      }
      awM();
      com.tencent.mm.ao.a.xH(paramString);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(10769, new Object[] { Integer.valueOf(com.tencent.mm.ao.c.hbe), Integer.valueOf(localg.field_fileType), Long.valueOf(bt.eGO() - localg.field_startTime) });
      this.haJ.remove(paramString);
      this.haL.remove(paramString);
      ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
      AppMethodBeat.o(120715);
      return true;
      label157:
      if (localg.fnQ)
      {
        awM();
        com.tencent.mm.ao.a.xI(paramString);
      }
      else
      {
        awM();
        com.tencent.mm.ao.a.xD(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.c.a
 * JD-Core Version:    0.7.0.1
 */