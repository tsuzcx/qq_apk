package android.arch.lifecycle;

import android.arch.a.a.a;
import android.arch.a.a.c;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ComputableLiveData<T>
{
  private final LiveData<T> ci;
  private AtomicBoolean cj = new AtomicBoolean(true);
  private AtomicBoolean ck = new AtomicBoolean(false);
  final Runnable cl = new Runnable()
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
  final Runnable cm = new Runnable()
  {
    public void run()
    {
      boolean bool = ComputableLiveData.d(ComputableLiveData.this).hasActiveObservers();
      if ((ComputableLiveData.c(ComputableLiveData.this).compareAndSet(false, true)) && (bool)) {
        ComputableLiveData.a(ComputableLiveData.this).execute(ComputableLiveData.this.cl);
      }
    }
  };
  private final Executor mExecutor;
  
  public ComputableLiveData()
  {
    this(a.U());
  }
  
  public ComputableLiveData(Executor paramExecutor)
  {
    this.mExecutor = paramExecutor;
    this.ci = new LiveData()
    {
      protected final void onActive()
      {
        ComputableLiveData.a(ComputableLiveData.this).execute(ComputableLiveData.this.cl);
      }
    };
  }
  
  protected abstract T compute();
  
  public LiveData<T> getLiveData()
  {
    return this.ci;
  }
  
  public void invalidate()
  {
    a locala = a.S();
    Runnable localRunnable = this.cm;
    if (locala.isMainThread())
    {
      localRunnable.run();
      return;
    }
    locala.postToMainThread(localRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.arch.lifecycle.ComputableLiveData
 * JD-Core Version:    0.7.0.1
 */