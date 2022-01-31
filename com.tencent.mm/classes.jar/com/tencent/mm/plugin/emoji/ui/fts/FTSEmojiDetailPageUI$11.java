package com.tencent.mm.plugin.emoji.ui.fts;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;

final class FTSEmojiDetailPageUI$11
  implements i
{
  FTSEmojiDetailPageUI$11(FTSEmojiDetailPageUI paramFTSEmojiDetailPageUI) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(53549);
    ab.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramString });
    if ((paramBitmap != null) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null) && ((paramVarArgs[0] instanceof String)) && (paramString.equals(FTSEmojiDetailPageUI.a(this.loH).field_encrypturl)))
    {
      paramString = new com.tencent.mm.vfs.b(paramVarArgs[0].toString());
      if (paramString.exists())
      {
        FTSEmojiDetailPageUI.a(this.loH).field_md5 = e.avP(j.p(paramString.mUri));
        FTSEmojiDetailPageUI.a(this.loH, EmojiLogic.M(com.tencent.mm.plugin.emoji.h.b.YP(), "", FTSEmojiDetailPageUI.a(this.loH).field_md5));
        e.C(j.p(paramString.dQJ()), FTSEmojiDetailPageUI.f(this.loH));
        al.d(new FTSEmojiDetailPageUI.11.1(this));
      }
    }
    AppMethodBeat.o(53549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.11
 * JD-Core Version:    0.7.0.1
 */