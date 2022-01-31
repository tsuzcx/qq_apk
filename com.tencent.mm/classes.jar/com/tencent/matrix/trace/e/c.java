package com.tencent.matrix.trace.e;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnDrawListener;
import android.view.Window;
import com.tencent.matrix.trace.d.a.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends a
  implements ViewTreeObserver.OnDrawListener, a.a
{
  private final com.tencent.matrix.trace.a.a bqr;
  private boolean brU = false;
  private boolean brV = false;
  private HashMap<String, Integer> brW;
  private SparseArray<String> brX;
  private LinkedList<Integer> brY;
  private SparseArray<LinkedList<Integer>> brZ;
  private com.tencent.matrix.trace.d.a brv;
  
  public c(com.tencent.matrix.trace.a parama, com.tencent.matrix.trace.a.a parama1)
  {
    super(parama);
    this.bqr = parama1;
    this.brY = new LinkedList();
    this.brW = new HashMap();
    this.brX = new SparseArray();
    this.brZ = new SparseArray();
    this.brv = new com.tencent.matrix.trace.d.a(com.tencent.matrix.d.a.rt(), parama1.bqF);
  }
  
  protected final String getTag()
  {
    return "Trace_FPS";
  }
  
  public final void k(long paramLong1, long paramLong2)
  {
    String str;
    boolean bool;
    if ((!this.brV) && (!this.isBackground) && (this.brU) && (com.tencent.matrix.trace.b.b.brh))
    {
      ??? = this.bqr;
      str = this.brs;
      if (((com.tencent.matrix.trace.a.a)???).bqz != null) {
        break label144;
      }
      bool = true;
    }
    for (;;)
    {
      int i;
      if (bool)
      {
        ??? = this.brs;
        if (!this.brW.containsKey(???)) {
          break label159;
        }
        i = ((Integer)this.brW.get(???)).intValue();
        i = (int)((i | 0x0) << 22 | (paramLong2 - paramLong1) / 10000L & 0x3FFFFF);
      }
      synchronized (getClass())
      {
        this.brY.add(Integer.valueOf(i));
        this.brU = false;
        return;
        label144:
        bool = ((com.tencent.matrix.trace.a.a)???).bqz.contains(str);
        continue;
        label159:
        i = this.brW.size() + 1;
        this.brW.put(???, Integer.valueOf(i));
        this.brX.put(i, ???);
      }
    }
  }
  
  public final void onActivityCreated(Activity paramActivity)
  {
    super.onActivityCreated(paramActivity);
  }
  
  public final void onActivityPause(Activity paramActivity)
  {
    super.onActivityPause(paramActivity);
    this.brV = true;
  }
  
  public final void onActivityResume(Activity paramActivity)
  {
    super.onActivityResume(paramActivity);
    this.brV = false;
  }
  
  public final void onBackground(Activity paramActivity)
  {
    super.onBackground(paramActivity);
    if (this.brv != null)
    {
      this.brv.cancel();
      this.brv.a(this, false);
    }
  }
  
  public final void onChange(final Activity paramActivity, Fragment paramFragment)
  {
    String str1 = this.brs;
    super.onChange(paramActivity, paramFragment);
    String str2 = paramActivity.getClass().getSimpleName();
    paramFragment = str1;
    if (str1 == null) {
      paramFragment = "";
    }
    com.tencent.matrix.d.b.i("Matrix.FPSTracer", "[onChange] activity:%s lastActivity:%s", new Object[] { str2, paramFragment });
    paramActivity.getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        paramActivity.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(c.this);
        paramActivity.getWindow().getDecorView().getViewTreeObserver().addOnDrawListener(c.this);
      }
    });
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    if (this.brv != null)
    {
      this.brv.cancel();
      this.brv = null;
    }
    if (this.brW != null)
    {
      this.brW.clear();
      this.brW = null;
    }
    if (this.brX != null)
    {
      this.brX.clear();
      this.brX = null;
    }
    if (this.brY != null)
    {
      this.brY.clear();
      this.brY = null;
    }
    if (this.brZ != null)
    {
      this.brZ.clear();
      this.brZ = null;
    }
  }
  
  public final void onDraw()
  {
    this.brU = true;
  }
  
  public final void onFront(Activity paramActivity)
  {
    super.onFront(paramActivity);
    if (this.brv != null)
    {
      this.brv.cancel();
      this.brv.a(this, true);
    }
  }
  
  public final void rq()
  {
    Object localObject4;
    Object localObject5;
    int i;
    int j;
    synchronized (getClass())
    {
      if (this.brY.isEmpty()) {
        return;
      }
      localObject4 = this.brY;
      this.brY = new LinkedList();
      localObject5 = ((LinkedList)localObject4).iterator();
      if (((Iterator)localObject5).hasNext())
      {
        i = ((Integer)((Iterator)localObject5).next()).intValue();
        j = i >> 22;
        LinkedList localLinkedList = (LinkedList)this.brZ.get(j);
        ??? = localLinkedList;
        if (localLinkedList == null)
        {
          ??? = new LinkedList();
          this.brZ.put(j, ???);
        }
        ((LinkedList)???).add(Integer.valueOf(0x3FFFFF & i));
      }
    }
    ((LinkedList)localObject4).clear();
    int k = 0;
    if (k < this.brZ.size())
    {
      int i3 = this.brZ.keyAt(k);
      localObject5 = (LinkedList)this.brZ.get(i3);
      int m;
      int n;
      Object localObject3;
      label225:
      int i2;
      int i1;
      if (localObject5 != null)
      {
        i = 0;
        m = 0;
        n = 0;
        localObject3 = new int[a.values().length];
        ??? = new int[a.values().length];
        Iterator localIterator = ((LinkedList)localObject5).iterator();
        if (localIterator.hasNext())
        {
          localObject4 = (Integer)localIterator.next();
          i2 = i + ((Integer)localObject4).intValue();
          n += 1;
          i1 = ((Integer)localObject4).intValue() / 1600 - 1;
          if (i1 >= 42)
          {
            i = a.bsb.index;
            localObject3[i] += 1;
            j = a.bsb.index;
            i = ???[j];
          }
        }
      }
      label1042:
      for (;;)
      {
        label311:
        localObject4 = ???;
        localObject4[j] = (i + i1);
        float f;
        if (i2 >= this.bqr.bqA * 100L)
        {
          f = Math.min(60.0F, 100000.0F * (n - m) / i2);
          com.tencent.matrix.d.b.i("Matrix.FPSTracer", "scene:%s fps:%s sumTime:%s [%s:%s]", new Object[] { this.brX.get(i3), Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(n), Integer.valueOf(m) });
        }
        for (;;)
        {
          try
          {
            localObject4 = new JSONObject();
            ((JSONObject)localObject4).put(a.bsb.name(), localObject3[a.bsb.index]);
            ((JSONObject)localObject4).put(a.bsc.name(), localObject3[a.bsc.index]);
            ((JSONObject)localObject4).put(a.bsd.name(), localObject3[a.bsd.index]);
            ((JSONObject)localObject4).put(a.bse.name(), localObject3[a.bse.index]);
            ((JSONObject)localObject4).put(a.bsf.name(), localObject3[a.bsf.index]);
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put(a.bsb.name(), ???[a.bsb.index]);
            ((JSONObject)localObject3).put(a.bsc.name(), ???[a.bsc.index]);
            ((JSONObject)localObject3).put(a.bsd.name(), ???[a.bsd.index]);
            ((JSONObject)localObject3).put(a.bse.name(), ???[a.bse.index]);
            ((JSONObject)localObject3).put(a.bsf.name(), ???[a.bsf.index]);
            ??? = new JSONObject();
            ((JSONObject)???).put("machine", this.bqr.ai(this.brr.application));
            ((JSONObject)???).put("scene", this.brX.get(i3));
            ((JSONObject)???).put("dropLevel", localObject4);
            ((JSONObject)???).put("dropSum", localObject3);
            ((JSONObject)???).put("fps", f);
            d((JSONObject)???);
            localObject3 = new int[a.values().length];
            ??? = new int[a.values().length];
            i = 0;
            j = n;
            m = j;
            break label225;
            if (i1 >= 12)
            {
              i = a.bsc.index;
              localObject3[i] += 1;
              j = a.bsc.index;
              i = ???[j];
              break label311;
            }
            if (i1 >= 6)
            {
              i = a.bsd.index;
              localObject3[i] += 1;
              j = a.bsd.index;
              i = ???[j];
              break label311;
            }
            if (i1 >= 2)
            {
              i = a.bse.index;
              localObject3[i] += 1;
              j = a.bse.index;
              i = ???[j];
              break label311;
            }
            i = a.bsf.index;
            localObject3[i] += 1;
            j = a.bsf.index;
            i = ???[j];
            if (i1 >= 0) {
              break label1042;
            }
            i1 = 0;
            localObject4 = ???;
          }
          catch (JSONException localJSONException)
          {
            com.tencent.matrix.d.b.e("Matrix.FPSTracer", "json error", new Object[] { localJSONException });
            continue;
          }
          if (m > 0)
          {
            j = 0;
            while (j < m)
            {
              ((LinkedList)localObject5).removeFirst();
              j += 1;
            }
          }
          if (!((LinkedList)localObject5).isEmpty()) {
            com.tencent.matrix.d.b.d("Matrix.FPSTracer", "[doReport] sumTime:[%sms < %sms], scene:[%s]", new Object[] { Integer.valueOf(i / 100), Long.valueOf(this.bqr.bqA), this.brX.get(i3) });
          }
          k += 1;
          break;
          i = i2;
          j = m;
        }
      }
    }
  }
  
  private static enum a
  {
    int index;
    
    private a(int paramInt)
    {
      this.index = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.e.c
 * JD-Core Version:    0.7.0.1
 */