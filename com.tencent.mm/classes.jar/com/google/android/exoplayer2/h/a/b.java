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
  private j bmN;
  private final int bufferSize;
  private final a bvo;
  private final long bvp;
  private FileOutputStream bvq;
  private long bvr;
  private long bvs;
  private q bvt;
  private File file;
  private OutputStream outputStream;
  
  public b(a parama, long paramLong, int paramInt)
  {
    AppMethodBeat.i(92959);
    this.bvo = ((a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    this.bvp = paramLong;
    this.bufferSize = paramInt;
    AppMethodBeat.o(92959);
  }
  
  private void vj()
  {
    AppMethodBeat.i(92963);
    long l;
    if (this.bmN.length == -1L)
    {
      l = this.bvp;
      this.file = this.bvo.e(this.bmN.key, this.bmN.absoluteStreamPosition + this.bvs, l);
      this.bvq = new FileOutputStream(this.file);
      if (this.bufferSize <= 0) {
        break label161;
      }
      if (this.bvt != null) {
        break label147;
      }
      this.bvt = new q(this.bvq, this.bufferSize);
    }
    label105:
    for (this.outputStream = this.bvt;; this.outputStream = this.bvq)
    {
      this.bvr = 0L;
      AppMethodBeat.o(92963);
      return;
      l = Math.min(this.bmN.length - this.bvs, this.bvp);
      break;
      this.bvt.a(this.bvq);
      break label105;
    }
  }
  
  private void vk()
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
      this.bvq.getFD().sync();
      x.closeQuietly(this.outputStream);
      this.outputStream = null;
      File localFile1 = this.file;
      this.file = null;
      this.bvo.w(localFile1);
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
      this.bmN = null;
      AppMethodBeat.o(92960);
      return;
    }
    this.bmN = paramj;
    this.bvs = 0L;
    try
    {
      vj();
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
    if (this.bmN == null)
    {
      AppMethodBeat.o(92962);
      return;
    }
    try
    {
      vk();
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
    if (this.bmN == null)
    {
      AppMethodBeat.o(92961);
      return;
    }
    int i = 0;
    while (i < paramInt2) {
      try
      {
        if (this.bvr == this.bvp)
        {
          vk();
          vj();
        }
        int j = (int)Math.min(paramInt2 - i, this.bvp - this.bvr);
        this.outputStream.write(paramArrayOfByte, paramInt1 + i, j);
        i += j;
        this.bvr += j;
        this.bvs += j;
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