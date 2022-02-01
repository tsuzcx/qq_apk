package com.tencent.mm.emoji.panel.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
final class d$a
  implements f.c
{
  d$a(EmojiInfo paramEmojiInfo) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(105632);
    if ((paramBoolean) && (!bu.isNullOrNil(this.gpM.Lj())))
    {
      paramString = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      p.g(paramString, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramString).getEmojiMgr().acw(this.gpM.Lj());
    }
    AppMethodBeat.o(105632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.d.a
 * JD-Core Version:    0.7.0.1
 */