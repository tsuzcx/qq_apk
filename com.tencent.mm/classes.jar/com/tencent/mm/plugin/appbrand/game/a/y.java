package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigWxbct;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "TAG", "", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableAlert", "enableKv", "getActuallyConfig", "getConfig", "()Ljava/lang/Boolean;", "getConfigDefaultValue", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  extends z<Boolean>
{
  public static final y rqD;
  
  static
  {
    AppMethodBeat.i(50387);
    rqD = new y();
    AppMethodBeat.o(50387);
  }
  
  public static final boolean coP()
  {
    AppMethodBeat.i(50386);
    if (!((Boolean)rqD.boF()).booleanValue())
    {
      Log.i("WAGameConfigWxbct", "getActuallyConfig self == false");
      AppMethodBeat.o(50386);
      return false;
    }
    int i = ((Number)a.a(c.a.yQO, Integer.valueOf(0))).intValue();
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
  
  protected final String coJ()
  {
    return "wxbct";
  }
  
  protected final c.a coK()
  {
    return c.a.yQS;
  }
  
  protected final boolean coL()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.y
 * JD-Core Version:    0.7.0.1
 */