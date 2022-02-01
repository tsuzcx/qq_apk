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
  private static final RectF aiy = new RectF();
  private static ConcurrentHashMap<String, Method> aiz = new ConcurrentHashMap();
  private final TextView Tu;
  int aiA = 0;
  private boolean aiB = false;
  float aiC = -1.0F;
  float aiD = -1.0F;
  float aiE = -1.0F;
  int[] aiF = new int[0];
  private boolean aiG = false;
  private TextPaint aiH;
  private final Context mContext;
  
  m(TextView paramTextView)
  {
    this.Tu = paramTextView;
    this.mContext = this.Tu.getContext();
  }
  
  private static Method C(String paramString)
  {
    try
    {
      Method localMethod2 = (Method)aiz.get(paramString);
      Method localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        localMethod2 = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        localMethod1 = localMethod2;
        if (localMethod2 != null)
        {
          localMethod2.setAccessible(true);
          aiz.put(paramString, localMethod2);
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
      f1 = this.Tu.getLineSpacingMultiplier();
      f2 = this.Tu.getLineSpacingExtra();
    }
    for (boolean bool = this.Tu.getIncludeFontPadding();; bool = ((Boolean)a(this.Tu, "getIncludeFontPadding", Boolean.TRUE)).booleanValue())
    {
      return new StaticLayout(paramCharSequence, this.aiH, paramInt, paramAlignment, f1, f2, bool);
      f1 = ((Float)a(this.Tu, "getLineSpacingMultiplier", Float.valueOf(1.0F))).floatValue();
      f2 = ((Float)a(this.Tu, "getLineSpacingExtra", Float.valueOf(0.0F))).floatValue();
    }
  }
  
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    TextDirectionHeuristic localTextDirectionHeuristic = (TextDirectionHeuristic)a(this.Tu, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
    paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), this.aiH, paramInt1).setAlignment(paramAlignment).setLineSpacing(this.Tu.getLineSpacingExtra(), this.Tu.getLineSpacingMultiplier()).setIncludePad(this.Tu.getIncludeFontPadding()).setBreakStrategy(this.Tu.getBreakStrategy()).setHyphenationFrequency(this.Tu.getHyphenationFrequency());
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
      paramObject = C(paramString).invoke(paramObject, new Object[0]);
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
    Object localObject2 = this.Tu.getText();
    Object localObject3 = this.Tu.getTransformationMethod();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((TransformationMethod)localObject3).getTransformation((CharSequence)localObject2, this.Tu);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = localObject3;
      }
    }
    int i;
    if (Build.VERSION.SDK_INT >= 16)
    {
      i = this.Tu.getMaxLines();
      if (this.aiH != null) {
        break label199;
      }
      this.aiH = new TextPaint();
      label89:
      this.aiH.set(this.Tu.getPaint());
      this.aiH.setTextSize(paramInt);
      localObject2 = (Layout.Alignment)a(this.Tu, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
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
      this.aiH.reset();
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
      this.aiF = i(arrayOfInt);
      iK();
    }
  }
  
  private int d(RectF paramRectF)
  {
    int j = this.aiF.length;
    if (j == 0) {
      throw new IllegalStateException("No available text sizes to choose from.");
    }
    int i = 1;
    int k = j - 1;
    j = 0;
    while (i <= k)
    {
      int m = (i + k) / 2;
      if (a(this.aiF[m], paramRectF))
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
    return this.aiF[j];
  }
  
  private void h(float paramFloat1, float paramFloat2, float paramFloat3)
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
    this.aiA = 1;
    this.aiD = paramFloat1;
    this.aiE = paramFloat2;
    this.aiC = paramFloat3;
    this.aiG = false;
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
  
  private boolean iK()
  {
    int i = this.aiF.length;
    if (i > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.aiG = bool;
      if (this.aiG)
      {
        this.aiA = 1;
        this.aiD = this.aiF[0];
        this.aiE = this.aiF[(i - 1)];
        this.aiC = -1.0F;
      }
      return this.aiG;
    }
  }
  
  private boolean iL()
  {
    if ((iP()) && (this.aiA == 1)) {
      if ((!this.aiG) || (this.aiF.length == 0))
      {
        float f1 = Math.round(this.aiD);
        int i = 1;
        while (Math.round(this.aiC + f1) <= Math.round(this.aiE))
        {
          i += 1;
          f1 += this.aiC;
        }
        int[] arrayOfInt = new int[i];
        f1 = this.aiD;
        int j = 0;
        while (j < i)
        {
          arrayOfInt[j] = Math.round(f1);
          float f2 = this.aiC;
          j += 1;
          f1 = f2 + f1;
        }
        this.aiF = i(arrayOfInt);
      }
    }
    for (this.aiB = true;; this.aiB = false) {
      return this.aiB;
    }
  }
  
  private void iN()
  {
    this.aiA = 0;
    this.aiD = -1.0F;
    this.aiE = -1.0F;
    this.aiC = -1.0F;
    this.aiF = new int[0];
    this.aiB = false;
  }
  
  private boolean iP()
  {
    return !(this.Tu instanceof AppCompatEditText);
  }
  
  private void setRawTextSize(float paramFloat)
  {
    if (paramFloat != this.Tu.getPaint().getTextSize())
    {
      this.Tu.getPaint().setTextSize(paramFloat);
      if (Build.VERSION.SDK_INT < 18) {
        break label114;
      }
    }
    label81:
    label114:
    for (boolean bool = this.Tu.isInLayout();; bool = false)
    {
      if (this.Tu.getLayout() != null) {
        this.aiB = false;
      }
      try
      {
        Method localMethod = C("nullLayouts");
        if (localMethod != null) {
          localMethod.invoke(this.Tu, new Object[0]);
        }
      }
      catch (Exception localException)
      {
        break label81;
      }
      if (!bool) {
        this.Tu.requestLayout();
      }
      for (;;)
      {
        this.Tu.invalidate();
        return;
        this.Tu.forceLayout();
      }
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.mContext.obtainStyledAttributes(paramAttributeSet, a.a.AppCompatTextView, paramInt, 0);
    if (paramAttributeSet.hasValue(5)) {
      this.aiA = paramAttributeSet.getInt(5, 0);
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
          if (iP())
          {
            if (this.aiA == 1)
            {
              if (!this.aiG)
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
                h(f4, f2, f3);
              }
              iL();
            }
            return;
          }
          this.aiA = 0;
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
  
  final void iM()
  {
    if (!iO()) {}
    do
    {
      return;
      if (!this.aiB) {
        break;
      }
    } while ((this.Tu.getMeasuredHeight() <= 0) || (this.Tu.getMeasuredWidth() <= 0));
    int i;
    if (((Boolean)a(this.Tu, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue()) {
      i = 1048576;
    }
    for (;;)
    {
      int j = this.Tu.getHeight() - this.Tu.getCompoundPaddingBottom() - this.Tu.getCompoundPaddingTop();
      if ((i <= 0) || (j <= 0)) {
        break;
      }
      synchronized (aiy)
      {
        aiy.setEmpty();
        aiy.right = i;
        aiy.bottom = j;
        float f = d(aiy);
        if (f != this.Tu.getTextSize()) {
          e(0, f);
        }
        this.aiB = true;
        return;
        i = this.Tu.getMeasuredWidth() - this.Tu.getTotalPaddingLeft() - this.Tu.getTotalPaddingRight();
      }
    }
  }
  
  final boolean iO()
  {
    return (iP()) && (this.aiA != 0);
  }
  
  final void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (iP())
    {
      DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      h(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (iL()) {
        iM();
      }
    }
  }
  
  final void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    if (iP())
    {
      int j = paramArrayOfInt.length;
      if (j > 0)
      {
        int[] arrayOfInt2 = new int[j];
        int[] arrayOfInt1;
        if (paramInt == 0)
        {
          arrayOfInt1 = Arrays.copyOf(paramArrayOfInt, j);
          this.aiF = i(arrayOfInt1);
          if (!iK()) {
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
        this.aiG = false;
      }
      if (iL()) {
        iM();
      }
    }
  }
  
  final void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (iP()) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("Unknown auto-size text type: ".concat(String.valueOf(paramInt)));
      case 0: 
        iN();
      }
    }
    do
    {
      return;
      DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      h(TypedValue.applyDimension(2, 12.0F, localDisplayMetrics), TypedValue.applyDimension(2, 112.0F, localDisplayMetrics), 1.0F);
    } while (!iL());
    iM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.m
 * JD-Core Version:    0.7.0.1
 */