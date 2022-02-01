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
    AppMethodBeat.i(109661);
    this.sServerEncoding = "GBK";
    this.bs = ByteBuffer.allocate(paramInt);
    AppMethodBeat.o(109661);
  }
  
  public JceOutputStream(ByteBuffer paramByteBuffer)
  {
    this.sServerEncoding = "GBK";
    this.bs = paramByteBuffer;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    AppMethodBeat.i(109695);
    paramArrayOfString = new JceOutputStream();
    paramArrayOfString.write(1311768467283714885L, 0);
    ByteBuffer localByteBuffer = paramArrayOfString.getByteBuffer();
    System.out.println(HexUtil.bytes2HexStr(localByteBuffer.array()));
    System.out.println(Arrays.toString(paramArrayOfString.toByteArray()));
    AppMethodBeat.o(109695);
  }
  
  private void writeArray(Object[] paramArrayOfObject, int paramInt)
  {
    AppMethodBeat.i(109684);
    reserve(8);
    writeHead((byte)9, paramInt);
    write(paramArrayOfObject.length, 0);
    int i = paramArrayOfObject.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= i)
      {
        AppMethodBeat.o(109684);
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
    AppMethodBeat.i(109663);
    if (this.bs.remaining() < paramInt)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate((this.bs.capacity() + paramInt) * 2);
      localByteBuffer.put(this.bs.array(), 0, this.bs.position());
      this.bs = localByteBuffer;
    }
    AppMethodBeat.o(109663);
  }
  
  public int setServerEncoding(String paramString)
  {
    this.sServerEncoding = paramString;
    return 0;
  }
  
  public byte[] toByteArray()
  {
    AppMethodBeat.i(109662);
    byte[] arrayOfByte = new byte[this.bs.position()];
    System.arraycopy(this.bs.array(), 0, arrayOfByte, 0, this.bs.position());
    AppMethodBeat.o(109662);
    return arrayOfByte;
  }
  
  public void write(byte paramByte, int paramInt)
  {
    AppMethodBeat.i(109666);
    reserve(3);
    if (paramByte == 0)
    {
      writeHead((byte)12, paramInt);
      AppMethodBeat.o(109666);
      return;
    }
    writeHead((byte)0, paramInt);
    this.bs.put(paramByte);
    AppMethodBeat.o(109666);
  }
  
  public void write(double paramDouble, int paramInt)
  {
    AppMethodBeat.i(109671);
    reserve(10);
    writeHead((byte)5, paramInt);
    this.bs.putDouble(paramDouble);
    AppMethodBeat.o(109671);
  }
  
  public void write(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(109670);
    reserve(6);
    writeHead((byte)4, paramInt);
    this.bs.putFloat(paramFloat);
    AppMethodBeat.o(109670);
  }
  
  public void write(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109668);
    reserve(6);
    if ((paramInt1 >= -32768) && (paramInt1 <= 32767))
    {
      write((short)paramInt1, paramInt2);
      AppMethodBeat.o(109668);
      return;
    }
    writeHead((byte)2, paramInt2);
    this.bs.putInt(paramInt1);
    AppMethodBeat.o(109668);
  }
  
  public void write(long paramLong, int paramInt)
  {
    AppMethodBeat.i(109669);
    reserve(10);
    if ((paramLong >= -2147483648L) && (paramLong <= 2147483647L))
    {
      write((int)paramLong, paramInt);
      AppMethodBeat.o(109669);
      return;
    }
    writeHead((byte)3, paramInt);
    this.bs.putLong(paramLong);
    AppMethodBeat.o(109669);
  }
  
  public void write(JceStruct paramJceStruct, int paramInt)
  {
    AppMethodBeat.i(109686);
    reserve(2);
    writeHead((byte)10, paramInt);
    paramJceStruct.writeTo(this);
    reserve(2);
    writeHead((byte)11, 0);
    AppMethodBeat.o(109686);
  }
  
  public void write(Boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(109688);
    write(paramBoolean.booleanValue(), paramInt);
    AppMethodBeat.o(109688);
  }
  
  public void write(Byte paramByte, int paramInt)
  {
    AppMethodBeat.i(109687);
    write(paramByte.byteValue(), paramInt);
    AppMethodBeat.o(109687);
  }
  
  public void write(Double paramDouble, int paramInt)
  {
    AppMethodBeat.i(109693);
    write(paramDouble.doubleValue(), paramInt);
    AppMethodBeat.o(109693);
  }
  
  public void write(Float paramFloat, int paramInt)
  {
    AppMethodBeat.i(109692);
    write(paramFloat.floatValue(), paramInt);
    AppMethodBeat.o(109692);
  }
  
  public void write(Integer paramInteger, int paramInt)
  {
    AppMethodBeat.i(109690);
    write(paramInteger.intValue(), paramInt);
    AppMethodBeat.o(109690);
  }
  
  public void write(Long paramLong, int paramInt)
  {
    AppMethodBeat.i(109691);
    write(paramLong.longValue(), paramInt);
    AppMethodBeat.o(109691);
  }
  
  public void write(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(109694);
    if ((paramObject instanceof Byte))
    {
      write(((Byte)paramObject).byteValue(), paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      write(((Boolean)paramObject).booleanValue(), paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof Short))
    {
      write(((Short)paramObject).shortValue(), paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      write(((Integer)paramObject).intValue(), paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof Long))
    {
      write(((Long)paramObject).longValue(), paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof Float))
    {
      write(((Float)paramObject).floatValue(), paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof Double))
    {
      write(((Double)paramObject).doubleValue(), paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof String))
    {
      write((String)paramObject, paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof Map))
    {
      write((Map)paramObject, paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof List))
    {
      write((List)paramObject, paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof JceStruct))
    {
      write((JceStruct)paramObject, paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      write((byte[])paramObject, paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof boolean[]))
    {
      write((boolean[])paramObject, paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof short[]))
    {
      write((short[])paramObject, paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof int[]))
    {
      write((int[])paramObject, paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof long[]))
    {
      write((long[])paramObject, paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof float[]))
    {
      write((float[])paramObject, paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof double[]))
    {
      write((double[])paramObject, paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if (paramObject.getClass().isArray())
    {
      writeArray((Object[])paramObject, paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    if ((paramObject instanceof Collection))
    {
      write((Collection)paramObject, paramInt);
      AppMethodBeat.o(109694);
      return;
    }
    paramObject = new JceEncodeException("write object error: unsupport type. " + paramObject.getClass());
    AppMethodBeat.o(109694);
    throw paramObject;
  }
  
  public void write(Short paramShort, int paramInt)
  {
    AppMethodBeat.i(109689);
    write(paramShort.shortValue(), paramInt);
    AppMethodBeat.o(109689);
  }
  
  public void write(String paramString, int paramInt)
  {
    AppMethodBeat.i(109674);
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
      AppMethodBeat.o(109674);
    }
    reserve(paramString.length + 10);
    if (paramString.length > 255)
    {
      writeHead((byte)7, paramInt);
      this.bs.putInt(paramString.length);
      this.bs.put(paramString);
      AppMethodBeat.o(109674);
      return;
    }
  }
  
  public <T> void write(Collection<T> paramCollection, int paramInt)
  {
    AppMethodBeat.i(109685);
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
        AppMethodBeat.o(109685);
        return;
        paramInt = paramCollection.size();
        break;
      }
      write((Object)paramCollection.next(), 0);
    }
  }
  
  public <K, V> void write(Map<K, V> paramMap, int paramInt)
  {
    AppMethodBeat.i(109675);
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
        AppMethodBeat.o(109675);
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
    AppMethodBeat.i(109667);
    reserve(4);
    if ((paramShort >= -128) && (paramShort <= 127))
    {
      write((byte)paramShort, paramInt);
      AppMethodBeat.o(109667);
      return;
    }
    writeHead((byte)1, paramInt);
    this.bs.putShort(paramShort);
    AppMethodBeat.o(109667);
  }
  
  public void write(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(109665);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      write((byte)i, paramInt);
      AppMethodBeat.o(109665);
      return;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(109677);
    reserve(paramArrayOfByte.length + 8);
    writeHead((byte)13, paramInt);
    writeHead((byte)0, 0);
    write(paramArrayOfByte.length, 0);
    this.bs.put(paramArrayOfByte);
    AppMethodBeat.o(109677);
  }
  
  public void write(double[] paramArrayOfDouble, int paramInt)
  {
    AppMethodBeat.i(109682);
    reserve(8);
    writeHead((byte)9, paramInt);
    write(paramArrayOfDouble.length, 0);
    int i = paramArrayOfDouble.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= i)
      {
        AppMethodBeat.o(109682);
        return;
      }
      write(paramArrayOfDouble[paramInt], 0);
      paramInt += 1;
    }
  }
  
  public void write(float[] paramArrayOfFloat, int paramInt)
  {
    AppMethodBeat.i(109681);
    reserve(8);
    writeHead((byte)9, paramInt);
    write(paramArrayOfFloat.length, 0);
    int i = paramArrayOfFloat.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= i)
      {
        AppMethodBeat.o(109681);
        return;
      }
      write(paramArrayOfFloat[paramInt], 0);
      paramInt += 1;
    }
  }
  
  public void write(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(109679);
    reserve(8);
    writeHead((byte)9, paramInt);
    write(paramArrayOfInt.length, 0);
    int i = paramArrayOfInt.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= i)
      {
        AppMethodBeat.o(109679);
        return;
      }
      write(paramArrayOfInt[paramInt], 0);
      paramInt += 1;
    }
  }
  
  public void write(long[] paramArrayOfLong, int paramInt)
  {
    AppMethodBeat.i(109680);
    reserve(8);
    writeHead((byte)9, paramInt);
    write(paramArrayOfLong.length, 0);
    int i = paramArrayOfLong.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= i)
      {
        AppMethodBeat.o(109680);
        return;
      }
      write(paramArrayOfLong[paramInt], 0);
      paramInt += 1;
    }
  }
  
  public <T> void write(T[] paramArrayOfT, int paramInt)
  {
    AppMethodBeat.i(109683);
    writeArray(paramArrayOfT, paramInt);
    AppMethodBeat.o(109683);
  }
  
  public void write(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(109678);
    reserve(8);
    writeHead((byte)9, paramInt);
    write(paramArrayOfShort.length, 0);
    int i = paramArrayOfShort.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= i)
      {
        AppMethodBeat.o(109678);
        return;
      }
      write(paramArrayOfShort[paramInt], 0);
      paramInt += 1;
    }
  }
  
  public void write(boolean[] paramArrayOfBoolean, int paramInt)
  {
    AppMethodBeat.i(109676);
    reserve(8);
    writeHead((byte)9, paramInt);
    write(paramArrayOfBoolean.length, 0);
    int i = paramArrayOfBoolean.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= i)
      {
        AppMethodBeat.o(109676);
        return;
      }
      write(paramArrayOfBoolean[paramInt], 0);
      paramInt += 1;
    }
  }
  
  public void writeByteString(String paramString, int paramInt)
  {
    AppMethodBeat.i(109673);
    reserve(paramString.length() + 10);
    paramString = HexUtil.hexStr2Bytes(paramString);
    if (paramString.length > 255)
    {
      writeHead((byte)7, paramInt);
      this.bs.putInt(paramString.length);
      this.bs.put(paramString);
      AppMethodBeat.o(109673);
      return;
    }
    writeHead((byte)6, paramInt);
    this.bs.put((byte)paramString.length);
    this.bs.put(paramString);
    AppMethodBeat.o(109673);
  }
  
  public void writeHead(byte paramByte, int paramInt)
  {
    AppMethodBeat.i(109664);
    byte b;
    if (paramInt < 15)
    {
      b = (byte)(paramInt << 4 | paramByte);
      this.bs.put(b);
      AppMethodBeat.o(109664);
      return;
    }
    if (paramInt < 256)
    {
      b = (byte)(paramByte | 0xF0);
      this.bs.put(b);
      this.bs.put((byte)paramInt);
      AppMethodBeat.o(109664);
      return;
    }
    JceEncodeException localJceEncodeException = new JceEncodeException("tag is too large: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(109664);
    throw localJceEncodeException;
  }
  
  public void writeStringByte(String paramString, int paramInt)
  {
    AppMethodBeat.i(109672);
    paramString = HexUtil.hexStr2Bytes(paramString);
    reserve(paramString.length + 10);
    if (paramString.length > 255)
    {
      writeHead((byte)7, paramInt);
      this.bs.putInt(paramString.length);
      this.bs.put(paramString);
      AppMethodBeat.o(109672);
      return;
    }
    writeHead((byte)6, paramInt);
    this.bs.put((byte)paramString.length);
    this.bs.put(paramString);
    AppMethodBeat.o(109672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.qq.taf.jce.JceOutputStream
 * JD-Core Version:    0.7.0.1
 */