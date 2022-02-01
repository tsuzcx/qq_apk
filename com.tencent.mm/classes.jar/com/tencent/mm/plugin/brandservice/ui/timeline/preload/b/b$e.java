package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"isIncludeFile", "", "Ljava/util/ArrayList;", "", "file", "Lcom/tencent/mm/vfs/VFSFile;", "invoke"})
final class b$e
  extends q
  implements m<ArrayList<String>, o, Boolean>
{
  public static final e pFx;
  
  static
  {
    AppMethodBeat.i(6834);
    pFx = new e();
    AppMethodBeat.o(6834);
  }
  
  b$e()
  {
    super(2);
  }
  
  public static boolean a(ArrayList<String> paramArrayList, o paramo)
  {
    AppMethodBeat.i(6833);
    p.h(paramArrayList, "$this$isIncludeFile");
    p.h(paramo, "file");
    StringBuilder localStringBuilder = new StringBuilder().append(paramo.getAbsolutePath());
    if (paramo.isDirectory()) {}
    for (paramo = "/";; paramo = "")
    {
      boolean bool = paramArrayList.contains(paramo);
      AppMethodBeat.o(6833);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.e
 * JD-Core Version:    0.7.0.1
 */