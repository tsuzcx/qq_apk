package com.tencent.mm.plugin.appbrand.shortlink;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkAbility;", "Lcom/tencent/mm/plugin/appbrand/IWxaShortLinkAbility;", "()V", "KEY_LAST_LAST_APPBRAND_SWITCH_SHORT_LINK_HIGHLIGHT", "", "TAG", "isHighlightEnable", "Lkotlin/Function0;", "", "()Lkotlin/jvm/functions/Function0;", "isMenuEntryEnable", "checkShortLinkABTestStatus", "", "plugin-appbrand-integration_release"})
public final class d
{
  private static final a<Boolean> nNO;
  private static final a<Boolean> nNP;
  public static final d nNQ;
  
  static
  {
    AppMethodBeat.i(229360);
    nNQ = new d();
    nNO = (a)a.nNR;
    nNP = (a)b.nNS;
    AppMethodBeat.o(229360);
  }
  
  public static a<Boolean> bVA()
  {
    return nNO;
  }
  
  public static a<Boolean> bVB()
  {
    return nNP;
  }
  
  public static void bVz()
  {
    AppMethodBeat.i(229359);
    boolean bool;
    StringBuilder localStringBuilder;
    if (((b)g.af(b.class)).a(b.a.soB, 0) == 1)
    {
      bool = true;
      localObject = f.kIs.VQ();
      if (localObject == null) {
        p.hyc();
      }
      if (((MultiProcessMMKV)localObject).getBoolean("last_appbrand_switch_short_link_highlight", false) != bool)
      {
        com.tencent.mm.pluginsdk.ui.span.l.clearCache();
        localObject = f.kIs.VQ();
        if (localObject == null) {
          p.hyc();
        }
        ((MultiProcessMMKV)localObject).putBoolean("last_appbrand_switch_short_link_highlight", bool);
        localStringBuilder = new StringBuilder("short link highlight change to ");
        if (!bool) {
          break label124;
        }
      }
    }
    label124:
    for (Object localObject = "enable";; localObject = "disable")
    {
      Log.i("WxaShortLinkCapacity", (String)localObject + '!');
      AppMethodBeat.o(229359);
      return;
      bool = false;
      break;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Boolean>
  {
    public static final a nNR;
    
    static
    {
      AppMethodBeat.i(229356);
      nNR = new a();
      AppMethodBeat.o(229356);
    }
    
    a()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Boolean>
  {
    public static final b nNS;
    
    static
    {
      AppMethodBeat.i(229358);
      nNS = new b();
      AppMethodBeat.o(229358);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.d
 * JD-Core Version:    0.7.0.1
 */