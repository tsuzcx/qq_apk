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
  protected h.a ZSC;
  protected b ZSD;
  private com.tencent.h.a.c.a ZSE;
  protected com.tencent.h.a.a.c ZSp;
  
  public a(String paramString, com.tencent.h.a.a.c paramc, b paramb)
  {
    super(paramString);
    this.ZSp = paramc;
    this.ZSD = paramb;
  }
  
  public final void a(com.tencent.h.a.c.b.i parami)
  {
    com.tencent.g.c.i.i("sensor_AbsEngine", "[method: onTouchEventCallBack ] ");
    k(3, 11, parami);
  }
  
  public boolean a(h.a parama, c paramc)
  {
    if ((paramc instanceof com.tencent.h.a.c.a)) {
      this.ZSE = ((com.tencent.h.a.c.a)paramc);
    }
    return false;
  }
  
  public boolean a(i.a parama, long paramLong)
  {
    return false;
  }
  
  public boolean adH()
  {
    return false;
  }
  
  public boolean adI()
  {
    return false;
  }
  
  public final void b(int paramInt, com.tencent.h.a.c.b.a parama)
  {
    if (this.ZSE != null) {
      this.ZSE.a(paramInt, parama);
    }
  }
  
  public void destroy() {}
  
  public boolean itL()
  {
    return false;
  }
  
  public boolean itM()
  {
    return false;
  }
  
  public boolean itN()
  {
    return false;
  }
  
  public final h.a itO()
  {
    return this.ZSC;
  }
  
  protected final boolean itP()
  {
    com.tencent.g.c.i.i("sensor_AbsEngine", "[method: monitorView ] 111");
    if (this.ZSC == null) {
      return false;
    }
    Object localObject1 = (com.tencent.h.a.b.c.a.d)this.ZSD.ZSH.BCY.get(Integer.valueOf(10));
    if ((localObject1 instanceof com.tencent.h.a.b.c.b))
    {
      localObject1 = (com.tencent.h.a.b.c.b)localObject1;
      Object localObject3;
      Object localObject2;
      Object localObject4;
      if (this.ZSC.ZRW != null)
      {
        com.tencent.g.c.i.i("sensor_AbsEngine", "[method: monitorView ] MonitorActivity");
        localObject3 = com.tencent.h.a.c.c.a.a.a.iuo();
        localObject2 = this.ZSC.ZRW;
        localObject4 = new com.tencent.h.a.c.c.a.a.a.a()
        {
          public final void s(Activity paramAnonymousActivity, String paramAnonymousString)
          {
            AppMethodBeat.i(208136);
            com.tencent.g.c.i.i("sensor_AbsEngine", "[method: onTryMonitor ] stopTasksImmediately when activity pause");
            a.this.itN();
            AppMethodBeat.o(208136);
          }
        };
        if ((localObject2 == null) || (localObject1 == null)) {
          return false;
        }
        String str = localObject2.getClass().getName();
        if ((((com.tencent.h.a.c.c.a.a.a)localObject3).ZUC != null) && (!TextUtils.isEmpty(str)) && (!((com.tencent.h.a.c.c.a.a.a)localObject3).ZUC.containsKey(str))) {
          ((com.tencent.h.a.c.c.a.a.a)localObject3).ZUC.put(str, localObject1);
        }
        com.tencent.h.a.c.c.a.a.a.a((Activity)localObject2, ((com.tencent.h.a.c.c.a.a.a)localObject3).ZUD);
        if (localObject2 != null)
        {
          ((com.tencent.h.a.c.c.a.a.a)localObject3).ZUD = new a.2((com.tencent.h.a.c.c.a.a.a)localObject3, (Activity)localObject2, (com.tencent.h.a.c.c.a.a.a.a)localObject4);
          localObject1 = ((Activity)localObject2).getApplication();
          if (localObject1 != null) {
            ((Application)localObject1).registerActivityLifecycleCallbacks(((com.tencent.h.a.c.c.a.a.a)localObject3).ZUD);
          }
        }
        com.tencent.g.c.i.i("TuringTouch", "[method: doInitActivity ] ");
        localObject1 = ((com.tencent.h.a.c.c.a.a.a)localObject3).ZUE;
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
      if (this.ZSC.ZRX != null)
      {
        com.tencent.g.c.i.i("sensor_AbsEngine", "[method: monitorView ] MonitorView");
        localObject4 = com.tencent.h.a.c.c.a.a.a.iuo();
        localObject2 = this.ZSC.ZRX;
        if ((localObject2 == null) || (localObject1 == null)) {
          return false;
        }
        localObject3 = com.tencent.h.a.c.c.a.a.a.eM(localObject2);
        if ((((com.tencent.h.a.c.c.a.a.a)localObject4).ZUC != null) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!((com.tencent.h.a.c.c.a.a.a)localObject4).ZUC.containsKey(localObject3))) {
          ((com.tencent.h.a.c.c.a.a.a)localObject4).ZUC.put(localObject3, localObject1);
        }
        localObject3 = com.tencent.g.b.a.itx();
        localObject4 = ((com.tencent.h.a.c.c.a.a.a)localObject4).ZUG;
        localObject1 = ((com.tencent.g.b.a)localObject3).ZRw.get(Integer.valueOf(localObject2.hashCode()));
        int i;
        if (localObject1 == null)
        {
          localObject1 = new HashSet();
          ((Set)localObject1).add(localObject4);
          ((Set)localObject1).add(localObject4);
          ((com.tencent.g.b.a)localObject3).ZRw.put(Integer.valueOf(localObject2.hashCode()), localObject1);
          localObject1 = com.tencent.g.b.a.itx();
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
          localObject3 = com.tencent.g.b.a.jh((View)localObject2);
          if (localObject3 == null)
          {
            i = -2;
          }
          else
          {
            localObject3 = com.tencent.g.b.a.c(localObject3.getClass(), "mOnTouchListener", localObject3);
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
      if (this.ZSC.ZRY != null)
      {
        com.tencent.g.c.i.i("sensor_AbsEngine", "[method: monitorView ] MonitorTouchWrapper");
        localObject2 = com.tencent.h.a.c.c.a.a.a.iuo();
        localObject3 = this.ZSC.ZRY;
        if ((localObject3 == null) || (localObject1 == null)) {
          return false;
        }
        localObject4 = com.tencent.h.a.c.c.a.a.a.eM(localObject3);
        if ((((com.tencent.h.a.c.c.a.a.a)localObject2).ZUC != null) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (!((com.tencent.h.a.c.c.a.a.a)localObject2).ZUC.containsKey(localObject4))) {
          ((com.tencent.h.a.c.c.a.a.a)localObject2).ZUC.put(localObject4, localObject1);
        }
        return ((com.tencent.h.a.g)localObject3).a(((com.tencent.h.a.c.c.a.a.a)localObject2).ZUF);
      }
    }
    return false;
  }
  
  protected final void itQ()
  {
    com.tencent.g.c.i.i("sensor_AbsEngine", "[method: unMonitorView ] ");
    if (this.ZSC == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.ZSC.ZRW != null)
    {
      com.tencent.g.c.i.i("sensor_AbsEngine", "[method: unMonitorView ] MonitorActivity");
      localObject1 = com.tencent.h.a.c.c.a.a.a.iuo();
      localObject2 = this.ZSC.ZRW;
      if (localObject2 != null)
      {
        if (((com.tencent.h.a.c.c.a.a.a)localObject1).ZUC != null) {
          ((com.tencent.h.a.c.c.a.a.a)localObject1).ZUC.remove(localObject2.getClass().getName());
        }
        com.tencent.h.a.c.c.a.a.a.a((Activity)localObject2, ((com.tencent.h.a.c.c.a.a.a)localObject1).ZUD);
      }
    }
    for (;;)
    {
      this.ZSC.ZRW = null;
      this.ZSC.ZRX = null;
      this.ZSC.ZRY = null;
      return;
      if (this.ZSC.ZRX != null)
      {
        com.tencent.g.c.i.i("sensor_AbsEngine", "[method: unMonitorView ] MonitorView");
        Object localObject3 = com.tencent.h.a.c.c.a.a.a.iuo();
        localObject1 = this.ZSC.ZRX;
        if (localObject1 != null)
        {
          if (((com.tencent.h.a.c.c.a.a.a)localObject3).ZUC != null) {
            ((com.tencent.h.a.c.c.a.a.a)localObject3).ZUC.remove(com.tencent.h.a.c.c.a.a.a.eM(localObject1));
          }
          localObject2 = com.tencent.g.b.a.itx();
          localObject3 = ((com.tencent.h.a.c.c.a.a.a)localObject3).ZUG;
          if ((localObject1 != null) && (localObject3 != null) && (((com.tencent.g.b.a)localObject2).ZRw != null) && (!((com.tencent.g.b.a)localObject2).ZRw.isEmpty()))
          {
            Set localSet = (Set)((com.tencent.g.b.a)localObject2).ZRw.get(Integer.valueOf(localObject1.hashCode()));
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
                ((com.tencent.g.b.a)localObject2).ZRw.remove(Integer.valueOf(localObject1.hashCode()));
              }
            }
          }
        }
      }
      else if (this.ZSC.ZRY != null)
      {
        com.tencent.g.c.i.i("sensor_AbsEngine", "[method: unMonitorView ] MonitorTouchWrapper");
        localObject1 = com.tencent.h.a.c.c.a.a.a.iuo();
        localObject2 = this.ZSC.ZRY;
        if ((localObject2 != null) && (((com.tencent.h.a.c.c.a.a.a)localObject1).ZUC != null)) {
          ((com.tencent.h.a.c.c.a.a.a)localObject1).ZUC.remove(com.tencent.h.a.c.c.a.a.a.eM(localObject2));
        }
      }
    }
  }
  
  protected final void itR()
  {
    com.tencent.h.a.b.c.a.d locald = (com.tencent.h.a.b.c.a.d)this.ZSD.ZSH.BCY.get(Integer.valueOf(10));
    Object localObject;
    if ((locald instanceof com.tencent.h.a.b.c.b))
    {
      localObject = null;
      if (this.ZSC.ZRU != com.tencent.h.a.c.ZRP) {
        break label70;
      }
      localObject = new com.tencent.h.a.c.c.a.g(this.ZSp, this);
    }
    for (;;)
    {
      if (localObject != null) {
        ((com.tencent.h.a.b.c.b)locald).ZST = ((b.b)localObject);
      }
      return;
      label70:
      if (this.ZSC.ZRU == com.tencent.h.a.c.ZRQ) {
        localObject = new com.tencent.h.a.c.c.a.f(this.ZSp, this);
      }
    }
  }
  
  public final void kZ(List<com.tencent.h.a.c.b.g> paramList)
  {
    k(3, 1, paramList);
  }
  
  public final void q(Throwable paramThrowable)
  {
    if ((this.ZSp != null) && (this.ZSp.ZSs != null)) {
      this.ZSp.ZSs.b(paramThrowable, "turing_engine");
    }
  }
  
  public final class a
  {
    public Object[] ZSG;
    
    public a(Object... paramVarArgs)
    {
      this.ZSG = paramVarArgs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.b.a
 * JD-Core Version:    0.7.0.1
 */