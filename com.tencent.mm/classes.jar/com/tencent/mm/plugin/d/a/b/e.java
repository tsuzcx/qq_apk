package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(18)
public final class e
{
  public Context IR;
  public ap mHandler;
  private ReentrantLock mLock;
  public Runnable mRunnable;
  public final HashMap<Long, f> nPZ;
  a nQH;
  public HashSet<Long> nQI;
  final HashMap<Long, Boolean> nQJ;
  public f.a nQK;
  public c nQb;
  public c.a nQe;
  
  public e(a parama)
  {
    AppMethodBeat.i(22523);
    this.IR = null;
    this.mLock = new ReentrantLock();
    this.mHandler = null;
    this.mRunnable = null;
    this.nQe = new c.a()
    {
      public final void a(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22514);
        long l = b.acY(paramAnonymousBluetoothDevice.getAddress());
        if (!e.this.nQI.contains(Long.valueOf(l)))
        {
          ad.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscover------ device Name = %s, mac = %s(%d), scanRecord = %s", new Object[] { paramAnonymousBluetoothDevice.getName(), paramAnonymousBluetoothDevice.getAddress(), Long.valueOf(l), b.bg(paramAnonymousArrayOfByte) });
          e.this.nQI.add(Long.valueOf(l));
          if (com.tencent.mm.plugin.d.a.b.a.c.aH(paramAnonymousArrayOfByte)) {
            e.this.nQH.a(paramAnonymousBluetoothDevice.getAddress(), paramAnonymousBluetoothDevice.getName(), paramAnonymousInt, paramAnonymousArrayOfByte);
          }
        }
        AppMethodBeat.o(22514);
      }
      
      public final void bMH()
      {
        AppMethodBeat.i(22515);
        ad.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscoverFinished------");
        if (e.this.nQH != null) {
          e.this.nQH.bMH();
        }
        for (;;)
        {
          e.this.nQI.clear();
          AppMethodBeat.o(22515);
          return;
          ad.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no SimpleBLEManagerCallback");
        }
      }
    };
    this.nQI = new HashSet();
    this.nPZ = new HashMap();
    this.nQJ = new HashMap();
    this.nQK = new f.a()
    {
      public final void a(final long paramAnonymousLong1, boolean paramAnonymousBoolean, final long paramAnonymousLong2)
      {
        AppMethodBeat.i(22517);
        String str2 = b.uO(paramAnonymousLong1);
        if (paramAnonymousBoolean) {}
        for (String str1 = "true";; str1 = "false")
        {
          ad.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onConnected. mac = %s, connected = %s", new Object[] { str2, str1 });
          e.this.ad(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(22516);
              f localf = (f)e.this.nPZ.get(Long.valueOf(paramAnonymousLong1));
              Boolean localBoolean = Boolean.FALSE;
              if (!paramAnonymousLong2) {}
              for (int i = 1; (localf != null) || (i != 0); i = 0)
              {
                if (e.this.nQH != null)
                {
                  e.this.nQH.a(paramAnonymousLong1, paramAnonymousLong2, this.nQN);
                  if (i != 0) {
                    ad.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnected, mBLEManagerCallback callback mac=%s", new Object[] { b.uO(paramAnonymousLong1) });
                  }
                }
                if (i == 0) {
                  break label214;
                }
                ad.d("MicroMsg.exdevice.BluetoothLESimpleManager", "remove seesion(mac=%s)", new Object[] { b.uO(paramAnonymousLong1) });
                e.this.nPZ.remove(Long.valueOf(paramAnonymousLong1));
                e.this.nQJ.remove(Long.valueOf(paramAnonymousLong1));
                AppMethodBeat.o(22516);
                return;
              }
              ad.e("MicroMsg.exdevice.BluetoothLESimpleManager", "no seesion(mac=%s) found", new Object[] { b.uO(paramAnonymousLong1) });
              label214:
              AppMethodBeat.o(22516);
            }
          });
          ad.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session size = %d", new Object[] { Integer.valueOf(e.this.nPZ.size()) });
          AppMethodBeat.o(22517);
          return;
        }
      }
      
      public final void b(long paramAnonymousLong, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22518);
        ad.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onRecv. mac = %s", new Object[] { b.uO(paramAnonymousLong) });
        if (e.this.nQH != null)
        {
          e.this.nQH.b(paramAnonymousLong, paramAnonymousArrayOfByte);
          AppMethodBeat.o(22518);
          return;
        }
        ad.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no BLEManagerCallback");
        AppMethodBeat.o(22518);
      }
      
      public final void m(long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(22519);
        String str2 = b.uO(paramAnonymousLong);
        if (paramAnonymousBoolean) {}
        for (String str1 = "true";; str1 = "false")
        {
          ad.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onSend. mac = %s, success = %s", new Object[] { str2, str1 });
          if (e.this.nQH != null) {
            e.this.nQH.m(paramAnonymousLong, paramAnonymousBoolean);
          }
          AppMethodBeat.o(22519);
          return;
        }
      }
    };
    this.IR = aj.getContext();
    this.nQH = parama;
    this.nQb = c.bMI();
    this.mRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22520);
        e.this.nQb.a(false, e.this.nQe);
        ad.i("MicroMsg.exdevice.BluetoothLESimpleManager", "Time out for discovering. Stop it");
        AppMethodBeat.o(22520);
      }
    };
    this.mHandler = new ap("BluetoothLESimpleManagerThread");
    AppMethodBeat.o(22523);
  }
  
  public final void ad(Runnable paramRunnable)
  {
    AppMethodBeat.i(22524);
    this.mLock.lock();
    paramRunnable.run();
    this.mLock.unlock();
    AppMethodBeat.o(22524);
  }
  
  @TargetApi(18)
  public final boolean bMG()
  {
    AppMethodBeat.i(22525);
    boolean bool = this.IR.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    AppMethodBeat.o(22525);
    return bool;
  }
  
  public static abstract class a
  {
    public void a(long paramLong1, boolean paramBoolean, long paramLong2) {}
    
    public void a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte) {}
    
    public void b(long paramLong, byte[] paramArrayOfByte) {}
    
    public void bMH() {}
    
    public void m(long paramLong, boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.e
 * JD-Core Version:    0.7.0.1
 */