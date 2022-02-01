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
  public Context FZ;
  public ap mHandler;
  private ReentrantLock mLock;
  public final HashMap<Long, f> mMR;
  public c mMT;
  public c.a mMW;
  public HashSet<Long> mNA;
  final HashMap<Long, Boolean> mNB;
  public f.a mNC;
  a mNz;
  public Runnable mRunnable;
  
  public e(a parama)
  {
    AppMethodBeat.i(22523);
    this.FZ = null;
    this.mLock = new ReentrantLock();
    this.mHandler = null;
    this.mRunnable = null;
    this.mMW = new c.a()
    {
      public final void a(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22514);
        long l = b.Vg(paramAnonymousBluetoothDevice.getAddress());
        if (!e.this.mNA.contains(Long.valueOf(l)))
        {
          ad.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscover------ device Name = %s, mac = %s(%d), scanRecord = %s", new Object[] { paramAnonymousBluetoothDevice.getName(), paramAnonymousBluetoothDevice.getAddress(), Long.valueOf(l), b.be(paramAnonymousArrayOfByte) });
          e.this.mNA.add(Long.valueOf(l));
          if (com.tencent.mm.plugin.d.a.b.a.c.aI(paramAnonymousArrayOfByte)) {
            e.this.mNz.a(paramAnonymousBluetoothDevice.getAddress(), paramAnonymousBluetoothDevice.getName(), paramAnonymousInt, paramAnonymousArrayOfByte);
          }
        }
        AppMethodBeat.o(22514);
      }
      
      public final void bBw()
      {
        AppMethodBeat.i(22515);
        ad.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscoverFinished------");
        if (e.this.mNz != null) {
          e.this.mNz.bBw();
        }
        for (;;)
        {
          e.this.mNA.clear();
          AppMethodBeat.o(22515);
          return;
          ad.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no SimpleBLEManagerCallback");
        }
      }
    };
    this.mNA = new HashSet();
    this.mMR = new HashMap();
    this.mNB = new HashMap();
    this.mNC = new f.a()
    {
      public final void a(final long paramAnonymousLong1, boolean paramAnonymousBoolean, final long paramAnonymousLong2)
      {
        AppMethodBeat.i(22517);
        String str2 = b.pe(paramAnonymousLong1);
        if (paramAnonymousBoolean) {}
        for (String str1 = "true";; str1 = "false")
        {
          ad.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onConnected. mac = %s, connected = %s", new Object[] { str2, str1 });
          e.this.ac(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(22516);
              f localf = (f)e.this.mMR.get(Long.valueOf(paramAnonymousLong1));
              Boolean localBoolean = Boolean.FALSE;
              if (!paramAnonymousLong2) {}
              for (int i = 1; (localf != null) || (i != 0); i = 0)
              {
                if (e.this.mNz != null)
                {
                  e.this.mNz.a(paramAnonymousLong1, paramAnonymousLong2, this.mNF);
                  if (i != 0) {
                    ad.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnected, mBLEManagerCallback callback mac=%s", new Object[] { b.pe(paramAnonymousLong1) });
                  }
                }
                if (i == 0) {
                  break label214;
                }
                ad.d("MicroMsg.exdevice.BluetoothLESimpleManager", "remove seesion(mac=%s)", new Object[] { b.pe(paramAnonymousLong1) });
                e.this.mMR.remove(Long.valueOf(paramAnonymousLong1));
                e.this.mNB.remove(Long.valueOf(paramAnonymousLong1));
                AppMethodBeat.o(22516);
                return;
              }
              ad.e("MicroMsg.exdevice.BluetoothLESimpleManager", "no seesion(mac=%s) found", new Object[] { b.pe(paramAnonymousLong1) });
              label214:
              AppMethodBeat.o(22516);
            }
          });
          ad.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session size = %d", new Object[] { Integer.valueOf(e.this.mMR.size()) });
          AppMethodBeat.o(22517);
          return;
        }
      }
      
      public final void b(long paramAnonymousLong, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22518);
        ad.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onRecv. mac = %s", new Object[] { b.pe(paramAnonymousLong) });
        if (e.this.mNz != null)
        {
          e.this.mNz.b(paramAnonymousLong, paramAnonymousArrayOfByte);
          AppMethodBeat.o(22518);
          return;
        }
        ad.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no BLEManagerCallback");
        AppMethodBeat.o(22518);
      }
      
      public final void l(long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(22519);
        String str2 = b.pe(paramAnonymousLong);
        if (paramAnonymousBoolean) {}
        for (String str1 = "true";; str1 = "false")
        {
          ad.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onSend. mac = %s, success = %s", new Object[] { str2, str1 });
          if (e.this.mNz != null) {
            e.this.mNz.l(paramAnonymousLong, paramAnonymousBoolean);
          }
          AppMethodBeat.o(22519);
          return;
        }
      }
    };
    this.FZ = aj.getContext();
    this.mNz = parama;
    this.mMT = c.bBx();
    this.mRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22520);
        e.this.mMT.a(false, e.this.mMW);
        ad.i("MicroMsg.exdevice.BluetoothLESimpleManager", "Time out for discovering. Stop it");
        AppMethodBeat.o(22520);
      }
    };
    this.mHandler = new ap("BluetoothLESimpleManagerThread");
    AppMethodBeat.o(22523);
  }
  
  public final void ac(Runnable paramRunnable)
  {
    AppMethodBeat.i(22524);
    this.mLock.lock();
    paramRunnable.run();
    this.mLock.unlock();
    AppMethodBeat.o(22524);
  }
  
  @TargetApi(18)
  public final boolean bBv()
  {
    AppMethodBeat.i(22525);
    boolean bool = this.FZ.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    AppMethodBeat.o(22525);
    return bool;
  }
  
  public static abstract class a
  {
    public void a(long paramLong1, boolean paramBoolean, long paramLong2) {}
    
    public void a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte) {}
    
    public void b(long paramLong, byte[] paramArrayOfByte) {}
    
    public void bBw() {}
    
    public void l(long paramLong, boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.e
 * JD-Core Version:    0.7.0.1
 */