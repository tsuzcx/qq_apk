package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigWxbct;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "TAG", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "enableKv", "getActuallyConfig", "getConfig", "()Ljava/lang/Boolean;", "getConfigDefaultValue", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "plugin-appbrand-integration_release"})
public final class s
  extends t<Boolean>
{
  public static final s kon;
  
  static
  {
    AppMethodBeat.i(50387);
    kon = new s();
    AppMethodBeat.o(50387);
  }
  
  public static final boolean bhP()
  {
    AppMethodBeat.i(50386);
    if (!((Boolean)kon.att()).booleanValue())
    {
      ae.i("WAGameConfigWxbct", "getActuallyConfig self == false");
      AppMethodBeat.o(50386);
      return false;
    }
    int i = ((Number)a.a(b.a.qDb, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      ae.i("WAGameConfigWxbct", "getActuallyConfig gcfactor == 0");
      AppMethodBeat.o(50386);
      return false;
    }
    ae.i("WAGameConfigWxbct", "getActuallyConfig gcfactor != 0 [" + i + "], enable wxbct");
    AppMethodBeat.o(50386);
    return true;
  }
  
  protected final String bhJ()
  {
    return "wxbct";
  }
  
  protected final b.a bhK()
  {
    return b.a.qDf;
  }
  
  protected final boolean bhL()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.s
 * JD-Core Version:    0.7.0.1
 */