package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Locale;

public final class zzfb
  extends zzhh
{
  private String zzadm;
  private String zzadt;
  private long zzadx;
  private int zzaen;
  private int zzaie;
  private long zzaif;
  private String zztg;
  private String zzth;
  private String zzti;
  
  zzfb(zzgl paramzzgl)
  {
    super(paramzzgl);
  }
  
  private final String zzgj()
  {
    AppMethodBeat.i(1301);
    zzab();
    if ((zzgg().zzay(this.zzti)) && (!this.zzacw.isEnabled()))
    {
      AppMethodBeat.o(1301);
      return null;
    }
    try
    {
      FirebaseInstanceId.wx().wy();
      String str = FirebaseInstanceId.zzf();
      AppMethodBeat.o(1301);
      return str;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      zzge().zzip().log("Failed to retrieve Firebase Instance Id");
      AppMethodBeat.o(1301);
    }
    return null;
  }
  
  final String getGmpAppId()
  {
    AppMethodBeat.i(1303);
    zzch();
    String str = this.zzadm;
    AppMethodBeat.o(1303);
    return str;
  }
  
  final String zzah()
  {
    AppMethodBeat.i(1302);
    zzch();
    String str = this.zzti;
    AppMethodBeat.o(1302);
    return str;
  }
  
  final zzdz zzbi(String paramString)
  {
    AppMethodBeat.i(1299);
    zzab();
    String str1 = zzah();
    String str2 = getGmpAppId();
    zzch();
    String str3 = this.zzth;
    long l1 = zzij();
    zzch();
    String str4 = this.zzadt;
    zzch();
    zzab();
    if (this.zzaif == 0L) {
      this.zzaif = this.zzacw.zzgb().zzd(getContext(), getContext().getPackageName());
    }
    long l2 = this.zzaif;
    boolean bool4 = this.zzacw.isEnabled();
    boolean bool1;
    String str5;
    long l3;
    int i;
    boolean bool2;
    if (!zzgf().zzakn)
    {
      bool1 = true;
      str5 = zzgj();
      zzch();
      l3 = this.zzacw.zzjt();
      i = zzik();
      Boolean localBoolean = zzgg().zzas("google_analytics_adid_collection_enabled");
      if ((localBoolean != null) && (!localBoolean.booleanValue())) {
        break label254;
      }
      bool2 = true;
      label169:
      localBoolean = zzgg().zzas("google_analytics_ssaid_collection_enabled");
      if ((localBoolean != null) && (!localBoolean.booleanValue())) {
        break label260;
      }
    }
    label260:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramString = new zzdz(str1, str2, str3, l1, str4, 12451L, l2, paramString, bool4, bool1, str5, 0L, l3, i, bool2, bool3, zzgf().zzje());
      AppMethodBeat.o(1299);
      return paramString;
      bool1 = false;
      break;
      label254:
      bool2 = false;
      break label169;
    }
  }
  
  protected final boolean zzhf()
  {
    return true;
  }
  
  protected final void zzih()
  {
    int j = 1;
    AppMethodBeat.i(1298);
    Object localObject3 = "unknown";
    String str3 = "Unknown";
    int k = -2147483648;
    String str1 = "Unknown";
    String str4 = getContext().getPackageName();
    Object localObject6 = getContext().getPackageManager();
    Object localObject5;
    String str2;
    int i;
    Object localObject1;
    if (localObject6 == null)
    {
      zzge().zzim().zzg("PackageManager is null, app identity information might be inaccurate. appId", zzfg.zzbm(str4));
      localObject5 = localObject3;
      str2 = str3;
      i = k;
      localObject3 = str1;
      this.zzti = str4;
      this.zzadt = ((String)localObject5);
      this.zzth = str2;
      this.zzaie = i;
      this.zztg = ((String)localObject3);
      this.zzaif = 0L;
      localObject1 = GoogleServices.initialize(getContext());
      if ((localObject1 == null) || (!((Status)localObject1).isSuccess())) {
        break label538;
      }
      i = 1;
      label135:
      if (i == 0)
      {
        if (localObject1 != null) {
          break label543;
        }
        zzge().zzim().log("GoogleService failed to initialize (no status)");
      }
      label157:
      if (i == 0) {
        break label692;
      }
      localObject1 = zzgg().zzas("firebase_analytics_collection_enabled");
      if (!zzgg().zzhg()) {
        break label572;
      }
      zzge().zzir().log("Collection disabled with firebase_analytics_collection_deactivated=1");
      i = 0;
    }
    label538:
    label543:
    label675:
    label680:
    label692:
    for (;;)
    {
      for (;;)
      {
        this.zzadm = "";
        this.zzadx = 0L;
        try
        {
          localObject3 = GoogleServices.getGoogleAppId();
          localObject1 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject1 = "";
          }
          this.zzadm = ((String)localObject1);
          if (i != 0) {
            zzge().zzit().zze("App package, google app id", this.zzti, this.zzadm);
          }
        }
        catch (IllegalStateException localIllegalStateException)
        {
          for (;;)
          {
            Object localObject2;
            zzge().zzim().zze("getGoogleAppId or isMeasurementEnabled failed with exception. appId", zzfg.zzbm(str4), localIllegalStateException);
            continue;
            i = 0;
          }
          this.zzaen = 0;
          AppMethodBeat.o(1298);
          return;
        }
        if (Build.VERSION.SDK_INT < 16) {
          break label680;
        }
        if (!InstantApps.isInstantApp(getContext())) {
          break label675;
        }
        i = j;
        this.zzaen = i;
        AppMethodBeat.o(1298);
        return;
        try
        {
          localObject1 = ((PackageManager)localObject6).getInstallerPackageName(str4);
          localObject3 = localObject1;
          if (localObject3 == null)
          {
            localObject1 = "manual_install";
            localObject5 = str1;
            str2 = str3;
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            try
            {
              PackageInfo localPackageInfo = ((PackageManager)localObject6).getPackageInfo(getContext().getPackageName(), 0);
              localObject3 = str1;
              i = k;
              str2 = str3;
              localObject5 = localObject1;
              if (localPackageInfo == null) {
                break;
              }
              localObject5 = str1;
              str2 = str3;
              localObject6 = ((PackageManager)localObject6).getApplicationLabel(localPackageInfo.applicationInfo);
              localObject3 = str1;
              localObject5 = str1;
              str2 = str3;
              if (!TextUtils.isEmpty((CharSequence)localObject6))
              {
                localObject5 = str1;
                str2 = str3;
                localObject3 = ((CharSequence)localObject6).toString();
              }
              localObject5 = localObject3;
              str2 = str3;
              str1 = localPackageInfo.versionName;
              localObject5 = localObject3;
              str2 = str1;
              i = localPackageInfo.versionCode;
              str2 = str1;
              localObject5 = localObject1;
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException)
            {
              zzge().zzim().zze("Error retrieving package info. appId, appName", zzfg.zzbm(str4), localObject5);
              Object localObject4 = localObject5;
              i = k;
              localObject5 = localObject2;
            }
            localIllegalArgumentException = localIllegalArgumentException;
            zzge().zzim().zzg("Error retrieving app installer package name. appId", zzfg.zzbm(str4));
            continue;
            localObject2 = localObject3;
            if ("com.android.vending".equals(localObject3)) {
              localObject2 = "";
            }
          }
        }
      }
      break;
      i = 0;
      break label135;
      zzge().zzim().zze("GoogleService failed to initialize, status", Integer.valueOf(((Status)localObject2).getStatusCode()), ((Status)localObject2).getStatusMessage());
      break label157;
      label572:
      if ((localObject2 != null) && (!((Boolean)localObject2).booleanValue()))
      {
        zzge().zzir().log("Collection disabled with firebase_analytics_collection_enabled=0");
        i = 0;
      }
      else if ((localObject2 == null) && (GoogleServices.isMeasurementExplicitlyDisabled()))
      {
        zzge().zzir().log("Collection disabled with google_app_measurement_enable=0");
        i = 0;
      }
      else
      {
        zzge().zzit().log("Collection enabled");
        i = 1;
        continue;
        i = 0;
      }
    }
  }
  
  final String zzii()
  {
    AppMethodBeat.i(1300);
    Object localObject = new byte[16];
    zzgb().zzlc().nextBytes((byte[])localObject);
    localObject = String.format(Locale.US, "%032x", new Object[] { new BigInteger(1, (byte[])localObject) });
    AppMethodBeat.o(1300);
    return localObject;
  }
  
  final int zzij()
  {
    AppMethodBeat.i(1304);
    zzch();
    int i = this.zzaie;
    AppMethodBeat.o(1304);
    return i;
  }
  
  final int zzik()
  {
    AppMethodBeat.i(1305);
    zzch();
    int i = this.zzaen;
    AppMethodBeat.o(1305);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfb
 * JD-Core Version:    0.7.0.1
 */