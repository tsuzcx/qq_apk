package androidx.core.e;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class f
{
  private static final Locale Mw;
  
  static
  {
    AppMethodBeat.i(251304);
    Mw = new Locale("", "");
    AppMethodBeat.o(251304);
  }
  
  public static int d(Locale paramLocale)
  {
    AppMethodBeat.i(251303);
    if (Build.VERSION.SDK_INT >= 17)
    {
      int i = TextUtils.getLayoutDirectionFromLocale(paramLocale);
      AppMethodBeat.o(251303);
      return i;
    }
    if ((paramLocale != null) && (!paramLocale.equals(Mw)))
    {
      String str = b.b(paramLocale);
      if (str == null)
      {
        switch (Character.getDirectionality(paramLocale.getDisplayName(paramLocale).charAt(0)))
        {
        default: 
          AppMethodBeat.o(251303);
          return 0;
        }
        AppMethodBeat.o(251303);
        return 1;
      }
      if ((str.equalsIgnoreCase("Arab")) || (str.equalsIgnoreCase("Hebr")))
      {
        AppMethodBeat.o(251303);
        return 1;
      }
    }
    AppMethodBeat.o(251303);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.e.f
 * JD-Core Version:    0.7.0.1
 */