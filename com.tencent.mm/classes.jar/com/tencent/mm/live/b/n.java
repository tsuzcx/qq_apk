package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.live.core.core.trtc.a.a.d;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.protocal.protobuf.vh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/LiveCgiUtil;", "", "()V", "checkCookiesDeprecated", "", "errType", "", "errCode", "parseAnchorStatusJson", "Lcom/tencent/mm/json/JSONObject;", "status", "Lcom/tencent/mm/protobuf/ByteString;", "processLiveCgiSDKResponse", "", "name", "", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "processLiveSdkParams", "liveSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkParams;", "setupAnchorStatusJson", "plugin-logic_release"})
public final class n
{
  public static final n hGh;
  
  static
  {
    AppMethodBeat.i(207594);
    hGh = new n();
    AppMethodBeat.o(207594);
  }
  
  public static void a(cjc paramcjc, TRTCCloudDef.TRTCParams paramTRTCParams, com.tencent.mm.live.core.core.b.e parame)
  {
    AppMethodBeat.i(207593);
    p.h(paramcjc, "liveSdkParam");
    p.h(parame, "liveRoomInfo");
    Object localObject1 = paramcjc.Mot;
    paramcjc = paramcjc.Mov;
    Object localObject2;
    label324:
    Object localObject3;
    if (localObject1 != null)
    {
      if (((cjd)localObject1).Mow > 0)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject2).aDD();
        p.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).setVideoResolution(((cjd)localObject1).Mow);
      }
      if (((cjd)localObject1).Moy > 0)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject2).aDD();
        p.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).qu(((cjd)localObject1).Moy);
      }
      if (((cjd)localObject1).Moz > 0)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject2).aDD();
        p.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).setVideoBitrate(((cjd)localObject1).Moz);
      }
      if (((cjd)localObject1).MoB > 0)
      {
        localObject2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
        p.g(localObject2, "ConfigHelper.getInstance()");
        localObject2 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject2).aDD();
        p.g(localObject2, "ConfigHelper.getInstance().videoConfig");
        ((d)localObject2).qv(((cjd)localObject1).MoB);
      }
      i = ((cjd)localObject1).MoC;
      if (i >= 0) {}
    }
    else
    {
      if ((paramcjc == null) || (paramTRTCParams == null)) {
        break label615;
      }
      Log.i("MicroMsg.LiveCoreSdk", "userDefineRecordId:" + paramcjc.MnU);
      localObject1 = paramcjc.MnV;
      localObject2 = paramcjc.MnU;
      int j = paramcjc.Moe;
      i = j;
      if (!com.tencent.mm.modelcontrol.e.sX(5))
      {
        i = j;
        if (j == com.tencent.mm.live.core.core.a.hwC.value) {
          i = paramcjc.Mof;
        }
      }
      parame.hzr = paramcjc.Mof;
      if (i >= 100) {
        break label485;
      }
      parame.a(com.tencent.mm.live.core.core.b.a.hyD);
      parame.hzq = i;
      localObject3 = (Collection)paramcjc.Moa;
      if ((localObject3 != null) && (!((Collection)localObject3).isEmpty())) {
        break label525;
      }
    }
    label525:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label530;
      }
      paramcjc = paramcjc.Moa;
      p.g(paramcjc, "channelParams.cdn_trans_info");
      paramcjc = ((Iterable)paramcjc).iterator();
      while (paramcjc.hasNext())
      {
        Object localObject4 = (vh)paramcjc.next();
        localObject3 = (Map)parame.hzs;
        i = ((vh)localObject4).LfB;
        localObject4 = ((vh)localObject4).url;
        p.g(localObject4, "it.url");
        ((Map)localObject3).put(Integer.valueOf(i), localObject4);
      }
      if (1 < i) {
        break;
      }
      localObject2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
      p.g(localObject2, "ConfigHelper.getInstance()");
      localObject2 = ((com.tencent.mm.live.core.core.trtc.a.a)localObject2).aDD();
      p.g(localObject2, "ConfigHelper.getInstance().videoConfig");
      ((d)localObject2).qt(((cjd)localObject1).MoC);
      break;
      label485:
      if (i == com.tencent.mm.live.core.core.a.hwD.value)
      {
        parame.a(com.tencent.mm.live.core.core.b.a.hyE);
        break label324;
      }
      if (i != com.tencent.mm.live.core.core.a.hwE.value) {
        break label324;
      }
      parame.a(com.tencent.mm.live.core.core.b.a.hyF);
      break label324;
    }
    label530:
    if ((!Util.isNullOrNil((String)localObject1)) || (!Util.isNullOrNil((String)localObject2)))
    {
      paramcjc = new i();
      if (!Util.isNullOrNil((String)localObject1)) {
        paramcjc.h("userdefine_streamid_main", localObject1);
      }
      if (!Util.isNullOrNil((String)localObject2)) {
        paramcjc.h("userdefine_record_id", localObject2);
      }
      parame = new i();
      parame.h("Str_uc_params", paramcjc);
      paramTRTCParams.businessInfo = parame.toString();
    }
    label615:
    AppMethodBeat.o(207593);
  }
  
  public static void a(String paramString, cjb paramcjb, civ paramciv, TRTCCloudDef.TRTCParams paramTRTCParams, com.tencent.mm.live.core.core.b.e parame)
  {
    AppMethodBeat.i(207592);
    p.h(paramString, "name");
    p.h(paramcjb, "liveSdkInfo");
    p.h(paramciv, "liveInfo");
    p.h(paramTRTCParams, "trtcParams");
    p.h(parame, "liveRoomInfo");
    paramTRTCParams.roomId = paramcjb.Mok;
    paramTRTCParams.sdkAppId = paramcjb.Moj;
    paramTRTCParams.privateMapKey = z.a(paramcjb.Mon);
    paramTRTCParams.userId = paramcjb.MnL;
    paramTRTCParams.userSig = z.a(paramcjb.Mom);
    int i = paramcjb.Mol;
    o.j localj = o.j.hHj;
    if (i != o.j.aFK())
    {
      localj = o.j.hHj;
      if (i != o.j.aFL()) {}
    }
    for (i = 21;; i = 20)
    {
      paramTRTCParams.role = i;
      parame.Gn(paramString);
      parame.liveId = paramciv.hyH;
      paramString = (Map)parame.hzs;
      paramciv = paramcjb.Mos;
      p.g(paramciv, "liveSdkInfo.live_cdn_url");
      paramString.put(Integer.valueOf(0), paramciv);
      parame.hzm = paramcjb.Mop;
      paramString = new cjc();
      paramcjb = paramcjb.Moo;
      p.g(paramcjb, "liveSdkInfo.sdk_params");
      paramString = paramString.parseFrom(paramcjb.zy);
      if (paramString != null) {
        break;
      }
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveSdkParams");
      AppMethodBeat.o(207592);
      throw paramString;
    }
    paramString = (cjc)paramString;
    parame.hzl = paramString.Mov.MnW;
    parame.appId = paramString.Mov.MnY;
    parame.hzn = paramString.Mov.MnZ;
    a(paramString, paramTRTCParams, parame);
    AppMethodBeat.o(207592);
  }
  
  public static boolean da(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 == -100020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.n
 * JD-Core Version:    0.7.0.1
 */