package android.support.v4.d;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class a
{
  static final d KU = e.Lt;
  private static final String KV = Character.toString('‎');
  private static final String KW = Character.toString('‏');
  static final a KX = new a(false, 2, KU);
  static final a KY = new a(true, 2, KU);
  private final int CW;
  private final boolean KZ;
  private final d La;
  
  private a(boolean paramBoolean, int paramInt, d paramd)
  {
    this.KZ = paramBoolean;
    this.CW = paramInt;
    this.La = paramd;
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
    if ((this.CW & 0x2) != 0)
    {
      k = 1;
      if (k != 0)
      {
        if (!bool1) {
          break label207;
        }
        paramd = e.Ls;
        bool2 = paramd.a(paramCharSequence, paramCharSequence.length());
        if ((this.KZ) || ((!bool2) && (n(paramCharSequence) != 1))) {
          break label214;
        }
        paramd = KV;
        label95:
        localSpannableStringBuilder.append(paramd);
      }
      if (bool1 == this.KZ) {
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
      paramd = e.Ls;
      label152:
      bool1 = paramd.a(paramCharSequence, paramCharSequence.length());
      if ((this.KZ) || ((!bool1) && (m(paramCharSequence) != 1))) {
        break label271;
      }
      paramCharSequence = KV;
    }
    for (;;)
    {
      localSpannableStringBuilder.append(paramCharSequence);
      return localSpannableStringBuilder;
      k = 0;
      break;
      label207:
      paramd = e.Lr;
      break label56;
      label214:
      if ((this.KZ) && ((!bool2) || (n(paramCharSequence) == -1)))
      {
        paramd = KW;
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
      paramd = e.Lr;
      break label152;
      label271:
      if ((this.KZ) && ((!bool1) || (m(paramCharSequence) == -1))) {
        paramCharSequence = KW;
      } else {
        paramCharSequence = "";
      }
    }
  }
  
  static boolean a(Locale paramLocale)
  {
    return f.getLayoutDirectionFromLocale(paramLocale) == 1;
  }
  
  public static a eC()
  {
    a locala = new a();
    if ((locala.CW == 2) && (locala.Lb == KU))
    {
      if (locala.KZ) {
        return KY;
      }
      return KX;
    }
    return new a(locala.KZ, locala.CW, locala.Lb);
  }
  
  private static int m(CharSequence paramCharSequence)
  {
    return new b(paramCharSequence).eE();
  }
  
  private static int n(CharSequence paramCharSequence)
  {
    return new b(paramCharSequence).eD();
  }
  
  public final CharSequence unicodeWrap(CharSequence paramCharSequence)
  {
    return a(paramCharSequence, this.La);
  }
  
  public static final class a
  {
    int CW = 2;
    boolean KZ = a.a(Locale.getDefault());
    d Lb = a.KU;
  }
  
  static final class b
  {
    private static final byte[] Lc = new byte[1792];
    private final boolean Ld;
    private int Le;
    private char Lf;
    private final int length;
    private final CharSequence text;
    
    static
    {
      int i = 0;
      while (i < 1792)
      {
        Lc[i] = Character.getDirectionality(i);
        i += 1;
      }
    }
    
    b(CharSequence paramCharSequence)
    {
      this.text = paramCharSequence;
      this.Ld = false;
      this.length = paramCharSequence.length();
    }
    
    private static byte a(char paramChar)
    {
      if (paramChar < '܀') {
        return Lc[paramChar];
      }
      return Character.getDirectionality(paramChar);
    }
    
    private byte eF()
    {
      this.Lf = this.text.charAt(this.Le);
      byte b1;
      if (Character.isHighSurrogate(this.Lf))
      {
        int i = Character.codePointAt(this.text, this.Le);
        this.Le += Character.charCount(i);
        b1 = Character.getDirectionality(i);
      }
      do
      {
        byte b2;
        do
        {
          return b1;
          this.Le += 1;
          b2 = a(this.Lf);
          b1 = b2;
        } while (!this.Ld);
        if (this.Lf == '<') {
          return eH();
        }
        b1 = b2;
      } while (this.Lf != '&');
      return eJ();
    }
    
    private byte eG()
    {
      this.Lf = this.text.charAt(this.Le - 1);
      byte b1;
      if (Character.isLowSurrogate(this.Lf))
      {
        int i = Character.codePointBefore(this.text, this.Le);
        this.Le -= Character.charCount(i);
        b1 = Character.getDirectionality(i);
      }
      do
      {
        byte b2;
        do
        {
          return b1;
          this.Le -= 1;
          b2 = a(this.Lf);
          b1 = b2;
        } while (!this.Ld);
        if (this.Lf == '>') {
          return eI();
        }
        b1 = b2;
      } while (this.Lf != ';');
      return eK();
    }
    
    private byte eH()
    {
      int j = this.Le;
      for (;;)
      {
        if (this.Le >= this.length) {
          break label135;
        }
        CharSequence localCharSequence = this.text;
        int k = this.Le;
        this.Le = (k + 1);
        this.Lf = localCharSequence.charAt(k);
        if (this.Lf == '>') {
          return 12;
        }
        if ((this.Lf == '"') || (this.Lf == '\''))
        {
          k = this.Lf;
          if (this.Le < this.length)
          {
            localCharSequence = this.text;
            int m = this.Le;
            this.Le = (m + 1);
            int i = localCharSequence.charAt(m);
            this.Lf = i;
            if (i != k) {
              break;
            }
          }
        }
      }
      label135:
      this.Le = j;
      this.Lf = '<';
      return 13;
    }
    
    private byte eI()
    {
      int j = this.Le;
      for (;;)
      {
        if (this.Le <= 0) {
          break label136;
        }
        CharSequence localCharSequence = this.text;
        int k = this.Le - 1;
        this.Le = k;
        this.Lf = localCharSequence.charAt(k);
        if (this.Lf == '<') {
          return 12;
        }
        if (this.Lf == '>') {
          break label136;
        }
        if ((this.Lf == '"') || (this.Lf == '\''))
        {
          k = this.Lf;
          if (this.Le > 0)
          {
            localCharSequence = this.text;
            int m = this.Le - 1;
            this.Le = m;
            int i = localCharSequence.charAt(m);
            this.Lf = i;
            if (i != k) {
              break;
            }
          }
        }
      }
      label136:
      this.Le = j;
      this.Lf = '>';
      return 13;
    }
    
    private byte eJ()
    {
      char c;
      do
      {
        if (this.Le >= this.length) {
          break;
        }
        CharSequence localCharSequence = this.text;
        int i = this.Le;
        this.Le = (i + 1);
        c = localCharSequence.charAt(i);
        this.Lf = c;
      } while (c != ';');
      return 12;
    }
    
    private byte eK()
    {
      int i = this.Le;
      do
      {
        if (this.Le <= 0) {
          break;
        }
        CharSequence localCharSequence = this.text;
        int j = this.Le - 1;
        this.Le = j;
        this.Lf = localCharSequence.charAt(j);
        if (this.Lf == '&') {
          return 12;
        }
      } while (this.Lf != ';');
      this.Le = i;
      this.Lf = ';';
      return 13;
    }
    
    final int eD()
    {
      this.Le = 0;
      int j = 0;
      int k = 0;
      int i = 0;
      while ((this.Le < this.length) && (j == 0)) {
        switch (eF())
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
        if (this.Le <= 0) {
          break label268;
        }
        switch (eG())
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
    
    final int eE()
    {
      int m = 0;
      this.Le = this.length;
      int j = 0;
      int i = 0;
      for (;;)
      {
        int k = m;
        if (this.Le > 0) {}
        switch (eG())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.d.a
 * JD-Core Version:    0.7.0.1
 */