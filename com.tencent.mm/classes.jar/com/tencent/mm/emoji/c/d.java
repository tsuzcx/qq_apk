package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.aq;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/report/EmojiDesignerReport;", "", "()V", "ActionBack", "", "ActionClick", "ActionDownload", "ActionExposure", "ActionViewPackDetail", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonBoardReddotNotificationStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonBoardReddotNotificationStruct;", "report", "", "action", "plugin-emojisdk_release"})
public final class d
{
  private static final aq hci;
  public static final d hcj;
  
  static
  {
    AppMethodBeat.i(183963);
    hcj = new d();
    hci = new aq();
    AppMethodBeat.o(183963);
  }
  
  public static aq awd()
  {
    return hci;
  }
  
  public static void pl(int paramInt)
  {
    AppMethodBeat.i(183962);
    if (hci.getIndex() > 0)
    {
      hci.jS(paramInt);
      hci.bfK();
    }
    AppMethodBeat.o(183962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.c.d
 * JD-Core Version:    0.7.0.1
 */