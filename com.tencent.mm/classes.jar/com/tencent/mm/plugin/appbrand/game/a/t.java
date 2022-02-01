package com.tencent.mm.plugin.appbrand.game.a;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import d.ac;
import d.f;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "", "()V", "mConfigMemory", "Ljava/lang/Object;", "askRestart", "", "context", "Landroid/content/Context;", "message", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "", "enableKv", "getConfig", "()Ljava/lang/Object;", "getConfigDefaultValue", "getConfigImpl", "getConfigLocalStorage", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Object;", "onProcessConfigBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", "onProcessConfigFloat", "", "(Ljava/lang/String;)Ljava/lang/Float;", "onProcessConfigInt", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "onProcessConfigLong", "", "(Ljava/lang/String;)Ljava/lang/Long;", "processCommand", "value", "removeConfigLocalStorage", "setConfigLocalStorage", "(Ljava/lang/Object;)V", "Companion", "plugin-appbrand-integration_release"})
public abstract class t<T>
{
  private static final f kop = d.g.O((a)b.kor);
  public static final a koq = new a((byte)0);
  private T koo;
  
  protected static Boolean Py(String paramString)
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
    paramString = n.beL(paramString);
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
    new AlertDialog.Builder(paramContext).setTitle((CharSequence)"").setMessage((CharSequence)paramString).setNegativeButton((CharSequence)"cancel", null).setPositiveButton((CharSequence)"restart", (DialogInterface.OnClickListener)t.c.kos).show();
  }
  
  public static final void a(Context paramContext, String[] paramArrayOfString)
  {
    a.a(paramContext, paramArrayOfString);
  }
  
  protected abstract T Pw(String paramString);
  
  public final void T(Context paramContext, String paramString)
  {
    int k = 1;
    int j = 1;
    p.h(paramContext, "context");
    if (bhJ() != null) {}
    for (int i = 1; (ac.Nhs) && (i == 0); i = 0) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    Object localObject = Pw(paramString);
    if (localObject == null)
    {
      if (bhJ() != null) {}
      for (i = 1; (ac.Nhs) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      paramString = ay.aRW("WAGameDynamicConfig");
      paramString.remove("WAGameDynamicConfig" + bhJ());
      paramString.commit();
      if (!paramString.containsKey("WAGameDynamicConfig" + bhJ())) {}
      for (i = j; (ac.Nhs) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      ae.i("WAGameDynamicConfig", "dl: remove localstorage config");
      if (bhL()) {
        U(paramContext, "config[" + bhJ() + "] removed");
      }
    }
    do
    {
      return;
      if (bhJ() != null) {}
      for (i = k; (ac.Nhs) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      ay localay = ay.aRW("WAGameDynamicConfig");
      localay.encode("WAGameDynamicConfig" + bhJ(), String.valueOf(localObject));
      localay.commit();
      ae.i("WAGameDynamicConfig", "dl: set localstorage config ".concat(String.valueOf(paramString)));
    } while (!bhL());
    U(paramContext, "config[" + bhJ() + "] set to " + localObject);
  }
  
  public T att()
  {
    Object localObject = this.koo;
    if (localObject != null) {
      return localObject;
    }
    if (bhJ() != null)
    {
      localObject = ay.aRW("WAGameDynamicConfig").decodeString("WAGameDynamicConfig" + bhJ(), null);
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null) {
          break label81;
        }
        ae.i("WAGameDynamicConfig", "hit localstorage");
      }
    }
    for (;;)
    {
      this.koo = localObject;
      return localObject;
      localObject = Pw((String)localObject);
      break;
      label81:
      if (bhK() != null)
      {
        localObject = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(bhK(), "");
        if (localObject != null)
        {
          localObject = Pw((String)localObject);
          if (localObject != null)
          {
            ae.i("WAGameDynamicConfig", "hit ABTest");
            continue;
          }
        }
      }
      localObject = bhM();
    }
  }
  
  protected String bhJ()
  {
    return null;
  }
  
  protected b.a bhK()
  {
    return null;
  }
  
  protected boolean bhL()
  {
    return true;
  }
  
  public abstract T bhM();
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig$Companion;", "", "()V", "TAG", "", "mCommandProcessor", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "getMCommandProcessor", "()Ljava/util/List;", "mCommandProcessor$delegate", "Lkotlin/Lazy;", "checkNotDuplicate", "", "registry", "processCommand", "context", "Landroid/content/Context;", "args", "", "(Landroid/content/Context;[Ljava/lang/String;)V", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static void a(Context paramContext, String[] paramArrayOfString)
    {
      AppMethodBeat.i(50391);
      p.h(paramContext, "context");
      p.h(paramArrayOfString, "args");
      if (paramArrayOfString.length >= 3) {}
      for (int i = 1; (ac.Nhs) && (i == 0); i = 0)
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      if ((paramArrayOfString[1] != null) && (paramArrayOfString[0] != null)) {}
      for (i = 1; (ac.Nhs) && (i == 0); i = 0)
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      boolean bool = n.H("//wagame", paramArrayOfString[0], true);
      if ((ac.Nhs) && (!bool))
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      Object localObject1 = t.bhQ();
      Object localObject2 = t.koq;
      localObject2 = ((Iterable)((f)localObject1).getValue()).iterator();
      t localt;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = ((Iterator)localObject2).next();
        localt = (t)localObject1;
      } while (!n.H(paramArrayOfString[1], localt.bhJ(), false));
      for (;;)
      {
        localObject1 = (t)localObject1;
        if (localObject1 != null) {
          break;
        }
        Toast.makeText(ak.getContext(), (CharSequence)("Unknown config name " + paramArrayOfString[1]), 0).show();
        AppMethodBeat.o(50391);
        return;
        localObject1 = null;
      }
      ((t)localObject1).T(paramContext, paramArrayOfString[2]);
      AppMethodBeat.o(50391);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "invoke"})
  static final class b
    extends q
    implements a<List<t<?>>>
  {
    public static final b kor;
    
    static
    {
      AppMethodBeat.i(50389);
      kor = new b();
      AppMethodBeat.o(50389);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.t
 * JD-Core Version:    0.7.0.1
 */