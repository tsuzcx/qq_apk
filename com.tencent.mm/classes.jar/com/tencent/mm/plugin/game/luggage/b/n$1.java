package com.tencent.mm.plugin.game.luggage.b;

import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class n$1
  implements MMActivity.a
{
  n$1(n paramn, a.a parama) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(154150);
    if (paramInt1 == 510)
    {
      if (paramInt2 != -1) {
        break label176;
      }
      switch (paramIntent.getIntExtra("webview_callback_err", 0))
      {
      }
    }
    for (;;)
    {
      ((MMActivity)((f)this.njN.byE).mContext).mmSetOnActivityResultCallback(null);
      AppMethodBeat.o(154150);
      return;
      JSONObject localJSONObject = new JSONObject();
      paramIntent = paramIntent.getStringExtra("key_video_info");
      try
      {
        localJSONObject.put("videoInfo", new JSONArray(paramIntent).getJSONObject(0));
        this.njN.a("", localJSONObject);
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          ab.e("MicroMsg.JsApiLaunchGameVideoEditor", "json_err:%s", new Object[] { paramIntent.getMessage() });
        }
      }
      this.njN.a("cancel", null);
      continue;
      this.njN.a("download_err", null);
      continue;
      label176:
      this.njN.a("cancel", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.n.1
 * JD-Core Version:    0.7.0.1
 */