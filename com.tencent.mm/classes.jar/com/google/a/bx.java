package com.google.a;

import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Logger;

public final class bx
{
  private static final b bZt;
  private static final Logger logger = Logger.getLogger(bx.class.getName());
  
  static
  {
    bx.b.a locala = new bx.b.a();
    bZt = new b(locala.bZu, locala.bZv, locala.bZw, locala.bZx, locala.bZy, (byte)0);
  }
  
  public static String H(byte[] paramArrayOfByte)
  {
    return by.a(new by.2(paramArrayOfByte));
  }
  
  public static String a(az paramaz)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      bx.c.a(bx.c.bZC, paramaz, b(localStringBuilder));
      paramaz = localStringBuilder.toString();
      return paramaz;
    }
    catch (IOException paramaz)
    {
      throw new IllegalStateException(paramaz);
    }
  }
  
  public static String aG(long paramLong)
  {
    if (paramLong >= 0L) {
      return Long.toString(paramLong);
    }
    return BigInteger.valueOf(0xFFFFFFFF & paramLong).setBit(63).toString();
  }
  
  public static String ab(cc paramcc)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      bx.c.a(bx.c.bZC, paramcc, b(localStringBuilder));
      paramcc = localStringBuilder.toString();
      return paramcc;
    }
    catch (IOException paramcc)
    {
      throw new IllegalStateException(paramcc);
    }
  }
  
  private static long b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k;
    if (paramString.startsWith("-", 0))
    {
      if (!paramBoolean1) {
        throw new NumberFormatException("Number must be positive: ".concat(String.valueOf(paramString)));
      }
      k = 1;
    }
    for (int i = 1;; i = 0)
    {
      int j = 10;
      int m;
      Object localObject;
      long l1;
      if (paramString.startsWith("0x", i))
      {
        m = i + 2;
        j = 16;
        localObject = paramString.substring(m);
        if (((String)localObject).length() >= 16) {
          break label207;
        }
        l1 = Long.parseLong((String)localObject, j);
        if (k == 0) {
          break label365;
        }
        l1 = -l1;
      }
      label207:
      label359:
      label362:
      label365:
      for (;;)
      {
        long l2 = l1;
        if (!paramBoolean2)
        {
          if (paramBoolean1)
          {
            if (l1 <= 2147483647L)
            {
              l2 = l1;
              if (l1 >= -2147483648L) {
                break label359;
              }
            }
            throw new NumberFormatException("Number out of range for 32-bit signed integer: ".concat(String.valueOf(paramString)));
            m = i;
            if (!paramString.startsWith("0", i)) {
              break;
            }
            j = 8;
            m = i;
            break;
          }
          if (l1 < 4294967296L)
          {
            l2 = l1;
            if (l1 >= 0L) {}
          }
          else
          {
            throw new NumberFormatException("Number out of range for 32-bit unsigned integer: ".concat(String.valueOf(paramString)));
            localObject = new BigInteger((String)localObject, j);
            if (k == 0) {
              break label362;
            }
            localObject = ((BigInteger)localObject).negate();
          }
        }
        for (;;)
        {
          if (!paramBoolean2)
          {
            if (paramBoolean1)
            {
              if (((BigInteger)localObject).bitLength() > 31) {
                throw new NumberFormatException("Number out of range for 32-bit signed integer: ".concat(String.valueOf(paramString)));
              }
            }
            else if (((BigInteger)localObject).bitLength() > 32) {
              throw new NumberFormatException("Number out of range for 32-bit unsigned integer: ".concat(String.valueOf(paramString)));
            }
          }
          else if (paramBoolean1)
          {
            if (((BigInteger)localObject).bitLength() > 63) {
              throw new NumberFormatException("Number out of range for 64-bit signed integer: ".concat(String.valueOf(paramString)));
            }
          }
          else if (((BigInteger)localObject).bitLength() > 64) {
            throw new NumberFormatException("Number out of range for 64-bit unsigned integer: ".concat(String.valueOf(paramString)));
          }
          l2 = ((BigInteger)localObject).longValue();
          return l2;
        }
      }
      k = 0;
    }
  }
  
  private static d b(Appendable paramAppendable)
  {
    return new d(paramAppendable, (byte)0);
  }
  
  public static String cl(String paramString)
  {
    return paramString.replace("\\", "\\\\").replace("\"", "\\\"");
  }
  
  static int cm(String paramString)
  {
    return (int)b(paramString, true, false);
  }
  
  static int cn(String paramString)
  {
    return (int)b(paramString, false, false);
  }
  
  static long co(String paramString)
  {
    return b(paramString, true, true);
  }
  
  static long cp(String paramString)
  {
    return b(paramString, false, true);
  }
  
  public static String e(g paramg)
  {
    return by.e(paramg);
  }
  
  private static boolean e(byte paramByte)
  {
    return (48 <= paramByte) && (paramByte <= 55);
  }
  
  private static boolean f(byte paramByte)
  {
    return ((48 <= paramByte) && (paramByte <= 57)) || ((97 <= paramByte) && (paramByte <= 102)) || ((65 <= paramByte) && (paramByte <= 70));
  }
  
  private static int g(byte paramByte)
  {
    if ((48 <= paramByte) && (paramByte <= 57)) {
      return paramByte - 48;
    }
    if ((97 <= paramByte) && (paramByte <= 122)) {
      return paramByte - 97 + 10;
    }
    return paramByte - 65 + 10;
  }
  
  public static String gP(int paramInt)
  {
    if (paramInt >= 0) {
      return Integer.toString(paramInt);
    }
    return Long.toString(paramInt & 0xFFFFFFFF);
  }
  
  public static g t(CharSequence paramCharSequence)
  {
    paramCharSequence = g.bZ(paramCharSequence.toString());
    byte[] arrayOfByte = new byte[paramCharSequence.size()];
    int j = 0;
    int m = 0;
    if (j < paramCharSequence.size())
    {
      byte b = paramCharSequence.fB(j);
      int k;
      int n;
      int i;
      if (b == 92) {
        if (j + 1 < paramCharSequence.size())
        {
          k = j + 1;
          b = paramCharSequence.fB(k);
          if (e(b))
          {
            n = g(b);
            i = n;
            j = k;
            if (k + 1 < paramCharSequence.size())
            {
              i = n;
              j = k;
              if (e(paramCharSequence.fB(k + 1)))
              {
                j = k + 1;
                i = n * 8 + g(paramCharSequence.fB(j));
              }
            }
            n = i;
            k = j;
            if (j + 1 < paramCharSequence.size())
            {
              n = i;
              k = j;
              if (e(paramCharSequence.fB(j + 1)))
              {
                k = j + 1;
                n = i * 8 + g(paramCharSequence.fB(k));
              }
            }
            arrayOfByte[m] = ((byte)n);
            i = m + 1;
            j = k;
          }
        }
      }
      for (;;)
      {
        j += 1;
        m = i;
        break;
        switch (b)
        {
        default: 
          throw new a("Invalid escape sequence: '\\" + (char)b + '\'');
        case 97: 
          arrayOfByte[m] = 7;
          i = m + 1;
          j = k;
          break;
        case 98: 
          arrayOfByte[m] = 8;
          i = m + 1;
          j = k;
          break;
        case 102: 
          arrayOfByte[m] = 12;
          i = m + 1;
          j = k;
          break;
        case 110: 
          arrayOfByte[m] = 10;
          i = m + 1;
          j = k;
          break;
        case 114: 
          arrayOfByte[m] = 13;
          i = m + 1;
          j = k;
          break;
        case 116: 
          arrayOfByte[m] = 9;
          i = m + 1;
          j = k;
          break;
        case 118: 
          arrayOfByte[m] = 11;
          i = m + 1;
          j = k;
          break;
        case 92: 
          arrayOfByte[m] = 92;
          i = m + 1;
          j = k;
          break;
        case 39: 
          arrayOfByte[m] = 39;
          i = m + 1;
          j = k;
          break;
        case 34: 
          arrayOfByte[m] = 34;
          i = m + 1;
          j = k;
          break;
        case 120: 
          if ((k + 1 < paramCharSequence.size()) && (f(paramCharSequence.fB(k + 1))))
          {
            n = k + 1;
            k = g(paramCharSequence.fB(n));
            i = k;
            j = n;
            if (n + 1 < paramCharSequence.size())
            {
              i = k;
              j = n;
              if (f(paramCharSequence.fB(n + 1)))
              {
                j = n + 1;
                i = k * 16 + g(paramCharSequence.fB(j));
              }
            }
            arrayOfByte[m] = ((byte)i);
            i = m + 1;
          }
          else
          {
            throw new a("Invalid escape sequence: '\\x' with no digits");
            throw new a("Invalid escape sequence: '\\' at end of string.");
            arrayOfByte[m] = b;
            i = m + 1;
          }
          break;
        }
      }
    }
    if (arrayOfByte.length == m) {
      return g.A(arrayOfByte);
    }
    return g.p(arrayOfByte, 0, m);
  }
  
  public static final class a
    extends IOException
  {
    a(String paramString)
    {
      super();
    }
  }
  
  public static final class b
  {
    private final boolean bZu;
    private final boolean bZv;
    private final boolean bZw;
    private final bx.b.b bZx;
    private bz.a bZy;
    
    private b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, bx.b.b paramb, bz.a parama)
    {
      this.bZu = paramBoolean1;
      this.bZv = paramBoolean2;
      this.bZw = paramBoolean3;
      this.bZx = paramb;
      this.bZy = parama;
    }
    
    public static final class a
    {
      boolean bZu = false;
      boolean bZv = false;
      boolean bZw = false;
      bx.b.b bZx = bx.b.b.bZz;
      bz.a bZy = null;
    }
  }
  
  static final class d
  {
    private final Appendable bZF;
    private final StringBuilder bZG = new StringBuilder();
    private final boolean bZH;
    private boolean bZI = false;
    
    private d(Appendable paramAppendable)
    {
      this.bZF = paramAppendable;
      this.bZH = false;
    }
    
    public final void HG()
    {
      this.bZG.append("  ");
    }
    
    public final void HH()
    {
      int i = this.bZG.length();
      if (i == 0) {
        throw new IllegalArgumentException(" Outdent() without matching Indent().");
      }
      this.bZG.setLength(i - 2);
    }
    
    public final void HI()
    {
      if (!this.bZH) {
        this.bZF.append("\n");
      }
      this.bZI = true;
    }
    
    public final void u(CharSequence paramCharSequence)
    {
      Appendable localAppendable;
      if (this.bZI)
      {
        this.bZI = false;
        localAppendable = this.bZF;
        if (!this.bZH) {
          break label50;
        }
      }
      label50:
      for (Object localObject = " ";; localObject = this.bZG)
      {
        localAppendable.append((CharSequence)localObject);
        this.bZF.append(paramCharSequence);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.bx
 * JD-Core Version:    0.7.0.1
 */