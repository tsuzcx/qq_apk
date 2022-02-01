package com.tencent.matrix.report;

import android.util.Pair;
import com.tencent.matrix.a.a.a.c;
import com.tencent.matrix.a.a.a.c.c;
import com.tencent.matrix.a.a.a.k;
import com.tencent.matrix.a.a.a.k.b;
import com.tencent.matrix.a.a.a.p;
import com.tencent.matrix.a.a.a.p.d;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static final Map<String, List<Pair<String, String>>> eYf = new HashMap();
  private static final b eYg = new b()
  {
    public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject1, Object paramAnonymousObject2) {}
    
    public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
    {
      Log.i("Matrix.battery.AmsInvokeListener", "on location invoke, method = " + paramAnonymousString4 + ", form = " + paramAnonymousString1);
      paramAnonymousString1 = (k)com.tencent.matrix.a.a.aj(k.class);
      int i;
      if (paramAnonymousString1 != null)
      {
        i = -1;
        switch (paramAnonymousString4.hashCode())
        {
        }
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          return;
          if (paramAnonymousString4.equals("requestLocationUpdates")) {
            i = 0;
          }
          break;
        }
      }
      paramAnonymousString1.eRU.awW();
    }
  };
  private static final Map<String, List<Pair<String, String>>> eYh = new HashMap();
  private static final b eYi = new b()
  {
    public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject1, Object paramAnonymousObject2) {}
    
    public final void a(String arg1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
    {
      Log.i("Matrix.battery.AmsInvokeListener", "on wakelock invoke, method = " + paramAnonymousString4 + ", form = " + ???);
      ??? = (p)com.tencent.matrix.a.a.aj(p.class);
      int i;
      if (??? != null)
      {
        i = -1;
        switch (paramAnonymousString4.hashCode())
        {
        }
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          return;
          if (paramAnonymousString4.equals("acquire"))
          {
            i = 0;
            continue;
            if (paramAnonymousString4.equals("release")) {
              i = 1;
            }
          }
          break;
        }
      }
      paramAnonymousString2 = ???.eSR;
      synchronized (paramAnonymousString2.mLock)
      {
        paramAnonymousString2.eQx += 1;
        paramAnonymousString2.eQy += 1;
        return;
      }
      paramAnonymousString2 = ???.eSR;
      synchronized (paramAnonymousString2.mLock)
      {
        paramAnonymousString2.eQy -= 1;
        return;
      }
    }
  };
  private static final Map<String, List<Pair<String, String>>> eYj = new HashMap();
  private static final b eYk = new b()
  {
    public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject1, Object paramAnonymousObject2) {}
    
    public final void a(String arg1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
    {
      Log.i("Matrix.battery.AmsInvokeListener", "on alarm invoke, method = " + paramAnonymousString4 + ", form = " + ???);
      ??? = (c)com.tencent.matrix.a.a.aj(c.class);
      int i;
      if (??? != null)
      {
        i = -1;
        switch (paramAnonymousString4.hashCode())
        {
        }
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          return;
          if (paramAnonymousString4.equals("set"))
          {
            i = 0;
            continue;
            if (paramAnonymousString4.equals("setWindow"))
            {
              i = 1;
              continue;
              if (paramAnonymousString4.equals("setRepeating"))
              {
                i = 2;
                continue;
                if (paramAnonymousString4.equals("cancel")) {
                  i = 3;
                }
              }
            }
          }
          break;
        }
      }
      paramAnonymousString2 = ???.eQj;
      synchronized (paramAnonymousString2.mLock)
      {
        paramAnonymousString2.eQx += 1;
        paramAnonymousString2.eQy += 1;
        return;
      }
      paramAnonymousString2 = ???.eQj;
      synchronized (paramAnonymousString2.mLock)
      {
        paramAnonymousString2.eQy -= 1;
        return;
      }
    }
  };
  
  public static void ayW()
  {
    new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("requestLocationUpdates", "(Ljava/lang/String;JFLandroid/location/LocationListener;)V"));
    localArrayList.add(Pair.create("requestLocationUpdates", "(Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V"));
    localArrayList.add(Pair.create("requestLocationUpdates", "(Ljava/lang/String;JFLandroid/app/PendingIntent;)V"));
    localArrayList.add(Pair.create("requestLocationUpdates", "(JFLandroid/location/Criteria;Landroid/app/PendingIntent;)V"));
    localArrayList.add(Pair.create("requestLocationUpdates", "(JFLandroid/location/Criteria;Landroid/location/LocationListener;Landroid/os/Looper;)V"));
    eYf.put("android/location/LocationManager", localArrayList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a(eYf, eYg);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("acquire", "()V"));
    localArrayList.add(Pair.create("acquire", "(J)V"));
    localArrayList.add(Pair.create("release", "()V"));
    localArrayList.add(Pair.create("release", "(I)V"));
    eYh.put("android/os/PowerManager$WakeLock", localArrayList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a(eYh, eYi);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("set", "(IJLandroid/app/PendingIntent;)V"));
    localArrayList.add(Pair.create("setWindow", "(IJJLandroid/app/PendingIntent;)V"));
    localArrayList.add(Pair.create("setRepeating", "(IJJLandroid/app/PendingIntent;)V"));
    localArrayList.add(Pair.create("cancel", "(Landroid/app/PendingIntent;)V"));
    localArrayList.add(Pair.create("cancel", "(Landroid/app/AlarmManager$OnAlarmListener;)V"));
    eYj.put("android/os/PowerManager$WakeLock", localArrayList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a(eYj, eYk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.report.a
 * JD-Core Version:    0.7.0.1
 */