package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.game.luggage.j.f;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class b
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(277084);
    if (!com.tencent.mm.compatible.e.b.dh(MMApplicationContext.getContext()))
    {
      paramString = new RequestFloatWindowPermissionDialog.a()
      {
        public final void a(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(277067);
          Log.w("LiteAppJsApiBookDownloadGame", "float window permission granted");
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(277067);
        }
        
        public final void b(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(277073);
          Log.w("LiteAppJsApiBookDownloadGame", "float window permission refused");
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(277073);
        }
        
        public final void c(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(277079);
          Log.w("LiteAppJsApiBookDownloadGame", "onResultCancel ok:%b", new Object[] { Boolean.valueOf(com.tencent.mm.compatible.e.b.dh(MMApplicationContext.getContext())) });
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(277079);
        }
      };
      RequestFloatWindowPermissionDialog.a(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(j.f.float_ball_no_float_window_permission_alert_download), paramString, true, a.aQB());
    }
    AppMethodBeat.o(277084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.b
 * JD-Core Version:    0.7.0.1
 */