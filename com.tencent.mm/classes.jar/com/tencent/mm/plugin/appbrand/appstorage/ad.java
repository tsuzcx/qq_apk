package com.tencent.mm.plugin.appbrand.appstorage;

public final class ad
  extends FileStructStat
  implements w.a
{
  public final String qNx;
  
  public ad(String paramString)
  {
    this.qNx = paramString;
  }
  
  public final long cia()
  {
    return this.st_size;
  }
  
  public final String getFileName()
  {
    return this.qNx;
  }
  
  public final long lastModified()
  {
    return this.st_mtime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.ad
 * JD-Core Version:    0.7.0.1
 */