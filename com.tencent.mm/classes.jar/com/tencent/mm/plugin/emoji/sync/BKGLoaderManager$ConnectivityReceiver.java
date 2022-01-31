package com.tencent.mm.plugin.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

public final class BKGLoaderManager$ConnectivityReceiver
  extends BroadcastReceiver
{
  public BKGLoaderManager$ConnectivityReceiver(BKGLoaderManager paramBKGLoaderManager) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = aq.getNetType(paramContext);
    if (this.jaT.mNetWorkType == i) {
      return;
    }
    y.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] network change type:%d", new Object[] { Integer.valueOf(i) });
    if (BKGLoaderManager.aHa()) {
      this.jaT.aIo();
    }
    for (;;)
    {
      this.jaT.mNetWorkType = i;
      return;
      if (BKGLoaderManager.aIq()) {
        this.jaT.aIn();
      } else if (!aq.isConnected(ae.getContext())) {
        this.jaT.aIo();
      } else {
        this.jaT.aIp();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.ConnectivityReceiver
 * JD-Core Version:    0.7.0.1
 */