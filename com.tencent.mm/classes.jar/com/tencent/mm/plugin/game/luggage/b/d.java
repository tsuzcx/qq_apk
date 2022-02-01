package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public class d
  extends bq
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final b.a parama)
  {
    AppMethodBeat.i(192990);
    if (b.cc(ak.getContext()))
    {
      parama.a("", null);
      AppMethodBeat.o(192990);
      return;
    }
    parama = new RequestFloatWindowPermissionDialog.a()
    {
      public final void a(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(192987);
        ae.w("MicroMsg.JsApiBookDownloadGame", "float window permission granted");
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        parama.a("", null);
        AppMethodBeat.o(192987);
      }
      
      public final void b(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(192988);
        ae.w("MicroMsg.JsApiBookDownloadGame", "float window permission refused");
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        parama.a("", null);
        AppMethodBeat.o(192988);
      }
      
      public final void c(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(192989);
        ae.w("MicroMsg.JsApiBookDownloadGame", "onResultCancel ok:%b", new Object[] { Boolean.valueOf(b.cc(ak.getContext())) });
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        parama.a("", null);
        AppMethodBeat.o(192989);
      }
    };
    RequestFloatWindowPermissionDialog.a(ak.getContext(), ak.getContext().getString(2131759453), parama, true, a.abK());
    AppMethodBeat.o(192990);
  }
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "bookDownloadGame";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.d
 * JD-Core Version:    0.7.0.1
 */