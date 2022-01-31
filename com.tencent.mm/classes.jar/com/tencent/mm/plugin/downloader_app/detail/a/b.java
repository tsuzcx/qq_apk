package com.tencent.mm.plugin.downloader_app.detail.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
  extends bh<n>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(136069);
    ab.i("MicroMsg.JsApiImagePreview", "invokeInOwn");
    Object localObject1 = parama.byF.bxK.optString("current");
    Object localObject2 = parama.byF.bxK.optJSONArray("urls");
    Object localObject3 = new ArrayList();
    if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0))
    {
      ab.e("MicroMsg.JsApiImagePreview", "fail, urls is null");
      parama.a("invalid_url", null);
      AppMethodBeat.o(136069);
      return;
    }
    int i = 0;
    if (i < ((JSONArray)localObject2).length())
    {
      String str = ((JSONArray)localObject2).optString(i);
      if ((bo.isNullOrNil(str)) || (str.equalsIgnoreCase("null"))) {
        ab.e("MicroMsg.JsApiImagePreview", "null url, i = %d", new Object[] { Integer.valueOf(i) });
      }
      for (;;)
      {
        i += 1;
        break;
        ((ArrayList)localObject3).add(str);
      }
    }
    localObject2 = (String[])((ArrayList)localObject3).toArray(new String[((ArrayList)localObject3).size()]);
    if (bo.isNullOrNil((String)localObject1)) {
      localObject1 = localObject2[0];
    }
    for (;;)
    {
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("nowUrl", (String)localObject1);
      ((Intent)localObject3).putExtra("urlList", (String[])localObject2);
      ((Intent)localObject3).putExtra("type", -255);
      ((Intent)localObject3).putExtra("isFromWebView", true);
      localObject1 = (Activity)((n)parama.byE).mContext;
      d.b((Context)localObject1, "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject3);
      ((Activity)localObject1).overridePendingTransition(2131034195, 2131034195);
      parama.a("", null);
      AppMethodBeat.o(136069);
      return;
    }
  }
  
  public final int bjL()
  {
    return 0;
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