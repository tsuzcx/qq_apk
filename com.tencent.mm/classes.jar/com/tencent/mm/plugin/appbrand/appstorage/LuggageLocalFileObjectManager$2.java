package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;
import java.io.FileFilter;

final class LuggageLocalFileObjectManager$2
  implements FileFilter
{
  LuggageLocalFileObjectManager$2(LuggageLocalFileObjectManager paramLuggageLocalFileObjectManager) {}
  
  public final boolean accept(File paramFile)
  {
    return (paramFile.exists()) && (!paramFile.isDirectory()) && (!bk.bl(paramFile.getName())) && (paramFile.getName().startsWith("tmp_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.2
 * JD-Core Version:    0.7.0.1
 */