package com.tencent.mm.al;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.jp;
import com.tencent.mm.i.b.a;
import com.tencent.mm.i.g.a;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class b
  implements com.tencent.mm.ai.f, com.tencent.mm.i.b, b.a, n.b
{
  private int fyG;
  ak fyH;
  com.tencent.mm.sdk.b.c<jp> fyI;
  com.tencent.mm.network.n fyJ;
  Queue<String> fyK;
  public Map<String, com.tencent.mm.i.g> fyL;
  public Map<String, com.tencent.mm.i.g> fyM;
  public Map<String, Integer> fyN;
  private String fyO;
  private long fyP;
  public HashSet<String> fyQ;
  
  public b()
  {
    AppMethodBeat.i(78046);
    this.fyG = -1;
    this.fyH = new b.1(this, Looper.getMainLooper());
    this.fyI = new b.2(this);
    this.fyJ = new b.3(this);
    this.fyK = new LinkedList();
    this.fyL = new HashMap();
    this.fyM = new ConcurrentHashMap();
    this.fyN = new HashMap();
    this.fyO = "";
    this.fyP = 0L;
    this.fyQ = new HashSet();
    com.tencent.mm.kernel.g.RK().a(this.fyJ);
    if (com.tencent.mm.kernel.g.RJ().QU()) {
      com.tencent.mm.kernel.g.RL().Ru().a(this);
    }
    com.tencent.mm.kernel.g.Rc().a(379, this);
    com.tencent.mm.sdk.b.a.ymk.c(this.fyI);
    ab.i("MicroMsg.CdnTransportService", "summersafecdn CdnTransportService init[%s] stack[%s]", new Object[] { Integer.valueOf(hashCode()), bo.dtY() });
    AppMethodBeat.o(78046);
  }
  
  public static boolean lc(int paramInt)
  {
    AppMethodBeat.i(78045);
    com.tencent.mm.kernel.g.RJ();
    if (com.tencent.mm.kernel.a.QT())
    {
      int i = bo.a((Integer)com.tencent.mm.kernel.g.RL().Ru().get(144385, null), 0);
      ab.d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(i & paramInt), Boolean.valueOf(ae.gkE) });
      if (ae.gkE)
      {
        AppMethodBeat.o(78045);
        return true;
      }
      if ((i & paramInt) > 0)
      {
        AppMethodBeat.o(78045);
        return true;
      }
      AppMethodBeat.o(78045);
      return false;
    }
    AppMethodBeat.o(78045);
    return true;
  }
  
  public final int a(String paramString, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(78055);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.CdnTransportService", "cdn callback mediaid is null");
      AppMethodBeat.o(78055);
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      ab.e("MicroMsg.CdnTransportService", "cdn callback info all null");
      AppMethodBeat.o(78055);
      return -2;
    }
    if (paramc != null) {
      ab.d("MicroMsg.CdnTransportService", "CDN progress. total:%d, cur:%d, canshow:%b", new Object[] { Integer.valueOf(paramc.field_toltalLength), Integer.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify) });
    }
    this.fyP = bo.aoy();
    this.fyO = paramString;
    com.tencent.mm.sdk.g.d.ysn.a(new b.7(this, paramString, paramc, paramd), "MicroMsg.CdnTransportService");
    AppMethodBeat.o(78055);
    return 0;
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(78043);
    if (!com.tencent.mm.kernel.g.RJ().QU())
    {
      AppMethodBeat.o(78043);
      return;
    }
    int i = bo.f(paramObject, 0);
    ab.d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.RL().Ru()) || (i <= 0))
    {
      ab.e("MicroMsg.CdnTransportService", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(78043);
      return;
    }
    if (i != 144385)
    {
      AppMethodBeat.o(78043);
      return;
    }
    f.afL().le(10);
    AppMethodBeat.o(78043);
  }
  
  public final void a(String paramString, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(78058);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78058);
      return;
    }
    com.tencent.mm.sdk.g.d.ysn.a(new b.8(this, paramString, paramd), "MicroMsg.CdnTransportService");
    AppMethodBeat.o(78058);
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(78056);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.CdnTransportService", "cdn callback getauthbuf mediaid is null");
      AppMethodBeat.o(78056);
      return;
    }
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.fyM.get(paramString);
    if (localg == null)
    {
      ab.e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(78056);
      return;
    }
    if (localg.edp != null)
    {
      localg.edp.a(paramString, paramByteArrayOutputStream);
      AppMethodBeat.o(78056);
      return;
    }
    ab.e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
    AppMethodBeat.o(78056);
  }
  
  public final void afJ()
  {
    AppMethodBeat.i(78054);
    com.tencent.mm.kernel.g.RJ();
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
    if (com.tencent.mm.kernel.a.QT())
    {
      localb = f.afP().afI();
      str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("EnableCDNUploadImg");
      str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("EnableCDNVerifyConnect");
      str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("EnableCDNVideoRedirectOC");
      str4 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("EnableStreamUploadVideo");
      str5 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("C2COverloadDelaySeconds");
      str6 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("SNSOverloadDelaySeconds");
      str7 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("EnableSnsStreamDownload");
      str8 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("EnableSnsImageDownload");
      str9 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("ApprovedVideoPrivateProtocolHosts");
    }
    for (;;)
    {
      try
      {
        if (!bo.isNullOrNil(str1)) {
          localb.field_UseStreamCDN = Integer.valueOf(str1).intValue();
        }
        if (!bo.isNullOrNil(str2)) {
          localb.field_EnableCDNVerifyConnect = Integer.valueOf(str2).intValue();
        }
        if (!bo.isNullOrNil(str3)) {
          localb.field_EnableCDNVideoRedirectOC = Integer.valueOf(str3).intValue();
        }
        if (!bo.isNullOrNil(str4)) {
          localb.field_EnableStreamUploadVideo = Integer.valueOf(str4).intValue();
        }
        if (!bo.isNullOrNil(str5)) {
          localb.field_C2COverloadDelaySeconds = Integer.valueOf(str5).intValue();
        }
        if (!bo.isNullOrNil(str6)) {
          localb.field_SNSOverloadDelaySeconds = Integer.valueOf(str6).intValue();
        }
        if (!bo.isNullOrNil(str7)) {
          localb.field_EnableSnsStreamDownload = Integer.valueOf(str7).intValue();
        }
        if (!bo.isNullOrNil(str8)) {
          localb.field_EnableSnsImageDownload = Integer.valueOf(str8).intValue();
        }
        if (!bo.isNullOrNil(str9)) {
          localb.field_ApprovedVideoHosts = str9;
        }
        f.afO();
        if (!lc(256)) {
          continue;
        }
        i = 1;
        localb.field_EnableSafeCDN = i;
        if (localb.field_UseStreamCDN != 0)
        {
          str1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("ProgJPEGUploadSizeLimitWifi");
          str2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("ProgJPEGUploadSizeLimit3G");
          str3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("ProgJPEGDownloadSizeLimit");
          str4 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("ProgJPEGOnlyRecvPTL");
          str5 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("EnableJPEGDyncmicETL");
          if (!bo.isNullOrNil(str1)) {
            localb.field_WifiEtl = Integer.valueOf(str1).intValue();
          }
          if (!bo.isNullOrNil(str2)) {
            localb.field_noWifiEtl = Integer.valueOf(str2).intValue();
          }
          if (!bo.isNullOrNil(str3)) {
            localb.field_Ptl = Integer.valueOf(str3).intValue();
          }
          if (!bo.isNullOrNil(str4))
          {
            if (Integer.valueOf(str4).intValue() == 0) {
              continue;
            }
            bool = true;
            localb.field_onlyrecvPtl = bool;
          }
          if (!bo.isNullOrNil(str5)) {
            localb.field_UseDynamicETL = Integer.valueOf(str5).intValue();
          }
        }
        ab.i("MicroMsg.CdnTransportService", "summersafecdn streamcdn config[SVR]:%s", new Object[] { localb });
        if (this.fyG != -1)
        {
          ab.w("MicroMsg.CdnTransportService", "cmd set snsimage flag: %d", new Object[] { Integer.valueOf(this.fyG) });
          localb.field_EnableSnsImageDownload = this.fyG;
        }
        f.afP();
        a.a(localb);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        boolean bool;
        ab.e("MicroMsg.CdnTransportService", localNumberFormatException.toString());
        continue;
        int i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
      }
      if (ae.gld)
      {
        ab.w("MicroMsg.CdnTransportService", "use cdn debug configure.");
        if (!ae.gkZ) {
          continue;
        }
        i = 1;
        localb.field_UseStreamCDN = i;
        if (localb.field_UseStreamCDN != 0)
        {
          localb.field_onlysendETL = ae.gla;
          localb.field_onlyrecvPtl = ae.glb;
          if (!bo.isNullOrNil(ae.gkW)) {
            localb.field_WifiEtl = Integer.valueOf(ae.gkW).intValue();
          }
          if (!bo.isNullOrNil(ae.gkX)) {
            localb.field_noWifiEtl = Integer.valueOf(ae.gkX).intValue();
          }
          if (!bo.isNullOrNil(ae.gkY)) {
            localb.field_Ptl = Integer.valueOf(ae.gkY).intValue();
          }
        }
        if (!ae.gle) {
          continue;
        }
        i = 1;
        localb.field_EnableCDNVerifyConnect = i;
        if (!ae.glf) {
          continue;
        }
        i = 1;
        localb.field_EnableCDNVideoRedirectOC = i;
        ab.i("MicroMsg.CdnTransportService", "streamcdn config[DEBUG]:%s", new Object[] { localb });
        f.afP();
        a.a(localb);
      }
      AppMethodBeat.o(78054);
      return;
      i = 0;
      continue;
      bool = false;
    }
  }
  
  public final boolean b(com.tencent.mm.i.g paramg, int paramInt)
  {
    AppMethodBeat.i(78048);
    if (paramg == null)
    {
      ab.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
      AppMethodBeat.o(78048);
      return false;
    }
    if (bo.isNullOrNil(paramg.field_mediaId))
    {
      ab.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
      AppMethodBeat.o(78048);
      return false;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.cMU = false;
    com.tencent.mm.sdk.g.d.ysn.a(new b.5(this, paramInt, paramg), "MicroMsg.CdnTransportService");
    AppMethodBeat.o(78048);
    return true;
  }
  
  public final void cV(boolean paramBoolean)
  {
    AppMethodBeat.i(78053);
    if ((!paramBoolean) && (f.afP().afH()))
    {
      com.tencent.mm.kernel.g.RJ();
      if (com.tencent.mm.kernel.a.QT())
      {
        ab.w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
        f.afL().le(4);
        AppMethodBeat.o(78053);
        return;
      }
    }
    afJ();
    ab.i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", new Object[] { Integer.valueOf(this.fyK.size()) });
    Object localObject1;
    Object localObject3;
    int i;
    label212:
    int j;
    label222:
    Object localObject2;
    if (!this.fyK.isEmpty())
    {
      localObject1 = (String)this.fyK.poll();
      localObject3 = (com.tencent.mm.i.g)this.fyL.remove(localObject1);
      if (localObject3 == null)
      {
        ab.e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
        AppMethodBeat.o(78053);
        return;
      }
      ab.i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[] { ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_autostart), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_chattype) });
      ((com.tencent.mm.i.g)localObject3).field_startTime = bo.aoy();
      if (((com.tencent.mm.i.g)localObject3).cMU)
      {
        String str;
        if (((com.tencent.mm.i.g)localObject3).field_fullpath == null)
        {
          i = -1;
          if (((com.tencent.mm.i.g)localObject3).field_thumbpath != null) {
            break label581;
          }
          j = -1;
          ab.i("MicroMsg.CdnTransportService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b] largesvideo[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), bo.aqg(((com.tencent.mm.i.g)localObject3).field_svr_signature), bo.aqg(((com.tencent.mm.i.g)localObject3).field_aesKey), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType), ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_onlycheckexist), Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_largesvideo) });
          if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {
            ((com.tencent.mm.i.g)localObject3).field_fullpath = "";
          }
          if (((com.tencent.mm.i.g)localObject3).field_thumbpath == null) {
            ((com.tencent.mm.i.g)localObject3).field_thumbpath = "";
          }
          localObject1 = (com.tencent.mm.i.g)this.fyM.put(((com.tencent.mm.i.g)localObject3).field_mediaId, localObject3);
          localObject2 = (com.tencent.mm.i.g)this.fyM.get(((com.tencent.mm.i.g)localObject3).field_mediaId);
          if (localObject2 == null) {
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(594L, 5L, 1L, true);
          }
          i = f.afP().b((com.tencent.mm.i.g)localObject3);
          str = ((com.tencent.mm.i.g)localObject3).field_mediaId;
          if (localObject1 != null) {
            break label593;
          }
          localObject1 = null;
          label427:
          if (localObject2 != null) {
            break label603;
          }
        }
        label581:
        label593:
        label603:
        for (localObject2 = null;; localObject2 = ((com.tencent.mm.i.g)localObject2).field_mediaId)
        {
          ab.i("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { str, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
          if (i == 0) {
            break;
          }
          localObject1 = (com.tencent.mm.i.g)this.fyM.remove(((com.tencent.mm.i.g)localObject3).field_mediaId);
          ab.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s remove[%s]", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.g)localObject3).field_mediaId, localObject1 });
          if (((com.tencent.mm.i.g)localObject3).edp == null) {
            break;
          }
          ((com.tencent.mm.i.g)localObject3).edp.a(((com.tencent.mm.i.g)localObject3).field_mediaId, i, null, null, ((com.tencent.mm.i.g)localObject3).field_onlycheckexist);
          break;
          i = ((com.tencent.mm.i.g)localObject3).field_fullpath.length();
          break label212;
          j = ((com.tencent.mm.i.g)localObject3).field_thumbpath.length();
          break label222;
          localObject1 = ((com.tencent.mm.i.g)localObject1).field_mediaId;
          break label427;
        }
      }
      i = -1;
      if (((com.tencent.mm.i.g)localObject3).field_fileType == 40001) {
        i = f.afP().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).eds, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).field_aesKey, ((com.tencent.mm.i.g)localObject3).field_authKey);
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        ab.e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.g)localObject3).field_mediaId });
        if (((com.tencent.mm.i.g)localObject3).edp == null) {
          break;
        }
        ((com.tencent.mm.i.g)localObject3).edp.a(((com.tencent.mm.i.g)localObject3).field_mediaId, i, null, null, ((com.tencent.mm.i.g)localObject3).field_onlycheckexist);
        break;
        if (((com.tencent.mm.i.g)localObject3).field_fileType == 19)
        {
          i = f.afP().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).eds, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).field_aesKey, ((com.tencent.mm.i.g)localObject3).field_authKey);
          continue;
        }
        if ((((com.tencent.mm.i.g)localObject3).field_fileType == com.tencent.mm.i.a.ecS) || (((com.tencent.mm.i.g)localObject3).field_fileType == com.tencent.mm.i.a.ecU))
        {
          j = i;
          if (((com.tencent.mm.i.g)localObject3).field_fullpath != null)
          {
            j = i;
            if (!((com.tencent.mm.i.g)localObject3).field_fullpath.isEmpty()) {
              j = f.afP().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).eds, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).field_fileType, ((com.tencent.mm.i.g)localObject3).edt, ((com.tencent.mm.i.g)localObject3).edu, ((com.tencent.mm.i.g)localObject3).edv, ((com.tencent.mm.i.g)localObject3).edw);
            }
          }
          if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {}
          for (i = -1;; i = ((com.tencent.mm.i.g)localObject3).field_fullpath.length())
          {
            ab.i("MicroMsg.CdnTransportService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d]", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).eds, Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType) });
            i = j;
            break;
          }
        }
        if (((com.tencent.mm.i.g)localObject3).edy)
        {
          j = i;
          if (((com.tencent.mm.i.g)localObject3).field_fullpath != null)
          {
            j = i;
            if (!((com.tencent.mm.i.g)localObject3).field_fullpath.isEmpty()) {
              j = f.afP().a(((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).field_fullpath, ((com.tencent.mm.i.g)localObject3).eds, ((com.tencent.mm.i.g)localObject3).edz, ((com.tencent.mm.i.g)localObject3).edA, ((com.tencent.mm.i.g)localObject3).allow_mobile_net_download, ((com.tencent.mm.i.g)localObject3).edt, ((com.tencent.mm.i.g)localObject3).edu, ((com.tencent.mm.i.g)localObject3).is_resume_task, ((com.tencent.mm.i.g)localObject3).edx, ((com.tencent.mm.i.g)localObject3).edv);
            }
          }
          if (((com.tencent.mm.i.g)localObject3).field_fullpath == null) {}
          for (i = -1;; i = ((com.tencent.mm.i.g)localObject3).field_fullpath.length())
          {
            ab.i("MicroMsg.CdnTransportService", "game package download tryStart recv file:%d field_mediaId[%s], download_url[%s] https url[%s]", new Object[] { Integer.valueOf(i), ((com.tencent.mm.i.g)localObject3).field_mediaId, ((com.tencent.mm.i.g)localObject3).eds, ((com.tencent.mm.i.g)localObject3).edz });
            i = j;
            break;
          }
        }
        if (((com.tencent.mm.i.g)localObject3).edB)
        {
          if ((localObject3 instanceof com.tencent.mm.i.f))
          {
            localObject1 = (com.tencent.mm.i.f)localObject3;
            i = f.afP().a((com.tencent.mm.i.f)localObject1);
            continue;
          }
          if (!(localObject3 instanceof com.tencent.mm.i.e)) {
            break label1782;
          }
          localObject1 = (com.tencent.mm.i.e)localObject3;
          i = f.afP().a(((com.tencent.mm.i.e)localObject1).field_mediaId, ((com.tencent.mm.i.e)localObject1).url, ((com.tencent.mm.i.e)localObject1).referer, ((com.tencent.mm.i.e)localObject1).edg, ((com.tencent.mm.i.e)localObject1).edh, ((com.tencent.mm.i.e)localObject1).edi, ((com.tencent.mm.i.e)localObject1).edj, ((com.tencent.mm.i.e)localObject1).edk, ((com.tencent.mm.i.e)localObject1).isColdSnsData, ((com.tencent.mm.i.e)localObject1).signalQuality, ((com.tencent.mm.i.e)localObject1).snsScene, ((com.tencent.mm.i.e)localObject1).snsCipherKey, ((com.tencent.mm.i.e)localObject1).dqS, ((com.tencent.mm.i.e)localObject1).edl, ((com.tencent.mm.i.e)localObject1).fileType);
          continue;
        }
        if (((com.tencent.mm.i.g)localObject3).field_fullpath == null)
        {
          j = -1;
          label1252:
          if (((com.tencent.mm.i.g)localObject3).field_thumbpath != null) {
            break label1395;
          }
        }
        label1395:
        for (int k = -1;; k = ((com.tencent.mm.i.g)localObject3).field_thumbpath.length())
        {
          ab.i("MicroMsg.CdnTransportService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), ((com.tencent.mm.i.g)localObject3).field_svr_signature, ((com.tencent.mm.i.g)localObject3).field_aesKey, Integer.valueOf(((com.tencent.mm.i.g)localObject3).field_fileType), ((com.tencent.mm.i.g)localObject3).field_mediaId, Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_onlycheckexist) });
          if (((com.tencent.mm.i.g)localObject3).edD != 2) {
            break label1614;
          }
          if (!(localObject3 instanceof com.tencent.mm.i.h)) {
            break label1782;
          }
          localObject1 = (com.tencent.mm.i.h)localObject3;
          if (!((com.tencent.mm.i.h)localObject1).Jr()) {
            break label1408;
          }
          i = f.afP().a((com.tencent.mm.i.g)localObject3, 2);
          break;
          j = ((com.tencent.mm.i.g)localObject3).field_fullpath.length();
          break label1252;
        }
        label1408:
        if (((com.tencent.mm.i.h)localObject1).Jp())
        {
          i = f.afP().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).edJ, ((com.tencent.mm.i.h)localObject1).edh, ((com.tencent.mm.i.h)localObject1).isColdSnsData, ((com.tencent.mm.i.h)localObject1).signalQuality, ((com.tencent.mm.i.h)localObject1).snsScene, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat, 1, 1);
          continue;
        }
        if (((com.tencent.mm.i.h)localObject1).Jq())
        {
          i = f.afP().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).edJ, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).concurrentCount);
          continue;
        }
        if (((com.tencent.mm.i.h)localObject1).Jt()) {
          i = f.afP().a(((com.tencent.mm.i.h)localObject1).field_mediaId, ((com.tencent.mm.i.h)localObject1).url, ((com.tencent.mm.i.h)localObject1).referer, ((com.tencent.mm.i.h)localObject1).field_fullpath, ((com.tencent.mm.i.h)localObject1).edJ, ((com.tencent.mm.i.h)localObject1).edh, ((com.tencent.mm.i.h)localObject1).isColdSnsData, ((com.tencent.mm.i.h)localObject1).signalQuality, ((com.tencent.mm.i.h)localObject1).snsScene, ((com.tencent.mm.i.h)localObject1).field_preloadRatio, ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat, ((com.tencent.mm.i.h)localObject1).connectionCount);
        }
        continue;
        label1614:
        i = f.afP().c((com.tencent.mm.i.g)localObject3);
        continue;
      }
      localObject1 = (com.tencent.mm.i.g)this.fyM.put(((com.tencent.mm.i.g)localObject3).field_mediaId, localObject3);
      localObject2 = (com.tencent.mm.i.g)this.fyM.get(((com.tencent.mm.i.g)localObject3).field_mediaId);
      if (localObject2 == null) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(594L, 6L, 1L, true);
      }
      localObject3 = ((com.tencent.mm.i.g)localObject3).field_mediaId;
      if (localObject1 == null)
      {
        localObject1 = null;
        label1700:
        if (localObject2 != null) {
          break label1765;
        }
      }
      label1765:
      for (localObject2 = null;; localObject2 = ((com.tencent.mm.i.g)localObject2).field_mediaId)
      {
        ab.i("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", new Object[] { localObject3, Integer.valueOf(i), localObject1, localObject2, Integer.valueOf(hashCode()) });
        break;
        localObject1 = ((com.tencent.mm.i.g)localObject1).field_mediaId;
        break label1700;
      }
      AppMethodBeat.o(78053);
      return;
      label1782:
      i = -1;
    }
  }
  
  public final boolean d(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(78049);
    boolean bool = b(paramg, -1);
    AppMethodBeat.o(78049);
    return bool;
  }
  
  public final boolean e(com.tencent.mm.i.g paramg)
  {
    AppMethodBeat.i(78050);
    if (paramg == null)
    {
      ab.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask task info is null");
      AppMethodBeat.o(78050);
      return false;
    }
    if (bo.isNullOrNil(paramg.field_mediaId))
    {
      ab.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask mediaId is null");
      AppMethodBeat.o(78050);
      return false;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    paramg.cMU = true;
    com.tencent.mm.sdk.g.d.ysn.a(new b.6(this, paramg), "MicroMsg.CdnTransportService");
    AppMethodBeat.o(78050);
    return true;
  }
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78057);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.CdnTransportService", "cdn callback decodePrepareResponse mediaid is null");
      AppMethodBeat.o(78057);
      return null;
    }
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.fyM.get(paramString);
    if (localg == null)
    {
      ab.e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(78057);
      return null;
    }
    if (localg.edp != null)
    {
      paramString = localg.edp.l(paramString, paramArrayOfByte);
      AppMethodBeat.o(78057);
      return paramString;
    }
    ab.e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
    AppMethodBeat.o(78057);
    return null;
  }
  
  public final void ld(int paramInt)
  {
    this.fyG = paramInt;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(78044);
    if (paramm.getType() != 379)
    {
      AppMethodBeat.o(78044);
      return;
    }
    ab.d("MicroMsg.CdnTransportService", "cdntra onSceneEnd it will tryStart sceneType:%d [%d,%d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.g.RJ().QU()) {
      com.tencent.mm.sdk.g.d.ysn.a(new b.4(this), "MicroMsg.CdnTransportService");
    }
    AppMethodBeat.o(78044);
  }
  
  public final boolean sI(String paramString)
  {
    AppMethodBeat.i(78051);
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.fyM.remove(paramString);
    if (localg != null)
    {
      f.afP();
      a.sA(paramString);
      com.tencent.mm.plugin.report.service.h.qsU.e(10769, new Object[] { Integer.valueOf(c.fzh), Integer.valueOf(localg.field_fileType), Long.valueOf(bo.aoy() - localg.field_startTime) });
    }
    this.fyL.remove(paramString);
    ab.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
    AppMethodBeat.o(78051);
    return true;
  }
  
  public final boolean sJ(String paramString)
  {
    AppMethodBeat.i(78052);
    com.tencent.mm.i.g localg = (com.tencent.mm.i.g)this.fyM.remove(paramString);
    if (localg != null)
    {
      if ((localg.field_fileType != com.tencent.mm.i.a.ecS) && (localg.field_fileType != com.tencent.mm.i.a.ecU)) {
        break label156;
      }
      f.afP();
      a.sF(paramString);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(10769, new Object[] { Integer.valueOf(c.fzg), Integer.valueOf(localg.field_fileType), Long.valueOf(bo.aoy() - localg.field_startTime) });
      this.fyL.remove(paramString);
      this.fyN.remove(paramString);
      ab.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramString, localg, Integer.valueOf(0) });
      AppMethodBeat.o(78052);
      return true;
      label156:
      if (localg.edy)
      {
        f.afP();
        a.sG(paramString);
      }
      else
      {
        f.afP();
        a.sB(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.al.b
 * JD-Core Version:    0.7.0.1
 */