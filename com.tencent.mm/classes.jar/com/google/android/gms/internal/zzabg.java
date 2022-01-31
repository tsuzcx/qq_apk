package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.f.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzabg
  extends Fragment
  implements zzabf
{
  private static WeakHashMap<Activity, WeakReference<zzabg>> zzaCS = new WeakHashMap();
  private int zzJO = 0;
  private Map<String, zzabe> zzaCT = new a();
  private Bundle zzaCU;
  
  private void zzb(String paramString, zzabe paramzzabe)
  {
    if (this.zzJO > 0) {
      new Handler(Looper.getMainLooper()).post(new zzabg.1(this, paramzzabe, paramString));
    }
  }
  
  public static zzabg zzt(Activity paramActivity)
  {
    Object localObject = (WeakReference)zzaCS.get(paramActivity);
    if (localObject != null)
    {
      localObject = (zzabg)((WeakReference)localObject).get();
      if (localObject != null) {
        return localObject;
      }
    }
    try
    {
      zzabg localzzabg = (zzabg)paramActivity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
      if (localzzabg != null)
      {
        localObject = localzzabg;
        if (!localzzabg.isRemoving()) {}
      }
      else
      {
        localObject = new zzabg();
        paramActivity.getFragmentManager().beginTransaction().add((Fragment)localObject, "LifecycleFragmentImpl").commitAllowingStateLoss();
      }
      zzaCS.put(paramActivity, new WeakReference(localObject));
      return localObject;
    }
    catch (ClassCastException paramActivity)
    {
      throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", paramActivity);
    }
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    Iterator localIterator = this.zzaCT.values().iterator();
    while (localIterator.hasNext()) {
      ((zzabe)localIterator.next()).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator localIterator = this.zzaCT.values().iterator();
    while (localIterator.hasNext()) {
      ((zzabe)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.zzJO = 1;
    this.zzaCU = paramBundle;
    Iterator localIterator = this.zzaCT.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      zzabe localzzabe = (zzabe)((Map.Entry)localObject).getValue();
      if (paramBundle != null) {}
      for (localObject = paramBundle.getBundle((String)((Map.Entry)localObject).getKey());; localObject = null)
      {
        localzzabe.onCreate((Bundle)localObject);
        break;
      }
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    this.zzJO = 4;
    Iterator localIterator = this.zzaCT.values().iterator();
    while (localIterator.hasNext()) {
      ((zzabe)localIterator.next()).onDestroy();
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.zzaCT.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Bundle localBundle = new Bundle();
        ((zzabe)localEntry.getValue()).onSaveInstanceState(localBundle);
        paramBundle.putBundle((String)localEntry.getKey(), localBundle);
      }
    }
  }
  
  public final void onStart()
  {
    super.onStart();
    this.zzJO = 2;
    Iterator localIterator = this.zzaCT.values().iterator();
    while (localIterator.hasNext()) {
      ((zzabe)localIterator.next()).onStart();
    }
  }
  
  public final void onStop()
  {
    super.onStop();
    this.zzJO = 3;
    Iterator localIterator = this.zzaCT.values().iterator();
    while (localIterator.hasNext()) {
      ((zzabe)localIterator.next()).onStop();
    }
  }
  
  public final <T extends zzabe> T zza(String paramString, Class<T> paramClass)
  {
    return (zzabe)paramClass.cast(this.zzaCT.get(paramString));
  }
  
  public final void zza(String paramString, zzabe paramzzabe)
  {
    if (!this.zzaCT.containsKey(paramString))
    {
      this.zzaCT.put(paramString, paramzzabe);
      zzb(paramString, paramzzabe);
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramString).length() + 59 + "LifecycleCallback with tag " + paramString + " already added to this fragment.");
  }
  
  public final Activity zzwV()
  {
    return getActivity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzabg
 * JD-Core Version:    0.7.0.1
 */