package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public final class a
{
  public static final UUID pjy;
  public static final UUID pjz;
  public MMHandler mHandler;
  public boolean mIsInit;
  public final BroadcastReceiver mReceiver;
  private Runnable mRunnable;
  public BluetoothAdapter pfW;
  public HashMap<Long, b> pgC;
  public a pjA;
  public Context pjB;
  
  static
  {
    AppMethodBeat.i(22593);
    pjy = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    pjz = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    AppMethodBeat.o(22593);
  }
  
  public a(MMHandler paramMMHandler)
  {
    AppMethodBeat.i(179583);
    this.mIsInit = false;
    this.mReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(22586);
        if (paramAnonymousIntent == null)
        {
          AppMethodBeat.o(22586);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getAction();
        Log.i("MicroMsg.exdevice.BluetoothChatManager", "------onReceive------ action  = ".concat(String.valueOf(paramAnonymousContext)));
        if ("android.bluetooth.device.action.FOUND".equals(paramAnonymousContext))
        {
          paramAnonymousContext = (BluetoothDevice)paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
          if (paramAnonymousContext.getBondState() != 12) {
            a.this.pjA.fb(paramAnonymousContext.getAddress(), paramAnonymousContext.getName());
          }
          AppMethodBeat.o(22586);
          return;
        }
        if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(paramAnonymousContext))
        {
          a.this.pjA.ckF();
          AppMethodBeat.o(22586);
          return;
        }
        if ("android.bluetooth.adapter.action.SCAN_MODE_CHANGED".equals(paramAnonymousContext))
        {
          paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.SCAN_MODE", -1);
          AppMethodBeat.o(22586);
          return;
        }
        if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(paramAnonymousContext))
        {
          paramAnonymousContext = (BluetoothDevice)paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
          paramAnonymousIntent = paramAnonymousContext.getAddress();
          if (!a.a(a.this).containsKey(Long.valueOf(com.tencent.mm.plugin.exdevice.k.b.anY(paramAnonymousIntent))))
          {
            AppMethodBeat.o(22586);
            return;
          }
          Log.i("MicroMsg.exdevice.BluetoothChatManager", "------ACTION_ACL_DISCONNECTED------ device name = %s, device Mac = %s", new Object[] { paramAnonymousContext.getName(), paramAnonymousIntent });
          if (a.this.pjA != null) {
            a.this.pjA.l(com.tencent.mm.plugin.exdevice.k.b.anY(paramAnonymousIntent), false);
          }
        }
        AppMethodBeat.o(22586);
      }
    };
    this.pgC = new HashMap();
    this.mHandler = new MMHandler(paramMMHandler.getSerialTag());
    this.mRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22587);
        if (a.b(a.this).isDiscovering()) {
          a.b(a.this).cancelDiscovery();
        }
        AppMethodBeat.o(22587);
      }
    };
    AppMethodBeat.o(179583);
  }
  
  private boolean ckO()
  {
    AppMethodBeat.i(22591);
    if (!this.pfW.isDiscovering())
    {
      AppMethodBeat.o(22591);
      return true;
    }
    if (!this.pfW.cancelDiscovery())
    {
      Log.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.cancelDiscovery Failed!!!");
      AppMethodBeat.o(22591);
      return false;
    }
    this.mHandler.removeCallbacks(this.mRunnable);
    AppMethodBeat.o(22591);
    return true;
  }
  
  public final boolean ckN()
  {
    AppMethodBeat.i(22590);
    Assert.assertTrue(this.mIsInit);
    if (this.pfW == null)
    {
      AppMethodBeat.o(22590);
      return false;
    }
    AppMethodBeat.o(22590);
    return true;
  }
  
  public final boolean kg(boolean paramBoolean)
  {
    AppMethodBeat.i(22592);
    StringBuilder localStringBuilder = new StringBuilder("scanDevices");
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      Log.i("MicroMsg.exdevice.BluetoothChatManager", str);
      Assert.assertTrue(this.mIsInit);
      if (ckN()) {
        break;
      }
      Log.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
      AppMethodBeat.o(22592);
      return false;
    }
    if (paramBoolean)
    {
      if ((this.pfW.isDiscovering()) && (!ckO()))
      {
        AppMethodBeat.o(22592);
        return false;
      }
      Log.i("MicroMsg.exdevice.BluetoothChatManager", "[BluetoothTrace] start scan");
      Log.printErrStackTrace("MicroMsg.exdevice.BluetoothChatManager", new Throwable(), "[BluetoothTrace] startDiscovery stacktrace", new Object[0]);
      if (!this.pfW.startDiscovery())
      {
        Log.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.startDiscovery() Failed");
        AppMethodBeat.o(22592);
        return false;
      }
      this.mHandler.postDelayed(this.mRunnable, 10000L);
      AppMethodBeat.o(22592);
      return true;
    }
    paramBoolean = ckO();
    AppMethodBeat.o(22592);
    return paramBoolean;
  }
  
  public static abstract class a
  {
    public void b(long paramLong, byte[] paramArrayOfByte) {}
    
    public void c(long paramLong, int paramInt, String paramString) {}
    
    public void ckF() {}
    
    public void fb(String paramString1, String paramString2) {}
    
    public void i(long paramLong1, long paramLong2, long paramLong3) {}
    
    public void l(long paramLong, boolean paramBoolean) {}
    
    public void m(long paramLong, boolean paramBoolean) {}
  }
  
  public final class b
    implements Runnable
  {
    private long pgN = 0L;
    private long pgO = 0L;
    
    public b(long paramLong1, long paramLong2)
    {
      this.pgN = paramLong1;
      this.pgO = paramLong2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(22588);
      a locala = a.this;
      b localb1 = new b(this.pgN);
      long l = localb1.mSessionId;
      b localb2 = (b)locala.pgC.remove(Long.valueOf(l));
      if (localb2 != null) {
        localb2.disconnect();
      }
      locala.pgC.put(Long.valueOf(l), localb1);
      if (a.this.pjA != null) {
        a.this.pjA.i(l, this.pgN, this.pgO);
      }
      AppMethodBeat.o(22588);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.a
 * JD-Core Version:    0.7.0.1
 */