package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.f.b;

final class EmojiAddCustomDialogUI$3
  implements f.b
{
  EmojiAddCustomDialogUI$3(EmojiAddCustomDialogUI paramEmojiAddCustomDialogUI) {}
  
  public final void b(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(53272);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      EmojiAddCustomDialogUI.b(this.lld, paramString);
      EmojiAddCustomDialogUI.c(this.lld, paramString);
      AppMethodBeat.o(53272);
      return;
    }
    if (paramBoolean)
    {
      EmojiAddCustomDialogUI.e(this.lld);
      AppMethodBeat.o(53272);
      return;
    }
    if (paramInt2 == 4)
    {
      EmojiAddCustomDialogUI.f(this.lld);
      AppMethodBeat.o(53272);
      return;
    }
    EmojiAddCustomDialogUI.g(this.lld);
    AppMethodBeat.o(53272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.3
 * JD-Core Version:    0.7.0.1
 */