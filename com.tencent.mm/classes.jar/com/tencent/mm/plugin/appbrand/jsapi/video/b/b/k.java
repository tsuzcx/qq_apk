package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class k
  implements t
{
  private long bEJ;
  private RandomAccessFile file;
  private final s mxN = null;
  private long mxP = -1L;
  private String mxw = "";
  private String myk;
  private boolean opened;
  private Uri uri;
  
  public k()
  {
    this((byte)0);
  }
  
  private k(byte paramByte) {}
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(234751);
    for (;;)
    {
      try
      {
        this.uri = paramg.uri;
        this.file = new RandomAccessFile(paramg.uri.getPath(), "r");
        this.file.seek(paramg.position);
        if (paramg.length == -1L)
        {
          l = this.file.length() - paramg.position;
          this.bEJ = l;
          this.mxP = (this.file.length() - paramg.position);
          if (this.bEJ >= 0L) {
            break;
          }
          paramg = new EOFException();
          AppMethodBeat.o(234751);
          throw paramg;
        }
      }
      catch (IOException paramg)
      {
        paramg = new a(paramg);
        AppMethodBeat.o(234751);
        throw paramg;
      }
      l = paramg.length;
    }
    this.opened = true;
    if (this.mxN != null) {
      this.mxN.onTransferStart();
    }
    long l = this.bEJ;
    AppMethodBeat.o(234751);
    return l;
  }
  
  public final long available()
  {
    return this.mxP;
  }
  
  public c bJP()
  {
    AppMethodBeat.i(234755);
    Object localObject = a.bJK().appContext.getContentResolver().getType(this.uri);
    if (localObject == null)
    {
      localObject = c.myw;
      AppMethodBeat.o(234755);
      return localObject;
    }
    localObject = c.abd((String)localObject);
    AppMethodBeat.o(234755);
    return localObject;
  }
  
  public final void close()
  {
    AppMethodBeat.i(234754);
    this.myk = null;
    if (this.file != null) {
      try
      {
        this.file.close();
        return;
      }
      catch (IOException localIOException)
      {
        a locala = new a(localIOException);
        AppMethodBeat.o(234754);
        throw locala;
      }
      finally
      {
        this.file = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.mxN != null) {
            this.mxN.onTransferEnd();
          }
        }
        AppMethodBeat.o(234754);
      }
    }
    AppMethodBeat.o(234754);
  }
  
  public final long getTotalLength()
  {
    AppMethodBeat.i(234756);
    long l1 = 0L;
    try
    {
      long l2 = this.file.length();
      l1 = l2;
    }
    catch (IOException localIOException)
    {
      label17:
      break label17;
    }
    AppMethodBeat.o(234756);
    return l1;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(234753);
    if ((TextUtils.isEmpty(this.myk)) && (this.uri != null)) {
      this.myk = this.uri.toString();
    }
    String str = this.myk;
    AppMethodBeat.o(234753);
    return str;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234752);
    if (this.bEJ == 0L)
    {
      AppMethodBeat.o(234752);
      return -1;
    }
    try
    {
      paramInt1 = this.file.read(paramArrayOfByte, paramInt1, (int)Math.min(this.bEJ, paramInt2));
      if (paramInt1 > 0)
      {
        this.bEJ -= paramInt1;
        if (this.mxN != null) {
          this.mxN.xx(paramInt1);
        }
      }
      AppMethodBeat.o(234752);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new a(paramArrayOfByte);
      AppMethodBeat.o(234752);
      throw paramArrayOfByte;
    }
  }
  
  public final void setLogTag(String paramString)
  {
    this.mxw = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.k
 * JD-Core Version:    0.7.0.1
 */