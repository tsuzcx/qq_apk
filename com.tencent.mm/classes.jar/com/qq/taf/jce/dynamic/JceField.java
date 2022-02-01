package com.qq.taf.jce.dynamic;

import com.qq.taf.jce.JceDecodeException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class JceField
{
  private static ZeroField[] zs;
  private int tag;
  
  static
  {
    AppMethodBeat.i(109574);
    zs = new ZeroField[256];
    int i = 0;
    for (;;)
    {
      if (i >= zs.length)
      {
        AppMethodBeat.o(109574);
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
    AppMethodBeat.i(109575);
    ByteField localByteField = new ByteField(paramByte, paramInt);
    AppMethodBeat.o(109575);
    return localByteField;
  }
  
  public static JceField create(double paramDouble, int paramInt)
  {
    AppMethodBeat.i(109580);
    DoubleField localDoubleField = new DoubleField(paramDouble, paramInt);
    AppMethodBeat.o(109580);
    return localDoubleField;
  }
  
  public static JceField create(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(109579);
    FloatField localFloatField = new FloatField(paramFloat, paramInt);
    AppMethodBeat.o(109579);
    return localFloatField;
  }
  
  public static JceField create(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109577);
    IntField localIntField = new IntField(paramInt1, paramInt2);
    AppMethodBeat.o(109577);
    return localIntField;
  }
  
  public static JceField create(long paramLong, int paramInt)
  {
    AppMethodBeat.i(109578);
    LongField localLongField = new LongField(paramLong, paramInt);
    AppMethodBeat.o(109578);
    return localLongField;
  }
  
  public static JceField create(String paramString, int paramInt)
  {
    AppMethodBeat.i(109581);
    paramString = new StringField(paramString, paramInt);
    AppMethodBeat.o(109581);
    return paramString;
  }
  
  public static JceField create(short paramShort, int paramInt)
  {
    AppMethodBeat.i(109576);
    ShortField localShortField = new ShortField(paramShort, paramInt);
    AppMethodBeat.o(109576);
    return localShortField;
  }
  
  public static JceField create(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(109582);
    paramArrayOfByte = new ByteArrayField(paramArrayOfByte, paramInt);
    AppMethodBeat.o(109582);
    return paramArrayOfByte;
  }
  
  public static JceField createList(JceField[] paramArrayOfJceField, int paramInt)
  {
    AppMethodBeat.i(109583);
    paramArrayOfJceField = new ListField(paramArrayOfJceField, paramInt);
    AppMethodBeat.o(109583);
    return paramArrayOfJceField;
  }
  
  public static JceField createMap(JceField[] paramArrayOfJceField1, JceField[] paramArrayOfJceField2, int paramInt)
  {
    AppMethodBeat.i(109584);
    paramArrayOfJceField1 = new MapField(paramArrayOfJceField1, paramArrayOfJceField2, paramInt);
    AppMethodBeat.o(109584);
    return paramArrayOfJceField1;
  }
  
  public static JceField createStruct(JceField[] paramArrayOfJceField, int paramInt)
  {
    AppMethodBeat.i(109585);
    paramArrayOfJceField = new StructField(paramArrayOfJceField, paramInt);
    AppMethodBeat.o(109585);
    return paramArrayOfJceField;
  }
  
  public static JceField createZero(int paramInt)
  {
    AppMethodBeat.i(109586);
    if ((paramInt < 0) || (paramInt >= 255))
    {
      localObject = new JceDecodeException("invalid tag: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(109586);
      throw ((Throwable)localObject);
    }
    Object localObject = zs[paramInt];
    AppMethodBeat.o(109586);
    return localObject;
  }
  
  public int getTag()
  {
    return this.tag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.JceField
 * JD-Core Version:    0.7.0.1
 */