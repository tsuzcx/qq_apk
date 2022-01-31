package com.tencent.mm.plugin.downloader.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

public final class a
{
  private static BroadcastReceiver kZn = null;
  private static int kZo = -1;
  
  public static void bje()
  {
    AppMethodBeat.i(2479);
    if (kZn == null) {
      kZn = new a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      ah.getContext().registerReceiver(kZn, localIntentFilter);
      AppMethodBeat.o(2479);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.Downloader.NetWorkManager", localException.getMessage());
      AppMethodBeat.o(2479);
    }
  }
  
  public static void bjf()
  {
    AppMethodBeat.i(2480);
    if (kZn != null) {}
    try
    {
      ah.getContext().unregisterReceiver(kZn);
      kZn = null;
      AppMethodBeat.o(2480);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.Downloader.NetWorkManager", localException.getMessage());
      }
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(2478);
      if ((!g.RG()) || (com.tencent.mm.kernel.a.QP()))
      {
        ab.e("MicroMsg.Downloader.NetWorkManager", "acc has not ready");
        AppMethodBeat.o(2478);
        return;
      }
      int i = at.getNetType(ah.getContext());
      if (i == a.kZo)
      {
        AppMethodBeat.o(2478);
        return;
      }
      a.ua(i);
      ab.i("MicroMsg.Downloader.NetWorkManager", "onNetStateChange, netState = ".concat(String.valueOf(i)));
      if (!at.isConnected(paramContext))
      {
        ab.w("MicroMsg.Downloader.NetWorkManager", "network is not connected");
        AppMethodBeat.o(2478);
        return;
      }
      d.ysm.execute(new a.a.1(this, i));
      AppMethodBeat.o(2478);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.e.a
 * JD-Core Version:    0.7.0.1
 */