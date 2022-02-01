package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "kv", "", "defaultValue", "askRestart", "(Ljava/lang/String;ZZ)V", "enableAlert", "enableKv", "getConfigDefaultValue", "()Ljava/lang/Boolean;", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Boolean;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends z<Boolean>
{
  public static final a rql;
  private static final HashMap<String, k> rqp;
  final String rqm;
  private final boolean rqn;
  private final boolean rqo;
  
  static
  {
    AppMethodBeat.i(50378);
    rql = new a((byte)0);
    rqp = new HashMap();
    a.a(new k("localso", (byte)0));
    a.a(new k("renderprofiler", (byte)0));
    a.a(new k("debugNode", (byte)0));
    a.a(new k("tracejstask", (byte)0));
    AppMethodBeat.o(50378);
  }
  
  private k(String paramString)
  {
    AppMethodBeat.i(50377);
    this.rqm = paramString;
    this.rqn = false;
    this.rqo = true;
    if (!n.bp((CharSequence)this.rqm)) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramString = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(50377);
      throw paramString;
    }
    AppMethodBeat.o(50377);
  }
  
  public static final k Zr(String paramString)
  {
    AppMethodBeat.i(50379);
    s.u(paramString, "kv_name");
    paramString = rqp.get(paramString);
    s.checkNotNull(paramString);
    s.s(paramString, "registry[kv_name]!!");
    paramString = (k)paramString;
    AppMethodBeat.o(50379);
    return paramString;
  }
  
  protected final String coJ()
  {
    return this.rqm;
  }
  
  protected final boolean coL()
  {
    return this.rqo;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple$Companion;", "", "()V", "registry", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigSimple;", "Lkotlin/collections/HashMap;", "get", "kv_name", "getAll", "", "register", "", "config", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static void a(k paramk)
    {
      AppMethodBeat.i(50374);
      Map localMap = (Map)k.coN();
      String str = paramk.rqm;
      s.checkNotNull(str);
      localMap.put(str, paramk);
      AppMethodBeat.o(50374);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.k
 * JD-Core Version:    0.7.0.1
 */