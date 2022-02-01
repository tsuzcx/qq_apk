package com.robinhood.ticker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TickerView
  extends View
{
  private static final Interpolator ciZ;
  private final ValueAnimator animator;
  private int bDm;
  private final f ciF;
  protected final Paint ciV;
  private final e cja;
  private final Rect cjb;
  private int cjc;
  private int cjd;
  private long cje;
  private long cjf;
  private Interpolator cjg;
  private boolean cjh;
  private String cji;
  private int ek;
  private String text;
  private int textColor;
  private float textSize;
  
  static
  {
    AppMethodBeat.i(39885);
    ciZ = new AccelerateDecelerateInterpolator();
    AppMethodBeat.o(39885);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(39866);
    this.ciV = new TextPaint(1);
    this.ciF = new f(this.ciV);
    this.cja = new e(this.ciF);
    this.animator = ValueAnimator.ofFloat(new float[] { 1.0F });
    this.cjb = new Rect();
    a(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(39866);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(39867);
    this.ciV = new TextPaint(1);
    this.ciF = new f(this.ciV);
    this.cja = new e(this.ciF);
    this.animator = ValueAnimator.ofFloat(new float[] { 1.0F });
    this.cjb = new Rect();
    a(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(39867);
  }
  
  private boolean Kt()
  {
    return this.cja.ciE != null;
  }
  
  private void Ku()
  {
    int j = 1;
    AppMethodBeat.i(39877);
    int i;
    if (this.cjc != Kv())
    {
      i = 1;
      if (this.cjd == Kw()) {
        break label54;
      }
    }
    for (;;)
    {
      if ((i != 0) || (j != 0)) {
        requestLayout();
      }
      AppMethodBeat.o(39877);
      return;
      i = 0;
      break;
      label54:
      j = 0;
    }
  }
  
  private int Kv()
  {
    AppMethodBeat.i(39878);
    if (this.cjh) {}
    for (float f = this.cja.Kp();; f = this.cja.Kr())
    {
      int i = (int)f;
      int j = getPaddingLeft();
      int k = getPaddingRight();
      AppMethodBeat.o(39878);
      return i + j + k;
    }
  }
  
  private int Kw()
  {
    AppMethodBeat.i(39879);
    int i = (int)this.ciF.ciL;
    int j = getPaddingTop();
    int k = getPaddingBottom();
    AppMethodBeat.o(39879);
    return i + j + k;
  }
  
  private void Kx()
  {
    AppMethodBeat.i(39880);
    this.ciF.invalidate();
    Ku();
    invalidate();
    AppMethodBeat.o(39880);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(39868);
    b localb = new b(paramContext.getResources());
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.a.TickerView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(b.a.TickerView_android_textAppearance, -1);
    if (paramInt != -1)
    {
      paramContext = paramContext.obtainStyledAttributes(paramInt, b.a.TickerView);
      localb.c(paramContext);
      paramContext.recycle();
    }
    localb.c(paramAttributeSet);
    this.cjg = ciZ;
    this.cjf = paramAttributeSet.getInt(b.a.TickerView_ticker_animationDuration, 350);
    this.cjh = paramAttributeSet.getBoolean(b.a.TickerView_ticker_animateMeasurementChange, false);
    this.ek = localb.ek;
    if (localb.shadowColor != 0) {
      this.ciV.setShadowLayer(localb.shadowRadius, localb.bDp, localb.bDq, localb.shadowColor);
    }
    if (localb.bDm != 0)
    {
      this.bDm = localb.bDm;
      setTypeface(this.ciV.getTypeface());
    }
    setTextColor(localb.textColor);
    setTextSize(localb.textSize);
    switch (paramAttributeSet.getInt(b.a.TickerView_ticker_defaultCharacterList, 0))
    {
    default: 
      if (isInEditMode()) {
        setCharacterLists(new String[] { "0123456789" });
      }
      break;
    }
    for (;;)
    {
      paramInt = paramAttributeSet.getInt(b.a.TickerView_ticker_defaultPreferredScrollingDirection, 0);
      switch (paramInt)
      {
      default: 
        paramContext = new IllegalArgumentException("Unsupported ticker_defaultPreferredScrollingDirection: ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(39868);
        throw paramContext;
        setCharacterLists(new String[] { "0123456789" });
        continue;
        setCharacterLists(new String[] { "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" });
      }
    }
    this.ciF.ciY = a.cjk;
    if (Kt()) {
      setText(localb.text, false);
    }
    for (;;)
    {
      paramAttributeSet.recycle();
      this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(39859);
          TickerView.a(TickerView.this).setAnimationProgress(paramAnonymousValueAnimator.getAnimatedFraction());
          TickerView.b(TickerView.this);
          TickerView.this.invalidate();
          AppMethodBeat.o(39859);
        }
      });
      this.animator.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(39860);
          TickerView.a(TickerView.this).onAnimationEnd();
          TickerView.b(TickerView.this);
          TickerView.this.invalidate();
          AppMethodBeat.o(39860);
        }
      });
      AppMethodBeat.o(39868);
      return;
      this.ciF.ciY = a.cjl;
      break;
      this.ciF.ciY = a.cjm;
      break;
      this.cji = localb.text;
    }
  }
  
  public boolean getAnimateMeasurementChange()
  {
    return this.cjh;
  }
  
  public long getAnimationDelay()
  {
    return this.cje;
  }
  
  public long getAnimationDuration()
  {
    return this.cjf;
  }
  
  public Interpolator getAnimationInterpolator()
  {
    return this.cjg;
  }
  
  public int getGravity()
  {
    return this.ek;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public int getTextColor()
  {
    return this.textColor;
  }
  
  public float getTextSize()
  {
    return this.textSize;
  }
  
  public Typeface getTypeface()
  {
    AppMethodBeat.i(39874);
    Typeface localTypeface = this.ciV.getTypeface();
    AppMethodBeat.o(39874);
    return localTypeface;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(39883);
    super.onDraw(paramCanvas);
    paramCanvas.save();
    float f3 = this.cja.Kp();
    float f4 = this.ciF.ciL;
    int i = this.ek;
    Object localObject = this.cjb;
    int j = ((Rect)localObject).width();
    int k = ((Rect)localObject).height();
    float f1;
    if ((i & 0x10) == 16) {
      f1 = ((Rect)localObject).top;
    }
    for (float f2 = (k - f4) / 2.0F + f1;; f2 = 0.0F)
    {
      if ((i & 0x1) == 1) {}
      for (f1 = ((Rect)localObject).left + (j - f3) / 2.0F;; f1 = 0.0F)
      {
        if ((i & 0x30) == 48) {
          f2 = 0.0F;
        }
        if ((i & 0x50) == 80) {
          f2 = ((Rect)localObject).top + (k - f4);
        }
        if ((i & 0x800003) == 8388611) {
          f1 = 0.0F;
        }
        if ((i & 0x800005) == 8388613) {
          f1 = ((Rect)localObject).left + (j - f3);
        }
        paramCanvas.translate(f1, f2);
        paramCanvas.clipRect(0.0F, 0.0F, f3, f4);
        paramCanvas.translate(0.0F, this.ciF.ciX);
        localObject = this.cja;
        Paint localPaint = this.ciV;
        j = ((e)localObject).ciT.size();
        i = 0;
        while (i < j)
        {
          d locald = (d)((e)localObject).ciT.get(i);
          if (d.a(paramCanvas, localPaint, locald.ciI, locald.ciJ, locald.ciK))
          {
            if (locald.ciJ >= 0) {
              locald.ciG = locald.ciI[locald.ciJ];
            }
            locald.ciQ = locald.ciK;
          }
          d.a(paramCanvas, localPaint, locald.ciI, locald.ciJ + 1, locald.ciK - locald.ciL);
          d.a(paramCanvas, localPaint, locald.ciI, locald.ciJ - 1, locald.ciK + locald.ciL);
          paramCanvas.translate(locald.Kp(), 0.0F);
          i += 1;
        }
        paramCanvas.restore();
        AppMethodBeat.o(39883);
        return;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39881);
    this.cjc = Kv();
    this.cjd = Kw();
    setMeasuredDimension(resolveSize(this.cjc, paramInt1), resolveSize(this.cjd, paramInt2));
    AppMethodBeat.o(39881);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(39882);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.cjb.set(getPaddingLeft(), getPaddingTop(), paramInt1 - getPaddingRight(), paramInt2 - getPaddingBottom());
    AppMethodBeat.o(39882);
  }
  
  public void setAnimateMeasurementChange(boolean paramBoolean)
  {
    this.cjh = paramBoolean;
  }
  
  public void setAnimationDelay(long paramLong)
  {
    this.cje = paramLong;
  }
  
  public void setAnimationDuration(long paramLong)
  {
    this.cjf = paramLong;
  }
  
  public void setAnimationInterpolator(Interpolator paramInterpolator)
  {
    this.cjg = paramInterpolator;
  }
  
  public void setCharacterLists(String... paramVarArgs)
  {
    AppMethodBeat.i(39869);
    e locale = this.cja;
    locale.ciE = new c[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      locale.ciE[i] = new c(paramVarArgs[i]);
      i += 1;
    }
    locale.ciU = new HashSet();
    i = 0;
    while (i < paramVarArgs.length)
    {
      locale.ciU.addAll(locale.ciE[i].ciB.keySet());
      i += 1;
    }
    if (this.cji != null)
    {
      setText(this.cji, false);
      this.cji = null;
    }
    AppMethodBeat.o(39869);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(39876);
    if (this.ek != paramInt)
    {
      this.ek = paramInt;
      invalidate();
    }
    AppMethodBeat.o(39876);
  }
  
  public void setPreferredScrollingDirection(a parama)
  {
    this.ciF.ciY = parama;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(39870);
    if (!TextUtils.isEmpty(this.text)) {}
    for (boolean bool = true;; bool = false)
    {
      setText(paramString, bool);
      AppMethodBeat.o(39870);
      return;
    }
  }
  
  public final void setText(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(39871);
    if (TextUtils.equals(paramString, this.text))
    {
      AppMethodBeat.o(39871);
      return;
    }
    this.text = paramString;
    if (paramString == null) {}
    for (char[] arrayOfChar = new char[0];; arrayOfChar = paramString.toCharArray())
    {
      this.cja.b(arrayOfChar);
      setContentDescription(paramString);
      if (!paramBoolean) {
        break;
      }
      if (this.animator.isRunning()) {
        this.animator.cancel();
      }
      this.animator.setStartDelay(this.cje);
      this.animator.setDuration(this.cjf);
      this.animator.setInterpolator(this.cjg);
      this.animator.start();
      AppMethodBeat.o(39871);
      return;
    }
    this.cja.setAnimationProgress(1.0F);
    this.cja.onAnimationEnd();
    Ku();
    invalidate();
    AppMethodBeat.o(39871);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(39872);
    if (this.textColor != paramInt)
    {
      this.textColor = paramInt;
      this.ciV.setColor(this.textColor);
      invalidate();
    }
    AppMethodBeat.o(39872);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(39873);
    if (this.textSize != paramFloat)
    {
      this.textSize = paramFloat;
      this.ciV.setTextSize(paramFloat);
      Kx();
    }
    AppMethodBeat.o(39873);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(39875);
    Typeface localTypeface;
    if (this.bDm == 3) {
      localTypeface = Typeface.create(paramTypeface, 3);
    }
    for (;;)
    {
      this.ciV.setTypeface(localTypeface);
      Kx();
      AppMethodBeat.o(39875);
      return;
      if (this.bDm == 1)
      {
        localTypeface = Typeface.create(paramTypeface, 1);
      }
      else
      {
        localTypeface = paramTypeface;
        if (this.bDm == 2) {
          localTypeface = Typeface.create(paramTypeface, 2);
        }
      }
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(39863);
      cjk = new a("ANY", 0);
      cjl = new a("UP", 1);
      cjm = new a("DOWN", 2);
      cjn = new a[] { cjk, cjl, cjm };
      AppMethodBeat.o(39863);
    }
    
    private a() {}
  }
  
  final class b
  {
    int bDm;
    float bDp;
    float bDq;
    int ek;
    int shadowColor;
    float shadowRadius;
    String text;
    int textColor;
    float textSize;
    
    b(Resources paramResources)
    {
      AppMethodBeat.i(39864);
      this.textColor = -16777216;
      this.textSize = TypedValue.applyDimension(2, 12.0F, paramResources.getDisplayMetrics());
      this.ek = 8388611;
      AppMethodBeat.o(39864);
    }
    
    final void c(TypedArray paramTypedArray)
    {
      AppMethodBeat.i(39865);
      this.ek = paramTypedArray.getInt(b.a.TickerView_android_gravity, this.ek);
      this.shadowColor = paramTypedArray.getColor(b.a.TickerView_android_shadowColor, this.shadowColor);
      this.bDp = paramTypedArray.getFloat(b.a.TickerView_android_shadowDx, this.bDp);
      this.bDq = paramTypedArray.getFloat(b.a.TickerView_android_shadowDy, this.bDq);
      this.shadowRadius = paramTypedArray.getFloat(b.a.TickerView_android_shadowRadius, this.shadowRadius);
      this.text = paramTypedArray.getString(b.a.TickerView_android_text);
      this.textColor = paramTypedArray.getColor(b.a.TickerView_android_textColor, this.textColor);
      this.textSize = paramTypedArray.getDimension(b.a.TickerView_android_textSize, this.textSize);
      this.bDm = paramTypedArray.getInt(b.a.TickerView_android_textStyle, this.bDm);
      AppMethodBeat.o(39865);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.robinhood.ticker.TickerView
 * JD-Core Version:    0.7.0.1
 */