package com.tencent.mm.plugin.g.a.b;

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

public final class e
{
  public Context mAppContext;
  public MMHandler mHandler;
  private ReentrantLock mLock;
  public Runnable mRunnable;
  public final HashMap<Long, f> vuM;
  public c vuO;
  public c.a vuR;
  a vvt;
  public HashSet<Long> vvu;
  final HashMap<Long, Boolean> vvv;
  public f.a vvw;
  
  public e(a parama)
  {
    AppMethodBeat.i(22523);
    this.mAppContext = null;
    this.mLock = new ReentrantLock();
    this.mHandler = null;
    this.mRunnable = null;
    this.vuR = new c.a()
    {
      public final void a(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22514);
        long l = b.apW(paramAnonymousBluetoothDevice.getAddress());
        if (!e.this.vvu.contains(Long.valueOf(l)))
        {
          Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscover------ device Name = %s, mac = %s(%d), scanRecord = %s", new Object[] { paramAnonymousBluetoothDevice.getName(), paramAnonymousBluetoothDevice.getAddress(), Long.valueOf(l), b.bK(paramAnonymousArrayOfByte) });
          e.this.vvu.add(Long.valueOf(l));
          if (com.tencent.mm.plugin.g.a.b.a.c.bl(paramAnonymousArrayOfByte)) {
            e.this.vvt.a(paramAnonymousBluetoothDevice.getAddress(), paramAnonymousBluetoothDevice.getName(), paramAnonymousInt, paramAnonymousArrayOfByte);
          }
        }
        AppMethodBeat.o(22514);
      }
      
      public final void daR()
      {
        AppMethodBeat.i(22515);
        Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscoverFinished------");
        if (e.this.vvt != null) {
          e.this.vvt.daR();
        }
        for (;;)
        {
          e.this.vvu.clear();
          AppMethodBeat.o(22515);
          return;
          Log.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no SimpleBLEManagerCallback");
        }
      }
    };
    this.vvu = new HashSet();
    this.vuM = new HashMap();
    this.vvv = new HashMap();
    this.vvw = new f.a()
    {
      public final void a(final long paramAnonymousLong1, boolean paramAnonymousBoolean, final long paramAnonymousLong2)
      {
        AppMethodBeat.i(22517);
        String str2 = b.lO(paramAnonymousLong1);
        if (paramAnonymousBoolean) {}
        for (String str1 = "true";; str1 = "false")
        {
          Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onConnected. mac = %s, connected = %s", new Object[] { str2, str1 });
          e.this.at(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(22516);
              f localf = (f)e.this.vuM.get(Long.valueOf(paramAnonymousLong1));
              Boolean localBoolean = Boolean.FALSE;
              if (!paramAnonymousLong2) {}
              for (int i = 1; (localf != null) || (i != 0); i = 0)
              {
                if (e.this.vvt != null)
                {
                  e.this.vvt.a(paramAnonymousLong1, paramAnonymousLong2, this.vvz);
                  if (i != 0) {
                    Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnected, mBLEManagerCallback callback mac=%s", new Object[] { b.lO(paramAnonymousLong1) });
                  }
                }
                if (i == 0) {
                  break label214;
                }
                Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "remove seesion(mac=%s)", new Object[] { b.lO(paramAnonymousLong1) });
                e.this.vuM.remove(Long.valueOf(paramAnonymousLong1));
                e.this.vvv.remove(Long.valueOf(paramAnonymousLong1));
                AppMethodBeat.o(22516);
                return;
              }
              Log.e("MicroMsg.exdevice.BluetoothLESimpleManager", "no seesion(mac=%s) found", new Object[] { b.lO(paramAnonymousLong1) });
              label214:
              AppMethodBeat.o(22516);
            }
          });
          Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session size = %d", new Object[] { Integer.valueOf(e.this.vuM.size()) });
          AppMethodBeat.o(22517);
          return;
        }
      }
      
      public final void c(long paramAnonymousLong, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22518);
        Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onRecv. mac = %s", new Object[] { b.lO(paramAnonymousLong) });
        if (e.this.vvt != null)
        {
          e.this.vvt.c(paramAnonymousLong, paramAnonymousArrayOfByte);
          AppMethodBeat.o(22518);
          return;
        }
        Log.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no BLEManagerCallback");
        AppMethodBeat.o(22518);
      }
      
      public final void s(long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(22519);
        String str2 = b.lO(paramAnonymousLong);
        if (paramAnonymousBoolean) {}
        for (String str1 = "true";; str1 = "false")
        {
          Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onSend. mac = %s, success = %s", new Object[] { str2, str1 });
          if (e.this.vvt != null) {
            e.this.vvt.s(paramAnonymousLong, paramAnonymousBoolean);
          }
          AppMethodBeat.o(22519);
          return;
        }
      }
    };
    this.mAppContext = MMApplicationContext.getContext();
    this.vvt = parama;
    this.vuO = c.daS();
    this.mRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22520);
        e.this.vuO.a(false, e.this.vuR);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleManager", "Time out for discovering. Stop it");
        AppMethodBeat.o(22520);
      }
    };
    this.mHandler = new MMHandler("BluetoothLESimpleManagerThread");
    AppMethodBeat.o(22523);
  }
  
  public final void at(Runnable paramRunnable)
  {
    AppMethodBeat.i(22524);
    this.mLock.lock();
    paramRunnable.run();
    this.mLock.unlock();
    AppMethodBeat.o(22524);
  }
  
  public final boolean daQ()
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
    
    public void c(long paramLong, byte[] paramArrayOfByte) {}
    
    public void daR() {}
    
    public void s(long paramLong, boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.b.e
 * JD-Core Version:    0.7.0.1
 */