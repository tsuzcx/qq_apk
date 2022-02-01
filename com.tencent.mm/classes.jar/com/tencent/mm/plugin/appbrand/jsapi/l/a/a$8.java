package com.tencent.mm.plugin.appbrand.jsapi.l.a;

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
    AppMethodBeat.i(186801);
    int i;
    if (this.oXy)
    {
      i = paramMotionEvent.getAction();
      if (i != 0) {
        break label40;
      }
      this.oXz.setColorFilter(Color.parseColor("#88888888"));
    }
    for (;;)
    {
      AppMethodBeat.o(186801);
      return false;
      label40:
      if ((i == 3) || (i == 1)) {
        this.oXz.clearColorFilter();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.a.a.8
 * JD-Core Version:    0.7.0.1
 */