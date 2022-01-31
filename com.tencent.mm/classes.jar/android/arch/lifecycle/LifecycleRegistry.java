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
  private int cA = 0;
  private boolean cB = false;
  private boolean cC = false;
  private ArrayList<Lifecycle.State> cD = new ArrayList();
  private a<LifecycleObserver, ObserverWithState> cx = new a();
  private Lifecycle.State cy;
  private final WeakReference<LifecycleOwner> cz;
  
  public LifecycleRegistry(LifecycleOwner paramLifecycleOwner)
  {
    this.cz = new WeakReference(paramLifecycleOwner);
    this.cy = Lifecycle.State.INITIALIZED;
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
    Object localObject = this.cx;
    if (((a)localObject).contains(paramLifecycleObserver))
    {
      paramLifecycleObserver = ((b.c)((a)localObject).bM.get(paramLifecycleObserver)).bS;
      if (paramLifecycleObserver == null) {
        break label93;
      }
      paramLifecycleObserver = ((ObserverWithState)paramLifecycleObserver.getValue()).cy;
      label45:
      if (this.cD.isEmpty()) {
        break label98;
      }
    }
    label93:
    label98:
    for (localObject = (Lifecycle.State)this.cD.get(this.cD.size() - 1);; localObject = null)
    {
      return a(a(this.cy, paramLifecycleObserver), (Lifecycle.State)localObject);
      paramLifecycleObserver = null;
      break;
      paramLifecycleObserver = null;
      break label45;
    }
  }
  
  private void a(Lifecycle.State paramState)
  {
    if (this.cy == paramState) {
      return;
    }
    this.cy = paramState;
    if ((this.cB) || (this.cA != 0))
    {
      this.cC = true;
      return;
    }
    this.cB = true;
    sync();
    this.cB = false;
  }
  
  private void a(LifecycleOwner paramLifecycleOwner)
  {
    b.d locald = this.cx.af();
    while ((locald.hasNext()) && (!this.cC))
    {
      Map.Entry localEntry = (Map.Entry)locald.next();
      ObserverWithState localObserverWithState = (ObserverWithState)localEntry.getValue();
      while ((localObserverWithState.cy.compareTo(this.cy) < 0) && (!this.cC) && (this.cx.contains(localEntry.getKey())))
      {
        b(localObserverWithState.cy);
        localObserverWithState.a(paramLifecycleOwner, c(localObserverWithState.cy));
        am();
      }
    }
  }
  
  private boolean al()
  {
    if (this.cx.mSize == 0) {
      return true;
    }
    Lifecycle.State localState1 = ((ObserverWithState)this.cx.bN.getValue()).cy;
    Lifecycle.State localState2 = ((ObserverWithState)this.cx.bO.getValue()).cy;
    return (localState1 == localState2) && (this.cy == localState2);
  }
  
  private void am()
  {
    this.cD.remove(this.cD.size() - 1);
  }
  
  static Lifecycle.State b(Lifecycle.Event paramEvent)
  {
    switch (1.cm[paramEvent.ordinal()])
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
    this.cD.add(paramState);
  }
  
  private void b(LifecycleOwner paramLifecycleOwner)
  {
    Object localObject = this.cx;
    b.b localb = new b.b(((b)localObject).bO, ((b)localObject).bN);
    ((b)localObject).bP.put(localb, Boolean.FALSE);
    while ((localb.hasNext()) && (!this.cC))
    {
      Map.Entry localEntry = (Map.Entry)localb.next();
      ObserverWithState localObserverWithState = (ObserverWithState)localEntry.getValue();
      if ((localObserverWithState.cy.compareTo(this.cy) > 0) && (!this.cC) && (this.cx.contains(localEntry.getKey())))
      {
        localObject = localObserverWithState.cy;
        switch (1.cE[localObject.ordinal()])
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
            am();
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
    switch (1.cE[paramState.ordinal()])
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
    LifecycleOwner localLifecycleOwner = (LifecycleOwner)this.cz.get();
    if (localLifecycleOwner == null) {
      return;
    }
    while (!al())
    {
      this.cC = false;
      if (this.cy.compareTo(((ObserverWithState)this.cx.bN.getValue()).cy) < 0) {
        b(localLifecycleOwner);
      }
      b.c localc = this.cx.bO;
      if ((!this.cC) && (localc != null) && (this.cy.compareTo(((ObserverWithState)localc.getValue()).cy) > 0)) {
        a(localLifecycleOwner);
      }
    }
    this.cC = false;
  }
  
  public void addObserver(LifecycleObserver paramLifecycleObserver)
  {
    Lifecycle.State localState;
    ObserverWithState localObserverWithState;
    if (this.cy == Lifecycle.State.DESTROYED)
    {
      localState = Lifecycle.State.DESTROYED;
      localObserverWithState = new ObserverWithState(paramLifecycleObserver, localState);
      if ((ObserverWithState)this.cx.putIfAbsent(paramLifecycleObserver, localObserverWithState) == null) {
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
      localLifecycleOwner = (LifecycleOwner)this.cz.get();
    } while (localLifecycleOwner == null);
    if ((this.cA != 0) || (this.cB)) {}
    for (int i = 1;; i = 0)
    {
      localState = a(paramLifecycleObserver);
      this.cA += 1;
      while ((localObserverWithState.cy.compareTo(localState) < 0) && (this.cx.contains(paramLifecycleObserver)))
      {
        b(localObserverWithState.cy);
        localObserverWithState.a(localLifecycleOwner, c(localObserverWithState.cy));
        am();
        localState = a(paramLifecycleObserver);
      }
    }
    if (i == 0) {
      sync();
    }
    this.cA -= 1;
  }
  
  public Lifecycle.State getCurrentState()
  {
    return this.cy;
  }
  
  public int getObserverCount()
  {
    return this.cx.mSize;
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
    this.cx.remove(paramLifecycleObserver);
  }
  
  static class ObserverWithState
  {
    GenericLifecycleObserver cF;
    Lifecycle.State cy;
    
    ObserverWithState(LifecycleObserver paramLifecycleObserver, Lifecycle.State paramState)
    {
      this.cF = Lifecycling.e(paramLifecycleObserver);
      this.cy = paramState;
    }
    
    final void a(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
    {
      Lifecycle.State localState = LifecycleRegistry.b(paramEvent);
      this.cy = LifecycleRegistry.a(this.cy, localState);
      this.cF.onStateChanged(paramLifecycleOwner, paramEvent);
      this.cy = localState;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.LifecycleRegistry
 * JD-Core Version:    0.7.0.1
 */