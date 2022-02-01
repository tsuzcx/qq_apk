package com.tencent.mm.plugin.lite.a.c;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class k
  extends e
{
  private String appId;
  private JSONObject rmi;
  
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271597);
    this.appId = paramString;
    this.rmi = paramJSONObject;
    String str1 = paramJSONObject.optString("url");
    String str2 = paramJSONObject.optString("path");
    if (str1.isEmpty())
    {
      this.JZj.aJV("");
      AppMethodBeat.o(271597);
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
    if (!fUc())
    {
      localIntent.putExtra("ksnsis_liteapp", true);
      localIntent.putExtra("KsnsUpload_LiteAppId", paramString);
      localIntent.putExtra("KsnsUpload_LiteAppPath", str2);
      localIntent.putExtra("KsnsUpload_LiteAppQuery", paramJSONObject.optString("query"));
    }
    localIntent.putExtra("Ksnsupload_title", paramJSONObject.optString("title"));
    if ((str4 != null) && (str4.length() > 0)) {
      localIntent.putExtra("Ksnsupload_appid", str4);
    }
    if ((str3.startsWith("http://")) || (str3.startsWith("https://"))) {
      localIntent.putExtra("Ksnsupload_imgurl", str3);
    }
    c.b(MMApplicationContext.getContext(), "sns", ".ui.SnsUploadUI", localIntent);
    AppMethodBeat.o(271597);
  }
  
  public final int fEx()
  {
    return 1;
  }
  
  protected boolean fUc()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.c.k
 * JD-Core Version:    0.7.0.1
 */