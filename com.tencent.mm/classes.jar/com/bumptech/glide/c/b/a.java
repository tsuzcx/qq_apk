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
  private final boolean aCD;
  final Handler aCF;
  final Map<h, b> aFI;
  o.a aFJ;
  ReferenceQueue<o<?>> aFK;
  private Thread aFL;
  volatile boolean aFM;
  volatile a aFN;
  
  a(boolean paramBoolean)
  {
    AppMethodBeat.i(76918);
    this.aCF = new Handler(Looper.getMainLooper(), new Handler.Callback()
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
    this.aFI = new HashMap();
    this.aCD = paramBoolean;
    AppMethodBeat.o(76918);
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(76920);
    j.qs();
    this.aFI.remove(paramb.aFP);
    if ((!paramb.aFQ) || (paramb.aFR == null))
    {
      AppMethodBeat.o(76920);
      return;
    }
    o localo = new o(paramb.aFR, true, false);
    localo.a(paramb.aFP, this.aFJ);
    this.aFJ.b(paramb.aFP, localo);
    AppMethodBeat.o(76920);
  }
  
  final void a(h paramh, o<?> paramo)
  {
    AppMethodBeat.i(76919);
    if (this.aFK == null)
    {
      this.aFK = new ReferenceQueue();
      this.aFL = new Thread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(76915);
          Process.setThreadPriority(10);
          a locala = a.this;
          while (!locala.aFM) {
            try
            {
              Object localObject = (a.b)locala.aFK.remove();
              locala.aCF.obtainMessage(1, localObject).sendToTarget();
              localObject = locala.aFN;
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
          AppMethodBeat.o(76915);
        }
      }, "glide-active-resources");
      this.aFL.start();
    }
    paramo = new b(paramh, paramo, this.aFK, this.aCD);
    paramh = (b)this.aFI.put(paramh, paramo);
    if (paramh != null) {
      paramh.reset();
    }
    AppMethodBeat.o(76919);
  }
  
  static abstract interface a {}
  
  static final class b
    extends WeakReference<o<?>>
  {
    final h aFP;
    final boolean aFQ;
    u<?> aFR;
    
    b(h paramh, o<?> paramo, ReferenceQueue<? super o<?>> paramReferenceQueue, boolean paramBoolean)
    {
      super(paramReferenceQueue);
      AppMethodBeat.i(76916);
      this.aFP = ((h)i.checkNotNull(paramh, "Argument must not be null"));
      if ((paramo.aFQ) && (paramBoolean)) {}
      for (paramh = (u)i.checkNotNull(paramo.aFR, "Argument must not be null");; paramh = null)
      {
        this.aFR = paramh;
        this.aFQ = paramo.aFQ;
        AppMethodBeat.o(76916);
        return;
      }
    }
    
    final void reset()
    {
      AppMethodBeat.i(76917);
      this.aFR = null;
      clear();
      AppMethodBeat.o(76917);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.a
 * JD-Core Version:    0.7.0.1
 */