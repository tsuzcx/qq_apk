package com.tencent.mm.plugin.appbrand.game.a;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import d.ac;
import d.f;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "", "()V", "mConfigMemory", "Ljava/lang/Object;", "askRestart", "", "context", "Landroid/content/Context;", "message", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "", "enableKv", "getConfig", "()Ljava/lang/Object;", "getConfigDefaultValue", "getConfigImpl", "getConfigLocalStorage", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Object;", "onProcessConfigBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", "onProcessConfigFloat", "", "(Ljava/lang/String;)Ljava/lang/Float;", "onProcessConfigInt", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "onProcessConfigLong", "", "(Ljava/lang/String;)Ljava/lang/Long;", "processCommand", "value", "removeConfigLocalStorage", "setConfigLocalStorage", "(Ljava/lang/Object;)V", "Companion", "plugin-appbrand-integration_release"})
public abstract class t<T>
{
  private static final f kkZ = d.g.O((a)b.klb);
  public static final a kla = new a((byte)0);
  private T kkY;
  
  protected static Boolean OQ(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if ("true".contentEquals((CharSequence)paramString)) {
      return Boolean.TRUE;
    }
    if ("false".contentEquals((CharSequence)paramString)) {
      return Boolean.FALSE;
    }
    paramString = n.bdh(paramString);
    if (paramString != null)
    {
      if (paramString.intValue() > 0) {
        return Boolean.TRUE;
      }
      if ((paramString.intValue() == 0) || (paramString.intValue() == -1)) {
        return Boolean.FALSE;
      }
      throw ((Throwable)new IllegalStateException("Ambiguity name"));
    }
    return null;
  }
  
  private static void T(Context paramContext, String paramString)
  {
    new AlertDialog.Builder(paramContext).setTitle((CharSequence)"").setMessage((CharSequence)paramString).setNegativeButton((CharSequence)"cancel", null).setPositiveButton((CharSequence)"restart", (DialogInterface.OnClickListener)t.c.klc).show();
  }
  
  public static final void a(Context paramContext, String[] paramArrayOfString)
  {
    a.a(paramContext, paramArrayOfString);
  }
  
  protected abstract T OO(String paramString);
  
  public final void S(Context paramContext, String paramString)
  {
    int k = 1;
    int j = 1;
    p.h(paramContext, "context");
    if (bhb() != null) {}
    for (int i = 1; (ac.MKp) && (i == 0); i = 0) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    Object localObject = OO(paramString);
    if (localObject == null)
    {
      if (bhb() != null) {}
      for (i = 1; (ac.MKp) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      paramString = ax.aQz("WAGameDynamicConfig");
      paramString.remove("WAGameDynamicConfig" + bhb());
      paramString.commit();
      if (!paramString.containsKey("WAGameDynamicConfig" + bhb())) {}
      for (i = j; (ac.MKp) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      ad.i("WAGameDynamicConfig", "dl: remove localstorage config");
      if (bhd()) {
        T(paramContext, "config[" + bhb() + "] removed");
      }
    }
    do
    {
      return;
      if (bhb() != null) {}
      for (i = k; (ac.MKp) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      ax localax = ax.aQz("WAGameDynamicConfig");
      localax.encode("WAGameDynamicConfig" + bhb(), String.valueOf(localObject));
      localax.commit();
      ad.i("WAGameDynamicConfig", "dl: set localstorage config ".concat(String.valueOf(paramString)));
    } while (!bhd());
    T(paramContext, "config[" + bhb() + "] set to " + localObject);
  }
  
  public T ate()
  {
    Object localObject = this.kkY;
    if (localObject != null) {
      return localObject;
    }
    if (bhb() != null)
    {
      localObject = ax.aQz("WAGameDynamicConfig").decodeString("WAGameDynamicConfig" + bhb(), null);
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null) {
          break label81;
        }
        ad.i("WAGameDynamicConfig", "hit localstorage");
      }
    }
    for (;;)
    {
      this.kkY = localObject;
      return localObject;
      localObject = OO((String)localObject);
      break;
      label81:
      if (bhc() != null)
      {
        localObject = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(bhc(), "");
        if (localObject != null)
        {
          localObject = OO((String)localObject);
          if (localObject != null)
          {
            ad.i("WAGameDynamicConfig", "hit ABTest");
            continue;
          }
        }
      }
      localObject = bhe();
    }
  }
  
  protected String bhb()
  {
    return null;
  }
  
  protected b.a bhc()
  {
    return null;
  }
  
  protected boolean bhd()
  {
    return true;
  }
  
  public abstract T bhe();
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig$Companion;", "", "()V", "TAG", "", "mCommandProcessor", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "getMCommandProcessor", "()Ljava/util/List;", "mCommandProcessor$delegate", "Lkotlin/Lazy;", "checkNotDuplicate", "", "registry", "processCommand", "context", "Landroid/content/Context;", "args", "", "(Landroid/content/Context;[Ljava/lang/String;)V", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static void a(Context paramContext, String[] paramArrayOfString)
    {
      AppMethodBeat.i(50391);
      p.h(paramContext, "context");
      p.h(paramArrayOfString, "args");
      if (paramArrayOfString.length >= 3) {}
      for (int i = 1; (ac.MKp) && (i == 0); i = 0)
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      if ((paramArrayOfString[1] != null) && (paramArrayOfString[0] != null)) {}
      for (i = 1; (ac.MKp) && (i == 0); i = 0)
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      boolean bool = n.H("//wagame", paramArrayOfString[0], true);
      if ((ac.MKp) && (!bool))
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      Object localObject1 = t.bhi();
      Object localObject2 = t.kla;
      localObject2 = ((Iterable)((f)localObject1).getValue()).iterator();
      t localt;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = ((Iterator)localObject2).next();
        localt = (t)localObject1;
      } while (!n.H(paramArrayOfString[1], localt.bhb(), false));
      for (;;)
      {
        localObject1 = (t)localObject1;
        if (localObject1 != null) {
          break;
        }
        Toast.makeText(aj.getContext(), (CharSequence)("Unknown config name " + paramArrayOfString[1]), 0).show();
        AppMethodBeat.o(50391);
        return;
        localObject1 = null;
      }
      ((t)localObject1).S(paramContext, paramArrayOfString[2]);
      AppMethodBeat.o(50391);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "invoke"})
  static final class b
    extends q
    implements a<List<t<?>>>
  {
    public static final b klb;
    
    static
    {
      AppMethodBeat.i(50389);
      klb = new b();
      AppMethodBeat.o(50389);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.t
 * JD-Core Version:    0.7.0.1
 */