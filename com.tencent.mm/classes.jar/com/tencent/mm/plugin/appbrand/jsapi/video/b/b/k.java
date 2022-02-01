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
  private long die;
  private RandomAccessFile file;
  private boolean opened;
  private String sAW = "";
  private String sBK;
  private final s sBn = null;
  private long sBp = -1L;
  private Uri uri;
  
  public k()
  {
    this((byte)0);
  }
  
  private k(byte paramByte) {}
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(328533);
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
          this.die = l;
          this.sBp = (this.file.length() - paramg.position);
          if (this.die >= 0L) {
            break;
          }
          paramg = new EOFException();
          AppMethodBeat.o(328533);
          throw paramg;
        }
      }
      catch (IOException paramg)
      {
        paramg = new a(paramg);
        AppMethodBeat.o(328533);
        throw paramg;
      }
      l = paramg.length;
    }
    this.opened = true;
    if (this.sBn != null) {
      this.sBn.onTransferStart();
    }
    long l = this.die;
    AppMethodBeat.o(328533);
    return l;
  }
  
  public final long available()
  {
    return this.sBp;
  }
  
  public final void close()
  {
    AppMethodBeat.i(328559);
    this.sBK = null;
    if (this.file != null) {
      try
      {
        this.file.close();
        return;
      }
      catch (IOException localIOException)
      {
        a locala = new a(localIOException);
        AppMethodBeat.o(328559);
        throw locala;
      }
      finally
      {
        this.file = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.sBn != null) {
            this.sBn.onTransferEnd();
          }
        }
        AppMethodBeat.o(328559);
      }
    }
    AppMethodBeat.o(328559);
  }
  
  public c cvM()
  {
    AppMethodBeat.i(328567);
    Object localObject = a.cvH().appContext.getContentResolver().getType(this.uri);
    if (localObject == null)
    {
      localObject = c.sBW;
      AppMethodBeat.o(328567);
      return localObject;
    }
    localObject = c.abW((String)localObject);
    AppMethodBeat.o(328567);
    return localObject;
  }
  
  public final long getTotalLength()
  {
    AppMethodBeat.i(328574);
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
    AppMethodBeat.o(328574);
    return l1;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(328554);
    if ((TextUtils.isEmpty(this.sBK)) && (this.uri != null)) {
      this.sBK = this.uri.toString();
    }
    String str = this.sBK;
    AppMethodBeat.o(328554);
    return str;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(328540);
    if (this.die == 0L)
    {
      AppMethodBeat.o(328540);
      return -1;
    }
    try
    {
      paramInt1 = this.file.read(paramArrayOfByte, paramInt1, (int)Math.min(this.die, paramInt2));
      if (paramInt1 > 0)
      {
        this.die -= paramInt1;
        if (this.sBn != null) {
          this.sBn.Bj(paramInt1);
        }
      }
      AppMethodBeat.o(328540);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new a(paramArrayOfByte);
      AppMethodBeat.o(328540);
      throw paramArrayOfByte;
    }
  }
  
  public final void setLogTag(String paramString)
  {
    this.sAW = paramString;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.k
 * JD-Core Version:    0.7.0.1
 */