package com.tencent.liteav.audio.impl;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.basic.log.TXCLog;

class b$1
  extends BroadcastReceiver
{
  b$1(b paramb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
      if (paramIntent.hasExtra("state"))
      {
        if (paramIntent.getIntExtra("state", 0) != 0) {
          break label101;
        }
        if (c.a().f() == TXEAudioDef.TXE_AEC_SYSTEM) {
          break label75;
        }
        if (b.a(this.a) != null) {
          b.a(this.a).OnHeadsetState(false);
        }
      }
    }
    label75:
    label101:
    do
    {
      do
      {
        for (;;)
        {
          TXCLog.d(b.b(), "耳机拔出");
          return;
          if (b.a(this.a) != null) {
            b.a(this.a).OnHeadsetState(true);
          }
        }
      } while (1 != paramIntent.getIntExtra("state", 0));
      if (b.a(this.a) != null) {
        b.a(this.a).OnHeadsetState(true);
      }
      TXCLog.d(b.b(), "耳机插入");
      return;
      paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    } while ((paramContext == null) || (b.b(this.a) == null));
    try
    {
      Thread.sleep(500L);
      label174:
      b.a(this.a, paramContext);
      return;
    }
    catch (InterruptedException paramIntent)
    {
      break label174;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.b.1
 * JD-Core Version:    0.7.0.1
 */