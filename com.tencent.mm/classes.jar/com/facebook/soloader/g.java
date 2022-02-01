package com.facebook.soloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public final class g
  implements f
{
  private FileInputStream cCy;
  private FileChannel cCz;
  private File mFile;
  
  public g(File paramFile)
  {
    AppMethodBeat.i(208066);
    this.mFile = paramFile;
    PT();
    AppMethodBeat.o(208066);
  }
  
  public final void PT()
  {
    AppMethodBeat.i(208074);
    this.cCy = new FileInputStream(this.mFile);
    this.cCz = this.cCy.getChannel();
    AppMethodBeat.o(208074);
  }
  
  public final int a(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(208087);
    int i = this.cCz.read(paramByteBuffer, paramLong);
    AppMethodBeat.o(208087);
    return i;
  }
  
  public final void close()
  {
    AppMethodBeat.i(208102);
    this.cCy.close();
    AppMethodBeat.o(208102);
  }
  
  public final boolean isOpen()
  {
    AppMethodBeat.i(208112);
    boolean bool = this.cCz.isOpen();
    AppMethodBeat.o(208112);
    return bool;
  }
  
  public final int read(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(208080);
    int i = this.cCz.read(paramByteBuffer);
    AppMethodBeat.o(208080);
    return i;
  }
  
  public final int write(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(208095);
    int i = this.cCz.write(paramByteBuffer);
    AppMethodBeat.o(208095);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.soloader.g
 * JD-Core Version:    0.7.0.1
 */