package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.b.e.a;

final class h$3
  implements Runnable
{
  h$3(h paramh, EmojiInfo paramEmojiInfo) {}
  
  public final void run()
  {
    AppMethodBeat.i(139675);
    Context localContext = ah.getContext();
    e.a locala = new e.a(localContext);
    locala.avu(localContext.getString(2131299105)).Rm(2131299288).Rn(localContext.getResources().getColor(2131690393));
    locala.c(new h.3.1(this)).show();
    AppMethodBeat.o(139675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.h.3
 * JD-Core Version:    0.7.0.1
 */