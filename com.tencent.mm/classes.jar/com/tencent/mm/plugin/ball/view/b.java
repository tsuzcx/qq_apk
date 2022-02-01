package com.tencent.mm.plugin.ball.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends View
{
  private Paint jPl;
  final List<c> mGf;
  private float mGg;
  private float mGh;
  private float mGi;
  private int mGj;
  boolean mGk;
  private Runnable mGl;
  private Paint mGm;
  List<d> mGn;
  boolean mInited;
  private Paint mPaint;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(106395);
    this.mGf = new ArrayList();
    this.mGj = 0;
    this.mInited = false;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mGm = new Paint();
    this.mGm.setAntiAlias(true);
    this.jPl = new Paint();
    this.jPl.setAntiAlias(true);
    this.jPl.setColor(paramContext.getResources().getColor(2131100377));
    this.jPl.setStyle(Paint.Style.STROKE);
    this.jPl.setStrokeWidth(1.0F);
    AppMethodBeat.o(106395);
  }
  
  private static void a(Canvas paramCanvas, Paint paramPaint, Bitmap paramBitmap, PointF paramPointF, float paramFloat)
  {
    AppMethodBeat.i(106402);
    float f = paramFloat / (paramBitmap.getWidth() / 2.0F);
    paramCanvas.save();
    paramCanvas.translate(paramPointF.x - paramFloat, paramPointF.y - paramFloat);
    paramCanvas.scale(f, f);
    paramCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, paramPaint);
    paramCanvas.restore();
    AppMethodBeat.o(106402);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, d paramd, PointF paramPointF, float paramFloat)
  {
    AppMethodBeat.i(106401);
    if (!paramd.isValid())
    {
      ad.i("MicroMsg.FloatBallCrescentView", "drawTheIcon, invalid icon info");
      AppMethodBeat.o(106401);
      return;
    }
    if ((paramd.bitmap != null) && (!paramd.bitmap.isRecycled())) {
      a(paramCanvas, paramPaint, paramd.bitmap, paramPointF, paramFloat);
    }
    if (paramd.mGA != 0) {
      this.mGm.setARGB(this.mGj, Color.red(paramd.mGA), Color.green(paramd.mGA), Color.blue(paramd.mGA));
    }
    for (;;)
    {
      paramCanvas.drawCircle(paramPointF.x, paramPointF.y, paramFloat, this.mGm);
      AppMethodBeat.o(106401);
      return;
      this.mGm.setARGB(0, 0, 0, 0);
    }
  }
  
  private void a(Canvas paramCanvas, c paramc1, c paramc2)
  {
    AppMethodBeat.i(106400);
    d locald = paramc1.bAt();
    PointF localPointF1 = paramc1.bAr();
    float f1 = paramc1.getRadius();
    PointF localPointF2 = paramc2.bAr();
    float f2 = paramc2.getRadius();
    if (f1 <= 0.0F)
    {
      AppMethodBeat.o(106400);
      return;
    }
    this.mPaint.setAlpha(paramc1.getAlpha());
    this.mGm.setAlpha(paramc1.getAlpha());
    int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    paramCanvas.drawCircle(localPointF1.x, localPointF1.y, f1, this.mPaint);
    this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    a(paramCanvas, this.mPaint, locald, localPointF1, f1);
    this.mPaint.setXfermode(null);
    paramCanvas.drawCircle(localPointF1.x, localPointF1.y, 0.5F + f1, this.jPl);
    if (f2 > 0.0F)
    {
      this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      paramCanvas.drawCircle(localPointF2.x, localPointF2.y, 4.0F + f2 + 0.5F, this.mPaint);
      this.mPaint.setXfermode(null);
    }
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(106400);
  }
  
  private void a(Canvas paramCanvas, c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(106399);
    d locald = paramc.bAt();
    PointF localPointF = paramc.bAr();
    float f = paramc.getRadius();
    if (f == 0.0F)
    {
      AppMethodBeat.o(106399);
      return;
    }
    this.mPaint.setAlpha(paramc.getAlpha());
    this.mGm.setAlpha(paramc.getAlpha());
    int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    paramCanvas.drawCircle(localPointF.x, localPointF.y, f, this.mPaint);
    this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    a(paramCanvas, this.mPaint, locald, localPointF, f);
    this.mPaint.setXfermode(null);
    if (paramBoolean) {
      paramCanvas.drawCircle(localPointF.x, localPointF.y, 0.5F + f, this.jPl);
    }
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(106399);
  }
  
  private List<PointF> c(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(106398);
    float f1 = this.mGg - paramFloat1;
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1)
    {
      localArrayList.add(new PointF(paramFloat1 + f1, paramFloat1 + f1));
      AppMethodBeat.o(106398);
      return localArrayList;
    }
    double d2 = 6.283185307179586D / paramInt;
    if (paramInt >= 3) {}
    for (double d1 = 1.570796326794897D;; d1 = 3.141592653589793D)
    {
      double d3 = paramFloat1 - paramFloat2 - 1.0D;
      int i = 0;
      while (i < paramInt)
      {
        paramFloat2 = (float)(Math.cos(d1) * d3);
        float f2 = (float)(Math.sin(d1) * d3);
        d1 += d2;
        localArrayList.add(new PointF(paramFloat1 - paramFloat2 + f1, paramFloat1 - f2 + f1));
        i += 1;
      }
    }
    AppMethodBeat.o(106398);
    return localArrayList;
  }
  
  public final void a(final List<d> paramList, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(106396);
    ad.i("MicroMsg.FloatBallCrescentView", "setIconInfoList size:%d newChangeIndex:%d", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(paramInt3) });
    this.mInited = false;
    this.mGn = paramList;
    this.mGl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106383);
        b.a(b.this, paramList, paramInt3, paramInt1, paramInt2);
        b.a(b.this);
        b.b(b.this);
        AppMethodBeat.o(106383);
      }
    };
    if (this.mGg > 0.0F)
    {
      ad.i("MicroMsg.FloatBallCrescentView", "setIconInfoList, run pending init");
      this.mGl.run();
    }
    AppMethodBeat.o(106396);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(106397);
    super.onDraw(paramCanvas);
    int j = this.mGf.size();
    if (j == 2)
    {
      a(paramCanvas, (c)this.mGf.get(1), (c)this.mGf.get(0));
      a(paramCanvas, (c)this.mGf.get(0), true);
      AppMethodBeat.o(106397);
      return;
    }
    int i = 0;
    if (i < j)
    {
      c localc2 = (c)this.mGf.get(i);
      c localc1;
      label128:
      boolean bool;
      if (i - 1 < 0)
      {
        localc1 = (c)this.mGf.get(j - 1);
        if (j >= 3) {
          break label183;
        }
        if (j == 1) {
          break label177;
        }
        bool = true;
        label141:
        a(paramCanvas, localc2, bool);
      }
      for (;;)
      {
        i += 1;
        break;
        localc1 = (c)this.mGf.get(i - 1);
        break label128;
        label177:
        bool = false;
        break label141;
        label183:
        a(paramCanvas, localc2, localc1);
      }
    }
    AppMethodBeat.o(106397);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106403);
    super.onMeasure(paramInt1, paramInt2);
    this.mGg = (View.MeasureSpec.getSize(paramInt1) / 2.0F);
    if (this.mGl != null)
    {
      ad.i("MicroMsg.FloatBallCrescentView", "onMeasure, run pending init");
      this.mGl.run();
    }
    AppMethodBeat.o(106403);
  }
  
  static class a
    extends b.b
  {
    protected float asb;
    protected final PointF mGt;
    final String mGu;
    final String mGv;
    final String mGw;
    protected final List<PropertyValuesHolder> mGx;
    
    private a(b.d paramd, PointF paramPointF1, float paramFloat1, PointF paramPointF2, float paramFloat2)
    {
      super((byte)0);
      AppMethodBeat.i(106389);
      this.mGx = new ArrayList();
      this.mGt = paramPointF2;
      this.mGu = String.format("x#%d", new Object[] { Integer.valueOf(hashCode()) });
      this.mGv = String.format("y#%d", new Object[] { Integer.valueOf(hashCode()) });
      this.mGw = String.format("r#%d", new Object[] { Integer.valueOf(hashCode()) });
      paramd = PropertyValuesHolder.ofFloat(this.mGu, new float[] { paramPointF2.x, paramPointF1.x });
      paramPointF1 = PropertyValuesHolder.ofFloat(this.mGv, new float[] { paramPointF2.y, paramPointF1.y });
      paramPointF2 = PropertyValuesHolder.ofFloat(this.mGw, new float[] { paramFloat2, paramFloat1 });
      this.mGx.add(paramd);
      this.mGx.add(paramPointF1);
      this.mGx.add(paramPointF2);
      AppMethodBeat.o(106389);
    }
    
    public final PointF bAr()
    {
      return this.mGt;
    }
    
    public final List<PropertyValuesHolder> bAs()
    {
      return this.mGx;
    }
    
    public void c(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(106390);
      paramValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(106388);
          b.a.this.mGt.x = ((Float)paramAnonymousValueAnimator.getAnimatedValue(b.a.this.mGu)).floatValue();
          b.a.this.mGt.y = ((Float)paramAnonymousValueAnimator.getAnimatedValue(b.a.this.mGv)).floatValue();
          b.a.this.asb = ((Float)paramAnonymousValueAnimator.getAnimatedValue(b.a.this.mGw)).floatValue();
          AppMethodBeat.o(106388);
        }
      });
      AppMethodBeat.o(106390);
    }
    
    public int getAlpha()
    {
      return 255;
    }
    
    public final float getRadius()
    {
      return this.asb;
    }
  }
  
  static abstract class b
    implements b.c
  {
    private final b.d mGz;
    
    private b(b.d paramd)
    {
      this.mGz = paramd;
    }
    
    public final b.d bAt()
    {
      return this.mGz;
    }
  }
  
  static abstract interface c
  {
    public abstract PointF bAr();
    
    public abstract b.d bAt();
    
    public abstract int getAlpha();
    
    public abstract float getRadius();
  }
  
  static final class d
  {
    Bitmap bitmap;
    int mGA = 0;
    
    final boolean isValid()
    {
      AppMethodBeat.i(106391);
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        AppMethodBeat.o(106391);
        return true;
      }
      AppMethodBeat.o(106391);
      return false;
    }
  }
  
  static final class e
    extends b.b
  {
    final float asb;
    final PointF mGt;
    
    private e(b.d paramd, PointF paramPointF, float paramFloat)
    {
      super((byte)0);
      this.mGt = paramPointF;
      this.asb = paramFloat;
    }
    
    public final PointF bAr()
    {
      return this.mGt;
    }
    
    public final int getAlpha()
    {
      return 255;
    }
    
    public final float getRadius()
    {
      return this.asb;
    }
  }
  
  static final class f
    extends b.a
  {
    int mAlpha;
    final String mGB;
    
    private f(b.d paramd, PointF paramPointF1, float paramFloat, PointF paramPointF2)
    {
      super(paramPointF1, paramFloat, paramPointF2, 0.0F, (byte)0);
      AppMethodBeat.i(106393);
      this.mGB = String.format("a#%d", new Object[] { Integer.valueOf(hashCode()) });
      paramd = PropertyValuesHolder.ofInt(this.mGB, new int[] { 0, 255 });
      this.mGx.add(paramd);
      AppMethodBeat.o(106393);
    }
    
    public final void c(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(106394);
      super.c(paramValueAnimator);
      paramValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(106392);
          b.f.this.mAlpha = ((Integer)paramAnonymousValueAnimator.getAnimatedValue(b.f.this.mGB)).intValue();
          AppMethodBeat.o(106392);
        }
      });
      AppMethodBeat.o(106394);
    }
    
    public final int getAlpha()
    {
      return this.mAlpha;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.b
 * JD-Core Version:    0.7.0.1
 */