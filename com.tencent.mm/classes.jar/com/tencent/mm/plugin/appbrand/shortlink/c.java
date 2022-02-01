package com.tencent.mm.plugin.appbrand.shortlink;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkAbility;", "Lcom/tencent/mm/plugin/appbrand/IWxaShortLinkAbility;", "()V", "KEY_LAST_LAST_APPBRAND_SWITCH_SHORT_LINK_HIGHLIGHT", "", "TAG", "isHighlightEnable", "Lkotlin/Function0;", "", "()Lkotlin/jvm/functions/Function0;", "isMenuEntryEnable", "checkShortLinkABTestStatus", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c tUX;
  private static final a<Boolean> tUY;
  private static final a<Boolean> tUZ;
  
  static
  {
    AppMethodBeat.i(321857);
    tUX = new c();
    tUY = (a)a.tVa;
    tUZ = (a)b.tVb;
    AppMethodBeat.o(321857);
  }
  
  public static a<Boolean> cJA()
  {
    return tUZ;
  }
  
  public static void cJy()
  {
    AppMethodBeat.i(321845);
    boolean bool;
    StringBuilder localStringBuilder;
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ztD, 0) == 1)
    {
      bool = true;
      localObject = f.qBv;
      localObject = f.aBP();
      s.checkNotNull(localObject);
      if (((MultiProcessMMKV)localObject).getBoolean("last_appbrand_switch_short_link_highlight", false) != bool)
      {
        p.clearCache();
        localObject = f.qBv;
        localObject = f.aBP();
        s.checkNotNull(localObject);
        ((MultiProcessMMKV)localObject).putBoolean("last_appbrand_switch_short_link_highlight", bool);
        localStringBuilder = new StringBuilder("short link highlight change to ");
        if (!bool) {
          break label120;
        }
      }
    }
    label120:
    for (Object localObject = "enable";; localObject = "disable")
    {
      Log.i("WxaShortLinkCapacity", (String)localObject + '!');
      AppMethodBeat.o(321845);
      return;
      bool = false;
      break;
    }
  }
  
  public static a<Boolean> cJz()
  {
    return tUY;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Boolean>
  {
    public static final a tVa;
    
    static
    {
      AppMethodBeat.i(321828);
      tVa = new a();
      AppMethodBeat.o(321828);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Boolean>
  {
    public static final b tVb;
    
    static
    {
      AppMethodBeat.i(321838);
      tVb = new b();
      AppMethodBeat.o(321838);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.c
 * JD-Core Version:    0.7.0.1
 */