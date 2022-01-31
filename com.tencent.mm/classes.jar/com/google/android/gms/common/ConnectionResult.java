package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;

public final class ConnectionResult
  extends zza
{
  public static final int API_UNAVAILABLE = 16;
  public static final int CANCELED = 13;
  public static final Parcelable.Creator<ConnectionResult> CREATOR = new zzb();
  public static final int DEVELOPER_ERROR = 10;
  @Deprecated
  public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
  public static final int INTERNAL_ERROR = 8;
  public static final int INTERRUPTED = 15;
  public static final int INVALID_ACCOUNT = 5;
  public static final int LICENSE_CHECK_FAILED = 11;
  public static final int NETWORK_ERROR = 7;
  public static final int RESOLUTION_REQUIRED = 6;
  public static final int RESTRICTED_PROFILE = 20;
  public static final int SERVICE_DISABLED = 3;
  public static final int SERVICE_INVALID = 9;
  public static final int SERVICE_MISSING = 1;
  public static final int SERVICE_MISSING_PERMISSION = 19;
  public static final int SERVICE_UPDATING = 18;
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  public static final int SIGN_IN_FAILED = 17;
  public static final int SIGN_IN_REQUIRED = 4;
  public static final int SUCCESS = 0;
  public static final int TIMEOUT = 14;
  public static final ConnectionResult zzayj = new ConnectionResult(0);
  private final PendingIntent mPendingIntent;
  final int zzaiI;
  private final int zzavD;
  private final String zzayk;
  
  public ConnectionResult(int paramInt)
  {
    this(paramInt, null, null);
  }
  
  ConnectionResult(int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString)
  {
    this.zzaiI = paramInt1;
    this.zzavD = paramInt2;
    this.mPendingIntent = paramPendingIntent;
    this.zzayk = paramString;
  }
  
  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramPendingIntent, null);
  }
  
  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent, String paramString)
  {
    this(1, paramInt, paramPendingIntent, paramString);
  }
  
  static String getStatusString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 31 + "UNKNOWN_ERROR_CODE(" + paramInt + ")";
    case 0: 
      return "SUCCESS";
    case 1: 
      return "SERVICE_MISSING";
    case 2: 
      return "SERVICE_VERSION_UPDATE_REQUIRED";
    case 3: 
      return "SERVICE_DISABLED";
    case 4: 
      return "SIGN_IN_REQUIRED";
    case 5: 
      return "INVALID_ACCOUNT";
    case 6: 
      return "RESOLUTION_REQUIRED";
    case 7: 
      return "NETWORK_ERROR";
    case 8: 
      return "INTERNAL_ERROR";
    case 9: 
      return "SERVICE_INVALID";
    case 10: 
      return "DEVELOPER_ERROR";
    case 11: 
      return "LICENSE_CHECK_FAILED";
    case 13: 
      return "CANCELED";
    case 14: 
      return "TIMEOUT";
    case 15: 
      return "INTERRUPTED";
    case 16: 
      return "API_UNAVAILABLE";
    case 17: 
      return "SIGN_IN_FAILED";
    case 18: 
      return "SERVICE_UPDATING";
    case 19: 
      return "SERVICE_MISSING_PERMISSION";
    case 20: 
      return "RESTRICTED_PROFILE";
    case 21: 
      return "API_VERSION_UPDATE_REQUIRED";
    case 1500: 
      return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
    case 99: 
      return "UNFINISHED";
    }
    return "UNKNOWN";
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ConnectionResult)) {
        return false;
      }
      paramObject = (ConnectionResult)paramObject;
    } while ((this.zzavD == paramObject.zzavD) && (zzaa.equal(this.mPendingIntent, paramObject.mPendingIntent)) && (zzaa.equal(this.zzayk, paramObject.zzayk)));
    return false;
  }
  
  public final int getErrorCode()
  {
    return this.zzavD;
  }
  
  public final String getErrorMessage()
  {
    return this.zzayk;
  }
  
  public final PendingIntent getResolution()
  {
    return this.mPendingIntent;
  }
  
  public final boolean hasResolution()
  {
    return (this.zzavD != 0) && (this.mPendingIntent != null);
  }
  
  public final int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(this.zzavD), this.mPendingIntent, this.zzayk });
  }
  
  public final boolean isSuccess()
  {
    return this.zzavD == 0;
  }
  
  public final void startResolutionForResult(Activity paramActivity, int paramInt)
  {
    if (!hasResolution()) {
      return;
    }
    paramActivity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public final String toString()
  {
    return zzaa.zzv(this).zzg("statusCode", getStatusString(this.zzavD)).zzg("resolution", this.mPendingIntent).zzg("message", this.zzayk).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.ConnectionResult
 * JD-Core Version:    0.7.0.1
 */