package com.tencent.mm.plugin.appbrand.appstorage;

import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public abstract interface k
  extends com.tencent.luggage.b.b
{
  public abstract h U(String paramString, boolean paramBoolean);
  
  public abstract h V(String paramString, boolean paramBoolean);
  
  public abstract h a(com.tencent.mm.plugin.appbrand.u.k<String> paramk);
  
  public abstract h a(File paramFile, String paramString, com.tencent.mm.plugin.appbrand.u.k<String> paramk);
  
  public abstract h a(File paramFile, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.u.k<String> paramk);
  
  public abstract h a(String paramString, FileStructStat paramFileStructStat);
  
  public abstract h a(String paramString, com.tencent.mm.plugin.appbrand.u.k<List<f>> paramk);
  
  public abstract h a(String paramString, File paramFile, boolean paramBoolean);
  
  public abstract h a(String paramString, InputStream paramInputStream, boolean paramBoolean);
  
  public abstract List<? extends a> acI();
  
  public abstract h b(String paramString, com.tencent.mm.plugin.appbrand.u.k<ByteBuffer> paramk);
  
  public abstract h b(String paramString, File paramFile);
  
  public abstract boolean bs(String paramString);
  
  public abstract h g(String paramString, List<n> paramList);
  
  public abstract void initialize();
  
  public abstract void release();
  
  public abstract h ru(String paramString);
  
  public abstract h rv(String paramString);
  
  public abstract h rw(String paramString);
  
  public abstract File rx(String paramString);
  
  public abstract com.tencent.mm.vfs.b ry(String paramString);
  
  public static abstract interface a
  {
    public abstract long acG();
    
    public abstract String getFileName();
    
    public abstract long lastModified();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.k
 * JD-Core Version:    0.7.0.1
 */