package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONArray;
import org.json.JSONObject;

public class f
  extends c<e>
{
  public static final int CTRL_INDEX = 69;
  public static final String NAME = "drawCanvas";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145537);
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(145537);
    return i;
  }
  
  public final boolean aYw()
  {
    return true;
  }
  
  public final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject, final g paramg)
  {
    AppMethodBeat.i(145538);
    if (!(paramView instanceof CoverViewContainer))
    {
      ad.i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of CoverViewContainer.(%s)", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145538);
      return false;
    }
    Object localObject = (View)((CoverViewContainer)paramView).ax(View.class);
    ad.d("MicroMsg.JsApiDrawCanvas", "drawCanvas(id : %s)", new Object[] { Integer.valueOf(paramInt) });
    if (!(localObject instanceof a))
    {
      ad.i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of AppBrandDrawableView.(%s)", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145538);
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
          AppMethodBeat.i(145535);
          paramg.HQ(f.this.e("ok", null));
          AppMethodBeat.o(145535);
        }
      });
    }
    for (;;)
    {
      ((a)localObject).aSM();
      ad.v("MicroMsg.JsApiDrawCanvas", "post drawCanvas cost : %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      bool = super.b(parame, paramInt, paramView, paramJSONObject, paramg);
      AppMethodBeat.o(145538);
      return bool;
      ((a)localObject).a(localJSONArray, new a.a()
      {
        public final void a(DrawCanvasArg paramAnonymousDrawCanvasArg)
        {
          AppMethodBeat.i(145536);
          paramg.HQ(f.this.e("ok", null));
          AppMethodBeat.o(145536);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.f
 * JD-Core Version:    0.7.0.1
 */