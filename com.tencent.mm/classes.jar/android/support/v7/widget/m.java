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
  private static final RectF alw = new RectF();
  private static ConcurrentHashMap<String, Method> alx = new ConcurrentHashMap();
  private final TextView Ws;
  float alA = -1.0F;
  float alB = -1.0F;
  float alC = -1.0F;
  int[] alD = new int[0];
  private boolean alE = false;
  private TextPaint alF;
  int aly = 0;
  private boolean alz = false;
  private final Context mContext;
  
  m(TextView paramTextView)
  {
    this.Ws = paramTextView;
    this.mContext = this.Ws.getContext();
  }
  
  private static Method E(String paramString)
  {
    try
    {
      Method localMethod2 = (Method)alx.get(paramString);
      Method localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        localMethod2 = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        localMethod1 = localMethod2;
        if (localMethod2 != null)
        {
          localMethod2.setAccessible(true);
          alx.put(paramString, localMethod2);
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
      f1 = this.Ws.getLineSpacingMultiplier();
      f2 = this.Ws.getLineSpacingExtra();
    }
    for (boolean bool = this.Ws.getIncludeFontPadding();; bool = ((Boolean)a(this.Ws, "getIncludeFontPadding", Boolean.TRUE)).booleanValue())
    {
      return new StaticLayout(paramCharSequence, this.alF, paramInt, paramAlignment, f1, f2, bool);
      f1 = ((Float)a(this.Ws, "getLineSpacingMultiplier", Float.valueOf(1.0F))).floatValue();
      f2 = ((Float)a(this.Ws, "getLineSpacingExtra", Float.valueOf(0.0F))).floatValue();
    }
  }
  
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    TextDirectionHeuristic localTextDirectionHeuristic = (TextDirectionHeuristic)a(this.Ws, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
    paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), this.alF, paramInt1).setAlignment(paramAlignment).setLineSpacing(this.Ws.getLineSpacingExtra(), this.Ws.getLineSpacingMultiplier()).setIncludePad(this.Ws.getIncludeFontPadding()).setBreakStrategy(this.Ws.getBreakStrategy()).setHyphenationFrequency(this.Ws.getHyphenationFrequency());
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
    Object localObject2 = this.Ws.getText();
    Object localObject3 = this.Ws.getTransformationMethod();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((TransformationMethod)localObject3).getTransformation((CharSequence)localObject2, this.Ws);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = localObject3;
      }
    }
    int i;
    if (Build.VERSION.SDK_INT >= 16)
    {
      i = this.Ws.getMaxLines();
      if (this.alF != null) {
        break label199;
      }
      this.alF = new TextPaint();
      label89:
      this.alF.set(this.Ws.getPaint());
      this.alF.setTextSize(paramInt);
      localObject2 = (Layout.Alignment)a(this.Ws, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
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
      this.alF.reset();
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
      this.alD = i(arrayOfInt);
      jr();
    }
  }
  
  private int d(RectF paramRectF)
  {
    int j = this.alD.length;
    if (j == 0) {
      throw new IllegalStateException("No available text sizes to choose from.");
    }
    int i = 1;
    int k = j - 1;
    j = 0;
    while (i <= k)
    {
      int m = (i + k) / 2;
      if (a(this.alD[m], paramRectF))
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
    return this.alD[j];
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
    this.aly = 1;
    this.alB = paramFloat1;
    this.alC = paramFloat2;
    this.alA = paramFloat3;
    this.alE = false;
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
  
  private boolean jr()
  {
    int i = this.alD.length;
    if (i > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.alE = bool;
      if (this.alE)
      {
        this.aly = 1;
        this.alB = this.alD[0];
        this.alC = this.alD[(i - 1)];
        this.alA = -1.0F;
      }
      return this.alE;
    }
  }
  
  private boolean js()
  {
    if ((jw()) && (this.aly == 1)) {
      if ((!this.alE) || (this.alD.length == 0))
      {
        float f1 = Math.round(this.alB);
        int i = 1;
        while (Math.round(this.alA + f1) <= Math.round(this.alC))
        {
          i += 1;
          f1 += this.alA;
        }
        int[] arrayOfInt = new int[i];
        f1 = this.alB;
        int j = 0;
        while (j < i)
        {
          arrayOfInt[j] = Math.round(f1);
          float f2 = this.alA;
          j += 1;
          f1 = f2 + f1;
        }
        this.alD = i(arrayOfInt);
      }
    }
    for (this.alz = true;; this.alz = false) {
      return this.alz;
    }
  }
  
  private void ju()
  {
    this.aly = 0;
    this.alB = -1.0F;
    this.alC = -1.0F;
    this.alA = -1.0F;
    this.alD = new int[0];
    this.alz = false;
  }
  
  private boolean jw()
  {
    return !(this.Ws instanceof AppCompatEditText);
  }
  
  private void setRawTextSize(float paramFloat)
  {
    if (paramFloat != this.Ws.getPaint().getTextSize())
    {
      this.Ws.getPaint().setTextSize(paramFloat);
      if (Build.VERSION.SDK_INT < 18) {
        break label114;
      }
    }
    label81:
    label114:
    for (boolean bool = this.Ws.isInLayout();; bool = false)
    {
      if (this.Ws.getLayout() != null) {
        this.alz = false;
      }
      try
      {
        Method localMethod = E("nullLayouts");
        if (localMethod != null) {
          localMethod.invoke(this.Ws, new Object[0]);
        }
      }
      catch (Exception localException)
      {
        break label81;
      }
      if (!bool) {
        this.Ws.requestLayout();
      }
      for (;;)
      {
        this.Ws.invalidate();
        return;
        this.Ws.forceLayout();
      }
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.mContext.obtainStyledAttributes(paramAttributeSet, a.a.AppCompatTextView, paramInt, 0);
    if (paramAttributeSet.hasValue(5)) {
      this.aly = paramAttributeSet.getInt(5, 0);
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
          if (jw())
          {
            if (this.aly == 1)
            {
              if (!this.alE)
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
              js();
            }
            return;
          }
          this.aly = 0;
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
  
  final void jt()
  {
    if (!jv()) {}
    do
    {
      return;
      if (!this.alz) {
        break;
      }
    } while ((this.Ws.getMeasuredHeight() <= 0) || (this.Ws.getMeasuredWidth() <= 0));
    int i;
    if (((Boolean)a(this.Ws, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue()) {
      i = 1048576;
    }
    for (;;)
    {
      int j = this.Ws.getHeight() - this.Ws.getCompoundPaddingBottom() - this.Ws.getCompoundPaddingTop();
      if ((i <= 0) || (j <= 0)) {
        break;
      }
      synchronized (alw)
      {
        alw.setEmpty();
        alw.right = i;
        alw.bottom = j;
        float f = d(alw);
        if (f != this.Ws.getTextSize()) {
          e(0, f);
        }
        this.alz = true;
        return;
        i = this.Ws.getMeasuredWidth() - this.Ws.getTotalPaddingLeft() - this.Ws.getTotalPaddingRight();
      }
    }
  }
  
  final boolean jv()
  {
    return (jw()) && (this.aly != 0);
  }
  
  final void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (jw())
    {
      DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      g(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (js()) {
        jt();
      }
    }
  }
  
  final void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    if (jw())
    {
      int j = paramArrayOfInt.length;
      if (j > 0)
      {
        int[] arrayOfInt2 = new int[j];
        int[] arrayOfInt1;
        if (paramInt == 0)
        {
          arrayOfInt1 = Arrays.copyOf(paramArrayOfInt, j);
          this.alD = i(arrayOfInt1);
          if (!jr()) {
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
        this.alE = false;
      }
      if (js()) {
        jt();
      }
    }
  }
  
  final void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (jw()) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("Unknown auto-size text type: ".concat(String.valueOf(paramInt)));
      case 0: 
        ju();
      }
    }
    do
    {
      return;
      DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      g(TypedValue.applyDimension(2, 12.0F, localDisplayMetrics), TypedValue.applyDimension(2, 112.0F, localDisplayMetrics), 1.0F);
    } while (!js());
    jt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.m
 * JD-Core Version:    0.7.0.1
 */