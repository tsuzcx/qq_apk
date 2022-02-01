package com.tencent.matrix.report;

import android.util.Pair;
import com.tencent.matrix.a.a.a.c;
import com.tencent.matrix.a.a.a.c.c;
import com.tencent.matrix.a.a.a.h;
import com.tencent.matrix.a.a.a.h.b;
import com.tencent.matrix.a.a.a.m;
import com.tencent.matrix.a.a.a.m.d;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  private static final Map<String, List<Pair<String, String>>> cZB = new HashMap();
  private static final b cZC = new b()
  {
    public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject) {}
    
    public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
    {
      Log.i("Matrix.battery.AmsInvokeListener", "on location invoke, method = " + paramAnonymousString4 + ", form = " + paramAnonymousString1);
      paramAnonymousString1 = (h)com.tencent.matrix.a.a.Z(h.class);
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
      paramAnonymousString1.cWa.Wo();
    }
  };
  private static final Map<String, List<Pair<String, String>>> cZD = new HashMap();
  private static final b cZE = new b()
  {
    public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject) {}
    
    public final void a(String arg1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
    {
      Log.i("Matrix.battery.AmsInvokeListener", "on wakelock invoke, method = " + paramAnonymousString4 + ", form = " + ???);
      ??? = (m)com.tencent.matrix.a.a.Z(m.class);
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
      paramAnonymousString2 = ???.cWK;
      synchronized (paramAnonymousString2.mLock)
      {
        paramAnonymousString2.cUX += 1;
        paramAnonymousString2.cUY += 1;
        return;
      }
      paramAnonymousString2 = ???.cWK;
      synchronized (paramAnonymousString2.mLock)
      {
        paramAnonymousString2.cUY -= 1;
        return;
      }
    }
  };
  private static final Map<String, List<Pair<String, String>>> cZF = new HashMap();
  private static final b cZG = new b()
  {
    public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject) {}
    
    public final void a(String arg1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
    {
      Log.i("Matrix.battery.AmsInvokeListener", "on alarm invoke, method = " + paramAnonymousString4 + ", form = " + ???);
      ??? = (c)com.tencent.matrix.a.a.Z(c.class);
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
      paramAnonymousString2 = ???.cUJ;
      synchronized (paramAnonymousString2.mLock)
      {
        paramAnonymousString2.cUX += 1;
        paramAnonymousString2.cUY += 1;
        return;
      }
      paramAnonymousString2 = ???.cUJ;
      synchronized (paramAnonymousString2.mLock)
      {
        paramAnonymousString2.cUY -= 1;
        return;
      }
    }
  };
  
  public static void Xr()
  {
    new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("requestLocationUpdates", "(Ljava/lang/String;JFLandroid/location/LocationListener;)V"));
    localArrayList.add(Pair.create("requestLocationUpdates", "(Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V"));
    localArrayList.add(Pair.create("requestLocationUpdates", "(Ljava/lang/String;JFLandroid/app/PendingIntent;)V"));
    localArrayList.add(Pair.create("requestLocationUpdates", "(JFLandroid/location/Criteria;Landroid/app/PendingIntent;)V"));
    localArrayList.add(Pair.create("requestLocationUpdates", "(JFLandroid/location/Criteria;Landroid/location/LocationListener;Landroid/os/Looper;)V"));
    cZB.put("android/location/LocationManager", localArrayList);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a(cZB, cZC);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("acquire", "()V"));
    localArrayList.add(Pair.create("acquire", "(J)V"));
    localArrayList.add(Pair.create("release", "()V"));
    localArrayList.add(Pair.create("release", "(I)V"));
    cZD.put("android/os/PowerManager$WakeLock", localArrayList);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a(cZD, cZE);
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("set", "(IJLandroid/app/PendingIntent;)V"));
    localArrayList.add(Pair.create("setWindow", "(IJJLandroid/app/PendingIntent;)V"));
    localArrayList.add(Pair.create("setRepeating", "(IJJLandroid/app/PendingIntent;)V"));
    localArrayList.add(Pair.create("cancel", "(Landroid/app/PendingIntent;)V"));
    localArrayList.add(Pair.create("cancel", "(Landroid/app/AlarmManager$OnAlarmListener;)V"));
    cZF.put("android/os/PowerManager$WakeLock", localArrayList);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a(cZF, cZG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.a
 * JD-Core Version:    0.7.0.1
 */