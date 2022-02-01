package com.tencent.mm.plugin.emoji.mgr;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.og;
import com.tencent.mm.autogen.a.og.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

class EmojiEventMgr$2
  extends IListener<og>
{
  EmojiEventMgr$2(b paramb, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(269908);
    this.__eventId = og.class.getName().hashCode();
    AppMethodBeat.o(269908);
  }
  
  private static boolean a(og paramog)
  {
    AppMethodBeat.i(108399);
    if ((paramog != null) && ((paramog instanceof og)))
    {
      Log.i("MicroMsg.emoji.EmojiEventMgr", "manualAuthEventListener callback");
      if (paramog.hQM.result)
      {
        h.baE().ban().set(at.a.acId, Boolean.TRUE);
        h.baE().ban().set(at.a.acIe, Boolean.TRUE);
      }
    }
    AppMethodBeat.o(108399);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.mgr.EmojiEventMgr.2
 * JD-Core Version:    0.7.0.1
 */