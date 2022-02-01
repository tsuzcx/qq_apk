package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public final class a
{
  public static final UUID nrY;
  public static final UUID nrZ;
  public ao mHandler;
  public boolean mIsInit;
  public final BroadcastReceiver mReceiver;
  private Runnable mRunnable;
  public BluetoothAdapter nox;
  public HashMap<Long, b> npd;
  public a nsa;
  public Context nsb;
  
  static
  {
    AppMethodBeat.i(22593);
    nrY = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    nrZ = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    AppMethodBeat.o(22593);
  }
  
  public a(ao paramao)
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
        ac.i("MicroMsg.exdevice.BluetoothChatManager", "------onReceive------ action  = ".concat(String.valueOf(paramAnonymousContext)));
        if ("android.bluetooth.device.action.FOUND".equals(paramAnonymousContext))
        {
          paramAnonymousContext = (BluetoothDevice)paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
          if (paramAnonymousContext.getBondState() != 12) {
            a.this.nsa.ex(paramAnonymousContext.getAddress(), paramAnonymousContext.getName());
          }
          AppMethodBeat.o(22586);
          return;
        }
        if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(paramAnonymousContext))
        {
          a.this.nsa.bIu();
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
          if (!a.a(a.this).containsKey(Long.valueOf(com.tencent.mm.plugin.exdevice.k.b.Zs(paramAnonymousIntent))))
          {
            AppMethodBeat.o(22586);
            return;
          }
          ac.i("MicroMsg.exdevice.BluetoothChatManager", "------ACTION_ACL_DISCONNECTED------ device name = %s, device Mac = %s", new Object[] { paramAnonymousContext.getName(), paramAnonymousIntent });
          if (a.this.nsa != null) {
            a.this.nsa.l(com.tencent.mm.plugin.exdevice.k.b.Zs(paramAnonymousIntent), false);
          }
        }
        AppMethodBeat.o(22586);
      }
    };
    this.npd = new HashMap();
    this.mHandler = new ao(paramao.getSerialTag());
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
  
  private boolean bID()
  {
    AppMethodBeat.i(22591);
    if (!this.nox.isDiscovering())
    {
      AppMethodBeat.o(22591);
      return true;
    }
    if (!this.nox.cancelDiscovery())
    {
      ac.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.cancelDiscovery Failed!!!");
      AppMethodBeat.o(22591);
      return false;
    }
    this.mHandler.removeCallbacks(this.mRunnable);
    AppMethodBeat.o(22591);
    return true;
  }
  
  public final boolean bIC()
  {
    AppMethodBeat.i(22590);
    Assert.assertTrue(this.mIsInit);
    if (this.nox == null)
    {
      AppMethodBeat.o(22590);
      return false;
    }
    AppMethodBeat.o(22590);
    return true;
  }
  
  public final boolean iZ(boolean paramBoolean)
  {
    AppMethodBeat.i(22592);
    StringBuilder localStringBuilder = new StringBuilder("scanDevices");
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      ac.i("MicroMsg.exdevice.BluetoothChatManager", str);
      Assert.assertTrue(this.mIsInit);
      if (bIC()) {
        break;
      }
      ac.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
      AppMethodBeat.o(22592);
      return false;
    }
    if (paramBoolean)
    {
      if ((this.nox.isDiscovering()) && (!bID()))
      {
        AppMethodBeat.o(22592);
        return false;
      }
      if (!this.nox.startDiscovery())
      {
        ac.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.startDiscovery() Failed");
        AppMethodBeat.o(22592);
        return false;
      }
      this.mHandler.postDelayed(this.mRunnable, 10000L);
      AppMethodBeat.o(22592);
      return true;
    }
    paramBoolean = bID();
    AppMethodBeat.o(22592);
    return paramBoolean;
  }
  
  public static abstract class a
  {
    public void b(long paramLong, byte[] paramArrayOfByte) {}
    
    public void bIu() {}
    
    public void c(long paramLong, int paramInt, String paramString) {}
    
    public void ex(String paramString1, String paramString2) {}
    
    public void i(long paramLong1, long paramLong2, long paramLong3) {}
    
    public void l(long paramLong, boolean paramBoolean) {}
    
    public void m(long paramLong, boolean paramBoolean) {}
  }
  
  public final class b
    implements Runnable
  {
    private long npo = 0L;
    private long npp = 0L;
    
    public b(long paramLong1, long paramLong2)
    {
      this.npo = paramLong1;
      this.npp = paramLong2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(22588);
      a locala = a.this;
      b localb1 = new b(this.npo);
      long l = localb1.mSessionId;
      b localb2 = (b)locala.npd.remove(Long.valueOf(l));
      if (localb2 != null) {
        localb2.disconnect();
      }
      locala.npd.put(Long.valueOf(l), localb1);
      if (a.this.nsa != null) {
        a.this.nsa.i(l, this.npo, this.npp);
      }
      AppMethodBeat.o(22588);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.a
 * JD-Core Version:    0.7.0.1
 */