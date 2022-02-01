package com.google.android.exoplayer2.h.a;

import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class b
  implements f
{
  private final a bFT;
  private final long bFU;
  private FileOutputStream bFV;
  private long bFW;
  private long bFX;
  private q bFY;
  private final int bufferSize;
  private j bxj;
  private File file;
  private OutputStream outputStream;
  
  public b(a parama, long paramLong, int paramInt)
  {
    AppMethodBeat.i(92959);
    this.bFT = ((a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    this.bFU = paramLong;
    this.bufferSize = paramInt;
    AppMethodBeat.o(92959);
  }
  
  private void wO()
  {
    AppMethodBeat.i(92963);
    long l;
    if (this.bxj.length == -1L)
    {
      l = this.bFU;
      this.file = this.bFT.e(this.bxj.key, this.bxj.bEP + this.bFX, l);
      this.bFV = new FileOutputStream(this.file);
      if (this.bufferSize <= 0) {
        break label161;
      }
      if (this.bFY != null) {
        break label147;
      }
      this.bFY = new q(this.bFV, this.bufferSize);
    }
    label105:
    for (this.outputStream = this.bFY;; this.outputStream = this.bFV)
    {
      this.bFW = 0L;
      AppMethodBeat.o(92963);
      return;
      l = Math.min(this.bxj.length - this.bFX, this.bFU);
      break;
      this.bFY.a(this.bFV);
      break label105;
    }
  }
  
  private void wP()
  {
    AppMethodBeat.i(92964);
    if (this.outputStream == null)
    {
      AppMethodBeat.o(92964);
      return;
    }
    try
    {
      this.outputStream.flush();
      this.bFV.getFD().sync();
      x.closeQuietly(this.outputStream);
      this.outputStream = null;
      File localFile1 = this.file;
      this.file = null;
      this.bFT.w(localFile1);
      AppMethodBeat.o(92964);
      return;
    }
    finally
    {
      x.closeQuietly(this.outputStream);
      this.outputStream = null;
      File localFile2 = this.file;
      this.file = null;
      localFile2.delete();
      AppMethodBeat.o(92964);
    }
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(92960);
    if ((paramj.length == -1L) && (!paramj.eW(2)))
    {
      this.bxj = null;
      AppMethodBeat.o(92960);
      return;
    }
    this.bxj = paramj;
    this.bFX = 0L;
    try
    {
      wO();
      AppMethodBeat.o(92960);
      return;
    }
    catch (IOException paramj)
    {
      paramj = new a(paramj);
      AppMethodBeat.o(92960);
      throw paramj;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(92962);
    if (this.bxj == null)
    {
      AppMethodBeat.o(92962);
      return;
    }
    try
    {
      wP();
      AppMethodBeat.o(92962);
      return;
    }
    catch (IOException localIOException)
    {
      a locala = new a(localIOException);
      AppMethodBeat.o(92962);
      throw locala;
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92961);
    if (this.bxj == null)
    {
      AppMethodBeat.o(92961);
      return;
    }
    int i = 0;
    while (i < paramInt2) {
      try
      {
        if (this.bFW == this.bFU)
        {
          wP();
          wO();
        }
        int j = (int)Math.min(paramInt2 - i, this.bFU - this.bFW);
        this.outputStream.write(paramArrayOfByte, paramInt1 + i, j);
        i += j;
        this.bFW += j;
        this.bFX += j;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte = new a(paramArrayOfByte);
        AppMethodBeat.o(92961);
        throw paramArrayOfByte;
      }
    }
    AppMethodBeat.o(92961);
  }
  
  public static final class a
    extends a.a
  {
    public a(IOException paramIOException)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.b
 * JD-Core Version:    0.7.0.1
 */