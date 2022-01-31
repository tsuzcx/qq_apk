package android.support.v4.app;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.ViewModelStore;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.content.c;
import android.support.v4.content.c.b;
import android.support.v4.f.d;
import android.support.v4.f.n;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class u
  extends t
{
  static boolean DEBUG = false;
  private final LifecycleOwner xh;
  final c xi;
  private boolean xj;
  
  u(LifecycleOwner paramLifecycleOwner, ViewModelStore paramViewModelStore)
  {
    this.xh = paramLifecycleOwner;
    this.xi = c.a(paramViewModelStore);
  }
  
  private <D> c<D> b(t.a<D> parama)
  {
    try
    {
      this.xj = true;
      localObject = parama.onCreateLoader(0, null);
      if ((localObject.getClass().isMemberClass()) && (!Modifier.isStatic(localObject.getClass().getModifiers()))) {
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + localObject);
      }
    }
    finally
    {
      this.xj = false;
    }
    Object localObject = new a((c)localObject);
    if (DEBUG) {
      new StringBuilder("  Created new loader ").append(localObject);
    }
    this.xi.xr.put(0, localObject);
    this.xj = false;
    return ((a)localObject).a(this.xh, parama);
  }
  
  public final <D> c<D> a(t.a<D> parama)
  {
    if (this.xj) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("initLoader must be called on the main thread");
    }
    a locala = (a)this.xi.xr.get(0);
    if (DEBUG) {
      new StringBuilder("initLoader in ").append(this).append(": args=").append(null);
    }
    if (locala == null) {
      return b(parama);
    }
    if (DEBUG) {
      new StringBuilder("  Re-using existing loader ").append(locala);
    }
    return locala.a(this.xh, parama);
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    c localc = this.xi;
    if (localc.xr.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loaders:");
      String str = paramString + "    ";
      int i = 0;
      while (i < localc.xr.size())
      {
        a locala = (a)localc.xr.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(localc.xr.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(locala.toString());
        paramPrintWriter.print(str);
        paramPrintWriter.print("mId=");
        paramPrintWriter.print(locala.mId);
        paramPrintWriter.print(" mArgs=");
        paramPrintWriter.println(locala.xk);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mLoader=");
        paramPrintWriter.println(locala.xl);
        locala.xl.dump(str + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        if (locala.xm != null)
        {
          paramPrintWriter.print(str);
          paramPrintWriter.print("mCallbacks=");
          paramPrintWriter.println(locala.xm);
          b localb = locala.xm;
          paramPrintWriter.print(str + "  ");
          paramPrintWriter.print("mDeliveredData=");
          paramPrintWriter.println(localb.xp);
        }
        paramPrintWriter.print(str);
        paramPrintWriter.print("mData=");
        paramPrintWriter.println(locala.xl.dataToString(locala.getValue()));
        paramPrintWriter.print(str);
        paramPrintWriter.print("mStarted=");
        paramPrintWriter.println(locala.hasActiveObservers());
        i += 1;
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    d.a(this.xh, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  public static final class a<D>
    extends MutableLiveData<D>
    implements c.b<D>
  {
    final int mId = 0;
    private LifecycleOwner xh;
    final Bundle xk = null;
    final c<D> xl;
    u.b<D> xm;
    c<D> xn;
    
    a(c<D> paramc)
    {
      this.xl = paramc;
      this.xn = null;
      this.xl.registerListener(0, this);
    }
    
    final c<D> a(LifecycleOwner paramLifecycleOwner, t.a<D> parama)
    {
      parama = new u.b(this.xl, parama);
      observe(paramLifecycleOwner, parama);
      if (this.xm != null) {
        removeObserver(this.xm);
      }
      this.xh = paramLifecycleOwner;
      this.xm = parama;
      return this.xl;
    }
    
    final void cf()
    {
      LifecycleOwner localLifecycleOwner = this.xh;
      u.b localb = this.xm;
      if ((localLifecycleOwner != null) && (localb != null))
      {
        super.removeObserver(localb);
        observe(localLifecycleOwner, localb);
      }
    }
    
    public final void k(D paramD)
    {
      if (u.DEBUG) {
        new StringBuilder("onLoadComplete: ").append(this);
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        setValue(paramD);
        return;
      }
      postValue(paramD);
    }
    
    protected final void onActive()
    {
      if (u.DEBUG) {
        new StringBuilder("  Starting: ").append(this);
      }
      this.xl.startLoading();
    }
    
    protected final void onInactive()
    {
      if (u.DEBUG) {
        new StringBuilder("  Stopping: ").append(this);
      }
      this.xl.stopLoading();
    }
    
    public final void removeObserver(Observer<D> paramObserver)
    {
      super.removeObserver(paramObserver);
      this.xh = null;
      this.xm = null;
    }
    
    public final void setValue(D paramD)
    {
      super.setValue(paramD);
      if (this.xn != null)
      {
        this.xn.reset();
        this.xn = null;
      }
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append("LoaderInfo{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" #");
      localStringBuilder.append(this.mId);
      localStringBuilder.append(" : ");
      d.a(this.xl, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }
  
  static final class b<D>
    implements Observer<D>
  {
    final c<D> xl;
    final t.a<D> xo;
    boolean xp = false;
    
    b(c<D> paramc, t.a<D> parama)
    {
      this.xl = paramc;
      this.xo = parama;
    }
    
    public final void onChanged(D paramD)
    {
      if (u.DEBUG) {
        new StringBuilder("  onLoadFinished in ").append(this.xl).append(": ").append(this.xl.dataToString(paramD));
      }
      this.xo.onLoadFinished(this.xl, paramD);
      this.xp = true;
    }
    
    public final String toString()
    {
      return this.xo.toString();
    }
  }
  
  static class c
    extends ViewModel
  {
    private static final ViewModelProvider.Factory xq = new ViewModelProvider.Factory()
    {
      public final <T extends ViewModel> T create(Class<T> paramAnonymousClass)
      {
        return new u.c();
      }
    };
    n<u.a> xr = new n();
    
    static c a(ViewModelStore paramViewModelStore)
    {
      return (c)new ViewModelProvider(paramViewModelStore, xq).get(c.class);
    }
    
    final void cf()
    {
      int j = this.xr.size();
      int i = 0;
      while (i < j)
      {
        ((u.a)this.xr.valueAt(i)).cf();
        i += 1;
      }
    }
    
    protected final void onCleared()
    {
      super.onCleared();
      int j = this.xr.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (u.a)this.xr.valueAt(i);
        if (u.DEBUG) {
          new StringBuilder("  Destroying: ").append(localObject);
        }
        ((u.a)localObject).xl.cancelLoad();
        ((u.a)localObject).xl.abandon();
        u.b localb = ((u.a)localObject).xm;
        if (localb != null)
        {
          ((u.a)localObject).removeObserver(localb);
          if (localb.xp)
          {
            if (u.DEBUG) {
              new StringBuilder("  Resetting: ").append(localb.xl);
            }
            localb.xo.onLoaderReset(localb.xl);
          }
        }
        ((u.a)localObject).xl.unregisterListener((c.b)localObject);
        ((u.a)localObject).xl.reset();
        localObject = ((u.a)localObject).xn;
        i += 1;
      }
      this.xr.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.u
 * JD-Core Version:    0.7.0.1
 */