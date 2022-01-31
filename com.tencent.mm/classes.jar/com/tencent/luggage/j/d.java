package com.tencent.luggage.j;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class d
{
  private static final HashMap<Activity, d> bjK = new HashMap();
  private static final HashMap<Context, d> bjL = new HashMap();
  public final SparseArray<Object> bjF = new SparseArray();
  private final SparseArray<Object> bjG = new SparseArray();
  public final Set<d.a> bjH = Collections.newSetFromMap(new ConcurrentHashMap());
  private WeakReference<Activity> bjI;
  private Random bjJ;
  
  private d(Activity paramActivity)
  {
    this.bjI = new WeakReference(paramActivity);
    this.bjJ = new Random();
  }
  
  public static d ad(Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      if (!bjK.containsKey(paramContext)) {
        bjK.put((Activity)paramContext, new d((Activity)paramContext));
      }
      return (d)bjK.get(paramContext);
    }
    Assert.assertFalse(false);
    if (!bjL.containsKey(paramContext)) {
      bjL.put(paramContext, new d(null));
    }
    return (d)bjL.get(paramContext);
  }
  
  public static void ae(Context paramContext)
  {
    bjK.remove(paramContext);
    bjL.remove(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.j.d
 * JD-Core Version:    0.7.0.1
 */