package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class n
{
  boolean faK;
  d.a.a faL;
  final Object lock;
  
  n()
  {
    AppMethodBeat.i(76544);
    this.lock = new byte[0];
    this.faK = false;
    AppMethodBeat.o(76544);
  }
  
  public final d.a.a S(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(76545);
    if (paramContext == null)
    {
      AppMethodBeat.o(76545);
      return null;
    }
    long l1 = bo.aoy();
    long l2 = Thread.currentThread().getId();
    synchronized (this.lock)
    {
      this.faK = false;
      this.faL = null;
      d.post(new n.1(this, l2, l1, paramContext, paramInt), "SightCamera_openCamera");
      try
      {
        this.lock.wait(30000L);
        if ((this.faL != null) && (this.faL.eoH != null))
        {
          ab.i("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Succ thread:%d Time:%d camera:%s", new Object[] { Long.valueOf(l2), Long.valueOf(bo.aoy() - l1), this.faL.eoH });
          paramContext = this.faL;
          AppMethodBeat.o(76545);
          return paramContext;
        }
      }
      catch (InterruptedException paramContext)
      {
        for (;;)
        {
          ab.e("MicroMsg.SightCamera.OpenCameraThread", "Lock wait failed e:%s", new Object[] { paramContext.getMessage() });
        }
      }
    }
    this.faK = true;
    ab.e("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Timeout:%d", new Object[] { Long.valueOf(bo.aoy() - l1) });
    AppMethodBeat.o(76545);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.n
 * JD-Core Version:    0.7.0.1
 */