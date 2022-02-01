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
    return new b(paramCharSequence).fd();
  }
  
  private static int n(CharSequence paramCharSequence)
  {
    return new b(paramCharSequence).fc();
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
  
  static final class b
  {
    private static final byte[] NP = new byte[1792];
    private final boolean NQ;
    private int NR;
    private char NS;
    private final int length;
    private final CharSequence text;
    
    static
    {
      int i = 0;
      while (i < 1792)
      {
        NP[i] = Character.getDirectionality(i);
        i += 1;
      }
    }
    
    b(CharSequence paramCharSequence)
    {
      this.text = paramCharSequence;
      this.NQ = false;
      this.length = paramCharSequence.length();
    }
    
    private static byte a(char paramChar)
    {
      if (paramChar < '܀') {
        return NP[paramChar];
      }
      return Character.getDirectionality(paramChar);
    }
    
    private byte fe()
    {
      this.NS = this.text.charAt(this.NR);
      byte b1;
      if (Character.isHighSurrogate(this.NS))
      {
        int i = Character.codePointAt(this.text, this.NR);
        this.NR += Character.charCount(i);
        b1 = Character.getDirectionality(i);
      }
      do
      {
        byte b2;
        do
        {
          return b1;
          this.NR += 1;
          b2 = a(this.NS);
          b1 = b2;
        } while (!this.NQ);
        if (this.NS == '<') {
          return fg();
        }
        b1 = b2;
      } while (this.NS != '&');
      return fi();
    }
    
    private byte ff()
    {
      this.NS = this.text.charAt(this.NR - 1);
      byte b1;
      if (Character.isLowSurrogate(this.NS))
      {
        int i = Character.codePointBefore(this.text, this.NR);
        this.NR -= Character.charCount(i);
        b1 = Character.getDirectionality(i);
      }
      do
      {
        byte b2;
        do
        {
          return b1;
          this.NR -= 1;
          b2 = a(this.NS);
          b1 = b2;
        } while (!this.NQ);
        if (this.NS == '>') {
          return fh();
        }
        b1 = b2;
      } while (this.NS != ';');
      return fj();
    }
    
    private byte fg()
    {
      int j = this.NR;
      for (;;)
      {
        if (this.NR >= this.length) {
          break label135;
        }
        CharSequence localCharSequence = this.text;
        int k = this.NR;
        this.NR = (k + 1);
        this.NS = localCharSequence.charAt(k);
        if (this.NS == '>') {
          return 12;
        }
        if ((this.NS == '"') || (this.NS == '\''))
        {
          k = this.NS;
          if (this.NR < this.length)
          {
            localCharSequence = this.text;
            int m = this.NR;
            this.NR = (m + 1);
            int i = localCharSequence.charAt(m);
            this.NS = i;
            if (i != k) {
              break;
            }
          }
        }
      }
      label135:
      this.NR = j;
      this.NS = '<';
      return 13;
    }
    
    private byte fh()
    {
      int j = this.NR;
      for (;;)
      {
        if (this.NR <= 0) {
          break label136;
        }
        CharSequence localCharSequence = this.text;
        int k = this.NR - 1;
        this.NR = k;
        this.NS = localCharSequence.charAt(k);
        if (this.NS == '<') {
          return 12;
        }
        if (this.NS == '>') {
          break label136;
        }
        if ((this.NS == '"') || (this.NS == '\''))
        {
          k = this.NS;
          if (this.NR > 0)
          {
            localCharSequence = this.text;
            int m = this.NR - 1;
            this.NR = m;
            int i = localCharSequence.charAt(m);
            this.NS = i;
            if (i != k) {
              break;
            }
          }
        }
      }
      label136:
      this.NR = j;
      this.NS = '>';
      return 13;
    }
    
    private byte fi()
    {
      char c;
      do
      {
        if (this.NR >= this.length) {
          break;
        }
        CharSequence localCharSequence = this.text;
        int i = this.NR;
        this.NR = (i + 1);
        c = localCharSequence.charAt(i);
        this.NS = c;
      } while (c != ';');
      return 12;
    }
    
    private byte fj()
    {
      int i = this.NR;
      do
      {
        if (this.NR <= 0) {
          break;
        }
        CharSequence localCharSequence = this.text;
        int j = this.NR - 1;
        this.NR = j;
        this.NS = localCharSequence.charAt(j);
        if (this.NS == '&') {
          return 12;
        }
      } while (this.NS != ';');
      this.NR = i;
      this.NS = ';';
      return 13;
    }
    
    final int fc()
    {
      this.NR = 0;
      int j = 0;
      int k = 0;
      int i = 0;
      while ((this.NR < this.length) && (j == 0)) {
        switch (fe())
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
        if (this.NR <= 0) {
          break label268;
        }
        switch (ff())
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
    
    final int fd()
    {
      int m = 0;
      this.NR = this.length;
      int j = 0;
      int i = 0;
      for (;;)
      {
        int k = m;
        if (this.NR > 0) {}
        switch (ff())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.d.a
 * JD-Core Version:    0.7.0.1
 */