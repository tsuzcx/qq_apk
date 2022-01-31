package com.tencent.mm.plugin.appbrand.appstorage;

import java.io.File;
import java.io.FileFilter;

final class c$1$1
  implements FileFilter
{
  c$1$1(c.1 param1) {}
  
  public final boolean accept(File paramFile)
  {
    return (!paramFile.getName().endsWith(".data")) && (!paramFile.getName().startsWith("store_")) && (!paramFile.getName().endsWith(".nomedia"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.c.1.1
 * JD-Core Version:    0.7.0.1
 */