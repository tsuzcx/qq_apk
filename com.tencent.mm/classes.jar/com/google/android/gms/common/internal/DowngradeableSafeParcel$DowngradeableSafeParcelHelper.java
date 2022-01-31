package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class DowngradeableSafeParcel$DowngradeableSafeParcelHelper
{
  public static Bundle getExtras(Intent paramIntent, Context paramContext, Integer paramInteger)
  {
    AppMethodBeat.i(89592);
    synchronized (DowngradeableSafeParcel.zzcs())
    {
      paramIntent = DowngradeableSafeParcel.getExtras(paramIntent, paramContext, paramInteger);
      AppMethodBeat.o(89592);
      return paramIntent;
    }
  }
  
  public static <T extends Parcelable> T getParcelable(Intent paramIntent, String paramString, Context paramContext, Integer paramInteger)
  {
    AppMethodBeat.i(89590);
    synchronized (DowngradeableSafeParcel.zzcs())
    {
      paramIntent = DowngradeableSafeParcel.getParcelable(paramIntent, paramString, paramContext, paramInteger);
      AppMethodBeat.o(89590);
      return paramIntent;
    }
  }
  
  public static <T extends Parcelable> T getParcelable(Bundle paramBundle, String paramString, Context paramContext, Integer paramInteger)
  {
    AppMethodBeat.i(89593);
    synchronized (DowngradeableSafeParcel.zzcs())
    {
      paramBundle = DowngradeableSafeParcel.getParcelable(paramBundle, paramString, paramContext, paramInteger);
      AppMethodBeat.o(89593);
      return paramBundle;
    }
  }
  
  public static boolean putParcelable(Bundle paramBundle, String paramString, DowngradeableSafeParcel paramDowngradeableSafeParcel, Context paramContext, Integer paramInteger)
  {
    AppMethodBeat.i(89591);
    boolean bool = DowngradeableSafeParcel.putParcelable(paramBundle, paramString, paramDowngradeableSafeParcel, paramContext, paramInteger);
    AppMethodBeat.o(89591);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.internal.DowngradeableSafeParcel.DowngradeableSafeParcelHelper
 * JD-Core Version:    0.7.0.1
 */