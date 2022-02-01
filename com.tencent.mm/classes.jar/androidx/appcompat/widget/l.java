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
  private static final RectF sG;
  private static ConcurrentHashMap<String, Method> sH;
  private final Context mContext;
  int sI;
  private boolean sJ;
  float sK;
  float sL;
  float sM;
  int[] sN;
  private boolean sO;
  private TextPaint sP;
  private final TextView sQ;
  
  static
  {
    AppMethodBeat.i(200122);
    sG = new RectF();
    sH = new ConcurrentHashMap();
    AppMethodBeat.o(200122);
  }
  
  l(TextView paramTextView)
  {
    AppMethodBeat.i(199942);
    this.sI = 0;
    this.sJ = false;
    this.sK = -1.0F;
    this.sL = -1.0F;
    this.sM = -1.0F;
    this.sN = new int[0];
    this.sO = false;
    this.sQ = paramTextView;
    this.mContext = this.sQ.getContext();
    AppMethodBeat.o(199942);
  }
  
  private int a(RectF paramRectF)
  {
    AppMethodBeat.i(200050);
    int j = this.sN.length;
    if (j == 0)
    {
      paramRectF = new IllegalStateException("No available text sizes to choose from.");
      AppMethodBeat.o(200050);
      throw paramRectF;
    }
    int i = 1;
    int k = j - 1;
    j = 0;
    while (i <= k)
    {
      int m = (i + k) / 2;
      if (a(this.sN[m], paramRectF))
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
    i = this.sN[j];
    AppMethodBeat.o(200050);
    return i;
  }
  
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt)
  {
    AppMethodBeat.i(200087);
    float f1;
    float f2;
    if (Build.VERSION.SDK_INT >= 16)
    {
      f1 = this.sQ.getLineSpacingMultiplier();
      f2 = this.sQ.getLineSpacingExtra();
    }
    for (boolean bool = this.sQ.getIncludeFontPadding();; bool = ((Boolean)b(this.sQ, "getIncludeFontPadding", Boolean.TRUE)).booleanValue())
    {
      paramCharSequence = new StaticLayout(paramCharSequence, this.sP, paramInt, paramAlignment, f1, f2, bool);
      AppMethodBeat.o(200087);
      return paramCharSequence;
      f1 = ((Float)b(this.sQ, "getLineSpacingMultiplier", Float.valueOf(1.0F))).floatValue();
      f2 = ((Float)b(this.sQ, "getLineSpacingExtra", Float.valueOf(0.0F))).floatValue();
    }
  }
  
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200075);
    TextDirectionHeuristic localTextDirectionHeuristic = (TextDirectionHeuristic)b(this.sQ, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
    paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), this.sP, paramInt1).setAlignment(paramAlignment).setLineSpacing(this.sQ.getLineSpacingExtra(), this.sQ.getLineSpacingMultiplier()).setIncludePad(this.sQ.getIncludeFontPadding()).setBreakStrategy(this.sQ.getBreakStrategy()).setHyphenationFrequency(this.sQ.getHyphenationFrequency());
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = 2147483647;
    }
    paramCharSequence = paramCharSequence.setMaxLines(paramInt1).setTextDirection(localTextDirectionHeuristic).build();
    AppMethodBeat.o(200075);
    return paramCharSequence;
  }
  
  private void a(TypedArray paramTypedArray)
  {
    AppMethodBeat.i(199957);
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
      this.sN = g(arrayOfInt);
      ew();
    }
    AppMethodBeat.o(199957);
  }
  
  private boolean a(int paramInt, RectF paramRectF)
  {
    AppMethodBeat.i(200063);
    Object localObject2 = this.sQ.getText();
    Object localObject3 = this.sQ.getTransformationMethod();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((TransformationMethod)localObject3).getTransformation((CharSequence)localObject2, this.sQ);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = localObject3;
      }
    }
    int i;
    if (Build.VERSION.SDK_INT >= 16)
    {
      i = this.sQ.getMaxLines();
      if (this.sP != null) {
        break label208;
      }
      this.sP = new TextPaint();
      label94:
      this.sP.set(this.sQ.getPaint());
      this.sP.setTextSize(paramInt);
      localObject2 = (Layout.Alignment)b(this.sQ, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
      if (Build.VERSION.SDK_INT < 23) {
        break label218;
      }
    }
    label208:
    label218:
    for (localObject2 = a(localObject1, (Layout.Alignment)localObject2, Math.round(paramRectF.right), i);; localObject2 = a(localObject1, (Layout.Alignment)localObject2, Math.round(paramRectF.right)))
    {
      if ((i == -1) || ((((StaticLayout)localObject2).getLineCount() <= i) && (((StaticLayout)localObject2).getLineEnd(((StaticLayout)localObject2).getLineCount() - 1) == localObject1.length()))) {
        break label238;
      }
      AppMethodBeat.o(200063);
      return false;
      i = -1;
      break;
      this.sP.reset();
      break label94;
    }
    label238:
    if (((StaticLayout)localObject2).getHeight() > paramRectF.bottom)
    {
      AppMethodBeat.o(200063);
      return false;
    }
    AppMethodBeat.o(200063);
    return true;
  }
  
  private static <T> T b(Object paramObject, String paramString, T paramT)
  {
    AppMethodBeat.i(200098);
    try
    {
      paramObject = s(paramString).invoke(paramObject, new Object[0]);
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
      AppMethodBeat.o(200098);
    }
    AppMethodBeat.o(200098);
    return paramT;
  }
  
  private void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(199986);
    IllegalArgumentException localIllegalArgumentException;
    if (paramFloat1 <= 0.0F)
    {
      localIllegalArgumentException = new IllegalArgumentException("Minimum auto-size text size (" + paramFloat1 + "px) is less or equal to (0px)");
      AppMethodBeat.o(199986);
      throw localIllegalArgumentException;
    }
    if (paramFloat2 <= paramFloat1)
    {
      localIllegalArgumentException = new IllegalArgumentException("Maximum auto-size text size (" + paramFloat2 + "px) is less or equal to minimum auto-size text size (" + paramFloat1 + "px)");
      AppMethodBeat.o(199986);
      throw localIllegalArgumentException;
    }
    if (paramFloat3 <= 0.0F)
    {
      localIllegalArgumentException = new IllegalArgumentException("The auto-size step granularity (" + paramFloat3 + "px) is less or equal to (0px)");
      AppMethodBeat.o(199986);
      throw localIllegalArgumentException;
    }
    this.sI = 1;
    this.sL = paramFloat1;
    this.sM = paramFloat2;
    this.sK = paramFloat3;
    this.sO = false;
    AppMethodBeat.o(199986);
  }
  
  private boolean eB()
  {
    return !(this.sQ instanceof AppCompatEditText);
  }
  
  private boolean ew()
  {
    int i = this.sN.length;
    if (i > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.sO = bool;
      if (this.sO)
      {
        this.sI = 1;
        this.sL = this.sN[0];
        this.sM = this.sN[(i - 1)];
        this.sK = -1.0F;
      }
      return this.sO;
    }
  }
  
  private boolean ex()
  {
    AppMethodBeat.i(200012);
    if ((eB()) && (this.sI == 1)) {
      if ((!this.sO) || (this.sN.length == 0))
      {
        float f1 = Math.round(this.sL);
        int i = 1;
        while (Math.round(this.sK + f1) <= Math.round(this.sM))
        {
          i += 1;
          f1 += this.sK;
        }
        int[] arrayOfInt = new int[i];
        f1 = this.sL;
        int j = 0;
        while (j < i)
        {
          arrayOfInt[j] = Math.round(f1);
          float f2 = this.sK;
          j += 1;
          f1 = f2 + f1;
        }
        this.sN = g(arrayOfInt);
      }
    }
    for (this.sJ = true;; this.sJ = false)
    {
      boolean bool = this.sJ;
      AppMethodBeat.o(200012);
      return bool;
    }
  }
  
  private void ez()
  {
    this.sI = 0;
    this.sL = -1.0F;
    this.sM = -1.0F;
    this.sK = -1.0F;
    this.sN = new int[0];
    this.sJ = false;
  }
  
  private static int[] g(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(199979);
    int j = paramArrayOfInt.length;
    if (j == 0)
    {
      AppMethodBeat.o(199979);
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
      AppMethodBeat.o(199979);
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
    AppMethodBeat.o(199979);
    return paramArrayOfInt;
  }
  
  private static Method s(String paramString)
  {
    AppMethodBeat.i(200106);
    try
    {
      Method localMethod2 = (Method)sH.get(paramString);
      Method localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        localMethod2 = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        localMethod1 = localMethod2;
        if (localMethod2 != null)
        {
          localMethod2.setAccessible(true);
          sH.put(paramString, localMethod2);
          localMethod1 = localMethod2;
        }
      }
      AppMethodBeat.o(200106);
      return localMethod1;
    }
    catch (Exception localException)
    {
      new StringBuilder("Failed to retrieve TextView#").append(paramString).append("() method");
      AppMethodBeat.o(200106);
    }
    return null;
  }
  
  private void setRawTextSize(float paramFloat)
  {
    AppMethodBeat.i(200035);
    if (paramFloat != this.sQ.getPaint().getTextSize())
    {
      this.sQ.getPaint().setTextSize(paramFloat);
      if (Build.VERSION.SDK_INT < 18) {
        break label126;
      }
    }
    label87:
    label126:
    for (boolean bool = this.sQ.isInLayout();; bool = false)
    {
      if (this.sQ.getLayout() != null) {
        this.sJ = false;
      }
      try
      {
        Method localMethod = s("nullLayouts");
        if (localMethod != null) {
          localMethod.invoke(this.sQ, new Object[0]);
        }
      }
      catch (Exception localException)
      {
        break label87;
      }
      if (!bool) {
        this.sQ.requestLayout();
      }
      for (;;)
      {
        this.sQ.invalidate();
        AppMethodBeat.o(200035);
        return;
        this.sQ.forceLayout();
      }
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(200136);
    paramAttributeSet = this.mContext.obtainStyledAttributes(paramAttributeSet, a.j.AppCompatTextView, paramInt, 0);
    if (paramAttributeSet.hasValue(a.j.AppCompatTextView_autoSizeTextType)) {
      this.sI = paramAttributeSet.getInt(a.j.AppCompatTextView_autoSizeTextType, 0);
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
          if (eB())
          {
            if (this.sI == 1)
            {
              if (!this.sO)
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
              ex();
              AppMethodBeat.o(200136);
            }
          }
          else {
            this.sI = 0;
          }
          AppMethodBeat.o(200136);
          return;
        }
      }
    }
  }
  
  final void c(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(200193);
    if (this.mContext == null) {}
    for (Resources localResources = Resources.getSystem();; localResources = this.mContext.getResources())
    {
      setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics()));
      AppMethodBeat.o(200193);
      return;
    }
  }
  
  final boolean eA()
  {
    AppMethodBeat.i(200198);
    if ((eB()) && (this.sI != 0))
    {
      AppMethodBeat.o(200198);
      return true;
    }
    AppMethodBeat.o(200198);
    return false;
  }
  
  final void ey()
  {
    AppMethodBeat.i(200185);
    if (!eA())
    {
      AppMethodBeat.o(200185);
      return;
    }
    int i;
    int j;
    if (this.sJ)
    {
      if ((this.sQ.getMeasuredHeight() <= 0) || (this.sQ.getMeasuredWidth() <= 0))
      {
        AppMethodBeat.o(200185);
        return;
      }
      if (((Boolean)b(this.sQ, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue()) {}
      for (i = 1048576;; i = this.sQ.getMeasuredWidth() - this.sQ.getTotalPaddingLeft() - this.sQ.getTotalPaddingRight())
      {
        j = this.sQ.getHeight() - this.sQ.getCompoundPaddingBottom() - this.sQ.getCompoundPaddingTop();
        if ((i > 0) && (j > 0)) {
          break;
        }
        AppMethodBeat.o(200185);
        return;
      }
    }
    synchronized (sG)
    {
      sG.setEmpty();
      sG.right = i;
      sG.bottom = j;
      float f = a(sG);
      if (f != this.sQ.getTextSize()) {
        c(0, f);
      }
      this.sJ = true;
      AppMethodBeat.o(200185);
      return;
    }
  }
  
  final void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200163);
    if (eB())
    {
      DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      b(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (ex()) {
        ey();
      }
    }
    AppMethodBeat.o(200163);
  }
  
  final void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(200172);
    if (eB())
    {
      int j = paramArrayOfInt.length;
      if (j > 0)
      {
        int[] arrayOfInt2 = new int[j];
        int[] arrayOfInt1;
        if (paramInt == 0)
        {
          arrayOfInt1 = Arrays.copyOf(paramArrayOfInt, j);
          this.sN = g(arrayOfInt1);
          if (!ew())
          {
            paramArrayOfInt = new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(paramArrayOfInt));
            AppMethodBeat.o(200172);
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
        this.sO = false;
      }
      if (ex()) {
        ey();
      }
    }
    AppMethodBeat.o(200172);
  }
  
  final void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    AppMethodBeat.i(200151);
    if (eB())
    {
      switch (paramInt)
      {
      default: 
        localObject = new IllegalArgumentException("Unknown auto-size text type: ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(200151);
        throw ((Throwable)localObject);
      case 0: 
        ez();
        AppMethodBeat.o(200151);
        return;
      }
      Object localObject = this.mContext.getResources().getDisplayMetrics();
      b(TypedValue.applyDimension(2, 12.0F, (DisplayMetrics)localObject), TypedValue.applyDimension(2, 112.0F, (DisplayMetrics)localObject), 1.0F);
      if (ex())
      {
        ey();
        AppMethodBeat.o(200151);
        return;
      }
    }
    AppMethodBeat.o(200151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.l
 * JD-Core Version:    0.7.0.1
 */