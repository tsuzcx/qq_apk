package com.tencent.matrix.trace.e;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnDrawListener;
import android.view.Window;
import com.tencent.matrix.d.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
  extends a
  implements ViewTreeObserver.OnDrawListener
{
  private boolean brU;
  private final LinkedList<com.tencent.matrix.trace.c.a> bsh = new LinkedList();
  
  public d(com.tencent.matrix.trace.a parama)
  {
    super(parama);
  }
  
  public final void a(com.tencent.matrix.trace.c.a parama)
  {
    if (!this.bsh.contains(parama)) {
      this.bsh.add(parama);
    }
  }
  
  public final void b(com.tencent.matrix.trace.c.a parama)
  {
    this.bsh.remove(parama);
  }
  
  protected final String getTag()
  {
    return null;
  }
  
  public final void k(final long paramLong1, long paramLong2)
  {
    if (!this.brU) {}
    for (;;)
    {
      return;
      this.brU = false;
      final int i = (int)((paramLong2 - paramLong1) / 16666668L);
      if (i > 1)
      {
        Iterator localIterator = this.bsh.iterator();
        while (localIterator.hasNext())
        {
          final com.tencent.matrix.trace.c.a locala = (com.tencent.matrix.trace.c.a)localIterator.next();
          locala.a(paramLong1, paramLong2, this.brs, i);
          if (locala.mHandler != null) {
            locala.mHandler.post(new Runnable()
            {
              public final void run()
              {
                locala.mHandler.post(new d.a(locala, paramLong1, i, d.this.brs, this.bsl));
              }
            });
          }
        }
      }
    }
  }
  
  public final void onChange(final Activity paramActivity, Fragment paramFragment)
  {
    super.onChange(paramActivity, paramFragment);
    b.i("Matrix.FrameTracer", "[onChange] activity:%s", new Object[] { paramActivity.getClass().getSimpleName() });
    paramActivity.getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        paramActivity.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(d.this);
        paramActivity.getWindow().getDecorView().getViewTreeObserver().addOnDrawListener(d.this);
      }
    });
  }
  
  public final void onDraw()
  {
    this.brU = true;
  }
  
  private static final class a
    implements Runnable
  {
    com.tencent.matrix.trace.c.a bsn;
    String bso;
    int bsp;
    long bsq;
    long bsr;
    
    a(com.tencent.matrix.trace.c.a parama, long paramLong1, long paramLong2, String paramString, int paramInt)
    {
      this.bsn = parama;
      this.bso = paramString;
      this.bsp = paramInt;
      this.bsq = paramLong1;
      this.bsr = paramLong2;
    }
    
    public final void run() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.e.d
 * JD-Core Version:    0.7.0.1
 */