package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.mz;
import com.tencent.mm.f.a.mz.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class b$4
  extends IListener<mz>
{
  b$4(b paramb)
  {
    AppMethodBeat.i(161072);
    this.__eventId = mz.class.getName().hashCode();
    AppMethodBeat.o(161072);
  }
  
  private static boolean a(mz parammz)
  {
    AppMethodBeat.i(108399);
    if ((parammz != null) && ((parammz instanceof mz)))
    {
      Log.i("MicroMsg.emoji.EmojiEventMgr", "manualAuthEventListener callback");
      if (parammz.fLf.result)
      {
        h.aHG().aHp().set(ar.a.VgN, Boolean.TRUE);
        h.aHG().aHp().set(ar.a.VgO, Boolean.TRUE);
      }
    }
    AppMethodBeat.o(108399);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b.4
 * JD-Core Version:    0.7.0.1
 */