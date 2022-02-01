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
  private long bus;
  private RandomAccessFile file;
  private String kPQ = "";
  private String kQE;
  private final s kQh = null;
  private long kQj = -1L;
  private boolean opened;
  private Uri uri;
  
  public k()
  {
    this((byte)0);
  }
  
  private k(byte paramByte) {}
  
  public final void No(String paramString)
  {
    this.kPQ = paramString;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(194243);
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
          this.bus = l;
          this.kQj = (this.file.length() - paramg.position);
          if (this.bus >= 0L) {
            break;
          }
          paramg = new EOFException();
          AppMethodBeat.o(194243);
          throw paramg;
        }
      }
      catch (IOException paramg)
      {
        paramg = new a(paramg);
        AppMethodBeat.o(194243);
        throw paramg;
      }
      l = paramg.length;
    }
    this.opened = true;
    if (this.kQh != null) {
      this.kQh.onTransferStart();
    }
    long l = this.bus;
    AppMethodBeat.o(194243);
    return l;
  }
  
  public final long aXm()
  {
    AppMethodBeat.i(194248);
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
    AppMethodBeat.o(194248);
    return l1;
  }
  
  public final long available()
  {
    return this.kQj;
  }
  
  public c bjR()
  {
    AppMethodBeat.i(194247);
    Object localObject = a.bjM().appContext.getContentResolver().getType(this.uri);
    if (localObject == null)
    {
      localObject = c.kQQ;
      AppMethodBeat.o(194247);
      return localObject;
    }
    localObject = c.Nr((String)localObject);
    AppMethodBeat.o(194247);
    return localObject;
  }
  
  public final void close()
  {
    AppMethodBeat.i(194246);
    this.kQE = null;
    if (this.file != null) {
      try
      {
        this.file.close();
        return;
      }
      catch (IOException localIOException)
      {
        a locala = new a(localIOException);
        AppMethodBeat.o(194246);
        throw locala;
      }
      finally
      {
        this.file = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.kQh != null) {
            this.kQh.onTransferEnd();
          }
        }
        AppMethodBeat.o(194246);
      }
    }
    AppMethodBeat.o(194246);
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(194245);
    if ((TextUtils.isEmpty(this.kQE)) && (this.uri != null)) {
      this.kQE = this.uri.toString();
    }
    String str = this.kQE;
    AppMethodBeat.o(194245);
    return str;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194244);
    if (this.bus == 0L)
    {
      AppMethodBeat.o(194244);
      return -1;
    }
    try
    {
      paramInt1 = this.file.read(paramArrayOfByte, paramInt1, (int)Math.min(this.bus, paramInt2));
      if (paramInt1 > 0)
      {
        this.bus -= paramInt1;
        if (this.kQh != null) {
          this.kQh.sS(paramInt1);
        }
      }
      AppMethodBeat.o(194244);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new a(paramArrayOfByte);
      AppMethodBeat.o(194244);
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