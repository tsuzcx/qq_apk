package com.tencent.mm.plugin.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.CoreService.a;
import com.tencent.mm.plugin.audio.broadcast.base.BaseAudioReceiver;
import com.tencent.mm.plugin.audio.broadcast.bluetooth.BluetoothReceiver;
import com.tencent.mm.plugin.audio.broadcast.headset.HeadsetPlugReceiver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper;", "Lcom/tencent/mm/booter/CoreService$BroadcastRegisterHelper;", "()V", "broadcastReceiverHashMap", "Ljava/util/HashMap;", "", "Landroid/content/BroadcastReceiver;", "registerBroadcast", "", "receiver", "actions", "", "(Landroid/content/BroadcastReceiver;[Ljava/lang/String;)V", "categories", "(Landroid/content/BroadcastReceiver;[Ljava/lang/String;[Ljava/lang/String;)V", "action", "registerBroadcasts", "unRegisterBroadcast", "unRegisterBroadcasts", "Companion", "plugin-audio_release"})
public final class a
  implements CoreService.a
{
  public static final a oHA;
  private final HashMap<String, BroadcastReceiver> broadcastReceiverHashMap;
  
  static
  {
    AppMethodBeat.i(223931);
    oHA = new a((byte)0);
    AppMethodBeat.o(223931);
  }
  
  public a()
  {
    AppMethodBeat.i(223930);
    this.broadcastReceiverHashMap = new HashMap();
    AppMethodBeat.o(223930);
  }
  
  private static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String paramString)
  {
    AppMethodBeat.i(223927);
    registerBroadcast(paramBroadcastReceiver, new String[] { paramString }, new String[0]);
    AppMethodBeat.o(223927);
  }
  
  private static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(223928);
    Log.i("MicroMsg.AudioBroadcastHelper", "registerBroadcast: " + paramBroadcastReceiver.getClass().getSimpleName());
    IntentFilter localIntentFilter = new IntentFilter();
    if (!Util.isNullOrNil((String[])Arrays.copyOf(paramArrayOfString1, paramArrayOfString1.length)))
    {
      int j = paramArrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        localIntentFilter.addAction(paramArrayOfString1[i]);
        i += 1;
      }
    }
    Util.isNullOrNil((String[])Arrays.copyOf(paramArrayOfString2, 0));
    MMApplicationContext.getContext().registerReceiver(paramBroadcastReceiver, localIntentFilter);
    AppMethodBeat.o(223928);
  }
  
  private static void unRegisterBroadcast(BroadcastReceiver paramBroadcastReceiver)
  {
    AppMethodBeat.i(223929);
    Log.i("MicroMsg.AudioBroadcastHelper", "unRegisterBroadcast: " + paramBroadcastReceiver.getClass().getSimpleName());
    MMApplicationContext.getContext().unregisterReceiver(paramBroadcastReceiver);
    AppMethodBeat.o(223929);
  }
  
  public final void registerBroadcasts()
  {
    AppMethodBeat.i(223925);
    Log.i("MicroMsg.AudioBroadcastHelper", "registerBroadcasts()");
    Object localObject = new BluetoothReceiver();
    Map localMap = (Map)this.broadcastReceiverHashMap;
    String str = BluetoothReceiver.class.getSimpleName();
    p.g(str, "BluetoothReceiver::class.java.simpleName");
    localMap.put(str, localObject);
    registerBroadcast((BroadcastReceiver)localObject, new String[] { "android.media.ACTION_SCO_AUDIO_STATE_UPDATED", "android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED", "android.bluetooth.adapter.action.STATE_CHANGED", "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED", "android.bluetooth.device.action.ACL_DISCONNECTED", "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED" }, new String[0]);
    localObject = new HeadsetPlugReceiver();
    localMap = (Map)this.broadcastReceiverHashMap;
    str = HeadsetPlugReceiver.class.getSimpleName();
    p.g(str, "HeadsetPlugReceiver::class.java.simpleName");
    localMap.put(str, localObject);
    registerBroadcast((BroadcastReceiver)localObject, "android.intent.action.HEADSET_PLUG");
    localObject = new BaseAudioReceiver();
    localMap = (Map)this.broadcastReceiverHashMap;
    str = BaseAudioReceiver.class.getSimpleName();
    p.g(str, "BaseAudioReceiver::class.java.simpleName");
    localMap.put(str, localObject);
    registerBroadcast((BroadcastReceiver)localObject, "android.media.AUDIO_BECOMING_NOISY");
    AppMethodBeat.o(223925);
  }
  
  public final void unRegisterBroadcasts()
  {
    AppMethodBeat.i(223926);
    Log.i("MicroMsg.AudioBroadcastHelper", "unRegisterBroadcasts()");
    try
    {
      Object localObject1 = this.broadcastReceiverHashMap.get(BluetoothReceiver.class.getSimpleName());
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.audio.broadcast.bluetooth.BluetoothReceiver");
        AppMethodBeat.o(223926);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AudioBroadcastHelper", "unRegisterBroadcasts() Exception = %s ", new Object[] { localException.getMessage() });
      AppMethodBeat.o(223926);
      return;
    }
    unRegisterBroadcast((BroadcastReceiver)localException);
    Object localObject2 = this.broadcastReceiverHashMap.get(HeadsetPlugReceiver.class.getSimpleName());
    if (localObject2 == null)
    {
      localObject2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.audio.broadcast.headset.HeadsetPlugReceiver");
      AppMethodBeat.o(223926);
      throw ((Throwable)localObject2);
    }
    unRegisterBroadcast((BroadcastReceiver)localObject2);
    localObject2 = this.broadcastReceiverHashMap.get(BaseAudioReceiver.class.getSimpleName());
    if (localObject2 == null)
    {
      localObject2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.audio.broadcast.base.BaseAudioReceiver");
      AppMethodBeat.o(223926);
      throw ((Throwable)localObject2);
    }
    unRegisterBroadcast((BroadcastReceiver)localObject2);
    AppMethodBeat.o(223926);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper$Companion;", "", "()V", "TAG", "", "plugin-audio_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.a
 * JD-Core Version:    0.7.0.1
 */