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
  private long bEH;
  private RandomAccessFile file;
  private String lqQ = "";
  private String lrE;
  private final s lrh = null;
  private long lrj = -1L;
  private boolean opened;
  private Uri uri;
  
  public k()
  {
    this((byte)0);
  }
  
  private k(byte paramByte) {}
  
  public final void Ru(String paramString)
  {
    this.lqQ = paramString;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(211082);
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
          this.bEH = l;
          this.lrj = (this.file.length() - paramg.position);
          if (this.bEH >= 0L) {
            break;
          }
          paramg = new EOFException();
          AppMethodBeat.o(211082);
          throw paramg;
        }
      }
      catch (IOException paramg)
      {
        paramg = new a(paramg);
        AppMethodBeat.o(211082);
        throw paramg;
      }
      l = paramg.length;
    }
    this.opened = true;
    if (this.lrh != null) {
      this.lrh.onTransferStart();
    }
    long l = this.bEH;
    AppMethodBeat.o(211082);
    return l;
  }
  
  public final long available()
  {
    return this.lrj;
  }
  
  public final long bbj()
  {
    AppMethodBeat.i(211087);
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
    AppMethodBeat.o(211087);
    return l1;
  }
  
  public c bom()
  {
    AppMethodBeat.i(211086);
    Object localObject = a.boh().appContext.getContentResolver().getType(this.uri);
    if (localObject == null)
    {
      localObject = c.lrQ;
      AppMethodBeat.o(211086);
      return localObject;
    }
    localObject = c.Rx((String)localObject);
    AppMethodBeat.o(211086);
    return localObject;
  }
  
  public final void close()
  {
    AppMethodBeat.i(211085);
    this.lrE = null;
    if (this.file != null) {
      try
      {
        this.file.close();
        return;
      }
      catch (IOException localIOException)
      {
        a locala = new a(localIOException);
        AppMethodBeat.o(211085);
        throw locala;
      }
      finally
      {
        this.file = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.lrh != null) {
            this.lrh.onTransferEnd();
          }
        }
        AppMethodBeat.o(211085);
      }
    }
    AppMethodBeat.o(211085);
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(211084);
    if ((TextUtils.isEmpty(this.lrE)) && (this.uri != null)) {
      this.lrE = this.uri.toString();
    }
    String str = this.lrE;
    AppMethodBeat.o(211084);
    return str;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211083);
    if (this.bEH == 0L)
    {
      AppMethodBeat.o(211083);
      return -1;
    }
    try
    {
      paramInt1 = this.file.read(paramArrayOfByte, paramInt1, (int)Math.min(this.bEH, paramInt2));
      if (paramInt1 > 0)
      {
        this.bEH -= paramInt1;
        if (this.lrh != null) {
          this.lrh.tz(paramInt1);
        }
      }
      AppMethodBeat.o(211083);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new a(paramArrayOfByte);
      AppMethodBeat.o(211083);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.k
 * JD-Core Version:    0.7.0.1
 */