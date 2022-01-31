package com.tencent.mm.plugin.emojicapture.ui;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class EmojiCaptureUI$e
  implements Runnable
{
  EmojiCaptureUI$e(EmojiCaptureUI paramEmojiCaptureUI, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(2868);
    ab.i(EmojiCaptureUI.a(this.lxg), "connect cost " + bo.av(this.eXJ));
    EmojiCaptureUI.b(this.lxg);
    AppMethodBeat.o(2868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.e
 * JD-Core Version:    0.7.0.1
 */