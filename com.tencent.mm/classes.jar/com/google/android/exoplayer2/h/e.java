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
  private final w<? super e> bEG;
  private long bEH;
  private final ContentResolver bEI;
  private AssetFileDescriptor bEJ;
  private InputStream inputStream;
  private boolean opened;
  private Uri uri;
  
  public e(Context paramContext, w<? super e> paramw)
  {
    AppMethodBeat.i(93033);
    this.bEI = paramContext.getContentResolver();
    this.bEG = paramw;
    AppMethodBeat.o(93033);
  }
  
  public final long a(j paramj)
  {
    AppMethodBeat.i(93034);
    try
    {
      this.uri = paramj.uri;
      this.bEJ = this.bEI.openAssetFileDescriptor(this.uri, "r");
      if (this.bEJ == null)
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
    this.inputStream = new FileInputStream(this.bEJ.getFileDescriptor());
    long l1 = this.bEJ.getStartOffset();
    l1 = this.inputStream.skip(paramj.position + l1) - l1;
    if (l1 != paramj.position)
    {
      paramj = new EOFException();
      AppMethodBeat.o(93034);
      throw paramj;
    }
    if (paramj.length != -1L) {
      this.bEH = paramj.length;
    }
    for (;;)
    {
      this.opened = true;
      if (this.bEG != null) {
        this.bEG.a(this, paramj);
      }
      l1 = this.bEH;
      AppMethodBeat.o(93034);
      return l1;
      long l2 = this.bEJ.getLength();
      if (l2 == -1L)
      {
        this.bEH = this.inputStream.available();
        if (this.bEH == 0L) {
          this.bEH = -1L;
        }
      }
      else
      {
        this.bEH = (l2 - l1);
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
        if (this.bEJ != null) {
          this.bEJ.close();
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
        this.bEJ = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.bEG != null) {
            this.bEG.ah(this);
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
        if (this.bEJ != null) {
          this.bEJ.close();
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
        this.bEJ = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.bEG != null) {
            this.bEG.ah(this);
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
    if (this.bEH == 0L)
    {
      AppMethodBeat.o(93035);
      return -1;
    }
    try
    {
      if (this.bEH == -1L) {}
      for (;;)
      {
        paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, paramInt2);
        if (paramInt1 != -1) {
          break label134;
        }
        if (this.bEH == -1L) {
          break;
        }
        paramArrayOfByte = new a(new EOFException());
        AppMethodBeat.o(93035);
        throw paramArrayOfByte;
        long l = Math.min(this.bEH, paramInt2);
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
    if (this.bEH != -1L) {
      this.bEH -= paramInt1;
    }
    if (this.bEG != null) {
      this.bEG.e(this, paramInt1);
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