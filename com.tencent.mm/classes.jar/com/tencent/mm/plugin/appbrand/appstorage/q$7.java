package com.tencent.mm.plugin.appbrand.appstorage;

import java.io.File;

final class q$7
  implements q.a
{
  q$7(q paramq) {}
  
  public final h a(File paramFile, Object... paramVarArgs)
  {
    if (paramFile.exists()) {
      return h.fGZ;
    }
    if (((Boolean)paramVarArgs[0]).booleanValue())
    {
      if (!paramFile.mkdirs()) {}
    }
    else {
      while (paramFile.mkdir()) {
        return h.fGU;
      }
    }
    return h.fGV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q.7
 * JD-Core Version:    0.7.0.1
 */