package androidx.camera.core.impl.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.ByteOrder;

final class a
  extends FilterOutputStream
{
  final OutputStream NY;
  ByteOrder NZ;
  
  a(OutputStream paramOutputStream, ByteOrder paramByteOrder)
  {
    super(paramOutputStream);
    this.NY = paramOutputStream;
    this.NZ = paramByteOrder;
  }
  
  public final void aX(int paramInt)
  {
    AppMethodBeat.i(198986);
    if (this.NZ == ByteOrder.LITTLE_ENDIAN)
    {
      this.NY.write(paramInt >>> 0 & 0xFF);
      this.NY.write(paramInt >>> 8 & 0xFF);
      this.NY.write(paramInt >>> 16 & 0xFF);
      this.NY.write(paramInt >>> 24 & 0xFF);
      AppMethodBeat.o(198986);
      return;
    }
    if (this.NZ == ByteOrder.BIG_ENDIAN)
    {
      this.NY.write(paramInt >>> 24 & 0xFF);
      this.NY.write(paramInt >>> 16 & 0xFF);
      this.NY.write(paramInt >>> 8 & 0xFF);
      this.NY.write(paramInt >>> 0 & 0xFF);
    }
    AppMethodBeat.o(198986);
  }
  
  public final void b(short paramShort)
  {
    AppMethodBeat.i(198978);
    if (this.NZ == ByteOrder.LITTLE_ENDIAN)
    {
      this.NY.write(paramShort >>> 0 & 0xFF);
      this.NY.write(paramShort >>> 8 & 0xFF);
      AppMethodBeat.o(198978);
      return;
    }
    if (this.NZ == ByteOrder.BIG_ENDIAN)
    {
      this.NY.write(paramShort >>> 8 & 0xFF);
      this.NY.write(paramShort >>> 0 & 0xFF);
    }
    AppMethodBeat.o(198978);
  }
  
  public final void write(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198965);
    this.NY.write(paramArrayOfByte);
    AppMethodBeat.o(198965);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198972);
    this.NY.write(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(198972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.core.impl.a.a
 * JD-Core Version:    0.7.0.1
 */