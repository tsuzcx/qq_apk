package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  public final void j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(193022);
    if (!com.tencent.mm.compatible.d.b.cc(ak.getContext()))
    {
      paramString = new RequestFloatWindowPermissionDialog.a()
      {
        public final void a(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(193019);
          ae.w("LiteAppJsApiBookDownloadGame", "float window permission granted");
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(193019);
        }
        
        public final void b(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(193020);
          ae.w("LiteAppJsApiBookDownloadGame", "float window permission refused");
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(193020);
        }
        
        public final void c(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(193021);
          ae.w("LiteAppJsApiBookDownloadGame", "onResultCancel ok:%b", new Object[] { Boolean.valueOf(com.tencent.mm.compatible.d.b.cc(ak.getContext())) });
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(193021);
        }
      };
      RequestFloatWindowPermissionDialog.a(ak.getContext(), ak.getContext().getString(2131759453), paramString, true, com.tencent.mm.bq.a.abK());
    }
    AppMethodBeat.o(193022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.b
 * JD-Core Version:    0.7.0.1
 */