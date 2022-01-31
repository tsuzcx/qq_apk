package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzbr
  extends Fragment
  implements LifecycleFragment
{
  private static WeakHashMap<Activity, WeakReference<zzbr>> zzla;
  private Map<String, LifecycleCallback> zzlb;
  private int zzlc;
  private Bundle zzld;
  
  static
  {
    AppMethodBeat.i(89498);
    zzla = new WeakHashMap();
    AppMethodBeat.o(89498);
  }
  
  public zzbr()
  {
    AppMethodBeat.i(89485);
    this.zzlb = new a();
    this.zzlc = 0;
    AppMethodBeat.o(89485);
  }
  
  public static zzbr zzc(Activity paramActivity)
  {
    AppMethodBeat.i(89486);
    Object localObject = (WeakReference)zzla.get(paramActivity);
    if (localObject != null)
    {
      localObject = (zzbr)((WeakReference)localObject).get();
      if (localObject != null)
      {
        AppMethodBeat.o(89486);
        return localObject;
      }
    }
    try
    {
      zzbr localzzbr = (zzbr)paramActivity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
      if (localzzbr != null)
      {
        localObject = localzzbr;
        if (!localzzbr.isRemoving()) {}
      }
      else
      {
        localObject = new zzbr();
        paramActivity.getFragmentManager().beginTransaction().add((Fragment)localObject, "LifecycleFragmentImpl").commitAllowingStateLoss();
      }
      zzla.put(paramActivity, new WeakReference(localObject));
      AppMethodBeat.o(89486);
      return localObject;
    }
    catch (ClassCastException paramActivity)
    {
      paramActivity = new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", paramActivity);
      AppMethodBeat.o(89486);
      throw paramActivity;
    }
  }
  
  public final void addCallback(String paramString, LifecycleCallback paramLifecycleCallback)
  {
    AppMethodBeat.i(89488);
    if (!this.zzlb.containsKey(paramString))
    {
      this.zzlb.put(paramString, paramLifecycleCallback);
      if (this.zzlc > 0) {
        new Handler(Looper.getMainLooper()).post(new zzbs(this, paramLifecycleCallback, paramString));
      }
      AppMethodBeat.o(89488);
      return;
    }
    paramString = new IllegalArgumentException(String.valueOf(paramString).length() + 59 + "LifecycleCallback with tag " + paramString + " already added to this fragment.");
    AppMethodBeat.o(89488);
    throw paramString;
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(89497);
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    AppMethodBeat.o(89497);
  }
  
  public final <T extends LifecycleCallback> T getCallbackOrNull(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(89487);
    paramString = (LifecycleCallback)paramClass.cast(this.zzlb.get(paramString));
    AppMethodBeat.o(89487);
    return paramString;
  }
  
  public final Activity getLifecycleActivity()
  {
    AppMethodBeat.i(89489);
    Activity localActivity = getActivity();
    AppMethodBeat.o(89489);
    return localActivity;
  }
  
  public final boolean isCreated()
  {
    return this.zzlc > 0;
  }
  
  public final boolean isStarted()
  {
    return this.zzlc >= 2;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(89493);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(89493);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(89490);
    super.onCreate(paramBundle);
    this.zzlc = 1;
    this.zzld = paramBundle;
    Iterator localIterator = this.zzlb.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      LifecycleCallback localLifecycleCallback = (LifecycleCallback)((Map.Entry)localObject).getValue();
      if (paramBundle != null) {}
      for (localObject = paramBundle.getBundle((String)((Map.Entry)localObject).getKey());; localObject = null)
      {
        localLifecycleCallback.onCreate((Bundle)localObject);
        break;
      }
    }
    AppMethodBeat.o(89490);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(89496);
    super.onDestroy();
    this.zzlc = 5;
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(89496);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(89492);
    super.onResume();
    this.zzlc = 3;
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onResume();
    }
    AppMethodBeat.o(89492);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(89494);
    super.onSaveInstanceState(paramBundle);
    if (paramBundle == null)
    {
      AppMethodBeat.o(89494);
      return;
    }
    Iterator localIterator = this.zzlb.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Bundle localBundle = new Bundle();
      ((LifecycleCallback)localEntry.getValue()).onSaveInstanceState(localBundle);
      paramBundle.putBundle((String)localEntry.getKey(), localBundle);
    }
    AppMethodBeat.o(89494);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(89491);
    super.onStart();
    this.zzlc = 2;
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onStart();
    }
    AppMethodBeat.o(89491);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(89495);
    super.onStop();
    this.zzlc = 4;
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onStop();
    }
    AppMethodBeat.o(89495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzbr
 * JD-Core Version:    0.7.0.1
 */