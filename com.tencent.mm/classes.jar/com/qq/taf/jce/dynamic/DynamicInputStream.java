package com.qq.taf.jce.dynamic;

import com.qq.taf.jce.JceDecodeException;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceInputStream.HeadData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class DynamicInputStream
{
  private ByteBuffer bs;
  private String sServerEncoding;
  
  public DynamicInputStream(ByteBuffer paramByteBuffer)
  {
    this.sServerEncoding = "GBK";
    this.bs = paramByteBuffer;
  }
  
  public DynamicInputStream(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109587);
    this.sServerEncoding = "GBK";
    this.bs = ByteBuffer.wrap(paramArrayOfByte);
    AppMethodBeat.o(109587);
  }
  
  private JceField readString(JceInputStream.HeadData paramHeadData, int paramInt)
  {
    AppMethodBeat.i(109589);
    byte[] arrayOfByte = new byte[paramInt];
    this.bs.get(arrayOfByte);
    try
    {
      String str1 = new String(arrayOfByte, this.sServerEncoding);
      paramHeadData = JceField.create(str1, paramHeadData.tag);
      AppMethodBeat.o(109589);
      return paramHeadData;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str2 = new String(arrayOfByte);
      }
    }
  }
  
  public final JceField read()
  {
    int i = 0;
    AppMethodBeat.i(109588);
    try
    {
      localObject1 = new JceInputStream.HeadData();
      JceInputStream.readHead((JceInputStream.HeadData)localObject1, this.bs);
      j = ((JceInputStream.HeadData)localObject1).type;
      switch (j)
      {
      default: 
        AppMethodBeat.o(109588);
        return null;
      }
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      Object localObject1;
      int j;
      Object localObject4;
      AppMethodBeat.o(109588);
      return null;
    }
    localObject1 = JceField.create(this.bs.get(), ((JceInputStream.HeadData)localObject1).tag);
    AppMethodBeat.o(109588);
    return localObject1;
    localObject1 = JceField.create(this.bs.getShort(), ((JceInputStream.HeadData)localObject1).tag);
    AppMethodBeat.o(109588);
    return localObject1;
    localObject1 = JceField.create(this.bs.getInt(), ((JceInputStream.HeadData)localObject1).tag);
    AppMethodBeat.o(109588);
    return localObject1;
    localObject1 = JceField.create(this.bs.getLong(), ((JceInputStream.HeadData)localObject1).tag);
    AppMethodBeat.o(109588);
    return localObject1;
    localObject1 = JceField.create(this.bs.getFloat(), ((JceInputStream.HeadData)localObject1).tag);
    AppMethodBeat.o(109588);
    return localObject1;
    localObject1 = JceField.create(this.bs.getDouble(), ((JceInputStream.HeadData)localObject1).tag);
    AppMethodBeat.o(109588);
    return localObject1;
    j = this.bs.get();
    i = j;
    if (j < 0) {
      i = j + 256;
    }
    localObject1 = readString((JceInputStream.HeadData)localObject1, i);
    AppMethodBeat.o(109588);
    return localObject1;
    localObject1 = readString((JceInputStream.HeadData)localObject1, this.bs.getInt());
    AppMethodBeat.o(109588);
    return localObject1;
    j = ((NumberField)read()).intValue();
    Object localObject3 = new JceField[j];
    for (;;)
    {
      if (i >= j)
      {
        localObject1 = JceField.createList((JceField[])localObject3, ((JceInputStream.HeadData)localObject1).tag);
        AppMethodBeat.o(109588);
        return localObject1;
      }
      localObject3[i] = read();
      i += 1;
    }
    j = ((NumberField)read()).intValue();
    localObject3 = new JceField[j];
    localObject4 = new JceField[j];
    i = 0;
    for (;;)
    {
      if (i >= j)
      {
        localObject1 = JceField.createMap((JceField[])localObject3, (JceField[])localObject4, ((JceInputStream.HeadData)localObject1).tag);
        AppMethodBeat.o(109588);
        return localObject1;
      }
      localObject3[i] = read();
      localObject4[i] = read();
      i += 1;
    }
    localObject3 = new ArrayList();
    for (;;)
    {
      localObject4 = read();
      if (localObject4 == null) {
        break;
      }
      ((List)localObject3).add(localObject4);
    }
    Object localObject2 = JceField.createStruct((JceField[])((List)localObject3).toArray(new JceField[0]), localBufferUnderflowException.tag);
    AppMethodBeat.o(109588);
    return localObject2;
    AppMethodBeat.o(109588);
    return null;
    localObject2 = JceField.createZero(((JceInputStream.HeadData)localObject2).tag);
    AppMethodBeat.o(109588);
    return localObject2;
    i = ((JceInputStream.HeadData)localObject2).tag;
    JceInputStream.readHead((JceInputStream.HeadData)localObject2, this.bs);
    if (((JceInputStream.HeadData)localObject2).type != 0)
    {
      localObject2 = new JceDecodeException("type mismatch, simple_list only support byte, tag: " + i + ", type: " + ((JceInputStream.HeadData)localObject2).type);
      AppMethodBeat.o(109588);
      throw ((Throwable)localObject2);
    }
    localObject2 = new byte[((NumberField)read()).intValue()];
    this.bs.get((byte[])localObject2);
    localObject2 = JceField.create((byte[])localObject2, i);
    AppMethodBeat.o(109588);
    return localObject2;
  }
  
  public final int setServerEncoding(String paramString)
  {
    this.sServerEncoding = paramString;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.DynamicInputStream
 * JD-Core Version:    0.7.0.1
 */