package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class WXEntryActivity$EntryReceiver$2
  implements Runnable
{
  WXEntryActivity$EntryReceiver$2(WXEntryActivity.EntryReceiver paramEntryReceiver, Context paramContext, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(22281);
    long l = System.currentTimeMillis();
    WXEntryActivity.EntryReceiver.a(this.nnC, this.val$context, this.val$data);
    ac.i("MicroMsg.WXEntryActivity", "cost:%s", new Object[] { System.currentTimeMillis() - l });
    AppMethodBeat.o(22281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver.2
 * JD-Core Version:    0.7.0.1
 */