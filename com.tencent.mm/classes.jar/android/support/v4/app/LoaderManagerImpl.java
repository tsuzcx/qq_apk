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
  private final LifecycleOwner DX;
  private final LoaderViewModel DY;
  
  LoaderManagerImpl(LifecycleOwner paramLifecycleOwner, ViewModelStore paramViewModelStore)
  {
    this.DX = paramLifecycleOwner;
    this.DY = LoaderViewModel.a(paramViewModelStore);
  }
  
  private <D> c<D> b(p.a<D> parama)
  {
    try
    {
      this.DY.Eh = true;
      localObject = parama.onCreateLoader(0, null);
      if (localObject == null) {
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
      }
    }
    finally
    {
      this.DY.Eh = false;
    }
    if ((localObject.getClass().isMemberClass()) && (!Modifier.isStatic(localObject.getClass().getModifiers()))) {
      throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: ".concat(String.valueOf(localObject)));
    }
    Object localObject = new a((c)localObject);
    if (DEBUG) {
      new StringBuilder("  Created new loader ").append(localObject);
    }
    this.DY.Eg.put(0, localObject);
    this.DY.Eh = false;
    return ((a)localObject).a(this.DX, parama);
  }
  
  public final <D> c<D> a(p.a<D> parama)
  {
    if (this.DY.Eh) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("initLoader must be called on the main thread");
    }
    a locala = (a)this.DY.Eg.get(0, null);
    if (DEBUG) {
      new StringBuilder("initLoader in ").append(this).append(": args=").append(null);
    }
    if (locala == null) {
      return b(parama);
    }
    if (DEBUG) {
      new StringBuilder("  Re-using existing loader ").append(locala);
    }
    return locala.a(this.DX, parama);
  }
  
  public final void dK()
  {
    LoaderViewModel localLoaderViewModel = this.DY;
    int j = localLoaderViewModel.Eg.size();
    int i = 0;
    while (i < j)
    {
      ((a)localLoaderViewModel.Eg.valueAt(i)).dK();
      i += 1;
    }
  }
  
  @Deprecated
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    LoaderViewModel localLoaderViewModel = this.DY;
    if (localLoaderViewModel.Eg.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loaders:");
      String str = paramString + "    ";
      int i = 0;
      while (i < localLoaderViewModel.Eg.size())
      {
        a locala = (a)localLoaderViewModel.Eg.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(localLoaderViewModel.Eg.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(locala.toString());
        paramPrintWriter.print(str);
        paramPrintWriter.print("mId=");
        paramPrintWriter.print(locala.mId);
        paramPrintWriter.print(" mArgs=");
        paramPrintWriter.println(locala.DZ);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mLoader=");
        paramPrintWriter.println(locala.Ea);
        locala.Ea.dump(str + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        if (locala.Eb != null)
        {
          paramPrintWriter.print(str);
          paramPrintWriter.print("mCallbacks=");
          paramPrintWriter.println(locala.Eb);
          b localb = locala.Eb;
          paramPrintWriter.print(str + "  ");
          paramPrintWriter.print("mDeliveredData=");
          paramPrintWriter.println(localb.Ee);
        }
        paramPrintWriter.print(str);
        paramPrintWriter.print("mData=");
        paramPrintWriter.println(locala.Ea.dataToString(locala.getValue()));
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
    e.a(this.DX, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  static class LoaderViewModel
    extends ViewModel
  {
    private static final ViewModelProvider.Factory Ef = new ViewModelProvider.Factory()
    {
      public final <T extends ViewModel> T create(Class<T> paramAnonymousClass)
      {
        return new LoaderManagerImpl.LoaderViewModel();
      }
    };
    o<LoaderManagerImpl.a> Eg = new o();
    boolean Eh = false;
    
    static LoaderViewModel a(ViewModelStore paramViewModelStore)
    {
      return (LoaderViewModel)new ViewModelProvider(paramViewModelStore, Ef).get(LoaderViewModel.class);
    }
    
    public final void ae()
    {
      super.ae();
      int j = this.Eg.size();
      int i = 0;
      while (i < j)
      {
        LoaderManagerImpl.a locala = (LoaderManagerImpl.a)this.Eg.valueAt(i);
        if (LoaderManagerImpl.DEBUG) {
          new StringBuilder("  Destroying: ").append(locala);
        }
        locala.Ea.cancelLoad();
        locala.Ea.abandon();
        LoaderManagerImpl.b localb = locala.Eb;
        if (localb != null)
        {
          locala.removeObserver(localb);
          if (localb.Ee)
          {
            if (LoaderManagerImpl.DEBUG) {
              new StringBuilder("  Resetting: ").append(localb.Ea);
            }
            localb.Ed.onLoaderReset(localb.Ea);
          }
        }
        locala.Ea.unregisterListener(locala);
        locala.Ea.reset();
        i += 1;
      }
      this.Eg.clear();
    }
  }
  
  public static final class a<D>
    extends MutableLiveData<D>
    implements c.b<D>
  {
    private LifecycleOwner DX;
    final Bundle DZ = null;
    final c<D> Ea;
    LoaderManagerImpl.b<D> Eb;
    c<D> Ec;
    final int mId = 0;
    
    a(c<D> paramc)
    {
      this.Ea = paramc;
      this.Ec = null;
      this.Ea.registerListener(0, this);
    }
    
    public final void V()
    {
      if (LoaderManagerImpl.DEBUG) {
        new StringBuilder("  Stopping: ").append(this);
      }
      this.Ea.stopLoading();
    }
    
    final c<D> a(LifecycleOwner paramLifecycleOwner, p.a<D> parama)
    {
      parama = new LoaderManagerImpl.b(this.Ea, parama);
      observe(paramLifecycleOwner, parama);
      if (this.Eb != null) {
        removeObserver(this.Eb);
      }
      this.DX = paramLifecycleOwner;
      this.Eb = parama;
      return this.Ea;
    }
    
    final void dK()
    {
      LifecycleOwner localLifecycleOwner = this.DX;
      LoaderManagerImpl.b localb = this.Eb;
      if ((localLifecycleOwner != null) && (localb != null))
      {
        super.removeObserver(localb);
        observe(localLifecycleOwner, localb);
      }
    }
    
    public final void j(D paramD)
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
      this.Ea.startLoading();
    }
    
    public final void removeObserver(Observer<? super D> paramObserver)
    {
      super.removeObserver(paramObserver);
      this.DX = null;
      this.Eb = null;
    }
    
    public final void setValue(D paramD)
    {
      super.setValue(paramD);
      if (this.Ec != null)
      {
        this.Ec.reset();
        this.Ec = null;
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
      e.a(this.Ea, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }
  
  static final class b<D>
    implements Observer<D>
  {
    final c<D> Ea;
    final p.a<D> Ed;
    boolean Ee = false;
    
    b(c<D> paramc, p.a<D> parama)
    {
      this.Ea = paramc;
      this.Ed = parama;
    }
    
    public final void onChanged(D paramD)
    {
      if (LoaderManagerImpl.DEBUG) {
        new StringBuilder("  onLoadFinished in ").append(this.Ea).append(": ").append(this.Ea.dataToString(paramD));
      }
      this.Ed.onLoadFinished(this.Ea, paramD);
      this.Ee = true;
    }
    
    public final String toString()
    {
      return this.Ed.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl
 * JD-Core Version:    0.7.0.1
 */