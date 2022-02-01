package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/action/ActionConfig;", "", "()V", "Companion", "plugin-finder_release"})
public final class a
{
  private static int MAX_RETRY_COUNT;
  private static long nLu;
  private static int qRD;
  public static final a qRF;
  
  static
  {
    AppMethodBeat.i(167803);
    qRF = new a((byte)0);
    qRD = 1200000;
    MAX_RETRY_COUNT = 2;
    nLu = 120000L;
    AppMethodBeat.o(167803);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/action/ActionConfig$Companion;", "", "()V", "DELAY_TIME", "", "getDELAY_TIME", "()J", "setDELAY_TIME", "(J)V", "MAX_RETRY_COUNT", "", "getMAX_RETRY_COUNT", "()I", "setMAX_RETRY_COUNT", "(I)V", "MAX_RETRY_TIME", "getMAX_RETRY_TIME", "setMAX_RETRY_TIME", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.a
 * JD-Core Version:    0.7.0.1
 */