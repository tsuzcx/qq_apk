package android.arch.lifecycle;

import android.arch.a.b.b;
import java.util.Iterator;
import java.util.Map.Entry;

public class MediatorLiveData<T>
  extends MutableLiveData<T>
{
  private b<LiveData<?>, Source<?>> cW = new b();
  
  public <S> void addSource(LiveData<S> paramLiveData, Observer<S> paramObserver)
  {
    Source localSource = new Source(paramLiveData, paramObserver);
    paramLiveData = (Source)this.cW.putIfAbsent(paramLiveData, localSource);
    if ((paramLiveData != null) && (paramLiveData.cU != paramObserver)) {
      throw new IllegalArgumentException("This source was already added with the different observer");
    }
    if (paramLiveData != null) {}
    while (!hasActiveObservers()) {
      return;
    }
    localSource.ar();
  }
  
  protected final void an()
  {
    Iterator localIterator = this.cW.iterator();
    while (localIterator.hasNext()) {
      ((Source)((Map.Entry)localIterator.next()).getValue()).as();
    }
  }
  
  protected final void onActive()
  {
    Iterator localIterator = this.cW.iterator();
    while (localIterator.hasNext()) {
      ((Source)((Map.Entry)localIterator.next()).getValue()).ar();
    }
  }
  
  public <S> void removeSource(LiveData<S> paramLiveData)
  {
    paramLiveData = (Source)this.cW.remove(paramLiveData);
    if (paramLiveData != null) {
      paramLiveData.as();
    }
  }
  
  static class Source<V>
    implements Observer<V>
  {
    int cO = -1;
    final Observer<V> cU;
    final LiveData<V> cf;
    
    Source(LiveData<V> paramLiveData, Observer<V> paramObserver)
    {
      this.cf = paramLiveData;
      this.cU = paramObserver;
    }
    
    final void ar()
    {
      this.cf.observeForever(this);
    }
    
    final void as()
    {
      this.cf.removeObserver(this);
    }
    
    public void onChanged(V paramV)
    {
      if (this.cO != this.cf.cO)
      {
        this.cO = this.cf.cO;
        this.cU.onChanged(paramV);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.MediatorLiveData
 * JD-Core Version:    0.7.0.1
 */