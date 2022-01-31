package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;

public final class Status
  extends zza
  implements Result, ReflectedParcelable
{
  public static final Parcelable.Creator<Status> CREATOR = new zzh();
  public static final Status zzazA;
  public static final Status zzazB;
  public static final Status zzazC;
  public static final Status zzazD;
  public static final Status zzazx = new Status(0);
  public static final Status zzazy = new Status(14);
  public static final Status zzazz = new Status(8);
  private final PendingIntent mPendingIntent;
  final int zzaiI;
  private final int zzavD;
  private final String zzayk;
  
  static
  {
    zzazA = new Status(15);
    zzazB = new Status(16);
    zzazC = new Status(17);
    zzazD = new Status(18);
  }
  
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.zzaiI = paramInt1;
    this.zzavD = paramInt2;
    this.zzayk = paramString;
    this.mPendingIntent = paramPendingIntent;
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
    if (!(paramObject instanceof Status)) {}
    do
    {
      return false;
      paramObject = (Status)paramObject;
    } while ((this.zzaiI != paramObject.zzaiI) || (this.zzavD != paramObject.zzavD) || (!zzaa.equal(this.zzayk, paramObject.zzayk)) || (!zzaa.equal(this.mPendingIntent, paramObject.mPendingIntent)));
    return true;
  }
  
  public final PendingIntent getResolution()
  {
    return this.mPendingIntent;
  }
  
  public final Status getStatus()
  {
    return this;
  }
  
  public final int getStatusCode()
  {
    return this.zzavD;
  }
  
  public final String getStatusMessage()
  {
    return this.zzayk;
  }
  
  public final boolean hasResolution()
  {
    return this.mPendingIntent != null;
  }
  
  public final int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(this.zzaiI), Integer.valueOf(this.zzavD), this.zzayk, this.mPendingIntent });
  }
  
  public final boolean isCanceled()
  {
    return this.zzavD == 16;
  }
  
  public final boolean isInterrupted()
  {
    return this.zzavD == 14;
  }
  
  public final boolean isSuccess()
  {
    return this.zzavD <= 0;
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
    return zzaa.zzv(this).zzg("statusCode", zzvv()).zzg("resolution", this.mPendingIntent).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  final PendingIntent zzvu()
  {
    return this.mPendingIntent;
  }
  
  public final String zzvv()
  {
    if (this.zzayk != null) {
      return this.zzayk;
    }
    return CommonStatusCodes.getStatusCodeString(this.zzavD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.api.Status
 * JD-Core Version:    0.7.0.1
 */