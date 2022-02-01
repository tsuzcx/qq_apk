package com.tencent.mm.plugin.appbrand.jsapi.i.a;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class a$7
  implements View.OnTouchListener
{
  a$7(a parama, boolean paramBoolean, ImageView paramImageView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(146466);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/map/mapsdk/DefaultTencentMapView$18", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    int i;
    if (this.kUz)
    {
      i = paramMotionEvent.getAction();
      if (i != 0) {
        break label91;
      }
      this.kUA.setColorFilter(Color.parseColor("#88888888"));
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/jsapi/map/mapsdk/DefaultTencentMapView$18", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(146466);
      return false;
      label91:
      if ((i == 3) || (i == 1)) {
        this.kUA.clearColorFilter();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.a.a.7
 * JD-Core Version:    0.7.0.1
 */