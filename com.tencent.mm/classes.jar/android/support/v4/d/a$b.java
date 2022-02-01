package android.support.v4.d;

final class a$b
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
  
  a$b(CharSequence paramCharSequence)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.d.a.b
 * JD-Core Version:    0.7.0.1
 */