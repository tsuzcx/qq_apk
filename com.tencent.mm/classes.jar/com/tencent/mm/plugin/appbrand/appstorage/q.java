package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.a.b;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.vfs.o;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public abstract interface q
  extends b
{
  public abstract o VV(String paramString);
  
  public abstract boolean VW(String paramString);
  
  public abstract m VX(String paramString);
  
  public abstract o VY(String paramString);
  
  public abstract boolean VZ(String paramString);
  
  public abstract boolean Vi(String paramString);
  
  public abstract m Vj(String paramString);
  
  public abstract m Vl(String paramString);
  
  public abstract o Wa(String paramString);
  
  public abstract boolean Wb(String paramString);
  
  public abstract InputStream Wc(String paramString);
  
  public abstract m a(i<String> parami);
  
  public abstract m a(o paramo, String paramString, i<String> parami);
  
  public abstract m a(o paramo, String paramString, boolean paramBoolean, i<String> parami);
  
  public abstract m a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami);
  
  public abstract m a(String paramString, i<List<k>> parami);
  
  public abstract m a(String paramString, FileStructStat paramFileStructStat);
  
  public abstract m a(String paramString, o paramo);
  
  public abstract m a(String paramString, o paramo, boolean paramBoolean);
  
  public abstract m a(String paramString, InputStream paramInputStream, boolean paramBoolean);
  
  public abstract o ag(String paramString, boolean paramBoolean);
  
  public abstract m ai(String paramString, boolean paramBoolean);
  
  public abstract m aj(String paramString, boolean paramBoolean);
  
  public abstract m b(String paramString, i<ByteBuffer> parami);
  
  public abstract List<? extends a> bxs();
  
  public abstract m h(String paramString, List<x> paramList);
  
  public abstract void initialize();
  
  public abstract void release();
  
  public static abstract interface a
  {
    public abstract long bxm();
    
    public abstract String getFileName();
    
    public abstract long lastModified();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q
 * JD-Core Version:    0.7.0.1
 */