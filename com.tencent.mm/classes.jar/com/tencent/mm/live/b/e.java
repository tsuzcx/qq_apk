package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.bx.b;
import com.tencent.mm.live.core.core.b.c;
import com.tencent.mm.live.core.core.trtc.a.a;
import com.tencent.mm.live.core.core.trtc.a.a.d;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.buw;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/LiveCgiUtil;", "", "()V", "checkCookiesDeprecated", "", "errType", "", "errCode", "parseAnchorStatusJson", "Lcom/tencent/mm/json/JSONObject;", "status", "Lcom/tencent/mm/protobuf/ByteString;", "processLiveCgiSDKResponse", "", "name", "", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "processLiveSdkParams", "liveSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkParams;", "setupAnchorStatusJson", "plugin-logic_release"})
public final class e
{
  public static final e gMR;
  
  static
  {
    AppMethodBeat.i(212039);
    gMR = new e();
    AppMethodBeat.o(212039);
  }
  
  public static void a(bux parambux, TRTCCloudDef.TRTCParams paramTRTCParams)
  {
    AppMethodBeat.i(212038);
    p.h(parambux, "liveSdkParam");
    Object localObject1 = parambux.GPe;
    parambux = parambux.GPg;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      if (((buy)localObject1).GPh > 0)
      {
        localObject2 = a.alJ();
        p.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).alK();
        p.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).setVideoResolution(((buy)localObject1).GPh);
      }
      if (((buy)localObject1).GPj > 0)
      {
        localObject2 = a.alJ();
        p.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).alK();
        p.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).na(((buy)localObject1).GPj);
      }
      if (((buy)localObject1).GPk > 0)
      {
        localObject2 = a.alJ();
        p.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).alK();
        p.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).setVideoBitrate(((buy)localObject1).GPk);
      }
      if (((buy)localObject1).GPm > 0)
      {
        localObject2 = a.alJ();
        p.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).alK();
        p.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).nb(((buy)localObject1).GPm);
      }
      i = ((buy)localObject1).GPn;
      if (i >= 0) {
        break label330;
      }
    }
    for (;;)
    {
      if ((parambux != null) && (paramTRTCParams != null))
      {
        ad.i("MicroMsg.LiveCoreSdk", "userDefineRecordId:" + parambux.GOO);
        localObject1 = parambux.GOP;
        localObject2 = parambux.GOO;
        if ((!bt.isNullOrNil((String)localObject1)) || (!bt.isNullOrNil((String)localObject2)))
        {
          parambux = new i();
          if (!bt.isNullOrNil((String)localObject1)) {
            parambux.h("userdefine_streamid_main", localObject1);
          }
          if (!bt.isNullOrNil((String)localObject2)) {
            parambux.h("userdefine_record_id", localObject2);
          }
          localObject1 = new i();
          ((i)localObject1).h("Str_uc_params", parambux);
          paramTRTCParams.businessInfo = ((i)localObject1).toString();
        }
      }
      AppMethodBeat.o(212038);
      return;
      label330:
      if (1 >= i)
      {
        localObject2 = a.alJ();
        p.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).alK();
        p.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).mZ(((buy)localObject1).GPn);
      }
    }
  }
  
  public static void a(String paramString, buw parambuw, buq parambuq, TRTCCloudDef.TRTCParams paramTRTCParams, c paramc)
  {
    AppMethodBeat.i(212037);
    p.h(paramString, "name");
    p.h(parambuw, "liveSdkInfo");
    p.h(parambuq, "liveInfo");
    p.h(paramTRTCParams, "trtcParams");
    p.h(paramc, "liveRoomInfo");
    paramTRTCParams.roomId = parambuw.GOV;
    paramTRTCParams.sdkAppId = parambuw.GOU;
    paramTRTCParams.privateMapKey = z.a(parambuw.GOY);
    paramTRTCParams.userId = parambuw.GOI;
    paramTRTCParams.userSig = z.a(parambuw.GOX);
    int i = parambuw.GOW;
    f.i locali = f.i.gNx;
    if (i != f.i.ani())
    {
      locali = f.i.gNx;
      if (i != f.i.anj()) {}
    }
    for (i = 21;; i = 20)
    {
      paramTRTCParams.role = i;
      p.h(paramString, "<set-?>");
      paramc.gGA = paramString;
      paramc.gGy = parambuq.Fsa;
      paramString = parambuw.GPd;
      p.g(paramString, "liveSdkInfo.live_cdn_url");
      p.h(paramString, "<set-?>");
      paramc.gHx = paramString;
      paramc.gHz = parambuw.GPa;
      paramString = new bux();
      parambuw = parambuw.GOZ;
      p.g(parambuw, "liveSdkInfo.sdk_params");
      paramString = paramString.parseFrom(parambuw.getBytes());
      if (paramString != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveSdkParams");
      AppMethodBeat.o(212037);
      throw paramString;
    }
    paramString = (bux)paramString;
    paramc.gHy = paramString.GPg.GOQ;
    paramc.appId = paramString.GPg.GOS;
    paramc.gHA = paramString.GPg.GOT;
    a(paramString, paramTRTCParams);
    AppMethodBeat.o(212037);
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