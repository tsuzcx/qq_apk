package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class q
  implements g
{
  private final w<? super q> did;
  private long die;
  private RandomAccessFile file;
  private boolean opened;
  private Uri uri;
  
  public q()
  {
    this(null);
  }
  
  public q(w<? super q> paramw)
  {
    this.did = paramw;
  }
  
  public final long a(j paramj)
  {
    AppMethodBeat.i(93079);
    for (;;)
    {
      try
      {
        this.uri = paramj.uri;
        this.file = new RandomAccessFile(paramj.uri.getPath(), "r");
        this.file.seek(paramj.position);
        if (paramj.length == -1L)
        {
          l = this.file.length() - paramj.position;
          this.die = l;
          if (this.die >= 0L) {
            break;
          }
          paramj = new EOFException();
          AppMethodBeat.o(93079);
          throw paramj;
        }
      }
      catch (IOException paramj)
      {
        paramj = new a(paramj);
        AppMethodBeat.o(93079);
        throw paramj;
      }
      l = paramj.length;
    }
    this.opened = true;
    if (this.did != null) {
      this.did.a(this, paramj);
    }
    long l = this.die;
    AppMethodBeat.o(93079);
    return l;
  }
  
  public final void close()
  {
    AppMethodBeat.i(93081);
    this.uri = null;
    try
    {
      if (this.file != null) {
        this.file.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      a locala = new a(localIOException);
      AppMethodBeat.o(93081);
      throw locala;
    }
    finally
    {
      this.file = null;
      if (this.opened)
      {
        this.opened = false;
        if (this.did != null) {
          this.did.bj(this);
        }
      }
      AppMethodBeat.o(93081);
    }
    AppMethodBeat.o(93081);
  }
  
  public final Uri getUri()
  {
    return this.uri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93080);
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(93080);
      return 0;
    }
    if (this.die == 0L)
    {
      AppMethodBeat.o(93080);
      return -1;
    }
    try
    {
      paramInt1 = this.file.read(paramArrayOfByte, paramInt1, (int)Math.min(this.die, paramInt2));
      if (paramInt1 > 0)
      {
        this.die -= paramInt1;
        if (this.did != null) {
          this.did.f(this, paramInt1);
        }
      }
      AppMethodBeat.o(93080);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new a(paramArrayOfByte);
      AppMethodBeat.o(93080);
      throw paramArrayOfByte;
    }
  }
  
  public static final class a
    extends IOException
  {
    public a(IOException paramIOException)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.q
 * JD-Core Version:    0.7.0.1
 */