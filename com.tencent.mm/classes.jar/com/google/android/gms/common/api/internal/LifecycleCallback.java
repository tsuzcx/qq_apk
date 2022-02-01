package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LifecycleCallback
{
  protected final LifecycleFragment mLifecycleFragment;
  
  protected LifecycleCallback(LifecycleFragment paramLifecycleFragment)
  {
    this.mLifecycleFragment = paramLifecycleFragment;
  }
  
  private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity paramLifecycleActivity)
  {
    AppMethodBeat.i(4504);
    paramLifecycleActivity = new IllegalStateException("Method not available in SDK.");
    AppMethodBeat.o(4504);
    throw paramLifecycleActivity;
  }
  
  public static LifecycleFragment getFragment(Activity paramActivity)
  {
    AppMethodBeat.i(4505);
    paramActivity = getFragment(new LifecycleActivity(paramActivity));
    AppMethodBeat.o(4505);
    return paramActivity;
  }
  
  protected static LifecycleFragment getFragment(LifecycleActivity paramLifecycleActivity)
  {
    AppMethodBeat.i(4503);
    if (paramLifecycleActivity.zzbv())
    {
      paramLifecycleActivity = zzcc.zza(paramLifecycleActivity.zzby());
      AppMethodBeat.o(4503);
      return paramLifecycleActivity;
    }
    if (paramLifecycleActivity.zzbw())
    {
      paramLifecycleActivity = zzbr.zzc(paramLifecycleActivity.zzbx());
      AppMethodBeat.o(4503);
      return paramLifecycleActivity;
    }
    paramLifecycleActivity = new IllegalArgumentException("Can't get fragment for unexpected activity.");
    AppMethodBeat.o(4503);
    throw paramLifecycleActivity;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(4506);
    Activity localActivity = this.mLifecycleFragment.getLifecycleActivity();
    AppMethodBeat.o(4506);
    return localActivity;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onResume() {}
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart() {}
  
  public void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.LifecycleCallback
 * JD-Core Version:    0.7.0.1
 */