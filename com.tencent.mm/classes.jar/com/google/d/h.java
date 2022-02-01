package com.google.d;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class h
  implements Serializable, Iterable<Byte>
{
  public static final h dIJ = new h(bj.EMPTY_BYTE_ARRAY);
  private static final h.d dIK;
  private static final Comparator<h> dIM;
  private int dIL = 0;
  
  static
  {
    if (e.ZR()) {}
    for (Object localObject = new h.i((byte)0);; localObject = new h.b((byte)0))
    {
      dIK = (h.d)localObject;
      dIM = new Comparator() {};
      return;
    }
  }
  
  static h A(byte[] paramArrayOfByte)
  {
    return new h(paramArrayOfByte);
  }
  
  static int S(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - paramInt1;
    if ((paramInt1 | paramInt2 | i | paramInt3 - paramInt2) < 0)
    {
      if (paramInt1 < 0) {
        throw new IndexOutOfBoundsException("Beginning index: " + paramInt1 + " < 0");
      }
      if (paramInt2 < paramInt1) {
        throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + paramInt1 + ", " + paramInt2);
      }
      throw new IndexOutOfBoundsException("End index: " + paramInt2 + " >= " + paramInt3);
    }
    return i;
  }
  
  static void cD(int paramInt1, int paramInt2)
  {
    if ((paramInt2 - (paramInt1 + 1) | paramInt1) < 0)
    {
      if (paramInt1 < 0) {
        throw new ArrayIndexOutOfBoundsException("Index < 0: ".concat(String.valueOf(paramInt1)));
      }
      throw new ArrayIndexOutOfBoundsException("Index > length: " + paramInt1 + ", " + paramInt2);
    }
  }
  
  public static h dS(String paramString)
  {
    return new h(paramString.getBytes(bj.UTF_8));
  }
  
  static h h(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasArray())
    {
      int i = paramByteBuffer.arrayOffset();
      return p(paramByteBuffer.array(), i + paramByteBuffer.position(), paramByteBuffer.remaining());
    }
    return new cq(paramByteBuffer);
  }
  
  static f jL(int paramInt)
  {
    return new f(paramInt, (byte)0);
  }
  
  public static h o(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    S(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    return new h(dIK.q(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  static h p(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new c(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static h z(byte[] paramArrayOfByte)
  {
    return o(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  protected abstract int Q(int paramInt1, int paramInt2, int paramInt3);
  
  protected abstract int R(int paramInt1, int paramInt2, int paramInt3);
  
  public e ZT()
  {
    new a()
    {
      private final int limit = h.this.size();
      private int position = 0;
      
      public final boolean hasNext()
      {
        return this.position < this.limit;
      }
      
      public final byte nextByte()
      {
        int i = this.position;
        if (i >= this.limit) {
          throw new NoSuchElementException();
        }
        this.position = (i + 1);
        return h.this.jK(i);
      }
    };
  }
  
  public abstract ByteBuffer ZU();
  
  public final String ZV()
  {
    Charset localCharset = bj.UTF_8;
    if (size() == 0) {
      return "";
    }
    return a(localCharset);
  }
  
  public abstract boolean ZW();
  
  public abstract i ZX();
  
  protected abstract int ZY();
  
  protected final int ZZ()
  {
    return this.dIL;
  }
  
  protected abstract String a(Charset paramCharset);
  
  abstract void a(g paramg);
  
  @Deprecated
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    S(paramInt1, paramInt1 + paramInt3, size());
    S(paramInt2, paramInt2 + paramInt3, paramArrayOfByte.length);
    if (paramInt3 > 0) {
      c(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    }
  }
  
  protected abstract void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract h cC(int paramInt1, int paramInt2);
  
  public abstract boolean equals(Object paramObject);
  
  public final int hashCode()
  {
    int j = this.dIL;
    int i = j;
    if (j == 0)
    {
      i = size();
      j = R(i, 0, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.dIL = i;
    }
    return i;
  }
  
  public final boolean isEmpty()
  {
    return size() == 0;
  }
  
  public abstract byte jJ(int paramInt);
  
  abstract byte jK(int paramInt);
  
  public abstract int size();
  
  public final byte[] toByteArray()
  {
    int i = size();
    if (i == 0) {
      return bj.EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte = new byte[i];
    c(arrayOfByte, 0, 0, i);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
  
  static abstract class a
    implements h.e
  {
    public final void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  static final class c
    extends h.h
  {
    private final int dIO;
    private final int dIP;
    
    c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      super();
      S(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
      this.dIO = paramInt1;
      this.dIP = paramInt2;
    }
    
    protected final int aaa()
    {
      return this.dIO;
    }
    
    protected final void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    {
      System.arraycopy(this.Op, this.dIO + paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    }
    
    public final byte jJ(int paramInt)
    {
      cD(paramInt, this.dIP);
      return this.Op[(this.dIO + paramInt)];
    }
    
    final byte jK(int paramInt)
    {
      return this.Op[(this.dIO + paramInt)];
    }
    
    public final int size()
    {
      return this.dIP;
    }
  }
  
  public static abstract interface e
    extends Iterator<Byte>
  {
    public abstract byte nextByte();
  }
  
  static final class f
  {
    private final byte[] buffer;
    final k dIQ;
    
    private f(int paramInt)
    {
      this.buffer = new byte[paramInt];
      this.dIQ = k.C(this.buffer);
    }
    
    public final h aab()
    {
      this.dIQ.aaN();
      return new h.h(this.buffer);
    }
  }
  
  static abstract class g
    extends h
  {
    protected final int ZY()
    {
      return 0;
    }
    
    abstract boolean a(h paramh, int paramInt1, int paramInt2);
  }
  
  static class h
    extends h.g
  {
    protected final byte[] Op;
    
    h(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null) {
        throw new NullPointerException();
      }
      this.Op = paramArrayOfByte;
    }
    
    protected final int Q(int paramInt1, int paramInt2, int paramInt3)
    {
      paramInt2 = aaa() + paramInt2;
      return dt.c(paramInt1, this.Op, paramInt2, paramInt2 + paramInt3);
    }
    
    protected final int R(int paramInt1, int paramInt2, int paramInt3)
    {
      return bj.b(paramInt1, this.Op, aaa() + paramInt2, paramInt3);
    }
    
    public final ByteBuffer ZU()
    {
      return ByteBuffer.wrap(this.Op, aaa(), size()).asReadOnlyBuffer();
    }
    
    public final boolean ZW()
    {
      int i = aaa();
      return dt.t(this.Op, i, size() + i);
    }
    
    public final i ZX()
    {
      return i.c(this.Op, aaa(), size(), true);
    }
    
    protected final String a(Charset paramCharset)
    {
      return new String(this.Op, aaa(), size(), paramCharset);
    }
    
    final void a(g paramg)
    {
      paramg.n(this.Op, aaa(), size());
    }
    
    final boolean a(h paramh, int paramInt1, int paramInt2)
    {
      if (paramInt2 > paramh.size()) {
        throw new IllegalArgumentException("Length too large: " + paramInt2 + size());
      }
      if (paramInt1 + paramInt2 > paramh.size()) {
        throw new IllegalArgumentException("Ran off end of other: " + paramInt1 + ", " + paramInt2 + ", " + paramh.size());
      }
      if ((paramh instanceof h))
      {
        paramh = (h)paramh;
        byte[] arrayOfByte1 = this.Op;
        byte[] arrayOfByte2 = paramh.Op;
        int j = aaa();
        int i = aaa();
        paramInt1 = paramh.aaa() + paramInt1;
        while (i < j + paramInt2)
        {
          if (arrayOfByte1[i] != arrayOfByte2[paramInt1]) {
            return false;
          }
          i += 1;
          paramInt1 += 1;
        }
        return true;
      }
      return paramh.cC(paramInt1, paramInt1 + paramInt2).equals(cC(0, paramInt2));
    }
    
    protected int aaa()
    {
      return 0;
    }
    
    protected void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    {
      System.arraycopy(this.Op, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    }
    
    public final h cC(int paramInt1, int paramInt2)
    {
      paramInt2 = S(paramInt1, paramInt2, size());
      if (paramInt2 == 0) {
        return h.dIJ;
      }
      return new h.c(this.Op, aaa() + paramInt1, paramInt2);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof h)) {
        return false;
      }
      if (size() != ((h)paramObject).size()) {
        return false;
      }
      if (size() == 0) {
        return true;
      }
      if ((paramObject instanceof h))
      {
        h localh = (h)paramObject;
        int i = ZZ();
        int j = localh.ZZ();
        if ((i != 0) && (j != 0) && (i != j)) {
          return false;
        }
        return a((h)paramObject, 0, size());
      }
      return paramObject.equals(this);
    }
    
    public byte jJ(int paramInt)
    {
      return this.Op[paramInt];
    }
    
    byte jK(int paramInt)
    {
      return this.Op[paramInt];
    }
    
    public int size()
    {
      return this.Op.length;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.h
 * JD-Core Version:    0.7.0.1
 */