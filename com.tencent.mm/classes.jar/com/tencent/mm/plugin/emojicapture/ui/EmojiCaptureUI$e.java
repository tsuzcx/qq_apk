package com.tencent.mm.plugin.emojicapture.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class EmojiCaptureUI$e
  implements Runnable
{
  EmojiCaptureUI$e(EmojiCaptureUI paramEmojiCaptureUI, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(455);
    Log.i(EmojiCaptureUI.a(this.rsa), "connect cost " + Util.ticksToNow(this.iiX));
    EmojiCaptureUI.b(this.rsa);
    AppMethodBeat.o(455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.e
 * JD-Core Version:    0.7.0.1
 */