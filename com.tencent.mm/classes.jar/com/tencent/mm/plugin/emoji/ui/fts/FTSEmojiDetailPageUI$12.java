package com.tencent.mm.plugin.emoji.ui.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

final class FTSEmojiDetailPageUI$12
  implements n.c
{
  FTSEmojiDetailPageUI$12(FTSEmojiDetailPageUI paramFTSEmojiDetailPageUI, List paramList1, List paramList2) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(53550);
    paraml.setHeaderTitle("");
    int i = 0;
    while (i < this.loL.size())
    {
      paraml.e(((Integer)this.loL.get(i)).intValue(), (CharSequence)this.loM.get(i));
      i += 1;
    }
    AppMethodBeat.o(53550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.12
 * JD-Core Version:    0.7.0.1
 */