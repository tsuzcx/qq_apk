package com.tencent.matrix.c.b;

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
import com.tencent.matrix.e.c.a;
import com.tencent.matrix.g.c;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements c.a
{
  public static long bNR = 0L;
  public static long bNS = 0L;
  public static int bNT = 0;
  private final com.tencent.matrix.c.a bNP;
  public com.tencent.matrix.g.a.a bNQ;
  private final com.tencent.matrix.c.a.a bNU;
  public long bNV;
  public int bNW;
  private boolean bNX = true;
  private String bNY;
  public HashMap<Integer, Long> bNZ;
  public final Runnable bOa = new Runnable()
  {
    public final void run()
    {
      a.a(a.this, false, 0);
    }
  };
  private final Runnable bOb = new Runnable()
  {
    public final void run()
    {
      a.a(a.this, false, 0);
    }
  };
  public final Application.ActivityLifecycleCallbacks bOc = new Application.ActivityLifecycleCallbacks()
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
  public final ComponentCallbacks2 bOd = new ComponentCallbacks2()
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
      long l1 = com.tencent.matrix.g.a.aG(a.a(a.this));
      long l2 = com.tencent.matrix.g.a.aD(a.a(a.this));
      if (l1 >= 2L * l2)
      {
        c.i("Matrix.MemoryCanaryCore", "onTrimMemory level:%d, but memFree > 2*threshold, memFree:%d, threshold:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(l1), Long.valueOf(l2) });
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
  public final Handler mHandler = new Handler(com.tencent.matrix.g.b.zI().getLooper());
  public boolean mIsOpen = false;
  public long mStartTime;
  
  public a(com.tencent.matrix.c.a parama)
  {
    this.bNP = parama;
    this.mContext = parama.getApplication();
    this.bNU = parama.bNM;
  }
  
  private void a(Debug.MemoryInfo paramMemoryInfo, a parama)
  {
    parama.bOj = com.tencent.matrix.c.c.a.a("summary.java-heap", paramMemoryInfo);
    if (parama.bOj == -1) {}
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
                parama.bOk = com.tencent.matrix.c.c.a.a("summary.native-heap", paramMemoryInfo);
              } while (parama.bOk == -1);
              parama.bOn = com.tencent.matrix.c.c.a.a("summary.code", paramMemoryInfo);
            } while (parama.bOn == -1);
            parama.bOm = com.tencent.matrix.c.c.a.a("summary.stack", paramMemoryInfo);
          } while (parama.bOm == -1);
          parama.bOl = com.tencent.matrix.c.c.a.a("summary.graphics", paramMemoryInfo);
        } while (parama.bOl == -1);
        parama.bOo = com.tencent.matrix.c.c.a.a("summary.private-other", paramMemoryInfo);
      } while (parama.bOo == -1);
      parama.bOp = com.tencent.matrix.c.c.a.a("summary.total-pss", paramMemoryInfo);
    } while (parama.bOp == -1);
    parama.bOq = com.tencent.matrix.c.c.a.a(paramMemoryInfo);
    parama.bOh = ((int)com.tencent.matrix.g.a.getDalvikHeap());
    parama.bOi = ((int)com.tencent.matrix.g.a.getNativeHeap());
    c.i("Matrix.MemoryCanaryCore", "activity:" + this.bNY + ", totalpss:" + parama.bOp + ", uss:" + parama.bOq + ", java:" + parama.bOj + " , Native:" + parama.bOk + ", code:" + parama.bOn + ", stack:" + parama.bOm + ", Graphics:" + parama.bOl + ", other:" + parama.bOo, new Object[0]);
  }
  
  private static void a(JSONObject paramJSONObject, a parama, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("pss", parama.bOp);
    localJSONObject.put("uss", parama.bOq);
    localJSONObject.put("java", parama.bOj);
    localJSONObject.put("native", parama.bOk);
    localJSONObject.put("graphics", parama.bOl);
    localJSONObject.put("stack", parama.bOm);
    localJSONObject.put("code", parama.bOn);
    localJSONObject.put("other", parama.bOo);
    localJSONObject.put("dalvikHeap", parama.bOh);
    localJSONObject.put("nativeHeap", parama.bOi);
    localJSONObject.put("vmsize", com.tencent.matrix.g.a.zG());
    if (!paramString2.isEmpty()) {
      localJSONObject.put("activity", paramString2);
    }
    paramJSONObject.put(paramString1, localJSONObject);
  }
  
  private void fM(int paramInt)
  {
    if (paramInt == 0) {}
    do
    {
      return;
      if ((this.bNZ.containsKey(Integer.valueOf(paramInt))) && (System.currentTimeMillis() - ((Long)this.bNZ.get(Integer.valueOf(paramInt))).longValue() < 600000L))
      {
        c.w("Matrix.MemoryCanaryCore", "trim memory too freq activity:%s, flag:%d", new Object[] { this.bNY, Integer.valueOf(paramInt) });
        return;
      }
      l = System.currentTimeMillis();
      localObject = com.tencent.matrix.g.a.aH(this.mContext);
    } while (localObject == null);
    long l = System.currentTimeMillis() - l;
    c.i("Matrix.MemoryCanaryCore", "get app memory cost:".concat(String.valueOf(l)), new Object[0]);
    if (l > 3000L)
    {
      this.mIsOpen = false;
      return;
    }
    a locala = new a(this.bNY);
    a((Debug.MemoryInfo)localObject, locala);
    Object localObject = new com.tencent.matrix.e.b();
    ((com.tencent.matrix.e.b)localObject).tag = this.bNP.getTag();
    ((com.tencent.matrix.e.b)localObject).setType(1);
    JSONObject localJSONObject = new JSONObject();
    ((com.tencent.matrix.e.b)localObject).bOx = localJSONObject;
    try
    {
      localJSONObject.put("sysMem", bNR);
      localJSONObject.put("threshold", bNS);
      localJSONObject.put("memClass", bNT);
      localJSONObject.put("available", com.tencent.matrix.g.a.zD());
      a(localJSONObject, locala, "appmem", this.bNY);
      if (this.bNX) {}
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("front", i);
        localJSONObject.put("trimFlag", paramInt);
        localJSONObject.put("memfree", com.tencent.matrix.g.a.aG(this.mContext));
        localJSONObject.put("islow", com.tencent.matrix.g.a.aF(this.mContext));
        this.bNZ.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
        onDetectIssue((com.tencent.matrix.e.b)localObject);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      c.e("Matrix.MemoryCanaryCore", "trim memory json exception:" + localException.toString(), new Object[0]);
    }
  }
  
  private int fN(int paramInt)
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
    return fN(paramInt - 1) + fN(paramInt - 2);
  }
  
  public static boolean za()
  {
    return Build.VERSION.SDK_INT >= 23;
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
      localJSONObject.put("sysMem", bNR);
      localJSONObject.put("memClass", bNT);
      localJSONObject.put("available", com.tencent.matrix.g.a.zD());
      localJSONObject.put("memfree", com.tencent.matrix.g.a.aG(this.mContext));
      localJSONObject.put("islow", com.tencent.matrix.g.a.aF(this.mContext));
      localJSONObject.put("vmSize", com.tencent.matrix.g.a.zG());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      c.e("Matrix.MemoryCanaryCore", "getJsonInfo exception:" + localJSONException.getMessage(), new Object[0]);
    }
    return localJSONObject;
  }
  
  public final void onDetectIssue(com.tencent.matrix.e.b paramb)
  {
    c.i("Matrix.MemoryCanaryCore", "detected memory json:" + paramb.bOx.toString(), new Object[0]);
    this.bNP.onDetectIssue(paramb);
  }
  
  public final long zb()
  {
    long l1;
    if (this.bNW >= 8) {
      l1 = 1800000L;
    }
    long l2;
    long l3;
    do
    {
      return l1;
      l1 = System.currentTimeMillis();
      l2 = (fN(this.bNW) - fN(this.bNW - 1)) * 60000;
      l3 = System.currentTimeMillis() - l1;
      l1 = l2;
    } while (l3 <= 1000L);
    c.e("Matrix.MemoryCanaryCore", "[getNextDelay] cost time[%s] too long!", new Object[] { Long.valueOf(l3) });
    return l2;
  }
  
  public static final class a
  {
    public int bOh = -1;
    public int bOi = -1;
    public int bOj = -1;
    public int bOk = -1;
    public int bOl = -1;
    public int bOm = -1;
    public int bOn = -1;
    public int bOo = -1;
    public int bOp = -1;
    public int bOq = -1;
    public String bOr;
    
    a(String paramString)
    {
      this.bOr = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.c.b.a
 * JD-Core Version:    0.7.0.1
 */