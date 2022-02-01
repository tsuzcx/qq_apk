package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.plugin.lite.jsapi.b
{
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186902);
    if (!com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext()))
    {
      paramString = new RequestFloatWindowPermissionDialog.a()
      {
        public final void onResultAllow(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(186899);
          Log.w("LiteAppJsApiBookDownloadGame", "float window permission granted");
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(186899);
        }
        
        public final void onResultCancel(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(186901);
          Log.w("LiteAppJsApiBookDownloadGame", "onResultCancel ok:%b", new Object[] { Boolean.valueOf(com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext())) });
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(186901);
        }
        
        public final void onResultRefuse(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(186900);
          Log.w("LiteAppJsApiBookDownloadGame", "float window permission refused");
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(186900);
        }
      };
      RequestFloatWindowPermissionDialog.a(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131760767), paramString, true, a.apJ());
    }
    AppMethodBeat.o(186902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.b
 * JD-Core Version:    0.7.0.1
 */