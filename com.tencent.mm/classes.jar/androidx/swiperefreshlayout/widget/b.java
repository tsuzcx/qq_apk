package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.f.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends Drawable
  implements Animatable
{
  private static final Interpolator aof;
  private static final Interpolator aog;
  private static final int[] aoh;
  private Animator Vp;
  final a aoi;
  private float aoj;
  float aok;
  boolean aol;
  private Resources mResources;
  
  static
  {
    AppMethodBeat.i(256345);
    aof = new LinearInterpolator();
    aog = new androidx.f.a.a.b();
    aoh = new int[] { -16777216 };
    AppMethodBeat.o(256345);
  }
  
  public b(final Context paramContext)
  {
    AppMethodBeat.i(256323);
    this.mResources = ((Context)g.checkNotNull(paramContext)).getResources();
    this.aoi = new a();
    this.aoi.setColors(aoh);
    this.aoi.setStrokeWidth(2.5F);
    invalidateSelf();
    paramContext = this.aoi;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(256300);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        b.a(f, paramContext);
        b.this.a(f, paramContext, false);
        b.this.invalidateSelf();
        AppMethodBeat.o(256300);
      }
    });
    localValueAnimator.setRepeatCount(-1);
    localValueAnimator.setRepeatMode(1);
    localValueAnimator.setInterpolator(aof);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(256302);
        b.this.a(1.0F, paramContext, true);
        paramContext.mY();
        b.a locala = paramContext;
        locala.dv(locala.mW());
        if (b.this.aol)
        {
          b.this.aol = false;
          paramAnonymousAnimator.cancel();
          paramAnonymousAnimator.setDuration(1332L);
          paramAnonymousAnimator.start();
          paramContext.aC(false);
          AppMethodBeat.o(256302);
          return;
        }
        b.this.aok += 1.0F;
        AppMethodBeat.o(256302);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        b.this.aok = 0.0F;
      }
    });
    this.Vp = localValueAnimator;
    AppMethodBeat.o(256323);
  }
  
  static void a(float paramFloat, a parama)
  {
    AppMethodBeat.i(256343);
    if (paramFloat > 0.75F)
    {
      paramFloat = (paramFloat - 0.75F) / 0.25F;
      int n = parama.mX();
      int i = parama.mColors[parama.mW()];
      int j = n >> 24 & 0xFF;
      int k = n >> 16 & 0xFF;
      int m = n >> 8 & 0xFF;
      n &= 0xFF;
      int i1 = (int)(((i >> 24 & 0xFF) - j) * paramFloat);
      int i2 = (int)(((i >> 16 & 0xFF) - k) * paramFloat);
      int i3 = (int)(((i >> 8 & 0xFF) - m) * paramFloat);
      parama.KZ = ((int)(paramFloat * ((i & 0xFF) - n)) + n | j + i1 << 24 | k + i2 << 16 | i3 + m << 8);
      AppMethodBeat.o(256343);
      return;
    }
    parama.KZ = parama.mX();
    AppMethodBeat.o(256343);
  }
  
  private void c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(256324);
    a locala = this.aoi;
    float f = this.mResources.getDisplayMetrics().density;
    locala.setStrokeWidth(paramFloat2 * f);
    locala.aoz = (paramFloat1 * f);
    locala.dv(0);
    locala.aoA = ((int)(paramFloat3 * f));
    locala.aoB = ((int)(f * paramFloat4));
    AppMethodBeat.o(256324);
  }
  
  final void a(float paramFloat, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(256344);
    float f1;
    float f2;
    if (this.aol)
    {
      a(paramFloat, parama);
      f1 = (float)(Math.floor(parama.aow / 0.8F) + 1.0D);
      parama.aor = (parama.aou + (parama.aov - 0.01F - parama.aou) * paramFloat);
      parama.aos = parama.aov;
      f2 = parama.aow;
      parama.aoj = ((f1 - parama.aow) * paramFloat + f2);
      AppMethodBeat.o(256344);
      return;
    }
    float f3;
    if ((paramFloat != 1.0F) || (paramBoolean))
    {
      f3 = parama.aow;
      if (paramFloat >= 0.5F) {
        break label194;
      }
      f1 = paramFloat / 0.5F;
      f2 = parama.aou;
      f1 = aog.getInterpolation(f1) * 0.79F + 0.01F + f2;
    }
    for (;;)
    {
      float f4 = this.aok;
      parama.aor = f2;
      parama.aos = f1;
      parama.aoj = (f3 + 0.21F * paramFloat);
      this.aoj = (216.0F * (f4 + paramFloat));
      AppMethodBeat.o(256344);
      return;
      label194:
      f2 = (paramFloat - 0.5F) / 0.5F;
      f1 = parama.aou + 0.79F;
      f2 = f1 - ((1.0F - aog.getInterpolation(f2)) * 0.79F + 0.01F);
    }
  }
  
  public final void aB(boolean paramBoolean)
  {
    AppMethodBeat.i(256328);
    this.aoi.aC(paramBoolean);
    invalidateSelf();
    AppMethodBeat.o(256328);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(256334);
    Rect localRect = getBounds();
    paramCanvas.save();
    paramCanvas.rotate(this.aoj, localRect.exactCenterX(), localRect.exactCenterY());
    a locala = this.aoi;
    RectF localRectF = locala.aoo;
    float f1 = locala.aoz + locala.mStrokeWidth / 2.0F;
    if (locala.aoz <= 0.0F) {
      f1 = Math.min(localRect.width(), localRect.height()) / 2.0F - Math.max(locala.aoA * locala.aoy / 2.0F, locala.mStrokeWidth / 2.0F);
    }
    localRectF.set(localRect.centerX() - f1, localRect.centerY() - f1, localRect.centerX() + f1, f1 + localRect.centerY());
    f1 = (locala.aor + locala.aoj) * 360.0F;
    float f2 = (locala.aos + locala.aoj) * 360.0F - f1;
    locala.mPaint.setColor(locala.KZ);
    locala.mPaint.setAlpha(locala.mAlpha);
    float f3 = locala.mStrokeWidth / 2.0F;
    localRectF.inset(f3, f3);
    paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localRectF.width() / 2.0F, locala.aoq);
    localRectF.inset(-f3, -f3);
    paramCanvas.drawArc(localRectF, f1, f2, false, locala.mPaint);
    if (locala.mShowArrow)
    {
      if (locala.aox != null) {
        break label532;
      }
      locala.aox = new Path();
      locala.aox.setFillType(Path.FillType.EVEN_ODD);
    }
    for (;;)
    {
      f3 = Math.min(localRectF.width(), localRectF.height()) / 2.0F;
      float f4 = locala.aoA * locala.aoy / 2.0F;
      locala.aox.moveTo(0.0F, 0.0F);
      locala.aox.lineTo(locala.aoA * locala.aoy, 0.0F);
      locala.aox.lineTo(locala.aoA * locala.aoy / 2.0F, locala.aoB * locala.aoy);
      locala.aox.offset(f3 + localRectF.centerX() - f4, localRectF.centerY() + locala.mStrokeWidth / 2.0F);
      locala.aox.close();
      locala.aop.setColor(locala.KZ);
      locala.aop.setAlpha(locala.mAlpha);
      paramCanvas.save();
      paramCanvas.rotate(f1 + f2, localRectF.centerX(), localRectF.centerY());
      paramCanvas.drawPath(locala.aox, locala.aop);
      paramCanvas.restore();
      paramCanvas.restore();
      AppMethodBeat.o(256334);
      return;
      label532:
      locala.aox.reset();
    }
  }
  
  public final int getAlpha()
  {
    return this.aoi.mAlpha;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(256340);
    boolean bool = this.Vp.isRunning();
    AppMethodBeat.o(256340);
    return bool;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(256336);
    this.aoi.mAlpha = paramInt;
    invalidateSelf();
    AppMethodBeat.o(256336);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(256338);
    this.aoi.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
    AppMethodBeat.o(256338);
  }
  
  public final void setStyle(int paramInt)
  {
    AppMethodBeat.i(256326);
    if (paramInt == 0) {
      c(11.0F, 3.0F, 12.0F, 6.0F);
    }
    for (;;)
    {
      invalidateSelf();
      AppMethodBeat.o(256326);
      return;
      c(7.5F, 2.5F, 10.0F, 5.0F);
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(256341);
    this.Vp.cancel();
    this.aoi.mY();
    if (this.aoi.aos != this.aoi.aor)
    {
      this.aol = true;
      this.Vp.setDuration(666L);
      this.Vp.start();
      AppMethodBeat.o(256341);
      return;
    }
    this.aoi.dv(0);
    this.aoi.mZ();
    this.Vp.setDuration(1332L);
    this.Vp.start();
    AppMethodBeat.o(256341);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(256342);
    this.Vp.cancel();
    this.aoj = 0.0F;
    this.aoi.aC(false);
    this.aoi.dv(0);
    this.aoi.mZ();
    invalidateSelf();
    AppMethodBeat.o(256342);
  }
  
  public final void v(float paramFloat)
  {
    AppMethodBeat.i(256330);
    a locala = this.aoi;
    if (paramFloat != locala.aoy) {
      locala.aoy = paramFloat;
    }
    invalidateSelf();
    AppMethodBeat.o(256330);
  }
  
  public final void w(float paramFloat)
  {
    AppMethodBeat.i(256331);
    this.aoi.aor = 0.0F;
    this.aoi.aos = paramFloat;
    invalidateSelf();
    AppMethodBeat.o(256331);
  }
  
  public final void x(float paramFloat)
  {
    AppMethodBeat.i(256333);
    this.aoi.aoj = paramFloat;
    invalidateSelf();
    AppMethodBeat.o(256333);
  }
  
  static final class a
  {
    int KZ;
    int aoA;
    int aoB;
    float aoj;
    final RectF aoo;
    final Paint aop;
    final Paint aoq;
    float aor;
    float aos;
    int aot;
    float aou;
    float aov;
    float aow;
    Path aox;
    float aoy;
    float aoz;
    int mAlpha;
    int[] mColors;
    final Paint mPaint;
    boolean mShowArrow;
    float mStrokeWidth;
    
    a()
    {
      AppMethodBeat.i(256305);
      this.aoo = new RectF();
      this.mPaint = new Paint();
      this.aop = new Paint();
      this.aoq = new Paint();
      this.aor = 0.0F;
      this.aos = 0.0F;
      this.aoj = 0.0F;
      this.mStrokeWidth = 5.0F;
      this.aoy = 1.0F;
      this.mAlpha = 255;
      this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.aop.setStyle(Paint.Style.FILL);
      this.aop.setAntiAlias(true);
      this.aoq.setColor(0);
      AppMethodBeat.o(256305);
    }
    
    final void aC(boolean paramBoolean)
    {
      if (this.mShowArrow != paramBoolean) {
        this.mShowArrow = paramBoolean;
      }
    }
    
    final void dv(int paramInt)
    {
      this.aot = paramInt;
      this.KZ = this.mColors[this.aot];
    }
    
    final int mW()
    {
      return (this.aot + 1) % this.mColors.length;
    }
    
    final int mX()
    {
      return this.mColors[this.aot];
    }
    
    final void mY()
    {
      this.aou = this.aor;
      this.aov = this.aos;
      this.aow = this.aoj;
    }
    
    final void mZ()
    {
      this.aou = 0.0F;
      this.aov = 0.0F;
      this.aow = 0.0F;
      this.aor = 0.0F;
      this.aos = 0.0F;
      this.aoj = 0.0F;
    }
    
    final void setColors(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(256306);
      this.mColors = paramArrayOfInt;
      dv(0);
      AppMethodBeat.o(256306);
    }
    
    final void setStrokeWidth(float paramFloat)
    {
      AppMethodBeat.i(256310);
      this.mStrokeWidth = paramFloat;
      this.mPaint.setStrokeWidth(paramFloat);
      AppMethodBeat.o(256310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.swiperefreshlayout.widget.b
 * JD-Core Version:    0.7.0.1
 */