package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "kv", "", "defaultValue", "askRestart", "(Ljava/lang/String;ZZ)V", "enableAlert", "enableKv", "getConfigDefaultValue", "()Ljava/lang/Boolean;", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "Companion", "plugin-appbrand-integration_release"})
public final class j
  extends v<Boolean>
{
  private static final HashMap<String, j> lrJ;
  public static final a lrK;
  final String lrG;
  private final boolean lrH;
  private final boolean lrI;
  
  static
  {
    AppMethodBeat.i(50378);
    lrK = new a((byte)0);
    lrJ = new HashMap();
    a.a(new j("localso", (byte)0));
    a.a(new j("renderprofiler", (byte)0));
    a.a(new j("debugNode", (byte)0));
    a.a(new j("tracejstask", (byte)0));
    AppMethodBeat.o(50378);
  }
  
  private j(String paramString)
  {
    AppMethodBeat.i(50377);
    this.lrG = paramString;
    this.lrH = false;
    this.lrI = true;
    if (!n.aL((CharSequence)this.lrG)) {}
    for (int i = 1; (aa.SXc) && (i == 0); i = 0)
    {
      paramString = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(50377);
      throw paramString;
    }
    AppMethodBeat.o(50377);
  }
  
  public static final j YI(String paramString)
  {
    AppMethodBeat.i(50379);
    p.h(paramString, "kv_name");
    paramString = lrJ.get(paramString);
    if (paramString == null) {
      p.hyc();
    }
    paramString = (j)paramString;
    AppMethodBeat.o(50379);
    return paramString;
  }
  
  protected final String bCY()
  {
    return this.lrG;
  }
  
  protected final boolean bDa()
  {
    return this.lrI;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple$Companion;", "", "()V", "registry", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lkotlin/collections/HashMap;", "get", "kv_name", "getAll", "", "register", "", "config", "plugin-appbrand-integration_release"})
  public static final class a
  {
    static void a(j paramj)
    {
      AppMethodBeat.i(50374);
      Map localMap = (Map)j.bDd();
      String str = paramj.lrG;
      if (str == null) {
        p.hyc();
      }
      localMap.put(str, paramj);
      AppMethodBeat.o(50374);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.j
 * JD-Core Version:    0.7.0.1
 */