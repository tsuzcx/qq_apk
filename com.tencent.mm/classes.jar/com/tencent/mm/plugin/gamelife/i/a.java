package com.tencent.mm.plugin.gamelife.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/report/GameLifeReportHelper;", "", "()V", "conversationSourceId", "", "getConversationSourceId", "()J", "setConversationSourceId", "(J)V", "plugin-gamelife_release"})
public final class a
{
  private static long DhW;
  public static final a DhX;
  
  static
  {
    AppMethodBeat.i(202934);
    DhX = new a();
    AppMethodBeat.o(202934);
  }
  
  public static void NT(long paramLong)
  {
    DhW = paramLong;
  }
  
  public static long eAv()
  {
    return DhW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.i.a
 * JD-Core Version:    0.7.0.1
 */