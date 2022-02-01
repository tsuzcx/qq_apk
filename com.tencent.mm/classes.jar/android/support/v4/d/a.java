package android.support.v4.d;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class a
{
  static final d NT = e.Os;
  private static final String NU = Character.toString('‎');
  private static final String NV = Character.toString('‏');
  static final a NW = new a(false, 2, NT);
  static final a NX = new a(true, 2, NT);
  private final int FV;
  private final boolean NY;
  private final d NZ;
  
  private a(boolean paramBoolean, int paramInt, d paramd)
  {
    this.NY = paramBoolean;
    this.FV = paramInt;
    this.NZ = paramd;
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
    if ((this.FV & 0x2) != 0)
    {
      k = 1;
      if (k != 0)
      {
        if (!bool1) {
          break label207;
        }
        paramd = e.Or;
        bool2 = paramd.a(paramCharSequence, paramCharSequence.length());
        if ((this.NY) || ((!bool2) && (n(paramCharSequence) != 1))) {
          break label214;
        }
        paramd = NU;
        label95:
        localSpannableStringBuilder.append(paramd);
      }
      if (bool1 == this.NY) {
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
      paramd = e.Or;
      label152:
      bool1 = paramd.a(paramCharSequence, paramCharSequence.length());
      if ((this.NY) || ((!bool1) && (m(paramCharSequence) != 1))) {
        break label271;
      }
      paramCharSequence = NU;
    }
    for (;;)
    {
      localSpannableStringBuilder.append(paramCharSequence);
      return localSpannableStringBuilder;
      k = 0;
      break;
      label207:
      paramd = e.Oq;
      break label56;
      label214:
      if ((this.NY) && ((!bool2) || (n(paramCharSequence) == -1)))
      {
        paramd = NV;
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
      paramd = e.Oq;
      break label152;
      label271:
      if ((this.NY) && ((!bool1) || (m(paramCharSequence) == -1))) {
        paramCharSequence = NV;
      } else {
        paramCharSequence = "";
      }
    }
  }
  
  static boolean a(Locale paramLocale)
  {
    return f.getLayoutDirectionFromLocale(paramLocale) == 1;
  }
  
  public static a fg()
  {
    a locala = new a();
    if ((locala.FV == 2) && (locala.Oa == NT))
    {
      if (locala.NY) {
        return NX;
      }
      return NW;
    }
    return new a(locala.NY, locala.FV, locala.Oa);
  }
  
  private static int m(CharSequence paramCharSequence)
  {
    return new b(paramCharSequence).fi();
  }
  
  private static int n(CharSequence paramCharSequence)
  {
    return new b(paramCharSequence).fh();
  }
  
  public final CharSequence unicodeWrap(CharSequence paramCharSequence)
  {
    return a(paramCharSequence, this.NZ);
  }
  
  public static final class a
  {
    int FV = 2;
    boolean NY = a.a(Locale.getDefault());
    d Oa = a.NT;
  }
  
  static final class b
  {
    private static final byte[] Ob = new byte[1792];
    private final boolean Oc;
    private int Od;
    private char Oe;
    private final int length;
    private final CharSequence text;
    
    static
    {
      int i = 0;
      while (i < 1792)
      {
        Ob[i] = Character.getDirectionality(i);
        i += 1;
      }
    }
    
    b(CharSequence paramCharSequence)
    {
      this.text = paramCharSequence;
      this.Oc = false;
      this.length = paramCharSequence.length();
    }
    
    private static byte a(char paramChar)
    {
      if (paramChar < '܀') {
        return Ob[paramChar];
      }
      return Character.getDirectionality(paramChar);
    }
    
    private byte fj()
    {
      this.Oe = this.text.charAt(this.Od);
      byte b1;
      if (Character.isHighSurrogate(this.Oe))
      {
        int i = Character.codePointAt(this.text, this.Od);
        this.Od += Character.charCount(i);
        b1 = Character.getDirectionality(i);
      }
      do
      {
        byte b2;
        do
        {
          return b1;
          this.Od += 1;
          b2 = a(this.Oe);
          b1 = b2;
        } while (!this.Oc);
        if (this.Oe == '<') {
          return fm();
        }
        b1 = b2;
      } while (this.Oe != '&');
      return fo();
    }
    
    private byte fl()
    {
      this.Oe = this.text.charAt(this.Od - 1);
      byte b1;
      if (Character.isLowSurrogate(this.Oe))
      {
        int i = Character.codePointBefore(this.text, this.Od);
        this.Od -= Character.charCount(i);
        b1 = Character.getDirectionality(i);
      }
      do
      {
        byte b2;
        do
        {
          return b1;
          this.Od -= 1;
          b2 = a(this.Oe);
          b1 = b2;
        } while (!this.Oc);
        if (this.Oe == '>') {
          return fn();
        }
        b1 = b2;
      } while (this.Oe != ';');
      return fp();
    }
    
    private byte fm()
    {
      int j = this.Od;
      for (;;)
      {
        if (this.Od >= this.length) {
          break label135;
        }
        CharSequence localCharSequence = this.text;
        int k = this.Od;
        this.Od = (k + 1);
        this.Oe = localCharSequence.charAt(k);
        if (this.Oe == '>') {
          return 12;
        }
        if ((this.Oe == '"') || (this.Oe == '\''))
        {
          k = this.Oe;
          if (this.Od < this.length)
          {
            localCharSequence = this.text;
            int m = this.Od;
            this.Od = (m + 1);
            int i = localCharSequence.charAt(m);
            this.Oe = i;
            if (i != k) {
              break;
            }
          }
        }
      }
      label135:
      this.Od = j;
      this.Oe = '<';
      return 13;
    }
    
    private byte fn()
    {
      int j = this.Od;
      for (;;)
      {
        if (this.Od <= 0) {
          break label136;
        }
        CharSequence localCharSequence = this.text;
        int k = this.Od - 1;
        this.Od = k;
        this.Oe = localCharSequence.charAt(k);
        if (this.Oe == '<') {
          return 12;
        }
        if (this.Oe == '>') {
          break label136;
        }
        if ((this.Oe == '"') || (this.Oe == '\''))
        {
          k = this.Oe;
          if (this.Od > 0)
          {
            localCharSequence = this.text;
            int m = this.Od - 1;
            this.Od = m;
            int i = localCharSequence.charAt(m);
            this.Oe = i;
            if (i != k) {
              break;
            }
          }
        }
      }
      label136:
      this.Od = j;
      this.Oe = '>';
      return 13;
    }
    
    private byte fo()
    {
      char c;
      do
      {
        if (this.Od >= this.length) {
          break;
        }
        CharSequence localCharSequence = this.text;
        int i = this.Od;
        this.Od = (i + 1);
        c = localCharSequence.charAt(i);
        this.Oe = c;
      } while (c != ';');
      return 12;
    }
    
    private byte fp()
    {
      int i = this.Od;
      do
      {
        if (this.Od <= 0) {
          break;
        }
        CharSequence localCharSequence = this.text;
        int j = this.Od - 1;
        this.Od = j;
        this.Oe = localCharSequence.charAt(j);
        if (this.Oe == '&') {
          return 12;
        }
      } while (this.Oe != ';');
      this.Od = i;
      this.Oe = ';';
      return 13;
    }
    
    final int fh()
    {
      this.Od = 0;
      int j = 0;
      int k = 0;
      int i = 0;
      while ((this.Od < this.length) && (j == 0)) {
        switch (fj())
        {
        case 9: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          j = i;
          break;
        case 14: 
        case 15: 
          i += 1;
          k = -1;
          break;
        case 16: 
        case 17: 
          i += 1;
          k = 1;
          break;
        case 18: 
          i -= 1;
          k = 0;
          break;
        case 0: 
          if (i == 0) {
            return -1;
          }
          j = i;
          break;
        case 1: 
        case 2: 
          if (i == 0) {
            return 1;
          }
          j = i;
        }
      }
      if (j == 0) {
        return 0;
      }
      if (k != 0) {
        return k;
      }
      for (;;)
      {
        if (this.Od <= 0) {
          break label268;
        }
        switch (fl())
        {
        default: 
          break;
        case 14: 
        case 15: 
          if (j == i) {
            break;
          }
          i -= 1;
          break;
        case 16: 
        case 17: 
          if (j == i) {
            return 1;
          }
          i -= 1;
          break;
        case 18: 
          i += 1;
        }
      }
      label268:
      return 0;
    }
    
    final int fi()
    {
      int m = 0;
      this.Od = this.length;
      int j = 0;
      int i = 0;
      for (;;)
      {
        int k = m;
        if (this.Od > 0) {}
        switch (fl())
        {
        case 9: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          if (j == 0) {
            j = i;
          }
          break;
        case 0: 
          if (i == 0)
          {
            k = -1;
            return k;
          }
          if (j == 0) {
            j = i;
          }
          break;
        case 14: 
        case 15: 
          if (j == i) {
            return -1;
          }
          i -= 1;
          break;
        case 1: 
        case 2: 
          if (i == 0) {
            return 1;
          }
          if (j == 0) {
            j = i;
          }
          break;
        case 16: 
        case 17: 
          if (j == i) {
            return 1;
          }
          i -= 1;
          break;
        case 18: 
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.d.a
 * JD-Core Version:    0.7.0.1
 */