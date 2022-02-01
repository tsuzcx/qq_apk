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
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "headsetStateChangeListener", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver$OnHeadsetStateChangeListener;", "isHeadsetOn", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "register", "stateChangeListener", "unRegister", "Companion", "OnHeadsetStateChangeListener", "finder-sdk_release"})
public final class HeadsetReceiver
  extends BroadcastReceiver
{
  public static final HeadsetReceiver.a Bwf;
  private HeadsetReceiver.b Bwe;
  
  static
  {
    AppMethodBeat.i(207994);
    Bwf = new HeadsetReceiver.a((byte)0);
    AppMethodBeat.o(207994);
  }
  
  public static boolean enr()
  {
    AppMethodBeat.i(207993);
    Object localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    boolean bool1 = a.a.crn().crh();
    localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    localObject = b.rKe;
    boolean bool2 = b.cro();
    Log.i("HeadsetReceiver", "isHeadsetOn isHeadsetPlugged:" + bool1 + " isBluetoothOn:" + bool2);
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(207993);
      return true;
    }
    AppMethodBeat.o(207993);
    return false;
  }
  
  public final void a(Context paramContext, HeadsetReceiver.b paramb)
  {
    AppMethodBeat.i(207991);
    p.k(paramContext, "context");
    Log.i("HeadsetReceiver", "register stateChangeListener：".concat(String.valueOf(paramb)));
    this.Bwe = paramb;
    paramb = new IntentFilter();
    paramb.addAction("android.media.AUDIO_BECOMING_NOISY");
    paramContext.registerReceiver((BroadcastReceiver)this, paramb);
    paramb.addAction("android.intent.action.HEADSET_PLUG");
    paramContext.registerReceiver((BroadcastReceiver)this, paramb);
    paramb.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
    paramContext.registerReceiver((BroadcastReceiver)this, paramb);
    paramContext = this.Bwe;
    if (paramContext != null)
    {
      paramContext.pR(enr());
      AppMethodBeat.o(207991);
      return;
    }
    AppMethodBeat.o(207991);
  }
  
  public final void gd(Context paramContext)
  {
    AppMethodBeat.i(207992);
    p.k(paramContext, "context");
    Log.i("HeadsetReceiver", "unRegister");
    try
    {
      paramContext.unregisterReceiver((BroadcastReceiver)this);
      this.Bwe = null;
      AppMethodBeat.o(207992);
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
    AppMethodBeat.i(207990);
    p.k(paramContext, "context");
    p.k(paramIntent, "intent");
    Log.i("HeadsetReceiver", "headset onReceive %s  %d", new Object[] { paramIntent.getAction(), Integer.valueOf(paramIntent.getIntExtra("state", 0)) });
    paramContext = paramIntent.getAction();
    if (p.h("android.media.AUDIO_BECOMING_NOISY", paramContext))
    {
      Log.i("HeadsetReceiver", "headset onReceive 耳机断开");
      if (this.Bwe != null)
      {
        paramContext = this.Bwe;
        if (paramContext == null) {
          p.iCn();
        }
        paramContext.pR(false);
      }
      AppMethodBeat.o(207990);
      return;
    }
    if ((paramIntent.getAction() != null) && (p.h(paramIntent.getAction(), "android.intent.action.HEADSET_PLUG")))
    {
      switch (paramIntent.getIntExtra("state", -1))
      {
      }
      for (;;)
      {
        AppMethodBeat.o(207990);
        return;
        Log.i("HeadsetReceiver", "headset onReceive 有线耳机连接");
        if (this.Bwe != null)
        {
          paramContext = this.Bwe;
          if (paramContext == null) {
            p.iCn();
          }
          paramContext.pR(true);
        }
      }
    }
    if (TextUtils.equals((CharSequence)paramContext, (CharSequence)"android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
      switch (paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1))
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(207990);
      return;
      Log.i("HeadsetReceiver", "headset onReceive 蓝牙耳机连接");
      if (this.Bwe != null)
      {
        paramContext = this.Bwe;
        if (paramContext == null) {
          p.iCn();
        }
        paramContext.pR(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver
 * JD-Core Version:    0.7.0.1
 */