package com.tencent.mm.loader.h.b;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class a
  implements Closeable
{
  byte[] gMD = null;
  d gME;
  c gMF;
  Object gMG;
  InputStream inputStream = null;
  
  private a(d paramd, c paramc, Object paramObject)
  {
    this.gME = paramd;
    this.gMF = paramc;
    this.gMG = paramObject;
  }
  
  public static a R(byte[] paramArrayOfByte)
  {
    return new a(new d(paramArrayOfByte), new a.b(paramArrayOfByte), null);
  }
  
  private static <T extends d,  extends c> a a(T paramT, Object paramObject)
  {
    return new a(paramT, (c)paramT, paramObject);
  }
  
  public static a a(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    return new a(new e(paramInputStream1), new c(paramInputStream2), null);
  }
  
  public static a k(String paramString, Object paramObject)
  {
    return a(new a(paramString), paramObject);
  }
  
  public static a vk(String paramString)
  {
    return k(paramString, null);
  }
  
  public static a vl(String paramString)
  {
    return a(ai.getContext().getAssets().open(paramString), ai.getContext().getAssets().open(paramString));
  }
  
  public final InputStream aoS()
  {
    if (this.inputStream != null) {
      return this.inputStream;
    }
    if (this.gME != null)
    {
      this.inputStream = this.gME.aoS();
      return this.inputStream;
    }
    return null;
  }
  
  public final void close()
  {
    if (this.gME != null)
    {
      this.gME.close();
      this.gME = null;
    }
    if (this.gMF != null) {
      this.gMF.close();
    }
  }
  
  public final Object getTag()
  {
    return this.gMG;
  }
  
  static final class a
    implements c, d
  {
    InputStream aDF = null;
    String mFilePath;
    
    public a(String paramString)
    {
      this.mFilePath = paramString;
    }
    
    public final InputStream aoS()
    {
      try
      {
        this.aDF = i.openRead(this.mFilePath);
        InputStream localInputStream = this.aDF;
        return localInputStream;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      return null;
    }
    
    public final void close()
    {
      a.q(this.aDF);
    }
  }
  
  static final class c
    implements c
  {
    InputStream gMI;
    
    public c(InputStream paramInputStream)
    {
      this.gMI = paramInputStream;
    }
    
    public final void close()
    {
      a.q(this.gMI);
    }
  }
  
  static final class d
    implements d
  {
    InputStream aDF = null;
    byte[] gMH;
    
    public d(byte[] paramArrayOfByte)
    {
      this.gMH = paramArrayOfByte;
    }
    
    public final InputStream aoS()
    {
      if (this.aDF == null) {
        this.aDF = new ByteArrayInputStream(this.gMH);
      }
      return this.aDF;
    }
    
    public final void close()
    {
      a.q(this.aDF);
    }
  }
  
  static final class e
    implements d
  {
    InputStream gMI;
    
    public e(InputStream paramInputStream)
    {
      this.gMI = paramInputStream;
    }
    
    public final InputStream aoS()
    {
      return this.gMI;
    }
    
    public final void close()
    {
      a.q(this.gMI);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.h.b.a
 * JD-Core Version:    0.7.0.1
 */