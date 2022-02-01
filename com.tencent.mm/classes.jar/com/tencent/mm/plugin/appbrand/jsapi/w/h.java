package com.tencent.mm.plugin.appbrand.jsapi.w;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.utils.aa.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
{
  private static String lhl;
  private static String lhm;
  private static g lhn;
  private static aa.a lho;
  private static aa.a lhp;
  private static boolean mEnable;
  
  static
  {
    AppMethodBeat.i(137644);
    mEnable = false;
    lhl = "";
    lhm = "";
    lhn = new g();
    lho = aa.a.mPq;
    lhp = aa.a.mPq;
    AppMethodBeat.o(137644);
  }
  
  public static void A(c paramc)
  {
    AppMethodBeat.i(137641);
    if (paramc.getAppId().equalsIgnoreCase(lhl))
    {
      ad.i("MicroMsg.OrientationConfigListenerHelper", "unInit mAppid:" + lhl);
      lhl = "";
      mEnable = false;
      lhp = aa.a.mPq;
    }
    AppMethodBeat.o(137641);
  }
  
  public static void a(Configuration paramConfiguration, String paramString)
  {
    AppMethodBeat.i(137642);
    if (paramConfiguration.orientation == 2) {
      if (lho == aa.a.mPu) {
        lhp = aa.a.mPu;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.OrientationConfigListenerHelper", "onConfigurationChanged mAppid:" + lhl + "; appid:" + paramString + "; mOrientation:" + lhp.name());
      if ((lhl.equalsIgnoreCase("")) || (!lhl.equalsIgnoreCase(paramString)) || (!mEnable)) {
        break;
      }
      lhn.b(lhp);
      AppMethodBeat.o(137642);
      return;
      lhp = aa.a.mPs;
      continue;
      if (paramConfiguration.orientation == 1) {
        lhp = aa.a.mPr;
      } else {
        lhp = aa.a.mPq;
      }
    }
    lhm = paramString;
    AppMethodBeat.o(137642);
  }
  
  public static void c(aa.a parama)
  {
    AppMethodBeat.i(137643);
    lho = parama;
    if ((mEnable) && (lhp == aa.a.mPs) && ((parama == aa.a.mPu) || (parama == aa.a.mPs)))
    {
      lhn.b(parama);
      ad.i("MicroMsg.OrientationConfigListenerHelper", "onFourOrientationsChange mAppid:" + lhl + "; mOrientation:" + parama.name());
    }
    AppMethodBeat.o(137643);
  }
  
  public static void z(c paramc)
  {
    AppMethodBeat.i(137640);
    lhl = paramc.getAppId();
    mEnable = true;
    lhn.h(paramc);
    if ((lhp != aa.a.mPq) && (lhm.equalsIgnoreCase(lhl))) {
      lhn.b(lhp);
    }
    for (;;)
    {
      ad.i("MicroMsg.OrientationConfigListenerHelper", "init mJsAppid:" + lhl + "; mEnable:" + mEnable);
      AppMethodBeat.o(137640);
      return;
      lhp = aa.a.mPq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.h
 * JD-Core Version:    0.7.0.1
 */