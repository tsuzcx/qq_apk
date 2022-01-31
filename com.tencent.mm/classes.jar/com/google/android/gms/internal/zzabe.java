package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzabe
{
  public final zzabf zzaCR;
  
  public zzabe(zzabf paramzzabf)
  {
    this.zzaCR = paramzzabf;
  }
  
  protected static zzabf zzc(zzabd paramzzabd)
  {
    if (paramzzabd.zzwS()) {
      return zzabu.zza(paramzzabd.zzwU());
    }
    return zzabg.zzt(paramzzabd.zzwT());
  }
  
  public static zzabf zzs(Activity paramActivity)
  {
    return zzc(new zzabd(paramActivity));
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public Activity getActivity()
  {
    return this.zzaCR.zzwV();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart() {}
  
  public void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzabe
 * JD-Core Version:    0.7.0.1
 */