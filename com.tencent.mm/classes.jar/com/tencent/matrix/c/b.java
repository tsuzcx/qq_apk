package com.tencent.matrix.c;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.a.b.c;
import com.tencent.matrix.a.b.o.a;
import com.tencent.matrix.report.e;
import com.tencent.matrix.report.e.a;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.ac;
import com.tencent.mm.app.ac.b;
import com.tencent.mm.app.q;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private static final List<b> eWg = new LinkedList();
  private static final Runnable eWh = new a(true, (byte)0);
  private static final Runnable eWi = new a(false, (byte)0);
  private static boolean eWj = false;
  private static String eWk = "unknown";
  private static final Handler mHandler = new Handler(Looper.getMainLooper());
  
  public static void a(b paramb)
  {
    synchronized (eWg)
    {
      eWg.add(paramb);
      return;
    }
  }
  
  public static boolean ayx()
  {
    return eWj;
  }
  
  public static void ayy()
  {
    if (a.ays()) {
      AppForegroundDelegate.heY.a(new q()
      {
        public final void onAppBackground(String paramAnonymousString)
        {
          if (a.ays()) {
            b.d(false, paramAnonymousString);
          }
        }
        
        public final void onAppForeground(String paramAnonymousString)
        {
          if (a.ays()) {
            b.d(true, paramAnonymousString);
          }
        }
      });
    }
    if (a.ayt()) {
      ac.aCN().a(new ac.b()
      {
        public final void onProcessBackground(String paramAnonymousString)
        {
          if (a.ayt()) {
            b.d(false, paramAnonymousString);
          }
        }
        
        public final void onProcessForeground(String paramAnonymousString)
        {
          if (a.ayt()) {
            b.d(true, paramAnonymousString);
          }
        }
      });
    }
    com.tencent.matrix.a.b.awt().a(new b.c()
    {
      public final boolean a(final com.tencent.matrix.a.b.b paramAnonymousb, final long paramAnonymousLong)
      {
        Log.i("Matrix.battery.LifeCycle", "#onAppLowEnergy");
        h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            long l;
            int i;
            if ((!com.tencent.matrix.a.b.b.bZ(paramAnonymousb.mContext)) && ((!paramAnonymousb.isForeground()) || (!com.tencent.matrix.a.b.b.ca(paramAnonymousb.mContext))))
            {
              if ((!com.tencent.matrix.a.a.a.awA().awx()) && (!b.ayB()) && (paramAnonymousLong >= 300000L)) {
                b.ayC();
              }
              Log.i("Matrix.battery.LifeCycle", "#onAppLowEnergy, bgMillis = " + paramAnonymousLong);
              l = paramAnonymousLong;
              if (l >= 300000L)
              {
                if (l >= 600000L) {
                  break label127;
                }
                i = 70;
              }
            }
            for (;;)
            {
              f.Ozc.idkeyStat(1540L, i, 1L, false);
              return;
              label127:
              if (l < 1800000L) {
                i = 71;
              } else {
                i = 72;
              }
            }
          }
        });
        return false;
      }
      
      public final boolean gl(final String paramAnonymousString)
      {
        Log.i("Matrix.battery.LifeCycle", "#onStateChanged");
        h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            com.tencent.matrix.a.b.b localb = com.tencent.matrix.a.b.awt().awu();
            Log.i("Matrix.battery.LifeCycle", "currStat, charging = " + com.tencent.matrix.a.b.b.bZ(localb.mContext) + ", fg = " + localb.isForeground() + ", screenOn = " + com.tencent.matrix.a.b.b.ca(localb.mContext));
            if ("android.intent.action.ACTION_POWER_CONNECTED".equals(paramAnonymousString)) {
              a.axY();
            }
          }
        });
        return false;
      }
    });
  }
  
  public static String ayz()
  {
    return eWk;
  }
  
  private static void dz(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!eWj)
      {
        mHandler.removeCallbacks(eWi);
        mHandler.postDelayed(eWh, 5000L);
      }
    }
    while (!eWj) {
      return;
    }
    mHandler.removeCallbacks(eWh);
    mHandler.postDelayed(eWi, 5000L);
  }
  
  private static void gE(String paramString)
  {
    if (!com.tencent.matrix.c.isInstalled()) {}
    for (;;)
    {
      return;
      Object localObject = (com.tencent.matrix.a.c)com.tencent.matrix.c.avW().ai(com.tencent.matrix.a.c.class);
      if ((localObject == null) || (((com.tencent.matrix.a.c)localObject).isPluginStopped())) {
        continue;
      }
      String str = e.gW(paramString);
      localObject = (com.tencent.matrix.a.a.a.d)((com.tencent.matrix.a.c)localObject).eOc.aj(com.tencent.matrix.a.a.a.d.class);
      if (localObject != null) {}
      try
      {
        if (((com.tencent.matrix.a.a.a.d)localObject).eQF != Collections.EMPTY_LIST)
        {
          ((com.tencent.matrix.a.a.a.d)localObject).eQF.add(0, new o.a(str));
          ((com.tencent.matrix.a.a.a.d)localObject).awN();
        }
        com.tencent.matrix.e.c.i("Matrix.battery.AppStatMonitorFeature", "updateAppImportance when launch: ".concat(String.valueOf(str)), new Object[0]);
        ((com.tencent.matrix.a.a.a.d)localObject).awS();
        if ("background".equals(paramString)) {
          continue;
        }
        eWk = str;
        return;
      }
      finally {}
    }
  }
  
  static final class a
    implements Runnable
  {
    final boolean eWo;
    
    private a(boolean paramBoolean)
    {
      this.eWo = paramBoolean;
    }
    
    public final void run()
    {
      synchronized ()
      {
        if (!this.eWo) {
          break label79;
        }
        if (b.ayB()) {
          break label76;
        }
        Log.i("Matrix.battery.LifeCycle", "#onAppLowEnergy, AppDoze ON");
        e.a.dI(true);
        Iterator localIterator1 = b.ayD().iterator();
        if (localIterator1.hasNext()) {
          ((b.b)localIterator1.next()).dB(true);
        }
      }
      b.dA(true);
      for (;;)
      {
        label76:
        return;
        label79:
        if (b.ayB())
        {
          Log.i("Matrix.battery.LifeCycle", "#onAppLowEnergy, AppDoze OFF");
          e.a.dI(false);
          Iterator localIterator2 = b.ayD().iterator();
          while (localIterator2.hasNext()) {
            ((b.b)localIterator2.next()).dB(false);
          }
          b.dA(false);
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void dB(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.c.b
 * JD-Core Version:    0.7.0.1
 */