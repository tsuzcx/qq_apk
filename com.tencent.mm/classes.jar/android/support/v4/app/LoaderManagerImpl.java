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
  private final LifecycleOwner GM;
  private final LoaderViewModel GN;
  
  LoaderManagerImpl(LifecycleOwner paramLifecycleOwner, ViewModelStore paramViewModelStore)
  {
    this.GM = paramLifecycleOwner;
    this.GN = LoaderViewModel.a(paramViewModelStore);
  }
  
  private <D> c<D> b(p.a<D> parama)
  {
    try
    {
      this.GN.GW = true;
      localObject = parama.onCreateLoader(0, null);
      if (localObject == null) {
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
      }
    }
    finally
    {
      this.GN.GW = false;
    }
    if ((localObject.getClass().isMemberClass()) && (!Modifier.isStatic(localObject.getClass().getModifiers()))) {
      throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: ".concat(String.valueOf(localObject)));
    }
    Object localObject = new a((c)localObject);
    if (DEBUG) {
      new StringBuilder("  Created new loader ").append(localObject);
    }
    this.GN.GV.put(0, localObject);
    this.GN.GW = false;
    return ((a)localObject).a(this.GM, parama);
  }
  
  public final <D> c<D> a(p.a<D> parama)
  {
    if (this.GN.GW) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("initLoader must be called on the main thread");
    }
    a locala = (a)this.GN.GV.get(0, null);
    if (DEBUG) {
      new StringBuilder("initLoader in ").append(this).append(": args=").append(null);
    }
    if (locala == null) {
      return b(parama);
    }
    if (DEBUG) {
      new StringBuilder("  Re-using existing loader ").append(locala);
    }
    return locala.a(this.GM, parama);
  }
  
  @Deprecated
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    LoaderViewModel localLoaderViewModel = this.GN;
    if (localLoaderViewModel.GV.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loaders:");
      String str = paramString + "    ";
      int i = 0;
      while (i < localLoaderViewModel.GV.size())
      {
        a locala = (a)localLoaderViewModel.GV.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(localLoaderViewModel.GV.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(locala.toString());
        paramPrintWriter.print(str);
        paramPrintWriter.print("mId=");
        paramPrintWriter.print(locala.mId);
        paramPrintWriter.print(" mArgs=");
        paramPrintWriter.println(locala.GO);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mLoader=");
        paramPrintWriter.println(locala.GP);
        locala.GP.dump(str + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        if (locala.GQ != null)
        {
          paramPrintWriter.print(str);
          paramPrintWriter.print("mCallbacks=");
          paramPrintWriter.println(locala.GQ);
          b localb = locala.GQ;
          paramPrintWriter.print(str + "  ");
          paramPrintWriter.print("mDeliveredData=");
          paramPrintWriter.println(localb.GT);
        }
        paramPrintWriter.print(str);
        paramPrintWriter.print("mData=");
        paramPrintWriter.println(locala.GP.dataToString(locala.getValue()));
        paramPrintWriter.print(str);
        paramPrintWriter.print("mStarted=");
        paramPrintWriter.println(locala.hasActiveObservers());
        i += 1;
      }
    }
  }
  
  public final void em()
  {
    LoaderViewModel localLoaderViewModel = this.GN;
    int j = localLoaderViewModel.GV.size();
    int i = 0;
    while (i < j)
    {
      ((a)localLoaderViewModel.GV.valueAt(i)).em();
      i += 1;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    e.a(this.GM, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  static class LoaderViewModel
    extends ViewModel
  {
    private static final ViewModelProvider.Factory GU = new ViewModelProvider.Factory()
    {
      public final <T extends ViewModel> T create(Class<T> paramAnonymousClass)
      {
        return new LoaderManagerImpl.LoaderViewModel();
      }
    };
    o<LoaderManagerImpl.a> GV = new o();
    boolean GW = false;
    
    static LoaderViewModel a(ViewModelStore paramViewModelStore)
    {
      return (LoaderViewModel)new ViewModelProvider(paramViewModelStore, GU).get(LoaderViewModel.class);
    }
    
    public final void af()
    {
      super.af();
      int j = this.GV.size();
      int i = 0;
      while (i < j)
      {
        LoaderManagerImpl.a locala = (LoaderManagerImpl.a)this.GV.valueAt(i);
        if (LoaderManagerImpl.DEBUG) {
          new StringBuilder("  Destroying: ").append(locala);
        }
        locala.GP.cancelLoad();
        locala.GP.abandon();
        LoaderManagerImpl.b localb = locala.GQ;
        if (localb != null)
        {
          locala.removeObserver(localb);
          if (localb.GT)
          {
            if (LoaderManagerImpl.DEBUG) {
              new StringBuilder("  Resetting: ").append(localb.GP);
            }
            localb.GS.onLoaderReset(localb.GP);
          }
        }
        locala.GP.unregisterListener(locala);
        locala.GP.reset();
        i += 1;
      }
      this.GV.clear();
    }
  }
  
  public static final class a<D>
    extends MutableLiveData<D>
    implements c.b<D>
  {
    private LifecycleOwner GM;
    final Bundle GO = null;
    final c<D> GP;
    LoaderManagerImpl.b<D> GQ;
    c<D> GR;
    final int mId = 0;
    
    a(c<D> paramc)
    {
      this.GP = paramc;
      this.GR = null;
      this.GP.registerListener(0, this);
    }
    
    public final void W()
    {
      if (LoaderManagerImpl.DEBUG) {
        new StringBuilder("  Stopping: ").append(this);
      }
      this.GP.stopLoading();
    }
    
    final c<D> a(LifecycleOwner paramLifecycleOwner, p.a<D> parama)
    {
      parama = new LoaderManagerImpl.b(this.GP, parama);
      observe(paramLifecycleOwner, parama);
      if (this.GQ != null) {
        removeObserver(this.GQ);
      }
      this.GM = paramLifecycleOwner;
      this.GQ = parama;
      return this.GP;
    }
    
    final void em()
    {
      LifecycleOwner localLifecycleOwner = this.GM;
      LoaderManagerImpl.b localb = this.GQ;
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
      this.GP.startLoading();
    }
    
    public final void removeObserver(Observer<? super D> paramObserver)
    {
      super.removeObserver(paramObserver);
      this.GM = null;
      this.GQ = null;
    }
    
    public final void setValue(D paramD)
    {
      super.setValue(paramD);
      if (this.GR != null)
      {
        this.GR.reset();
        this.GR = null;
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
      e.a(this.GP, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }
  
  static final class b<D>
    implements Observer<D>
  {
    final c<D> GP;
    final p.a<D> GS;
    boolean GT = false;
    
    b(c<D> paramc, p.a<D> parama)
    {
      this.GP = paramc;
      this.GS = parama;
    }
    
    public final void onChanged(D paramD)
    {
      if (LoaderManagerImpl.DEBUG) {
        new StringBuilder("  onLoadFinished in ").append(this.GP).append(": ").append(this.GP.dataToString(paramD));
      }
      this.GS.onLoadFinished(this.GP, paramD);
      this.GT = true;
    }
    
    public final String toString()
    {
      return this.GS.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl
 * JD-Core Version:    0.7.0.1
 */