package com.tencent.mm.plugin.downloader_app.detail.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
  extends bq<s>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(8824);
    ad.i("MicroMsg.JsApiImagePreview", "invokeInOwn");
    Object localObject1 = parama.chh.cgn.optString("current");
    Object localObject2 = parama.chh.cgn.optJSONArray("urls");
    Object localObject3 = new ArrayList();
    if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0))
    {
      ad.e("MicroMsg.JsApiImagePreview", "fail, urls is null");
      parama.a("invalid_url", null);
      AppMethodBeat.o(8824);
      return;
    }
    int i = 0;
    if (i < ((JSONArray)localObject2).length())
    {
      String str = ((JSONArray)localObject2).optString(i);
      if ((bt.isNullOrNil(str)) || (str.equalsIgnoreCase("null"))) {
        ad.e("MicroMsg.JsApiImagePreview", "null url, i = %d", new Object[] { Integer.valueOf(i) });
      }
      for (;;)
      {
        i += 1;
        break;
        ((ArrayList)localObject3).add(str);
      }
    }
    localObject2 = (String[])((ArrayList)localObject3).toArray(new String[((ArrayList)localObject3).size()]);
    if (bt.isNullOrNil((String)localObject1)) {
      localObject1 = localObject2[0];
    }
    for (;;)
    {
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("nowUrl", (String)localObject1);
      ((Intent)localObject3).putExtra("urlList", (String[])localObject2);
      ((Intent)localObject3).putExtra("type", -255);
      ((Intent)localObject3).putExtra("isFromWebView", true);
      localObject1 = (Activity)((s)parama.chg).mContext;
      d.b((Context)localObject1, "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject3);
      ((Activity)localObject1).overridePendingTransition(2130772069, 2130772069);
      parama.a("", null);
      AppMethodBeat.o(8824);
      return;
    }
  }
  
  public final int ccO()
  {
    return 0;
  }
  
  public final String name()
  {
    return "imagePreview";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.b
 * JD-Core Version:    0.7.0.1
 */