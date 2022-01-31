package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(18)
public final class e
{
  public final HashMap<Long, f> jNO;
  public c jNQ;
  public c.a jNT;
  e.a jOw;
  public HashSet<Long> jOx;
  final HashMap<Long, Boolean> jOy;
  public f.a jOz;
  public ak mHandler;
  private ReentrantLock mLock;
  public Runnable mRunnable;
  public Context zF;
  
  public e(e.a parama)
  {
    AppMethodBeat.i(18412);
    this.zF = null;
    this.mLock = new ReentrantLock();
    this.mHandler = null;
    this.mRunnable = null;
    this.jNT = new e.1(this);
    this.jOx = new HashSet();
    this.jNO = new HashMap();
    this.jOy = new HashMap();
    this.jOz = new e.2(this);
    this.zF = ah.getContext();
    this.jOw = parama;
    this.jNQ = c.aVV();
    this.mRunnable = new e.3(this);
    this.mHandler = new ak(new al("BluetoothLESimpleManagerThread").oNc.getLooper());
    AppMethodBeat.o(18412);
  }
  
  public final void N(Runnable paramRunnable)
  {
    AppMethodBeat.i(18413);
    this.mLock.lock();
    paramRunnable.run();
    this.mLock.unlock();
    AppMethodBeat.o(18413);
  }
  
  @TargetApi(18)
  public final boolean aVT()
  {
    AppMethodBeat.i(18414);
    boolean bool = this.zF.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    AppMethodBeat.o(18414);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.e
 * JD-Core Version:    0.7.0.1
 */