package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class n
{
  public ByteBuffer a;
  protected String b;
  private r c;
  
  public n()
  {
    this(128);
  }
  
  public n(int paramInt)
  {
    AppMethodBeat.i(224502);
    this.b = "GBK";
    this.a = ByteBuffer.allocate(paramInt);
    AppMethodBeat.o(224502);
  }
  
  private n(ByteBuffer paramByteBuffer)
  {
    this.b = "GBK";
    this.a = paramByteBuffer;
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(224527);
    int i;
    if (this.a.remaining() < paramInt) {
      i = this.a.capacity();
    }
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate((i + paramInt) * 2);
      localByteBuffer.put(this.a.array(), 0, this.a.position());
      this.a = localByteBuffer;
      AppMethodBeat.o(224527);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(224527);
      throw localIllegalArgumentException;
    }
  }
  
  private void a(r paramr)
  {
    this.c = paramr;
  }
  
  private void a(Boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(224665);
    a(paramBoolean.booleanValue(), paramInt);
    AppMethodBeat.o(224665);
  }
  
  private void a(Byte paramByte, int paramInt)
  {
    AppMethodBeat.i(224655);
    a(paramByte.byteValue(), paramInt);
    AppMethodBeat.o(224655);
  }
  
  private void a(Double paramDouble, int paramInt)
  {
    AppMethodBeat.i(224709);
    a(paramDouble.doubleValue(), paramInt);
    AppMethodBeat.o(224709);
  }
  
  private void a(Float paramFloat, int paramInt)
  {
    AppMethodBeat.i(224700);
    a(paramFloat.floatValue(), paramInt);
    AppMethodBeat.o(224700);
  }
  
  private void a(Integer paramInteger, int paramInt)
  {
    AppMethodBeat.i(224681);
    a(paramInteger.intValue(), paramInt);
    AppMethodBeat.o(224681);
  }
  
  private void a(Long paramLong, int paramInt)
  {
    AppMethodBeat.i(224693);
    a(paramLong.longValue(), paramInt);
    AppMethodBeat.o(224693);
  }
  
  private void a(Short paramShort, int paramInt)
  {
    AppMethodBeat.i(224673);
    a(paramShort.shortValue(), paramInt);
    AppMethodBeat.o(224673);
  }
  
  private void a(double[] paramArrayOfDouble, int paramInt)
  {
    AppMethodBeat.i(224623);
    a(8);
    b((byte)9, paramInt);
    a(paramArrayOfDouble.length, 0);
    int i = paramArrayOfDouble.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfDouble[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(224623);
  }
  
  private void a(float[] paramArrayOfFloat, int paramInt)
  {
    AppMethodBeat.i(224614);
    a(8);
    b((byte)9, paramInt);
    a(paramArrayOfFloat.length, 0);
    int i = paramArrayOfFloat.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfFloat[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(224614);
  }
  
  private void a(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(224596);
    a(8);
    b((byte)9, paramInt);
    a(paramArrayOfInt.length, 0);
    int i = paramArrayOfInt.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfInt[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(224596);
  }
  
  private void a(long[] paramArrayOfLong, int paramInt)
  {
    AppMethodBeat.i(224604);
    a(8);
    b((byte)9, paramInt);
    a(paramArrayOfLong.length, 0);
    int i = paramArrayOfLong.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfLong[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(224604);
  }
  
  private <T> void a(T[] paramArrayOfT, int paramInt)
  {
    AppMethodBeat.i(224632);
    b(paramArrayOfT, paramInt);
    AppMethodBeat.o(224632);
  }
  
  private void a(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(224586);
    a(8);
    b((byte)9, paramInt);
    a(paramArrayOfShort.length, 0);
    int i = paramArrayOfShort.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfShort[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(224586);
  }
  
  private void a(boolean[] paramArrayOfBoolean, int paramInt)
  {
    AppMethodBeat.i(224575);
    a(8);
    b((byte)9, paramInt);
    a(paramArrayOfBoolean.length, 0);
    int i = paramArrayOfBoolean.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfBoolean[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(224575);
  }
  
  private ByteBuffer b()
  {
    return this.a;
  }
  
  private void b(byte paramByte, int paramInt)
  {
    AppMethodBeat.i(224542);
    byte b1;
    if (paramInt < 15)
    {
      b1 = (byte)(paramInt << 4 | paramByte);
      this.a.put(b1);
      AppMethodBeat.o(224542);
      return;
    }
    if (paramInt < 256)
    {
      b1 = (byte)(paramByte | 0xF0);
      this.a.put(b1);
      this.a.put((byte)paramInt);
      AppMethodBeat.o(224542);
      return;
    }
    l locall = new l("tag is too large: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(224542);
    throw locall;
  }
  
  private void b(String paramString, int paramInt)
  {
    AppMethodBeat.i(224554);
    paramString = i.a(paramString);
    a(paramString.length + 10);
    if (paramString.length > 255)
    {
      b((byte)7, paramInt);
      this.a.putInt(paramString.length);
      this.a.put(paramString);
      AppMethodBeat.o(224554);
      return;
    }
    b((byte)6, paramInt);
    this.a.put((byte)paramString.length);
    this.a.put(paramString);
    AppMethodBeat.o(224554);
  }
  
  private void b(Object[] paramArrayOfObject, int paramInt)
  {
    AppMethodBeat.i(224645);
    a(8);
    b((byte)9, paramInt);
    a(paramArrayOfObject.length, 0);
    int i = paramArrayOfObject.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfObject[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(224645);
  }
  
  private r c()
  {
    return this.c;
  }
  
  private void c(String paramString, int paramInt)
  {
    AppMethodBeat.i(224566);
    a(paramString.length() + 10);
    paramString = i.a(paramString);
    if (paramString.length > 255)
    {
      b((byte)7, paramInt);
      this.a.putInt(paramString.length);
      this.a.put(paramString);
      AppMethodBeat.o(224566);
      return;
    }
    b((byte)6, paramInt);
    this.a.put((byte)paramString.length);
    this.a.put(paramString);
    AppMethodBeat.o(224566);
  }
  
  public final int a(String paramString)
  {
    this.b = paramString;
    return 0;
  }
  
  public final void a(byte paramByte, int paramInt)
  {
    AppMethodBeat.i(224752);
    a(3);
    if (paramByte == 0)
    {
      b((byte)12, paramInt);
      AppMethodBeat.o(224752);
      return;
    }
    b((byte)0, paramInt);
    this.a.put(paramByte);
    AppMethodBeat.o(224752);
  }
  
  public final void a(double paramDouble, int paramInt)
  {
    AppMethodBeat.i(224790);
    a(10);
    b((byte)5, paramInt);
    this.a.putDouble(paramDouble);
    AppMethodBeat.o(224790);
  }
  
  public final void a(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(224783);
    a(6);
    b((byte)4, paramInt);
    this.a.putFloat(paramFloat);
    AppMethodBeat.o(224783);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(224768);
    a(6);
    if ((paramInt1 >= -32768) && (paramInt1 <= 32767))
    {
      a((short)paramInt1, paramInt2);
      AppMethodBeat.o(224768);
      return;
    }
    b((byte)2, paramInt2);
    this.a.putInt(paramInt1);
    AppMethodBeat.o(224768);
  }
  
  public final void a(long paramLong, int paramInt)
  {
    AppMethodBeat.i(224775);
    a(10);
    if ((paramLong >= -2147483648L) && (paramLong <= 2147483647L))
    {
      a((int)paramLong, paramInt);
      AppMethodBeat.o(224775);
      return;
    }
    b((byte)3, paramInt);
    this.a.putLong(paramLong);
    AppMethodBeat.o(224775);
  }
  
  public final void a(p paramp, int paramInt)
  {
    AppMethodBeat.i(224836);
    a(2);
    b((byte)10, paramInt);
    paramp.writeTo(this);
    a(2);
    b((byte)11, 0);
    AppMethodBeat.o(224836);
  }
  
  public final void a(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(224851);
    if ((paramObject instanceof Byte))
    {
      a(((Byte)paramObject).byteValue(), paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      a(((Boolean)paramObject).booleanValue(), paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof Short))
    {
      a(((Short)paramObject).shortValue(), paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      a(((Integer)paramObject).intValue(), paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof Long))
    {
      a(((Long)paramObject).longValue(), paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof Float))
    {
      a(((Float)paramObject).floatValue(), paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof Double))
    {
      a(((Double)paramObject).doubleValue(), paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof String))
    {
      a((String)paramObject, paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof Map))
    {
      a((Map)paramObject, paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof List))
    {
      a((List)paramObject, paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof p))
    {
      a((p)paramObject, paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      a((byte[])paramObject, paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof boolean[]))
    {
      a((boolean[])paramObject, paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof short[]))
    {
      a((short[])paramObject, paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof int[]))
    {
      a((int[])paramObject, paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof long[]))
    {
      a((long[])paramObject, paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof float[]))
    {
      a((float[])paramObject, paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof double[]))
    {
      a((double[])paramObject, paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if (paramObject.getClass().isArray())
    {
      b((Object[])paramObject, paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    if ((paramObject instanceof Collection))
    {
      a((Collection)paramObject, paramInt);
      AppMethodBeat.o(224851);
      return;
    }
    paramObject = new l("write object error: unsupport type. " + paramObject.getClass());
    AppMethodBeat.o(224851);
    throw paramObject;
  }
  
  public final void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(224800);
    try
    {
      byte[] arrayOfByte = paramString.getBytes(this.b);
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        paramString = paramString.getBytes();
      }
      b((byte)6, paramInt);
      this.a.put((byte)paramString.length);
      this.a.put(paramString);
      AppMethodBeat.o(224800);
    }
    a(paramString.length + 10);
    if (paramString.length > 255)
    {
      b((byte)7, paramInt);
      this.a.putInt(paramString.length);
      this.a.put(paramString);
      AppMethodBeat.o(224800);
      return;
    }
  }
  
  public final <T> void a(Collection<T> paramCollection, int paramInt)
  {
    AppMethodBeat.i(224827);
    a(8);
    b((byte)9, paramInt);
    if (paramCollection == null) {}
    for (paramInt = 0;; paramInt = paramCollection.size())
    {
      a(paramInt, 0);
      if (paramCollection == null) {
        break;
      }
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        a(paramCollection.next(), 0);
      }
    }
    AppMethodBeat.o(224827);
  }
  
  public final <K, V> void a(Map<K, V> paramMap, int paramInt)
  {
    AppMethodBeat.i(224809);
    a(8);
    b((byte)8, paramInt);
    if (paramMap == null) {}
    for (paramInt = 0;; paramInt = paramMap.size())
    {
      a(paramInt, 0);
      if (paramMap == null) {
        break;
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        a(localEntry.getKey(), 0);
        a(localEntry.getValue(), 1);
      }
    }
    AppMethodBeat.o(224809);
  }
  
  public final void a(short paramShort, int paramInt)
  {
    AppMethodBeat.i(224761);
    a(4);
    if ((paramShort >= -128) && (paramShort <= 127))
    {
      a((byte)paramShort, paramInt);
      AppMethodBeat.o(224761);
      return;
    }
    b((byte)1, paramInt);
    this.a.putShort(paramShort);
    AppMethodBeat.o(224761);
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(224740);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      a((byte)i, paramInt);
      AppMethodBeat.o(224740);
      return;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(224818);
    a(paramArrayOfByte.length + 8);
    b((byte)13, paramInt);
    b((byte)0, 0);
    a(paramArrayOfByte.length, 0);
    this.a.put(paramArrayOfByte);
    AppMethodBeat.o(224818);
  }
  
  public final byte[] a()
  {
    AppMethodBeat.i(224731);
    byte[] arrayOfByte = new byte[this.a.position()];
    System.arraycopy(this.a.array(), 0, arrayOfByte, 0, this.a.position());
    AppMethodBeat.o(224731);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.n
 * JD-Core Version:    0.7.0.1
 */