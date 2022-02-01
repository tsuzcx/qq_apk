package com.tencent.mm.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.bx.b;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.live.core.core.model.j;
import com.tencent.mm.live.core.core.trtc.sdkadapter.a.a;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.protocal.protobuf.xb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/LiveCgiUtil;", "", "()V", "checkCookiesDeprecated", "", "errType", "", "errCode", "parseAnchorStatusJson", "Lcom/tencent/mm/json/JSONObject;", "status", "Lcom/tencent/mm/protobuf/ByteString;", "processLiveCgiSDKResponse", "", "name", "", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "trtcParams", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "processLiveSdkParams", "liveSdkParam", "Lcom/tencent/mm/protocal/protobuf/LiveSdkParams;", "setupAnchorStatusJson", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k mYa;
  
  static
  {
    AppMethodBeat.i(246606);
    mYa = new k();
    AppMethodBeat.o(246606);
  }
  
  public static void a(diy paramdiy, TRTCCloudDef.TRTCParams paramTRTCParams, g paramg)
  {
    AppMethodBeat.i(246588);
    s.u(paramdiy, "liveSdkParam");
    s.u(paramg, "liveRoomInfo");
    Object localObject1 = paramdiy.aaOA;
    Object localObject2 = paramdiy.aaOC;
    int i;
    if (localObject1 != null)
    {
      if (((diz)localObject1).aaOD > 0) {
        a.a.bfr().bfn().mSZ = ((diz)localObject1).aaOD;
      }
      if (((diz)localObject1).aaOF > 0) {
        a.a.bfr().bfn().mTa = ((diz)localObject1).aaOF;
      }
      if (((diz)localObject1).aaOG > 0) {
        a.a.bfr().bfn().mVideoBitrate = ((diz)localObject1).aaOG;
      }
      if (((diz)localObject1).aaON > 0) {
        a.a.bfr().bfn().mMinVideoBitrate = ((diz)localObject1).aaON;
      }
      if (((diz)localObject1).aaOP > 0) {
        a.a.bfr().bfn().mTb = ((diz)localObject1).aaOP;
      }
      if (((diz)localObject1).aaOQ > 0) {
        a.a.bfr().bfn().mTc = ((diz)localObject1).aaOQ;
      }
      if (((diz)localObject1).aaOR > 0) {
        a.a.bfr().bfn().mTd = ((diz)localObject1).aaOR;
      }
      if (((diz)localObject1).aaOS > 0) {
        a.a.bfr().bfn().mTe = ((diz)localObject1).aaOS;
      }
      if (((diz)localObject1).aaOI > 0) {
        a.a.bfr().bfn().mQosPreference = ((diz)localObject1).aaOI;
      }
      i = ((diz)localObject1).aaOJ;
      if (i < 0) {
        break label546;
      }
      if (i > 1) {
        break label541;
      }
      i = 1;
      if (i != 0) {
        a.a.bfr().bfn().mQosMode = ((diz)localObject1).aaOJ;
      }
    }
    if ((localObject2 != null) && (paramTRTCParams != null))
    {
      Log.i("MicroMsg.LiveCoreSdk", "userDefineRecordId:" + ((diw)localObject2).aaNE + ',' + ((diw)localObject2).aaNF);
      paramdiy = ((diw)localObject2).aaNF;
      localObject1 = ((diw)localObject2).aaNE;
      int j = ((diw)localObject2).aaNO;
      String str1 = ((diw)localObject2).aaOl;
      i = j;
      if (!e.wb(5))
      {
        i = j;
        if (j == com.tencent.mm.live.core.core.a.mJu.value) {
          i = ((diw)localObject2).aaNP;
        }
      }
      paramg.mJU = ((diw)localObject2).aaNP;
      label398:
      Object localObject3;
      if (i < 100)
      {
        paramg.a(com.tencent.mm.live.core.core.model.a.mMz);
        paramg.mNr = i;
        localObject3 = (Collection)((diw)localObject2).aaNK;
        if ((localObject3 != null) && (!((Collection)localObject3).isEmpty())) {
          break label591;
        }
      }
      label541:
      label546:
      label591:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label596;
        }
        localObject2 = ((diw)localObject2).aaNK;
        s.s(localObject2, "channelParams.cdn_trans_info");
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (xb)((Iterator)localObject2).next();
          Map localMap = (Map)paramg.mNt;
          i = ((xb)localObject3).ZeQ;
          String str2 = ((xb)localObject3).url;
          s.s(str2, "it.url");
          localMap.put(Integer.valueOf(i), new j(str2, ((xb)localObject3).ZeS, ((xb)localObject3).ZeT));
        }
        i = 0;
        break;
        i = 0;
        break;
        if (i == com.tencent.mm.live.core.core.a.mJv.value)
        {
          paramg.a(com.tencent.mm.live.core.core.model.a.mMA);
          break label398;
        }
        if (i != com.tencent.mm.live.core.core.a.mJw.value) {
          break label398;
        }
        paramg.a(com.tencent.mm.live.core.core.model.a.mMB);
        break label398;
      }
      label596:
      if ((!Util.isNullOrNil(paramdiy)) || (!Util.isNullOrNil((String)localObject1)) || (!Util.isNullOrNil(str1)))
      {
        paramg = new i();
        if (!Util.isNullOrNil(paramdiy)) {
          paramg.m("userdefine_streamid_main", paramdiy);
        }
        if (!Util.isNullOrNil((String)localObject1)) {
          paramg.m("userdefine_record_id", localObject1);
        }
        if (!Util.isNullOrNil(str1)) {
          paramg.m("userdefine_push_args", str1);
        }
        paramdiy = new i();
        paramdiy.m("Str_uc_params", paramg);
        paramTRTCParams.businessInfo = paramdiy.toString();
      }
    }
    AppMethodBeat.o(246588);
  }
  
  public static void a(String paramString, dix paramdix, dio paramdio, TRTCCloudDef.TRTCParams paramTRTCParams, g paramg)
  {
    AppMethodBeat.i(246566);
    s.u(paramString, "name");
    s.u(paramdix, "liveSdkInfo");
    s.u(paramdio, "liveInfo");
    s.u(paramTRTCParams, "trtcParams");
    s.u(paramg, "liveRoomInfo");
    paramTRTCParams.roomId = paramdix.aaOr;
    paramTRTCParams.sdkAppId = paramdix.aaOq;
    paramTRTCParams.privateMapKey = w.a(paramdix.aaOu);
    paramTRTCParams.userId = paramdix.aaNn;
    paramTRTCParams.userSig = w.a(paramdix.aaOt);
    int i = paramdix.aaOs;
    l.i locali = l.i.mYH;
    if (i != l.i.bhC())
    {
      locali = l.i.mYH;
      if (i != l.i.bhD()) {}
    }
    for (i = 21;; i = 20)
    {
      paramTRTCParams.role = i;
      paramg.FN(paramString);
      paramg.liveId = paramdio.mMJ;
      paramString = (Map)paramg.mNt;
      paramdio = paramdix.aaOz;
      s.s(paramdio, "liveSdkInfo.live_cdn_url");
      paramString.put(Integer.valueOf(0), new j(paramdio, 0, ""));
      paramg.mNo = paramdix.aaOw;
      paramString = new diy().parseFrom(paramdix.aaOv.Op);
      if (paramString != null) {
        break;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LiveSdkParams");
      AppMethodBeat.o(246566);
      throw paramString;
    }
    paramString = (diy)paramString;
    paramg.mNn = paramString.aaOC.aaNG;
    paramg.appId = paramString.aaOC.aaNI;
    paramg.mNp = paramString.aaOC.aaNJ;
    a(paramString, paramTRTCParams, paramg);
    AppMethodBeat.o(246566);
  }
  
  public static boolean en(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 == -100020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.model.k
 * JD-Core Version:    0.7.0.1
 */