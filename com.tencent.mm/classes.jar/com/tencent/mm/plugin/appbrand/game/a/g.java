package com.tencent.mm.plugin.appbrand.game.a;

import a.aa;
import a.f;
import a.f.b.j;
import a.l;
import a.l.m;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "T", "", "()V", "mConfigMemory", "Ljava/lang/Object;", "askRestart", "", "context", "Landroid/content/Context;", "message", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "", "enableKv", "getConfig", "()Ljava/lang/Object;", "getConfigDefaultValue", "getConfigImpl", "getConfigLocalStorage", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Object;", "onProcessConfigBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", "onProcessConfigFloat", "", "(Ljava/lang/String;)Ljava/lang/Float;", "onProcessConfigInt", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "onProcessConfigLong", "", "(Ljava/lang/String;)Ljava/lang/Long;", "processCommand", "value", "removeConfigLocalStorage", "setConfigLocalStorage", "(Ljava/lang/Object;)V", "Companion", "plugin-appbrand-integration_release"})
public abstract class g<T>
{
  private static final f hsv = a.g.j((a.f.a.a)g.b.hsx);
  public static final g.a hsw = new g.a((byte)0);
  private T hsu;
  
  protected static Boolean Bu(String paramString)
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
    paramString = m.azu(paramString);
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
  
  private static void W(Context paramContext, String paramString)
  {
    new AlertDialog.Builder(paramContext).setTitle((CharSequence)"").setMessage((CharSequence)paramString).setNegativeButton((CharSequence)"cancel", null).setPositiveButton((CharSequence)"restart", (DialogInterface.OnClickListener)g.c.hsy).show();
  }
  
  public static final void a(Context paramContext, String[] paramArrayOfString)
  {
    g.a.a(paramContext, paramArrayOfString);
  }
  
  protected abstract T Bs(String paramString);
  
  public T Uw()
  {
    Object localObject = this.hsu;
    if (localObject != null) {
      return localObject;
    }
    if (aAs() != null)
    {
      localObject = as.apq("WAGameDynamicConfig").decodeString("WAGameDynamicConfig" + aAs(), null);
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null) {
          break label80;
        }
        ab.i("WAGameDynamicConfig", "hit localstorage");
      }
    }
    for (;;)
    {
      this.hsu = localObject;
      return localObject;
      localObject = Bs((String)localObject);
      break;
      label80:
      if (aAt() != null)
      {
        localObject = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(aAt(), "");
        if (localObject != null)
        {
          localObject = Bs((String)localObject);
          if (localObject != null)
          {
            ab.i("WAGameDynamicConfig", "hit ABTest");
            continue;
          }
        }
      }
      localObject = aAv();
    }
  }
  
  public final void V(Context paramContext, String paramString)
  {
    int k = 1;
    int j = 1;
    j.q(paramContext, "context");
    if (aAs() != null) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    Object localObject = Bs(paramString);
    if (localObject == null)
    {
      if (aAs() != null) {}
      for (i = 1; (aa.BMh) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      paramString = as.apq("WAGameDynamicConfig");
      paramString.remove("WAGameDynamicConfig" + aAs());
      paramString.commit();
      if (!paramString.containsKey("WAGameDynamicConfig" + aAs())) {}
      for (i = j; (aa.BMh) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      ab.i("WAGameDynamicConfig", "dl: remove localstorage config");
      if (aAu()) {
        W(paramContext, "config[" + aAs() + "] removed");
      }
    }
    do
    {
      return;
      if (aAs() != null) {}
      for (i = k; (aa.BMh) && (i == 0); i = 0) {
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      as localas = as.apq("WAGameDynamicConfig");
      localas.encode("WAGameDynamicConfig" + aAs(), String.valueOf(localObject));
      localas.commit();
      ab.i("WAGameDynamicConfig", "dl: set localstorage config ".concat(String.valueOf(paramString)));
    } while (!aAu());
    W(paramContext, "config[" + aAs() + "] set to " + localObject);
  }
  
  protected String aAs()
  {
    return null;
  }
  
  protected a.a aAt()
  {
    return null;
  }
  
  protected boolean aAu()
  {
    return true;
  }
  
  public abstract T aAv();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.g
 * JD-Core Version:    0.7.0.1
 */