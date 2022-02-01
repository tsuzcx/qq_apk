package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.b.a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
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
    AppMethodBeat.i(4535);
    zzla = new WeakHashMap();
    AppMethodBeat.o(4535);
  }
  
  public zzcc()
  {
    AppMethodBeat.i(4522);
    this.zzlb = new a();
    this.zzlc = 0;
    AppMethodBeat.o(4522);
  }
  
  public static zzcc zza(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(210378);
    Object localObject = (WeakReference)zzla.get(paramFragmentActivity);
    if (localObject != null)
    {
      localObject = (zzcc)((WeakReference)localObject).get();
      if (localObject != null)
      {
        AppMethodBeat.o(210378);
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
        paramFragmentActivity.getSupportFragmentManager().beginTransaction().a((Fragment)localObject, "SupportLifecycleFragmentImpl").FX();
      }
      zzla.put(paramFragmentActivity, new WeakReference(localObject));
      AppMethodBeat.o(210378);
      return localObject;
    }
    catch (ClassCastException paramFragmentActivity)
    {
      paramFragmentActivity = new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", paramFragmentActivity);
      AppMethodBeat.o(210378);
      throw paramFragmentActivity;
    }
  }
  
  public final void addCallback(String paramString, LifecycleCallback paramLifecycleCallback)
  {
    AppMethodBeat.i(4525);
    if (!this.zzlb.containsKey(paramString))
    {
      this.zzlb.put(paramString, paramLifecycleCallback);
      if (this.zzlc > 0) {
        new Handler(Looper.getMainLooper()).post(new zzcd(this, paramLifecycleCallback, paramString));
      }
      AppMethodBeat.o(4525);
      return;
    }
    paramString = new IllegalArgumentException(String.valueOf(paramString).length() + 59 + "LifecycleCallback with tag " + paramString + " already added to this fragment.");
    AppMethodBeat.o(4525);
    throw paramString;
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    AppMethodBeat.i(4533);
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    AppMethodBeat.o(4533);
  }
  
  public final <T extends LifecycleCallback> T getCallbackOrNull(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(4524);
    paramString = (LifecycleCallback)paramClass.cast(this.zzlb.get(paramString));
    AppMethodBeat.o(4524);
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
    AppMethodBeat.i(4529);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(4529);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(4526);
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
    AppMethodBeat.o(4526);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(4532);
    super.onDestroy();
    this.zzlc = 5;
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onDestroy();
    }
    AppMethodBeat.o(4532);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(4528);
    super.onResume();
    this.zzlc = 3;
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onResume();
    }
    AppMethodBeat.o(4528);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(4530);
    super.onSaveInstanceState(paramBundle);
    if (paramBundle == null)
    {
      AppMethodBeat.o(4530);
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
    AppMethodBeat.o(4530);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(4527);
    super.onStart();
    this.zzlc = 2;
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onStart();
    }
    AppMethodBeat.o(4527);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(4531);
    super.onStop();
    this.zzlc = 4;
    Iterator localIterator = this.zzlb.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onStop();
    }
    AppMethodBeat.o(4531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzcc
 * JD-Core Version:    0.7.0.1
 */