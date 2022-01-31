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
import android.support.v4.e.d;
import android.support.v4.e.n;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class LoaderManagerImpl
  extends p
{
  static boolean DEBUG = false;
  private final LifecycleOwner xE;
  private final LoaderViewModel xF;
  
  LoaderManagerImpl(LifecycleOwner paramLifecycleOwner, ViewModelStore paramViewModelStore)
  {
    this.xE = paramLifecycleOwner;
    this.xF = LoaderViewModel.a(paramViewModelStore);
  }
  
  private <D> c<D> b(p.a<D> parama)
  {
    try
    {
      this.xF.xP = true;
      localObject = parama.onCreateLoader(0, null);
      if (localObject == null) {
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
      }
    }
    finally
    {
      this.xF.xP = false;
    }
    if ((localObject.getClass().isMemberClass()) && (!Modifier.isStatic(localObject.getClass().getModifiers()))) {
      throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: ".concat(String.valueOf(localObject)));
    }
    Object localObject = new a((c)localObject);
    if (DEBUG) {
      new StringBuilder("  Created new loader ").append(localObject);
    }
    this.xF.xO.put(0, localObject);
    this.xF.xP = false;
    return ((a)localObject).a(this.xE, parama);
  }
  
  public final <D> c<D> a(p.a<D> parama)
  {
    if (this.xF.xP) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      throw new IllegalStateException("initLoader must be called on the main thread");
    }
    a locala = (a)this.xF.xO.get(0, null);
    if (DEBUG) {
      new StringBuilder("initLoader in ").append(this).append(": args=").append(null);
    }
    if (locala == null) {
      return b(parama);
    }
    if (DEBUG) {
      new StringBuilder("  Re-using existing loader ").append(locala);
    }
    return locala.a(this.xE, parama);
  }
  
  public final void cH()
  {
    LoaderViewModel localLoaderViewModel = this.xF;
    int j = localLoaderViewModel.xO.size();
    int i = 0;
    while (i < j)
    {
      ((a)localLoaderViewModel.xO.valueAt(i)).cH();
      i += 1;
    }
  }
  
  @Deprecated
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    LoaderViewModel localLoaderViewModel = this.xF;
    if (localLoaderViewModel.xO.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loaders:");
      String str = paramString + "    ";
      int i = 0;
      while (i < localLoaderViewModel.xO.size())
      {
        a locala = (a)localLoaderViewModel.xO.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(localLoaderViewModel.xO.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(locala.toString());
        paramPrintWriter.print(str);
        paramPrintWriter.print("mId=");
        paramPrintWriter.print(locala.mId);
        paramPrintWriter.print(" mArgs=");
        paramPrintWriter.println(locala.xG);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mLoader=");
        paramPrintWriter.println(locala.xH);
        locala.xH.dump(str + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        if (locala.xI != null)
        {
          paramPrintWriter.print(str);
          paramPrintWriter.print("mCallbacks=");
          paramPrintWriter.println(locala.xI);
          b localb = locala.xI;
          paramPrintWriter.print(str + "  ");
          paramPrintWriter.print("mDeliveredData=");
          paramPrintWriter.println(localb.xM);
        }
        paramPrintWriter.print(str);
        paramPrintWriter.print("mData=");
        paramPrintWriter.println(locala.xH.dataToString(locala.getValue()));
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
    d.a(this.xE, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  static class LoaderViewModel
    extends ViewModel
  {
    private static final ViewModelProvider.Factory xN = new ViewModelProvider.Factory()
    {
      public final <T extends ViewModel> T create(Class<T> paramAnonymousClass)
      {
        return new LoaderManagerImpl.LoaderViewModel();
      }
    };
    n<LoaderManagerImpl.a> xO = new n();
    boolean xP = false;
    
    static LoaderViewModel a(ViewModelStore paramViewModelStore)
    {
      return (LoaderViewModel)new ViewModelProvider(paramViewModelStore, xN).get(LoaderViewModel.class);
    }
    
    public final void au()
    {
      super.au();
      int j = this.xO.size();
      int i = 0;
      while (i < j)
      {
        LoaderManagerImpl.a locala = (LoaderManagerImpl.a)this.xO.valueAt(i);
        if (LoaderManagerImpl.DEBUG) {
          new StringBuilder("  Destroying: ").append(locala);
        }
        locala.xH.cancelLoad();
        locala.xH.abandon();
        LoaderManagerImpl.b localb = locala.xI;
        if (localb != null)
        {
          locala.removeObserver(localb);
          if (localb.xM)
          {
            if (LoaderManagerImpl.DEBUG) {
              new StringBuilder("  Resetting: ").append(localb.xH);
            }
            localb.xL.onLoaderReset(localb.xH);
          }
        }
        locala.xH.unregisterListener(locala);
        locala.xH.reset();
        i += 1;
      }
      this.xO.clear();
    }
  }
  
  public static final class a<D>
    extends MutableLiveData<D>
    implements c.b<D>
  {
    final int mId = 0;
    private LifecycleOwner xE;
    final Bundle xG = null;
    final c<D> xH;
    LoaderManagerImpl.b<D> xI;
    c<D> xJ;
    
    a(c<D> paramc)
    {
      this.xH = paramc;
      this.xJ = null;
      this.xH.registerListener(0, this);
    }
    
    final c<D> a(LifecycleOwner paramLifecycleOwner, p.a<D> parama)
    {
      parama = new LoaderManagerImpl.b(this.xH, parama);
      observe(paramLifecycleOwner, parama);
      if (this.xI != null) {
        removeObserver(this.xI);
      }
      this.xE = paramLifecycleOwner;
      this.xI = parama;
      return this.xH;
    }
    
    public final void an()
    {
      if (LoaderManagerImpl.DEBUG) {
        new StringBuilder("  Stopping: ").append(this);
      }
      this.xH.stopLoading();
    }
    
    final void cH()
    {
      LifecycleOwner localLifecycleOwner = this.xE;
      LoaderManagerImpl.b localb = this.xI;
      if ((localLifecycleOwner != null) && (localb != null))
      {
        super.removeObserver(localb);
        observe(localLifecycleOwner, localb);
      }
    }
    
    public final void k(D paramD)
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
      this.xH.startLoading();
    }
    
    public final void removeObserver(Observer<? super D> paramObserver)
    {
      super.removeObserver(paramObserver);
      this.xE = null;
      this.xI = null;
    }
    
    public final void setValue(D paramD)
    {
      super.setValue(paramD);
      if (this.xJ != null)
      {
        this.xJ.reset();
        this.xJ = null;
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
      d.a(this.xH, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }
  
  static final class b<D>
    implements Observer<D>
  {
    final c<D> xH;
    final p.a<D> xL;
    boolean xM = false;
    
    b(c<D> paramc, p.a<D> parama)
    {
      this.xH = paramc;
      this.xL = parama;
    }
    
    public final void onChanged(D paramD)
    {
      if (LoaderManagerImpl.DEBUG) {
        new StringBuilder("  onLoadFinished in ").append(this.xH).append(": ").append(this.xH.dataToString(paramD));
      }
      this.xL.onLoadFinished(this.xH, paramD);
      this.xM = true;
    }
    
    public final String toString()
    {
      return this.xL.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl
 * JD-Core Version:    0.7.0.1
 */