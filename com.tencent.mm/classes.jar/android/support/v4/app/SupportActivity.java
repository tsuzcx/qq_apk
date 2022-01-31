package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.State;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ReportFragment;
import android.os.Bundle;
import android.support.v4.f.m;

public class SupportActivity
  extends Activity
  implements LifecycleOwner
{
  private m<Class<? extends a>, a> mExtraDataMap = new m();
  private LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
  
  public <T extends a> T getExtraData(Class<T> paramClass)
  {
    return (a)this.mExtraDataMap.get(paramClass);
  }
  
  public Lifecycle getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ReportFragment.injectIfNeededIn(this);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    this.mLifecycleRegistry.markState(Lifecycle.State.CREATED);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void putExtraData(a parama)
  {
    this.mExtraDataMap.put(parama.getClass(), parama);
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.SupportActivity
 * JD-Core Version:    0.7.0.1
 */