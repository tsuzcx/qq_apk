package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
  extends c
{
  private static final int CTRL_INDEX = 87;
  public static final String NAME = "updateVideoPlayer";
  
  protected final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView : videoPlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof CoverViewContainer))
    {
      y.w("MicroMsg.JsApiUpdateVideoPlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramView = (AppBrandVideoView)((CoverViewContainer)paramView).K(AppBrandVideoView.class);
    if (paramView == null)
    {
      y.e("MicroMsg.JsApiUpdateVideoPlayer", "view not AppBrandVideoView");
      return false;
    }
    try
    {
      if (paramJSONObject.has("showDanmuBtn")) {
        paramView.setShowDanmakuBtn(paramJSONObject.getBoolean("showDanmuBtn"));
      }
    }
    catch (JSONException parame)
    {
      try
      {
        if (paramJSONObject.has("danmuList")) {
          paramView.setDanmakuItemList(paramJSONObject.getJSONArray("danmuList"));
        }
      }
      catch (JSONException parame)
      {
        try
        {
          if (paramJSONObject.has("objectFit")) {
            paramView.setObjectFit(paramJSONObject.getString("objectFit"));
          }
        }
        catch (JSONException parame)
        {
          try
          {
            if (paramJSONObject.has("autoplay")) {
              paramView.setAutoPlay(paramJSONObject.getBoolean("autoplay"));
            }
          }
          catch (JSONException parame)
          {
            try
            {
              if (paramJSONObject.has("showBasicControls")) {
                paramView.setIsShowBasicControls(paramJSONObject.getBoolean("showBasicControls"));
              }
            }
            catch (JSONException parame)
            {
              try
              {
                if (paramJSONObject.has("poster")) {
                  paramView.setCover$16da05f7(paramJSONObject.getString("poster"));
                }
              }
              catch (JSONException parame)
              {
                try
                {
                  if (paramJSONObject.has("direction")) {
                    paramView.setFullScreenDirection(paramJSONObject.getInt("direction"));
                  }
                }
                catch (Exception parame)
                {
                  try
                  {
                    if (paramJSONObject.has("muted")) {
                      paramView.setMute(paramJSONObject.getBoolean("muted"));
                    }
                  }
                  catch (JSONException parame)
                  {
                    try
                    {
                      if (paramJSONObject.has("loop")) {
                        paramView.setLoop(paramJSONObject.getBoolean("loop"));
                      }
                    }
                    catch (JSONException parame)
                    {
                      try
                      {
                        if (paramJSONObject.has("data")) {
                          paramView.setCookieData(paramJSONObject.getString("data"));
                        }
                      }
                      catch (JSONException parame)
                      {
                        try
                        {
                          if (paramJSONObject.has("pageGesture")) {
                            paramView.setPageGesture(paramJSONObject.getBoolean("pageGesture"));
                          }
                        }
                        catch (JSONException parame)
                        {
                          try
                          {
                            if (paramJSONObject.has("showControlProgress")) {
                              paramView.setShowControlProgress(paramJSONObject.getBoolean("showControlProgress"));
                            }
                          }
                          catch (JSONException parame)
                          {
                            try
                            {
                              if (paramJSONObject.has("showProgress")) {
                                paramView.setShowProgress(paramJSONObject.getBoolean("showProgress"));
                              }
                            }
                            catch (JSONException parame)
                            {
                              try
                              {
                                if (paramJSONObject.has("showFullScreenBtn")) {
                                  paramView.setShowFullScreenBtn(paramJSONObject.getBoolean("showFullScreenBtn"));
                                }
                              }
                              catch (JSONException parame)
                              {
                                try
                                {
                                  if (paramJSONObject.has("showPlayBtn")) {
                                    paramView.setShowPlayBtn(paramJSONObject.getBoolean("showPlayBtn"));
                                  }
                                }
                                catch (JSONException parame)
                                {
                                  try
                                  {
                                    if (paramJSONObject.has("showCenterPlayBtn")) {
                                      paramView.setShowCenterPlayBtn(paramJSONObject.getBoolean("showCenterPlayBtn"));
                                    }
                                  }
                                  catch (JSONException parame)
                                  {
                                    try
                                    {
                                      if (paramJSONObject.has("enableProgressGesture")) {
                                        paramView.ds(paramJSONObject.getBoolean("enableProgressGesture"));
                                      }
                                    }
                                    catch (JSONException parame)
                                    {
                                      try
                                      {
                                        if (paramJSONObject.has("duration")) {
                                          paramView.setDuration(paramJSONObject.getInt("duration"));
                                        }
                                      }
                                      catch (JSONException parame)
                                      {
                                        try
                                        {
                                          if ((paramJSONObject.has("hide")) && (paramJSONObject.getBoolean("hide")))
                                          {
                                            y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView hide stop");
                                            paramView.stop();
                                          }
                                        }
                                        catch (JSONException parame)
                                        {
                                          try
                                          {
                                            if (paramJSONObject.has("initialTime")) {
                                              paramView.setInitialTime(paramJSONObject.getInt("initialTime"));
                                            }
                                          }
                                          catch (JSONException parame)
                                          {
                                            try
                                            {
                                              if (paramJSONObject.has("needEvent"))
                                              {
                                                if (paramJSONObject.getBoolean("needEvent")) {
                                                  break label1227;
                                                }
                                                paramView.setCallback(null);
                                              }
                                            }
                                            catch (JSONException parame)
                                            {
                                              try
                                              {
                                                if (paramJSONObject.has("showMuteBtn")) {
                                                  paramView.setShowMuteBtn(paramJSONObject.getBoolean("showMuteBtn"));
                                                }
                                              }
                                              catch (JSONException parame)
                                              {
                                                try
                                                {
                                                  if (paramJSONObject.has("title")) {
                                                    paramView.setTitle(paramJSONObject.getString("title"));
                                                  }
                                                }
                                                catch (JSONException parame)
                                                {
                                                  try
                                                  {
                                                    if (paramJSONObject.has("playBtnPosition")) {
                                                      paramView.setPlayBtnPosition(paramJSONObject.getString("playBtnPosition"));
                                                    }
                                                  }
                                                  catch (JSONException parame)
                                                  {
                                                    try
                                                    {
                                                      if (paramJSONObject.has("enablePlayGesture")) {
                                                        paramView.setEnablePlayGesture(paramJSONObject.getBoolean("enablePlayGesture"));
                                                      }
                                                    }
                                                    catch (JSONException parame)
                                                    {
                                                      try
                                                      {
                                                        for (;;)
                                                        {
                                                          if (paramJSONObject.has("filePath")) {
                                                            paramView.e(paramJSONObject.getString("filePath"), paramJSONObject.optBoolean("live"), paramJSONObject.optInt("duration"));
                                                          }
                                                          return true;
                                                          localJSONException1 = localJSONException1;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "showDanmuBtn", localJSONException1.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException2 = localJSONException2;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "danmuList", localJSONException2.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException3 = localJSONException3;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "objectFit", localJSONException3.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException4 = localJSONException4;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "autoplay", localJSONException4.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException5 = localJSONException5;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "showBasicControls", localJSONException5.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException6 = localJSONException6;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "poster", localJSONException6.getLocalizedMessage() });
                                                          continue;
                                                          localException = localException;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "direction", localException.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException7 = localJSONException7;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "muted", localJSONException7.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException8 = localJSONException8;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "loop", localJSONException8.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException9 = localJSONException9;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "data", localJSONException9.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException10 = localJSONException10;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "pageGesture", localJSONException10.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException11 = localJSONException11;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "showControlProgress", localJSONException11.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException12 = localJSONException12;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "showProgress", localJSONException12.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException13 = localJSONException13;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "showFullScreenBtn", localJSONException13.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException14 = localJSONException14;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "showPlayBtn", localJSONException14.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException15 = localJSONException15;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "showCenterPlayBtn", localJSONException15.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException16 = localJSONException16;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "enableProgressGesture", localJSONException16.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException17 = localJSONException17;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "disableScroll", localJSONException17.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException18 = localJSONException18;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "hide", localJSONException18.getLocalizedMessage() });
                                                          continue;
                                                          localJSONException19 = localJSONException19;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "initialTime", localJSONException19.getLocalizedMessage() });
                                                          continue;
                                                          label1227:
                                                          if (paramView.gDC != null) {}
                                                          for (paramInt = 1; paramInt == 0; paramInt = 0)
                                                          {
                                                            paramView.setCallback(new j(paramView, parame));
                                                            break;
                                                            parame = parame;
                                                            y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "needEvent", parame.getLocalizedMessage() });
                                                            break;
                                                          }
                                                          parame = parame;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "showMuteBtn", parame.getLocalizedMessage() });
                                                          continue;
                                                          parame = parame;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "title", parame.getLocalizedMessage() });
                                                          continue;
                                                          parame = parame;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "playBtnPosition", parame.getLocalizedMessage() });
                                                          continue;
                                                          parame = parame;
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "enablePlayGesture", parame.getLocalizedMessage() });
                                                        }
                                                      }
                                                      catch (JSONException parame)
                                                      {
                                                        for (;;)
                                                        {
                                                          y.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[] { "filePath", parame.getLocalizedMessage() });
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
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("videoPlayerId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.i
 * JD-Core Version:    0.7.0.1
 */