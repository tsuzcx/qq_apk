package com.tencent.mm.plugin.emoji.ui.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import java.util.List;

final class FTSEmojiDetailPageUI$12
  implements u.g
{
  FTSEmojiDetailPageUI$12(FTSEmojiDetailPageUI paramFTSEmojiDetailPageUI, List paramList1, List paramList2) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(109113);
    params.setHeaderTitle("");
    int i = 0;
    while (i < this.xVu.size())
    {
      params.c(((Integer)this.xVu.get(i)).intValue(), (CharSequence)this.xVv.get(i));
      i += 1;
    }
    AppMethodBeat.o(109113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.12
 * JD-Core Version:    0.7.0.1
 */