package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ConnectionResult
  extends AbstractSafeParcelable
{
  public static final int API_UNAVAILABLE = 16;
  public static final int API_VERSION_UPDATE_REQUIRED = 21;
  public static final int CANCELED = 13;
  public static final Parcelable.Creator<ConnectionResult> CREATOR;
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
  public static final ConnectionResult RESULT_SUCCESS;
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
  public static final int UNFINISHED = 99;
  public static final int UNKNOWN = -1;
  private final int zzal;
  private final int zzam;
  private final PendingIntent zzan;
  private final String zzao;
  
  static
  {
    AppMethodBeat.i(4370);
    RESULT_SUCCESS = new ConnectionResult(0);
    CREATOR = new ConnectionResultCreator();
    AppMethodBeat.o(4370);
  }
  
  public ConnectionResult(int paramInt)
  {
    this(paramInt, null, null);
  }
  
  ConnectionResult(int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString)
  {
    this.zzal = paramInt1;
    this.zzam = paramInt2;
    this.zzan = paramPendingIntent;
    this.zzao = paramString;
  }
  
  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramPendingIntent, null);
  }
  
  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent, String paramString)
  {
    this(1, paramInt, paramPendingIntent, paramString);
  }
  
  static String zza(int paramInt)
  {
    AppMethodBeat.i(4365);
    switch (paramInt)
    {
    default: 
      String str = 31 + "UNKNOWN_ERROR_CODE(" + paramInt + ")";
      AppMethodBeat.o(4365);
      return str;
    case 0: 
      AppMethodBeat.o(4365);
      return "SUCCESS";
    case 1: 
      AppMethodBeat.o(4365);
      return "SERVICE_MISSING";
    case 2: 
      AppMethodBeat.o(4365);
      return "SERVICE_VERSION_UPDATE_REQUIRED";
    case 3: 
      AppMethodBeat.o(4365);
      return "SERVICE_DISABLED";
    case 4: 
      AppMethodBeat.o(4365);
      return "SIGN_IN_REQUIRED";
    case 5: 
      AppMethodBeat.o(4365);
      return "INVALID_ACCOUNT";
    case 6: 
      AppMethodBeat.o(4365);
      return "RESOLUTION_REQUIRED";
    case 7: 
      AppMethodBeat.o(4365);
      return "NETWORK_ERROR";
    case 8: 
      AppMethodBeat.o(4365);
      return "INTERNAL_ERROR";
    case 9: 
      AppMethodBeat.o(4365);
      return "SERVICE_INVALID";
    case 10: 
      AppMethodBeat.o(4365);
      return "DEVELOPER_ERROR";
    case 11: 
      AppMethodBeat.o(4365);
      return "LICENSE_CHECK_FAILED";
    case 13: 
      AppMethodBeat.o(4365);
      return "CANCELED";
    case 14: 
      AppMethodBeat.o(4365);
      return "TIMEOUT";
    case 15: 
      AppMethodBeat.o(4365);
      return "INTERRUPTED";
    case 16: 
      AppMethodBeat.o(4365);
      return "API_UNAVAILABLE";
    case 17: 
      AppMethodBeat.o(4365);
      return "SIGN_IN_FAILED";
    case 18: 
      AppMethodBeat.o(4365);
      return "SERVICE_UPDATING";
    case 19: 
      AppMethodBeat.o(4365);
      return "SERVICE_MISSING_PERMISSION";
    case 20: 
      AppMethodBeat.o(4365);
      return "RESTRICTED_PROFILE";
    case 21: 
      AppMethodBeat.o(4365);
      return "API_VERSION_UPDATE_REQUIRED";
    case 1500: 
      AppMethodBeat.o(4365);
      return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
    case 99: 
      AppMethodBeat.o(4365);
      return "UNFINISHED";
    }
    AppMethodBeat.o(4365);
    return "UNKNOWN";
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(4366);
    if (paramObject == this)
    {
      AppMethodBeat.o(4366);
      return true;
    }
    if (!(paramObject instanceof ConnectionResult))
    {
      AppMethodBeat.o(4366);
      return false;
    }
    paramObject = (ConnectionResult)paramObject;
    if ((this.zzam == paramObject.zzam) && (Objects.equal(this.zzan, paramObject.zzan)) && (Objects.equal(this.zzao, paramObject.zzao)))
    {
      AppMethodBeat.o(4366);
      return true;
    }
    AppMethodBeat.o(4366);
    return false;
  }
  
  public final int getErrorCode()
  {
    return this.zzam;
  }
  
  public final String getErrorMessage()
  {
    return this.zzao;
  }
  
  public final PendingIntent getResolution()
  {
    return this.zzan;
  }
  
  public final boolean hasResolution()
  {
    return (this.zzam != 0) && (this.zzan != null);
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(4367);
    int i = Objects.hashCode(new Object[] { Integer.valueOf(this.zzam), this.zzan, this.zzao });
    AppMethodBeat.o(4367);
    return i;
  }
  
  public final boolean isSuccess()
  {
    return this.zzam == 0;
  }
  
  public final void startResolutionForResult(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(4364);
    if (!hasResolution())
    {
      AppMethodBeat.o(4364);
      return;
    }
    paramActivity.startIntentSenderForResult(this.zzan.getIntentSender(), paramInt, null, 0, 0, 0);
    AppMethodBeat.o(4364);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(4368);
    String str = Objects.toStringHelper(this).add("statusCode", zza(this.zzam)).add("resolution", this.zzan).add("message", this.zzao).toString();
    AppMethodBeat.o(4368);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4369);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeInt(paramParcel, 2, getErrorCode());
    SafeParcelWriter.writeParcelable(paramParcel, 3, getResolution(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 4, getErrorMessage(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(4369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.ConnectionResult
 * JD-Core Version:    0.7.0.1
 */