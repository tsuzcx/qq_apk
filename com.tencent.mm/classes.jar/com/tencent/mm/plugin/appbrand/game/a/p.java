package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigWxbct;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "TAG", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "enableKv", "getActuallyConfig", "getConfig", "()Ljava/lang/Boolean;", "getConfigDefaultValue", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "plugin-appbrand-integration_release"})
public final class p
  extends q<Boolean>
{
  public static final p jQI;
  
  static
  {
    AppMethodBeat.i(50387);
    jQI = new p();
    AppMethodBeat.o(50387);
  }
  
  public static final boolean bdD()
  {
    AppMethodBeat.i(50386);
    if (!((Boolean)jQI.aqp()).booleanValue())
    {
      ac.i("WAGameConfigWxbct", "getActuallyConfig self == false");
      AppMethodBeat.o(50386);
      return false;
    }
    int i = ((Number)a.a(b.a.pRF, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      ac.i("WAGameConfigWxbct", "getActuallyConfig gcfactor == 0");
      AppMethodBeat.o(50386);
      return false;
    }
    ac.i("WAGameConfigWxbct", "getActuallyConfig gcfactor != 0 [" + i + "], enable wxbct");
    AppMethodBeat.o(50386);
    return true;
  }
  
  protected final String bdx()
  {
    return "wxbct";
  }
  
  protected final b.a bdy()
  {
    return b.a.pRJ;
  }
  
  protected final boolean bdz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.p
 * JD-Core Version:    0.7.0.1
 */