package androidx.camera.core.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

final class i$a
  extends OutputStream
{
  private final ByteBuffer mByteBuffer;
  
  i$a(ByteBuffer paramByteBuffer)
  {
    this.mByteBuffer = paramByteBuffer;
  }
  
  public final void write(int paramInt)
  {
    AppMethodBeat.i(199168);
    if (!this.mByteBuffer.hasRemaining())
    {
      EOFException localEOFException = new EOFException("Output ByteBuffer has no bytes remaining.");
      AppMethodBeat.o(199168);
      throw localEOFException;
    }
    this.mByteBuffer.put((byte)paramInt);
    AppMethodBeat.o(199168);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199172);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new NullPointerException();
      AppMethodBeat.o(199172);
      throw paramArrayOfByte;
    }
    if ((paramInt1 < 0) || (paramInt1 > paramArrayOfByte.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length) || (paramInt1 + paramInt2 < 0))
    {
      paramArrayOfByte = new IndexOutOfBoundsException();
      AppMethodBeat.o(199172);
      throw paramArrayOfByte;
    }
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(199172);
      return;
    }
    if (this.mByteBuffer.remaining() < paramInt2)
    {
      paramArrayOfByte = new EOFException("Output ByteBuffer has insufficient bytes remaining.");
      AppMethodBeat.o(199172);
      throw paramArrayOfByte;
    }
    this.mByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(199172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.core.a.i.a
 * JD-Core Version:    0.7.0.1
 */