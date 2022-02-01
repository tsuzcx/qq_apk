package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Status
  extends AbstractSafeParcelable
  implements Result, ReflectedParcelable
{
  public static final Parcelable.Creator<Status> CREATOR;
  public static final Status RESULT_CANCELED;
  public static final Status RESULT_DEAD_CLIENT;
  public static final Status RESULT_INTERNAL_ERROR;
  public static final Status RESULT_INTERRUPTED;
  public static final Status RESULT_SUCCESS;
  public static final Status RESULT_TIMEOUT;
  private static final Status zzdq;
  private final int zzal;
  private final int zzam;
  private final PendingIntent zzan;
  private final String zzao;
  
  static
  {
    AppMethodBeat.i(4480);
    RESULT_SUCCESS = new Status(0);
    RESULT_INTERRUPTED = new Status(14);
    RESULT_INTERNAL_ERROR = new Status(8);
    RESULT_TIMEOUT = new Status(15);
    RESULT_CANCELED = new Status(16);
    zzdq = new Status(17);
    RESULT_DEAD_CLIENT = new Status(18);
    CREATOR = new zze();
    AppMethodBeat.o(4480);
  }
  
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.zzal = paramInt1;
    this.zzam = paramInt2;
    this.zzao = paramString;
    this.zzan = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString)
  {
    this(1, paramInt, paramString, null);
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(4476);
    if (!(paramObject instanceof Status))
    {
      AppMethodBeat.o(4476);
      return false;
    }
    paramObject = (Status)paramObject;
    if ((this.zzal == paramObject.zzal) && (this.zzam == paramObject.zzam) && (Objects.equal(this.zzao, paramObject.zzao)) && (Objects.equal(this.zzan, paramObject.zzan)))
    {
      AppMethodBeat.o(4476);
      return true;
    }
    AppMethodBeat.o(4476);
    return false;
  }
  
  public final PendingIntent getResolution()
  {
    return this.zzan;
  }
  
  public final Status getStatus()
  {
    return this;
  }
  
  public final int getStatusCode()
  {
    return this.zzam;
  }
  
  public final String getStatusMessage()
  {
    return this.zzao;
  }
  
  public final boolean hasResolution()
  {
    return this.zzan != null;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(4475);
    int i = Objects.hashCode(new Object[] { Integer.valueOf(this.zzal), Integer.valueOf(this.zzam), this.zzao, this.zzan });
    AppMethodBeat.o(4475);
    return i;
  }
  
  public final boolean isCanceled()
  {
    return this.zzam == 16;
  }
  
  public final boolean isInterrupted()
  {
    return this.zzam == 14;
  }
  
  public final boolean isSuccess()
  {
    return this.zzam <= 0;
  }
  
  public final void startResolutionForResult(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(4474);
    if (!hasResolution())
    {
      AppMethodBeat.o(4474);
      return;
    }
    paramActivity.startIntentSenderForResult(this.zzan.getIntentSender(), paramInt, null, 0, 0, 0);
    AppMethodBeat.o(4474);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(4478);
    String str = Objects.toStringHelper(this).add("statusCode", zzp()).add("resolution", this.zzan).toString();
    AppMethodBeat.o(4478);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4479);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getStatusCode());
    SafeParcelWriter.writeString(paramParcel, 2, getStatusMessage(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzan, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.zzal);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(4479);
  }
  
  public final String zzp()
  {
    AppMethodBeat.i(4477);
    if (this.zzao != null)
    {
      str = this.zzao;
      AppMethodBeat.o(4477);
      return str;
    }
    String str = CommonStatusCodes.getStatusCodeString(this.zzam);
    AppMethodBeat.o(4477);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.Status
 * JD-Core Version:    0.7.0.1
 */