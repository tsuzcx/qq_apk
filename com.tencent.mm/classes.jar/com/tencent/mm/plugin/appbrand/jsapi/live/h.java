package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.t.b;
import com.tencent.mm.plugin.appbrand.t.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigDecimal;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  extends c
{
  private static final int CTRL_INDEX = 361;
  public static final String NAME = "updateLivePusher";
  
  private static Bundle F(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96127);
    Bundle localBundle = new Bundle();
    try
    {
      if (paramJSONObject.has("pushUrl"))
      {
        localBundle.putString("pushUrl", paramJSONObject.getString("pushUrl"));
        ab.i("MicroMsg.JsApiUpdateLivePusher", "convertParams pushUrl:%s", new Object[] { paramJSONObject.getString("pushUrl") });
      }
    }
    catch (JSONException localJSONException20)
    {
      try
      {
        if (paramJSONObject.has("mode")) {
          localBundle.putInt("mode", paramJSONObject.getInt("mode"));
        }
      }
      catch (JSONException localJSONException20)
      {
        try
        {
          if (paramJSONObject.has("autopush")) {
            localBundle.putBoolean("autopush", paramJSONObject.getBoolean("autopush"));
          }
        }
        catch (JSONException localJSONException20)
        {
          try
          {
            if (paramJSONObject.has("audioQuality")) {
              localBundle.putString("audioQuality", paramJSONObject.getString("audioQuality"));
            }
          }
          catch (JSONException localJSONException20)
          {
            try
            {
              if (paramJSONObject.has("muted")) {
                localBundle.putBoolean("muted", paramJSONObject.getBoolean("muted"));
              }
            }
            catch (JSONException localJSONException20)
            {
              try
              {
                if (paramJSONObject.has("enableCamera")) {
                  localBundle.putBoolean("enableCamera", paramJSONObject.getBoolean("enableCamera"));
                }
              }
              catch (JSONException localJSONException20)
              {
                try
                {
                  if (paramJSONObject.has("focusMode")) {
                    localBundle.putInt("focusMode", paramJSONObject.getInt("focusMode"));
                  }
                }
                catch (JSONException localJSONException20)
                {
                  try
                  {
                    if (paramJSONObject.has("orientation")) {
                      localBundle.putString("orientation", paramJSONObject.getString("orientation"));
                    }
                  }
                  catch (JSONException localJSONException20)
                  {
                    try
                    {
                      if (paramJSONObject.has("beauty")) {
                        localBundle.putInt("beauty", paramJSONObject.getInt("beauty"));
                      }
                    }
                    catch (JSONException localJSONException20)
                    {
                      try
                      {
                        if (paramJSONObject.has("whiteness")) {
                          localBundle.putInt("whiteness", paramJSONObject.getInt("whiteness"));
                        }
                      }
                      catch (JSONException localJSONException20)
                      {
                        try
                        {
                          if (paramJSONObject.has("aspect")) {
                            localBundle.putInt("aspect", paramJSONObject.getInt("aspect"));
                          }
                        }
                        catch (JSONException localJSONException20)
                        {
                          try
                          {
                            if (paramJSONObject.has("minBitrate")) {
                              localBundle.putInt("minBitrate", paramJSONObject.getInt("minBitrate"));
                            }
                          }
                          catch (JSONException localJSONException20)
                          {
                            try
                            {
                              if (paramJSONObject.has("maxBitrate")) {
                                localBundle.putInt("maxBitrate", paramJSONObject.getInt("maxBitrate"));
                              }
                            }
                            catch (JSONException localJSONException20)
                            {
                              try
                              {
                                if (paramJSONObject.has("needEvent")) {
                                  localBundle.putBoolean("needEvent", paramJSONObject.getBoolean("needEvent"));
                                }
                              }
                              catch (JSONException localJSONException20)
                              {
                                try
                                {
                                  if (paramJSONObject.has("debug")) {
                                    localBundle.putBoolean("debug", paramJSONObject.getBoolean("debug"));
                                  }
                                }
                                catch (JSONException localJSONException20)
                                {
                                  try
                                  {
                                    if (paramJSONObject.has("mirror")) {
                                      localBundle.putBoolean("mirror", paramJSONObject.getBoolean("mirror"));
                                    }
                                  }
                                  catch (JSONException localJSONException20)
                                  {
                                    try
                                    {
                                      if (paramJSONObject.has("watermarkLeft")) {
                                        localBundle.putFloat("watermarkLeft", BigDecimal.valueOf(paramJSONObject.getDouble("watermarkLeft")).floatValue());
                                      }
                                    }
                                    catch (JSONException localJSONException20)
                                    {
                                      try
                                      {
                                        if (paramJSONObject.has("watermarkTop")) {
                                          localBundle.putFloat("watermarkTop", BigDecimal.valueOf(paramJSONObject.getDouble("watermarkTop")).floatValue());
                                        }
                                      }
                                      catch (JSONException localJSONException20)
                                      {
                                        try
                                        {
                                          if (paramJSONObject.has("watermarkWidth")) {
                                            localBundle.putFloat("watermarkWidth", BigDecimal.valueOf(paramJSONObject.getDouble("watermarkWidth")).floatValue());
                                          }
                                        }
                                        catch (JSONException localJSONException20)
                                        {
                                          try
                                          {
                                            if (paramJSONObject.has("devicePosition")) {
                                              localBundle.putString("devicePosition", paramJSONObject.getString("devicePosition"));
                                            }
                                          }
                                          catch (JSONException localJSONException20)
                                          {
                                            try
                                            {
                                              for (;;)
                                              {
                                                if (paramJSONObject.has("needBGMEvent")) {
                                                  localBundle.putBoolean("needBGMEvent", paramJSONObject.getBoolean("needBGMEvent"));
                                                }
                                                AppMethodBeat.o(96127);
                                                return localBundle;
                                                localJSONException1 = localJSONException1;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "pushUrl", localJSONException1.getLocalizedMessage() });
                                                continue;
                                                localJSONException2 = localJSONException2;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "mode", localJSONException2.getLocalizedMessage() });
                                                continue;
                                                localJSONException3 = localJSONException3;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "autopush", localJSONException3.getLocalizedMessage() });
                                                continue;
                                                localJSONException4 = localJSONException4;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "audioQuality", localJSONException4.getLocalizedMessage() });
                                                continue;
                                                localJSONException5 = localJSONException5;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "muted", localJSONException5.getLocalizedMessage() });
                                                continue;
                                                localJSONException6 = localJSONException6;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "enableCamera", localJSONException6.getLocalizedMessage() });
                                                continue;
                                                localJSONException7 = localJSONException7;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "focusMode", localJSONException7.getLocalizedMessage() });
                                                continue;
                                                localJSONException8 = localJSONException8;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "orientation", localJSONException8.getLocalizedMessage() });
                                                continue;
                                                localJSONException9 = localJSONException9;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "beauty", localJSONException9.getLocalizedMessage() });
                                                continue;
                                                localJSONException10 = localJSONException10;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "whiteness", localJSONException10.getLocalizedMessage() });
                                                continue;
                                                localJSONException11 = localJSONException11;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "aspect", localJSONException11.getLocalizedMessage() });
                                                continue;
                                                localJSONException12 = localJSONException12;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "minBitrate", localJSONException12.getLocalizedMessage() });
                                                continue;
                                                localJSONException13 = localJSONException13;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "maxBitrate", localJSONException13.getLocalizedMessage() });
                                                continue;
                                                localJSONException14 = localJSONException14;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "needEvent", localJSONException14.getLocalizedMessage() });
                                                continue;
                                                localJSONException15 = localJSONException15;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "debug", localJSONException15.getLocalizedMessage() });
                                                continue;
                                                localJSONException16 = localJSONException16;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "mirror", localJSONException16.getLocalizedMessage() });
                                                continue;
                                                localJSONException17 = localJSONException17;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "watermarkLeft", localJSONException17.getLocalizedMessage() });
                                                continue;
                                                localJSONException18 = localJSONException18;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "watermarkTop", localJSONException18.getLocalizedMessage() });
                                                continue;
                                                localJSONException19 = localJSONException19;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "watermarkWidth", localJSONException19.getLocalizedMessage() });
                                                continue;
                                                localJSONException20 = localJSONException20;
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "devicePosition", localJSONException20.getLocalizedMessage() });
                                              }
                                            }
                                            catch (JSONException paramJSONObject)
                                            {
                                              for (;;)
                                              {
                                                ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "needBGMEvent", paramJSONObject.getLocalizedMessage() });
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final boolean c(e parame, int paramInt, final View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96126);
    ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView : livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ab.w("MicroMsg.JsApiUpdateLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(96126);
      return false;
    }
    paramView = (View)((CoverViewContainer)paramView).aa(View.class);
    if (!(paramView instanceof AppBrandLivePusherView))
    {
      ab.e("MicroMsg.JsApiUpdateLivePusher", "targetView not AppBrandLivePusherView");
      AppMethodBeat.o(96126);
      return false;
    }
    paramView = (AppBrandLivePusherView)paramView;
    paramView.D(F(paramJSONObject));
    try
    {
      if (paramJSONObject.has("backgroundImage"))
      {
        str1 = paramJSONObject.getString("backgroundImage");
        str2 = paramJSONObject.optString("backgroundMD5");
        if (!bo.isNullOrNil(str1)) {
          break label196;
        }
        ab.i("MicroMsg.JsApiUpdateLivePusher", "convertBackgroundImageToLocalPath, url is null");
      }
    }
    catch (JSONException localJSONException)
    {
      try
      {
        final String str1;
        String str2;
        if (paramJSONObject.has("watermarkImage"))
        {
          str1 = paramJSONObject.getString("watermarkImage");
          paramJSONObject = paramJSONObject.optString("watermarkMD5");
          if (!bo.isNullOrNil(str1)) {
            break label247;
          }
          ab.i("MicroMsg.JsApiUpdateLivePusher", "convertWatermarkImageToLocalPath, url is null");
        }
        for (;;)
        {
          AppMethodBeat.o(96126);
          return true;
          label196:
          b.a(parame, str1, str2, new b.a()
          {
            public final void BO(String paramAnonymousString)
            {
              AppMethodBeat.i(96123);
              if (!bo.isNullOrNil(paramAnonymousString))
              {
                ab.i("MicroMsg.JsApiUpdateLivePusher", "convertBackgroundImageToLocalPath, localPath:%s", new Object[] { paramAnonymousString });
                Bundle localBundle = new Bundle();
                localBundle.putString("backgroundImage", paramAnonymousString);
                paramView.D(localBundle);
                AppMethodBeat.o(96123);
                return;
              }
              ab.i("MicroMsg.JsApiUpdateLivePusher", "convertBackgroundImageToLocalPath, load background image fail");
              paramAnonymousString = new HashMap();
              paramAnonymousString.put("url", str1);
              paramView.a(10004, "load background image fail", paramAnonymousString);
              AppMethodBeat.o(96123);
            }
          });
          break;
          localJSONException = localJSONException;
          ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "backgroundImage", localJSONException.getLocalizedMessage() });
          break;
          label247:
          b.a(parame, localJSONException, paramJSONObject, new h.2(this, paramView));
        }
      }
      catch (JSONException parame)
      {
        for (;;)
        {
          ab.i("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "watermarkImage", parame.getLocalizedMessage() });
        }
      }
    }
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96125);
    int i = paramJSONObject.optInt("livePusherId");
    AppMethodBeat.o(96125);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.h
 * JD-Core Version:    0.7.0.1
 */