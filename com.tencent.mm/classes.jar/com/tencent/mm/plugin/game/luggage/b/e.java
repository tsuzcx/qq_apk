package com.tencent.mm.plugin.game.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bi;
import com.tencent.mm.plugin.webview.ui.tools.game.GameChooseMediaUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.base.p;
import org.json.JSONObject;

public class e
  extends bi<f>
{
  private static final int njD;
  private p ehb;
  private DialogInterface.OnCancelListener hQL;
  
  static
  {
    AppMethodBeat.i(154148);
    njD = "choose_media_request_code".hashCode() & 0xFFFF;
    AppMethodBeat.o(154148);
  }
  
  private static String Cn(String paramString)
  {
    AppMethodBeat.i(154144);
    int i = Exif.fromFile(paramString).getOrientationInDegree();
    if (i != 0) {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        Object localObject = MMBitmapFactory.decodeFile(paramString, localOptions);
        if (localObject == null)
        {
          ab.e("MicroMsg.JsApiChooseHaowanMedia", "rotate image, get null bmp");
          AppMethodBeat.o(154144);
          return paramString;
        }
        float f = i % 360;
        Bitmap localBitmap = d.b((Bitmap)localObject, f);
        String str = com.tencent.mm.compatible.util.e.esr + "microMsg.tmp." + System.currentTimeMillis();
        ab.i("MicroMsg.JsApiChooseHaowanMedia", "doRotate, dstPath : %s", new Object[] { str });
        if (com.tencent.luggage.e.a.a.b(localOptions)) {}
        for (localObject = Bitmap.CompressFormat.JPEG;; localObject = Bitmap.CompressFormat.PNG) {
          try
          {
            d.a(localBitmap, 80, (Bitmap.CompressFormat)localObject, str, true);
            if (com.tencent.luggage.e.a.a.b(localOptions)) {
              com.tencent.mm.plugin.appbrand.h.b.bZ(paramString, str);
            }
            AppMethodBeat.o(154144);
            return str;
          }
          catch (Exception localException)
          {
            ab.e("MicroMsg.JsApiChooseHaowanMedia", "rotate image, exception occurred when saving | %s", new Object[] { localException });
            com.tencent.mm.a.e.deleteFile(str);
            AppMethodBeat.o(154144);
            return paramString;
          }
        }
        AppMethodBeat.o(154144);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        AppMethodBeat.o(154144);
        return paramString;
      }
      catch (NullPointerException localNullPointerException)
      {
        AppMethodBeat.o(154144);
        return paramString;
      }
    }
    return paramString;
  }
  
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(154143);
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.BJ(paramString);
    if (paramString == null)
    {
      parama.c("invalid_params", null);
      AppMethodBeat.o(154143);
      return;
    }
    int i = paramString.optInt("mediaType", 3);
    paramString.optString("mediaTag");
    int j = paramString.optInt("limitCount", 9);
    paramString = new Intent(paramContext, GameChooseMediaUI.class);
    paramString.putExtra("key_can_select_video_and_pic", true);
    paramString.putExtra("key_send_raw_image", false);
    ((MMActivity)paramContext).mmSetOnActivityResultCallback(new e.1(this, parama, paramContext));
    paramString.putExtra("max_select_count", j);
    paramString.putExtra("query_source_type", 15);
    paramString.putExtra("query_media_type", i);
    paramString.putExtra("show_header_view", false);
    paramString.addFlags(67108864);
    ((MMActivity)paramContext).startActivityForResult(paramString, njD);
    ((Activity)paramContext).overridePendingTransition(MMFragmentActivity.a.zbX, MMFragmentActivity.a.zbY);
    com.tencent.mm.game.report.b.a.a(paramContext, 8761, 0, 1, com.tencent.mm.game.report.b.a.a(3, null));
    AppMethodBeat.o(154143);
  }
  
  public final void b(com.tencent.luggage.d.a<f>.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "chooseHaowanMedia";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.e
 * JD-Core Version:    0.7.0.1
 */