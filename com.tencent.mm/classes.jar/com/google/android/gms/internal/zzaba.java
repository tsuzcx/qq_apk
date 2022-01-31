package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.R.string;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzam;
import com.google.android.gms.common.internal.zzz;

@Deprecated
public final class zzaba
{
  private static zzaba zzaCM;
  private static final Object zztX = new Object();
  private final String mAppId;
  private final Status zzaCN;
  private final boolean zzaCO;
  private final boolean zzaCP;
  
  zzaba(Context paramContext)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getIdentifier("google_app_measurement_enable", "integer", ((Resources)localObject).getResourcePackageName(R.string.common_google_play_services_unknown_issue));
    if (i != 0) {
      if (((Resources)localObject).getInteger(i) != 0)
      {
        bool1 = true;
        if (bool1) {
          break label127;
        }
      }
    }
    label52:
    for (this.zzaCP = bool2;; this.zzaCP = false)
    {
      this.zzaCO = bool1;
      String str = zzz.zzaV(paramContext);
      localObject = str;
      if (str == null) {
        localObject = new zzam(paramContext).getString("google_app_id");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label141;
      }
      this.zzaCN = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
      this.mAppId = null;
      return;
      bool1 = false;
      break;
      label127:
      bool2 = false;
      break label52;
    }
    label141:
    this.mAppId = ((String)localObject);
    this.zzaCN = Status.zzazx;
  }
  
  public static Status zzaQ(Context paramContext)
  {
    zzac.zzb(paramContext, "Context must not be null.");
    synchronized (zztX)
    {
      if (zzaCM == null) {
        zzaCM = new zzaba(paramContext);
      }
      paramContext = zzaCM.zzaCN;
      return paramContext;
    }
  }
  
  private static zzaba zzde(String paramString)
  {
    synchronized (zztX)
    {
      if (zzaCM == null) {
        throw new IllegalStateException(String.valueOf(paramString).length() + 34 + "Initialize must be called before " + paramString + ".");
      }
    }
    paramString = zzaCM;
    return paramString;
  }
  
  public static String zzwQ()
  {
    return zzde("getGoogleAppId").mAppId;
  }
  
  public static boolean zzwR()
  {
    return zzde("isMeasurementExplicitlyDisabled").zzaCP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzaba
 * JD-Core Version:    0.7.0.1
 */