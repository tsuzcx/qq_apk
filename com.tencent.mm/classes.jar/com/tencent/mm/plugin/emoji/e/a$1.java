package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureUploadManager.UploadTask;
import java.util.ArrayDeque;

 enum a$1
{
  private boolean fQi;
  private ArrayDeque<EmojiCaptureUploadManager.UploadTask> lfn;
  
  a$1()
  {
    AppMethodBeat.i(52820);
    this.fQi = false;
    this.lfn = new ArrayDeque();
    AppMethodBeat.o(52820);
  }
  
  public final void bkM()
  {
    AppMethodBeat.i(52821);
    this.fQi = true;
    if (!this.lfn.isEmpty())
    {
      EmojiCaptureUploadManager.UploadTask localUploadTask = (EmojiCaptureUploadManager.UploadTask)this.lfn.poll();
      if (localUploadTask != null) {
        ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(localUploadTask);
      }
      AppMethodBeat.o(52821);
      return;
    }
    this.fQi = false;
    AppMethodBeat.o(52821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.a.1
 * JD-Core Version:    0.7.0.1
 */