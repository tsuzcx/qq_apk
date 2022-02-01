package com.tencent.mm.loader.h.b;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class a
  implements Closeable
{
  InputStream aFw = null;
  byte[] kQS = null;
  d kQT;
  c kQU;
  Object kQV;
  
  private a(d paramd, c paramc, Object paramObject)
  {
    this.kQT = paramd;
    this.kQU = paramc;
    this.kQV = paramObject;
  }
  
  public static a Ov(String paramString)
  {
    return i(paramString, null);
  }
  
  public static a Ow(String paramString)
  {
    return a(MMApplicationContext.getContext().getAssets().open(paramString), MMApplicationContext.getContext().getAssets().open(paramString));
  }
  
  private static <T extends d,  extends c> a a(T paramT, Object paramObject)
  {
    return new a(paramT, (c)paramT, paramObject);
  }
  
  public static a a(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    return new a(new e(paramInputStream1), new c(paramInputStream2), null);
  }
  
  public static a an(byte[] paramArrayOfByte)
  {
    return new a(new d(paramArrayOfByte), new b(paramArrayOfByte), null);
  }
  
  public static a i(String paramString, Object paramObject)
  {
    return a(new a(paramString), paramObject);
  }
  
  public final InputStream aSw()
  {
    if (this.aFw != null) {
      return this.aFw;
    }
    if (this.kQT != null)
    {
      this.aFw = this.kQT.aSw();
      return this.aFw;
    }
    return null;
  }
  
  public final void close()
  {
    if (this.kQT != null)
    {
      this.kQT.close();
      this.kQT = null;
    }
    if (this.kQU != null) {
      this.kQU.close();
    }
  }
  
  public final Object getTag()
  {
    return this.kQV;
  }
  
  static final class a
    implements c, d
  {
    InputStream ctN = null;
    String mFilePath;
    
    public a(String paramString)
    {
      this.mFilePath = paramString;
    }
    
    public final InputStream aSw()
    {
      try
      {
        this.ctN = u.Tf(this.mFilePath);
        InputStream localInputStream = this.ctN;
        return localInputStream;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      return null;
    }
    
    public final void close()
    {
      a.r(this.ctN);
    }
  }
  
  static final class b
    implements c
  {
    byte[] kQW;
    
    public b(byte[] paramArrayOfByte)
    {
      this.kQW = paramArrayOfByte;
    }
    
    public final void close() {}
  }
  
  static final class c
    implements c
  {
    InputStream kQX;
    
    public c(InputStream paramInputStream)
    {
      this.kQX = paramInputStream;
    }
    
    public final void close()
    {
      a.r(this.kQX);
    }
  }
  
  static final class d
    implements d
  {
    InputStream ctN = null;
    byte[] kQW;
    
    public d(byte[] paramArrayOfByte)
    {
      this.kQW = paramArrayOfByte;
    }
    
    public final InputStream aSw()
    {
      if (this.ctN == null) {
        this.ctN = new ByteArrayInputStream(this.kQW);
      }
      return this.ctN;
    }
    
    public final void close()
    {
      a.r(this.ctN);
    }
  }
  
  static final class e
    implements d
  {
    InputStream kQX;
    
    public e(InputStream paramInputStream)
    {
      this.kQX = paramInputStream;
    }
    
    public final InputStream aSw()
    {
      return this.kQX;
    }
    
    public final void close()
    {
      a.r(this.kQX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.h.b.a
 * JD-Core Version:    0.7.0.1
 */