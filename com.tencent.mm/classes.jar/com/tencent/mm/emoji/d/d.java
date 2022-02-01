package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.bt;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/report/EmojiDesignerReport;", "", "()V", "ActionBack", "", "ActionClick", "ActionDownload", "ActionExposure", "ActionViewPackDetail", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonBoardReddotNotificationStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonBoardReddotNotificationStruct;", "report", "", "action", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d mmr;
  private static final bt mms;
  
  static
  {
    AppMethodBeat.i(183963);
    mmr = new d();
    mms = new bt();
    AppMethodBeat.o(183963);
  }
  
  public static bt aWc()
  {
    return mms;
  }
  
  public static void rG(int paramInt)
  {
    AppMethodBeat.i(183962);
    if (mms.iuy > 0)
    {
      mms.ilm = paramInt;
      mms.bMH();
    }
    AppMethodBeat.o(183962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.d.d
 * JD-Core Version:    0.7.0.1
 */