package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(18)
public final class e
{
  public Context IR;
  public aq mHandler;
  private ReentrantLock mLock;
  public Runnable mRunnable;
  public final HashMap<Long, f> nVF;
  public c nVH;
  public c.a nVK;
  a nWn;
  public HashSet<Long> nWo;
  final HashMap<Long, Boolean> nWp;
  public f.a nWq;
  
  public e(a parama)
  {
    AppMethodBeat.i(22523);
    this.IR = null;
    this.mLock = new ReentrantLock();
    this.mHandler = null;
    this.mRunnable = null;
    this.nVK = new c.a()
    {
      public final void a(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22514);
        long l = b.adP(paramAnonymousBluetoothDevice.getAddress());
        if (!e.this.nWo.contains(Long.valueOf(l)))
        {
          ae.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscover------ device Name = %s, mac = %s(%d), scanRecord = %s", new Object[] { paramAnonymousBluetoothDevice.getName(), paramAnonymousBluetoothDevice.getAddress(), Long.valueOf(l), b.bf(paramAnonymousArrayOfByte) });
          e.this.nWo.add(Long.valueOf(l));
          if (com.tencent.mm.plugin.d.a.b.a.c.aH(paramAnonymousArrayOfByte)) {
            e.this.nWn.a(paramAnonymousBluetoothDevice.getAddress(), paramAnonymousBluetoothDevice.getName(), paramAnonymousInt, paramAnonymousArrayOfByte);
          }
        }
        AppMethodBeat.o(22514);
      }
      
      public final void bNF()
      {
        AppMethodBeat.i(22515);
        ae.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscoverFinished------");
        if (e.this.nWn != null) {
          e.this.nWn.bNF();
        }
        for (;;)
        {
          e.this.nWo.clear();
          AppMethodBeat.o(22515);
          return;
          ae.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no SimpleBLEManagerCallback");
        }
      }
    };
    this.nWo = new HashSet();
    this.nVF = new HashMap();
    this.nWp = new HashMap();
    this.nWq = new f.a()
    {
      public final void a(final long paramAnonymousLong1, boolean paramAnonymousBoolean, final long paramAnonymousLong2)
      {
        AppMethodBeat.i(22517);
        String str2 = b.vf(paramAnonymousLong1);
        if (paramAnonymousBoolean) {}
        for (String str1 = "true";; str1 = "false")
        {
          ae.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onConnected. mac = %s, connected = %s", new Object[] { str2, str1 });
          e.this.ab(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(22516);
              f localf = (f)e.this.nVF.get(Long.valueOf(paramAnonymousLong1));
              Boolean localBoolean = Boolean.FALSE;
              if (!paramAnonymousLong2) {}
              for (int i = 1; (localf != null) || (i != 0); i = 0)
              {
                if (e.this.nWn != null)
                {
                  e.this.nWn.a(paramAnonymousLong1, paramAnonymousLong2, this.nWt);
                  if (i != 0) {
                    ae.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnected, mBLEManagerCallback callback mac=%s", new Object[] { b.vf(paramAnonymousLong1) });
                  }
                }
                if (i == 0) {
                  break label214;
                }
                ae.d("MicroMsg.exdevice.BluetoothLESimpleManager", "remove seesion(mac=%s)", new Object[] { b.vf(paramAnonymousLong1) });
                e.this.nVF.remove(Long.valueOf(paramAnonymousLong1));
                e.this.nWp.remove(Long.valueOf(paramAnonymousLong1));
                AppMethodBeat.o(22516);
                return;
              }
              ae.e("MicroMsg.exdevice.BluetoothLESimpleManager", "no seesion(mac=%s) found", new Object[] { b.vf(paramAnonymousLong1) });
              label214:
              AppMethodBeat.o(22516);
            }
          });
          ae.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session size = %d", new Object[] { Integer.valueOf(e.this.nVF.size()) });
          AppMethodBeat.o(22517);
          return;
        }
      }
      
      public final void b(long paramAnonymousLong, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(22518);
        ae.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onRecv. mac = %s", new Object[] { b.vf(paramAnonymousLong) });
        if (e.this.nWn != null)
        {
          e.this.nWn.b(paramAnonymousLong, paramAnonymousArrayOfByte);
          AppMethodBeat.o(22518);
          return;
        }
        ae.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no BLEManagerCallback");
        AppMethodBeat.o(22518);
      }
      
      public final void m(long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(22519);
        String str2 = b.vf(paramAnonymousLong);
        if (paramAnonymousBoolean) {}
        for (String str1 = "true";; str1 = "false")
        {
          ae.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onSend. mac = %s, success = %s", new Object[] { str2, str1 });
          if (e.this.nWn != null) {
            e.this.nWn.m(paramAnonymousLong, paramAnonymousBoolean);
          }
          AppMethodBeat.o(22519);
          return;
        }
      }
    };
    this.IR = ak.getContext();
    this.nWn = parama;
    this.nVH = c.bNG();
    this.mRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22520);
        e.this.nVH.a(false, e.this.nVK);
        ae.i("MicroMsg.exdevice.BluetoothLESimpleManager", "Time out for discovering. Stop it");
        AppMethodBeat.o(22520);
      }
    };
    this.mHandler = new aq("BluetoothLESimpleManagerThread");
    AppMethodBeat.o(22523);
  }
  
  public final void ab(Runnable paramRunnable)
  {
    AppMethodBeat.i(22524);
    this.mLock.lock();
    paramRunnable.run();
    this.mLock.unlock();
    AppMethodBeat.o(22524);
  }
  
  @TargetApi(18)
  public final boolean bNE()
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
    
    public void bNF() {}
    
    public void m(long paramLong, boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.e
 * JD-Core Version:    0.7.0.1
 */