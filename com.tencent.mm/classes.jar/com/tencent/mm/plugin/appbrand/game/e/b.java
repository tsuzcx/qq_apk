package com.tencent.mm.plugin.appbrand.game.e;

import android.view.View;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae;
import com.tencent.mm.plugin.appbrand.game.a.m;
import com.tencent.mm.plugin.appbrand.game.a.o;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.y;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/game/jsapi/WAGameJsApiInsertVideoPlayer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/jsapi/JsApiInsertVideoPlayer;", "()V", "getUnderView", "", "data", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Ljava/lang/Boolean;", "onInsertView", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "viewId", "", "view", "Landroid/view/View;", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends a
{
  public static final int CTRL_INDEX = 6;
  public static final String NAME = "insertVideoPlayer";
  @Deprecated
  public static final a jRl;
  
  static
  {
    AppMethodBeat.i(180454);
    jRl = new a((byte)0);
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
    ac.i("Luggage.WAGameJsApiInsertVideoPlayer", "getUnderView ".concat(String.valueOf(localObject1)));
    AppMethodBeat.o(180452);
    return localObject1;
  }
  
  public final void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(180453);
    k.h(parame, "component");
    super.a(parame, paramInt, paramView, paramJSONObject);
    paramView = ((com.tencent.mm.plugin.appbrand.game.f.d)parame).aTU();
    k.g(paramView, "(component as WAGamePageView).service");
    paramView = paramView.getMagicBrush();
    if (paramView == null)
    {
      ac.e("Luggage.WAGameJsApiInsertVideoPlayer", "InsertViewPlayer but, no magicbrush found, maybe functionalPage[%d]", new Object[] { Boolean.valueOf(ae.v(((com.tencent.mm.plugin.appbrand.game.f.d)parame).getRuntime())) });
      AppMethodBeat.o(180453);
      return;
    }
    if (k.g(Boolean.TRUE, B(paramJSONObject)))
    {
      paramView.cmk.forEach((d.g.a.b)b.jRm);
      if (((Boolean)m.jQF.aqp()).booleanValue())
      {
        ac.i("Luggage.WAGameJsApiInsertVideoPlayer", "hy: use main thread choreographer");
        if (((Boolean)o.jQH.aqp()).booleanValue())
        {
          paramView.a(a.b.coY);
          AppMethodBeat.o(180453);
          return;
        }
        paramView.a(a.b.coV);
        AppMethodBeat.o(180453);
        return;
      }
      ac.i("Luggage.WAGameJsApiInsertVideoPlayer", "hy: use js thread choreographer");
      paramView.a(a.b.coU);
    }
    AppMethodBeat.o(180453);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/game/jsapi/WAGameJsApiInsertVideoPlayer$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<MagicBrushView, y>
  {
    public static final b jRm;
    
    static
    {
      AppMethodBeat.i(180451);
      jRm = new b();
      AppMethodBeat.o(180451);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.b
 * JD-Core Version:    0.7.0.1
 */