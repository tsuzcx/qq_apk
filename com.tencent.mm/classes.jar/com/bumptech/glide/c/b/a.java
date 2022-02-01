package com.bumptech.glide.c.b;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.bumptech.glide.c.h;
import com.bumptech.glide.h.i;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class a
{
  private final boolean aAM;
  final Handler aAO;
  final Map<h, b> aDR;
  o.a aDS;
  ReferenceQueue<o<?>> aDT;
  private Thread aDU;
  volatile boolean aDV;
  volatile a aDW;
  
  a(boolean paramBoolean)
  {
    AppMethodBeat.i(76918);
    this.aAO = new Handler(Looper.getMainLooper(), new Handler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(76914);
        if (paramAnonymousMessage.what == 1)
        {
          a.this.a((a.b)paramAnonymousMessage.obj);
          AppMethodBeat.o(76914);
          return true;
        }
        AppMethodBeat.o(76914);
        return false;
      }
    });
    this.aDR = new HashMap();
    this.aAM = paramBoolean;
    AppMethodBeat.o(76918);
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(76920);
    j.qa();
    this.aDR.remove(paramb.aDY);
    if ((!paramb.aDZ) || (paramb.aEa == null))
    {
      AppMethodBeat.o(76920);
      return;
    }
    o localo = new o(paramb.aEa, true, false);
    localo.a(paramb.aDY, this.aDS);
    this.aDS.b(paramb.aDY, localo);
    AppMethodBeat.o(76920);
  }
  
  final void a(h paramh, o<?> paramo)
  {
    AppMethodBeat.i(76919);
    if (this.aDT == null)
    {
      this.aDT = new ReferenceQueue();
      this.aDU = new Thread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(76915);
          Process.setThreadPriority(10);
          a locala = a.this;
          while (!locala.aDV) {
            try
            {
              Object localObject = (a.b)locala.aDT.remove();
              locala.aAO.obtainMessage(1, localObject).sendToTarget();
              localObject = locala.aDW;
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
          AppMethodBeat.o(76915);
        }
      }, "glide-active-resources");
      this.aDU.start();
    }
    paramo = new b(paramh, paramo, this.aDT, this.aAM);
    paramh = (b)this.aDR.put(paramh, paramo);
    if (paramh != null) {
      paramh.reset();
    }
    AppMethodBeat.o(76919);
  }
  
  static abstract interface a {}
  
  static final class b
    extends WeakReference<o<?>>
  {
    final h aDY;
    final boolean aDZ;
    u<?> aEa;
    
    b(h paramh, o<?> paramo, ReferenceQueue<? super o<?>> paramReferenceQueue, boolean paramBoolean)
    {
      super(paramReferenceQueue);
      AppMethodBeat.i(76916);
      this.aDY = ((h)i.checkNotNull(paramh, "Argument must not be null"));
      if ((paramo.aDZ) && (paramBoolean)) {}
      for (paramh = (u)i.checkNotNull(paramo.aEa, "Argument must not be null");; paramh = null)
      {
        this.aEa = paramh;
        this.aDZ = paramo.aDZ;
        AppMethodBeat.o(76916);
        return;
      }
    }
    
    final void reset()
    {
      AppMethodBeat.i(76917);
      this.aEa = null;
      clear();
      AppMethodBeat.o(76917);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.a
 * JD-Core Version:    0.7.0.1
 */