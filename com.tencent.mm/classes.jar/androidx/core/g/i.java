package androidx.core.g;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public static MenuItem a(MenuItem paramMenuItem, b paramb)
  {
    AppMethodBeat.i(195728);
    if ((paramMenuItem instanceof androidx.core.a.a.b))
    {
      paramMenuItem = ((androidx.core.a.a.b)paramMenuItem).a(paramb);
      AppMethodBeat.o(195728);
      return paramMenuItem;
    }
    AppMethodBeat.o(195728);
    return paramMenuItem;
  }
  
  public static void a(MenuItem paramMenuItem, char paramChar, int paramInt)
  {
    AppMethodBeat.i(195759);
    if ((paramMenuItem instanceof androidx.core.a.a.b))
    {
      ((androidx.core.a.a.b)paramMenuItem).setNumericShortcut(paramChar, paramInt);
      AppMethodBeat.o(195759);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setNumericShortcut(paramChar, paramInt);
    }
    AppMethodBeat.o(195759);
  }
  
  public static void a(MenuItem paramMenuItem, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(195777);
    if ((paramMenuItem instanceof androidx.core.a.a.b))
    {
      ((androidx.core.a.a.b)paramMenuItem).setIconTintList(paramColorStateList);
      AppMethodBeat.o(195777);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setIconTintList(paramColorStateList);
    }
    AppMethodBeat.o(195777);
  }
  
  public static void a(MenuItem paramMenuItem, PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(195789);
    if ((paramMenuItem instanceof androidx.core.a.a.b))
    {
      ((androidx.core.a.a.b)paramMenuItem).setIconTintMode(paramMode);
      AppMethodBeat.o(195789);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setIconTintMode(paramMode);
    }
    AppMethodBeat.o(195789);
  }
  
  public static void a(MenuItem paramMenuItem, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(195737);
    if ((paramMenuItem instanceof androidx.core.a.a.b))
    {
      ((androidx.core.a.a.b)paramMenuItem).b(paramCharSequence);
      AppMethodBeat.o(195737);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setContentDescription(paramCharSequence);
    }
    AppMethodBeat.o(195737);
  }
  
  public static void b(MenuItem paramMenuItem, char paramChar, int paramInt)
  {
    AppMethodBeat.i(195770);
    if ((paramMenuItem instanceof androidx.core.a.a.b))
    {
      ((androidx.core.a.a.b)paramMenuItem).setAlphabeticShortcut(paramChar, paramInt);
      AppMethodBeat.o(195770);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setAlphabeticShortcut(paramChar, paramInt);
    }
    AppMethodBeat.o(195770);
  }
  
  public static void b(MenuItem paramMenuItem, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(195748);
    if ((paramMenuItem instanceof androidx.core.a.a.b))
    {
      ((androidx.core.a.a.b)paramMenuItem).c(paramCharSequence);
      AppMethodBeat.o(195748);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setTooltipText(paramCharSequence);
    }
    AppMethodBeat.o(195748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.i
 * JD-Core Version:    0.7.0.1
 */