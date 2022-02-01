package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WXEntryActivity$EntryReceiver$1
  implements com.tencent.mm.kernel.api.g
{
  WXEntryActivity$EntryReceiver$1(WXEntryActivity.EntryReceiver paramEntryReceiver, Context paramContext, Intent paramIntent) {}
  
  public final void Lh()
  {
    AppMethodBeat.i(22280);
    com.tencent.mm.kernel.g.agS().b(this);
    WXEntryActivity.EntryReceiver.a(this.nnC, this.val$context, this.val$data);
    AppMethodBeat.o(22280);
  }
  
  public final void cf(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver.1
 * JD-Core Version:    0.7.0.1
 */