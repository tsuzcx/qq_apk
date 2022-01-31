package com.tencent.mm.plugin.f.a.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(18)
public final class e
{
  public final HashMap<Long, f> hTU = new HashMap();
  public c hTW;
  public c.a hTZ = new e.1(this);
  e.a hUC;
  public HashSet<Long> hUD = new HashSet();
  final HashMap<Long, Boolean> hUE = new HashMap();
  public f.a hUF = new e.2(this);
  public ah mHandler = null;
  private ReentrantLock mLock = new ReentrantLock();
  public Runnable mRunnable = null;
  public Context ze = null;
  
  public e(e.a parama)
  {
    this.hUC = parama;
    this.hTW = c.aws();
    this.mRunnable = new e.3(this);
    this.mHandler = new ah(new ai("BluetoothLESimpleManagerThread").mnU.getLooper());
  }
  
  public final void G(Runnable paramRunnable)
  {
    this.mLock.lock();
    paramRunnable.run();
    this.mLock.unlock();
  }
  
  @TargetApi(18)
  public final boolean awq()
  {
    return this.ze.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.e
 * JD-Core Version:    0.7.0.1
 */