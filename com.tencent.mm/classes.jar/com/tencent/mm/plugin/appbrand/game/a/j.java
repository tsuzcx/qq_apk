package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.z;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "kv", "", "defaultValue", "askRestart", "(Ljava/lang/String;ZZ)V", "enableAlert", "enableKv", "getConfigDefaultValue", "()Ljava/lang/Boolean;", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "Companion", "plugin-appbrand-integration_release"})
public final class j
  extends x<Boolean>
{
  private static final HashMap<String, j> omE;
  public static final a omF;
  final String omB;
  private final boolean omC;
  private final boolean omD;
  
  static
  {
    AppMethodBeat.i(50378);
    omF = new a((byte)0);
    omE = new HashMap();
    a.a(new j("localso", (byte)0));
    a.a(new j("renderprofiler", (byte)0));
    a.a(new j("debugNode", (byte)0));
    a.a(new j("tracejstask", (byte)0));
    AppMethodBeat.o(50378);
  }
  
  private j(String paramString)
  {
    AppMethodBeat.i(50377);
    this.omB = paramString;
    this.omC = false;
    this.omD = true;
    if (!n.ba((CharSequence)this.omB)) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0)
    {
      paramString = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(50377);
      throw paramString;
    }
    AppMethodBeat.o(50377);
  }
  
  public static final j agw(String paramString)
  {
    AppMethodBeat.i(50379);
    p.k(paramString, "kv_name");
    paramString = omE.get(paramString);
    if (paramString == null) {
      p.iCn();
    }
    paramString = (j)paramString;
    AppMethodBeat.o(50379);
    return paramString;
  }
  
  protected final String bOt()
  {
    return this.omB;
  }
  
  protected final boolean bOv()
  {
    return this.omD;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple$Companion;", "", "()V", "registry", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lkotlin/collections/HashMap;", "get", "kv_name", "getAll", "", "register", "", "config", "plugin-appbrand-integration_release"})
  public static final class a
  {
    static void a(j paramj)
    {
      AppMethodBeat.i(50374);
      Map localMap = (Map)j.bOy();
      String str = paramj.omB;
      if (str == null) {
        p.iCn();
      }
      localMap.put(str, paramj);
      AppMethodBeat.o(50374);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.j
 * JD-Core Version:    0.7.0.1
 */