package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.c.e;
import com.tencent.mm.sdk.platformtools.aj;
import d.f;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;
import d.l.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/debugger/MockScanCodeUrl;", "Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShell$DebuggerAction;", "()V", "handler", "Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "getHandler", "()Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "handler$delegate", "Lkotlin/Lazy;", "name", "", "onAction", "", "intent", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
public final class g
  implements DebuggerShell.a
{
  private final f jgk;
  
  static
  {
    AppMethodBeat.i(50348);
    $$delegatedProperties = new k[] { (k)w.a(new u(w.bk(g.class), "handler", "getHandler()Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;")) };
    AppMethodBeat.o(50348);
  }
  
  public g()
  {
    AppMethodBeat.i(50350);
    this.jgk = d.g.E((a)a.jgl);
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
        ((e)this.jgk.getValue()).a(aj.getContext(), paramIntent, 1011, new Bundle());
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<e>
  {
    public static final a jgl;
    
    static
    {
      AppMethodBeat.i(50347);
      jgl = new a();
      AppMethodBeat.o(50347);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.g
 * JD-Core Version:    0.7.0.1
 */