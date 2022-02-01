package com.tencent.mm.plugin.appbrand.appstorage;

public final class v
  extends FileStructStat
  implements p.a
{
  public final String jNe;
  
  public v(String paramString)
  {
    this.jNe = paramString;
  }
  
  public final long bbu()
  {
    return this.st_size;
  }
  
  public final String getFileName()
  {
    return this.jNe;
  }
  
  public final long lastModified()
  {
    return this.st_mtime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.v
 * JD-Core Version:    0.7.0.1
 */