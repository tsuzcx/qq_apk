package com.tencent.mm.plugin.flash;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

final class FaceFlashProcessLayout$2
  implements View.OnClickListener
{
  FaceFlashProcessLayout$2(FaceFlashProcessLayout paramFaceFlashProcessLayout, JSONObject paramJSONObject, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(264617);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/flash/FaceFlashProcessLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    try
    {
      paramView = r.as(String.format("appid=%s;errcode=%d;identifyid=%s", new Object[] { this.HhV.optString("key_app_id", ""), Integer.valueOf(this.HhV.optInt("err_code", 0)), this.HhV.optString("verify_result", "") }), "UTF-8");
      paramView = this.HhW + "?customInfo=" + paramView;
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramView);
      c.b(this.HhU.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      a.a(this, "com/tencent/mm/plugin/flash/FaceFlashProcessLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(264617);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Log.printErrStackTrace(FaceFlashProcessLayout.access$000(), paramView, "face start feedback webview exception", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.FaceFlashProcessLayout.2
 * JD-Core Version:    0.7.0.1
 */