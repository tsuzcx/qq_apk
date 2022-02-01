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
  private RectF bYu;
  private boolean bYv;
  private float bYw;
  private float bYx;
  
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
  
  private boolean p(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(130485);
    if (this.bYu == null)
    {
      AppMethodBeat.o(130485);
      return false;
    }
    boolean bool = this.bYu.contains(paramFloat1, paramFloat2);
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
      this.bYw = paramMotionEvent.getRawX();
      this.bYx = paramMotionEvent.getRawY();
      AppMethodBeat.o(130486);
      return true;
      this.bYu = new RectF(getX(), getY(), getX() + getWidth(), getY() + getHeight());
      this.bYv = false;
      continue;
      if ((this.bYv) || (!p(paramMotionEvent.getRawX(), paramMotionEvent.getRawY())))
      {
        setX(getX() + (paramMotionEvent.getRawX() - this.bYw));
        setY(getY() + (paramMotionEvent.getRawY() - this.bYx));
        requestLayout();
        this.bYv = true;
        continue;
        if ((!this.bYv) && (p(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))) {
          performClick();
        }
      }
    }
  }
  
  final class a
    extends Drawable
  {
    RectF bYy;
    Paint paint;
    
    private a()
    {
      AppMethodBeat.i(130482);
      this.paint = new Paint(1);
      this.bYy = new RectF();
      this.paint.setColor(-12748166);
      this.paint.setStyle(Paint.Style.FILL);
      AppMethodBeat.o(130482);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(130483);
      float f1 = paramCanvas.getHeight() / 2.0F;
      RectF localRectF1 = this.bYy;
      this.bYy.top = 0.0F;
      localRectF1.left = 0.0F;
      localRectF1 = this.bYy;
      RectF localRectF2 = this.bYy;
      float f2 = f1 * 2.0F;
      localRectF2.bottom = f2;
      localRectF1.right = f2;
      paramCanvas.drawArc(this.bYy, 90.0F, 180.0F, false, this.paint);
      this.bYy.left = (paramCanvas.getWidth() - f1 * 2.0F);
      this.bYy.top = 0.0F;
      this.bYy.right = paramCanvas.getWidth();
      this.bYy.bottom = paramCanvas.getHeight();
      paramCanvas.drawArc(this.bYy, -90.0F, 180.0F, false, this.paint);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.c.a
 * JD-Core Version:    0.7.0.1
 */