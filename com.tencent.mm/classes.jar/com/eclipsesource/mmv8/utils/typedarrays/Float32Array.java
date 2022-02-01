package com.eclipsesource.mmv8.utils.typedarrays;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class Float32Array
  extends TypedArray
{
  public Float32Array(ArrayBuffer paramArrayBuffer)
  {
    this(paramArrayBuffer.getByteBuffer());
    AppMethodBeat.i(61672);
    AppMethodBeat.o(61672);
  }
  
  public Float32Array(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public float get(int paramInt)
  {
    AppMethodBeat.i(61673);
    float f = this.buffer.asFloatBuffer().get(paramInt);
    AppMethodBeat.o(61673);
    return f;
  }
  
  public int getType()
  {
    return 16;
  }
  
  public int length()
  {
    AppMethodBeat.i(61674);
    int i = this.buffer.asFloatBuffer().limit();
    AppMethodBeat.o(61674);
    return i;
  }
  
  public void put(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(61675);
    this.buffer.asFloatBuffer().put(paramInt, paramFloat);
    AppMethodBeat.o(61675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.typedarrays.Float32Array
 * JD-Core Version:    0.7.0.1
 */