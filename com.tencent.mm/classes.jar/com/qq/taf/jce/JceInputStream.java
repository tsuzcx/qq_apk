package com.qq.taf.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class JceInputStream
{
  private ByteBuffer bs;
  protected String sServerEncoding;
  
  public JceInputStream()
  {
    this.sServerEncoding = "GBK";
  }
  
  public JceInputStream(ByteBuffer paramByteBuffer)
  {
    this.sServerEncoding = "GBK";
    this.bs = paramByteBuffer;
  }
  
  public JceInputStream(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109696);
    this.sServerEncoding = "GBK";
    this.bs = ByteBuffer.wrap(paramArrayOfByte);
    AppMethodBeat.o(109696);
  }
  
  public JceInputStream(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(109697);
    this.sServerEncoding = "GBK";
    this.bs = ByteBuffer.wrap(paramArrayOfByte);
    this.bs.position(paramInt);
    AppMethodBeat.o(109697);
  }
  
  public static void main(String[] paramArrayOfString) {}
  
  private int peakHead(HeadData paramHeadData)
  {
    AppMethodBeat.i(109702);
    int i = readHead(paramHeadData, this.bs.duplicate());
    AppMethodBeat.o(109702);
    return i;
  }
  
  private <T> T[] readArrayImpl(T paramT, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109732);
    if (skipToTag(paramInt))
    {
      Object localObject = new HeadData();
      readHead((HeadData)localObject);
      switch (((HeadData)localObject).type)
      {
      default: 
        paramT = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109732);
        throw paramT;
      }
      int i = read(0, 0, true);
      if (i < 0)
      {
        paramT = new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(109732);
        throw paramT;
      }
      localObject = (Object[])Array.newInstance(paramT.getClass(), i);
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= i)
        {
          AppMethodBeat.o(109732);
          return localObject;
        }
        localObject[paramInt] = read(paramT, 0, true);
        paramInt += 1;
      }
    }
    if (paramBoolean)
    {
      paramT = new JceDecodeException("require field not exist.");
      AppMethodBeat.o(109732);
      throw paramT;
    }
    AppMethodBeat.o(109732);
    return null;
  }
  
  public static int readHead(HeadData paramHeadData, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(109700);
    int i = paramByteBuffer.get();
    paramHeadData.type = ((byte)(i & 0xF));
    paramHeadData.tag = ((i & 0xF0) >> 4);
    if (paramHeadData.tag == 15)
    {
      paramHeadData.tag = (paramByteBuffer.get() & 0xFF);
      AppMethodBeat.o(109700);
      return 2;
    }
    AppMethodBeat.o(109700);
    return 1;
  }
  
  private <K, V> Map<K, V> readMap(Map<K, V> paramMap1, Map<K, V> paramMap2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109721);
    if ((paramMap2 == null) || (paramMap2.isEmpty()))
    {
      paramMap1 = new HashMap();
      AppMethodBeat.o(109721);
      return paramMap1;
    }
    Object localObject = (Map.Entry)paramMap2.entrySet().iterator().next();
    paramMap2 = ((Map.Entry)localObject).getKey();
    localObject = ((Map.Entry)localObject).getValue();
    if (skipToTag(paramInt))
    {
      localHeadData = new HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      default: 
        paramMap1 = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109721);
        throw paramMap1;
      }
      i = read(0, 0, true);
      if (i < 0)
      {
        paramMap1 = new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(109721);
        throw paramMap1;
      }
      paramInt = 0;
      if (paramInt < i) {}
    }
    while (!paramBoolean) {
      for (;;)
      {
        HeadData localHeadData;
        int i;
        AppMethodBeat.o(109721);
        return paramMap1;
        paramMap1.put(read(paramMap2, 0, true), read(localObject, 1, true));
        paramInt += 1;
      }
    }
    paramMap1 = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109721);
    throw paramMap1;
  }
  
  private void skip(int paramInt)
  {
    AppMethodBeat.i(109703);
    this.bs.position(this.bs.position() + paramInt);
    AppMethodBeat.o(109703);
  }
  
  private void skipField()
  {
    AppMethodBeat.i(109706);
    HeadData localHeadData = new HeadData();
    readHead(localHeadData);
    skipField(localHeadData.type);
    AppMethodBeat.o(109706);
  }
  
  private void skipField(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    AppMethodBeat.i(109707);
    Object localObject;
    switch (paramByte)
    {
    default: 
      localObject = new JceDecodeException("invalid type.");
      AppMethodBeat.o(109707);
      throw ((Throwable)localObject);
    case 0: 
      skip(1);
      AppMethodBeat.o(109707);
      return;
    case 1: 
      skip(2);
      AppMethodBeat.o(109707);
      return;
    case 2: 
      skip(4);
      AppMethodBeat.o(109707);
      return;
    case 3: 
      skip(8);
      AppMethodBeat.o(109707);
      return;
    case 4: 
      skip(4);
      AppMethodBeat.o(109707);
      return;
    case 5: 
      skip(8);
      AppMethodBeat.o(109707);
      return;
    case 6: 
      b1 = this.bs.get();
      paramByte = b1;
      if (b1 < 0) {
        paramByte = b1 + 256;
      }
      skip(paramByte);
      AppMethodBeat.o(109707);
      return;
    case 7: 
      skip(this.bs.getInt());
      AppMethodBeat.o(109707);
      return;
    case 8: 
      b2 = read(0, 0, true);
      paramByte = b1;
      for (;;)
      {
        if (paramByte >= b2 * 2)
        {
          AppMethodBeat.o(109707);
          return;
        }
        skipField();
        paramByte += 1;
      }
    case 9: 
      b1 = read(0, 0, true);
      paramByte = b2;
      for (;;)
      {
        if (paramByte >= b1)
        {
          AppMethodBeat.o(109707);
          return;
        }
        skipField();
        paramByte += 1;
      }
    case 13: 
      localObject = new HeadData();
      readHead((HeadData)localObject);
      if (((HeadData)localObject).type != 0)
      {
        localObject = new JceDecodeException("skipField with invalid type, type value: " + paramByte + ", " + ((HeadData)localObject).type);
        AppMethodBeat.o(109707);
        throw ((Throwable)localObject);
      }
      skip(read(0, 0, true));
      AppMethodBeat.o(109707);
      return;
    case 10: 
      skipToStructEnd();
      AppMethodBeat.o(109707);
      return;
    }
    AppMethodBeat.o(109707);
  }
  
  public final JceStruct directRead(JceStruct paramJceStruct, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109733);
    HeadData localHeadData = null;
    if (skipToTag(paramInt))
    {
      try
      {
        paramJceStruct = paramJceStruct.newInit();
        localHeadData = new HeadData();
        readHead(localHeadData);
        if (localHeadData.type != 10)
        {
          paramJceStruct = new JceDecodeException("type mismatch.");
          AppMethodBeat.o(109733);
          throw paramJceStruct;
        }
      }
      catch (Exception paramJceStruct)
      {
        paramJceStruct = new JceDecodeException(paramJceStruct.getMessage());
        AppMethodBeat.o(109733);
        throw paramJceStruct;
      }
      paramJceStruct.readFrom(this);
      skipToStructEnd();
    }
    do
    {
      AppMethodBeat.o(109733);
      return paramJceStruct;
      paramJceStruct = localHeadData;
    } while (!paramBoolean);
    paramJceStruct = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109733);
    throw paramJceStruct;
  }
  
  public final ByteBuffer getBs()
  {
    return this.bs;
  }
  
  public final byte read(byte paramByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109709);
    if (skipToTag(paramInt))
    {
      localObject = new HeadData();
      readHead((HeadData)localObject);
      switch (((HeadData)localObject).type)
      {
      default: 
        localObject = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109709);
        throw ((Throwable)localObject);
      case 12: 
        paramByte = 0;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        AppMethodBeat.o(109709);
        return paramByte;
        paramByte = this.bs.get();
      }
    }
    Object localObject = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109709);
    throw ((Throwable)localObject);
  }
  
  public final double read(double paramDouble, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109714);
    if (skipToTag(paramInt))
    {
      localObject = new HeadData();
      readHead((HeadData)localObject);
      switch (((HeadData)localObject).type)
      {
      default: 
        localObject = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109714);
        throw ((Throwable)localObject);
      case 12: 
        paramDouble = 0.0D;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        AppMethodBeat.o(109714);
        return paramDouble;
        paramDouble = this.bs.getFloat();
        continue;
        paramDouble = this.bs.getDouble();
      }
    }
    Object localObject = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109714);
    throw ((Throwable)localObject);
  }
  
  public final float read(float paramFloat, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109713);
    if (skipToTag(paramInt))
    {
      localObject = new HeadData();
      readHead((HeadData)localObject);
      switch (((HeadData)localObject).type)
      {
      default: 
        localObject = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109713);
        throw ((Throwable)localObject);
      case 12: 
        paramFloat = 0.0F;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        AppMethodBeat.o(109713);
        return paramFloat;
        paramFloat = this.bs.getFloat();
      }
    }
    Object localObject = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109713);
    throw ((Throwable)localObject);
  }
  
  public final int read(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(109711);
    if (skipToTag(paramInt2))
    {
      localObject = new HeadData();
      readHead((HeadData)localObject);
      switch (((HeadData)localObject).type)
      {
      default: 
        localObject = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109711);
        throw ((Throwable)localObject);
      case 12: 
        paramInt1 = 0;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        AppMethodBeat.o(109711);
        return paramInt1;
        paramInt1 = this.bs.get();
        continue;
        paramInt1 = this.bs.getShort();
        continue;
        paramInt1 = this.bs.getInt();
      }
    }
    Object localObject = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109711);
    throw ((Throwable)localObject);
  }
  
  public final long read(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109712);
    if (skipToTag(paramInt))
    {
      localObject = new HeadData();
      readHead((HeadData)localObject);
      switch (((HeadData)localObject).type)
      {
      default: 
        localObject = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109712);
        throw ((Throwable)localObject);
      case 12: 
        paramLong = 0L;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        AppMethodBeat.o(109712);
        return paramLong;
        paramLong = this.bs.get();
        continue;
        paramLong = this.bs.getShort();
        continue;
        paramLong = this.bs.getInt();
        continue;
        paramLong = this.bs.getLong();
      }
    }
    Object localObject = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109712);
    throw ((Throwable)localObject);
  }
  
  public final JceStruct read(JceStruct paramJceStruct, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109734);
    HeadData localHeadData = null;
    if (skipToTag(paramInt))
    {
      try
      {
        paramJceStruct = (JceStruct)paramJceStruct.getClass().newInstance();
        localHeadData = new HeadData();
        readHead(localHeadData);
        if (localHeadData.type != 10)
        {
          paramJceStruct = new JceDecodeException("type mismatch.");
          AppMethodBeat.o(109734);
          throw paramJceStruct;
        }
      }
      catch (Exception paramJceStruct)
      {
        paramJceStruct = new JceDecodeException(paramJceStruct.getMessage());
        AppMethodBeat.o(109734);
        throw paramJceStruct;
      }
      paramJceStruct.readFrom(this);
      skipToStructEnd();
    }
    do
    {
      AppMethodBeat.o(109734);
      return paramJceStruct;
      paramJceStruct = localHeadData;
    } while (!paramBoolean);
    paramJceStruct = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109734);
    throw paramJceStruct;
  }
  
  public final <T> Object read(T paramT, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109736);
    if ((paramT instanceof Byte))
    {
      byte b = read((byte)0, paramInt, paramBoolean);
      AppMethodBeat.o(109736);
      return Byte.valueOf(b);
    }
    if ((paramT instanceof Boolean))
    {
      paramBoolean = read(false, paramInt, paramBoolean);
      AppMethodBeat.o(109736);
      return Boolean.valueOf(paramBoolean);
    }
    if ((paramT instanceof Short))
    {
      short s = read((short)0, paramInt, paramBoolean);
      AppMethodBeat.o(109736);
      return Short.valueOf(s);
    }
    if ((paramT instanceof Integer))
    {
      paramInt = read(0, paramInt, paramBoolean);
      AppMethodBeat.o(109736);
      return Integer.valueOf(paramInt);
    }
    if ((paramT instanceof Long))
    {
      long l = read(0L, paramInt, paramBoolean);
      AppMethodBeat.o(109736);
      return Long.valueOf(l);
    }
    if ((paramT instanceof Float))
    {
      float f = read(0.0F, paramInt, paramBoolean);
      AppMethodBeat.o(109736);
      return Float.valueOf(f);
    }
    if ((paramT instanceof Double))
    {
      double d = read(0.0D, paramInt, paramBoolean);
      AppMethodBeat.o(109736);
      return Double.valueOf(d);
    }
    if ((paramT instanceof String))
    {
      paramT = readString(paramInt, paramBoolean);
      AppMethodBeat.o(109736);
      return paramT;
    }
    if ((paramT instanceof Map))
    {
      paramT = readMap((Map)paramT, paramInt, paramBoolean);
      AppMethodBeat.o(109736);
      return paramT;
    }
    if ((paramT instanceof List))
    {
      paramT = readArray((List)paramT, paramInt, paramBoolean);
      AppMethodBeat.o(109736);
      return paramT;
    }
    if ((paramT instanceof JceStruct))
    {
      paramT = read((JceStruct)paramT, paramInt, paramBoolean);
      AppMethodBeat.o(109736);
      return paramT;
    }
    if (paramT.getClass().isArray())
    {
      if (((paramT instanceof byte[])) || ((paramT instanceof Byte[])))
      {
        paramT = read(null, paramInt, paramBoolean);
        AppMethodBeat.o(109736);
        return paramT;
      }
      if ((paramT instanceof boolean[]))
      {
        paramT = read(null, paramInt, paramBoolean);
        AppMethodBeat.o(109736);
        return paramT;
      }
      if ((paramT instanceof short[]))
      {
        paramT = read(null, paramInt, paramBoolean);
        AppMethodBeat.o(109736);
        return paramT;
      }
      if ((paramT instanceof int[]))
      {
        paramT = read(null, paramInt, paramBoolean);
        AppMethodBeat.o(109736);
        return paramT;
      }
      if ((paramT instanceof long[]))
      {
        paramT = read(null, paramInt, paramBoolean);
        AppMethodBeat.o(109736);
        return paramT;
      }
      if ((paramT instanceof float[]))
      {
        paramT = read(null, paramInt, paramBoolean);
        AppMethodBeat.o(109736);
        return paramT;
      }
      if ((paramT instanceof double[]))
      {
        paramT = read(null, paramInt, paramBoolean);
        AppMethodBeat.o(109736);
        return paramT;
      }
      paramT = readArray((Object[])paramT, paramInt, paramBoolean);
      AppMethodBeat.o(109736);
      return paramT;
    }
    paramT = new JceDecodeException("read object error: unsupport type.");
    AppMethodBeat.o(109736);
    throw paramT;
  }
  
  public final String read(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109716);
    if (skipToTag(paramInt))
    {
      paramString = new HeadData();
      readHead(paramString);
      switch (paramString.type)
      {
      default: 
        paramString = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109716);
        throw paramString;
      case 6: 
        i = this.bs.get();
        paramInt = i;
        if (i < 0) {
          paramInt = i + 256;
        }
        arrayOfByte = new byte[paramInt];
        this.bs.get(arrayOfByte);
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        try
        {
          int i;
          paramString = new String(arrayOfByte, this.sServerEncoding);
          AppMethodBeat.o(109716);
          return paramString;
        }
        catch (UnsupportedEncodingException paramString)
        {
          paramString = new String(arrayOfByte);
          continue;
        }
        paramInt = this.bs.getInt();
        if ((paramInt > 104857600) || (paramInt < 0))
        {
          paramString = new JceDecodeException("String too long: ".concat(String.valueOf(paramInt)));
          AppMethodBeat.o(109716);
          throw paramString;
        }
        byte[] arrayOfByte = new byte[paramInt];
        this.bs.get(arrayOfByte);
        try
        {
          paramString = new String(arrayOfByte, this.sServerEncoding);
        }
        catch (UnsupportedEncodingException paramString)
        {
          paramString = new String(arrayOfByte);
        }
      }
    }
    paramString = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109716);
    throw paramString;
  }
  
  public final short read(short paramShort, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109710);
    if (skipToTag(paramInt))
    {
      localObject = new HeadData();
      readHead((HeadData)localObject);
      switch (((HeadData)localObject).type)
      {
      default: 
        localObject = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109710);
        throw ((Throwable)localObject);
      case 12: 
        paramShort = 0;
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        AppMethodBeat.o(109710);
        return paramShort;
        paramShort = (short)this.bs.get();
        continue;
        paramShort = this.bs.getShort();
      }
    }
    Object localObject = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109710);
    throw ((Throwable)localObject);
  }
  
  public final boolean read(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(109708);
    if (read((byte)0, paramInt, paramBoolean2) != 0)
    {
      AppMethodBeat.o(109708);
      return true;
    }
    AppMethodBeat.o(109708);
    return false;
  }
  
  public final byte[] read(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109724);
    paramArrayOfByte = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfByte = new HeadData();
      readHead(paramArrayOfByte);
      switch (paramArrayOfByte.type)
      {
      default: 
        paramArrayOfByte = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109724);
        throw paramArrayOfByte;
      case 13: 
        localObject = new HeadData();
        readHead((HeadData)localObject);
        if (((HeadData)localObject).type != 0)
        {
          paramArrayOfByte = new JceDecodeException("type mismatch, tag: " + paramInt + ", type: " + paramArrayOfByte.type + ", " + ((HeadData)localObject).type);
          AppMethodBeat.o(109724);
          throw paramArrayOfByte;
        }
        i = read(0, 0, true);
        if (i < 0)
        {
          paramArrayOfByte = new JceDecodeException("invalid size, tag: " + paramInt + ", type: " + paramArrayOfByte.type + ", " + ((HeadData)localObject).type + ", size: " + i);
          AppMethodBeat.o(109724);
          throw paramArrayOfByte;
        }
        paramArrayOfByte = new byte[i];
        this.bs.get(paramArrayOfByte);
      }
    }
    while (!paramBoolean)
    {
      AppMethodBeat.o(109724);
      return paramArrayOfByte;
      int i = read(0, 0, true);
      if (i < 0)
      {
        paramArrayOfByte = new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(109724);
        throw paramArrayOfByte;
      }
      Object localObject = new byte[i];
      paramInt = 0;
      for (;;)
      {
        paramArrayOfByte = (byte[])localObject;
        if (paramInt >= i) {
          break;
        }
        localObject[paramInt] = read(localObject[0], 0, true);
        paramInt += 1;
      }
    }
    paramArrayOfByte = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109724);
    throw paramArrayOfByte;
  }
  
  public final double[] read(double[] paramArrayOfDouble, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109729);
    paramArrayOfDouble = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfDouble = new HeadData();
      readHead(paramArrayOfDouble);
      switch (paramArrayOfDouble.type)
      {
      default: 
        paramArrayOfDouble = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109729);
        throw paramArrayOfDouble;
      }
      i = read(0, 0, true);
      if (i < 0)
      {
        paramArrayOfDouble = new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(109729);
        throw paramArrayOfDouble;
      }
      paramArrayOfDouble = new double[i];
      paramInt = 0;
      if (paramInt < i) {}
    }
    while (!paramBoolean) {
      for (;;)
      {
        int i;
        AppMethodBeat.o(109729);
        return paramArrayOfDouble;
        paramArrayOfDouble[paramInt] = read(paramArrayOfDouble[0], 0, true);
        paramInt += 1;
      }
    }
    paramArrayOfDouble = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109729);
    throw paramArrayOfDouble;
  }
  
  public final float[] read(float[] paramArrayOfFloat, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109728);
    paramArrayOfFloat = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfFloat = new HeadData();
      readHead(paramArrayOfFloat);
      switch (paramArrayOfFloat.type)
      {
      default: 
        paramArrayOfFloat = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109728);
        throw paramArrayOfFloat;
      }
      i = read(0, 0, true);
      if (i < 0)
      {
        paramArrayOfFloat = new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(109728);
        throw paramArrayOfFloat;
      }
      paramArrayOfFloat = new float[i];
      paramInt = 0;
      if (paramInt < i) {}
    }
    while (!paramBoolean) {
      for (;;)
      {
        int i;
        AppMethodBeat.o(109728);
        return paramArrayOfFloat;
        paramArrayOfFloat[paramInt] = read(paramArrayOfFloat[0], 0, true);
        paramInt += 1;
      }
    }
    paramArrayOfFloat = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109728);
    throw paramArrayOfFloat;
  }
  
  public final int[] read(int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109726);
    paramArrayOfInt = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfInt = new HeadData();
      readHead(paramArrayOfInt);
      switch (paramArrayOfInt.type)
      {
      default: 
        paramArrayOfInt = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109726);
        throw paramArrayOfInt;
      }
      i = read(0, 0, true);
      if (i < 0)
      {
        paramArrayOfInt = new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(109726);
        throw paramArrayOfInt;
      }
      paramArrayOfInt = new int[i];
      paramInt = 0;
      if (paramInt < i) {}
    }
    while (!paramBoolean) {
      for (;;)
      {
        int i;
        AppMethodBeat.o(109726);
        return paramArrayOfInt;
        paramArrayOfInt[paramInt] = read(paramArrayOfInt[0], 0, true);
        paramInt += 1;
      }
    }
    paramArrayOfInt = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109726);
    throw paramArrayOfInt;
  }
  
  public final long[] read(long[] paramArrayOfLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109727);
    paramArrayOfLong = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfLong = new HeadData();
      readHead(paramArrayOfLong);
      switch (paramArrayOfLong.type)
      {
      default: 
        paramArrayOfLong = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109727);
        throw paramArrayOfLong;
      }
      i = read(0, 0, true);
      if (i < 0)
      {
        paramArrayOfLong = new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(109727);
        throw paramArrayOfLong;
      }
      paramArrayOfLong = new long[i];
      paramInt = 0;
      if (paramInt < i) {}
    }
    while (!paramBoolean) {
      for (;;)
      {
        int i;
        AppMethodBeat.o(109727);
        return paramArrayOfLong;
        paramArrayOfLong[paramInt] = read(paramArrayOfLong[0], 0, true);
        paramInt += 1;
      }
    }
    paramArrayOfLong = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109727);
    throw paramArrayOfLong;
  }
  
  public final JceStruct[] read(JceStruct[] paramArrayOfJceStruct, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109735);
    paramArrayOfJceStruct = (JceStruct[])readArray(paramArrayOfJceStruct, paramInt, paramBoolean);
    AppMethodBeat.o(109735);
    return paramArrayOfJceStruct;
  }
  
  public final String[] read(String[] paramArrayOfString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109718);
    paramArrayOfString = (String[])readArray(paramArrayOfString, paramInt, paramBoolean);
    AppMethodBeat.o(109718);
    return paramArrayOfString;
  }
  
  public final short[] read(short[] paramArrayOfShort, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109725);
    paramArrayOfShort = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfShort = new HeadData();
      readHead(paramArrayOfShort);
      switch (paramArrayOfShort.type)
      {
      default: 
        paramArrayOfShort = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109725);
        throw paramArrayOfShort;
      }
      i = read(0, 0, true);
      if (i < 0)
      {
        paramArrayOfShort = new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(109725);
        throw paramArrayOfShort;
      }
      paramArrayOfShort = new short[i];
      paramInt = 0;
      if (paramInt < i) {}
    }
    while (!paramBoolean) {
      for (;;)
      {
        int i;
        AppMethodBeat.o(109725);
        return paramArrayOfShort;
        paramArrayOfShort[paramInt] = read(paramArrayOfShort[0], 0, true);
        paramInt += 1;
      }
    }
    paramArrayOfShort = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109725);
    throw paramArrayOfShort;
  }
  
  public final boolean[] read(boolean[] paramArrayOfBoolean, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109723);
    paramArrayOfBoolean = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfBoolean = new HeadData();
      readHead(paramArrayOfBoolean);
      switch (paramArrayOfBoolean.type)
      {
      default: 
        paramArrayOfBoolean = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109723);
        throw paramArrayOfBoolean;
      }
      i = read(0, 0, true);
      if (i < 0)
      {
        paramArrayOfBoolean = new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(109723);
        throw paramArrayOfBoolean;
      }
      paramArrayOfBoolean = new boolean[i];
      paramInt = 0;
      if (paramInt < i) {}
    }
    while (!paramBoolean) {
      for (;;)
      {
        int i;
        AppMethodBeat.o(109723);
        return paramArrayOfBoolean;
        paramArrayOfBoolean[paramInt] = read(paramArrayOfBoolean[0], 0, true);
        paramInt += 1;
      }
    }
    paramArrayOfBoolean = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109723);
    throw paramArrayOfBoolean;
  }
  
  public final <T> List<T> readArray(List<T> paramList, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(109731);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = new ArrayList();
      AppMethodBeat.o(109731);
      return paramList;
    }
    paramList = readArrayImpl(paramList.get(0), paramInt, paramBoolean);
    if (paramList == null)
    {
      AppMethodBeat.o(109731);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramInt = i;
    for (;;)
    {
      if (paramInt >= paramList.length)
      {
        AppMethodBeat.o(109731);
        return localArrayList;
      }
      localArrayList.add(paramList[paramInt]);
      paramInt += 1;
    }
  }
  
  public final <T> T[] readArray(T[] paramArrayOfT, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109730);
    if ((paramArrayOfT == null) || (paramArrayOfT.length == 0))
    {
      paramArrayOfT = new JceDecodeException("unable to get type of key and value.");
      AppMethodBeat.o(109730);
      throw paramArrayOfT;
    }
    paramArrayOfT = readArrayImpl(paramArrayOfT[0], paramInt, paramBoolean);
    AppMethodBeat.o(109730);
    return paramArrayOfT;
  }
  
  public final String readByteString(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109715);
    if (skipToTag(paramInt))
    {
      paramString = new HeadData();
      readHead(paramString);
      switch (paramString.type)
      {
      default: 
        paramString = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109715);
        throw paramString;
      case 6: 
        i = this.bs.get();
        paramInt = i;
        if (i < 0) {
          paramInt = i + 256;
        }
        paramString = new byte[paramInt];
        this.bs.get(paramString);
        paramString = HexUtil.bytes2HexStr(paramString);
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        int i;
        AppMethodBeat.o(109715);
        return paramString;
        paramInt = this.bs.getInt();
        if ((paramInt > 104857600) || (paramInt < 0))
        {
          paramString = new JceDecodeException("String too long: ".concat(String.valueOf(paramInt)));
          AppMethodBeat.o(109715);
          throw paramString;
        }
        paramString = new byte[paramInt];
        this.bs.get(paramString);
        paramString = HexUtil.bytes2HexStr(paramString);
      }
    }
    paramString = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109715);
    throw paramString;
  }
  
  public final void readHead(HeadData paramHeadData)
  {
    AppMethodBeat.i(109701);
    readHead(paramHeadData, this.bs);
    AppMethodBeat.o(109701);
  }
  
  public final List readList(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109722);
    Object localObject1 = new ArrayList();
    if (skipToTag(paramInt))
    {
      localObject2 = new HeadData();
      readHead((HeadData)localObject2);
      switch (((HeadData)localObject2).type)
      {
      default: 
        localObject1 = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109722);
        throw ((Throwable)localObject1);
      }
      k = read(0, 0, true);
      if (k < 0)
      {
        localObject1 = new JceDecodeException("size invalid: ".concat(String.valueOf(k)));
        AppMethodBeat.o(109722);
        throw ((Throwable)localObject1);
      }
      paramInt = 0;
      if (paramInt < k) {}
    }
    while (!paramBoolean)
    {
      int k;
      AppMethodBeat.o(109722);
      return localObject1;
      Object localObject2 = new HeadData();
      readHead((HeadData)localObject2);
      switch (((HeadData)localObject2).type)
      {
      case 11: 
      default: 
        localObject1 = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109722);
        throw ((Throwable)localObject1);
      case 0: 
        skip(1);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        skip(2);
        continue;
        skip(4);
        continue;
        skip(8);
        continue;
        skip(4);
        continue;
        skip(8);
        continue;
        int j = this.bs.get();
        int i = j;
        if (j < 0) {
          i = j + 256;
        }
        skip(i);
        continue;
        skip(this.bs.getInt());
        continue;
        try
        {
          localObject2 = (JceStruct)Class.forName(JceStruct.class.getName()).getConstructor(new Class[0]).newInstance(new Object[0]);
          ((JceStruct)localObject2).readFrom(this);
          skipToStructEnd();
          ((List)localObject1).add(localObject2);
        }
        catch (Exception localException)
        {
          localJceDecodeException = new JceDecodeException("type mismatch.".concat(String.valueOf(localException)));
          AppMethodBeat.o(109722);
          throw localJceDecodeException;
        }
        localJceDecodeException.add(Integer.valueOf(0));
      }
    }
    JceDecodeException localJceDecodeException = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109722);
    throw localJceDecodeException;
  }
  
  public final <K, V> HashMap<K, V> readMap(Map<K, V> paramMap, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109720);
    paramMap = (HashMap)readMap(new HashMap(), paramMap, paramInt, paramBoolean);
    AppMethodBeat.o(109720);
    return paramMap;
  }
  
  public final String readString(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109717);
    Object localObject1 = null;
    if (skipToTag(paramInt))
    {
      localObject1 = new HeadData();
      readHead((HeadData)localObject1);
      switch (((HeadData)localObject1).type)
      {
      default: 
        localObject1 = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109717);
        throw ((Throwable)localObject1);
      case 6: 
        i = this.bs.get();
        paramInt = i;
        if (i < 0) {
          paramInt = i + 256;
        }
        arrayOfByte = new byte[paramInt];
        this.bs.get(arrayOfByte);
      }
    }
    while (!paramBoolean) {
      for (;;)
      {
        Object localObject2;
        try
        {
          int i;
          localObject1 = new String(arrayOfByte, this.sServerEncoding);
          AppMethodBeat.o(109717);
          return localObject1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          localObject2 = new String(arrayOfByte);
          continue;
        }
        paramInt = this.bs.getInt();
        if ((paramInt > 104857600) || (paramInt < 0))
        {
          localObject2 = new JceDecodeException("String too long: ".concat(String.valueOf(paramInt)));
          AppMethodBeat.o(109717);
          throw ((Throwable)localObject2);
        }
        byte[] arrayOfByte = new byte[paramInt];
        this.bs.get(arrayOfByte);
        try
        {
          localObject2 = new String(arrayOfByte, this.sServerEncoding);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          localObject3 = new String(arrayOfByte);
        }
      }
    }
    Object localObject3 = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109717);
    throw ((Throwable)localObject3);
  }
  
  public final Map<String, String> readStringMap(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109719);
    Object localObject = new HashMap();
    if (skipToTag(paramInt))
    {
      localHeadData = new HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      default: 
        localObject = new JceDecodeException("type mismatch.");
        AppMethodBeat.o(109719);
        throw ((Throwable)localObject);
      }
      i = read(0, 0, true);
      if (i < 0)
      {
        localObject = new JceDecodeException("size invalid: ".concat(String.valueOf(i)));
        AppMethodBeat.o(109719);
        throw ((Throwable)localObject);
      }
      paramInt = 0;
      if (paramInt < i) {}
    }
    while (!paramBoolean) {
      for (;;)
      {
        HeadData localHeadData;
        int i;
        AppMethodBeat.o(109719);
        return localObject;
        ((HashMap)localObject).put(readString(0, true), readString(1, true));
        paramInt += 1;
      }
    }
    localObject = new JceDecodeException("require field not exist.");
    AppMethodBeat.o(109719);
    throw ((Throwable)localObject);
  }
  
  public final int setServerEncoding(String paramString)
  {
    this.sServerEncoding = paramString;
    return 0;
  }
  
  public final void skipToStructEnd()
  {
    AppMethodBeat.i(109705);
    HeadData localHeadData = new HeadData();
    do
    {
      readHead(localHeadData);
      skipField(localHeadData.type);
    } while (localHeadData.type != 11);
    AppMethodBeat.o(109705);
  }
  
  /* Error */
  public final boolean skipToTag(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 473
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 6	com/qq/taf/jce/JceInputStream$HeadData
    //   9: dup
    //   10: invokespecial 67	com/qq/taf/jce/JceInputStream$HeadData:<init>	()V
    //   13: astore_3
    //   14: aload_0
    //   15: aload_3
    //   16: invokespecial 475	com/qq/taf/jce/JceInputStream:peakHead	(Lcom/qq/taf/jce/JceInputStream$HeadData;)I
    //   19: istore_2
    //   20: iload_1
    //   21: aload_3
    //   22: getfield 125	com/qq/taf/jce/JceInputStream$HeadData:tag	I
    //   25: if_icmple +12 -> 37
    //   28: aload_3
    //   29: getfield 74	com/qq/taf/jce/JceInputStream$HeadData:type	B
    //   32: bipush 11
    //   34: if_icmpne +27 -> 61
    //   37: iload_1
    //   38: aload_3
    //   39: getfield 125	com/qq/taf/jce/JceInputStream$HeadData:tag	I
    //   42: if_icmpne +11 -> 53
    //   45: ldc_w 473
    //   48: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_1
    //   52: ireturn
    //   53: ldc_w 473
    //   56: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: iconst_0
    //   60: ireturn
    //   61: aload_0
    //   62: iload_2
    //   63: invokespecial 181	com/qq/taf/jce/JceInputStream:skip	(I)V
    //   66: aload_0
    //   67: aload_3
    //   68: getfield 74	com/qq/taf/jce/JceInputStream$HeadData:type	B
    //   71: invokespecial 176	com/qq/taf/jce/JceInputStream:skipField	(B)V
    //   74: goto -60 -> 14
    //   77: astore_3
    //   78: ldc_w 473
    //   81: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: iconst_0
    //   85: ireturn
    //   86: astore_3
    //   87: goto -9 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	JceInputStream
    //   0	90	1	paramInt	int
    //   19	44	2	i	int
    //   13	55	3	localHeadData	HeadData
    //   77	1	3	localJceDecodeException	JceDecodeException
    //   86	1	3	localBufferUnderflowException	java.nio.BufferUnderflowException
    // Exception table:
    //   from	to	target	type
    //   6	14	77	com/qq/taf/jce/JceDecodeException
    //   14	37	77	com/qq/taf/jce/JceDecodeException
    //   37	51	77	com/qq/taf/jce/JceDecodeException
    //   61	74	77	com/qq/taf/jce/JceDecodeException
    //   6	14	86	java/nio/BufferUnderflowException
    //   14	37	86	java/nio/BufferUnderflowException
    //   37	51	86	java/nio/BufferUnderflowException
    //   61	74	86	java/nio/BufferUnderflowException
  }
  
  public final void warp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109698);
    wrap(paramArrayOfByte);
    AppMethodBeat.o(109698);
  }
  
  public final void wrap(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109699);
    this.bs = ByteBuffer.wrap(paramArrayOfByte);
    AppMethodBeat.o(109699);
  }
  
  public static class HeadData
  {
    public int tag;
    public byte type;
    
    public void clear()
    {
      this.type = 0;
      this.tag = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.qq.taf.jce.JceInputStream
 * JD-Core Version:    0.7.0.1
 */