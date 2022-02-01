package com.tencent.mm.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.CoreService.a;
import com.tencent.mm.booter.InstallReceiver;
import com.tencent.mm.booter.MMReceivers.ConnectionReceiver;
import com.tencent.mm.booter.MountReceiver;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.downloader.model.FileDownloadReceiver;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public class BroadcastHelper
  implements CoreService.a
{
  private static final String TAG = "MicroMsg.BroadcastHelper";
  private static HashMap<String, BroadcastReceiver> broadcastReceiverHashMap;
  
  static
  {
    AppMethodBeat.i(20712);
    broadcastReceiverHashMap = new HashMap();
    AppMethodBeat.o(20712);
  }
  
  public static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String paramString)
  {
    AppMethodBeat.i(20704);
    registerBroadcast(paramBroadcastReceiver, new String[] { paramString }, new String[0]);
    AppMethodBeat.o(20704);
  }
  
  public static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String paramString1, String paramString2)
  {
    AppMethodBeat.i(20705);
    registerBroadcast(paramBroadcastReceiver, new String[] { paramString1 }, new String[] { paramString2 });
    AppMethodBeat.o(20705);
  }
  
  public static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String[] paramArrayOfString)
  {
    AppMethodBeat.i(20706);
    registerBroadcast(paramBroadcastReceiver, paramArrayOfString, new String[0]);
    AppMethodBeat.o(20706);
  }
  
  public static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20707);
    registerBroadcast(paramBroadcastReceiver, paramArrayOfString, new String[] { paramString });
    AppMethodBeat.o(20707);
  }
  
  public static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int j = 0;
    AppMethodBeat.i(20708);
    ad.i("MicroMsg.BroadcastHelper", "registerBroadcast: " + paramBroadcastReceiver.getClass().getSimpleName());
    IntentFilter localIntentFilter = new IntentFilter();
    int k;
    int i;
    if (!bt.V(paramArrayOfString1))
    {
      k = paramArrayOfString1.length;
      i = 0;
      while (i < k)
      {
        localIntentFilter.addAction(paramArrayOfString1[i]);
        i += 1;
      }
    }
    if (!bt.V(paramArrayOfString2))
    {
      k = paramArrayOfString2.length;
      i = j;
      while (i < k)
      {
        localIntentFilter.addCategory(paramArrayOfString2[i]);
        i += 1;
      }
    }
    aj.getContext().registerReceiver(paramBroadcastReceiver, localIntentFilter);
    AppMethodBeat.o(20708);
  }
  
  public static void unRegisterBroadcast(BroadcastReceiver paramBroadcastReceiver)
  {
    AppMethodBeat.i(20709);
    ad.i("MicroMsg.BroadcastHelper", "unRegisterBroadcast: " + paramBroadcastReceiver.getClass().getSimpleName());
    if (paramBroadcastReceiver != null) {
      aj.getContext().unregisterReceiver(paramBroadcastReceiver);
    }
    AppMethodBeat.o(20709);
  }
  
  public void registerBroadcasts()
  {
    AppMethodBeat.i(20710);
    ad.i("MicroMsg.BroadcastHelper", "registerBroadcasts()");
    Object localObject;
    if ((aj.fkG()) && (d.ly(24)))
    {
      localObject = new MMReceivers.ConnectionReceiver();
      broadcastReceiverHashMap.put(MMReceivers.ConnectionReceiver.class.getSimpleName(), localObject);
      registerBroadcast((BroadcastReceiver)localObject, "android.net.conn.CONNECTIVITY_CHANGE");
    }
    if ((aj.cnC()) && (d.ly(26)))
    {
      localObject = new FileDownloadReceiver();
      broadcastReceiverHashMap.put(FileDownloadReceiver.class.getSimpleName(), localObject);
      registerBroadcast((BroadcastReceiver)localObject, "android.intent.action.DOWNLOAD_COMPLETE");
      localObject = new MountReceiver();
      broadcastReceiverHashMap.put(MountReceiver.class.getSimpleName(), localObject);
      registerBroadcast((BroadcastReceiver)localObject, new String[] { "android.intent.action.MEDIA_MOUNTED", "android.intent.action.MEDIA_EJECT", "android.intent.action.MEDIA_UNMOUNTED", "android.intent.action.MEDIA_SHARED", "android.intent.action.MEDIA_SCANNER_STARTED", "android.intent.action.MEDIA_SCANNER_FINISHED", "android.intent.action.MEDIA_REMOVED", "android.intent.action.MEDIA_BAD_REMOVAL" });
    }
    AppMethodBeat.o(20710);
  }
  
  public void unRegisterBroadcasts()
  {
    AppMethodBeat.i(20711);
    ad.i("MicroMsg.BroadcastHelper", "unRegisterBroadcasts()");
    try
    {
      if ((aj.fkG()) && (d.ly(24))) {
        unRegisterBroadcast((MMReceivers.ConnectionReceiver)broadcastReceiverHashMap.get(MMReceivers.ConnectionReceiver.class.getSimpleName()));
      }
      if ((aj.cnC()) && (d.ly(26)))
      {
        unRegisterBroadcast((FileDownloadReceiver)broadcastReceiverHashMap.get(FileDownloadReceiver.class.getSimpleName()));
        unRegisterBroadcast((InstallReceiver)broadcastReceiverHashMap.get(InstallReceiver.class.getSimpleName()));
        unRegisterBroadcast((MountReceiver)broadcastReceiverHashMap.get(MountReceiver.class.getSimpleName()));
      }
      AppMethodBeat.o(20711);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.BroadcastHelper", "unRegisterBroadcasts() Exception = %s ", new Object[] { localException.getMessage() });
      AppMethodBeat.o(20711);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.BroadcastHelper
 * JD-Core Version:    0.7.0.1
 */