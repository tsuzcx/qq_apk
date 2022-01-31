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
        this.dq.setValue(parama.apply(paramAnonymousX));
      }
    });
    return localMediatorLiveData;
  }
  
  public static <X, Y> LiveData<Y> switchMap(LiveData<X> paramLiveData, a<X, LiveData<Y>> parama)
  {
    final MediatorLiveData localMediatorLiveData = new MediatorLiveData();
    localMediatorLiveData.addSource(paramLiveData, new Observer()
    {
      LiveData<Y> ds;
      
      public final void onChanged(X paramAnonymousX)
      {
        paramAnonymousX = (LiveData)this.dr.apply(paramAnonymousX);
        if (this.ds == paramAnonymousX) {}
        do
        {
          return;
          if (this.ds != null) {
            localMediatorLiveData.removeSource(this.ds);
          }
          this.ds = paramAnonymousX;
        } while (this.ds == null);
        localMediatorLiveData.addSource(this.ds, new Observer()
        {
          public void onChanged(Y paramAnonymous2Y)
          {
            Transformations.2.this.dq.setValue(paramAnonymous2Y);
          }
        });
      }
    });
    return localMediatorLiveData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.Transformations
 * JD-Core Version:    0.7.0.1
 */