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
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends Drawable
  implements Animatable
{
  private static final Interpolator ccP;
  private static final Interpolator ccQ;
  private static final int[] ccR;
  private Animator bBZ;
  final a ccS;
  private float ccT;
  float ccU;
  boolean ccV;
  private Resources mResources;
  
  static
  {
    AppMethodBeat.i(193262);
    ccP = new LinearInterpolator();
    ccQ = new androidx.g.a.a.b();
    ccR = new int[] { -16777216 };
    AppMethodBeat.o(193262);
  }
  
  public b(final Context paramContext)
  {
    AppMethodBeat.i(193238);
    this.mResources = ((Context)f.checkNotNull(paramContext)).getResources();
    this.ccS = new a();
    this.ccS.setColors(ccR);
    this.ccS.setStrokeWidth(2.5F);
    invalidateSelf();
    paramContext = this.ccS;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(193235);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        b.a(f, paramContext);
        b.this.a(f, paramContext, false);
        b.this.invalidateSelf();
        AppMethodBeat.o(193235);
      }
    });
    localValueAnimator.setRepeatCount(-1);
    localValueAnimator.setRepeatMode(1);
    localValueAnimator.setInterpolator(ccP);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(193249);
        b.this.a(1.0F, paramContext, true);
        paramContext.LA();
        b.a locala = paramContext;
        locala.gF(locala.Ly());
        if (b.this.ccV)
        {
          b.this.ccV = false;
          paramAnonymousAnimator.cancel();
          paramAnonymousAnimator.setDuration(1332L);
          paramAnonymousAnimator.start();
          paramContext.bk(false);
          AppMethodBeat.o(193249);
          return;
        }
        b.this.ccU += 1.0F;
        AppMethodBeat.o(193249);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        b.this.ccU = 0.0F;
      }
    });
    this.bBZ = localValueAnimator;
    AppMethodBeat.o(193238);
  }
  
  static void a(float paramFloat, a parama)
  {
    AppMethodBeat.i(193257);
    if (paramFloat > 0.75F)
    {
      paramFloat = (paramFloat - 0.75F) / 0.25F;
      int n = parama.Lz();
      int i = parama.mColors[parama.Ly()];
      int j = n >> 24 & 0xFF;
      int k = n >> 16 & 0xFF;
      int m = n >> 8 & 0xFF;
      n &= 0xFF;
      int i1 = (int)(((i >> 24 & 0xFF) - j) * paramFloat);
      int i2 = (int)(((i >> 16 & 0xFF) - k) * paramFloat);
      int i3 = (int)(((i >> 8 & 0xFF) - m) * paramFloat);
      parama.bri = ((int)(paramFloat * ((i & 0xFF) - n)) + n | j + i1 << 24 | k + i2 << 16 | i3 + m << 8);
      AppMethodBeat.o(193257);
      return;
    }
    parama.bri = parama.Lz();
    AppMethodBeat.o(193257);
  }
  
  private void g(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(193245);
    a locala = this.ccS;
    float f = this.mResources.getDisplayMetrics().density;
    locala.setStrokeWidth(paramFloat2 * f);
    locala.cdj = (paramFloat1 * f);
    locala.gF(0);
    locala.cdk = ((int)(paramFloat3 * f));
    locala.cdl = ((int)(f * paramFloat4));
    AppMethodBeat.o(193245);
  }
  
  final void a(float paramFloat, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(193367);
    float f1;
    float f2;
    if (this.ccV)
    {
      a(paramFloat, parama);
      f1 = (float)(Math.floor(parama.cdg / 0.8F) + 1.0D);
      parama.cdb = (parama.cde + (parama.cdf - 0.01F - parama.cde) * paramFloat);
      parama.cdc = parama.cdf;
      f2 = parama.cdg;
      parama.ccT = ((f1 - parama.cdg) * paramFloat + f2);
      AppMethodBeat.o(193367);
      return;
    }
    float f3;
    if ((paramFloat != 1.0F) || (paramBoolean))
    {
      f3 = parama.cdg;
      if (paramFloat >= 0.5F) {
        break label194;
      }
      f1 = paramFloat / 0.5F;
      f2 = parama.cde;
      f1 = ccQ.getInterpolation(f1) * 0.79F + 0.01F + f2;
    }
    for (;;)
    {
      float f4 = this.ccU;
      parama.cdb = f2;
      parama.cdc = f1;
      parama.ccT = (f3 + 0.21F * paramFloat);
      this.ccT = (216.0F * (f4 + paramFloat));
      AppMethodBeat.o(193367);
      return;
      label194:
      f2 = (paramFloat - 0.5F) / 0.5F;
      f1 = parama.cde + 0.79F;
      f2 = f1 - ((1.0F - ccQ.getInterpolation(f2)) * 0.79F + 0.01F);
    }
  }
  
  public final void aC(float paramFloat)
  {
    AppMethodBeat.i(193285);
    a locala = this.ccS;
    if (paramFloat != locala.cdi) {
      locala.cdi = paramFloat;
    }
    invalidateSelf();
    AppMethodBeat.o(193285);
  }
  
  public final void aD(float paramFloat)
  {
    AppMethodBeat.i(193290);
    this.ccS.cdb = 0.0F;
    this.ccS.cdc = paramFloat;
    invalidateSelf();
    AppMethodBeat.o(193290);
  }
  
  public final void aE(float paramFloat)
  {
    AppMethodBeat.i(193298);
    this.ccS.ccT = paramFloat;
    invalidateSelf();
    AppMethodBeat.o(193298);
  }
  
  public final void bj(boolean paramBoolean)
  {
    AppMethodBeat.i(193278);
    this.ccS.bk(paramBoolean);
    invalidateSelf();
    AppMethodBeat.o(193278);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(193316);
    Rect localRect = getBounds();
    paramCanvas.save();
    paramCanvas.rotate(this.ccT, localRect.exactCenterX(), localRect.exactCenterY());
    a locala = this.ccS;
    RectF localRectF = locala.ccY;
    float f1 = locala.cdj + locala.mStrokeWidth / 2.0F;
    if (locala.cdj <= 0.0F) {
      f1 = Math.min(localRect.width(), localRect.height()) / 2.0F - Math.max(locala.cdk * locala.cdi / 2.0F, locala.mStrokeWidth / 2.0F);
    }
    localRectF.set(localRect.centerX() - f1, localRect.centerY() - f1, localRect.centerX() + f1, f1 + localRect.centerY());
    f1 = (locala.cdb + locala.ccT) * 360.0F;
    float f2 = (locala.cdc + locala.ccT) * 360.0F - f1;
    locala.mPaint.setColor(locala.bri);
    locala.mPaint.setAlpha(locala.mAlpha);
    float f3 = locala.mStrokeWidth / 2.0F;
    localRectF.inset(f3, f3);
    paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localRectF.width() / 2.0F, locala.cda);
    localRectF.inset(-f3, -f3);
    paramCanvas.drawArc(localRectF, f1, f2, false, locala.mPaint);
    if (locala.mShowArrow)
    {
      if (locala.cdh != null) {
        break label532;
      }
      locala.cdh = new Path();
      locala.cdh.setFillType(Path.FillType.EVEN_ODD);
    }
    for (;;)
    {
      f3 = Math.min(localRectF.width(), localRectF.height()) / 2.0F;
      float f4 = locala.cdk * locala.cdi / 2.0F;
      locala.cdh.moveTo(0.0F, 0.0F);
      locala.cdh.lineTo(locala.cdk * locala.cdi, 0.0F);
      locala.cdh.lineTo(locala.cdk * locala.cdi / 2.0F, locala.cdl * locala.cdi);
      locala.cdh.offset(f3 + localRectF.centerX() - f4, localRectF.centerY() + locala.mStrokeWidth / 2.0F);
      locala.cdh.close();
      locala.ccZ.setColor(locala.bri);
      locala.ccZ.setAlpha(locala.mAlpha);
      paramCanvas.save();
      paramCanvas.rotate(f1 + f2, localRectF.centerX(), localRectF.centerY());
      paramCanvas.drawPath(locala.cdh, locala.ccZ);
      paramCanvas.restore();
      paramCanvas.restore();
      AppMethodBeat.o(193316);
      return;
      label532:
      locala.cdh.reset();
    }
  }
  
  public final int getAlpha()
  {
    return this.ccS.mAlpha;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(193345);
    boolean bool = this.bBZ.isRunning();
    AppMethodBeat.o(193345);
    return bool;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(193321);
    this.ccS.mAlpha = paramInt;
    invalidateSelf();
    AppMethodBeat.o(193321);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(193332);
    this.ccS.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
    AppMethodBeat.o(193332);
  }
  
  public final void setStyle(int paramInt)
  {
    AppMethodBeat.i(193272);
    if (paramInt == 0) {
      g(11.0F, 3.0F, 12.0F, 6.0F);
    }
    for (;;)
    {
      invalidateSelf();
      AppMethodBeat.o(193272);
      return;
      g(7.5F, 2.5F, 10.0F, 5.0F);
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(193351);
    this.bBZ.cancel();
    this.ccS.LA();
    if (this.ccS.cdc != this.ccS.cdb)
    {
      this.ccV = true;
      this.bBZ.setDuration(666L);
      this.bBZ.start();
      AppMethodBeat.o(193351);
      return;
    }
    this.ccS.gF(0);
    this.ccS.LB();
    this.bBZ.setDuration(1332L);
    this.bBZ.start();
    AppMethodBeat.o(193351);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(193357);
    this.bBZ.cancel();
    this.ccT = 0.0F;
    this.ccS.bk(false);
    this.ccS.gF(0);
    this.ccS.LB();
    invalidateSelf();
    AppMethodBeat.o(193357);
  }
  
  static final class a
  {
    int bri;
    float ccT;
    final RectF ccY;
    final Paint ccZ;
    final Paint cda;
    float cdb;
    float cdc;
    int cdd;
    float cde;
    float cdf;
    float cdg;
    Path cdh;
    float cdi;
    float cdj;
    int cdk;
    int cdl;
    int mAlpha;
    int[] mColors;
    final Paint mPaint;
    boolean mShowArrow;
    float mStrokeWidth;
    
    a()
    {
      AppMethodBeat.i(193237);
      this.ccY = new RectF();
      this.mPaint = new Paint();
      this.ccZ = new Paint();
      this.cda = new Paint();
      this.cdb = 0.0F;
      this.cdc = 0.0F;
      this.ccT = 0.0F;
      this.mStrokeWidth = 5.0F;
      this.cdi = 1.0F;
      this.mAlpha = 255;
      this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.ccZ.setStyle(Paint.Style.FILL);
      this.ccZ.setAntiAlias(true);
      this.cda.setColor(0);
      AppMethodBeat.o(193237);
    }
    
    final void LA()
    {
      this.cde = this.cdb;
      this.cdf = this.cdc;
      this.cdg = this.ccT;
    }
    
    final void LB()
    {
      this.cde = 0.0F;
      this.cdf = 0.0F;
      this.cdg = 0.0F;
      this.cdb = 0.0F;
      this.cdc = 0.0F;
      this.ccT = 0.0F;
    }
    
    final int Ly()
    {
      return (this.cdd + 1) % this.mColors.length;
    }
    
    final int Lz()
    {
      return this.mColors[this.cdd];
    }
    
    final void bk(boolean paramBoolean)
    {
      if (this.mShowArrow != paramBoolean) {
        this.mShowArrow = paramBoolean;
      }
    }
    
    final void gF(int paramInt)
    {
      this.cdd = paramInt;
      this.bri = this.mColors[this.cdd];
    }
    
    final void setColors(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(193248);
      this.mColors = paramArrayOfInt;
      gF(0);
      AppMethodBeat.o(193248);
    }
    
    final void setStrokeWidth(float paramFloat)
    {
      AppMethodBeat.i(193277);
      this.mStrokeWidth = paramFloat;
      this.mPaint.setStrokeWidth(paramFloat);
      AppMethodBeat.o(193277);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.swiperefreshlayout.widget.b
 * JD-Core Version:    0.7.0.1
 */