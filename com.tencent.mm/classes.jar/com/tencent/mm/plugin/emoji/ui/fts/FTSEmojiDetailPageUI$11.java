package com.tencent.mm.plugin.emoji.ui.fts;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.as.a.c.i;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;

final class FTSEmojiDetailPageUI$11
  implements i
{
  FTSEmojiDetailPageUI$11(FTSEmojiDetailPageUI paramFTSEmojiDetailPageUI) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    y.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramString });
    if ((paramBitmap != null) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null) && ((paramVarArgs[0] instanceof String)) && (paramString.equals(FTSEmojiDetailPageUI.a(this.jfO).field_encrypturl)))
    {
      paramString = new com.tencent.mm.vfs.b(paramVarArgs[0].toString());
      if (paramString.exists())
      {
        FTSEmojiDetailPageUI.a(this.jfO).field_md5 = e.aeY(j.n(paramString.mUri));
        FTSEmojiDetailPageUI.a(this.jfO, EmojiLogic.J(com.tencent.mm.plugin.emoji.h.b.FL(), "", FTSEmojiDetailPageUI.a(this.jfO).field_md5));
        e.r(j.n(paramString.cLr()), FTSEmojiDetailPageUI.e(this.jfO));
        ai.d(new FTSEmojiDetailPageUI.11.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.11
 * JD-Core Version:    0.7.0.1
 */