package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.plugin.emoji.f.a.b;

final class EmojiAddCustomDialogUI$3
  implements a.b
{
  EmojiAddCustomDialogUI$3(EmojiAddCustomDialogUI paramEmojiAddCustomDialogUI) {}
  
  public final void b(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      EmojiAddCustomDialogUI.b(this.jcr, paramString);
      EmojiAddCustomDialogUI.c(this.jcr, paramString);
      return;
    }
    if (paramBoolean)
    {
      EmojiAddCustomDialogUI.e(this.jcr);
      return;
    }
    EmojiAddCustomDialogUI.f(this.jcr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.3
 * JD-Core Version:    0.7.0.1
 */