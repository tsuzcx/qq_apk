package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.cd.b;
import com.tencent.mm.live.core.core.model.f;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.protocal.protobuf.vj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveCgiUtil;", "", "()V", "checkCookiesDeprecated", "", "errType", "", "errCode", "parseAnchorStatusJson", "Lcom/tencent/mm/json/JSONObject;", "status", "Lcom/tencent/mm/protobuf/ByteString;", "processLiveCgiSDKResponse", "", "name", "", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "processLiveSdkParams", "liveSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkParams;", "setupAnchorStatusJson", "plugin-logic_release"})
public final class k
{
  public static final k kuf;
  
  static
  {
    AppMethodBeat.i(195791);
    kuf = new k();
    AppMethodBeat.o(195791);
  }
  
  public static void a(crx paramcrx, TRTCCloudDef.TRTCParams paramTRTCParams, f paramf)
  {
    AppMethodBeat.i(195790);
    p.k(paramcrx, "liveSdkParam");
    p.k(paramf, "liveRoomInfo");
    Object localObject1 = paramcrx.Tzt;
    paramcrx = paramcrx.Tzv;
    Object localObject2;
    label556:
    Object localObject3;
    if (localObject1 != null)
    {
      if (((cry)localObject1).Tzw > 0)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        p.j(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject2).aLJ();
        p.j(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).setVideoResolution(((cry)localObject1).Tzw);
      }
      if (((cry)localObject1).Tzy > 0)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        p.j(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject2).aLJ();
        p.j(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).ta(((cry)localObject1).Tzy);
      }
      if (((cry)localObject1).Tzz > 0)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        p.j(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject2).aLJ();
        p.j(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).setVideoBitrate(((cry)localObject1).Tzz);
      }
      if (((cry)localObject1).TzG > 0)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        p.j(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject2).aLJ();
        p.j(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).setMinVideoBitrate(((cry)localObject1).TzG);
      }
      if (((cry)localObject1).TzI > 0)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        p.j(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject2).aLJ();
        p.j(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).tb(((cry)localObject1).TzI);
      }
      if (((cry)localObject1).TzJ > 0)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        p.j(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject2).aLJ();
        p.j(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).tc(((cry)localObject1).TzJ);
      }
      if (((cry)localObject1).TzK > 0)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        p.j(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject2).aLJ();
        p.j(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).td(((cry)localObject1).TzK);
      }
      if (((cry)localObject1).TzL > 0)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        p.j(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject2).aLJ();
        p.j(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).te(((cry)localObject1).TzL);
      }
      if (((cry)localObject1).TzB > 0)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
        p.j(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject2).aLJ();
        p.j(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).tf(((cry)localObject1).TzB);
      }
      i = ((cry)localObject1).TzC;
      if (i >= 0) {}
    }
    else
    {
      if ((paramcrx == null) || (paramTRTCParams == null)) {
        break label848;
      }
      Log.i("MicroMsg.LiveCoreSdk", "userDefineRecordId:" + paramcrx.TyO + ',' + paramcrx.TyP);
      localObject1 = paramcrx.TyP;
      localObject2 = paramcrx.TyO;
      int j = paramcrx.TyY;
      i = j;
      if (!com.tencent.mm.modelcontrol.e.vW(5))
      {
        i = j;
        if (j == com.tencent.mm.live.core.core.a.kiQ.value) {
          i = paramcrx.TyZ;
        }
      }
      paramf.kjr = paramcrx.TyZ;
      if (i >= 100) {
        break label718;
      }
      paramf.a(com.tencent.mm.live.core.core.model.a.klz);
      paramf.kjq = i;
      localObject3 = (Collection)paramcrx.TyU;
      if ((localObject3 != null) && (!((Collection)localObject3).isEmpty())) {
        break label758;
      }
    }
    label718:
    label758:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label763;
      }
      paramcrx = paramcrx.TyU;
      p.j(paramcrx, "channelParams.cdn_trans_info");
      paramcrx = ((Iterable)paramcrx).iterator();
      while (paramcrx.hasNext())
      {
        Object localObject4 = (vj)paramcrx.next();
        localObject3 = (Map)paramf.kmm;
        i = ((vj)localObject4).SgP;
        localObject4 = ((vj)localObject4).url;
        p.j(localObject4, "it.url");
        ((Map)localObject3).put(Integer.valueOf(i), localObject4);
      }
      if (1 < i) {
        break;
      }
      localObject2 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
      p.j(localObject2, "ConfigHelper.getInstance()");
      localObject2 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject2).aLJ();
      p.j(localObject2, "ConfigHelper.getInstance().videoConfig");
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e)localObject2).sZ(((cry)localObject1).TzC);
      break;
      if (i == com.tencent.mm.live.core.core.a.kiR.value)
      {
        paramf.a(com.tencent.mm.live.core.core.model.a.klA);
        break label556;
      }
      if (i != com.tencent.mm.live.core.core.a.kiS.value) {
        break label556;
      }
      paramf.a(com.tencent.mm.live.core.core.model.a.klB);
      break label556;
    }
    label763:
    if ((!Util.isNullOrNil((String)localObject1)) || (!Util.isNullOrNil((String)localObject2)))
    {
      paramcrx = new i();
      if (!Util.isNullOrNil((String)localObject1)) {
        paramcrx.g("userdefine_streamid_main", localObject1);
      }
      if (!Util.isNullOrNil((String)localObject2)) {
        paramcrx.g("userdefine_record_id", localObject2);
      }
      paramf = new i();
      paramf.g("Str_uc_params", paramcrx);
      paramTRTCParams.businessInfo = paramf.toString();
    }
    label848:
    AppMethodBeat.o(195790);
  }
  
  public static void a(String paramString, crw paramcrw, crq paramcrq, TRTCCloudDef.TRTCParams paramTRTCParams, f paramf)
  {
    AppMethodBeat.i(195781);
    p.k(paramString, "name");
    p.k(paramcrw, "liveSdkInfo");
    p.k(paramcrq, "liveInfo");
    p.k(paramTRTCParams, "trtcParams");
    p.k(paramf, "liveRoomInfo");
    paramTRTCParams.roomId = paramcrw.Tzk;
    paramTRTCParams.sdkAppId = paramcrw.Tzj;
    paramTRTCParams.privateMapKey = z.a(paramcrw.Tzn);
    paramTRTCParams.userId = paramcrw.TyF;
    paramTRTCParams.userSig = z.a(paramcrw.Tzm);
    int i = paramcrw.Tzl;
    l.i locali = l.i.kuO;
    if (i != l.i.aNR())
    {
      locali = l.i.kuO;
      if (i != l.i.aNS()) {}
    }
    for (i = 21;; i = 20)
    {
      paramTRTCParams.role = i;
      paramf.Nu(paramString);
      paramf.liveId = paramcrq.klE;
      paramString = (Map)paramf.kmm;
      paramcrq = paramcrw.Tzs;
      p.j(paramcrq, "liveSdkInfo.live_cdn_url");
      paramString.put(Integer.valueOf(0), paramcrq);
      paramf.kmj = paramcrw.Tzp;
      paramString = new crx();
      paramcrw = paramcrw.Tzo;
      p.j(paramcrw, "liveSdkInfo.sdk_params");
      paramString = paramString.parseFrom(paramcrw.UH);
      if (paramString != null) {
        break;
      }
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveSdkParams");
      AppMethodBeat.o(195781);
      throw paramString;
    }
    paramString = (crx)paramString;
    paramf.kmi = paramString.Tzv.TyQ;
    paramf.appId = paramString.Tzv.TyS;
    paramf.kmk = paramString.Tzv.TyT;
    a(paramString, paramTRTCParams, paramf);
    AppMethodBeat.o(195781);
  }
  
  public static boolean dw(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 == -100020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.k
 * JD-Core Version:    0.7.0.1
 */