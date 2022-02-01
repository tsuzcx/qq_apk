package com.tencent.mm.plugin.cdndownloader.c;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.i.b.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h;
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
  private static a oQS = null;
  Queue<String> hTI;
  Map<String, com.tencent.mm.i.g> hTJ;
  Map<String, com.tencent.mm.i.g> hTK;
  private Map<String, Integer> hTL;
  private String hTM;
  private long hTN;
  public HashSet<String> hTO;
  private ap oQR;
  private com.tencent.mm.ao.a oQT;
  
  public a()
  {
    AppMethodBeat.i(120711);
    this.hTI = new LinkedList();
    this.hTJ = new ConcurrentHashMap();
    this.hTK = new ConcurrentHashMap();
    this.hTL = new ConcurrentHashMap();
    this.oQR = new ap("CdnDownloadNativeService#" + hashCode());
    this.oQT = null;
    this.hTM = "";
    this.hTN = 0L;
    this.hTO = new HashSet();
    AppMethodBeat.o(120711);
  }
  
  public static boolean Zx(String paramString)
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
  
  public static a bYT()
  {
    try
    {
      AppMethodBeat.i(120712);
      if (oQS == null) {
        oQS = new a();
      }
      a locala = oQS;
      AppMethodBeat.o(120712);
      return locala;
    }
    finally {}
  }
  
  public final boolean EQ(String paramString)
  {
    AppMethodBeat.i(120715);
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hTK.remove(paramString);
    if (localg != null)
    {
      if ((localg.field_fileType != com.tencent.mm.i.a.fIK) && (localg.field_fileType != com.tencent.mm.i.a.fIM)) {
        break label154;
      }
      aGJ();
      com.tencent.mm.ao.a.EM(paramString);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(10769, new Object[] { Integer.valueOf(com.tencent.mm.ao.c.hUl), Integer.valueOf(localg.field_fileType), Long.valueOf(bt.flT() - localg.field_startTime) });
      this.hTJ.remove(paramString);
      this.hTL.remove(paramString);
      ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
      AppMethodBeat.o(120715);
      return true;
      label154:
      if (localg.fJs)
      {
        aGJ();
        com.tencent.mm.ao.a.EN(paramString);
      }
      else
      {
        aGJ();
        com.tencent.mm.ao.a.EI(paramString);
      }
    }
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
      this.hTN = bt.flT();
      this.hTM = paramString;
      this.oQR.postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(120708);
          com.tencent.mm.i.g localg = (com.tencent.mm.i.g)a.d(a.this).get(paramString);
          if (localg == null)
          {
            ad.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
            AppMethodBeat.o(120708);
            return;
          }
          if (paramc != null)
          {
            paramc.mediaId = paramString;
            ad.i("MicroMsg.CdnDownloadNativeService", "MTL: total:%d, cur:%d, mtl:%b, isSend:%b, isUploadTask:%b(%b)", new Object[] { Long.valueOf(paramc.field_toltalLength), Long.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify), Boolean.valueOf(localg.dNR), Boolean.valueOf(paramc.field_isUploadTask), Boolean.valueOf(bool) });
            if (bool != localg.dNR)
            {
              AppMethodBeat.o(120708);
              return;
            }
          }
          if (paramd != null) {
            paramd.mediaId = paramString;
          }
          if (localg.fJj != null)
          {
            long l = bt.flT();
            if ((paramd == null) && (paramc != null) && (!paramc.field_mtlnotify) && (ay.getNetWorkType(aj.getContext()) == -1))
            {
              AppMethodBeat.o(120708);
              return;
            }
            localg.field_lastProgressCallbackTime = l;
            localg.fJj.a(paramString, 0, paramc, paramd, localg.field_onlycheckexist);
          }
          if (a.b(paramc)) {
            a.a(a.this).remove(paramString);
          }
          if (paramd != null)
          {
            a.d(a.this).remove(paramString);
            if (paramd.field_retCode == -5103011)
            {
              ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn ERR_VALIDATE_AUTHKEY");
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(546L, 4L, 1L, true);
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
    AppMethodBeat.i(195146);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(195146);
      return 0;
    }
    this.oQR.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(120710);
        com.tencent.mm.i.g localg = (com.tencent.mm.i.g)a.d(a.this).get(paramString);
        if (localg == null)
        {
          ad.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
          AppMethodBeat.o(120710);
          return;
        }
        if (localg.fJB != null) {
          localg.fJB.b(paramString, paramd);
        }
        AppMethodBeat.o(120710);
      }
    });
    AppMethodBeat.o(195146);
    return 0;
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
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hTK.get(paramString);
    if (localg == null)
    {
      ad.e("MicroMsg.CdnDownloadNativeService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(120719);
      return;
    }
    if (localg.fJj != null)
    {
      localg.fJj.a(paramString, paramByteArrayOutputStream);
      AppMethodBeat.o(120719);
      return;
    }
    ad.e("MicroMsg.CdnDownloadNativeService", "getCdnAuthInfo fail, null taskcallback.");
    AppMethodBeat.o(120719);
  }
  
  final com.tencent.mm.ao.a aGJ()
  {
    AppMethodBeat.i(120713);
    if (this.oQT == null)
    {
      if (!aj.cnC()) {
        break label47;
      }
      ad.i("MicroMsg.CdnDownloadNativeService", "use mm process cdn engine.");
    }
    for (this.oQT = f.aGJ();; this.oQT = new com.tencent.mm.ao.a(aj.getContext().getFilesDir() + "/NativeCDNInfo", this))
    {
      com.tencent.mm.ao.a locala = this.oQT;
      AppMethodBeat.o(120713);
      return locala;
      label47:
      ad.i("MicroMsg.CdnDownloadNativeService", "use new cdn engine.");
    }
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
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.hTK.get(paramString);
    if (localg == null)
    {
      ad.e("MicroMsg.CdnDownloadNativeService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(120720);
      return null;
    }
    if (localg.fJj != null)
    {
      paramString = localg.fJj.f(paramString, paramArrayOfByte);
      AppMethodBeat.o(120720);
      return paramString;
    }
    ad.e("MicroMsg.CdnDownloadNativeService", "decodePrepareResponse fail, null taskcallback.");
    AppMethodBeat.o(120720);
    return null;
  }
  
  public final int h(final com.tencent.mm.i.g paramg)
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
    if (this.hTI.contains(paramg.field_fileId))
    {
      ad.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in queueTask");
      AppMethodBeat.o(120714);
      return -2;
    }
    if (this.hTJ.containsKey(paramg.field_fileId))
    {
      ad.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapWaitTask");
      AppMethodBeat.o(120714);
      return -2;
    }
    if (this.hTK.containsKey(paramg.field_fileId))
    {
      ad.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapTaskInJni");
      AppMethodBeat.o(120714);
      return -2;
    }
    paramg.dNR = false;
    this.oQR.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(120706);
        if (this.hTW != -1) {
          a.a(a.this).put(paramg.field_mediaId, Integer.valueOf(this.hTW));
        }
        a.b(a.this).add(paramg.field_mediaId);
        a.c(a.this).put(paramg.field_mediaId, paramg);
        a locala = a.this;
        ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(locala.hTI.size()) });
        Object localObject;
        com.tencent.mm.i.g localg;
        label247:
        int j;
        for (;;)
        {
          if (!locala.hTI.isEmpty())
          {
            localObject = (String)locala.hTI.poll();
            localg = (com.tencent.mm.i.g)locala.hTJ.remove(localObject);
            if (localg == null)
            {
              ad.e("MicroMsg.CdnDownloadNativeService", "summersafecdn task queue is empty , maybe bug here");
              AppMethodBeat.o(120706);
              return;
            }
            ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { localg.field_mediaId, Boolean.valueOf(localg.field_autostart), Integer.valueOf(localg.field_chattype) });
            localg.field_startTime = bt.flT();
            if (localg.dNR)
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
                ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), bt.aRp(localg.field_svr_signature), bt.aRp(localg.field_aesKey), Integer.valueOf(localg.field_fileType), localg.field_mediaId, Boolean.valueOf(localg.field_onlycheckexist) });
                if (localg.field_fullpath == null) {
                  localg.field_fullpath = "";
                }
                if (localg.field_thumbpath == null) {
                  localg.field_thumbpath = "";
                }
                i = locala.aGJ().b(localg);
                if (i == 0) {
                  break label466;
                }
                ad.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), localg.field_mediaId });
                if (localg.fJj == null) {
                  break;
                }
                localg.fJj.a(localg.field_mediaId, i, null, null, localg.field_onlycheckexist);
                break;
                i = localg.field_fullpath.length();
                break label247;
              }
              label466:
              ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia ok, field_mediaId[%s]", new Object[] { localg.field_mediaId });
              locala.hTK.put(localg.field_mediaId, localg);
            }
            else
            {
              j = -1;
              if ((localg.field_fileType == com.tencent.mm.i.a.fIK) || (localg.field_fileType == com.tencent.mm.i.a.fIM) || (localg.field_fileType == com.tencent.mm.i.a.fIN) || (localg.field_fileType == com.tencent.mm.i.a.fIO) || (localg.field_fileType == com.tencent.mm.i.a.fIP) || (localg.field_fileType == com.tencent.mm.i.a.fIQ)) {
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
        for (int i = locala.aGJ().a(localg.field_mediaId, localg.fJm, localg.field_fullpath, localg.field_fileType, localg.fJn, localg.fJo, localg.fJp, localg.fJq, localg.fJx, localg.fJy);; i = -1)
        {
          if (localg.field_fullpath == null)
          {
            j = -1;
            ad.i("MicroMsg.CdnDownloadNativeService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d], ret:%d", new Object[] { Integer.valueOf(j), localg.field_mediaId, localg.fJm, Integer.valueOf(localg.field_fileType), Integer.valueOf(i) });
          }
          for (;;)
          {
            if (i != 0)
            {
              ad.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), localg.field_mediaId });
              if (localg.fJj == null) {
                break;
              }
              localg.fJj.a(localg.field_mediaId, i, null, null, localg.field_onlycheckexist);
              break;
              j = localg.field_fullpath.length();
              break label662;
              if (localg.fJs)
              {
                i = j;
                if (localg.field_fullpath != null)
                {
                  i = j;
                  if (!localg.field_fullpath.isEmpty()) {
                    i = locala.aGJ().a(localg.field_mediaId, localg.field_fullpath, localg.fJm, localg.fJt, localg.fJu, localg.allow_mobile_net_download, localg.fJn, localg.fJo, localg.is_resume_task, localg.fJr, localg.fJp);
                  }
                }
                if (localg.field_fullpath == null) {}
                for (localObject = "";; localObject = localg.field_fullpath)
                {
                  ad.i("MicroMsg.CdnDownloadNativeService", "game package download tryStart recv file:%s field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { localObject, localg.field_mediaId, localg.fJm, localg.fJt });
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
                ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), localg.field_svr_signature, localg.field_aesKey, Integer.valueOf(localg.field_fileType), localg.field_mediaId, Boolean.valueOf(localg.field_onlycheckexist) });
                if (localg.fJz != 2) {
                  break label1201;
                }
                if (!(localg instanceof h)) {
                  break label1262;
                }
                localObject = (h)localg;
                if (!((h)localObject).XT()) {
                  break label1117;
                }
                i = locala.aGJ().a(localg, 2);
                break;
                i = localg.field_fullpath.length();
                break label962;
              }
              i = j;
              if (((h)localObject).XR()) {
                i = locala.aGJ().a(((h)localObject).field_mediaId, ((h)localObject).url, ((h)localObject).referer, ((h)localObject).field_fullpath, ((h)localObject).fJF, ((h)localObject).fJa, ((h)localObject).isColdSnsData, ((h)localObject).signalQuality, ((h)localObject).snsScene, ((h)localObject).field_preloadRatio, ((h)localObject).preloadMinSize, ((h)localObject).field_requestVideoFormat, 1, 1);
              }
              continue;
              i = locala.aGJ().c(localg);
              continue;
            }
            ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s]", new Object[] { localg.field_mediaId });
            locala.hTK.put(localg.field_mediaId, localg);
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
    if (this.hTK.containsKey(paramg.field_mediaId))
    {
      i = CdnLogic.resumeHttpMultiSocketDownloadTask(paramg.field_mediaId);
      ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task resume mediaid:%s, ret:%d", new Object[] { paramg.field_mediaId, Integer.valueOf(i) });
      AppMethodBeat.o(120716);
      return i;
    }
    ad.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task add new mediaid:%s", new Object[] { paramg.field_mediaId });
    int i = h(paramg);
    AppMethodBeat.o(120716);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.c.a
 * JD-Core Version:    0.7.0.1
 */