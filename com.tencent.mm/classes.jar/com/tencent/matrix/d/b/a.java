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
  public static long cwl = 0L;
  public static long cwm = 0L;
  public static int cwn = 0;
  private final com.tencent.matrix.d.a cwj;
  public com.tencent.matrix.g.a.a cwk;
  private final com.tencent.matrix.d.a.a cwo;
  public long cwp;
  public int cwq;
  private boolean cwr = true;
  private String cws;
  public HashMap<Integer, Long> cwt;
  public final Runnable cwu = new Runnable()
  {
    public final void run()
    {
      a.a(a.this, false, 0);
    }
  };
  private final Runnable cwv = new Runnable()
  {
    public final void run()
    {
      a.a(a.this, false, 0);
    }
  };
  public final Application.ActivityLifecycleCallbacks cww = new Application.ActivityLifecycleCallbacks()
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
  public final ComponentCallbacks2 cwx = new ComponentCallbacks2()
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
      long l1 = com.tencent.matrix.g.a.aR(a.a(a.this));
      long l2 = com.tencent.matrix.g.a.aO(a.a(a.this));
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
  public final Handler mHandler = new Handler(b.Ip().getLooper());
  public boolean mIsOpen = false;
  public long mStartTime;
  
  public a(com.tencent.matrix.d.a parama)
  {
    this.cwj = parama;
    this.mContext = parama.getApplication();
    this.cwo = parama.cwg;
  }
  
  public static boolean Ho()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  private void a(Debug.MemoryInfo paramMemoryInfo, a parama)
  {
    parama.cwD = com.tencent.matrix.d.c.a.a("summary.java-heap", paramMemoryInfo);
    if (parama.cwD == -1) {}
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
                parama.cwE = com.tencent.matrix.d.c.a.a("summary.native-heap", paramMemoryInfo);
              } while (parama.cwE == -1);
              parama.cwH = com.tencent.matrix.d.c.a.a("summary.code", paramMemoryInfo);
            } while (parama.cwH == -1);
            parama.cwG = com.tencent.matrix.d.c.a.a("summary.stack", paramMemoryInfo);
          } while (parama.cwG == -1);
          parama.cwF = com.tencent.matrix.d.c.a.a("summary.graphics", paramMemoryInfo);
        } while (parama.cwF == -1);
        parama.cwI = com.tencent.matrix.d.c.a.a("summary.private-other", paramMemoryInfo);
      } while (parama.cwI == -1);
      parama.cwJ = com.tencent.matrix.d.c.a.a("summary.total-pss", paramMemoryInfo);
    } while (parama.cwJ == -1);
    parama.cwK = com.tencent.matrix.d.c.a.a(paramMemoryInfo);
    parama.cwB = ((int)com.tencent.matrix.g.a.getDalvikHeap());
    parama.cwC = ((int)com.tencent.matrix.g.a.getNativeHeap());
    com.tencent.matrix.g.c.i("Matrix.MemoryCanaryCore", "activity:" + this.cws + ", totalpss:" + parama.cwJ + ", uss:" + parama.cwK + ", java:" + parama.cwD + " , Native:" + parama.cwE + ", code:" + parama.cwH + ", stack:" + parama.cwG + ", Graphics:" + parama.cwF + ", other:" + parama.cwI, new Object[0]);
  }
  
  private static void a(JSONObject paramJSONObject, a parama, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("pss", parama.cwJ);
    localJSONObject.put("uss", parama.cwK);
    localJSONObject.put("java", parama.cwD);
    localJSONObject.put("native", parama.cwE);
    localJSONObject.put("graphics", parama.cwF);
    localJSONObject.put("stack", parama.cwG);
    localJSONObject.put("code", parama.cwH);
    localJSONObject.put("other", parama.cwI);
    localJSONObject.put("dalvikHeap", parama.cwB);
    localJSONObject.put("nativeHeap", parama.cwC);
    localJSONObject.put("vmsize", com.tencent.matrix.g.a.In());
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      localJSONObject.put("activity", paramString2);
    }
    paramJSONObject.put(paramString1, localJSONObject);
  }
  
  private void hi(int paramInt)
  {
    if (paramInt == 0) {}
    do
    {
      return;
      if ((this.cwt.containsKey(Integer.valueOf(paramInt))) && (System.currentTimeMillis() - ((Long)this.cwt.get(Integer.valueOf(paramInt))).longValue() < 600000L))
      {
        com.tencent.matrix.g.c.w("Matrix.MemoryCanaryCore", "trim memory too freq activity:%s, flag:%d", new Object[] { this.cws, Integer.valueOf(paramInt) });
        return;
      }
      l = System.currentTimeMillis();
      localObject = com.tencent.matrix.g.a.aS(this.mContext);
    } while (localObject == null);
    long l = System.currentTimeMillis() - l;
    com.tencent.matrix.g.c.i("Matrix.MemoryCanaryCore", "get app memory cost:".concat(String.valueOf(l)), new Object[0]);
    if (l > 3000L)
    {
      this.mIsOpen = false;
      return;
    }
    a locala = new a(this.cws);
    a((Debug.MemoryInfo)localObject, locala);
    Object localObject = new com.tencent.matrix.report.c();
    ((com.tencent.matrix.report.c)localObject).tag = this.cwj.getTag();
    ((com.tencent.matrix.report.c)localObject).type = 1;
    JSONObject localJSONObject = new JSONObject();
    ((com.tencent.matrix.report.c)localObject).cwV = localJSONObject;
    try
    {
      localJSONObject.put("sysMem", cwl);
      localJSONObject.put("threshold", cwm);
      localJSONObject.put("memClass", cwn);
      localJSONObject.put("available", com.tencent.matrix.g.a.Ik());
      a(localJSONObject, locala, "appmem", this.cws);
      if (this.cwr) {}
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("front", i);
        localJSONObject.put("trimFlag", paramInt);
        localJSONObject.put("memfree", com.tencent.matrix.g.a.aR(this.mContext));
        localJSONObject.put("islow", com.tencent.matrix.g.a.aQ(this.mContext));
        this.cwt.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
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
  
  private int hj(int paramInt)
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
    return hj(paramInt - 1) + hj(paramInt - 2);
  }
  
  public final long Hp()
  {
    long l1;
    if (this.cwq >= 8) {
      l1 = 1800000L;
    }
    long l2;
    long l3;
    do
    {
      return l1;
      l1 = System.currentTimeMillis();
      l2 = (hj(this.cwq) - hj(this.cwq - 1)) * 60000;
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
      localJSONObject.put("sysMem", cwl);
      localJSONObject.put("memClass", cwn);
      localJSONObject.put("available", com.tencent.matrix.g.a.Ik());
      localJSONObject.put("memfree", com.tencent.matrix.g.a.aR(this.mContext));
      localJSONObject.put("islow", com.tencent.matrix.g.a.aQ(this.mContext));
      localJSONObject.put("vmSize", com.tencent.matrix.g.a.In());
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
    com.tencent.matrix.g.c.i("Matrix.MemoryCanaryCore", "detected memory json:" + paramc.cwV.toString(), new Object[0]);
    this.cwj.onDetectIssue(paramc);
  }
  
  public static final class a
  {
    public int cwB = -1;
    public int cwC = -1;
    public int cwD = -1;
    public int cwE = -1;
    public int cwF = -1;
    public int cwG = -1;
    public int cwH = -1;
    public int cwI = -1;
    public int cwJ = -1;
    public int cwK = -1;
    public String cwL;
    
    a(String paramString)
    {
      this.cwL = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.d.b.a
 * JD-Core Version:    0.7.0.1
 */