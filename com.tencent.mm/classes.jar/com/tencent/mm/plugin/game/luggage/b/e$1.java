package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.b.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONException;
import org.json.JSONObject;

final class e$1
  implements MMActivity.a
{
  e$1(e parame, bh.a parama, Context paramContext) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(154142);
    String str;
    if (paramInt1 == e.access$000())
    {
      if (paramInt2 != -1) {
        break label171;
      }
      str = paramIntent.getStringExtra("key_video_info");
      if (bo.isNullOrNil(str)) {
        break label100;
      }
      ab.i("MicroMsg.JsApiChooseHaowanMedia", "video, result: %s", new Object[] { str });
      paramIntent = new JSONObject();
    }
    try
    {
      paramIntent.put("type", 2);
      paramIntent.put("localIds", str);
      label74:
      this.lax.c(null, paramIntent);
      for (;;)
      {
        ((MMActivity)this.val$context).mmSetOnActivityResultCallback(null);
        AppMethodBeat.o(154142);
        return;
        label100:
        paramIntent = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
        if (!bo.es(paramIntent))
        {
          boolean bool = e.bY(paramIntent);
          if (bool) {
            e.a(this.njE, this.val$context);
          }
          d.ysm.execute(new e.1.1(this, paramIntent, bool));
        }
        else
        {
          this.lax.c("cancel", null);
          continue;
          label171:
          a.a(this.val$context, 8761, 1, 2, a.a(3, null));
          this.lax.c("cancel", null);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      break label74;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.e.1
 * JD-Core Version:    0.7.0.1
 */