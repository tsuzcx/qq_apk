package com.tencent.mm.plugin.gamelife.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/report/GameLifeReportHelper;", "", "()V", "conversationSourceId", "", "getConversationSourceId", "()J", "setConversationSourceId", "(J)V", "plugin-gamelife_release"})
public final class a
{
  private static long ycr;
  public static final a ycs;
  
  static
  {
    AppMethodBeat.i(241413);
    ycs = new a();
    AppMethodBeat.o(241413);
  }
  
  public static void GN(long paramLong)
  {
    ycr = paramLong;
  }
  
  public static long dXm()
  {
    return ycr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.i.a
 * JD-Core Version:    0.7.0.1
 */