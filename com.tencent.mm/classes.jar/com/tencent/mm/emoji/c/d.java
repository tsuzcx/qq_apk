package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ay;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/report/EmojiDesignerReport;", "", "()V", "ActionBack", "", "ActionClick", "ActionDownload", "ActionExposure", "ActionViewPackDetail", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonBoardReddotNotificationStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonBoardReddotNotificationStruct;", "report", "", "action", "plugin-emojisdk_release"})
public final class d
{
  private static final ay jNs;
  public static final d jNt;
  
  static
  {
    AppMethodBeat.i(183963);
    jNt = new d();
    jNs = new ay();
    AppMethodBeat.o(183963);
  }
  
  public static ay aDc()
  {
    return jNs;
  }
  
  public static void rE(int paramInt)
  {
    AppMethodBeat.i(183962);
    if (jNs.getIndex() > 0)
    {
      jNs.lm(paramInt);
      jNs.bpa();
    }
    AppMethodBeat.o(183962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.d
 * JD-Core Version:    0.7.0.1
 */