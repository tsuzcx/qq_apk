package com.tencent.mm.plugin.appbrand.config;

import android.webkit.WebSettings;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.file.c;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.s.q;
import com.tencent.mm.plugin.appbrand.s.q.a;
import com.tencent.mm.protocal.protobuf.bbx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  public static c a(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    AppMethodBeat.i(101790);
    c localc = new c();
    localc.bDx = paramAppBrandSysConfigLU.bDx;
    if (localc.bDx <= 0L) {
      localc.bDx = 10L;
    }
    localc.hhZ = paramAppBrandSysConfigLU.bDI.hhZ;
    if (localc.hhZ <= 0L) {
      localc.hhZ = 30L;
    }
    AppMethodBeat.o(101790);
    return localc;
  }
  
  public static String ayp()
  {
    AppMethodBeat.i(101791);
    try
    {
      String str1 = WebSettings.getDefaultUserAgent(ah.getContext());
      str1 = q.a(ah.getContext(), str1, (q.a)e.q(q.a.class));
      AppMethodBeat.o(101791);
      return str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = System.getProperty("http.agent");
      }
    }
  }
  
  public static int p(int... paramVarArgs)
  {
    int k = 0;
    int i = 0;
    if (k < 2)
    {
      int m = paramVarArgs[k];
      int j;
      if (m > 0) {
        if (i == 0) {
          j = m;
        }
      }
      for (;;)
      {
        k += 1;
        i = j;
        break;
        j = m;
        if (m >= i) {
          j = i;
        }
      }
    }
    return i;
  }
  
  public static ArrayList<byte[]> s(i parami)
  {
    AppMethodBeat.i(101789);
    localArrayList = new ArrayList();
    Object localObject = new j();
    parami.wX().b("cer", (j)localObject);
    if (((j)localObject).value == null)
    {
      AppMethodBeat.o(101789);
      return localArrayList;
    }
    localObject = com.tencent.mm.plugin.appbrand.s.d.m((ByteBuffer)((j)localObject).value);
    try
    {
      parami = new bbx();
      parami.parseFrom((byte[])localObject);
      localObject = parami.xqY;
      if (localObject == null)
      {
        AppMethodBeat.o(101789);
        return localArrayList;
      }
      parami = parami.xqY.iterator();
      while (parami.hasNext()) {
        localArrayList.add(((b)parami.next()).pW);
      }
      return localArrayList;
    }
    catch (Exception parami)
    {
      ab.e("", "readPkgCertificate, parse error: ".concat(String.valueOf(parami)));
      AppMethodBeat.o(101789);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.d
 * JD-Core Version:    0.7.0.1
 */