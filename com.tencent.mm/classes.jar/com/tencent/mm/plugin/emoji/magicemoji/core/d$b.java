package com.tencent.mm.plugin.emoji.magicemoji.core;

import com.tencent.magicbrush.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiService$installMagicBrush$1", "Lcom/tencent/magicbrush/delegate/LoadDelegate$ILoadLibrary;", "find", "", "libName", "loadLibrary", "", "loader", "Ljava/lang/ClassLoader;", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$b
  implements b.a
{
  public final String fX(String paramString)
  {
    AppMethodBeat.i(270047);
    s.u(paramString, "libName");
    paramString = k.fX(paramString);
    s.s(paramString, "find(libName)");
    AppMethodBeat.o(270047);
    return paramString;
  }
  
  public final void loadLibrary(String paramString)
  {
    AppMethodBeat.i(270042);
    s.u(paramString, "libName");
    k.load(paramString);
    AppMethodBeat.o(270042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.core.d.b
 * JD-Core Version:    0.7.0.1
 */