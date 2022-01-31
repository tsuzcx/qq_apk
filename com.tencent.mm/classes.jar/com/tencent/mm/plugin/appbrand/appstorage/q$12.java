package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.j.c;
import java.io.File;

final class q$12
  extends q.b
{
  q$12(q paramq)
  {
    super(paramq, (byte)0);
  }
  
  public final h x(File paramFile)
  {
    if (paramFile.isDirectory()) {
      return h.fHd;
    }
    if (!paramFile.exists()) {
      return h.fHa;
    }
    int i = FileUnlink.unlink(paramFile.getPath());
    if (i != 0) {
      c.e("MicroMsg.LuggageNonFlattenedFileSystem", "unlink err %d, %s", new Object[] { Integer.valueOf(i), paramFile.getPath() });
    }
    if (i == 0) {
      return h.fGU;
    }
    return h.fGV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q.12
 * JD-Core Version:    0.7.0.1
 */