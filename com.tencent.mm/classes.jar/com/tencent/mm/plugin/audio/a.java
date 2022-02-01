package com.tencent.mm.plugin.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.CoreService.a;
import com.tencent.mm.plugin.audio.broadcast.base.BaseAudioReceiver;
import com.tencent.mm.plugin.audio.broadcast.bluetooth.BluetoothReceiver;
import com.tencent.mm.plugin.audio.broadcast.headset.HeadsetPlugReceiver;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import d.v;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper;", "Lcom/tencent/mm/booter/CoreService$BroadcastRegisterHelper;", "()V", "broadcastReceiverHashMap", "Ljava/util/HashMap;", "", "Landroid/content/BroadcastReceiver;", "registerBroadcast", "", "receiver", "actions", "", "(Landroid/content/BroadcastReceiver;[Ljava/lang/String;)V", "categories", "(Landroid/content/BroadcastReceiver;[Ljava/lang/String;[Ljava/lang/String;)V", "action", "registerBroadcasts", "unRegisterBroadcast", "unRegisterBroadcasts", "Companion", "plugin-audio_release"})
public final class a
  implements CoreService.a
{
  public static final a mQS;
  private final HashMap<String, BroadcastReceiver> broadcastReceiverHashMap;
  
  static
  {
    AppMethodBeat.i(198328);
    mQS = new a((byte)0);
    AppMethodBeat.o(198328);
  }
  
  public a()
  {
    AppMethodBeat.i(198327);
    this.broadcastReceiverHashMap = new HashMap();
    AppMethodBeat.o(198327);
  }
  
  private static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String paramString)
  {
    AppMethodBeat.i(198324);
    registerBroadcast(paramBroadcastReceiver, new String[] { paramString }, new String[0]);
    AppMethodBeat.o(198324);
  }
  
  private static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(198325);
    ac.i("MicroMsg.AudioBroadcastHelper", "registerBroadcast: " + paramBroadcastReceiver.getClass().getSimpleName());
    IntentFilter localIntentFilter = new IntentFilter();
    if (!bs.T((String[])Arrays.copyOf(paramArrayOfString1, paramArrayOfString1.length)))
    {
      int j = paramArrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        localIntentFilter.addAction(paramArrayOfString1[i]);
        i += 1;
      }
    }
    bs.T((String[])Arrays.copyOf(paramArrayOfString2, 0));
    ai.getContext().registerReceiver(paramBroadcastReceiver, localIntentFilter);
    AppMethodBeat.o(198325);
  }
  
  private static void unRegisterBroadcast(BroadcastReceiver paramBroadcastReceiver)
  {
    AppMethodBeat.i(198326);
    ac.i("MicroMsg.AudioBroadcastHelper", "unRegisterBroadcast: " + paramBroadcastReceiver.getClass().getSimpleName());
    ai.getContext().unregisterReceiver(paramBroadcastReceiver);
    AppMethodBeat.o(198326);
  }
  
  public final void registerBroadcasts()
  {
    AppMethodBeat.i(198322);
    ac.i("MicroMsg.AudioBroadcastHelper", "registerBroadcasts()");
    Object localObject = new BluetoothReceiver();
    Map localMap = (Map)this.broadcastReceiverHashMap;
    String str = BluetoothReceiver.class.getSimpleName();
    k.g(str, "BluetoothReceiver::class.java.simpleName");
    localMap.put(str, localObject);
    registerBroadcast((BroadcastReceiver)localObject, new String[] { "android.media.ACTION_SCO_AUDIO_STATE_UPDATED", "android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED", "android.bluetooth.adapter.action.STATE_CHANGED", "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED", "android.bluetooth.device.action.ACL_DISCONNECTED" }, new String[0]);
    localObject = new HeadsetPlugReceiver();
    localMap = (Map)this.broadcastReceiverHashMap;
    str = HeadsetPlugReceiver.class.getSimpleName();
    k.g(str, "HeadsetPlugReceiver::class.java.simpleName");
    localMap.put(str, localObject);
    registerBroadcast((BroadcastReceiver)localObject, "android.intent.action.HEADSET_PLUG");
    localObject = new BaseAudioReceiver();
    localMap = (Map)this.broadcastReceiverHashMap;
    str = BaseAudioReceiver.class.getSimpleName();
    k.g(str, "BaseAudioReceiver::class.java.simpleName");
    localMap.put(str, localObject);
    registerBroadcast((BroadcastReceiver)localObject, "android.media.AUDIO_BECOMING_NOISY");
    AppMethodBeat.o(198322);
  }
  
  public final void unRegisterBroadcasts()
  {
    AppMethodBeat.i(198323);
    ac.i("MicroMsg.AudioBroadcastHelper", "unRegisterBroadcasts()");
    try
    {
      Object localObject1 = this.broadcastReceiverHashMap.get(BluetoothReceiver.class.getSimpleName());
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.audio.broadcast.bluetooth.BluetoothReceiver");
        AppMethodBeat.o(198323);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.AudioBroadcastHelper", "unRegisterBroadcasts() Exception = %s ", new Object[] { localException.getMessage() });
      AppMethodBeat.o(198323);
      return;
    }
    unRegisterBroadcast((BroadcastReceiver)localException);
    Object localObject2 = this.broadcastReceiverHashMap.get(HeadsetPlugReceiver.class.getSimpleName());
    if (localObject2 == null)
    {
      localObject2 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.audio.broadcast.headset.HeadsetPlugReceiver");
      AppMethodBeat.o(198323);
      throw ((Throwable)localObject2);
    }
    unRegisterBroadcast((BroadcastReceiver)localObject2);
    localObject2 = this.broadcastReceiverHashMap.get(BaseAudioReceiver.class.getSimpleName());
    if (localObject2 == null)
    {
      localObject2 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.audio.broadcast.base.BaseAudioReceiver");
      AppMethodBeat.o(198323);
      throw ((Throwable)localObject2);
    }
    unRegisterBroadcast((BroadcastReceiver)localObject2);
    AppMethodBeat.o(198323);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper$Companion;", "", "()V", "TAG", "", "plugin-audio_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.a
 * JD-Core Version:    0.7.0.1
 */