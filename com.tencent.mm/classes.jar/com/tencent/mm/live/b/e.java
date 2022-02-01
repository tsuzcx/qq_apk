package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.live.core.core.b.c;
import com.tencent.mm.live.core.core.trtc.a.a;
import com.tencent.mm.live.core.core.trtc.a.a.d;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LiveCgiUtil;", "", "()V", "checkCookiesDeprecated", "", "errType", "", "errCode", "parseAnchorStatusJson", "Lcom/tencent/mm/json/JSONObject;", "status", "Lcom/tencent/mm/protobuf/ByteString;", "processLiveCgiSDKResponse", "", "name", "", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "processLiveSdkParams", "liveSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkParams;", "setupAnchorStatusJson", "plugin-logic_release"})
public final class e
{
  public static final e gtg;
  
  static
  {
    AppMethodBeat.i(189753);
    gtg = new e();
    AppMethodBeat.o(189753);
  }
  
  public static void a(bqk parambqk, TRTCCloudDef.TRTCParams paramTRTCParams)
  {
    AppMethodBeat.i(189752);
    k.h(parambqk, "liveSdkParam");
    Object localObject1 = parambqk.FfA;
    parambqk = parambqk.FfC;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      if (((bql)localObject1).FfD > 0)
      {
        localObject2 = a.aiX();
        k.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).aiY();
        k.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).setVideoResolution(((bql)localObject1).FfD);
      }
      if (((bql)localObject1).FfF > 0)
      {
        localObject2 = a.aiX();
        k.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).aiY();
        k.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).mB(((bql)localObject1).FfF);
      }
      if (((bql)localObject1).FfG > 0)
      {
        localObject2 = a.aiX();
        k.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).aiY();
        k.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).setVideoBitrate(((bql)localObject1).FfG);
      }
      if (((bql)localObject1).FfI > 0)
      {
        localObject2 = a.aiX();
        k.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).aiY();
        k.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).mC(((bql)localObject1).FfI);
      }
      i = ((bql)localObject1).FfJ;
      if (i >= 0) {
        break label330;
      }
    }
    for (;;)
    {
      if ((parambqk != null) && (paramTRTCParams != null))
      {
        ac.i("MicroMsg.LiveCoreSdk", "userDefineRecordId:" + parambqk.Ffk);
        localObject1 = parambqk.Ffl;
        localObject2 = parambqk.Ffk;
        if ((!bs.isNullOrNil((String)localObject1)) || (!bs.isNullOrNil((String)localObject2)))
        {
          parambqk = new i();
          if (!bs.isNullOrNil((String)localObject1)) {
            parambqk.i("userdefine_streamid_main", localObject1);
          }
          if (!bs.isNullOrNil((String)localObject2)) {
            parambqk.i("userdefine_record_id", localObject2);
          }
          localObject1 = new i();
          ((i)localObject1).i("Str_uc_params", parambqk);
          paramTRTCParams.businessInfo = ((i)localObject1).toString();
        }
      }
      AppMethodBeat.o(189752);
      return;
      label330:
      if (1 >= i)
      {
        localObject2 = a.aiX();
        k.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).aiY();
        k.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).mA(((bql)localObject1).FfJ);
      }
    }
  }
  
  public static void a(String paramString, bqj parambqj, bqd parambqd, TRTCCloudDef.TRTCParams paramTRTCParams, c paramc)
  {
    AppMethodBeat.i(189751);
    k.h(paramString, "name");
    k.h(parambqj, "liveSdkInfo");
    k.h(parambqd, "liveInfo");
    k.h(paramTRTCParams, "trtcParams");
    k.h(paramc, "liveRoomInfo");
    paramTRTCParams.roomId = parambqj.Ffr;
    paramTRTCParams.sdkAppId = parambqj.Ffq;
    paramTRTCParams.privateMapKey = z.a(parambqj.Ffu);
    paramTRTCParams.userId = parambqj.Ffe;
    paramTRTCParams.userSig = z.a(parambqj.Fft);
    int i = parambqj.Ffs;
    f.i locali = f.i.gtM;
    if (i != f.i.akw())
    {
      locali = f.i.gtM;
      if (i != f.i.akx()) {}
    }
    for (i = 21;; i = 20)
    {
      paramTRTCParams.role = i;
      k.h(paramString, "<set-?>");
      paramc.gmR = paramString;
      paramc.gmP = parambqd.DMV;
      paramString = parambqj.Ffz;
      k.g(paramString, "liveSdkInfo.live_cdn_url");
      k.h(paramString, "<set-?>");
      paramc.gnO = paramString;
      paramc.gnQ = parambqj.Ffw;
      paramString = new bqk();
      parambqj = parambqj.Ffv;
      k.g(parambqj, "liveSdkInfo.sdk_params");
      paramString = paramString.parseFrom(parambqj.getBytes());
      if (paramString != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveSdkParams");
      AppMethodBeat.o(189751);
      throw paramString;
    }
    paramString = (bqk)paramString;
    paramc.gnP = paramString.FfC.Ffm;
    paramc.appId = paramString.FfC.Ffo;
    paramc.gnR = paramString.FfC.Ffp;
    a(paramString, paramTRTCParams);
    AppMethodBeat.o(189751);
  }
  
  public static boolean cT(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 == -100020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.e
 * JD-Core Version:    0.7.0.1
 */