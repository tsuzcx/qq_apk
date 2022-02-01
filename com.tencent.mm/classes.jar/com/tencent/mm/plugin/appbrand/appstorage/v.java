package com.tencent.mm.plugin.appbrand.appstorage;

public final class v
  extends FileStructStat
  implements p.a
{
  public final String jtk;
  
  public v(String paramString)
  {
    this.jtk = paramString;
  }
  
  public final long aXW()
  {
    return this.st_size;
  }
  
  public final String getFileName()
  {
    return this.jtk;
  }
  
  public final long lastModified()
  {
    return this.st_mtime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.v
 * JD-Core Version:    0.7.0.1
 */