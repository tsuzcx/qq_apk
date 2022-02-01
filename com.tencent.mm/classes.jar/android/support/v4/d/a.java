package android.support.v4.d;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class a
{
  static final d LP = e.Mo;
  private static final String LQ = Character.toString('‎');
  private static final String LR = Character.toString('‏');
  static final a LS = new a(false, 2, LP);
  static final a LT = new a(true, 2, LP);
  private final int DU;
  private final boolean LU;
  private final d LV;
  
  private a(boolean paramBoolean, int paramInt, d paramd)
  {
    this.LU = paramBoolean;
    this.DU = paramInt;
    this.LV = paramd;
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
    if ((this.DU & 0x2) != 0)
    {
      k = 1;
      if (k != 0)
      {
        if (!bool1) {
          break label207;
        }
        paramd = e.Mn;
        bool2 = paramd.a(paramCharSequence, paramCharSequence.length());
        if ((this.LU) || ((!bool2) && (n(paramCharSequence) != 1))) {
          break label214;
        }
        paramd = LQ;
        label95:
        localSpannableStringBuilder.append(paramd);
      }
      if (bool1 == this.LU) {
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
      paramd = e.Mn;
      label152:
      bool1 = paramd.a(paramCharSequence, paramCharSequence.length());
      if ((this.LU) || ((!bool1) && (m(paramCharSequence) != 1))) {
        break label271;
      }
      paramCharSequence = LQ;
    }
    for (;;)
    {
      localSpannableStringBuilder.append(paramCharSequence);
      return localSpannableStringBuilder;
      k = 0;
      break;
      label207:
      paramd = e.Mm;
      break label56;
      label214:
      if ((this.LU) && ((!bool2) || (n(paramCharSequence) == -1)))
      {
        paramd = LR;
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
      paramd = e.Mm;
      break label152;
      label271:
      if ((this.LU) && ((!bool1) || (m(paramCharSequence) == -1))) {
        paramCharSequence = LR;
      } else {
        paramCharSequence = "";
      }
    }
  }
  
  static boolean a(Locale paramLocale)
  {
    return f.getLayoutDirectionFromLocale(paramLocale) == 1;
  }
  
  public static a eK()
  {
    a locala = new a();
    if ((locala.DU == 2) && (locala.LW == LP))
    {
      if (locala.LU) {
        return LT;
      }
      return LS;
    }
    return new a(locala.LU, locala.DU, locala.LW);
  }
  
  private static int m(CharSequence paramCharSequence)
  {
    return new b(paramCharSequence).eM();
  }
  
  private static int n(CharSequence paramCharSequence)
  {
    return new b(paramCharSequence).eL();
  }
  
  public final CharSequence unicodeWrap(CharSequence paramCharSequence)
  {
    return a(paramCharSequence, this.LV);
  }
  
  public static final class a
  {
    int DU = 2;
    boolean LU = a.a(Locale.getDefault());
    d LW = a.LP;
  }
  
  static final class b
  {
    private static final byte[] LX = new byte[1792];
    private final boolean LY;
    private int LZ;
    private char Ma;
    private final int length;
    private final CharSequence text;
    
    static
    {
      int i = 0;
      while (i < 1792)
      {
        LX[i] = Character.getDirectionality(i);
        i += 1;
      }
    }
    
    b(CharSequence paramCharSequence)
    {
      this.text = paramCharSequence;
      this.LY = false;
      this.length = paramCharSequence.length();
    }
    
    private static byte a(char paramChar)
    {
      if (paramChar < '܀') {
        return LX[paramChar];
      }
      return Character.getDirectionality(paramChar);
    }
    
    private byte eN()
    {
      this.Ma = this.text.charAt(this.LZ);
      byte b1;
      if (Character.isHighSurrogate(this.Ma))
      {
        int i = Character.codePointAt(this.text, this.LZ);
        this.LZ += Character.charCount(i);
        b1 = Character.getDirectionality(i);
      }
      do
      {
        byte b2;
        do
        {
          return b1;
          this.LZ += 1;
          b2 = a(this.Ma);
          b1 = b2;
        } while (!this.LY);
        if (this.Ma == '<') {
          return eP();
        }
        b1 = b2;
      } while (this.Ma != '&');
      return eR();
    }
    
    private byte eO()
    {
      this.Ma = this.text.charAt(this.LZ - 1);
      byte b1;
      if (Character.isLowSurrogate(this.Ma))
      {
        int i = Character.codePointBefore(this.text, this.LZ);
        this.LZ -= Character.charCount(i);
        b1 = Character.getDirectionality(i);
      }
      do
      {
        byte b2;
        do
        {
          return b1;
          this.LZ -= 1;
          b2 = a(this.Ma);
          b1 = b2;
        } while (!this.LY);
        if (this.Ma == '>') {
          return eQ();
        }
        b1 = b2;
      } while (this.Ma != ';');
      return eS();
    }
    
    private byte eP()
    {
      int j = this.LZ;
      for (;;)
      {
        if (this.LZ >= this.length) {
          break label135;
        }
        CharSequence localCharSequence = this.text;
        int k = this.LZ;
        this.LZ = (k + 1);
        this.Ma = localCharSequence.charAt(k);
        if (this.Ma == '>') {
          return 12;
        }
        if ((this.Ma == '"') || (this.Ma == '\''))
        {
          k = this.Ma;
          if (this.LZ < this.length)
          {
            localCharSequence = this.text;
            int m = this.LZ;
            this.LZ = (m + 1);
            int i = localCharSequence.charAt(m);
            this.Ma = i;
            if (i != k) {
              break;
            }
          }
        }
      }
      label135:
      this.LZ = j;
      this.Ma = '<';
      return 13;
    }
    
    private byte eQ()
    {
      int j = this.LZ;
      for (;;)
      {
        if (this.LZ <= 0) {
          break label136;
        }
        CharSequence localCharSequence = this.text;
        int k = this.LZ - 1;
        this.LZ = k;
        this.Ma = localCharSequence.charAt(k);
        if (this.Ma == '<') {
          return 12;
        }
        if (this.Ma == '>') {
          break label136;
        }
        if ((this.Ma == '"') || (this.Ma == '\''))
        {
          k = this.Ma;
          if (this.LZ > 0)
          {
            localCharSequence = this.text;
            int m = this.LZ - 1;
            this.LZ = m;
            int i = localCharSequence.charAt(m);
            this.Ma = i;
            if (i != k) {
              break;
            }
          }
        }
      }
      label136:
      this.LZ = j;
      this.Ma = '>';
      return 13;
    }
    
    private byte eR()
    {
      char c;
      do
      {
        if (this.LZ >= this.length) {
          break;
        }
        CharSequence localCharSequence = this.text;
        int i = this.LZ;
        this.LZ = (i + 1);
        c = localCharSequence.charAt(i);
        this.Ma = c;
      } while (c != ';');
      return 12;
    }
    
    private byte eS()
    {
      int i = this.LZ;
      do
      {
        if (this.LZ <= 0) {
          break;
        }
        CharSequence localCharSequence = this.text;
        int j = this.LZ - 1;
        this.LZ = j;
        this.Ma = localCharSequence.charAt(j);
        if (this.Ma == '&') {
          return 12;
        }
      } while (this.Ma != ';');
      this.LZ = i;
      this.Ma = ';';
      return 13;
    }
    
    final int eL()
    {
      this.LZ = 0;
      int j = 0;
      int k = 0;
      int i = 0;
      while ((this.LZ < this.length) && (j == 0)) {
        switch (eN())
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
        if (this.LZ <= 0) {
          break label268;
        }
        switch (eO())
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
    
    final int eM()
    {
      int m = 0;
      this.LZ = this.length;
      int j = 0;
      int i = 0;
      for (;;)
      {
        int k = m;
        if (this.LZ > 0) {}
        switch (eO())
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