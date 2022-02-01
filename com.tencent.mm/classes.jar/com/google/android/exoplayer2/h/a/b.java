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
  private j bml;
  private final int bufferSize;
  private final a bxF;
  private final long bxG;
  private FileOutputStream bxH;
  private long bxI;
  private long bxJ;
  private q bxK;
  private File file;
  private OutputStream outputStream;
  
  public b(a parama, long paramLong, int paramInt)
  {
    AppMethodBeat.i(92959);
    this.bxF = ((a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    this.bxG = paramLong;
    this.bufferSize = paramInt;
    AppMethodBeat.o(92959);
  }
  
  private void vs()
  {
    AppMethodBeat.i(92963);
    long l;
    if (this.bml.length == -1L)
    {
      l = this.bxG;
      this.file = this.bxF.f(this.bml.key, this.bml.bwz + this.bxJ, l);
      this.bxH = new FileOutputStream(this.file);
      if (this.bufferSize <= 0) {
        break label161;
      }
      if (this.bxK != null) {
        break label147;
      }
      this.bxK = new q(this.bxH, this.bufferSize);
    }
    label105:
    for (this.outputStream = this.bxK;; this.outputStream = this.bxH)
    {
      this.bxI = 0L;
      AppMethodBeat.o(92963);
      return;
      l = Math.min(this.bml.length - this.bxJ, this.bxG);
      break;
      this.bxK.a(this.bxH);
      break label105;
    }
  }
  
  private void vt()
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
      this.bxH.getFD().sync();
      x.closeQuietly(this.outputStream);
      this.outputStream = null;
      File localFile1 = this.file;
      this.file = null;
      this.bxF.w(localFile1);
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
    if ((paramj.length == -1L) && (!paramj.fh(2)))
    {
      this.bml = null;
      AppMethodBeat.o(92960);
      return;
    }
    this.bml = paramj;
    this.bxJ = 0L;
    try
    {
      vs();
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
    if (this.bml == null)
    {
      AppMethodBeat.o(92962);
      return;
    }
    try
    {
      vt();
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
    if (this.bml == null)
    {
      AppMethodBeat.o(92961);
      return;
    }
    int i = 0;
    while (i < paramInt2) {
      try
      {
        if (this.bxI == this.bxG)
        {
          vt();
          vs();
        }
        int j = (int)Math.min(paramInt2 - i, this.bxG - this.bxI);
        this.outputStream.write(paramArrayOfByte, paramInt1 + i, j);
        i += j;
        this.bxI += j;
        this.bxJ += j;
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