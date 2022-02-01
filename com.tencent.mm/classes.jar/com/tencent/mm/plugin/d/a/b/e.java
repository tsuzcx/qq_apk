package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(18)
public final class e
{
  public Context GX;
  public ao mHandler;
  private ReentrantLock mLock;
  public Runnable mRunnable;
  a npL;
  public HashSet<Long> npM;
  final HashMap<Long, Boolean> npN;
  public f.a npO;
  public final HashMap<Long, f> npd;
  public c npf;
  public c.a npi;
  
  public e(a parama)
  {
    AppMethodBeat.i(22523);
    this.GX = null;
    this.mLock = new ReentrantLock();
    this.mHandler = null;
    this.mRunnable = null;
    this.npi = new c.a()
    {
      public final void a(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22514);
        long l = b.Zs(paramAnonymousBluetoothDevice.getAddress());
        if (!e.this.npM.contains(Long.valueOf(l)))
        {
          ac.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscover------ device Name = %s, mac = %s(%d), scanRecord = %s", new Object[] { paramAnonymousBluetoothDevice.getName(), paramAnonymousBluetoothDevice.getAddress(), Long.valueOf(l), b.bd(paramAnonymousArrayOfByte) });
          e.this.npM.add(Long.valueOf(l));
          if (com.tencent.mm.plugin.d.a.b.a.c.aH(paramAnonymousArrayOfByte)) {
            e.this.npL.a(paramAnonymousBluetoothDevice.getAddress(), paramAnonymousBluetoothDevice.getName(), paramAnonymousInt, paramAnonymousArrayOfByte);
          }
        }
        AppMethodBeat.o(22514);
      }
      
      public final void bIu()
      {
        AppMethodBeat.i(22515);
        ac.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscoverFinished------");
        if (e.this.npL != null) {
          e.this.npL.bIu();
        }
        for (;;)
        {
          e.this.npM.clear();
          AppMethodBeat.o(22515);
          return;
          ac.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no SimpleBLEManagerCallback");
        }
      }
    };
    this.npM = new HashSet();
    this.npd = new HashMap();
    this.npN = new HashMap();
    this.npO = new f.a()
    {
      public final void a(final long paramAnonymousLong1, boolean paramAnonymousBoolean, final long paramAnonymousLong2)
      {
        AppMethodBeat.i(22517);
        String str2 = b.sQ(paramAnonymousLong1);
        if (paramAnonymousBoolean) {}
        for (String str1 = "true";; str1 = "false")
        {
          ac.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onConnected. mac = %s, connected = %s", new Object[] { str2, str1 });
          e.this.ae(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(22516);
              f localf = (f)e.this.npd.get(Long.valueOf(paramAnonymousLong1));
              Boolean localBoolean = Boolean.FALSE;
              if (!paramAnonymousLong2) {}
              for (int i = 1; (localf != null) || (i != 0); i = 0)
              {
                if (e.this.npL != null)
                {
                  e.this.npL.a(paramAnonymousLong1, paramAnonymousLong2, this.npR);
                  if (i != 0) {
                    ac.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnected, mBLEManagerCallback callback mac=%s", new Object[] { b.sQ(paramAnonymousLong1) });
                  }
                }
                if (i == 0) {
                  break label214;
                }
                ac.d("MicroMsg.exdevice.BluetoothLESimpleManager", "remove seesion(mac=%s)", new Object[] { b.sQ(paramAnonymousLong1) });
                e.this.npd.remove(Long.valueOf(paramAnonymousLong1));
                e.this.npN.remove(Long.valueOf(paramAnonymousLong1));
                AppMethodBeat.o(22516);
                return;
              }
              ac.e("MicroMsg.exdevice.BluetoothLESimpleManager", "no seesion(mac=%s) found", new Object[] { b.sQ(paramAnonymousLong1) });
              label214:
              AppMethodBeat.o(22516);
            }
          });
          ac.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session size = %d", new Object[] { Integer.valueOf(e.this.npd.size()) });
          AppMethodBeat.o(22517);
          return;
        }
      }
      
      public final void b(long paramAnonymousLong, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22518);
        ac.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onRecv. mac = %s", new Object[] { b.sQ(paramAnonymousLong) });
        if (e.this.npL != null)
        {
          e.this.npL.b(paramAnonymousLong, paramAnonymousArrayOfByte);
          AppMethodBeat.o(22518);
          return;
        }
        ac.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no BLEManagerCallback");
        AppMethodBeat.o(22518);
      }
      
      public final void m(long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(22519);
        String str2 = b.sQ(paramAnonymousLong);
        if (paramAnonymousBoolean) {}
        for (String str1 = "true";; str1 = "false")
        {
          ac.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onSend. mac = %s, success = %s", new Object[] { str2, str1 });
          if (e.this.npL != null) {
            e.this.npL.m(paramAnonymousLong, paramAnonymousBoolean);
          }
          AppMethodBeat.o(22519);
          return;
        }
      }
    };
    this.GX = ai.getContext();
    this.npL = parama;
    this.npf = c.bIv();
    this.mRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22520);
        e.this.npf.a(false, e.this.npi);
        ac.i("MicroMsg.exdevice.BluetoothLESimpleManager", "Time out for discovering. Stop it");
        AppMethodBeat.o(22520);
      }
    };
    this.mHandler = new ao("BluetoothLESimpleManagerThread");
    AppMethodBeat.o(22523);
  }
  
  public final void ae(Runnable paramRunnable)
  {
    AppMethodBeat.i(22524);
    this.mLock.lock();
    paramRunnable.run();
    this.mLock.unlock();
    AppMethodBeat.o(22524);
  }
  
  @TargetApi(18)
  public final boolean bIt()
  {
    AppMethodBeat.i(22525);
    boolean bool = this.GX.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    AppMethodBeat.o(22525);
    return bool;
  }
  
  public static abstract class a
  {
    public void a(long paramLong1, boolean paramBoolean, long paramLong2) {}
    
    public void a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte) {}
    
    public void b(long paramLong, byte[] paramArrayOfByte) {}
    
    public void bIu() {}
    
    public void m(long paramLong, boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.e
 * JD-Core Version:    0.7.0.1
 */