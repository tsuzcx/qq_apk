package com.google.a;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class g
  implements Serializable, Iterable<Byte>
{
  public static final g bNg = new h(ae.EMPTY_BYTE_ARRAY);
  private static final d bNh;
  private static final Comparator<g> bNj;
  int bNi = 0;
  
  static
  {
    if (e.yM()) {}
    for (Object localObject = new i((byte)0);; localObject = new b((byte)0))
    {
      bNh = (d)localObject;
      bNj = new Comparator() {};
      return;
    }
  }
  
  static g A(byte[] paramArrayOfByte)
  {
    return new h(paramArrayOfByte);
  }
  
  public static g bZ(String paramString)
  {
    return new h(paramString.getBytes(ae.UTF_8));
  }
  
  static f fE(int paramInt)
  {
    return new f(paramInt, (byte)0);
  }
  
  public static g p(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    y(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    return new h(bNh.r(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  static g q(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new c(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static int y(int paramInt1, int paramInt2, int paramInt3)
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
  
  public static g z(byte[] paramArrayOfByte)
  {
    return p(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  protected abstract String a(Charset paramCharset);
  
  abstract void a(f paramf);
  
  protected abstract int bq(int paramInt1, int paramInt2);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract byte fB(int paramInt);
  
  abstract byte fC(int paramInt);
  
  public abstract g fD(int paramInt);
  
  public final int hashCode()
  {
    int j = this.bNi;
    int i = j;
    if (j == 0)
    {
      i = size();
      j = bq(i, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.bNi = i;
    }
    return i;
  }
  
  protected abstract void q(byte[] paramArrayOfByte, int paramInt);
  
  public abstract int size();
  
  public final byte[] toByteArray()
  {
    int i = size();
    if (i == 0) {
      return ae.EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte = new byte[i];
    q(arrayOfByte, i);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
  
  public final e yN()
  {
    new a()
    {
      private final int limit = g.this.size();
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
        return g.this.fC(i);
      }
    };
  }
  
  public final String yO()
  {
    Charset localCharset = ae.UTF_8;
    if (size() == 0) {
      return "";
    }
    return a(localCharset);
  }
  
  public abstract boolean yP();
  
  public abstract h yQ();
  
  static abstract class a
    implements g.e
  {
    public final void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  static final class b
    implements g.d
  {
    public final byte[] r(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      return Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt1 + paramInt2);
    }
  }
  
  static final class c
    extends g.h
  {
    private final int bNl;
    private final int bNm;
    
    c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      super();
      y(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
      this.bNl = paramInt1;
      this.bNm = paramInt2;
    }
    
    private void readObject(ObjectInputStream paramObjectInputStream)
    {
      throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
    }
    
    public final byte fB(int paramInt)
    {
      int i = this.bNm;
      if ((i - (paramInt + 1) | paramInt) < 0)
      {
        if (paramInt < 0) {
          throw new ArrayIndexOutOfBoundsException("Index < 0: ".concat(String.valueOf(paramInt)));
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + paramInt + ", " + i);
      }
      return this.zy[(this.bNl + paramInt)];
    }
    
    final byte fC(int paramInt)
    {
      return this.zy[(this.bNl + paramInt)];
    }
    
    protected final void q(byte[] paramArrayOfByte, int paramInt)
    {
      System.arraycopy(this.zy, this.bNl + 0, paramArrayOfByte, 0, paramInt);
    }
    
    public final int size()
    {
      return this.bNm;
    }
    
    final Object writeReplace()
    {
      return g.A(toByteArray());
    }
    
    protected final int yR()
    {
      return this.bNl;
    }
  }
  
  static abstract interface d
  {
    public abstract byte[] r(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
  
  public static abstract interface e
    extends Iterator<Byte>
  {
    public abstract byte nextByte();
  }
  
  static final class f
  {
    final i bNn;
    private final byte[] buffer;
    
    private f(int paramInt)
    {
      this.buffer = new byte[paramInt];
      this.bNn = i.C(this.buffer);
    }
    
    public final g yS()
    {
      this.bNn.zA();
      return new g.h(this.buffer);
    }
  }
  
  static abstract class g
    extends g
  {}
  
  static class h
    extends g.g
  {
    protected final byte[] zy;
    
    h(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null) {
        throw new NullPointerException();
      }
      this.zy = paramArrayOfByte;
    }
    
    protected final String a(Charset paramCharset)
    {
      return new String(this.zy, yR(), size(), paramCharset);
    }
    
    final void a(f paramf)
    {
      paramf.o(this.zy, yR(), size());
    }
    
    protected final int bq(int paramInt1, int paramInt2)
    {
      return ae.a(paramInt1, this.zy, yR() + 0, paramInt2);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof g)) {
        return false;
      }
      if (size() != ((g)paramObject).size()) {
        return false;
      }
      if (size() == 0) {
        return true;
      }
      if ((paramObject instanceof h))
      {
        Object localObject = (h)paramObject;
        int i = this.bNi;
        int j = ((g)localObject).bNi;
        if ((i != 0) && (j != 0) && (i != j)) {
          return false;
        }
        paramObject = (h)paramObject;
        int k = size();
        if (k > paramObject.size()) {
          throw new IllegalArgumentException("Length too large: " + k + size());
        }
        if (k + 0 > paramObject.size()) {
          throw new IllegalArgumentException("Ran off end of other: 0, " + k + ", " + paramObject.size());
        }
        if ((paramObject instanceof h))
        {
          paramObject = (h)paramObject;
          localObject = this.zy;
          byte[] arrayOfByte = paramObject.zy;
          int m = yR();
          j = yR();
          i = paramObject.yR() + 0;
          while (j < m + k)
          {
            if (localObject[j] != arrayOfByte[i]) {
              return false;
            }
            j += 1;
            i += 1;
          }
          return true;
        }
        return paramObject.fD(k + 0).equals(fD(k));
      }
      return paramObject.equals(this);
    }
    
    public byte fB(int paramInt)
    {
      return this.zy[paramInt];
    }
    
    byte fC(int paramInt)
    {
      return this.zy[paramInt];
    }
    
    public final g fD(int paramInt)
    {
      paramInt = y(0, paramInt, size());
      if (paramInt == 0) {
        return g.bNg;
      }
      return new g.c(this.zy, yR() + 0, paramInt);
    }
    
    protected void q(byte[] paramArrayOfByte, int paramInt)
    {
      System.arraycopy(this.zy, 0, paramArrayOfByte, 0, paramInt);
    }
    
    public int size()
    {
      return this.zy.length;
    }
    
    public final boolean yP()
    {
      int i = yR();
      return ci.s(this.zy, i, size() + i);
    }
    
    public final h yQ()
    {
      return h.c(this.zy, yR(), size(), true);
    }
    
    protected int yR()
    {
      return 0;
    }
  }
  
  static final class i
    implements g.d
  {
    public final byte[] r(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      byte[] arrayOfByte = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
      return arrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.g
 * JD-Core Version:    0.7.0.1
 */