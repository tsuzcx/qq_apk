package com.tencent.mm.plugin.gamelife.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/report/GameLifeReportHelper;", "", "()V", "conversationSourceId", "", "getConversationSourceId", "()J", "setConversationSourceId", "(J)V", "plugin-gamelife_release"})
public final class a
{
  private static long uJW;
  public static final a uJX;
  
  static
  {
    AppMethodBeat.i(212172);
    uJX = new a();
    AppMethodBeat.o(212172);
  }
  
  public static long ddC()
  {
    return uJW;
  }
  
  public static void yd(long paramLong)
  {
    uJW = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.i.a
 * JD-Core Version:    0.7.0.1
 */