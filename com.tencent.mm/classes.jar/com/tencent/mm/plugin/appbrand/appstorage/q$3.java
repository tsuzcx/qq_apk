package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.sdk.platformtools.j;
import java.io.File;

final class q$3
  implements q.a
{
  q$3(q paramq) {}
  
  public final h a(File paramFile, Object... paramVarArgs)
  {
    File localFile = (File)paramVarArgs[0];
    boolean bool = ((Boolean)paramVarArgs[1]).booleanValue();
    if (paramFile.isDirectory()) {
      return h.fGZ;
    }
    if (i.w(paramFile)) {
      return h.fHe;
    }
    if ((q.b(this.fHF) > 0L) && (q.c(this.fHF) + localFile.length() > q.b(this.fHF))) {
      return h.fHh;
    }
    if (bool)
    {
      if (g.bd(localFile.getAbsolutePath(), paramFile.getAbsolutePath())) {
        return h.fGU;
      }
      return h.fGV;
    }
    if (j.u(localFile.getAbsolutePath(), paramFile.getAbsolutePath(), false)) {
      return h.fGU;
    }
    return h.fGV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q.3
 * JD-Core Version:    0.7.0.1
 */