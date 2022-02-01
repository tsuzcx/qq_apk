package com.tencent.mm.plugin.gamelife.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/report/GameLifeReportHelper;", "", "()V", "conversationSourceId", "", "getConversationSourceId", "()J", "setConversationSourceId", "(J)V", "plugin-gamelife_release"})
public final class a
{
  private static long uyt;
  public static final a uyu;
  
  static
  {
    AppMethodBeat.i(211394);
    uyu = new a();
    AppMethodBeat.o(211394);
  }
  
  public static long daL()
  {
    return uyt;
  }
  
  public static void xJ(long paramLong)
  {
    uyt = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.h.a
 * JD-Core Version:    0.7.0.1
 */