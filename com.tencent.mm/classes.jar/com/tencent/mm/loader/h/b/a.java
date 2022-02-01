package com.tencent.mm.loader.h.b;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class a
  implements Closeable
{
  byte[] icl = null;
  d icm;
  c icn;
  Object ico;
  InputStream inputStream = null;
  
  private a(d paramd, c paramc, Object paramObject)
  {
    this.icm = paramd;
    this.icn = paramc;
    this.ico = paramObject;
  }
  
  public static a Hk(String paramString)
  {
    return j(paramString, null);
  }
  
  public static a Hl(String paramString)
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
  
  public static a ae(byte[] paramArrayOfByte)
  {
    return new a(new d(paramArrayOfByte), new b(paramArrayOfByte), null);
  }
  
  public static a j(String paramString, Object paramObject)
  {
    return a(new a(paramString), paramObject);
  }
  
  public final InputStream aKu()
  {
    if (this.inputStream != null) {
      return this.inputStream;
    }
    if (this.icm != null)
    {
      this.inputStream = this.icm.aKu();
      return this.inputStream;
    }
    return null;
  }
  
  public final void close()
  {
    if (this.icm != null)
    {
      this.icm.close();
      this.icm = null;
    }
    if (this.icn != null) {
      this.icn.close();
    }
  }
  
  public final Object getTag()
  {
    return this.ico;
  }
  
  static final class a
    implements c, d
  {
    InputStream aFm = null;
    String mFilePath;
    
    public a(String paramString)
    {
      this.mFilePath = paramString;
    }
    
    public final InputStream aKu()
    {
      try
      {
        this.aFm = s.openRead(this.mFilePath);
        InputStream localInputStream = this.aFm;
        return localInputStream;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      return null;
    }
    
    public final void close()
    {
      a.t(this.aFm);
    }
  }
  
  static final class b
    implements c
  {
    byte[] icp;
    
    public b(byte[] paramArrayOfByte)
    {
      this.icp = paramArrayOfByte;
    }
    
    public final void close() {}
  }
  
  static final class c
    implements c
  {
    InputStream icq;
    
    public c(InputStream paramInputStream)
    {
      this.icq = paramInputStream;
    }
    
    public final void close()
    {
      a.t(this.icq);
    }
  }
  
  static final class d
    implements d
  {
    InputStream aFm = null;
    byte[] icp;
    
    public d(byte[] paramArrayOfByte)
    {
      this.icp = paramArrayOfByte;
    }
    
    public final InputStream aKu()
    {
      if (this.aFm == null) {
        this.aFm = new ByteArrayInputStream(this.icp);
      }
      return this.aFm;
    }
    
    public final void close()
    {
      a.t(this.aFm);
    }
  }
  
  static final class e
    implements d
  {
    InputStream icq;
    
    public e(InputStream paramInputStream)
    {
      this.icq = paramInputStream;
    }
    
    public final InputStream aKu()
    {
      return this.icq;
    }
    
    public final void close()
    {
      a.t(this.icq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.h.b.a
 * JD-Core Version:    0.7.0.1
 */