package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.content.res.Configuration;
import com.tencent.mm.bl.a.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.y;

public final class g
{
  private static String gBa = "";
  private static String gBb = "";
  private static f gBc = new f();
  private static a.a gBd = a.a.eQB;
  private static a.a gBe = a.a.eQB;
  private static boolean mEnable = false;
  
  public static void a(Configuration paramConfiguration, String paramString)
  {
    if (paramConfiguration.orientation == 2) {
      if (gBd == a.a.eQF) {
        gBe = a.a.eQF;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.OrientationConfigListenerHelper", "onConfigurationChanged mAppid:" + gBa + "; appid:" + paramString + "; mOrientation:" + gBe.name());
      if ((gBa.equalsIgnoreCase("")) || (!gBa.equalsIgnoreCase(paramString)) || (!mEnable)) {
        break;
      }
      gBc.a(gBe);
      return;
      gBe = a.a.eQD;
      continue;
      if (paramConfiguration.orientation == 1) {
        gBe = a.a.eQC;
      } else {
        gBe = a.a.eQB;
      }
    }
    gBb = paramString;
  }
  
  public static void b(a.a parama)
  {
    gBd = parama;
    if ((mEnable) && (gBe == a.a.eQD) && ((parama == a.a.eQF) || (parama == a.a.eQD)))
    {
      gBc.a(parama);
      y.i("MicroMsg.OrientationConfigListenerHelper", "onFourOrientationsChange mAppid:" + gBa + "; mOrientation:" + parama.name());
    }
  }
  
  public static void f(o paramo)
  {
    gBa = paramo.mAppId;
    mEnable = true;
    gBc.d(paramo);
    if ((gBe != a.a.eQB) && (gBb.equalsIgnoreCase(gBa))) {
      gBc.a(gBe);
    }
    for (;;)
    {
      y.i("MicroMsg.OrientationConfigListenerHelper", "init mJsAppid:" + gBa + "; mEnable:" + mEnable);
      return;
      gBe = a.a.eQB;
    }
  }
  
  public static void g(o paramo)
  {
    if (paramo.mAppId.equalsIgnoreCase(gBa))
    {
      y.i("MicroMsg.OrientationConfigListenerHelper", "unInit mAppid:" + gBa);
      gBa = "";
      mEnable = false;
      gBe = a.a.eQB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.g
 * JD-Core Version:    0.7.0.1
 */