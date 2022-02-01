package com.tencent.mm.plugin.appbrand.game.a;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import d.aa;
import d.f;
import d.g.b.u;
import d.g.b.w;
import d.n.n;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "", "()V", "mConfigMemory", "Ljava/lang/Object;", "askRestart", "", "context", "Landroid/content/Context;", "message", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "", "enableKv", "getConfig", "()Ljava/lang/Object;", "getConfigDefaultValue", "getConfigImpl", "getConfigLocalStorage", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Object;", "onProcessConfigBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", "onProcessConfigFloat", "", "(Ljava/lang/String;)Ljava/lang/Float;", "onProcessConfigInt", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "onProcessConfigLong", "", "(Ljava/lang/String;)Ljava/lang/Long;", "processCommand", "value", "removeConfigLocalStorage", "setConfigLocalStorage", "(Ljava/lang/Object;)V", "Companion", "plugin-appbrand-integration_release"})
public abstract class q<T>
{
  private static final f jQK = d.g.K((d.g.a.a)b.jQM);
  public static final a jQL = new a((byte)0);
  private T jQJ;
  
  protected static Boolean Lw(String paramString)
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
    paramString = n.aXe(paramString);
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
  
  private static void U(Context paramContext, String paramString)
  {
    new AlertDialog.Builder(paramContext).setTitle((CharSequence)"").setMessage((CharSequence)paramString).setNegativeButton((CharSequence)"cancel", null).setPositiveButton((CharSequence)"restart", (DialogInterface.OnClickListener)c.jQN).show();
  }
  
  public static final void a(Context paramContext, String[] paramArrayOfString)
  {
    a.a(paramContext, paramArrayOfString);
  }
  
  protected abstract T Lu(String paramString);
  
  public final void T(Context paramContext, String paramString)
  {
    int k = 1;
    int j = 1;
    d.g.b.k.h(paramContext, "context");
    if (bdx() != null) {}
    for (int i = 1; (aa.KTq) && (i == 0); i = 0) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    Object localObject = Lu(paramString);
    if (localObject == null)
    {
      if (bdx() != null) {}
      for (i = 1; (aa.KTq) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      paramString = aw.aKT("WAGameDynamicConfig");
      paramString.remove("WAGameDynamicConfig" + bdx());
      paramString.commit();
      if (!paramString.containsKey("WAGameDynamicConfig" + bdx())) {}
      for (i = j; (aa.KTq) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      ac.i("WAGameDynamicConfig", "dl: remove localstorage config");
      if (bdz()) {
        U(paramContext, "config[" + bdx() + "] removed");
      }
    }
    do
    {
      return;
      if (bdx() != null) {}
      for (i = k; (aa.KTq) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      aw localaw = aw.aKT("WAGameDynamicConfig");
      localaw.encode("WAGameDynamicConfig" + bdx(), String.valueOf(localObject));
      localaw.commit();
      ac.i("WAGameDynamicConfig", "dl: set localstorage config ".concat(String.valueOf(paramString)));
    } while (!bdz());
    U(paramContext, "config[" + bdx() + "] set to " + localObject);
  }
  
  public T aqp()
  {
    Object localObject = this.jQJ;
    if (localObject != null) {
      return localObject;
    }
    if (bdx() != null)
    {
      localObject = aw.aKT("WAGameDynamicConfig").decodeString("WAGameDynamicConfig" + bdx(), null);
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null) {
          break label81;
        }
        ac.i("WAGameDynamicConfig", "hit localstorage");
      }
    }
    for (;;)
    {
      this.jQJ = localObject;
      return localObject;
      localObject = Lu((String)localObject);
      break;
      label81:
      if (bdy() != null)
      {
        localObject = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(bdy(), "");
        if (localObject != null)
        {
          localObject = Lu((String)localObject);
          if (localObject != null)
          {
            ac.i("WAGameDynamicConfig", "hit ABTest");
            continue;
          }
        }
      }
      localObject = bdA();
    }
  }
  
  public abstract T bdA();
  
  protected String bdx()
  {
    return null;
  }
  
  protected b.a bdy()
  {
    return null;
  }
  
  protected boolean bdz()
  {
    return true;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig$Companion;", "", "()V", "TAG", "", "mCommandProcessor", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "getMCommandProcessor", "()Ljava/util/List;", "mCommandProcessor$delegate", "Lkotlin/Lazy;", "checkNotDuplicate", "", "registry", "processCommand", "context", "Landroid/content/Context;", "args", "", "(Landroid/content/Context;[Ljava/lang/String;)V", "plugin-appbrand-integration_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(50390);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(a.class), "mCommandProcessor", "getMCommandProcessor()Ljava/util/List;")) };
      AppMethodBeat.o(50390);
    }
    
    public static void a(Context paramContext, String[] paramArrayOfString)
    {
      AppMethodBeat.i(50391);
      d.g.b.k.h(paramContext, "context");
      d.g.b.k.h(paramArrayOfString, "args");
      if (paramArrayOfString.length >= 3) {}
      for (int i = 1; (aa.KTq) && (i == 0); i = 0)
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      if ((paramArrayOfString[1] != null) && (paramArrayOfString[0] != null)) {}
      for (i = 1; (aa.KTq) && (i == 0); i = 0)
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      boolean bool = n.I("//wagame", paramArrayOfString[0], true);
      if ((aa.KTq) && (!bool))
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      Object localObject1 = q.bdE();
      Object localObject2 = q.jQL;
      localObject2 = ((Iterable)((f)localObject1).getValue()).iterator();
      q localq;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = ((Iterator)localObject2).next();
        localq = (q)localObject1;
      } while (!n.I(paramArrayOfString[1], localq.bdx(), false));
      for (;;)
      {
        localObject1 = (q)localObject1;
        if (localObject1 != null) {
          break;
        }
        Toast.makeText(ai.getContext(), (CharSequence)("Unknown config name " + paramArrayOfString[1]), 0).show();
        AppMethodBeat.o(50391);
        return;
        localObject1 = null;
      }
      ((q)localObject1).T(paramContext, paramArrayOfString[2]);
      AppMethodBeat.o(50391);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<List<q<?>>>
  {
    public static final b jQM;
    
    static
    {
      AppMethodBeat.i(50389);
      jQM = new b();
      AppMethodBeat.o(50389);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    public static final c jQN;
    
    static
    {
      AppMethodBeat.i(50394);
      jQN = new c();
      AppMethodBeat.o(50394);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(50393);
      paramDialogInterface = com.tencent.mm.plugin.appbrand.game.h.a.jUn;
      com.tencent.mm.plugin.appbrand.game.h.a.beb();
      com.tencent.mm.plugin.appbrand.game.h.a.suicide();
      AppMethodBeat.o(50393);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.q
 * JD-Core Version:    0.7.0.1
 */