package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class n
{
  final Object lock = new byte[0];
  boolean mhF = false;
  d.a.a mhG;
  
  public final d.a.a u(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return null;
    }
    long l1 = bk.UY();
    long l2 = Thread.currentThread().getId();
    synchronized (this.lock)
    {
      this.mhF = false;
      this.mhG = null;
      e.post(new n.1(this, l2, l1, paramContext, paramInt), "SightCamera_openCamera");
    }
    try
    {
      this.lock.wait(30000L);
      if ((this.mhG != null) && (this.mhG.dwJ != null))
      {
        y.i("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Succ thread:%d Time:%d camera:%s", new Object[] { Long.valueOf(l2), Long.valueOf(bk.UY() - l1), this.mhG.dwJ });
        paramContext = this.mhG;
        return paramContext;
        paramContext = finally;
        throw paramContext;
      }
    }
    catch (InterruptedException paramContext)
    {
      for (;;)
      {
        y.e("MicroMsg.SightCamera.OpenCameraThread", "Lock wait failed e:%s", new Object[] { paramContext.getMessage() });
      }
      this.mhF = true;
      y.e("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Timeout:%d", new Object[] { Long.valueOf(bk.UY() - l1) });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.n
 * JD-Core Version:    0.7.0.1
 */