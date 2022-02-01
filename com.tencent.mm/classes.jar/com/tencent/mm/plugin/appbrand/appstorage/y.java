package com.tencent.mm.plugin.appbrand.appstorage;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/IWxaStorageSpaceStatistics;", "", "getDirTotalSize", "", "dirPath", "", "filePath", "handleDirSizeChangeEvent", "", "sizeDiff", "op", "handleFileSizeChangeEvent", "monitorDirPath", "register", "", "filePattern", "Lcom/tencent/mm/plugin/appbrand/appstorage/FilePattern;", "currentSize", "reset", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface y
{
  public abstract void a(String paramString1, String paramString2, long paramLong, String paramString3);
  
  public abstract void c(String paramString1, long paramLong, String paramString2);
  
  public abstract void d(String paramString1, long paramLong, String paramString2);
  
  public abstract long df(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.y
 * JD-Core Version:    0.7.0.1
 */