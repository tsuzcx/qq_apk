package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.a;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public class d
  extends bq
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final b.a parama)
  {
    AppMethodBeat.i(211601);
    if (b.ca(aj.getContext()))
    {
      parama.a("", null);
      AppMethodBeat.o(211601);
      return;
    }
    parama = new RequestFloatWindowPermissionDialog.a()
    {
      public final void a(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(211598);
        ad.w("MicroMsg.JsApiBookDownloadGame", "float window permission granted");
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        parama.a("", null);
        AppMethodBeat.o(211598);
      }
      
      public final void b(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(211599);
        ad.w("MicroMsg.JsApiBookDownloadGame", "float window permission refused");
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        parama.a("", null);
        AppMethodBeat.o(211599);
      }
      
      public final void c(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(211600);
        ad.w("MicroMsg.JsApiBookDownloadGame", "onResultCancel ok:%b", new Object[] { Boolean.valueOf(b.ca(aj.getContext())) });
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        parama.a("", null);
        AppMethodBeat.o(211600);
      }
    };
    RequestFloatWindowPermissionDialog.a(aj.getContext(), aj.getContext().getString(2131759453), parama, true, a.abB());
    AppMethodBeat.o(211601);
  }
  
  public final int ccO()
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