package com.tencent.mm.plugin.game.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.game.commlib.e.b.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
  extends bo<com.tencent.mm.plugin.game.luggage.d.f>
{
  private static final String sXc;
  private static final int sXd;
  private p fxw;
  private DialogInterface.OnCancelListener kxv;
  
  static
  {
    AppMethodBeat.i(83062);
    sXc = com.tencent.mm.plugin.game.commlib.e.b.b(b.a.sWw) + "haowan/";
    sXd = "choose_media_request_code".hashCode() & 0xFFFF;
    AppMethodBeat.o(83062);
  }
  
  private static String gH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(83059);
    int i = Exif.fromFile(paramString1).getOrientationInDegree();
    if (i != 0) {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        Object localObject = MMBitmapFactory.decodeFile(paramString1, localOptions);
        if (localObject == null)
        {
          ac.e("MicroMsg.JsApiChooseHaowanMedia", "rotate image, get null bmp");
          AppMethodBeat.o(83059);
          return paramString1;
        }
        float f = i % 360;
        Bitmap localBitmap = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject, f);
        ac.i("MicroMsg.JsApiChooseHaowanMedia", "doRotate, dstPath : %s", new Object[] { paramString2 });
        if (com.tencent.luggage.e.a.a.d(localOptions)) {}
        for (localObject = Bitmap.CompressFormat.JPEG;; localObject = Bitmap.CompressFormat.PNG) {
          try
          {
            com.tencent.mm.sdk.platformtools.f.a(localBitmap, 80, (Bitmap.CompressFormat)localObject, paramString2, true);
            if (com.tencent.luggage.e.a.a.d(localOptions)) {
              com.tencent.mm.plugin.appbrand.m.b.cR(paramString1, paramString2);
            }
            AppMethodBeat.o(83059);
            return paramString2;
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.JsApiChooseHaowanMedia", "rotate image, exception occurred when saving | %s", new Object[] { localException });
            com.tencent.mm.vfs.i.deleteFile(paramString2);
            AppMethodBeat.o(83059);
            return paramString1;
          }
        }
        AppMethodBeat.o(83059);
      }
      catch (OutOfMemoryError paramString2)
      {
        AppMethodBeat.o(83059);
        return paramString1;
      }
      catch (NullPointerException paramString2)
      {
        AppMethodBeat.o(83059);
        return paramString1;
      }
    }
    return paramString1;
  }
  
  public final void a(final Context paramContext, String paramString, final bn.a parama)
  {
    AppMethodBeat.i(83058);
    Object localObject = com.tencent.mm.plugin.webview.luggage.c.b.LK(paramString);
    if (localObject == null)
    {
      parama.f("invalid_params", null);
      AppMethodBeat.o(83058);
      return;
    }
    int i = ((JSONObject)localObject).optInt("mediaType", 3);
    ((JSONObject)localObject).optString("mediaTag");
    int j = ((JSONObject)localObject).optInt("limitCount", 9);
    int k = ((JSONObject)localObject).optInt("galleryType");
    paramString = ((JSONObject)localObject).optJSONArray("albumInfos");
    boolean bool = ((JSONObject)localObject).optBoolean("ignoreVideoPreview", true);
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_can_select_video_and_pic", true);
    ((Intent)localObject).putExtra("key_send_raw_image", false);
    ((MMActivity)paramContext).mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, final Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(83057);
        String str;
        Object localObject;
        if (paramAnonymousInt1 == f.sXd)
        {
          if (paramAnonymousInt2 != -1) {
            break label278;
          }
          str = paramAnonymousIntent.getStringExtra("key_video_info");
          if (bs.isNullOrNil(str)) {
            break label146;
          }
          ac.i("MicroMsg.JsApiChooseHaowanMedia", "video, result: %s", new Object[] { str });
          localObject = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject).put("type", 2);
          ((JSONObject)localObject).put("localIds", str);
          ((JSONObject)localObject).put("appId", paramAnonymousIntent.getStringExtra("key_game_video_appid"));
          ((JSONObject)localObject).put("appName", paramAnonymousIntent.getStringExtra("key_game_video_appname"));
          ((JSONObject)localObject).put("transInfo", paramAnonymousIntent.getStringExtra("key_game_trans_info"));
          label119:
          parama.f(null, (JSONObject)localObject);
          for (;;)
          {
            ((MMActivity)paramContext).mmSetOnActivityResultCallback(null);
            AppMethodBeat.o(83057);
            return;
            label146:
            localObject = paramAnonymousIntent.getStringArrayListExtra("CropImage_OutputPath_List");
            if (!bs.gY((List)localObject))
            {
              f.a(f.this, paramContext);
              h.JZN.aS(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(83056);
                  ap.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(83055);
                      if (f.a(f.this) != null) {
                        f.a(f.this).dismiss();
                      }
                      JSONObject localJSONObject = new JSONObject();
                      try
                      {
                        localJSONObject.put("type", 1);
                        localJSONObject.put("localIds", this.sXh);
                        localJSONObject.put("appId", f.1.1.this.val$data.getStringExtra("key_game_video_appid"));
                        localJSONObject.put("appName", f.1.1.this.val$data.getStringExtra("key_game_video_appname"));
                        label102:
                        f.1.this.oKM.f(null, localJSONObject);
                        AppMethodBeat.o(83055);
                        return;
                      }
                      catch (JSONException localJSONException)
                      {
                        break label102;
                      }
                    }
                  });
                  AppMethodBeat.o(83056);
                }
              });
              continue;
            }
            if (paramAnonymousIntent.getBooleanExtra("key_game_haowan_text", false)) {
              localObject = new JSONObject();
            }
            try
            {
              ((JSONObject)localObject).put("type", 3);
              ((JSONObject)localObject).put("appId", paramAnonymousIntent.getStringExtra("key_game_video_appid"));
              ((JSONObject)localObject).put("appName", paramAnonymousIntent.getStringExtra("key_game_video_appname"));
              label252:
              parama.f(null, (JSONObject)localObject);
              continue;
              parama.f("cancel", null);
              continue;
              label278:
              parama.f("cancel", null);
            }
            catch (JSONException paramAnonymousIntent)
            {
              break label252;
            }
          }
        }
        catch (JSONException paramAnonymousIntent)
        {
          break label119;
        }
      }
    });
    ((Intent)localObject).putExtra("max_select_count", j);
    ((Intent)localObject).putExtra("query_source_type", 15);
    ((Intent)localObject).putExtra("query_media_type", i);
    ((Intent)localObject).putExtra("show_header_view", false);
    ((Intent)localObject).addFlags(67108864);
    if (paramString != null) {
      ((Intent)localObject).putExtra("game_haowan_local_albums_info", paramString.toString());
    }
    ((Intent)localObject).putExtra("game_haowan_ignore_video_preview", bool);
    if (k == 2) {
      d.b(paramContext, "game", ".media.GameTabGalleryUI", (Intent)localObject, sXd);
    }
    for (;;)
    {
      ((Activity)paramContext).overridePendingTransition(MMFragmentActivity.a.mnC, MMFragmentActivity.a.mnD);
      AppMethodBeat.o(83058);
      return;
      if (k != 1) {
        break;
      }
      d.b(paramContext, "game", ".media.GamePublishGalleryUI", (Intent)localObject, sXd);
    }
    parama.f("galleryType is invalid", null);
    AppMethodBeat.o(83058);
  }
  
  public final void b(com.tencent.luggage.d.a<com.tencent.mm.plugin.game.luggage.d.f>.a parama) {}
  
  public final int bYk()
  {
    return 2;
  }
  
  public final String name()
  {
    return "chooseHaowanMedia";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.f
 * JD-Core Version:    0.7.0.1
 */