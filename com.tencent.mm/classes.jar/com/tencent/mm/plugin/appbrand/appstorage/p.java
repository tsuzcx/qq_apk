package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.a.b;
import com.tencent.mm.plugin.appbrand.aa.i;
import com.tencent.mm.vfs.e;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public abstract interface p
  extends b
{
  public abstract l EO(String paramString);
  
  public abstract e EP(String paramString);
  
  public abstract boolean EQ(String paramString);
  
  public abstract e ER(String paramString);
  
  public abstract boolean ES(String paramString);
  
  public abstract InputStream ET(String paramString);
  
  public abstract boolean Eb(String paramString);
  
  public abstract l Ec(String paramString);
  
  public abstract l Ee(String paramString);
  
  public abstract l a(i<String> parami);
  
  public abstract l a(e parame, String paramString, i<String> parami);
  
  public abstract l a(e parame, String paramString, boolean paramBoolean, i<String> parami);
  
  public abstract l a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami);
  
  public abstract l a(String paramString, i<List<j>> parami);
  
  public abstract l a(String paramString, FileStructStat paramFileStructStat);
  
  public abstract l a(String paramString, e parame);
  
  public abstract l a(String paramString, e parame, boolean paramBoolean);
  
  public abstract l a(String paramString, InputStream paramInputStream, boolean paramBoolean);
  
  public abstract List<? extends a> aRh();
  
  public abstract e ad(String paramString, boolean paramBoolean);
  
  public abstract l af(String paramString, boolean paramBoolean);
  
  public abstract l ag(String paramString, boolean paramBoolean);
  
  public abstract l b(String paramString, i<ByteBuffer> parami);
  
  public abstract void initialize();
  
  public abstract l j(String paramString, List<v> paramList);
  
  public abstract void release();
  
  public static abstract interface a
  {
    public abstract long aRb();
    
    public abstract String getFileName();
    
    public abstract long lastModified();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.p
 * JD-Core Version:    0.7.0.1
 */