package com.tencent.mm.plugin.appbrand.appstorage;

import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public abstract interface o
  extends com.tencent.luggage.a.b
{
  public abstract j Y(String paramString, boolean paramBoolean);
  
  public abstract j Z(String paramString, boolean paramBoolean);
  
  public abstract j a(com.tencent.mm.plugin.appbrand.s.j<String> paramj);
  
  public abstract j a(File paramFile, String paramString, com.tencent.mm.plugin.appbrand.s.j<String> paramj);
  
  public abstract j a(File paramFile, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.s.j<String> paramj);
  
  public abstract j a(String paramString, FileStructStat paramFileStructStat);
  
  public abstract j a(String paramString, com.tencent.mm.plugin.appbrand.s.j<List<h>> paramj);
  
  public abstract j a(String paramString, File paramFile, boolean paramBoolean);
  
  public abstract j a(String paramString, InputStream paramInputStream, boolean paramBoolean);
  
  public abstract File aa(String paramString, boolean paramBoolean);
  
  public abstract List<? extends a> awJ();
  
  public abstract j b(String paramString, com.tencent.mm.plugin.appbrand.s.j<ByteBuffer> paramj);
  
  public abstract j b(String paramString, File paramFile);
  
  public abstract boolean bL(String paramString);
  
  public abstract j h(String paramString, List<u> paramList);
  
  public abstract void initialize();
  
  public abstract void release();
  
  public abstract j zd(String paramString);
  
  public abstract j ze(String paramString);
  
  public abstract j zf(String paramString);
  
  public abstract File zg(String paramString);
  
  public abstract com.tencent.mm.vfs.b zh(String paramString);
  
  public abstract boolean zi(String paramString);
  
  public abstract InputStream zj(String paramString);
  
  public static abstract interface a
  {
    public abstract long awE();
    
    public abstract String getFileName();
    
    public abstract long lastModified();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.o
 * JD-Core Version:    0.7.0.1
 */