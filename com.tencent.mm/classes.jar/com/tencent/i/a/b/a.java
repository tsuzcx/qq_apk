package com.tencent.i.a.b;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.Window.Callback;
import com.tencent.h.c.h;
import com.tencent.i.a.b.c.b.b;
import com.tencent.i.a.c.b.i;
import com.tencent.i.a.c.c.a.a.a.2;
import com.tencent.i.a.h.a;
import com.tencent.i.a.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class a
  extends com.tencent.i.a.a.a
  implements com.tencent.i.a.b.c.a.b, com.tencent.i.a.b.c.a.c, com.tencent.i.a.b.c.a.f, com.tencent.i.a.c.d.b
{
  protected com.tencent.i.a.a.c SqM;
  protected h.a SqZ;
  protected b Sra;
  private com.tencent.i.a.c.a Srb;
  
  public a(String paramString, com.tencent.i.a.a.c paramc, b paramb)
  {
    super(paramString);
    this.SqM = paramc;
    this.Sra = paramb;
  }
  
  public boolean YY()
  {
    return false;
  }
  
  public boolean YZ()
  {
    return false;
  }
  
  public final void a(i parami)
  {
    h.i("sensor_AbsEngine", "[method: onTouchEventCallBack ] ");
    j(3, 11, parami);
  }
  
  public boolean a(h.a parama, c paramc)
  {
    if ((paramc instanceof com.tencent.i.a.c.a)) {
      this.Srb = ((com.tencent.i.a.c.a)paramc);
    }
    return false;
  }
  
  public boolean a(i.a parama, long paramLong)
  {
    return false;
  }
  
  public final void b(int paramInt, com.tencent.i.a.c.b.a parama)
  {
    if (this.Srb != null) {
      this.Srb.a(paramInt, parama);
    }
  }
  
  public void destroy() {}
  
  public boolean hqe()
  {
    return false;
  }
  
  public boolean hqf()
  {
    return false;
  }
  
  public boolean hqg()
  {
    return false;
  }
  
  public final h.a hqh()
  {
    return this.SqZ;
  }
  
  protected final boolean hqi()
  {
    h.i("sensor_AbsEngine", "[method: monitorView ] 111");
    if (this.SqZ == null) {
      return false;
    }
    Object localObject1 = (com.tencent.i.a.b.c.a.d)this.Sra.Sre.wLb.get(Integer.valueOf(10));
    if ((localObject1 instanceof com.tencent.i.a.b.c.b))
    {
      localObject1 = (com.tencent.i.a.b.c.b)localObject1;
      Object localObject3;
      Object localObject2;
      Object localObject4;
      if (this.SqZ.Sqt != null)
      {
        h.i("sensor_AbsEngine", "[method: monitorView ] MonitorActivity");
        localObject3 = com.tencent.i.a.c.c.a.a.a.hqF();
        localObject2 = this.SqZ.Sqt;
        localObject4 = new com.tencent.i.a.c.c.a.a.a.a()
        {
          public final void s(Activity paramAnonymousActivity, String paramAnonymousString)
          {
            AppMethodBeat.i(214697);
            h.i("sensor_AbsEngine", "[method: onTryMonitor ] stopTasksImmediately when activity pause");
            a.this.hqg();
            AppMethodBeat.o(214697);
          }
        };
        if ((localObject2 == null) || (localObject1 == null)) {
          return false;
        }
        String str = localObject2.getClass().getName();
        if ((((com.tencent.i.a.c.c.a.a.a)localObject3).SsZ != null) && (!TextUtils.isEmpty(str)) && (!((com.tencent.i.a.c.c.a.a.a)localObject3).SsZ.containsKey(str))) {
          ((com.tencent.i.a.c.c.a.a.a)localObject3).SsZ.put(str, localObject1);
        }
        com.tencent.i.a.c.c.a.a.a.a((Activity)localObject2, ((com.tencent.i.a.c.c.a.a.a)localObject3).Sta);
        if (localObject2 != null)
        {
          ((com.tencent.i.a.c.c.a.a.a)localObject3).Sta = new a.2((com.tencent.i.a.c.c.a.a.a)localObject3, (Activity)localObject2, (com.tencent.i.a.c.c.a.a.a.a)localObject4);
          localObject1 = ((Activity)localObject2).getApplication();
          if (localObject1 != null) {
            ((Application)localObject1).registerActivityLifecycleCallbacks(((com.tencent.i.a.c.c.a.a.a)localObject3).Sta);
          }
        }
        h.i("TuringTouch", "[method: doInitActivity ] ");
        localObject1 = ((com.tencent.i.a.c.c.a.a.a)localObject3).Stb;
        localObject3 = ((Activity)localObject2).getWindow();
        localObject4 = ((Window)localObject3).getCallback();
        if (localObject4 == null)
        {
          h.i("sensor_WindowCallbackManager", "not set callback");
          return false;
        }
        if ((localObject4 instanceof com.tencent.i.a.c.c.a.a.a.d))
        {
          h.i("sensor_WindowCallbackManager", "[method: monitor ] callback is WindowCallbackWrapper");
          return true;
        }
        h.i("sensor_WindowCallbackManager", "set " + localObject2.getClass().getName() + " WindowCallback");
        ((Window)localObject3).setCallback(new com.tencent.i.a.c.c.a.a.a.d((Window.Callback)localObject4, (com.tencent.i.a.c.c.a.a.a.c)localObject1, localObject2.getClass().getName()));
        return true;
      }
      if (this.SqZ.Squ != null)
      {
        h.i("sensor_AbsEngine", "[method: monitorView ] MonitorView");
        localObject4 = com.tencent.i.a.c.c.a.a.a.hqF();
        localObject2 = this.SqZ.Squ;
        if ((localObject2 == null) || (localObject1 == null)) {
          return false;
        }
        localObject3 = com.tencent.i.a.c.c.a.a.a.eG(localObject2);
        if ((((com.tencent.i.a.c.c.a.a.a)localObject4).SsZ != null) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!((com.tencent.i.a.c.c.a.a.a)localObject4).SsZ.containsKey(localObject3))) {
          ((com.tencent.i.a.c.c.a.a.a)localObject4).SsZ.put(localObject3, localObject1);
        }
        localObject3 = com.tencent.h.b.a.hpS();
        localObject4 = ((com.tencent.i.a.c.c.a.a.a)localObject4).Std;
        localObject1 = ((com.tencent.h.b.a)localObject3).SpR.get(Integer.valueOf(localObject2.hashCode()));
        int i;
        if (localObject1 == null)
        {
          localObject1 = new HashSet();
          ((Set)localObject1).add(localObject4);
          ((Set)localObject1).add(localObject4);
          ((com.tencent.h.b.a)localObject3).SpR.put(Integer.valueOf(localObject2.hashCode()), localObject1);
          localObject1 = com.tencent.h.b.a.hpS();
          if (localObject2 != null) {
            break label509;
          }
          i = -1;
        }
        for (;;)
        {
          if (i != 0) {
            break label587;
          }
          return true;
          localObject1 = (Set)localObject1;
          break;
          label509:
          localObject3 = com.tencent.h.b.a.hO((View)localObject2);
          if (localObject3 == null)
          {
            i = -2;
          }
          else
          {
            localObject3 = com.tencent.h.b.a.c(localObject3.getClass(), "mOnTouchListener", localObject3);
            if ((localObject3 == null) || (!(localObject3 instanceof com.tencent.h.b.a.a)))
            {
              localObject1 = new com.tencent.h.b.a.a((com.tencent.h.b.a)localObject1, (View.OnTouchListener)localObject3);
              h.i("sensor_TouchEventWrapperManager", "[method: wrapperViewTouchEvent ] set TouchListenerWrapper");
              ((View)localObject2).setOnTouchListener((View.OnTouchListener)localObject1);
            }
            i = 0;
          }
        }
        label587:
        return false;
      }
      if (this.SqZ.Sqv != null)
      {
        h.i("sensor_AbsEngine", "[method: monitorView ] MonitorTouchWrapper");
        localObject2 = com.tencent.i.a.c.c.a.a.a.hqF();
        localObject3 = this.SqZ.Sqv;
        if ((localObject3 == null) || (localObject1 == null)) {
          return false;
        }
        localObject4 = com.tencent.i.a.c.c.a.a.a.eG(localObject3);
        if ((((com.tencent.i.a.c.c.a.a.a)localObject2).SsZ != null) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (!((com.tencent.i.a.c.c.a.a.a)localObject2).SsZ.containsKey(localObject4))) {
          ((com.tencent.i.a.c.c.a.a.a)localObject2).SsZ.put(localObject4, localObject1);
        }
        return ((com.tencent.i.a.g)localObject3).a(((com.tencent.i.a.c.c.a.a.a)localObject2).Stc);
      }
    }
    return false;
  }
  
  protected final void hqj()
  {
    h.i("sensor_AbsEngine", "[method: unMonitorView ] ");
    if (this.SqZ == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.SqZ.Sqt != null)
    {
      h.i("sensor_AbsEngine", "[method: unMonitorView ] MonitorActivity");
      localObject1 = com.tencent.i.a.c.c.a.a.a.hqF();
      localObject2 = this.SqZ.Sqt;
      if (localObject2 != null)
      {
        if (((com.tencent.i.a.c.c.a.a.a)localObject1).SsZ != null) {
          ((com.tencent.i.a.c.c.a.a.a)localObject1).SsZ.remove(localObject2.getClass().getName());
        }
        com.tencent.i.a.c.c.a.a.a.a((Activity)localObject2, ((com.tencent.i.a.c.c.a.a.a)localObject1).Sta);
      }
    }
    for (;;)
    {
      this.SqZ.Sqt = null;
      this.SqZ.Squ = null;
      this.SqZ.Sqv = null;
      return;
      if (this.SqZ.Squ != null)
      {
        h.i("sensor_AbsEngine", "[method: unMonitorView ] MonitorView");
        Object localObject3 = com.tencent.i.a.c.c.a.a.a.hqF();
        localObject1 = this.SqZ.Squ;
        if (localObject1 != null)
        {
          if (((com.tencent.i.a.c.c.a.a.a)localObject3).SsZ != null) {
            ((com.tencent.i.a.c.c.a.a.a)localObject3).SsZ.remove(com.tencent.i.a.c.c.a.a.a.eG(localObject1));
          }
          localObject2 = com.tencent.h.b.a.hpS();
          localObject3 = ((com.tencent.i.a.c.c.a.a.a)localObject3).Std;
          if ((localObject1 != null) && (localObject3 != null) && (((com.tencent.h.b.a)localObject2).SpR != null) && (!((com.tencent.h.b.a)localObject2).SpR.isEmpty()))
          {
            Set localSet = (Set)((com.tencent.h.b.a)localObject2).SpR.get(Integer.valueOf(localObject1.hashCode()));
            if ((localSet != null) && (!localSet.isEmpty()))
            {
              Iterator localIterator = localSet.iterator();
              while (localIterator.hasNext())
              {
                com.tencent.h.b.b localb = (com.tencent.h.b.b)localIterator.next();
                if (localb == localObject3) {
                  localSet.remove(localb);
                }
              }
              if ((localSet.isEmpty()) && (localObject1 != null)) {
                ((com.tencent.h.b.a)localObject2).SpR.remove(Integer.valueOf(localObject1.hashCode()));
              }
            }
          }
        }
      }
      else if (this.SqZ.Sqv != null)
      {
        h.i("sensor_AbsEngine", "[method: unMonitorView ] MonitorTouchWrapper");
        localObject1 = com.tencent.i.a.c.c.a.a.a.hqF();
        localObject2 = this.SqZ.Sqv;
        if ((localObject2 != null) && (((com.tencent.i.a.c.c.a.a.a)localObject1).SsZ != null)) {
          ((com.tencent.i.a.c.c.a.a.a)localObject1).SsZ.remove(com.tencent.i.a.c.c.a.a.a.eG(localObject2));
        }
      }
    }
  }
  
  protected final void hqk()
  {
    com.tencent.i.a.b.c.a.d locald = (com.tencent.i.a.b.c.a.d)this.Sra.Sre.wLb.get(Integer.valueOf(10));
    Object localObject;
    if ((locald instanceof com.tencent.i.a.b.c.b))
    {
      localObject = null;
      if (this.SqZ.Sqr != com.tencent.i.a.c.Sqm) {
        break label70;
      }
      localObject = new com.tencent.i.a.c.c.a.g(this.SqM, this);
    }
    for (;;)
    {
      if (localObject != null) {
        ((com.tencent.i.a.b.c.b)locald).Srq = ((b.b)localObject);
      }
      return;
      label70:
      if (this.SqZ.Sqr == com.tencent.i.a.c.Sqn) {
        localObject = new com.tencent.i.a.c.c.a.f(this.SqM, this);
      }
    }
  }
  
  public final void kf(List<com.tencent.i.a.c.b.g> paramList)
  {
    j(3, 1, paramList);
  }
  
  public final void q(Throwable paramThrowable)
  {
    if ((this.SqM != null) && (this.SqM.SqP != null)) {
      this.SqM.SqP.b(paramThrowable, "turing_engine");
    }
  }
  
  public final class a
  {
    public Object[] Srd;
    
    public a(Object... paramVarArgs)
    {
      this.Srd = paramVarArgs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.b.a
 * JD-Core Version:    0.7.0.1
 */