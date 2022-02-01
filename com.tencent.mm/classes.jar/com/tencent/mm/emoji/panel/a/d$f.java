package com.tencent.mm.emoji.panel.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
final class d$f
  implements f.c
{
  d$f(EmojiInfo paramEmojiInfo) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(105637);
    if ((paramBoolean) && (!bt.isNullOrNil(this.fPR.JS())))
    {
      paramString = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      k.g(paramString, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramString).getEmojiMgr().TN(this.fPR.JS());
    }
    AppMethodBeat.o(105637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.d.f
 * JD-Core Version:    0.7.0.1
 */