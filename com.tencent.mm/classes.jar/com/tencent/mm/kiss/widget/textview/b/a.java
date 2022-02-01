package com.tencent.mm.kiss.widget.textview.b;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class a
{
  private static boolean glU;
  private static Constructor<StaticLayout> glV;
  private static Object glW;
  private static boolean sInitialized;
  
  public static StaticLayout a(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5)
  {
    try
    {
      AppMethodBeat.i(141138);
      ensureInitialized();
      if (glU)
      {
        paramCharSequence = new IllegalStateException("initialize error, cannot create StaticLayout");
        AppMethodBeat.o(141138);
        throw paramCharSequence;
      }
    }
    finally {}
    try
    {
      Object localObject = glW;
      paramCharSequence = (StaticLayout)glV.newInstance(new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramTextPaint, Integer.valueOf(paramInt3), paramAlignment, localObject, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(paramBoolean), paramTruncateAt, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      AppMethodBeat.o(141138);
      return paramCharSequence;
    }
    catch (Exception paramCharSequence)
    {
      paramCharSequence = new IllegalStateException("Error creating StaticLayout with max lines: " + paramCharSequence.getCause());
      AppMethodBeat.o(141138);
      throw paramCharSequence;
    }
  }
  
  public static StaticLayout a(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint, int paramInt3, Layout.Alignment paramAlignment, TextDirectionHeuristic paramTextDirectionHeuristic, float paramFloat1, float paramFloat2, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt4, int paramInt5)
  {
    try
    {
      AppMethodBeat.i(141139);
      ensureInitialized();
      if (glU)
      {
        paramCharSequence = new IllegalStateException("initialize error, cannot create StaticLayout");
        AppMethodBeat.o(141139);
        throw paramCharSequence;
      }
    }
    finally {}
    try
    {
      paramCharSequence = (StaticLayout)glV.newInstance(new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramTextPaint, Integer.valueOf(paramInt3), paramAlignment, paramTextDirectionHeuristic, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(paramBoolean), paramTruncateAt, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      AppMethodBeat.o(141139);
      return paramCharSequence;
    }
    catch (Exception paramCharSequence)
    {
      paramCharSequence = new IllegalStateException("Error creating StaticLayout with max lines: " + paramCharSequence.getCause());
      AppMethodBeat.o(141139);
      throw paramCharSequence;
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
        AppMethodBeat.i(141137);
        if (sInitialized)
        {
          AppMethodBeat.o(141137);
          return;
        }
      }
      finally {}
      try
      {
        if (Build.VERSION.SDK_INT < 18) {
          break label180;
        }
        localObject1 = TextDirectionHeuristic.class;
        glW = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        localObject1 = StaticLayout.class.getDeclaredConstructor(new Class[] { CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, localObject1, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE });
        glV = (Constructor)localObject1;
        ((Constructor)localObject1).setAccessible(true);
        sInitialized = true;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Object localObject4;
        Class localClass;
        ac.e("StaticTextView.StaticLayoutWithMaxLines", "StaticLayout constructor with max lines not found.", new Object[] { localNoSuchMethodException });
        glU = true;
        sInitialized = true;
        continue;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        ac.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristic class not found.", new Object[] { localClassNotFoundException });
        glU = true;
        sInitialized = true;
        continue;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        ac.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristics.FIRSTSTRONG_LTR not found.", new Object[] { localNoSuchFieldException });
        glU = true;
        sInitialized = true;
        continue;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        ac.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristics.FIRSTSTRONG_LTR not accessible.", new Object[] { localIllegalAccessException });
        glU = true;
        sInitialized = true;
        continue;
      }
      catch (Exception localException)
      {
        ac.e("StaticTextView.StaticLayoutWithMaxLines", "Other error.", new Object[] { localException });
        glU = true;
        sInitialized = true;
        continue;
      }
      finally
      {
        sInitialized = true;
        AppMethodBeat.o(141137);
      }
      ac.i("StaticTextView.StaticLayoutWithMaxLines", "ensureInitialized finish, sInitialError: " + glU);
      AppMethodBeat.o(141137);
      continue;
      label180:
      localObject4 = a.class.getClassLoader();
      localClass = ((ClassLoader)localObject4).loadClass("android.text.TextDirectionHeuristic");
      localObject4 = ((ClassLoader)localObject4).loadClass("android.text.TextDirectionHeuristics");
      glW = ((Class)localObject4).getField("FIRSTSTRONG_LTR").get(localObject4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.b.a
 * JD-Core Version:    0.7.0.1
 */