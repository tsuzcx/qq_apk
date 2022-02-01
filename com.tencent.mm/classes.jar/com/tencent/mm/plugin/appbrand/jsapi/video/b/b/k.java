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
  private final s lmH = null;
  private long lmJ = -1L;
  private String lmq = "";
  private String lne;
  private boolean opened;
  private Uri uri;
  
  public k()
  {
    this((byte)0);
  }
  
  private k(byte paramByte) {}
  
  public final void QL(String paramString)
  {
    this.lmq = paramString;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(206055);
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
          this.lmJ = (this.file.length() - paramg.position);
          if (this.bEH >= 0L) {
            break;
          }
          paramg = new EOFException();
          AppMethodBeat.o(206055);
          throw paramg;
        }
      }
      catch (IOException paramg)
      {
        paramg = new a(paramg);
        AppMethodBeat.o(206055);
        throw paramg;
      }
      l = paramg.length;
    }
    this.opened = true;
    if (this.lmH != null) {
      this.lmH.onTransferStart();
    }
    long l = this.bEH;
    AppMethodBeat.o(206055);
    return l;
  }
  
  public final long available()
  {
    return this.lmJ;
  }
  
  public final long baK()
  {
    AppMethodBeat.i(206060);
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
    AppMethodBeat.o(206060);
    return l1;
  }
  
  public c bnC()
  {
    AppMethodBeat.i(206059);
    Object localObject = a.bnx().appContext.getContentResolver().getType(this.uri);
    if (localObject == null)
    {
      localObject = c.lnr;
      AppMethodBeat.o(206059);
      return localObject;
    }
    localObject = c.QO((String)localObject);
    AppMethodBeat.o(206059);
    return localObject;
  }
  
  public final void close()
  {
    AppMethodBeat.i(206058);
    this.lne = null;
    if (this.file != null) {
      try
      {
        this.file.close();
        return;
      }
      catch (IOException localIOException)
      {
        a locala = new a(localIOException);
        AppMethodBeat.o(206058);
        throw locala;
      }
      finally
      {
        this.file = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.lmH != null) {
            this.lmH.onTransferEnd();
          }
        }
        AppMethodBeat.o(206058);
      }
    }
    AppMethodBeat.o(206058);
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(206057);
    if ((TextUtils.isEmpty(this.lne)) && (this.uri != null)) {
      this.lne = this.uri.toString();
    }
    String str = this.lne;
    AppMethodBeat.o(206057);
    return str;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206056);
    if (this.bEH == 0L)
    {
      AppMethodBeat.o(206056);
      return -1;
    }
    try
    {
      paramInt1 = this.file.read(paramArrayOfByte, paramInt1, (int)Math.min(this.bEH, paramInt2));
      if (paramInt1 > 0)
      {
        this.bEH -= paramInt1;
        if (this.lmH != null) {
          this.lmH.tv(paramInt1);
        }
      }
      AppMethodBeat.o(206056);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new a(paramArrayOfByte);
      AppMethodBeat.o(206056);
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