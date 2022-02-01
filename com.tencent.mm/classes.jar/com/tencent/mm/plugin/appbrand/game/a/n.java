package com.tencent.mm.plugin.appbrand.game.a;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import d.aa;
import d.f;
import d.g.b.u;
import d.g.b.w;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "", "()V", "mConfigMemory", "Ljava/lang/Object;", "askRestart", "", "context", "Landroid/content/Context;", "message", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "", "enableKv", "getConfig", "()Ljava/lang/Object;", "getConfigDefaultValue", "getConfigImpl", "getConfigLocalStorage", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Object;", "onProcessConfigBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", "onProcessConfigFloat", "", "(Ljava/lang/String;)Ljava/lang/Float;", "onProcessConfigInt", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "onProcessConfigLong", "", "(Ljava/lang/String;)Ljava/lang/Long;", "processCommand", "value", "removeConfigLocalStorage", "setConfigLocalStorage", "(Ljava/lang/Object;)V", "Companion", "plugin-appbrand-integration_release"})
public abstract class n<T>
{
  private static final f jqs = d.g.E((d.g.a.a)b.jqu);
  public static final a jqt = new a((byte)0);
  private T jqr;
  
  protected static Boolean Hs(String paramString)
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
    paramString = d.n.n.aRf(paramString);
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
    new AlertDialog.Builder(paramContext).setTitle((CharSequence)"").setMessage((CharSequence)paramString).setNegativeButton((CharSequence)"cancel", null).setPositiveButton((CharSequence)"restart", (DialogInterface.OnClickListener)c.jqv).show();
  }
  
  public static final void a(Context paramContext, String[] paramArrayOfString)
  {
    a.a(paramContext, paramArrayOfString);
  }
  
  protected abstract T Hq(String paramString);
  
  public final void S(Context paramContext, String paramString)
  {
    int k = 1;
    int j = 1;
    d.g.b.k.h(paramContext, "context");
    if (aWz() != null) {}
    for (int i = 1; (aa.JfW) && (i == 0); i = 0) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    Object localObject = Hq(paramString);
    if (localObject == null)
    {
      if (aWz() != null) {}
      for (i = 1; (aa.JfW) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      paramString = ax.aFC("WAGameDynamicConfig");
      paramString.remove("WAGameDynamicConfig" + aWz());
      paramString.commit();
      if (!paramString.containsKey("WAGameDynamicConfig" + aWz())) {}
      for (i = j; (aa.JfW) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      ad.i("WAGameDynamicConfig", "dl: remove localstorage config");
      if (aWB()) {
        T(paramContext, "config[" + aWz() + "] removed");
      }
    }
    do
    {
      return;
      if (aWz() != null) {}
      for (i = k; (aa.JfW) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      ax localax = ax.aFC("WAGameDynamicConfig");
      localax.encode("WAGameDynamicConfig" + aWz(), String.valueOf(localObject));
      localax.commit();
      ad.i("WAGameDynamicConfig", "dl: set localstorage config ".concat(String.valueOf(paramString)));
    } while (!aWB());
    T(paramContext, "config[" + aWz() + "] set to " + localObject);
  }
  
  protected b.a aWA()
  {
    return null;
  }
  
  protected boolean aWB()
  {
    return true;
  }
  
  public abstract T aWC();
  
  protected String aWz()
  {
    return null;
  }
  
  public T ajp()
  {
    Object localObject = this.jqr;
    if (localObject != null) {
      return localObject;
    }
    if (aWz() != null)
    {
      localObject = ax.aFC("WAGameDynamicConfig").decodeString("WAGameDynamicConfig" + aWz(), null);
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
      this.jqr = localObject;
      return localObject;
      localObject = Hq((String)localObject);
      break;
      label81:
      if (aWA() != null)
      {
        localObject = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(aWA(), "");
        if (localObject != null)
        {
          localObject = Hq((String)localObject);
          if (localObject != null)
          {
            ad.i("WAGameDynamicConfig", "hit ABTest");
            continue;
          }
        }
      }
      localObject = aWC();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig$Companion;", "", "()V", "TAG", "", "mCommandProcessor", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "getMCommandProcessor", "()Ljava/util/List;", "mCommandProcessor$delegate", "Lkotlin/Lazy;", "checkNotDuplicate", "", "registry", "processCommand", "context", "Landroid/content/Context;", "args", "", "(Landroid/content/Context;[Ljava/lang/String;)V", "plugin-appbrand-integration_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(50390);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(a.class), "mCommandProcessor", "getMCommandProcessor()Ljava/util/List;")) };
      AppMethodBeat.o(50390);
    }
    
    public static void a(Context paramContext, String[] paramArrayOfString)
    {
      AppMethodBeat.i(50391);
      d.g.b.k.h(paramContext, "context");
      d.g.b.k.h(paramArrayOfString, "args");
      if (paramArrayOfString.length >= 3) {}
      for (int i = 1; (aa.JfW) && (i == 0); i = 0)
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      if ((paramArrayOfString[1] != null) && (paramArrayOfString[0] != null)) {}
      for (i = 1; (aa.JfW) && (i == 0); i = 0)
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      boolean bool = d.n.n.I("//wagame", paramArrayOfString[0], true);
      if ((aa.JfW) && (!bool))
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      Object localObject1 = n.aWG();
      Object localObject2 = n.jqt;
      localObject2 = ((Iterable)((f)localObject1).getValue()).iterator();
      n localn;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = ((Iterator)localObject2).next();
        localn = (n)localObject1;
      } while (!d.n.n.I(paramArrayOfString[1], localn.aWz(), false));
      for (;;)
      {
        localObject1 = (n)localObject1;
        if (localObject1 != null) {
          break;
        }
        Toast.makeText(aj.getContext(), (CharSequence)("Unknown config name " + paramArrayOfString[1]), 0).show();
        AppMethodBeat.o(50391);
        return;
        localObject1 = null;
      }
      ((n)localObject1).S(paramContext, paramArrayOfString[2]);
      AppMethodBeat.o(50391);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<List<n<?>>>
  {
    public static final b jqu;
    
    static
    {
      AppMethodBeat.i(50389);
      jqu = new b();
      AppMethodBeat.o(50389);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    public static final c jqv;
    
    static
    {
      AppMethodBeat.i(50394);
      jqv = new c();
      AppMethodBeat.o(50394);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(50393);
      paramDialogInterface = com.tencent.mm.plugin.appbrand.game.h.a.jtS;
      com.tencent.mm.plugin.appbrand.game.h.a.aXd();
      com.tencent.mm.plugin.appbrand.game.h.a.suicide();
      AppMethodBeat.o(50393);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.n
 * JD-Core Version:    0.7.0.1
 */