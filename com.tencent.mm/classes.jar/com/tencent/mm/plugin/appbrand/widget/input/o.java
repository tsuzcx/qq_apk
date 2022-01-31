package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.e.a;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.s.m;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum o
{
  public static final Map<String, Integer> jmi;
  public static final Set<String> jmj;
  private static final a<v, ab> jmk;
  
  static
  {
    AppMethodBeat.i(123693);
    jml = new o[0];
    Object localObject = new HashSet();
    ((Set)localObject).add("text");
    ((Set)localObject).add("emoji");
    ((Set)localObject).add("number");
    ((Set)localObject).add("digit");
    ((Set)localObject).add("idcard");
    jmj = Collections.unmodifiableSet((Set)localObject);
    localObject = new HashMap(3);
    ((Map)localObject).put("digit", Integer.valueOf(2));
    ((Map)localObject).put("number", Integer.valueOf(0));
    ((Map)localObject).put("idcard", Integer.valueOf(1));
    jmi = Collections.unmodifiableMap((Map)localObject);
    jmk = new a();
    AppMethodBeat.o(123693);
  }
  
  public static aa a(v paramv, int paramInt)
  {
    AppMethodBeat.i(123684);
    paramv = e.a(paramv, new e.a()
    {
      public final boolean a(aa paramAnonymousaa)
      {
        AppMethodBeat.i(123677);
        if ((paramAnonymousaa.aQw() != null) && (((ab)paramAnonymousaa.aQw()).getInputId() == this.hMH))
        {
          AppMethodBeat.o(123677);
          return true;
        }
        AppMethodBeat.o(123677);
        return false;
      }
    });
    AppMethodBeat.o(123684);
    return paramv;
  }
  
  static void a(v paramv, ab paramab)
  {
    AppMethodBeat.i(123690);
    if (paramv == null)
    {
      AppMethodBeat.o(123690);
      return;
    }
    m.runOnUiThread(new o.3(paramv, paramab));
    AppMethodBeat.o(123690);
  }
  
  public static void a(v paramv, String paramString, Integer paramInteger)
  {
    AppMethodBeat.i(123685);
    if (paramv == null)
    {
      AppMethodBeat.o(123685);
      return;
    }
    m.runOnUiThread(new o.2(paramv, paramString, paramInteger));
    AppMethodBeat.o(123685);
  }
  
  public static boolean a(v paramv, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(123688);
    aa localaa = a(paramv, paramInt1);
    if ((localaa != null) && (localaa.n(paramv)) && (localaa.dw(paramInt2, paramInt3)))
    {
      AppMethodBeat.o(123688);
      return true;
    }
    AppMethodBeat.o(123688);
    return false;
  }
  
  public static boolean a(v paramv, Integer paramInteger)
  {
    AppMethodBeat.i(123687);
    Integer localInteger = paramInteger;
    if (paramInteger == null) {}
    try
    {
      paramInteger = (ab)jmk.get(paramv);
      if (paramInteger == null)
      {
        AppMethodBeat.o(123687);
        return false;
      }
      localInteger = Integer.valueOf(paramInteger.getInputId());
      paramv = a(paramv, localInteger.intValue());
      if ((paramv != null) && (paramv.aQB()))
      {
        AppMethodBeat.o(123687);
        return true;
      }
    }
    catch (Throwable paramv)
    {
      d.printErrStackTrace("MicroMsg.AppBrandInputService", paramv, "[NOT CRASH]", new Object[0]);
      AppMethodBeat.o(123687);
      return false;
    }
    AppMethodBeat.o(123687);
    return false;
  }
  
  static void b(v paramv, aa paramaa)
  {
    AppMethodBeat.i(123683);
    e.a(paramv, paramaa);
    AppMethodBeat.o(123683);
  }
  
  public static boolean b(v paramv, int paramInt)
  {
    AppMethodBeat.i(123689);
    paramv = a(paramv, paramInt);
    if ((paramv != null) && (paramv.aQv()))
    {
      AppMethodBeat.o(123689);
      return true;
    }
    AppMethodBeat.o(123689);
    return false;
  }
  
  public static boolean q(v paramv)
  {
    AppMethodBeat.i(123686);
    boolean bool = a(paramv, null);
    AppMethodBeat.o(123686);
    return bool;
  }
  
  static void r(v paramv)
  {
    AppMethodBeat.i(123691);
    if (paramv == null)
    {
      AppMethodBeat.o(123691);
      return;
    }
    m.runOnUiThread(new o.4(paramv));
    AppMethodBeat.o(123691);
  }
  
  public static aa s(v paramv)
  {
    AppMethodBeat.i(123692);
    if (paramv == null)
    {
      AppMethodBeat.o(123692);
      return null;
    }
    ab localab = (ab)jmk.get(paramv);
    if (localab == null)
    {
      AppMethodBeat.o(123692);
      return null;
    }
    paramv = a(paramv, localab.getInputId());
    AppMethodBeat.o(123692);
    return paramv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.o
 * JD-Core Version:    0.7.0.1
 */