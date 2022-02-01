package com.tencent.mm.plugin.appbrand.jsapi.ac.b.a;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.skia_canvas.IXWebWorkingHandler;
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
          AppMethodBeat.i(186910);
          if (parame == null)
          {
            ad.i("Luggage.JsApiInsertXWebCanvasTextureView", "component is null, return");
            AppMethodBeat.o(186910);
            return;
          }
          com.tencent.mm.plugin.appbrand.jsruntime.q localq = null;
          if ((parame instanceof com.tencent.mm.plugin.appbrand.q)) {
            localq = (com.tencent.mm.plugin.appbrand.jsruntime.q)parame.aYh().P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
          }
          while (localq != null) {
            if (localq.Ct())
            {
              paramAnonymousRunnable.run();
              AppMethodBeat.o(186910);
              return;
              if ((parame instanceof aa)) {
                localq = (com.tencent.mm.plugin.appbrand.jsruntime.q)((aa)parame).Ew().aYh().P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
              }
            }
            else
            {
              localq.post(paramAnonymousRunnable);
              AppMethodBeat.o(186910);
              return;
            }
          }
          ad.e("Luggage.JsApiInsertXWebCanvasTextureView", "jsThreadAddon is null, error");
          AppMethodBeat.o(186910);
        }
      }, A(paramJSONObject), parame.getAppId(), i, j);
      parame = new CoverViewContainer(localContext, parame);
      AppMethodBeat.o(139451);
      return parame;
    }
    catch (JSONException parame)
    {
      ad.m("Luggage.JsApiInsertXWebCanvasTextureView", "insertXWebCanvas fail: %s", new Object[] { parame });
      AppMethodBeat.o(139451);
    }
    return null;
  }
  
  public final void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject, final com.tencent.mm.plugin.appbrand.jsapi.base.i parami)
  {
    AppMethodBeat.i(139452);
    ((d)((CoverViewContainer)paramView).ax(d.class)).setOnReadyListener(new d.a()
    {
      public final void onReady()
      {
        AppMethodBeat.i(186911);
        parami.Pr(a.this.e("ok", null));
        AppMethodBeat.o(186911);
      }
    });
    AppMethodBeat.o(139452);
  }
  
  public final boolean biW()
  {
    return true;
  }
  
  public final boolean biX()
  {
    return true;
  }
  
  public final boolean biY()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.b.a.a
 * JD-Core Version:    0.7.0.1
 */