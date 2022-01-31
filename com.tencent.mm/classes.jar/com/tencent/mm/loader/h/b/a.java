package com.tencent.mm.loader.h.b;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.e;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class a
  implements Closeable
{
  InputStream aYr = null;
  byte[] eQn = null;
  d eQo;
  c eQp;
  Object eQq;
  
  private a(d paramd, c paramc, Object paramObject)
  {
    this.eQo = paramd;
    this.eQp = paramc;
    this.eQq = paramObject;
  }
  
  public static a K(byte[] paramArrayOfByte)
  {
    return new a(new a.d(paramArrayOfByte), new b(paramArrayOfByte), null);
  }
  
  private static <T extends d,  extends c> a a(T paramT, Object paramObject)
  {
    return new a(paramT, (c)paramT, paramObject);
  }
  
  public static a a(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    return new a(new a.e(paramInputStream1), new c(paramInputStream2), null);
  }
  
  public static a h(String paramString, Object paramObject)
  {
    return a(new a(paramString), paramObject);
  }
  
  public static a mM(String paramString)
  {
    return h(paramString, null);
  }
  
  public static a mN(String paramString)
  {
    return a(ah.getContext().getAssets().open(paramString), ah.getContext().getAssets().open(paramString));
  }
  
  public final InputStream Uh()
  {
    if (this.aYr != null) {
      return this.aYr;
    }
    if (this.eQo != null)
    {
      this.aYr = this.eQo.Uh();
      return this.aYr;
    }
    return null;
  }
  
  public final void close()
  {
    if (this.eQo != null)
    {
      this.eQo.close();
      this.eQo = null;
    }
    if (this.eQp != null) {
      this.eQp.close();
    }
  }
  
  static final class a
    implements c, d
  {
    InputStream bAO = null;
    String mFilePath;
    
    public a(String paramString)
    {
      this.mFilePath = paramString;
    }
    
    public final InputStream Uh()
    {
      try
      {
        this.bAO = e.openRead(this.mFilePath);
        InputStream localInputStream = this.bAO;
        return localInputStream;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      return null;
    }
    
    public final void close()
    {
      a.o(this.bAO);
    }
  }
  
  static final class b
    implements c
  {
    byte[] mBuf;
    
    public b(byte[] paramArrayOfByte)
    {
      this.mBuf = paramArrayOfByte;
    }
    
    public final void close() {}
  }
  
  static final class c
    implements c
  {
    InputStream eQr;
    
    public c(InputStream paramInputStream)
    {
      this.eQr = paramInputStream;
    }
    
    public final void close()
    {
      a.o(this.eQr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.h.b.a
 * JD-Core Version:    0.7.0.1
 */