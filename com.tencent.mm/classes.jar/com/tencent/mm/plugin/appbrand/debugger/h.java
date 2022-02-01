package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.c.e;
import com.tencent.mm.sdk.platformtools.aj;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/debugger/MockScanCodeUrl;", "Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShell$DebuggerAction;", "()V", "handler", "Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "getHandler", "()Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "handler$delegate", "Lkotlin/Lazy;", "name", "", "onAction", "", "intent", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
public final class h
  implements DebuggerShell.a
{
  private final f kaL;
  
  public h()
  {
    AppMethodBeat.i(50350);
    this.kaL = g.O((a)a.kaM);
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
        ((e)this.kaL.getValue()).a(aj.getContext(), paramIntent, 1011, new Bundle(), null);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "invoke"})
  static final class a
    extends q
    implements a<e>
  {
    public static final a kaM;
    
    static
    {
      AppMethodBeat.i(50347);
      kaM = new a();
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