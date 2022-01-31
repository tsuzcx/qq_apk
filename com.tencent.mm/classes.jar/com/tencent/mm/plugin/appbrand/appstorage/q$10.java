package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.u.k;
import java.io.File;

final class q$10
  implements q.a
{
  q$10(q paramq) {}
  
  public final h a(File paramFile, Object... paramVarArgs)
  {
    paramVarArgs = (k)paramVarArgs[0];
    if (!paramFile.exists()) {
      return h.fHa;
    }
    if (!paramFile.isFile()) {
      return h.fGY;
    }
    if (i.w(paramFile)) {
      return h.fHe;
    }
    if (paramVarArgs != null) {
      paramVarArgs.value = i.u(paramFile);
    }
    return h.fGU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q.10
 * JD-Core Version:    0.7.0.1
 */