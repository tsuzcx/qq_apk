package com.tencent.mm.plugin.appbrand.jsapi.y;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.ad.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
{
  private static boolean mEnable;
  private static String mqI;
  private static String mqJ;
  private static g mqK;
  private static ad.a mqL;
  private static ad.a mqM;
  
  static
  {
    AppMethodBeat.i(137644);
    mEnable = false;
    mqI = "";
    mqJ = "";
    mqK = new g();
    mqL = ad.a.ohA;
    mqM = ad.a.ohA;
    AppMethodBeat.o(137644);
  }
  
  public static void A(f paramf)
  {
    AppMethodBeat.i(137640);
    mqI = paramf.getAppId();
    mEnable = true;
    mqK.h(paramf);
    if ((mqM != ad.a.ohA) && (mqJ.equalsIgnoreCase(mqI))) {
      mqK.b(mqM);
    }
    for (;;)
    {
      Log.i("MicroMsg.OrientationConfigListenerHelper", "init mJsAppid:" + mqI + "; mEnable:" + mEnable);
      AppMethodBeat.o(137640);
      return;
      mqM = ad.a.ohA;
    }
  }
  
  public static void B(f paramf)
  {
    AppMethodBeat.i(137641);
    if (paramf.getAppId().equalsIgnoreCase(mqI))
    {
      Log.i("MicroMsg.OrientationConfigListenerHelper", "unInit mAppid:" + mqI);
      mqI = "";
      mEnable = false;
      mqM = ad.a.ohA;
    }
    AppMethodBeat.o(137641);
  }
  
  public static void a(Configuration paramConfiguration, String paramString)
  {
    AppMethodBeat.i(137642);
    if (paramConfiguration.orientation == 2) {
      if (mqL == ad.a.ohE) {
        mqM = ad.a.ohE;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.OrientationConfigListenerHelper", "onConfigurationChanged mAppid:" + mqI + "; appid:" + paramString + "; mOrientation:" + mqM.name());
      if ((mqI.equalsIgnoreCase("")) || (!mqI.equalsIgnoreCase(paramString)) || (!mEnable)) {
        break;
      }
      mqK.b(mqM);
      AppMethodBeat.o(137642);
      return;
      mqM = ad.a.ohC;
      continue;
      if (paramConfiguration.orientation == 1) {
        mqM = ad.a.ohB;
      } else {
        mqM = ad.a.ohA;
      }
    }
    mqJ = paramString;
    AppMethodBeat.o(137642);
  }
  
  public static void c(ad.a parama)
  {
    AppMethodBeat.i(137643);
    mqL = parama;
    if ((mEnable) && (mqM == ad.a.ohC) && ((parama == ad.a.ohE) || (parama == ad.a.ohC)))
    {
      mqK.b(parama);
      Log.i("MicroMsg.OrientationConfigListenerHelper", "onFourOrientationsChange mAppid:" + mqI + "; mOrientation:" + parama.name());
    }
    AppMethodBeat.o(137643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.h
 * JD-Core Version:    0.7.0.1
 */