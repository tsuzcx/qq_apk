package com.tencent.matrix.trace.e;

import android.app.Activity;
import android.os.Process;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.MethodBeat;
import com.tencent.matrix.trace.core.a.a;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;

public abstract class a
  extends com.tencent.matrix.c.c
  implements com.tencent.matrix.trace.c.b, com.tencent.matrix.trace.c.c, a.a
{
  static final MethodBeat brt = new MethodBeat();
  private static final HashMap<Class<a>, a> bru = new HashMap();
  final com.tencent.matrix.trace.a brr;
  String brs;
  boolean isBackground = true;
  
  a(com.tencent.matrix.trace.a parama)
  {
    super(parama);
    this.brr = parama;
    bru.put(getClass(), this);
  }
  
  public static <T extends a> T m(Class<T> paramClass)
  {
    return (a)bru.get(paramClass);
  }
  
  public void a(Activity paramActivity, boolean paramBoolean, int paramInt, long[] paramArrayOfLong) {}
  
  public void b(long[] paramArrayOfLong) {}
  
  protected final void d(JSONObject paramJSONObject)
  {
    com.tencent.matrix.c.b localb = new com.tencent.matrix.c.b();
    localb.tag = getTag();
    localb.boK = paramJSONObject;
    this.brr.a(localb);
  }
  
  protected abstract String getTag();
  
  public void k(long paramLong1, long paramLong2) {}
  
  public void onActivityCreated(Activity paramActivity) {}
  
  public void onActivityPause(Activity paramActivity) {}
  
  public void onActivityResume(Activity paramActivity) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onBackground(Activity paramActivity)
  {
    this.isBackground = true;
  }
  
  public void onChange(Activity paramActivity, Fragment paramFragment)
  {
    if (paramActivity == null)
    {
      paramActivity = "null";
      this.brs = paramActivity;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(paramActivity.getClass().getName());
    if (paramFragment == null) {}
    for (paramActivity = "";; paramActivity = "&" + paramFragment.getClass().getName())
    {
      paramActivity = paramActivity;
      break;
    }
  }
  
  public void onCreate()
  {
    com.tencent.matrix.d.b.i("Matrix.BaseTracer", "[onCreate] name:%s process:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(Process.myPid()) });
    if (rr())
    {
      brt.onCreate();
      brt.registerListener(this);
    }
    com.tencent.matrix.trace.core.a.rn().a(this);
    com.tencent.matrix.trace.core.b localb = com.tencent.matrix.trace.core.b.ro();
    if ((localb.brc != null) && (!localb.brc.contains(this))) {
      localb.brc.add(this);
    }
  }
  
  public void onDestroy()
  {
    com.tencent.matrix.d.b.i("Matrix.BaseTracer", "[onDestroy] name:%s  process:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(Process.myPid()) });
    if (rr())
    {
      brt.unregisterListener(this);
      brt.onDestroy();
    }
    com.tencent.matrix.trace.core.a.rn().b(this);
    com.tencent.matrix.trace.core.b localb = com.tencent.matrix.trace.core.b.ro();
    if (localb.brc != null) {
      localb.brc.remove(this);
    }
  }
  
  public void onFront(Activity paramActivity)
  {
    this.isBackground = false;
  }
  
  protected boolean rr()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.e.a
 * JD-Core Version:    0.7.0.1
 */