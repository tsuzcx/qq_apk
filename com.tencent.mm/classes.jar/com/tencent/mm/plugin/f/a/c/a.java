package com.tencent.mm.plugin.f.a.c;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.HandlerThread;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public final class a
{
  public static final UUID hWQ = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
  public static final UUID hWR = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
  public HashMap<Long, b> hTU = new HashMap();
  public BluetoothAdapter hTo;
  public a.a hWS;
  public Context hWT;
  public final BroadcastReceiver hWU = new a.1(this);
  public ah mHandler;
  public boolean mIsInit = false;
  private Runnable mRunnable;
  
  public a(ai paramai)
  {
    this.mHandler = new ah(paramai.mnU.getLooper());
    this.mRunnable = new Runnable()
    {
      public final void run()
      {
        if (a.b(a.this).isDiscovering()) {
          a.b(a.this).cancelDiscovery();
        }
      }
    };
  }
  
  private boolean awA()
  {
    if (!this.hTo.isDiscovering()) {
      return true;
    }
    if (!this.hTo.cancelDiscovery())
    {
      y.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.cancelDiscovery Failed!!!");
      return false;
    }
    this.mHandler.removeCallbacks(this.mRunnable);
    return true;
  }
  
  public final boolean awz()
  {
    Assert.assertTrue(this.mIsInit);
    return this.hTo != null;
  }
  
  public final boolean ep(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("scanDevices");
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      y.i("MicroMsg.exdevice.BluetoothChatManager", str);
      Assert.assertTrue(this.mIsInit);
      if (awz()) {
        break;
      }
      y.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
      return false;
    }
    if (paramBoolean)
    {
      if ((this.hTo.isDiscovering()) && (!awA())) {
        return false;
      }
      if (!this.hTo.startDiscovery())
      {
        y.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.startDiscovery() Failed");
        return false;
      }
      this.mHandler.postDelayed(this.mRunnable, 10000L);
      return true;
    }
    return awA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.c.a
 * JD-Core Version:    0.7.0.1
 */