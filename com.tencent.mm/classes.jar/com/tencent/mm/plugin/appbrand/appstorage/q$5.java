package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.j.c;
import java.io.File;

final class q$5
  implements q.a
{
  q$5(q paramq) {}
  
  public final h a(File paramFile, Object... paramVarArgs)
  {
    if (i.w(paramFile)) {
      return h.fHe;
    }
    if ((paramFile.isFile()) && (paramFile.exists())) {
      return h.fGZ;
    }
    paramVarArgs = (File)paramVarArgs[0];
    int i = ZipJNI.unzip(paramVarArgs.getAbsolutePath(), paramFile.getAbsolutePath(), null);
    c.i("MicroMsg.LuggageNonFlattenedFileSystem", "unzip zipFile(%s) iRet(%d)", new Object[] { paramVarArgs.getAbsolutePath(), Integer.valueOf(i) });
    if (i == 0)
    {
      if ((q.b(this.fHF) > 0L) && (q.c(this.fHF) > q.b(this.fHF)))
      {
        i.v(paramFile);
        return h.fHh;
      }
      return h.fGU;
    }
    switch (i)
    {
    default: 
      return h.fGV;
    case 1: 
      return h.fGY;
    case -106: 
      return h.fHg;
    }
    return h.fHf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q.5
 * JD-Core Version:    0.7.0.1
 */