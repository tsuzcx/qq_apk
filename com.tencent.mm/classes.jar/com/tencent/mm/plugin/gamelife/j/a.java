package com.tencent.mm.plugin.gamelife.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/report/GameLifeReportHelper;", "", "()V", "conversationSourceId", "", "getConversationSourceId", "()J", "setConversationSourceId", "(J)V", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a JbN;
  private static long JbO;
  
  static
  {
    AppMethodBeat.i(267766);
    JbN = new a();
    AppMethodBeat.o(267766);
  }
  
  public static long fIw()
  {
    return JbO;
  }
  
  public static void rK(long paramLong)
  {
    JbO = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.j.a
 * JD-Core Version:    0.7.0.1
 */