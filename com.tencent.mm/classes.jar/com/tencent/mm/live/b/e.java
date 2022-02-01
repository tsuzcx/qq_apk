package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.live.core.core.b.c;
import com.tencent.mm.live.core.core.trtc.a.a;
import com.tencent.mm.live.core.core.trtc.a.a.d;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.bvp;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.bvr;
import com.tencent.mm.protocal.protobuf.bvs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/LiveCgiUtil;", "", "()V", "checkCookiesDeprecated", "", "errType", "", "errCode", "parseAnchorStatusJson", "Lcom/tencent/mm/json/JSONObject;", "status", "Lcom/tencent/mm/protobuf/ByteString;", "processLiveCgiSDKResponse", "", "name", "", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "processLiveSdkParams", "liveSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkParams;", "setupAnchorStatusJson", "plugin-logic_release"})
public final class e
{
  public static final e gPA;
  
  static
  {
    AppMethodBeat.i(215658);
    gPA = new e();
    AppMethodBeat.o(215658);
  }
  
  public static void a(bvr parambvr, TRTCCloudDef.TRTCParams paramTRTCParams)
  {
    AppMethodBeat.i(215657);
    p.h(parambvr, "liveSdkParam");
    Object localObject1 = parambvr.HiG;
    parambvr = parambvr.HiI;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      if (((bvs)localObject1).HiJ > 0)
      {
        localObject2 = a.alY();
        p.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).alZ();
        p.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).setVideoResolution(((bvs)localObject1).HiJ);
      }
      if (((bvs)localObject1).HiL > 0)
      {
        localObject2 = a.alY();
        p.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).alZ();
        p.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).nd(((bvs)localObject1).HiL);
      }
      if (((bvs)localObject1).HiM > 0)
      {
        localObject2 = a.alY();
        p.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).alZ();
        p.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).setVideoBitrate(((bvs)localObject1).HiM);
      }
      if (((bvs)localObject1).HiO > 0)
      {
        localObject2 = a.alY();
        p.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).alZ();
        p.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).ne(((bvs)localObject1).HiO);
      }
      i = ((bvs)localObject1).HiP;
      if (i >= 0) {
        break label330;
      }
    }
    for (;;)
    {
      if ((parambvr != null) && (paramTRTCParams != null))
      {
        ae.i("MicroMsg.LiveCoreSdk", "userDefineRecordId:" + parambvr.Hiq);
        localObject1 = parambvr.Hir;
        localObject2 = parambvr.Hiq;
        if ((!bu.isNullOrNil((String)localObject1)) || (!bu.isNullOrNil((String)localObject2)))
        {
          parambvr = new i();
          if (!bu.isNullOrNil((String)localObject1)) {
            parambvr.h("userdefine_streamid_main", localObject1);
          }
          if (!bu.isNullOrNil((String)localObject2)) {
            parambvr.h("userdefine_record_id", localObject2);
          }
          localObject1 = new i();
          ((i)localObject1).h("Str_uc_params", parambvr);
          paramTRTCParams.businessInfo = ((i)localObject1).toString();
        }
      }
      AppMethodBeat.o(215657);
      return;
      label330:
      if (1 >= i)
      {
        localObject2 = a.alY();
        p.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).alZ();
        p.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).nc(((bvs)localObject1).HiP);
      }
    }
  }
  
  public static void a(String paramString, bvq parambvq, bvk parambvk, TRTCCloudDef.TRTCParams paramTRTCParams, c paramc)
  {
    AppMethodBeat.i(215656);
    p.h(paramString, "name");
    p.h(parambvq, "liveSdkInfo");
    p.h(parambvk, "liveInfo");
    p.h(paramTRTCParams, "trtcParams");
    p.h(paramc, "liveRoomInfo");
    paramTRTCParams.roomId = parambvq.Hix;
    paramTRTCParams.sdkAppId = parambvq.Hiw;
    paramTRTCParams.privateMapKey = z.a(parambvq.HiA);
    paramTRTCParams.userId = parambvq.Hii;
    paramTRTCParams.userSig = z.a(parambvq.Hiz);
    int i = parambvq.Hiy;
    f.i locali = f.i.gQg;
    if (i != f.i.any())
    {
      locali = f.i.gQg;
      if (i != f.i.anz()) {}
    }
    for (i = 21;; i = 20)
    {
      paramTRTCParams.role = i;
      p.h(paramString, "<set-?>");
      paramc.gJj = paramString;
      paramc.gJh = parambvk.FKy;
      paramString = parambvq.HiF;
      p.g(paramString, "liveSdkInfo.live_cdn_url");
      p.h(paramString, "<set-?>");
      paramc.gKg = paramString;
      paramc.gKi = parambvq.HiC;
      paramString = new bvr();
      parambvq = parambvq.HiB;
      p.g(parambvq, "liveSdkInfo.sdk_params");
      paramString = paramString.parseFrom(parambvq.getBytes());
      if (paramString != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveSdkParams");
      AppMethodBeat.o(215656);
      throw paramString;
    }
    paramString = (bvr)paramString;
    paramc.gKh = paramString.HiI.His;
    paramc.appId = paramString.HiI.Hiu;
    paramc.gKj = paramString.HiI.Hiv;
    a(paramString, paramTRTCParams);
    AppMethodBeat.o(215656);
  }
  
  public static boolean cV(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 == -100020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.e
 * JD-Core Version:    0.7.0.1
 */