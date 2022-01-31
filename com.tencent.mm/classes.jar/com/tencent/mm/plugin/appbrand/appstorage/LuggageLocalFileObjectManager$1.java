package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;
import java.io.FileFilter;

final class LuggageLocalFileObjectManager$1
  implements FileFilter
{
  LuggageLocalFileObjectManager$1(LuggageLocalFileObjectManager paramLuggageLocalFileObjectManager) {}
  
  public final boolean accept(File paramFile)
  {
    return (paramFile.exists()) && (!paramFile.isDirectory()) && (!bk.bl(paramFile.getName())) && (paramFile.getName().startsWith("store_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.1
 * JD-Core Version:    0.7.0.1
 */