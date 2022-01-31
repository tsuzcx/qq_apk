package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.rtmp.TXLivePlayer;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  extends c
{
  private static final int CTRL_INDEX = 365;
  public static final String NAME = "updateLivePlayer";
  
  private static Bundle x(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    try
    {
      if (paramJSONObject.has("playUrl"))
      {
        localBundle.putString("playUrl", paramJSONObject.getString("playUrl"));
        y.i("MicroMsg.JsApiUpdateLivePlayer", "convertParams playUrl:%s", new Object[] { paramJSONObject.getString("playUrl") });
      }
    }
    catch (JSONException localJSONException10)
    {
      try
      {
        if (paramJSONObject.has("mode")) {
          localBundle.putInt("mode", paramJSONObject.getInt("mode"));
        }
      }
      catch (JSONException localJSONException10)
      {
        try
        {
          if (paramJSONObject.has("autoplay")) {
            localBundle.putBoolean("autoplay", paramJSONObject.getBoolean("autoplay"));
          }
        }
        catch (JSONException localJSONException10)
        {
          try
          {
            if (paramJSONObject.has("muted")) {
              localBundle.putBoolean("muted", paramJSONObject.getBoolean("muted"));
            }
          }
          catch (JSONException localJSONException10)
          {
            try
            {
              if (paramJSONObject.has("orientation")) {
                localBundle.putString("orientation", paramJSONObject.getString("orientation"));
              }
            }
            catch (JSONException localJSONException10)
            {
              try
              {
                if (paramJSONObject.has("objectFit")) {
                  localBundle.putString("objectFit", paramJSONObject.getString("objectFit"));
                }
              }
              catch (JSONException localJSONException10)
              {
                try
                {
                  if (paramJSONObject.has("backgroundMute")) {
                    localBundle.putBoolean("backgroundMute", paramJSONObject.getBoolean("backgroundMute"));
                  }
                }
                catch (JSONException localJSONException10)
                {
                  try
                  {
                    if (paramJSONObject.has("minCache")) {
                      localBundle.putFloat("minCache", BigDecimal.valueOf(paramJSONObject.getDouble("minCache")).floatValue());
                    }
                  }
                  catch (JSONException localJSONException10)
                  {
                    try
                    {
                      if (paramJSONObject.has("maxCache")) {
                        localBundle.putFloat("maxCache", BigDecimal.valueOf(paramJSONObject.getDouble("maxCache")).floatValue());
                      }
                    }
                    catch (JSONException localJSONException10)
                    {
                      try
                      {
                        if (paramJSONObject.has("needEvent")) {
                          localBundle.putBoolean("needEvent", paramJSONObject.getBoolean("needEvent"));
                        }
                      }
                      catch (JSONException localJSONException10)
                      {
                        try
                        {
                          for (;;)
                          {
                            if (paramJSONObject.has("debug")) {
                              localBundle.putBoolean("debug", paramJSONObject.getBoolean("debug"));
                            }
                            try
                            {
                              if (paramJSONObject.has("soundMode"))
                              {
                                localBundle.putString("soundMode", paramJSONObject.getString("soundMode"));
                                y.i("MicroMsg.JsApiUpdateLivePlayer", "convertParams soundMode:%s", new Object[] { paramJSONObject.getString("soundMode") });
                              }
                              return localBundle;
                            }
                            catch (JSONException paramJSONObject)
                            {
                              y.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "soundMode", paramJSONObject.getLocalizedMessage() });
                            }
                            localJSONException1 = localJSONException1;
                            y.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "playUrl", localJSONException1.getLocalizedMessage() });
                            continue;
                            localJSONException2 = localJSONException2;
                            y.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "mode", localJSONException2.getLocalizedMessage() });
                            continue;
                            localJSONException3 = localJSONException3;
                            y.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "autoplay", localJSONException3.getLocalizedMessage() });
                            continue;
                            localJSONException4 = localJSONException4;
                            y.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "muted", localJSONException4.getLocalizedMessage() });
                            continue;
                            localJSONException5 = localJSONException5;
                            y.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "orientation", localJSONException5.getLocalizedMessage() });
                            continue;
                            localJSONException6 = localJSONException6;
                            y.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "objectFit", localJSONException6.getLocalizedMessage() });
                            continue;
                            localJSONException7 = localJSONException7;
                            y.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "backgroundMute", localJSONException7.getLocalizedMessage() });
                            continue;
                            localJSONException8 = localJSONException8;
                            y.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "minCache", localJSONException8.getLocalizedMessage() });
                            continue;
                            localJSONException9 = localJSONException9;
                            y.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "maxCache", localJSONException9.getLocalizedMessage() });
                            continue;
                            localJSONException10 = localJSONException10;
                            y.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "needEvent", localJSONException10.getLocalizedMessage() });
                          }
                        }
                        catch (JSONException localJSONException11)
                        {
                          for (;;)
                          {
                            y.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "debug", localJSONException11.getLocalizedMessage() });
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
    y.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView : livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      y.w("MicroMsg.JsApiUpdateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    parame = (View)((CoverViewContainer)paramView).K(View.class);
    if (!(parame instanceof AppBrandLivePlayerView))
    {
      y.e("MicroMsg.JsApiUpdateLivePlayer", "targetView not AppBrandLivePlayerView");
      return false;
    }
    paramView = (AppBrandLivePlayerView)parame;
    parame = x(paramJSONObject);
    paramView.gsa = parame.getBoolean("needEvent", paramView.gsa);
    paramView = paramView.grW;
    if (!paramView.mInited) {}
    for (parame = new j(-3, "uninited livePlayer");; parame = new j())
    {
      y.i("MicroMsg.AppBrandLivePlayerView", "onUpdate code:%d info:%s", new Object[] { Integer.valueOf(parame.errorCode), parame.gst });
      return true;
      l.h("updateLivePlayer", parame);
      paramView.w(parame);
      boolean bool = paramView.gsx.isPlaying();
      paramJSONObject = parame.getString("playUrl", paramView.gsz);
      if ((paramJSONObject != null) && (!paramJSONObject.isEmpty()) && (paramView.gsz != null) && (!paramView.gsz.equalsIgnoreCase(paramJSONObject)) && (paramView.gsx.isPlaying()))
      {
        y.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + paramView.gsz + " playUrl-new = " + paramJSONObject);
        paramView.gsx.stopPlay(true);
      }
      paramView.gsz = paramJSONObject;
      paramInt = paramView.v(parame);
      if ((paramInt != paramView.gsA) && (paramView.gsx.isPlaying()))
      {
        y.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + paramView.gsA + " playType-new = " + paramInt);
        paramView.gsx.stopPlay(true);
      }
      paramView.gsA = paramInt;
      paramView.mAutoPlay = parame.getBoolean("autoplay", paramView.mAutoPlay);
      if (((paramView.mAutoPlay) || (bool)) && (paramView.gsz != null) && (!paramView.gsz.isEmpty()) && (!paramView.gsx.isPlaying()))
      {
        y.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
        paramView.gsx.startPlay(paramView.gsz, paramView.gsA);
      }
    }
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("livePlayerId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.h
 * JD-Core Version:    0.7.0.1
 */