package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.base.i;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public class f
  extends d<h>
{
  public static final int CTRL_INDEX = 69;
  public static final String NAME = "drawCanvas";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145537);
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(145537);
    return i;
  }
  
  public final boolean b(h paramh, int paramInt, View paramView, JSONObject paramJSONObject, final i parami)
  {
    AppMethodBeat.i(145538);
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of CoverViewContainer.(%s)", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145538);
      return false;
    }
    Object localObject = (View)((CoverViewContainer)paramView).aT(View.class);
    Log.d("MicroMsg.JsApiDrawCanvas", "drawCanvas(id : %s)", new Object[] { Integer.valueOf(paramInt) });
    if (!(localObject instanceof a))
    {
      Log.i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of AppBrandDrawableView.(%s)", new Object[] { Integer.valueOf(paramInt) });
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
          parami.aal(f.this.ZP("ok"));
          AppMethodBeat.o(145535);
        }
      });
    }
    for (;;)
    {
      ((a)localObject).cjV();
      Log.v("MicroMsg.JsApiDrawCanvas", "post drawCanvas cost : %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      bool = super.b(paramh, paramInt, paramView, paramJSONObject, parami);
      AppMethodBeat.o(145538);
      return bool;
      ((a)localObject).a(localJSONArray, new a.a()
      {
        public final void a(DrawCanvasArg paramAnonymousDrawCanvasArg)
        {
          AppMethodBeat.i(145536);
          parami.aal(f.this.ZP("ok"));
          AppMethodBeat.o(145536);
        }
      });
    }
  }
  
  public final boolean cqw()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.f
 * JD-Core Version:    0.7.0.1
 */