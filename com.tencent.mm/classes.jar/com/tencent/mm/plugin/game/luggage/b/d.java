package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.a;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public class d
  extends bn
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a.a parama)
  {
    AppMethodBeat.i(190162);
    if (b.bZ(aj.getContext()))
    {
      parama.a("", null);
      AppMethodBeat.o(190162);
      return;
    }
    parama = new RequestFloatWindowPermissionDialog.a()
    {
      public final void a(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(190159);
        ad.w("MicroMsg.JsApiBookDownloadGame", "float window permission granted");
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        parama.a("", null);
        AppMethodBeat.o(190159);
      }
      
      public final void b(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(190160);
        ad.w("MicroMsg.JsApiBookDownloadGame", "float window permission refused");
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        parama.a("", null);
        AppMethodBeat.o(190160);
      }
      
      public final void c(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(190161);
        ad.w("MicroMsg.JsApiBookDownloadGame", "onResultCancel ok:%b", new Object[] { Boolean.valueOf(b.bZ(aj.getContext())) });
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        parama.a("", null);
        AppMethodBeat.o(190161);
      }
    };
    RequestFloatWindowPermissionDialog.a(aj.getContext(), aj.getContext().getString(2131759453), parama, true, a.Ye());
    AppMethodBeat.o(190162);
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "bookDownloadGame";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.d
 * JD-Core Version:    0.7.0.1
 */