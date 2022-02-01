package android.arch.lifecycle;

import android.arch.a.b.b;
import java.util.Iterator;
import java.util.Map.Entry;

public class MediatorLiveData<T>
  extends MutableLiveData<T>
{
  private b<LiveData<?>, Source<?>> cZ = new b();
  
  protected final void Z()
  {
    Iterator localIterator = this.cZ.iterator();
    while (localIterator.hasNext()) {
      ((Source)((Map.Entry)localIterator.next()).getValue()).am();
    }
  }
  
  public <S> void addSource(LiveData<S> paramLiveData, Observer<S> paramObserver)
  {
    Source localSource = new Source(paramLiveData, paramObserver);
    paramLiveData = (Source)this.cZ.putIfAbsent(paramLiveData, localSource);
    if ((paramLiveData != null) && (paramLiveData.cX != paramObserver)) {
      throw new IllegalArgumentException("This source was already added with the different observer");
    }
    if (paramLiveData != null) {}
    while (!hasActiveObservers()) {
      return;
    }
    localSource.af();
  }
  
  protected final void onActive()
  {
    Iterator localIterator = this.cZ.iterator();
    while (localIterator.hasNext()) {
      ((Source)((Map.Entry)localIterator.next()).getValue()).af();
    }
  }
  
  public <S> void removeSource(LiveData<S> paramLiveData)
  {
    paramLiveData = (Source)this.cZ.remove(paramLiveData);
    if (paramLiveData != null) {
      paramLiveData.am();
    }
  }
  
  static class Source<V>
    implements Observer<V>
  {
    int cR = -1;
    final Observer<V> cX;
    final LiveData<V> ci;
    
    Source(LiveData<V> paramLiveData, Observer<V> paramObserver)
    {
      this.ci = paramLiveData;
      this.cX = paramObserver;
    }
    
    final void af()
    {
      this.ci.observeForever(this);
    }
    
    final void am()
    {
      this.ci.removeObserver(this);
    }
    
    public void onChanged(V paramV)
    {
      if (this.cR != this.ci.cR)
      {
        this.cR = this.ci.cR;
        this.cX.onChanged(paramV);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.arch.lifecycle.MediatorLiveData
 * JD-Core Version:    0.7.0.1
 */