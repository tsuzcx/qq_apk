package com.tencent.mm.plugin.appbrand.appstorage;

public final class v
  extends FileStructStat
  implements p.a
{
  public final String iSZ;
  
  public v(String paramString)
  {
    this.iSZ = paramString;
  }
  
  public final long aRb()
  {
    return this.st_size;
  }
  
  public final String getFileName()
  {
    return this.iSZ;
  }
  
  public final long lastModified()
  {
    return this.st_mtime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.v
 * JD-Core Version:    0.7.0.1
 */