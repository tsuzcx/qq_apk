package com.tencent.mm.plugin.appbrand.game.a;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.z;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "", "()V", "mConfigMemory", "Ljava/lang/Object;", "askRestart", "", "context", "Landroid/content/Context;", "message", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "", "enableKv", "getConfig", "()Ljava/lang/Object;", "getConfigDefaultValue", "getConfigImpl", "getConfigLocalStorage", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Object;", "onProcessConfigBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", "onProcessConfigFloat", "", "(Ljava/lang/String;)Ljava/lang/Float;", "onProcessConfigInt", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "onProcessConfigLong", "", "(Ljava/lang/String;)Ljava/lang/Long;", "processCommand", "value", "removeConfigLocalStorage", "setConfigLocalStorage", "(Ljava/lang/Object;)V", "Companion", "plugin-appbrand-integration_release"})
public abstract class x<T>
{
  private static final f omU = g.ar((kotlin.g.a.a)b.omW);
  public static final a omV = new a((byte)0);
  private T omT;
  
  public static final void a(Context paramContext, String[] paramArrayOfString)
  {
    a.a(paramContext, paramArrayOfString);
  }
  
  private static void aa(Context paramContext, String paramString)
  {
    new AlertDialog.Builder(paramContext).setTitle((CharSequence)"").setMessage((CharSequence)paramString).setNegativeButton((CharSequence)"cancel", null).setPositiveButton((CharSequence)"restart", (DialogInterface.OnClickListener)c.omX).show();
  }
  
  protected static Boolean agx(String paramString)
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
    paramString = n.bHC(paramString);
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
  
  public final void Z(Context paramContext, String paramString)
  {
    int k = 1;
    int j = 1;
    p.k(paramContext, "context");
    if (bOt() != null) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    Object localObject = agv(paramString);
    if (localObject == null)
    {
      if (bOt() != null) {}
      for (i = 1; (z.aazO) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      paramString = MultiProcessMMKV.getMMKV("WAGameDynamicConfig");
      paramString.remove("WAGameDynamicConfig" + bOt());
      paramString.commit();
      if (!paramString.containsKey("WAGameDynamicConfig" + bOt())) {}
      for (i = j; (z.aazO) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      Log.i("WAGameDynamicConfig", "dl: remove localstorage config");
      if (bOv()) {
        aa(paramContext, "config[" + bOt() + "] removed");
      }
    }
    do
    {
      return;
      if (bOt() != null) {}
      for (i = k; (z.aazO) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("WAGameDynamicConfig");
      localMultiProcessMMKV.encode("WAGameDynamicConfig" + bOt(), String.valueOf(localObject));
      localMultiProcessMMKV.commit();
      Log.i("WAGameDynamicConfig", "dl: set localstorage config ".concat(String.valueOf(paramString)));
    } while (!bOv());
    aa(paramContext, "config[" + bOt() + "] set to " + localObject);
  }
  
  public T aUb()
  {
    Object localObject = this.omT;
    if (localObject != null) {
      return localObject;
    }
    if (bOt() != null)
    {
      localObject = MultiProcessMMKV.getMMKV("WAGameDynamicConfig").decodeString("WAGameDynamicConfig" + bOt(), null);
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null) {
          break label81;
        }
        Log.i("WAGameDynamicConfig", "hit localstorage");
      }
    }
    for (;;)
    {
      this.omT = localObject;
      return localObject;
      localObject = agv((String)localObject);
      break;
      label81:
      if (bOu() != null)
      {
        localObject = ((b)h.ae(b.class)).a(bOu(), "");
        if (localObject != null)
        {
          localObject = agv((String)localObject);
          if (localObject != null)
          {
            Log.i("WAGameDynamicConfig", "hit ABTest");
            continue;
          }
        }
      }
      localObject = bOw();
    }
  }
  
  protected abstract T agv(String paramString);
  
  protected String bOt()
  {
    return null;
  }
  
  protected b.a bOu()
  {
    return null;
  }
  
  protected boolean bOv()
  {
    return true;
  }
  
  public abstract T bOw();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig$Companion;", "", "()V", "TAG", "", "mCommandProcessor", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "getMCommandProcessor", "()Ljava/util/List;", "mCommandProcessor$delegate", "Lkotlin/Lazy;", "checkNotDuplicate", "", "registry", "processCommand", "context", "Landroid/content/Context;", "args", "", "(Landroid/content/Context;[Ljava/lang/String;)V", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static void a(Context paramContext, String[] paramArrayOfString)
    {
      AppMethodBeat.i(50391);
      p.k(paramContext, "context");
      p.k(paramArrayOfString, "args");
      if (paramArrayOfString.length >= 3) {}
      for (int i = 1; (z.aazO) && (i == 0); i = 0)
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      if ((paramArrayOfString[1] != null) && (paramArrayOfString[0] != null)) {}
      for (i = 1; (z.aazO) && (i == 0); i = 0)
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      boolean bool = n.L("//wagame", paramArrayOfString[0], true);
      if ((z.aazO) && (!bool))
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      Object localObject1 = x.bOB();
      Object localObject2 = x.omV;
      localObject2 = ((Iterable)((f)localObject1).getValue()).iterator();
      x localx;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = ((Iterator)localObject2).next();
        localx = (x)localObject1;
      } while (!n.L(paramArrayOfString[1], localx.bOt(), false));
      for (;;)
      {
        localObject1 = (x)localObject1;
        if (localObject1 != null) {
          break;
        }
        Toast.makeText(MMApplicationContext.getContext(), (CharSequence)("Unknown config name " + paramArrayOfString[1]), 0).show();
        AppMethodBeat.o(50391);
        return;
        localObject1 = null;
      }
      ((x)localObject1).Z(paramContext, paramArrayOfString[2]);
      AppMethodBeat.o(50391);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<List<x<?>>>
  {
    public static final b omW;
    
    static
    {
      AppMethodBeat.i(50389);
      omW = new b();
      AppMethodBeat.o(50389);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    public static final c omX;
    
    static
    {
      AppMethodBeat.i(50394);
      omX = new c();
      AppMethodBeat.o(50394);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(50393);
      paramDialogInterface = com.tencent.mm.plugin.appbrand.game.h.a.oqw;
      com.tencent.mm.plugin.appbrand.game.h.a.bPa();
      com.tencent.mm.plugin.appbrand.game.h.a.suicide();
      AppMethodBeat.o(50393);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.x
 * JD-Core Version:    0.7.0.1
 */