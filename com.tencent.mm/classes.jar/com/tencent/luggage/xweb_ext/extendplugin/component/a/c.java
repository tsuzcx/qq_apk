package com.tencent.luggage.xweb_ext.extendplugin.component.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public static Bundle g(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138811);
    StringBuilder localStringBuilder = new StringBuilder("LivePlayer params:");
    Object localObject;
    if (paramJSONObject != null) {
      localObject = paramJSONObject.toString();
    }
    for (;;)
    {
      localStringBuilder.append((String)localObject);
      localObject = new Bundle();
      try
      {
        if (paramJSONObject.has("playUrl")) {
          ((Bundle)localObject).putString("playUrl", paramJSONObject.getString("playUrl"));
        }
      }
      catch (JSONException localJSONException19)
      {
        try
        {
          if (paramJSONObject.has("mode")) {
            ((Bundle)localObject).putInt("mode", paramJSONObject.getInt("mode"));
          }
        }
        catch (JSONException localJSONException19)
        {
          try
          {
            if (paramJSONObject.has("autoplay")) {
              ((Bundle)localObject).putBoolean("autoplay", paramJSONObject.getBoolean("autoplay"));
            }
          }
          catch (JSONException localJSONException19)
          {
            try
            {
              if (paramJSONObject.has("muted")) {
                ((Bundle)localObject).putBoolean("muted", paramJSONObject.getBoolean("muted"));
              }
            }
            catch (JSONException localJSONException19)
            {
              try
              {
                if (paramJSONObject.has("muteAudio")) {
                  ((Bundle)localObject).putBoolean("muteAudio", paramJSONObject.getBoolean("muteAudio"));
                }
              }
              catch (JSONException localJSONException19)
              {
                try
                {
                  if (paramJSONObject.has("muteVideo")) {
                    ((Bundle)localObject).putBoolean("muteVideo", paramJSONObject.getBoolean("muteVideo"));
                  }
                }
                catch (JSONException localJSONException19)
                {
                  try
                  {
                    if (paramJSONObject.has("orientation")) {
                      ((Bundle)localObject).putString("orientation", paramJSONObject.getString("orientation"));
                    }
                  }
                  catch (JSONException localJSONException19)
                  {
                    try
                    {
                      if (paramJSONObject.has("objectFit")) {
                        ((Bundle)localObject).putString("objectFit", paramJSONObject.getString("objectFit"));
                      }
                    }
                    catch (JSONException localJSONException19)
                    {
                      try
                      {
                        if (paramJSONObject.has("backgroundMute")) {
                          ((Bundle)localObject).putBoolean("backgroundMute", paramJSONObject.getBoolean("backgroundMute"));
                        }
                      }
                      catch (JSONException localJSONException19)
                      {
                        try
                        {
                          if (paramJSONObject.has("minCache")) {
                            ((Bundle)localObject).putFloat("minCache", BigDecimal.valueOf(paramJSONObject.getDouble("minCache")).floatValue());
                          }
                        }
                        catch (JSONException localJSONException19)
                        {
                          try
                          {
                            if (paramJSONObject.has("maxCache")) {
                              ((Bundle)localObject).putFloat("maxCache", BigDecimal.valueOf(paramJSONObject.getDouble("maxCache")).floatValue());
                            }
                          }
                          catch (JSONException localJSONException19)
                          {
                            try
                            {
                              if (paramJSONObject.has("enableRecvMessage")) {
                                ((Bundle)localObject).putBoolean("enableRecvMessage", paramJSONObject.getBoolean("enableRecvMessage"));
                              }
                            }
                            catch (JSONException localJSONException19)
                            {
                              try
                              {
                                if (paramJSONObject.has("needEvent")) {
                                  ((Bundle)localObject).putBoolean("needEvent", paramJSONObject.getBoolean("needEvent"));
                                }
                              }
                              catch (JSONException localJSONException19)
                              {
                                try
                                {
                                  if (paramJSONObject.has("needAudioVolume")) {
                                    ((Bundle)localObject).putBoolean("needAudioVolume", paramJSONObject.getBoolean("needAudioVolume"));
                                  }
                                }
                                catch (JSONException localJSONException19)
                                {
                                  try
                                  {
                                    if (paramJSONObject.has("debug")) {
                                      ((Bundle)localObject).putBoolean("debug", paramJSONObject.getBoolean("debug"));
                                    }
                                  }
                                  catch (JSONException localJSONException19)
                                  {
                                    try
                                    {
                                      if (paramJSONObject.has("soundMode")) {
                                        ((Bundle)localObject).putString("soundMode", paramJSONObject.getString("soundMode"));
                                      }
                                    }
                                    catch (JSONException localJSONException19)
                                    {
                                      try
                                      {
                                        if (paramJSONObject.has("autoPauseIfNavigate")) {
                                          ((Bundle)localObject).putBoolean("autoPauseIfNavigate", paramJSONObject.getBoolean("autoPauseIfNavigate"));
                                        }
                                      }
                                      catch (JSONException localJSONException19)
                                      {
                                        try
                                        {
                                          if (paramJSONObject.has("autoPauseIfOpenNative")) {
                                            ((Bundle)localObject).putBoolean("autoPauseIfOpenNative", paramJSONObject.getBoolean("autoPauseIfOpenNative"));
                                          }
                                        }
                                        catch (JSONException localJSONException19)
                                        {
                                          try
                                          {
                                            if (paramJSONObject.has("referrer")) {
                                              ((Bundle)localObject).putString("referrer", paramJSONObject.getString("referrer"));
                                            }
                                          }
                                          catch (JSONException localJSONException19)
                                          {
                                            try
                                            {
                                              for (;;)
                                              {
                                                if (paramJSONObject.has("canStartPlay")) {
                                                  ((Bundle)localObject).putBoolean("canStartPlay", paramJSONObject.getBoolean("canStartPlay"));
                                                }
                                                AppMethodBeat.o(138811);
                                                return localObject;
                                                localObject = "";
                                                break;
                                                localJSONException1 = localJSONException1;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "playUrl", localJSONException1.getLocalizedMessage() });
                                                continue;
                                                localJSONException2 = localJSONException2;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "mode", localJSONException2.getLocalizedMessage() });
                                                continue;
                                                localJSONException3 = localJSONException3;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "autoplay", localJSONException3.getLocalizedMessage() });
                                                continue;
                                                localJSONException4 = localJSONException4;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "muted", localJSONException4.getLocalizedMessage() });
                                                continue;
                                                localJSONException5 = localJSONException5;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "muteAudio", localJSONException5.getLocalizedMessage() });
                                                continue;
                                                localJSONException6 = localJSONException6;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "muteVideo", localJSONException6.getLocalizedMessage() });
                                                continue;
                                                localJSONException7 = localJSONException7;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "orientation", localJSONException7.getLocalizedMessage() });
                                                continue;
                                                localJSONException8 = localJSONException8;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "objectFit", localJSONException8.getLocalizedMessage() });
                                                continue;
                                                localJSONException9 = localJSONException9;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "backgroundMute", localJSONException9.getLocalizedMessage() });
                                                continue;
                                                localJSONException10 = localJSONException10;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "minCache", localJSONException10.getLocalizedMessage() });
                                                continue;
                                                localJSONException11 = localJSONException11;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "maxCache", localJSONException11.getLocalizedMessage() });
                                                continue;
                                                localJSONException12 = localJSONException12;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "enableRecvMessage", localJSONException12.getLocalizedMessage() });
                                                continue;
                                                localJSONException13 = localJSONException13;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "needEvent", localJSONException13.getLocalizedMessage() });
                                                continue;
                                                localJSONException14 = localJSONException14;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "needAudioVolume", localJSONException14.getLocalizedMessage() });
                                                continue;
                                                localJSONException15 = localJSONException15;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "debug", localJSONException15.getLocalizedMessage() });
                                                continue;
                                                localJSONException16 = localJSONException16;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "soundMode", localJSONException16.getLocalizedMessage() });
                                                continue;
                                                localJSONException17 = localJSONException17;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "autoPauseIfNavigate", localJSONException17.getLocalizedMessage() });
                                                continue;
                                                localJSONException18 = localJSONException18;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "autoPauseIfOpenNative", localJSONException18.getLocalizedMessage() });
                                                continue;
                                                localJSONException19 = localJSONException19;
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "referrer", localJSONException19.getLocalizedMessage() });
                                              }
                                            }
                                            catch (JSONException paramJSONObject)
                                            {
                                              for (;;)
                                              {
                                                ad.i("MicroMsg.TXLiveParamUtil", "updateLivePlayer param=%s exp=%s", new Object[] { "canStartPlay", paramJSONObject.getLocalizedMessage() });
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
  
  public static Bundle h(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(138812);
    StringBuilder localStringBuilder = new StringBuilder("LivePusher params:");
    Object localObject;
    if (paramJSONObject != null) {
      localObject = paramJSONObject.toString();
    }
    for (;;)
    {
      localStringBuilder.append((String)localObject);
      localObject = new Bundle();
      try
      {
        if (paramJSONObject.has("pushUrl")) {
          ((Bundle)localObject).putString("pushUrl", paramJSONObject.getString("pushUrl"));
        }
      }
      catch (JSONException localJSONException36)
      {
        try
        {
          if (paramJSONObject.has("mode")) {
            ((Bundle)localObject).putInt("mode", paramJSONObject.getInt("mode"));
          }
        }
        catch (JSONException localJSONException36)
        {
          try
          {
            if (paramJSONObject.has("autopush")) {
              ((Bundle)localObject).putBoolean("autopush", paramJSONObject.getBoolean("autopush"));
            }
          }
          catch (JSONException localJSONException36)
          {
            try
            {
              if (paramJSONObject.has("audioQuality")) {
                ((Bundle)localObject).putString("audioQuality", paramJSONObject.getString("audioQuality"));
              }
            }
            catch (JSONException localJSONException36)
            {
              try
              {
                if (paramJSONObject.has("muted")) {
                  ((Bundle)localObject).putBoolean("muted", paramJSONObject.getBoolean("muted"));
                }
              }
              catch (JSONException localJSONException36)
              {
                try
                {
                  if (paramJSONObject.has("enableCamera")) {
                    ((Bundle)localObject).putBoolean("enableCamera", paramJSONObject.getBoolean("enableCamera"));
                  }
                }
                catch (JSONException localJSONException36)
                {
                  try
                  {
                    if (paramJSONObject.has("enableMic")) {
                      ((Bundle)localObject).putBoolean("enableMic", paramJSONObject.getBoolean("enableMic"));
                    }
                  }
                  catch (JSONException localJSONException36)
                  {
                    try
                    {
                      if (paramJSONObject.has("enableAGC")) {
                        ((Bundle)localObject).putBoolean("enableAGC", paramJSONObject.getBoolean("enableAGC"));
                      }
                    }
                    catch (JSONException localJSONException36)
                    {
                      try
                      {
                        if (paramJSONObject.has("enableANS")) {
                          ((Bundle)localObject).putBoolean("enableANS", paramJSONObject.getBoolean("enableANS"));
                        }
                      }
                      catch (JSONException localJSONException36)
                      {
                        try
                        {
                          if (paramJSONObject.has("enableEarMonitor")) {
                            ((Bundle)localObject).putBoolean("enableEarMonitor", paramJSONObject.getBoolean("enableEarMonitor"));
                          }
                        }
                        catch (JSONException localJSONException36)
                        {
                          try
                          {
                            if (paramJSONObject.has("audioVolumeType")) {
                              ((Bundle)localObject).putString("audioVolumeType", paramJSONObject.getString("audioVolumeType"));
                            }
                          }
                          catch (JSONException localJSONException36)
                          {
                            try
                            {
                              if (paramJSONObject.has("audioReverbType")) {
                                ((Bundle)localObject).putInt("audioReverbType", paramJSONObject.getInt("audioReverbType"));
                              }
                            }
                            catch (JSONException localJSONException36)
                            {
                              try
                              {
                                if (paramJSONObject.has("videoWidth")) {
                                  ((Bundle)localObject).putInt("videoWidth", paramJSONObject.getInt("videoWidth"));
                                }
                              }
                              catch (JSONException localJSONException36)
                              {
                                try
                                {
                                  if (paramJSONObject.has("videoHeight")) {
                                    ((Bundle)localObject).putInt("videoHeight", paramJSONObject.getInt("videoHeight"));
                                  }
                                }
                                catch (JSONException localJSONException36)
                                {
                                  try
                                  {
                                    if (paramJSONObject.has("focusMode")) {
                                      ((Bundle)localObject).putInt("focusMode", paramJSONObject.getInt("focusMode"));
                                    }
                                  }
                                  catch (JSONException localJSONException36)
                                  {
                                    try
                                    {
                                      if (paramJSONObject.has("orientation")) {
                                        ((Bundle)localObject).putString("orientation", paramJSONObject.getString("orientation"));
                                      }
                                    }
                                    catch (JSONException localJSONException36)
                                    {
                                      try
                                      {
                                        if (paramJSONObject.has("beauty")) {
                                          ((Bundle)localObject).putInt("beauty", paramJSONObject.getInt("beauty"));
                                        }
                                      }
                                      catch (JSONException localJSONException36)
                                      {
                                        try
                                        {
                                          if (paramJSONObject.has("beautyStyle")) {
                                            ((Bundle)localObject).putString("beautyStyle", paramJSONObject.getString("beautyStyle"));
                                          }
                                        }
                                        catch (JSONException localJSONException36)
                                        {
                                          try
                                          {
                                            if (paramJSONObject.has("filterImage")) {
                                              ((Bundle)localObject).putString("filterImage", paramJSONObject.getString("filterImage"));
                                            }
                                          }
                                          catch (JSONException localJSONException36)
                                          {
                                            try
                                            {
                                              if (paramJSONObject.has("filterImageMd5")) {
                                                ((Bundle)localObject).putString("filterImageMd5", paramJSONObject.getString("filterImageMd5"));
                                              }
                                            }
                                            catch (JSONException localJSONException36)
                                            {
                                              try
                                              {
                                                if (paramJSONObject.has("whiteness")) {
                                                  ((Bundle)localObject).putInt("whiteness", paramJSONObject.getInt("whiteness"));
                                                }
                                              }
                                              catch (JSONException localJSONException36)
                                              {
                                                try
                                                {
                                                  if (paramJSONObject.has("aspect")) {
                                                    ((Bundle)localObject).putInt("aspect", paramJSONObject.getInt("aspect"));
                                                  }
                                                }
                                                catch (JSONException localJSONException36)
                                                {
                                                  try
                                                  {
                                                    if (paramJSONObject.has("minBitrate")) {
                                                      ((Bundle)localObject).putInt("minBitrate", paramJSONObject.getInt("minBitrate"));
                                                    }
                                                  }
                                                  catch (JSONException localJSONException36)
                                                  {
                                                    try
                                                    {
                                                      if (paramJSONObject.has("maxBitrate")) {
                                                        ((Bundle)localObject).putInt("maxBitrate", paramJSONObject.getInt("maxBitrate"));
                                                      }
                                                    }
                                                    catch (JSONException localJSONException36)
                                                    {
                                                      try
                                                      {
                                                        if (paramJSONObject.has("backgroundMute")) {
                                                          ((Bundle)localObject).putBoolean("backgroundMute", paramJSONObject.getBoolean("backgroundMute"));
                                                        }
                                                      }
                                                      catch (JSONException localJSONException36)
                                                      {
                                                        try
                                                        {
                                                          if (paramJSONObject.has("zoom")) {
                                                            ((Bundle)localObject).putBoolean("zoom", paramJSONObject.getBoolean("zoom"));
                                                          }
                                                        }
                                                        catch (JSONException localJSONException36)
                                                        {
                                                          try
                                                          {
                                                            if (paramJSONObject.has("needEvent")) {
                                                              ((Bundle)localObject).putBoolean("needEvent", paramJSONObject.getBoolean("needEvent"));
                                                            }
                                                          }
                                                          catch (JSONException localJSONException36)
                                                          {
                                                            try
                                                            {
                                                              if (paramJSONObject.has("debug")) {
                                                                ((Bundle)localObject).putBoolean("debug", paramJSONObject.getBoolean("debug"));
                                                              }
                                                            }
                                                            catch (JSONException localJSONException36)
                                                            {
                                                              try
                                                              {
                                                                if (paramJSONObject.has("mirror")) {
                                                                  ((Bundle)localObject).putBoolean("mirror", paramJSONObject.getBoolean("mirror"));
                                                                }
                                                              }
                                                              catch (JSONException localJSONException36)
                                                              {
                                                                try
                                                                {
                                                                  if (paramJSONObject.has("remoteMirror")) {
                                                                    ((Bundle)localObject).putBoolean("remoteMirror", paramJSONObject.getBoolean("remoteMirror"));
                                                                  }
                                                                }
                                                                catch (JSONException localJSONException36)
                                                                {
                                                                  try
                                                                  {
                                                                    if (paramJSONObject.has("localMirror")) {
                                                                      ((Bundle)localObject).putString("localMirror", paramJSONObject.getString("localMirror"));
                                                                    }
                                                                  }
                                                                  catch (JSONException localJSONException36)
                                                                  {
                                                                    try
                                                                    {
                                                                      if (paramJSONObject.has("watermarkLeft")) {
                                                                        ((Bundle)localObject).putFloat("watermarkLeft", BigDecimal.valueOf(paramJSONObject.getDouble("watermarkLeft")).floatValue());
                                                                      }
                                                                    }
                                                                    catch (JSONException localJSONException36)
                                                                    {
                                                                      try
                                                                      {
                                                                        if (paramJSONObject.has("watermarkTop")) {
                                                                          ((Bundle)localObject).putFloat("watermarkTop", BigDecimal.valueOf(paramJSONObject.getDouble("watermarkTop")).floatValue());
                                                                        }
                                                                      }
                                                                      catch (JSONException localJSONException36)
                                                                      {
                                                                        try
                                                                        {
                                                                          if (paramJSONObject.has("watermarkWidth")) {
                                                                            ((Bundle)localObject).putFloat("watermarkWidth", BigDecimal.valueOf(paramJSONObject.getDouble("watermarkWidth")).floatValue());
                                                                          }
                                                                        }
                                                                        catch (JSONException localJSONException36)
                                                                        {
                                                                          try
                                                                          {
                                                                            if (paramJSONObject.has("devicePosition")) {
                                                                              ((Bundle)localObject).putString("devicePosition", paramJSONObject.getString("devicePosition"));
                                                                            }
                                                                          }
                                                                          catch (JSONException localJSONException36)
                                                                          {
                                                                            try
                                                                            {
                                                                              if (paramJSONObject.has("needBGMEvent")) {
                                                                                ((Bundle)localObject).putBoolean("needBGMEvent", paramJSONObject.getBoolean("needBGMEvent"));
                                                                              }
                                                                            }
                                                                            catch (JSONException localJSONException36)
                                                                            {
                                                                              try
                                                                              {
                                                                                for (;;)
                                                                                {
                                                                                  if (paramJSONObject.has("needAudioVolume")) {
                                                                                    ((Bundle)localObject).putBoolean("needAudioVolume", paramJSONObject.getBoolean("needAudioVolume"));
                                                                                  }
                                                                                  AppMethodBeat.o(138812);
                                                                                  return localObject;
                                                                                  localObject = "";
                                                                                  break;
                                                                                  localJSONException1 = localJSONException1;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "pushUrl", localJSONException1.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException2 = localJSONException2;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "mode", localJSONException2.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException3 = localJSONException3;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "autopush", localJSONException3.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException4 = localJSONException4;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "audioQuality", localJSONException4.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException5 = localJSONException5;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "muted", localJSONException5.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException6 = localJSONException6;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "enableCamera", localJSONException6.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException7 = localJSONException7;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "enableMic", localJSONException7.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException8 = localJSONException8;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "enableAGC", localJSONException8.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException9 = localJSONException9;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "enableANS", localJSONException9.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException10 = localJSONException10;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "enableEarMonitor", localJSONException10.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException11 = localJSONException11;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "audioVolumeType", localJSONException11.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException12 = localJSONException12;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "audioReverbType", localJSONException12.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException13 = localJSONException13;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "videoWidth", localJSONException13.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException14 = localJSONException14;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "videoHeight", localJSONException14.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException15 = localJSONException15;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "focusMode", localJSONException15.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException16 = localJSONException16;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "orientation", localJSONException16.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException17 = localJSONException17;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "beauty", localJSONException17.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException18 = localJSONException18;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "beautyStyle", localJSONException18.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException19 = localJSONException19;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "filterImage", localJSONException19.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException20 = localJSONException20;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "filterImageMd5", localJSONException20.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException21 = localJSONException21;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "whiteness", localJSONException21.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException22 = localJSONException22;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "aspect", localJSONException22.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException23 = localJSONException23;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "minBitrate", localJSONException23.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException24 = localJSONException24;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "maxBitrate", localJSONException24.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException25 = localJSONException25;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "backgroundMute", localJSONException25.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException26 = localJSONException26;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "zoom", localJSONException26.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException27 = localJSONException27;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "needEvent", localJSONException27.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException28 = localJSONException28;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "debug", localJSONException28.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException29 = localJSONException29;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "mirror", localJSONException29.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException30 = localJSONException30;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "remoteMirror", localJSONException30.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException31 = localJSONException31;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "localMirror", localJSONException31.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException32 = localJSONException32;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "watermarkLeft", localJSONException32.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException33 = localJSONException33;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "watermarkTop", localJSONException33.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException34 = localJSONException34;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "watermarkWidth", localJSONException34.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException35 = localJSONException35;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "devicePosition", localJSONException35.getLocalizedMessage() });
                                                                                  continue;
                                                                                  localJSONException36 = localJSONException36;
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "needBGMEvent", localJSONException36.getLocalizedMessage() });
                                                                                }
                                                                              }
                                                                              catch (JSONException paramJSONObject)
                                                                              {
                                                                                for (;;)
                                                                                {
                                                                                  ad.i("MicroMsg.TXLiveParamUtil", "updateLivePusher param=%s exp=%s", new Object[] { "needAudioVolume", paramJSONObject.getLocalizedMessage() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.c
 * JD-Core Version:    0.7.0.1
 */