package com.tencent.mm.plugin.appbrand.appstorage;

public final class z
  extends FileStructStat
  implements r.a
{
  public final String nNF;
  
  public z(String paramString)
  {
    this.nNF = paramString;
  }
  
  public final long bIw()
  {
    return this.st_size;
  }
  
  public final String getFileName()
  {
    return this.nNF;
  }
  
  public final long lastModified()
  {
    return this.st_mtime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.z
 * JD-Core Version:    0.7.0.1
 */