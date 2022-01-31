package com.eclipsesource.a;

import java.io.Writer;

class i
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final char[] arR = { 92, 34 };
  private static final char[] arS = { 92, 92 };
  private static final char[] arT = { 92, 110 };
  private static final char[] arU = { 92, 114 };
  private static final char[] arV = { 92, 116 };
  private static final char[] arW = { 92, 117, 50, 48, 50, 56 };
  private static final char[] arX = { 92, 117, 50, 48, 50, 57 };
  protected final Writer arY;
  
  i(Writer paramWriter)
  {
    this.arY = paramWriter;
  }
  
  private void ae(String paramString)
  {
    int m = paramString.length();
    int i = 0;
    int j = 0;
    if (i < m)
    {
      int k = paramString.charAt(i);
      char[] arrayOfChar;
      if (k > 92) {
        if ((k < 8232) || (k > 8233)) {
          arrayOfChar = null;
        }
      }
      for (;;)
      {
        k = j;
        if (arrayOfChar != null)
        {
          this.arY.write(paramString, j, i - j);
          this.arY.write(arrayOfChar);
          k = i + 1;
        }
        i += 1;
        j = k;
        break;
        if (k == 8232)
        {
          arrayOfChar = arW;
        }
        else
        {
          arrayOfChar = arX;
          continue;
          if (k == 92)
          {
            arrayOfChar = arS;
          }
          else if (k > 34)
          {
            arrayOfChar = null;
          }
          else if (k == 34)
          {
            arrayOfChar = arR;
          }
          else if (k > 31)
          {
            arrayOfChar = null;
          }
          else if (k == 10)
          {
            arrayOfChar = arT;
          }
          else if (k == 13)
          {
            arrayOfChar = arU;
          }
          else if (k == 9)
          {
            arrayOfChar = arV;
          }
          else
          {
            arrayOfChar = new char[6];
            arrayOfChar[0] = '\\';
            arrayOfChar[1] = 'u';
            arrayOfChar[2] = '0';
            arrayOfChar[3] = '0';
            arrayOfChar[4] = HEX_DIGITS[(k >> 4 & 0xF)];
            arrayOfChar[5] = HEX_DIGITS[(k & 0xF)];
          }
        }
      }
    }
    this.arY.write(paramString, j, m - j);
  }
  
  protected final void ab(String paramString)
  {
    this.arY.write(paramString);
  }
  
  protected final void ac(String paramString)
  {
    this.arY.write(paramString);
  }
  
  protected final void ad(String paramString)
  {
    this.arY.write(34);
    ae(paramString);
    this.arY.write(34);
  }
  
  protected void kc()
  {
    this.arY.write(91);
  }
  
  protected void kd()
  {
    this.arY.write(93);
  }
  
  protected void ke()
  {
    this.arY.write(44);
  }
  
  protected void kf()
  {
    this.arY.write(123);
  }
  
  protected void kg()
  {
    this.arY.write(125);
  }
  
  protected void kh()
  {
    this.arY.write(58);
  }
  
  protected void ki()
  {
    this.arY.write(44);
  }
  
  protected final void writeString(String paramString)
  {
    this.arY.write(34);
    ae(paramString);
    this.arY.write(34);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.eclipsesource.a.i
 * JD-Core Version:    0.7.0.1
 */