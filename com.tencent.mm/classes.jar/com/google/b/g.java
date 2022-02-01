package com.google.b;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;

public abstract class g
  implements Serializable, Iterable<Byte>
{
  public static final g bPf = new h(be.EMPTY_BYTE_ARRAY);
  private static final g.d bPg;
  private static final Comparator<g> bPi;
  private int bPh = 0;
  
  static
  {
    if (e.An()) {}
    for (Object localObject = new g.i((byte)0);; localObject = new g.b((byte)0))
    {
      bPg = (g.d)localObject;
      bPi = new g.2();
      return;
    }
  }
  
  static int A(int paramInt1, int paramInt2, int paramInt3)
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
  
  public static g ct(String paramString)
  {
    return new h(paramString.getBytes(be.UTF_8));
  }
  
  static f gx(int paramInt)
  {
    return new f(paramInt, (byte)0);
  }
  
  public static g p(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    A(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    return new h(bPg.r(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  static g q(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new c(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static g x(byte[] paramArrayOfByte)
  {
    return p(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  static g y(byte[] paramArrayOfByte)
  {
    return new h(paramArrayOfByte);
  }
  
  public final g.e Ao()
  {
    return new g.1(this);
  }
  
  public final String Ap()
  {
    Charset localCharset = be.UTF_8;
    if (size() == 0) {
      return "";
    }
    return a(localCharset);
  }
  
  public abstract boolean Aq();
  
  public abstract h Ar();
  
  protected final int As()
  {
    return this.bPh;
  }
  
  protected abstract String a(Charset paramCharset);
  
  abstract void a(f paramf);
  
  protected abstract int bH(int paramInt1, int paramInt2);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract byte gu(int paramInt);
  
  abstract byte gv(int paramInt);
  
  public abstract g gw(int paramInt);
  
  public final int hashCode()
  {
    int j = this.bPh;
    int i = j;
    if (j == 0)
    {
      i = size();
      j = bH(i, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.bPh = i;
    }
    return i;
  }
  
  public final boolean isEmpty()
  {
    return size() == 0;
  }
  
  protected abstract void q(byte[] paramArrayOfByte, int paramInt);
  
  public abstract int size();
  
  public final byte[] toByteArray()
  {
    int i = size();
    if (i == 0) {
      return be.EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte = new byte[i];
    q(arrayOfByte, i);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
  
  static final class c
    extends g.h
  {
    private final int bPk;
    private final int bPl;
    
    c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      super();
      A(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
      this.bPk = paramInt1;
      this.bPl = paramInt2;
    }
    
    private void readObject(ObjectInputStream paramObjectInputStream)
    {
      throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
    }
    
    protected final int At()
    {
      return this.bPk;
    }
    
    public final byte gu(int paramInt)
    {
      int i = this.bPl;
      if ((i - (paramInt + 1) | paramInt) < 0)
      {
        if (paramInt < 0) {
          throw new ArrayIndexOutOfBoundsException("Index < 0: ".concat(String.valueOf(paramInt)));
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + paramInt + ", " + i);
      }
      return this.UH[(this.bPk + paramInt)];
    }
    
    final byte gv(int paramInt)
    {
      return this.UH[(this.bPk + paramInt)];
    }
    
    protected final void q(byte[] paramArrayOfByte, int paramInt)
    {
      System.arraycopy(this.UH, this.bPk + 0, paramArrayOfByte, 0, paramInt);
    }
    
    public final int size()
    {
      return this.bPl;
    }
    
    final Object writeReplace()
    {
      return g.y(toByteArray());
    }
  }
  
  static final class f
  {
    final i bPm;
    private final byte[] buffer;
    
    private f(int paramInt)
    {
      this.buffer = new byte[paramInt];
      this.bPm = i.A(this.buffer);
    }
    
    public final g Au()
    {
      this.bPm.Bc();
      return new g.h(this.buffer);
    }
  }
  
  static class h
    extends g.g
  {
    protected final byte[] UH;
    
    h(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null) {
        throw new NullPointerException();
      }
      this.UH = paramArrayOfByte;
    }
    
    public final boolean Aq()
    {
      int i = At();
      return dg.s(this.UH, i, size() + i);
    }
    
    public final h Ar()
    {
      return h.c(this.UH, At(), size(), true);
    }
    
    protected int At()
    {
      return 0;
    }
    
    protected final String a(Charset paramCharset)
    {
      return new String(this.UH, At(), size(), paramCharset);
    }
    
    final void a(f paramf)
    {
      paramf.o(this.UH, At(), size());
    }
    
    protected final int bH(int paramInt1, int paramInt2)
    {
      return be.a(paramInt1, this.UH, At() + 0, paramInt2);
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
        int i = As();
        int j = ((h)localObject).As();
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
          localObject = this.UH;
          byte[] arrayOfByte = paramObject.UH;
          int m = At();
          j = At();
          i = paramObject.At() + 0;
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
        return paramObject.gw(k + 0).equals(gw(k));
      }
      return paramObject.equals(this);
    }
    
    public byte gu(int paramInt)
    {
      return this.UH[paramInt];
    }
    
    byte gv(int paramInt)
    {
      return this.UH[paramInt];
    }
    
    public final g gw(int paramInt)
    {
      paramInt = A(0, paramInt, size());
      if (paramInt == 0) {
        return g.bPf;
      }
      return new g.c(this.UH, At() + 0, paramInt);
    }
    
    protected void q(byte[] paramArrayOfByte, int paramInt)
    {
      System.arraycopy(this.UH, 0, paramArrayOfByte, 0, paramInt);
    }
    
    public int size()
    {
      return this.UH.length;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.g
 * JD-Core Version:    0.7.0.1
 */