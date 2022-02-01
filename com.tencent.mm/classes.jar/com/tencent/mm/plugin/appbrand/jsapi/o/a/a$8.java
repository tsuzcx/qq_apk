package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$8
  implements View.OnTouchListener
{
  a$8(a parama, boolean paramBoolean, ImageView paramImageView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(329459);
    int i;
    if (this.scY)
    {
      i = paramMotionEvent.getAction();
      if (i != 0) {
        break label40;
      }
      this.scZ.setColorFilter(Color.parseColor("#88888888"));
    }
    for (;;)
    {
      AppMethodBeat.o(329459);
      return false;
      label40:
      if ((i == 3) || (i == 1)) {
        this.scZ.clearColorFilter();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.a.8
 * JD-Core Version:    0.7.0.1
 */