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
  private a<LifecycleObserver, ObserverWithState> cA = new a();
  private Lifecycle.State cB;
  private final WeakReference<LifecycleOwner> cC;
  private int cD = 0;
  private boolean cE = false;
  private boolean cF = false;
  private ArrayList<Lifecycle.State> cG = new ArrayList();
  
  public LifecycleRegistry(LifecycleOwner paramLifecycleOwner)
  {
    this.cC = new WeakReference(paramLifecycleOwner);
    this.cB = Lifecycle.State.INITIALIZED;
  }
  
  private boolean T()
  {
    if (this.cA.mSize == 0) {
      return true;
    }
    Lifecycle.State localState1 = ((ObserverWithState)this.cA.bQ.getValue()).cB;
    Lifecycle.State localState2 = ((ObserverWithState)this.cA.bR.getValue()).cB;
    return (localState1 == localState2) && (this.cB == localState2);
  }
  
  private void U()
  {
    this.cG.remove(this.cG.size() - 1);
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
    Object localObject = this.cA;
    if (((a)localObject).contains(paramLifecycleObserver))
    {
      paramLifecycleObserver = ((b.c)((a)localObject).bP.get(paramLifecycleObserver)).bV;
      if (paramLifecycleObserver == null) {
        break label93;
      }
      paramLifecycleObserver = ((ObserverWithState)paramLifecycleObserver.getValue()).cB;
      label45:
      if (this.cG.isEmpty()) {
        break label98;
      }
    }
    label93:
    label98:
    for (localObject = (Lifecycle.State)this.cG.get(this.cG.size() - 1);; localObject = null)
    {
      return a(a(this.cB, paramLifecycleObserver), (Lifecycle.State)localObject);
      paramLifecycleObserver = null;
      break;
      paramLifecycleObserver = null;
      break label45;
    }
  }
  
  private void a(Lifecycle.State paramState)
  {
    if (this.cB == paramState) {
      return;
    }
    this.cB = paramState;
    if ((this.cE) || (this.cD != 0))
    {
      this.cF = true;
      return;
    }
    this.cE = true;
    sync();
    this.cE = false;
  }
  
  private void a(LifecycleOwner paramLifecycleOwner)
  {
    b.d locald = this.cA.R();
    while ((locald.hasNext()) && (!this.cF))
    {
      Map.Entry localEntry = (Map.Entry)locald.next();
      ObserverWithState localObserverWithState = (ObserverWithState)localEntry.getValue();
      while ((localObserverWithState.cB.compareTo(this.cB) < 0) && (!this.cF) && (this.cA.contains(localEntry.getKey())))
      {
        b(localObserverWithState.cB);
        localObserverWithState.a(paramLifecycleOwner, c(localObserverWithState.cB));
        U();
      }
    }
  }
  
  static Lifecycle.State b(Lifecycle.Event paramEvent)
  {
    switch (1.cp[paramEvent.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unexpected event value ".concat(String.valueOf(paramEvent)));
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
  
  private void b(Lifecycle.State paramState)
  {
    this.cG.add(paramState);
  }
  
  private void b(LifecycleOwner paramLifecycleOwner)
  {
    Object localObject = this.cA;
    b.b localb = new b.b(((b)localObject).bR, ((b)localObject).bQ);
    ((b)localObject).bS.put(localb, Boolean.FALSE);
    while ((localb.hasNext()) && (!this.cF))
    {
      Map.Entry localEntry = (Map.Entry)localb.next();
      ObserverWithState localObserverWithState = (ObserverWithState)localEntry.getValue();
      if ((localObserverWithState.cB.compareTo(this.cB) > 0) && (!this.cF) && (this.cA.contains(localEntry.getKey())))
      {
        localObject = localObserverWithState.cB;
        switch (1.cH[localObject.ordinal()])
        {
        default: 
          throw new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(localObject)));
        case 1: 
          throw new IllegalArgumentException();
        case 2: 
          localObject = Lifecycle.Event.ON_DESTROY;
        case 3: 
        case 4: 
          for (;;)
          {
            b(b((Lifecycle.Event)localObject));
            localObserverWithState.a(paramLifecycleOwner, (Lifecycle.Event)localObject);
            U();
            break;
            localObject = Lifecycle.Event.ON_STOP;
            continue;
            localObject = Lifecycle.Event.ON_PAUSE;
          }
        }
        throw new IllegalArgumentException();
      }
    }
  }
  
  private static Lifecycle.Event c(Lifecycle.State paramState)
  {
    switch (1.cH[paramState.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(paramState)));
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
    LifecycleOwner localLifecycleOwner = (LifecycleOwner)this.cC.get();
    if (localLifecycleOwner == null) {
      return;
    }
    while (!T())
    {
      this.cF = false;
      if (this.cB.compareTo(((ObserverWithState)this.cA.bQ.getValue()).cB) < 0) {
        b(localLifecycleOwner);
      }
      b.c localc = this.cA.bR;
      if ((!this.cF) && (localc != null) && (this.cB.compareTo(((ObserverWithState)localc.getValue()).cB) > 0)) {
        a(localLifecycleOwner);
      }
    }
    this.cF = false;
  }
  
  public void addObserver(LifecycleObserver paramLifecycleObserver)
  {
    Lifecycle.State localState;
    ObserverWithState localObserverWithState;
    if (this.cB == Lifecycle.State.DESTROYED)
    {
      localState = Lifecycle.State.DESTROYED;
      localObserverWithState = new ObserverWithState(paramLifecycleObserver, localState);
      if ((ObserverWithState)this.cA.putIfAbsent(paramLifecycleObserver, localObserverWithState) == null) {
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
      localLifecycleOwner = (LifecycleOwner)this.cC.get();
    } while (localLifecycleOwner == null);
    if ((this.cD != 0) || (this.cE)) {}
    for (int i = 1;; i = 0)
    {
      localState = a(paramLifecycleObserver);
      this.cD += 1;
      while ((localObserverWithState.cB.compareTo(localState) < 0) && (this.cA.contains(paramLifecycleObserver)))
      {
        b(localObserverWithState.cB);
        localObserverWithState.a(localLifecycleOwner, c(localObserverWithState.cB));
        U();
        localState = a(paramLifecycleObserver);
      }
    }
    if (i == 0) {
      sync();
    }
    this.cD -= 1;
  }
  
  public Lifecycle.State getCurrentState()
  {
    return this.cB;
  }
  
  public int getObserverCount()
  {
    return this.cA.mSize;
  }
  
  public void handleLifecycleEvent(Lifecycle.Event paramEvent)
  {
    a(b(paramEvent));
  }
  
  public void markState(Lifecycle.State paramState)
  {
    a(paramState);
  }
  
  public void removeObserver(LifecycleObserver paramLifecycleObserver)
  {
    this.cA.remove(paramLifecycleObserver);
  }
  
  static class ObserverWithState
  {
    Lifecycle.State cB;
    GenericLifecycleObserver cI;
    
    ObserverWithState(LifecycleObserver paramLifecycleObserver, Lifecycle.State paramState)
    {
      this.cI = Lifecycling.d(paramLifecycleObserver);
      this.cB = paramState;
    }
    
    final void a(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
    {
      Lifecycle.State localState = LifecycleRegistry.b(paramEvent);
      this.cB = LifecycleRegistry.a(this.cB, localState);
      this.cI.onStateChanged(paramLifecycleOwner, paramEvent);
      this.cB = localState;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.LifecycleRegistry
 * JD-Core Version:    0.7.0.1
 */