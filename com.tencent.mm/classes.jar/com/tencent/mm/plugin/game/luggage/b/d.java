package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class d
  extends br
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final b.a parama)
  {
    AppMethodBeat.i(186851);
    if (b.cx(MMApplicationContext.getContext()))
    {
      parama.c("", null);
      AppMethodBeat.o(186851);
      return;
    }
    parama = new RequestFloatWindowPermissionDialog.a()
    {
      public final void onResultAllow(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(186848);
        Log.w("MicroMsg.JsApiBookDownloadGame", "float window permission granted");
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        parama.c("", null);
        AppMethodBeat.o(186848);
      }
      
      public final void onResultCancel(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(186850);
        Log.w("MicroMsg.JsApiBookDownloadGame", "onResultCancel ok:%b", new Object[] { Boolean.valueOf(b.cx(MMApplicationContext.getContext())) });
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        parama.c("", null);
        AppMethodBeat.o(186850);
      }
      
      public final void onResultRefuse(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(186849);
        Log.w("MicroMsg.JsApiBookDownloadGame", "float window permission refused");
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        parama.c("", null);
        AppMethodBeat.o(186849);
      }
    };
    RequestFloatWindowPermissionDialog.a(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131760767), parama, true, a.apJ());
    AppMethodBeat.o(186851);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "bookDownloadGame";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.d
 * JD-Core Version:    0.7.0.1
 */