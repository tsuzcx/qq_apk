package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.support.v4.app.k;
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

public final class zzcc
  extends Fragment
  implements LifecycleFragment
{
  private static WeakHashMap<FragmentActivity, WeakReference<zzcc>> zzla;
  private Map<String, LifecycleCallback> zzlb;
  private int zzlc;
  private Bundle zzld;
  
  static
  {
    AppMethodBeat.i(89513);
    zzla = new WeakHashMap();
    AppMethodBeat.o(89513);
  }
  
  public zzcc()
  {
    AppMethodBeat.i(89500);
    this.zzlb = new a();
    this.zzlc = 0;
    AppMethodBeat.o(89500);
  }
  
  public static zzcc zza(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(89501);
    Object localObject = (WeakReference)zzla.get(paramFragmentActivity);
    if (localObject != null)
    {
      localObject = (zzcc)((WeakReference)localObject).get();
      if (localObject != null)
      {
        AppMethodBeat.o(89501);
        return localObject;
      }
    }
    try
    {
      zzcc localzzcc = (zzcc)paramFragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
      if (localzzcc != null)
      {
        localObject = localzzcc;
        if (!localzzcc.isRemoving()) {}
      }
      else
      {
        localObject = new zzcc();
        paramFragmentActivity.getSupportFragmentManager().beginTransaction().a((Fragment)localObject, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
      }
      zzla.put(paramFragmentActivity, new WeakReference(localObject));
      AppMethodBeat.o(89501);
      return localObject;
    }
    catch (ClassCastException paramFragmentActivity)
    {
      paramFragmentActivity = new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", paramFragmentActivity);
      AppMethodBeat.o(89501);
      throw paramFragmentActivity;
    }
  }
  
  public final void addCallback(String paramString, LifecycleCallback paramLifecycleCallback)
  {
    AppMethodBeat.i(89503);
    if (!this.zzlb.containsKey(paramString))
    {
      this.zzlb.put(paramString, paramLifecycleCallback);
      if (this.zzlc > 0) {
        new Handler(Looper.getMainLooper()).post(new zzcd(this, paramLifecycleCallback, paramString));
      }
      AppMethodBeat.o(89503);
      return;
    }
    paramString = new IllegalArgumentException(String.valueOf(paramString).length() + 59 + "LifecycleCallback with tag " + paramString + " already added to this fragment.");
    AppMethodBeat.o(89503);
    throw paramString;
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(89511);
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    AppMethodBeat.o(89511);
  }
  
  public final <T extends LifecycleCallback> T getCallbackOrNull(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(89502);
    paramString = (LifecycleCallback)paramClass.cast(this.zzlb.get(paramString));
    AppMethodBeat.o(89502);
    return paramString;
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
    AppMethodBeat.i(89507);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(89507);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(89504);
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
    AppMethodBeat.o(89504);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(89510);
    super.onDestroy();
    this.zzlc = 5;
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(89510);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(89506);
    super.onResume();
    this.zzlc = 3;
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onResume();
    }
    AppMethodBeat.o(89506);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(89508);
    super.onSaveInstanceState(paramBundle);
    if (paramBundle == null)
    {
      AppMethodBeat.o(89508);
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
    AppMethodBeat.o(89508);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(89505);
    super.onStart();
    this.zzlc = 2;
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onStart();
    }
    AppMethodBeat.o(89505);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(89509);
    super.onStop();
    this.zzlc = 4;
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onStop();
    }
    AppMethodBeat.o(89509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzcc
 * JD-Core Version:    0.7.0.1
 */