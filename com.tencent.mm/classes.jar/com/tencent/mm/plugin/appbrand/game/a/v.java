package com.tencent.mm.plugin.appbrand.game.a;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Iterator;
import java.util.List;
import kotlin.aa;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "", "()V", "mConfigMemory", "Ljava/lang/Object;", "askRestart", "", "context", "Landroid/content/Context;", "message", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "", "enableKv", "getConfig", "()Ljava/lang/Object;", "getConfigDefaultValue", "getConfigImpl", "getConfigLocalStorage", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Object;", "onProcessConfigBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", "onProcessConfigFloat", "", "(Ljava/lang/String;)Ljava/lang/Float;", "onProcessConfigInt", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "onProcessConfigLong", "", "(Ljava/lang/String;)Ljava/lang/Long;", "processCommand", "value", "removeConfigLocalStorage", "setConfigLocalStorage", "(Ljava/lang/Object;)V", "Companion", "plugin-appbrand-integration_release"})
public abstract class v<T>
{
  private static final f lrX = kotlin.g.ah((kotlin.g.a.a)b.lrZ);
  public static final a lrY = new a((byte)0);
  private T lrW;
  
  protected static Boolean YJ(String paramString)
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
    paramString = n.buA(paramString);
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
  
  public static final void a(Context paramContext, String[] paramArrayOfString)
  {
    a.a(paramContext, paramArrayOfString);
  }
  
  private static void ac(Context paramContext, String paramString)
  {
    new AlertDialog.Builder(paramContext).setTitle((CharSequence)"").setMessage((CharSequence)paramString).setNegativeButton((CharSequence)"cancel", null).setPositiveButton((CharSequence)"restart", (DialogInterface.OnClickListener)c.lsa).show();
  }
  
  protected abstract T YH(String paramString);
  
  public T aLT()
  {
    Object localObject = this.lrW;
    if (localObject != null) {
      return localObject;
    }
    if (bCY() != null)
    {
      localObject = MultiProcessMMKV.getMMKV("WAGameDynamicConfig").decodeString("WAGameDynamicConfig" + bCY(), null);
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null) {
          break label80;
        }
        Log.i("WAGameDynamicConfig", "hit localstorage");
      }
    }
    for (;;)
    {
      this.lrW = localObject;
      return localObject;
      localObject = YH((String)localObject);
      break;
      label80:
      if (bCZ() != null)
      {
        localObject = ((b)com.tencent.mm.kernel.g.af(b.class)).a(bCZ(), "");
        if (localObject != null)
        {
          localObject = YH((String)localObject);
          if (localObject != null)
          {
            Log.i("WAGameDynamicConfig", "hit ABTest");
            continue;
          }
        }
      }
      localObject = bDb();
    }
  }
  
  public final void ab(Context paramContext, String paramString)
  {
    int k = 1;
    int j = 1;
    p.h(paramContext, "context");
    if (bCY() != null) {}
    for (int i = 1; (aa.SXc) && (i == 0); i = 0) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    Object localObject = YH(paramString);
    if (localObject == null)
    {
      if (bCY() != null) {}
      for (i = 1; (aa.SXc) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      paramString = MultiProcessMMKV.getMMKV("WAGameDynamicConfig");
      paramString.remove("WAGameDynamicConfig" + bCY());
      paramString.commit();
      if (!paramString.containsKey("WAGameDynamicConfig" + bCY())) {}
      for (i = j; (aa.SXc) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      Log.i("WAGameDynamicConfig", "dl: remove localstorage config");
      if (bDa()) {
        ac(paramContext, "config[" + bCY() + "] removed");
      }
    }
    do
    {
      return;
      if (bCY() != null) {}
      for (i = k; (aa.SXc) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("WAGameDynamicConfig");
      localMultiProcessMMKV.encode("WAGameDynamicConfig" + bCY(), String.valueOf(localObject));
      localMultiProcessMMKV.commit();
      Log.i("WAGameDynamicConfig", "dl: set localstorage config ".concat(String.valueOf(paramString)));
    } while (!bDa());
    ac(paramContext, "config[" + bCY() + "] set to " + localObject);
  }
  
  protected String bCY()
  {
    return null;
  }
  
  protected b.a bCZ()
  {
    return null;
  }
  
  protected boolean bDa()
  {
    return true;
  }
  
  public abstract T bDb();
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig$Companion;", "", "()V", "TAG", "", "mCommandProcessor", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "getMCommandProcessor", "()Ljava/util/List;", "mCommandProcessor$delegate", "Lkotlin/Lazy;", "checkNotDuplicate", "", "registry", "processCommand", "context", "Landroid/content/Context;", "args", "", "(Landroid/content/Context;[Ljava/lang/String;)V", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static void a(Context paramContext, String[] paramArrayOfString)
    {
      AppMethodBeat.i(50391);
      p.h(paramContext, "context");
      p.h(paramArrayOfString, "args");
      if (paramArrayOfString.length >= 3) {}
      for (int i = 1; (aa.SXc) && (i == 0); i = 0)
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      if ((paramArrayOfString[1] != null) && (paramArrayOfString[0] != null)) {}
      for (i = 1; (aa.SXc) && (i == 0); i = 0)
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      boolean bool = n.I("//wagame", paramArrayOfString[0], true);
      if ((aa.SXc) && (!bool))
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50391);
        throw paramContext;
      }
      Object localObject1 = v.bDf();
      Object localObject2 = v.lrY;
      localObject2 = ((Iterable)((f)localObject1).getValue()).iterator();
      v localv;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = ((Iterator)localObject2).next();
        localv = (v)localObject1;
      } while (!n.I(paramArrayOfString[1], localv.bCY(), false));
      for (;;)
      {
        localObject1 = (v)localObject1;
        if (localObject1 != null) {
          break;
        }
        Toast.makeText(MMApplicationContext.getContext(), (CharSequence)("Unknown config name " + paramArrayOfString[1]), 0).show();
        AppMethodBeat.o(50391);
        return;
        localObject1 = null;
      }
      ((v)localObject1).ab(paramContext, paramArrayOfString[2]);
      AppMethodBeat.o(50391);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<List<v<?>>>
  {
    public static final b lrZ;
    
    static
    {
      AppMethodBeat.i(50389);
      lrZ = new b();
      AppMethodBeat.o(50389);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    public static final c lsa;
    
    static
    {
      AppMethodBeat.i(50394);
      lsa = new c();
      AppMethodBeat.o(50394);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(50393);
      paramDialogInterface = com.tencent.mm.plugin.appbrand.game.h.a.lvA;
      com.tencent.mm.plugin.appbrand.game.h.a.bDC();
      com.tencent.mm.plugin.appbrand.game.h.a.suicide();
      AppMethodBeat.o(50393);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.v
 * JD-Core Version:    0.7.0.1
 */