package com.tencent.mm.plugin.appbrand.game.a;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.List;
import kotlin.Metadata;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "", "()V", "mConfigMemory", "Ljava/lang/Object;", "askRestart", "", "context", "Landroid/content/Context;", "message", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "", "enableKv", "getConfig", "()Ljava/lang/Object;", "getConfigDefaultValue", "getConfigImpl", "getConfigLocalStorage", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Object;", "onProcessConfigBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", "onProcessConfigFloat", "", "(Ljava/lang/String;)Ljava/lang/Float;", "onProcessConfigInt", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "onProcessConfigLong", "", "(Ljava/lang/String;)Ljava/lang/Long;", "processCommand", "value", "removeConfigLocalStorage", "setConfigLocalStorage", "(Ljava/lang/Object;)V", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class z<T>
{
  public static final z.a rqE = new z.a((byte)0);
  private static final j<List<z<?>>> rqG = k.cm((kotlin.g.a.a)b.rqH);
  private T rqF;
  
  protected static Boolean Zs(String paramString)
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
    paramString = n.bJF(paramString);
    if (paramString != null)
    {
      if (paramString.intValue() > 0) {
        return Boolean.TRUE;
      }
      if ((paramString.intValue() == 0) || (paramString.intValue() == -1)) {
        return Boolean.FALSE;
      }
      throw new IllegalStateException("Ambiguity name");
    }
    return null;
  }
  
  protected static Integer Zt(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return n.bJF(paramString);
  }
  
  public static final void a(Context paramContext, String[] paramArrayOfString)
  {
    z.a.a(paramContext, paramArrayOfString);
  }
  
  private static void aa(Context paramContext, String paramString)
  {
    new AlertDialog.Builder(paramContext).setTitle((CharSequence)"").setMessage((CharSequence)paramString).setNegativeButton((CharSequence)"cancel", null).setPositiveButton((CharSequence)"restart", z..ExternalSyntheticLambda0.INSTANCE).show();
  }
  
  private static final void d(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = com.tencent.mm.plugin.appbrand.game.h.a.rug;
    com.tencent.mm.plugin.appbrand.game.h.a.cpp();
    com.tencent.mm.plugin.appbrand.game.h.a.suicide();
  }
  
  public final void Z(Context paramContext, String paramString)
  {
    int k = 1;
    int j = 1;
    s.u(paramContext, "context");
    if (coJ() != null) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    Object localObject = Zq(paramString);
    if (localObject == null)
    {
      if (coJ() != null) {}
      for (i = 1; (ak.aiuY) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      paramString = MultiProcessMMKV.getMMKV("WAGameDynamicConfig");
      paramString.remove(s.X("WAGameDynamicConfig", coJ()));
      paramString.commit();
      if (!paramString.containsKey(s.X("WAGameDynamicConfig", coJ()))) {}
      for (i = j; (ak.aiuY) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      Log.i("WAGameDynamicConfig", "dl: remove localstorage config");
      if (coL()) {
        aa(paramContext, "config[" + coJ() + "] removed");
      }
    }
    do
    {
      return;
      if (coJ() != null) {}
      for (i = k; (ak.aiuY) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("WAGameDynamicConfig");
      localMultiProcessMMKV.encode(s.X("WAGameDynamicConfig", coJ()), String.valueOf(localObject));
      localMultiProcessMMKV.commit();
      Log.i("WAGameDynamicConfig", s.X("dl: set localstorage config ", paramString));
    } while (!coL());
    aa(paramContext, "config[" + coJ() + "] set to " + localObject);
  }
  
  protected abstract T Zq(String paramString);
  
  public T boF()
  {
    Object localObject = this.rqF;
    if (localObject != null) {
      return localObject;
    }
    if (coJ() != null)
    {
      localObject = MultiProcessMMKV.getMMKV("WAGameDynamicConfig").decodeString(s.X("WAGameDynamicConfig", coJ()), null);
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null) {
          break label71;
        }
        Log.i("WAGameDynamicConfig", "hit localstorage");
      }
    }
    for (;;)
    {
      this.rqF = localObject;
      return localObject;
      localObject = Zq((String)localObject);
      break;
      label71:
      if (coK() != null)
      {
        localObject = ((c)h.ax(c.class)).a(coK(), "");
        if (localObject != null)
        {
          localObject = Zq((String)localObject);
          if (localObject != null)
          {
            Log.i("WAGameDynamicConfig", "hit ABTest");
            continue;
          }
        }
      }
      localObject = coM();
    }
  }
  
  protected String coJ()
  {
    return null;
  }
  
  protected c.a coK()
  {
    return null;
  }
  
  protected boolean coL()
  {
    return true;
  }
  
  public abstract T coM();
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<List<z<?>>>
  {
    public static final b rqH;
    
    static
    {
      AppMethodBeat.i(50389);
      rqH = new b();
      AppMethodBeat.o(50389);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.z
 * JD-Core Version:    0.7.0.1
 */