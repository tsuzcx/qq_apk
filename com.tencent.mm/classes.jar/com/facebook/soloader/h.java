package com.facebook.soloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class h
  implements f
{
  private InputStream cCA;
  private final ZipEntry cCB;
  private final ZipFile cCC;
  private final long cCD;
  private boolean cCE;
  private long cCF;
  
  public h(ZipFile paramZipFile, ZipEntry paramZipEntry)
  {
    AppMethodBeat.i(208072);
    this.cCC = paramZipFile;
    this.cCB = paramZipEntry;
    this.cCE = true;
    this.cCF = 0L;
    this.cCD = this.cCB.getSize();
    this.cCA = this.cCC.getInputStream(this.cCB);
    if (this.cCA == null)
    {
      paramZipFile = new IOException(this.cCB.getName() + "'s InputStream is null");
      AppMethodBeat.o(208072);
      throw paramZipFile;
    }
    AppMethodBeat.o(208072);
  }
  
  private f bJ(long paramLong)
  {
    AppMethodBeat.i(208084);
    IOException localIOException;
    if (this.cCA == null)
    {
      localIOException = new IOException(this.cCB.getName() + "'s InputStream is null");
      AppMethodBeat.o(208084);
      throw localIOException;
    }
    if (paramLong == this.cCF)
    {
      AppMethodBeat.o(208084);
      return this;
    }
    long l = paramLong;
    if (paramLong > this.cCD) {
      l = this.cCD;
    }
    if (l >= this.cCF) {
      this.cCA.skip(l - this.cCF);
    }
    for (;;)
    {
      this.cCF = l;
      AppMethodBeat.o(208084);
      return this;
      this.cCA.close();
      this.cCA = this.cCC.getInputStream(this.cCB);
      if (this.cCA == null)
      {
        localIOException = new IOException(this.cCB.getName() + "'s InputStream is null");
        AppMethodBeat.o(208084);
        throw localIOException;
      }
      this.cCA.skip(l);
    }
  }
  
  public final int a(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(208101);
    if (this.cCA == null)
    {
      paramByteBuffer = new IOException("InputStream is null");
      AppMethodBeat.o(208101);
      throw paramByteBuffer;
    }
    int j = paramByteBuffer.remaining();
    long l = this.cCD - paramLong;
    if (l <= 0L)
    {
      AppMethodBeat.o(208101);
      return -1;
    }
    int i = j;
    if (j > (int)l) {
      i = (int)l;
    }
    bJ(paramLong);
    if (paramByteBuffer.hasArray())
    {
      this.cCA.read(paramByteBuffer.array(), 0, i);
      paramByteBuffer.position(paramByteBuffer.position() + i);
    }
    for (;;)
    {
      this.cCF += i;
      AppMethodBeat.o(208101);
      return i;
      byte[] arrayOfByte = new byte[i];
      this.cCA.read(arrayOfByte, 0, i);
      paramByteBuffer.put(arrayOfByte, 0, i);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(208124);
    if (this.cCA != null)
    {
      this.cCA.close();
      this.cCE = false;
    }
    AppMethodBeat.o(208124);
  }
  
  public final boolean isOpen()
  {
    return this.cCE;
  }
  
  public final int read(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(208091);
    int i = a(paramByteBuffer, this.cCF);
    AppMethodBeat.o(208091);
    return i;
  }
  
  public final int write(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(208109);
    paramByteBuffer = new UnsupportedOperationException("ElfZipFileChannel doesn't support write");
    AppMethodBeat.o(208109);
    throw paramByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.soloader.h
 * JD-Core Version:    0.7.0.1
 */