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
  private final LifecycleOwner GW;
  private final LoaderViewModel GX;
  
  LoaderManagerImpl(LifecycleOwner paramLifecycleOwner, ViewModelStore paramViewModelStore)
  {
    this.GW = paramLifecycleOwner;
    this.GX = LoaderViewModel.a(paramViewModelStore);
  }
  
  private <D> c<D> b(p.a<D> parama)
  {
    try
    {
      this.GX.Hg = true;
      localObject = parama.onCreateLoader(0, null);
      if (localObject == null) {
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
      }
    }
    finally
    {
      this.GX.Hg = false;
    }
    if ((localObject.getClass().isMemberClass()) && (!Modifier.isStatic(localObject.getClass().getModifiers()))) {
      throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: ".concat(String.valueOf(localObject)));
    }
    Object localObject = new a(0, null, (c)localObject);
    if (DEBUG) {
      new StringBuilder("  Created new loader ").append(localObject);
    }
    this.GX.Hf.put(0, localObject);
    this.GX.Hg = false;
    return ((a)localObject).a(this.GW, parama);
  }
  
  public final <D> c<D> a(p.a<D> parama)
  {
    if (this.GX.Hg) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("initLoader must be called on the main thread");
    }
    a locala = (a)this.GX.Hf.get(0, null);
    if (DEBUG) {
      new StringBuilder("initLoader in ").append(this).append(": args=").append(null);
    }
    if (locala == null) {
      return b(parama);
    }
    if (DEBUG) {
      new StringBuilder("  Re-using existing loader ").append(locala);
    }
    return locala.a(this.GW, parama);
  }
  
  @Deprecated
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    LoaderViewModel localLoaderViewModel = this.GX;
    if (localLoaderViewModel.Hf.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loaders:");
      String str = paramString + "    ";
      int i = 0;
      while (i < localLoaderViewModel.Hf.size())
      {
        a locala = (a)localLoaderViewModel.Hf.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(localLoaderViewModel.Hf.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(locala.toString());
        paramPrintWriter.print(str);
        paramPrintWriter.print("mId=");
        paramPrintWriter.print(locala.mId);
        paramPrintWriter.print(" mArgs=");
        paramPrintWriter.println(locala.GY);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mLoader=");
        paramPrintWriter.println(locala.GZ);
        locala.GZ.dump(str + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        if (locala.Ha != null)
        {
          paramPrintWriter.print(str);
          paramPrintWriter.print("mCallbacks=");
          paramPrintWriter.println(locala.Ha);
          b localb = locala.Ha;
          paramPrintWriter.print(str + "  ");
          paramPrintWriter.print("mDeliveredData=");
          paramPrintWriter.println(localb.Hd);
        }
        paramPrintWriter.print(str);
        paramPrintWriter.print("mData=");
        paramPrintWriter.println(locala.GZ.dataToString(locala.getValue()));
        paramPrintWriter.print(str);
        paramPrintWriter.print("mStarted=");
        paramPrintWriter.println(locala.hasActiveObservers());
        i += 1;
      }
    }
  }
  
  public final void eq()
  {
    LoaderViewModel localLoaderViewModel = this.GX;
    int j = localLoaderViewModel.Hf.size();
    int i = 0;
    while (i < j)
    {
      ((a)localLoaderViewModel.Hf.valueAt(i)).eq();
      i += 1;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    e.a(this.GW, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  static class LoaderViewModel
    extends ViewModel
  {
    private static final ViewModelProvider.Factory He = new ViewModelProvider.Factory()
    {
      public final <T extends ViewModel> T create(Class<T> paramAnonymousClass)
      {
        return new LoaderManagerImpl.LoaderViewModel();
      }
    };
    o<LoaderManagerImpl.a> Hf = new o();
    boolean Hg = false;
    
    static LoaderViewModel a(ViewModelStore paramViewModelStore)
    {
      return (LoaderViewModel)new ViewModelProvider(paramViewModelStore, He).get(LoaderViewModel.class);
    }
    
    public void onCleared()
    {
      super.onCleared();
      int j = this.Hf.size();
      int i = 0;
      while (i < j)
      {
        LoaderManagerImpl.a locala = (LoaderManagerImpl.a)this.Hf.valueAt(i);
        if (LoaderManagerImpl.DEBUG) {
          new StringBuilder("  Destroying: ").append(locala);
        }
        locala.GZ.cancelLoad();
        locala.GZ.abandon();
        LoaderManagerImpl.b localb = locala.Ha;
        if (localb != null)
        {
          locala.removeObserver(localb);
          if (localb.Hd)
          {
            if (LoaderManagerImpl.DEBUG) {
              new StringBuilder("  Resetting: ").append(localb.GZ);
            }
            localb.Hc.onLoaderReset(localb.GZ);
          }
        }
        locala.GZ.unregisterListener(locala);
        locala.GZ.reset();
        i += 1;
      }
      this.Hf.clear();
    }
  }
  
  public static final class a<D>
    extends MutableLiveData<D>
    implements c.b<D>
  {
    private LifecycleOwner GW;
    final Bundle GY = null;
    final c<D> GZ;
    LoaderManagerImpl.b<D> Ha;
    c<D> Hb;
    final int mId = 0;
    
    a(int paramInt, Bundle paramBundle, c<D> paramc)
    {
      this.GZ = paramc;
      this.Hb = null;
      this.GZ.registerListener(0, this);
    }
    
    public final void Z()
    {
      if (LoaderManagerImpl.DEBUG) {
        new StringBuilder("  Stopping: ").append(this);
      }
      this.GZ.stopLoading();
    }
    
    final c<D> a(LifecycleOwner paramLifecycleOwner, p.a<D> parama)
    {
      parama = new LoaderManagerImpl.b(this.GZ, parama);
      observe(paramLifecycleOwner, parama);
      if (this.Ha != null) {
        removeObserver(this.Ha);
      }
      this.GW = paramLifecycleOwner;
      this.Ha = parama;
      return this.GZ;
    }
    
    final void eq()
    {
      LifecycleOwner localLifecycleOwner = this.GW;
      LoaderManagerImpl.b localb = this.Ha;
      if ((localLifecycleOwner != null) && (localb != null))
      {
        super.removeObserver(localb);
        observe(localLifecycleOwner, localb);
      }
    }
    
    public final void m(D paramD)
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
      this.GZ.startLoading();
    }
    
    public final void removeObserver(Observer<? super D> paramObserver)
    {
      super.removeObserver(paramObserver);
      this.GW = null;
      this.Ha = null;
    }
    
    public final void setValue(D paramD)
    {
      super.setValue(paramD);
      if (this.Hb != null)
      {
        this.Hb.reset();
        this.Hb = null;
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
      e.a(this.GZ, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }
  
  static final class b<D>
    implements Observer<D>
  {
    final c<D> GZ;
    final p.a<D> Hc;
    boolean Hd = false;
    
    b(c<D> paramc, p.a<D> parama)
    {
      this.GZ = paramc;
      this.Hc = parama;
    }
    
    public final void onChanged(D paramD)
    {
      if (LoaderManagerImpl.DEBUG) {
        new StringBuilder("  onLoadFinished in ").append(this.GZ).append(": ").append(this.GZ.dataToString(paramD));
      }
      this.Hc.onLoadFinished(this.GZ, paramD);
      this.Hd = true;
    }
    
    public final String toString()
    {
      return this.Hc.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl
 * JD-Core Version:    0.7.0.1
 */