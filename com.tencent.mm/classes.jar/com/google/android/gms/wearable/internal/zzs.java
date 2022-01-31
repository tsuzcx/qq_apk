package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

public final class zzs
  extends zza
{
  public static final Parcelable.Creator<zzs> CREATOR = new zzt();
  final int type;
  final int zzbTY;
  final int zzbTZ;
  final zzu zzbUa;
  
  public zzs(zzu paramzzu, int paramInt1, int paramInt2, int paramInt3)
  {
    this.zzbUa = paramzzu;
    this.type = paramInt1;
    this.zzbTY = paramInt2;
    this.zzbTZ = paramInt3;
  }
  
  private static String zzpr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Integer.toString(paramInt);
    case 1: 
      return "CHANNEL_OPENED";
    case 2: 
      return "CHANNEL_CLOSED";
    case 4: 
      return "OUTPUT_CLOSED";
    }
    return "INPUT_CLOSED";
  }
  
  private static String zzps(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Integer.toString(paramInt);
    case 1: 
      return "CLOSE_REASON_DISCONNECTED";
    case 2: 
      return "CLOSE_REASON_REMOTE_CLOSE";
    case 3: 
      return "CLOSE_REASON_LOCAL_CLOSE";
    }
    return "CLOSE_REASON_NORMAL";
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(this.zzbUa);
    String str2 = String.valueOf(zzpr(this.type));
    String str3 = String.valueOf(zzps(this.zzbTY));
    int i = this.zzbTZ;
    return String.valueOf(str1).length() + 81 + String.valueOf(str2).length() + String.valueOf(str3).length() + "ChannelEventParcelable[, channel=" + str1 + ", type=" + str2 + ", closeReason=" + str3 + ", appErrorCode=" + i + "]";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzt.zza(this, paramParcel, paramInt);
  }
  
  public final void zza(ChannelApi.ChannelListener paramChannelListener)
  {
    switch (this.type)
    {
    default: 
      int i = this.type;
      new StringBuilder(25).append("Unknown type: ").append(i);
      return;
    case 1: 
      paramChannelListener.onChannelOpened(this.zzbUa);
      return;
    case 2: 
      paramChannelListener.onChannelClosed(this.zzbUa, this.zzbTY, this.zzbTZ);
      return;
    case 3: 
      paramChannelListener.onInputClosed(this.zzbUa, this.zzbTY, this.zzbTZ);
      return;
    }
    paramChannelListener.onOutputClosed(this.zzbUa, this.zzbTY, this.zzbTZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzs
 * JD-Core Version:    0.7.0.1
 */