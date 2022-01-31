package com.eclipsesource.v8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

public class Float64Array
  extends TypedArray
{
  public Float64Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
    AppMethodBeat.i(75052);
    AppMethodBeat.o(75052);
  }
  
  public Float64Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public double get(int paramInt)
  {
    AppMethodBeat.i(75053);
    double d = this.buffer.asDoubleBuffer().get(paramInt);
    AppMethodBeat.o(75053);
    return d;
  }
  
  public int getType()
  {
    return 2;
  }
  
  public int length()
  {
    AppMethodBeat.i(75054);
    int i = this.buffer.asDoubleBuffer().limit();
    AppMethodBeat.o(75054);
    return i;
  }
  
  public void put(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(75055);
    this.buffer.asDoubleBuffer().put(paramInt, paramDouble);
    AppMethodBeat.o(75055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.v8.utils.typedarrays.Float64Array
 * JD-Core Version:    0.7.0.1
 */