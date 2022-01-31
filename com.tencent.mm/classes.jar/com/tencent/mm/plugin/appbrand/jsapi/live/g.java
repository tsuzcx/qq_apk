package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.TXLivePlayer;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  extends c
{
  private static final int CTRL_INDEX = 365;
  public static final String NAME = "updateLivePlayer";
  
  private static Bundle F(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96122);
    Bundle localBundle = new Bundle();
    try
    {
      if (paramJSONObject.has("playUrl"))
      {
        localBundle.putString("playUrl", paramJSONObject.getString("playUrl"));
        ab.i("MicroMsg.JsApiUpdateLivePlayer", "convertParams playUrl:%s", new Object[] { paramJSONObject.getString("playUrl") });
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
                              ab.i("MicroMsg.JsApiUpdateLivePlayer", "convertParams soundMode:%s", new Object[] { paramJSONObject.getString("soundMode") });
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
                                  AppMethodBeat.o(96122);
                                  return localBundle;
                                  localJSONException1 = localJSONException1;
                                  ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "playUrl", localJSONException1.getLocalizedMessage() });
                                  continue;
                                  localJSONException2 = localJSONException2;
                                  ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "mode", localJSONException2.getLocalizedMessage() });
                                  continue;
                                  localJSONException3 = localJSONException3;
                                  ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "autoplay", localJSONException3.getLocalizedMessage() });
                                  continue;
                                  localJSONException4 = localJSONException4;
                                  ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "muted", localJSONException4.getLocalizedMessage() });
                                  continue;
                                  localJSONException5 = localJSONException5;
                                  ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "orientation", localJSONException5.getLocalizedMessage() });
                                  continue;
                                  localJSONException6 = localJSONException6;
                                  ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "objectFit", localJSONException6.getLocalizedMessage() });
                                  continue;
                                  localJSONException7 = localJSONException7;
                                  ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "backgroundMute", localJSONException7.getLocalizedMessage() });
                                  continue;
                                  localJSONException8 = localJSONException8;
                                  ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "minCache", localJSONException8.getLocalizedMessage() });
                                  continue;
                                  localJSONException9 = localJSONException9;
                                  ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "maxCache", localJSONException9.getLocalizedMessage() });
                                  continue;
                                  localJSONException10 = localJSONException10;
                                  ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "needEvent", localJSONException10.getLocalizedMessage() });
                                  continue;
                                  localJSONException11 = localJSONException11;
                                  ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "debug", localJSONException11.getLocalizedMessage() });
                                  continue;
                                  localJSONException12 = localJSONException12;
                                  ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "soundMode", localJSONException12.getLocalizedMessage() });
                                  continue;
                                  localJSONException13 = localJSONException13;
                                  ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "autoPauseIfNavigate", localJSONException13.getLocalizedMessage() });
                                }
                              }
                              catch (JSONException paramJSONObject)
                              {
                                for (;;)
                                {
                                  ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView param=%s exp=%s", new Object[] { "autoPauseIfOpenNative", paramJSONObject.getLocalizedMessage() });
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
  
  public final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96121);
    ab.i("MicroMsg.JsApiUpdateLivePlayer", "onUpdateView : livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      ab.w("MicroMsg.JsApiUpdateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(96121);
      return false;
    }
    parame = (View)((CoverViewContainer)paramView).aa(View.class);
    if (!(parame instanceof AppBrandLivePlayerView))
    {
      ab.e("MicroMsg.JsApiUpdateLivePlayer", "targetView not AppBrandLivePlayerView");
      AppMethodBeat.o(96121);
      return false;
    }
    paramView = (AppBrandLivePlayerView)parame;
    parame = F(paramJSONObject);
    paramView.bGw = parame.getBoolean("needEvent", paramView.bGw);
    paramView = paramView.hNq;
    if (!paramView.mInited) {}
    for (parame = new i(-3, "uninited livePlayer");; parame = new i())
    {
      ab.i("MicroMsg.AppBrandLivePlayerView", "onUpdate code:%d info:%s", new Object[] { Integer.valueOf(parame.errorCode), parame.bFT });
      AppMethodBeat.o(96121);
      return true;
      k.k("updateLivePlayer", parame);
      paramView.m(parame);
      boolean bool = paramView.bGk.isPlaying();
      paramJSONObject = parame.getString("playUrl", paramView.bGn);
      if ((paramJSONObject != null) && (!paramJSONObject.isEmpty()) && (paramView.bGn != null) && (!paramView.bGn.equalsIgnoreCase(paramJSONObject)) && (paramView.bGk.isPlaying()))
      {
        ab.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + paramView.bGn + " playUrl-new = " + paramJSONObject);
        paramView.bGk.stopPlay(true);
      }
      paramView.bGn = paramJSONObject;
      paramInt = paramView.l(parame);
      if ((paramInt != paramView.bGo) && (paramView.bGk.isPlaying()))
      {
        ab.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + paramView.bGo + " playType-new = " + paramInt);
        paramView.bGk.stopPlay(true);
      }
      paramView.bGo = paramInt;
      paramView.mAutoPlay = parame.getBoolean("autoplay", paramView.mAutoPlay);
      if (((paramView.mAutoPlay) || (bool)) && (paramView.bGn != null) && (!paramView.bGn.isEmpty()) && (!paramView.bGk.isPlaying()))
      {
        ab.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
        paramView.cm(paramView.bGn);
        paramView.bGk.startPlay(paramView.bGn, paramView.bGo);
      }
    }
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96120);
    int i = paramJSONObject.optInt("livePlayerId");
    AppMethodBeat.o(96120);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.g
 * JD-Core Version:    0.7.0.1
 */