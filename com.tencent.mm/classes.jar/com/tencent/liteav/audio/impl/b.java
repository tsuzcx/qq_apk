package com.tencent.liteav.audio.impl;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.basic.log.TXCLog;

public class b
{
  private static final String a = b.class.getSimpleName();
  private Context b;
  private BroadcastReceiver c;
  private boolean d = false;
  private BluetoothHeadset e;
  private BluetoothProfile.ServiceListener f;
  private d g;
  
  public b(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.c = new b.1(this);
    this.f = new b.2(this);
    boolean bool = ((AudioManager)this.b.getSystemService("audio")).isWiredHeadsetOn();
    if (this.g != null) {
      this.g.OnHeadsetState(bool);
    }
    this.d = false;
  }
  
  private void a(BluetoothDevice paramBluetoothDevice)
  {
    if ((paramBluetoothDevice == null) || (this.e == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        i = this.e.getConnectionState(paramBluetoothDevice);
        TXCLog.d(a, "蓝牙耳机状态：" + i);
        switch (i)
        {
        case 1: 
        default: 
          return;
        case 0: 
          if (c.a().f() != TXEAudioDef.TXE_AEC_SYSTEM)
          {
            if (this.g != null) {
              this.g.OnHeadsetState(false);
            }
            TXCLog.d(a, "蓝牙耳机拔出");
            return;
          }
          break;
        }
      }
      catch (Exception paramBluetoothDevice)
      {
        TXCLog.e(a, "getConnectionState exception: " + paramBluetoothDevice);
        int i = 0;
        continue;
        if (this.g != null) {
          this.g.OnHeadsetState(true);
        }
        TXCLog.d(a, "蓝牙耳机插入");
        return;
      }
      if (this.g != null) {
        this.g.OnHeadsetState(true);
      }
    }
  }
  
  public void a()
  {
    this.g = null;
    if (!this.d) {
      TXCLog.w(a, " invalid unregister headset, ignore");
    }
    for (;;)
    {
      return;
      this.d = false;
      this.b.unregisterReceiver(this.c);
      try
      {
        BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (localBluetoothAdapter != null)
        {
          localBluetoothAdapter.closeProfileProxy(1, this.e);
          return;
        }
      }
      catch (Exception localException)
      {
        TXCLog.e(a, "BluetoothAdapter closeProfileProxy: " + localException);
      }
    }
  }
  
  public void a(d paramd)
  {
    this.g = paramd;
    if (this.d)
    {
      TXCLog.w(a, " repeate register headset, ignore");
      return;
    }
    paramd = new IntentFilter();
    paramd.addAction("android.intent.action.HEADSET_PLUG");
    paramd.addAction("android.bluetooth.device.action.ACL_CONNECTED");
    paramd.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
    paramd.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    this.b.registerReceiver(this.c, paramd);
    try
    {
      paramd = BluetoothAdapter.getDefaultAdapter();
      if (paramd != null) {
        paramd.getProfileProxy(this.b, this.f, 1);
      }
    }
    catch (Exception paramd)
    {
      for (;;)
      {
        TXCLog.e(a, "BluetoothAdapter getProfileProxy: " + paramd);
      }
    }
    this.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.b
 * JD-Core Version:    0.7.0.1
 */