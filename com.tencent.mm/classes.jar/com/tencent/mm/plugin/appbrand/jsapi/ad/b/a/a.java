package com.tencent.mm.plugin.appbrand.jsapi.ad.b.a;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.i;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends b
{
  private static final int CTRL_INDEX = 672;
  public static final String NAME = "insertXWebCanvas";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139453);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(139453);
    return i;
  }
  
  public final View a(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139451);
    Context localContext = parame.getContext();
    try
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
      localJSONObject.optInt("width", 300);
      localJSONObject.optInt("height", 150);
      parame = new d(localContext, c.F(parame), A(paramJSONObject), parame.getAppId());
      parame = new CoverViewContainer(localContext, parame);
      AppMethodBeat.o(139451);
      return parame;
    }
    catch (JSONException parame)
    {
      ae.m("Luggage.JsApiInsertXWebCanvasTextureView", "insertXWebCanvas fail: %s", new Object[] { parame });
      AppMethodBeat.o(139451);
    }
    return null;
  }
  
  public final void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject, final i parami)
  {
    AppMethodBeat.i(139452);
    ((d)((CoverViewContainer)paramView).ax(d.class)).setOnReadyListener(new d.a()
    {
      public final void onReady()
      {
        AppMethodBeat.i(139450);
        parami.PZ(a.this.e("ok", null));
        AppMethodBeat.o(139450);
      }
    });
    AppMethodBeat.o(139452);
  }
  
  public final boolean bjF()
  {
    return true;
  }
  
  public final boolean bjG()
  {
    return true;
  }
  
  public final boolean bjH()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.b.a.a
 * JD-Core Version:    0.7.0.1
 */