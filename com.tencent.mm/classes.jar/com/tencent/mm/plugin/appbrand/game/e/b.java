package com.tencent.mm.plugin.appbrand.game.e;

import android.view.View;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.y;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/game/jsapi/WAGameJsApiInsertVideoPlayer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/jsapi/JsApiInsertVideoPlayer;", "()V", "getUnderView", "", "data", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Ljava/lang/Boolean;", "onInsertView", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "viewId", "", "view", "Landroid/view/View;", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends a
{
  public static final int CTRL_INDEX = 6;
  public static final String NAME = "insertVideoPlayer";
  @Deprecated
  public static final b.a jqT;
  
  static
  {
    AppMethodBeat.i(180454);
    jqT = new b.a((byte)0);
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
    d.g.b.k.h(parame, "component");
    super.a(parame, paramInt, paramView, paramJSONObject);
    paramView = ((com.tencent.mm.plugin.appbrand.game.f.d)parame).aNe();
    d.g.b.k.g(paramView, "(component as WAGamePageView).service");
    paramView = paramView.getMagicBrush();
    if (paramView == null)
    {
      ad.e("Luggage.WAGameJsApiInsertVideoPlayer", "InsertViewPlayer but, no magicbrush found, maybe functionalPage[%d]", new Object[] { Boolean.valueOf(ae.v(((com.tencent.mm.plugin.appbrand.game.f.d)parame).getRuntime())) });
      AppMethodBeat.o(180453);
      return;
    }
    if (d.g.b.k.g(Boolean.TRUE, B(paramJSONObject)))
    {
      paramView.cpf.forEach((d.g.a.b)b.jqU);
      if (((Boolean)com.tencent.mm.plugin.appbrand.game.a.k.jqo.ajp()).booleanValue())
      {
        ad.i("Luggage.WAGameJsApiInsertVideoPlayer", "hy: use main thread choreographer");
        paramView.a(a.b.crP);
        AppMethodBeat.o(180453);
        return;
      }
      ad.i("Luggage.WAGameJsApiInsertVideoPlayer", "hy: use js thread choreographer");
      paramView.a(a.b.crO);
    }
    AppMethodBeat.o(180453);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<MagicBrushView, y>
  {
    public static final b jqU;
    
    static
    {
      AppMethodBeat.i(180451);
      jqU = new b();
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