package com.tencent.mm.plugin.appbrand.game.e;

import android.view.View;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af;
import com.tencent.mm.plugin.appbrand.game.a.r;
import com.tencent.mm.plugin.appbrand.game.a.t;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/game/jsapi/WAGameJsApiInsertVideoPlayer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/jsapi/JsApiInsertVideoPlayer;", "()V", "getUnderView", "", "data", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Ljava/lang/Boolean;", "onInsertView", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "viewId", "", "view", "Landroid/view/View;", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends a
{
  public static final int CTRL_INDEX = 6;
  public static final String NAME = "insertVideoPlayer";
  @Deprecated
  public static final a lsy;
  
  static
  {
    AppMethodBeat.i(180454);
    lsy = new a((byte)0);
    AppMethodBeat.o(180454);
  }
  
  public final Boolean I(JSONObject paramJSONObject)
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
  
  public final void a(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(180453);
    p.h(paramh, "component");
    super.a(paramh, paramInt, paramView, paramJSONObject);
    paramView = ((d)paramh).bsE();
    if (paramView != null) {}
    for (paramView = (com.tencent.luggage.game.d.a.a.b)paramView.S(com.tencent.luggage.game.d.a.a.b.class); paramView == null; paramView = null)
    {
      Log.w("JsApiInsertHTMLCanvasElement", "hy: webgl extension not exists!");
      AppMethodBeat.o(180453);
      return;
    }
    paramView = paramView.getMagicBrush();
    if (paramView == null)
    {
      Log.e("Luggage.WAGameJsApiInsertVideoPlayer", "InsertViewPlayer but, no magicbrush found, maybe functionalPage[%d]", new Object[] { Boolean.valueOf(af.p(((d)paramh).getRuntime())) });
      AppMethodBeat.o(180453);
      return;
    }
    if (p.j(Boolean.TRUE, I(paramJSONObject)))
    {
      paramView.cLz.forEach((kotlin.g.a.b)b.lsz);
      if (((Boolean)r.lrS.aLT()).booleanValue())
      {
        Log.i("Luggage.WAGameJsApiInsertVideoPlayer", "hy: use main thread choreographer");
        if (((Boolean)t.lrU.aLT()).booleanValue())
        {
          paramView.a(a.b.cOC);
          AppMethodBeat.o(180453);
          return;
        }
        paramView.a(a.b.cOz);
        AppMethodBeat.o(180453);
        return;
      }
      Log.i("Luggage.WAGameJsApiInsertVideoPlayer", "hy: use js thread choreographer");
      paramView.a(a.b.cOy);
    }
    AppMethodBeat.o(180453);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/game/jsapi/WAGameJsApiInsertVideoPlayer$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<MagicBrushView, x>
  {
    public static final b lsz;
    
    static
    {
      AppMethodBeat.i(180451);
      lsz = new b();
      AppMethodBeat.o(180451);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.b
 * JD-Core Version:    0.7.0.1
 */