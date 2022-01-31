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
  private static final RectF abs = new RectF();
  private static ConcurrentHashMap<String, Method> abt = new ConcurrentHashMap();
  private boolean abA = false;
  private TextPaint abB;
  int abu = 0;
  private boolean abv = false;
  float abw = -1.0F;
  float abx = -1.0F;
  float aby = -1.0F;
  int[] abz = new int[0];
  private final Context mContext;
  private final TextView md;
  
  m(TextView paramTextView)
  {
    this.md = paramTextView;
    this.mContext = this.md.getContext();
  }
  
  private static Method Q(String paramString)
  {
    try
    {
      Method localMethod2 = (Method)abt.get(paramString);
      Method localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        localMethod2 = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        localMethod1 = localMethod2;
        if (localMethod2 != null)
        {
          localMethod2.setAccessible(true);
          abt.put(paramString, localMethod2);
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
  
  private int a(RectF paramRectF)
  {
    int j = this.abz.length;
    if (j == 0) {
      throw new IllegalStateException("No available text sizes to choose from.");
    }
    int i = 1;
    int k = j - 1;
    j = 0;
    while (i <= k)
    {
      int m = (i + k) / 2;
      if (a(this.abz[m], paramRectF))
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
    return this.abz[j];
  }
  
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt)
  {
    float f1;
    float f2;
    if (Build.VERSION.SDK_INT >= 16)
    {
      f1 = this.md.getLineSpacingMultiplier();
      f2 = this.md.getLineSpacingExtra();
    }
    for (boolean bool = this.md.getIncludeFontPadding();; bool = ((Boolean)a(this.md, "getIncludeFontPadding", Boolean.TRUE)).booleanValue())
    {
      return new StaticLayout(paramCharSequence, this.abB, paramInt, paramAlignment, f1, f2, bool);
      f1 = ((Float)a(this.md, "getLineSpacingMultiplier", Float.valueOf(1.0F))).floatValue();
      f2 = ((Float)a(this.md, "getLineSpacingExtra", Float.valueOf(0.0F))).floatValue();
    }
  }
  
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    TextDirectionHeuristic localTextDirectionHeuristic = (TextDirectionHeuristic)a(this.md, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
    paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), this.abB, paramInt1).setAlignment(paramAlignment).setLineSpacing(this.md.getLineSpacingExtra(), this.md.getLineSpacingMultiplier()).setIncludePad(this.md.getIncludeFontPadding()).setBreakStrategy(this.md.getBreakStrategy()).setHyphenationFrequency(this.md.getHyphenationFrequency());
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
      paramObject = Q(paramString).invoke(paramObject, new Object[0]);
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
    Object localObject2 = this.md.getText();
    Object localObject3 = this.md.getTransformationMethod();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((TransformationMethod)localObject3).getTransformation((CharSequence)localObject2, this.md);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = localObject3;
      }
    }
    int i;
    if (Build.VERSION.SDK_INT >= 16)
    {
      i = this.md.getMaxLines();
      if (this.abB != null) {
        break label199;
      }
      this.abB = new TextPaint();
      label89:
      this.abB.set(this.md.getPaint());
      this.abB.setTextSize(paramInt);
      localObject2 = (Layout.Alignment)a(this.md, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
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
      this.abB.reset();
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
      this.abz = i(arrayOfInt);
      hn();
    }
  }
  
  private void f(float paramFloat1, float paramFloat2, float paramFloat3)
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
    this.abu = 1;
    this.abx = paramFloat1;
    this.aby = paramFloat2;
    this.abw = paramFloat3;
    this.abA = false;
  }
  
  private boolean hn()
  {
    int i = this.abz.length;
    if (i > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.abA = bool;
      if (this.abA)
      {
        this.abu = 1;
        this.abx = this.abz[0];
        this.aby = this.abz[(i - 1)];
        this.abw = -1.0F;
      }
      return this.abA;
    }
  }
  
  private boolean ho()
  {
    if ((hs()) && (this.abu == 1)) {
      if ((!this.abA) || (this.abz.length == 0))
      {
        float f1 = Math.round(this.abx);
        int i = 1;
        while (Math.round(this.abw + f1) <= Math.round(this.aby))
        {
          i += 1;
          f1 += this.abw;
        }
        int[] arrayOfInt = new int[i];
        f1 = this.abx;
        int j = 0;
        while (j < i)
        {
          arrayOfInt[j] = Math.round(f1);
          float f2 = this.abw;
          j += 1;
          f1 = f2 + f1;
        }
        this.abz = i(arrayOfInt);
      }
    }
    for (this.abv = true;; this.abv = false) {
      return this.abv;
    }
  }
  
  private void hq()
  {
    this.abu = 0;
    this.abx = -1.0F;
    this.aby = -1.0F;
    this.abw = -1.0F;
    this.abz = new int[0];
    this.abv = false;
  }
  
  private boolean hs()
  {
    return !(this.md instanceof AppCompatEditText);
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
  
  private void setRawTextSize(float paramFloat)
  {
    if (paramFloat != this.md.getPaint().getTextSize())
    {
      this.md.getPaint().setTextSize(paramFloat);
      if (Build.VERSION.SDK_INT < 18) {
        break label114;
      }
    }
    label81:
    label114:
    for (boolean bool = this.md.isInLayout();; bool = false)
    {
      if (this.md.getLayout() != null) {
        this.abv = false;
      }
      try
      {
        Method localMethod = Q("nullLayouts");
        if (localMethod != null) {
          localMethod.invoke(this.md, new Object[0]);
        }
      }
      catch (Exception localException)
      {
        break label81;
      }
      if (!bool) {
        this.md.requestLayout();
      }
      for (;;)
      {
        this.md.invalidate();
        return;
        this.md.forceLayout();
      }
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.mContext.obtainStyledAttributes(paramAttributeSet, a.a.AppCompatTextView, paramInt, 0);
    if (paramAttributeSet.hasValue(2)) {
      this.abu = paramAttributeSet.getInt(2, 0);
    }
    if (paramAttributeSet.hasValue(3)) {}
    for (float f1 = paramAttributeSet.getDimension(3, -1.0F);; f1 = -1.0F)
    {
      if (paramAttributeSet.hasValue(5)) {}
      for (float f2 = paramAttributeSet.getDimension(5, -1.0F);; f2 = -1.0F)
      {
        if (paramAttributeSet.hasValue(6)) {}
        for (float f3 = paramAttributeSet.getDimension(6, -1.0F);; f3 = -1.0F)
        {
          if (paramAttributeSet.hasValue(4))
          {
            paramInt = paramAttributeSet.getResourceId(4, 0);
            if (paramInt > 0)
            {
              TypedArray localTypedArray = paramAttributeSet.getResources().obtainTypedArray(paramInt);
              b(localTypedArray);
              localTypedArray.recycle();
            }
          }
          paramAttributeSet.recycle();
          if (hs())
          {
            if (this.abu == 1)
            {
              if (!this.abA)
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
                f(f4, f2, f3);
              }
              ho();
            }
            return;
          }
          this.abu = 0;
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
  
  final void hp()
  {
    if (!hr()) {}
    do
    {
      return;
      if (!this.abv) {
        break;
      }
    } while ((this.md.getMeasuredHeight() <= 0) || (this.md.getMeasuredWidth() <= 0));
    int i;
    if (((Boolean)a(this.md, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue()) {
      i = 1048576;
    }
    for (;;)
    {
      int j = this.md.getHeight() - this.md.getCompoundPaddingBottom() - this.md.getCompoundPaddingTop();
      if ((i <= 0) || (j <= 0)) {
        break;
      }
      synchronized (abs)
      {
        abs.setEmpty();
        abs.right = i;
        abs.bottom = j;
        float f = a(abs);
        if (f != this.md.getTextSize()) {
          e(0, f);
        }
        this.abv = true;
        return;
        i = this.md.getMeasuredWidth() - this.md.getTotalPaddingLeft() - this.md.getTotalPaddingRight();
      }
    }
  }
  
  final boolean hr()
  {
    return (hs()) && (this.abu != 0);
  }
  
  final void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (hs())
    {
      DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      f(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (ho()) {
        hp();
      }
    }
  }
  
  final void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    if (hs())
    {
      int j = paramArrayOfInt.length;
      if (j > 0)
      {
        int[] arrayOfInt2 = new int[j];
        int[] arrayOfInt1;
        if (paramInt == 0)
        {
          arrayOfInt1 = Arrays.copyOf(paramArrayOfInt, j);
          this.abz = i(arrayOfInt1);
          if (!hn()) {
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
        this.abA = false;
      }
      if (ho()) {
        hp();
      }
    }
  }
  
  final void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (hs()) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("Unknown auto-size text type: ".concat(String.valueOf(paramInt)));
      case 0: 
        hq();
      }
    }
    do
    {
      return;
      DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      f(TypedValue.applyDimension(2, 12.0F, localDisplayMetrics), TypedValue.applyDimension(2, 112.0F, localDisplayMetrics), 1.0F);
    } while (!ho());
    hp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.m
 * JD-Core Version:    0.7.0.1
 */