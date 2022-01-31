package com.tencent.mm.plugin.appbrand.debugger;

import a.f;
import a.f.a.a;
import a.f.b.t;
import a.f.b.v;
import a.j.k;
import a.l;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.b.e;
import com.tencent.mm.sdk.platformtools.ah;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/debugger/MockScanCodeUrl;", "Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShell$DebuggerAction;", "()V", "handler", "Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "getHandler", "()Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "handler$delegate", "Lkotlin/Lazy;", "name", "", "onAction", "", "intent", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
public final class g
  implements DebuggerShell.a
{
  private final f hlg;
  
  static
  {
    AppMethodBeat.i(134598);
    eOJ = new k[] { (k)v.a(new t(v.aG(g.class), "handler", "getHandler()Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;")) };
    AppMethodBeat.o(134598);
  }
  
  public g()
  {
    AppMethodBeat.i(134600);
    this.hlg = a.g.j((a)g.a.hlh);
    AppMethodBeat.o(134600);
  }
  
  public final void B(Intent paramIntent)
  {
    AppMethodBeat.i(134599);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("url");
      if (paramIntent != null)
      {
        ((e)this.hlg.getValue()).a(ah.getContext(), paramIntent, 1011, new Bundle());
        AppMethodBeat.o(134599);
        return;
      }
    }
    AppMethodBeat.o(134599);
  }
  
  public final String name()
  {
    return "MockScanCodeUrl";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.g
 * JD-Core Version:    0.7.0.1
 */