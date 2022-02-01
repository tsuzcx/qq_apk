package com.tencent.mm.plugin.emoji.ui.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import java.util.List;

final class FTSEmojiDetailPageUI$12
  implements o.f
{
  FTSEmojiDetailPageUI$12(FTSEmojiDetailPageUI paramFTSEmojiDetailPageUI, List paramList1, List paramList2) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(109113);
    paramm.setHeaderTitle("");
    int i = 0;
    while (i < this.rjE.size())
    {
      paramm.d(((Integer)this.rjE.get(i)).intValue(), (CharSequence)this.rjF.get(i));
      i += 1;
    }
    AppMethodBeat.o(109113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.12
 * JD-Core Version:    0.7.0.1
 */