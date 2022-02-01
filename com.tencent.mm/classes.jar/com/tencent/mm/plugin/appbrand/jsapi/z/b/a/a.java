package com.tencent.mm.plugin.appbrand.jsapi.z.b.a;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.xweb.skia_canvas.IXWebWorkingHandler;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
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
  
  public final View a(final e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139451);
    Context localContext = parame.getContext();
    try
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
      int i = localJSONObject.optInt("width", 300);
      int j = localJSONObject.optInt("height", 150);
      parame = new d(localContext, new IXWebWorkingHandler()
      {
        public final boolean isRunOnWorkingThread()
        {
          return false;
        }
        
        public final void post(Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(206721);
          if (parame == null)
          {
            ac.i("Luggage.JsApiInsertXWebCanvasTextureView", "component is null, return");
            AppMethodBeat.o(206721);
            return;
          }
          com.tencent.mm.plugin.appbrand.jsruntime.q localq = null;
          if ((parame instanceof com.tencent.mm.plugin.appbrand.q)) {
            localq = (com.tencent.mm.plugin.appbrand.jsruntime.q)parame.aUV().P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
          }
          while (localq != null) {
            if (localq.AU())
            {
              paramAnonymousRunnable.run();
              AppMethodBeat.o(206721);
              return;
              if ((parame instanceof aa)) {
                localq = (com.tencent.mm.plugin.appbrand.jsruntime.q)((aa)parame).CX().aUV().P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
              }
            }
            else
            {
              localq.post(paramAnonymousRunnable);
              AppMethodBeat.o(206721);
              return;
            }
          }
          ac.e("Luggage.JsApiInsertXWebCanvasTextureView", "jsThreadAddon is null, error");
          AppMethodBeat.o(206721);
        }
      }, A(paramJSONObject), parame.getAppId(), i, j);
      parame = new CoverViewContainer(localContext, parame);
      AppMethodBeat.o(139451);
      return parame;
    }
    catch (JSONException parame)
    {
      ac.m("Luggage.JsApiInsertXWebCanvasTextureView", "insertXWebCanvas fail: %s", new Object[] { parame });
      AppMethodBeat.o(139451);
    }
    return null;
  }
  
  public final void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject, final g paramg)
  {
    AppMethodBeat.i(139452);
    ((d)((CoverViewContainer)paramView).ax(d.class)).setOnReadyListener(new d.a()
    {
      public final void onReady()
      {
        AppMethodBeat.i(206722);
        paramg.LV(a.this.e("ok", null));
        AppMethodBeat.o(206722);
      }
    });
    AppMethodBeat.o(139452);
  }
  
  public final boolean bft()
  {
    return true;
  }
  
  public final boolean bfu()
  {
    return true;
  }
  
  public final boolean bfv()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.b.a.a
 * JD-Core Version:    0.7.0.1
 */