package com.hilive.mediasdk.serialize;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Marshallable
{
  public static final int PACKET_SIZE = 4096;
  private static final String TAG = "Marshallable";
  protected ByteBuffer mBuffer;
  
  public Marshallable()
  {
    AppMethodBeat.i(142863);
    this.mBuffer = null;
    this.mBuffer = ByteBuffer.allocate(4096);
    this.mBuffer.order(ByteOrder.LITTLE_ENDIAN);
    AppMethodBeat.o(142863);
  }
  
  public Marshallable(int paramInt)
  {
    AppMethodBeat.i(142865);
    this.mBuffer = null;
    this.mBuffer = ByteBuffer.allocate(paramInt);
    this.mBuffer.order(ByteOrder.LITTLE_ENDIAN);
    AppMethodBeat.o(142865);
  }
  
  public Marshallable(boolean paramBoolean)
  {
    AppMethodBeat.i(142864);
    this.mBuffer = null;
    if (paramBoolean)
    {
      this.mBuffer = ByteBuffer.allocate(4096);
      this.mBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }
    AppMethodBeat.o(142864);
  }
  
  private <T> T popElem(Class<T> paramClass, Marshallable.ELenType paramELenType, String paramString)
  {
    AppMethodBeat.i(142909);
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramClass == Integer.class) {
      paramClass = Integer.valueOf(popInt());
    }
    for (;;)
    {
      AppMethodBeat.o(142909);
      return paramClass;
      if (paramClass == Short.class)
      {
        paramClass = Short.valueOf(popShort());
        continue;
      }
      if (paramClass == Long.class)
      {
        paramClass = Long.valueOf(popInt64());
        continue;
      }
      if (paramClass == Byte.class)
      {
        paramClass = Byte.valueOf(popByte());
        continue;
      }
      if (paramClass == String.class)
      {
        if (paramELenType == Marshallable.ELenType.E_SHORT)
        {
          paramClass = popString16(paramString);
          continue;
        }
        paramClass = localObject2;
        if (paramELenType != Marshallable.ELenType.E_INT) {
          continue;
        }
        paramClass = popString32(paramString);
        continue;
      }
      if (paramClass == [B.class)
      {
        if (paramELenType == Marshallable.ELenType.E_SHORT)
        {
          paramClass = popBytes();
          continue;
        }
        paramClass = localObject2;
        if (paramELenType != Marshallable.ELenType.E_INT) {
          continue;
        }
        paramClass = popBytes32();
        continue;
      }
      try
      {
        paramELenType = paramClass.newInstance();
        paramClass = paramELenType;
        if (!(paramELenType instanceof Marshallable)) {
          continue;
        }
        ((Marshallable)paramELenType).unmarshall(this.mBuffer);
        paramClass = paramELenType;
      }
      catch (InstantiationException paramClass)
      {
        for (;;)
        {
          paramELenType = localObject1;
        }
      }
      catch (IllegalAccessException paramClass)
      {
        for (;;)
        {
          paramELenType = localObject1;
        }
      }
    }
  }
  
  private <K> K popKey(Class<K> paramClass, Marshallable.ELenType paramELenType, String paramString)
  {
    AppMethodBeat.i(142907);
    Object localObject = null;
    if (paramClass == Byte.class) {
      paramClass = Short.valueOf((short)popByte());
    }
    for (;;)
    {
      AppMethodBeat.o(142907);
      return paramClass;
      if (paramClass == Short.class)
      {
        paramClass = Short.valueOf(popShort());
      }
      else if (paramClass == Integer.class)
      {
        paramClass = Integer.valueOf(popInt());
      }
      else if (paramClass == Long.class)
      {
        paramClass = Long.valueOf(popInt64());
      }
      else if (paramClass == [B.class)
      {
        if (paramELenType == Marshallable.ELenType.E_SHORT)
        {
          paramClass = popBytes();
        }
        else
        {
          paramClass = localObject;
          if (paramELenType == Marshallable.ELenType.E_INT) {
            paramClass = popBytes32();
          }
        }
      }
      else
      {
        if (paramClass != String.class) {
          break;
        }
        if (paramELenType == Marshallable.ELenType.E_SHORT)
        {
          paramClass = popString16(paramString);
        }
        else
        {
          paramClass = localObject;
          if (paramELenType == Marshallable.ELenType.E_INT) {
            paramClass = popString32(paramString);
          }
        }
      }
    }
    paramClass = new IllegalStateException("unMarshall Map but unknown key type: " + paramClass.getName());
    AppMethodBeat.o(142907);
    throw paramClass;
  }
  
  private <T> void pushElem(T paramT, Class<T> paramClass, Marshallable.ELenType paramELenType)
  {
    AppMethodBeat.i(142908);
    if (paramClass == Integer.class)
    {
      pushInt(((Integer)paramT).intValue());
      AppMethodBeat.o(142908);
      return;
    }
    if (paramClass == Short.class)
    {
      pushShort(((Short)paramT).shortValue());
      AppMethodBeat.o(142908);
      return;
    }
    if (paramClass == Long.class)
    {
      pushInt64(((Long)paramT).longValue());
      AppMethodBeat.o(142908);
      return;
    }
    if (paramClass == Byte.class)
    {
      pushByte(((Byte)paramT).byteValue());
      AppMethodBeat.o(142908);
      return;
    }
    if (paramClass == String.class)
    {
      if (paramELenType == Marshallable.ELenType.E_SHORT)
      {
        pushString16((String)paramT);
        AppMethodBeat.o(142908);
        return;
      }
      if (paramELenType == Marshallable.ELenType.E_INT)
      {
        pushString32((String)paramT);
        AppMethodBeat.o(142908);
      }
    }
    else if (paramClass == [B.class)
    {
      if (paramELenType == Marshallable.ELenType.E_SHORT)
      {
        pushBytes((byte[])paramT);
        AppMethodBeat.o(142908);
        return;
      }
      if (paramELenType == Marshallable.ELenType.E_INT)
      {
        pushBytes32((byte[])paramT);
        AppMethodBeat.o(142908);
      }
    }
    else
    {
      if ((paramT instanceof Marshallable))
      {
        ((Marshallable)paramT).marshall(this.mBuffer);
        AppMethodBeat.o(142908);
        return;
      }
      paramT = new RuntimeException("unable to marshal element of class " + paramClass.getName());
      AppMethodBeat.o(142908);
      throw paramT;
    }
    AppMethodBeat.o(142908);
  }
  
  private <K> void pushKey(K paramK, Marshallable.ELenType paramELenType)
  {
    AppMethodBeat.i(142906);
    if ((paramK instanceof Byte))
    {
      pushByte(((Byte)paramK).byteValue());
      AppMethodBeat.o(142906);
      return;
    }
    if ((paramK instanceof Short))
    {
      pushShort(((Short)paramK).shortValue());
      AppMethodBeat.o(142906);
      return;
    }
    if ((paramK instanceof Integer))
    {
      pushInt(((Integer)paramK).intValue());
      AppMethodBeat.o(142906);
      return;
    }
    if ((paramK instanceof Long))
    {
      pushInt64(((Long)paramK).longValue());
      AppMethodBeat.o(142906);
      return;
    }
    if ((paramK instanceof String))
    {
      pushString16((String)paramK);
      AppMethodBeat.o(142906);
      return;
    }
    if ((paramK instanceof byte[]))
    {
      pushBytes((byte[])paramK);
      AppMethodBeat.o(142906);
      return;
    }
    paramK = new IllegalStateException("marshall Map but unknown key type: " + paramK.getClass().getName());
    AppMethodBeat.o(142906);
    throw paramK;
  }
  
  protected void check_capactiy(int paramInt)
  {
    AppMethodBeat.i(142902);
    if (this.mBuffer.capacity() - this.mBuffer.position() < paramInt) {
      increase_capacity(paramInt - (this.mBuffer.capacity() - this.mBuffer.position()));
    }
    AppMethodBeat.o(142902);
  }
  
  public ByteBuffer getBuffer()
  {
    return this.mBuffer;
  }
  
  protected void increase_capacity(int paramInt)
  {
    AppMethodBeat.i(142903);
    int j = this.mBuffer.capacity();
    if (j == 0)
    {
      AppMethodBeat.o(142903);
      return;
    }
    int i = j * 2;
    if (paramInt > j) {
      i = j + paramInt;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    this.mBuffer.limit(this.mBuffer.position());
    this.mBuffer.position(0);
    localByteBuffer.put(this.mBuffer);
    this.mBuffer = localByteBuffer;
    AppMethodBeat.o(142903);
  }
  
  public void marshall(ByteBuffer paramByteBuffer)
  {
    this.mBuffer = paramByteBuffer;
  }
  
  public byte[] marshall()
  {
    AppMethodBeat.i(142866);
    byte[] arrayOfByte = new byte[this.mBuffer.position()];
    this.mBuffer.position(0);
    this.mBuffer.get(arrayOfByte);
    AppMethodBeat.o(142866);
    return arrayOfByte;
  }
  
  public byte[] popAll()
  {
    AppMethodBeat.i(142876);
    byte[] arrayOfByte = new byte[this.mBuffer.remaining()];
    this.mBuffer.get(arrayOfByte);
    AppMethodBeat.o(142876);
    return arrayOfByte;
  }
  
  public Boolean popBool()
  {
    boolean bool = true;
    AppMethodBeat.i(142869);
    if (this.mBuffer.get() == 1) {}
    for (;;)
    {
      AppMethodBeat.o(142869);
      return Boolean.valueOf(bool);
      bool = false;
    }
  }
  
  public byte popByte()
  {
    AppMethodBeat.i(142871);
    byte b = this.mBuffer.get();
    AppMethodBeat.o(142871);
    return b;
  }
  
  public byte[] popBytes()
  {
    AppMethodBeat.i(142873);
    int i = this.mBuffer.getShort();
    byte[] arrayOfByte = null;
    if (i >= 0)
    {
      arrayOfByte = new byte[i];
      this.mBuffer.get(arrayOfByte);
    }
    AppMethodBeat.o(142873);
    return arrayOfByte;
  }
  
  public byte[] popBytes32()
  {
    AppMethodBeat.i(142875);
    int i = this.mBuffer.getInt();
    byte[] arrayOfByte = null;
    if (i >= 0)
    {
      arrayOfByte = new byte[i];
      this.mBuffer.get(arrayOfByte);
    }
    AppMethodBeat.o(142875);
    return arrayOfByte;
  }
  
  public <T> Collection<T> popCollection(Class<? extends Collection> paramClass, Class<T> paramClass1)
  {
    AppMethodBeat.i(142912);
    paramClass = popCollection(paramClass, paramClass1, Marshallable.ELenType.E_SHORT, "utf-8");
    AppMethodBeat.o(142912);
    return paramClass;
  }
  
  public <T> Collection<T> popCollection(Class<? extends Collection> paramClass, Class<T> paramClass1, Marshallable.ELenType paramELenType, String paramString)
  {
    AppMethodBeat.i(142913);
    int j = popInt();
    try
    {
      paramClass = (Collection)paramClass.newInstance();
      if (paramClass == null)
      {
        AppMethodBeat.o(142913);
        return null;
      }
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        paramClass = null;
      }
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        paramClass = null;
      }
      int i = 0;
      while (i < j)
      {
        paramClass.add(popElem(paramClass1, paramELenType, paramString));
        i += 1;
      }
      AppMethodBeat.o(142913);
    }
    return paramClass;
  }
  
  public float popFloat()
  {
    AppMethodBeat.i(142882);
    float f = this.mBuffer.getFloat();
    AppMethodBeat.o(142882);
    return f;
  }
  
  public int popInt()
  {
    AppMethodBeat.i(142883);
    int i = this.mBuffer.getInt();
    AppMethodBeat.o(142883);
    return i;
  }
  
  public long popInt2Long()
  {
    AppMethodBeat.i(142884);
    long l = this.mBuffer.getInt();
    AppMethodBeat.o(142884);
    return l & 0xFFFFFFFF;
  }
  
  public long popInt64()
  {
    AppMethodBeat.i(142886);
    long l = this.mBuffer.getLong();
    AppMethodBeat.o(142886);
    return l;
  }
  
  public int[] popIntArray()
  {
    AppMethodBeat.i(142893);
    int j = popShort();
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = popInt();
      i += 1;
    }
    AppMethodBeat.o(142893);
    return arrayOfInt;
  }
  
  public long[] popIntArray2Long()
  {
    AppMethodBeat.i(142894);
    int j = popShort();
    long[] arrayOfLong = new long[j];
    int i = 0;
    while (i < j)
    {
      arrayOfLong[i] = popInt2Long();
      i += 1;
    }
    AppMethodBeat.o(142894);
    return arrayOfLong;
  }
  
  public <K, T> Map<K, T> popMap(Class<K> paramClass, Marshallable.ELenType paramELenType1, String paramString1, Class<T> paramClass1, Marshallable.ELenType paramELenType2, String paramString2)
  {
    AppMethodBeat.i(142917);
    int j = popInt();
    TreeMap localTreeMap = new TreeMap();
    int i = 0;
    while (i < j)
    {
      localTreeMap.put(popKey(paramClass, paramELenType1, paramString1), popElem(paramClass1, paramELenType2, paramString2));
      i += 1;
    }
    AppMethodBeat.o(142917);
    return localTreeMap;
  }
  
  public <K, T> Map<K, T> popMap(Class<K> paramClass, Class<T> paramClass1)
  {
    AppMethodBeat.i(142916);
    paramClass = popMap(paramClass, Marshallable.ELenType.E_SHORT, "utf-8", paramClass1, Marshallable.ELenType.E_SHORT, "utf-8");
    AppMethodBeat.o(142916);
    return paramClass;
  }
  
  public Marshallable popMarshallable(Class<? extends Marshallable> paramClass)
  {
    AppMethodBeat.i(142905);
    try
    {
      paramClass = (Marshallable)paramClass.newInstance();
      paramClass.unmarshall(this.mBuffer);
      AppMethodBeat.o(142905);
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        paramClass = null;
      }
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        paramClass = null;
      }
    }
  }
  
  public short popShort()
  {
    AppMethodBeat.i(142878);
    short s = this.mBuffer.getShort();
    AppMethodBeat.o(142878);
    return s;
  }
  
  public short[] popShortArray()
  {
    AppMethodBeat.i(142896);
    int j = popShort();
    short[] arrayOfShort = new short[j];
    int i = 0;
    while (i < j)
    {
      arrayOfShort[i] = popShort();
      i += 1;
    }
    AppMethodBeat.o(142896);
    return arrayOfShort;
  }
  
  public String popString16()
  {
    AppMethodBeat.i(142888);
    int i = this.mBuffer.getShort();
    if (i >= 0)
    {
      Object localObject = new byte[i];
      this.mBuffer.get((byte[])localObject);
      try
      {
        localObject = new String((byte[])localObject, "ISO-8859-1");
        AppMethodBeat.o(142888);
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    }
    AppMethodBeat.o(142888);
    return "";
  }
  
  public String popString16(String paramString)
  {
    AppMethodBeat.i(142898);
    int i = this.mBuffer.getShort();
    if (i >= 0)
    {
      byte[] arrayOfByte = new byte[i];
      this.mBuffer.get(arrayOfByte);
      try
      {
        paramString = new String(arrayOfByte, paramString);
        AppMethodBeat.o(142898);
        return paramString;
      }
      catch (UnsupportedEncodingException paramString) {}
    }
    AppMethodBeat.o(142898);
    return "";
  }
  
  public String popString16UTF8()
  {
    AppMethodBeat.i(142889);
    int i = this.mBuffer.getShort();
    if (i >= 0)
    {
      Object localObject = new byte[i];
      this.mBuffer.get((byte[])localObject);
      try
      {
        localObject = new String((byte[])localObject, "utf-8");
        AppMethodBeat.o(142889);
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    }
    AppMethodBeat.o(142889);
    return "";
  }
  
  public String popString32()
  {
    AppMethodBeat.i(142897);
    int i = this.mBuffer.getInt();
    if (i >= 0)
    {
      Object localObject = new byte[i];
      this.mBuffer.get((byte[])localObject);
      try
      {
        localObject = new String((byte[])localObject, "ISO-8859-1");
        AppMethodBeat.o(142897);
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    }
    AppMethodBeat.o(142897);
    return "";
  }
  
  public String popString32(String paramString)
  {
    AppMethodBeat.i(142901);
    int i = this.mBuffer.getInt();
    if (i >= 0)
    {
      byte[] arrayOfByte = new byte[i];
      this.mBuffer.get(arrayOfByte);
      try
      {
        paramString = new String(arrayOfByte, paramString);
        AppMethodBeat.o(142901);
        return paramString;
      }
      catch (UnsupportedEncodingException paramString) {}
    }
    AppMethodBeat.o(142901);
    return "";
  }
  
  public void pushBool(Boolean paramBoolean)
  {
    AppMethodBeat.i(142868);
    byte b = 0;
    if (paramBoolean.booleanValue()) {
      b = 1;
    }
    check_capactiy(1);
    this.mBuffer.put(b);
    AppMethodBeat.o(142868);
  }
  
  public void pushByte(byte paramByte)
  {
    AppMethodBeat.i(142870);
    check_capactiy(1);
    this.mBuffer.put(paramByte);
    AppMethodBeat.o(142870);
  }
  
  public void pushBytes(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(142872);
    if (paramArrayOfByte == null)
    {
      check_capactiy(2);
      this.mBuffer.putShort((short)0);
      AppMethodBeat.o(142872);
      return;
    }
    check_capactiy(paramArrayOfByte.length + 2);
    this.mBuffer.putShort((short)paramArrayOfByte.length);
    this.mBuffer.put(paramArrayOfByte);
    AppMethodBeat.o(142872);
  }
  
  public void pushBytes32(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(142874);
    if (paramArrayOfByte == null)
    {
      check_capactiy(4);
      this.mBuffer.putInt(0);
      AppMethodBeat.o(142874);
      return;
    }
    check_capactiy(paramArrayOfByte.length + 4);
    this.mBuffer.putInt(paramArrayOfByte.length);
    this.mBuffer.put(paramArrayOfByte);
    AppMethodBeat.o(142874);
  }
  
  public <T> void pushCollection(Collection<T> paramCollection, Class<T> paramClass)
  {
    AppMethodBeat.i(142911);
    pushCollection(paramCollection, paramClass, Marshallable.ELenType.E_NONE);
    AppMethodBeat.o(142911);
  }
  
  public <T> void pushCollection(Collection<T> paramCollection, Class<T> paramClass, Marshallable.ELenType paramELenType)
  {
    AppMethodBeat.i(142910);
    if ((paramCollection == null) || (paramCollection.size() == 0))
    {
      pushShort((short)0);
      AppMethodBeat.o(142910);
      return;
    }
    pushShort((short)paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      pushElem(paramCollection.next(), paramClass, paramELenType);
    }
    AppMethodBeat.o(142910);
  }
  
  public void pushFloat(float paramFloat)
  {
    AppMethodBeat.i(142881);
    check_capactiy(4);
    this.mBuffer.putFloat(paramFloat);
    AppMethodBeat.o(142881);
  }
  
  public void pushInt(int paramInt)
  {
    AppMethodBeat.i(142879);
    check_capactiy(4);
    this.mBuffer.putInt(paramInt);
    AppMethodBeat.o(142879);
  }
  
  public void pushInt(long paramLong)
  {
    AppMethodBeat.i(142880);
    check_capactiy(4);
    this.mBuffer.putInt((int)paramLong);
    AppMethodBeat.o(142880);
  }
  
  public void pushInt64(long paramLong)
  {
    AppMethodBeat.i(142885);
    check_capactiy(8);
    this.mBuffer.putLong(paramLong);
    AppMethodBeat.o(142885);
  }
  
  public void pushIntArray(int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(142890);
    if (paramArrayOfInt == null)
    {
      pushShort((short)0);
      AppMethodBeat.o(142890);
      return;
    }
    int j = paramArrayOfInt.length;
    pushShort((short)j);
    while (i < j)
    {
      pushInt(paramArrayOfInt[i]);
      i += 1;
    }
    AppMethodBeat.o(142890);
  }
  
  public void pushIntArray(long[] paramArrayOfLong)
  {
    int i = 0;
    AppMethodBeat.i(142892);
    if (paramArrayOfLong == null)
    {
      pushShort((short)0);
      AppMethodBeat.o(142892);
      return;
    }
    int j = paramArrayOfLong.length;
    pushShort((short)j);
    while (i < j)
    {
      pushInt(paramArrayOfLong[i]);
      i += 1;
    }
    AppMethodBeat.o(142892);
  }
  
  public void pushIntArray(Integer[] paramArrayOfInteger)
  {
    int i = 0;
    AppMethodBeat.i(142891);
    if (paramArrayOfInteger == null)
    {
      pushShort((short)0);
      AppMethodBeat.o(142891);
      return;
    }
    int j = paramArrayOfInteger.length;
    pushShort((short)j);
    while (i < j)
    {
      pushInt(paramArrayOfInteger[i].intValue());
      i += 1;
    }
    AppMethodBeat.o(142891);
  }
  
  public <K, T> void pushMap(Map<K, T> paramMap, Class<T> paramClass)
  {
    AppMethodBeat.i(142914);
    Marshallable.ELenType localELenType = Marshallable.ELenType.E_SHORT;
    pushMap(paramMap, paramClass, localELenType, localELenType);
    AppMethodBeat.o(142914);
  }
  
  public <K, T> void pushMap(Map<K, T> paramMap, Class<T> paramClass, Marshallable.ELenType paramELenType1, Marshallable.ELenType paramELenType2)
  {
    AppMethodBeat.i(142915);
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      pushShort((short)0);
      AppMethodBeat.o(142915);
      return;
    }
    pushShort((short)paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      pushKey(localEntry.getKey(), paramELenType1);
      pushElem(localEntry.getValue(), paramClass, paramELenType2);
    }
    AppMethodBeat.o(142915);
  }
  
  public void pushMarshallable(Marshallable paramMarshallable)
  {
    AppMethodBeat.i(142904);
    if (paramMarshallable != null) {
      paramMarshallable.marshall(this.mBuffer);
    }
    AppMethodBeat.o(142904);
  }
  
  public void pushShort(short paramShort)
  {
    AppMethodBeat.i(142877);
    check_capactiy(2);
    this.mBuffer.putShort(paramShort);
    AppMethodBeat.o(142877);
  }
  
  public void pushShortArray(short[] paramArrayOfShort)
  {
    int i = 0;
    AppMethodBeat.i(142895);
    if (paramArrayOfShort == null)
    {
      pushShort((short)0);
      AppMethodBeat.o(142895);
      return;
    }
    int j = paramArrayOfShort.length;
    pushShort((short)j);
    while (i < j)
    {
      pushShort(paramArrayOfShort[i]);
      i += 1;
    }
    AppMethodBeat.o(142895);
  }
  
  public void pushString16(String paramString)
  {
    AppMethodBeat.i(142887);
    if (paramString == null)
    {
      check_capactiy(2);
      this.mBuffer.putShort((short)0);
      AppMethodBeat.o(142887);
      return;
    }
    check_capactiy(paramString.getBytes().length + 2);
    this.mBuffer.putShort((short)paramString.getBytes().length);
    if (paramString.getBytes().length > 0) {
      this.mBuffer.put(paramString.getBytes());
    }
    AppMethodBeat.o(142887);
  }
  
  public void pushString32(String paramString)
  {
    AppMethodBeat.i(142899);
    if (paramString == null)
    {
      check_capactiy(4);
      this.mBuffer.putInt(0);
      AppMethodBeat.o(142899);
      return;
    }
    check_capactiy(paramString.getBytes().length + 4);
    this.mBuffer.putInt(paramString.getBytes().length);
    if (paramString.getBytes().length > 0) {
      this.mBuffer.put(paramString.getBytes());
    }
    AppMethodBeat.o(142899);
  }
  
  public void pushString32(String paramString1, String paramString2)
  {
    AppMethodBeat.i(142900);
    if (paramString1 == null)
    {
      check_capactiy(4);
      this.mBuffer.putInt(0);
      AppMethodBeat.o(142900);
      return;
    }
    try
    {
      check_capactiy(paramString1.getBytes().length + 4);
      this.mBuffer.putInt(paramString1.getBytes(paramString2).length);
      if (paramString1.getBytes().length > 0) {
        this.mBuffer.put(paramString1.getBytes(paramString2));
      }
      AppMethodBeat.o(142900);
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      AppMethodBeat.o(142900);
    }
  }
  
  public void unmarshall(ByteBuffer paramByteBuffer)
  {
    this.mBuffer = paramByteBuffer;
  }
  
  public void unmarshall(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(142867);
    this.mBuffer = ByteBuffer.wrap(paramArrayOfByte);
    this.mBuffer.order(ByteOrder.LITTLE_ENDIAN);
    AppMethodBeat.o(142867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.hilive.mediasdk.serialize.Marshallable
 * JD-Core Version:    0.7.0.1
 */