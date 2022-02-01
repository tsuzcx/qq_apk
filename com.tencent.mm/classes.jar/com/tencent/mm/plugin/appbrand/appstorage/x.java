package com.tencent.mm.plugin.appbrand.appstorage;

public final class x
  extends FileStructStat
  implements q.a
{
  public final String jQx;
  
  public x(String paramString)
  {
    this.jQx = paramString;
  }
  
  public final long bbW()
  {
    return this.st_size;
  }
  
  public final String getFileName()
  {
    return this.jQx;
  }
  
  public final long lastModified()
  {
    return this.st_mtime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.x
 * JD-Core Version:    0.7.0.1
 */