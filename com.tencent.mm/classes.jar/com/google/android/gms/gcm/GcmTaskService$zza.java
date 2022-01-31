package com.google.android.gms.gcm;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.List;

class GcmTaskService$zza
  implements Runnable
{
  private final Bundle mExtras;
  private final String mTag;
  private final zzb zzbgy;
  private final List<Uri> zzbgz;
  
  GcmTaskService$zza(String paramString, IBinder paramIBinder, Bundle paramBundle, List<Uri> paramList)
  {
    this.mTag = paramIBinder;
    this.zzbgy = zzb.zza.zzcV(paramBundle);
    this.mExtras = paramList;
    Object localObject;
    this.zzbgz = localObject;
  }
  
  public void run()
  {
    TaskParams localTaskParams = new TaskParams(this.mTag, this.mExtras, this.zzbgz);
    int i = this.zzbgA.onRunTask(localTaskParams);
    try
    {
      this.zzbgy.zzjC(i);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      String str = String.valueOf(this.mTag);
      if (str.length() != 0) {
        "Error reporting result of operation to scheduler for ".concat(str);
      }
      for (;;)
      {
        return;
        new String("Error reporting result of operation to scheduler for ");
      }
    }
    finally
    {
      GcmTaskService.zza(this.zzbgA, this.mTag);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmTaskService.zza
 * JD-Core Version:    0.7.0.1
 */