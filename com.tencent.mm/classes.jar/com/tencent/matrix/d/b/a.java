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
  public static long cEW = 0L;
  public static long cEX = 0L;
  public static int cEY = 0;
  private final com.tencent.matrix.d.a cEU;
  public com.tencent.matrix.g.a.a cEV;
  private final com.tencent.matrix.d.a.a cEZ;
  public long cFa;
  public int cFb;
  private boolean cFc = true;
  private String cFd;
  public HashMap<Integer, Long> cFe;
  public final Runnable cFf = new Runnable()
  {
    public final void run()
    {
      a.a(a.this, false, 0);
    }
  };
  private final Runnable cFg = new Runnable()
  {
    public final void run()
    {
      a.a(a.this, false, 0);
    }
  };
  public final Application.ActivityLifecycleCallbacks cFh = new Application.ActivityLifecycleCallbacks()
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
  public final ComponentCallbacks2 cFi = new ComponentCallbacks2()
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
      long l1 = com.tencent.matrix.g.a.aT(a.a(a.this));
      long l2 = com.tencent.matrix.g.a.aQ(a.a(a.this));
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
  public final Context mContext;
  public final Handler mHandler = new Handler(b.JB().getLooper());
  public boolean mIsOpen = false;
  public long mStartTime;
  
  public a(com.tencent.matrix.d.a parama)
  {
    this.cEU = parama;
    this.mContext = parama.getApplication();
    this.cEZ = parama.cER;
  }
  
  public static boolean IC()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  private void a(Debug.MemoryInfo paramMemoryInfo, a parama)
  {
    parama.cFo = com.tencent.matrix.d.c.a.a("summary.java-heap", paramMemoryInfo);
    if (parama.cFo == -1) {}
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
                parama.cFp = com.tencent.matrix.d.c.a.a("summary.native-heap", paramMemoryInfo);
              } while (parama.cFp == -1);
              parama.cFs = com.tencent.matrix.d.c.a.a("summary.code", paramMemoryInfo);
            } while (parama.cFs == -1);
            parama.cFr = com.tencent.matrix.d.c.a.a("summary.stack", paramMemoryInfo);
          } while (parama.cFr == -1);
          parama.cFq = com.tencent.matrix.d.c.a.a("summary.graphics", paramMemoryInfo);
        } while (parama.cFq == -1);
        parama.cFt = com.tencent.matrix.d.c.a.a("summary.private-other", paramMemoryInfo);
      } while (parama.cFt == -1);
      parama.cFu = com.tencent.matrix.d.c.a.a("summary.total-pss", paramMemoryInfo);
    } while (parama.cFu == -1);
    parama.cFv = com.tencent.matrix.d.c.a.a(paramMemoryInfo);
    parama.cFm = ((int)com.tencent.matrix.g.a.getDalvikHeap());
    parama.cFn = ((int)com.tencent.matrix.g.a.getNativeHeap());
    com.tencent.matrix.g.c.i("Matrix.MemoryCanaryCore", "activity:" + this.cFd + ", totalpss:" + parama.cFu + ", uss:" + parama.cFv + ", java:" + parama.cFo + " , Native:" + parama.cFp + ", code:" + parama.cFs + ", stack:" + parama.cFr + ", Graphics:" + parama.cFq + ", other:" + parama.cFt, new Object[0]);
  }
  
  private static void a(JSONObject paramJSONObject, a parama, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("pss", parama.cFu);
    localJSONObject.put("uss", parama.cFv);
    localJSONObject.put("java", parama.cFo);
    localJSONObject.put("native", parama.cFp);
    localJSONObject.put("graphics", parama.cFq);
    localJSONObject.put("stack", parama.cFr);
    localJSONObject.put("code", parama.cFs);
    localJSONObject.put("other", parama.cFt);
    localJSONObject.put("dalvikHeap", parama.cFm);
    localJSONObject.put("nativeHeap", parama.cFn);
    localJSONObject.put("vmsize", com.tencent.matrix.g.a.Jz());
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      localJSONObject.put("activity", paramString2);
    }
    paramJSONObject.put(paramString1, localJSONObject);
  }
  
  private void gX(int paramInt)
  {
    if (paramInt == 0) {}
    do
    {
      return;
      if ((this.cFe.containsKey(Integer.valueOf(paramInt))) && (System.currentTimeMillis() - ((Long)this.cFe.get(Integer.valueOf(paramInt))).longValue() < 600000L))
      {
        com.tencent.matrix.g.c.w("Matrix.MemoryCanaryCore", "trim memory too freq activity:%s, flag:%d", new Object[] { this.cFd, Integer.valueOf(paramInt) });
        return;
      }
      l = System.currentTimeMillis();
      localObject = com.tencent.matrix.g.a.aU(this.mContext);
    } while (localObject == null);
    long l = System.currentTimeMillis() - l;
    com.tencent.matrix.g.c.i("Matrix.MemoryCanaryCore", "get app memory cost:".concat(String.valueOf(l)), new Object[0]);
    if (l > 3000L)
    {
      this.mIsOpen = false;
      return;
    }
    a locala = new a(this.cFd);
    a((Debug.MemoryInfo)localObject, locala);
    Object localObject = new com.tencent.matrix.report.c();
    ((com.tencent.matrix.report.c)localObject).tag = this.cEU.getTag();
    ((com.tencent.matrix.report.c)localObject).type = 1;
    JSONObject localJSONObject = new JSONObject();
    ((com.tencent.matrix.report.c)localObject).cFG = localJSONObject;
    try
    {
      localJSONObject.put("sysMem", cEW);
      localJSONObject.put("threshold", cEX);
      localJSONObject.put("memClass", cEY);
      localJSONObject.put("available", com.tencent.matrix.g.a.Jw());
      a(localJSONObject, locala, "appmem", this.cFd);
      if (this.cFc) {}
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("front", i);
        localJSONObject.put("trimFlag", paramInt);
        localJSONObject.put("memfree", com.tencent.matrix.g.a.aT(this.mContext));
        localJSONObject.put("islow", com.tencent.matrix.g.a.aS(this.mContext));
        this.cFe.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
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
  
  private int gY(int paramInt)
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
    return gY(paramInt - 1) + gY(paramInt - 2);
  }
  
  public final long ID()
  {
    long l1;
    if (this.cFb >= 8) {
      l1 = 1800000L;
    }
    long l2;
    long l3;
    do
    {
      return l1;
      l1 = System.currentTimeMillis();
      l2 = (gY(this.cFb) - gY(this.cFb - 1)) * 60000;
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
      localJSONObject.put("sysMem", cEW);
      localJSONObject.put("memClass", cEY);
      localJSONObject.put("available", com.tencent.matrix.g.a.Jw());
      localJSONObject.put("memfree", com.tencent.matrix.g.a.aT(this.mContext));
      localJSONObject.put("islow", com.tencent.matrix.g.a.aS(this.mContext));
      localJSONObject.put("vmSize", com.tencent.matrix.g.a.Jz());
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
    com.tencent.matrix.g.c.i("Matrix.MemoryCanaryCore", "detected memory json:" + paramc.cFG.toString(), new Object[0]);
    this.cEU.onDetectIssue(paramc);
  }
  
  public static final class a
  {
    public int cFm = -1;
    public int cFn = -1;
    public int cFo = -1;
    public int cFp = -1;
    public int cFq = -1;
    public int cFr = -1;
    public int cFs = -1;
    public int cFt = -1;
    public int cFu = -1;
    public int cFv = -1;
    public String cFw;
    
    a(String paramString)
    {
      this.cFw = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.d.b.a
 * JD-Core Version:    0.7.0.1
 */