package com.tencent.mm.plugin.cdndownloader.c;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.b.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements b.a
{
  private static a oXu = null;
  Queue<String> hWA;
  Map<String, com.tencent.mm.i.g> hWB;
  Map<String, com.tencent.mm.i.g> hWC;
  private Map<String, Integer> hWD;
  private String hWE;
  private long hWF;
  public HashSet<String> hWG;
  private aq oXt;
  private com.tencent.mm.an.a oXv;
  
  public a()
  {
    AppMethodBeat.i(120711);
    this.hWA = new LinkedList();
    this.hWB = new ConcurrentHashMap();
    this.hWC = new ConcurrentHashMap();
    this.hWD = new ConcurrentHashMap();
    this.oXt = new aq("CdnDownloadNativeService#" + hashCode());
    this.oXv = null;
    this.hWE = "";
    this.hWF = 0L;
    this.hWG = new HashSet();
    AppMethodBeat.o(120711);
  }
  
  public static boolean aao(String paramString)
  {
    AppMethodBeat.i(120717);
    int i = CdnLogic.pauseHttpMultiSocketDownloadTask(paramString);
    ae.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra pauseRecvTask mediaid:%s, ret:%d", new Object[] { paramString, Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(120717);
      return true;
    }
    AppMethodBeat.o(120717);
    return false;
  }
  
  public static a cai()
  {
    try
    {
      AppMethodBeat.i(120712);
      if (oXu == null) {
        oXu = new a();
      }
      a locala = oXu;
      AppMethodBeat.o(120712);
      return locala;
    }
    finally {}
  }
  
  public final boolean Fs(String paramString)
  {
    AppMethodBeat.i(120715);
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hWC.remove(paramString);
    if (localg != null)
    {
      if ((localg.field_fileType != com.tencent.mm.i.a.fKO) && (localg.field_fileType != com.tencent.mm.i.a.fKQ)) {
        break label154;
      }
      aHa();
      com.tencent.mm.an.a.Fo(paramString);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(10769, new Object[] { Integer.valueOf(com.tencent.mm.an.c.hXd), Integer.valueOf(localg.field_fileType), Long.valueOf(bu.fpO() - localg.field_startTime) });
      this.hWB.remove(paramString);
      this.hWD.remove(paramString);
      ae.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
      AppMethodBeat.o(120715);
      return true;
      label154:
      if (localg.fLv)
      {
        aHa();
        com.tencent.mm.an.a.Fp(paramString);
      }
      else
      {
        aHa();
        com.tencent.mm.an.a.Fk(paramString);
      }
    }
  }
  
  public final int a(final String paramString, final com.tencent.mm.i.c paramc, final d paramd)
  {
    AppMethodBeat.i(120718);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.CdnDownloadNativeService", "cdn callback mediaid is null");
      AppMethodBeat.o(120718);
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      ae.e("MicroMsg.CdnDownloadNativeService", "cdn callback info all null");
      AppMethodBeat.o(120718);
      return -2;
    }
    if (paramc != null) {
      ae.d("MicroMsg.CdnDownloadNativeService", "CDN progress. total:%d, cur:%d, canshow:%b, isUploadTask:%b", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify), Boolean.valueOf(paramc.field_isUploadTask) });
    }
    if (paramc != null) {}
    for (final boolean bool = paramc.field_isUploadTask;; bool = false)
    {
      this.hWF = bu.fpO();
      this.hWE = paramString;
      this.oXt.postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(120708);
          com.tencent.mm.i.g localg = (com.tencent.mm.i.g)a.d(a.this).get(paramString);
          if (localg == null)
          {
            ae.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
            AppMethodBeat.o(120708);
            return;
          }
          if (paramc != null)
          {
            paramc.mediaId = paramString;
            ae.i("MicroMsg.CdnDownloadNativeService", "MTL: total:%d, cur:%d, mtl:%b, isSend:%b, isUploadTask:%b(%b)", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify), Boolean.valueOf(localg.dPh), Boolean.valueOf(paramc.field_isUploadTask), Boolean.valueOf(bool) });
            if (bool != localg.dPh)
            {
              AppMethodBeat.o(120708);
              return;
            }
          }
          if (paramd != null) {
            paramd.mediaId = paramString;
          }
          if (localg.fLm != null)
          {
            long l = bu.fpO();
            if ((paramd == null) && (paramc != null) && (!paramc.field_mtlnotify) && (az.getNetWorkType(ak.getContext()) == -1))
            {
              AppMethodBeat.o(120708);
              return;
            }
            localg.field_lastProgressCallbackTime = l;
            localg.fLm.a(paramString, 0, paramc, paramd, localg.field_onlycheckexist);
          }
          if (a.b(paramc)) {
            a.a(a.this).remove(paramString);
          }
          if (paramd != null)
          {
            a.d(a.this).remove(paramString);
            if (paramd.field_retCode == -5103011)
            {
              ae.i("MicroMsg.CdnDownloadNativeService", "summersafecdn ERR_VALIDATE_AUTHKEY");
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(546L, 4L, 1L, true);
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
    AppMethodBeat.i(220275);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(220275);
      return 0;
    }
    this.oXt.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(120710);
        com.tencent.mm.i.g localg = (com.tencent.mm.i.g)a.d(a.this).get(paramString);
        if (localg == null)
        {
          ae.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
          AppMethodBeat.o(120710);
          return;
        }
        if (localg.fLE != null) {
          localg.fLE.b(paramString, paramd);
        }
        AppMethodBeat.o(120710);
      }
    });
    AppMethodBeat.o(220275);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(120719);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.CdnDownloadNativeService", "cdn callback getauthbuf mediaid is null");
      AppMethodBeat.o(120719);
      return;
    }
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hWC.get(paramString);
    if (localg == null)
    {
      ae.e("MicroMsg.CdnDownloadNativeService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(120719);
      return;
    }
    if (localg.fLm != null)
    {
      localg.fLm.a(paramString, paramByteArrayOutputStream);
      AppMethodBeat.o(120719);
      return;
    }
    ae.e("MicroMsg.CdnDownloadNativeService", "getCdnAuthInfo fail, null taskcallback.");
    AppMethodBeat.o(120719);
  }
  
  final com.tencent.mm.an.a aHa()
  {
    AppMethodBeat.i(120713);
    if (this.oXv == null)
    {
      if (!ak.cpe()) {
        break label47;
      }
      ae.i("MicroMsg.CdnDownloadNativeService", "use mm process cdn engine.");
    }
    for (this.oXv = f.aHa();; this.oXv = new com.tencent.mm.an.a(ak.getContext().getFilesDir() + "/NativeCDNInfo", this))
    {
      com.tencent.mm.an.a locala = this.oXv;
      AppMethodBeat.o(120713);
      return locala;
      label47:
      ae.i("MicroMsg.CdnDownloadNativeService", "use new cdn engine.");
    }
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(120720);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.CdnDownloadNativeService", "cdn callback decodePrepareResponse mediaid is null");
      AppMethodBeat.o(120720);
      return null;
    }
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hWC.get(paramString);
    if (localg == null)
    {
      ae.e("MicroMsg.CdnDownloadNativeService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(120720);
      return null;
    }
    if (localg.fLm != null)
    {
      paramString = localg.fLm.f(paramString, paramArrayOfByte);
      AppMethodBeat.o(120720);
      return paramString;
    }
    ae.e("MicroMsg.CdnDownloadNativeService", "decodePrepareResponse fail, null taskcallback.");
    AppMethodBeat.o(120720);
    return null;
  }
  
  public final int h(final com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(120714);
    if (paramg == null)
    {
      ae.e("MicroMsg.CdnDownloadNativeService", "addRecvTask task info is null");
      AppMethodBeat.o(120714);
      return -1;
    }
    if (bu.isNullOrNil(paramg.field_mediaId))
    {
      ae.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId is null");
      AppMethodBeat.o(120714);
      return -1;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    if (this.hWA.contains(paramg.field_fileId))
    {
      ae.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in queueTask");
      AppMethodBeat.o(120714);
      return -2;
    }
    if (this.hWB.containsKey(paramg.field_fileId))
    {
      ae.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapWaitTask");
      AppMethodBeat.o(120714);
      return -2;
    }
    if (this.hWC.containsKey(paramg.field_fileId))
    {
      ae.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapTaskInJni");
      AppMethodBeat.o(120714);
      return -2;
    }
    paramg.dPh = false;
    this.oXt.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(120706);
        if (this.hWO != -1) {
          a.a(a.this).put(paramg.field_mediaId, Integer.valueOf(this.hWO));
        }
        a.b(a.this).add(paramg.field_mediaId);
        a.c(a.this).put(paramg.field_mediaId, paramg);
        a locala = a.this;
        ae.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(locala.hWA.size()) });
        Object localObject;
        com.tencent.mm.i.g localg;
        label247:
        int j;
        for (;;)
        {
          if (!locala.hWA.isEmpty())
          {
            localObject = (String)locala.hWA.poll();
            localg = (com.tencent.mm.i.g)locala.hWB.remove(localObject);
            if (localg == null)
            {
              ae.e("MicroMsg.CdnDownloadNativeService", "summersafecdn task queue is empty , maybe bug here");
              AppMethodBeat.o(120706);
              return;
            }
            ae.i("MicroMsg.CdnDownloadNativeService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { localg.field_mediaId, Boolean.valueOf(localg.field_autostart), Integer.valueOf(localg.field_chattype) });
            localg.field_startTime = bu.fpO();
            if (localg.dPh)
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
                ae.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), bu.aSM(localg.field_svr_signature), bu.aSM(localg.field_aesKey), Integer.valueOf(localg.field_fileType), localg.field_mediaId, Boolean.valueOf(localg.field_onlycheckexist) });
                if (localg.field_fullpath == null) {
                  localg.field_fullpath = "";
                }
                if (localg.field_thumbpath == null) {
                  localg.field_thumbpath = "";
                }
                i = locala.aHa().b(localg);
                if (i == 0) {
                  break label466;
                }
                ae.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), localg.field_mediaId });
                if (localg.fLm == null) {
                  break;
                }
                localg.fLm.a(localg.field_mediaId, i, null, null, localg.field_onlycheckexist);
                break;
                i = localg.field_fullpath.length();
                break label247;
              }
              label466:
              ae.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia ok, field_mediaId[%s]", new Object[] { localg.field_mediaId });
              locala.hWC.put(localg.field_mediaId, localg);
            }
            else
            {
              j = -1;
              if ((localg.field_fileType == com.tencent.mm.i.a.fKO) || (localg.field_fileType == com.tencent.mm.i.a.fKQ) || (localg.field_fileType == com.tencent.mm.i.a.fKR) || (localg.field_fileType == com.tencent.mm.i.a.fKS) || (localg.field_fileType == com.tencent.mm.i.a.fKT) || (localg.field_fileType == com.tencent.mm.i.a.fKU)) {
                if ((localg.field_fullpath == null) || (localg.field_fullpath.isEmpty())) {
                  break label1267;
                }
              }
            }
          }
        }
        label662:
        label962:
        label1105:
        label1117:
        label1262:
        label1267:
        for (int i = locala.aHa().a(localg.field_mediaId, localg.fLp, localg.field_fullpath, localg.field_fileType, localg.fLq, localg.fLr, localg.fLs, localg.fLt, localg.fLA, localg.fLB);; i = -1)
        {
          if (localg.field_fullpath == null)
          {
            j = -1;
            ae.i("MicroMsg.CdnDownloadNativeService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d], ret:%d", new Object[] { Integer.valueOf(j), localg.field_mediaId, localg.fLp, Integer.valueOf(localg.field_fileType), Integer.valueOf(i) });
          }
          for (;;)
          {
            if (i != 0)
            {
              ae.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), localg.field_mediaId });
              if (localg.fLm == null) {
                break;
              }
              localg.fLm.a(localg.field_mediaId, i, null, null, localg.field_onlycheckexist);
              break;
              j = localg.field_fullpath.length();
              break label662;
              if (localg.fLv)
              {
                i = j;
                if (localg.field_fullpath != null)
                {
                  i = j;
                  if (!localg.field_fullpath.isEmpty()) {
                    i = locala.aHa().a(localg.field_mediaId, localg.field_fullpath, localg.fLp, localg.fLw, localg.fLx, localg.allow_mobile_net_download, localg.fLq, localg.fLr, localg.is_resume_task, localg.fLu, localg.fLs);
                  }
                }
                if (localg.field_fullpath == null) {}
                for (localObject = "";; localObject = localg.field_fullpath)
                {
                  ae.i("MicroMsg.CdnDownloadNativeService", "game package download tryStart recv file:%s field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { localObject, localg.field_mediaId, localg.fLp, localg.fLw });
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
              for (int k = -1;; k = localg.field_thumbpath.length())
              {
                ae.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), localg.field_svr_signature, localg.field_aesKey, Integer.valueOf(localg.field_fileType), localg.field_mediaId, Boolean.valueOf(localg.field_onlycheckexist) });
                if (localg.fLC != 2) {
                  break label1201;
                }
                if (!(localg instanceof h)) {
                  break label1262;
                }
                localObject = (h)localg;
                if (!((h)localObject).Yd()) {
                  break label1117;
                }
                i = locala.aHa().a(localg, 2);
                break;
                i = localg.field_fullpath.length();
                break label962;
              }
              i = j;
              if (((h)localObject).Yb()) {
                i = locala.aHa().a(((h)localObject).field_mediaId, ((h)localObject).url, ((h)localObject).referer, ((h)localObject).field_fullpath, ((h)localObject).fLI, ((h)localObject).fLe, ((h)localObject).isColdSnsData, ((h)localObject).signalQuality, ((h)localObject).snsScene, ((h)localObject).field_preloadRatio, ((h)localObject).preloadMinSize, ((h)localObject).field_requestVideoFormat, 1, 1);
              }
              continue;
              i = locala.aHa().c(localg);
              continue;
            }
            ae.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s]", new Object[] { localg.field_mediaId });
            locala.hWC.put(localg.field_mediaId, localg);
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
  
  public final int i(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(120716);
    if (this.hWC.containsKey(paramg.field_mediaId))
    {
      i = CdnLogic.resumeHttpMultiSocketDownloadTask(paramg.field_mediaId);
      ae.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task resume mediaid:%s, ret:%d", new Object[] { paramg.field_mediaId, Integer.valueOf(i) });
      AppMethodBeat.o(120716);
      return i;
    }
    ae.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task add new mediaid:%s", new Object[] { paramg.field_mediaId });
    int i = h(paramg);
    AppMethodBeat.o(120716);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.c.a
 * JD-Core Version:    0.7.0.1
 */