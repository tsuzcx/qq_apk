package com.tencent.mm.plugin.appbrand.appstorage;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

final class q$9$1
  implements FileFilter
{
  q$9$1(q.9 param9, String paramString, List paramList) {}
  
  public final boolean accept(File paramFile)
  {
    if (!paramFile.getName().endsWith(".nomedia")) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        f localf = new f();
        localf.fileName = i.rz(paramFile.getAbsolutePath().replaceFirst(this.fHG, ""));
        this.fHJ.add(localf);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q.9.1
 * JD-Core Version:    0.7.0.1
 */