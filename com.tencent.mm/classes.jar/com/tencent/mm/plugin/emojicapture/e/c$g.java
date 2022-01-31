package com.tencent.mm.plugin.emojicapture.e;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.c.b.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class c$g
  implements Runnable
{
  c$g(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(2772);
    if ((c.e(this.lww)) && (c.c(this.lww)))
    {
      EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = c.a(this.lww).getVideoPlayView();
      if (localEmojiVideoPlayTextureView != null) {
        EmojiVideoPlayTextureView.a(localEmojiVideoPlayTextureView, c.b(this.lww));
      }
      c.a(this.lww).bnD();
      c.h(this.lww).boR();
      c.a(this.lww, c.g(this.lww), c.i(this.lww), true);
      c.a(this.lww, false);
      c.b(this.lww, false);
    }
    AppMethodBeat.o(2772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.c.g
 * JD-Core Version:    0.7.0.1
 */