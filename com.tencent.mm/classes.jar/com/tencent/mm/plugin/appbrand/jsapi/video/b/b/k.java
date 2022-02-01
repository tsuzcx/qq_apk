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
  private long bom;
  private RandomAccessFile file;
  private boolean opened;
  private String pvQ = "";
  private String pwE;
  private final s pwh = null;
  private long pwj = -1L;
  private Uri uri;
  
  public k()
  {
    this((byte)0);
  }
  
  private k(byte paramByte) {}
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(229137);
    for (;;)
    {
      try
      {
        this.uri = paramg.uri;
        this.file = new RandomAccessFile(paramg.uri.getPath(), "r");
        this.file.seek(paramg.position);
        if (paramg.aFL == -1L)
        {
          l = this.file.length() - paramg.position;
          this.bom = l;
          this.pwj = (this.file.length() - paramg.position);
          if (this.bom >= 0L) {
            break;
          }
          paramg = new EOFException();
          AppMethodBeat.o(229137);
          throw paramg;
        }
      }
      catch (IOException paramg)
      {
        paramg = new a(paramg);
        AppMethodBeat.o(229137);
        throw paramg;
      }
      l = paramg.aFL;
    }
    this.opened = true;
    if (this.pwh != null) {
      this.pwh.onTransferStart();
    }
    long l = this.bom;
    AppMethodBeat.o(229137);
    return l;
  }
  
  public final long available()
  {
    return this.pwj;
  }
  
  public c bVy()
  {
    AppMethodBeat.i(229148);
    Object localObject = a.bVt().appContext.getContentResolver().getType(this.uri);
    if (localObject == null)
    {
      localObject = c.pwQ;
      AppMethodBeat.o(229148);
      return localObject;
    }
    localObject = c.aiX((String)localObject);
    AppMethodBeat.o(229148);
    return localObject;
  }
  
  public final void close()
  {
    AppMethodBeat.i(229145);
    this.pwE = null;
    if (this.file != null) {
      try
      {
        this.file.close();
        return;
      }
      catch (IOException localIOException)
      {
        a locala = new a(localIOException);
        AppMethodBeat.o(229145);
        throw locala;
      }
      finally
      {
        this.file = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.pwh != null) {
            this.pwh.onTransferEnd();
          }
        }
        AppMethodBeat.o(229145);
      }
    }
    AppMethodBeat.o(229145);
  }
  
  public final long getTotalLength()
  {
    AppMethodBeat.i(229149);
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
    AppMethodBeat.o(229149);
    return l1;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(229143);
    if ((TextUtils.isEmpty(this.pwE)) && (this.uri != null)) {
      this.pwE = this.uri.toString();
    }
    String str = this.pwE;
    AppMethodBeat.o(229143);
    return str;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229141);
    if (this.bom == 0L)
    {
      AppMethodBeat.o(229141);
      return -1;
    }
    try
    {
      paramInt1 = this.file.read(paramArrayOfByte, paramInt1, (int)Math.min(this.bom, paramInt2));
      if (paramInt1 > 0)
      {
        this.bom -= paramInt1;
        if (this.pwh != null) {
          this.pwh.AU(paramInt1);
        }
      }
      AppMethodBeat.o(229141);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new a(paramArrayOfByte);
      AppMethodBeat.o(229141);
      throw paramArrayOfByte;
    }
  }
  
  public final void setLogTag(String paramString)
  {
    this.pvQ = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.k
 * JD-Core Version:    0.7.0.1
 */