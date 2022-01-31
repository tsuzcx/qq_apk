package com.tencent.mm.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.BluetoothReceiver;
import com.tencent.mm.booter.BluetoothStateReceiver;
import com.tencent.mm.booter.CoreService.a;
import com.tencent.mm.booter.InstallReceiver;
import com.tencent.mm.booter.MMReceivers.ConnectionReceiver;
import com.tencent.mm.booter.MountReceiver;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.downloader.model.FileDownloadReceiver;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public class BroadcastHelper
  implements CoreService.a
{
  private static final String TAG = "MicroMsg.BroadcastHelper";
  private static HashMap<String, BroadcastReceiver> broadcastReceiverHashMap;
  
  static
  {
    AppMethodBeat.i(16668);
    broadcastReceiverHashMap = new HashMap();
    AppMethodBeat.o(16668);
  }
  
  public static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String paramString)
  {
    AppMethodBeat.i(16660);
    registerBroadcast(paramBroadcastReceiver, new String[] { paramString }, new String[0]);
    AppMethodBeat.o(16660);
  }
  
  public static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String paramString1, String paramString2)
  {
    AppMethodBeat.i(16661);
    registerBroadcast(paramBroadcastReceiver, new String[] { paramString1 }, new String[] { paramString2 });
    AppMethodBeat.o(16661);
  }
  
  public static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String[] paramArrayOfString)
  {
    AppMethodBeat.i(16662);
    registerBroadcast(paramBroadcastReceiver, paramArrayOfString, new String[0]);
    AppMethodBeat.o(16662);
  }
  
  public static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(16663);
    registerBroadcast(paramBroadcastReceiver, paramArrayOfString, new String[] { paramString });
    AppMethodBeat.o(16663);
  }
  
  public static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int j = 0;
    AppMethodBeat.i(16664);
    ab.i("MicroMsg.BroadcastHelper", "registerBroadcast: " + paramBroadcastReceiver.getClass().getSimpleName());
    IntentFilter localIntentFilter = new IntentFilter();
    int k;
    int i;
    if (!bo.Q(paramArrayOfString1))
    {
      k = paramArrayOfString1.length;
      i = 0;
      while (i < k)
      {
        localIntentFilter.addAction(paramArrayOfString1[i]);
        i += 1;
      }
    }
    if (!bo.Q(paramArrayOfString2))
    {
      k = paramArrayOfString2.length;
      i = j;
      while (i < k)
      {
        localIntentFilter.addCategory(paramArrayOfString2[i]);
        i += 1;
      }
    }
    ah.getContext().registerReceiver(paramBroadcastReceiver, localIntentFilter);
    AppMethodBeat.o(16664);
  }
  
  public static void unRegisterBroadcast(BroadcastReceiver paramBroadcastReceiver)
  {
    AppMethodBeat.i(16665);
    ab.i("MicroMsg.BroadcastHelper", "unRegisterBroadcast: " + paramBroadcastReceiver.getClass().getSimpleName());
    if (paramBroadcastReceiver != null) {
      ah.getContext().unregisterReceiver(paramBroadcastReceiver);
    }
    AppMethodBeat.o(16665);
  }
  
  public void registerBroadcasts()
  {
    AppMethodBeat.i(16666);
    ab.i("MicroMsg.BroadcastHelper", "registerBroadcasts()");
    Object localObject;
    if ((ah.dsU()) && (d.fv(24)))
    {
      localObject = new MMReceivers.ConnectionReceiver();
      broadcastReceiverHashMap.put(MMReceivers.ConnectionReceiver.class.getSimpleName(), localObject);
      registerBroadcast((BroadcastReceiver)localObject, "android.net.conn.CONNECTIVITY_CHANGE");
    }
    if ((ah.brt()) && (d.fv(26)))
    {
      localObject = new FileDownloadReceiver();
      broadcastReceiverHashMap.put(FileDownloadReceiver.class.getSimpleName(), localObject);
      registerBroadcast((BroadcastReceiver)localObject, "android.intent.action.DOWNLOAD_COMPLETE");
      localObject = new InstallReceiver();
      broadcastReceiverHashMap.put(InstallReceiver.class.getSimpleName(), localObject);
      registerBroadcast((BroadcastReceiver)localObject, "com.android.vending.INSTALL_REFERRER");
      localObject = new BluetoothReceiver();
      broadcastReceiverHashMap.put(BluetoothReceiver.class.getSimpleName(), localObject);
      registerBroadcast((BroadcastReceiver)localObject, new String[] { "android.media.SCO_AUDIO_STATE_CHANGED", "android.media.ACTION_SCO_AUDIO_STATE_UPDATED" });
      localObject = new BluetoothStateReceiver();
      broadcastReceiverHashMap.put(BluetoothStateReceiver.class.getSimpleName(), localObject);
      registerBroadcast((BroadcastReceiver)localObject, "android.bluetooth.adapter.action.STATE_CHANGED");
      localObject = new MountReceiver();
      broadcastReceiverHashMap.put(MountReceiver.class.getSimpleName(), localObject);
      registerBroadcast((BroadcastReceiver)localObject, new String[] { "android.intent.action.MEDIA_MOUNTED", "android.intent.action.MEDIA_EJECT", "android.intent.action.MEDIA_UNMOUNTED", "android.intent.action.MEDIA_SHARED", "android.intent.action.MEDIA_SCANNER_STARTED", "android.intent.action.MEDIA_SCANNER_FINISHED", "android.intent.action.MEDIA_REMOVED", "android.intent.action.MEDIA_BAD_REMOVAL" });
    }
    AppMethodBeat.o(16666);
  }
  
  public void unRegisterBroadcasts()
  {
    AppMethodBeat.i(16667);
    ab.i("MicroMsg.BroadcastHelper", "unRegisterBroadcasts()");
    try
    {
      if ((ah.dsU()) && (d.fv(24))) {
        unRegisterBroadcast((MMReceivers.ConnectionReceiver)broadcastReceiverHashMap.get(MMReceivers.ConnectionReceiver.class.getSimpleName()));
      }
      if ((ah.brt()) && (d.fv(26)))
      {
        unRegisterBroadcast((FileDownloadReceiver)broadcastReceiverHashMap.get(FileDownloadReceiver.class.getSimpleName()));
        unRegisterBroadcast((InstallReceiver)broadcastReceiverHashMap.get(InstallReceiver.class.getSimpleName()));
        unRegisterBroadcast((BluetoothReceiver)broadcastReceiverHashMap.get(BluetoothReceiver.class.getSimpleName()));
        unRegisterBroadcast((BluetoothStateReceiver)broadcastReceiverHashMap.get(BluetoothStateReceiver.class.getSimpleName()));
        unRegisterBroadcast((MountReceiver)broadcastReceiverHashMap.get(MountReceiver.class.getSimpleName()));
      }
      AppMethodBeat.o(16667);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.BroadcastHelper", "unRegisterBroadcasts() Exception = %s ", new Object[] { localException.getMessage() });
      AppMethodBeat.o(16667);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.platformtools.BroadcastHelper
 * JD-Core Version:    0.7.0.1
 */