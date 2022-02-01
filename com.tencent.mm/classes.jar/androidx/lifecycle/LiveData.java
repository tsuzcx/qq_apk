package androidx.lifecycle;

import androidx.a.a.a.a;
import androidx.a.a.a.c;
import androidx.a.a.b.b;
import androidx.a.a.b.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData<T>
{
  static final Object aaj = new Object();
  final Object aai = new Object();
  public b<s<? super T>, LiveData<T>.b> aak = new b();
  int aal = 0;
  volatile Object aam = aaj;
  int aan = -1;
  private boolean aao;
  private boolean aap;
  private final Runnable aaq = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(241191);
      synchronized (LiveData.this.aai)
      {
        Object localObject2 = LiveData.this.aam;
        LiveData.this.aam = LiveData.aaj;
        LiveData.this.setValue(localObject2);
        AppMethodBeat.o(241191);
        return;
      }
    }
  };
  private volatile Object mData = aaj;
  
  private static void P(String paramString)
  {
    if (!a.eJ().xW.isMainThread()) {
      throw new IllegalStateException("Cannot invoke " + paramString + " on a background thread");
    }
  }
  
  private void a(LiveData<T>.b paramLiveData)
  {
    if (!paramLiveData.mActive) {}
    do
    {
      return;
      if (!paramLiveData.shouldBeActive())
      {
        paramLiveData.an(false);
        return;
      }
    } while (paramLiveData.aau >= this.aan);
    paramLiveData.aau = this.aan;
    paramLiveData.aat.onChanged(this.mData);
  }
  
  protected void L(T paramT)
  {
    synchronized (this.aai)
    {
      int i;
      if (this.aam == aaj)
      {
        i = 1;
        this.aam = paramT;
        if (i != 0) {}
      }
      else
      {
        i = 0;
      }
    }
    a.eJ().postToMainThread(this.aaq);
  }
  
  public final void a(l paraml, s<? super T> params)
  {
    P("observe");
    if (paraml.getLifecycle().jc() == h.b.ZO) {}
    LifecycleBoundObserver localLifecycleBoundObserver;
    do
    {
      return;
      localLifecycleBoundObserver = new LifecycleBoundObserver(paraml, params);
      params = (b)this.aak.putIfAbsent(params, localLifecycleBoundObserver);
      if ((params != null) && (!params.d(paraml))) {
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
      }
    } while (params != null);
    paraml.getLifecycle().a(localLifecycleBoundObserver);
  }
  
  public final void a(s<? super T> params)
  {
    P("observeForever");
    a locala = new a(params);
    params = (b)this.aak.putIfAbsent(params, locala);
    if ((params != null) && ((params instanceof LifecycleBoundObserver))) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (params != null) {
      return;
    }
    locala.an(true);
  }
  
  final void b(LiveData<T>.b paramLiveData)
  {
    if (this.aao)
    {
      this.aap = true;
      return;
    }
    this.aao = true;
    this.aap = false;
    LiveData<T>.b localLiveData;
    if (paramLiveData != null)
    {
      a(paramLiveData);
      localLiveData = null;
    }
    for (;;)
    {
      paramLiveData = localLiveData;
      if (this.aap) {
        break;
      }
      this.aao = false;
      return;
      b.d locald = this.aak.eM();
      do
      {
        localLiveData = paramLiveData;
        if (!locald.hasNext()) {
          break;
        }
        a((b)((Map.Entry)locald.next()).getValue());
      } while (!this.aap);
      localLiveData = paramLiveData;
    }
  }
  
  public void b(s<? super T> params)
  {
    P("removeObserver");
    params = (b)this.aak.remove(params);
    if (params == null) {
      return;
    }
    params.detachObserver();
    params.an(false);
  }
  
  public final void c(l paraml)
  {
    P("removeObservers");
    Iterator localIterator = this.aak.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((b)localEntry.getValue()).d(paraml)) {
        b((s)localEntry.getKey());
      }
    }
  }
  
  public final T getValue()
  {
    Object localObject = this.mData;
    if (localObject != aaj) {
      return localObject;
    }
    return null;
  }
  
  protected void jb() {}
  
  protected void jh() {}
  
  public final boolean ji()
  {
    return this.aal > 0;
  }
  
  protected void setValue(T paramT)
  {
    P("setValue");
    this.aan += 1;
    this.mData = paramT;
    b(null);
  }
  
  class LifecycleBoundObserver
    extends LiveData<T>.b
    implements g
  {
    final l aas;
    
    LifecycleBoundObserver(s<? super T> params)
    {
      super(locals);
      this.aas = params;
    }
    
    public final void a(l paraml, h.a parama)
    {
      AppMethodBeat.i(241200);
      if (this.aas.getLifecycle().jc() == h.b.ZO)
      {
        LiveData.this.b(this.aat);
        AppMethodBeat.o(241200);
        return;
      }
      an(shouldBeActive());
      AppMethodBeat.o(241200);
    }
    
    final boolean d(l paraml)
    {
      return this.aas == paraml;
    }
    
    final void detachObserver()
    {
      AppMethodBeat.i(241204);
      this.aas.getLifecycle().b(this);
      AppMethodBeat.o(241204);
    }
    
    final boolean shouldBeActive()
    {
      AppMethodBeat.i(241196);
      boolean bool = this.aas.getLifecycle().jc().a(h.b.ZR);
      AppMethodBeat.o(241196);
      return bool;
    }
  }
  
  final class a
    extends LiveData<T>.b
  {
    a()
    {
      super(locals);
    }
    
    final boolean shouldBeActive()
    {
      return true;
    }
  }
  
  abstract class b
  {
    final s<? super T> aat;
    int aau = -1;
    boolean mActive;
    
    b()
    {
      Object localObject;
      this.aat = localObject;
    }
    
    final void an(boolean paramBoolean)
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
      if (LiveData.this.aal == 0)
      {
        i = 1;
        localLiveData = LiveData.this;
        k = localLiveData.aal;
        if (!this.mActive) {
          break label120;
        }
      }
      for (;;)
      {
        localLiveData.aal = (j + k);
        if ((i != 0) && (this.mActive)) {
          LiveData.this.jb();
        }
        if ((LiveData.this.aal == 0) && (!this.mActive)) {
          LiveData.this.jh();
        }
        if (!this.mActive) {
          break;
        }
        LiveData.this.b(this);
        return;
        i = 0;
        break label28;
        label120:
        j = -1;
      }
    }
    
    boolean d(l paraml)
    {
      return false;
    }
    
    void detachObserver() {}
    
    abstract boolean shouldBeActive();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.lifecycle.LiveData
 * JD-Core Version:    0.7.0.1
 */