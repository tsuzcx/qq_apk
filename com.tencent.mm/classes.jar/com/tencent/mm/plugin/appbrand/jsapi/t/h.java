package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.utils.aa.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class h
{
  private static String kKM;
  private static String kKN;
  private static g kKO;
  private static aa.a kKP;
  private static aa.a kKQ;
  private static boolean mEnable;
  
  static
  {
    AppMethodBeat.i(137644);
    mEnable = false;
    kKM = "";
    kKN = "";
    kKO = new g();
    kKP = aa.a.moO;
    kKQ = aa.a.moO;
    AppMethodBeat.o(137644);
  }
  
  public static void A(c paramc)
  {
    AppMethodBeat.i(137641);
    if (paramc.getAppId().equalsIgnoreCase(kKM))
    {
      ac.i("MicroMsg.OrientationConfigListenerHelper", "unInit mAppid:" + kKM);
      kKM = "";
      mEnable = false;
      kKQ = aa.a.moO;
    }
    AppMethodBeat.o(137641);
  }
  
  public static void a(Configuration paramConfiguration, String paramString)
  {
    AppMethodBeat.i(137642);
    if (paramConfiguration.orientation == 2) {
      if (kKP == aa.a.moS) {
        kKQ = aa.a.moS;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.OrientationConfigListenerHelper", "onConfigurationChanged mAppid:" + kKM + "; appid:" + paramString + "; mOrientation:" + kKQ.name());
      if ((kKM.equalsIgnoreCase("")) || (!kKM.equalsIgnoreCase(paramString)) || (!mEnable)) {
        break;
      }
      kKO.b(kKQ);
      AppMethodBeat.o(137642);
      return;
      kKQ = aa.a.moQ;
      continue;
      if (paramConfiguration.orientation == 1) {
        kKQ = aa.a.moP;
      } else {
        kKQ = aa.a.moO;
      }
    }
    kKN = paramString;
    AppMethodBeat.o(137642);
  }
  
  public static void c(aa.a parama)
  {
    AppMethodBeat.i(137643);
    kKP = parama;
    if ((mEnable) && (kKQ == aa.a.moQ) && ((parama == aa.a.moS) || (parama == aa.a.moQ)))
    {
      kKO.b(parama);
      ac.i("MicroMsg.OrientationConfigListenerHelper", "onFourOrientationsChange mAppid:" + kKM + "; mOrientation:" + parama.name());
    }
    AppMethodBeat.o(137643);
  }
  
  public static void z(c paramc)
  {
    AppMethodBeat.i(137640);
    kKM = paramc.getAppId();
    mEnable = true;
    kKO.h(paramc);
    if ((kKQ != aa.a.moO) && (kKN.equalsIgnoreCase(kKM))) {
      kKO.b(kKQ);
    }
    for (;;)
    {
      ac.i("MicroMsg.OrientationConfigListenerHelper", "init mJsAppid:" + kKM + "; mEnable:" + mEnable);
      AppMethodBeat.o(137640);
      return;
      kKQ = aa.a.moO;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.h
 * JD-Core Version:    0.7.0.1
 */