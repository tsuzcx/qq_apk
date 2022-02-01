package com.tencent.mm.plugin.emoji.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.vm;
import com.tencent.mm.sdk.event.IListener;

public class EmojiRevokeMsgListener
  extends IListener<vm>
{
  public EmojiRevokeMsgListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161068);
    this.__eventId = vm.class.getName().hashCode();
    AppMethodBeat.o(161068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.event.EmojiRevokeMsgListener
 * JD-Core Version:    0.7.0.1
 */