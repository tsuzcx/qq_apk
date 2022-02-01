package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.bx.b;
import com.tencent.mm.live.core.core.b.c;
import com.tencent.mm.live.core.core.trtc.a.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.protocal.protobuf.eav;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.protocal.protobuf.eay;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveCgiUtil;", "", "()V", "checkCookiesDeprecated", "", "errType", "", "errCode", "parseAnchorStatusJson", "Lcom/tencent/mm/json/JSONObject;", "status", "Lcom/tencent/mm/protobuf/ByteString;", "processLiveCgiSDKResponse", "", "name", "", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "processLiveSdkParams", "liveSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkParams;", "setupAnchorStatusJson", "plugin-logic_release"})
public final class d
{
  public static final d qYj;
  
  static
  {
    AppMethodBeat.i(202578);
    qYj = new d();
    AppMethodBeat.o(202578);
  }
  
  public static void a(eax parameax, TRTCCloudDef.TRTCParams paramTRTCParams)
  {
    AppMethodBeat.i(202577);
    k.h(parameax, "liveSdkParam");
    Object localObject1 = parameax.LzA;
    parameax = parameax.LzC;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      if (((eay)localObject1).LzD > 0)
      {
        localObject2 = a.cpE();
        k.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).cpF();
        k.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject2).setVideoResolution(((eay)localObject1).LzD);
      }
      if (((eay)localObject1).LzF > 0)
      {
        localObject2 = a.cpE();
        k.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).cpF();
        k.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject2).BA(((eay)localObject1).LzF);
      }
      if (((eay)localObject1).LzG > 0)
      {
        localObject2 = a.cpE();
        k.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).cpF();
        k.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject2).setVideoBitrate(((eay)localObject1).LzG);
      }
      if (((eay)localObject1).LzI > 0)
      {
        localObject2 = a.cpE();
        k.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).cpF();
        k.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject2).BE(((eay)localObject1).LzI);
      }
      i = ((eay)localObject1).LzJ;
      if (i >= 0) {
        break label330;
      }
    }
    for (;;)
    {
      if ((parameax != null) && (paramTRTCParams != null))
      {
        ad.i("MicroMsg.LiveCoreSdk", "userDefineRecordId:" + parameax.Lzk);
        localObject1 = parameax.Lzl;
        localObject2 = parameax.Lzk;
        if ((!bt.isNullOrNil((String)localObject1)) || (!bt.isNullOrNil((String)localObject2)))
        {
          parameax = new i();
          if (!bt.isNullOrNil((String)localObject1)) {
            parameax.j("userdefine_streamid_main", localObject1);
          }
          if (!bt.isNullOrNil((String)localObject2)) {
            parameax.j("userdefine_record_id", localObject2);
          }
          localObject1 = new i();
          ((i)localObject1).j("Str_uc_params", parameax);
          paramTRTCParams.businessInfo = ((i)localObject1).toString();
        }
      }
      AppMethodBeat.o(202577);
      return;
      label330:
      if (1 >= i)
      {
        localObject2 = a.cpE();
        k.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((a)localObject2).cpF();
        k.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject2).Bz(((eay)localObject1).LzJ);
      }
    }
  }
  
  public static void a(String paramString, eaw parameaw, eas parameas, TRTCCloudDef.TRTCParams paramTRTCParams, c paramc)
  {
    AppMethodBeat.i(202576);
    k.h(paramString, "name");
    k.h(parameaw, "liveSdkInfo");
    k.h(parameas, "liveInfo");
    k.h(paramTRTCParams, "trtcParams");
    k.h(paramc, "liveRoomInfo");
    paramTRTCParams.roomId = parameaw.Lzr;
    paramTRTCParams.sdkAppId = parameaw.Lzq;
    paramTRTCParams.privateMapKey = z.a(parameaw.Lzu);
    paramTRTCParams.userId = parameaw.Lze;
    paramTRTCParams.userSig = z.a(parameaw.Lzt);
    int i = parameaw.Lzs;
    e.i locali = e.i.rFG;
    if (i != e.i.eNx())
    {
      locali = e.i.rFG;
      if (i != e.i.eNy()) {}
    }
    for (i = 21;; i = 20)
    {
      paramTRTCParams.role = i;
      k.h(paramString, "<set-?>");
      paramc.qud = paramString;
      paramc.DlB = parameas.LwA;
      paramString = parameaw.Lzz;
      k.g(paramString, "liveSdkInfo.live_cdn_url");
      k.h(paramString, "<set-?>");
      paramc.syH = paramString;
      paramc.qzc = parameaw.Lzw;
      paramString = new eax();
      parameaw = parameaw.Lzv;
      k.g(parameaw, "liveSdkInfo.sdk_params");
      paramString = paramString.parseFrom(parameaw.getBytes());
      if (paramString != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveSdkParams");
      AppMethodBeat.o(202576);
      throw paramString;
    }
    paramString = (eax)paramString;
    paramc.qzb = paramString.LzC.Lzm;
    paramc.appId = paramString.LzC.Lzo;
    paramc.qzd = paramString.LzC.Lzp;
    a(paramString, paramTRTCParams);
    AppMethodBeat.o(202576);
  }
  
  public static boolean eq(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 == -100020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.d
 * JD-Core Version:    0.7.0.1
 */