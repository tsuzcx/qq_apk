package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public class d
  extends bn
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a.a parama)
  {
    AppMethodBeat.i(195140);
    if (b.cc(ai.getContext()))
    {
      parama.a("", null);
      AppMethodBeat.o(195140);
      return;
    }
    parama = new RequestFloatWindowPermissionDialog.a()
    {
      public final void a(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(195137);
        ac.w("MicroMsg.JsApiBookDownloadGame", "float window permission granted");
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        parama.a("", null);
        AppMethodBeat.o(195137);
      }
      
      public final void b(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(195138);
        ac.w("MicroMsg.JsApiBookDownloadGame", "float window permission refused");
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        parama.a("", null);
        AppMethodBeat.o(195138);
      }
      
      public final void c(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
      {
        AppMethodBeat.i(195139);
        ac.w("MicroMsg.JsApiBookDownloadGame", "onResultCancel ok:%b", new Object[] { Boolean.valueOf(b.cc(ai.getContext())) });
        paramAnonymousRequestFloatWindowPermissionDialog.finish();
        parama.a("", null);
        AppMethodBeat.o(195139);
      }
    };
    RequestFloatWindowPermissionDialog.a(ai.getContext(), ai.getContext().getString(2131759453), parama, true, a.Zb());
    AppMethodBeat.o(195140);
  }
  
  public final int bYk()
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