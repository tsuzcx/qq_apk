package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
  extends c
{
  private static final int CTRL_INDEX = 361;
  public static final String NAME = "updateLivePusher";
  
  private static Bundle x(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    try
    {
      if (paramJSONObject.has("pushUrl"))
      {
        localBundle.putString("pushUrl", paramJSONObject.getString("pushUrl"));
        y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "convertParams pushUrl:%s", new Object[] { paramJSONObject.getString("pushUrl") });
      }
    }
    catch (JSONException localJSONException18)
    {
      try
      {
        if (paramJSONObject.has("mode")) {
          localBundle.putInt("mode", paramJSONObject.getInt("mode"));
        }
      }
      catch (JSONException localJSONException18)
      {
        try
        {
          if (paramJSONObject.has("autopush")) {
            localBundle.putBoolean("autopush", paramJSONObject.getBoolean("autopush"));
          }
        }
        catch (JSONException localJSONException18)
        {
          try
          {
            if (paramJSONObject.has("audioQuality")) {
              localBundle.putString("audioQuality", paramJSONObject.getString("audioQuality"));
            }
          }
          catch (JSONException localJSONException18)
          {
            try
            {
              if (paramJSONObject.has("muted")) {
                localBundle.putBoolean("muted", paramJSONObject.getBoolean("muted"));
              }
            }
            catch (JSONException localJSONException18)
            {
              try
              {
                if (paramJSONObject.has("enableCamera")) {
                  localBundle.putBoolean("enableCamera", paramJSONObject.getBoolean("enableCamera"));
                }
              }
              catch (JSONException localJSONException18)
              {
                try
                {
                  if (paramJSONObject.has("focusMode")) {
                    localBundle.putInt("focusMode", paramJSONObject.getInt("focusMode"));
                  }
                }
                catch (JSONException localJSONException18)
                {
                  try
                  {
                    if (paramJSONObject.has("orientation")) {
                      localBundle.putString("orientation", paramJSONObject.getString("orientation"));
                    }
                  }
                  catch (JSONException localJSONException18)
                  {
                    try
                    {
                      if (paramJSONObject.has("beauty")) {
                        localBundle.putInt("beauty", paramJSONObject.getInt("beauty"));
                      }
                    }
                    catch (JSONException localJSONException18)
                    {
                      try
                      {
                        if (paramJSONObject.has("whiteness")) {
                          localBundle.putInt("whiteness", paramJSONObject.getInt("whiteness"));
                        }
                      }
                      catch (JSONException localJSONException18)
                      {
                        try
                        {
                          if (paramJSONObject.has("aspect")) {
                            localBundle.putInt("aspect", paramJSONObject.getInt("aspect"));
                          }
                        }
                        catch (JSONException localJSONException18)
                        {
                          try
                          {
                            if (paramJSONObject.has("minBitrate")) {
                              localBundle.putInt("minBitrate", paramJSONObject.getInt("minBitrate"));
                            }
                          }
                          catch (JSONException localJSONException18)
                          {
                            try
                            {
                              if (paramJSONObject.has("maxBitrate")) {
                                localBundle.putInt("maxBitrate", paramJSONObject.getInt("maxBitrate"));
                              }
                            }
                            catch (JSONException localJSONException18)
                            {
                              try
                              {
                                if (paramJSONObject.has("needEvent")) {
                                  localBundle.putBoolean("needEvent", paramJSONObject.getBoolean("needEvent"));
                                }
                              }
                              catch (JSONException localJSONException18)
                              {
                                try
                                {
                                  if (paramJSONObject.has("debug")) {
                                    localBundle.putBoolean("debug", paramJSONObject.getBoolean("debug"));
                                  }
                                }
                                catch (JSONException localJSONException18)
                                {
                                  try
                                  {
                                    if (paramJSONObject.has("watermarkLeft")) {
                                      localBundle.putFloat("watermarkLeft", BigDecimal.valueOf(paramJSONObject.getDouble("watermarkLeft")).floatValue());
                                    }
                                  }
                                  catch (JSONException localJSONException18)
                                  {
                                    try
                                    {
                                      if (paramJSONObject.has("watermarkTop")) {
                                        localBundle.putFloat("watermarkTop", BigDecimal.valueOf(paramJSONObject.getDouble("watermarkTop")).floatValue());
                                      }
                                    }
                                    catch (JSONException localJSONException18)
                                    {
                                      try
                                      {
                                        if (paramJSONObject.has("watermarkWidth")) {
                                          localBundle.putFloat("watermarkWidth", BigDecimal.valueOf(paramJSONObject.getDouble("watermarkWidth")).floatValue());
                                        }
                                      }
                                      catch (JSONException localJSONException18)
                                      {
                                        try
                                        {
                                          for (;;)
                                          {
                                            if (paramJSONObject.has("devicePosition")) {
                                              localBundle.putString("devicePosition", paramJSONObject.getString("devicePosition"));
                                            }
                                            try
                                            {
                                              if (paramJSONObject.has("needBGMEvent")) {
                                                localBundle.putBoolean("needBGMEvent", paramJSONObject.getBoolean("needBGMEvent"));
                                              }
                                              return localBundle;
                                            }
                                            catch (JSONException paramJSONObject)
                                            {
                                              y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "needBGMEvent", paramJSONObject.getLocalizedMessage() });
                                            }
                                            localJSONException1 = localJSONException1;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "pushUrl", localJSONException1.getLocalizedMessage() });
                                            continue;
                                            localJSONException2 = localJSONException2;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "mode", localJSONException2.getLocalizedMessage() });
                                            continue;
                                            localJSONException3 = localJSONException3;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "autopush", localJSONException3.getLocalizedMessage() });
                                            continue;
                                            localJSONException4 = localJSONException4;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "audioQuality", localJSONException4.getLocalizedMessage() });
                                            continue;
                                            localJSONException5 = localJSONException5;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "muted", localJSONException5.getLocalizedMessage() });
                                            continue;
                                            localJSONException6 = localJSONException6;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "enableCamera", localJSONException6.getLocalizedMessage() });
                                            continue;
                                            localJSONException7 = localJSONException7;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "focusMode", localJSONException7.getLocalizedMessage() });
                                            continue;
                                            localJSONException8 = localJSONException8;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "orientation", localJSONException8.getLocalizedMessage() });
                                            continue;
                                            localJSONException9 = localJSONException9;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "beauty", localJSONException9.getLocalizedMessage() });
                                            continue;
                                            localJSONException10 = localJSONException10;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "whiteness", localJSONException10.getLocalizedMessage() });
                                            continue;
                                            localJSONException11 = localJSONException11;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "aspect", localJSONException11.getLocalizedMessage() });
                                            continue;
                                            localJSONException12 = localJSONException12;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "minBitrate", localJSONException12.getLocalizedMessage() });
                                            continue;
                                            localJSONException13 = localJSONException13;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "maxBitrate", localJSONException13.getLocalizedMessage() });
                                            continue;
                                            localJSONException14 = localJSONException14;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "needEvent", localJSONException14.getLocalizedMessage() });
                                            continue;
                                            localJSONException15 = localJSONException15;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "debug", localJSONException15.getLocalizedMessage() });
                                            continue;
                                            localJSONException16 = localJSONException16;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "watermarkLeft", localJSONException16.getLocalizedMessage() });
                                            continue;
                                            localJSONException17 = localJSONException17;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "watermarkTop", localJSONException17.getLocalizedMessage() });
                                            continue;
                                            localJSONException18 = localJSONException18;
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "watermarkWidth", localJSONException18.getLocalizedMessage() });
                                          }
                                        }
                                        catch (JSONException localJSONException19)
                                        {
                                          for (;;)
                                          {
                                            y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "devicePosition", localJSONException19.getLocalizedMessage() });
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
    return localBundle;
  }
  
  protected final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView : livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      y.w("MicroMsg.JsApiUpdateLivePusher.javayhu", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramView = (View)((CoverViewContainer)paramView).K(View.class);
    if (!(paramView instanceof AppBrandLivePusherView))
    {
      y.e("MicroMsg.JsApiUpdateLivePusher.javayhu", "targetView not AppBrandLivePusherView");
      return false;
    }
    paramView = (AppBrandLivePusherView)paramView;
    paramView.u(x(paramJSONObject));
    try
    {
      if (paramJSONObject.has("backgroundImage"))
      {
        str1 = paramJSONObject.getString("backgroundImage");
        str2 = paramJSONObject.optString("backgroundMD5");
        if (!bk.bl(str1)) {
          break label176;
        }
        y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "convertBackgroundImageToLocalPath, url is null");
      }
    }
    catch (JSONException localJSONException)
    {
      try
      {
        String str1;
        String str2;
        if (paramJSONObject.has("watermarkImage"))
        {
          str1 = paramJSONObject.getString("watermarkImage");
          paramJSONObject = paramJSONObject.optString("watermarkMD5");
          if (!bk.bl(str1)) {
            break label227;
          }
          y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "convertWatermarkImageToLocalPath, url is null");
        }
        for (;;)
        {
          return true;
          label176:
          a.a(parame, str1, str2, new i.1(this, paramView, str1));
          break;
          localJSONException = localJSONException;
          y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "backgroundImage", localJSONException.getLocalizedMessage() });
          break;
          label227:
          a.a(parame, localJSONException, paramJSONObject, new i.2(this, paramView));
        }
      }
      catch (JSONException parame)
      {
        for (;;)
        {
          y.i("MicroMsg.JsApiUpdateLivePusher.javayhu", "onUpdateView param=%s exp=%s", new Object[] { "watermarkImage", parame.getLocalizedMessage() });
        }
      }
    }
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("livePusherId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.i
 * JD-Core Version:    0.7.0.1
 */