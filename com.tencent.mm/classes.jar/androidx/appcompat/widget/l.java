package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
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
import androidx.appcompat.a.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class l
{
  private static final RectF rH;
  private static ConcurrentHashMap<String, Method> rI;
  private final Context mContext;
  int rJ;
  private boolean rK;
  float rL;
  float rM;
  float rN;
  int[] rO;
  private boolean rP;
  private TextPaint rQ;
  private final TextView rR;
  
  static
  {
    AppMethodBeat.i(241174);
    rH = new RectF();
    rI = new ConcurrentHashMap();
    AppMethodBeat.o(241174);
  }
  
  l(TextView paramTextView)
  {
    AppMethodBeat.i(241137);
    this.rJ = 0;
    this.rK = false;
    this.rL = -1.0F;
    this.rM = -1.0F;
    this.rN = -1.0F;
    this.rO = new int[0];
    this.rP = false;
    this.rR = paramTextView;
    this.mContext = this.rR.getContext();
    AppMethodBeat.o(241137);
  }
  
  private int a(RectF paramRectF)
  {
    AppMethodBeat.i(241161);
    int j = this.rO.length;
    if (j == 0)
    {
      paramRectF = new IllegalStateException("No available text sizes to choose from.");
      AppMethodBeat.o(241161);
      throw paramRectF;
    }
    int i = 1;
    int k = j - 1;
    j = 0;
    while (i <= k)
    {
      int m = (i + k) / 2;
      if (a(this.rO[m], paramRectF))
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
    i = this.rO[j];
    AppMethodBeat.o(241161);
    return i;
  }
  
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt)
  {
    AppMethodBeat.i(241170);
    float f1;
    float f2;
    if (Build.VERSION.SDK_INT >= 16)
    {
      f1 = this.rR.getLineSpacingMultiplier();
      f2 = this.rR.getLineSpacingExtra();
    }
    for (boolean bool = this.rR.getIncludeFontPadding();; bool = ((Boolean)a(this.rR, "getIncludeFontPadding", Boolean.TRUE)).booleanValue())
    {
      paramCharSequence = new StaticLayout(paramCharSequence, this.rQ, paramInt, paramAlignment, f1, f2, bool);
      AppMethodBeat.o(241170);
      return paramCharSequence;
      f1 = ((Float)a(this.rR, "getLineSpacingMultiplier", Float.valueOf(1.0F))).floatValue();
      f2 = ((Float)a(this.rR, "getLineSpacingExtra", Float.valueOf(0.0F))).floatValue();
    }
  }
  
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241168);
    TextDirectionHeuristic localTextDirectionHeuristic = (TextDirectionHeuristic)a(this.rR, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
    paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), this.rQ, paramInt1).setAlignment(paramAlignment).setLineSpacing(this.rR.getLineSpacingExtra(), this.rR.getLineSpacingMultiplier()).setIncludePad(this.rR.getIncludeFontPadding()).setBreakStrategy(this.rR.getBreakStrategy()).setHyphenationFrequency(this.rR.getHyphenationFrequency());
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = 2147483647;
    }
    paramCharSequence = paramCharSequence.setMaxLines(paramInt1).setTextDirection(localTextDirectionHeuristic).build();
    AppMethodBeat.o(241168);
    return paramCharSequence;
  }
  
  private static <T> T a(Object paramObject, String paramString, T paramT)
  {
    AppMethodBeat.i(241171);
    try
    {
      paramObject = r(paramString).invoke(paramObject, new Object[0]);
      paramT = paramObject;
      if (paramObject != null) {}
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        new StringBuilder("Failed to invoke TextView#").append(paramString).append("() method");
      }
    }
    finally
    {
      AppMethodBeat.o(241171);
    }
    AppMethodBeat.o(241171);
    return paramT;
  }
  
  private void a(TypedArray paramTypedArray)
  {
    AppMethodBeat.i(241143);
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
      this.rO = d(arrayOfInt);
      dx();
    }
    AppMethodBeat.o(241143);
  }
  
  private boolean a(int paramInt, RectF paramRectF)
  {
    AppMethodBeat.i(241166);
    Object localObject2 = this.rR.getText();
    Object localObject3 = this.rR.getTransformationMethod();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((TransformationMethod)localObject3).getTransformation((CharSequence)localObject2, this.rR);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = localObject3;
      }
    }
    int i;
    if (Build.VERSION.SDK_INT >= 16)
    {
      i = this.rR.getMaxLines();
      if (this.rQ != null) {
        break label209;
      }
      this.rQ = new TextPaint();
      label94:
      this.rQ.set(this.rR.getPaint());
      this.rQ.setTextSize(paramInt);
      localObject2 = (Layout.Alignment)a(this.rR, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
      if (Build.VERSION.SDK_INT < 23) {
        break label219;
      }
    }
    label209:
    label219:
    for (localObject2 = a(localObject1, (Layout.Alignment)localObject2, Math.round(paramRectF.right), i);; localObject2 = a(localObject1, (Layout.Alignment)localObject2, Math.round(paramRectF.right)))
    {
      if ((i == -1) || ((((StaticLayout)localObject2).getLineCount() <= i) && (((StaticLayout)localObject2).getLineEnd(((StaticLayout)localObject2).getLineCount() - 1) == localObject1.length()))) {
        break label239;
      }
      AppMethodBeat.o(241166);
      return false;
      i = -1;
      break;
      this.rQ.reset();
      break label94;
    }
    label239:
    if (((StaticLayout)localObject2).getHeight() > paramRectF.bottom)
    {
      AppMethodBeat.o(241166);
      return false;
    }
    AppMethodBeat.o(241166);
    return true;
  }
  
  private void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(241147);
    IllegalArgumentException localIllegalArgumentException;
    if (paramFloat1 <= 0.0F)
    {
      localIllegalArgumentException = new IllegalArgumentException("Minimum auto-size text size (" + paramFloat1 + "px) is less or equal to (0px)");
      AppMethodBeat.o(241147);
      throw localIllegalArgumentException;
    }
    if (paramFloat2 <= paramFloat1)
    {
      localIllegalArgumentException = new IllegalArgumentException("Maximum auto-size text size (" + paramFloat2 + "px) is less or equal to minimum auto-size text size (" + paramFloat1 + "px)");
      AppMethodBeat.o(241147);
      throw localIllegalArgumentException;
    }
    if (paramFloat3 <= 0.0F)
    {
      localIllegalArgumentException = new IllegalArgumentException("The auto-size step granularity (" + paramFloat3 + "px) is less or equal to (0px)");
      AppMethodBeat.o(241147);
      throw localIllegalArgumentException;
    }
    this.rJ = 1;
    this.rM = paramFloat1;
    this.rN = paramFloat2;
    this.rL = paramFloat3;
    this.rP = false;
    AppMethodBeat.o(241147);
  }
  
  private static int[] d(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(241146);
    int j = paramArrayOfInt.length;
    if (j == 0)
    {
      AppMethodBeat.o(241146);
      return paramArrayOfInt;
    }
    Arrays.sort(paramArrayOfInt);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if ((k > 0) && (Collections.binarySearch(localArrayList, Integer.valueOf(k)) < 0)) {
        localArrayList.add(Integer.valueOf(k));
      }
      i += 1;
    }
    if (j == localArrayList.size())
    {
      AppMethodBeat.o(241146);
      return paramArrayOfInt;
    }
    j = localArrayList.size();
    paramArrayOfInt = new int[j];
    i = 0;
    while (i < j)
    {
      paramArrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    AppMethodBeat.o(241146);
    return paramArrayOfInt;
  }
  
  private void dA()
  {
    this.rJ = 0;
    this.rM = -1.0F;
    this.rN = -1.0F;
    this.rL = -1.0F;
    this.rO = new int[0];
    this.rK = false;
  }
  
  private boolean dC()
  {
    return !(this.rR instanceof AppCompatEditText);
  }
  
  private boolean dx()
  {
    int i = this.rO.length;
    if (i > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.rP = bool;
      if (this.rP)
      {
        this.rJ = 1;
        this.rM = this.rO[0];
        this.rN = this.rO[(i - 1)];
        this.rL = -1.0F;
      }
      return this.rP;
    }
  }
  
  private boolean dy()
  {
    AppMethodBeat.i(241149);
    if ((dC()) && (this.rJ == 1)) {
      if ((!this.rP) || (this.rO.length == 0))
      {
        float f1 = Math.round(this.rM);
        int i = 1;
        while (Math.round(this.rL + f1) <= Math.round(this.rN))
        {
          i += 1;
          f1 += this.rL;
        }
        int[] arrayOfInt = new int[i];
        f1 = this.rM;
        int j = 0;
        while (j < i)
        {
          arrayOfInt[j] = Math.round(f1);
          float f2 = this.rL;
          j += 1;
          f1 = f2 + f1;
        }
        this.rO = d(arrayOfInt);
      }
    }
    for (this.rK = true;; this.rK = false)
    {
      boolean bool = this.rK;
      AppMethodBeat.o(241149);
      return bool;
    }
  }
  
  private static Method r(String paramString)
  {
    AppMethodBeat.i(241172);
    try
    {
      Method localMethod2 = (Method)rI.get(paramString);
      Method localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        localMethod2 = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        localMethod1 = localMethod2;
        if (localMethod2 != null)
        {
          localMethod2.setAccessible(true);
          rI.put(paramString, localMethod2);
          localMethod1 = localMethod2;
        }
      }
      AppMethodBeat.o(241172);
      return localMethod1;
    }
    catch (Exception localException)
    {
      new StringBuilder("Failed to retrieve TextView#").append(paramString).append("() method");
      AppMethodBeat.o(241172);
    }
    return null;
  }
  
  private void setRawTextSize(float paramFloat)
  {
    AppMethodBeat.i(241157);
    if (paramFloat != this.rR.getPaint().getTextSize())
    {
      this.rR.getPaint().setTextSize(paramFloat);
      if (Build.VERSION.SDK_INT < 18) {
        break label126;
      }
    }
    label87:
    label126:
    for (boolean bool = this.rR.isInLayout();; bool = false)
    {
      if (this.rR.getLayout() != null) {
        this.rK = false;
      }
      try
      {
        Method localMethod = r("nullLayouts");
        if (localMethod != null) {
          localMethod.invoke(this.rR, new Object[0]);
        }
      }
      catch (Exception localException)
      {
        break label87;
      }
      if (!bool) {
        this.rR.requestLayout();
      }
      for (;;)
      {
        this.rR.invalidate();
        AppMethodBeat.o(241157);
        return;
        this.rR.forceLayout();
      }
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(241138);
    paramAttributeSet = this.mContext.obtainStyledAttributes(paramAttributeSet, a.j.AppCompatTextView, paramInt, 0);
    if (paramAttributeSet.hasValue(a.j.AppCompatTextView_autoSizeTextType)) {
      this.rJ = paramAttributeSet.getInt(a.j.AppCompatTextView_autoSizeTextType, 0);
    }
    if (paramAttributeSet.hasValue(a.j.AppCompatTextView_autoSizeStepGranularity)) {}
    for (float f1 = paramAttributeSet.getDimension(a.j.AppCompatTextView_autoSizeStepGranularity, -1.0F);; f1 = -1.0F)
    {
      if (paramAttributeSet.hasValue(a.j.AppCompatTextView_autoSizeMinTextSize)) {}
      for (float f2 = paramAttributeSet.getDimension(a.j.AppCompatTextView_autoSizeMinTextSize, -1.0F);; f2 = -1.0F)
      {
        if (paramAttributeSet.hasValue(a.j.AppCompatTextView_autoSizeMaxTextSize)) {}
        for (float f3 = paramAttributeSet.getDimension(a.j.AppCompatTextView_autoSizeMaxTextSize, -1.0F);; f3 = -1.0F)
        {
          if (paramAttributeSet.hasValue(a.j.AppCompatTextView_autoSizePresetSizes))
          {
            paramInt = paramAttributeSet.getResourceId(a.j.AppCompatTextView_autoSizePresetSizes, 0);
            if (paramInt > 0)
            {
              TypedArray localTypedArray = paramAttributeSet.getResources().obtainTypedArray(paramInt);
              a(localTypedArray);
              localTypedArray.recycle();
            }
          }
          paramAttributeSet.recycle();
          if (dC())
          {
            if (this.rJ == 1)
            {
              if (!this.rP)
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
                b(f4, f2, f3);
              }
              dy();
              AppMethodBeat.o(241138);
            }
          }
          else {
            this.rJ = 0;
          }
          AppMethodBeat.o(241138);
          return;
        }
      }
    }
  }
  
  final void b(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(241155);
    if (this.mContext == null) {}
    for (Resources localResources = Resources.getSystem();; localResources = this.mContext.getResources())
    {
      setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics()));
      AppMethodBeat.o(241155);
      return;
    }
  }
  
  final boolean dB()
  {
    AppMethodBeat.i(241173);
    if ((dC()) && (this.rJ != 0))
    {
      AppMethodBeat.o(241173);
      return true;
    }
    AppMethodBeat.o(241173);
    return false;
  }
  
  final void dz()
  {
    AppMethodBeat.i(241152);
    if (!dB())
    {
      AppMethodBeat.o(241152);
      return;
    }
    int i;
    int j;
    if (this.rK)
    {
      if ((this.rR.getMeasuredHeight() <= 0) || (this.rR.getMeasuredWidth() <= 0))
      {
        AppMethodBeat.o(241152);
        return;
      }
      if (((Boolean)a(this.rR, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue()) {}
      for (i = 1048576;; i = this.rR.getMeasuredWidth() - this.rR.getTotalPaddingLeft() - this.rR.getTotalPaddingRight())
      {
        j = this.rR.getHeight() - this.rR.getCompoundPaddingBottom() - this.rR.getCompoundPaddingTop();
        if ((i > 0) && (j > 0)) {
          break;
        }
        AppMethodBeat.o(241152);
        return;
      }
    }
    synchronized (rH)
    {
      rH.setEmpty();
      rH.right = i;
      rH.bottom = j;
      float f = a(rH);
      if (f != this.rR.getTextSize()) {
        b(0, f);
      }
      this.rK = true;
      AppMethodBeat.o(241152);
      return;
    }
  }
  
  final void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(241140);
    if (dC())
    {
      DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      b(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (dy()) {
        dz();
      }
    }
    AppMethodBeat.o(241140);
  }
  
  final void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(241142);
    if (dC())
    {
      int j = paramArrayOfInt.length;
      if (j > 0)
      {
        int[] arrayOfInt2 = new int[j];
        int[] arrayOfInt1;
        if (paramInt == 0)
        {
          arrayOfInt1 = Arrays.copyOf(paramArrayOfInt, j);
          this.rO = d(arrayOfInt1);
          if (!dx())
          {
            paramArrayOfInt = new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(paramArrayOfInt));
            AppMethodBeat.o(241142);
            throw paramArrayOfInt;
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
        this.rP = false;
      }
      if (dy()) {
        dz();
      }
    }
    AppMethodBeat.o(241142);
  }
  
  final void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    AppMethodBeat.i(241139);
    if (dC())
    {
      switch (paramInt)
      {
      default: 
        localObject = new IllegalArgumentException("Unknown auto-size text type: ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(241139);
        throw ((Throwable)localObject);
      case 0: 
        dA();
        AppMethodBeat.o(241139);
        return;
      }
      Object localObject = this.mContext.getResources().getDisplayMetrics();
      b(TypedValue.applyDimension(2, 12.0F, (DisplayMetrics)localObject), TypedValue.applyDimension(2, 112.0F, (DisplayMetrics)localObject), 1.0F);
      if (dy())
      {
        dz();
        AppMethodBeat.o(241139);
        return;
      }
    }
    AppMethodBeat.o(241139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.l
 * JD-Core Version:    0.7.0.1
 */