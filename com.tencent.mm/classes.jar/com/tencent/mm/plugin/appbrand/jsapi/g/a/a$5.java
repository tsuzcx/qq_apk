package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$5
  implements View.OnTouchListener
{
  a$5(a parama, boolean paramBoolean, ImageView paramImageView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(138415);
    int i;
    if (this.hOO)
    {
      i = paramMotionEvent.getAction();
      if (i != 0) {
        break label40;
      }
      this.hOP.setColorFilter(Color.parseColor("#88888888"));
    }
    for (;;)
    {
      AppMethodBeat.o(138415);
      return false;
      label40:
      if ((i == 3) || (i == 1)) {
        this.hOP.clearColorFilter();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.5
 * JD-Core Version:    0.7.0.1
 */