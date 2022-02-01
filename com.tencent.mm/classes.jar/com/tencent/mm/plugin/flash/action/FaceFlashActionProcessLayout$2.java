package com.tencent.mm.plugin.flash.action;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.plugin.facedetectaction.ui.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

final class FaceFlashActionProcessLayout$2
  implements a.a
{
  FaceFlashActionProcessLayout$2(FaceFlashActionProcessLayout paramFaceFlashActionProcessLayout, JSONObject paramJSONObject, String paramString) {}
  
  public final void onClick(String paramString)
  {
    AppMethodBeat.i(264729);
    Log.i(FaceFlashActionProcessLayout.access$000(), "click feedback url ");
    try
    {
      paramString = r.as(String.format("appid=%s;errcode=%d;identifyid=%s", new Object[] { this.HhV.optString("key_app_id", ""), Integer.valueOf(this.HhV.optInt("err_code", 0)), this.HhV.optString("verify_result", "") }), "UTF-8");
      paramString = this.HhW + "?customInfo=" + paramString;
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramString);
      c.b(this.HiO.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(264729);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace(FaceFlashActionProcessLayout.access$200(), paramString, "face start feedback webview exception", new Object[0]);
      AppMethodBeat.o(264729);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.action.FaceFlashActionProcessLayout.2
 * JD-Core Version:    0.7.0.1
 */