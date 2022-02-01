package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigWxbct;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "TAG", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "enableKv", "getActuallyConfig", "getConfig", "()Ljava/lang/Boolean;", "getConfigDefaultValue", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "plugin-appbrand-integration_release"})
public final class u
  extends v<Boolean>
{
  public static final u lrV;
  
  static
  {
    AppMethodBeat.i(50387);
    lrV = new u();
    AppMethodBeat.o(50387);
  }
  
  public static final boolean bDe()
  {
    AppMethodBeat.i(50386);
    if (!((Boolean)lrV.aLT()).booleanValue())
    {
      Log.i("WAGameConfigWxbct", "getActuallyConfig self == false");
      AppMethodBeat.o(50386);
      return false;
    }
    int i = ((Number)a.a(b.a.rVU, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      Log.i("WAGameConfigWxbct", "getActuallyConfig gcfactor == 0");
      AppMethodBeat.o(50386);
      return false;
    }
    Log.i("WAGameConfigWxbct", "getActuallyConfig gcfactor != 0 [" + i + "], enable wxbct");
    AppMethodBeat.o(50386);
    return true;
  }
  
  protected final String bCY()
  {
    return "wxbct";
  }
  
  protected final b.a bCZ()
  {
    return b.a.rVY;
  }
  
  protected final boolean bDa()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.u
 * JD-Core Version:    0.7.0.1
 */