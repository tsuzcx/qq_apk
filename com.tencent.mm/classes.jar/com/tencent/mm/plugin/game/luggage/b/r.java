package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class r
  extends br<com.tencent.mm.plugin.game.luggage.f.g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final b<com.tencent.mm.plugin.game.luggage.f.g>.a paramb)
  {
    AppMethodBeat.i(83078);
    String str1 = paramb.chh.cgn.optString("videoUrl");
    String str2 = paramb.chh.cgn.optString("thumbUrl");
    String str3 = paramb.chh.cgn.optString("appId");
    if (bu.isNullOrNil(str1))
    {
      paramb.a("invalid_videoUrl", null);
      AppMethodBeat.o(83078);
      return;
    }
    ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.g.class)).a(((com.tencent.mm.plugin.game.luggage.f.g)paramb.chg).mContext, str1, str2, str3, 510);
    ((MMActivity)((com.tencent.mm.plugin.game.luggage.f.g)paramb.chg).mContext).mmSetOnActivityResultCallback(new MMActivity.a()
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
          ((MMActivity)((com.tencent.mm.plugin.game.luggage.f.g)paramb.chg).mContext).mmSetOnActivityResultCallback(null);
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
              ae.e("MicroMsg.JsApiLaunchGameVideoEditor", "json_err:%s", new Object[] { paramAnonymousIntent.getMessage() });
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
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "launchGameVideoEditor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.r
 * JD-Core Version:    0.7.0.1
 */