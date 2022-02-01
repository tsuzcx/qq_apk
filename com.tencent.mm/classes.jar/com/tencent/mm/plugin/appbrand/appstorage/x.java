package com.tencent.mm.plugin.appbrand.appstorage;

public final class x
  extends FileStructStat
  implements q.a
{
  public final String kTh;
  
  public x(String paramString)
  {
    this.kTh = paramString;
  }
  
  public final long bxm()
  {
    return this.st_size;
  }
  
  public final String getFileName()
  {
    return this.kTh;
  }
  
  public final long lastModified()
  {
    return this.st_mtime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.x
 * JD-Core Version:    0.7.0.1
 */