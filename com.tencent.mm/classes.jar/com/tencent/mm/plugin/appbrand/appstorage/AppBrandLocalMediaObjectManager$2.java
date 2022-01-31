package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;
import java.io.FileFilter;

final class AppBrandLocalMediaObjectManager$2
  implements FileFilter
{
  public final boolean accept(File paramFile)
  {
    return (paramFile.exists()) && (!paramFile.isDirectory()) && (!bk.bl(paramFile.getName())) && (paramFile.getName().startsWith("tmp_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.2
 * JD-Core Version:    0.7.0.1
 */