package com.google.d;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class db
  extends h
{
  static final int[] dUI = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, 2147483647 };
  private final int dUJ;
  private final h dUK;
  private final h dUL;
  private final int dUM;
  final int dUN;
  
  private db(h paramh1, h paramh2)
  {
    this.dUK = paramh1;
    this.dUL = paramh2;
    this.dUM = paramh1.size();
    this.dUJ = (this.dUM + paramh2.size());
    this.dUN = (Math.max(paramh1.ZY(), paramh2.ZY()) + 1);
  }
  
  protected final int Q(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 + paramInt3 <= this.dUM) {
      return this.dUK.Q(paramInt1, paramInt2, paramInt3);
    }
    if (paramInt2 >= this.dUM) {
      return this.dUL.Q(paramInt1, paramInt2 - this.dUM, paramInt3);
    }
    int i = this.dUM - paramInt2;
    paramInt1 = this.dUK.Q(paramInt1, paramInt2, i);
    return this.dUL.Q(paramInt1, 0, paramInt3 - i);
  }
  
  protected final int R(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 + paramInt3 <= this.dUM) {
      return this.dUK.R(paramInt1, paramInt2, paramInt3);
    }
    if (paramInt2 >= this.dUM) {
      return this.dUL.R(paramInt1, paramInt2 - this.dUM, paramInt3);
    }
    int i = this.dUM - paramInt2;
    paramInt1 = this.dUK.R(paramInt1, paramInt2, i);
    return this.dUL.R(paramInt1, 0, paramInt3 - i);
  }
  
  public final h.e ZT()
  {
    new h.a()
    {
      final db.a dUO = new db.a(db.this, (byte)0);
      h.e dUP = ajd();
      
      private h.e ajd()
      {
        if (this.dUO.hasNext()) {
          return this.dUO.ajf().ZT();
        }
        return null;
      }
      
      public final boolean hasNext()
      {
        return this.dUP != null;
      }
      
      public final byte nextByte()
      {
        if (this.dUP == null) {
          throw new NoSuchElementException();
        }
        byte b = this.dUP.nextByte();
        if (!this.dUP.hasNext()) {
          this.dUP = ajd();
        }
        return b;
      }
    };
  }
  
  public final ByteBuffer ZU()
  {
    return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
  }
  
  public final boolean ZW()
  {
    boolean bool = false;
    int i = this.dUK.Q(0, 0, this.dUM);
    if (this.dUL.Q(i, 0, this.dUL.size()) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public final i ZX()
  {
    return i.u(new b());
  }
  
  protected final int ZY()
  {
    return this.dUN;
  }
  
  protected final String a(Charset paramCharset)
  {
    return new String(toByteArray(), paramCharset);
  }
  
  final void a(g paramg)
  {
    this.dUK.a(paramg);
    this.dUL.a(paramg);
  }
  
  protected final void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 + paramInt3 <= this.dUM)
    {
      this.dUK.c(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      return;
    }
    if (paramInt1 >= this.dUM)
    {
      this.dUL.c(paramArrayOfByte, paramInt1 - this.dUM, paramInt2, paramInt3);
      return;
    }
    int i = this.dUM - paramInt1;
    this.dUK.c(paramArrayOfByte, paramInt1, paramInt2, i);
    this.dUL.c(paramArrayOfByte, 0, paramInt2 + i, paramInt3 - i);
  }
  
  public final h cC(int paramInt1, int paramInt2)
  {
    int i = S(paramInt1, paramInt2, this.dUJ);
    if (i == 0) {
      localObject = h.dIJ;
    }
    do
    {
      return localObject;
      localObject = this;
    } while (i == this.dUJ);
    if (paramInt2 <= this.dUM) {
      return this.dUK.cC(paramInt1, paramInt2);
    }
    if (paramInt1 >= this.dUM) {
      return this.dUL.cC(paramInt1 - this.dUM, paramInt2 - this.dUM);
    }
    Object localObject = this.dUK;
    return new db(((h)localObject).cC(paramInt1, ((h)localObject).size()), this.dUL.cC(0, paramInt2 - this.dUM));
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool3 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool3;
        } while (!(paramObject instanceof h));
        paramObject = (h)paramObject;
        bool1 = bool3;
      } while (this.dUJ != paramObject.size());
      if (this.dUJ == 0) {
        return true;
      }
      i = ZZ();
      j = paramObject.ZZ();
      if ((i == 0) || (j == 0)) {
        break;
      }
      bool1 = bool3;
    } while (i != j);
    a locala1 = new a(this, (byte)0);
    h.g localg = (h.g)locala1.next();
    a locala2 = new a(paramObject, (byte)0);
    paramObject = (h.g)locala2.next();
    int k = 0;
    int i = 0;
    int j = 0;
    for (;;)
    {
      int i1 = localg.size() - j;
      int n = paramObject.size() - i;
      int m = Math.min(i1, n);
      if (j == 0) {}
      for (boolean bool2 = localg.a(paramObject, i, m);; bool2 = paramObject.a(localg, j, m))
      {
        bool1 = bool3;
        if (!bool2) {
          break;
        }
        k += m;
        if (k < this.dUJ) {
          break label232;
        }
        if (k != this.dUJ) {
          break label224;
        }
        return true;
      }
      label224:
      throw new IllegalStateException();
      label232:
      if (m == i1)
      {
        localg = (h.g)locala1.next();
        j = 0;
      }
      for (;;)
      {
        if (m != n) {
          break label284;
        }
        paramObject = (h.g)locala2.next();
        i = 0;
        break;
        j += m;
      }
      label284:
      i += m;
    }
  }
  
  public final byte jJ(int paramInt)
  {
    cD(paramInt, this.dUJ);
    return jK(paramInt);
  }
  
  final byte jK(int paramInt)
  {
    if (paramInt < this.dUM) {
      return this.dUK.jK(paramInt);
    }
    return this.dUL.jK(paramInt - this.dUM);
  }
  
  public final int size()
  {
    return this.dUJ;
  }
  
  static final class a
    implements Iterator<h.g>
  {
    private final ArrayDeque<db> dUR;
    private h.g dUS;
    
    private a(h paramh)
    {
      if ((paramh instanceof db))
      {
        paramh = (db)paramh;
        this.dUR = new ArrayDeque(paramh.dUN);
        this.dUR.push(paramh);
        this.dUS = e(db.a(paramh));
        return;
      }
      this.dUR = null;
      this.dUS = ((h.g)paramh);
    }
    
    private h.g aje()
    {
      h.g localg;
      do
      {
        if ((this.dUR == null) || (this.dUR.isEmpty())) {
          return null;
        }
        localg = e(db.b((db)this.dUR.pop()));
      } while (localg.isEmpty());
      return localg;
    }
    
    private h.g e(h paramh)
    {
      while ((paramh instanceof db))
      {
        paramh = (db)paramh;
        this.dUR.push(paramh);
        paramh = db.a(paramh);
      }
      return (h.g)paramh;
    }
    
    public final h.g ajf()
    {
      if (this.dUS == null) {
        throw new NoSuchElementException();
      }
      h.g localg = this.dUS;
      this.dUS = aje();
      return localg;
    }
    
    public final boolean hasNext()
    {
      return this.dUS != null;
    }
    
    public final void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  final class b
    extends InputStream
  {
    private db.a dUT;
    private h.g dUU;
    private int dUV;
    private int dUW;
    private int dUX;
    private int dUY;
    
    public b()
    {
      initialize();
    }
    
    private void ajg()
    {
      if ((this.dUU != null) && (this.dUW == this.dUV))
      {
        this.dUX += this.dUV;
        this.dUW = 0;
        if (this.dUT.hasNext())
        {
          this.dUU = this.dUT.ajf();
          this.dUV = this.dUU.size();
        }
      }
      else
      {
        return;
      }
      this.dUU = null;
      this.dUV = 0;
    }
    
    private void initialize()
    {
      this.dUT = new db.a(db.this, (byte)0);
      this.dUU = this.dUT.ajf();
      this.dUV = this.dUU.size();
      this.dUW = 0;
      this.dUX = 0;
    }
    
    private int s(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int i = paramInt2;
      int j = paramInt1;
      paramInt1 = i;
      for (i = j; paramInt1 > 0; i = j)
      {
        ajg();
        if (this.dUU == null)
        {
          if (paramInt1 != paramInt2) {
            break;
          }
          return -1;
        }
        int k = Math.min(this.dUV - this.dUW, paramInt1);
        j = i;
        if (paramArrayOfByte != null)
        {
          this.dUU.b(paramArrayOfByte, this.dUW, i, k);
          j = i + k;
        }
        this.dUW += k;
        paramInt1 -= k;
      }
      return paramInt2 - paramInt1;
    }
    
    public final int available()
    {
      int i = this.dUX;
      int j = this.dUW;
      return db.this.size() - (i + j);
    }
    
    public final void mark(int paramInt)
    {
      this.dUY = (this.dUX + this.dUW);
    }
    
    public final boolean markSupported()
    {
      return true;
    }
    
    public final int read()
    {
      ajg();
      if (this.dUU == null) {
        return -1;
      }
      h.g localg = this.dUU;
      int i = this.dUW;
      this.dUW = (i + 1);
      return localg.jJ(i) & 0xFF;
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (paramArrayOfByte == null) {
        throw new NullPointerException();
      }
      if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1)) {
        throw new IndexOutOfBoundsException();
      }
      return s(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void reset()
    {
      try
      {
        initialize();
        s(null, 0, this.dUY);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final long skip(long paramLong)
    {
      if (paramLong < 0L) {
        throw new IndexOutOfBoundsException();
      }
      long l = paramLong;
      if (paramLong > 2147483647L) {
        l = 2147483647L;
      }
      return s(null, 0, (int)l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.db
 * JD-Core Version:    0.7.0.1
 */