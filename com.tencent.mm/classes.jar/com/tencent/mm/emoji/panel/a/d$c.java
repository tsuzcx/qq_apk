package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
final class d$c
  implements f.c
{
  d$c(Context paramContext) {}
  
  public final void e(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(105634);
    if (paramBoolean)
    {
      paramString = new Intent();
      paramString.putExtra("key_emoji_panel_type", 1);
      c.b(this.$context, "emoji", ".ui.EmojiCustomUI", paramString);
    }
    AppMethodBeat.o(105634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.d.c
 * JD-Core Version:    0.7.0.1
 */