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
  byte[] glQ = null;
  d glR;
  c glS;
  Object glT;
  InputStream inputStream = null;
  
  private a(d paramd, c paramc, Object paramObject)
  {
    this.glR = paramd;
    this.glS = paramc;
    this.glT = paramObject;
  }
  
  public static a S(byte[] paramArrayOfByte)
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
  
  public static a l(String paramString, Object paramObject)
  {
    return a(new a(paramString), paramObject);
  }
  
  public static a ri(String paramString)
  {
    return l(paramString, null);
  }
  
  public static a rj(String paramString)
  {
    return a(aj.getContext().getAssets().open(paramString), aj.getContext().getAssets().open(paramString));
  }
  
  public final InputStream ahS()
  {
    if (this.inputStream != null) {
      return this.inputStream;
    }
    if (this.glR != null)
    {
      this.inputStream = this.glR.ahS();
      return this.inputStream;
    }
    return null;
  }
  
  public final void close()
  {
    if (this.glR != null)
    {
      this.glR.close();
      this.glR = null;
    }
    if (this.glS != null) {
      this.glS.close();
    }
  }
  
  public final Object getTag()
  {
    return this.glT;
  }
  
  static final class a
    implements c, d
  {
    InputStream aCO = null;
    String mFilePath;
    
    public a(String paramString)
    {
      this.mFilePath = paramString;
    }
    
    public final InputStream ahS()
    {
      try
      {
        this.aCO = i.openRead(this.mFilePath);
        InputStream localInputStream = this.aCO;
        return localInputStream;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      return null;
    }
    
    public final void close()
    {
      a.r(this.aCO);
    }
  }
  
  static final class b
    implements c
  {
    byte[] glU;
    
    public b(byte[] paramArrayOfByte)
    {
      this.glU = paramArrayOfByte;
    }
    
    public final void close() {}
  }
  
  static final class c
    implements c
  {
    InputStream glV;
    
    public c(InputStream paramInputStream)
    {
      this.glV = paramInputStream;
    }
    
    public final void close()
    {
      a.r(this.glV);
    }
  }
  
  static final class d
    implements d
  {
    InputStream aCO = null;
    byte[] glU;
    
    public d(byte[] paramArrayOfByte)
    {
      this.glU = paramArrayOfByte;
    }
    
    public final InputStream ahS()
    {
      if (this.aCO == null) {
        this.aCO = new ByteArrayInputStream(this.glU);
      }
      return this.aCO;
    }
    
    public final void close()
    {
      a.r(this.aCO);
    }
  }
  
  static final class e
    implements d
  {
    InputStream glV;
    
    public e(InputStream paramInputStream)
    {
      this.glV = paramInputStream;
    }
    
    public final InputStream ahS()
    {
      return this.glV;
    }
    
    public final void close()
    {
      a.r(this.glV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.h.b.a
 * JD-Core Version:    0.7.0.1
 */