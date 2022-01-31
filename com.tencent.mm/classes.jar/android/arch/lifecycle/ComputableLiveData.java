package android.arch.lifecycle;

import android.arch.a.a.a;
import android.arch.a.a.c;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ComputableLiveData<T>
{
  private final LiveData<T> cf;
  private AtomicBoolean cg = new AtomicBoolean(true);
  private AtomicBoolean ch = new AtomicBoolean(false);
  final Runnable ci = new Runnable()
  {
    public void run()
    {
      Object localObject1;
      if (ComputableLiveData.b(ComputableLiveData.this).compareAndSet(false, true)) {
        localObject1 = null;
      }
      for (int i = 0;; i = 0) {
        try
        {
          while (ComputableLiveData.c(ComputableLiveData.this).compareAndSet(true, false))
          {
            localObject1 = ComputableLiveData.this.compute();
            i = 1;
          }
          if (i != 0) {
            ComputableLiveData.d(ComputableLiveData.this).postValue(localObject1);
          }
          ComputableLiveData.b(ComputableLiveData.this).set(false);
          if ((i != 0) && (ComputableLiveData.c(ComputableLiveData.this).get())) {
            break;
          }
          return;
        }
        finally
        {
          ComputableLiveData.b(ComputableLiveData.this).set(false);
        }
      }
    }
  };
  final Runnable cj = new Runnable()
  {
    public void run()
    {
      boolean bool = ComputableLiveData.d(ComputableLiveData.this).hasActiveObservers();
      if ((ComputableLiveData.c(ComputableLiveData.this).compareAndSet(false, true)) && (bool)) {
        ComputableLiveData.a(ComputableLiveData.this).execute(ComputableLiveData.this.ci);
      }
    }
  };
  private final Executor mExecutor;
  
  public ComputableLiveData()
  {
    this(a.ad());
  }
  
  public ComputableLiveData(Executor paramExecutor)
  {
    this.mExecutor = paramExecutor;
    this.cf = new LiveData()
    {
      protected final void onActive()
      {
        ComputableLiveData.a(ComputableLiveData.this).execute(ComputableLiveData.this.ci);
      }
    };
  }
  
  protected abstract T compute();
  
  public LiveData<T> getLiveData()
  {
    return this.cf;
  }
  
  public void invalidate()
  {
    a locala = a.aa();
    Runnable localRunnable = this.cj;
    if (locala.isMainThread())
    {
      localRunnable.run();
      return;
    }
    locala.d(localRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.ComputableLiveData
 * JD-Core Version:    0.7.0.1
 */