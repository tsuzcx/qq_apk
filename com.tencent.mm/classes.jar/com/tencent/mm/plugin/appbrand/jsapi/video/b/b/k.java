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
  private long bwt;
  private RandomAccessFile file;
  private final s koO = null;
  private long koQ = -1L;
  private String kox = "";
  private String kpl;
  private boolean opened;
  private Uri uri;
  
  public k()
  {
    this((byte)0);
  }
  
  private k(byte paramByte) {}
  
  public final void Jk(String paramString)
  {
    this.kox = paramString;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(193896);
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
          this.bwt = l;
          this.koQ = (this.file.length() - paramg.position);
          if (this.bwt >= 0L) {
            break;
          }
          paramg = new EOFException();
          AppMethodBeat.o(193896);
          throw paramg;
        }
      }
      catch (IOException paramg)
      {
        paramg = new a(paramg);
        AppMethodBeat.o(193896);
        throw paramg;
      }
      l = paramg.length;
    }
    this.opened = true;
    if (this.koO != null) {
      this.koO.onTransferStart();
    }
    long l = this.bwt;
    AppMethodBeat.o(193896);
    return l;
  }
  
  public final long aQu()
  {
    AppMethodBeat.i(193901);
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
    AppMethodBeat.o(193901);
    return l1;
  }
  
  public final long available()
  {
    return this.koQ;
  }
  
  public c bcW()
  {
    AppMethodBeat.i(193900);
    Object localObject = a.bcR().kob.getContentResolver().getType(this.uri);
    if (localObject == null)
    {
      localObject = c.kpx;
      AppMethodBeat.o(193900);
      return localObject;
    }
    localObject = c.Jn((String)localObject);
    AppMethodBeat.o(193900);
    return localObject;
  }
  
  public final void close()
  {
    AppMethodBeat.i(193899);
    this.kpl = null;
    if (this.file != null) {
      try
      {
        this.file.close();
        return;
      }
      catch (IOException localIOException)
      {
        a locala = new a(localIOException);
        AppMethodBeat.o(193899);
        throw locala;
      }
      finally
      {
        this.file = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.koO != null) {
            this.koO.onTransferEnd();
          }
        }
        AppMethodBeat.o(193899);
      }
    }
    AppMethodBeat.o(193899);
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(193898);
    if ((TextUtils.isEmpty(this.kpl)) && (this.uri != null)) {
      this.kpl = this.uri.toString();
    }
    String str = this.kpl;
    AppMethodBeat.o(193898);
    return str;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193897);
    if (this.bwt == 0L)
    {
      AppMethodBeat.o(193897);
      return -1;
    }
    try
    {
      paramInt1 = this.file.read(paramArrayOfByte, paramInt1, (int)Math.min(this.bwt, paramInt2));
      if (paramInt1 > 0)
      {
        this.bwt -= paramInt1;
        if (this.koO != null) {
          this.koO.sc(paramInt1);
        }
      }
      AppMethodBeat.o(193897);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new a(paramArrayOfByte);
      AppMethodBeat.o(193897);
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