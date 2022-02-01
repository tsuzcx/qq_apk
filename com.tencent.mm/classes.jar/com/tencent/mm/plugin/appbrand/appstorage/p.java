package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.a.b;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.vfs.e;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public abstract interface p
  extends b
{
  public abstract boolean Lw(String paramString);
  
  public abstract l Lx(String paramString);
  
  public abstract l Lz(String paramString);
  
  public abstract l Mi(String paramString);
  
  public abstract e Mj(String paramString);
  
  public abstract boolean Mk(String paramString);
  
  public abstract e Ml(String paramString);
  
  public abstract boolean Mm(String paramString);
  
  public abstract InputStream Mn(String paramString);
  
  public abstract l a(i<String> parami);
  
  public abstract l a(e parame, String paramString, i<String> parami);
  
  public abstract l a(e parame, String paramString, boolean paramBoolean, i<String> parami);
  
  public abstract l a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami);
  
  public abstract l a(String paramString, FileStructStat paramFileStructStat);
  
  public abstract l a(String paramString, i<List<j>> parami);
  
  public abstract l a(String paramString, e parame);
  
  public abstract l a(String paramString, e parame, boolean paramBoolean);
  
  public abstract l a(String paramString, InputStream paramInputStream, boolean paramBoolean);
  
  public abstract e ae(String paramString, boolean paramBoolean);
  
  public abstract l ag(String paramString, boolean paramBoolean);
  
  public abstract l ah(String paramString, boolean paramBoolean);
  
  public abstract l b(String paramString, i<ByteBuffer> parami);
  
  public abstract List<? extends a> bbA();
  
  public abstract l g(String paramString, List<v> paramList);
  
  public abstract void initialize();
  
  public abstract void release();
  
  public static abstract interface a
  {
    public abstract long bbu();
    
    public abstract String getFileName();
    
    public abstract long lastModified();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.p
 * JD-Core Version:    0.7.0.1
 */