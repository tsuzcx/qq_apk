package com.tencent.luggage.game.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatButton;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
  extends AppCompatButton
{
  private RectF bAh;
  private boolean bAi;
  private float bAj;
  private float bAk;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(140364);
    setGravity(17);
    setText("vConsole");
    setTextColor(-1);
    float f = getContext().getResources().getDisplayMetrics().density;
    setPadding((int)(13.0F * f), (int)(4.0F * f), (int)(13.0F * f), (int)(f * 6.0F));
    setBackgroundDrawable(new a.a(this, (byte)0));
    AppMethodBeat.o(140364);
  }
  
  private boolean z(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(140365);
    if (this.bAh == null)
    {
      AppMethodBeat.o(140365);
      return false;
    }
    boolean bool = this.bAh.contains(paramFloat1, paramFloat2);
    AppMethodBeat.o(140365);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140366);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.bAj = paramMotionEvent.getRawX();
      this.bAk = paramMotionEvent.getRawY();
      AppMethodBeat.o(140366);
      return true;
      this.bAh = new RectF(getX(), getY(), getX() + getWidth(), getY() + getHeight());
      this.bAi = false;
      continue;
      if ((this.bAi) || (!z(paramMotionEvent.getRawX(), paramMotionEvent.getRawY())))
      {
        setX(getX() + (paramMotionEvent.getRawX() - this.bAj));
        setY(getY() + (paramMotionEvent.getRawY() - this.bAk));
        requestLayout();
        this.bAi = true;
        continue;
        if ((!this.bAi) && (z(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))) {
          performClick();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.game.d.a
 * JD-Core Version:    0.7.0.1
 */