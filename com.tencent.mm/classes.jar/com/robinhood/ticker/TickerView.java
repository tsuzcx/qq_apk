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
  private static final Interpolator bOv;
  private long bOA;
  private long bOB;
  private Interpolator bOC;
  private boolean bOD;
  private String bOE;
  private final f bOb;
  protected final Paint bOr;
  private final e bOw;
  private final Rect bOx;
  private int bOy;
  private int bOz;
  private int gravity;
  private final ValueAnimator qT;
  private String text;
  private int textColor;
  private float textSize;
  private int textStyle;
  
  static
  {
    AppMethodBeat.i(39885);
    bOv = new AccelerateDecelerateInterpolator();
    AppMethodBeat.o(39885);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(39866);
    this.bOr = new TextPaint(1);
    this.bOb = new f(this.bOr);
    this.bOw = new e(this.bOb);
    this.qT = ValueAnimator.ofFloat(new float[] { 1.0F });
    this.bOx = new Rect();
    b(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(39866);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(39867);
    this.bOr = new TextPaint(1);
    this.bOb = new f(this.bOr);
    this.bOw = new e(this.bOb);
    this.qT = ValueAnimator.ofFloat(new float[] { 1.0F });
    this.bOx = new Rect();
    b(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(39867);
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
    this.bOC = bOv;
    this.bOB = paramAttributeSet.getInt(11, 350);
    this.bOD = paramAttributeSet.getBoolean(10, false);
    this.gravity = localb.gravity;
    if (localb.shadowColor != 0) {
      this.bOr.setShadowLayer(localb.shadowRadius, localb.iH, localb.iI, localb.shadowColor);
    }
    if (localb.textStyle != 0)
    {
      this.textStyle = localb.textStyle;
      setTypeface(this.bOr.getTypeface());
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
    this.bOb.bOu = a.bOG;
    if (yM()) {
      setText(localb.text, false);
    }
    for (;;)
    {
      paramAttributeSet.recycle();
      this.qT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
      this.qT.addListener(new AnimatorListenerAdapter()
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
      this.bOb.bOu = a.bOH;
      break;
      this.bOb.bOu = a.bOI;
      break;
      this.bOE = localb.text;
    }
  }
  
  private boolean yM()
  {
    return this.bOw.bOa != null;
  }
  
  private void yN()
  {
    int j = 1;
    AppMethodBeat.i(39877);
    int i;
    if (this.bOy != yO())
    {
      i = 1;
      if (this.bOz == yP()) {
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
  
  private int yO()
  {
    AppMethodBeat.i(39878);
    if (this.bOD) {}
    for (float f = this.bOw.yI();; f = this.bOw.yK())
    {
      int i = (int)f;
      int j = getPaddingLeft();
      int k = getPaddingRight();
      AppMethodBeat.o(39878);
      return i + j + k;
    }
  }
  
  private int yP()
  {
    AppMethodBeat.i(39879);
    int i = (int)this.bOb.bOh;
    int j = getPaddingTop();
    int k = getPaddingBottom();
    AppMethodBeat.o(39879);
    return i + j + k;
  }
  
  private void yQ()
  {
    AppMethodBeat.i(39880);
    this.bOb.invalidate();
    yN();
    invalidate();
    AppMethodBeat.o(39880);
  }
  
  public boolean getAnimateMeasurementChange()
  {
    return this.bOD;
  }
  
  public long getAnimationDelay()
  {
    return this.bOA;
  }
  
  public long getAnimationDuration()
  {
    return this.bOB;
  }
  
  public Interpolator getAnimationInterpolator()
  {
    return this.bOC;
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
    Typeface localTypeface = this.bOr.getTypeface();
    AppMethodBeat.o(39874);
    return localTypeface;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(39883);
    super.onDraw(paramCanvas);
    paramCanvas.save();
    float f3 = this.bOw.yI();
    float f4 = this.bOb.bOh;
    int i = this.gravity;
    Object localObject = this.bOx;
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
        paramCanvas.translate(0.0F, this.bOb.bOt);
        localObject = this.bOw;
        Paint localPaint = this.bOr;
        j = ((e)localObject).bOp.size();
        i = 0;
        while (i < j)
        {
          d locald = (d)((e)localObject).bOp.get(i);
          if (d.a(paramCanvas, localPaint, locald.bOe, locald.bOf, locald.bOg))
          {
            if (locald.bOf >= 0) {
              locald.bOc = locald.bOe[locald.bOf];
            }
            locald.bOm = locald.bOg;
          }
          d.a(paramCanvas, localPaint, locald.bOe, locald.bOf + 1, locald.bOg - locald.bOh);
          d.a(paramCanvas, localPaint, locald.bOe, locald.bOf - 1, locald.bOg + locald.bOh);
          paramCanvas.translate(locald.yI(), 0.0F);
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
    this.bOy = yO();
    this.bOz = yP();
    setMeasuredDimension(resolveSize(this.bOy, paramInt1), resolveSize(this.bOz, paramInt2));
    AppMethodBeat.o(39881);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(39882);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.bOx.set(getPaddingLeft(), getPaddingTop(), paramInt1 - getPaddingRight(), paramInt2 - getPaddingBottom());
    AppMethodBeat.o(39882);
  }
  
  public void setAnimateMeasurementChange(boolean paramBoolean)
  {
    this.bOD = paramBoolean;
  }
  
  public void setAnimationDelay(long paramLong)
  {
    this.bOA = paramLong;
  }
  
  public void setAnimationDuration(long paramLong)
  {
    this.bOB = paramLong;
  }
  
  public void setAnimationInterpolator(Interpolator paramInterpolator)
  {
    this.bOC = paramInterpolator;
  }
  
  public void setCharacterLists(String... paramVarArgs)
  {
    AppMethodBeat.i(39869);
    e locale = this.bOw;
    locale.bOa = new c[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      locale.bOa[i] = new c(paramVarArgs[i]);
      i += 1;
    }
    locale.bOq = new HashSet();
    i = 0;
    while (i < paramVarArgs.length)
    {
      locale.bOq.addAll(locale.bOa[i].bNX.keySet());
      i += 1;
    }
    if (this.bOE != null)
    {
      setText(this.bOE, false);
      this.bOE = null;
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
  
  public void setPreferredScrollingDirection(a parama)
  {
    this.bOb.bOu = parama;
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
      this.bOw.b(arrayOfChar);
      setContentDescription(paramString);
      if (!paramBoolean) {
        break;
      }
      if (this.qT.isRunning()) {
        this.qT.cancel();
      }
      this.qT.setStartDelay(this.bOA);
      this.qT.setDuration(this.bOB);
      this.qT.setInterpolator(this.bOC);
      this.qT.start();
      AppMethodBeat.o(39871);
      return;
    }
    this.bOw.setAnimationProgress(1.0F);
    this.bOw.onAnimationEnd();
    yN();
    invalidate();
    AppMethodBeat.o(39871);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(39872);
    if (this.textColor != paramInt)
    {
      this.textColor = paramInt;
      this.bOr.setColor(this.textColor);
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
      this.bOr.setTextSize(paramFloat);
      yQ();
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
      this.bOr.setTypeface(localTypeface);
      yQ();
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
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(39863);
      bOG = new a("ANY", 0);
      bOH = new a("UP", 1);
      bOI = new a("DOWN", 2);
      bOJ = new a[] { bOG, bOH, bOI };
      AppMethodBeat.o(39863);
    }
    
    private a() {}
  }
  
  final class b
  {
    int gravity;
    float iH;
    float iI;
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
      this.iH = paramTypedArray.getFloat(7, this.iH);
      this.iI = paramTypedArray.getFloat(8, this.iI);
      this.shadowRadius = paramTypedArray.getFloat(9, this.shadowRadius);
      this.text = paramTypedArray.getString(5);
      this.textColor = paramTypedArray.getColor(3, this.textColor);
      this.textSize = paramTypedArray.getDimension(1, this.textSize);
      this.textStyle = paramTypedArray.getInt(2, this.textStyle);
      AppMethodBeat.o(39865);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.robinhood.ticker.TickerView
 * JD-Core Version:    0.7.0.1
 */