package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.facedetectaction.ui.FaceTransStubUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class b
  extends a
{
  public static final int CTRL_INDEX = 495;
  public static final String NAME = "faceVerifyForPay";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.i("MicroMsg.JsApiStartFaceAction", "carson: start JsApiStartFaceAction（） ");
    h.nFQ.a(917L, 35L, 1L, false);
    if ((paramc.getContext() instanceof MMActivity)) {}
    for (MMActivity localMMActivity = (MMActivity)paramc.getContext();; localMMActivity = null)
    {
      int i = paramJSONObject.optInt("scene");
      String str1 = paramJSONObject.optString("package");
      String str2 = paramJSONObject.optString("packageSign");
      paramJSONObject = paramJSONObject.optString("otherVerifyTitle");
      Intent localIntent = new Intent(localMMActivity, FaceTransStubUI.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("scene", i);
      localBundle.putString("package", str1);
      localBundle.putString("packageSign", str2);
      localBundle.putString("otherVerifyTitle", paramJSONObject);
      localIntent.putExtras(localBundle);
      localMMActivity.gJb = new b.1(this, paramc, paramInt);
      localMMActivity.startActivityForResult(localIntent, 63);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.face.b
 * JD-Core Version:    0.7.0.1
 */