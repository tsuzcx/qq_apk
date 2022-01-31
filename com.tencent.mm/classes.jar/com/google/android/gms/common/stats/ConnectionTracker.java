package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public class ConnectionTracker
{
  private static final Object zztm;
  private static volatile ConnectionTracker zzyg;
  @VisibleForTesting
  private static boolean zzyh;
  private final List<String> zzyi = Collections.EMPTY_LIST;
  private final List<String> zzyj = Collections.EMPTY_LIST;
  private final List<String> zzyk = Collections.EMPTY_LIST;
  private final List<String> zzyl = Collections.EMPTY_LIST;
  
  static
  {
    AppMethodBeat.i(89959);
    zztm = new Object();
    zzyh = false;
    AppMethodBeat.o(89959);
  }
  
  public static ConnectionTracker getInstance()
  {
    AppMethodBeat.i(89953);
    if (zzyg == null) {}
    synchronized (zztm)
    {
      if (zzyg == null) {
        zzyg = new ConnectionTracker();
      }
      ??? = zzyg;
      AppMethodBeat.o(89953);
      return ???;
    }
  }
  
  @SuppressLint({"UntrackedBindService"})
  private static boolean zza(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(89956);
    if (paramBoolean)
    {
      paramString = paramIntent.getComponent();
      if (paramString == null) {}
      for (paramBoolean = false; paramBoolean; paramBoolean = ClientLibraryUtils.isPackageStopped(paramContext, paramString.getPackageName()))
      {
        AppMethodBeat.o(89956);
        return false;
      }
    }
    paramBoolean = paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
    AppMethodBeat.o(89956);
    return paramBoolean;
  }
  
  public boolean bindService(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    AppMethodBeat.i(89957);
    boolean bool = bindService(paramContext, paramContext.getClass().getName(), paramIntent, paramServiceConnection, paramInt);
    AppMethodBeat.o(89957);
    return bool;
  }
  
  public boolean bindService(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    AppMethodBeat.i(89954);
    boolean bool = zza(paramContext, paramString, paramIntent, paramServiceConnection, paramInt, true);
    AppMethodBeat.o(89954);
    return bool;
  }
  
  public boolean bindServiceAllowStoppedPackages(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    AppMethodBeat.i(89955);
    boolean bool = zza(paramContext, paramString, paramIntent, paramServiceConnection, paramInt, false);
    AppMethodBeat.o(89955);
    return bool;
  }
  
  public void logConnectService(Context paramContext, ServiceConnection paramServiceConnection, String paramString, Intent paramIntent) {}
  
  public void logDisconnectService(Context paramContext, ServiceConnection paramServiceConnection) {}
  
  public void logStartService(Service paramService, int paramInt) {}
  
  public void logStopService(Service paramService, int paramInt) {}
  
  @SuppressLint({"UntrackedBindService"})
  public void unbindService(Context paramContext, ServiceConnection paramServiceConnection)
  {
    AppMethodBeat.i(89958);
    paramContext.unbindService(paramServiceConnection);
    AppMethodBeat.o(89958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.stats.ConnectionTracker
 * JD-Core Version:    0.7.0.1
 */