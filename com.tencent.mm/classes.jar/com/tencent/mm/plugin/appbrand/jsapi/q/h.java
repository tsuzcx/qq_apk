package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.t.t.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class h
{
  private static String hYT;
  private static String hYU;
  private static g hYV;
  private static t.a hYW;
  private static t.a hYX;
  private static boolean mEnable;
  
  static
  {
    AppMethodBeat.i(126390);
    mEnable = false;
    hYT = "";
    hYU = "";
    hYV = new g();
    hYW = t.a.iYd;
    hYX = t.a.iYd;
    AppMethodBeat.o(126390);
  }
  
  public static void a(Configuration paramConfiguration, String paramString)
  {
    AppMethodBeat.i(126388);
    if (paramConfiguration.orientation == 2) {
      if (hYW == t.a.iYh) {
        hYX = t.a.iYh;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.OrientationConfigListenerHelper", "onConfigurationChanged mAppid:" + hYT + "; appid:" + paramString + "; mOrientation:" + hYX.name());
      if ((hYT.equalsIgnoreCase("")) || (!hYT.equalsIgnoreCase(paramString)) || (!mEnable)) {
        break;
      }
      hYV.a(hYX);
      AppMethodBeat.o(126388);
      return;
      hYX = t.a.iYf;
      continue;
      if (paramConfiguration.orientation == 1) {
        hYX = t.a.iYe;
      } else {
        hYX = t.a.iYd;
      }
    }
    hYU = paramString;
    AppMethodBeat.o(126388);
  }
  
  public static void b(t.a parama)
  {
    AppMethodBeat.i(126389);
    hYW = parama;
    if ((mEnable) && (hYX == t.a.iYf) && ((parama == t.a.iYh) || (parama == t.a.iYf)))
    {
      hYV.a(parama);
      ab.i("MicroMsg.OrientationConfigListenerHelper", "onFourOrientationsChange mAppid:" + hYT + "; mOrientation:" + parama.name());
    }
    AppMethodBeat.o(126389);
  }
  
  public static void u(c paramc)
  {
    AppMethodBeat.i(126386);
    hYT = paramc.getAppId();
    mEnable = true;
    hYV.j(paramc);
    if ((hYX != t.a.iYd) && (hYU.equalsIgnoreCase(hYT))) {
      hYV.a(hYX);
    }
    for (;;)
    {
      ab.i("MicroMsg.OrientationConfigListenerHelper", "init mJsAppid:" + hYT + "; mEnable:" + mEnable);
      AppMethodBeat.o(126386);
      return;
      hYX = t.a.iYd;
    }
  }
  
  public static void v(c paramc)
  {
    AppMethodBeat.i(126387);
    if (paramc.getAppId().equalsIgnoreCase(hYT))
    {
      ab.i("MicroMsg.OrientationConfigListenerHelper", "unInit mAppid:" + hYT);
      hYT = "";
      mEnable = false;
      hYX = t.a.iYd;
    }
    AppMethodBeat.o(126387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.h
 * JD-Core Version:    0.7.0.1
 */