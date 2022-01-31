package com.qq.taf.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JceOutputStream
{
  private ByteBuffer bs;
  protected String sServerEncoding;
  
  public JceOutputStream()
  {
    this(128);
  }
  
  public JceOutputStream(int paramInt)
  {
    AppMethodBeat.i(117107);
    this.sServerEncoding = "GBK";
    this.bs = ByteBuffer.allocate(paramInt);
    AppMethodBeat.o(117107);
  }
  
  public JceOutputStream(ByteBuffer paramByteBuffer)
  {
    this.sServerEncoding = "GBK";
    this.bs = paramByteBuffer;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    AppMethodBeat.i(117141);
    paramArrayOfString = new JceOutputStream();
    paramArrayOfString.write(1311768467283714885L, 0);
    ByteBuffer localByteBuffer = paramArrayOfString.getByteBuffer();
    System.out.println(HexUtil.bytes2HexStr(localByteBuffer.array()));
    System.out.println(Arrays.toString(paramArrayOfString.toByteArray()));
    AppMethodBeat.o(117141);
  }
  
  private void writeArray(Object[] paramArrayOfObject, int paramInt)
  {
    AppMethodBeat.i(117130);
    reserve(8);
    writeHead((byte)9, paramInt);
    write(paramArrayOfObject.length, 0);
    int i = paramArrayOfObject.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= i)
      {
        AppMethodBeat.o(117130);
        return;
      }
      write(paramArrayOfObject[paramInt], 0);
      paramInt += 1;
    }
  }
  
  public ByteBuffer getByteBuffer()
  {
    return this.bs;
  }
  
  public void reserve(int paramInt)
  {
    AppMethodBeat.i(117109);
    if (this.bs.remaining() < paramInt)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate((this.bs.capacity() + paramInt) * 2);
      localByteBuffer.put(this.bs.array(), 0, this.bs.position());
      this.bs = localByteBuffer;
    }
    AppMethodBeat.o(117109);
  }
  
  public int setServerEncoding(String paramString)
  {
    this.sServerEncoding = paramString;
    return 0;
  }
  
  public byte[] toByteArray()
  {
    AppMethodBeat.i(117108);
    byte[] arrayOfByte = new byte[this.bs.position()];
    System.arraycopy(this.bs.array(), 0, arrayOfByte, 0, this.bs.position());
    AppMethodBeat.o(117108);
    return arrayOfByte;
  }
  
  public void write(byte paramByte, int paramInt)
  {
    AppMethodBeat.i(117112);
    reserve(3);
    if (paramByte == 0)
    {
      writeHead((byte)12, paramInt);
      AppMethodBeat.o(117112);
      return;
    }
    writeHead((byte)0, paramInt);
    this.bs.put(paramByte);
    AppMethodBeat.o(117112);
  }
  
  public void write(double paramDouble, int paramInt)
  {
    AppMethodBeat.i(117117);
    reserve(10);
    writeHead((byte)5, paramInt);
    this.bs.putDouble(paramDouble);
    AppMethodBeat.o(117117);
  }
  
  public void write(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(117116);
    reserve(6);
    writeHead((byte)4, paramInt);
    this.bs.putFloat(paramFloat);
    AppMethodBeat.o(117116);
  }
  
  public void write(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117114);
    reserve(6);
    if ((paramInt1 >= -32768) && (paramInt1 <= 32767))
    {
      write((short)paramInt1, paramInt2);
      AppMethodBeat.o(117114);
      return;
    }
    writeHead((byte)2, paramInt2);
    this.bs.putInt(paramInt1);
    AppMethodBeat.o(117114);
  }
  
  public void write(long paramLong, int paramInt)
  {
    AppMethodBeat.i(117115);
    reserve(10);
    if ((paramLong >= -2147483648L) && (paramLong <= 2147483647L))
    {
      write((int)paramLong, paramInt);
      AppMethodBeat.o(117115);
      return;
    }
    writeHead((byte)3, paramInt);
    this.bs.putLong(paramLong);
    AppMethodBeat.o(117115);
  }
  
  public void write(JceStruct paramJceStruct, int paramInt)
  {
    AppMethodBeat.i(117132);
    reserve(2);
    writeHead((byte)10, paramInt);
    paramJceStruct.writeTo(this);
    reserve(2);
    writeHead((byte)11, 0);
    AppMethodBeat.o(117132);
  }
  
  public void write(Boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(117134);
    write(paramBoolean.booleanValue(), paramInt);
    AppMethodBeat.o(117134);
  }
  
  public void write(Byte paramByte, int paramInt)
  {
    AppMethodBeat.i(117133);
    write(paramByte.byteValue(), paramInt);
    AppMethodBeat.o(117133);
  }
  
  public void write(Double paramDouble, int paramInt)
  {
    AppMethodBeat.i(117139);
    write(paramDouble.doubleValue(), paramInt);
    AppMethodBeat.o(117139);
  }
  
  public void write(Float paramFloat, int paramInt)
  {
    AppMethodBeat.i(117138);
    write(paramFloat.floatValue(), paramInt);
    AppMethodBeat.o(117138);
  }
  
  public void write(Integer paramInteger, int paramInt)
  {
    AppMethodBeat.i(117136);
    write(paramInteger.intValue(), paramInt);
    AppMethodBeat.o(117136);
  }
  
  public void write(Long paramLong, int paramInt)
  {
    AppMethodBeat.i(117137);
    write(paramLong.longValue(), paramInt);
    AppMethodBeat.o(117137);
  }
  
  public void write(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(117140);
    if ((paramObject instanceof Byte))
    {
      write(((Byte)paramObject).byteValue(), paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      write(((Boolean)paramObject).booleanValue(), paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof Short))
    {
      write(((Short)paramObject).shortValue(), paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      write(((Integer)paramObject).intValue(), paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof Long))
    {
      write(((Long)paramObject).longValue(), paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof Float))
    {
      write(((Float)paramObject).floatValue(), paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof Double))
    {
      write(((Double)paramObject).doubleValue(), paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof String))
    {
      write((String)paramObject, paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof Map))
    {
      write((Map)paramObject, paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof List))
    {
      write((List)paramObject, paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof JceStruct))
    {
      write((JceStruct)paramObject, paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      write((byte[])paramObject, paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof boolean[]))
    {
      write((boolean[])paramObject, paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof short[]))
    {
      write((short[])paramObject, paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof int[]))
    {
      write((int[])paramObject, paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof long[]))
    {
      write((long[])paramObject, paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof float[]))
    {
      write((float[])paramObject, paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof double[]))
    {
      write((double[])paramObject, paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if (paramObject.getClass().isArray())
    {
      writeArray((Object[])paramObject, paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    if ((paramObject instanceof Collection))
    {
      write((Collection)paramObject, paramInt);
      AppMethodBeat.o(117140);
      return;
    }
    paramObject = new JceEncodeException("write object error: unsupport type. " + paramObject.getClass());
    AppMethodBeat.o(117140);
    throw paramObject;
  }
  
  public void write(Short paramShort, int paramInt)
  {
    AppMethodBeat.i(117135);
    write(paramShort.shortValue(), paramInt);
    AppMethodBeat.o(117135);
  }
  
  public void write(String paramString, int paramInt)
  {
    AppMethodBeat.i(117120);
    try
    {
      byte[] arrayOfByte = paramString.getBytes(this.sServerEncoding);
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        paramString = paramString.getBytes();
      }
      writeHead((byte)6, paramInt);
      this.bs.put((byte)paramString.length);
      this.bs.put(paramString);
      AppMethodBeat.o(117120);
    }
    reserve(paramString.length + 10);
    if (paramString.length > 255)
    {
      writeHead((byte)7, paramInt);
      this.bs.putInt(paramString.length);
      this.bs.put(paramString);
      AppMethodBeat.o(117120);
      return;
    }
  }
  
  public <T> void write(Collection<T> paramCollection, int paramInt)
  {
    AppMethodBeat.i(117131);
    reserve(8);
    writeHead((byte)9, paramInt);
    if (paramCollection == null)
    {
      paramInt = 0;
      write(paramInt, 0);
      if (paramCollection != null) {
        paramCollection = paramCollection.iterator();
      }
    }
    for (;;)
    {
      if (!paramCollection.hasNext())
      {
        AppMethodBeat.o(117131);
        return;
        paramInt = paramCollection.size();
        break;
      }
      write((Object)paramCollection.next(), 0);
    }
  }
  
  public <K, V> void write(Map<K, V> paramMap, int paramInt)
  {
    AppMethodBeat.i(117121);
    reserve(8);
    writeHead((byte)8, paramInt);
    if (paramMap == null)
    {
      paramInt = 0;
      write(paramInt, 0);
      if (paramMap != null) {
        paramMap = paramMap.entrySet().iterator();
      }
    }
    for (;;)
    {
      if (!paramMap.hasNext())
      {
        AppMethodBeat.o(117121);
        return;
        paramInt = paramMap.size();
        break;
      }
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      write(localEntry.getKey(), 0);
      write(localEntry.getValue(), 1);
    }
  }
  
  public void write(short paramShort, int paramInt)
  {
    AppMethodBeat.i(117113);
    reserve(4);
    if ((paramShort >= -128) && (paramShort <= 127))
    {
      write((byte)paramShort, paramInt);
      AppMethodBeat.o(117113);
      return;
    }
    writeHead((byte)1, paramInt);
    this.bs.putShort(paramShort);
    AppMethodBeat.o(117113);
  }
  
  public void write(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(117111);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      write((byte)i, paramInt);
      AppMethodBeat.o(117111);
      return;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(117123);
    reserve(paramArrayOfByte.length + 8);
    writeHead((byte)13, paramInt);
    writeHead((byte)0, 0);
    write(paramArrayOfByte.length, 0);
    this.bs.put(paramArrayOfByte);
    AppMethodBeat.o(117123);
  }
  
  public void write(double[] paramArrayOfDouble, int paramInt)
  {
    AppMethodBeat.i(117128);
    reserve(8);
    writeHead((byte)9, paramInt);
    write(paramArrayOfDouble.length, 0);
    int i = paramArrayOfDouble.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= i)
      {
        AppMethodBeat.o(117128);
        return;
      }
      write(paramArrayOfDouble[paramInt], 0);
      paramInt += 1;
    }
  }
  
  public void write(float[] paramArrayOfFloat, int paramInt)
  {
    AppMethodBeat.i(117127);
    reserve(8);
    writeHead((byte)9, paramInt);
    write(paramArrayOfFloat.length, 0);
    int i = paramArrayOfFloat.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= i)
      {
        AppMethodBeat.o(117127);
        return;
      }
      write(paramArrayOfFloat[paramInt], 0);
      paramInt += 1;
    }
  }
  
  public void write(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(117125);
    reserve(8);
    writeHead((byte)9, paramInt);
    write(paramArrayOfInt.length, 0);
    int i = paramArrayOfInt.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= i)
      {
        AppMethodBeat.o(117125);
        return;
      }
      write(paramArrayOfInt[paramInt], 0);
      paramInt += 1;
    }
  }
  
  public void write(long[] paramArrayOfLong, int paramInt)
  {
    AppMethodBeat.i(117126);
    reserve(8);
    writeHead((byte)9, paramInt);
    write(paramArrayOfLong.length, 0);
    int i = paramArrayOfLong.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= i)
      {
        AppMethodBeat.o(117126);
        return;
      }
      write(paramArrayOfLong[paramInt], 0);
      paramInt += 1;
    }
  }
  
  public <T> void write(T[] paramArrayOfT, int paramInt)
  {
    AppMethodBeat.i(117129);
    writeArray(paramArrayOfT, paramInt);
    AppMethodBeat.o(117129);
  }
  
  public void write(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(117124);
    reserve(8);
    writeHead((byte)9, paramInt);
    write(paramArrayOfShort.length, 0);
    int i = paramArrayOfShort.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= i)
      {
        AppMethodBeat.o(117124);
        return;
      }
      write(paramArrayOfShort[paramInt], 0);
      paramInt += 1;
    }
  }
  
  public void write(boolean[] paramArrayOfBoolean, int paramInt)
  {
    AppMethodBeat.i(117122);
    reserve(8);
    writeHead((byte)9, paramInt);
    write(paramArrayOfBoolean.length, 0);
    int i = paramArrayOfBoolean.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= i)
      {
        AppMethodBeat.o(117122);
        return;
      }
      write(paramArrayOfBoolean[paramInt], 0);
      paramInt += 1;
    }
  }
  
  public void writeByteString(String paramString, int paramInt)
  {
    AppMethodBeat.i(117119);
    reserve(paramString.length() + 10);
    paramString = HexUtil.hexStr2Bytes(paramString);
    if (paramString.length > 255)
    {
      writeHead((byte)7, paramInt);
      this.bs.putInt(paramString.length);
      this.bs.put(paramString);
      AppMethodBeat.o(117119);
      return;
    }
    writeHead((byte)6, paramInt);
    this.bs.put((byte)paramString.length);
    this.bs.put(paramString);
    AppMethodBeat.o(117119);
  }
  
  public void writeHead(byte paramByte, int paramInt)
  {
    AppMethodBeat.i(117110);
    byte b;
    if (paramInt < 15)
    {
      b = (byte)(paramInt << 4 | paramByte);
      this.bs.put(b);
      AppMethodBeat.o(117110);
      return;
    }
    if (paramInt < 256)
    {
      b = (byte)(paramByte | 0xF0);
      this.bs.put(b);
      this.bs.put((byte)paramInt);
      AppMethodBeat.o(117110);
      return;
    }
    JceEncodeException localJceEncodeException = new JceEncodeException("tag is too large: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(117110);
    throw localJceEncodeException;
  }
  
  public void writeStringByte(String paramString, int paramInt)
  {
    AppMethodBeat.i(117118);
    paramString = HexUtil.hexStr2Bytes(paramString);
    reserve(paramString.length + 10);
    if (paramString.length > 255)
    {
      writeHead((byte)7, paramInt);
      this.bs.putInt(paramString.length);
      this.bs.put(paramString);
      AppMethodBeat.o(117118);
      return;
    }
    writeHead((byte)6, paramInt);
    this.bs.put((byte)paramString.length);
    this.bs.put(paramString);
    AppMethodBeat.o(117118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.qq.taf.jce.JceOutputStream
 * JD-Core Version:    0.7.0.1
 */