package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.view.View;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

public class e
  extends c<com.tencent.mm.plugin.appbrand.jsapi.e>
{
  public static final int CTRL_INDEX = 69;
  public static final String NAME = "drawCanvas";
  
  protected final boolean a(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject, final g paramg)
  {
    if (!(paramView instanceof CoverViewContainer))
    {
      y.i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of CoverViewContainer.(%s)", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    Object localObject = (View)((CoverViewContainer)paramView).K(View.class);
    y.d("MicroMsg.JsApiDrawCanvas", "drawCanvas(id : %s)", new Object[] { Integer.valueOf(paramInt) });
    if (!(localObject instanceof a))
    {
      y.i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of AppBrandDrawableView.(%s)", new Object[] { Integer.valueOf(paramInt) });
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
          paramg.tT(e.this.h("ok", null));
        }
      });
    }
    for (;;)
    {
      ((a)localObject).adB();
      y.v("MicroMsg.JsApiDrawCanvas", "post drawCanvas cost : %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return super.a(parame, paramInt, paramView, paramJSONObject, paramg);
      ((a)localObject).a(localJSONArray, new e.2(this, paramg));
    }
  }
  
  protected final boolean aik()
  {
    return true;
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("canvasId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.e
 * JD-Core Version:    0.7.0.1
 */