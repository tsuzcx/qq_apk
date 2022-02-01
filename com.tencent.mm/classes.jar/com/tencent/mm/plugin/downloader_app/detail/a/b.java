package com.tencent.mm.plugin.downloader_app.detail.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
  extends bn<n>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(8824);
    ac.i("MicroMsg.JsApiImagePreview", "invokeInOwn");
    Object localObject1 = parama.bWS.bVY.optString("current");
    Object localObject2 = parama.bWS.bVY.optJSONArray("urls");
    Object localObject3 = new ArrayList();
    if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0))
    {
      ac.e("MicroMsg.JsApiImagePreview", "fail, urls is null");
      parama.a("invalid_url", null);
      AppMethodBeat.o(8824);
      return;
    }
    int i = 0;
    if (i < ((JSONArray)localObject2).length())
    {
      String str = ((JSONArray)localObject2).optString(i);
      if ((bs.isNullOrNil(str)) || (str.equalsIgnoreCase("null"))) {
        ac.e("MicroMsg.JsApiImagePreview", "null url, i = %d", new Object[] { Integer.valueOf(i) });
      }
      for (;;)
      {
        i += 1;
        break;
        ((ArrayList)localObject3).add(str);
      }
    }
    localObject2 = (String[])((ArrayList)localObject3).toArray(new String[((ArrayList)localObject3).size()]);
    if (bs.isNullOrNil((String)localObject1)) {
      localObject1 = localObject2[0];
    }
    for (;;)
    {
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("nowUrl", (String)localObject1);
      ((Intent)localObject3).putExtra("urlList", (String[])localObject2);
      ((Intent)localObject3).putExtra("type", -255);
      ((Intent)localObject3).putExtra("isFromWebView", true);
      localObject1 = (Activity)((n)parama.bWR).mContext;
      d.b((Context)localObject1, "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject3);
      ((Activity)localObject1).overridePendingTransition(2130772069, 2130772069);
      parama.a("", null);
      AppMethodBeat.o(8824);
      return;
    }
  }
  
  public final int bYk()
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