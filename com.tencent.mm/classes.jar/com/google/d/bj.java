package com.google.d;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public final class bj
{
  public static final byte[] EMPTY_BYTE_ARRAY;
  static final Charset ISO_8859_1;
  static final Charset UTF_8 = Charset.forName("UTF-8");
  public static final ByteBuffer dSR;
  public static final i dSS = i.B(EMPTY_BYTE_ARRAY);
  
  static
  {
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    byte[] arrayOfByte = new byte[0];
    EMPTY_BYTE_ARRAY = arrayOfByte;
    dSR = ByteBuffer.wrap(arrayOfByte);
  }
  
  public static boolean F(byte[] paramArrayOfByte)
  {
    return dt.F(paramArrayOfByte);
  }
  
  public static String G(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, UTF_8);
  }
  
  static int b(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    while (i < paramInt2 + paramInt3)
    {
      paramInt1 = paramInt1 * 31 + paramArrayOfByte[i];
      i += 1;
    }
    return paramInt1;
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
  
  public static int hashBoolean(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
  
  public static int hashCode(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = b(i, paramArrayOfByte, 0, i);
    i = j;
    if (j == 0) {
      i = 1;
    }
    return i;
  }
  
  public static int hashEnum(c paramc)
  {
    return paramc.getNumber();
  }
  
  public static int hashEnumList(List<? extends c> paramList)
  {
    paramList = paramList.iterator();
    for (int i = 1; paramList.hasNext(); i = ((c)paramList.next()).getNumber() + i * 31) {}
    return i;
  }
  
  public static int hashLong(long paramLong)
  {
    return (int)(paramLong >>> 32 ^ paramLong);
  }
  
  static Object q(Object paramObject1, Object paramObject2)
  {
    return ((ce)paramObject1).toBuilder().mergeFrom((ce)paramObject2).buildPartial();
  }
  
  public static abstract interface a
    extends bj.i<Boolean>
  {
    public abstract a jF(int paramInt);
  }
  
  public static abstract interface b
    extends bj.i<Double>
  {
    public abstract b le(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract int getNumber();
  }
  
  public static abstract interface e
  {
    public abstract boolean kB(int paramInt);
  }
  
  public static abstract interface f
    extends bj.i<Float>
  {
    public abstract f lh(int paramInt);
  }
  
  public static abstract interface g
    extends bj.i<Integer>
  {
    public abstract int getInt(int paramInt);
    
    public abstract g li(int paramInt);
    
    public abstract void lj(int paramInt);
  }
  
  public static abstract interface h
    extends bj.i<Long>
  {
    public abstract h lk(int paramInt);
  }
  
  public static abstract interface i<E>
    extends List<E>, RandomAccess
  {
    public abstract boolean ZO();
    
    public abstract void ZP();
    
    public abstract i<E> jI(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bj
 * JD-Core Version:    0.7.0.1
 */