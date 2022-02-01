package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/api/FinderContactLogic;", "", "()V", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d.a AwY;
  private static final b AwZ;
  private static final com.tencent.mm.b.h<String, d.a.a> Axa;
  private static boolean DEBUG;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(165145);
    AwY = new d.a((byte)0);
    TAG = "Finder.FinderContactLogic";
    DEBUG = false;
    AwZ = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).getFinderContactCache();
    Axa = new com.tencent.mm.b.h(20);
    AppMethodBeat.o(165145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.d
 * JD-Core Version:    0.7.0.1
 */