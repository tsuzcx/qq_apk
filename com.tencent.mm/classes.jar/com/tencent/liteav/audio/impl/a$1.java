package com.tencent.liteav.audio.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

class a$1
  extends BroadcastReceiver
{
  a$1(a parama) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(66707);
    paramContext = paramIntent.getAction();
    TXCLog.i(a.a(this.a), "onReceive, action = ".concat(String.valueOf(paramContext)));
    if (paramContext.equals("android.intent.action.HEADSET_PLUG"))
    {
      a.a(this.a, paramIntent);
      AppMethodBeat.o(66707);
      return;
    }
    if (paramContext.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"))
    {
      int i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
      paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      a.a(this.a, i);
      AppMethodBeat.o(66707);
      return;
    }
    if (paramContext.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
      a.b(this.a, paramIntent);
    }
    AppMethodBeat.o(66707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.a.1
 * JD-Core Version:    0.7.0.1
 */