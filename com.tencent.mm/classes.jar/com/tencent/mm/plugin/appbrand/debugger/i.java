package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.c.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/debugger/MockScanCodeUrl;", "Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShell$DebuggerAction;", "()V", "handler", "Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "getHandler", "()Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "handler$delegate", "Lkotlin/Lazy;", "name", "", "onAction", "", "intent", "Landroid/content/Intent;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements DebuggerShell.a
{
  private final j rdm;
  
  public i()
  {
    AppMethodBeat.i(50350);
    this.rdm = k.cm((a)a.rdn);
    AppMethodBeat.o(50350);
  }
  
  public final void D(Intent paramIntent)
  {
    AppMethodBeat.i(50349);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("url");
      if (paramIntent != null) {
        ((e)this.rdm.getValue()).a(MMApplicationContext.getContext(), paramIntent, 1011, new Bundle(), null);
      }
    }
    AppMethodBeat.o(50349);
  }
  
  public final String name()
  {
    return "MockScanCodeUrl";
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<e>
  {
    public static final a rdn;
    
    static
    {
      AppMethodBeat.i(50347);
      rdn = new a();
      AppMethodBeat.o(50347);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.i
 * JD-Core Version:    0.7.0.1
 */