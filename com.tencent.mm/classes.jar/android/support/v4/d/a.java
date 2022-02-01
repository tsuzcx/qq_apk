package android.support.v4.d;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class a
{
  static final d NH = e.Og;
  private static final String NI = Character.toString('‎');
  private static final String NJ = Character.toString('‏');
  static final a NK = new a(false, 2, NH);
  static final a NL = new a(true, 2, NH);
  private final int FL;
  private final boolean NM;
  private final d NN;
  
  private a(boolean paramBoolean, int paramInt, d paramd)
  {
    this.NM = paramBoolean;
    this.FL = paramInt;
    this.NN = paramd;
  }
  
  private CharSequence a(CharSequence paramCharSequence, d paramd)
  {
    if (paramCharSequence == null) {
      return null;
    }
    boolean bool1 = paramd.a(paramCharSequence, paramCharSequence.length());
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int k;
    label56:
    boolean bool2;
    if ((this.FL & 0x2) != 0)
    {
      k = 1;
      if (k != 0)
      {
        if (!bool1) {
          break label207;
        }
        paramd = e.Of;
        bool2 = paramd.a(paramCharSequence, paramCharSequence.length());
        if ((this.NM) || ((!bool2) && (n(paramCharSequence) != 1))) {
          break label214;
        }
        paramd = NI;
        label95:
        localSpannableStringBuilder.append(paramd);
      }
      if (bool1 == this.NM) {
        break label254;
      }
      if (!bool1) {
        break label247;
      }
      int i = 8235;
      label120:
      localSpannableStringBuilder.append(i);
      localSpannableStringBuilder.append(paramCharSequence);
      localSpannableStringBuilder.append('‬');
      label143:
      if (!bool1) {
        break label264;
      }
      paramd = e.Of;
      label152:
      bool1 = paramd.a(paramCharSequence, paramCharSequence.length());
      if ((this.NM) || ((!bool1) && (m(paramCharSequence) != 1))) {
        break label271;
      }
      paramCharSequence = NI;
    }
    for (;;)
    {
      localSpannableStringBuilder.append(paramCharSequence);
      return localSpannableStringBuilder;
      k = 0;
      break;
      label207:
      paramd = e.Oe;
      break label56;
      label214:
      if ((this.NM) && ((!bool2) || (n(paramCharSequence) == -1)))
      {
        paramd = NJ;
        break label95;
      }
      paramd = "";
      break label95;
      label247:
      int j = 8234;
      break label120;
      label254:
      localSpannableStringBuilder.append(paramCharSequence);
      break label143;
      label264:
      paramd = e.Oe;
      break label152;
      label271:
      if ((this.NM) && ((!bool1) || (m(paramCharSequence) == -1))) {
        paramCharSequence = NJ;
      } else {
        paramCharSequence = "";
      }
    }
  }
  
  static boolean a(Locale paramLocale)
  {
    return f.getLayoutDirectionFromLocale(paramLocale) == 1;
  }
  
  public static a fb()
  {
    a locala = new a();
    if ((locala.FL == 2) && (locala.NO == NH))
    {
      if (locala.NM) {
        return NL;
      }
      return NK;
    }
    return new a(locala.NM, locala.FL, locala.NO);
  }
  
  private static int m(CharSequence paramCharSequence)
  {
    return new a.b(paramCharSequence).fd();
  }
  
  private static int n(CharSequence paramCharSequence)
  {
    return new a.b(paramCharSequence).fc();
  }
  
  public final CharSequence unicodeWrap(CharSequence paramCharSequence)
  {
    return a(paramCharSequence, this.NN);
  }
  
  public static final class a
  {
    int FL = 2;
    boolean NM = a.a(Locale.getDefault());
    d NO = a.NH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.d.a
 * JD-Core Version:    0.7.0.1
 */