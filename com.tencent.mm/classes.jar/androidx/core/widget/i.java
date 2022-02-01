package androidx.core.widget;

import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode.Callback;
import android.widget.TextView;
import androidx.core.e.c;
import androidx.core.e.c.a;
import androidx.core.e.c.a.a;
import androidx.core.f.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class i
{
  private static Field QG;
  private static boolean QH;
  private static Field QI;
  private static boolean QJ;
  
  private static Field G(String paramString)
  {
    AppMethodBeat.i(253210);
    Object localObject = null;
    try
    {
      Field localField = TextView.class.getDeclaredField(paramString);
      localObject = localField;
      localField.setAccessible(true);
      localObject = localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        new StringBuilder("Could not retrieve ").append(paramString).append(" field.");
      }
    }
    AppMethodBeat.o(253210);
    return localObject;
  }
  
  public static int a(TextView paramTextView)
  {
    AppMethodBeat.i(253218);
    int i;
    if (Build.VERSION.SDK_INT >= 16)
    {
      i = paramTextView.getMaxLines();
      AppMethodBeat.o(253218);
      return i;
    }
    if (!QJ)
    {
      QI = G("mMaxMode");
      QJ = true;
    }
    if ((QI != null) && (a(QI, paramTextView) == 1))
    {
      if (!QH)
      {
        QG = G("mMaximum");
        QH = true;
      }
      if (QG != null)
      {
        i = a(QG, paramTextView);
        AppMethodBeat.o(253218);
        return i;
      }
    }
    AppMethodBeat.o(253218);
    return -1;
  }
  
  private static int a(Field paramField, TextView paramTextView)
  {
    AppMethodBeat.i(253211);
    try
    {
      int i = paramField.getInt(paramTextView);
      AppMethodBeat.o(253211);
      return i;
    }
    catch (IllegalAccessException paramTextView)
    {
      new StringBuilder("Could not retrieve value of ").append(paramField.getName()).append(" field.");
      AppMethodBeat.o(253211);
    }
    return -1;
  }
  
  public static ActionMode.Callback a(TextView paramTextView, ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(253222);
    if ((Build.VERSION.SDK_INT < 26) || (Build.VERSION.SDK_INT > 27) || ((paramCallback instanceof i.a)))
    {
      AppMethodBeat.o(253222);
      return paramCallback;
    }
    paramTextView = new i.a(paramCallback, paramTextView);
    AppMethodBeat.o(253222);
    return paramTextView;
  }
  
  public static void a(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(253219);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramTextView.setTextAppearance(paramInt);
      AppMethodBeat.o(253219);
      return;
    }
    paramTextView.setTextAppearance(paramTextView.getContext(), paramInt);
    AppMethodBeat.o(253219);
  }
  
  public static void a(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    AppMethodBeat.i(253215);
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
      AppMethodBeat.o(253215);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      int i;
      Drawable localDrawable;
      if (paramTextView.getLayoutDirection() == 1)
      {
        i = 1;
        if (i == 0) {
          break label82;
        }
        localDrawable = paramDrawable3;
        label55:
        if (i == 0) {
          break label88;
        }
      }
      for (;;)
      {
        paramTextView.setCompoundDrawables(localDrawable, paramDrawable2, paramDrawable1, paramDrawable4);
        AppMethodBeat.o(253215);
        return;
        i = 0;
        break;
        label82:
        localDrawable = paramDrawable1;
        break label55;
        label88:
        paramDrawable1 = paramDrawable3;
      }
    }
    paramTextView.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    AppMethodBeat.o(253215);
  }
  
  public static void a(TextView paramTextView, c paramc)
  {
    AppMethodBeat.i(253229);
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramTextView.setText(paramc.gR());
      AppMethodBeat.o(253229);
      return;
    }
    if (!d(paramTextView).a(paramc.Md))
    {
      paramTextView = new IllegalArgumentException("Given text can not be applied to TextView.");
      AppMethodBeat.o(253229);
      throw paramTextView;
    }
    paramTextView.setText(paramc);
    AppMethodBeat.o(253229);
  }
  
  public static void b(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(253224);
    g.bv(paramInt);
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramTextView.setFirstBaselineToTopHeight(paramInt);
      AppMethodBeat.o(253224);
      return;
    }
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    if ((Build.VERSION.SDK_INT < 16) || (paramTextView.getIncludeFontPadding())) {}
    for (int i = localFontMetricsInt.top;; i = localFontMetricsInt.ascent)
    {
      if (paramInt > Math.abs(i)) {
        paramTextView.setPadding(paramTextView.getPaddingLeft(), i + paramInt, paramTextView.getPaddingRight(), paramTextView.getPaddingBottom());
      }
      AppMethodBeat.o(253224);
      return;
    }
  }
  
  public static Drawable[] b(TextView paramTextView)
  {
    int i = 1;
    AppMethodBeat.i(253220);
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView = paramTextView.getCompoundDrawablesRelative();
      AppMethodBeat.o(253220);
      return paramTextView;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (paramTextView.getLayoutDirection() == 1) {}
      for (;;)
      {
        paramTextView = paramTextView.getCompoundDrawables();
        if (i != 0)
        {
          Object localObject1 = paramTextView[2];
          Object localObject2 = paramTextView[0];
          paramTextView[0] = localObject1;
          paramTextView[2] = localObject2;
        }
        AppMethodBeat.o(253220);
        return paramTextView;
        i = 0;
      }
    }
    paramTextView = paramTextView.getCompoundDrawables();
    AppMethodBeat.o(253220);
    return paramTextView;
  }
  
  public static void c(TextView paramTextView)
  {
    AppMethodBeat.i(253221);
    if (Build.VERSION.SDK_INT >= 27)
    {
      paramTextView.setAutoSizeTextTypeWithDefaults(1);
      AppMethodBeat.o(253221);
      return;
    }
    if ((paramTextView instanceof b)) {
      ((b)paramTextView).setAutoSizeTextTypeWithDefaults(1);
    }
    AppMethodBeat.o(253221);
  }
  
  public static void c(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(253225);
    g.bv(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    if ((Build.VERSION.SDK_INT < 16) || (paramTextView.getIncludeFontPadding())) {}
    for (int i = localFontMetricsInt.bottom;; i = localFontMetricsInt.descent)
    {
      if (paramInt > Math.abs(i)) {
        paramTextView.setPadding(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop(), paramTextView.getPaddingRight(), paramInt - i);
      }
      AppMethodBeat.o(253225);
      return;
    }
  }
  
  public static c.a d(TextView paramTextView)
  {
    AppMethodBeat.i(253227);
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramTextView = new c.a(paramTextView.getTextMetricsParams());
      AppMethodBeat.o(253227);
      return paramTextView;
    }
    c.a.a locala = new c.a.a(new TextPaint(paramTextView.getPaint()));
    if (Build.VERSION.SDK_INT >= 23)
    {
      locala.Mh = paramTextView.getBreakStrategy();
      locala.Mi = paramTextView.getHyphenationFrequency();
    }
    if (Build.VERSION.SDK_INT >= 18) {
      locala.Mg = e(paramTextView);
    }
    paramTextView = locala.gS();
    AppMethodBeat.o(253227);
    return paramTextView;
  }
  
  public static void d(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(253226);
    g.bv(paramInt);
    int i = paramTextView.getPaint().getFontMetricsInt(null);
    if (paramInt != i) {
      paramTextView.setLineSpacing(paramInt - i, 1.0F);
    }
    AppMethodBeat.o(253226);
  }
  
  private static TextDirectionHeuristic e(TextView paramTextView)
  {
    int i = 1;
    AppMethodBeat.i(253230);
    if ((paramTextView.getTransformationMethod() instanceof PasswordTransformationMethod))
    {
      paramTextView = TextDirectionHeuristics.LTR;
      AppMethodBeat.o(253230);
      return paramTextView;
    }
    if ((Build.VERSION.SDK_INT >= 28) && ((paramTextView.getInputType() & 0xF) == 3))
    {
      i = Character.getDirectionality(android.icu.text.DecimalFormatSymbols.getInstance(paramTextView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
      if ((i == 1) || (i == 2))
      {
        paramTextView = TextDirectionHeuristics.RTL;
        AppMethodBeat.o(253230);
        return paramTextView;
      }
      paramTextView = TextDirectionHeuristics.LTR;
      AppMethodBeat.o(253230);
      return paramTextView;
    }
    if (paramTextView.getLayoutDirection() == 1) {}
    for (;;)
    {
      switch (paramTextView.getTextDirection())
      {
      default: 
        if (i == 0) {
          break label173;
        }
        paramTextView = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        AppMethodBeat.o(253230);
        return paramTextView;
        i = 0;
      }
    }
    label173:
    paramTextView = TextDirectionHeuristics.FIRSTSTRONG_LTR;
    AppMethodBeat.o(253230);
    return paramTextView;
    paramTextView = TextDirectionHeuristics.ANYRTL_LTR;
    AppMethodBeat.o(253230);
    return paramTextView;
    paramTextView = TextDirectionHeuristics.LTR;
    AppMethodBeat.o(253230);
    return paramTextView;
    paramTextView = TextDirectionHeuristics.RTL;
    AppMethodBeat.o(253230);
    return paramTextView;
    paramTextView = TextDirectionHeuristics.LOCALE;
    AppMethodBeat.o(253230);
    return paramTextView;
    paramTextView = TextDirectionHeuristics.FIRSTSTRONG_LTR;
    AppMethodBeat.o(253230);
    return paramTextView;
    paramTextView = TextDirectionHeuristics.FIRSTSTRONG_RTL;
    AppMethodBeat.o(253230);
    return paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.widget.i
 * JD-Core Version:    0.7.0.1
 */