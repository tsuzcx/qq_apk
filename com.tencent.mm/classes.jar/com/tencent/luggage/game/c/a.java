package com.tencent.luggage.game.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatButton;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
  extends AppCompatButton
{
  private RectF ciM;
  private boolean ciN;
  private float ciO;
  private float ciP;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(130484);
    setGravity(17);
    setText("vConsole");
    setTextColor(-1);
    float f = getContext().getResources().getDisplayMetrics().density;
    setPadding((int)(13.0F * f), (int)(4.0F * f), (int)(13.0F * f), (int)(f * 6.0F));
    setBackgroundDrawable(new a((byte)0));
    AppMethodBeat.o(130484);
  }
  
  private boolean r(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(130485);
    if (this.ciM == null)
    {
      AppMethodBeat.o(130485);
      return false;
    }
    boolean bool = this.ciM.contains(paramFloat1, paramFloat2);
    AppMethodBeat.o(130485);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(130486);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.ciO = paramMotionEvent.getRawX();
      this.ciP = paramMotionEvent.getRawY();
      AppMethodBeat.o(130486);
      return true;
      this.ciM = new RectF(getX(), getY(), getX() + getWidth(), getY() + getHeight());
      this.ciN = false;
      continue;
      if ((this.ciN) || (!r(paramMotionEvent.getRawX(), paramMotionEvent.getRawY())))
      {
        setX(getX() + (paramMotionEvent.getRawX() - this.ciO));
        setY(getY() + (paramMotionEvent.getRawY() - this.ciP));
        requestLayout();
        this.ciN = true;
        continue;
        if ((!this.ciN) && (r(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))) {
          performClick();
        }
      }
    }
  }
  
  final class a
    extends Drawable
  {
    RectF ciQ;
    Paint paint;
    
    private a()
    {
      AppMethodBeat.i(130482);
      this.paint = new Paint(1);
      this.ciQ = new RectF();
      this.paint.setColor(-12748166);
      this.paint.setStyle(Paint.Style.FILL);
      AppMethodBeat.o(130482);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(130483);
      float f1 = paramCanvas.getHeight() / 2.0F;
      RectF localRectF1 = this.ciQ;
      this.ciQ.top = 0.0F;
      localRectF1.left = 0.0F;
      localRectF1 = this.ciQ;
      RectF localRectF2 = this.ciQ;
      float f2 = f1 * 2.0F;
      localRectF2.bottom = f2;
      localRectF1.right = f2;
      paramCanvas.drawArc(this.ciQ, 90.0F, 180.0F, false, this.paint);
      this.ciQ.left = (paramCanvas.getWidth() - f1 * 2.0F);
      this.ciQ.top = 0.0F;
      this.ciQ.right = paramCanvas.getWidth();
      this.ciQ.bottom = paramCanvas.getHeight();
      paramCanvas.drawArc(this.ciQ, -90.0F, 180.0F, false, this.paint);
      paramCanvas.drawRect(f1 - 1.0F, 0.0F, a.this.getWidth() - f1 + 1.0F, a.this.getHeight(), this.paint);
      AppMethodBeat.o(130483);
    }
    
    public final int getOpacity()
    {
      return -1;
    }
    
    public final void setAlpha(int paramInt) {}
    
    public final void setColorFilter(ColorFilter paramColorFilter) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.game.c.a
 * JD-Core Version:    0.7.0.1
 */