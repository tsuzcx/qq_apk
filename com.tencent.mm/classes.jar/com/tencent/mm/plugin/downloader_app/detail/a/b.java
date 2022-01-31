package com.tencent.mm.plugin.downloader_app.detail.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a.a;
import com.tencent.luggage.e.e;
import com.tencent.luggage.e.n;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.downloader_app.b.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
  extends aw<n>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a.a parama)
  {
    y.i("MicroMsg.JsApiImagePreview", "invokeInOwn");
    Object localObject1 = parama.bih.bhk.optString("current");
    Object localObject2 = parama.bih.bhk.optJSONArray("urls");
    Object localObject3 = new ArrayList();
    if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0))
    {
      y.e("MicroMsg.JsApiImagePreview", "fail, urls is null");
      parama.a("invalid_url", null);
      return;
    }
    int i = 0;
    if (i < ((JSONArray)localObject2).length())
    {
      String str = ((JSONArray)localObject2).optString(i);
      if ((bk.bl(str)) || (str.equalsIgnoreCase("null"))) {
        y.e("MicroMsg.JsApiImagePreview", "null url, i = %d", new Object[] { Integer.valueOf(i) });
      }
      for (;;)
      {
        i += 1;
        break;
        ((ArrayList)localObject3).add(str);
      }
    }
    localObject2 = (String[])((ArrayList)localObject3).toArray(new String[((ArrayList)localObject3).size()]);
    if (bk.bl((String)localObject1)) {
      localObject1 = localObject2[0];
    }
    for (;;)
    {
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("nowUrl", (String)localObject1);
      ((Intent)localObject3).putExtra("urlList", (String[])localObject2);
      ((Intent)localObject3).putExtra("type", -255);
      ((Intent)localObject3).putExtra("isFromWebView", true);
      localObject1 = (Activity)((n)parama.big).mContext;
      d.b((Context)localObject1, "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject3);
      ((Activity)localObject1).overridePendingTransition(b.a.in_no_slide, b.a.in_no_slide);
      parama.a("", null);
      return;
    }
  }
  
  public final String name()
  {
    return "imagePreview";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.b
 * JD-Core Version:    0.7.0.1
 */