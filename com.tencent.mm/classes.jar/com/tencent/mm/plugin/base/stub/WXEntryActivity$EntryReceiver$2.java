package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WXEntryActivity$EntryReceiver$2
  implements Runnable
{
  WXEntryActivity$EntryReceiver$2(WXEntryActivity.EntryReceiver paramEntryReceiver, Context paramContext, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(18195);
    long l = System.currentTimeMillis();
    WXEntryActivity.EntryReceiver.a(this.jMs, this.val$context, this.val$data);
    ab.i("MicroMsg.WXEntryActivity", "cost:%s", new Object[] { System.currentTimeMillis() - l });
    AppMethodBeat.o(18195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver.2
 * JD-Core Version:    0.7.0.1
 */