package com.tencent.mm.plugin.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.CoreService.a;
import com.tencent.mm.plugin.audio.broadcast.base.BaseAudioReceiver;
import com.tencent.mm.plugin.audio.broadcast.bluetooth.BluetoothReceiver;
import com.tencent.mm.plugin.audio.broadcast.headset.HeadsetPlugReceiver;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import d.v;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper;", "Lcom/tencent/mm/booter/CoreService$BroadcastRegisterHelper;", "()V", "broadcastReceiverHashMap", "Ljava/util/HashMap;", "", "Landroid/content/BroadcastReceiver;", "registerBroadcast", "", "receiver", "actions", "", "(Landroid/content/BroadcastReceiver;[Ljava/lang/String;)V", "categories", "(Landroid/content/BroadcastReceiver;[Ljava/lang/String;[Ljava/lang/String;)V", "action", "registerBroadcasts", "unRegisterBroadcast", "unRegisterBroadcasts", "Companion", "plugin-audio_release"})
public final class a
  implements CoreService.a
{
  public static final a moR;
  private final HashMap<String, BroadcastReceiver> broadcastReceiverHashMap;
  
  static
  {
    AppMethodBeat.i(189208);
    moR = new a((byte)0);
    AppMethodBeat.o(189208);
  }
  
  public a()
  {
    AppMethodBeat.i(189207);
    this.broadcastReceiverHashMap = new HashMap();
    AppMethodBeat.o(189207);
  }
  
  private static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String paramString)
  {
    AppMethodBeat.i(189204);
    registerBroadcast(paramBroadcastReceiver, new String[] { paramString }, new String[0]);
    AppMethodBeat.o(189204);
  }
  
  private static void registerBroadcast(BroadcastReceiver paramBroadcastReceiver, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(189205);
    ad.i("MicroMsg.AudioBroadcastHelper", "registerBroadcast: " + paramBroadcastReceiver.getClass().getSimpleName());
    IntentFilter localIntentFilter = new IntentFilter();
    if (!bt.T((String[])Arrays.copyOf(paramArrayOfString1, paramArrayOfString1.length)))
    {
      int j = paramArrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        localIntentFilter.addAction(paramArrayOfString1[i]);
        i += 1;
      }
    }
    bt.T((String[])Arrays.copyOf(paramArrayOfString2, 0));
    aj.getContext().registerReceiver(paramBroadcastReceiver, localIntentFilter);
    AppMethodBeat.o(189205);
  }
  
  private static void unRegisterBroadcast(BroadcastReceiver paramBroadcastReceiver)
  {
    AppMethodBeat.i(189206);
    ad.i("MicroMsg.AudioBroadcastHelper", "unRegisterBroadcast: " + paramBroadcastReceiver.getClass().getSimpleName());
    aj.getContext().unregisterReceiver(paramBroadcastReceiver);
    AppMethodBeat.o(189206);
  }
  
  public final void registerBroadcasts()
  {
    AppMethodBeat.i(189202);
    ad.i("MicroMsg.AudioBroadcastHelper", "registerBroadcasts()");
    if (aj.cbv())
    {
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
    }
    AppMethodBeat.o(189202);
  }
  
  public final void unRegisterBroadcasts()
  {
    AppMethodBeat.i(189203);
    ad.i("MicroMsg.AudioBroadcastHelper", "unRegisterBroadcasts()");
    try
    {
      if (aj.cbv())
      {
        Object localObject1 = this.broadcastReceiverHashMap.get(BluetoothReceiver.class.getSimpleName());
        if (localObject1 != null) {
          break label77;
        }
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.audio.broadcast.bluetooth.BluetoothReceiver");
        AppMethodBeat.o(189203);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.AudioBroadcastHelper", "unRegisterBroadcasts() Exception = %s ", new Object[] { localException.getMessage() });
      AppMethodBeat.o(189203);
      return;
    }
    label77:
    unRegisterBroadcast((BroadcastReceiver)localException);
    Object localObject2 = this.broadcastReceiverHashMap.get(HeadsetPlugReceiver.class.getSimpleName());
    if (localObject2 == null)
    {
      localObject2 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.audio.broadcast.headset.HeadsetPlugReceiver");
      AppMethodBeat.o(189203);
      throw ((Throwable)localObject2);
    }
    unRegisterBroadcast((BroadcastReceiver)localObject2);
    localObject2 = this.broadcastReceiverHashMap.get(BaseAudioReceiver.class.getSimpleName());
    if (localObject2 == null)
    {
      localObject2 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.audio.broadcast.base.BaseAudioReceiver");
      AppMethodBeat.o(189203);
      throw ((Throwable)localObject2);
    }
    unRegisterBroadcast((BroadcastReceiver)localObject2);
    AppMethodBeat.o(189203);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper$Companion;", "", "()V", "TAG", "", "plugin-audio_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.a
 * JD-Core Version:    0.7.0.1
 */