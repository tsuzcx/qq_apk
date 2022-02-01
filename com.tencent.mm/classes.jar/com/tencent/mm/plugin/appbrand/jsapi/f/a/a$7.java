package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$7
  implements View.OnTouchListener
{
  a$7(a parama, boolean paramBoolean, ImageView paramImageView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(146466);
    int i;
    if (this.kve)
    {
      i = paramMotionEvent.getAction();
      if (i != 0) {
        break label40;
      }
      this.kvf.setColorFilter(Color.parseColor("#88888888"));
    }
    for (;;)
    {
      AppMethodBeat.o(146466);
      return false;
      label40:
      if ((i == 3) || (i == 1)) {
        this.kvf.clearColorFilter();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.a.a.7
 * JD-Core Version:    0.7.0.1
 */