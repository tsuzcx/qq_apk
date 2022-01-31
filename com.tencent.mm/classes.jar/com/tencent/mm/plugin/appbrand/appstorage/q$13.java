package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.j.c;
import java.io.File;

final class q$13
  implements q.a
{
  q$13(q paramq) {}
  
  public final h a(File paramFile, Object... paramVarArgs)
  {
    if (!paramFile.exists()) {
      return h.fHa;
    }
    int i = FileStat.stat(paramFile.getPath(), (FileStructStat)paramVarArgs[0]);
    if (i != 0) {
      c.e("MicroMsg.LuggageNonFlattenedFileSystem", "stat err %d, %s", new Object[] { Integer.valueOf(i), paramFile.getPath() });
    }
    if (i == 0) {
      return h.fGU;
    }
    return h.fGV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q.13
 * JD-Core Version:    0.7.0.1
 */