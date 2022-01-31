package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class q
  implements g
{
  private final w<? super q> aYq;
  private long aYs;
  private RandomAccessFile aZl;
  private boolean opened;
  private Uri uri;
  
  public q()
  {
    this(null);
  }
  
  public q(w<? super q> paramw)
  {
    this.aYq = paramw;
  }
  
  public final long a(j paramj)
  {
    AppMethodBeat.i(95835);
    for (;;)
    {
      try
      {
        this.uri = paramj.uri;
        this.aZl = new RandomAccessFile(paramj.uri.getPath(), "r");
        this.aZl.seek(paramj.position);
        if (paramj.aPF == -1L)
        {
          l = this.aZl.length() - paramj.position;
          this.aYs = l;
          if (this.aYs >= 0L) {
            break;
          }
          paramj = new EOFException();
          AppMethodBeat.o(95835);
          throw paramj;
        }
      }
      catch (IOException paramj)
      {
        paramj = new q.a(paramj);
        AppMethodBeat.o(95835);
        throw paramj;
      }
      l = paramj.aPF;
    }
    this.opened = true;
    if (this.aYq != null) {
      this.aYq.qq();
    }
    long l = this.aYs;
    AppMethodBeat.o(95835);
    return l;
  }
  
  public final void close()
  {
    AppMethodBeat.i(95837);
    this.uri = null;
    try
    {
      if (this.aZl != null) {
        this.aZl.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      q.a locala = new q.a(localIOException);
      AppMethodBeat.o(95837);
      throw locala;
    }
    finally
    {
      this.aZl = null;
      if (this.opened)
      {
        this.opened = false;
        if (this.aYq != null) {
          this.aYq.qr();
        }
      }
      AppMethodBeat.o(95837);
    }
    AppMethodBeat.o(95837);
  }
  
  public final Uri getUri()
  {
    return this.uri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95836);
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(95836);
      return 0;
    }
    if (this.aYs == 0L)
    {
      AppMethodBeat.o(95836);
      return -1;
    }
    try
    {
      paramInt1 = this.aZl.read(paramArrayOfByte, paramInt1, (int)Math.min(this.aYs, paramInt2));
      if (paramInt1 > 0)
      {
        this.aYs -= paramInt1;
        if (this.aYq != null) {
          this.aYq.el(paramInt1);
        }
      }
      AppMethodBeat.o(95836);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new q.a(paramArrayOfByte);
      AppMethodBeat.o(95836);
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.q
 * JD-Core Version:    0.7.0.1
 */