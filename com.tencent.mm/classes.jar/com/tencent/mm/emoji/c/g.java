package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/report/EmojiTabClickReport;", "", "()V", "clickIndex", "", "getClickIndex", "()I", "setClickIndex", "(I)V", "scene", "getScene", "setScene", "timePanelShow", "", "panelShow", "", "openTime", "reportClick", "tabIndex", "productId", "", "plugin-emojisdk_release"})
public final class g
{
  private static long hcf;
  private static int hcg;
  public static final g hcn;
  private static int scene;
  
  static
  {
    AppMethodBeat.i(105727);
    hcn = new g();
    AppMethodBeat.o(105727);
  }
  
  public static void B(int paramInt, String paramString)
  {
    AppMethodBeat.i(105726);
    long l = System.currentTimeMillis();
    h.CyF.a(18231, new Object[] { Long.valueOf(hcf), Integer.valueOf(scene), Integer.valueOf(hcg), Long.valueOf(l), Integer.valueOf(paramInt), paramString });
    hcg += 1;
    AppMethodBeat.o(105726);
  }
  
  public static void setScene(int paramInt)
  {
    scene = paramInt;
  }
  
  public static void zj(long paramLong)
  {
    hcf = paramLong;
    hcg = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.c.g
 * JD-Core Version:    0.7.0.1
 */