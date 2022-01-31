package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="ConnectionResultCreator")
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
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  @SafeParcelable.Field(getter="getErrorCode", id=2)
  private final int zzam;
  @SafeParcelable.Field(getter="getResolution", id=3)
  private final PendingIntent zzan;
  @SafeParcelable.Field(getter="getErrorMessage", id=4)
  private final String zzao;
  
  static
  {
    AppMethodBeat.i(89348);
    RESULT_SUCCESS = new ConnectionResult(0);
    CREATOR = new ConnectionResultCreator();
    AppMethodBeat.o(89348);
  }
  
  public ConnectionResult(int paramInt)
  {
    this(paramInt, null, null);
  }
  
  @SafeParcelable.Constructor
  ConnectionResult(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) PendingIntent paramPendingIntent, @SafeParcelable.Param(id=4) String paramString)
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
    AppMethodBeat.i(89343);
    switch (paramInt)
    {
    default: 
      String str = 31 + "UNKNOWN_ERROR_CODE(" + paramInt + ")";
      AppMethodBeat.o(89343);
      return str;
    case 0: 
      AppMethodBeat.o(89343);
      return "SUCCESS";
    case 1: 
      AppMethodBeat.o(89343);
      return "SERVICE_MISSING";
    case 2: 
      AppMethodBeat.o(89343);
      return "SERVICE_VERSION_UPDATE_REQUIRED";
    case 3: 
      AppMethodBeat.o(89343);
      return "SERVICE_DISABLED";
    case 4: 
      AppMethodBeat.o(89343);
      return "SIGN_IN_REQUIRED";
    case 5: 
      AppMethodBeat.o(89343);
      return "INVALID_ACCOUNT";
    case 6: 
      AppMethodBeat.o(89343);
      return "RESOLUTION_REQUIRED";
    case 7: 
      AppMethodBeat.o(89343);
      return "NETWORK_ERROR";
    case 8: 
      AppMethodBeat.o(89343);
      return "INTERNAL_ERROR";
    case 9: 
      AppMethodBeat.o(89343);
      return "SERVICE_INVALID";
    case 10: 
      AppMethodBeat.o(89343);
      return "DEVELOPER_ERROR";
    case 11: 
      AppMethodBeat.o(89343);
      return "LICENSE_CHECK_FAILED";
    case 13: 
      AppMethodBeat.o(89343);
      return "CANCELED";
    case 14: 
      AppMethodBeat.o(89343);
      return "TIMEOUT";
    case 15: 
      AppMethodBeat.o(89343);
      return "INTERRUPTED";
    case 16: 
      AppMethodBeat.o(89343);
      return "API_UNAVAILABLE";
    case 17: 
      AppMethodBeat.o(89343);
      return "SIGN_IN_FAILED";
    case 18: 
      AppMethodBeat.o(89343);
      return "SERVICE_UPDATING";
    case 19: 
      AppMethodBeat.o(89343);
      return "SERVICE_MISSING_PERMISSION";
    case 20: 
      AppMethodBeat.o(89343);
      return "RESTRICTED_PROFILE";
    case 21: 
      AppMethodBeat.o(89343);
      return "API_VERSION_UPDATE_REQUIRED";
    case 1500: 
      AppMethodBeat.o(89343);
      return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
    case 99: 
      AppMethodBeat.o(89343);
      return "UNFINISHED";
    }
    AppMethodBeat.o(89343);
    return "UNKNOWN";
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(89344);
    if (paramObject == this)
    {
      AppMethodBeat.o(89344);
      return true;
    }
    if (!(paramObject instanceof ConnectionResult))
    {
      AppMethodBeat.o(89344);
      return false;
    }
    paramObject = (ConnectionResult)paramObject;
    if ((this.zzam == paramObject.zzam) && (Objects.equal(this.zzan, paramObject.zzan)) && (Objects.equal(this.zzao, paramObject.zzao)))
    {
      AppMethodBeat.o(89344);
      return true;
    }
    AppMethodBeat.o(89344);
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
    AppMethodBeat.i(89345);
    int i = Objects.hashCode(new Object[] { Integer.valueOf(this.zzam), this.zzan, this.zzao });
    AppMethodBeat.o(89345);
    return i;
  }
  
  public final boolean isSuccess()
  {
    return this.zzam == 0;
  }
  
  public final void startResolutionForResult(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(89342);
    if (!hasResolution())
    {
      AppMethodBeat.o(89342);
      return;
    }
    paramActivity.startIntentSenderForResult(this.zzan.getIntentSender(), paramInt, null, 0, 0, 0);
    AppMethodBeat.o(89342);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(89346);
    String str = Objects.toStringHelper(this).add("statusCode", zza(this.zzam)).add("resolution", this.zzan).add("message", this.zzao).toString();
    AppMethodBeat.o(89346);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89347);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeInt(paramParcel, 2, getErrorCode());
    SafeParcelWriter.writeParcelable(paramParcel, 3, getResolution(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 4, getErrorMessage(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(89347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.ConnectionResult
 * JD-Core Version:    0.7.0.1
 */