package com.tencent.mm.plugin.appbrand.game.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatButton;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

final class a
  extends AppCompatButton
{
  private RectF gaV;
  private boolean gaW;
  private float gaX;
  private float gaY;
  
  public a(Context paramContext)
  {
    super(paramContext);
    setGravity(17);
    setText("vConsole");
    setTextColor(-1);
    float f = getContext().getResources().getDisplayMetrics().density;
    setPadding((int)(13.0F * f), (int)(4.0F * f), (int)(13.0F * f), (int)(f * 6.0F));
    setBackgroundDrawable(new a.a(this, (byte)0));
  }
  
  private boolean E(float paramFloat1, float paramFloat2)
  {
    if (this.gaV == null) {
      return false;
    }
    return this.gaV.contains(paramFloat1, paramFloat2);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.gaX = paramMotionEvent.getRawX();
      this.gaY = paramMotionEvent.getRawY();
      return true;
      this.gaV = new RectF(getX(), getY(), getX() + getWidth(), getY() + getHeight());
      this.gaW = false;
      continue;
      if ((this.gaW) || (!E(paramMotionEvent.getRawX(), paramMotionEvent.getRawY())))
      {
        setX(getX() + (paramMotionEvent.getRawX() - this.gaX));
        setY(getY() + (paramMotionEvent.getRawY() - this.gaY));
        requestLayout();
        this.gaW = true;
        continue;
        if ((!this.gaW) && (E(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))) {
          performClick();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.a
 * JD-Core Version:    0.7.0.1
 */