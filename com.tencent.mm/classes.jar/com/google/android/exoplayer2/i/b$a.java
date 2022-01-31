package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class b$a
  extends OutputStream
{
  private final FileOutputStream baD;
  private boolean closed;
  
  public b$a(File paramFile)
  {
    AppMethodBeat.i(152020);
    this.closed = false;
    this.baD = new FileOutputStream(paramFile);
    AppMethodBeat.o(152020);
  }
  
  public final void close()
  {
    AppMethodBeat.i(152021);
    if (this.closed)
    {
      AppMethodBeat.o(152021);
      return;
    }
    this.closed = true;
    flush();
    try
    {
      this.baD.getFD().sync();
      label37:
      this.baD.close();
      AppMethodBeat.o(152021);
      return;
    }
    catch (IOException localIOException)
    {
      break label37;
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(152022);
    this.baD.flush();
    AppMethodBeat.o(152022);
  }
  
  public final void write(int paramInt)
  {
    AppMethodBeat.i(152023);
    this.baD.write(paramInt);
    AppMethodBeat.o(152023);
  }
  
  public final void write(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(152024);
    this.baD.write(paramArrayOfByte);
    AppMethodBeat.o(152024);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152025);
    this.baD.write(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(152025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.i.b.a
 * JD-Core Version:    0.7.0.1
 */