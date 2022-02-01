package com.tencent.mm.loader.h.b;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class a
  implements Closeable
{
  byte[] hjo = null;
  d hjp;
  c hjq;
  Object hjr;
  InputStream inputStream = null;
  
  private a(d paramd, c paramc, Object paramObject)
  {
    this.hjp = paramd;
    this.hjq = paramc;
    this.hjr = paramObject;
  }
  
  public static a Q(byte[] paramArrayOfByte)
  {
    return new a(new d(paramArrayOfByte), new b(paramArrayOfByte), null);
  }
  
  private static <T extends d,  extends c> a a(T paramT, Object paramObject)
  {
    return new a(paramT, (c)paramT, paramObject);
  }
  
  public static a a(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    return new a(new e(paramInputStream1), new c(paramInputStream2), null);
  }
  
  public static a j(String paramString, Object paramObject)
  {
    return a(new a(paramString), paramObject);
  }
  
  public static a yL(String paramString)
  {
    return j(paramString, null);
  }
  
  public static a yM(String paramString)
  {
    return a(ak.getContext().getAssets().open(paramString), ak.getContext().getAssets().open(paramString));
  }
  
  public final InputStream arU()
  {
    if (this.inputStream != null) {
      return this.inputStream;
    }
    if (this.hjp != null)
    {
      this.inputStream = this.hjp.arU();
      return this.inputStream;
    }
    return null;
  }
  
  public final void close()
  {
    if (this.hjp != null)
    {
      this.hjp.close();
      this.hjp = null;
    }
    if (this.hjq != null) {
      this.hjq.close();
    }
  }
  
  public final Object getTag()
  {
    return this.hjr;
  }
  
  static final class a
    implements c, d
  {
    InputStream aFw = null;
    String mFilePath;
    
    public a(String paramString)
    {
      this.mFilePath = paramString;
    }
    
    public final InputStream arU()
    {
      try
      {
        this.aFw = o.openRead(this.mFilePath);
        InputStream localInputStream = this.aFw;
        return localInputStream;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      return null;
    }
    
    public final void close()
    {
      a.u(this.aFw);
    }
  }
  
  static final class b
    implements c
  {
    byte[] hjs;
    
    public b(byte[] paramArrayOfByte)
    {
      this.hjs = paramArrayOfByte;
    }
    
    public final void close() {}
  }
  
  static final class c
    implements c
  {
    InputStream hjt;
    
    public c(InputStream paramInputStream)
    {
      this.hjt = paramInputStream;
    }
    
    public final void close()
    {
      a.u(this.hjt);
    }
  }
  
  static final class d
    implements d
  {
    InputStream aFw = null;
    byte[] hjs;
    
    public d(byte[] paramArrayOfByte)
    {
      this.hjs = paramArrayOfByte;
    }
    
    public final InputStream arU()
    {
      if (this.aFw == null) {
        this.aFw = new ByteArrayInputStream(this.hjs);
      }
      return this.aFw;
    }
    
    public final void close()
    {
      a.u(this.aFw);
    }
  }
  
  static final class e
    implements d
  {
    InputStream hjt;
    
    public e(InputStream paramInputStream)
    {
      this.hjt = paramInputStream;
    }
    
    public final InputStream arU()
    {
      return this.hjt;
    }
    
    public final void close()
    {
      a.u(this.hjt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.h.b.a
 * JD-Core Version:    0.7.0.1
 */