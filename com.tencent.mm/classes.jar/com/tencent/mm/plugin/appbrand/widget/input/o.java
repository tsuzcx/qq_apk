package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum o
{
  public static final Map<String, Integer> otl;
  public static final Set<String> otm;
  private static final a<ac, ab> otn;
  
  static
  {
    AppMethodBeat.i(136427);
    oto = new o[0];
    Object localObject = new HashSet();
    ((Set)localObject).add("text");
    ((Set)localObject).add("emoji");
    ((Set)localObject).add("number");
    ((Set)localObject).add("digit");
    ((Set)localObject).add("idcard");
    otm = Collections.unmodifiableSet((Set)localObject);
    localObject = new HashMap(3);
    ((Map)localObject).put("digit", Integer.valueOf(2));
    ((Map)localObject).put("number", Integer.valueOf(0));
    ((Map)localObject).put("idcard", Integer.valueOf(1));
    otl = Collections.unmodifiableMap((Map)localObject);
    otn = new a();
    AppMethodBeat.o(136427);
  }
  
  public static boolean D(ac paramac)
  {
    AppMethodBeat.i(136420);
    boolean bool = a(paramac, null);
    AppMethodBeat.o(136420);
    return bool;
  }
  
  static void E(ac paramac)
  {
    AppMethodBeat.i(136425);
    if (paramac == null)
    {
      AppMethodBeat.o(136425);
      return;
    }
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136414);
        o.cbv().remove(this.mkX);
        AppMethodBeat.o(136414);
      }
    });
    AppMethodBeat.o(136425);
  }
  
  public static aa F(ac paramac)
  {
    AppMethodBeat.i(136426);
    if (paramac == null)
    {
      AppMethodBeat.o(136426);
      return null;
    }
    ab localab = (ab)otn.get(paramac);
    if (localab == null)
    {
      AppMethodBeat.o(136426);
      return null;
    }
    paramac = a(paramac, localab.getInputId());
    AppMethodBeat.o(136426);
    return paramac;
  }
  
  public static aa a(ac paramac, int paramInt)
  {
    AppMethodBeat.i(136418);
    paramac = e.a(paramac, new e.a()
    {
      public final boolean a(aa paramAnonymousaa)
      {
        AppMethodBeat.i(136411);
        if ((paramAnonymousaa.caV() != null) && (((ab)paramAnonymousaa.caV()).getInputId() == this.lWD))
        {
          AppMethodBeat.o(136411);
          return true;
        }
        AppMethodBeat.o(136411);
        return false;
      }
    });
    AppMethodBeat.o(136418);
    return paramac;
  }
  
  static void a(ac paramac, final ab paramab)
  {
    AppMethodBeat.i(136424);
    if (paramac == null)
    {
      AppMethodBeat.o(136424);
      return;
    }
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136413);
        o.cbv().put(this.mkX, paramab);
        AppMethodBeat.o(136413);
      }
    });
    AppMethodBeat.o(136424);
  }
  
  public static void a(ac paramac, final String paramString, final Integer paramInteger)
  {
    AppMethodBeat.i(136419);
    if (paramac == null)
    {
      AppMethodBeat.o(136419);
      return;
    }
    m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136412);
        Object localObject = (ab)o.cbv().get(this.lIf);
        if (localObject != null)
        {
          localObject = o.a(this.lIf, ((ab)localObject).getInputId());
          if (localObject != null) {
            ((aa)localObject).a(paramString, paramInteger);
          }
        }
        AppMethodBeat.o(136412);
      }
    });
    AppMethodBeat.o(136419);
  }
  
  public static boolean a(ac paramac, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136422);
    aa localaa = a(paramac, paramInt1);
    if ((localaa != null) && (localaa.A(paramac)) && (localaa.q(paramInt2, paramInt3, paramac.kEb.OG())))
    {
      AppMethodBeat.o(136422);
      return true;
    }
    AppMethodBeat.o(136422);
    return false;
  }
  
  public static boolean a(ac paramac, Integer paramInteger)
  {
    AppMethodBeat.i(136421);
    Integer localInteger = paramInteger;
    if (paramInteger == null) {}
    try
    {
      paramInteger = (ab)otn.get(paramac);
      if (paramInteger == null)
      {
        AppMethodBeat.o(136421);
        return false;
      }
      localInteger = Integer.valueOf(paramInteger.getInputId());
      paramac = a(paramac, localInteger.intValue());
      if ((paramac != null) && (paramac.cba()))
      {
        AppMethodBeat.o(136421);
        return true;
      }
    }
    catch (Throwable paramac)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandInputService", paramac, "[NOT CRASH]", new Object[0]);
      AppMethodBeat.o(136421);
      return false;
    }
    AppMethodBeat.o(136421);
    return false;
  }
  
  static void b(ac paramac, aa paramaa)
  {
    AppMethodBeat.i(136417);
    e.a(paramac, paramaa);
    AppMethodBeat.o(136417);
  }
  
  public static boolean b(ac paramac, int paramInt)
  {
    AppMethodBeat.i(136423);
    paramac = a(paramac, paramInt);
    if ((paramac != null) && (paramac.caU()))
    {
      AppMethodBeat.o(136423);
      return true;
    }
    AppMethodBeat.o(136423);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.o
 * JD-Core Version:    0.7.0.1
 */