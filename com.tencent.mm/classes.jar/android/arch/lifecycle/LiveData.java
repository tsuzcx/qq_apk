package android.arch.lifecycle;

import android.arch.a.a.a;
import android.arch.a.a.c;
import android.arch.a.b.b;
import android.arch.a.b.b.d;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData<T>
{
  private static final Object cK = new Object();
  private final Object cJ = new Object();
  private b<Observer<T>, LiveData<T>.ObserverWrapper> cL = new b();
  private int cM = 0;
  private volatile Object cN = cK;
  int cO = -1;
  private boolean cP;
  private boolean cQ;
  private final Runnable cR = new Runnable()
  {
    public void run()
    {
      synchronized (LiveData.a(LiveData.this))
      {
        Object localObject2 = LiveData.b(LiveData.this);
        LiveData.a(LiveData.this, LiveData.ao());
        LiveData.this.setValue(localObject2);
        return;
      }
    }
  };
  private volatile Object mData = cK;
  
  private void a(LiveData<T>.ObserverWrapper paramLiveData)
  {
    if (!paramLiveData.mActive) {}
    do
    {
      return;
      if (!paramLiveData.ap())
      {
        paramLiveData.m(false);
        return;
      }
    } while (paramLiveData.cV >= this.cO);
    paramLiveData.cV = this.cO;
    paramLiveData.cU.onChanged(this.mData);
  }
  
  private void b(LiveData<T>.ObserverWrapper paramLiveData)
  {
    if (this.cP)
    {
      this.cQ = true;
      return;
    }
    this.cP = true;
    this.cQ = false;
    LiveData<T>.ObserverWrapper localLiveData;
    if (paramLiveData != null)
    {
      a(paramLiveData);
      localLiveData = null;
    }
    for (;;)
    {
      paramLiveData = localLiveData;
      if (this.cQ) {
        break;
      }
      this.cP = false;
      return;
      b.d locald = this.cL.af();
      do
      {
        localLiveData = paramLiveData;
        if (!locald.hasNext()) {
          break;
        }
        a((ObserverWrapper)((Map.Entry)locald.next()).getValue());
      } while (!this.cQ);
      localLiveData = paramLiveData;
    }
  }
  
  private static void z(String paramString)
  {
    if (!a.aa().bH.isMainThread()) {
      throw new IllegalStateException("Cannot invoke " + paramString + " on a background thread");
    }
  }
  
  protected void an() {}
  
  public T getValue()
  {
    Object localObject = this.mData;
    if (localObject != cK) {
      return localObject;
    }
    return null;
  }
  
  public boolean hasActiveObservers()
  {
    return this.cM > 0;
  }
  
  public boolean hasObservers()
  {
    return this.cL.mSize > 0;
  }
  
  public void observe(LifecycleOwner paramLifecycleOwner, Observer<T> paramObserver)
  {
    if (paramLifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {}
    LifecycleBoundObserver localLifecycleBoundObserver;
    do
    {
      return;
      localLifecycleBoundObserver = new LifecycleBoundObserver(paramLifecycleOwner, paramObserver);
      paramObserver = (ObserverWrapper)this.cL.putIfAbsent(paramObserver, localLifecycleBoundObserver);
      if ((paramObserver != null) && (!paramObserver.c(paramLifecycleOwner))) {
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
      }
    } while (paramObserver != null);
    paramLifecycleOwner.getLifecycle().addObserver(localLifecycleBoundObserver);
  }
  
  public void observeForever(Observer<T> paramObserver)
  {
    AlwaysActiveObserver localAlwaysActiveObserver = new AlwaysActiveObserver(paramObserver);
    paramObserver = (ObserverWrapper)this.cL.putIfAbsent(paramObserver, localAlwaysActiveObserver);
    if ((paramObserver != null) && ((paramObserver instanceof LifecycleBoundObserver))) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (paramObserver != null) {
      return;
    }
    localAlwaysActiveObserver.m(true);
  }
  
  protected void onActive() {}
  
  protected void postValue(T paramT)
  {
    for (;;)
    {
      synchronized (this.cJ)
      {
        if (this.cN != cK) {
          break label47;
        }
        i = 1;
        this.cN = paramT;
        if (i == 0) {
          return;
        }
      }
      a.aa().d(this.cR);
      return;
      label47:
      int i = 0;
    }
  }
  
  public void removeObserver(Observer<T> paramObserver)
  {
    z("removeObserver");
    paramObserver = (ObserverWrapper)this.cL.remove(paramObserver);
    if (paramObserver == null) {
      return;
    }
    paramObserver.aq();
    paramObserver.m(false);
  }
  
  public void removeObservers(LifecycleOwner paramLifecycleOwner)
  {
    z("removeObservers");
    Iterator localIterator = this.cL.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((ObserverWrapper)localEntry.getValue()).c(paramLifecycleOwner)) {
        removeObserver((Observer)localEntry.getKey());
      }
    }
  }
  
  protected void setValue(T paramT)
  {
    z("setValue");
    this.cO += 1;
    this.mData = paramT;
    b(null);
  }
  
  class AlwaysActiveObserver
    extends LiveData<T>.ObserverWrapper
  {
    AlwaysActiveObserver()
    {
      super(localObserver);
    }
    
    final boolean ap()
    {
      return true;
    }
  }
  
  class LifecycleBoundObserver
    extends LiveData<T>.ObserverWrapper
    implements GenericLifecycleObserver
  {
    final LifecycleOwner cT;
    
    LifecycleBoundObserver(Observer<T> paramObserver)
    {
      super(localObserver);
      this.cT = paramObserver;
    }
    
    final boolean ap()
    {
      return this.cT.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
    }
    
    final void aq()
    {
      this.cT.getLifecycle().removeObserver(this);
    }
    
    final boolean c(LifecycleOwner paramLifecycleOwner)
    {
      return this.cT == paramLifecycleOwner;
    }
    
    public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
    {
      if (this.cT.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED)
      {
        LiveData.this.removeObserver(this.cU);
        return;
      }
      m(ap());
    }
  }
  
  abstract class ObserverWrapper
  {
    final Observer<T> cU;
    int cV = -1;
    boolean mActive;
    
    ObserverWrapper()
    {
      Object localObject;
      this.cU = localObject;
    }
    
    abstract boolean ap();
    
    void aq() {}
    
    boolean c(LifecycleOwner paramLifecycleOwner)
    {
      return false;
    }
    
    final void m(boolean paramBoolean)
    {
      int j = 1;
      if (paramBoolean == this.mActive) {
        return;
      }
      this.mActive = paramBoolean;
      int i;
      label28:
      LiveData localLiveData;
      int k;
      if (LiveData.c(LiveData.this) == 0)
      {
        i = 1;
        localLiveData = LiveData.this;
        k = LiveData.c(localLiveData);
        if (!this.mActive) {
          break label121;
        }
      }
      for (;;)
      {
        LiveData.a(localLiveData, j + k);
        if ((i != 0) && (this.mActive)) {
          LiveData.this.onActive();
        }
        if ((LiveData.c(LiveData.this) == 0) && (!this.mActive)) {
          LiveData.this.an();
        }
        if (!this.mActive) {
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