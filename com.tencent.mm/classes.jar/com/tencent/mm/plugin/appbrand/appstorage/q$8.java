package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.j.c;
import java.io.File;

final class q$8
  implements q.a
{
  q$8(q paramq) {}
  
  public final h a(File paramFile, Object... paramVarArgs)
  {
    if ((paramFile.isFile()) || (!paramFile.exists())) {
      return h.fHa;
    }
    if (paramFile.equals(q.a(this.fHF))) {
      return h.fGY;
    }
    if (((Boolean)paramVarArgs[0]).booleanValue())
    {
      c.d("MicroMsg.LuggageNonFlattenedFileSystem", "rmdir recursive");
      try
      {
        i.v(paramFile);
        return h.fGU;
      }
      catch (Exception paramFile)
      {
        c.e("MicroMsg.LuggageNonFlattenedFileSystem", "rmdir recursive exp = %s", new Object[] { paramFile });
        return h.fGV;
      }
    }
    paramVarArgs = paramFile.listFiles();
    if (paramVarArgs.length > 0)
    {
      if (paramVarArgs.length != 1) {
        break label135;
      }
      if (paramVarArgs[0].getName().equals(".nomedia")) {
        paramVarArgs[0].delete();
      }
    }
    else
    {
      if (!paramFile.delete()) {
        break label139;
      }
      return h.fGU;
    }
    return h.fHb;
    label135:
    return h.fHb;
    label139:
    return h.fGV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q.8
 * JD-Core Version:    0.7.0.1
 */