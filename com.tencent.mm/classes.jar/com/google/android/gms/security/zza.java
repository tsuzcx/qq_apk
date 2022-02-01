package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza
  extends AsyncTask<Void, Void, Integer>
{
  zza(Context paramContext, ProviderInstaller.ProviderInstallListener paramProviderInstallListener) {}
  
  private final Integer zza(Void... paramVarArgs)
  {
    AppMethodBeat.i(5527);
    int i;
    try
    {
      ProviderInstaller.installIfNeeded(this.val$context);
      AppMethodBeat.o(5527);
      return Integer.valueOf(0);
    }
    catch (GooglePlayServicesRepairableException paramVarArgs)
    {
      i = paramVarArgs.getConnectionStatusCode();
      AppMethodBeat.o(5527);
      return Integer.valueOf(i);
    }
    catch (GooglePlayServicesNotAvailableException paramVarArgs)
    {
      i = paramVarArgs.errorCode;
      AppMethodBeat.o(5527);
    }
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.security.zza
 * JD-Core Version:    0.7.0.1
 */