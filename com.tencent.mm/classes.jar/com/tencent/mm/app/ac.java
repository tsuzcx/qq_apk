package com.tencent.mm.app;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class ac
{
  static final Bundle bt(Context paramContext)
  {
    AppMethodBeat.i(123475);
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      AppMethodBeat.o(123475);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ad.printErrStackTrace("MicroMsg.SetupBaseBuildInfo", paramContext, "", new Object[0]);
      AppMethodBeat.o(123475);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.ac
 * JD-Core Version:    0.7.0.1
 */