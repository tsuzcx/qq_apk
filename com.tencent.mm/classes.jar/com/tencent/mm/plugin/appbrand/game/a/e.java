package com.tencent.mm.plugin.appbrand.game.a;

import a.aa;
import a.f.b.j;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "kv", "", "defaultValue", "askRestart", "(Ljava/lang/String;ZZ)V", "enableAlert", "enableKv", "getConfigDefaultValue", "()Ljava/lang/Boolean;", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends g<Boolean>
{
  private static final HashMap<String, e> hsr;
  public static final a hss;
  final String hso;
  private final boolean hsp;
  private final boolean hsq;
  
  static
  {
    AppMethodBeat.i(134623);
    hss = new a((byte)0);
    hsr = new HashMap();
    a.a(new e("localso", (byte)0));
    a.a(new e("showmemory", (byte)0));
    AppMethodBeat.o(134623);
  }
  
  private e(String paramString)
  {
    AppMethodBeat.i(134622);
    this.hso = paramString;
    this.hsp = false;
    this.hsq = true;
    if (!m.ap((CharSequence)this.hso)) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramString = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(134622);
      throw paramString;
    }
    AppMethodBeat.o(134622);
  }
  
  public static final e Bt(String paramString)
  {
    AppMethodBeat.i(134624);
    j.q(paramString, "kv_name");
    paramString = hsr.get(paramString);
    if (paramString == null) {
      j.ebi();
    }
    paramString = (e)paramString;
    AppMethodBeat.o(134624);
    return paramString;
  }
  
  protected final String aAs()
  {
    return this.hso;
  }
  
  protected final boolean aAu()
  {
    return this.hsq;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple$Companion;", "", "()V", "registry", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lkotlin/collections/HashMap;", "get", "kv_name", "getAll", "", "register", "", "config", "plugin-appbrand-integration_release"})
  public static final class a
  {
    static void a(e parame)
    {
      AppMethodBeat.i(134619);
      Map localMap = (Map)e.aAx();
      String str = parame.hso;
      if (str == null) {
        j.ebi();
      }
      localMap.put(str, parame);
      AppMethodBeat.o(134619);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.e
 * JD-Core Version:    0.7.0.1
 */