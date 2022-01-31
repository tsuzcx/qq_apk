package com.qq.taf.jce.dynamic;

import com.qq.taf.jce.JceDecodeException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class JceField
{
  private static ZeroField[] zs;
  private int tag;
  
  static
  {
    AppMethodBeat.i(117020);
    zs = new ZeroField[256];
    int i = 0;
    for (;;)
    {
      if (i >= zs.length)
      {
        AppMethodBeat.o(117020);
        return;
      }
      zs[i] = new ZeroField(i);
      i += 1;
    }
  }
  
  JceField(int paramInt)
  {
    this.tag = paramInt;
  }
  
  public static JceField create(byte paramByte, int paramInt)
  {
    AppMethodBeat.i(117021);
    ByteField localByteField = new ByteField(paramByte, paramInt);
    AppMethodBeat.o(117021);
    return localByteField;
  }
  
  public static JceField create(double paramDouble, int paramInt)
  {
    AppMethodBeat.i(117026);
    DoubleField localDoubleField = new DoubleField(paramDouble, paramInt);
    AppMethodBeat.o(117026);
    return localDoubleField;
  }
  
  public static JceField create(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(117025);
    FloatField localFloatField = new FloatField(paramFloat, paramInt);
    AppMethodBeat.o(117025);
    return localFloatField;
  }
  
  public static JceField create(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117023);
    IntField localIntField = new IntField(paramInt1, paramInt2);
    AppMethodBeat.o(117023);
    return localIntField;
  }
  
  public static JceField create(long paramLong, int paramInt)
  {
    AppMethodBeat.i(117024);
    LongField localLongField = new LongField(paramLong, paramInt);
    AppMethodBeat.o(117024);
    return localLongField;
  }
  
  public static JceField create(String paramString, int paramInt)
  {
    AppMethodBeat.i(117027);
    paramString = new StringField(paramString, paramInt);
    AppMethodBeat.o(117027);
    return paramString;
  }
  
  public static JceField create(short paramShort, int paramInt)
  {
    AppMethodBeat.i(117022);
    ShortField localShortField = new ShortField(paramShort, paramInt);
    AppMethodBeat.o(117022);
    return localShortField;
  }
  
  public static JceField create(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(117028);
    paramArrayOfByte = new ByteArrayField(paramArrayOfByte, paramInt);
    AppMethodBeat.o(117028);
    return paramArrayOfByte;
  }
  
  public static JceField createList(JceField[] paramArrayOfJceField, int paramInt)
  {
    AppMethodBeat.i(117029);
    paramArrayOfJceField = new ListField(paramArrayOfJceField, paramInt);
    AppMethodBeat.o(117029);
    return paramArrayOfJceField;
  }
  
  public static JceField createMap(JceField[] paramArrayOfJceField1, JceField[] paramArrayOfJceField2, int paramInt)
  {
    AppMethodBeat.i(117030);
    paramArrayOfJceField1 = new MapField(paramArrayOfJceField1, paramArrayOfJceField2, paramInt);
    AppMethodBeat.o(117030);
    return paramArrayOfJceField1;
  }
  
  public static JceField createStruct(JceField[] paramArrayOfJceField, int paramInt)
  {
    AppMethodBeat.i(117031);
    paramArrayOfJceField = new StructField(paramArrayOfJceField, paramInt);
    AppMethodBeat.o(117031);
    return paramArrayOfJceField;
  }
  
  public static JceField createZero(int paramInt)
  {
    AppMethodBeat.i(117032);
    if ((paramInt < 0) || (paramInt >= 255))
    {
      localObject = new JceDecodeException("invalid tag: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(117032);
      throw ((Throwable)localObject);
    }
    Object localObject = zs[paramInt];
    AppMethodBeat.o(117032);
    return localObject;
  }
  
  public int getTag()
  {
    return this.tag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.JceField
 * JD-Core Version:    0.7.0.1
 */