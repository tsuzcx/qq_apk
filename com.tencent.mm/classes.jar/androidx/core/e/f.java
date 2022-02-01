package androidx.core.e;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class f
{
  private static final Locale bsB;
  
  static
  {
    AppMethodBeat.i(195452);
    bsB = new Locale("", "");
    AppMethodBeat.o(195452);
  }
  
  public static int d(Locale paramLocale)
  {
    AppMethodBeat.i(195441);
    if (Build.VERSION.SDK_INT >= 17)
    {
      int i = TextUtils.getLayoutDirectionFromLocale(paramLocale);
      AppMethodBeat.o(195441);
      return i;
    }
    if ((paramLocale != null) && (!paramLocale.equals(bsB)))
    {
      String str = b.b(paramLocale);
      if (str == null)
      {
        switch (Character.getDirectionality(paramLocale.getDisplayName(paramLocale).charAt(0)))
        {
        default: 
          AppMethodBeat.o(195441);
          return 0;
        }
        AppMethodBeat.o(195441);
        return 1;
      }
      if ((str.equalsIgnoreCase("Arab")) || (str.equalsIgnoreCase("Hebr")))
      {
        AppMethodBeat.o(195441);
        return 1;
      }
    }
    AppMethodBeat.o(195441);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.e.f
 * JD-Core Version:    0.7.0.1
 */