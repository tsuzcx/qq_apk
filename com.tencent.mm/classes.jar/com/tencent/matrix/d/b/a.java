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
  public static long cVA = 0L;
  public static long cVB = 0L;
  public static int cVC = 0;
  private final com.tencent.matrix.d.a.a cVD;
  public long cVE;
  public int cVF;
  private String cVG;
  public HashMap<Integer, Long> cVH;
  public final Runnable cVI = new Runnable()
  {
    public final void run()
    {
      a.a(a.this, false, 0);
    }
  };
  private final Runnable cVJ = new Runnable()
  {
    public final void run()
    {
      a.a(a.this, false, 0);
    }
  };
  public final Application.ActivityLifecycleCallbacks cVK = new Application.ActivityLifecycleCallbacks()
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
  public final ComponentCallbacks2 cVL = new ComponentCallbacks2()
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
      long l1 = com.tencent.matrix.g.a.bn(a.a(a.this));
      long l2 = com.tencent.matrix.g.a.bk(a.a(a.this));
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
  private final com.tencent.matrix.d.a cVy;
  public com.tencent.matrix.g.a.a cVz;
  public final Context mContext;
  public final Handler mHandler = new Handler(b.TP().getLooper());
  private boolean mIsForeground = true;
  public boolean mIsOpen = false;
  public long mStartTime;
  
  public a(com.tencent.matrix.d.a parama)
  {
    this.cVy = parama;
    this.mContext = parama.getApplication();
    this.cVD = parama.cVv;
  }
  
  public static boolean SL()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  private void a(Debug.MemoryInfo paramMemoryInfo, a parama)
  {
    parama.cVR = com.tencent.matrix.d.c.a.a("summary.java-heap", paramMemoryInfo);
    if (parama.cVR == -1) {}
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
                parama.cVS = com.tencent.matrix.d.c.a.a("summary.native-heap", paramMemoryInfo);
              } while (parama.cVS == -1);
              parama.cVV = com.tencent.matrix.d.c.a.a("summary.code", paramMemoryInfo);
            } while (parama.cVV == -1);
            parama.cVU = com.tencent.matrix.d.c.a.a("summary.stack", paramMemoryInfo);
          } while (parama.cVU == -1);
          parama.cVT = com.tencent.matrix.d.c.a.a("summary.graphics", paramMemoryInfo);
        } while (parama.cVT == -1);
        parama.cVW = com.tencent.matrix.d.c.a.a("summary.private-other", paramMemoryInfo);
      } while (parama.cVW == -1);
      parama.cVX = com.tencent.matrix.d.c.a.a("summary.total-pss", paramMemoryInfo);
    } while (parama.cVX == -1);
    parama.cVY = com.tencent.matrix.d.c.a.a(paramMemoryInfo);
    parama.cVP = ((int)com.tencent.matrix.g.a.getDalvikHeap());
    parama.cVQ = ((int)com.tencent.matrix.g.a.getNativeHeap());
    com.tencent.matrix.g.c.i("Matrix.MemoryCanaryCore", "activity:" + this.cVG + ", totalpss:" + parama.cVX + ", uss:" + parama.cVY + ", java:" + parama.cVR + " , Native:" + parama.cVS + ", code:" + parama.cVV + ", stack:" + parama.cVU + ", Graphics:" + parama.cVT + ", other:" + parama.cVW, new Object[0]);
  }
  
  private static void a(JSONObject paramJSONObject, a parama, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("pss", parama.cVX);
    localJSONObject.put("uss", parama.cVY);
    localJSONObject.put("java", parama.cVR);
    localJSONObject.put("native", parama.cVS);
    localJSONObject.put("graphics", parama.cVT);
    localJSONObject.put("stack", parama.cVU);
    localJSONObject.put("code", parama.cVV);
    localJSONObject.put("other", parama.cVW);
    localJSONObject.put("dalvikHeap", parama.cVP);
    localJSONObject.put("nativeHeap", parama.cVQ);
    localJSONObject.put("vmsize", com.tencent.matrix.g.a.TN());
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      localJSONObject.put("activity", paramString2);
    }
    paramJSONObject.put(paramString1, localJSONObject);
  }
  
  private void iq(int paramInt)
  {
    if (paramInt == 0) {}
    do
    {
      return;
      if ((this.cVH.containsKey(Integer.valueOf(paramInt))) && (System.currentTimeMillis() - ((Long)this.cVH.get(Integer.valueOf(paramInt))).longValue() < 600000L))
      {
        com.tencent.matrix.g.c.w("Matrix.MemoryCanaryCore", "trim memory too freq activity:%s, flag:%d", new Object[] { this.cVG, Integer.valueOf(paramInt) });
        return;
      }
      l = System.currentTimeMillis();
      localObject = com.tencent.matrix.g.a.bo(this.mContext);
    } while (localObject == null);
    long l = System.currentTimeMillis() - l;
    com.tencent.matrix.g.c.i("Matrix.MemoryCanaryCore", "get app memory cost:".concat(String.valueOf(l)), new Object[0]);
    if (l > 3000L)
    {
      this.mIsOpen = false;
      return;
    }
    a locala = new a(this.cVG);
    a((Debug.MemoryInfo)localObject, locala);
    Object localObject = new com.tencent.matrix.report.c();
    ((com.tencent.matrix.report.c)localObject).tag = this.cVy.getTag();
    ((com.tencent.matrix.report.c)localObject).type = 1;
    JSONObject localJSONObject = new JSONObject();
    ((com.tencent.matrix.report.c)localObject).cWe = localJSONObject;
    try
    {
      localJSONObject.put("sysMem", cVA);
      localJSONObject.put("threshold", cVB);
      localJSONObject.put("memClass", cVC);
      localJSONObject.put("available", com.tencent.matrix.g.a.TK());
      a(localJSONObject, locala, "appmem", this.cVG);
      if (this.mIsForeground) {}
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("front", i);
        localJSONObject.put("trimFlag", paramInt);
        localJSONObject.put("memfree", com.tencent.matrix.g.a.bn(this.mContext));
        localJSONObject.put("islow", com.tencent.matrix.g.a.bm(this.mContext));
        this.cVH.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
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
  
  private int ir(int paramInt)
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
    return ir(paramInt - 1) + ir(paramInt - 2);
  }
  
  public final long SM()
  {
    long l1;
    if (this.cVF >= 8) {
      l1 = 1800000L;
    }
    long l2;
    long l3;
    do
    {
      return l1;
      l1 = System.currentTimeMillis();
      l2 = (ir(this.cVF) - ir(this.cVF - 1)) * 60000;
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
      localJSONObject.put("sysMem", cVA);
      localJSONObject.put("memClass", cVC);
      localJSONObject.put("available", com.tencent.matrix.g.a.TK());
      localJSONObject.put("memfree", com.tencent.matrix.g.a.bn(this.mContext));
      localJSONObject.put("islow", com.tencent.matrix.g.a.bm(this.mContext));
      localJSONObject.put("vmSize", com.tencent.matrix.g.a.TN());
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
    com.tencent.matrix.g.c.i("Matrix.MemoryCanaryCore", "detected memory json:" + paramc.cWe.toString(), new Object[0]);
    this.cVy.onDetectIssue(paramc);
  }
  
  public static final class a
  {
    public int cVP = -1;
    public int cVQ = -1;
    public int cVR = -1;
    public int cVS = -1;
    public int cVT = -1;
    public int cVU = -1;
    public int cVV = -1;
    public int cVW = -1;
    public int cVX = -1;
    public int cVY = -1;
    public String cVZ;
    
    a(String paramString)
    {
      this.cVZ = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.d.b.a
 * JD-Core Version:    0.7.0.1
 */