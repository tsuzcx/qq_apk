package com.tencent.h.a.b;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.Window.Callback;
import com.tencent.h.a.b.c.b.b;
import com.tencent.h.a.c.c.a.a.a.2;
import com.tencent.h.a.h.a;
import com.tencent.h.a.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class a
  extends com.tencent.h.a.a.a
  implements com.tencent.h.a.b.c.a.b, com.tencent.h.a.b.c.a.c, com.tencent.h.a.b.c.a.f, com.tencent.h.a.c.d.b
{
  protected com.tencent.h.a.a.c ahWN;
  protected h.a ahXc;
  protected b ahXd;
  private com.tencent.h.a.c.a ahXe;
  
  public a(String paramString, com.tencent.h.a.a.c paramc, b paramb)
  {
    super(paramString);
    this.ahWN = paramc;
    this.ahXd = paramb;
  }
  
  public final void G(Throwable paramThrowable)
  {
    if ((this.ahWN != null) && (this.ahWN.ahWQ != null)) {
      this.ahWN.ahWQ.b(paramThrowable, "turing_engine");
    }
  }
  
  public final void a(com.tencent.h.a.c.b.i parami)
  {
    com.tencent.g.c.i.i("sensor_AbsEngine", "[method: onTouchEventCallBack ] ");
    l(3, 11, parami);
  }
  
  public boolean a(h.a parama, c paramc)
  {
    if ((paramc instanceof com.tencent.h.a.c.a)) {
      this.ahXe = ((com.tencent.h.a.c.a)paramc);
    }
    return false;
  }
  
  public boolean a(i.a parama, long paramLong)
  {
    return false;
  }
  
  public boolean aFF()
  {
    return false;
  }
  
  public boolean aFG()
  {
    return false;
  }
  
  public final void b(int paramInt, com.tencent.h.a.c.b.a parama)
  {
    if (this.ahXe != null) {
      this.ahXe.a(paramInt, parama);
    }
  }
  
  public void destroy() {}
  
  public boolean kdh()
  {
    return false;
  }
  
  public boolean kdi()
  {
    return false;
  }
  
  public boolean kdj()
  {
    return false;
  }
  
  public final h.a kdk()
  {
    return this.ahXc;
  }
  
  protected final boolean kdl()
  {
    com.tencent.g.c.i.i("sensor_AbsEngine", "[method: monitorView ] 111");
    if (this.ahXc == null) {
      return false;
    }
    Object localObject1 = (com.tencent.h.a.b.c.a.d)this.ahXd.ahXh.HlG.get(Integer.valueOf(10));
    if ((localObject1 instanceof com.tencent.h.a.b.c.b))
    {
      localObject1 = (com.tencent.h.a.b.c.b)localObject1;
      Object localObject3;
      Object localObject2;
      Object localObject4;
      if (this.ahXc.ahWt != null)
      {
        com.tencent.g.c.i.i("sensor_AbsEngine", "[method: monitorView ] MonitorActivity");
        localObject3 = com.tencent.h.a.c.c.a.a.a.kdK();
        localObject2 = this.ahXc.ahWt;
        localObject4 = new com.tencent.h.a.c.c.a.a.a.a()
        {
          public final void v(Activity paramAnonymousActivity, String paramAnonymousString)
          {
            AppMethodBeat.i(212115);
            com.tencent.g.c.i.i("sensor_AbsEngine", "[method: onTryMonitor ] stopTasksImmediately when activity pause");
            a.this.kdj();
            AppMethodBeat.o(212115);
          }
        };
        if ((localObject2 == null) || (localObject1 == null)) {
          return false;
        }
        String str = localObject2.getClass().getName();
        if ((((com.tencent.h.a.c.c.a.a.a)localObject3).ahZc != null) && (!TextUtils.isEmpty(str)) && (!((com.tencent.h.a.c.c.a.a.a)localObject3).ahZc.containsKey(str))) {
          ((com.tencent.h.a.c.c.a.a.a)localObject3).ahZc.put(str, localObject1);
        }
        com.tencent.h.a.c.c.a.a.a.a((Activity)localObject2, ((com.tencent.h.a.c.c.a.a.a)localObject3).ahZd);
        if (localObject2 != null)
        {
          ((com.tencent.h.a.c.c.a.a.a)localObject3).ahZd = new a.2((com.tencent.h.a.c.c.a.a.a)localObject3, (Activity)localObject2, (com.tencent.h.a.c.c.a.a.a.a)localObject4);
          localObject1 = ((Activity)localObject2).getApplication();
          if (localObject1 != null) {
            ((Application)localObject1).registerActivityLifecycleCallbacks(((com.tencent.h.a.c.c.a.a.a)localObject3).ahZd);
          }
        }
        com.tencent.g.c.i.i("TuringTouch", "[method: doInitActivity ] ");
        localObject1 = ((com.tencent.h.a.c.c.a.a.a)localObject3).ahZe;
        localObject3 = ((Activity)localObject2).getWindow();
        localObject4 = ((Window)localObject3).getCallback();
        if (localObject4 == null)
        {
          com.tencent.g.c.i.i("sensor_WindowCallbackManager", "not set callback");
          return false;
        }
        if ((localObject4 instanceof com.tencent.h.a.c.c.a.a.a.d))
        {
          com.tencent.g.c.i.i("sensor_WindowCallbackManager", "[method: monitor ] callback is WindowCallbackWrapper");
          return true;
        }
        com.tencent.g.c.i.i("sensor_WindowCallbackManager", "set " + localObject2.getClass().getName() + " WindowCallback");
        ((Window)localObject3).setCallback(new com.tencent.h.a.c.c.a.a.a.d((Window.Callback)localObject4, (com.tencent.h.a.c.c.a.a.a.c)localObject1, localObject2.getClass().getName()));
        return true;
      }
      if (this.ahXc.ahWu != null)
      {
        com.tencent.g.c.i.i("sensor_AbsEngine", "[method: monitorView ] MonitorView");
        localObject4 = com.tencent.h.a.c.c.a.a.a.kdK();
        localObject2 = this.ahXc.ahWu;
        if ((localObject2 == null) || (localObject1 == null)) {
          return false;
        }
        localObject3 = com.tencent.h.a.c.c.a.a.a.hj(localObject2);
        if ((((com.tencent.h.a.c.c.a.a.a)localObject4).ahZc != null) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!((com.tencent.h.a.c.c.a.a.a)localObject4).ahZc.containsKey(localObject3))) {
          ((com.tencent.h.a.c.c.a.a.a)localObject4).ahZc.put(localObject3, localObject1);
        }
        localObject3 = com.tencent.g.b.a.kcP();
        localObject4 = ((com.tencent.h.a.c.c.a.a.a)localObject4).ahZg;
        localObject1 = ((com.tencent.g.b.a)localObject3).ahVS.get(Integer.valueOf(localObject2.hashCode()));
        int i;
        if (localObject1 == null)
        {
          localObject1 = new HashSet();
          ((Set)localObject1).add(localObject4);
          ((Set)localObject1).add(localObject4);
          ((com.tencent.g.b.a)localObject3).ahVS.put(Integer.valueOf(localObject2.hashCode()), localObject1);
          localObject1 = com.tencent.g.b.a.kcP();
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
          localObject3 = com.tencent.g.b.a.mL((View)localObject2);
          if (localObject3 == null)
          {
            i = -2;
          }
          else
          {
            localObject3 = com.tencent.g.b.a.b(localObject3.getClass(), "mOnTouchListener", localObject3);
            if ((localObject3 == null) || (!(localObject3 instanceof com.tencent.g.b.a.a)))
            {
              localObject1 = new com.tencent.g.b.a.a((com.tencent.g.b.a)localObject1, (View.OnTouchListener)localObject3);
              com.tencent.g.c.i.i("sensor_TouchEventWrapperManager", "[method: wrapperViewTouchEvent ] set TouchListenerWrapper");
              ((View)localObject2).setOnTouchListener((View.OnTouchListener)localObject1);
            }
            i = 0;
          }
        }
        label587:
        return false;
      }
      if (this.ahXc.ahWv != null)
      {
        com.tencent.g.c.i.i("sensor_AbsEngine", "[method: monitorView ] MonitorTouchWrapper");
        localObject2 = com.tencent.h.a.c.c.a.a.a.kdK();
        localObject3 = this.ahXc.ahWv;
        if ((localObject3 == null) || (localObject1 == null)) {
          return false;
        }
        localObject4 = com.tencent.h.a.c.c.a.a.a.hj(localObject3);
        if ((((com.tencent.h.a.c.c.a.a.a)localObject2).ahZc != null) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (!((com.tencent.h.a.c.c.a.a.a)localObject2).ahZc.containsKey(localObject4))) {
          ((com.tencent.h.a.c.c.a.a.a)localObject2).ahZc.put(localObject4, localObject1);
        }
        return ((com.tencent.h.a.g)localObject3).a(((com.tencent.h.a.c.c.a.a.a)localObject2).ahZf);
      }
    }
    return false;
  }
  
  protected final void kdm()
  {
    com.tencent.g.c.i.i("sensor_AbsEngine", "[method: unMonitorView ] ");
    if (this.ahXc == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.ahXc.ahWt != null)
    {
      com.tencent.g.c.i.i("sensor_AbsEngine", "[method: unMonitorView ] MonitorActivity");
      localObject1 = com.tencent.h.a.c.c.a.a.a.kdK();
      localObject2 = this.ahXc.ahWt;
      if (localObject2 != null)
      {
        if (((com.tencent.h.a.c.c.a.a.a)localObject1).ahZc != null) {
          ((com.tencent.h.a.c.c.a.a.a)localObject1).ahZc.remove(localObject2.getClass().getName());
        }
        com.tencent.h.a.c.c.a.a.a.a((Activity)localObject2, ((com.tencent.h.a.c.c.a.a.a)localObject1).ahZd);
      }
    }
    for (;;)
    {
      this.ahXc.ahWt = null;
      this.ahXc.ahWu = null;
      this.ahXc.ahWv = null;
      return;
      if (this.ahXc.ahWu != null)
      {
        com.tencent.g.c.i.i("sensor_AbsEngine", "[method: unMonitorView ] MonitorView");
        Object localObject3 = com.tencent.h.a.c.c.a.a.a.kdK();
        localObject1 = this.ahXc.ahWu;
        if (localObject1 != null)
        {
          if (((com.tencent.h.a.c.c.a.a.a)localObject3).ahZc != null) {
            ((com.tencent.h.a.c.c.a.a.a)localObject3).ahZc.remove(com.tencent.h.a.c.c.a.a.a.hj(localObject1));
          }
          localObject2 = com.tencent.g.b.a.kcP();
          localObject3 = ((com.tencent.h.a.c.c.a.a.a)localObject3).ahZg;
          if ((localObject1 != null) && (localObject3 != null) && (((com.tencent.g.b.a)localObject2).ahVS != null) && (!((com.tencent.g.b.a)localObject2).ahVS.isEmpty()))
          {
            Set localSet = (Set)((com.tencent.g.b.a)localObject2).ahVS.get(Integer.valueOf(localObject1.hashCode()));
            if ((localSet != null) && (!localSet.isEmpty()))
            {
              Iterator localIterator = localSet.iterator();
              while (localIterator.hasNext())
              {
                com.tencent.g.b.b localb = (com.tencent.g.b.b)localIterator.next();
                if (localb == localObject3) {
                  localSet.remove(localb);
                }
              }
              if ((localSet.isEmpty()) && (localObject1 != null)) {
                ((com.tencent.g.b.a)localObject2).ahVS.remove(Integer.valueOf(localObject1.hashCode()));
              }
            }
          }
        }
      }
      else if (this.ahXc.ahWv != null)
      {
        com.tencent.g.c.i.i("sensor_AbsEngine", "[method: unMonitorView ] MonitorTouchWrapper");
        localObject1 = com.tencent.h.a.c.c.a.a.a.kdK();
        localObject2 = this.ahXc.ahWv;
        if ((localObject2 != null) && (((com.tencent.h.a.c.c.a.a.a)localObject1).ahZc != null)) {
          ((com.tencent.h.a.c.c.a.a.a)localObject1).ahZc.remove(com.tencent.h.a.c.c.a.a.a.hj(localObject2));
        }
      }
    }
  }
  
  protected final void kdn()
  {
    com.tencent.h.a.b.c.a.d locald = (com.tencent.h.a.b.c.a.d)this.ahXd.ahXh.HlG.get(Integer.valueOf(10));
    Object localObject;
    if ((locald instanceof com.tencent.h.a.b.c.b))
    {
      localObject = null;
      if (this.ahXc.ahWr != com.tencent.h.a.c.ahWm) {
        break label70;
      }
      localObject = new com.tencent.h.a.c.c.a.g(this.ahWN, this);
    }
    for (;;)
    {
      if (localObject != null) {
        ((com.tencent.h.a.b.c.b)locald).ahXt = ((b.b)localObject);
      }
      return;
      label70:
      if (this.ahXc.ahWr == com.tencent.h.a.c.ahWn) {
        localObject = new com.tencent.h.a.c.c.a.f(this.ahWN, this);
      }
    }
  }
  
  public final void ow(List<com.tencent.h.a.c.b.g> paramList)
  {
    l(3, 1, paramList);
  }
  
  public final class a
  {
    public Object[] ahXg;
    
    public a(Object... paramVarArgs)
    {
      this.ahXg = paramVarArgs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.b.a
 * JD-Core Version:    0.7.0.1
 */