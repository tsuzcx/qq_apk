package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum o
{
  public static final Map<String, Integer> mDW;
  public static final Set<String> mDX;
  private static final a<com.tencent.mm.plugin.appbrand.page.aa, ab> mDY;
  
  static
  {
    AppMethodBeat.i(136427);
    mDZ = new o[0];
    Object localObject = new HashSet();
    ((Set)localObject).add("text");
    ((Set)localObject).add("emoji");
    ((Set)localObject).add("number");
    ((Set)localObject).add("digit");
    ((Set)localObject).add("idcard");
    mDX = Collections.unmodifiableSet((Set)localObject);
    localObject = new HashMap(3);
    ((Map)localObject).put("digit", Integer.valueOf(2));
    ((Map)localObject).put("number", Integer.valueOf(0));
    ((Map)localObject).put("idcard", Integer.valueOf(1));
    mDW = Collections.unmodifiableMap((Map)localObject);
    mDY = new a();
    AppMethodBeat.o(136427);
  }
  
  public static aa a(com.tencent.mm.plugin.appbrand.page.aa paramaa, int paramInt)
  {
    AppMethodBeat.i(136418);
    paramaa = e.a(paramaa, new e.a()
    {
      public final boolean a(aa paramAnonymousaa)
      {
        AppMethodBeat.i(136411);
        if ((paramAnonymousaa.bzM() != null) && (((ab)paramAnonymousaa.bzM()).getInputId() == this.ksD))
        {
          AppMethodBeat.o(136411);
          return true;
        }
        AppMethodBeat.o(136411);
        return false;
      }
    });
    AppMethodBeat.o(136418);
    return paramaa;
  }
  
  static void a(com.tencent.mm.plugin.appbrand.page.aa paramaa, final ab paramab)
  {
    AppMethodBeat.i(136424);
    if (paramaa == null)
    {
      AppMethodBeat.o(136424);
      return;
    }
    l.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136413);
        o.bAm().put(this.kFz, paramab);
        AppMethodBeat.o(136413);
      }
    });
    AppMethodBeat.o(136424);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.page.aa paramaa, final String paramString, final Integer paramInteger)
  {
    AppMethodBeat.i(136419);
    if (paramaa == null)
    {
      AppMethodBeat.o(136419);
      return;
    }
    l.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136412);
        Object localObject = (ab)o.bAm().get(this.kfC);
        if (localObject != null)
        {
          localObject = o.a(this.kfC, ((ab)localObject).getInputId());
          if (localObject != null) {
            ((aa)localObject).a(paramString, paramInteger);
          }
        }
        AppMethodBeat.o(136412);
      }
    });
    AppMethodBeat.o(136419);
  }
  
  public static boolean a(com.tencent.mm.plugin.appbrand.page.aa paramaa, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136422);
    aa localaa = a(paramaa, paramInt1);
    if ((localaa != null) && (localaa.u(paramaa)) && (localaa.eu(paramInt2, paramInt3)))
    {
      AppMethodBeat.o(136422);
      return true;
    }
    AppMethodBeat.o(136422);
    return false;
  }
  
  public static boolean a(com.tencent.mm.plugin.appbrand.page.aa paramaa, Integer paramInteger)
  {
    AppMethodBeat.i(136421);
    Integer localInteger = paramInteger;
    if (paramInteger == null) {}
    try
    {
      paramInteger = (ab)mDY.get(paramaa);
      if (paramInteger == null)
      {
        AppMethodBeat.o(136421);
        return false;
      }
      localInteger = Integer.valueOf(paramInteger.getInputId());
      paramaa = a(paramaa, localInteger.intValue());
      if ((paramaa != null) && (paramaa.bzS()))
      {
        AppMethodBeat.o(136421);
        return true;
      }
    }
    catch (Throwable paramaa)
    {
      ac.printErrStackTrace("MicroMsg.AppBrandInputService", paramaa, "[NOT CRASH]", new Object[0]);
      AppMethodBeat.o(136421);
      return false;
    }
    AppMethodBeat.o(136421);
    return false;
  }
  
  static void b(com.tencent.mm.plugin.appbrand.page.aa paramaa, aa paramaa1)
  {
    AppMethodBeat.i(136417);
    e.a(paramaa, paramaa1);
    AppMethodBeat.o(136417);
  }
  
  public static boolean b(com.tencent.mm.plugin.appbrand.page.aa paramaa, int paramInt)
  {
    AppMethodBeat.i(136423);
    paramaa = a(paramaa, paramInt);
    if ((paramaa != null) && (paramaa.bzL()))
    {
      AppMethodBeat.o(136423);
      return true;
    }
    AppMethodBeat.o(136423);
    return false;
  }
  
  public static boolean x(com.tencent.mm.plugin.appbrand.page.aa paramaa)
  {
    AppMethodBeat.i(136420);
    boolean bool = a(paramaa, null);
    AppMethodBeat.o(136420);
    return bool;
  }
  
  static void y(com.tencent.mm.plugin.appbrand.page.aa paramaa)
  {
    AppMethodBeat.i(136425);
    if (paramaa == null)
    {
      AppMethodBeat.o(136425);
      return;
    }
    l.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136414);
        o.bAm().remove(this.kFz);
        AppMethodBeat.o(136414);
      }
    });
    AppMethodBeat.o(136425);
  }
  
  public static aa z(com.tencent.mm.plugin.appbrand.page.aa paramaa)
  {
    AppMethodBeat.i(136426);
    if (paramaa == null)
    {
      AppMethodBeat.o(136426);
      return null;
    }
    ab localab = (ab)mDY.get(paramaa);
    if (localab == null)
    {
      AppMethodBeat.o(136426);
      return null;
    }
    paramaa = a(paramaa, localab.getInputId());
    AppMethodBeat.o(136426);
    return paramaa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.o
 * JD-Core Version:    0.7.0.1
 */