package android.support.v4.app;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.os.Bundle;
import android.support.v4.content.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class p
{
  public static <T extends LifecycleOwner,  extends ViewModelStoreOwner> p d(T paramT)
  {
    return new LoaderManagerImpl(paramT, ((ViewModelStoreOwner)paramT).getViewModelStore());
  }
  
  public abstract <D> c<D> a(a<D> parama);
  
  @Deprecated
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract void em();
  
  public static abstract interface a<D>
  {
    public abstract c<D> onCreateLoader(int paramInt, Bundle paramBundle);
    
    public abstract void onLoadFinished(c<D> paramc, D paramD);
    
    public abstract void onLoaderReset(c<D> paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.p
 * JD-Core Version:    0.7.0.1
 */