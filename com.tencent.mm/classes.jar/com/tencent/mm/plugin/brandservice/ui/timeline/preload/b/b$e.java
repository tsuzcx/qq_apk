package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"isIncludeFile", "", "Ljava/util/ArrayList;", "", "file", "Ljava/io/File;", "invoke"})
final class b$e
  extends k
  implements m<ArrayList<String>, File, Boolean>
{
  public static final e kcK;
  
  static
  {
    AppMethodBeat.i(14985);
    kcK = new e();
    AppMethodBeat.o(14985);
  }
  
  b$e()
  {
    super(2);
  }
  
  public static boolean a(ArrayList<String> paramArrayList, File paramFile)
  {
    AppMethodBeat.i(14984);
    j.q(paramArrayList, "receiver$0");
    j.q(paramFile, "file");
    StringBuilder localStringBuilder = new StringBuilder().append(paramFile.getAbsolutePath());
    if (paramFile.isDirectory()) {}
    for (paramFile = "/";; paramFile = "")
    {
      boolean bool = paramArrayList.contains(paramFile);
      AppMethodBeat.o(14984);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.e
 * JD-Core Version:    0.7.0.1
 */