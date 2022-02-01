package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.u;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/report/EmojiDesignerReport;", "", "()V", "ActionBack", "", "ActionClick", "ActionDownload", "ActionExposure", "ActionViewPackDetail", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonBoardReddotNotificationStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonBoardReddotNotificationStruct;", "report", "", "action", "plugin-emojisdk_release"})
public final class c
{
  private static final u fVa;
  public static final c fVb;
  
  static
  {
    AppMethodBeat.i(183963);
    fVb = new c();
    fVa = new u();
    AppMethodBeat.o(183963);
  }
  
  public static u adt()
  {
    return fVa;
  }
  
  public static void lA(int paramInt)
  {
    AppMethodBeat.i(183962);
    if (fVa.getIndex() > 0)
    {
      fVa.hY(paramInt);
      fVa.aHZ();
    }
    AppMethodBeat.o(183962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c
 * JD-Core Version:    0.7.0.1
 */