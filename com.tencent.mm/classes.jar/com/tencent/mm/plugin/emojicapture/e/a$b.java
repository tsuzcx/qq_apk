package com.tencent.mm.plugin.emojicapture.e;

import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b;
import com.tencent.mm.sdk.platformtools.y;

final class a$b
  implements Runnable
{
  a$b(a parama) {}
  
  public final void run()
  {
    y.i(this.jme.TAG, "voice finish called force");
    if (!this.jme.jlW) {
      this.jme.jmd.Bn(this.jme.jlX);
    }
    this.jme.jlW = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.a.b
 * JD-Core Version:    0.7.0.1
 */