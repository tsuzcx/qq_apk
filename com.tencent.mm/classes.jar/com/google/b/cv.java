package com.google.b;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

public final class cv
{
  private static final b caW;
  private static final Logger logger = Logger.getLogger(cv.class.getName());
  
  static
  {
    cv.b.a locala = new cv.b.a();
    caW = new b(locala.caX, locala.caY, locala.caZ, locala.cba, locala.cbb, (byte)0);
  }
  
  public static String F(byte[] paramArrayOfByte)
  {
    return cw.a(new cw.2(paramArrayOfByte));
  }
  
  private static d a(Appendable paramAppendable)
  {
    return new d(paramAppendable, (byte)0);
  }
  
  public static String a(bz parambz)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      c.a(c.cbf, parambz, a(localStringBuilder));
      parambz = localStringBuilder.toString();
      return parambz;
    }
    catch (IOException parambz)
    {
      throw new IllegalStateException(parambz);
    }
  }
  
  public static String aK(long paramLong)
  {
    if (paramLong >= 0L) {
      return Long.toString(paramLong);
    }
    return BigInteger.valueOf(0xFFFFFFFF & paramLong).setBit(63).toString();
  }
  
  public static String ab(da paramda)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      c.a(c.cbf, paramda, a(localStringBuilder));
      paramda = localStringBuilder.toString();
      return paramda;
    }
    catch (IOException paramda)
    {
      throw new IllegalStateException(paramda);
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
          break label367;
        }
        l1 = -l1;
      }
      label207:
      label361:
      label364:
      label367:
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
                break label361;
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
              break label364;
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
  
  public static String cF(String paramString)
  {
    return paramString.replace("\\", "\\\\").replace("\"", "\\\"");
  }
  
  static int cG(String paramString)
  {
    return (int)b(paramString, true, false);
  }
  
  static int cH(String paramString)
  {
    return (int)b(paramString, false, false);
  }
  
  static long cI(String paramString)
  {
    return b(paramString, true, true);
  }
  
  static long cJ(String paramString)
  {
    return b(paramString, false, true);
  }
  
  public static String e(g paramg)
  {
    return cw.e(paramg);
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
  
  public static String hG(int paramInt)
  {
    if (paramInt >= 0) {
      return Integer.toString(paramInt);
    }
    return Long.toString(paramInt & 0xFFFFFFFF);
  }
  
  public static g z(CharSequence paramCharSequence)
  {
    paramCharSequence = g.ct(paramCharSequence.toString());
    byte[] arrayOfByte = new byte[paramCharSequence.size()];
    int j = 0;
    int m = 0;
    if (j < paramCharSequence.size())
    {
      byte b = paramCharSequence.gu(j);
      int k;
      int n;
      int i;
      if (b == 92) {
        if (j + 1 < paramCharSequence.size())
        {
          k = j + 1;
          b = paramCharSequence.gu(k);
          if (e(b))
          {
            n = g(b);
            i = n;
            j = k;
            if (k + 1 < paramCharSequence.size())
            {
              i = n;
              j = k;
              if (e(paramCharSequence.gu(k + 1)))
              {
                j = k + 1;
                i = n * 8 + g(paramCharSequence.gu(j));
              }
            }
            n = i;
            k = j;
            if (j + 1 < paramCharSequence.size())
            {
              n = i;
              k = j;
              if (e(paramCharSequence.gu(j + 1)))
              {
                k = j + 1;
                n = i * 8 + g(paramCharSequence.gu(k));
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
          if ((k + 1 < paramCharSequence.size()) && (f(paramCharSequence.gu(k + 1))))
          {
            n = k + 1;
            k = g(paramCharSequence.gu(n));
            i = k;
            j = n;
            if (n + 1 < paramCharSequence.size())
            {
              i = k;
              j = n;
              if (f(paramCharSequence.gu(n + 1)))
              {
                j = n + 1;
                i = k * 16 + g(paramCharSequence.gu(j));
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
      return g.y(arrayOfByte);
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
    private final boolean caX;
    private final boolean caY;
    private final boolean caZ;
    private final cv.b.b cba;
    private cx.a cbb;
    
    private b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, cv.b.b paramb, cx.a parama)
    {
      this.caX = paramBoolean1;
      this.caY = paramBoolean2;
      this.caZ = paramBoolean3;
      this.cba = paramb;
      this.cbb = parama;
    }
    
    public static final class a
    {
      boolean caX = false;
      boolean caY = false;
      boolean caZ = false;
      cv.b.b cba = cv.b.b.cbc;
      cx.a cbb = null;
    }
  }
  
  static final class c
  {
    static final c cbf = new c(true);
    static final c cbg = new c(false);
    private final boolean cbh;
    
    private c(boolean paramBoolean)
    {
      this.cbh = paramBoolean;
    }
    
    private static void a(int paramInt1, int paramInt2, List<?> paramList, cv.d paramd)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        paramd.A(String.valueOf(paramInt1));
        paramd.A(": ");
        cv.a(paramInt2, localObject, paramd);
        paramd.Ji();
      }
    }
    
    private void a(aj.f paramf, Object paramObject, cv.d paramd)
    {
      if (paramf.bUO.DU())
      {
        paramd.A("[");
        if ((paramf.bUr.bUp.Ck().bTs) && (paramf.bUR == aj.f.b.bVr) && (paramf.Ho()) && (paramf.Ht() == paramf.Hu()))
        {
          paramd.A(paramf.Hu().fullName);
          paramd.A("]");
          label77:
          if (paramf.bUR.bVz != aj.f.a.bVe) {
            break label191;
          }
          paramd.A(" {");
          paramd.Ji();
          paramd.Jg();
        }
      }
      for (;;)
      {
        b(paramf, paramObject, paramd);
        if (paramf.bUR.bVz == aj.f.a.bVe)
        {
          paramd.Jh();
          paramd.A("}");
        }
        paramd.Ji();
        return;
        paramd.A(paramf.fullName);
        break;
        if (paramf.bUR == aj.f.b.bVq)
        {
          paramd.A(paramf.Hu().bUp.getName());
          break label77;
        }
        paramd.A(paramf.bUO.getName());
        break label77;
        label191:
        paramd.A(": ");
      }
    }
    
    private void a(bz parambz, cv.d paramd)
    {
      Iterator localIterator = parambz.Hz().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        aj.f localf = (aj.f)((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        if (localf.Hp())
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            a(localf, ((Iterator)localObject).next(), paramd);
          }
        }
        else
        {
          a(localf, localObject, paramd);
        }
      }
      a(parambz.Ca(), paramd);
    }
    
    private void a(da paramda, cv.d paramd)
    {
      paramda = paramda.cbq.entrySet().iterator();
      while (paramda.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramda.next();
        int i = ((Integer)localEntry.getKey()).intValue();
        Object localObject = (da.b)localEntry.getValue();
        a(i, 0, ((da.b)localObject).cbw, paramd);
        a(i, 5, ((da.b)localObject).cbx, paramd);
        a(i, 1, ((da.b)localObject).cby, paramd);
        a(i, 2, ((da.b)localObject).cbz, paramd);
        localObject = ((da.b)localObject).cbA.iterator();
        while (((Iterator)localObject).hasNext())
        {
          da localda = (da)((Iterator)localObject).next();
          paramd.A(((Integer)localEntry.getKey()).toString());
          paramd.A(" {");
          paramd.Ji();
          paramd.Jg();
          a(localda, paramd);
          paramd.Jh();
          paramd.A("}");
          paramd.Ji();
        }
      }
    }
    
    private void b(aj.f paramf, Object paramObject, cv.d paramd)
    {
      switch (cv.1.bPF[paramf.bUR.ordinal()])
      {
      default: 
        return;
      case 1: 
      case 2: 
      case 3: 
        paramd.A(((Integer)paramObject).toString());
        return;
      case 4: 
      case 5: 
      case 6: 
        paramd.A(((Long)paramObject).toString());
        return;
      case 7: 
        paramd.A(((Boolean)paramObject).toString());
        return;
      case 8: 
        paramd.A(((Float)paramObject).toString());
        return;
      case 9: 
        paramd.A(((Double)paramObject).toString());
        return;
      case 10: 
      case 11: 
        paramd.A(cv.hG(((Integer)paramObject).intValue()));
        return;
      case 12: 
      case 13: 
        paramd.A(cv.aK(((Long)paramObject).longValue()));
        return;
      case 14: 
        paramd.A("\"");
        if (this.cbh) {}
        for (paramf = cw.e(g.ct((String)paramObject));; paramf = cv.cF((String)paramObject).replace("\n", "\\n"))
        {
          paramd.A(paramf);
          paramd.A("\"");
          return;
        }
      case 15: 
        paramd.A("\"");
        if ((paramObject instanceof g)) {
          paramd.A(cv.e((g)paramObject));
        }
        for (;;)
        {
          paramd.A("\"");
          return;
          paramd.A(cv.F((byte[])paramObject));
        }
      case 16: 
        paramd.A(((aj.e)paramObject).bUL.getName());
        return;
      }
      a((bt)paramObject, paramd);
    }
  }
  
  static final class d
  {
    private final Appendable cbi;
    private final StringBuilder cbj = new StringBuilder();
    private final boolean cbk;
    private boolean cbl = false;
    
    private d(Appendable paramAppendable)
    {
      this.cbi = paramAppendable;
      this.cbk = false;
    }
    
    public final void A(CharSequence paramCharSequence)
    {
      Appendable localAppendable;
      if (this.cbl)
      {
        this.cbl = false;
        localAppendable = this.cbi;
        if (!this.cbk) {
          break label50;
        }
      }
      label50:
      for (Object localObject = " ";; localObject = this.cbj)
      {
        localAppendable.append((CharSequence)localObject);
        this.cbi.append(paramCharSequence);
        return;
      }
    }
    
    public final void Jg()
    {
      this.cbj.append("  ");
    }
    
    public final void Jh()
    {
      int i = this.cbj.length();
      if (i == 0) {
        throw new IllegalArgumentException(" Outdent() without matching Indent().");
      }
      this.cbj.setLength(i - 2);
    }
    
    public final void Ji()
    {
      if (!this.cbk) {
        this.cbi.append("\n");
      }
      this.cbl = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.cv
 * JD-Core Version:    0.7.0.1
 */