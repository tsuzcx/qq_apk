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
  private final a bFC;
  private final long bFD;
  private FileOutputStream bFE;
  private long bFF;
  private long bFG;
  private q bFH;
  private final int bufferSize;
  private j bxi;
  private File file;
  private OutputStream outputStream;
  
  public b(a parama, long paramLong, int paramInt)
  {
    AppMethodBeat.i(92959);
    this.bFC = ((a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    this.bFD = paramLong;
    this.bufferSize = paramInt;
    AppMethodBeat.o(92959);
  }
  
  private void wG()
  {
    AppMethodBeat.i(92963);
    long l;
    if (this.bxi.length == -1L)
    {
      l = this.bFD;
      this.file = this.bFC.e(this.bxi.key, this.bxi.absoluteStreamPosition + this.bFG, l);
      this.bFE = new FileOutputStream(this.file);
      if (this.bufferSize <= 0) {
        break label161;
      }
      if (this.bFH != null) {
        break label147;
      }
      this.bFH = new q(this.bFE, this.bufferSize);
    }
    label105:
    for (this.outputStream = this.bFH;; this.outputStream = this.bFE)
    {
      this.bFF = 0L;
      AppMethodBeat.o(92963);
      return;
      l = Math.min(this.bxi.length - this.bFG, this.bFD);
      break;
      this.bFH.a(this.bFE);
      break label105;
    }
  }
  
  private void wH()
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
      this.bFE.getFD().sync();
      x.closeQuietly(this.outputStream);
      this.outputStream = null;
      File localFile1 = this.file;
      this.file = null;
      this.bFC.w(localFile1);
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
    if ((paramj.length == -1L) && (!paramj.isFlagSet(2)))
    {
      this.bxi = null;
      AppMethodBeat.o(92960);
      return;
    }
    this.bxi = paramj;
    this.bFG = 0L;
    try
    {
      wG();
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
    if (this.bxi == null)
    {
      AppMethodBeat.o(92962);
      return;
    }
    try
    {
      wH();
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
    if (this.bxi == null)
    {
      AppMethodBeat.o(92961);
      return;
    }
    int i = 0;
    while (i < paramInt2) {
      try
      {
        if (this.bFF == this.bFD)
        {
          wH();
          wG();
        }
        int j = (int)Math.min(paramInt2 - i, this.bFD - this.bFF);
        this.outputStream.write(paramArrayOfByte, paramInt1 + i, j);
        i += j;
        this.bFF += j;
        this.bFG += j;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.b
 * JD-Core Version:    0.7.0.1
 */