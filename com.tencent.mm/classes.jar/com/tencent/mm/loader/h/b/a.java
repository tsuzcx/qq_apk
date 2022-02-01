package com.tencent.mm.loader.h.b;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class a
  implements Closeable
{
  byte[] hgA = null;
  d hgB;
  c hgC;
  Object hgD;
  InputStream inputStream = null;
  
  private a(d paramd, c paramc, Object paramObject)
  {
    this.hgB = paramd;
    this.hgC = paramc;
    this.hgD = paramObject;
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
  
  public static a yb(String paramString)
  {
    return j(paramString, null);
  }
  
  public static a yc(String paramString)
  {
    return a(aj.getContext().getAssets().open(paramString), aj.getContext().getAssets().open(paramString));
  }
  
  public final InputStream arF()
  {
    if (this.inputStream != null) {
      return this.inputStream;
    }
    if (this.hgB != null)
    {
      this.inputStream = this.hgB.arF();
      return this.inputStream;
    }
    return null;
  }
  
  public final void close()
  {
    if (this.hgB != null)
    {
      this.hgB.close();
      this.hgB = null;
    }
    if (this.hgC != null) {
      this.hgC.close();
    }
  }
  
  public final Object getTag()
  {
    return this.hgD;
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
    
    public final InputStream arF()
    {
      try
      {
        this.aFw = i.openRead(this.mFilePath);
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
    byte[] hgE;
    
    public b(byte[] paramArrayOfByte)
    {
      this.hgE = paramArrayOfByte;
    }
    
    public final void close() {}
  }
  
  static final class c
    implements c
  {
    InputStream hgF;
    
    public c(InputStream paramInputStream)
    {
      this.hgF = paramInputStream;
    }
    
    public final void close()
    {
      a.u(this.hgF);
    }
  }
  
  static final class d
    implements d
  {
    InputStream aFw = null;
    byte[] hgE;
    
    public d(byte[] paramArrayOfByte)
    {
      this.hgE = paramArrayOfByte;
    }
    
    public final InputStream arF()
    {
      if (this.aFw == null) {
        this.aFw = new ByteArrayInputStream(this.hgE);
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
    InputStream hgF;
    
    public e(InputStream paramInputStream)
    {
      this.hgF = paramInputStream;
    }
    
    public final InputStream arF()
    {
      return this.hgF;
    }
    
    public final void close()
    {
      a.u(this.hgF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.h.b.a
 * JD-Core Version:    0.7.0.1
 */