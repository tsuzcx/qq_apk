package com.tencent.mm.ak;

import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.jg;
import com.tencent.mm.j.b.a;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class b
  implements com.tencent.mm.ah.f, com.tencent.mm.j.b, b.a, m.b
{
  private int eiC = -1;
  ah eiD = new b.1(this, Looper.getMainLooper());
  com.tencent.mm.sdk.b.c<jg> eiE = new b.2(this);
  n eiF = new b.3(this);
  Queue<String> eiG = new LinkedList();
  public Map<String, com.tencent.mm.j.f> eiH = new HashMap();
  public Map<String, com.tencent.mm.j.f> eiI = new ConcurrentHashMap();
  public Map<String, Integer> eiJ = new HashMap();
  private String eiK = "";
  private long eiL = 0L;
  public HashSet<String> eiM = new HashSet();
  
  public b()
  {
    com.tencent.mm.kernel.g.DO().a(this.eiF);
    if (com.tencent.mm.kernel.g.DN().Dc()) {
      com.tencent.mm.kernel.g.DP().Dz().a(this);
    }
    com.tencent.mm.kernel.g.Dk().a(379, this);
    com.tencent.mm.sdk.b.a.udP.c(this.eiE);
    y.i("MicroMsg.CdnTransportService", "summersafecdn CdnTransportService init[%s] stack[%s]", new Object[] { Integer.valueOf(hashCode()), bk.csb() });
  }
  
  public static boolean iq(int paramInt)
  {
    com.tencent.mm.kernel.g.DN();
    if (com.tencent.mm.kernel.a.Db())
    {
      int i = bk.a((Integer)com.tencent.mm.kernel.g.DP().Dz().get(144385, null), 0);
      y.d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(i & paramInt), Boolean.valueOf(ae.eSJ) });
      if (ae.eSJ) {
        return true;
      }
      return (i & paramInt) > 0;
    }
    return true;
  }
  
  public final void MY()
  {
    com.tencent.mm.kernel.g.DN();
    a.b localb;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    String str8;
    String str9;
    if (com.tencent.mm.kernel.a.Db())
    {
      localb = new a.b(f.Ne());
      str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("EnableCDNUploadImg");
      str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("EnableCDNVerifyConnect");
      str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("EnableCDNVideoRedirectOC");
      str4 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("EnableStreamUploadVideo");
      str5 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("C2COverloadDelaySeconds");
      str6 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("SNSOverloadDelaySeconds");
      str7 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("EnableSnsStreamDownload");
      str8 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("EnableSnsImageDownload");
      str9 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("ApprovedVideoPrivateProtocolHosts");
    }
    for (;;)
    {
      try
      {
        if (!bk.bl(str1)) {
          localb.field_UseStreamCDN = Integer.valueOf(str1).intValue();
        }
        if (!bk.bl(str2)) {
          localb.field_EnableCDNVerifyConnect = Integer.valueOf(str2).intValue();
        }
        if (!bk.bl(str3)) {
          localb.field_EnableCDNVideoRedirectOC = Integer.valueOf(str3).intValue();
        }
        if (!bk.bl(str4)) {
          localb.field_EnableStreamUploadVideo = Integer.valueOf(str4).intValue();
        }
        if (!bk.bl(str5)) {
          localb.field_C2COverloadDelaySeconds = Integer.valueOf(str5).intValue();
        }
        if (!bk.bl(str6)) {
          localb.field_SNSOverloadDelaySeconds = Integer.valueOf(str6).intValue();
        }
        if (!bk.bl(str7)) {
          localb.field_EnableSnsStreamDownload = Integer.valueOf(str7).intValue();
        }
        if (!bk.bl(str8)) {
          localb.field_EnableSnsImageDownload = Integer.valueOf(str8).intValue();
        }
        if (!bk.bl(str9)) {
          localb.field_ApprovedVideoHosts = str9;
        }
        f.Nd();
        if (!iq(256)) {
          continue;
        }
        i = 1;
        localb.field_EnableSafeCDN = i;
        if (localb.field_UseStreamCDN != 0)
        {
          str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("ProgJPEGUploadSizeLimitWifi");
          str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("ProgJPEGUploadSizeLimit3G");
          str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("ProgJPEGDownloadSizeLimit");
          str4 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("ProgJPEGOnlyRecvPTL");
          str5 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("EnableJPEGDyncmicETL");
          if (!bk.bl(str1)) {
            localb.field_WifiEtl = Integer.valueOf(str1).intValue();
          }
          if (!bk.bl(str2)) {
            localb.field_noWifiEtl = Integer.valueOf(str2).intValue();
          }
          if (!bk.bl(str3)) {
            localb.field_Ptl = Integer.valueOf(str3).intValue();
          }
          if (!bk.bl(str4))
          {
            if (Integer.valueOf(str4).intValue() == 0) {
              continue;
            }
            bool = true;
            localb.field_onlyrecvPtl = bool;
          }
          if (!bk.bl(str5)) {
            localb.field_UseDynamicETL = Integer.valueOf(str5).intValue();
          }
        }
        y.i("MicroMsg.CdnTransportService", "summersafecdn streamcdn config[SVR]:%s", new Object[] { localb });
        if (this.eiC != -1)
        {
          y.w("MicroMsg.CdnTransportService", "cmd set snsimage flag: %d", new Object[] { Integer.valueOf(this.eiC) });
          localb.field_EnableSnsImageDownload = this.eiC;
        }
        f.Ne();
        a.a(localb);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        boolean bool;
        y.e("MicroMsg.CdnTransportService", localNumberFormatException.toString());
        continue;
        int i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
      }
      if (ae.eTi)
      {
        y.w("MicroMsg.CdnTransportService", "use cdn debug configure.");
        if (!ae.eTe) {
          continue;
        }
        i = 1;
        localb.field_UseStreamCDN = i;
        if (localb.field_UseStreamCDN != 0)
        {
          localb.field_onlysendETL = ae.eTf;
          localb.field_onlyrecvPtl = ae.eTg;
          if (!bk.bl(ae.eTb)) {
            localb.field_WifiEtl = Integer.valueOf(ae.eTb).intValue();
          }
          if (!bk.bl(ae.eTc)) {
            localb.field_noWifiEtl = Integer.valueOf(ae.eTc).intValue();
          }
          if (!bk.bl(ae.eTd)) {
            localb.field_Ptl = Integer.valueOf(ae.eTd).intValue();
          }
        }
        if (!ae.eTj) {
          continue;
        }
        i = 1;
        localb.field_EnableCDNVerifyConnect = i;
        if (!ae.eTk) {
          continue;
        }
        i = 1;
        localb.field_EnableCDNVideoRedirectOC = i;
        y.i("MicroMsg.CdnTransportService", "streamcdn config[DEBUG]:%s", new Object[] { localb });
        f.Ne();
        a.a(localb);
      }
      return;
      i = 0;
      continue;
      bool = false;
    }
  }
  
  public final int a(String paramString, com.tencent.mm.j.c paramc, d paramd)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.CdnTransportService", "cdn callback mediaid is null");
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      y.e("MicroMsg.CdnTransportService", "cdn callback info all null");
      return -2;
    }
    if (paramc != null) {
      y.d("MicroMsg.CdnTransportService", "CDN progress. total:%d, cur:%d, canshow:%b", new Object[] { Integer.valueOf(paramc.field_toltalLength), Integer.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify) });
    }
    this.eiL = bk.UY();
    this.eiK = paramString;
    com.tencent.mm.kernel.g.DS().O(new b.7(this, paramString, paramc, paramd));
    return 0;
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    if (!com.tencent.mm.kernel.g.DN().Dc()) {}
    int i;
    do
    {
      return;
      i = bk.e(paramObject, 0);
      y.d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
      if ((paramm != com.tencent.mm.kernel.g.DP().Dz()) || (i <= 0))
      {
        y.e("MicroMsg.CdnTransportService", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
        return;
      }
    } while (i != 144385);
    f.Na().Nf();
  }
  
  public final void a(String paramString, d paramd)
  {
    if (bk.bl(paramString)) {
      return;
    }
    com.tencent.mm.kernel.g.DS().O(new b.8(this, paramString, paramd));
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.CdnTransportService", "cdn callback getauthbuf mediaid is null");
      return;
    }
    com.tencent.mm.j.f localf = (com.tencent.mm.j.f)this.eiI.get(paramString);
    if (localf == null)
    {
      y.e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      return;
    }
    if (localf.dlP != null)
    {
      localf.dlP.a(paramString, paramByteArrayOutputStream);
      return;
    }
    y.e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
  }
  
  public final boolean b(com.tencent.mm.j.f paramf, int paramInt)
  {
    if (paramf == null)
    {
      y.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
      return false;
    }
    if (bk.bl(paramf.field_mediaId))
    {
      y.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
      return false;
    }
    if (paramf.field_fileId == null) {
      paramf.field_fileId = "";
    }
    if (paramf.field_aesKey == null) {
      paramf.field_aesKey = "";
    }
    paramf.ceg = false;
    com.tencent.mm.kernel.g.DS().O(new b.5(this, paramInt, paramf));
    return true;
  }
  
  public final void bT(boolean paramBoolean)
  {
    if ((!paramBoolean) && (f.Ne().MX()))
    {
      com.tencent.mm.kernel.g.DN();
      if (com.tencent.mm.kernel.a.Db())
      {
        y.w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
        f.Na().Nf();
        return;
      }
    }
    MY();
    y.i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(this.eiG.size()) });
    label69:
    Object localObject1;
    Object localObject3;
    int i;
    label193:
    int j;
    label203:
    Object localObject2;
    if (!this.eiG.isEmpty())
    {
      localObject1 = (String)this.eiG.poll();
      localObject3 = (com.tencent.mm.j.f)this.eiH.remove(localObject1);
      if (localObject3 == null)
      {
        y.e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
        return;
      }
      y.i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { ((com.tencent.mm.j.f)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.j.f)localObject3).field_autostart), Integer.valueOf(((com.tencent.mm.j.f)localObject3).field_chattype) });
      ((com.tencent.mm.j.f)localObject3).field_startTime = bk.UY();
      if (((com.tencent.mm.j.f)localObject3).ceg)
      {
        String str;
        if (((com.tencent.mm.j.f)localObject3).field_fullpath == null)
        {
          i = -1;
          if (((com.tencent.mm.j.f)localObject3).field_thumbpath != null) {
            break label563;
          }
          j = -1;
          y.i("MicroMsg.CdnTransportService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b] largesvideo[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), bk.aac(((com.tencent.mm.j.f)localObject3).field_svr_signature), bk.aac(((com.tencent.mm.j.f)localObject3).field_aesKey), Integer.valueOf(((com.tencent.mm.j.f)localObject3).field_fileType), ((com.tencent.mm.j.f)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.j.f)localObject3).field_onlycheckexist), Integer.valueOf(((com.tencent.mm.j.f)localObject3).field_largesvideo) });
          if (((com.tencent.mm.j.f)localObject3).field_fullpath == null) {
            ((com.tencent.mm.j.f)localObject3).field_fullpath = "";
          }
          if (((com.tencent.mm.j.f)localObject3).field_thumbpath == null) {
            ((com.tencent.mm.j.f)localObject3).field_thumbpath = "";
          }
          localObject1 = (com.tencent.mm.j.f)this.eiI.put(((com.tencent.mm.j.f)localObject3).field_mediaId, localObject3);
          localObject2 = (com.tencent.mm.j.f)this.eiI.get(((com.tencent.mm.j.f)localObject3).field_mediaId);
          if (localObject2 == null) {
            h.nFQ.a(594L, 5L, 1L, true);
          }
          f.Ne();
          i = a.b((com.tencent.mm.j.f)localObject3);
          str = ((com.tencent.mm.j.f)localObject3).field_mediaId;
          if (localObject1 != null) {
            break label575;
          }
          localObject1 = null;
          label409:
          if (localObject2 != null) {
            break label585;
          }
        }
        label563:
        label575:
        label585:
        for (localObject2 = null;; localObject2 = ((com.tencent.mm.j.f)localObject2).field_mediaId)
        {
          y.i("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { str, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
          if (i == 0) {
            break;
          }
          localObject1 = (com.tencent.mm.j.f)this.eiI.remove(((com.tencent.mm.j.f)localObject3).field_mediaId);
          y.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s remove[%s]", new Object[] { Integer.valueOf(i), ((com.tencent.mm.j.f)localObject3).field_mediaId, localObject1 });
          if (((com.tencent.mm.j.f)localObject3).dlP == null) {
            break;
          }
          ((com.tencent.mm.j.f)localObject3).dlP.a(((com.tencent.mm.j.f)localObject3).field_mediaId, i, null, null, ((com.tencent.mm.j.f)localObject3).field_onlycheckexist);
          break;
          i = ((com.tencent.mm.j.f)localObject3).field_fullpath.length();
          break label193;
          j = ((com.tencent.mm.j.f)localObject3).field_thumbpath.length();
          break label203;
          localObject1 = ((com.tencent.mm.j.f)localObject1).field_mediaId;
          break label409;
        }
      }
      i = -1;
      if (((com.tencent.mm.j.f)localObject3).field_fileType == 19)
      {
        f.Ne();
        i = a.a(((com.tencent.mm.j.f)localObject3).field_mediaId, ((com.tencent.mm.j.f)localObject3).dlQ, ((com.tencent.mm.j.f)localObject3).field_fullpath, ((com.tencent.mm.j.f)localObject3).field_fileType, ((com.tencent.mm.j.f)localObject3).field_aesKey, ((com.tencent.mm.j.f)localObject3).field_authKey);
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        y.e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), ((com.tencent.mm.j.f)localObject3).field_mediaId });
        if (((com.tencent.mm.j.f)localObject3).dlP == null) {
          break label69;
        }
        ((com.tencent.mm.j.f)localObject3).dlP.a(((com.tencent.mm.j.f)localObject3).field_mediaId, i, null, null, ((com.tencent.mm.j.f)localObject3).field_onlycheckexist);
        break label69;
        if ((((com.tencent.mm.j.f)localObject3).field_fileType == com.tencent.mm.j.a.dlx) || (((com.tencent.mm.j.f)localObject3).field_fileType == com.tencent.mm.j.a.dlz))
        {
          j = i;
          if (((com.tencent.mm.j.f)localObject3).field_fullpath != null)
          {
            j = i;
            if (!((com.tencent.mm.j.f)localObject3).field_fullpath.isEmpty())
            {
              f.Ne();
              j = a.a(((com.tencent.mm.j.f)localObject3).field_mediaId, ((com.tencent.mm.j.f)localObject3).dlQ, ((com.tencent.mm.j.f)localObject3).field_fullpath, ((com.tencent.mm.j.f)localObject3).field_fileType, ((com.tencent.mm.j.f)localObject3).dlR, ((com.tencent.mm.j.f)localObject3).dlS, ((com.tencent.mm.j.f)localObject3).dlT, ((com.tencent.mm.j.f)localObject3).dlU);
            }
          }
          if (((com.tencent.mm.j.f)localObject3).field_fullpath == null) {}
          for (i = -1;; i = ((com.tencent.mm.j.f)localObject3).field_fullpath.length())
          {
            y.i("MicroMsg.CdnTransportService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d]", new Object[] { Integer.valueOf(i), ((com.tencent.mm.j.f)localObject3).field_mediaId, ((com.tencent.mm.j.f)localObject3).dlQ, Integer.valueOf(((com.tencent.mm.j.f)localObject3).field_fileType) });
            i = j;
            break;
          }
        }
        if (((com.tencent.mm.j.f)localObject3).dlW)
        {
          j = i;
          if (((com.tencent.mm.j.f)localObject3).field_fullpath != null)
          {
            j = i;
            if (!((com.tencent.mm.j.f)localObject3).field_fullpath.isEmpty())
            {
              f.Ne();
              j = a.a(((com.tencent.mm.j.f)localObject3).field_mediaId, ((com.tencent.mm.j.f)localObject3).field_fullpath, ((com.tencent.mm.j.f)localObject3).dlQ, ((com.tencent.mm.j.f)localObject3).dlX, ((com.tencent.mm.j.f)localObject3).dlY, ((com.tencent.mm.j.f)localObject3).allow_mobile_net_download, ((com.tencent.mm.j.f)localObject3).dlR, ((com.tencent.mm.j.f)localObject3).dlS, ((com.tencent.mm.j.f)localObject3).is_resume_task, ((com.tencent.mm.j.f)localObject3).dlV, ((com.tencent.mm.j.f)localObject3).dlT);
            }
          }
          if (((com.tencent.mm.j.f)localObject3).field_fullpath == null) {}
          for (i = -1;; i = ((com.tencent.mm.j.f)localObject3).field_fullpath.length())
          {
            y.i("MicroMsg.CdnTransportService", "game package download tryStart recv file:%d field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { Integer.valueOf(i), ((com.tencent.mm.j.f)localObject3).field_mediaId, ((com.tencent.mm.j.f)localObject3).dlQ, ((com.tencent.mm.j.f)localObject3).dlX });
            i = j;
            break;
          }
        }
        if (((com.tencent.mm.j.f)localObject3).dlZ)
        {
          if (!(localObject3 instanceof com.tencent.mm.j.e)) {
            break label1620;
          }
          localObject1 = (com.tencent.mm.j.e)localObject3;
          f.Ne();
          i = a.a(((com.tencent.mm.j.e)localObject1).field_mediaId, ((com.tencent.mm.j.e)localObject1).url, ((com.tencent.mm.j.e)localObject1).referer, ((com.tencent.mm.j.e)localObject1).dlJ, ((com.tencent.mm.j.e)localObject1).dlK, ((com.tencent.mm.j.e)localObject1).dlL, ((com.tencent.mm.j.e)localObject1).dlM, ((com.tencent.mm.j.e)localObject1).dlN, ((com.tencent.mm.j.e)localObject1).isColdSnsData, ((com.tencent.mm.j.e)localObject1).signalQuality, ((com.tencent.mm.j.e)localObject1).snsScene, ((com.tencent.mm.j.e)localObject1).snsCipherKey, ((com.tencent.mm.j.e)localObject1).cCI, ((com.tencent.mm.j.e)localObject1).dlO, ((com.tencent.mm.j.e)localObject1).fileType);
          continue;
        }
        if (((com.tencent.mm.j.f)localObject3).field_fullpath == null)
        {
          j = -1;
          label1160:
          if (((com.tencent.mm.j.f)localObject3).field_thumbpath != null) {
            break label1304;
          }
        }
        label1304:
        for (int k = -1;; k = ((com.tencent.mm.j.f)localObject3).field_thumbpath.length())
        {
          y.i("MicroMsg.CdnTransportService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), ((com.tencent.mm.j.f)localObject3).field_svr_signature, ((com.tencent.mm.j.f)localObject3).field_aesKey, Integer.valueOf(((com.tencent.mm.j.f)localObject3).field_fileType), ((com.tencent.mm.j.f)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.j.f)localObject3).field_onlycheckexist) });
          if (((com.tencent.mm.j.f)localObject3).dma != 2) {
            break label1455;
          }
          if (!(localObject3 instanceof com.tencent.mm.j.g)) {
            break label1620;
          }
          localObject1 = (com.tencent.mm.j.g)localObject3;
          if (!((com.tencent.mm.j.g)localObject1).wZ()) {
            break label1317;
          }
          f.Ne();
          i = a.a((com.tencent.mm.j.f)localObject3, 2);
          break;
          j = ((com.tencent.mm.j.f)localObject3).field_fullpath.length();
          break label1160;
        }
        label1317:
        if (((com.tencent.mm.j.g)localObject1).wX())
        {
          f.Ne();
          i = a.a(((com.tencent.mm.j.g)localObject1).field_mediaId, ((com.tencent.mm.j.g)localObject1).url, ((com.tencent.mm.j.g)localObject1).referer, ((com.tencent.mm.j.g)localObject1).field_fullpath, ((com.tencent.mm.j.g)localObject1).dmg, ((com.tencent.mm.j.g)localObject1).dlK, ((com.tencent.mm.j.g)localObject1).initialDownloadOffset, ((com.tencent.mm.j.g)localObject1).initialDownloadLength, ((com.tencent.mm.j.g)localObject1).isColdSnsData, ((com.tencent.mm.j.g)localObject1).signalQuality, ((com.tencent.mm.j.g)localObject1).snsScene, ((com.tencent.mm.j.g)localObject1).field_preloadRatio, ((com.tencent.mm.j.g)localObject1).field_requestVideoFormat);
          continue;
        }
        if (((com.tencent.mm.j.g)localObject1).wY())
        {
          f.Ne();
          i = a.a(((com.tencent.mm.j.g)localObject1).field_mediaId, ((com.tencent.mm.j.g)localObject1).url, ((com.tencent.mm.j.g)localObject1).referer, ((com.tencent.mm.j.g)localObject1).field_fullpath, ((com.tencent.mm.j.g)localObject1).dmg, ((com.tencent.mm.j.g)localObject1).field_preloadRatio, ((com.tencent.mm.j.g)localObject1).concurrentCount);
        }
        continue;
        label1455:
        f.Ne();
        i = CdnLogic.startC2CDownload(a.a((com.tencent.mm.j.f)localObject3));
        continue;
      }
      localObject1 = (com.tencent.mm.j.f)this.eiI.put(((com.tencent.mm.j.f)localObject3).field_mediaId, localObject3);
      localObject2 = (com.tencent.mm.j.f)this.eiI.get(((com.tencent.mm.j.f)localObject3).field_mediaId);
      if (localObject2 == null) {
        h.nFQ.a(594L, 6L, 1L, true);
      }
      localObject3 = ((com.tencent.mm.j.f)localObject3).field_mediaId;
      if (localObject1 == null)
      {
        localObject1 = null;
        label1545:
        if (localObject2 != null) {
          break label1610;
        }
      }
      label1610:
      for (localObject2 = null;; localObject2 = ((com.tencent.mm.j.f)localObject2).field_mediaId)
      {
        y.i("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { localObject3, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
        break label69;
        break;
        localObject1 = ((com.tencent.mm.j.f)localObject1).field_mediaId;
        break label1545;
      }
      label1620:
      i = -1;
    }
  }
  
  public final boolean c(com.tencent.mm.j.f paramf)
  {
    if (bk.bl(paramf.field_mediaId))
    {
      y.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask mediaId is null");
      return false;
    }
    if (paramf.field_fileId == null) {
      paramf.field_fileId = "";
    }
    if (paramf.field_aesKey == null) {
      paramf.field_aesKey = "";
    }
    paramf.ceg = true;
    com.tencent.mm.kernel.g.DS().O(new b.6(this, paramf));
    return true;
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.CdnTransportService", "cdn callback decodePrepareResponse mediaid is null");
      return null;
    }
    com.tencent.mm.j.f localf = (com.tencent.mm.j.f)this.eiI.get(paramString);
    if (localf == null)
    {
      y.e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      return null;
    }
    if (localf.dlP != null) {
      return localf.dlP.f(paramString, paramArrayOfByte);
    }
    y.e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
    return null;
  }
  
  public final void ir(int paramInt)
  {
    this.eiC = paramInt;
  }
  
  public final boolean lL(String paramString)
  {
    com.tencent.mm.j.f localf = (com.tencent.mm.j.f)this.eiI.remove(paramString);
    if (localf != null)
    {
      f.Ne();
      a.lD(paramString);
      h.nFQ.f(10769, new Object[] { Integer.valueOf(c.ejd), Integer.valueOf(localf.field_fileType), Long.valueOf(bk.UY() - localf.field_startTime) });
    }
    this.eiH.remove(paramString);
    y.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localf, Integer.valueOf(0) });
    return true;
  }
  
  public final boolean lM(String paramString)
  {
    com.tencent.mm.j.f localf = (com.tencent.mm.j.f)this.eiI.remove(paramString);
    if (localf != null)
    {
      if ((localf.field_fileType != com.tencent.mm.j.a.dlx) && (localf.field_fileType != com.tencent.mm.j.a.dlz)) {
        break label144;
      }
      f.Ne();
      a.lI(paramString);
    }
    for (;;)
    {
      h.nFQ.f(10769, new Object[] { Integer.valueOf(c.ejc), Integer.valueOf(localf.field_fileType), Long.valueOf(bk.UY() - localf.field_startTime) });
      this.eiH.remove(paramString);
      this.eiJ.remove(paramString);
      y.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localf, Integer.valueOf(0) });
      return true;
      label144:
      if (localf.dlW)
      {
        f.Ne();
        a.lJ(paramString);
      }
      else
      {
        f.Ne();
        a.lE(paramString);
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if (paramm.getType() != 379) {}
    do
    {
      return;
      y.d("MicroMsg.CdnTransportService", "cdntra onSceneEnd it will tryStart sceneType:%d [%d,%d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    } while (!com.tencent.mm.kernel.g.DN().Dc());
    com.tencent.mm.kernel.g.DS().O(new b.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.b
 * JD-Core Version:    0.7.0.1
 */