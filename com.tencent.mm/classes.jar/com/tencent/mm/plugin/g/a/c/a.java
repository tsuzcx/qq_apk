package com.tencent.mm.plugin.g.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

public final class a
{
  public static final UUID vxG;
  public static final UUID vxH;
  public MMHandler mHandler;
  public boolean mIsInit;
  public final BroadcastReceiver mReceiver;
  private Runnable mRunnable;
  public HashMap<Long, b> vuM;
  public BluetoothAdapter vug;
  public a vxI;
  public Context vxJ;
  
  static
  {
    AppMethodBeat.i(22593);
    vxG = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    vxH = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
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
            a.this.vxI.fG(paramAnonymousContext.getAddress(), paramAnonymousContext.getName());
          }
          AppMethodBeat.o(22586);
          return;
        }
        if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(paramAnonymousContext))
        {
          a.this.vxI.daR();
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
          if (!a.a(a.this).containsKey(Long.valueOf(com.tencent.mm.plugin.exdevice.k.b.apW(paramAnonymousIntent))))
          {
            AppMethodBeat.o(22586);
            return;
          }
          Log.i("MicroMsg.exdevice.BluetoothChatManager", "------ACTION_ACL_DISCONNECTED------ device name = %s, device Mac = %s", new Object[] { paramAnonymousContext.getName(), paramAnonymousIntent });
          if (a.this.vxI != null) {
            a.this.vxI.r(com.tencent.mm.plugin.exdevice.k.b.apW(paramAnonymousIntent), false);
          }
        }
        AppMethodBeat.o(22586);
      }
    };
    this.vuM = new HashMap();
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
  
  private boolean dba()
  {
    AppMethodBeat.i(22591);
    if (!this.vug.isDiscovering())
    {
      AppMethodBeat.o(22591);
      return true;
    }
    if (!this.vug.cancelDiscovery())
    {
      Log.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.cancelDiscovery Failed!!!");
      AppMethodBeat.o(22591);
      return false;
    }
    this.mHandler.removeCallbacks(this.mRunnable);
    AppMethodBeat.o(22591);
    return true;
  }
  
  public final boolean daZ()
  {
    AppMethodBeat.i(22590);
    Assert.assertTrue(this.mIsInit);
    if (this.vug == null)
    {
      AppMethodBeat.o(22590);
      return false;
    }
    AppMethodBeat.o(22590);
    return true;
  }
  
  public final boolean mJ(boolean paramBoolean)
  {
    AppMethodBeat.i(22592);
    StringBuilder localStringBuilder = new StringBuilder("scanDevices");
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      Log.i("MicroMsg.exdevice.BluetoothChatManager", str);
      Assert.assertTrue(this.mIsInit);
      if (daZ()) {
        break;
      }
      Log.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
      AppMethodBeat.o(22592);
      return false;
    }
    if (paramBoolean)
    {
      if ((this.vug.isDiscovering()) && (!dba()))
      {
        AppMethodBeat.o(22592);
        return false;
      }
      Log.i("MicroMsg.exdevice.BluetoothChatManager", "[BluetoothTrace] start scan");
      Log.printErrStackTrace("MicroMsg.exdevice.BluetoothChatManager", new Throwable(), "[BluetoothTrace] startDiscovery stacktrace", new Object[0]);
      if (!((Boolean)com.tencent.mm.hellhoundlib.a.a.a(this.vug, "com/tencent/mm/plugin/bluetooth/sdk/classic/BluetoothChatManager", "scanDevices", "(Z)Z", "android/bluetooth/BluetoothAdapter", "startDiscovery", "()Z")).booleanValue())
      {
        Log.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.startDiscovery() Failed");
        AppMethodBeat.o(22592);
        return false;
      }
      this.mHandler.postDelayed(this.mRunnable, 10000L);
      AppMethodBeat.o(22592);
      return true;
    }
    paramBoolean = dba();
    AppMethodBeat.o(22592);
    return paramBoolean;
  }
  
  public static abstract class a
  {
    public void c(long paramLong, int paramInt, String paramString) {}
    
    public void c(long paramLong, byte[] paramArrayOfByte) {}
    
    public void daR() {}
    
    public void fG(String paramString1, String paramString2) {}
    
    public void k(long paramLong1, long paramLong2, long paramLong3) {}
    
    public void r(long paramLong, boolean paramBoolean) {}
    
    public void s(long paramLong, boolean paramBoolean) {}
  }
  
  public final class b
    implements Runnable
  {
    private long vuX = 0L;
    private long vuY = 0L;
    
    public b(long paramLong1, long paramLong2)
    {
      this.vuX = paramLong1;
      this.vuY = paramLong2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(22588);
      a locala = a.this;
      b localb1 = new b(this.vuX);
      long l = localb1.mSessionId;
      b localb2 = (b)locala.vuM.remove(Long.valueOf(l));
      if (localb2 != null) {
        localb2.disconnect();
      }
      locala.vuM.put(Long.valueOf(l), localb1);
      if (a.this.vxI != null) {
        a.this.vxI.k(l, this.vuX, this.vuY);
      }
      AppMethodBeat.o(22588);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.c.a
 * JD-Core Version:    0.7.0.1
 */