package com.tencent.mm.plugin.appbrand.appstorage;

public final class u
  extends FileStructStat
  implements o.a
{
  public final String haf;
  
  public u(String paramString)
  {
    this.haf = paramString;
  }
  
  public final long awE()
  {
    return this.st_size;
  }
  
  public final String getFileName()
  {
    return this.haf;
  }
  
  public final long lastModified()
  {
    return this.st_mtime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.u
 * JD-Core Version:    0.7.0.1
 */