package android.arch.lifecycle;

import android.arch.a.a.a;
import android.arch.a.a.c;
import android.arch.a.b.b;
import android.arch.a.b.b.d;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData<T>
{
  private static final Object cp = new Object();
  private final Object co = new Object();
  private b<Observer<T>, LiveData<T>.ObserverWrapper> cq = new b();
  private int cs = 0;
  private volatile Object ct = cp;
  private boolean cu;
  private boolean cv;
  private final Runnable cw = new Runnable()
  {
    public void run()
    {
      synchronized (LiveData.a(LiveData.this))
      {
        Object localObject2 = LiveData.b(LiveData.this);
        LiveData.a(LiveData.this, LiveData.Q());
        LiveData.this.setValue(localObject2);
        return;
      }
    }
  };
  private volatile Object mData = cp;
  private int mVersion = -1;
  
  private void a(LiveData<T>.ObserverWrapper paramLiveData)
  {
    if (!paramLiveData.cA) {}
    do
    {
      return;
      if (!paramLiveData.R())
      {
        paramLiveData.n(false);
        return;
      }
    } while (paramLiveData.cB >= this.mVersion);
    paramLiveData.cB = this.mVersion;
    paramLiveData.cz.onChanged(this.mData);
  }
  
  private void b(LiveData<T>.ObserverWrapper paramLiveData)
  {
    if (this.cu)
    {
      this.cv = true;
      return;
    }
    this.cu = true;
    this.cv = false;
    LiveData<T>.ObserverWrapper localLiveData;
    if (paramLiveData != null)
    {
      a(paramLiveData);
      localLiveData = null;
    }
    for (;;)
    {
      paramLiveData = localLiveData;
      if (this.cv) {
        break;
      }
      this.cu = false;
      return;
      b.d locald = this.cq.N();
      do
      {
        localLiveData = paramLiveData;
        if (!locald.hasNext()) {
          break;
        }
        a((ObserverWrapper)((Map.Entry)locald.next()).getValue());
      } while (!this.cv);
      localLiveData = paramLiveData;
    }
  }
  
  private static void z(String paramString)
  {
    if (!a.M().bD.isMainThread()) {
      throw new IllegalStateException("Cannot invoke " + paramString + " on a background thread");
    }
  }
  
  public T getValue()
  {
    Object localObject = this.mData;
    if (localObject != cp) {
      return localObject;
    }
    return null;
  }
  
  public boolean hasActiveObservers()
  {
    return this.cs > 0;
  }
  
  public boolean hasObservers()
  {
    return this.cq.mSize > 0;
  }
  
  public void observe(LifecycleOwner paramLifecycleOwner, Observer<T> paramObserver)
  {
    if (paramLifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {}
    LifecycleBoundObserver localLifecycleBoundObserver;
    do
    {
      return;
      localLifecycleBoundObserver = new LifecycleBoundObserver(paramLifecycleOwner, paramObserver);
      paramObserver = (ObserverWrapper)this.cq.putIfAbsent(paramObserver, localLifecycleBoundObserver);
      if ((paramObserver != null) && (!paramObserver.b(paramLifecycleOwner))) {
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
      }
    } while (paramObserver != null);
    paramLifecycleOwner.getLifecycle().addObserver(localLifecycleBoundObserver);
  }
  
  public void observeForever(Observer<T> paramObserver)
  {
    AlwaysActiveObserver localAlwaysActiveObserver = new AlwaysActiveObserver(paramObserver);
    paramObserver = (ObserverWrapper)this.cq.putIfAbsent(paramObserver, localAlwaysActiveObserver);
    if ((paramObserver != null) && ((paramObserver instanceof LifecycleBoundObserver))) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (paramObserver != null) {
      return;
    }
    localAlwaysActiveObserver.n(true);
  }
  
  public void onActive() {}
  
  public void onInactive() {}
  
  protected void postValue(T paramT)
  {
    for (;;)
    {
      synchronized (this.co)
      {
        if (this.ct != cp) {
          break label47;
        }
        i = 1;
        this.ct = paramT;
        if (i == 0) {
          return;
        }
      }
      a.M().d(this.cw);
      return;
      label47:
      int i = 0;
    }
  }
  
  public void removeObserver(Observer<T> paramObserver)
  {
    z("removeObserver");
    paramObserver = (ObserverWrapper)this.cq.remove(paramObserver);
    if (paramObserver == null) {
      return;
    }
    paramObserver.S();
    paramObserver.n(false);
  }
  
  public void removeObservers(LifecycleOwner paramLifecycleOwner)
  {
    z("removeObservers");
    Iterator localIterator = this.cq.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((ObserverWrapper)localEntry.getValue()).b(paramLifecycleOwner)) {
        removeObserver((Observer)localEntry.getKey());
      }
    }
  }
  
  public void setValue(T paramT)
  {
    z("setValue");
    this.mVersion += 1;
    this.mData = paramT;
    b(null);
  }
  
  private class AlwaysActiveObserver
    extends LiveData<T>.ObserverWrapper
  {
    AlwaysActiveObserver()
    {
      super(localObserver);
    }
    
    final boolean R()
    {
      return true;
    }
  }
  
  class LifecycleBoundObserver
    extends LiveData<T>.ObserverWrapper
    implements GenericLifecycleObserver
  {
    final LifecycleOwner cy;
    
    LifecycleBoundObserver(Observer<T> paramObserver)
    {
      super(localObserver);
      this.cy = paramObserver;
    }
    
    final boolean R()
    {
      return this.cy.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
    }
    
    final void S()
    {
      this.cy.getLifecycle().removeObserver(this);
    }
    
    final boolean b(LifecycleOwner paramLifecycleOwner)
    {
      return this.cy == paramLifecycleOwner;
    }
    
    public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
    {
      if (this.cy.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED)
      {
        LiveData.this.removeObserver(this.cz);
        return;
      }
      n(R());
    }
  }
  
  private abstract class ObserverWrapper
  {
    boolean cA;
    int cB = -1;
    final Observer<T> cz;
    
    ObserverWrapper()
    {
      Object localObject;
      this.cz = localObject;
    }
    
    abstract boolean R();
    
    void S() {}
    
    boolean b(LifecycleOwner paramLifecycleOwner)
    {
      return false;
    }
    
    final void n(boolean paramBoolean)
    {
      int j = 1;
      if (paramBoolean == this.cA) {
        return;
      }
      this.cA = paramBoolean;
      int i;
      label28:
      LiveData localLiveData;
      int k;
      if (LiveData.c(LiveData.this) == 0)
      {
        i = 1;
        localLiveData = LiveData.this;
        k = LiveData.c(localLiveData);
        if (!this.cA) {
          break label121;
        }
      }
      for (;;)
      {
        LiveData.a(localLiveData, j + k);
        if ((i != 0) && (this.cA)) {
          LiveData.this.onActive();
        }
        if ((LiveData.c(LiveData.this) == 0) && (!this.cA)) {
          LiveData.this.onInactive();
        }
        if (!this.cA) {
          break;
        }
        LiveData.a(LiveData.this, this);
        return;
        i = 0;
        break label28;
        label121:
        j = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.LiveData
 * JD-Core Version:    0.7.0.1
 */