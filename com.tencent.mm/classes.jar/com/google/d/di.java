package com.google.d;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

public final class di
{
  private static final b dVx;
  private static final Logger logger = Logger.getLogger(di.class.getName());
  
  static
  {
    di.b.a locala = new di.b.a();
    dVx = new b(locala.dVy, locala.dVz, locala.dVA, locala.dVB, locala.dVC, (byte)0);
  }
  
  public static h F(CharSequence paramCharSequence)
  {
    paramCharSequence = h.dS(paramCharSequence.toString());
    byte[] arrayOfByte = new byte[paramCharSequence.size()];
    int j = 0;
    int m = 0;
    if (j < paramCharSequence.size())
    {
      byte b = paramCharSequence.jJ(j);
      int k;
      int n;
      int i;
      if (b == 92) {
        if (j + 1 < paramCharSequence.size())
        {
          k = j + 1;
          b = paramCharSequence.jJ(k);
          if (g(b))
          {
            n = i(b);
            i = n;
            j = k;
            if (k + 1 < paramCharSequence.size())
            {
              i = n;
              j = k;
              if (g(paramCharSequence.jJ(k + 1)))
              {
                j = k + 1;
                i = n * 8 + i(paramCharSequence.jJ(j));
              }
            }
            n = i;
            k = j;
            if (j + 1 < paramCharSequence.size())
            {
              n = i;
              k = j;
              if (g(paramCharSequence.jJ(j + 1)))
              {
                k = j + 1;
                n = i * 8 + i(paramCharSequence.jJ(k));
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
          if ((k + 1 < paramCharSequence.size()) && (h(paramCharSequence.jJ(k + 1))))
          {
            n = k + 1;
            k = i(paramCharSequence.jJ(n));
            i = k;
            j = n;
            if (n + 1 < paramCharSequence.size())
            {
              i = k;
              j = n;
              if (h(paramCharSequence.jJ(n + 1)))
              {
                j = n + 1;
                i = k * 16 + i(paramCharSequence.jJ(j));
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
      return h.A(arrayOfByte);
    }
    return h.o(arrayOfByte, 0, m);
  }
  
  public static String H(byte[] paramArrayOfByte)
  {
    return dj.a(new dj.2(paramArrayOfByte));
  }
  
  public static String X(dn paramdn)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      c.a(c.dVG, paramdn, a(localStringBuilder));
      paramdn = localStringBuilder.toString();
      return paramdn;
    }
    catch (IOException paramdn)
    {
      throw new IllegalStateException(paramdn);
    }
  }
  
  private static d a(Appendable paramAppendable)
  {
    return new d(paramAppendable, (byte)0);
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
          break label210;
        }
        l1 = Long.parseLong((String)localObject, j);
        if (k == 0) {
          break label372;
        }
        l1 = -l1;
      }
      label210:
      label366:
      label369:
      label372:
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
                break label366;
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
              break label369;
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
  
  public static String b(ch paramch)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      c.a(c.dVG, paramch, a(localStringBuilder));
      paramch = localStringBuilder.toString();
      return paramch;
    }
    catch (IOException paramch)
    {
      throw new IllegalStateException(paramch);
    }
  }
  
  public static String db(long paramLong)
  {
    if (paramLong >= 0L) {
      return Long.toString(paramLong);
    }
    return BigInteger.valueOf(0xFFFFFFFF & paramLong).setBit(63).toString();
  }
  
  public static String ee(String paramString)
  {
    return paramString.replace("\\", "\\\\").replace("\"", "\\\"");
  }
  
  static int ef(String paramString)
  {
    return (int)b(paramString, true, false);
  }
  
  static int eg(String paramString)
  {
    return (int)b(paramString, false, false);
  }
  
  static long eh(String paramString)
  {
    return b(paramString, true, true);
  }
  
  static long ei(String paramString)
  {
    return b(paramString, false, true);
  }
  
  public static String f(h paramh)
  {
    return dj.f(paramh);
  }
  
  private static boolean g(byte paramByte)
  {
    return (48 <= paramByte) && (paramByte <= 55);
  }
  
  private static boolean h(byte paramByte)
  {
    return ((48 <= paramByte) && (paramByte <= 57)) || ((97 <= paramByte) && (paramByte <= 102)) || ((65 <= paramByte) && (paramByte <= 70));
  }
  
  private static int i(byte paramByte)
  {
    if ((48 <= paramByte) && (paramByte <= 57)) {
      return paramByte - 48;
    }
    if ((97 <= paramByte) && (paramByte <= 122)) {
      return paramByte - 97 + 10;
    }
    return paramByte - 65 + 10;
  }
  
  public static String lw(int paramInt)
  {
    if (paramInt >= 0) {
      return Integer.toString(paramInt);
    }
    return Long.toString(paramInt & 0xFFFFFFFF);
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
    private final boolean dVA;
    private final di.b.b dVB;
    private dk.a dVC;
    private final boolean dVy;
    private final boolean dVz;
    
    private b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, di.b.b paramb, dk.a parama)
    {
      this.dVy = paramBoolean1;
      this.dVz = paramBoolean2;
      this.dVA = paramBoolean3;
      this.dVB = paramb;
      this.dVC = parama;
    }
    
    public static final class a
    {
      boolean dVA = false;
      di.b.b dVB = di.b.b.dVD;
      dk.a dVC = null;
      boolean dVy = false;
      boolean dVz = false;
    }
  }
  
  static final class c
  {
    static final c dVG = new c(true);
    static final c dVH = new c(false);
    private final boolean dVI;
    
    private c(boolean paramBoolean)
    {
      this.dVI = paramBoolean;
    }
    
    private static void a(int paramInt1, int paramInt2, List<?> paramList, di.d paramd)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        paramd.G(String.valueOf(paramInt1));
        paramd.G(": ");
        di.a(paramInt2, localObject, paramd);
        paramd.ajC();
      }
    }
    
    private void a(am.f paramf, Object paramObject, di.d paramd)
    {
      if (paramf.dOB.adB())
      {
        paramd.G("[");
        if ((paramf.dOe.dOc.abU().dNf) && (paramf.dOE == am.f.b.dPe) && (paramf.ahk()) && (paramf.ahp() == paramf.ahq()))
        {
          paramd.G(paramf.ahq().fullName);
          paramd.G("]");
          label77:
          if (paramf.dOE.dPm != am.f.a.dOR) {
            break label191;
          }
          paramd.G(" {");
          paramd.ajC();
          paramd.ajA();
        }
      }
      for (;;)
      {
        b(paramf, paramObject, paramd);
        if (paramf.dOE.dPm == am.f.a.dOR)
        {
          paramd.ajB();
          paramd.G("}");
        }
        paramd.ajC();
        return;
        paramd.G(paramf.fullName);
        break;
        if (paramf.dOE == am.f.b.dPd)
        {
          paramd.G(paramf.ahq().dOc.getName());
          break label77;
        }
        paramd.G(paramf.dOB.getName());
        break label77;
        label191:
        paramd.G(": ");
      }
    }
    
    private void a(ch paramch, di.d paramd)
    {
      Iterator localIterator = paramch.getAllFields().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        am.f localf = (am.f)((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        if (localf.ahl())
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
      a(paramch.getUnknownFields(), paramd);
    }
    
    private void a(dn paramdn, di.d paramd)
    {
      paramdn = paramdn.dVR.entrySet().iterator();
      while (paramdn.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramdn.next();
        int i = ((Integer)localEntry.getKey()).intValue();
        Object localObject = (dn.b)localEntry.getValue();
        a(i, 0, ((dn.b)localObject).dVX, paramd);
        a(i, 5, ((dn.b)localObject).dVY, paramd);
        a(i, 1, ((dn.b)localObject).dVZ, paramd);
        a(i, 2, ((dn.b)localObject).dWa, paramd);
        localObject = ((dn.b)localObject).dWb.iterator();
        while (((Iterator)localObject).hasNext())
        {
          dn localdn = (dn)((Iterator)localObject).next();
          paramd.G(((Integer)localEntry.getKey()).toString());
          paramd.G(" {");
          paramd.ajC();
          paramd.ajA();
          a(localdn, paramd);
          paramd.ajB();
          paramd.G("}");
          paramd.ajC();
        }
      }
    }
    
    private void b(am.f paramf, Object paramObject, di.d paramd)
    {
      switch (di.1.dJx[paramf.dOE.ordinal()])
      {
      default: 
        return;
      case 1: 
      case 2: 
      case 3: 
        paramd.G(((Integer)paramObject).toString());
        return;
      case 4: 
      case 5: 
      case 6: 
        paramd.G(((Long)paramObject).toString());
        return;
      case 7: 
        paramd.G(((Boolean)paramObject).toString());
        return;
      case 8: 
        paramd.G(((Float)paramObject).toString());
        return;
      case 9: 
        paramd.G(((Double)paramObject).toString());
        return;
      case 10: 
      case 11: 
        paramd.G(di.lw(((Integer)paramObject).intValue()));
        return;
      case 12: 
      case 13: 
        paramd.G(di.db(((Long)paramObject).longValue()));
        return;
      case 14: 
        paramd.G("\"");
        if (this.dVI) {}
        for (paramf = dj.f(h.dS((String)paramObject));; paramf = di.ee((String)paramObject).replace("\n", "\\n"))
        {
          paramd.G(paramf);
          paramd.G("\"");
          return;
        }
      case 15: 
        paramd.G("\"");
        if ((paramObject instanceof h)) {
          paramd.G(di.f((h)paramObject));
        }
        for (;;)
        {
          paramd.G("\"");
          return;
          paramd.G(di.H((byte[])paramObject));
        }
      case 16: 
        paramd.G(((am.e)paramObject).dOy.getName());
        return;
      }
      a((cb)paramObject, paramd);
    }
  }
  
  static final class d
  {
    private final Appendable dVJ;
    private final StringBuilder dVK = new StringBuilder();
    private final boolean dVL;
    private boolean dVM = false;
    
    private d(Appendable paramAppendable)
    {
      this.dVJ = paramAppendable;
      this.dVL = false;
    }
    
    public final void G(CharSequence paramCharSequence)
    {
      Appendable localAppendable;
      if (this.dVM)
      {
        this.dVM = false;
        localAppendable = this.dVJ;
        if (!this.dVL) {
          break label50;
        }
      }
      label50:
      for (Object localObject = " ";; localObject = this.dVK)
      {
        localAppendable.append((CharSequence)localObject);
        this.dVJ.append(paramCharSequence);
        return;
      }
    }
    
    public final void ajA()
    {
      this.dVK.append("  ");
    }
    
    public final void ajB()
    {
      int i = this.dVK.length();
      if (i == 0) {
        throw new IllegalArgumentException(" Outdent() without matching Indent().");
      }
      this.dVK.setLength(i - 2);
    }
    
    public final void ajC()
    {
      if (!this.dVL) {
        this.dVJ.append("\n");
      }
      this.dVM = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.di
 * JD-Core Version:    0.7.0.1
 */