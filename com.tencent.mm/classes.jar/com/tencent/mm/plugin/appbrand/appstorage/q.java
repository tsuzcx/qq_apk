package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.a.b;
import com.tencent.mm.plugin.appbrand.y.i;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public abstract interface q
  extends b
{
  public abstract boolean LZ(String paramString);
  
  public abstract com.tencent.mm.vfs.k MM(String paramString);
  
  public abstract boolean MN(String paramString);
  
  public abstract m MO(String paramString);
  
  public abstract com.tencent.mm.vfs.k MP(String paramString);
  
  public abstract boolean MQ(String paramString);
  
  public abstract com.tencent.mm.vfs.k MR(String paramString);
  
  public abstract boolean MS(String paramString);
  
  public abstract InputStream MT(String paramString);
  
  public abstract m Ma(String paramString);
  
  public abstract m Mc(String paramString);
  
  public abstract m a(i<String> parami);
  
  public abstract m a(com.tencent.mm.vfs.k paramk, String paramString, i<String> parami);
  
  public abstract m a(com.tencent.mm.vfs.k paramk, String paramString, boolean paramBoolean, i<String> parami);
  
  public abstract m a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami);
  
  public abstract m a(String paramString, FileStructStat paramFileStructStat);
  
  public abstract m a(String paramString, i<List<k>> parami);
  
  public abstract m a(String paramString, com.tencent.mm.vfs.k paramk);
  
  public abstract m a(String paramString, com.tencent.mm.vfs.k paramk, boolean paramBoolean);
  
  public abstract m a(String paramString, InputStream paramInputStream, boolean paramBoolean);
  
  public abstract com.tencent.mm.vfs.k ae(String paramString, boolean paramBoolean);
  
  public abstract m ag(String paramString, boolean paramBoolean);
  
  public abstract m ah(String paramString, boolean paramBoolean);
  
  public abstract m b(String paramString, i<ByteBuffer> parami);
  
  public abstract List<? extends a> bcd();
  
  public abstract m g(String paramString, List<x> paramList);
  
  public abstract void initialize();
  
  public abstract void release();
  
  public static abstract interface a
  {
    public abstract long bbW();
    
    public abstract String getFileName();
    
    public abstract long lastModified();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q
 * JD-Core Version:    0.7.0.1
 */