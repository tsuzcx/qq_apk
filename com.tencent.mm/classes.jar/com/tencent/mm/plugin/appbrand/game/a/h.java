package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.aa;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.HashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "kv", "", "defaultValue", "askRestart", "(Ljava/lang/String;ZZ)V", "enableAlert", "enableKv", "getConfigDefaultValue", "()Ljava/lang/Boolean;", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "Companion", "plugin-appbrand-integration_release"})
public final class h
  extends q<Boolean>
{
  public static final a jQA;
  private static final HashMap<String, h> jQz;
  final String jQw;
  private final boolean jQx;
  private final boolean jQy;
  
  static
  {
    AppMethodBeat.i(50378);
    jQA = new a((byte)0);
    jQz = new HashMap();
    a.a(new h("localso", (byte)0));
    a.a(new h("renderprofiler", (byte)0));
    a.a(new h("debugNode", (byte)0));
    a.a(new h("tracejstask", (byte)0));
    AppMethodBeat.o(50378);
  }
  
  private h(String paramString)
  {
    AppMethodBeat.i(50377);
    this.jQw = paramString;
    this.jQx = false;
    this.jQy = true;
    if (!n.aD((CharSequence)this.jQw)) {}
    for (int i = 1; (aa.KTq) && (i == 0); i = 0)
    {
      paramString = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(50377);
      throw paramString;
    }
    AppMethodBeat.o(50377);
  }
  
  public static final h Lv(String paramString)
  {
    AppMethodBeat.i(50379);
    k.h(paramString, "kv_name");
    paramString = jQz.get(paramString);
    if (paramString == null) {
      k.fOy();
    }
    paramString = (h)paramString;
    AppMethodBeat.o(50379);
    return paramString;
  }
  
  protected final String bdx()
  {
    return this.jQw;
  }
  
  protected final boolean bdz()
  {
    return this.jQy;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple$Companion;", "", "()V", "registry", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lkotlin/collections/HashMap;", "get", "kv_name", "getAll", "", "register", "", "config", "plugin-appbrand-integration_release"})
  public static final class a
  {
    static void a(h paramh)
    {
      AppMethodBeat.i(50374);
      Map localMap = (Map)h.bdC();
      String str = paramh.jQw;
      if (str == null) {
        k.fOy();
      }
      localMap.put(str, paramh);
      AppMethodBeat.o(50374);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.h
 * JD-Core Version:    0.7.0.1
 */