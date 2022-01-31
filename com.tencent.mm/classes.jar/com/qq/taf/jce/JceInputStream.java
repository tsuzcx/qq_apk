package com.qq.taf.jce;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.nio.BufferUnderflowException;
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
  protected String sServerEncoding = "GBK";
  
  public JceInputStream() {}
  
  public JceInputStream(ByteBuffer paramByteBuffer)
  {
    this.bs = paramByteBuffer;
  }
  
  public JceInputStream(byte[] paramArrayOfByte)
  {
    this.bs = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public JceInputStream(byte[] paramArrayOfByte, int paramInt)
  {
    this.bs = ByteBuffer.wrap(paramArrayOfByte);
    this.bs.position(paramInt);
  }
  
  public static void main(String[] paramArrayOfString) {}
  
  private int peakHead(JceInputStream.HeadData paramHeadData)
  {
    return readHead(paramHeadData, this.bs.duplicate());
  }
  
  private <T> T[] readArrayImpl(T paramT, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      Object localObject = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject);
      switch (((JceInputStream.HeadData)localObject).type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      int i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
      localObject = (Object[])Array.newInstance(paramT.getClass(), i);
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= i) {
          return localObject;
        }
        localObject[paramInt] = read(paramT, 0, true);
        paramInt += 1;
      }
    }
    if (paramBoolean) {
      throw new JceDecodeException("require field not exist.");
    }
    return null;
  }
  
  public static int readHead(JceInputStream.HeadData paramHeadData, ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.get();
    paramHeadData.type = ((byte)(i & 0xF));
    paramHeadData.tag = ((i & 0xF0) >> 4);
    if (paramHeadData.tag == 15)
    {
      paramHeadData.tag = (paramByteBuffer.get() & 0xFF);
      return 2;
    }
    return 1;
  }
  
  private <K, V> Map<K, V> readMap(Map<K, V> paramMap1, Map<K, V> paramMap2, int paramInt, boolean paramBoolean)
  {
    if ((paramMap2 == null) || (paramMap2.isEmpty())) {
      paramMap2 = new HashMap();
    }
    do
    {
      return paramMap2;
      paramMap2 = (Map.Entry)paramMap2.entrySet().iterator().next();
      Object localObject1 = paramMap2.getKey();
      Object localObject2 = paramMap2.getValue();
      if (skipToTag(paramInt))
      {
        paramMap2 = new JceInputStream.HeadData();
        readHead(paramMap2);
        switch (paramMap2.type)
        {
        default: 
          throw new JceDecodeException("type mismatch.");
        }
        int i = read(0, 0, true);
        if (i < 0) {
          throw new JceDecodeException("size invalid: " + i);
        }
        paramInt = 0;
        for (;;)
        {
          paramMap2 = paramMap1;
          if (paramInt >= i) {
            break;
          }
          paramMap1.put(read(localObject1, 0, true), read(localObject2, 1, true));
          paramInt += 1;
        }
      }
      paramMap2 = paramMap1;
    } while (!paramBoolean);
    throw new JceDecodeException("require field not exist.");
  }
  
  private void skip(int paramInt)
  {
    this.bs.position(this.bs.position() + paramInt);
  }
  
  private void skipField()
  {
    JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
    readHead(localHeadData);
    skipField(localHeadData.type);
  }
  
  private void skipField(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    switch (paramByte)
    {
    default: 
      throw new JceDecodeException("invalid type.");
    case 0: 
      skip(1);
    case 11: 
    case 12: 
      return;
    case 1: 
      skip(2);
      return;
    case 2: 
      skip(4);
      return;
    case 3: 
      skip(8);
      return;
    case 4: 
      skip(4);
      return;
    case 5: 
      skip(8);
      return;
    case 6: 
      b1 = this.bs.get();
      paramByte = b1;
      if (b1 < 0) {
        paramByte = b1 + 256;
      }
      skip(paramByte);
      return;
    case 7: 
      skip(this.bs.getInt());
      return;
    case 8: 
      b2 = read(0, 0, true);
      paramByte = b1;
      while (paramByte < b2 * 2)
      {
        skipField();
        paramByte += 1;
      }
    case 9: 
      b1 = read(0, 0, true);
      paramByte = b2;
      while (paramByte < b1)
      {
        skipField();
        paramByte += 1;
      }
    case 13: 
      JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      if (localHeadData.type != 0) {
        throw new JceDecodeException("skipField with invalid type, type value: " + paramByte + ", " + localHeadData.type);
      }
      skip(read(0, 0, true));
      return;
    }
    skipToStructEnd();
  }
  
  public final JceStruct directRead(JceStruct paramJceStruct, int paramInt, boolean paramBoolean)
  {
    JceInputStream.HeadData localHeadData = null;
    if (skipToTag(paramInt))
    {
      try
      {
        paramJceStruct = paramJceStruct.newInit();
        localHeadData = new JceInputStream.HeadData();
        readHead(localHeadData);
        if (localHeadData.type != 10) {
          throw new JceDecodeException("type mismatch.");
        }
      }
      catch (Exception paramJceStruct)
      {
        throw new JceDecodeException(paramJceStruct.getMessage());
      }
      paramJceStruct.readFrom(this);
      skipToStructEnd();
    }
    do
    {
      return paramJceStruct;
      paramJceStruct = localHeadData;
    } while (!paramBoolean);
    throw new JceDecodeException("require field not exist.");
  }
  
  public final ByteBuffer getBs()
  {
    return this.bs;
  }
  
  public final byte read(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 12: 
        paramByte = 0;
      }
    }
    while (!paramBoolean)
    {
      JceInputStream.HeadData localHeadData;
      return paramByte;
      return this.bs.get();
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final double read(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 12: 
        paramDouble = 0.0D;
      }
    }
    while (!paramBoolean)
    {
      JceInputStream.HeadData localHeadData;
      return paramDouble;
      return this.bs.getFloat();
      return this.bs.getDouble();
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final float read(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 12: 
        paramFloat = 0.0F;
      }
    }
    while (!paramBoolean)
    {
      JceInputStream.HeadData localHeadData;
      return paramFloat;
      return this.bs.getFloat();
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final int read(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (skipToTag(paramInt2))
    {
      localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 12: 
        paramInt1 = 0;
      }
    }
    while (!paramBoolean)
    {
      JceInputStream.HeadData localHeadData;
      return paramInt1;
      return this.bs.get();
      return this.bs.getShort();
      return this.bs.getInt();
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final long read(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 12: 
        paramLong = 0L;
      }
    }
    while (!paramBoolean)
    {
      JceInputStream.HeadData localHeadData;
      return paramLong;
      return this.bs.get();
      return this.bs.getShort();
      return this.bs.getInt();
      return this.bs.getLong();
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final JceStruct read(JceStruct paramJceStruct, int paramInt, boolean paramBoolean)
  {
    JceInputStream.HeadData localHeadData = null;
    if (skipToTag(paramInt))
    {
      try
      {
        paramJceStruct = (JceStruct)paramJceStruct.getClass().newInstance();
        localHeadData = new JceInputStream.HeadData();
        readHead(localHeadData);
        if (localHeadData.type != 10) {
          throw new JceDecodeException("type mismatch.");
        }
      }
      catch (Exception paramJceStruct)
      {
        throw new JceDecodeException(paramJceStruct.getMessage());
      }
      paramJceStruct.readFrom(this);
      skipToStructEnd();
    }
    do
    {
      return paramJceStruct;
      paramJceStruct = localHeadData;
    } while (!paramBoolean);
    throw new JceDecodeException("require field not exist.");
  }
  
  public final <T> Object read(T paramT, int paramInt, boolean paramBoolean)
  {
    if ((paramT instanceof Byte)) {
      return Byte.valueOf(read((byte)0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Boolean)) {
      return Boolean.valueOf(read(false, paramInt, paramBoolean));
    }
    if ((paramT instanceof Short)) {
      return Short.valueOf(read((short)0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Integer)) {
      return Integer.valueOf(read(0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Long)) {
      return Long.valueOf(read(0L, paramInt, paramBoolean));
    }
    if ((paramT instanceof Float)) {
      return Float.valueOf(read(0.0F, paramInt, paramBoolean));
    }
    if ((paramT instanceof Double)) {
      return Double.valueOf(read(0.0D, paramInt, paramBoolean));
    }
    if ((paramT instanceof String)) {
      return readString(paramInt, paramBoolean);
    }
    if ((paramT instanceof Map)) {
      return readMap((Map)paramT, paramInt, paramBoolean);
    }
    if ((paramT instanceof List)) {
      return readArray((List)paramT, paramInt, paramBoolean);
    }
    if ((paramT instanceof JceStruct)) {
      return read((JceStruct)paramT, paramInt, paramBoolean);
    }
    if (paramT.getClass().isArray())
    {
      if (((paramT instanceof byte[])) || ((paramT instanceof Byte[]))) {
        return read(null, paramInt, paramBoolean);
      }
      if ((paramT instanceof boolean[])) {
        return read(null, paramInt, paramBoolean);
      }
      if ((paramT instanceof short[])) {
        return read(null, paramInt, paramBoolean);
      }
      if ((paramT instanceof int[])) {
        return read(null, paramInt, paramBoolean);
      }
      if ((paramT instanceof long[])) {
        return read(null, paramInt, paramBoolean);
      }
      if ((paramT instanceof float[])) {
        return read(null, paramInt, paramBoolean);
      }
      if ((paramT instanceof double[])) {
        return read(null, paramInt, paramBoolean);
      }
      return readArray((Object[])paramT, paramInt, paramBoolean);
    }
    throw new JceDecodeException("read object error: unsupport type.");
  }
  
  public final String read(String paramString, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramString = new JceInputStream.HeadData();
      readHead(paramString);
      switch (paramString.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 6: 
        i = this.bs.get();
        paramInt = i;
        if (i < 0) {
          paramInt = i + 256;
        }
        localObject = new byte[paramInt];
        this.bs.get((byte[])localObject);
      }
    }
    while (!paramBoolean)
    {
      Object localObject;
      try
      {
        int i;
        paramString = new String((byte[])localObject, this.sServerEncoding);
        return paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        return new String((byte[])localObject);
      }
      paramInt = this.bs.getInt();
      if ((paramInt > 104857600) || (paramInt < 0)) {
        throw new JceDecodeException("String too long: " + paramInt);
      }
      paramString = new byte[paramInt];
      this.bs.get(paramString);
      try
      {
        localObject = new String(paramString, this.sServerEncoding);
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        return new String(paramString);
      }
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final short read(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 12: 
        paramShort = 0;
      }
    }
    while (!paramBoolean)
    {
      JceInputStream.HeadData localHeadData;
      return paramShort;
      return (short)this.bs.get();
      return this.bs.getShort();
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final boolean read(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    paramBoolean1 = false;
    if (read((byte)0, paramInt, paramBoolean2) != 0) {
      paramBoolean1 = true;
    }
    return paramBoolean1;
  }
  
  public final byte[] read(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    paramArrayOfByte = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfByte = new JceInputStream.HeadData();
      readHead(paramArrayOfByte);
      switch (paramArrayOfByte.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 13: 
        localObject = new JceInputStream.HeadData();
        readHead((JceInputStream.HeadData)localObject);
        if (((JceInputStream.HeadData)localObject).type != 0) {
          throw new JceDecodeException("type mismatch, tag: " + paramInt + ", type: " + paramArrayOfByte.type + ", " + ((JceInputStream.HeadData)localObject).type);
        }
        i = read(0, 0, true);
        if (i < 0) {
          throw new JceDecodeException("invalid size, tag: " + paramInt + ", type: " + paramArrayOfByte.type + ", " + ((JceInputStream.HeadData)localObject).type + ", size: " + i);
        }
        paramArrayOfByte = new byte[i];
        this.bs.get(paramArrayOfByte);
      }
    }
    while (!paramBoolean)
    {
      return paramArrayOfByte;
      int i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
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
    throw new JceDecodeException("require field not exist.");
  }
  
  public final double[] read(double[] paramArrayOfDouble, int paramInt, boolean paramBoolean)
  {
    paramArrayOfDouble = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfDouble = new JceInputStream.HeadData();
      readHead(paramArrayOfDouble);
      switch (paramArrayOfDouble.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
      paramArrayOfDouble = new double[i];
      paramInt = 0;
      if (paramInt < i) {}
    }
    while (!paramBoolean) {
      for (;;)
      {
        int i;
        return paramArrayOfDouble;
        paramArrayOfDouble[paramInt] = read(paramArrayOfDouble[0], 0, true);
        paramInt += 1;
      }
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final float[] read(float[] paramArrayOfFloat, int paramInt, boolean paramBoolean)
  {
    paramArrayOfFloat = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfFloat = new JceInputStream.HeadData();
      readHead(paramArrayOfFloat);
      switch (paramArrayOfFloat.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
      paramArrayOfFloat = new float[i];
      paramInt = 0;
      if (paramInt < i) {}
    }
    while (!paramBoolean) {
      for (;;)
      {
        int i;
        return paramArrayOfFloat;
        paramArrayOfFloat[paramInt] = read(paramArrayOfFloat[0], 0, true);
        paramInt += 1;
      }
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final int[] read(int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    paramArrayOfInt = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfInt = new JceInputStream.HeadData();
      readHead(paramArrayOfInt);
      switch (paramArrayOfInt.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
      paramArrayOfInt = new int[i];
      paramInt = 0;
      if (paramInt < i) {}
    }
    while (!paramBoolean) {
      for (;;)
      {
        int i;
        return paramArrayOfInt;
        paramArrayOfInt[paramInt] = read(paramArrayOfInt[0], 0, true);
        paramInt += 1;
      }
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final long[] read(long[] paramArrayOfLong, int paramInt, boolean paramBoolean)
  {
    paramArrayOfLong = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfLong = new JceInputStream.HeadData();
      readHead(paramArrayOfLong);
      switch (paramArrayOfLong.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
      paramArrayOfLong = new long[i];
      paramInt = 0;
      if (paramInt < i) {}
    }
    while (!paramBoolean) {
      for (;;)
      {
        int i;
        return paramArrayOfLong;
        paramArrayOfLong[paramInt] = read(paramArrayOfLong[0], 0, true);
        paramInt += 1;
      }
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final JceStruct[] read(JceStruct[] paramArrayOfJceStruct, int paramInt, boolean paramBoolean)
  {
    return (JceStruct[])readArray(paramArrayOfJceStruct, paramInt, paramBoolean);
  }
  
  public final String[] read(String[] paramArrayOfString, int paramInt, boolean paramBoolean)
  {
    return (String[])readArray(paramArrayOfString, paramInt, paramBoolean);
  }
  
  public final short[] read(short[] paramArrayOfShort, int paramInt, boolean paramBoolean)
  {
    paramArrayOfShort = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfShort = new JceInputStream.HeadData();
      readHead(paramArrayOfShort);
      switch (paramArrayOfShort.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
      paramArrayOfShort = new short[i];
      paramInt = 0;
      if (paramInt < i) {}
    }
    while (!paramBoolean) {
      for (;;)
      {
        int i;
        return paramArrayOfShort;
        paramArrayOfShort[paramInt] = read(paramArrayOfShort[0], 0, true);
        paramInt += 1;
      }
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final boolean[] read(boolean[] paramArrayOfBoolean, int paramInt, boolean paramBoolean)
  {
    paramArrayOfBoolean = null;
    if (skipToTag(paramInt))
    {
      paramArrayOfBoolean = new JceInputStream.HeadData();
      readHead(paramArrayOfBoolean);
      switch (paramArrayOfBoolean.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
      paramArrayOfBoolean = new boolean[i];
      paramInt = 0;
      if (paramInt < i) {}
    }
    while (!paramBoolean) {
      for (;;)
      {
        int i;
        return paramArrayOfBoolean;
        paramArrayOfBoolean[paramInt] = read(paramArrayOfBoolean[0], 0, true);
        paramInt += 1;
      }
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final <T> List<T> readArray(List<T> paramList, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    if ((paramList == null) || (paramList.isEmpty())) {
      return new ArrayList();
    }
    paramList = readArrayImpl(paramList.get(0), paramInt, paramBoolean);
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramInt = i;
    for (;;)
    {
      if (paramInt >= paramList.length) {
        return localArrayList;
      }
      localArrayList.add(paramList[paramInt]);
      paramInt += 1;
    }
  }
  
  public final <T> T[] readArray(T[] paramArrayOfT, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayOfT == null) || (paramArrayOfT.length == 0)) {
      throw new JceDecodeException("unable to get type of key and value.");
    }
    return readArrayImpl(paramArrayOfT[0], paramInt, paramBoolean);
  }
  
  public final String readByteString(String paramString, int paramInt, boolean paramBoolean)
  {
    if (skipToTag(paramInt))
    {
      paramString = new JceInputStream.HeadData();
      readHead(paramString);
      switch (paramString.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
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
    while (!paramBoolean)
    {
      int i;
      return paramString;
      paramInt = this.bs.getInt();
      if ((paramInt > 104857600) || (paramInt < 0)) {
        throw new JceDecodeException("String too long: " + paramInt);
      }
      paramString = new byte[paramInt];
      this.bs.get(paramString);
      return HexUtil.bytes2HexStr(paramString);
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final void readHead(JceInputStream.HeadData paramHeadData)
  {
    readHead(paramHeadData, this.bs);
  }
  
  public final List readList(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (skipToTag(paramInt))
    {
      localObject = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject);
      switch (((JceInputStream.HeadData)localObject).type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      k = read(0, 0, true);
      if (k < 0) {
        throw new JceDecodeException("size invalid: " + k);
      }
      paramInt = 0;
      if (paramInt < k) {}
    }
    while (!paramBoolean)
    {
      int k;
      return localArrayList;
      Object localObject = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject);
      switch (((JceInputStream.HeadData)localObject).type)
      {
      case 11: 
      default: 
        throw new JceDecodeException("type mismatch.");
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
          localObject = (JceStruct)Class.forName(JceStruct.class.getName()).getConstructor(new Class[0]).newInstance(new Object[0]);
          ((JceStruct)localObject).readFrom(this);
          skipToStructEnd();
          localArrayList.add(localObject);
        }
        catch (Exception localException)
        {
          throw new JceDecodeException("type mismatch." + localException);
        }
        localException.add(new Integer(0));
      }
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final <K, V> HashMap<K, V> readMap(Map<K, V> paramMap, int paramInt, boolean paramBoolean)
  {
    return (HashMap)readMap(new HashMap(), paramMap, paramInt, paramBoolean);
  }
  
  public final String readString(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (skipToTag(paramInt))
    {
      localObject1 = new JceInputStream.HeadData();
      readHead((JceInputStream.HeadData)localObject1);
      switch (((JceInputStream.HeadData)localObject1).type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      case 6: 
        i = this.bs.get();
        paramInt = i;
        if (i < 0) {
          paramInt = i + 256;
        }
        localObject2 = new byte[paramInt];
        this.bs.get((byte[])localObject2);
      }
    }
    while (!paramBoolean)
    {
      Object localObject2;
      try
      {
        int i;
        localObject1 = new String((byte[])localObject2, this.sServerEncoding);
        return localObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        return new String((byte[])localObject2);
      }
      paramInt = this.bs.getInt();
      if ((paramInt > 104857600) || (paramInt < 0)) {
        throw new JceDecodeException("String too long: " + paramInt);
      }
      byte[] arrayOfByte = new byte[paramInt];
      this.bs.get(arrayOfByte);
      try
      {
        localObject2 = new String(arrayOfByte, this.sServerEncoding);
        return localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        return new String(arrayOfByte);
      }
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final Map<String, String> readStringMap(int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (skipToTag(paramInt))
    {
      localHeadData = new JceInputStream.HeadData();
      readHead(localHeadData);
      switch (localHeadData.type)
      {
      default: 
        throw new JceDecodeException("type mismatch.");
      }
      i = read(0, 0, true);
      if (i < 0) {
        throw new JceDecodeException("size invalid: " + i);
      }
      paramInt = 0;
      if (paramInt < i) {}
    }
    while (!paramBoolean) {
      for (;;)
      {
        JceInputStream.HeadData localHeadData;
        int i;
        return localHashMap;
        localHashMap.put(readString(0, true), readString(1, true));
        paramInt += 1;
      }
    }
    throw new JceDecodeException("require field not exist.");
  }
  
  public final int setServerEncoding(String paramString)
  {
    this.sServerEncoding = paramString;
    return 0;
  }
  
  public final void skipToStructEnd()
  {
    JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
    do
    {
      readHead(localHeadData);
      skipField(localHeadData.type);
    } while (localHeadData.type != 11);
  }
  
  public final boolean skipToTag(int paramInt)
  {
    try
    {
      JceInputStream.HeadData localHeadData = new JceInputStream.HeadData();
      for (;;)
      {
        int i = peakHead(localHeadData);
        if ((paramInt <= localHeadData.tag) || (localHeadData.type == 11))
        {
          if (paramInt != localHeadData.tag) {
            break;
          }
          return true;
        }
        skip(i);
        skipField(localHeadData.type);
      }
      return false;
    }
    catch (JceDecodeException localJceDecodeException)
    {
      return false;
    }
    catch (BufferUnderflowException localBufferUnderflowException) {}
  }
  
  public final void warp(byte[] paramArrayOfByte)
  {
    wrap(paramArrayOfByte);
  }
  
  public final void wrap(byte[] paramArrayOfByte)
  {
    this.bs = ByteBuffer.wrap(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.qq.taf.jce.JceInputStream
 * JD-Core Version:    0.7.0.1
 */