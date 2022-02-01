package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public final class a
{
  public static final UUID nYA;
  public static final UUID nYB;
  public aq mHandler;
  public boolean mIsInit;
  public final BroadcastReceiver mReceiver;
  private Runnable mRunnable;
  public BluetoothAdapter nUZ;
  public HashMap<Long, b> nVF;
  public a nYC;
  public Context nYD;
  
  static
  {
    AppMethodBeat.i(22593);
    nYA = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    nYB = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    AppMethodBeat.o(22593);
  }
  
  public a(aq paramaq)
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
        ae.i("MicroMsg.exdevice.BluetoothChatManager", "------onReceive------ action  = ".concat(String.valueOf(paramAnonymousContext)));
        if ("android.bluetooth.device.action.FOUND".equals(paramAnonymousContext))
        {
          paramAnonymousContext = (BluetoothDevice)paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
          if (paramAnonymousContext.getBondState() != 12) {
            a.this.nYC.eJ(paramAnonymousContext.getAddress(), paramAnonymousContext.getName());
          }
          AppMethodBeat.o(22586);
          return;
        }
        if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(paramAnonymousContext))
        {
          a.this.nYC.bNF();
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
          if (!a.a(a.this).containsKey(Long.valueOf(com.tencent.mm.plugin.exdevice.k.b.adP(paramAnonymousIntent))))
          {
            AppMethodBeat.o(22586);
            return;
          }
          ae.i("MicroMsg.exdevice.BluetoothChatManager", "------ACTION_ACL_DISCONNECTED------ device name = %s, device Mac = %s", new Object[] { paramAnonymousContext.getName(), paramAnonymousIntent });
          if (a.this.nYC != null) {
            a.this.nYC.l(com.tencent.mm.plugin.exdevice.k.b.adP(paramAnonymousIntent), false);
          }
        }
        AppMethodBeat.o(22586);
      }
    };
    this.nVF = new HashMap();
    this.mHandler = new aq(paramaq.getSerialTag());
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
  
  private boolean bNO()
  {
    AppMethodBeat.i(22591);
    if (!this.nUZ.isDiscovering())
    {
      AppMethodBeat.o(22591);
      return true;
    }
    if (!this.nUZ.cancelDiscovery())
    {
      ae.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.cancelDiscovery Failed!!!");
      AppMethodBeat.o(22591);
      return false;
    }
    this.mHandler.removeCallbacks(this.mRunnable);
    AppMethodBeat.o(22591);
    return true;
  }
  
  public final boolean bNN()
  {
    AppMethodBeat.i(22590);
    Assert.assertTrue(this.mIsInit);
    if (this.nUZ == null)
    {
      AppMethodBeat.o(22590);
      return false;
    }
    AppMethodBeat.o(22590);
    return true;
  }
  
  public final boolean jh(boolean paramBoolean)
  {
    AppMethodBeat.i(22592);
    StringBuilder localStringBuilder = new StringBuilder("scanDevices");
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      ae.i("MicroMsg.exdevice.BluetoothChatManager", str);
      Assert.assertTrue(this.mIsInit);
      if (bNN()) {
        break;
      }
      ae.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
      AppMethodBeat.o(22592);
      return false;
    }
    if (paramBoolean)
    {
      if ((this.nUZ.isDiscovering()) && (!bNO()))
      {
        AppMethodBeat.o(22592);
        return false;
      }
      if (!this.nUZ.startDiscovery())
      {
        ae.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.startDiscovery() Failed");
        AppMethodBeat.o(22592);
        return false;
      }
      this.mHandler.postDelayed(this.mRunnable, 10000L);
      AppMethodBeat.o(22592);
      return true;
    }
    paramBoolean = bNO();
    AppMethodBeat.o(22592);
    return paramBoolean;
  }
  
  public static abstract class a
  {
    public void b(long paramLong, byte[] paramArrayOfByte) {}
    
    public void bNF() {}
    
    public void c(long paramLong, int paramInt, String paramString) {}
    
    public void eJ(String paramString1, String paramString2) {}
    
    public void i(long paramLong1, long paramLong2, long paramLong3) {}
    
    public void l(long paramLong, boolean paramBoolean) {}
    
    public void m(long paramLong, boolean paramBoolean) {}
  }
  
  public final class b
    implements Runnable
  {
    private long nVQ = 0L;
    private long nVR = 0L;
    
    public b(long paramLong1, long paramLong2)
    {
      this.nVQ = paramLong1;
      this.nVR = paramLong2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(22588);
      a locala = a.this;
      b localb1 = new b(this.nVQ);
      long l = localb1.mSessionId;
      b localb2 = (b)locala.nVF.remove(Long.valueOf(l));
      if (localb2 != null) {
        localb2.disconnect();
      }
      locala.nVF.put(Long.valueOf(l), localb1);
      if (a.this.nYC != null) {
        a.this.nYC.i(l, this.nVQ, this.nVR);
      }
      AppMethodBeat.o(22588);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.a
 * JD-Core Version:    0.7.0.1
 */