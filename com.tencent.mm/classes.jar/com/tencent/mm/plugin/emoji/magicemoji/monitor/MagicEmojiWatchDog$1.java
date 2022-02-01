package com.tencent.mm.plugin.emoji.magicemoji.monitor;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.sdk.event.IListener;

class MagicEmojiWatchDog$1
  extends IListener<gh>
{
  MagicEmojiWatchDog$1(c paramc, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(270171);
    this.__eventId = gh.class.getName().hashCode();
    AppMethodBeat.o(270171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.monitor.MagicEmojiWatchDog.1
 * JD-Core Version:    0.7.0.1
 */