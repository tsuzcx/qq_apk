package com.tencent.matrix.c;

import android.os.Handler;
import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.a.a.a.j.a.a;
import com.tencent.matrix.a.b.c;
import com.tencent.matrix.a.b.k.a;
import com.tencent.matrix.report.d.a;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.app.z;
import com.tencent.mm.app.z.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private static final List<b> cZl = new LinkedList();
  private static final Runnable cZm = new a(true, (byte)0);
  private static final Runnable cZn = new a(false, (byte)0);
  private static boolean cZo = false;
  private static final Handler mHandler = new Handler(Looper.getMainLooper());
  
  public static boolean Xm()
  {
    return cZo;
  }
  
  public static void Xn()
  {
    if (a.Xi()) {
      AppForegroundDelegate.fby.a(new o()
      {
        public final void onAppBackground(String paramAnonymousString)
        {
          if (a.Xi()) {
            b.d(false, paramAnonymousString);
          }
        }
        
        public final void onAppForeground(String paramAnonymousString)
        {
          if (a.Xi()) {
            b.d(true, paramAnonymousString);
          }
        }
      });
    }
    if (a.Xj())
    {
      z localz = z.abb();
      z.b local2 = new z.b()
      {
        public final void fm(String paramAnonymousString)
        {
          if (a.Xj()) {
            b.d(true, paramAnonymousString);
          }
        }
        
        public final void fn(String paramAnonymousString)
        {
          if (a.Xj()) {
            b.d(false, paramAnonymousString);
          }
        }
      };
      if (!localz.cSF.contains(local2)) {
        localz.cSF.add(local2);
      }
    }
    com.tencent.matrix.a.b.VJ().a(new b.c()
    {
      public final boolean a(com.tencent.matrix.a.b.b paramAnonymousb, long paramAnonymousLong)
      {
        Log.i("Matrix.battery.LifeCycle", "#onAppLowEnergy");
        h.ZvG.be(new b.3.2(this, paramAnonymousb, paramAnonymousLong));
        return false;
      }
      
      public final boolean eM(String paramAnonymousString)
      {
        Log.i("Matrix.battery.LifeCycle", "#onStateChanged");
        h.ZvG.be(new b.3.1(this, paramAnonymousString));
        return false;
      }
    });
  }
  
  public static void a(b paramb)
  {
    synchronized (cZl)
    {
      cZl.add(paramb);
      return;
    }
  }
  
  private static void cS(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!cZo)
      {
        mHandler.removeCallbacks(cZn);
        mHandler.postDelayed(cZm, 5000L);
      }
    }
    while (!cZo) {
      return;
    }
    mHandler.removeCallbacks(cZm);
    mHandler.postDelayed(cZn, 5000L);
  }
  
  private static void fk(String paramString)
  {
    if (!com.tencent.matrix.b.Vt()) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (com.tencent.matrix.a.c)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.a.c.class);
      } while ((localObject == null) || (((com.tencent.matrix.a.c)localObject).isPluginStopped()));
      localObject = (com.tencent.matrix.a.a.a.d)((com.tencent.matrix.a.c)localObject).cSM.Z(com.tencent.matrix.a.a.a.d.class);
    } while (localObject == null);
    try
    {
      if (((com.tencent.matrix.a.a.a.d)localObject).cVf != Collections.EMPTY_LIST)
      {
        ((com.tencent.matrix.a.a.a.d)localObject).cVf.add(0, new k.a(paramString));
        ((com.tencent.matrix.a.a.a.d)localObject).We();
      }
      com.tencent.matrix.e.c.i("Matrix.battery.AppStatMonitorFeature", "updateAppImportance when launch: ".concat(String.valueOf(paramString)), new Object[0]);
      ((com.tencent.matrix.a.a.a.d)localObject).Wj();
      return;
    }
    finally {}
  }
  
  static final class a
    implements Runnable
  {
    final boolean cZp;
    
    private a(boolean paramBoolean)
    {
      this.cZp = paramBoolean;
    }
    
    public final void run()
    {
      synchronized ()
      {
        if (!this.cZp) {
          break label79;
        }
        if (b.cZo) {
          break label76;
        }
        Log.i("Matrix.battery.LifeCycle", "#onAppLowEnergy, AppDoze ON");
        d.a.cZ(true);
        Iterator localIterator1 = b.Xp().iterator();
        if (localIterator1.hasNext()) {
          ((b.b)localIterator1.next()).cT(true);
        }
      }
      b.access$202(true);
      for (;;)
      {
        label76:
        return;
        label79:
        if (b.cZo)
        {
          Log.i("Matrix.battery.LifeCycle", "#onAppLowEnergy, AppDoze OFF");
          d.a.cZ(false);
          Iterator localIterator2 = b.Xp().iterator();
          while (localIterator2.hasNext()) {
            ((b.b)localIterator2.next()).cT(false);
          }
          b.access$202(false);
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void cT(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.c.b
 * JD-Core Version:    0.7.0.1
 */