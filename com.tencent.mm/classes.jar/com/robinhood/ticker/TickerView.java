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
  private static final Interpolator cgY;
  private final ValueAnimator animator;
  private final f cgE;
  protected final Paint cgU;
  private final e cgZ;
  private final Rect cha;
  private int chb;
  private int chc;
  private long chd;
  private long che;
  private Interpolator chf;
  private boolean chg;
  private String chh;
  private int gravity;
  private String text;
  private int textColor;
  private float textSize;
  private int textStyle;
  
  static
  {
    AppMethodBeat.i(39885);
    cgY = new AccelerateDecelerateInterpolator();
    AppMethodBeat.o(39885);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(39866);
    this.cgU = new TextPaint(1);
    this.cgE = new f(this.cgU);
    this.cgZ = new e(this.cgE);
    this.animator = ValueAnimator.ofFloat(new float[] { 1.0F });
    this.cha = new Rect();
    b(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(39866);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(39867);
    this.cgU = new TextPaint(1);
    this.cgE = new f(this.cgU);
    this.cgZ = new e(this.cgE);
    this.animator = ValueAnimator.ofFloat(new float[] { 1.0F });
    this.cha = new Rect();
    b(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(39867);
  }
  
  private boolean IQ()
  {
    return this.cgZ.cgD != null;
  }
  
  private void IR()
  {
    int j = 1;
    AppMethodBeat.i(39877);
    int i;
    if (this.chb != IS())
    {
      i = 1;
      if (this.chc == IT()) {
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
  
  private int IS()
  {
    AppMethodBeat.i(39878);
    if (this.chg) {}
    for (float f = this.cgZ.IM();; f = this.cgZ.IO())
    {
      int i = (int)f;
      int j = getPaddingLeft();
      int k = getPaddingRight();
      AppMethodBeat.o(39878);
      return i + j + k;
    }
  }
  
  private int IT()
  {
    AppMethodBeat.i(39879);
    int i = (int)this.cgE.cgK;
    int j = getPaddingTop();
    int k = getPaddingBottom();
    AppMethodBeat.o(39879);
    return i + j + k;
  }
  
  private void IU()
  {
    AppMethodBeat.i(39880);
    this.cgE.invalidate();
    IR();
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
    this.chf = cgY;
    this.che = paramAttributeSet.getInt(11, 350);
    this.chg = paramAttributeSet.getBoolean(10, false);
    this.gravity = localb.gravity;
    if (localb.shadowColor != 0) {
      this.cgU.setShadowLayer(localb.shadowRadius, localb.ly, localb.lz, localb.shadowColor);
    }
    if (localb.textStyle != 0)
    {
      this.textStyle = localb.textStyle;
      setTypeface(this.cgU.getTypeface());
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
    this.cgE.cgX = a.chj;
    if (IQ()) {
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
      this.cgE.cgX = a.chk;
      break;
      this.cgE.cgX = a.chl;
      break;
      this.chh = localb.text;
    }
  }
  
  public boolean getAnimateMeasurementChange()
  {
    return this.chg;
  }
  
  public long getAnimationDelay()
  {
    return this.chd;
  }
  
  public long getAnimationDuration()
  {
    return this.che;
  }
  
  public Interpolator getAnimationInterpolator()
  {
    return this.chf;
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
    Typeface localTypeface = this.cgU.getTypeface();
    AppMethodBeat.o(39874);
    return localTypeface;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(39883);
    super.onDraw(paramCanvas);
    paramCanvas.save();
    float f3 = this.cgZ.IM();
    float f4 = this.cgE.cgK;
    int i = this.gravity;
    Object localObject = this.cha;
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
        paramCanvas.translate(0.0F, this.cgE.cgW);
        localObject = this.cgZ;
        Paint localPaint = this.cgU;
        j = ((e)localObject).cgS.size();
        i = 0;
        while (i < j)
        {
          d locald = (d)((e)localObject).cgS.get(i);
          if (d.a(paramCanvas, localPaint, locald.cgH, locald.cgI, locald.cgJ))
          {
            if (locald.cgI >= 0) {
              locald.cgF = locald.cgH[locald.cgI];
            }
            locald.cgP = locald.cgJ;
          }
          d.a(paramCanvas, localPaint, locald.cgH, locald.cgI + 1, locald.cgJ - locald.cgK);
          d.a(paramCanvas, localPaint, locald.cgH, locald.cgI - 1, locald.cgJ + locald.cgK);
          paramCanvas.translate(locald.IM(), 0.0F);
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
    this.chb = IS();
    this.chc = IT();
    setMeasuredDimension(resolveSize(this.chb, paramInt1), resolveSize(this.chc, paramInt2));
    AppMethodBeat.o(39881);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(39882);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.cha.set(getPaddingLeft(), getPaddingTop(), paramInt1 - getPaddingRight(), paramInt2 - getPaddingBottom());
    AppMethodBeat.o(39882);
  }
  
  public void setAnimateMeasurementChange(boolean paramBoolean)
  {
    this.chg = paramBoolean;
  }
  
  public void setAnimationDelay(long paramLong)
  {
    this.chd = paramLong;
  }
  
  public void setAnimationDuration(long paramLong)
  {
    this.che = paramLong;
  }
  
  public void setAnimationInterpolator(Interpolator paramInterpolator)
  {
    this.chf = paramInterpolator;
  }
  
  public void setCharacterLists(String... paramVarArgs)
  {
    AppMethodBeat.i(39869);
    e locale = this.cgZ;
    locale.cgD = new c[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      locale.cgD[i] = new c(paramVarArgs[i]);
      i += 1;
    }
    locale.cgT = new HashSet();
    i = 0;
    while (i < paramVarArgs.length)
    {
      locale.cgT.addAll(locale.cgD[i].cgA.keySet());
      i += 1;
    }
    if (this.chh != null)
    {
      setText(this.chh, false);
      this.chh = null;
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
    this.cgE.cgX = parama;
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
      this.cgZ.b(arrayOfChar);
      setContentDescription(paramString);
      if (!paramBoolean) {
        break;
      }
      if (this.animator.isRunning()) {
        this.animator.cancel();
      }
      this.animator.setStartDelay(this.chd);
      this.animator.setDuration(this.che);
      this.animator.setInterpolator(this.chf);
      this.animator.start();
      AppMethodBeat.o(39871);
      return;
    }
    this.cgZ.setAnimationProgress(1.0F);
    this.cgZ.onAnimationEnd();
    IR();
    invalidate();
    AppMethodBeat.o(39871);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(39872);
    if (this.textColor != paramInt)
    {
      this.textColor = paramInt;
      this.cgU.setColor(this.textColor);
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
      this.cgU.setTextSize(paramFloat);
      IU();
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
      this.cgU.setTypeface(localTypeface);
      IU();
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
      chj = new a("ANY", 0);
      chk = new a("UP", 1);
      chl = new a("DOWN", 2);
      chm = new a[] { chj, chk, chl };
      AppMethodBeat.o(39863);
    }
    
    private a() {}
  }
  
  final class b
  {
    int gravity;
    float ly;
    float lz;
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
      this.ly = paramTypedArray.getFloat(7, this.ly);
      this.lz = paramTypedArray.getFloat(8, this.lz);
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