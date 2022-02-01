package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/ActionConfig;", "", "()V", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a GcD;
  private static int GcE;
  private static int MAX_RETRY_COUNT;
  private static long wPu;
  
  static
  {
    AppMethodBeat.i(167803);
    GcD = new a.a((byte)0);
    GcE = 1200000;
    MAX_RETRY_COUNT = 2;
    wPu = 120000L;
    AppMethodBeat.o(167803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.a
 * JD-Core Version:    0.7.0.1
 */