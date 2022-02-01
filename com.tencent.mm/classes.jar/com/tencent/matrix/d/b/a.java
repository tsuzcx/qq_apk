package com.tencent.matrix.d.b;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.g.b;
import com.tencent.matrix.report.d.a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements d.a
{
  public static long ctt = 0L;
  public static long ctu = 0L;
  public static int ctv = 0;
  private boolean ctA = true;
  private String ctB;
  public HashMap<Integer, Long> ctC;
  public final Runnable ctD = new Runnable()
  {
    public final void run()
    {
      a.a(a.this, false, 0);
    }
  };
  private final Runnable ctE = new Runnable()
  {
    public final void run()
    {
      a.a(a.this, false, 0);
    }
  };
  public final Application.ActivityLifecycleCallbacks ctF = new Application.ActivityLifecycleCallbacks()
  {
    public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
    
    public final void onActivityDestroyed(Activity paramAnonymousActivity) {}
    
    public final void onActivityPaused(Activity paramAnonymousActivity) {}
    
    public final void onActivityResumed(Activity paramAnonymousActivity)
    {
      a.a(a.this, paramAnonymousActivity);
    }
    
    public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
    
    public final void onActivityStarted(Activity paramAnonymousActivity) {}
    
    public final void onActivityStopped(Activity paramAnonymousActivity) {}
  };
  public final ComponentCallbacks2 ctG = new ComponentCallbacks2()
  {
    public final void onConfigurationChanged(Configuration paramAnonymousConfiguration) {}
    
    public final void onLowMemory()
    {
      a.b(a.this).post(new Runnable()
      {
        public final void run()
        {
          a.a(a.this, true, 3);
        }
      });
    }
    
    public final void onTrimMemory(final int paramAnonymousInt)
    {
      switch (paramAnonymousInt)
      {
      default: 
        return;
      }
      long l1 = com.tencent.matrix.g.a.aS(a.a(a.this));
      long l2 = com.tencent.matrix.g.a.aP(a.a(a.this));
      if (l1 >= 2L * l2)
      {
        com.tencent.matrix.g.c.i("Matrix.MemoryCanaryCore", "onTrimMemory level:%d, but memFree > 2*threshold, memFree:%d, threshold:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(l1), Long.valueOf(l2) });
        return;
      }
      a.b(a.this).post(new Runnable()
      {
        public final void run()
        {
          a.a(a.this, true, paramAnonymousInt);
        }
      });
    }
  };
  private final com.tencent.matrix.d.a ctr;
  public com.tencent.matrix.g.a.a cts;
  private final com.tencent.matrix.d.a.a ctw;
  public long cty;
  public int ctz;
  public final Context mContext;
  public final Handler mHandler = new Handler(b.HY().getLooper());
  public boolean mIsOpen = false;
  public long mStartTime;
  
  public a(com.tencent.matrix.d.a parama)
  {
    this.ctr = parama;
    this.mContext = parama.getApplication();
    this.ctw = parama.cto;
  }
  
  public static boolean GZ()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  private void a(Debug.MemoryInfo paramMemoryInfo, a parama)
  {
    parama.ctM = com.tencent.matrix.d.c.a.a("summary.java-heap", paramMemoryInfo);
    if (parama.ctM == -1) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                parama.ctN = com.tencent.matrix.d.c.a.a("summary.native-heap", paramMemoryInfo);
              } while (parama.ctN == -1);
              parama.ctQ = com.tencent.matrix.d.c.a.a("summary.code", paramMemoryInfo);
            } while (parama.ctQ == -1);
            parama.ctP = com.tencent.matrix.d.c.a.a("summary.stack", paramMemoryInfo);
          } while (parama.ctP == -1);
          parama.ctO = com.tencent.matrix.d.c.a.a("summary.graphics", paramMemoryInfo);
        } while (parama.ctO == -1);
        parama.ctR = com.tencent.matrix.d.c.a.a("summary.private-other", paramMemoryInfo);
      } while (parama.ctR == -1);
      parama.ctS = com.tencent.matrix.d.c.a.a("summary.total-pss", paramMemoryInfo);
    } while (parama.ctS == -1);
    parama.ctT = com.tencent.matrix.d.c.a.a(paramMemoryInfo);
    parama.ctK = ((int)com.tencent.matrix.g.a.getDalvikHeap());
    parama.ctL = ((int)com.tencent.matrix.g.a.getNativeHeap());
    com.tencent.matrix.g.c.i("Matrix.MemoryCanaryCore", "activity:" + this.ctB + ", totalpss:" + parama.ctS + ", uss:" + parama.ctT + ", java:" + parama.ctM + " , Native:" + parama.ctN + ", code:" + parama.ctQ + ", stack:" + parama.ctP + ", Graphics:" + parama.ctO + ", other:" + parama.ctR, new Object[0]);
  }
  
  private static void a(JSONObject paramJSONObject, a parama, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("pss", parama.ctS);
    localJSONObject.put("uss", parama.ctT);
    localJSONObject.put("java", parama.ctM);
    localJSONObject.put("native", parama.ctN);
    localJSONObject.put("graphics", parama.ctO);
    localJSONObject.put("stack", parama.ctP);
    localJSONObject.put("code", parama.ctQ);
    localJSONObject.put("other", parama.ctR);
    localJSONObject.put("dalvikHeap", parama.ctK);
    localJSONObject.put("nativeHeap", parama.ctL);
    localJSONObject.put("vmsize", com.tencent.matrix.g.a.HW());
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      localJSONObject.put("activity", paramString2);
    }
    paramJSONObject.put(paramString1, localJSONObject);
  }
  
  private void gR(int paramInt)
  {
    if (paramInt == 0) {}
    do
    {
      return;
      if ((this.ctC.containsKey(Integer.valueOf(paramInt))) && (System.currentTimeMillis() - ((Long)this.ctC.get(Integer.valueOf(paramInt))).longValue() < 600000L))
      {
        com.tencent.matrix.g.c.w("Matrix.MemoryCanaryCore", "trim memory too freq activity:%s, flag:%d", new Object[] { this.ctB, Integer.valueOf(paramInt) });
        return;
      }
      l = System.currentTimeMillis();
      localObject = com.tencent.matrix.g.a.aT(this.mContext);
    } while (localObject == null);
    long l = System.currentTimeMillis() - l;
    com.tencent.matrix.g.c.i("Matrix.MemoryCanaryCore", "get app memory cost:".concat(String.valueOf(l)), new Object[0]);
    if (l > 3000L)
    {
      this.mIsOpen = false;
      return;
    }
    a locala = new a(this.ctB);
    a((Debug.MemoryInfo)localObject, locala);
    Object localObject = new com.tencent.matrix.report.c();
    ((com.tencent.matrix.report.c)localObject).tag = this.ctr.getTag();
    ((com.tencent.matrix.report.c)localObject).type = 1;
    JSONObject localJSONObject = new JSONObject();
    ((com.tencent.matrix.report.c)localObject).cue = localJSONObject;
    try
    {
      localJSONObject.put("sysMem", ctt);
      localJSONObject.put("threshold", ctu);
      localJSONObject.put("memClass", ctv);
      localJSONObject.put("available", com.tencent.matrix.g.a.HT());
      a(localJSONObject, locala, "appmem", this.ctB);
      if (this.ctA) {}
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("front", i);
        localJSONObject.put("trimFlag", paramInt);
        localJSONObject.put("memfree", com.tencent.matrix.g.a.aS(this.mContext));
        localJSONObject.put("islow", com.tencent.matrix.g.a.aR(this.mContext));
        this.ctC.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
        onDetectIssue((com.tencent.matrix.report.c)localObject);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.matrix.g.c.e("Matrix.MemoryCanaryCore", "trim memory json exception:" + localException.toString(), new Object[0]);
    }
  }
  
  private int gS(int paramInt)
  {
    int i = 1;
    if (paramInt <= 0) {
      i = 0;
    }
    while (paramInt == 1) {
      return i;
    }
    if (paramInt == 2) {
      return 2;
    }
    if (paramInt >= 8) {
      return 30;
    }
    return gS(paramInt - 1) + gS(paramInt - 2);
  }
  
  public final long Ha()
  {
    long l1;
    if (this.ctz >= 8) {
      l1 = 1800000L;
    }
    long l2;
    long l3;
    do
    {
      return l1;
      l1 = System.currentTimeMillis();
      l2 = (gS(this.ctz) - gS(this.ctz - 1)) * 60000;
      l3 = System.currentTimeMillis() - l1;
      l1 = l2;
    } while (l3 <= 1000L);
    com.tencent.matrix.g.c.e("Matrix.MemoryCanaryCore", "[getNextDelay] cost time[%s] too long!", new Object[] { Long.valueOf(l3) });
    return l2;
  }
  
  public final JSONObject getJsonInfo()
  {
    JSONObject localJSONObject = new JSONObject();
    long l1 = com.tencent.matrix.g.a.getDalvikHeap();
    long l2 = com.tencent.matrix.g.a.getNativeHeap();
    try
    {
      localJSONObject.put("dalvikHeap", l1);
      localJSONObject.put("nativeHeap", l2);
      localJSONObject.put("sysMem", ctt);
      localJSONObject.put("memClass", ctv);
      localJSONObject.put("available", com.tencent.matrix.g.a.HT());
      localJSONObject.put("memfree", com.tencent.matrix.g.a.aS(this.mContext));
      localJSONObject.put("islow", com.tencent.matrix.g.a.aR(this.mContext));
      localJSONObject.put("vmSize", com.tencent.matrix.g.a.HW());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      com.tencent.matrix.g.c.e("Matrix.MemoryCanaryCore", "getJsonInfo exception:" + localJSONException.getMessage(), new Object[0]);
    }
    return localJSONObject;
  }
  
  public final void onDetectIssue(com.tencent.matrix.report.c paramc)
  {
    com.tencent.matrix.g.c.i("Matrix.MemoryCanaryCore", "detected memory json:" + paramc.cue.toString(), new Object[0]);
    this.ctr.onDetectIssue(paramc);
  }
  
  public static final class a
  {
    public int ctK = -1;
    public int ctL = -1;
    public int ctM = -1;
    public int ctN = -1;
    public int ctO = -1;
    public int ctP = -1;
    public int ctQ = -1;
    public int ctR = -1;
    public int ctS = -1;
    public int ctT = -1;
    public String ctU;
    
    a(String paramString)
    {
      this.ctU = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.d.b.a
 * JD-Core Version:    0.7.0.1
 */