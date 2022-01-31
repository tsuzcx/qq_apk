package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.i;
import java.util.LinkedList;

final class EmojiStoreVpHeader$1
  implements Runnable
{
  EmojiStoreVpHeader$1(EmojiStoreVpHeader paramEmojiStoreVpHeader) {}
  
  public final void run()
  {
    AppMethodBeat.i(53508);
    if ((EmojiStoreVpHeader.a(this.lnS) != null) && (EmojiStoreVpHeader.b(this.lnS) != null))
    {
      i locali = EmojiStoreVpHeader.a(this.lnS);
      LinkedList localLinkedList = EmojiStoreVpHeader.b(this.lnS);
      locali.leC.clear();
      locali.leC.addAll(localLinkedList);
      locali.notifyDataSetChanged();
    }
    AppMethodBeat.o(53508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader.1
 * JD-Core Version:    0.7.0.1
 */