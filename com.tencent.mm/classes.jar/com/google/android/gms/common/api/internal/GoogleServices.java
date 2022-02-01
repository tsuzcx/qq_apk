package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R.string;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.MetadataValueReader;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public final class GoogleServices
{
  private static final Object sLock;
  private static GoogleServices zzku;
  private final String zzkv;
  private final Status zzkw;
  private final boolean zzkx;
  private final boolean zzky;
  
  static
  {
    AppMethodBeat.i(4501);
    sLock = new Object();
    AppMethodBeat.o(4501);
  }
  
  GoogleServices(Context paramContext)
  {
    AppMethodBeat.i(4492);
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getIdentifier("google_app_measurement_enable", "integer", ((Resources)localObject).getResourcePackageName(R.string.common_google_play_services_unknown_issue));
    if (i != 0) {
      if (((Resources)localObject).getInteger(i) != 0)
      {
        bool1 = true;
        if (bool1) {
          break label139;
        }
      }
    }
    label58:
    for (this.zzky = bool2;; this.zzky = false)
    {
      this.zzkx = bool1;
      String str = MetadataValueReader.getGoogleAppId(paramContext);
      localObject = str;
      if (str == null) {
        localObject = new StringResourceValueReader(paramContext).getString("google_app_id");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label153;
      }
      this.zzkw = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
      this.zzkv = null;
      AppMethodBeat.o(4492);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label58;
    }
    label139:
    label153:
    this.zzkv = ((String)localObject);
    this.zzkw = Status.RESULT_SUCCESS;
    AppMethodBeat.o(4492);
  }
  
  GoogleServices(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(4493);
    this.zzkv = paramString;
    this.zzkw = Status.RESULT_SUCCESS;
    this.zzkx = paramBoolean;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.zzky = paramBoolean;
      AppMethodBeat.o(4493);
      return;
    }
  }
  
  private static GoogleServices checkInitialized(String paramString)
  {
    AppMethodBeat.i(4500);
    synchronized (sLock)
    {
      if (zzku == null)
      {
        paramString = new IllegalStateException(String.valueOf(paramString).length() + 34 + "Initialize must be called before " + paramString + ".");
        AppMethodBeat.o(4500);
        throw paramString;
      }
    }
    paramString = zzku;
    AppMethodBeat.o(4500);
    return paramString;
  }
  
  static void clearInstanceForTest()
  {
    synchronized (sLock)
    {
      zzku = null;
      return;
    }
  }
  
  public static String getGoogleAppId()
  {
    AppMethodBeat.i(4497);
    String str = checkInitialized("getGoogleAppId").zzkv;
    AppMethodBeat.o(4497);
    return str;
  }
  
  public static Status initialize(Context paramContext)
  {
    AppMethodBeat.i(4496);
    Preconditions.checkNotNull(paramContext, "Context must not be null.");
    synchronized (sLock)
    {
      if (zzku == null) {
        zzku = new GoogleServices(paramContext);
      }
      paramContext = zzku.zzkw;
      AppMethodBeat.o(4496);
      return paramContext;
    }
  }
  
  public static Status initialize(Context arg0, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(4494);
    Preconditions.checkNotNull(???, "Context must not be null.");
    Preconditions.checkNotEmpty(paramString, "App ID must be nonempty.");
    synchronized (sLock)
    {
      if (zzku != null)
      {
        paramString = zzku.checkGoogleAppId(paramString);
        AppMethodBeat.o(4494);
        return paramString;
      }
      paramString = new GoogleServices(paramString, paramBoolean);
      zzku = paramString;
      paramString = paramString.zzkw;
      AppMethodBeat.o(4494);
      return paramString;
    }
  }
  
  public static boolean isMeasurementEnabled()
  {
    AppMethodBeat.i(4498);
    GoogleServices localGoogleServices = checkInitialized("isMeasurementEnabled");
    if ((localGoogleServices.zzkw.isSuccess()) && (localGoogleServices.zzkx))
    {
      AppMethodBeat.o(4498);
      return true;
    }
    AppMethodBeat.o(4498);
    return false;
  }
  
  public static boolean isMeasurementExplicitlyDisabled()
  {
    AppMethodBeat.i(4499);
    boolean bool = checkInitialized("isMeasurementExplicitlyDisabled").zzky;
    AppMethodBeat.o(4499);
    return bool;
  }
  
  final Status checkGoogleAppId(String paramString)
  {
    AppMethodBeat.i(4495);
    if ((this.zzkv != null) && (!this.zzkv.equals(paramString)))
    {
      paramString = this.zzkv;
      paramString = new Status(10, String.valueOf(paramString).length() + 97 + "Initialize was called with two different Google App IDs.  Only the first app ID will be used: '" + paramString + "'.");
      AppMethodBeat.o(4495);
      return paramString;
    }
    paramString = Status.RESULT_SUCCESS;
    AppMethodBeat.o(4495);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.GoogleServices
 * JD-Core Version:    0.7.0.1
 */