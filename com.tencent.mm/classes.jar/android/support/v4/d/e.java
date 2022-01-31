package android.support.v4.d;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Locale;

public final class e
{
  private static final Locale ROOT = new Locale("", "");
  
  public static int getLayoutDirectionFromLocale(Locale paramLocale)
  {
    int j = 1;
    int i;
    if (Build.VERSION.SDK_INT >= 17) {
      i = TextUtils.getLayoutDirectionFromLocale(paramLocale);
    }
    String str;
    do
    {
      do
      {
        return i;
        if ((paramLocale == null) || (paramLocale.equals(ROOT))) {
          break;
        }
        str = a.a(paramLocale);
        if (str == null)
        {
          i = j;
          switch (Character.getDirectionality(paramLocale.getDisplayName(paramLocale).charAt(0)))
          {
          }
          return 0;
        }
        i = j;
      } while (str.equalsIgnoreCase("Arab"));
      i = j;
    } while (str.equalsIgnoreCase("Hebr"));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.d.e
 * JD-Core Version:    0.7.0.1
 */