package com.tencent.mm.kiss.widget.textview.b;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class a
{
  private static boolean dJj;
  private static boolean dOC;
  private static Constructor<StaticLayout> dOD;
  private static Object dOE;
  
  public static StaticLayout a(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5)
  {
    try
    {
      ensureInitialized();
      if (dOC) {
        throw new IllegalStateException("initialize error, cannot create StaticLayout");
      }
    }
    finally {}
    try
    {
      Object localObject = dOE;
      paramCharSequence = (StaticLayout)dOD.newInstance(new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramTextPaint, Integer.valueOf(paramInt3), paramAlignment, localObject, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(paramBoolean), paramTruncateAt, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      return paramCharSequence;
    }
    catch (Exception paramCharSequence)
    {
      throw new IllegalStateException("Error creating StaticLayout with max lines: " + paramCharSequence.getCause());
    }
  }
  
  public static StaticLayout a(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, TextDirectionHeuristic paramTextDirectionHeuristic, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5)
  {
    try
    {
      ensureInitialized();
      if (dOC) {
        throw new IllegalStateException("initialize error, cannot create StaticLayout");
      }
    }
    finally {}
    try
    {
      paramCharSequence = (StaticLayout)dOD.newInstance(new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramTextPaint, Integer.valueOf(paramInt3), paramAlignment, paramTextDirectionHeuristic, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(paramBoolean), paramTruncateAt, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      return paramCharSequence;
    }
    catch (Exception paramCharSequence)
    {
      throw new IllegalStateException("Error creating StaticLayout with max lines: " + paramCharSequence.getCause());
    }
  }
  
  @TargetApi(18)
  private static void ensureInitialized()
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        boolean bool = dJj;
        if (bool) {
          return;
        }
      }
      finally {}
      try
      {
        if (Build.VERSION.SDK_INT < 18) {
          break label167;
        }
        localObject1 = TextDirectionHeuristic.class;
        dOE = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        localObject1 = StaticLayout.class.getDeclaredConstructor(new Class[] { CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, localObject1, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE });
        dOD = (Constructor)localObject1;
        ((Constructor)localObject1).setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Object localObject4;
        Class localClass;
        y.e("StaticTextView.StaticLayoutWithMaxLines", "StaticLayout constructor with max lines not found.", new Object[] { localNoSuchMethodException });
        dOC = true;
        dJj = true;
        continue;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        y.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristic class not found.", new Object[] { localClassNotFoundException });
        dOC = true;
        dJj = true;
        continue;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        y.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristics.FIRSTSTRONG_LTR not found.", new Object[] { localNoSuchFieldException });
        dOC = true;
        dJj = true;
        continue;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        y.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristics.FIRSTSTRONG_LTR not accessible.", new Object[] { localIllegalAccessException });
        dOC = true;
        dJj = true;
        continue;
      }
      catch (Exception localException)
      {
        y.e("StaticTextView.StaticLayoutWithMaxLines", "Other error.", new Object[] { localException });
        dOC = true;
        dJj = true;
        continue;
      }
      finally
      {
        dJj = true;
      }
      y.i("StaticTextView.StaticLayoutWithMaxLines", "ensureInitialized finish, sInitialError: " + dOC);
      continue;
      label167:
      localObject4 = a.class.getClassLoader();
      localClass = ((ClassLoader)localObject4).loadClass("android.text.TextDirectionHeuristic");
      localObject4 = ((ClassLoader)localObject4).loadClass("android.text.TextDirectionHeuristics");
      dOE = ((Class)localObject4).getField("FIRSTSTRONG_LTR").get(localObject4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.b.a
 * JD-Core Version:    0.7.0.1
 */