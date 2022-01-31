package com.tencent.mm.plugin.appbrand.appstorage;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

final class q$2$1
  implements FileFilter
{
  q$2$1(q.2 param2, String paramString, List paramList) {}
  
  public final boolean accept(File paramFile)
  {
    if (!paramFile.getName().endsWith(".nomedia")) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (!paramFile.isDirectory()))
      {
        n localn = new n(i.rz(paramFile.getAbsolutePath().replaceFirst(this.fHG, "")));
        FileStat.stat(paramFile.getAbsolutePath(), localn);
        this.fHH.add(localn);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q.2.1
 * JD-Core Version:    0.7.0.1
 */