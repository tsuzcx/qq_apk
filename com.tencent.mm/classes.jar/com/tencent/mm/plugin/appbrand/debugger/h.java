package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.c.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/debugger/MockScanCodeUrl;", "Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShell$DebuggerAction;", "()V", "handler", "Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "getHandler", "()Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "handler$delegate", "Lkotlin/Lazy;", "name", "", "onAction", "", "intent", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
public final class h
  implements DebuggerShell.a
{
  private final f lhN;
  
  public h()
  {
    AppMethodBeat.i(50350);
    this.lhN = g.ah((a)a.lhO);
    AppMethodBeat.o(50350);
  }
  
  public final void A(Intent paramIntent)
  {
    AppMethodBeat.i(50349);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("url");
      if (paramIntent != null)
      {
        ((e)this.lhN.getValue()).a(MMApplicationContext.getContext(), paramIntent, 1011, new Bundle(), null);
        AppMethodBeat.o(50349);
        return;
      }
    }
    AppMethodBeat.o(50349);
  }
  
  public final String name()
  {
    return "MockScanCodeUrl";
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "invoke"})
  static final class a
    extends q
    implements a<e>
  {
    public static final a lhO;
    
    static
    {
      AppMethodBeat.i(50347);
      lhO = new a();
      AppMethodBeat.o(50347);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.h
 * JD-Core Version:    0.7.0.1
 */