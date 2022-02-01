package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.v7.a.a.a;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class m
{
  private static final RectF ajs = new RectF();
  private static ConcurrentHashMap<String, Method> ajt = new ConcurrentHashMap();
  private final TextView Up;
  private boolean ajA = false;
  private TextPaint ajB;
  int aju = 0;
  private boolean ajv = false;
  float ajw = -1.0F;
  float ajx = -1.0F;
  float ajy = -1.0F;
  int[] ajz = new int[0];
  private final Context mContext;
  
  m(TextView paramTextView)
  {
    this.Up = paramTextView;
    this.mContext = this.Up.getContext();
  }
  
  private static Method E(String paramString)
  {
    try
    {
      Method localMethod2 = (Method)ajt.get(paramString);
      Method localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        localMethod2 = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        localMethod1 = localMethod2;
        if (localMethod2 != null)
        {
          localMethod2.setAccessible(true);
          ajt.put(paramString, localMethod2);
          localMethod1 = localMethod2;
        }
      }
      return localMethod1;
    }
    catch (Exception localException)
    {
      new StringBuilder("Failed to retrieve TextView#").append(paramString).append("() method");
    }
    return null;
  }
  
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt)
  {
    float f1;
    float f2;
    if (Build.VERSION.SDK_INT >= 16)
    {
      f1 = this.Up.getLineSpacingMultiplier();
      f2 = this.Up.getLineSpacingExtra();
    }
    for (boolean bool = this.Up.getIncludeFontPadding();; bool = ((Boolean)a(this.Up, "getIncludeFontPadding", Boolean.TRUE)).booleanValue())
    {
      return new StaticLayout(paramCharSequence, this.ajB, paramInt, paramAlignment, f1, f2, bool);
      f1 = ((Float)a(this.Up, "getLineSpacingMultiplier", Float.valueOf(1.0F))).floatValue();
      f2 = ((Float)a(this.Up, "getLineSpacingExtra", Float.valueOf(0.0F))).floatValue();
    }
  }
  
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    TextDirectionHeuristic localTextDirectionHeuristic = (TextDirectionHeuristic)a(this.Up, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
    paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), this.ajB, paramInt1).setAlignment(paramAlignment).setLineSpacing(this.Up.getLineSpacingExtra(), this.Up.getLineSpacingMultiplier()).setIncludePad(this.Up.getIncludeFontPadding()).setBreakStrategy(this.Up.getBreakStrategy()).setHyphenationFrequency(this.Up.getHyphenationFrequency());
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = 2147483647;
    }
    return paramCharSequence.setMaxLines(paramInt1).setTextDirection(localTextDirectionHeuristic).build();
  }
  
  private static <T> T a(Object paramObject, String paramString, T paramT)
  {
    try
    {
      paramObject = E(paramString).invoke(paramObject, new Object[0]);
      if (paramObject == null) {}
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject = paramObject;
      new StringBuilder("Failed to invoke TextView#").append(paramString).append("() method");
      return paramT;
    }
    finally {}
  }
  
  private boolean a(int paramInt, RectF paramRectF)
  {
    Object localObject2 = this.Up.getText();
    Object localObject3 = this.Up.getTransformationMethod();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((TransformationMethod)localObject3).getTransformation((CharSequence)localObject2, this.Up);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = localObject3;
      }
    }
    int i;
    if (Build.VERSION.SDK_INT >= 16)
    {
      i = this.Up.getMaxLines();
      if (this.ajB != null) {
        break label199;
      }
      this.ajB = new TextPaint();
      label89:
      this.ajB.set(this.Up.getPaint());
      this.ajB.setTextSize(paramInt);
      localObject2 = (Layout.Alignment)a(this.Up, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
      if (Build.VERSION.SDK_INT < 23) {
        break label209;
      }
    }
    label199:
    label209:
    for (localObject2 = a(localObject1, (Layout.Alignment)localObject2, Math.round(paramRectF.right), i);; localObject2 = a(localObject1, (Layout.Alignment)localObject2, Math.round(paramRectF.right)))
    {
      if ((i == -1) || ((((StaticLayout)localObject2).getLineCount() <= i) && (((StaticLayout)localObject2).getLineEnd(((StaticLayout)localObject2).getLineCount() - 1) == localObject1.length()))) {
        break label229;
      }
      return false;
      i = -1;
      break;
      this.ajB.reset();
      break label89;
    }
    label229:
    return ((StaticLayout)localObject2).getHeight() <= paramRectF.bottom;
  }
  
  private void b(TypedArray paramTypedArray)
  {
    int j = paramTypedArray.length();
    int[] arrayOfInt = new int[j];
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        arrayOfInt[i] = paramTypedArray.getDimensionPixelSize(i, -1);
        i += 1;
      }
      this.ajz = i(arrayOfInt);
      iS();
    }
  }
  
  private int d(RectF paramRectF)
  {
    int j = this.ajz.length;
    if (j == 0) {
      throw new IllegalStateException("No available text sizes to choose from.");
    }
    int i = 1;
    int k = j - 1;
    j = 0;
    while (i <= k)
    {
      int m = (i + k) / 2;
      if (a(this.ajz[m], paramRectF))
      {
        j = i;
        i = m + 1;
      }
      else
      {
        k = m - 1;
        j = k;
      }
    }
    return this.ajz[j];
  }
  
  private void g(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 <= 0.0F) {
      throw new IllegalArgumentException("Minimum auto-size text size (" + paramFloat1 + "px) is less or equal to (0px)");
    }
    if (paramFloat2 <= paramFloat1) {
      throw new IllegalArgumentException("Maximum auto-size text size (" + paramFloat2 + "px) is less or equal to minimum auto-size text size (" + paramFloat1 + "px)");
    }
    if (paramFloat3 <= 0.0F) {
      throw new IllegalArgumentException("The auto-size step granularity (" + paramFloat3 + "px) is less or equal to (0px)");
    }
    this.aju = 1;
    this.ajx = paramFloat1;
    this.ajy = paramFloat2;
    this.ajw = paramFloat3;
    this.ajA = false;
  }
  
  private static int[] i(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    if (j == 0) {}
    ArrayList localArrayList;
    do
    {
      return paramArrayOfInt;
      Arrays.sort(paramArrayOfInt);
      localArrayList = new ArrayList();
      i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        if ((k > 0) && (Collections.binarySearch(localArrayList, Integer.valueOf(k)) < 0)) {
          localArrayList.add(Integer.valueOf(k));
        }
        i += 1;
      }
    } while (j == localArrayList.size());
    j = localArrayList.size();
    int[] arrayOfInt = new int[j];
    int i = 0;
    for (;;)
    {
      paramArrayOfInt = arrayOfInt;
      if (i >= j) {
        break;
      }
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
  }
  
  private boolean iS()
  {
    int i = this.ajz.length;
    if (i > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.ajA = bool;
      if (this.ajA)
      {
        this.aju = 1;
        this.ajx = this.ajz[0];
        this.ajy = this.ajz[(i - 1)];
        this.ajw = -1.0F;
      }
      return this.ajA;
    }
  }
  
  private boolean iT()
  {
    if ((iX()) && (this.aju == 1)) {
      if ((!this.ajA) || (this.ajz.length == 0))
      {
        float f1 = Math.round(this.ajx);
        int i = 1;
        while (Math.round(this.ajw + f1) <= Math.round(this.ajy))
        {
          i += 1;
          f1 += this.ajw;
        }
        int[] arrayOfInt = new int[i];
        f1 = this.ajx;
        int j = 0;
        while (j < i)
        {
          arrayOfInt[j] = Math.round(f1);
          float f2 = this.ajw;
          j += 1;
          f1 = f2 + f1;
        }
        this.ajz = i(arrayOfInt);
      }
    }
    for (this.ajv = true;; this.ajv = false) {
      return this.ajv;
    }
  }
  
  private void iV()
  {
    this.aju = 0;
    this.ajx = -1.0F;
    this.ajy = -1.0F;
    this.ajw = -1.0F;
    this.ajz = new int[0];
    this.ajv = false;
  }
  
  private boolean iX()
  {
    return !(this.Up instanceof AppCompatEditText);
  }
  
  private void setRawTextSize(float paramFloat)
  {
    if (paramFloat != this.Up.getPaint().getTextSize())
    {
      this.Up.getPaint().setTextSize(paramFloat);
      if (Build.VERSION.SDK_INT < 18) {
        break label114;
      }
    }
    label81:
    label114:
    for (boolean bool = this.Up.isInLayout();; bool = false)
    {
      if (this.Up.getLayout() != null) {
        this.ajv = false;
      }
      try
      {
        Method localMethod = E("nullLayouts");
        if (localMethod != null) {
          localMethod.invoke(this.Up, new Object[0]);
        }
      }
      catch (Exception localException)
      {
        break label81;
      }
      if (!bool) {
        this.Up.requestLayout();
      }
      for (;;)
      {
        this.Up.invalidate();
        return;
        this.Up.forceLayout();
      }
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.mContext.obtainStyledAttributes(paramAttributeSet, a.a.AppCompatTextView, paramInt, 0);
    if (paramAttributeSet.hasValue(5)) {
      this.aju = paramAttributeSet.getInt(5, 0);
    }
    if (paramAttributeSet.hasValue(4)) {}
    for (float f1 = paramAttributeSet.getDimension(4, -1.0F);; f1 = -1.0F)
    {
      if (paramAttributeSet.hasValue(2)) {}
      for (float f2 = paramAttributeSet.getDimension(2, -1.0F);; f2 = -1.0F)
      {
        if (paramAttributeSet.hasValue(1)) {}
        for (float f3 = paramAttributeSet.getDimension(1, -1.0F);; f3 = -1.0F)
        {
          if (paramAttributeSet.hasValue(3))
          {
            paramInt = paramAttributeSet.getResourceId(3, 0);
            if (paramInt > 0)
            {
              TypedArray localTypedArray = paramAttributeSet.getResources().obtainTypedArray(paramInt);
              b(localTypedArray);
              localTypedArray.recycle();
            }
          }
          paramAttributeSet.recycle();
          if (iX())
          {
            if (this.aju == 1)
            {
              if (!this.ajA)
              {
                paramAttributeSet = this.mContext.getResources().getDisplayMetrics();
                float f4 = f2;
                if (f2 == -1.0F) {
                  f4 = TypedValue.applyDimension(2, 12.0F, paramAttributeSet);
                }
                f2 = f3;
                if (f3 == -1.0F) {
                  f2 = TypedValue.applyDimension(2, 112.0F, paramAttributeSet);
                }
                f3 = f1;
                if (f1 == -1.0F) {
                  f3 = 1.0F;
                }
                g(f4, f2, f3);
              }
              iT();
            }
            return;
          }
          this.aju = 0;
          return;
        }
      }
    }
  }
  
  final void e(int paramInt, float paramFloat)
  {
    if (this.mContext == null) {}
    for (Resources localResources = Resources.getSystem();; localResources = this.mContext.getResources())
    {
      setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics()));
      return;
    }
  }
  
  final void iU()
  {
    if (!iW()) {}
    do
    {
      return;
      if (!this.ajv) {
        break;
      }
    } while ((this.Up.getMeasuredHeight() <= 0) || (this.Up.getMeasuredWidth() <= 0));
    int i;
    if (((Boolean)a(this.Up, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue()) {
      i = 1048576;
    }
    for (;;)
    {
      int j = this.Up.getHeight() - this.Up.getCompoundPaddingBottom() - this.Up.getCompoundPaddingTop();
      if ((i <= 0) || (j <= 0)) {
        break;
      }
      synchronized (ajs)
      {
        ajs.setEmpty();
        ajs.right = i;
        ajs.bottom = j;
        float f = d(ajs);
        if (f != this.Up.getTextSize()) {
          e(0, f);
        }
        this.ajv = true;
        return;
        i = this.Up.getMeasuredWidth() - this.Up.getTotalPaddingLeft() - this.Up.getTotalPaddingRight();
      }
    }
  }
  
  final boolean iW()
  {
    return (iX()) && (this.aju != 0);
  }
  
  final void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (iX())
    {
      DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      g(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (iT()) {
        iU();
      }
    }
  }
  
  final void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    if (iX())
    {
      int j = paramArrayOfInt.length;
      if (j > 0)
      {
        int[] arrayOfInt2 = new int[j];
        int[] arrayOfInt1;
        if (paramInt == 0)
        {
          arrayOfInt1 = Arrays.copyOf(paramArrayOfInt, j);
          this.ajz = i(arrayOfInt1);
          if (!iS()) {
            throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(paramArrayOfInt));
          }
        }
        else
        {
          DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
          for (;;)
          {
            arrayOfInt1 = arrayOfInt2;
            if (i >= j) {
              break;
            }
            arrayOfInt2[i] = Math.round(TypedValue.applyDimension(paramInt, paramArrayOfInt[i], localDisplayMetrics));
            i += 1;
          }
        }
      }
      else
      {
        this.ajA = false;
      }
      if (iT()) {
        iU();
      }
    }
  }
  
  final void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (iX()) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("Unknown auto-size text type: ".concat(String.valueOf(paramInt)));
      case 0: 
        iV();
      }
    }
    do
    {
      return;
      DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      g(TypedValue.applyDimension(2, 12.0F, localDisplayMetrics), TypedValue.applyDimension(2, 112.0F, localDisplayMetrics), 1.0F);
    } while (!iT());
    iU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.m
 * JD-Core Version:    0.7.0.1
 */