package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(18)
public final class e
{
  public Context mAppContext;
  public MMHandler mHandler;
  private ReentrantLock mLock;
  public Runnable mRunnable;
  public final HashMap<Long, f> pgC;
  public c pgE;
  public c.a pgH;
  a phj;
  public HashSet<Long> phk;
  final HashMap<Long, Boolean> phl;
  public f.a phm;
  
  public e(a parama)
  {
    AppMethodBeat.i(22523);
    this.mAppContext = null;
    this.mLock = new ReentrantLock();
    this.mHandler = null;
    this.mRunnable = null;
    this.pgH = new c.a()
    {
      public final void a(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22514);
        long l = b.anY(paramAnonymousBluetoothDevice.getAddress());
        if (!e.this.phk.contains(Long.valueOf(l)))
        {
          Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscover------ device Name = %s, mac = %s(%d), scanRecord = %s", new Object[] { paramAnonymousBluetoothDevice.getName(), paramAnonymousBluetoothDevice.getAddress(), Long.valueOf(l), b.bw(paramAnonymousArrayOfByte) });
          e.this.phk.add(Long.valueOf(l));
          if (com.tencent.mm.plugin.d.a.b.a.c.aY(paramAnonymousArrayOfByte)) {
            e.this.phj.a(paramAnonymousBluetoothDevice.getAddress(), paramAnonymousBluetoothDevice.getName(), paramAnonymousInt, paramAnonymousArrayOfByte);
          }
        }
        AppMethodBeat.o(22514);
      }
      
      public final void ckF()
      {
        AppMethodBeat.i(22515);
        Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscoverFinished------");
        if (e.this.phj != null) {
          e.this.phj.ckF();
        }
        for (;;)
        {
          e.this.phk.clear();
          AppMethodBeat.o(22515);
          return;
          Log.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no SimpleBLEManagerCallback");
        }
      }
    };
    this.phk = new HashSet();
    this.pgC = new HashMap();
    this.phl = new HashMap();
    this.phm = new f.a()
    {
      public final void a(final long paramAnonymousLong1, boolean paramAnonymousBoolean, final long paramAnonymousLong2)
      {
        AppMethodBeat.i(22517);
        String str2 = b.Dj(paramAnonymousLong1);
        if (paramAnonymousBoolean) {}
        for (String str1 = "true";; str1 = "false")
        {
          Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onConnected. mac = %s, connected = %s", new Object[] { str2, str1 });
          e.this.ai(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(22516);
              f localf = (f)e.this.pgC.get(Long.valueOf(paramAnonymousLong1));
              Boolean localBoolean = Boolean.FALSE;
              if (!paramAnonymousLong2) {}
              for (int i = 1; (localf != null) || (i != 0); i = 0)
              {
                if (e.this.phj != null)
                {
                  e.this.phj.a(paramAnonymousLong1, paramAnonymousLong2, this.php);
                  if (i != 0) {
                    Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnected, mBLEManagerCallback callback mac=%s", new Object[] { b.Dj(paramAnonymousLong1) });
                  }
                }
                if (i == 0) {
                  break label214;
                }
                Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "remove seesion(mac=%s)", new Object[] { b.Dj(paramAnonymousLong1) });
                e.this.pgC.remove(Long.valueOf(paramAnonymousLong1));
                e.this.phl.remove(Long.valueOf(paramAnonymousLong1));
                AppMethodBeat.o(22516);
                return;
              }
              Log.e("MicroMsg.exdevice.BluetoothLESimpleManager", "no seesion(mac=%s) found", new Object[] { b.Dj(paramAnonymousLong1) });
              label214:
              AppMethodBeat.o(22516);
            }
          });
          Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session size = %d", new Object[] { Integer.valueOf(e.this.pgC.size()) });
          AppMethodBeat.o(22517);
          return;
        }
      }
      
      public final void b(long paramAnonymousLong, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22518);
        Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onRecv. mac = %s", new Object[] { b.Dj(paramAnonymousLong) });
        if (e.this.phj != null)
        {
          e.this.phj.b(paramAnonymousLong, paramAnonymousArrayOfByte);
          AppMethodBeat.o(22518);
          return;
        }
        Log.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no BLEManagerCallback");
        AppMethodBeat.o(22518);
      }
      
      public final void m(long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(22519);
        String str2 = b.Dj(paramAnonymousLong);
        if (paramAnonymousBoolean) {}
        for (String str1 = "true";; str1 = "false")
        {
          Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onSend. mac = %s, success = %s", new Object[] { str2, str1 });
          if (e.this.phj != null) {
            e.this.phj.m(paramAnonymousLong, paramAnonymousBoolean);
          }
          AppMethodBeat.o(22519);
          return;
        }
      }
    };
    this.mAppContext = MMApplicationContext.getContext();
    this.phj = parama;
    this.pgE = c.ckG();
    this.mRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22520);
        e.this.pgE.a(false, e.this.pgH);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleManager", "Time out for discovering. Stop it");
        AppMethodBeat.o(22520);
      }
    };
    this.mHandler = new MMHandler("BluetoothLESimpleManagerThread");
    AppMethodBeat.o(22523);
  }
  
  public final void ai(Runnable paramRunnable)
  {
    AppMethodBeat.i(22524);
    this.mLock.lock();
    paramRunnable.run();
    this.mLock.unlock();
    AppMethodBeat.o(22524);
  }
  
  @TargetApi(18)
  public final boolean ckE()
  {
    AppMethodBeat.i(22525);
    boolean bool = this.mAppContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    AppMethodBeat.o(22525);
    return bool;
  }
  
  public static abstract class a
  {
    public void a(long paramLong1, boolean paramBoolean, long paramLong2) {}
    
    public void a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte) {}
    
    public void b(long paramLong, byte[] paramArrayOfByte) {}
    
    public void ckF() {}
    
    public void m(long paramLong, boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.e
 * JD-Core Version:    0.7.0.1
 */