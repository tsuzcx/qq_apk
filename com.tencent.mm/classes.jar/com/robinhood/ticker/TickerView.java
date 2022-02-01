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
  private static final Interpolator bWq;
  private final ValueAnimator animator;
  private final f bVW;
  protected final Paint bWm;
  private final e bWr;
  private final Rect bWs;
  private int bWt;
  private int bWu;
  private long bWv;
  private long bWw;
  private Interpolator bWx;
  private boolean bWy;
  private String bWz;
  private int gravity;
  private String text;
  private int textColor;
  private float textSize;
  private int textStyle;
  
  static
  {
    AppMethodBeat.i(39885);
    bWq = new AccelerateDecelerateInterpolator();
    AppMethodBeat.o(39885);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(39866);
    this.bWm = new TextPaint(1);
    this.bVW = new f(this.bWm);
    this.bWr = new e(this.bVW);
    this.animator = ValueAnimator.ofFloat(new float[] { 1.0F });
    this.bWs = new Rect();
    b(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(39866);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(39867);
    this.bWm = new TextPaint(1);
    this.bVW = new f(this.bWm);
    this.bWr = new e(this.bVW);
    this.animator = ValueAnimator.ofFloat(new float[] { 1.0F });
    this.bWs = new Rect();
    b(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(39867);
  }
  
  private void Aa()
  {
    AppMethodBeat.i(39880);
    this.bVW.invalidate();
    zX();
    invalidate();
    AppMethodBeat.o(39880);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(39868);
    b localb = new b(paramContext.getResources());
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.a.TickerView, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(0, -1);
    if (paramInt != -1)
    {
      paramContext = paramContext.obtainStyledAttributes(paramInt, b.a.TickerView);
      localb.c(paramContext);
      paramContext.recycle();
    }
    localb.c(paramAttributeSet);
    this.bWx = bWq;
    this.bWw = paramAttributeSet.getInt(11, 350);
    this.bWy = paramAttributeSet.getBoolean(10, false);
    this.gravity = localb.gravity;
    if (localb.shadowColor != 0) {
      this.bWm.setShadowLayer(localb.shadowRadius, localb.lw, localb.lx, localb.shadowColor);
    }
    if (localb.textStyle != 0)
    {
      this.textStyle = localb.textStyle;
      setTypeface(this.bWm.getTypeface());
    }
    setTextColor(localb.textColor);
    setTextSize(localb.textSize);
    switch (paramAttributeSet.getInt(12, 0))
    {
    default: 
      if (isInEditMode()) {
        setCharacterLists(new String[] { "0123456789" });
      }
      break;
    }
    for (;;)
    {
      paramInt = paramAttributeSet.getInt(13, 0);
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
    this.bVW.bWp = TickerView.a.bWB;
    if (zW()) {
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
      this.bVW.bWp = TickerView.a.bWC;
      break;
      this.bVW.bWp = TickerView.a.bWD;
      break;
      this.bWz = localb.text;
    }
  }
  
  private boolean zW()
  {
    return this.bWr.bVV != null;
  }
  
  private void zX()
  {
    int j = 1;
    AppMethodBeat.i(39877);
    int i;
    if (this.bWt != zY())
    {
      i = 1;
      if (this.bWu == zZ()) {
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
  
  private int zY()
  {
    AppMethodBeat.i(39878);
    if (this.bWy) {}
    for (float f = this.bWr.zS();; f = this.bWr.zU())
    {
      int i = (int)f;
      int j = getPaddingLeft();
      int k = getPaddingRight();
      AppMethodBeat.o(39878);
      return i + j + k;
    }
  }
  
  private int zZ()
  {
    AppMethodBeat.i(39879);
    int i = (int)this.bVW.bWc;
    int j = getPaddingTop();
    int k = getPaddingBottom();
    AppMethodBeat.o(39879);
    return i + j + k;
  }
  
  public boolean getAnimateMeasurementChange()
  {
    return this.bWy;
  }
  
  public long getAnimationDelay()
  {
    return this.bWv;
  }
  
  public long getAnimationDuration()
  {
    return this.bWw;
  }
  
  public Interpolator getAnimationInterpolator()
  {
    return this.bWx;
  }
  
  public int getGravity()
  {
    return this.gravity;
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
    Typeface localTypeface = this.bWm.getTypeface();
    AppMethodBeat.o(39874);
    return localTypeface;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(39883);
    super.onDraw(paramCanvas);
    paramCanvas.save();
    float f3 = this.bWr.zS();
    float f4 = this.bVW.bWc;
    int i = this.gravity;
    Object localObject = this.bWs;
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
        paramCanvas.translate(0.0F, this.bVW.bWo);
        localObject = this.bWr;
        Paint localPaint = this.bWm;
        j = ((e)localObject).bWk.size();
        i = 0;
        while (i < j)
        {
          d locald = (d)((e)localObject).bWk.get(i);
          if (d.a(paramCanvas, localPaint, locald.bVZ, locald.bWa, locald.bWb))
          {
            if (locald.bWa >= 0) {
              locald.bVX = locald.bVZ[locald.bWa];
            }
            locald.bWh = locald.bWb;
          }
          d.a(paramCanvas, localPaint, locald.bVZ, locald.bWa + 1, locald.bWb - locald.bWc);
          d.a(paramCanvas, localPaint, locald.bVZ, locald.bWa - 1, locald.bWb + locald.bWc);
          paramCanvas.translate(locald.zS(), 0.0F);
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
    this.bWt = zY();
    this.bWu = zZ();
    setMeasuredDimension(resolveSize(this.bWt, paramInt1), resolveSize(this.bWu, paramInt2));
    AppMethodBeat.o(39881);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(39882);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.bWs.set(getPaddingLeft(), getPaddingTop(), paramInt1 - getPaddingRight(), paramInt2 - getPaddingBottom());
    AppMethodBeat.o(39882);
  }
  
  public void setAnimateMeasurementChange(boolean paramBoolean)
  {
    this.bWy = paramBoolean;
  }
  
  public void setAnimationDelay(long paramLong)
  {
    this.bWv = paramLong;
  }
  
  public void setAnimationDuration(long paramLong)
  {
    this.bWw = paramLong;
  }
  
  public void setAnimationInterpolator(Interpolator paramInterpolator)
  {
    this.bWx = paramInterpolator;
  }
  
  public void setCharacterLists(String... paramVarArgs)
  {
    AppMethodBeat.i(39869);
    e locale = this.bWr;
    locale.bVV = new c[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      locale.bVV[i] = new c(paramVarArgs[i]);
      i += 1;
    }
    locale.bWl = new HashSet();
    i = 0;
    while (i < paramVarArgs.length)
    {
      locale.bWl.addAll(locale.bVV[i].bVS.keySet());
      i += 1;
    }
    if (this.bWz != null)
    {
      setText(this.bWz, false);
      this.bWz = null;
    }
    AppMethodBeat.o(39869);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(39876);
    if (this.gravity != paramInt)
    {
      this.gravity = paramInt;
      invalidate();
    }
    AppMethodBeat.o(39876);
  }
  
  public void setPreferredScrollingDirection(TickerView.a parama)
  {
    this.bVW.bWp = parama;
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
      this.bWr.b(arrayOfChar);
      setContentDescription(paramString);
      if (!paramBoolean) {
        break;
      }
      if (this.animator.isRunning()) {
        this.animator.cancel();
      }
      this.animator.setStartDelay(this.bWv);
      this.animator.setDuration(this.bWw);
      this.animator.setInterpolator(this.bWx);
      this.animator.start();
      AppMethodBeat.o(39871);
      return;
    }
    this.bWr.setAnimationProgress(1.0F);
    this.bWr.onAnimationEnd();
    zX();
    invalidate();
    AppMethodBeat.o(39871);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(39872);
    if (this.textColor != paramInt)
    {
      this.textColor = paramInt;
      this.bWm.setColor(this.textColor);
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
      this.bWm.setTextSize(paramFloat);
      Aa();
    }
    AppMethodBeat.o(39873);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(39875);
    Typeface localTypeface;
    if (this.textStyle == 3) {
      localTypeface = Typeface.create(paramTypeface, 3);
    }
    for (;;)
    {
      this.bWm.setTypeface(localTypeface);
      Aa();
      AppMethodBeat.o(39875);
      return;
      if (this.textStyle == 1)
      {
        localTypeface = Typeface.create(paramTypeface, 1);
      }
      else
      {
        localTypeface = paramTypeface;
        if (this.textStyle == 2) {
          localTypeface = Typeface.create(paramTypeface, 2);
        }
      }
    }
  }
  
  final class b
  {
    int gravity;
    float lw;
    float lx;
    int shadowColor;
    float shadowRadius;
    String text;
    int textColor;
    float textSize;
    int textStyle;
    
    b(Resources paramResources)
    {
      AppMethodBeat.i(39864);
      this.textColor = -16777216;
      this.textSize = TypedValue.applyDimension(2, 12.0F, paramResources.getDisplayMetrics());
      this.gravity = 8388611;
      AppMethodBeat.o(39864);
    }
    
    final void c(TypedArray paramTypedArray)
    {
      AppMethodBeat.i(39865);
      this.gravity = paramTypedArray.getInt(4, this.gravity);
      this.shadowColor = paramTypedArray.getColor(6, this.shadowColor);
      this.lw = paramTypedArray.getFloat(7, this.lw);
      this.lx = paramTypedArray.getFloat(8, this.lx);
      this.shadowRadius = paramTypedArray.getFloat(9, this.shadowRadius);
      this.text = paramTypedArray.getString(5);
      this.textColor = paramTypedArray.getColor(3, this.textColor);
      this.textSize = paramTypedArray.getDimension(1, this.textSize);
      this.textStyle = paramTypedArray.getInt(2, this.textStyle);
      AppMethodBeat.o(39865);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.robinhood.ticker.TickerView
 * JD-Core Version:    0.7.0.1
 */