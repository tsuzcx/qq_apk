package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class p
  extends bo<com.tencent.mm.plugin.game.luggage.d.f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a<com.tencent.mm.plugin.game.luggage.d.f>.a parama)
  {
    AppMethodBeat.i(83078);
    String str1 = parama.bWS.bVY.optString("videoUrl");
    String str2 = parama.bWS.bVY.optString("thumbUrl");
    String str3 = parama.bWS.bVY.optString("appId");
    if (bs.isNullOrNil(str1))
    {
      parama.a("invalid_videoUrl", null);
      AppMethodBeat.o(83078);
      return;
    }
    ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).a(((com.tencent.mm.plugin.game.luggage.d.f)parama.bWR).mContext, str1, str2, str3, 510);
    ((MMActivity)((com.tencent.mm.plugin.game.luggage.d.f)parama.bWR).mContext).mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
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
          ((MMActivity)((com.tencent.mm.plugin.game.luggage.d.f)parama.bWR).mContext).mmSetOnActivityResultCallback(null);
          AppMethodBeat.o(83077);
          return;
          JSONObject localJSONObject = new JSONObject();
          paramAnonymousIntent = paramAnonymousIntent.getStringExtra("key_video_info");
          try
          {
            localJSONObject.put("videoInfo", new JSONArray(paramAnonymousIntent).getJSONObject(0));
            parama.a("", localJSONObject);
          }
          catch (JSONException paramAnonymousIntent)
          {
            for (;;)
            {
              ac.e("MicroMsg.JsApiLaunchGameVideoEditor", "json_err:%s", new Object[] { paramAnonymousIntent.getMessage() });
            }
          }
          parama.a("cancel", null);
          continue;
          parama.a("download_err", null);
          continue;
          label176:
          parama.a("cancel", null);
        }
      }
    });
    AppMethodBeat.o(83078);
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "launchGameVideoEditor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.p
 * JD-Core Version:    0.7.0.1
 */