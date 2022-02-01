package android.arch.lifecycle;

import android.arch.a.a.a;
import android.arch.a.a.c;
import android.arch.a.b.b;
import android.arch.a.b.b.d;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData<T>
{
  private static final Object cN = new Object();
  private final Object cM = new Object();
  private b<Observer<T>, LiveData<T>.ObserverWrapper> cO = new b();
  private int cP = 0;
  private volatile Object cQ = cN;
  int cR = -1;
  private boolean cS;
  private boolean cT;
  private final Runnable cU = new Runnable()
  {
    public void run()
    {
      synchronized (LiveData.a(LiveData.this))
      {
        Object localObject2 = LiveData.b(LiveData.this);
        LiveData.a(LiveData.this, LiveData.X());
        LiveData.this.setValue(localObject2);
        return;
      }
    }
  };
  private volatile Object mData = cN;
  
  private void a(LiveData<T>.ObserverWrapper paramLiveData)
  {
    if (!paramLiveData.mActive) {}
    do
    {
      return;
      if (!paramLiveData.Y())
      {
        paramLiveData.l(false);
        return;
      }
    } while (paramLiveData.cY >= this.cR);
    paramLiveData.cY = this.cR;
    paramLiveData.cX.onChanged(this.mData);
  }
  
  private void b(LiveData<T>.ObserverWrapper paramLiveData)
  {
    if (this.cS)
    {
      this.cT = true;
      return;
    }
    this.cS = true;
    this.cT = false;
    LiveData<T>.ObserverWrapper localLiveData;
    if (paramLiveData != null)
    {
      a(paramLiveData);
      localLiveData = null;
    }
    for (;;)
    {
      paramLiveData = localLiveData;
      if (this.cT) {
        break;
      }
      this.cS = false;
      return;
      b.d locald = this.cO.S();
      do
      {
        localLiveData = paramLiveData;
        if (!locald.hasNext()) {
          break;
        }
        a((ObserverWrapper)((Map.Entry)locald.next()).getValue());
      } while (!this.cT);
      localLiveData = paramLiveData;
    }
  }
  
  private static void h(String paramString)
  {
    if (!a.P().bK.isMainThread()) {
      throw new IllegalStateException("Cannot invoke " + paramString + " on a background thread");
    }
  }
  
  protected void W() {}
  
  public T getValue()
  {
    Object localObject = this.mData;
    if (localObject != cN) {
      return localObject;
    }
    return null;
  }
  
  public boolean hasActiveObservers()
  {
    return this.cP > 0;
  }
  
  public boolean hasObservers()
  {
    return this.cO.mSize > 0;
  }
  
  public void observe(LifecycleOwner paramLifecycleOwner, Observer<T> paramObserver)
  {
    if (paramLifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {}
    LifecycleBoundObserver localLifecycleBoundObserver;
    do
    {
      return;
      localLifecycleBoundObserver = new LifecycleBoundObserver(paramLifecycleOwner, paramObserver);
      paramObserver = (ObserverWrapper)this.cO.putIfAbsent(paramObserver, localLifecycleBoundObserver);
      if ((paramObserver != null) && (!paramObserver.c(paramLifecycleOwner))) {
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
      }
    } while (paramObserver != null);
    paramLifecycleOwner.getLifecycle().addObserver(localLifecycleBoundObserver);
  }
  
  public void observeForever(Observer<T> paramObserver)
  {
    AlwaysActiveObserver localAlwaysActiveObserver = new AlwaysActiveObserver(paramObserver);
    paramObserver = (ObserverWrapper)this.cO.putIfAbsent(paramObserver, localAlwaysActiveObserver);
    if ((paramObserver != null) && ((paramObserver instanceof LifecycleBoundObserver))) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (paramObserver != null) {
      return;
    }
    localAlwaysActiveObserver.l(true);
  }
  
  protected void onActive() {}
  
  protected void postValue(T paramT)
  {
    for (;;)
    {
      synchronized (this.cM)
      {
        if (this.cQ != cN) {
          break label47;
        }
        i = 1;
        this.cQ = paramT;
        if (i == 0) {
          return;
        }
      }
      a.P().f(this.cU);
      return;
      label47:
      int i = 0;
    }
  }
  
  public void removeObserver(Observer<T> paramObserver)
  {
    h("removeObserver");
    paramObserver = (ObserverWrapper)this.cO.remove(paramObserver);
    if (paramObserver == null) {
      return;
    }
    paramObserver.Z();
    paramObserver.l(false);
  }
  
  public void removeObservers(LifecycleOwner paramLifecycleOwner)
  {
    h("removeObservers");
    Iterator localIterator = this.cO.iterator();
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
    h("setValue");
    this.cR += 1;
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
    
    final boolean Y()
    {
      return true;
    }
  }
  
  class LifecycleBoundObserver
    extends LiveData<T>.ObserverWrapper
    implements GenericLifecycleObserver
  {
    final LifecycleOwner cW;
    
    LifecycleBoundObserver(Observer<T> paramObserver)
    {
      super(localObserver);
      this.cW = paramObserver;
    }
    
    final boolean Y()
    {
      return this.cW.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
    }
    
    final void Z()
    {
      this.cW.getLifecycle().removeObserver(this);
    }
    
    final boolean c(LifecycleOwner paramLifecycleOwner)
    {
      return this.cW == paramLifecycleOwner;
    }
    
    public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
    {
      if (this.cW.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED)
      {
        LiveData.this.removeObserver(this.cX);
        return;
      }
      l(Y());
    }
  }
  
  abstract class ObserverWrapper
  {
    final Observer<T> cX;
    int cY = -1;
    boolean mActive;
    
    ObserverWrapper()
    {
      Object localObject;
      this.cX = localObject;
    }
    
    abstract boolean Y();
    
    void Z() {}
    
    boolean c(LifecycleOwner paramLifecycleOwner)
    {
      return false;
    }
    
    final void l(boolean paramBoolean)
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
          LiveData.this.W();
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