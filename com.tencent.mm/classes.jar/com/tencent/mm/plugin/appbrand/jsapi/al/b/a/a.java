package com.tencent.mm.plugin.appbrand.jsapi.al.b.a;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.i;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends b
{
  private static final int CTRL_INDEX = 672;
  public static final String NAME = "insertXWebCanvas";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139453);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(139453);
    return i;
  }
  
  public final View a(h paramh, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139451);
    Context localContext = paramh.getContext();
    try
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
      localJSONObject.optInt("width", 300);
      localJSONObject.optInt("height", 150);
      paramJSONObject = new d(localContext, com.tencent.mm.plugin.appbrand.jsapi.al.b.d.L(paramh), V(paramJSONObject), paramh.getAppId());
      paramh.a(new i.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(327045);
          paramJSONObject.notifyVisibilityChanged(false);
          AppMethodBeat.o(327045);
        }
      });
      paramh.a(new i.d()
      {
        public final void onForeground()
        {
          AppMethodBeat.i(327046);
          paramJSONObject.notifyVisibilityChanged(true);
          AppMethodBeat.o(327046);
        }
      });
      paramh.a(new i.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(327063);
          paramJSONObject.release();
          AppMethodBeat.o(327063);
        }
      });
      paramh = new CoverViewContainer(localContext, paramJSONObject);
      AppMethodBeat.o(139451);
      return paramh;
    }
    catch (JSONException paramh)
    {
      Log.printInfoStack("Luggage.JsApiInsertXWebCanvasTextureView", "insertXWebCanvas fail: %s", new Object[] { paramh });
      AppMethodBeat.o(139451);
    }
    return null;
  }
  
  public final void a(h paramh, int paramInt, View paramView, JSONObject paramJSONObject, final i parami)
  {
    AppMethodBeat.i(139452);
    ((d)((CoverViewContainer)paramView).aT(d.class)).setOnReadyListener(new d.a()
    {
      public final void onReady()
      {
        AppMethodBeat.i(327053);
        parami.aal(a.this.ZP("ok"));
        AppMethodBeat.o(327053);
      }
    });
    AppMethodBeat.o(139452);
  }
  
  public final boolean cqw()
  {
    return true;
  }
  
  public final boolean cqx()
  {
    return true;
  }
  
  public final boolean cqy()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.b.a.a
 * JD-Core Version:    0.7.0.1
 */