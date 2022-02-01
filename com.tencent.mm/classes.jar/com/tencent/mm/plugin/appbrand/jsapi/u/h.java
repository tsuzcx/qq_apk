package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
{
  private static String kjv;
  private static String kjw;
  private static g kjx;
  private static z.a kjy;
  private static z.a kjz;
  private static boolean mEnable;
  
  static
  {
    AppMethodBeat.i(137644);
    mEnable = false;
    kjv = "";
    kjw = "";
    kjx = new g();
    kjy = z.a.lMO;
    kjz = z.a.lMO;
    AppMethodBeat.o(137644);
  }
  
  public static void A(c paramc)
  {
    AppMethodBeat.i(137641);
    if (paramc.getAppId().equalsIgnoreCase(kjv))
    {
      ad.i("MicroMsg.OrientationConfigListenerHelper", "unInit mAppid:" + kjv);
      kjv = "";
      mEnable = false;
      kjz = z.a.lMO;
    }
    AppMethodBeat.o(137641);
  }
  
  public static void a(Configuration paramConfiguration, String paramString)
  {
    AppMethodBeat.i(137642);
    if (paramConfiguration.orientation == 2) {
      if (kjy == z.a.lMS) {
        kjz = z.a.lMS;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.OrientationConfigListenerHelper", "onConfigurationChanged mAppid:" + kjv + "; appid:" + paramString + "; mOrientation:" + kjz.name());
      if ((kjv.equalsIgnoreCase("")) || (!kjv.equalsIgnoreCase(paramString)) || (!mEnable)) {
        break;
      }
      kjx.b(kjz);
      AppMethodBeat.o(137642);
      return;
      kjz = z.a.lMQ;
      continue;
      if (paramConfiguration.orientation == 1) {
        kjz = z.a.lMP;
      } else {
        kjz = z.a.lMO;
      }
    }
    kjw = paramString;
    AppMethodBeat.o(137642);
  }
  
  public static void c(z.a parama)
  {
    AppMethodBeat.i(137643);
    kjy = parama;
    if ((mEnable) && (kjz == z.a.lMQ) && ((parama == z.a.lMS) || (parama == z.a.lMQ)))
    {
      kjx.b(parama);
      ad.i("MicroMsg.OrientationConfigListenerHelper", "onFourOrientationsChange mAppid:" + kjv + "; mOrientation:" + parama.name());
    }
    AppMethodBeat.o(137643);
  }
  
  public static void z(c paramc)
  {
    AppMethodBeat.i(137640);
    kjv = paramc.getAppId();
    mEnable = true;
    kjx.h(paramc);
    if ((kjz != z.a.lMO) && (kjw.equalsIgnoreCase(kjv))) {
      kjx.b(kjz);
    }
    for (;;)
    {
      ad.i("MicroMsg.OrientationConfigListenerHelper", "init mJsAppid:" + kjv + "; mEnable:" + mEnable);
      AppMethodBeat.o(137640);
      return;
      kjz = z.a.lMO;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.h
 * JD-Core Version:    0.7.0.1
 */