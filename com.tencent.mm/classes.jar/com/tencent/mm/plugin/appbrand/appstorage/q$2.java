package com.tencent.mm.plugin.appbrand.appstorage;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

final class q$2
  implements q.a
{
  q$2(q paramq) {}
  
  public final h a(File paramFile, Object... paramVarArgs)
  {
    if (!paramFile.isDirectory()) {
      return h.fHi;
    }
    paramVarArgs = (List)paramVarArgs[0];
    i.a(paramFile, new q.2.1(this, Pattern.quote(paramFile.getAbsolutePath()), paramVarArgs));
    return h.fGU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q.2
 * JD-Core Version:    0.7.0.1
 */