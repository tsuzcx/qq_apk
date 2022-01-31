package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

final class a$4
  implements View.OnTouchListener
{
  a$4(a parama, boolean paramBoolean, ImageView paramImageView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i;
    if (this.gtY)
    {
      i = paramMotionEvent.getAction();
      if (i != 0) {
        break label30;
      }
      this.gtZ.setColorFilter(Color.parseColor("#88888888"));
    }
    for (;;)
    {
      return false;
      label30:
      if ((i == 3) || (i == 1)) {
        this.gtZ.clearColorFilter();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.4
 * JD-Core Version:    0.7.0.1
 */