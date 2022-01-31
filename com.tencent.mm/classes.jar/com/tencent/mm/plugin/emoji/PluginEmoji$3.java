package com.tencent.mm.plugin.emoji;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.t;
import com.tencent.mm.api.u.a;
import com.tencent.mm.pluginsdk.ui.chat.k;
import com.tencent.mm.view.c;

final class PluginEmoji$3
  implements u.a
{
  PluginEmoji$3(PluginEmoji paramPluginEmoji) {}
  
  public final t AG()
  {
    AppMethodBeat.i(62324);
    k localk = new k();
    AppMethodBeat.o(62324);
    return localk;
  }
  
  public final SmileyPanel aX(Context paramContext)
  {
    AppMethodBeat.i(62322);
    paramContext = k(paramContext, false);
    AppMethodBeat.o(62322);
    return paramContext;
  }
  
  public final SmileyPanel k(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(62323);
    paramContext = new c(paramContext, paramBoolean);
    AppMethodBeat.o(62323);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.PluginEmoji.3
 * JD-Core Version:    0.7.0.1
 */