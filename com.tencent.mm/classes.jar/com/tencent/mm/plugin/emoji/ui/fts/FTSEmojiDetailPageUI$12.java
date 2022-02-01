package com.tencent.mm.plugin.emoji.ui.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import java.util.List;

final class FTSEmojiDetailPageUI$12
  implements q.f
{
  FTSEmojiDetailPageUI$12(FTSEmojiDetailPageUI paramFTSEmojiDetailPageUI, List paramList1, List paramList2) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(109113);
    paramo.setHeaderTitle("");
    int i = 0;
    while (i < this.uMR.size())
    {
      paramo.d(((Integer)this.uMR.get(i)).intValue(), (CharSequence)this.uMS.get(i));
      i += 1;
    }
    AppMethodBeat.o(109113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.12
 * JD-Core Version:    0.7.0.1
 */