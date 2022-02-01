package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum o
{
  public static final Map<String, Integer> njD;
  public static final Set<String> njE;
  private static final a<z, ab> njF;
  
  static
  {
    AppMethodBeat.i(136427);
    njG = new o[0];
    Object localObject = new HashSet();
    ((Set)localObject).add("text");
    ((Set)localObject).add("emoji");
    ((Set)localObject).add("number");
    ((Set)localObject).add("digit");
    ((Set)localObject).add("idcard");
    njE = Collections.unmodifiableSet((Set)localObject);
    localObject = new HashMap(3);
    ((Map)localObject).put("digit", Integer.valueOf(2));
    ((Map)localObject).put("number", Integer.valueOf(0));
    ((Map)localObject).put("idcard", Integer.valueOf(1));
    njD = Collections.unmodifiableMap((Map)localObject);
    njF = new a();
    AppMethodBeat.o(136427);
  }
  
  public static aa A(z paramz)
  {
    AppMethodBeat.i(136426);
    if (paramz == null)
    {
      AppMethodBeat.o(136426);
      return null;
    }
    ab localab = (ab)njF.get(paramz);
    if (localab == null)
    {
      AppMethodBeat.o(136426);
      return null;
    }
    paramz = a(paramz, localab.getInputId());
    AppMethodBeat.o(136426);
    return paramz;
  }
  
  public static aa a(z paramz, int paramInt)
  {
    AppMethodBeat.i(136418);
    paramz = e.a(paramz, new e.a()
    {
      public final boolean a(aa paramAnonymousaa)
      {
        AppMethodBeat.i(136411);
        if ((paramAnonymousaa.bEH() != null) && (((ab)paramAnonymousaa.bEH()).getInputId() == this.kRB))
        {
          AppMethodBeat.o(136411);
          return true;
        }
        AppMethodBeat.o(136411);
        return false;
      }
    });
    AppMethodBeat.o(136418);
    return paramz;
  }
  
  static void a(z paramz, final ab paramab)
  {
    AppMethodBeat.i(136424);
    if (paramz == null)
    {
      AppMethodBeat.o(136424);
      return;
    }
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136413);
        o.bFg().put(this.lfA, paramab);
        AppMethodBeat.o(136413);
      }
    });
    AppMethodBeat.o(136424);
  }
  
  public static void a(z paramz, final String paramString, final Integer paramInteger)
  {
    AppMethodBeat.i(136419);
    if (paramz == null)
    {
      AppMethodBeat.o(136419);
      return;
    }
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136412);
        Object localObject = (ab)o.bFg().get(this.kDF);
        if (localObject != null)
        {
          localObject = o.a(this.kDF, ((ab)localObject).getInputId());
          if (localObject != null) {
            ((aa)localObject).a(paramString, paramInteger);
          }
        }
        AppMethodBeat.o(136412);
      }
    });
    AppMethodBeat.o(136419);
  }
  
  public static boolean a(z paramz, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136422);
    aa localaa = a(paramz, paramInt1);
    if ((localaa != null) && (localaa.v(paramz)) && (localaa.ew(paramInt2, paramInt3)))
    {
      AppMethodBeat.o(136422);
      return true;
    }
    AppMethodBeat.o(136422);
    return false;
  }
  
  public static boolean a(z paramz, Integer paramInteger)
  {
    AppMethodBeat.i(136421);
    Integer localInteger = paramInteger;
    if (paramInteger == null) {}
    try
    {
      paramInteger = (ab)njF.get(paramz);
      if (paramInteger == null)
      {
        AppMethodBeat.o(136421);
        return false;
      }
      localInteger = Integer.valueOf(paramInteger.getInputId());
      paramz = a(paramz, localInteger.intValue());
      if ((paramz != null) && (paramz.bEM()))
      {
        AppMethodBeat.o(136421);
        return true;
      }
    }
    catch (Throwable paramz)
    {
      ae.printErrStackTrace("MicroMsg.AppBrandInputService", paramz, "[NOT CRASH]", new Object[0]);
      AppMethodBeat.o(136421);
      return false;
    }
    AppMethodBeat.o(136421);
    return false;
  }
  
  static void b(z paramz, aa paramaa)
  {
    AppMethodBeat.i(136417);
    e.a(paramz, paramaa);
    AppMethodBeat.o(136417);
  }
  
  public static boolean b(z paramz, int paramInt)
  {
    AppMethodBeat.i(136423);
    paramz = a(paramz, paramInt);
    if ((paramz != null) && (paramz.bEG()))
    {
      AppMethodBeat.o(136423);
      return true;
    }
    AppMethodBeat.o(136423);
    return false;
  }
  
  public static boolean y(z paramz)
  {
    AppMethodBeat.i(136420);
    boolean bool = a(paramz, null);
    AppMethodBeat.o(136420);
    return bool;
  }
  
  static void z(z paramz)
  {
    AppMethodBeat.i(136425);
    if (paramz == null)
    {
      AppMethodBeat.o(136425);
      return;
    }
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136414);
        o.bFg().remove(this.lfA);
        AppMethodBeat.o(136414);
      }
    });
    AppMethodBeat.o(136425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.o
 * JD-Core Version:    0.7.0.1
 */