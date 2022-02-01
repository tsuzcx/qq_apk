package com.tencent.mm.plugin.appbrand.jsapi.aa;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.utils.af.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
{
  private static boolean mEnable;
  private static String poP;
  private static String poQ;
  private static g poR;
  private static af.a poS;
  private static af.a poT;
  
  static
  {
    AppMethodBeat.i(137644);
    mEnable = false;
    poP = "";
    poQ = "";
    poR = new g();
    poS = af.a.rjo;
    poT = af.a.rjo;
    AppMethodBeat.o(137644);
  }
  
  public static void D(e parame)
  {
    AppMethodBeat.i(137640);
    poP = parame.getAppId();
    mEnable = true;
    poR.j(parame);
    if ((poT != af.a.rjo) && (poQ.equalsIgnoreCase(poP))) {
      poR.b(poT);
    }
    for (;;)
    {
      Log.i("MicroMsg.OrientationConfigListenerHelper", "init mJsAppid:" + poP + "; mEnable:" + mEnable);
      AppMethodBeat.o(137640);
      return;
      poT = af.a.rjo;
    }
  }
  
  public static void E(e parame)
  {
    AppMethodBeat.i(137641);
    if (parame.getAppId().equalsIgnoreCase(poP))
    {
      Log.i("MicroMsg.OrientationConfigListenerHelper", "unInit mAppid:" + poP);
      poP = "";
      mEnable = false;
      poT = af.a.rjo;
    }
    AppMethodBeat.o(137641);
  }
  
  public static void a(Configuration paramConfiguration, String paramString)
  {
    AppMethodBeat.i(137642);
    if (paramConfiguration.orientation == 2) {
      if (poS == af.a.rjs) {
        poT = af.a.rjs;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.OrientationConfigListenerHelper", "onConfigurationChanged mAppid:" + poP + "; appid:" + paramString + "; mOrientation:" + poT.name());
      if ((poP.equalsIgnoreCase("")) || (!poP.equalsIgnoreCase(paramString)) || (!mEnable)) {
        break;
      }
      poR.b(poT);
      AppMethodBeat.o(137642);
      return;
      poT = af.a.rjq;
      continue;
      if (paramConfiguration.orientation == 1) {
        poT = af.a.rjp;
      } else {
        poT = af.a.rjo;
      }
    }
    poQ = paramString;
    AppMethodBeat.o(137642);
  }
  
  public static void c(af.a parama)
  {
    AppMethodBeat.i(137643);
    poS = parama;
    if ((mEnable) && (poT == af.a.rjq) && ((parama == af.a.rjs) || (parama == af.a.rjq)))
    {
      poR.b(parama);
      Log.i("MicroMsg.OrientationConfigListenerHelper", "onFourOrientationsChange mAppid:" + poP + "; mOrientation:" + parama.name());
    }
    AppMethodBeat.o(137643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.h
 * JD-Core Version:    0.7.0.1
 */