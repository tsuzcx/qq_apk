package com.tencent.matrix.trace.e;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.trace.c.c;
import com.tencent.matrix.trace.core.MethodBeat;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends a
  implements c
{
  private final com.tencent.matrix.trace.a.a bqr;
  private boolean bss = true;
  private String bst = "";
  private int bsu;
  private final HashMap<String, Long> bsv = new HashMap();
  private final HashMap<String, Long> bsw = new HashMap();
  private final Handler mHandler;
  
  public e(com.tencent.matrix.trace.a parama, com.tencent.matrix.trace.a.a parama1)
  {
    super(parama);
    this.bqr = parama1;
    this.mHandler = new Handler(com.tencent.matrix.d.a.rt().getLooper());
  }
  
  private static long a(HashMap<String, Long> paramHashMap, String paramString)
  {
    if ((paramHashMap == null) || (paramString == null) || (!paramHashMap.containsKey(paramString)))
    {
      paramHashMap = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramHashMap = "null";
      }
      com.tencent.matrix.d.b.w("Matrix.StartUpTracer", "[getValueFromMap] key:%s", new Object[] { paramHashMap });
      return 0L;
    }
    return ((Long)paramHashMap.get(paramString)).longValue();
  }
  
  public final void a(Activity paramActivity, boolean paramBoolean, int paramInt, long[] paramArrayOfLong)
  {
    if ((!this.bss) || (this.bst == null))
    {
      this.bss = false;
      a.brt.lockBuffer(false);
      return;
    }
    paramActivity = paramActivity.getComponentName().getClassName();
    if ((!this.bsw.containsKey(paramActivity)) || (paramBoolean)) {
      this.bsw.put(paramActivity, Long.valueOf(System.currentTimeMillis()));
    }
    if (!paramBoolean)
    {
      com.tencent.matrix.d.b.i("Matrix.StartUpTracer", "[onActivityEntered] isFocus false,activityName:%s", new Object[] { paramActivity });
      return;
    }
    if ((this.bqr.rm()) && (paramActivity.equals(this.bqr.bqH)))
    {
      com.tencent.matrix.d.b.i("Matrix.StartUpTracer", "[onActivityEntered] has splash activity! %s", new Object[] { this.bqr.bqH });
      return;
    }
    a.brt.lockBuffer(false);
    long l2 = a(this.bsw, paramActivity);
    long l1 = a(this.bsv, this.bst);
    if ((l2 <= 0L) || (l1 <= 0L))
    {
      com.tencent.matrix.d.b.w("Matrix.StartUpTracer", "[onActivityEntered] error activityCost! [%s:%s]", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
      this.bsv.clear();
      this.bsw.clear();
      return;
    }
    long l5;
    long l6;
    if (l1 - com.tencent.matrix.trace.b.b.brk > 2000L)
    {
      paramBoolean = true;
      l5 = l2 - l1;
      l6 = com.tencent.matrix.trace.b.b.brk - com.tencent.matrix.trace.b.b.bri;
      l3 = com.tencent.matrix.trace.b.b.brk;
      l2 -= com.tencent.matrix.trace.b.b.bri;
      if (!paramBoolean) {
        break label688;
      }
      l2 = l5;
    }
    label669:
    label681:
    label688:
    for (long l3 = 0L;; l3 = l1 - l3)
    {
      l1 = 0L;
      if (this.bqr.rm())
      {
        l1 = a(this.bsw, this.bqr.bqH);
        if (l1 != 0L) {
          break label357;
        }
      }
      label357:
      for (l1 = 0L;; l1 = a(this.bsw, paramActivity) - l1)
      {
        if (l6 > 0L) {
          break label373;
        }
        com.tencent.matrix.d.b.e("Matrix.StartUpTracer", "[onActivityEntered] appCreateTime is wrong! appCreateTime:%s", new Object[] { Long.valueOf(l6) });
        this.bsv.clear();
        this.bsw.clear();
        return;
        paramBoolean = false;
        break;
      }
      label373:
      if ((this.bqr.rm()) && (l1 < 0L))
      {
        com.tencent.matrix.d.b.e("Matrix.StartUpTracer", "splashCost < 0! splashCost:%s", new Object[] { Long.valueOf(l1) });
        return;
      }
      long l4;
      if ((b)m(b.class) != null)
      {
        if (!paramBoolean) {
          break label669;
        }
        l4 = this.bqr.bqD;
        if (!paramBoolean) {
          break label681;
        }
      }
      for (paramInt = this.bsu;; paramInt = com.tencent.matrix.trace.b.b.brj)
      {
        int i = MethodBeat.getCurIndex();
        if (l2 > l4)
        {
          com.tencent.matrix.d.b.i("Matrix.StartUpTracer", "appCreateTime[%s] is over threshold![%s], dump stack! index[%s:%s]", new Object[] { Long.valueOf(l6), Long.valueOf(l4), Integer.valueOf(paramInt), Integer.valueOf(i) });
          ((b)m(b.class)).a(b.f.brS, paramInt, i, MethodBeat.getBuffer(), null, l6, System.nanoTime() / 1000000L - a.brt.getLastDiffTime(), 1);
        }
        com.tencent.matrix.d.b.i("Matrix.StartUpTracer", "[onActivityEntered] firstActivity:%s appCreateTime:%dms betweenCost:%dms activityCreate:%dms splashCost:%dms allCost:%sms isWarnStartUp:%b ApplicationCreateScene:%s", new Object[] { this.bst, Long.valueOf(l6), Long.valueOf(l3), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(paramBoolean), Integer.valueOf(com.tencent.matrix.trace.b.b.brm) });
        this.mHandler.post(new a(paramActivity, l6, l5, l3, l1, l2, paramBoolean, com.tencent.matrix.trace.b.b.brm));
        this.bsv.clear();
        this.bsw.clear();
        this.bss = false;
        this.bst = null;
        return;
        l4 = this.bqr.bqC;
        break;
      }
    }
  }
  
  protected final String getTag()
  {
    return "Trace_StartUp";
  }
  
  public final void onActivityCreated(Activity paramActivity)
  {
    super.onActivityCreated(paramActivity);
    if ((this.bss) && (this.bsv.isEmpty()))
    {
      paramActivity = paramActivity.getComponentName().getClassName();
      this.bsu = MethodBeat.getCurIndex();
      this.bst = paramActivity;
      this.bsv.put(paramActivity, Long.valueOf(System.currentTimeMillis()));
      com.tencent.matrix.d.b.i("Matrix.StartUpTracer", "[onActivityCreated] first activity:%s index:%s", new Object[] { this.bst, Integer.valueOf(this.bsu) });
      a.brt.lockBuffer(true);
    }
  }
  
  public final void onBackground(Activity paramActivity)
  {
    super.onBackground(paramActivity);
    this.bss = true;
  }
  
  protected final boolean rr()
  {
    return true;
  }
  
  private final class a
    implements Runnable
  {
    long bsA;
    long bsB;
    String bsC;
    boolean bsD;
    long bsx;
    long bsy;
    long bsz;
    int scene;
    
    a(String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean, int paramInt)
    {
      this.bsx = paramLong1;
      this.bsy = paramLong2;
      this.bsz = paramLong3;
      this.bsA = paramLong4;
      this.bsB = paramLong5;
      this.bsC = paramString;
      this.bsD = paramBoolean;
      this.scene = paramInt;
    }
    
    public final void run()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("machine", e.a(e.this).ai(e.this.brr.application));
        localJSONObject.put("application_create", this.bsx);
        localJSONObject.put("first_activity_create", this.bsy);
        localJSONObject.put("stage_between_app_and_activity", this.bsz);
        localJSONObject.put("splash_activity_duration", this.bsA);
        localJSONObject.put("splash_startup_duration", this.bsB);
        localJSONObject.put("scene", this.bsC);
        localJSONObject.put("is_warm_start_up", this.bsD);
        localJSONObject.put("application_create_scene", this.scene);
        e locale = e.this;
        com.tencent.matrix.c.b localb = new com.tencent.matrix.c.b();
        localb.tag = "Trace_StartUp";
        localb.boK = localJSONObject;
        locale.brr.a(localb);
        return;
      }
      catch (JSONException localJSONException)
      {
        com.tencent.matrix.d.b.e("Matrix.StartUpTracer", "[JSONException for StartUpReportTask error: %s", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.e.e
 * JD-Core Version:    0.7.0.1
 */