package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.aa;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "kv", "", "defaultValue", "askRestart", "(Ljava/lang/String;ZZ)V", "enableAlert", "enableKv", "getConfigDefaultValue", "()Ljava/lang/Boolean;", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "Companion", "plugin-appbrand-integration_release"})
public final class h
  extends n<Boolean>
{
  private static final HashMap<String, h> jqk;
  public static final a jql;
  final String jqh;
  private final boolean jqi;
  private final boolean jqj;
  
  static
  {
    AppMethodBeat.i(50378);
    jql = new a((byte)0);
    jqk = new HashMap();
    a.a(new h("localso", (byte)0));
    a.a(new h("renderprofiler", (byte)0));
    a.a(new h("debugNode", (byte)0));
    a.a(new h("tracejstask", (byte)0));
    AppMethodBeat.o(50378);
  }
  
  private h(String paramString)
  {
    AppMethodBeat.i(50377);
    this.jqh = paramString;
    this.jqi = false;
    this.jqj = true;
    if (!d.n.n.aC((CharSequence)this.jqh)) {}
    for (int i = 1; (aa.JfW) && (i == 0); i = 0)
    {
      paramString = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(50377);
      throw paramString;
    }
    AppMethodBeat.o(50377);
  }
  
  public static final h Hr(String paramString)
  {
    AppMethodBeat.i(50379);
    k.h(paramString, "kv_name");
    paramString = jqk.get(paramString);
    if (paramString == null) {
      k.fvU();
    }
    paramString = (h)paramString;
    AppMethodBeat.o(50379);
    return paramString;
  }
  
  protected final boolean aWB()
  {
    return this.jqj;
  }
  
  protected final String aWz()
  {
    return this.jqh;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple$Companion;", "", "()V", "registry", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lkotlin/collections/HashMap;", "get", "kv_name", "getAll", "", "register", "", "config", "plugin-appbrand-integration_release"})
  public static final class a
  {
    static void a(h paramh)
    {
      AppMethodBeat.i(50374);
      Map localMap = (Map)h.aWE();
      String str = paramh.jqh;
      if (str == null) {
        k.fvU();
      }
      localMap.put(str, paramh);
      AppMethodBeat.o(50374);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.h
 * JD-Core Version:    0.7.0.1
 */