package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class LuckyAvatarParticleView
  extends View
{
  public static DisplayMetrics gjH;
  private long duration;
  private ValueAnimator ggX;
  private int okW;
  private int okX;
  private List<Rect> okY;
  private List<Integer> okZ;
  private List<Integer> ola;
  private int olb;
  private int olc;
  private int old;
  private int ole;
  private Paint paint;
  
  public LuckyAvatarParticleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42161);
    this.okY = new ArrayList();
    this.okZ = new ArrayList();
    this.ola = new ArrayList();
    this.paint = new Paint();
    AppMethodBeat.o(42161);
  }
  
  private int getRandomRectWidth()
  {
    AppMethodBeat.i(42163);
    int i = this.old;
    int j = (int)(Math.random() * (this.ole - this.old));
    AppMethodBeat.o(42163);
    return i + j;
  }
  
  private int getRandomVelocity()
  {
    AppMethodBeat.i(42162);
    int i = this.olb;
    int j = (int)(Math.random() * (this.olc - this.olb));
    AppMethodBeat.o(42162);
    return i + j;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(42164);
    super.onDraw(paramCanvas);
    int i = 0;
    while (i < this.okY.size())
    {
      paramCanvas.drawRect((Rect)this.okY.get(i), this.paint);
      i += 1;
    }
    AppMethodBeat.o(42164);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(42166);
    this.paint.setColor(paramInt);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(42166);
  }
  
  public void setDuration(long paramLong)
  {
    AppMethodBeat.i(42165);
    this.duration = paramLong;
    this.ggX = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(this.duration);
    this.ggX.addUpdateListener(new LuckyAvatarParticleView.1(this));
    AppMethodBeat.o(42165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyAvatarParticleView
 * JD-Core Version:    0.7.0.1
 */