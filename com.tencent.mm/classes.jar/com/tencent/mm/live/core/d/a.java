package com.tencent.mm.live.core.d;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/util/LiveCoreUtil;", "", "()V", "LIMIT_URL_SEQ", "", "TAG", "calcFloatBallSize", "Landroid/graphics/Point;", "width", "", "height", "genDecryptionParamsByChannel", "liveSdkChannelParams", "Lcom/tencent/mm/protocal/protobuf/LiveSdkChannelParams;", "url", "genDecryptionParamsByLiveInfo", "finderLiveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "getSizeFromDp", "dp", "isLimitUrl", "", "isTest", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final String TAG;
  public static final a mWH;
  
  static
  {
    AppMethodBeat.i(247682);
    mWH = new a();
    TAG = "Finder.LiveCoreUtil";
    AppMethodBeat.o(247682);
  }
  
  public static boolean Gd(String paramString)
  {
    AppMethodBeat.i(247672);
    s.u(paramString, "url");
    boolean bool = n.a((CharSequence)paramString, (CharSequence)"openid=reqtoken_", false);
    AppMethodBeat.o(247672);
    return bool;
  }
  
  public static String a(bip parambip, String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(247651);
    s.u(paramString, "url");
    if (parambip == null) {
      parambip = (bip)localObject1;
    }
    for (;;)
    {
      localObject1 = parambip;
      if (parambip == null)
      {
        Log.e(TAG, "genDecryptionParams error sdk_params null!");
        localObject1 = new diw();
      }
      parambip = a((diw)localObject1, paramString);
      AppMethodBeat.o(247651);
      return parambip;
      Object localObject2 = parambip.ZOg;
      parambip = (bip)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((dix)localObject2).aaOv;
        parambip = (bip)localObject1;
        if (localObject2 != null)
        {
          parambip = new diy();
          parambip.parseFrom(((b)localObject2).toByteArray());
          parambip = parambip.aaOC;
        }
      }
    }
  }
  
  public static String a(diw paramdiw, String paramString)
  {
    AppMethodBeat.i(247661);
    s.u(paramString, "url");
    if ((paramdiw != null) && (paramdiw.aaOn > 0))
    {
      localObject = (CharSequence)paramdiw.aaOo;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label65;
      }
    }
    label65:
    for (int i = 1; i != 0; i = 0)
    {
      Log.e(TAG, "genDecryptionParams error!");
      AppMethodBeat.o(247661);
      return "";
    }
    Object localObject = new i();
    ((i)localObject).m("api", "setEncryptionParams");
    i locali = new i();
    locali.m("url", paramString);
    locali.au("encMode", paramdiw.aaOn);
    paramString = (CharSequence)paramdiw.aaOp;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        locali.m("encIV", paramdiw.aaOp);
      }
      locali.m("encKey", paramdiw.aaOo);
      paramdiw = ah.aiuX;
      ((i)localObject).m("params", locali);
      paramdiw = ((i)localObject).toString();
      s.s(paramdiw, "{\n            JSONObject…   }.toString()\n        }");
      AppMethodBeat.o(247661);
      return paramdiw;
    }
  }
  
  public static boolean bgV()
  {
    return (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG);
  }
  
  public static Point em(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(247641);
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      Log.i(TAG, "calcFloatBallSize invalid, width:" + paramInt1 + ", height:" + paramInt2);
      localPoint = new Point(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 88), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 132));
      AppMethodBeat.o(247641);
      return localPoint;
    }
    float f = paramInt1 / paramInt2;
    Log.i(TAG, "calcFloatBallSize width:" + paramInt1 + ", height:" + paramInt2 + ", rate:" + f);
    if (f >= 1.5F)
    {
      localPoint = new Point(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 132), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 88));
      AppMethodBeat.o(247641);
      return localPoint;
    }
    if (f >= 0.6666667F)
    {
      localPoint = new Point(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 108), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 108));
      AppMethodBeat.o(247641);
      return localPoint;
    }
    Point localPoint = new Point(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 88), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 132));
    AppMethodBeat.o(247641);
    return localPoint;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.d.a
 * JD-Core Version:    0.7.0.1
 */