package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class u
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final b<i>.a paramb)
  {
    AppMethodBeat.i(83078);
    String str1 = paramb.ctb.csi.optString("videoUrl");
    String str2 = paramb.ctb.csi.optString("thumbUrl");
    String str3 = paramb.ctb.csi.optString("appId");
    int i = paramb.ctb.csi.optInt("sourceSceneId");
    if (Util.isNullOrNil(str1))
    {
      paramb.c("invalid_videoUrl", null);
      AppMethodBeat.o(83078);
      return;
    }
    ((com.tencent.mm.plugin.game.api.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.g.class)).a(((i)paramb.cta).mContext, str1, str2, str3, 510, i);
    ((MMActivity)((i)paramb.cta).mContext).mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
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
          ((MMActivity)((i)paramb.cta).mContext).mmSetOnActivityResultCallback(null);
          AppMethodBeat.o(83077);
          return;
          JSONObject localJSONObject = new JSONObject();
          paramAnonymousIntent = paramAnonymousIntent.getStringExtra("key_video_info");
          try
          {
            localJSONObject.put("videoInfo", new JSONArray(paramAnonymousIntent).getJSONObject(0));
            paramb.c("", localJSONObject);
          }
          catch (JSONException paramAnonymousIntent)
          {
            for (;;)
            {
              Log.e("MicroMsg.JsApiLaunchGameVideoEditor", "json_err:%s", new Object[] { paramAnonymousIntent.getMessage() });
            }
          }
          paramb.c("cancel", null);
          continue;
          paramb.c("download_err", null);
          continue;
          label176:
          paramb.c("cancel", null);
        }
      }
    });
    AppMethodBeat.o(83078);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "launchGameVideoEditor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.u
 * JD-Core Version:    0.7.0.1
 */