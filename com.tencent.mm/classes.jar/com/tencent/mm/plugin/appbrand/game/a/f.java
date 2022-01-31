package com.tencent.mm.plugin.appbrand.game.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigWxbct;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "TAG", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "enableKv", "getActuallyConfig", "getConfig", "()Ljava/lang/Boolean;", "getConfigDefaultValue", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "plugin-appbrand-integration_release"})
public final class f
  extends g<Boolean>
{
  public static final f hst;
  
  static
  {
    AppMethodBeat.i(134628);
    hst = new f();
    AppMethodBeat.o(134628);
  }
  
  public static final boolean aAy()
  {
    AppMethodBeat.i(134627);
    if (!((Boolean)hst.Uw()).booleanValue())
    {
      ab.i("WAGameConfigWxbct", "getActuallyConfig self == false");
      AppMethodBeat.o(134627);
      return false;
    }
    int i = ((Number)a.a(a.a.lUW, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      ab.i("WAGameConfigWxbct", "getActuallyConfig gcfactor == 0");
      AppMethodBeat.o(134627);
      return false;
    }
    ab.i("WAGameConfigWxbct", "getActuallyConfig gcfactor != 0 [" + i + "], enable wxbct");
    AppMethodBeat.o(134627);
    return true;
  }
  
  protected final String aAs()
  {
    return "wxbct";
  }
  
  protected final a.a aAt()
  {
    return a.a.lVa;
  }
  
  protected final boolean aAu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.f
 * JD-Core Version:    0.7.0.1
 */