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
import android.support.v4.e.e;
import android.support.v4.e.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class LoaderManagerImpl
  extends p
{
  static boolean DEBUG = false;
  private final LifecycleOwner EV;
  private final LoaderViewModel EW;
  
  LoaderManagerImpl(LifecycleOwner paramLifecycleOwner, ViewModelStore paramViewModelStore)
  {
    this.EV = paramLifecycleOwner;
    this.EW = LoaderViewModel.a(paramViewModelStore);
  }
  
  private <D> c<D> b(p.a<D> parama)
  {
    try
    {
      this.EW.Ff = true;
      localObject = parama.onCreateLoader(0, null);
      if (localObject == null) {
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
      }
    }
    finally
    {
      this.EW.Ff = false;
    }
    if ((localObject.getClass().isMemberClass()) && (!Modifier.isStatic(localObject.getClass().getModifiers()))) {
      throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: ".concat(String.valueOf(localObject)));
    }
    Object localObject = new a((c)localObject);
    if (DEBUG) {
      new StringBuilder("  Created new loader ").append(localObject);
    }
    this.EW.Fe.put(0, localObject);
    this.EW.Ff = false;
    return ((a)localObject).a(this.EV, parama);
  }
  
  public final <D> c<D> a(p.a<D> parama)
  {
    if (this.EW.Ff) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("initLoader must be called on the main thread");
    }
    a locala = (a)this.EW.Fe.get(0, null);
    if (DEBUG) {
      new StringBuilder("initLoader in ").append(this).append(": args=").append(null);
    }
    if (locala == null) {
      return b(parama);
    }
    if (DEBUG) {
      new StringBuilder("  Re-using existing loader ").append(locala);
    }
    return locala.a(this.EV, parama);
  }
  
  public final void dR()
  {
    LoaderViewModel localLoaderViewModel = this.EW;
    int j = localLoaderViewModel.Fe.size();
    int i = 0;
    while (i < j)
    {
      ((a)localLoaderViewModel.Fe.valueAt(i)).dR();
      i += 1;
    }
  }
  
  @Deprecated
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    LoaderViewModel localLoaderViewModel = this.EW;
    if (localLoaderViewModel.Fe.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loaders:");
      String str = paramString + "    ";
      int i = 0;
      while (i < localLoaderViewModel.Fe.size())
      {
        a locala = (a)localLoaderViewModel.Fe.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(localLoaderViewModel.Fe.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(locala.toString());
        paramPrintWriter.print(str);
        paramPrintWriter.print("mId=");
        paramPrintWriter.print(locala.mId);
        paramPrintWriter.print(" mArgs=");
        paramPrintWriter.println(locala.EX);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mLoader=");
        paramPrintWriter.println(locala.EY);
        locala.EY.dump(str + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        if (locala.EZ != null)
        {
          paramPrintWriter.print(str);
          paramPrintWriter.print("mCallbacks=");
          paramPrintWriter.println(locala.EZ);
          b localb = locala.EZ;
          paramPrintWriter.print(str + "  ");
          paramPrintWriter.print("mDeliveredData=");
          paramPrintWriter.println(localb.Fc);
        }
        paramPrintWriter.print(str);
        paramPrintWriter.print("mData=");
        paramPrintWriter.println(locala.EY.dataToString(locala.getValue()));
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
    e.a(this.EV, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  static class LoaderViewModel
    extends ViewModel
  {
    private static final ViewModelProvider.Factory Fd = new ViewModelProvider.Factory()
    {
      public final <T extends ViewModel> T create(Class<T> paramAnonymousClass)
      {
        return new LoaderManagerImpl.LoaderViewModel();
      }
    };
    o<LoaderManagerImpl.a> Fe = new o();
    boolean Ff = false;
    
    static LoaderViewModel a(ViewModelStore paramViewModelStore)
    {
      return (LoaderViewModel)new ViewModelProvider(paramViewModelStore, Fd).get(LoaderViewModel.class);
    }
    
    public final void ae()
    {
      super.ae();
      int j = this.Fe.size();
      int i = 0;
      while (i < j)
      {
        LoaderManagerImpl.a locala = (LoaderManagerImpl.a)this.Fe.valueAt(i);
        if (LoaderManagerImpl.DEBUG) {
          new StringBuilder("  Destroying: ").append(locala);
        }
        locala.EY.cancelLoad();
        locala.EY.abandon();
        LoaderManagerImpl.b localb = locala.EZ;
        if (localb != null)
        {
          locala.removeObserver(localb);
          if (localb.Fc)
          {
            if (LoaderManagerImpl.DEBUG) {
              new StringBuilder("  Resetting: ").append(localb.EY);
            }
            localb.Fb.onLoaderReset(localb.EY);
          }
        }
        locala.EY.unregisterListener(locala);
        locala.EY.reset();
        i += 1;
      }
      this.Fe.clear();
    }
  }
  
  public static final class a<D>
    extends MutableLiveData<D>
    implements c.b<D>
  {
    private LifecycleOwner EV;
    final Bundle EX = null;
    final c<D> EY;
    LoaderManagerImpl.b<D> EZ;
    c<D> Fa;
    final int mId = 0;
    
    a(c<D> paramc)
    {
      this.EY = paramc;
      this.Fa = null;
      this.EY.registerListener(0, this);
    }
    
    public final void V()
    {
      if (LoaderManagerImpl.DEBUG) {
        new StringBuilder("  Stopping: ").append(this);
      }
      this.EY.stopLoading();
    }
    
    final c<D> a(LifecycleOwner paramLifecycleOwner, p.a<D> parama)
    {
      parama = new LoaderManagerImpl.b(this.EY, parama);
      observe(paramLifecycleOwner, parama);
      if (this.EZ != null) {
        removeObserver(this.EZ);
      }
      this.EV = paramLifecycleOwner;
      this.EZ = parama;
      return this.EY;
    }
    
    final void dR()
    {
      LifecycleOwner localLifecycleOwner = this.EV;
      LoaderManagerImpl.b localb = this.EZ;
      if ((localLifecycleOwner != null) && (localb != null))
      {
        super.removeObserver(localb);
        observe(localLifecycleOwner, localb);
      }
    }
    
    public final void l(D paramD)
    {
      if (LoaderManagerImpl.DEBUG) {
        new StringBuilder("onLoadComplete: ").append(this);
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        setValue(paramD);
        return;
      }
      boolean bool = LoaderManagerImpl.DEBUG;
      postValue(paramD);
    }
    
    public final void onActive()
    {
      if (LoaderManagerImpl.DEBUG) {
        new StringBuilder("  Starting: ").append(this);
      }
      this.EY.startLoading();
    }
    
    public final void removeObserver(Observer<? super D> paramObserver)
    {
      super.removeObserver(paramObserver);
      this.EV = null;
      this.EZ = null;
    }
    
    public final void setValue(D paramD)
    {
      super.setValue(paramD);
      if (this.Fa != null)
      {
        this.Fa.reset();
        this.Fa = null;
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
      e.a(this.EY, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }
  
  static final class b<D>
    implements Observer<D>
  {
    final c<D> EY;
    final p.a<D> Fb;
    boolean Fc = false;
    
    b(c<D> paramc, p.a<D> parama)
    {
      this.EY = paramc;
      this.Fb = parama;
    }
    
    public final void onChanged(D paramD)
    {
      if (LoaderManagerImpl.DEBUG) {
        new StringBuilder("  onLoadFinished in ").append(this.EY).append(": ").append(this.EY.dataToString(paramD));
      }
      this.Fb.onLoadFinished(this.EY, paramD);
      this.Fc = true;
    }
    
    public final String toString()
    {
      return this.Fb.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl
 * JD-Core Version:    0.7.0.1
 */