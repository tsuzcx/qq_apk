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
  public static DisplayMetrics iQv;
  private ValueAnimator animator;
  private long duration;
  private Paint paint;
  private int vxO;
  private int vxP;
  private List<Rect> vxQ;
  private List<Integer> vxR;
  private List<Integer> vxS;
  private int vxT;
  private int vxU;
  private int vxV;
  private int vxW;
  
  public LuckyAvatarParticleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65051);
    this.vxQ = new ArrayList();
    this.vxR = new ArrayList();
    this.vxS = new ArrayList();
    this.paint = new Paint();
    AppMethodBeat.o(65051);
  }
  
  private int getRandomRectWidth()
  {
    AppMethodBeat.i(65053);
    int i = this.vxV;
    int j = (int)(Math.random() * (this.vxW - this.vxV));
    AppMethodBeat.o(65053);
    return i + j;
  }
  
  private int getRandomVelocity()
  {
    AppMethodBeat.i(65052);
    int i = this.vxT;
    int j = (int)(Math.random() * (this.vxU - this.vxT));
    AppMethodBeat.o(65052);
    return i + j;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(65054);
    super.onDraw(paramCanvas);
    int i = 0;
    while (i < this.vxQ.size())
    {
      paramCanvas.drawRect((Rect)this.vxQ.get(i), this.paint);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyAvatarParticleView
 * JD-Core Version:    0.7.0.1
 */