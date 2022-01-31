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
  private final w<? super e> aYq;
  private InputStream aYr;
  private long aYs;
  private final ContentResolver aYt;
  private AssetFileDescriptor aYu;
  private boolean opened;
  private Uri uri;
  
  public e(Context paramContext, w<? super e> paramw)
  {
    AppMethodBeat.i(95791);
    this.aYt = paramContext.getContentResolver();
    this.aYq = paramw;
    AppMethodBeat.o(95791);
  }
  
  public final long a(j paramj)
  {
    AppMethodBeat.i(95792);
    try
    {
      this.uri = paramj.uri;
      this.aYu = this.aYt.openAssetFileDescriptor(this.uri, "r");
      if (this.aYu == null)
      {
        paramj = new FileNotFoundException("Could not open file descriptor for: " + this.uri);
        AppMethodBeat.o(95792);
        throw paramj;
      }
    }
    catch (IOException paramj)
    {
      paramj = new e.a(paramj);
      AppMethodBeat.o(95792);
      throw paramj;
    }
    this.aYr = new FileInputStream(this.aYu.getFileDescriptor());
    long l1 = this.aYu.getStartOffset();
    l1 = this.aYr.skip(paramj.position + l1) - l1;
    if (l1 != paramj.position)
    {
      paramj = new EOFException();
      AppMethodBeat.o(95792);
      throw paramj;
    }
    if (paramj.aPF != -1L) {
      this.aYs = paramj.aPF;
    }
    for (;;)
    {
      this.opened = true;
      if (this.aYq != null) {
        this.aYq.qq();
      }
      l1 = this.aYs;
      AppMethodBeat.o(95792);
      return l1;
      long l2 = this.aYu.getLength();
      if (l2 == -1L)
      {
        this.aYs = this.aYr.available();
        if (this.aYs == 0L) {
          this.aYs = -1L;
        }
      }
      else
      {
        this.aYs = (l2 - l1);
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(95794);
    this.uri = null;
    try
    {
      if (this.aYr != null) {
        this.aYr.close();
      }
      this.aYr = null;
      try
      {
        if (this.aYu != null) {
          this.aYu.close();
        }
        return;
      }
      catch (IOException localIOException1)
      {
        e.a locala1 = new e.a(localIOException1);
        AppMethodBeat.o(95794);
        throw locala1;
      }
      finally
      {
        this.aYu = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.aYq != null) {
            this.aYq.qr();
          }
        }
        AppMethodBeat.o(95794);
      }
      AppMethodBeat.o(95794);
      return;
    }
    catch (IOException localIOException2)
    {
      e.a locala2 = new e.a(localIOException2);
      AppMethodBeat.o(95794);
      throw locala2;
    }
    finally
    {
      this.aYr = null;
      try
      {
        if (this.aYu != null) {
          this.aYu.close();
        }
        throw localObject2;
      }
      catch (IOException localIOException3)
      {
        e.a locala3 = new e.a(localIOException3);
        AppMethodBeat.o(95794);
        throw locala3;
      }
      finally
      {
        this.aYu = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.aYq != null) {
            this.aYq.qr();
          }
        }
        AppMethodBeat.o(95794);
      }
    }
  }
  
  public final Uri getUri()
  {
    return this.uri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95793);
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(95793);
      return 0;
    }
    if (this.aYs == 0L)
    {
      AppMethodBeat.o(95793);
      return -1;
    }
    try
    {
      if (this.aYs == -1L) {}
      for (;;)
      {
        paramInt1 = this.aYr.read(paramArrayOfByte, paramInt1, paramInt2);
        if (paramInt1 != -1) {
          break label134;
        }
        if (this.aYs == -1L) {
          break;
        }
        paramArrayOfByte = new e.a(new EOFException());
        AppMethodBeat.o(95793);
        throw paramArrayOfByte;
        long l = Math.min(this.aYs, paramInt2);
        paramInt2 = (int)l;
      }
      AppMethodBeat.o(95793);
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new e.a(paramArrayOfByte);
      AppMethodBeat.o(95793);
      throw paramArrayOfByte;
    }
    return -1;
    label134:
    if (this.aYs != -1L) {
      this.aYs -= paramInt1;
    }
    if (this.aYq != null) {
      this.aYq.el(paramInt1);
    }
    AppMethodBeat.o(95793);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.h.e
 * JD-Core Version:    0.7.0.1
 */