package com.qq.taf.jce.dynamic;

import com.qq.taf.jce.JceDecodeException;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class DynamicOutputStream
  extends JceOutputStream
{
  public DynamicOutputStream() {}
  
  public DynamicOutputStream(int paramInt)
  {
    super(paramInt);
  }
  
  public DynamicOutputStream(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public final void write(JceField paramJceField)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(109573);
    int k = paramJceField.getTag();
    if ((paramJceField instanceof ZeroField))
    {
      write(0, k);
      AppMethodBeat.o(109573);
      return;
    }
    if ((paramJceField instanceof IntField))
    {
      write(((IntField)paramJceField).get(), k);
      AppMethodBeat.o(109573);
      return;
    }
    if ((paramJceField instanceof ShortField))
    {
      write(((ShortField)paramJceField).get(), k);
      AppMethodBeat.o(109573);
      return;
    }
    if ((paramJceField instanceof ByteField))
    {
      write(((ByteField)paramJceField).get(), k);
      AppMethodBeat.o(109573);
      return;
    }
    if ((paramJceField instanceof StringField))
    {
      write(((StringField)paramJceField).get(), k);
      AppMethodBeat.o(109573);
      return;
    }
    if ((paramJceField instanceof ByteArrayField))
    {
      write(((ByteArrayField)paramJceField).get(), k);
      AppMethodBeat.o(109573);
      return;
    }
    if ((paramJceField instanceof ListField))
    {
      paramJceField = (ListField)paramJceField;
      reserve(8);
      writeHead((byte)9, k);
      write(paramJceField.size(), 0);
      paramJceField = paramJceField.get();
      j = paramJceField.length;
      for (;;)
      {
        if (i >= j)
        {
          AppMethodBeat.o(109573);
          return;
        }
        write(paramJceField[i]);
        i += 1;
      }
    }
    if ((paramJceField instanceof MapField))
    {
      paramJceField = (MapField)paramJceField;
      reserve(8);
      writeHead((byte)8, k);
      k = paramJceField.size();
      write(k, 0);
      i = j;
      for (;;)
      {
        if (i >= k)
        {
          AppMethodBeat.o(109573);
          return;
        }
        write(paramJceField.getKey(i));
        write(paramJceField.getValue(i));
        i += 1;
      }
    }
    if ((paramJceField instanceof StructField))
    {
      paramJceField = (StructField)paramJceField;
      reserve(2);
      writeHead((byte)10, k);
      paramJceField = paramJceField.get();
      j = paramJceField.length;
      i = 0;
      for (;;)
      {
        if (i >= j)
        {
          reserve(2);
          writeHead((byte)11, 0);
          AppMethodBeat.o(109573);
          return;
        }
        write(paramJceField[i]);
        i += 1;
      }
    }
    if ((paramJceField instanceof LongField))
    {
      write(((LongField)paramJceField).get(), k);
      AppMethodBeat.o(109573);
      return;
    }
    if ((paramJceField instanceof FloatField))
    {
      write(((FloatField)paramJceField).get(), k);
      AppMethodBeat.o(109573);
      return;
    }
    if ((paramJceField instanceof DoubleField))
    {
      write(((DoubleField)paramJceField).get(), k);
      AppMethodBeat.o(109573);
      return;
    }
    paramJceField = new JceDecodeException("unknow JceField type: " + paramJceField.getClass().getName());
    AppMethodBeat.o(109573);
    throw paramJceField;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.DynamicOutputStream
 * JD-Core Version:    0.7.0.1
 */