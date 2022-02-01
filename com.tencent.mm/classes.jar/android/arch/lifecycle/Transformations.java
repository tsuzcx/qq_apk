package android.arch.lifecycle;

import android.arch.a.c.a;

public class Transformations
{
  public static <X, Y> LiveData<Y> map(LiveData<X> paramLiveData, final a<X, Y> parama)
  {
    MediatorLiveData localMediatorLiveData = new MediatorLiveData();
    localMediatorLiveData.addSource(paramLiveData, new Observer()
    {
      public final void onChanged(X paramAnonymousX)
      {
        this.dt.setValue(parama.apply(paramAnonymousX));
      }
    });
    return localMediatorLiveData;
  }
  
  public static <X, Y> LiveData<Y> switchMap(LiveData<X> paramLiveData, a<X, LiveData<Y>> parama)
  {
    final MediatorLiveData localMediatorLiveData = new MediatorLiveData();
    localMediatorLiveData.addSource(paramLiveData, new Observer()
    {
      LiveData<Y> dv;
      
      public final void onChanged(X paramAnonymousX)
      {
        paramAnonymousX = (LiveData)this.du.apply(paramAnonymousX);
        if (this.dv == paramAnonymousX) {}
        do
        {
          return;
          if (this.dv != null) {
            localMediatorLiveData.removeSource(this.dv);
          }
          this.dv = paramAnonymousX;
        } while (this.dv == null);
        localMediatorLiveData.addSource(this.dv, new Observer()
        {
          public void onChanged(Y paramAnonymous2Y)
          {
            Transformations.2.this.dt.setValue(paramAnonymous2Y);
          }
        });
      }
    });
    return localMediatorLiveData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.arch.lifecycle.Transformations
 * JD-Core Version:    0.7.0.1
 */