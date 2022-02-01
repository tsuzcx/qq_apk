package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.s;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/report/EmojiDesignerReport;", "", "()V", "ActionBack", "", "ActionClick", "ActionDownload", "ActionExposure", "ActionViewPackDetail", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonBoardReddotNotificationStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonBoardReddotNotificationStruct;", "report", "", "action", "plugin-emojisdk_release"})
public final class c
{
  private static final s fRf;
  public static final c fRg;
  
  static
  {
    AppMethodBeat.i(183963);
    fRg = new c();
    fRf = new s();
    AppMethodBeat.o(183963);
  }
  
  public static s acn()
  {
    return fRf;
  }
  
  public static void lI(int paramInt)
  {
    AppMethodBeat.i(183962);
    if (fRf.getIndex() > 0)
    {
      fRf.io(paramInt);
      fRf.aBj();
    }
    AppMethodBeat.o(183962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c
 * JD-Core Version:    0.7.0.1
 */