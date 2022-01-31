package com.google.android.gms.gcm;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class GcmTaskService$zze
  implements Runnable
{
  private final Bundle extras;
  private final String tag;
  private final zzg zzaa;
  private final Messenger zzab;
  private final List<Uri> zzz;
  
  GcmTaskService$zze(String paramString, IBinder paramIBinder, Bundle paramBundle, List<Uri> paramList)
  {
    AppMethodBeat.i(69956);
    this.tag = paramIBinder;
    if (paramBundle == null) {
      paramString = null;
    }
    for (;;)
    {
      this.zzaa = paramString;
      this.extras = paramList;
      Object localObject;
      this.zzz = localObject;
      this.zzab = null;
      AppMethodBeat.o(69956);
      return;
      paramString = paramBundle.queryLocalInterface("com.google.android.gms.gcm.INetworkTaskCallback");
      if ((paramString instanceof zzg)) {
        paramString = (zzg)paramString;
      } else {
        paramString = new zzh(paramBundle);
      }
    }
  }
  
  GcmTaskService$zze(String paramString, Messenger paramMessenger, Bundle paramBundle, List<Uri> paramList)
  {
    this.tag = paramMessenger;
    this.zzab = paramBundle;
    this.extras = paramList;
    Object localObject;
    this.zzz = localObject;
    this.zzaa = null;
  }
  
  private final void zze(int paramInt)
  {
    AppMethodBeat.i(69958);
    localObject1 = GcmTaskService.zzd(this.zzy);
    for (;;)
    {
      try
      {
        boolean bool = GcmTaskService.zzf(this.zzy).zzf(this.tag, GcmTaskService.zze(this.zzy).getClassName());
        if (!bool) {}
      }
      catch (RemoteException localRemoteException)
      {
        Messenger localMessenger;
        Message localMessage;
        Bundle localBundle;
        String str = String.valueOf(this.tag);
        if (str.length() == 0) {
          continue;
        }
        "Error reporting result of operation to scheduler for ".concat(str);
        GcmTaskService.zzf(this.zzy).zze(this.tag, GcmTaskService.zze(this.zzy).getClassName());
        if ((zzf()) || (GcmTaskService.zzf(this.zzy).zzf(GcmTaskService.zze(this.zzy).getClassName()))) {
          continue;
        }
        this.zzy.stopSelf(GcmTaskService.zzg(this.zzy));
        continue;
        new String("Error reporting result of operation to scheduler for ");
        continue;
      }
      finally
      {
        GcmTaskService.zzf(this.zzy).zze(this.tag, GcmTaskService.zze(this.zzy).getClassName());
        if ((zzf()) || (GcmTaskService.zzf(this.zzy).zzf(GcmTaskService.zze(this.zzy).getClassName()))) {
          continue;
        }
        this.zzy.stopSelf(GcmTaskService.zzg(this.zzy));
        AppMethodBeat.o(69958);
      }
      try
      {
        GcmTaskService.zzf(this.zzy).zze(this.tag, GcmTaskService.zze(this.zzy).getClassName());
        if ((!zzf()) && (!GcmTaskService.zzf(this.zzy).zzf(GcmTaskService.zze(this.zzy).getClassName()))) {
          this.zzy.stopSelf(GcmTaskService.zzg(this.zzy));
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(69958);
      }
    }
    if (zzf())
    {
      localMessenger = this.zzab;
      localMessage = Message.obtain();
      localMessage.what = 3;
      localMessage.arg1 = paramInt;
      localBundle = new Bundle();
      localBundle.putParcelable("component", GcmTaskService.zze(this.zzy));
      localBundle.putString("tag", this.tag);
      localMessage.setData(localBundle);
      localMessenger.send(localMessage);
    }
    for (;;)
    {
      GcmTaskService.zzf(this.zzy).zze(this.tag, GcmTaskService.zze(this.zzy).getClassName());
      if ((!zzf()) && (!GcmTaskService.zzf(this.zzy).zzf(GcmTaskService.zze(this.zzy).getClassName()))) {
        this.zzy.stopSelf(GcmTaskService.zzg(this.zzy));
      }
      AppMethodBeat.o(69958);
      return;
      this.zzaa.zzf(paramInt);
    }
  }
  
  private final boolean zzf()
  {
    return this.zzab != null;
  }
  
  public final void run()
  {
    AppMethodBeat.i(69957);
    TaskParams localTaskParams = new TaskParams(this.tag, this.extras, this.zzz);
    zze(this.zzy.onRunTask(localTaskParams));
    AppMethodBeat.o(69957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmTaskService.zze
 * JD-Core Version:    0.7.0.1
 */