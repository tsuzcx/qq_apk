package com.tencent.mm.plugin.appbrand.jsapi.w;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.utils.ad.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class h
{
  private static String lkX;
  private static String lkY;
  private static g lkZ;
  private static ad.a lla;
  private static ad.a llb;
  private static boolean mEnable;
  
  static
  {
    AppMethodBeat.i(137644);
    mEnable = false;
    lkX = "";
    lkY = "";
    lkZ = new g();
    lla = ad.a.mUz;
    llb = ad.a.mUz;
    AppMethodBeat.o(137644);
  }
  
  public static void A(c paramc)
  {
    AppMethodBeat.i(137641);
    if (paramc.getAppId().equalsIgnoreCase(lkX))
    {
      ae.i("MicroMsg.OrientationConfigListenerHelper", "unInit mAppid:" + lkX);
      lkX = "";
      mEnable = false;
      llb = ad.a.mUz;
    }
    AppMethodBeat.o(137641);
  }
  
  public static void a(Configuration paramConfiguration, String paramString)
  {
    AppMethodBeat.i(137642);
    if (paramConfiguration.orientation == 2) {
      if (lla == ad.a.mUE) {
        llb = ad.a.mUE;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.OrientationConfigListenerHelper", "onConfigurationChanged mAppid:" + lkX + "; appid:" + paramString + "; mOrientation:" + llb.name());
      if ((lkX.equalsIgnoreCase("")) || (!lkX.equalsIgnoreCase(paramString)) || (!mEnable)) {
        break;
      }
      lkZ.b(llb);
      AppMethodBeat.o(137642);
      return;
      llb = ad.a.mUC;
      continue;
      if (paramConfiguration.orientation == 1) {
        llb = ad.a.mUB;
      } else {
        llb = ad.a.mUz;
      }
    }
    lkY = paramString;
    AppMethodBeat.o(137642);
  }
  
  public static void c(ad.a parama)
  {
    AppMethodBeat.i(137643);
    lla = parama;
    if ((mEnable) && (llb == ad.a.mUC) && ((parama == ad.a.mUE) || (parama == ad.a.mUC)))
    {
      lkZ.b(parama);
      ae.i("MicroMsg.OrientationConfigListenerHelper", "onFourOrientationsChange mAppid:" + lkX + "; mOrientation:" + parama.name());
    }
    AppMethodBeat.o(137643);
  }
  
  public static void z(c paramc)
  {
    AppMethodBeat.i(137640);
    lkX = paramc.getAppId();
    mEnable = true;
    lkZ.h(paramc);
    if ((llb != ad.a.mUz) && (lkY.equalsIgnoreCase(lkX))) {
      lkZ.b(llb);
    }
    for (;;)
    {
      ae.i("MicroMsg.OrientationConfigListenerHelper", "init mJsAppid:" + lkX + "; mEnable:" + mEnable);
      AppMethodBeat.o(137640);
      return;
      llb = ad.a.mUz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.h
 * JD-Core Version:    0.7.0.1
 */