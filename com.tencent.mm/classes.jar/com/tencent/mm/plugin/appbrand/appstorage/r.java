package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.a.b;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.vfs.q;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public abstract interface r
  extends b
{
  public abstract m a(i<String> parami);
  
  public abstract m a(q paramq, String paramString, i<String> parami);
  
  public abstract m a(q paramq, String paramString, boolean paramBoolean, i<String> parami);
  
  public abstract m a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami);
  
  public abstract m a(String paramString, i<List<k>> parami);
  
  public abstract m a(String paramString1, i<Map<String, ByteBuffer>> parami, String paramString2, long paramLong1, long paramLong2);
  
  public abstract m a(String paramString, FileStructStat paramFileStructStat);
  
  public abstract m a(String paramString, q paramq);
  
  public abstract m a(String paramString, q paramq, boolean paramBoolean);
  
  public abstract m a(String paramString, InputStream paramInputStream, boolean paramBoolean);
  
  public abstract boolean acS(String paramString);
  
  public abstract m acT(String paramString);
  
  public abstract m acV(String paramString);
  
  public abstract q adI(String paramString);
  
  public abstract boolean adJ(String paramString);
  
  public abstract m adK(String paramString);
  
  public abstract q adL(String paramString);
  
  public abstract boolean adM(String paramString);
  
  public abstract q adN(String paramString);
  
  public abstract boolean adO(String paramString);
  
  public abstract boolean adP(String paramString);
  
  public abstract InputStream adQ(String paramString);
  
  public abstract q ah(String paramString, boolean paramBoolean);
  
  public abstract m aj(String paramString, boolean paramBoolean);
  
  public abstract m ak(String paramString, boolean paramBoolean);
  
  public abstract m b(String paramString, i<ByteBuffer> parami);
  
  public abstract List<? extends a> bIG();
  
  public abstract t bIH();
  
  public abstract m h(String paramString, List<z> paramList);
  
  public abstract void initialize();
  
  public abstract void release();
  
  public static abstract interface a
  {
    public abstract long bIw();
    
    public abstract String getFileName();
    
    public abstract long lastModified();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.r
 * JD-Core Version:    0.7.0.1
 */