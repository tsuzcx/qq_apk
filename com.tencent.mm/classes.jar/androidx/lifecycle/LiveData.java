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
  static final Object bHD = new Object();
  final Object bHC = new Object();
  public b<y<? super T>, LiveData<T>.b> bHE = new b();
  int bHF = 0;
  private boolean bHG;
  volatile Object bHH = bHD;
  int bHI;
  private boolean bHJ;
  private boolean bHK;
  private final Runnable bHL = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(194327);
      synchronized (LiveData.this.bHC)
      {
        Object localObject2 = LiveData.this.bHH;
        LiveData.this.bHH = LiveData.bHD;
        LiveData.this.setValue(localObject2);
        AppMethodBeat.o(194327);
        return;
      }
    }
  };
  private volatile Object mData;
  
  public LiveData()
  {
    this.mData = bHD;
    this.bHI = -1;
  }
  
  public LiveData(T paramT)
  {
    this.mData = paramT;
    this.bHI = 0;
  }
  
  private void a(LiveData<T>.b paramLiveData)
  {
    if (!paramLiveData.mActive) {}
    do
    {
      return;
      if (!paramLiveData.shouldBeActive())
      {
        paramLiveData.aW(false);
        return;
      }
    } while (paramLiveData.bHO >= this.bHI);
    paramLiveData.bHO = this.bHI;
    paramLiveData.mObserver.onChanged(this.mData);
  }
  
  private static void aM(String paramString)
  {
    if (!a.fG().yR.isMainThread()) {
      throw new IllegalStateException("Cannot invoke " + paramString + " on a background thread");
    }
  }
  
  protected void Hf() {}
  
  protected void Hk() {}
  
  public final boolean Hl()
  {
    return this.bHF > 0;
  }
  
  public final void a(q paramq, y<? super T> paramy)
  {
    aM("observe");
    if (paramq.getLifecycle().getCurrentState() == j.b.bHg) {}
    LifecycleBoundObserver localLifecycleBoundObserver;
    do
    {
      return;
      localLifecycleBoundObserver = new LifecycleBoundObserver(paramq, paramy);
      paramy = (b)this.bHE.putIfAbsent(paramy, localLifecycleBoundObserver);
      if ((paramy != null) && (!paramy.k(paramq))) {
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
      }
    } while (paramy != null);
    paramq.getLifecycle().addObserver(localLifecycleBoundObserver);
  }
  
  public final void a(y<? super T> paramy)
  {
    aM("observeForever");
    a locala = new a(paramy);
    paramy = (b)this.bHE.putIfAbsent(paramy, locala);
    if ((paramy instanceof LifecycleBoundObserver)) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (paramy != null) {
      return;
    }
    locala.aW(true);
  }
  
  final void b(LiveData<T>.b paramLiveData)
  {
    if (this.bHJ)
    {
      this.bHK = true;
      return;
    }
    this.bHJ = true;
    this.bHK = false;
    LiveData<T>.b localLiveData;
    if (paramLiveData != null)
    {
      a(paramLiveData);
      localLiveData = null;
    }
    for (;;)
    {
      paramLiveData = localLiveData;
      if (this.bHK) {
        break;
      }
      this.bHJ = false;
      return;
      b.d locald = this.bHE.fJ();
      do
      {
        localLiveData = paramLiveData;
        if (!locald.hasNext()) {
          break;
        }
        a((b)((Map.Entry)locald.next()).getValue());
      } while (!this.bHK);
      localLiveData = paramLiveData;
    }
  }
  
  public void b(y<? super T> paramy)
  {
    aM("removeObserver");
    paramy = (b)this.bHE.remove(paramy);
    if (paramy == null) {
      return;
    }
    paramy.detachObserver();
    paramy.aW(false);
  }
  
  final void fa(int paramInt)
  {
    int i = this.bHF;
    this.bHF += paramInt;
    if (this.bHG) {
      return;
    }
    this.bHG = true;
    paramInt = i;
    for (;;)
    {
      try
      {
        if (paramInt != this.bHF)
        {
          if ((paramInt == 0) && (this.bHF > 0))
          {
            i = 1;
            if ((paramInt <= 0) || (this.bHF != 0)) {
              break label116;
            }
            paramInt = 1;
            int j = this.bHF;
            if (i != 0)
            {
              Hf();
              paramInt = j;
              continue;
            }
            if (paramInt != 0) {
              Hk();
            }
            paramInt = j;
          }
        }
        else {
          return;
        }
      }
      finally
      {
        this.bHG = false;
      }
      i = 0;
      continue;
      label116:
      paramInt = 0;
    }
  }
  
  public T getValue()
  {
    Object localObject = this.mData;
    if (localObject != bHD) {
      return localObject;
    }
    return null;
  }
  
  public final void j(q paramq)
  {
    aM("removeObservers");
    Iterator localIterator = this.bHE.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((b)localEntry.getValue()).k(paramq)) {
        b((y)localEntry.getKey());
      }
    }
  }
  
  protected void setValue(T paramT)
  {
    aM("setValue");
    this.bHI += 1;
    this.mData = paramT;
    b(null);
  }
  
  protected void t(T paramT)
  {
    synchronized (this.bHC)
    {
      int i;
      if (this.bHH == bHD)
      {
        i = 1;
        this.bHH = paramT;
        if (i != 0) {}
      }
      else
      {
        i = 0;
      }
    }
    a.fG().postToMainThread(this.bHL);
  }
  
  class LifecycleBoundObserver
    extends LiveData<T>.b
    implements o
  {
    final q bHN;
    
    LifecycleBoundObserver(y<? super T> paramy)
    {
      super(localy);
      this.bHN = paramy;
    }
    
    final void detachObserver()
    {
      AppMethodBeat.i(194377);
      this.bHN.getLifecycle().removeObserver(this);
      AppMethodBeat.o(194377);
    }
    
    final boolean k(q paramq)
    {
      return this.bHN == paramq;
    }
    
    public void onStateChanged(q paramq, j.a parama)
    {
      AppMethodBeat.i(194359);
      paramq = this.bHN.getLifecycle().getCurrentState();
      if (paramq == j.b.bHg)
      {
        LiveData.this.b(this.mObserver);
        AppMethodBeat.o(194359);
        return;
      }
      parama = null;
      while (parama != paramq)
      {
        aW(shouldBeActive());
        j.b localb = this.bHN.getLifecycle().getCurrentState();
        parama = paramq;
        paramq = localb;
      }
      AppMethodBeat.o(194359);
    }
    
    final boolean shouldBeActive()
    {
      AppMethodBeat.i(194349);
      boolean bool = this.bHN.getLifecycle().getCurrentState().d(j.b.bHj);
      AppMethodBeat.o(194349);
      return bool;
    }
  }
  
  final class a
    extends LiveData<T>.b
  {
    a()
    {
      super(localy);
    }
    
    final boolean shouldBeActive()
    {
      return true;
    }
  }
  
  abstract class b
  {
    int bHO = -1;
    boolean mActive;
    final y<? super T> mObserver;
    
    b()
    {
      Object localObject;
      this.mObserver = localObject;
    }
    
    final void aW(boolean paramBoolean)
    {
      if (paramBoolean == this.mActive) {
        return;
      }
      this.mActive = paramBoolean;
      LiveData localLiveData = LiveData.this;
      if (this.mActive) {}
      for (int i = 1;; i = -1)
      {
        localLiveData.fa(i);
        if (!this.mActive) {
          break;
        }
        LiveData.this.b(this);
        return;
      }
    }
    
    void detachObserver() {}
    
    boolean k(q paramq)
    {
      return false;
    }
    
    abstract boolean shouldBeActive();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.LiveData
 * JD-Core Version:    0.7.0.1
 */