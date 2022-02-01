package com.tencent.mm.plugin.appbrand.game.e;

import android.view.View;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ai;
import com.tencent.mm.plugin.appbrand.game.a.t;
import com.tencent.mm.plugin.appbrand.game.a.v;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/game/jsapi/WAGameJsApiInsertVideoPlayer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/jsapi/JsApiInsertVideoPlayer;", "()V", "getUnderView", "", "data", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Ljava/lang/Boolean;", "onInsertView", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "viewId", "", "view", "Landroid/view/View;", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends a
{
  public static final int CTRL_INDEX = 6;
  public static final String NAME = "insertVideoPlayer";
  @Deprecated
  public static final b.a onv;
  
  static
  {
    AppMethodBeat.i(180454);
    onv = new b.a((byte)0);
    AppMethodBeat.o(180454);
  }
  
  public final Boolean L(JSONObject paramJSONObject)
  {
    localObject2 = null;
    AppMethodBeat.i(180452);
    localObject1 = localObject2;
    if (paramJSONObject != null) {}
    try
    {
      boolean bool = paramJSONObject.getBoolean("underGameView");
      localObject1 = Boolean.valueOf(bool);
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
    Log.i("Luggage.WAGameJsApiInsertVideoPlayer", "getUnderView ".concat(String.valueOf(localObject1)));
    AppMethodBeat.o(180452);
    return localObject1;
  }
  
  public final void a(g paramg, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(180453);
    p.k(paramg, "component");
    super.a(paramg, paramInt, paramView, paramJSONObject);
    paramView = ((d)paramg).bDA();
    if (paramView != null) {}
    for (paramView = (com.tencent.luggage.game.d.a.a.b)paramView.R(com.tencent.luggage.game.d.a.a.b.class); paramView == null; paramView = null)
    {
      Log.w("JsApiInsertHTMLCanvasElement", "hy: webgl extension not exists!");
      AppMethodBeat.o(180453);
      return;
    }
    paramView = paramView.getMagicBrush();
    if (paramView == null)
    {
      Log.e("Luggage.WAGameJsApiInsertVideoPlayer", "InsertViewPlayer but, no magicbrush found, maybe functionalPage[%d]", new Object[] { Boolean.valueOf(ai.q(((d)paramg).getRuntime())) });
      AppMethodBeat.o(180453);
      return;
    }
    if (p.h(Boolean.TRUE, L(paramJSONObject)))
    {
      paramView.cMj.forEach((kotlin.g.a.b)b.b.onw);
      if (((Boolean)t.omP.aUb()).booleanValue())
      {
        Log.i("Luggage.WAGameJsApiInsertVideoPlayer", "hy: use main thread choreographer");
        if (((Boolean)v.omR.aUb()).booleanValue())
        {
          paramView.a(a.b.cPr);
          AppMethodBeat.o(180453);
          return;
        }
        paramView.a(a.b.cPo);
        AppMethodBeat.o(180453);
        return;
      }
      Log.i("Luggage.WAGameJsApiInsertVideoPlayer", "hy: use js thread choreographer");
      paramView.a(a.b.cPn);
    }
    AppMethodBeat.o(180453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.b
 * JD-Core Version:    0.7.0.1
 */