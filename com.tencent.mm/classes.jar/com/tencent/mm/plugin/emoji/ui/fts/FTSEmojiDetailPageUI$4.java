package com.tencent.mm.plugin.emoji.ui.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.vfs.e;

final class FTSEmojiDetailPageUI$4
  implements Runnable
{
  FTSEmojiDetailPageUI$4(FTSEmojiDetailPageUI paramFTSEmojiDetailPageUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(53538);
    Object localObject = i.getEmojiStorageMgr().yNn.asP(FTSEmojiDetailPageUI.a(this.loH).Al());
    if (localObject != null) {
      FTSEmojiDetailPageUI.a(this.loH, (EmojiInfo)localObject);
    }
    if (f.bkQ().m(FTSEmojiDetailPageUI.a(this.loH)))
    {
      localObject = FTSEmojiDetailPageUI.a(this.loH).dQB() + "_decode";
      if (e.cN((String)localObject)) {
        e.deleteFile((String)localObject);
      }
      e.avL((String)localObject);
      byte[] arrayOfByte = f.bkQ().l(FTSEmojiDetailPageUI.a(this.loH));
      e.b((String)localObject, arrayOfByte, arrayOfByte.length);
      n.k((String)localObject, this.loH);
      e.deleteFile((String)localObject);
      AppMethodBeat.o(53538);
      return;
    }
    if (e.cN(FTSEmojiDetailPageUI.f(this.loH))) {
      n.k(FTSEmojiDetailPageUI.f(this.loH), this.loH);
    }
    AppMethodBeat.o(53538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.4
 * JD-Core Version:    0.7.0.1
 */