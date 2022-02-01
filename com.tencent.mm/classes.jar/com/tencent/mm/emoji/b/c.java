package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.x;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/report/EmojiDesignerReport;", "", "()V", "ActionBack", "", "ActionClick", "ActionDownload", "ActionExposure", "ActionViewPackDetail", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonBoardReddotNotificationStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonBoardReddotNotificationStruct;", "report", "", "action", "plugin-emojisdk_release"})
public final class c
{
  private static final x goD;
  public static final c goE;
  
  static
  {
    AppMethodBeat.i(183963);
    goE = new c();
    goD = new x();
    AppMethodBeat.o(183963);
  }
  
  public static x afZ()
  {
    return goD;
  }
  
  public static void ma(int paramInt)
  {
    AppMethodBeat.i(183962);
    if (goD.getIndex() > 0)
    {
      goD.ij(paramInt);
      goD.aLk();
    }
    AppMethodBeat.o(183962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c
 * JD-Core Version:    0.7.0.1
 */