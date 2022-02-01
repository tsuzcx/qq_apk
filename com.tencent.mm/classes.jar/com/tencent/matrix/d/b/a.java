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
  public static long cEp = 0L;
  public static long cEq = 0L;
  public static int cEr = 0;
  public final Application.ActivityLifecycleCallbacks cEA = new Application.ActivityLifecycleCallbacks()
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
  public final ComponentCallbacks2 cEB = new ComponentCallbacks2()
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
  private final com.tencent.matrix.d.a cEn;
  public com.tencent.matrix.g.a.a cEo;
  private final com.tencent.matrix.d.a.a cEs;
  public long cEt;
  public int cEu;
  private boolean cEv = true;
  private String cEw;
  public HashMap<Integer, Long> cEx;
  public final Runnable cEy = new Runnable()
  {
    public final void run()
    {
      a.a(a.this, false, 0);
    }
  };
  private final Runnable cEz = new Runnable()
  {
    public final void run()
    {
      a.a(a.this, false, 0);
    }
  };
  public final Context mContext;
  public final Handler mHandler = new Handler(b.Jt().getLooper());
  public boolean mIsOpen = false;
  public long mStartTime;
  
  public a(com.tencent.matrix.d.a parama)
  {
    this.cEn = parama;
    this.mContext = parama.getApplication();
    this.cEs = parama.cEk;
  }
  
  public static boolean Iu()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  private void a(Debug.MemoryInfo paramMemoryInfo, a parama)
  {
    parama.cEH = com.tencent.matrix.d.c.a.a("summary.java-heap", paramMemoryInfo);
    if (parama.cEH == -1) {}
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
                parama.cEI = com.tencent.matrix.d.c.a.a("summary.native-heap", paramMemoryInfo);
              } while (parama.cEI == -1);
              parama.cEL = com.tencent.matrix.d.c.a.a("summary.code", paramMemoryInfo);
            } while (parama.cEL == -1);
            parama.cEK = com.tencent.matrix.d.c.a.a("summary.stack", paramMemoryInfo);
          } while (parama.cEK == -1);
          parama.cEJ = com.tencent.matrix.d.c.a.a("summary.graphics", paramMemoryInfo);
        } while (parama.cEJ == -1);
        parama.cEM = com.tencent.matrix.d.c.a.a("summary.private-other", paramMemoryInfo);
      } while (parama.cEM == -1);
      parama.cEN = com.tencent.matrix.d.c.a.a("summary.total-pss", paramMemoryInfo);
    } while (parama.cEN == -1);
    parama.cEO = com.tencent.matrix.d.c.a.a(paramMemoryInfo);
    parama.cEF = ((int)com.tencent.matrix.g.a.getDalvikHeap());
    parama.cEG = ((int)com.tencent.matrix.g.a.getNativeHeap());
    com.tencent.matrix.g.c.i("Matrix.MemoryCanaryCore", "activity:" + this.cEw + ", totalpss:" + parama.cEN + ", uss:" + parama.cEO + ", java:" + parama.cEH + " , Native:" + parama.cEI + ", code:" + parama.cEL + ", stack:" + parama.cEK + ", Graphics:" + parama.cEJ + ", other:" + parama.cEM, new Object[0]);
  }
  
  private static void a(JSONObject paramJSONObject, a parama, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("pss", parama.cEN);
    localJSONObject.put("uss", parama.cEO);
    localJSONObject.put("java", parama.cEH);
    localJSONObject.put("native", parama.cEI);
    localJSONObject.put("graphics", parama.cEJ);
    localJSONObject.put("stack", parama.cEK);
    localJSONObject.put("code", parama.cEL);
    localJSONObject.put("other", parama.cEM);
    localJSONObject.put("dalvikHeap", parama.cEF);
    localJSONObject.put("nativeHeap", parama.cEG);
    localJSONObject.put("vmsize", com.tencent.matrix.g.a.Jr());
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      localJSONObject.put("activity", paramString2);
    }
    paramJSONObject.put(paramString1, localJSONObject);
  }
  
  private void gW(int paramInt)
  {
    if (paramInt == 0) {}
    do
    {
      return;
      if ((this.cEx.containsKey(Integer.valueOf(paramInt))) && (System.currentTimeMillis() - ((Long)this.cEx.get(Integer.valueOf(paramInt))).longValue() < 600000L))
      {
        com.tencent.matrix.g.c.w("Matrix.MemoryCanaryCore", "trim memory too freq activity:%s, flag:%d", new Object[] { this.cEw, Integer.valueOf(paramInt) });
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
    a locala = new a(this.cEw);
    a((Debug.MemoryInfo)localObject, locala);
    Object localObject = new com.tencent.matrix.report.c();
    ((com.tencent.matrix.report.c)localObject).tag = this.cEn.getTag();
    ((com.tencent.matrix.report.c)localObject).type = 1;
    JSONObject localJSONObject = new JSONObject();
    ((com.tencent.matrix.report.c)localObject).cEZ = localJSONObject;
    try
    {
      localJSONObject.put("sysMem", cEp);
      localJSONObject.put("threshold", cEq);
      localJSONObject.put("memClass", cEr);
      localJSONObject.put("available", com.tencent.matrix.g.a.Jo());
      a(localJSONObject, locala, "appmem", this.cEw);
      if (this.cEv) {}
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("front", i);
        localJSONObject.put("trimFlag", paramInt);
        localJSONObject.put("memfree", com.tencent.matrix.g.a.aS(this.mContext));
        localJSONObject.put("islow", com.tencent.matrix.g.a.aR(this.mContext));
        this.cEx.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
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
  
  private int gX(int paramInt)
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
    return gX(paramInt - 1) + gX(paramInt - 2);
  }
  
  public final long Iv()
  {
    long l1;
    if (this.cEu >= 8) {
      l1 = 1800000L;
    }
    long l2;
    long l3;
    do
    {
      return l1;
      l1 = System.currentTimeMillis();
      l2 = (gX(this.cEu) - gX(this.cEu - 1)) * 60000;
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
      localJSONObject.put("sysMem", cEp);
      localJSONObject.put("memClass", cEr);
      localJSONObject.put("available", com.tencent.matrix.g.a.Jo());
      localJSONObject.put("memfree", com.tencent.matrix.g.a.aS(this.mContext));
      localJSONObject.put("islow", com.tencent.matrix.g.a.aR(this.mContext));
      localJSONObject.put("vmSize", com.tencent.matrix.g.a.Jr());
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
    com.tencent.matrix.g.c.i("Matrix.MemoryCanaryCore", "detected memory json:" + paramc.cEZ.toString(), new Object[0]);
    this.cEn.onDetectIssue(paramc);
  }
  
  public static final class a
  {
    public int cEF = -1;
    public int cEG = -1;
    public int cEH = -1;
    public int cEI = -1;
    public int cEJ = -1;
    public int cEK = -1;
    public int cEL = -1;
    public int cEM = -1;
    public int cEN = -1;
    public int cEO = -1;
    public String cEP;
    
    a(String paramString)
    {
      this.cEP = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.d.b.a
 * JD-Core Version:    0.7.0.1
 */