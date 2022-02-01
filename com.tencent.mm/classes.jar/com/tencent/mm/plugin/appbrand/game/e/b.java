package com.tencent.mm.plugin.appbrand.game.e;

import android.view.View;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.an;
import com.tencent.mm.plugin.appbrand.game.a.w;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/game/jsapi/WAGameJsApiInsertVideoPlayer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/jsapi/JsApiInsertVideoPlayer;", "()V", "getUnderView", "", "data", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Ljava/lang/Boolean;", "onInsertView", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "viewId", "", "view", "Landroid/view/View;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  @Deprecated
  public static final int CTRL_INDEX = 6;
  @Deprecated
  public static final String NAME = "insertVideoPlayer";
  private static final b.a rre;
  
  static
  {
    AppMethodBeat.i(180454);
    rre = new b.a((byte)0);
    AppMethodBeat.o(180454);
  }
  
  public final Boolean W(JSONObject paramJSONObject)
  {
    Object localObject = null;
    AppMethodBeat.i(180452);
    if (paramJSONObject == null) {
      paramJSONObject = localObject;
    }
    for (;;)
    {
      Log.i("Luggage.WAGameJsApiInsertVideoPlayer", s.X("getUnderView ", paramJSONObject));
      AppMethodBeat.o(180452);
      return paramJSONObject;
      try
      {
        boolean bool = paramJSONObject.getBoolean("underGameView");
        paramJSONObject = Boolean.valueOf(bool);
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject = localObject;
      }
    }
  }
  
  public final void a(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(180453);
    s.u(paramh, "component");
    super.a(paramh, paramInt, paramView, paramJSONObject);
    paramView = ((d)paramh).ccO();
    if (paramView == null) {}
    for (paramView = null; paramView == null; paramView = (com.tencent.luggage.game.d.a.a.b)paramView.aa(com.tencent.luggage.game.d.a.a.b.class))
    {
      Log.w("JsApiInsertHTMLCanvasElement", "hy: webgl extension not exists!");
      AppMethodBeat.o(180453);
      return;
    }
    paramView = paramView.getMagicBrush();
    if (paramView == null)
    {
      Log.e("Luggage.WAGameJsApiInsertVideoPlayer", "InsertViewPlayer but, no magicbrush found, maybe functionalPage[%d]", new Object[] { Boolean.valueOf(an.u(((d)paramh).getRuntime())) });
      AppMethodBeat.o(180453);
      return;
    }
    if (s.p(Boolean.TRUE, W(paramJSONObject)))
    {
      paramView.eHD.forEach((kotlin.g.a.b)b.rrf);
      if (((Boolean)com.tencent.mm.plugin.appbrand.game.a.u.rqz.boF()).booleanValue())
      {
        Log.i("Luggage.WAGameJsApiInsertVideoPlayer", "hy: use main thread choreographer");
        if (((Boolean)w.rqB.boF()).booleanValue())
        {
          paramView.a(a.b.eKw);
          AppMethodBeat.o(180453);
          return;
        }
        paramView.a(a.b.eKt);
        AppMethodBeat.o(180453);
        return;
      }
      Log.i("Luggage.WAGameJsApiInsertVideoPlayer", "hy: use js thread choreographer");
      paramView.a(a.b.eKs);
    }
    AppMethodBeat.o(180453);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/ui/MagicBrushView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<MagicBrushView, ah>
  {
    public static final b rrf;
    
    static
    {
      AppMethodBeat.i(180451);
      rrf = new b();
      AppMethodBeat.o(180451);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.b
 * JD-Core Version:    0.7.0.1
 */