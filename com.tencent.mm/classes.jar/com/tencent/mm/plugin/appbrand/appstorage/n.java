package com.tencent.mm.plugin.appbrand.appstorage;

public final class n
  extends FileStructStat
  implements k.a
{
  public final String fHo;
  
  n(String paramString)
  {
    this.fHo = paramString;
  }
  
  public final long acG()
  {
    return this.st_size;
  }
  
  public final String getFileName()
  {
    return this.fHo;
  }
  
  public final long lastModified()
  {
    return this.st_mtime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.n
 * JD-Core Version:    0.7.0.1
 */