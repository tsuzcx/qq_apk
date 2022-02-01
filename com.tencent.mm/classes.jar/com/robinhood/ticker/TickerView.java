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
  private static final Interpolator dZy;
  private final ValueAnimator animator;
  private int dZA;
  private int dZB;
  private long dZC;
  private long dZD;
  private Interpolator dZE;
  private boolean dZF;
  private String dZG;
  private final f dZe;
  protected final Paint dZu;
  private final e dZz;
  private int dwn;
  private int fl;
  private String text;
  private int textColor;
  private float textSize;
  private final Rect viewBounds;
  
  static
  {
    AppMethodBeat.i(39885);
    dZy = new AccelerateDecelerateInterpolator();
    AppMethodBeat.o(39885);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(39866);
    this.dZu = new TextPaint(1);
    this.dZe = new f(this.dZu);
    this.dZz = new e(this.dZe);
    this.animator = ValueAnimator.ofFloat(new float[] { 1.0F });
    this.viewBounds = new Rect();
    a(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(39866);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(39867);
    this.dZu = new TextPaint(1);
    this.dZe = new f(this.dZu);
    this.dZz = new e(this.dZe);
    this.animator = ValueAnimator.ofFloat(new float[] { 1.0F });
    this.viewBounds = new Rect();
    a(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(39867);
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
    this.dZE = dZy;
    this.dZD = paramAttributeSet.getInt(b.a.TickerView_ticker_animationDuration, 350);
    this.dZF = paramAttributeSet.getBoolean(b.a.TickerView_ticker_animateMeasurementChange, false);
    this.fl = localb.fl;
    if (localb.shadowColor != 0) {
      this.dZu.setShadowLayer(localb.shadowRadius, localb.dwq, localb.dwr, localb.shadowColor);
    }
    if (localb.dwn != 0)
    {
      this.dwn = localb.dwn;
      setTypeface(this.dZu.getTypeface());
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
    this.dZe.dZx = TickerView.a.dZI;
    if (aku()) {
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
      this.dZe.dZx = TickerView.a.dZJ;
      break;
      this.dZe.dZx = TickerView.a.dZK;
      break;
      this.dZG = localb.text;
    }
  }
  
  private boolean aku()
  {
    return this.dZz.dZd != null;
  }
  
  private void akv()
  {
    int j = 1;
    AppMethodBeat.i(39877);
    int i;
    if (this.dZA != akw())
    {
      i = 1;
      if (this.dZB == akx()) {
        break label56;
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
      label56:
      j = 0;
    }
  }
  
  private int akw()
  {
    AppMethodBeat.i(39878);
    if (this.dZF) {}
    for (float f = this.dZz.akq();; f = this.dZz.aks())
    {
      int i = (int)f;
      int j = getPaddingLeft();
      int k = getPaddingRight();
      AppMethodBeat.o(39878);
      return i + j + k;
    }
  }
  
  private int akx()
  {
    AppMethodBeat.i(39879);
    int i = (int)this.dZe.dZk;
    int j = getPaddingTop();
    int k = getPaddingBottom();
    AppMethodBeat.o(39879);
    return i + j + k;
  }
  
  private void aky()
  {
    AppMethodBeat.i(39880);
    this.dZe.invalidate();
    akv();
    invalidate();
    AppMethodBeat.o(39880);
  }
  
  public boolean getAnimateMeasurementChange()
  {
    return this.dZF;
  }
  
  public long getAnimationDelay()
  {
    return this.dZC;
  }
  
  public long getAnimationDuration()
  {
    return this.dZD;
  }
  
  public Interpolator getAnimationInterpolator()
  {
    return this.dZE;
  }
  
  public int getGravity()
  {
    return this.fl;
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
    Typeface localTypeface = this.dZu.getTypeface();
    AppMethodBeat.o(39874);
    return localTypeface;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(39883);
    super.onDraw(paramCanvas);
    paramCanvas.save();
    float f3 = this.dZz.akq();
    float f4 = this.dZe.dZk;
    int i = this.fl;
    Object localObject = this.viewBounds;
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
        paramCanvas.translate(0.0F, this.dZe.dZw);
        localObject = this.dZz;
        Paint localPaint = this.dZu;
        j = ((e)localObject).dZs.size();
        i = 0;
        while (i < j)
        {
          d locald = (d)((e)localObject).dZs.get(i);
          if (d.a(paramCanvas, localPaint, locald.dZh, locald.dZi, locald.dZj))
          {
            if (locald.dZi >= 0) {
              locald.dZf = locald.dZh[locald.dZi];
            }
            locald.dZp = locald.dZj;
          }
          d.a(paramCanvas, localPaint, locald.dZh, locald.dZi + 1, locald.dZj - locald.dZk);
          d.a(paramCanvas, localPaint, locald.dZh, locald.dZi - 1, locald.dZj + locald.dZk);
          paramCanvas.translate(locald.akq(), 0.0F);
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
    this.dZA = akw();
    this.dZB = akx();
    setMeasuredDimension(resolveSize(this.dZA, paramInt1), resolveSize(this.dZB, paramInt2));
    AppMethodBeat.o(39881);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(39882);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.viewBounds.set(getPaddingLeft(), getPaddingTop(), paramInt1 - getPaddingRight(), paramInt2 - getPaddingBottom());
    AppMethodBeat.o(39882);
  }
  
  public void setAnimateMeasurementChange(boolean paramBoolean)
  {
    this.dZF = paramBoolean;
  }
  
  public void setAnimationDelay(long paramLong)
  {
    this.dZC = paramLong;
  }
  
  public void setAnimationDuration(long paramLong)
  {
    this.dZD = paramLong;
  }
  
  public void setAnimationInterpolator(Interpolator paramInterpolator)
  {
    this.dZE = paramInterpolator;
  }
  
  public void setCharacterLists(String... paramVarArgs)
  {
    AppMethodBeat.i(39869);
    e locale = this.dZz;
    locale.dZd = new c[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      locale.dZd[i] = new c(paramVarArgs[i]);
      i += 1;
    }
    locale.dZt = new HashSet();
    i = 0;
    while (i < paramVarArgs.length)
    {
      locale.dZt.addAll(locale.dZd[i].dZa.keySet());
      i += 1;
    }
    if (this.dZG != null)
    {
      setText(this.dZG, false);
      this.dZG = null;
    }
    AppMethodBeat.o(39869);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(39876);
    if (this.fl != paramInt)
    {
      this.fl = paramInt;
      invalidate();
    }
    AppMethodBeat.o(39876);
  }
  
  public void setPreferredScrollingDirection(TickerView.a parama)
  {
    this.dZe.dZx = parama;
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
      this.dZz.b(arrayOfChar);
      setContentDescription(paramString);
      if (!paramBoolean) {
        break;
      }
      if (this.animator.isRunning()) {
        this.animator.cancel();
      }
      this.animator.setStartDelay(this.dZC);
      this.animator.setDuration(this.dZD);
      this.animator.setInterpolator(this.dZE);
      this.animator.start();
      AppMethodBeat.o(39871);
      return;
    }
    this.dZz.setAnimationProgress(1.0F);
    this.dZz.onAnimationEnd();
    akv();
    invalidate();
    AppMethodBeat.o(39871);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(39872);
    if (this.textColor != paramInt)
    {
      this.textColor = paramInt;
      this.dZu.setColor(this.textColor);
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
      this.dZu.setTextSize(paramFloat);
      aky();
    }
    AppMethodBeat.o(39873);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(39875);
    Typeface localTypeface;
    if (this.dwn == 3) {
      localTypeface = Typeface.create(paramTypeface, 3);
    }
    for (;;)
    {
      this.dZu.setTypeface(localTypeface);
      aky();
      AppMethodBeat.o(39875);
      return;
      if (this.dwn == 1)
      {
        localTypeface = Typeface.create(paramTypeface, 1);
      }
      else
      {
        localTypeface = paramTypeface;
        if (this.dwn == 2) {
          localTypeface = Typeface.create(paramTypeface, 2);
        }
      }
    }
  }
  
  final class b
  {
    int dwn;
    float dwq;
    float dwr;
    int fl;
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
      this.fl = 8388611;
      AppMethodBeat.o(39864);
    }
    
    final void c(TypedArray paramTypedArray)
    {
      AppMethodBeat.i(39865);
      this.fl = paramTypedArray.getInt(b.a.TickerView_android_gravity, this.fl);
      this.shadowColor = paramTypedArray.getColor(b.a.TickerView_android_shadowColor, this.shadowColor);
      this.dwq = paramTypedArray.getFloat(b.a.TickerView_android_shadowDx, this.dwq);
      this.dwr = paramTypedArray.getFloat(b.a.TickerView_android_shadowDy, this.dwr);
      this.shadowRadius = paramTypedArray.getFloat(b.a.TickerView_android_shadowRadius, this.shadowRadius);
      this.text = paramTypedArray.getString(b.a.TickerView_android_text);
      this.textColor = paramTypedArray.getColor(b.a.TickerView_android_textColor, this.textColor);
      this.textSize = paramTypedArray.getDimension(b.a.TickerView_android_textSize, this.textSize);
      this.dwn = paramTypedArray.getInt(b.a.TickerView_android_textStyle, this.dwn);
      AppMethodBeat.o(39865);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.robinhood.ticker.TickerView
 * JD-Core Version:    0.7.0.1
 */