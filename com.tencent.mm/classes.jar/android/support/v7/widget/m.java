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
  private static final RectF alj = new RectF();
  private static ConcurrentHashMap<String, Method> alk = new ConcurrentHashMap();
  private final TextView Wf;
  int all = 0;
  private boolean alm = false;
  float aln = -1.0F;
  float alo = -1.0F;
  float alp = -1.0F;
  int[] alq = new int[0];
  private boolean alr = false;
  private TextPaint als;
  private final Context mContext;
  
  m(TextView paramTextView)
  {
    this.Wf = paramTextView;
    this.mContext = this.Wf.getContext();
  }
  
  private static Method D(String paramString)
  {
    try
    {
      Method localMethod2 = (Method)alk.get(paramString);
      Method localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        localMethod2 = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        localMethod1 = localMethod2;
        if (localMethod2 != null)
        {
          localMethod2.setAccessible(true);
          alk.put(paramString, localMethod2);
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
      f1 = this.Wf.getLineSpacingMultiplier();
      f2 = this.Wf.getLineSpacingExtra();
    }
    for (boolean bool = this.Wf.getIncludeFontPadding();; bool = ((Boolean)a(this.Wf, "getIncludeFontPadding", Boolean.TRUE)).booleanValue())
    {
      return new StaticLayout(paramCharSequence, this.als, paramInt, paramAlignment, f1, f2, bool);
      f1 = ((Float)a(this.Wf, "getLineSpacingMultiplier", Float.valueOf(1.0F))).floatValue();
      f2 = ((Float)a(this.Wf, "getLineSpacingExtra", Float.valueOf(0.0F))).floatValue();
    }
  }
  
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    TextDirectionHeuristic localTextDirectionHeuristic = (TextDirectionHeuristic)a(this.Wf, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
    paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), this.als, paramInt1).setAlignment(paramAlignment).setLineSpacing(this.Wf.getLineSpacingExtra(), this.Wf.getLineSpacingMultiplier()).setIncludePad(this.Wf.getIncludeFontPadding()).setBreakStrategy(this.Wf.getBreakStrategy()).setHyphenationFrequency(this.Wf.getHyphenationFrequency());
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
      paramObject = D(paramString).invoke(paramObject, new Object[0]);
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
    Object localObject2 = this.Wf.getText();
    Object localObject3 = this.Wf.getTransformationMethod();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((TransformationMethod)localObject3).getTransformation((CharSequence)localObject2, this.Wf);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = localObject3;
      }
    }
    int i;
    if (Build.VERSION.SDK_INT >= 16)
    {
      i = this.Wf.getMaxLines();
      if (this.als != null) {
        break label199;
      }
      this.als = new TextPaint();
      label89:
      this.als.set(this.Wf.getPaint());
      this.als.setTextSize(paramInt);
      localObject2 = (Layout.Alignment)a(this.Wf, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
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
      this.als.reset();
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
      this.alq = i(arrayOfInt);
      ji();
    }
  }
  
  private int d(RectF paramRectF)
  {
    int j = this.alq.length;
    if (j == 0) {
      throw new IllegalStateException("No available text sizes to choose from.");
    }
    int i = 1;
    int k = j - 1;
    j = 0;
    while (i <= k)
    {
      int m = (i + k) / 2;
      if (a(this.alq[m], paramRectF))
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
    return this.alq[j];
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
    this.all = 1;
    this.alo = paramFloat1;
    this.alp = paramFloat2;
    this.aln = paramFloat3;
    this.alr = false;
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
  
  private boolean ji()
  {
    int i = this.alq.length;
    if (i > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.alr = bool;
      if (this.alr)
      {
        this.all = 1;
        this.alo = this.alq[0];
        this.alp = this.alq[(i - 1)];
        this.aln = -1.0F;
      }
      return this.alr;
    }
  }
  
  private boolean jj()
  {
    if ((jn()) && (this.all == 1)) {
      if ((!this.alr) || (this.alq.length == 0))
      {
        float f1 = Math.round(this.alo);
        int i = 1;
        while (Math.round(this.aln + f1) <= Math.round(this.alp))
        {
          i += 1;
          f1 += this.aln;
        }
        int[] arrayOfInt = new int[i];
        f1 = this.alo;
        int j = 0;
        while (j < i)
        {
          arrayOfInt[j] = Math.round(f1);
          float f2 = this.aln;
          j += 1;
          f1 = f2 + f1;
        }
        this.alq = i(arrayOfInt);
      }
    }
    for (this.alm = true;; this.alm = false) {
      return this.alm;
    }
  }
  
  private void jl()
  {
    this.all = 0;
    this.alo = -1.0F;
    this.alp = -1.0F;
    this.aln = -1.0F;
    this.alq = new int[0];
    this.alm = false;
  }
  
  private boolean jn()
  {
    return !(this.Wf instanceof AppCompatEditText);
  }
  
  private void setRawTextSize(float paramFloat)
  {
    if (paramFloat != this.Wf.getPaint().getTextSize())
    {
      this.Wf.getPaint().setTextSize(paramFloat);
      if (Build.VERSION.SDK_INT < 18) {
        break label114;
      }
    }
    label81:
    label114:
    for (boolean bool = this.Wf.isInLayout();; bool = false)
    {
      if (this.Wf.getLayout() != null) {
        this.alm = false;
      }
      try
      {
        Method localMethod = D("nullLayouts");
        if (localMethod != null) {
          localMethod.invoke(this.Wf, new Object[0]);
        }
      }
      catch (Exception localException)
      {
        break label81;
      }
      if (!bool) {
        this.Wf.requestLayout();
      }
      for (;;)
      {
        this.Wf.invalidate();
        return;
        this.Wf.forceLayout();
      }
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.mContext.obtainStyledAttributes(paramAttributeSet, a.a.AppCompatTextView, paramInt, 0);
    if (paramAttributeSet.hasValue(5)) {
      this.all = paramAttributeSet.getInt(5, 0);
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
          if (jn())
          {
            if (this.all == 1)
            {
              if (!this.alr)
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
              jj();
            }
            return;
          }
          this.all = 0;
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
  
  final void jk()
  {
    if (!jm()) {}
    do
    {
      return;
      if (!this.alm) {
        break;
      }
    } while ((this.Wf.getMeasuredHeight() <= 0) || (this.Wf.getMeasuredWidth() <= 0));
    int i;
    if (((Boolean)a(this.Wf, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue()) {
      i = 1048576;
    }
    for (;;)
    {
      int j = this.Wf.getHeight() - this.Wf.getCompoundPaddingBottom() - this.Wf.getCompoundPaddingTop();
      if ((i <= 0) || (j <= 0)) {
        break;
      }
      synchronized (alj)
      {
        alj.setEmpty();
        alj.right = i;
        alj.bottom = j;
        float f = d(alj);
        if (f != this.Wf.getTextSize()) {
          e(0, f);
        }
        this.alm = true;
        return;
        i = this.Wf.getMeasuredWidth() - this.Wf.getTotalPaddingLeft() - this.Wf.getTotalPaddingRight();
      }
    }
  }
  
  final boolean jm()
  {
    return (jn()) && (this.all != 0);
  }
  
  final void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (jn())
    {
      DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      g(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (jj()) {
        jk();
      }
    }
  }
  
  final void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    if (jn())
    {
      int j = paramArrayOfInt.length;
      if (j > 0)
      {
        int[] arrayOfInt2 = new int[j];
        int[] arrayOfInt1;
        if (paramInt == 0)
        {
          arrayOfInt1 = Arrays.copyOf(paramArrayOfInt, j);
          this.alq = i(arrayOfInt1);
          if (!ji()) {
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
        this.alr = false;
      }
      if (jj()) {
        jk();
      }
    }
  }
  
  final void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (jn()) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("Unknown auto-size text type: ".concat(String.valueOf(paramInt)));
      case 0: 
        jl();
      }
    }
    do
    {
      return;
      DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      g(TypedValue.applyDimension(2, 12.0F, localDisplayMetrics), TypedValue.applyDimension(2, 112.0F, localDisplayMetrics), 1.0F);
    } while (!jj());
    jk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.m
 * JD-Core Version:    0.7.0.1
 */