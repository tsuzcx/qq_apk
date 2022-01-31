package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class o
{
  private static final RectF aaH = new RectF();
  private static ConcurrentHashMap<String, Method> aaI = new ConcurrentHashMap();
  int aaJ = 0;
  boolean aaK = false;
  float aaL = -1.0F;
  float aaM = -1.0F;
  float aaN = -1.0F;
  int[] aaO = new int[0];
  boolean aaP = false;
  private TextPaint aaQ;
  private final TextView lh;
  final Context mContext;
  
  o(TextView paramTextView)
  {
    this.lh = paramTextView;
    this.mContext = this.lh.getContext();
  }
  
  private static Method P(String paramString)
  {
    try
    {
      Method localMethod2 = (Method)aaI.get(paramString);
      Method localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        localMethod2 = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        localMethod1 = localMethod2;
        if (localMethod2 != null)
        {
          localMethod2.setAccessible(true);
          aaI.put(paramString, localMethod2);
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
  
  private static <T> T a(Object paramObject, String paramString, T paramT)
  {
    try
    {
      paramObject = P(paramString).invoke(paramObject, new Object[0]);
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
  
  static int[] e(int[] paramArrayOfInt)
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
  
  final void d(int paramInt, float paramFloat)
  {
    Object localObject;
    if (this.mContext == null)
    {
      localObject = Resources.getSystem();
      paramFloat = TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics());
      if (paramFloat != this.lh.getPaint().getTextSize())
      {
        this.lh.getPaint().setTextSize(paramFloat);
        if (Build.VERSION.SDK_INT < 18) {
          break label152;
        }
      }
    }
    label152:
    for (boolean bool = this.lh.isInLayout();; bool = false)
    {
      if (this.lh.getLayout() != null) {
        this.aaK = false;
      }
      try
      {
        localObject = P("nullLayouts");
        if (localObject != null) {
          ((Method)localObject).invoke(this.lh, new Object[0]);
        }
      }
      catch (Exception localException)
      {
        label106:
        break label106;
      }
      if (!bool) {
        this.lh.requestLayout();
      }
      for (;;)
      {
        this.lh.invalidate();
        return;
        localObject = this.mContext.getResources();
        break;
        this.lh.forceLayout();
      }
    }
  }
  
  final void f(float paramFloat1, float paramFloat2, float paramFloat3)
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
    this.aaJ = 1;
    this.aaM = paramFloat1;
    this.aaN = paramFloat2;
    this.aaL = paramFloat3;
    this.aaP = false;
  }
  
  final boolean go()
  {
    int i = this.aaO.length;
    if (i > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.aaP = bool;
      if (this.aaP)
      {
        this.aaJ = 1;
        this.aaM = this.aaO[0];
        this.aaN = this.aaO[(i - 1)];
        this.aaL = -1.0F;
      }
      return this.aaP;
    }
  }
  
  final boolean gp()
  {
    if ((gs()) && (this.aaJ == 1)) {
      if ((!this.aaP) || (this.aaO.length == 0))
      {
        float f1 = Math.round(this.aaM);
        int i = 1;
        while (Math.round(this.aaL + f1) <= Math.round(this.aaN))
        {
          i += 1;
          f1 += this.aaL;
        }
        int[] arrayOfInt = new int[i];
        f1 = this.aaM;
        int j = 0;
        while (j < i)
        {
          arrayOfInt[j] = Math.round(f1);
          float f2 = this.aaL;
          j += 1;
          f1 = f2 + f1;
        }
        this.aaO = e(arrayOfInt);
      }
    }
    for (this.aaK = true;; this.aaK = false) {
      return this.aaK;
    }
  }
  
  final void gq()
  {
    if (!gr()) {}
    do
    {
      return;
      if (!this.aaK) {
        break;
      }
    } while ((this.lh.getMeasuredHeight() <= 0) || (this.lh.getMeasuredWidth() <= 0));
    if (((Boolean)a(this.lh, "getHorizontallyScrolling", Boolean.valueOf(false))).booleanValue()) {}
    RectF localRectF2;
    int k;
    for (int i = 1048576;; i = this.lh.getMeasuredWidth() - this.lh.getTotalPaddingLeft() - this.lh.getTotalPaddingRight())
    {
      j = this.lh.getHeight() - this.lh.getCompoundPaddingBottom() - this.lh.getCompoundPaddingTop();
      if ((i <= 0) || (j <= 0)) {
        break;
      }
      synchronized (aaH)
      {
        aaH.setEmpty();
        aaH.right = i;
        aaH.bottom = j;
        localRectF2 = aaH;
        k = this.aaO.length;
        if (k != 0) {
          break label190;
        }
        throw new IllegalStateException("No available text sizes to choose from.");
      }
    }
    label190:
    int j = 0;
    i = 1;
    k -= 1;
    for (;;)
    {
      int n;
      int m;
      Object localObject2;
      Object localObject3;
      if (i <= k)
      {
        n = (i + k) / 2;
        m = this.aaO[n];
        localObject2 = this.lh.getText();
        localObject3 = this.lh.getTransformationMethod();
        if (localObject3 == null) {
          break label729;
        }
        localObject3 = ((TransformationMethod)localObject3).getTransformation((CharSequence)localObject2, this.lh);
        if (localObject3 == null) {
          break label729;
        }
        localObject2 = localObject3;
      }
      label288:
      label468:
      label729:
      for (;;)
      {
        if (Build.VERSION.SDK_INT < 16) {
          break label755;
        }
        j = this.lh.getMaxLines();
        if (this.aaQ == null) {
          this.aaQ = new TextPaint();
        }
        Object localObject4;
        for (;;)
        {
          this.aaQ.set(this.lh.getPaint());
          this.aaQ.setTextSize(m);
          localObject4 = (Layout.Alignment)a(this.lh, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
          if (Build.VERSION.SDK_INT < 23) {
            break;
          }
          m = Math.round(localRectF2.right);
          localObject3 = (TextDirectionHeuristic)a(this.lh, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
          localObject4 = StaticLayout.Builder.obtain((CharSequence)localObject2, 0, ((CharSequence)localObject2).length(), this.aaQ, m).setAlignment((Layout.Alignment)localObject4).setLineSpacing(this.lh.getLineSpacingExtra(), this.lh.getLineSpacingMultiplier()).setIncludePad(this.lh.getIncludeFontPadding()).setBreakStrategy(this.lh.getBreakStrategy()).setHyphenationFrequency(this.lh.getHyphenationFrequency());
          if (j != -1) {
            break label761;
          }
          m = 2147483647;
          localObject3 = ((StaticLayout.Builder)localObject4).setMaxLines(m).setTextDirection((TextDirectionHeuristic)localObject3).build();
          if (j == -1) {
            break label672;
          }
          if (((StaticLayout)localObject3).getLineCount() > j) {
            break label732;
          }
          if (((StaticLayout)localObject3).getLineEnd(((StaticLayout)localObject3).getLineCount() - 1) == ((CharSequence)localObject2).length()) {
            break label672;
          }
          break label732;
          this.aaQ.reset();
        }
        m = Math.round(localRectF2.right);
        float f2;
        if (Build.VERSION.SDK_INT >= 16)
        {
          f1 = this.lh.getLineSpacingMultiplier();
          f2 = this.lh.getLineSpacingExtra();
        }
        for (boolean bool = this.lh.getIncludeFontPadding();; bool = ((Boolean)a(this.lh, "getIncludeFontPadding", Boolean.valueOf(true))).booleanValue())
        {
          localObject3 = new StaticLayout((CharSequence)localObject2, this.aaQ, m, (Layout.Alignment)localObject4, f1, f2, bool);
          break;
          f1 = ((Float)a(this.lh, "getLineSpacingMultiplier", Float.valueOf(1.0F))).floatValue();
          f2 = ((Float)a(this.lh, "getLineSpacingExtra", Float.valueOf(0.0F))).floatValue();
        }
        if (((StaticLayout)localObject3).getHeight() <= localRectF2.bottom) {
          break label768;
        }
        j = 0;
        break label735;
        float f1 = this.aaO[j];
        if (f1 != this.lh.getTextSize()) {
          d(0, f1);
        }
        this.aaK = true;
        return;
      }
      label672:
      label732:
      for (j = 0;; j = 1)
      {
        label735:
        if (j == 0) {
          break label774;
        }
        m = n + 1;
        j = i;
        i = m;
        break;
        label755:
        j = -1;
        break label288;
        label761:
        m = j;
        break label468;
      }
      label768:
      label774:
      k = n - 1;
      j = k;
    }
  }
  
  final boolean gr()
  {
    return (gs()) && (this.aaJ != 0);
  }
  
  final boolean gs()
  {
    return !(this.lh instanceof AppCompatEditText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.o
 * JD-Core Version:    0.7.0.1
 */