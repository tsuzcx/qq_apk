package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/ActionConfig;", "", "()V", "Companion", "plugin-finder-base_release"})
public final class a
{
  private static int ABt;
  public static final a ABu;
  private static int MAX_RETRY_COUNT;
  private static long tMe;
  
  static
  {
    AppMethodBeat.i(167803);
    ABu = new a((byte)0);
    ABt = 1200000;
    MAX_RETRY_COUNT = 2;
    tMe = 120000L;
    AppMethodBeat.o(167803);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/ActionConfig$Companion;", "", "()V", "DELAY_TIME", "", "getDELAY_TIME", "()J", "setDELAY_TIME", "(J)V", "MAX_RETRY_COUNT", "", "getMAX_RETRY_COUNT", "()I", "setMAX_RETRY_COUNT", "(I)V", "MAX_RETRY_TIME", "getMAX_RETRY_TIME", "setMAX_RETRY_TIME", "plugin-finder-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.a
 * JD-Core Version:    0.7.0.1
 */