package com.google.android.gms.iid;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class MessengerCompat
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<MessengerCompat> CREATOR = new MessengerCompat.1();
  Messenger zzbhU;
  zzb zzbhV;
  
  public MessengerCompat(Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.zzbhU = new Messenger(paramHandler);
      return;
    }
    this.zzbhV = new MessengerCompat.zza(this, paramHandler);
  }
  
  public MessengerCompat(IBinder paramIBinder)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.zzbhU = new Messenger(paramIBinder);
      return;
    }
    this.zzbhV = zzb.zza.zzcZ(paramIBinder);
  }
  
  public static int zzc(Message paramMessage)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return zzd(paramMessage);
    }
    return paramMessage.arg2;
  }
  
  @TargetApi(21)
  private static int zzd(Message paramMessage)
  {
    return paramMessage.sendingUid;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      boolean bool = getBinder().equals(((MessengerCompat)paramObject).getBinder());
      return bool;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public IBinder getBinder()
  {
    if (this.zzbhU != null) {
      return this.zzbhU.getBinder();
    }
    return this.zzbhV.asBinder();
  }
  
  public int hashCode()
  {
    return getBinder().hashCode();
  }
  
  public void send(Message paramMessage)
  {
    if (this.zzbhU != null)
    {
      this.zzbhU.send(paramMessage);
      return;
    }
    this.zzbhV.send(paramMessage);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.zzbhU != null)
    {
      paramParcel.writeStrongBinder(this.zzbhU.getBinder());
      return;
    }
    paramParcel.writeStrongBinder(this.zzbhV.asBinder());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.iid.MessengerCompat
 * JD-Core Version:    0.7.0.1
 */