package com.tencent.mm.plugin.lite.jsapi.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class f
  extends b
{
  private String appId;
  private JSONObject oiG;
  
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(233605);
    this.appId = paramString;
    this.oiG = paramJSONObject;
    String str1 = paramJSONObject.optString("url");
    String str2 = paramJSONObject.optString("path");
    if (str1.isEmpty())
    {
      this.Ega.aNa("");
      AppMethodBeat.o(233605);
      return;
    }
    String str3 = paramJSONObject.optString("thumbUrl");
    String str4 = paramJSONObject.optString("srcId");
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_link", str1);
    localIntent.putExtra("Ksnsupload_contentattribute", 0);
    localIntent.putExtra("Ksnsupload_source", 1);
    localIntent.putExtra("Ksnsupload_type", 1);
    localIntent.putExtra("need_result", true);
    localIntent.putExtra("ksnsis_liteapp", true);
    localIntent.putExtra("KsnsUpload_LiteAppId", paramString);
    localIntent.putExtra("KsnsUpload_LiteAppPath", str2);
    localIntent.putExtra("KsnsUpload_LiteAppQuery", paramJSONObject.optString("query"));
    localIntent.putExtra("Ksnsupload_title", paramJSONObject.optString("title"));
    if ((str4 != null) && (str4.length() > 0)) {
      localIntent.putExtra("Ksnsupload_appid", str4);
    }
    if ((str3.startsWith("http://")) || (str3.startsWith("https://"))) {
      localIntent.putExtra("Ksnsupload_imgurl", str3);
    }
    c.b(MMApplicationContext.getContext(), "sns", ".ui.SnsUploadUI", localIntent);
    AppMethodBeat.o(233605);
  }
  
  public final int ewF()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.a.f
 * JD-Core Version:    0.7.0.1
 */