package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g.a;

final class WXEntryActivity$EntryReceiver$3
  implements g.a
{
  WXEntryActivity$EntryReceiver$3(WXEntryActivity.EntryReceiver paramEntryReceiver, f paramf) {}
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(153511);
    f localf = paramf;
    if (paramf == null) {
      localf = this.jMp;
    }
    WXEntryActivity.EntryReceiver.a(this.jMs, localf);
    AppMethodBeat.o(153511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver.3
 * JD-Core Version:    0.7.0.1
 */