package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/report/EmojiTabClickReport;", "", "()V", "clickIndex", "", "getClickIndex", "()I", "setClickIndex", "(I)V", "scene", "getScene", "setScene", "timePanelShow", "", "panelShow", "", "openTime", "reportClick", "tabIndex", "productId", "", "plugin-emojisdk_release"})
public final class g
{
  private static long jNp;
  private static int jNq;
  public static final g jNx;
  private static int scene;
  
  static
  {
    AppMethodBeat.i(105727);
    jNx = new g();
    AppMethodBeat.o(105727);
  }
  
  public static void C(int paramInt, String paramString)
  {
    AppMethodBeat.i(105726);
    long l = System.currentTimeMillis();
    h.IzE.a(18231, new Object[] { Long.valueOf(jNp), Integer.valueOf(scene), Integer.valueOf(jNq), Long.valueOf(l), Integer.valueOf(paramInt), paramString });
    jNq += 1;
    AppMethodBeat.o(105726);
  }
  
  public static void Fn(long paramLong)
  {
    jNp = paramLong;
    jNq = 1;
  }
  
  public static void setScene(int paramInt)
  {
    scene = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.c.g
 * JD-Core Version:    0.7.0.1
 */