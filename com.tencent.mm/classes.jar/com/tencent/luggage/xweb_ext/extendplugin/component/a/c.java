package com.tencent.luggage.xweb_ext.extendplugin.component.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public static Bundle g(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139751);
    Bundle localBundle = new Bundle();
    try
    {
      if (paramJSONObject.has("playUrl"))
      {
        localBundle.putString("playUrl", paramJSONObject.getString("playUrl"));
        ab.i("MicroMsg.TXLiveParamUtil", "convertParams playUrl:%s", new Object[] { paramJSONObject.getString("playUrl") });
      }
    }
    catch (JSONException localJSONException13)
    {
      try
      {
        if (paramJSONObject.has("mode")) {
          localBundle.putInt("mode", paramJSONObject.getInt("mode"));
        }
      }
      catch (JSONException localJSONException13)
      {
        try
        {
          if (paramJSONObject.has("autoplay")) {
            localBundle.putBoolean("autoplay", paramJSONObject.getBoolean("autoplay"));
          }
        }
        catch (JSONException localJSONException13)
        {
          try
          {
            if (paramJSONObject.has("muted")) {
              localBundle.putBoolean("muted", paramJSONObject.getBoolean("muted"));
            }
          }
          catch (JSONException localJSONException13)
          {
            try
            {
              if (paramJSONObject.has("orientation")) {
                localBundle.putString("orientation", paramJSONObject.getString("orientation"));
              }
            }
            catch (JSONException localJSONException13)
            {
              try
              {
                if (paramJSONObject.has("objectFit")) {
                  localBundle.putString("objectFit", paramJSONObject.getString("objectFit"));
                }
              }
              catch (JSONException localJSONException13)
              {
                try
                {
                  if (paramJSONObject.has("backgroundMute")) {
                    localBundle.putBoolean("backgroundMute", paramJSONObject.getBoolean("backgroundMute"));
                  }
                }
                catch (JSONException localJSONException13)
                {
                  try
                  {
                    if (paramJSONObject.has("minCache")) {
                      localBundle.putFloat("minCache", BigDecimal.valueOf(paramJSONObject.getDouble("minCache")).floatValue());
                    }
                  }
                  catch (JSONException localJSONException13)
                  {
                    try
                    {
                      if (paramJSONObject.has("maxCache")) {
                        localBundle.putFloat("maxCache", BigDecimal.valueOf(paramJSONObject.getDouble("maxCache")).floatValue());
                      }
                    }
                    catch (JSONException localJSONException13)
                    {
                      try
                      {
                        if (paramJSONObject.has("needEvent")) {
                          localBundle.putBoolean("needEvent", paramJSONObject.getBoolean("needEvent"));
                        }
                      }
                      catch (JSONException localJSONException13)
                      {
                        try
                        {
                          if (paramJSONObject.has("debug")) {
                            localBundle.putBoolean("debug", paramJSONObject.getBoolean("debug"));
                          }
                        }
                        catch (JSONException localJSONException13)
                        {
                          try
                          {
                            if (paramJSONObject.has("soundMode"))
                            {
                              localBundle.putString("soundMode", paramJSONObject.getString("soundMode"));
                              ab.i("MicroMsg.TXLiveParamUtil", "convertParams soundMode:%s", new Object[] { paramJSONObject.getString("soundMode") });
                            }
                          }
                          catch (JSONException localJSONException13)
                          {
                            try
                            {
                              if (paramJSONObject.has("autoPauseIfNavigate")) {
                                localBundle.putBoolean("autoPauseIfNavigate", paramJSONObject.getBoolean("autoPauseIfNavigate"));
                              }
                            }
                            catch (JSONException localJSONException13)
                            {
                              try
                              {
                                for (;;)
                                {
                                  if (paramJSONObject.has("autoPauseIfOpenNative")) {
                                    localBundle.putBoolean("autoPauseIfOpenNative", paramJSONObject.getBoolean("autoPauseIfOpenNative"));
                                  }
                                  AppMethodBeat.o(139751);
                                  return localBundle;
                                  localJSONException1 = localJSONException1;
                                  ab.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "playUrl", localJSONException1.getLocalizedMessage() });
                                  continue;
                                  localJSONException2 = localJSONException2;
                                  ab.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "mode", localJSONException2.getLocalizedMessage() });
                                  continue;
                                  localJSONException3 = localJSONException3;
                                  ab.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "autoplay", localJSONException3.getLocalizedMessage() });
                                  continue;
                                  localJSONException4 = localJSONException4;
                                  ab.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "muted", localJSONException4.getLocalizedMessage() });
                                  continue;
                                  localJSONException5 = localJSONException5;
                                  ab.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "orientation", localJSONException5.getLocalizedMessage() });
                                  continue;
                                  localJSONException6 = localJSONException6;
                                  ab.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "objectFit", localJSONException6.getLocalizedMessage() });
                                  continue;
                                  localJSONException7 = localJSONException7;
                                  ab.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "backgroundMute", localJSONException7.getLocalizedMessage() });
                                  continue;
                                  localJSONException8 = localJSONException8;
                                  ab.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "minCache", localJSONException8.getLocalizedMessage() });
                                  continue;
                                  localJSONException9 = localJSONException9;
                                  ab.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "maxCache", localJSONException9.getLocalizedMessage() });
                                  continue;
                                  localJSONException10 = localJSONException10;
                                  ab.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "needEvent", localJSONException10.getLocalizedMessage() });
                                  continue;
                                  localJSONException11 = localJSONException11;
                                  ab.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "debug", localJSONException11.getLocalizedMessage() });
                                  continue;
                                  localJSONException12 = localJSONException12;
                                  ab.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "soundMode", localJSONException12.getLocalizedMessage() });
                                  continue;
                                  localJSONException13 = localJSONException13;
                                  ab.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "autoPauseIfNavigate", localJSONException13.getLocalizedMessage() });
                                }
                              }
                              catch (JSONException paramJSONObject)
                              {
                                for (;;)
                                {
                                  ab.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "autoPauseIfOpenNative", paramJSONObject.getLocalizedMessage() });
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
  
  public static Bundle h(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139752);
    Bundle localBundle = new Bundle();
    try
    {
      if (paramJSONObject.has("pushUrl"))
      {
        localBundle.putString("pushUrl", paramJSONObject.getString("pushUrl"));
        ab.i("MicroMsg.TXLiveParamUtil", "convertParams pushUrl:%s", new Object[] { paramJSONObject.getString("pushUrl") });
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
                                                AppMethodBeat.o(139752);
                                                return localBundle;
                                                localJSONException1 = localJSONException1;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "pushUrl", localJSONException1.getLocalizedMessage() });
                                                continue;
                                                localJSONException2 = localJSONException2;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "mode", localJSONException2.getLocalizedMessage() });
                                                continue;
                                                localJSONException3 = localJSONException3;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "autopush", localJSONException3.getLocalizedMessage() });
                                                continue;
                                                localJSONException4 = localJSONException4;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "audioQuality", localJSONException4.getLocalizedMessage() });
                                                continue;
                                                localJSONException5 = localJSONException5;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "muted", localJSONException5.getLocalizedMessage() });
                                                continue;
                                                localJSONException6 = localJSONException6;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "enableCamera", localJSONException6.getLocalizedMessage() });
                                                continue;
                                                localJSONException7 = localJSONException7;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "focusMode", localJSONException7.getLocalizedMessage() });
                                                continue;
                                                localJSONException8 = localJSONException8;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "orientation", localJSONException8.getLocalizedMessage() });
                                                continue;
                                                localJSONException9 = localJSONException9;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "beauty", localJSONException9.getLocalizedMessage() });
                                                continue;
                                                localJSONException10 = localJSONException10;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "whiteness", localJSONException10.getLocalizedMessage() });
                                                continue;
                                                localJSONException11 = localJSONException11;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "aspect", localJSONException11.getLocalizedMessage() });
                                                continue;
                                                localJSONException12 = localJSONException12;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "minBitrate", localJSONException12.getLocalizedMessage() });
                                                continue;
                                                localJSONException13 = localJSONException13;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "maxBitrate", localJSONException13.getLocalizedMessage() });
                                                continue;
                                                localJSONException14 = localJSONException14;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "needEvent", localJSONException14.getLocalizedMessage() });
                                                continue;
                                                localJSONException15 = localJSONException15;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "debug", localJSONException15.getLocalizedMessage() });
                                                continue;
                                                localJSONException16 = localJSONException16;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "mirror", localJSONException16.getLocalizedMessage() });
                                                continue;
                                                localJSONException17 = localJSONException17;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "watermarkLeft", localJSONException17.getLocalizedMessage() });
                                                continue;
                                                localJSONException18 = localJSONException18;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "watermarkTop", localJSONException18.getLocalizedMessage() });
                                                continue;
                                                localJSONException19 = localJSONException19;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "watermarkWidth", localJSONException19.getLocalizedMessage() });
                                                continue;
                                                localJSONException20 = localJSONException20;
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "devicePosition", localJSONException20.getLocalizedMessage() });
                                              }
                                            }
                                            catch (JSONException paramJSONObject)
                                            {
                                              for (;;)
                                              {
                                                ab.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "needBGMEvent", paramJSONObject.getLocalizedMessage() });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.c
 * JD-Core Version:    0.7.0.1
 */