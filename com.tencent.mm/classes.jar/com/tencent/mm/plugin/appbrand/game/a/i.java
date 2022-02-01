package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.ac;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "kv", "", "defaultValue", "askRestart", "(Ljava/lang/String;ZZ)V", "enableAlert", "enableKv", "getConfigDefaultValue", "()Ljava/lang/Boolean;", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "Companion", "plugin-appbrand-integration_release"})
public final class i
  extends t<Boolean>
{
  private static final HashMap<String, i> kkM;
  public static final a kkN;
  final String kkJ;
  private final boolean kkK;
  private final boolean kkL;
  
  static
  {
    AppMethodBeat.i(50378);
    kkN = new a((byte)0);
    kkM = new HashMap();
    a.a(new i("localso", (byte)0));
    a.a(new i("renderprofiler", (byte)0));
    a.a(new i("debugNode", (byte)0));
    a.a(new i("tracejstask", (byte)0));
    AppMethodBeat.o(50378);
  }
  
  private i(String paramString)
  {
    AppMethodBeat.i(50377);
    this.kkJ = paramString;
    this.kkK = false;
    this.kkL = true;
    if (!n.aE((CharSequence)this.kkJ)) {}
    for (int i = 1; (ac.MKp) && (i == 0); i = 0)
    {
      paramString = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(50377);
      throw paramString;
    }
    AppMethodBeat.o(50377);
  }
  
  public static final i OP(String paramString)
  {
    AppMethodBeat.i(50379);
    p.h(paramString, "kv_name");
    paramString = kkM.get(paramString);
    if (paramString == null) {
      p.gfZ();
    }
    paramString = (i)paramString;
    AppMethodBeat.o(50379);
    return paramString;
  }
  
  protected final String bhb()
  {
    return this.kkJ;
  }
  
  protected final boolean bhd()
  {
    return this.kkL;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple$Companion;", "", "()V", "registry", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lkotlin/collections/HashMap;", "get", "kv_name", "getAll", "", "register", "", "config", "plugin-appbrand-integration_release"})
  public static final class a
  {
    static void a(i parami)
    {
      AppMethodBeat.i(50374);
      Map localMap = (Map)i.bhg();
      String str = parami.kkJ;
      if (str == null) {
        p.gfZ();
      }
      localMap.put(str, parami);
      AppMethodBeat.o(50374);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.i
 * JD-Core Version:    0.7.0.1
 */