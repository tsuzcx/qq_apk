package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  public final void j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(211633);
    if (!com.tencent.mm.compatible.d.b.ca(aj.getContext()))
    {
      paramString = new RequestFloatWindowPermissionDialog.a()
      {
        public final void a(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(211630);
          ad.w("LiteAppJsApiBookDownloadGame", "float window permission granted");
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(211630);
        }
        
        public final void b(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(211631);
          ad.w("LiteAppJsApiBookDownloadGame", "float window permission refused");
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(211631);
        }
        
        public final void c(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(211632);
          ad.w("LiteAppJsApiBookDownloadGame", "onResultCancel ok:%b", new Object[] { Boolean.valueOf(com.tencent.mm.compatible.d.b.ca(aj.getContext())) });
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(211632);
        }
      };
      RequestFloatWindowPermissionDialog.a(aj.getContext(), aj.getContext().getString(2131759453), paramString, true, com.tencent.mm.br.a.abB());
    }
    AppMethodBeat.o(211633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.b
 * JD-Core Version:    0.7.0.1
 */