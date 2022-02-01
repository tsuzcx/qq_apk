package com.tencent.mm.plugin.findersdk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.audio.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "headsetStateChangeListener", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver$OnHeadsetStateChangeListener;", "isHeadsetOn", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "register", "stateChangeListener", "unRegister", "Companion", "OnHeadsetStateChangeListener", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HeadsetReceiver
  extends BroadcastReceiver
{
  public static final HeadsetReceiver.a Hdo;
  private HeadsetReceiver.b Hdp;
  
  static
  {
    AppMethodBeat.i(273721);
    Hdo = new HeadsetReceiver.a((byte)0);
    AppMethodBeat.o(273721);
  }
  
  public static boolean fsb()
  {
    AppMethodBeat.i(273715);
    Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    boolean bool1 = a.a.cTW().cTQ();
    localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    localObject = b.uVo;
    boolean bool2 = b.cTX();
    Log.i("HeadsetReceiver", "isHeadsetOn isHeadsetPlugged:" + bool1 + " isBluetoothOn:" + bool2);
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(273715);
      return true;
    }
    AppMethodBeat.o(273715);
    return false;
  }
  
  public final void a(Context paramContext, HeadsetReceiver.b paramb)
  {
    AppMethodBeat.i(273738);
    s.u(paramContext, "context");
    Log.i("HeadsetReceiver", s.X("register stateChangeListener：", paramb));
    this.Hdp = paramb;
    paramb = new IntentFilter();
    paramb.addAction("android.media.AUDIO_BECOMING_NOISY");
    paramContext.registerReceiver((BroadcastReceiver)this, paramb);
    paramb.addAction("android.intent.action.HEADSET_PLUG");
    paramContext.registerReceiver((BroadcastReceiver)this, paramb);
    paramb.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
    paramContext.registerReceiver((BroadcastReceiver)this, paramb);
    paramContext = this.Hdp;
    if (paramContext != null) {
      paramContext.sO(fsb());
    }
    AppMethodBeat.o(273738);
  }
  
  public final void hy(Context paramContext)
  {
    AppMethodBeat.i(273748);
    s.u(paramContext, "context");
    Log.i("HeadsetReceiver", "unRegister");
    try
    {
      paramContext.unregisterReceiver((BroadcastReceiver)this);
      this.Hdp = null;
      AppMethodBeat.o(273748);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.e("HeadsetReceiver", "unregisterReceiver(HeadsetPlugReceiver.this) error:%s", new Object[] { paramContext.getMessage() });
      }
    }
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(273731);
    s.u(paramContext, "context");
    s.u(paramIntent, "intent");
    Log.i("HeadsetReceiver", "headset onReceive %s  %d", new Object[] { paramIntent.getAction(), Integer.valueOf(paramIntent.getIntExtra("state", 0)) });
    paramContext = paramIntent.getAction();
    if (s.p("android.media.AUDIO_BECOMING_NOISY", paramContext))
    {
      Log.i("HeadsetReceiver", "headset onReceive 耳机断开");
      if (this.Hdp != null)
      {
        paramContext = this.Hdp;
        s.checkNotNull(paramContext);
        paramContext.sO(false);
      }
      AppMethodBeat.o(273731);
      return;
    }
    if ((paramIntent.getAction() != null) && (s.p(paramIntent.getAction(), "android.intent.action.HEADSET_PLUG")))
    {
      if (paramIntent.getIntExtra("state", -1) == 1)
      {
        Log.i("HeadsetReceiver", "headset onReceive 有线耳机连接");
        if (this.Hdp != null)
        {
          paramContext = this.Hdp;
          s.checkNotNull(paramContext);
          paramContext.sO(true);
        }
      }
      AppMethodBeat.o(273731);
      return;
    }
    if ((TextUtils.equals((CharSequence)paramContext, (CharSequence)"android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) && (paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1) == 2))
    {
      Log.i("HeadsetReceiver", "headset onReceive 蓝牙耳机连接");
      if (this.Hdp != null)
      {
        paramContext = this.Hdp;
        s.checkNotNull(paramContext);
        paramContext.sO(true);
      }
    }
    AppMethodBeat.o(273731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver
 * JD-Core Version:    0.7.0.1
 */