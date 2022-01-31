package com.tencent.mm.plugin.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

public final class BKGLoaderManager$ConnectivityReceiver
  extends BroadcastReceiver
{
  public BKGLoaderManager$ConnectivityReceiver(BKGLoaderManager paramBKGLoaderManager) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(53185);
    int i = at.getNetType(paramContext);
    if (this.ljC.mNetWorkType == i)
    {
      AppMethodBeat.o(53185);
      return;
    }
    ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] network change type:%d", new Object[] { Integer.valueOf(i) });
    if (BKGLoaderManager.bkO()) {
      this.ljC.blN();
    }
    for (;;)
    {
      this.ljC.mNetWorkType = i;
      AppMethodBeat.o(53185);
      return;
      if (BKGLoaderManager.blP()) {
        this.ljC.blM();
      } else if (!at.isConnected(ah.getContext())) {
        this.ljC.blN();
      } else {
        this.ljC.blO();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.ConnectivityReceiver
 * JD-Core Version:    0.7.0.1
 */