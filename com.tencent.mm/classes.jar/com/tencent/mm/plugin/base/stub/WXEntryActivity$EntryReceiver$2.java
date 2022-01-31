package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;

final class WXEntryActivity$EntryReceiver$2
  implements Runnable
{
  WXEntryActivity$EntryReceiver$2(WXEntryActivity.EntryReceiver paramEntryReceiver, Context paramContext, Intent paramIntent) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    WXEntryActivity.EntryReceiver.a(this.hSG, this.val$context, this.hSF);
    y.i("MicroMsg.WXEntryActivity", "cost:%s", new Object[] { System.currentTimeMillis() - l });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver.2
 * JD-Core Version:    0.7.0.1
 */