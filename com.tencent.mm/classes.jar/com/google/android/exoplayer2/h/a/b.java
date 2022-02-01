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
  private final int bufferSize;
  private j daF;
  private final a dja;
  private final long djb;
  private OutputStream djc;
  private FileOutputStream djd;
  private long dje;
  private long djf;
  private q djg;
  private File file;
  
  public b(a parama, long paramLong, int paramInt)
  {
    AppMethodBeat.i(92959);
    this.dja = ((a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    this.djb = paramLong;
    this.bufferSize = paramInt;
    AppMethodBeat.o(92959);
  }
  
  private void Up()
  {
    AppMethodBeat.i(92963);
    long l;
    if (this.daF.length == -1L)
    {
      l = this.djb;
      this.file = this.dja.e(this.daF.key, this.daF.absoluteStreamPosition + this.djf, l);
      this.djd = new FileOutputStream(this.file);
      if (this.bufferSize <= 0) {
        break label161;
      }
      if (this.djg != null) {
        break label147;
      }
      this.djg = new q(this.djd, this.bufferSize);
    }
    label105:
    for (this.djc = this.djg;; this.djc = this.djd)
    {
      this.dje = 0L;
      AppMethodBeat.o(92963);
      return;
      l = Math.min(this.daF.length - this.djf, this.djb);
      break;
      this.djg.a(this.djd);
      break label105;
    }
  }
  
  private void Uq()
  {
    AppMethodBeat.i(92964);
    if (this.djc == null)
    {
      AppMethodBeat.o(92964);
      return;
    }
    try
    {
      this.djc.flush();
      this.djd.getFD().sync();
      x.closeQuietly(this.djc);
      this.djc = null;
      File localFile1 = this.file;
      this.file = null;
      this.dja.x(localFile1);
      AppMethodBeat.o(92964);
      return;
    }
    finally
    {
      x.closeQuietly(this.djc);
      this.djc = null;
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
      this.daF = null;
      AppMethodBeat.o(92960);
      return;
    }
    this.daF = paramj;
    this.djf = 0L;
    try
    {
      Up();
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
    if (this.daF == null)
    {
      AppMethodBeat.o(92962);
      return;
    }
    try
    {
      Uq();
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
    if (this.daF == null)
    {
      AppMethodBeat.o(92961);
      return;
    }
    int i = 0;
    while (i < paramInt2) {
      try
      {
        if (this.dje == this.djb)
        {
          Uq();
          Up();
        }
        int j = (int)Math.min(paramInt2 - i, this.djb - this.dje);
        this.djc.write(paramArrayOfByte, paramInt1 + i, j);
        i += j;
        this.dje += j;
        this.djf += j;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.b
 * JD-Core Version:    0.7.0.1
 */