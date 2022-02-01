package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Looper;
import androidx.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum o
{
  public static final Map<String, Integer> uGA;
  public static final Set<String> uGB;
  private static final a<ad, af> uGC;
  
  static
  {
    AppMethodBeat.i(136427);
    uGD = new o[0];
    Object localObject = new HashSet();
    ((Set)localObject).add("text");
    ((Set)localObject).add("emoji");
    ((Set)localObject).add("number");
    ((Set)localObject).add("digit");
    ((Set)localObject).add("idcard");
    ((Set)localObject).add("safe-password");
    uGB = Collections.unmodifiableSet((Set)localObject);
    localObject = new HashMap(3);
    ((Map)localObject).put("digit", Integer.valueOf(2));
    ((Map)localObject).put("number", Integer.valueOf(0));
    ((Map)localObject).put("idcard", Integer.valueOf(1));
    uGA = Collections.unmodifiableMap((Map)localObject);
    uGC = new a();
    AppMethodBeat.o(136427);
  }
  
  public static boolean E(ad paramad)
  {
    AppMethodBeat.i(136420);
    boolean bool = a(paramad, null);
    AppMethodBeat.o(136420);
    return bool;
  }
  
  static void F(ad paramad)
  {
    AppMethodBeat.i(136425);
    if (paramad == null)
    {
      AppMethodBeat.o(136425);
      return;
    }
    com.tencent.mm.plugin.appbrand.af.o.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136414);
        o.cRh().remove(o.this);
        AppMethodBeat.o(136414);
      }
    });
    AppMethodBeat.o(136425);
  }
  
  public static ae<?> G(ad paramad)
  {
    AppMethodBeat.i(136426);
    if (paramad == null)
    {
      AppMethodBeat.o(136426);
      return null;
    }
    af localaf = (af)uGC.get(paramad);
    if (localaf == null)
    {
      AppMethodBeat.o(136426);
      return null;
    }
    paramad = a(paramad, localaf.getInputId());
    AppMethodBeat.o(136426);
    return paramad;
  }
  
  public static ae<?> a(ad paramad, int paramInt)
  {
    AppMethodBeat.i(136418);
    paramad = e.a(paramad, new e.a()
    {
      public final boolean a(ae<?> paramAnonymousae)
      {
        AppMethodBeat.i(136411);
        if ((paramAnonymousae.cQE() != null) && (((af)paramAnonymousae.cQE()).getInputId() == this.rZD))
        {
          AppMethodBeat.o(136411);
          return true;
        }
        AppMethodBeat.o(136411);
        return false;
      }
    });
    AppMethodBeat.o(136418);
    return paramad;
  }
  
  static void a(ad paramad, final af paramaf)
  {
    AppMethodBeat.i(136424);
    if (paramad == null)
    {
      AppMethodBeat.o(136424);
      return;
    }
    com.tencent.mm.plugin.appbrand.af.o.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136413);
        o.cRh().put(o.this, paramaf);
        AppMethodBeat.o(136413);
      }
    });
    AppMethodBeat.o(136424);
  }
  
  public static void a(ad paramad, final String paramString, final Integer paramInteger)
  {
    AppMethodBeat.i(136419);
    if (paramad == null)
    {
      AppMethodBeat.o(136419);
      return;
    }
    com.tencent.mm.plugin.appbrand.af.o.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136412);
        Object localObject = (af)o.cRh().get(o.this);
        if (localObject != null)
        {
          localObject = o.a(o.this, ((af)localObject).getInputId());
          if (localObject != null) {
            ((ae)localObject).a(paramString, paramInteger);
          }
        }
        AppMethodBeat.o(136412);
      }
    });
    AppMethodBeat.o(136419);
  }
  
  public static boolean a(ad paramad, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136422);
    ae localae = a(paramad, paramInt1);
    if ((localae != null) && (localae.B(paramad)) && (localae.r(paramInt2, paramInt3, paramad.qwF.ast())))
    {
      AppMethodBeat.o(136422);
      return true;
    }
    AppMethodBeat.o(136422);
    return false;
  }
  
  public static boolean a(ad paramad, Integer paramInteger)
  {
    AppMethodBeat.i(136421);
    Integer localInteger = paramInteger;
    if (paramInteger == null) {}
    try
    {
      paramInteger = (af)uGC.get(paramad);
      if (paramInteger == null)
      {
        AppMethodBeat.o(136421);
        return false;
      }
      localInteger = Integer.valueOf(paramInteger.getInputId());
      paramad = a(paramad, localInteger.intValue());
      if ((paramad != null) && (paramad.cQN()))
      {
        AppMethodBeat.o(136421);
        return true;
      }
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.AppBrandInputService", paramad, "[NOT CRASH]", new Object[0]);
      AppMethodBeat.o(136421);
      return false;
    }
    AppMethodBeat.o(136421);
    return false;
  }
  
  static void b(ad paramad, ae<?> paramae)
  {
    AppMethodBeat.i(136417);
    e.a(paramad, paramae);
    AppMethodBeat.o(136417);
  }
  
  static void b(ad paramad, final af paramaf)
  {
    AppMethodBeat.i(324535);
    if ((paramad == null) || (paramaf == null))
    {
      AppMethodBeat.o(324535);
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      com.tencent.mm.plugin.appbrand.af.o.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(324646);
          o.b(o.this, paramaf);
          AppMethodBeat.o(324646);
        }
      });
      AppMethodBeat.o(324535);
      return;
    }
    if (uGC.get(paramad) == paramaf) {
      uGC.remove(paramad);
    }
    AppMethodBeat.o(324535);
  }
  
  public static boolean b(ad paramad, int paramInt)
  {
    AppMethodBeat.i(136423);
    paramad = a(paramad, paramInt);
    if ((paramad != null) && (paramad.cQD()))
    {
      AppMethodBeat.o(136423);
      return true;
    }
    AppMethodBeat.o(136423);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.o
 * JD-Core Version:    0.7.0.1
 */