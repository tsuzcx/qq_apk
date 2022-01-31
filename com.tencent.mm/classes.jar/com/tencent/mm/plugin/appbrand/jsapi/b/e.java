package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONObject;

public class e
  extends c<com.tencent.mm.plugin.appbrand.jsapi.e>
{
  public static final int CTRL_INDEX = 69;
  public static final String NAME = "drawCanvas";
  
  public final boolean aCb()
  {
    return true;
  }
  
  public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject, final g paramg)
  {
    AppMethodBeat.i(103852);
    if (!(paramView instanceof CoverViewContainer))
    {
      ab.i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of CoverViewContainer.(%s)", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(103852);
      return false;
    }
    Object localObject = (View)((CoverViewContainer)paramView).aa(View.class);
    ab.d("MicroMsg.JsApiDrawCanvas", "drawCanvas(id : %s)", new Object[] { Integer.valueOf(paramInt) });
    if (!(localObject instanceof a))
    {
      ab.i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of AppBrandDrawableView.(%s)", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(103852);
      return false;
    }
    long l = System.currentTimeMillis();
    JSONArray localJSONArray = paramJSONObject.optJSONArray("actions");
    boolean bool = paramJSONObject.optBoolean("reserve");
    localObject = (a)localObject;
    if (bool) {
      ((a)localObject).b(localJSONArray, new a.a()
      {
        public final void a(DrawCanvasArg paramAnonymousDrawCanvasArg)
        {
          AppMethodBeat.i(103849);
          paramg.BS(e.this.j("ok", null));
          AppMethodBeat.o(103849);
        }
      });
    }
    for (;;)
    {
      ((a)localObject).axT();
      ab.v("MicroMsg.JsApiDrawCanvas", "post drawCanvas cost : %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      bool = super.b(parame, paramInt, paramView, paramJSONObject, paramg);
      AppMethodBeat.o(103852);
      return bool;
      ((a)localObject).a(localJSONArray, new e.2(this, paramg));
    }
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103851);
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(103851);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.e
 * JD-Core Version:    0.7.0.1
 */