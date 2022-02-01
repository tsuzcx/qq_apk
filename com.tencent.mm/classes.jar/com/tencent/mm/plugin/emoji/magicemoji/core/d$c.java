package com.tencent.mm.plugin.emoji.magicemoji.core;

import com.tencent.luggage.game.b.e;
import com.tencent.magicbrush.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiService$installMagicBrush$2", "Lcom/tencent/luggage/game/handler/MBLogDelegateRegistry;", "loadNativeLibs", "", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$c
  extends e
{
  public final void aoX()
  {
    AppMethodBeat.i(270040);
    super.aoX();
    b.loadLibrary("gamelog_delegate");
    AppMethodBeat.o(270040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.core.d.c
 * JD-Core Version:    0.7.0.1
 */