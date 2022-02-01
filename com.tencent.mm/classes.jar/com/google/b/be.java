package com.google.b;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public final class be
{
  public static final byte[] EMPTY_BYTE_ARRAY;
  static final Charset ISO_8859_1;
  static final Charset UTF_8 = Charset.forName("UTF-8");
  public static final ByteBuffer bZh;
  public static final h bZi = h.z(EMPTY_BYTE_ARRAY);
  
  static
  {
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    byte[] arrayOfByte = new byte[0];
    EMPTY_BYTE_ARRAY = arrayOfByte;
    bZh = ByteBuffer.wrap(arrayOfByte);
  }
  
  public static boolean D(byte[] paramArrayOfByte)
  {
    return dg.D(paramArrayOfByte);
  }
  
  public static String E(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, UTF_8);
  }
  
  static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    while (i < paramInt2 + paramInt3)
    {
      paramInt1 = paramInt1 * 31 + paramArrayOfByte[i];
      i += 1;
    }
    return paramInt1;
  }
  
  public static int a(a parama)
  {
    return parama.getNumber();
  }
  
  public static int aJ(long paramLong)
  {
    return (int)(paramLong >>> 32 ^ paramLong);
  }
  
  public static int bS(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
  
  static <T> T c(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new NullPointerException(paramString);
    }
    return paramT;
  }
  
  static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  public static int hashCode(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = a(i, paramArrayOfByte, 0, i);
    i = j;
    if (j == 0) {
      i = 1;
    }
    return i;
  }
  
  public static int z(List<? extends a> paramList)
  {
    paramList = paramList.iterator();
    for (int i = 1; paramList.hasNext(); i = ((a)paramList.next()).getNumber() + i * 31) {}
    return i;
  }
  
  public static abstract interface a
  {
    public abstract int getNumber();
  }
  
  public static abstract interface c {}
  
  public static abstract interface d
    extends be.e<Integer>
  {
    public abstract int getInt(int paramInt);
    
    public abstract d hw(int paramInt);
    
    public abstract void hx(int paramInt);
  }
  
  public static abstract interface e<E>
    extends List<E>, RandomAccess
  {
    public abstract void Al();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.be
 * JD-Core Version:    0.7.0.1
 */