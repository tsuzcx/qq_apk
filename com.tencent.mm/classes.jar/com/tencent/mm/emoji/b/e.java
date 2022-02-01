package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/report/EmojiTabClickReport;", "", "()V", "clickIndex", "", "getClickIndex", "()I", "setClickIndex", "(I)V", "scene", "getScene", "setScene", "timePanelShow", "", "panelShow", "", "openTime", "reportClick", "tabIndex", "productId", "", "plugin-emojisdk_release"})
public final class e
{
  private static long gqV;
  private static int gqW;
  public static final e grc;
  private static int scene;
  
  static
  {
    AppMethodBeat.i(105727);
    grc = new e();
    AppMethodBeat.o(105727);
  }
  
  public static void rg(long paramLong)
  {
    gqV = paramLong;
    gqW = 1;
  }
  
  public static void setScene(int paramInt)
  {
    scene = paramInt;
  }
  
  public static void z(int paramInt, String paramString)
  {
    AppMethodBeat.i(105726);
    long l = System.currentTimeMillis();
    g.yxI.f(18231, new Object[] { Long.valueOf(gqV), Integer.valueOf(scene), Integer.valueOf(gqW), Long.valueOf(l), Integer.valueOf(paramInt), paramString });
    gqW += 1;
    AppMethodBeat.o(105726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.e
 * JD-Core Version:    0.7.0.1
 */