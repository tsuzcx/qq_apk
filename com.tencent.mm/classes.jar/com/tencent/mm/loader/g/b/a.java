package com.tencent.mm.loader.g.b;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class a
  implements Closeable
{
  InputStream inputStream = null;
  byte[] nsv = null;
  d nsw;
  c nsx;
  public Object nsy;
  
  private a(d paramd, c paramc, Object paramObject)
  {
    this.nsw = paramd;
    this.nsx = paramc;
    this.nsy = paramObject;
  }
  
  public static a GJ(String paramString)
  {
    return o(paramString, null);
  }
  
  public static a GK(String paramString)
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
  
  public static a o(String paramString, Object paramObject)
  {
    return a(new a(paramString), paramObject);
  }
  
  public final InputStream bmk()
  {
    if (this.inputStream != null) {
      return this.inputStream;
    }
    if (this.nsw != null)
    {
      this.inputStream = this.nsw.bmk();
      return this.inputStream;
    }
    return null;
  }
  
  public final void close()
  {
    if (this.nsw != null)
    {
      this.nsw.close();
      this.nsw = null;
    }
    if (this.nsx != null) {
      this.nsx.close();
    }
  }
  
  static final class a
    implements c, d
  {
    InputStream elH = null;
    String mFilePath;
    
    public a(String paramString)
    {
      this.mFilePath = paramString;
    }
    
    public final InputStream bmk()
    {
      try
      {
        this.elH = y.Lh(this.mFilePath);
        InputStream localInputStream = this.elH;
        return localInputStream;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      return null;
    }
    
    public final void close()
    {
      a.D(this.elH);
    }
  }
  
  static final class b
    implements c
  {
    byte[] nsz;
    
    public b(byte[] paramArrayOfByte)
    {
      this.nsz = paramArrayOfByte;
    }
    
    public final void close() {}
  }
  
  static final class c
    implements c
  {
    InputStream nsA;
    
    public c(InputStream paramInputStream)
    {
      this.nsA = paramInputStream;
    }
    
    public final void close()
    {
      a.D(this.nsA);
    }
  }
  
  static final class d
    implements d
  {
    InputStream elH = null;
    byte[] nsz;
    
    public d(byte[] paramArrayOfByte)
    {
      this.nsz = paramArrayOfByte;
    }
    
    public final InputStream bmk()
    {
      if (this.elH == null) {
        this.elH = new ByteArrayInputStream(this.nsz);
      }
      return this.elH;
    }
    
    public final void close()
    {
      a.D(this.elH);
    }
  }
  
  static final class e
    implements d
  {
    InputStream nsA;
    
    public e(InputStream paramInputStream)
    {
      this.nsA = paramInputStream;
    }
    
    public final InputStream bmk()
    {
      return this.nsA;
    }
    
    public final void close()
    {
      a.D(this.nsA);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.g.b.a
 * JD-Core Version:    0.7.0.1
 */