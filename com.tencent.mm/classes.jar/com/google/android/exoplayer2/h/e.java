package com.google.android.exoplayer2.h;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class e
  implements g
{
  private final w<? super e> bur;
  private long bus;
  private final ContentResolver but;
  private AssetFileDescriptor buu;
  private InputStream inputStream;
  private boolean opened;
  private Uri uri;
  
  public e(Context paramContext, w<? super e> paramw)
  {
    AppMethodBeat.i(93033);
    this.but = paramContext.getContentResolver();
    this.bur = paramw;
    AppMethodBeat.o(93033);
  }
  
  public final long a(j paramj)
  {
    AppMethodBeat.i(93034);
    try
    {
      this.uri = paramj.uri;
      this.buu = this.but.openAssetFileDescriptor(this.uri, "r");
      if (this.buu == null)
      {
        paramj = new FileNotFoundException("Could not open file descriptor for: " + this.uri);
        AppMethodBeat.o(93034);
        throw paramj;
      }
    }
    catch (IOException paramj)
    {
      paramj = new a(paramj);
      AppMethodBeat.o(93034);
      throw paramj;
    }
    this.inputStream = new FileInputStream(this.buu.getFileDescriptor());
    long l1 = this.buu.getStartOffset();
    l1 = this.inputStream.skip(paramj.position + l1) - l1;
    if (l1 != paramj.position)
    {
      paramj = new EOFException();
      AppMethodBeat.o(93034);
      throw paramj;
    }
    if (paramj.length != -1L) {
      this.bus = paramj.length;
    }
    for (;;)
    {
      this.opened = true;
      if (this.bur != null) {
        this.bur.ve();
      }
      l1 = this.bus;
      AppMethodBeat.o(93034);
      return l1;
      long l2 = this.buu.getLength();
      if (l2 == -1L)
      {
        this.bus = this.inputStream.available();
        if (this.bus == 0L) {
          this.bus = -1L;
        }
      }
      else
      {
        this.bus = (l2 - l1);
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(93036);
    this.uri = null;
    try
    {
      if (this.inputStream != null) {
        this.inputStream.close();
      }
      this.inputStream = null;
      try
      {
        if (this.buu != null) {
          this.buu.close();
        }
        return;
      }
      catch (IOException localIOException1)
      {
        a locala1 = new a(localIOException1);
        AppMethodBeat.o(93036);
        throw locala1;
      }
      finally
      {
        this.buu = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.bur != null) {
            this.bur.vf();
          }
        }
        AppMethodBeat.o(93036);
      }
      AppMethodBeat.o(93036);
      return;
    }
    catch (IOException localIOException2)
    {
      a locala2 = new a(localIOException2);
      AppMethodBeat.o(93036);
      throw locala2;
    }
    finally
    {
      this.inputStream = null;
      try
      {
        if (this.buu != null) {
          this.buu.close();
        }
        throw localObject2;
      }
      catch (IOException localIOException3)
      {
        a locala3 = new a(localIOException3);
        AppMethodBeat.o(93036);
        throw locala3;
      }
      finally
      {
        this.buu = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.bur != null) {
            this.bur.vf();
          }
        }
        AppMethodBeat.o(93036);
      }
    }
  }
  
  public final Uri getUri()
  {
    return this.uri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93035);
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(93035);
      return 0;
    }
    if (this.bus == 0L)
    {
      AppMethodBeat.o(93035);
      return -1;
    }
    try
    {
      if (this.bus == -1L) {}
      for (;;)
      {
        paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, paramInt2);
        if (paramInt1 != -1) {
          break label134;
        }
        if (this.bus == -1L) {
          break;
        }
        paramArrayOfByte = new a(new EOFException());
        AppMethodBeat.o(93035);
        throw paramArrayOfByte;
        long l = Math.min(this.bus, paramInt2);
        paramInt2 = (int)l;
      }
      AppMethodBeat.o(93035);
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new a(paramArrayOfByte);
      AppMethodBeat.o(93035);
      throw paramArrayOfByte;
    }
    return -1;
    label134:
    if (this.bus != -1L) {
      this.bus -= paramInt1;
    }
    if (this.bur != null) {
      this.bur.eV(paramInt1);
    }
    AppMethodBeat.o(93035);
    return paramInt1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.e
 * JD-Core Version:    0.7.0.1
 */