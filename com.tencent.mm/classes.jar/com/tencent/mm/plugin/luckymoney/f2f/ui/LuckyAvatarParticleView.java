package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
  public static DisplayMetrics metrics;
  private ValueAnimator animator;
  private long duration;
  private Paint paint;
  private int ySc;
  private int ySd;
  private List<Rect> ySe;
  private List<Integer> ySf;
  private List<Integer> ySg;
  private int ySh;
  private int ySi;
  private int ySj;
  private int ySk;
  
  public LuckyAvatarParticleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65051);
    this.ySe = new ArrayList();
    this.ySf = new ArrayList();
    this.ySg = new ArrayList();
    this.paint = new Paint();
    AppMethodBeat.o(65051);
  }
  
  private int getRandomRectWidth()
  {
    AppMethodBeat.i(65053);
    int i = this.ySj;
    int j = (int)(Math.random() * (this.ySk - this.ySj));
    AppMethodBeat.o(65053);
    return i + j;
  }
  
  private int getRandomVelocity()
  {
    AppMethodBeat.i(65052);
    int i = this.ySh;
    int j = (int)(Math.random() * (this.ySi - this.ySh));
    AppMethodBeat.o(65052);
    return i + j;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(65054);
    super.onDraw(paramCanvas);
    int i = 0;
    while (i < this.ySe.size())
    {
      paramCanvas.drawRect((Rect)this.ySe.get(i), this.paint);
      i += 1;
    }
    AppMethodBeat.o(65054);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(65056);
    this.paint.setColor(paramInt);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(65056);
  }
  
  public void setDuration(long paramLong)
  {
    AppMethodBeat.i(65055);
    this.duration = paramLong;
    this.animator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(this.duration);
    this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(65050);
        if (((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() == 1.0F)
        {
          LuckyAvatarParticleView.a(LuckyAvatarParticleView.this).clear();
          LuckyAvatarParticleView.b(LuckyAvatarParticleView.this).clear();
          LuckyAvatarParticleView.c(LuckyAvatarParticleView.this).clear();
        }
        for (;;)
        {
          LuckyAvatarParticleView.this.invalidate();
          AppMethodBeat.o(65050);
          return;
          if (((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() == 0.0F)
          {
            LuckyAvatarParticleView.d(LuckyAvatarParticleView.this);
          }
          else
          {
            int i = 0;
            while (i < LuckyAvatarParticleView.a(LuckyAvatarParticleView.this).size())
            {
              LuckyAvatarParticleView.a(LuckyAvatarParticleView.this, i);
              i += 1;
            }
          }
        }
      }
    });
    AppMethodBeat.o(65055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyAvatarParticleView
 * JD-Core Version:    0.7.0.1
 */