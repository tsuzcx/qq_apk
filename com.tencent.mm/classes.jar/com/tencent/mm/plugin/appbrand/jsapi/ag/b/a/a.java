package com.tencent.mm.plugin.appbrand.jsapi.ag.b.a;

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
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends b
{
  private static final int CTRL_INDEX = 672;
  public static final String NAME = "insertXWebCanvas";
  
  public final int H(JSONObject paramJSONObject)
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
      paramJSONObject = new d(localContext, com.tencent.mm.plugin.appbrand.jsapi.ag.b.d.G(paramh), H(paramJSONObject), paramh.getAppId());
      paramh.a(new i.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(215829);
          paramJSONObject.notifyVisibilityChanged(false);
          AppMethodBeat.o(215829);
        }
      });
      paramh.a(new i.d()
      {
        public final void onForeground()
        {
          AppMethodBeat.i(215830);
          paramJSONObject.notifyVisibilityChanged(true);
          AppMethodBeat.o(215830);
        }
      });
      paramh.a(new i.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(215831);
          paramJSONObject.release();
          AppMethodBeat.o(215831);
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
    ((d)((CoverViewContainer)paramView).aB(d.class)).setOnReadyListener(new d.a()
    {
      public final void onReady()
      {
        AppMethodBeat.i(215832);
        parami.ZA(a.this.h("ok", null));
        AppMethodBeat.o(215832);
      }
    });
    AppMethodBeat.o(139452);
  }
  
  public final boolean bEV()
  {
    return true;
  }
  
  public final boolean bEW()
  {
    return true;
  }
  
  public final boolean bEX()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.a
 * JD-Core Version:    0.7.0.1
 */