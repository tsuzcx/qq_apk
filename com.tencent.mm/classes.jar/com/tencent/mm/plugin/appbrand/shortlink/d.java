package com.tencent.mm.plugin.appbrand.shortlink;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkAbility;", "Lcom/tencent/mm/plugin/appbrand/IWxaShortLinkAbility;", "()V", "KEY_LAST_LAST_APPBRAND_SWITCH_SHORT_LINK_HIGHLIGHT", "", "TAG", "isHighlightEnable", "Lkotlin/Function0;", "", "()Lkotlin/jvm/functions/Function0;", "isMenuEntryEnable", "checkShortLinkABTestStatus", "", "plugin-appbrand-integration_release"})
public final class d
{
  private static final a<Boolean> qQk;
  private static final a<Boolean> qQl;
  public static final d qQm;
  
  static
  {
    AppMethodBeat.i(282247);
    qQm = new d();
    qQk = (a)a.qQn;
    qQl = (a)b.qQo;
    AppMethodBeat.o(282247);
  }
  
  public static void ciG()
  {
    AppMethodBeat.i(282245);
    boolean bool;
    StringBuilder localStringBuilder;
    if (((b)h.ae(b.class)).a(b.a.wab, 0) == 1)
    {
      bool = true;
      localObject = f.nCi.aal();
      if (localObject == null) {
        p.iCn();
      }
      if (((MultiProcessMMKV)localObject).getBoolean("last_appbrand_switch_short_link_highlight", false) != bool)
      {
        com.tencent.mm.pluginsdk.ui.span.l.clearCache();
        localObject = f.nCi.aal();
        if (localObject == null) {
          p.iCn();
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
      AppMethodBeat.o(282245);
      return;
      bool = false;
      break;
    }
  }
  
  public static a<Boolean> ciH()
  {
    return qQk;
  }
  
  public static a<Boolean> ciI()
  {
    return qQl;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Boolean>
  {
    public static final a qQn;
    
    static
    {
      AppMethodBeat.i(276336);
      qQn = new a();
      AppMethodBeat.o(276336);
    }
    
    a()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Boolean>
  {
    public static final b qQo;
    
    static
    {
      AppMethodBeat.i(270178);
      qQo = new b();
      AppMethodBeat.o(270178);
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