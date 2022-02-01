package com.tencent.mm.plugin.appbrand.game.e;

import android.view.View;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae;
import com.tencent.mm.plugin.appbrand.game.a.r;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.q;
import d.l;
import d.z;
import org.json.JSONException;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/game/jsapi/WAGameJsApiInsertVideoPlayer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/jsapi/JsApiInsertVideoPlayer;", "()V", "getUnderView", "", "data", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Ljava/lang/Boolean;", "onInsertView", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "viewId", "", "view", "Landroid/view/View;", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends a
{
  public static final int CTRL_INDEX = 6;
  public static final String NAME = "insertVideoPlayer";
  @Deprecated
  public static final b.a klz;
  
  static
  {
    AppMethodBeat.i(180454);
    klz = new b.a((byte)0);
    AppMethodBeat.o(180454);
  }
  
  public final Boolean B(JSONObject paramJSONObject)
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
    ad.i("Luggage.WAGameJsApiInsertVideoPlayer", "getUnderView ".concat(String.valueOf(localObject1)));
    AppMethodBeat.o(180452);
    return localObject1;
  }
  
  public final void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(180453);
    d.g.b.p.h(parame, "component");
    super.a(parame, paramInt, paramView, paramJSONObject);
    paramView = ((com.tencent.mm.plugin.appbrand.game.f.d)parame).aXe();
    d.g.b.p.g(paramView, "(component as WAGamePageView).service");
    paramView = paramView.getMagicBrush();
    if (paramView == null)
    {
      ad.e("Luggage.WAGameJsApiInsertVideoPlayer", "InsertViewPlayer but, no magicbrush found, maybe functionalPage[%d]", new Object[] { Boolean.valueOf(ae.m(((com.tencent.mm.plugin.appbrand.game.f.d)parame).getRuntime())) });
      AppMethodBeat.o(180453);
      return;
    }
    if (d.g.b.p.i(Boolean.TRUE, B(paramJSONObject)))
    {
      paramView.cwM.forEach((d.g.a.b)b.klA);
      if (((Boolean)com.tencent.mm.plugin.appbrand.game.a.p.kkU.ate()).booleanValue())
      {
        ad.i("Luggage.WAGameJsApiInsertVideoPlayer", "hy: use main thread choreographer");
        if (((Boolean)r.kkW.ate()).booleanValue())
        {
          paramView.a(a.b.czP);
          AppMethodBeat.o(180453);
          return;
        }
        paramView.a(a.b.czM);
        AppMethodBeat.o(180453);
        return;
      }
      ad.i("Luggage.WAGameJsApiInsertVideoPlayer", "hy: use js thread choreographer");
      paramView.a(a.b.czL);
    }
    AppMethodBeat.o(180453);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<MagicBrushView, z>
  {
    public static final b klA;
    
    static
    {
      AppMethodBeat.i(180451);
      klA = new b();
      AppMethodBeat.o(180451);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.b
 * JD-Core Version:    0.7.0.1
 */