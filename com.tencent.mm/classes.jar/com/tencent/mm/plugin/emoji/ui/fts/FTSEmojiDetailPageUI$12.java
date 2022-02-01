package com.tencent.mm.plugin.emoji.ui.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

final class FTSEmojiDetailPageUI$12
  implements n.d
{
  FTSEmojiDetailPageUI$12(FTSEmojiDetailPageUI paramFTSEmojiDetailPageUI, List paramList1, List paramList2) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(109113);
    paraml.setHeaderTitle("");
    int i = 0;
    while (i < this.pSF.size())
    {
      paraml.d(((Integer)this.pSF.get(i)).intValue(), (CharSequence)this.pSG.get(i));
      i += 1;
    }
    AppMethodBeat.o(109113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.12
 * JD-Core Version:    0.7.0.1
 */