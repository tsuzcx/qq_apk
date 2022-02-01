package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class x
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(final b<GameWebPage>.a paramb)
  {
    AppMethodBeat.i(83078);
    String str1 = paramb.eiZ.eif.optString("videoUrl");
    String str2 = paramb.eiZ.eif.optString("thumbUrl");
    String str3 = paramb.eiZ.eif.optString("appId");
    int i = paramb.eiZ.eif.optInt("sourceSceneId");
    if (Util.isNullOrNil(str1))
    {
      paramb.a("invalid_videoUrl", null);
      AppMethodBeat.o(83078);
      return;
    }
    ((com.tencent.mm.plugin.game.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.h.class)).a(((GameWebPage)paramb.eiY).mContext, str1, str2, str3, 510, i);
    ((MMActivity)((GameWebPage)paramb.eiY).mContext).mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(83077);
        if (paramAnonymousInt1 == 510)
        {
          if (paramAnonymousInt2 != -1) {
            break label176;
          }
          switch (paramAnonymousIntent.getIntExtra("webview_callback_err", 0))
          {
          }
        }
        for (;;)
        {
          ((MMActivity)((GameWebPage)paramb.eiY).mContext).mmSetOnActivityResultCallback(null);
          AppMethodBeat.o(83077);
          return;
          JSONObject localJSONObject = new JSONObject();
          paramAnonymousIntent = paramAnonymousIntent.getStringExtra("key_video_info");
          try
          {
            localJSONObject.put("videoInfo", new JSONArray(paramAnonymousIntent).getJSONObject(0));
            paramb.a("", localJSONObject);
          }
          catch (JSONException paramAnonymousIntent)
          {
            for (;;)
            {
              Log.e("MicroMsg.JsApiLaunchGameVideoEditor", "json_err:%s", new Object[] { paramAnonymousIntent.getMessage() });
            }
          }
          paramb.a("cancel", null);
          continue;
          paramb.a("download_err", null);
          continue;
          label176:
          paramb.a("cancel", null);
        }
      }
    });
    AppMethodBeat.o(83078);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "launchGameVideoEditor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.x
 * JD-Core Version:    0.7.0.1
 */