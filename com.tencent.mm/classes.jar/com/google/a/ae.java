package com.google.a;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public final class ae
{
  public static final byte[] EMPTY_BYTE_ARRAY;
  static final Charset ISO_8859_1;
  static final Charset UTF_8 = Charset.forName("UTF-8");
  public static final ByteBuffer bXp;
  public static final h bXq = h.B(EMPTY_BYTE_ARRAY);
  
  static
  {
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    byte[] arrayOfByte = new byte[0];
    EMPTY_BYTE_ARRAY = arrayOfByte;
    bXp = ByteBuffer.wrap(arrayOfByte);
  }
  
  public static int B(List<? extends a> paramList)
  {
    paramList = paramList.iterator();
    for (int i = 1; paramList.hasNext(); i = ((a)paramList.next()).getNumber() + i * 31) {}
    return i;
  }
  
  public static boolean F(byte[] paramArrayOfByte)
  {
    return ci.F(paramArrayOfByte);
  }
  
  public static String G(byte[] paramArrayOfByte)
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
  
  public static int aF(long paramLong)
  {
    return (int)(paramLong >>> 32 ^ paramLong);
  }
  
  public static int bF(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
  
  static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  static <T> T checkNotNull(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new NullPointerException(paramString);
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
  
  static Object l(Object paramObject1, Object paramObject2)
  {
    return ((aw)paramObject1).AN().a((aw)paramObject2).Bo();
  }
  
  public static abstract interface a
  {
    public abstract int getNumber();
  }
  
  public static abstract interface c {}
  
  public static abstract interface e<E>
    extends List<E>, RandomAccess
  {
    public abstract e<E> gI(int paramInt);
    
    public abstract boolean yJ();
    
    public abstract void yK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.ae
 * JD-Core Version:    0.7.0.1
 */