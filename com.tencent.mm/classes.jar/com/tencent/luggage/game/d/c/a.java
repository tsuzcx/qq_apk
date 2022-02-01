package com.tencent.luggage.game.d.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.ae.ag;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/game/jsapi/system/GetSystemInfoNewWAGame;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/GetSystemInfoNewLU;", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "()V", "handleInvoke", "", "", "", "type", "component", "Companion", "luggage-wxa-game-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.ae.d<com.tencent.luggage.sdk.b.a.d.d>
{
  public static final a eng;
  private static final j<b> enh;
  
  static
  {
    AppMethodBeat.i(220167);
    eng = new a((byte)0);
    enh = k.cm((kotlin.g.a.a)b.eni);
    AppMethodBeat.o(220167);
  }
  
  private Map<String, Object> a(String paramString, com.tencent.luggage.sdk.b.a.d.d paramd)
  {
    AppMethodBeat.i(220162);
    s.u(paramString, "type");
    s.u(paramd, "component");
    Map localMap = null;
    if (s.p(a.apN().sxw, paramString)) {
      localMap = a.apN().b(paramString, (g)paramd);
    }
    if (localMap == null)
    {
      paramString = super.a(paramString, (g)paramd);
      AppMethodBeat.o(220162);
      return paramString;
    }
    AppMethodBeat.o(220162);
    return localMap;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/game/jsapi/system/GetSystemInfoNewWAGame$Companion;", "", "()V", "getWindowInfoWAGame", "Lcom/tencent/luggage/game/jsapi/system/PartOfGetSystemInfo_WindowInfoWAGame;", "getGetWindowInfoWAGame", "()Lcom/tencent/luggage/game/jsapi/system/PartOfGetSystemInfo_WindowInfoWAGame;", "getWindowInfoWAGame$delegate", "Lkotlin/Lazy;", "luggage-wxa-game-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static b apN()
    {
      AppMethodBeat.i(220166);
      b localb = (b)a.apM().getValue();
      AppMethodBeat.o(220166);
      return localb;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/luggage/game/jsapi/system/PartOfGetSystemInfo_WindowInfoWAGame;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<b>
  {
    public static final b eni;
    
    static
    {
      AppMethodBeat.i(220164);
      eni = new b();
      AppMethodBeat.o(220164);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.d.c.a
 * JD-Core Version:    0.7.0.1
 */