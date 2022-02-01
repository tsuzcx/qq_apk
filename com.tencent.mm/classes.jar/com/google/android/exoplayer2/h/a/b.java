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
  private j bgL;
  private long bpA;
  private long bpB;
  private q bpC;
  private final a bpx;
  private final long bpy;
  private FileOutputStream bpz;
  private final int bufferSize;
  private File file;
  private OutputStream outputStream;
  
  public b(a parama, long paramLong, int paramInt)
  {
    AppMethodBeat.i(92959);
    this.bpx = ((a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    this.bpy = paramLong;
    this.bufferSize = paramInt;
    AppMethodBeat.o(92959);
  }
  
  private void uQ()
  {
    AppMethodBeat.i(92963);
    long l;
    if (this.bgL.aFL == -1L)
    {
      l = this.bpy;
      this.file = this.bpx.e(this.bgL.key, this.bgL.bos + this.bpB, l);
      this.bpz = new FileOutputStream(this.file);
      if (this.bufferSize <= 0) {
        break label161;
      }
      if (this.bpC != null) {
        break label147;
      }
      this.bpC = new q(this.bpz, this.bufferSize);
    }
    label105:
    for (this.outputStream = this.bpC;; this.outputStream = this.bpz)
    {
      this.bpA = 0L;
      AppMethodBeat.o(92963);
      return;
      l = Math.min(this.bgL.aFL - this.bpB, this.bpy);
      break;
      this.bpC.a(this.bpz);
      break label105;
    }
  }
  
  private void uR()
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
      this.bpz.getFD().sync();
      x.closeQuietly(this.outputStream);
      this.outputStream = null;
      File localFile1 = this.file;
      this.file = null;
      this.bpx.r(localFile1);
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
    if ((paramj.aFL == -1L) && (!paramj.fp(2)))
    {
      this.bgL = null;
      AppMethodBeat.o(92960);
      return;
    }
    this.bgL = paramj;
    this.bpB = 0L;
    try
    {
      uQ();
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
    if (this.bgL == null)
    {
      AppMethodBeat.o(92962);
      return;
    }
    try
    {
      uR();
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
    if (this.bgL == null)
    {
      AppMethodBeat.o(92961);
      return;
    }
    int i = 0;
    while (i < paramInt2) {
      try
      {
        if (this.bpA == this.bpy)
        {
          uR();
          uQ();
        }
        int j = (int)Math.min(paramInt2 - i, this.bpy - this.bpA);
        this.outputStream.write(paramArrayOfByte, paramInt1 + i, j);
        i += j;
        this.bpA += j;
        this.bpB += j;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.b
 * JD-Core Version:    0.7.0.1
 */