package com.tencent.mm.plugin.appbrand.jsapi.ai.b.a;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.i;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends b
{
  private static final int CTRL_INDEX = 672;
  public static final String NAME = "insertXWebCanvas";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139453);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(139453);
    return i;
  }
  
  public final View a(g paramg, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139451);
    Context localContext = paramg.getContext();
    try
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
      localJSONObject.optInt("width", 300);
      localJSONObject.optInt("height", 150);
      paramJSONObject = new d(localContext, com.tencent.mm.plugin.appbrand.jsapi.ai.b.d.J(paramg), K(paramJSONObject), paramg.getAppId());
      paramg.a(new h.b()
      {
        public final void onBackground()
        {
          AppMethodBeat.i(220610);
          paramJSONObject.notifyVisibilityChanged(false);
          AppMethodBeat.o(220610);
        }
      });
      paramg.a(new h.d()
      {
        public final void onForeground()
        {
          AppMethodBeat.i(223893);
          paramJSONObject.notifyVisibilityChanged(true);
          AppMethodBeat.o(223893);
        }
      });
      paramg.a(new h.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(224129);
          paramJSONObject.release();
          AppMethodBeat.o(224129);
        }
      });
      paramg = new CoverViewContainer(localContext, paramJSONObject);
      AppMethodBeat.o(139451);
      return paramg;
    }
    catch (JSONException paramg)
    {
      Log.printInfoStack("Luggage.JsApiInsertXWebCanvasTextureView", "insertXWebCanvas fail: %s", new Object[] { paramg });
      AppMethodBeat.o(139451);
    }
    return null;
  }
  
  public final void a(g paramg, int paramInt, View paramView, JSONObject paramJSONObject, final i parami)
  {
    AppMethodBeat.i(139452);
    ((d)((CoverViewContainer)paramView).aA(d.class)).setOnReadyListener(new d.a()
    {
      public final void NR()
      {
        AppMethodBeat.i(224418);
        parami.aho(a.this.h("ok", null));
        AppMethodBeat.o(224418);
      }
    });
    AppMethodBeat.o(139452);
  }
  
  public final boolean bQA()
  {
    return true;
  }
  
  public final boolean bQB()
  {
    return true;
  }
  
  public final boolean bQz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.b.a.a
 * JD-Core Version:    0.7.0.1
 */