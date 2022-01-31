package com.tencent.matrix.trace;

import android.app.Application;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.matrix.trace.e.d;
import com.tencent.matrix.trace.e.e;
import java.util.LinkedList;

public class a
  extends com.tencent.matrix.b.b
{
  private final com.tencent.matrix.trace.a.a bqr;
  private com.tencent.matrix.trace.e.c bqs;
  private com.tencent.matrix.trace.e.b bqt;
  public d bqu;
  private e bqv;
  
  public a(com.tencent.matrix.trace.a.a parama)
  {
    this.bqr = parama;
  }
  
  public final void a(Application paramApplication, com.tencent.matrix.b.c paramc)
  {
    super.a(paramApplication, paramc);
    com.tencent.matrix.d.b.i("Matrix.TracePlugin", "trace plugin init, trace config: %s", new Object[] { this.bqr.toString() });
    if (Build.VERSION.SDK_INT < 16)
    {
      com.tencent.matrix.d.b.e("Matrix.TracePlugin", "[FrameBeat] API is low Build.VERSION_CODES.JELLY_BEAN(16), TracePlugin is not supported", new Object[0]);
      this.boE = false;
    }
    do
    {
      return;
      com.tencent.matrix.trace.core.a.b(paramApplication);
      this.bqu = new d(this);
      this.bqv = new e(this, this.bqr);
      if (this.bqr.bqx) {
        this.bqs = new com.tencent.matrix.trace.e.c(this, this.bqr);
      }
    } while (!this.bqr.bqy);
    this.bqt = new com.tencent.matrix.trace.e.b(this, this.bqr);
  }
  
  public final String getTag()
  {
    return "Trace";
  }
  
  public final void start()
  {
    super.start();
    if (!this.boE) {
      return;
    }
    if (this.bqs != null) {
      this.bqs.onCreate();
    }
    if (this.bqt != null) {
      this.bqt.onCreate();
    }
    if (this.bqu != null) {
      this.bqu.onCreate();
    }
    if (this.bqv != null) {
      this.bqv.onCreate();
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        com.tencent.matrix.trace.core.b localb = com.tencent.matrix.trace.core.b.ro();
        if (!com.tencent.matrix.d.c.ae(Thread.currentThread().getId()))
        {
          com.tencent.matrix.d.b.e("Matrix.FrameBeat", "[onCreate] FrameBeat must create on main thread", new Object[0]);
          return;
        }
        com.tencent.matrix.d.b.i("Matrix.FrameBeat", "[onCreate] FrameBeat real onCreate!", new Object[0]);
        if (!localb.bre)
        {
          localb.bre = true;
          localb.brf = System.nanoTime();
          com.tencent.matrix.trace.core.a.rn().a(localb);
          localb.brd = Choreographer.getInstance();
          return;
        }
        com.tencent.matrix.d.b.w("Matrix.FrameBeat", "[onCreate] FrameBeat is created!", new Object[0]);
      }
    });
  }
  
  public final void stop()
  {
    super.stop();
    if (!this.boE) {
      return;
    }
    com.tencent.matrix.trace.core.b localb = com.tencent.matrix.trace.core.b.ro();
    if (localb.bre)
    {
      localb.bre = false;
      localb.brd.removeFrameCallback(localb);
      localb.brd = null;
      if (localb.brc != null) {
        localb.brc.clear();
      }
      com.tencent.matrix.trace.core.a.rn().b(localb);
    }
    for (;;)
    {
      if (this.bqs != null) {
        this.bqs.onDestroy();
      }
      if (this.bqt != null) {
        this.bqt.onDestroy();
      }
      if (this.bqu != null) {
        this.bqu.onDestroy();
      }
      if (this.bqv == null) {
        break;
      }
      this.bqv.onDestroy();
      return;
      com.tencent.matrix.d.b.w("Matrix.FrameBeat", "[onDestroy] FrameBeat is not created!", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.a
 * JD-Core Version:    0.7.0.1
 */