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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper;", "Lcom/tencent/mm/booter/CoreService$BroadcastRegisterHelper;", "()V", "broadcastReceiverHashMap", "Ljava/util/HashMap;", "", "Landroid/content/BroadcastReceiver;", "registerBroadcast", "", "receiver", "actions", "", "(Landroid/content/BroadcastReceiver;[Ljava/lang/String;)V", "categories", "(Landroid/content/BroadcastReceiver;[Ljava/lang/String;[Ljava/lang/String;)V", "action", "registerBroadcasts", "unRegisterBroadcast", "unRegisterBroadcasts", "Companion", "plugin-audio_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements CoreService.a
{
  public static final a uUH;
  private final HashMap<String, BroadcastReceiver> broadcastReceiverHashMap;
  
  static
  {
    AppMethodBeat.i(263850);
    uUH = new a((byte)0);
    AppMethodBeat.o(263850);
  }
  
  public a()
  {
    AppMethodBeat.i(263820);
    this.broadcastReceiverHashMap = new HashMap();
    AppMethodBeat.o(263820);
  }
  
  private static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String paramString)
  {
    AppMethodBeat.i(263829);
    registerBroadcast(paramBroadcastReceiver, new String[] { paramString }, new String[0]);
    AppMethodBeat.o(263829);
  }
  
  private static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(263840);
    Log.i("MicroMsg.AudioBroadcastHelper", s.X("registerBroadcast: ", paramBroadcastReceiver.getClass().getSimpleName()));
    IntentFilter localIntentFilter = new IntentFilter();
    if (!Util.isNullOrNil((String[])Arrays.copyOf(paramArrayOfString1, paramArrayOfString1.length)))
    {
      int j = paramArrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString1[i];
        i += 1;
        localIntentFilter.addAction(str);
      }
    }
    Util.isNullOrNil((String[])Arrays.copyOf(paramArrayOfString2, 0));
    MMApplicationContext.getContext().registerReceiver(paramBroadcastReceiver, localIntentFilter);
    AppMethodBeat.o(263840);
  }
  
  private static void unRegisterBroadcast(BroadcastReceiver paramBroadcastReceiver)
  {
    AppMethodBeat.i(263845);
    Log.i("MicroMsg.AudioBroadcastHelper", s.X("unRegisterBroadcast: ", paramBroadcastReceiver.getClass().getSimpleName()));
    MMApplicationContext.getContext().unregisterReceiver(paramBroadcastReceiver);
    AppMethodBeat.o(263845);
  }
  
  public final void registerBroadcasts()
  {
    AppMethodBeat.i(263854);
    Log.i("MicroMsg.AudioBroadcastHelper", "registerBroadcasts()");
    Object localObject = new BluetoothReceiver();
    Map localMap = (Map)this.broadcastReceiverHashMap;
    String str = BluetoothReceiver.class.getSimpleName();
    s.s(str, "BluetoothReceiver::class.java.simpleName");
    localMap.put(str, localObject);
    registerBroadcast((BroadcastReceiver)localObject, new String[] { "android.media.ACTION_SCO_AUDIO_STATE_UPDATED", "android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED", "android.bluetooth.adapter.action.STATE_CHANGED", "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED", "android.bluetooth.device.action.ACL_DISCONNECTED", "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED" }, new String[0]);
    localObject = new HeadsetPlugReceiver();
    localMap = (Map)this.broadcastReceiverHashMap;
    str = HeadsetPlugReceiver.class.getSimpleName();
    s.s(str, "HeadsetPlugReceiver::class.java.simpleName");
    localMap.put(str, localObject);
    registerBroadcast((BroadcastReceiver)localObject, "android.intent.action.HEADSET_PLUG");
    localObject = new BaseAudioReceiver();
    localMap = (Map)this.broadcastReceiverHashMap;
    str = BaseAudioReceiver.class.getSimpleName();
    s.s(str, "BaseAudioReceiver::class.java.simpleName");
    localMap.put(str, localObject);
    registerBroadcast((BroadcastReceiver)localObject, "android.media.AUDIO_BECOMING_NOISY");
    AppMethodBeat.o(263854);
  }
  
  public final void unRegisterBroadcasts()
  {
    AppMethodBeat.i(263857);
    Log.i("MicroMsg.AudioBroadcastHelper", "unRegisterBroadcasts()");
    try
    {
      Object localObject1 = this.broadcastReceiverHashMap.get(BluetoothReceiver.class.getSimpleName());
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.audio.broadcast.bluetooth.BluetoothReceiver");
        AppMethodBeat.o(263857);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AudioBroadcastHelper", "unRegisterBroadcasts() Exception = %s ", new Object[] { localException.getMessage() });
      AppMethodBeat.o(263857);
      return;
    }
    unRegisterBroadcast((BroadcastReceiver)localException);
    Object localObject2 = this.broadcastReceiverHashMap.get(HeadsetPlugReceiver.class.getSimpleName());
    if (localObject2 == null)
    {
      localObject2 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.audio.broadcast.headset.HeadsetPlugReceiver");
      AppMethodBeat.o(263857);
      throw ((Throwable)localObject2);
    }
    unRegisterBroadcast((BroadcastReceiver)localObject2);
    localObject2 = this.broadcastReceiverHashMap.get(BaseAudioReceiver.class.getSimpleName());
    if (localObject2 == null)
    {
      localObject2 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.audio.broadcast.base.BaseAudioReceiver");
      AppMethodBeat.o(263857);
      throw ((Throwable)localObject2);
    }
    unRegisterBroadcast((BroadcastReceiver)localObject2);
    AppMethodBeat.o(263857);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper$Companion;", "", "()V", "TAG", "", "plugin-audio_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.a
 * JD-Core Version:    0.7.0.1
 */