package com.tencent.mm.emoji.panel.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
final class e$f
  implements f.c
{
  e$f(EmojiInfo paramEmojiInfo) {}
  
  public final void g(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(105637);
    if ((paramBoolean) && (!Util.isNullOrNil(this.jLK.getMd5())))
    {
      paramString = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
      p.j(paramString, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramString).getEmojiMgr().auu(this.jLK.getMd5());
    }
    AppMethodBeat.o(105637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.e.f
 * JD-Core Version:    0.7.0.1
 */