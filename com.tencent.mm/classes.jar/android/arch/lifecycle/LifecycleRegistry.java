package android.arch.lifecycle;

import android.arch.a.b.a;
import android.arch.a.b.b;
import android.arch.a.b.b.b;
import android.arch.a.b.b.c;
import android.arch.a.b.b.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class LifecycleRegistry
  extends Lifecycle
{
  private a<LifecycleObserver, ObserverWithState> cd = new a();
  private Lifecycle.State ce;
  private final WeakReference<LifecycleOwner> cf;
  private int cg = 0;
  private boolean ch = false;
  private boolean ci = false;
  private ArrayList<Lifecycle.State> cj = new ArrayList();
  
  public LifecycleRegistry(LifecycleOwner paramLifecycleOwner)
  {
    this.cf = new WeakReference(paramLifecycleOwner);
    this.ce = Lifecycle.State.INITIALIZED;
  }
  
  private void P()
  {
    this.cj.remove(this.cj.size() - 1);
  }
  
  static Lifecycle.State a(Lifecycle.Event paramEvent)
  {
    switch (1.cc[paramEvent.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unexpected event value " + paramEvent);
    case 1: 
    case 2: 
      return Lifecycle.State.CREATED;
    case 3: 
    case 4: 
      return Lifecycle.State.STARTED;
    case 5: 
      return Lifecycle.State.RESUMED;
    }
    return Lifecycle.State.DESTROYED;
  }
  
  static Lifecycle.State a(Lifecycle.State paramState1, Lifecycle.State paramState2)
  {
    if ((paramState2 != null) && (paramState2.compareTo(paramState1) < 0)) {
      return paramState2;
    }
    return paramState1;
  }
  
  private Lifecycle.State a(LifecycleObserver paramLifecycleObserver)
  {
    Object localObject = this.cd;
    if (((a)localObject).contains(paramLifecycleObserver))
    {
      paramLifecycleObserver = ((b.c)((a)localObject).bI.get(paramLifecycleObserver)).bO;
      if (paramLifecycleObserver == null) {
        break label93;
      }
      paramLifecycleObserver = ((ObserverWithState)paramLifecycleObserver.getValue()).ce;
      label45:
      if (this.cj.isEmpty()) {
        break label98;
      }
    }
    label93:
    label98:
    for (localObject = (Lifecycle.State)this.cj.get(this.cj.size() - 1);; localObject = null)
    {
      return a(a(this.ce, paramLifecycleObserver), (Lifecycle.State)localObject);
      paramLifecycleObserver = null;
      break;
      paramLifecycleObserver = null;
      break label45;
    }
  }
  
  private void a(Lifecycle.State paramState)
  {
    if (this.ce == paramState) {
      return;
    }
    this.ce = paramState;
    if ((this.ch) || (this.cg != 0))
    {
      this.ci = true;
      return;
    }
    this.ch = true;
    sync();
    this.ch = false;
  }
  
  private void a(LifecycleOwner paramLifecycleOwner)
  {
    b.d locald = this.cd.N();
    while ((locald.hasNext()) && (!this.ci))
    {
      Map.Entry localEntry = (Map.Entry)locald.next();
      ObserverWithState localObserverWithState = (ObserverWithState)localEntry.getValue();
      while ((localObserverWithState.ce.compareTo(this.ce) < 0) && (!this.ci) && (this.cd.contains(localEntry.getKey())))
      {
        b(localObserverWithState.ce);
        localObserverWithState.a(paramLifecycleOwner, c(localObserverWithState.ce));
        P();
      }
    }
  }
  
  private void b(Lifecycle.State paramState)
  {
    this.cj.add(paramState);
  }
  
  private static Lifecycle.Event c(Lifecycle.State paramState)
  {
    switch (1.ck[paramState.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value " + paramState);
    case 1: 
    case 5: 
      return Lifecycle.Event.ON_CREATE;
    case 2: 
      return Lifecycle.Event.ON_START;
    case 3: 
      return Lifecycle.Event.ON_RESUME;
    }
    throw new IllegalArgumentException();
  }
  
  private void sync()
  {
    LifecycleOwner localLifecycleOwner = (LifecycleOwner)this.cf.get();
    label16:
    Object localObject1;
    if (localLifecycleOwner == null)
    {
      return;
      break label147;
      localObject1 = this.cd.bK;
      if ((!this.ci) && (localObject1 != null) && (this.ce.compareTo(((ObserverWithState)((Map.Entry)localObject1).getValue()).ce) > 0)) {
        a(localLifecycleOwner);
      }
    }
    int i;
    if (this.cd.mSize == 0) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        this.ci = false;
        if (this.ce.compareTo(((ObserverWithState)this.cd.bJ.getValue()).ce) >= 0) {
          break label16;
        }
        localObject1 = this.cd;
        Object localObject2 = new b.b(((b)localObject1).bK, ((b)localObject1).bJ);
        ((b)localObject1).bL.put(localObject2, Boolean.valueOf(false));
        label147:
        if ((!((Iterator)localObject2).hasNext()) || (this.ci)) {
          break label16;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ObserverWithState localObserverWithState = (ObserverWithState)localEntry.getValue();
        if ((localObserverWithState.ce.compareTo(this.ce) <= 0) || (this.ci) || (!this.cd.contains(localEntry.getKey()))) {
          break;
        }
        localObject1 = localObserverWithState.ce;
        switch (1.ck[localObject1.ordinal()])
        {
        default: 
          throw new IllegalArgumentException("Unexpected state value " + localObject1);
          localObject1 = ((ObserverWithState)this.cd.bJ.getValue()).ce;
          localObject2 = ((ObserverWithState)this.cd.bK.getValue()).ce;
          if ((localObject1 == localObject2) && (this.ce == localObject2)) {
            i = 1;
          } else {
            i = 0;
          }
          break;
        case 1: 
          throw new IllegalArgumentException();
        case 2: 
          localObject1 = Lifecycle.Event.ON_DESTROY;
        case 3: 
        case 4: 
          for (;;)
          {
            b(a((Lifecycle.Event)localObject1));
            localObserverWithState.a(localLifecycleOwner, (Lifecycle.Event)localObject1);
            P();
            break;
            localObject1 = Lifecycle.Event.ON_STOP;
            continue;
            localObject1 = Lifecycle.Event.ON_PAUSE;
          }
        case 5: 
          throw new IllegalArgumentException();
        }
      }
    }
    this.ci = false;
  }
  
  public void addObserver(LifecycleObserver paramLifecycleObserver)
  {
    Lifecycle.State localState;
    ObserverWithState localObserverWithState;
    if (this.ce == Lifecycle.State.DESTROYED)
    {
      localState = Lifecycle.State.DESTROYED;
      localObserverWithState = new ObserverWithState(paramLifecycleObserver, localState);
      if ((ObserverWithState)this.cd.putIfAbsent(paramLifecycleObserver, localObserverWithState) == null) {
        break label49;
      }
    }
    label49:
    LifecycleOwner localLifecycleOwner;
    do
    {
      return;
      localState = Lifecycle.State.INITIALIZED;
      break;
      localLifecycleOwner = (LifecycleOwner)this.cf.get();
    } while (localLifecycleOwner == null);
    if ((this.cg != 0) || (this.ch)) {}
    for (int i = 1;; i = 0)
    {
      localState = a(paramLifecycleObserver);
      this.cg += 1;
      while ((localObserverWithState.ce.compareTo(localState) < 0) && (this.cd.contains(paramLifecycleObserver)))
      {
        b(localObserverWithState.ce);
        localObserverWithState.a(localLifecycleOwner, c(localObserverWithState.ce));
        P();
        localState = a(paramLifecycleObserver);
      }
    }
    if (i == 0) {
      sync();
    }
    this.cg -= 1;
  }
  
  public Lifecycle.State getCurrentState()
  {
    return this.ce;
  }
  
  public int getObserverCount()
  {
    return this.cd.mSize;
  }
  
  public void handleLifecycleEvent(Lifecycle.Event paramEvent)
  {
    a(a(paramEvent));
  }
  
  public void markState(Lifecycle.State paramState)
  {
    a(paramState);
  }
  
  public void removeObserver(LifecycleObserver paramLifecycleObserver)
  {
    this.cd.remove(paramLifecycleObserver);
  }
  
  static class ObserverWithState
  {
    Lifecycle.State ce;
    GenericLifecycleObserver cl;
    
    ObserverWithState(LifecycleObserver paramLifecycleObserver, Lifecycle.State paramState)
    {
      this.cl = Lifecycling.e(paramLifecycleObserver);
      this.ce = paramState;
    }
    
    final void a(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
    {
      Lifecycle.State localState = LifecycleRegistry.a(paramEvent);
      this.ce = LifecycleRegistry.a(this.ce, localState);
      this.cl.onStateChanged(paramLifecycleOwner, paramEvent);
      this.ce = localState;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.LifecycleRegistry
 * JD-Core Version:    0.7.0.1
 */