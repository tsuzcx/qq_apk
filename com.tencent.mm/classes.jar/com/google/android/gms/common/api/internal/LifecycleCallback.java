package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@KeepForSdk
public class LifecycleCallback
{
  @KeepForSdk
  protected final LifecycleFragment mLifecycleFragment;
  
  @KeepForSdk
  protected LifecycleCallback(LifecycleFragment paramLifecycleFragment)
  {
    this.mLifecycleFragment = paramLifecycleFragment;
  }
  
  @Keep
  private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity paramLifecycleActivity)
  {
    AppMethodBeat.i(89482);
    paramLifecycleActivity = new IllegalStateException("Method not available in SDK.");
    AppMethodBeat.o(89482);
    throw paramLifecycleActivity;
  }
  
  @KeepForSdk
  public static LifecycleFragment getFragment(Activity paramActivity)
  {
    AppMethodBeat.i(89483);
    paramActivity = getFragment(new LifecycleActivity(paramActivity));
    AppMethodBeat.o(89483);
    return paramActivity;
  }
  
  @KeepForSdk
  protected static LifecycleFragment getFragment(LifecycleActivity paramLifecycleActivity)
  {
    AppMethodBeat.i(89481);
    if (paramLifecycleActivity.zzbv())
    {
      paramLifecycleActivity = zzcc.zza(paramLifecycleActivity.zzby());
      AppMethodBeat.o(89481);
      return paramLifecycleActivity;
    }
    if (paramLifecycleActivity.zzbw())
    {
      paramLifecycleActivity = zzbr.zzc(paramLifecycleActivity.zzbx());
      AppMethodBeat.o(89481);
      return paramLifecycleActivity;
    }
    paramLifecycleActivity = new IllegalArgumentException("Can't get fragment for unexpected activity.");
    AppMethodBeat.o(89481);
    throw paramLifecycleActivity;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(89484);
    Activity localActivity = this.mLifecycleFragment.getLifecycleActivity();
    AppMethodBeat.o(89484);
    return localActivity;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onResume() {}
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart() {}
  
  @KeepForSdk
  public void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.LifecycleCallback
 * JD-Core Version:    0.7.0.1
 */