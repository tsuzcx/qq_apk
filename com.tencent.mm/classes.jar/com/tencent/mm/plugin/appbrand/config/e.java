package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.sdk.platformtools.ac;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  public static ArrayList<byte[]> W(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146963);
    localArrayList = new ArrayList();
    Object localObject = new i();
    paramAppBrandRuntime.DH().b("cer", (i)localObject);
    if (((i)localObject).value == null)
    {
      AppMethodBeat.o(146963);
      return localArrayList;
    }
    localObject = com.tencent.mm.plugin.appbrand.z.d.q((ByteBuffer)((i)localObject).value);
    try
    {
      paramAppBrandRuntime = new bsy();
      paramAppBrandRuntime.parseFrom((byte[])localObject);
      localObject = paramAppBrandRuntime.FhX;
      if (localObject == null)
      {
        AppMethodBeat.o(146963);
        return localArrayList;
      }
      paramAppBrandRuntime = paramAppBrandRuntime.FhX.iterator();
      while (paramAppBrandRuntime.hasNext()) {
        localArrayList.add(((b)paramAppBrandRuntime.next()).xy);
      }
      return localArrayList;
    }
    catch (Exception paramAppBrandRuntime)
    {
      ac.e("", "readPkgCertificate, parse error: ".concat(String.valueOf(paramAppBrandRuntime)));
      AppMethodBeat.o(146963);
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.jsapi.file.d a(AppBrandSysConfigLU paramAppBrandSysConfigLU)
  {
    AppMethodBeat.i(146964);
    com.tencent.mm.plugin.appbrand.jsapi.file.d locald = new com.tencent.mm.plugin.appbrand.jsapi.file.d();
    locald.ccC = paramAppBrandSysConfigLU.ccC;
    if (locald.ccC <= 0L) {
      locald.ccC = 10L;
    }
    locald.jCX = paramAppBrandSysConfigLU.ccO.jCX;
    if (locald.jCX <= 0L) {
      locald.jCX = 30L;
    }
    AppMethodBeat.o(146964);
    return locald;
  }
  
  public static int s(int... paramVarArgs)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.e
 * JD-Core Version:    0.7.0.1
 */