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
  final Map<h, b> aDa;
  o.a aDb;
  ReferenceQueue<o<?>> aDc;
  private Thread aDd;
  volatile boolean aDe;
  volatile a aDf;
  private final boolean azS;
  final Handler azU;
  
  a(boolean paramBoolean)
  {
    AppMethodBeat.i(76918);
    this.azU = new Handler(Looper.getMainLooper(), new Handler.Callback()
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
    this.aDa = new HashMap();
    this.azS = paramBoolean;
    AppMethodBeat.o(76918);
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(76920);
    j.pQ();
    this.aDa.remove(paramb.aDh);
    if ((!paramb.aDi) || (paramb.aDj == null))
    {
      AppMethodBeat.o(76920);
      return;
    }
    o localo = new o(paramb.aDj, true, false);
    localo.a(paramb.aDh, this.aDb);
    this.aDb.b(paramb.aDh, localo);
    AppMethodBeat.o(76920);
  }
  
  final void a(h paramh, o<?> paramo)
  {
    AppMethodBeat.i(76919);
    if (this.aDc == null)
    {
      this.aDc = new ReferenceQueue();
      this.aDd = new Thread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(76915);
          Process.setThreadPriority(10);
          a locala = a.this;
          while (!locala.aDe) {
            try
            {
              Object localObject = (a.b)locala.aDc.remove();
              locala.azU.obtainMessage(1, localObject).sendToTarget();
              localObject = locala.aDf;
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
          AppMethodBeat.o(76915);
        }
      }, "glide-active-resources");
      this.aDd.start();
    }
    paramo = new b(paramh, paramo, this.aDc, this.azS);
    paramh = (b)this.aDa.put(paramh, paramo);
    if (paramh != null) {
      paramh.reset();
    }
    AppMethodBeat.o(76919);
  }
  
  static abstract interface a {}
  
  static final class b
    extends WeakReference<o<?>>
  {
    final h aDh;
    final boolean aDi;
    u<?> aDj;
    
    b(h paramh, o<?> paramo, ReferenceQueue<? super o<?>> paramReferenceQueue, boolean paramBoolean)
    {
      super(paramReferenceQueue);
      AppMethodBeat.i(76916);
      this.aDh = ((h)i.checkNotNull(paramh, "Argument must not be null"));
      if ((paramo.aDi) && (paramBoolean)) {}
      for (paramh = (u)i.checkNotNull(paramo.aDj, "Argument must not be null");; paramh = null)
      {
        this.aDj = paramh;
        this.aDi = paramo.aDi;
        AppMethodBeat.o(76916);
        return;
      }
    }
    
    final void reset()
    {
      AppMethodBeat.i(76917);
      this.aDj = null;
      clear();
      AppMethodBeat.o(76917);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.a
 * JD-Core Version:    0.7.0.1
 */