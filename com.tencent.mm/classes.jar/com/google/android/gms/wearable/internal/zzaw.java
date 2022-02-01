package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="ChannelEventParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zzaw
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzaw> CREATOR;
  @SafeParcelable.Field(id=3)
  private final int type;
  @SafeParcelable.Field(id=5)
  private final int zzcj;
  @SafeParcelable.Field(id=2)
  private final zzay zzck;
  @SafeParcelable.Field(id=4)
  private final int zzg;
  
  static
  {
    AppMethodBeat.i(101024);
    CREATOR = new zzax();
    AppMethodBeat.o(101024);
  }
  
  @SafeParcelable.Constructor
  public zzaw(@SafeParcelable.Param(id=2) zzay paramzzay, @SafeParcelable.Param(id=3) int paramInt1, @SafeParcelable.Param(id=4) int paramInt2, @SafeParcelable.Param(id=5) int paramInt3)
  {
    this.zzck = paramzzay;
    this.type = paramInt1;
    this.zzg = paramInt2;
    this.zzcj = paramInt3;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(101023);
    String str3 = String.valueOf(this.zzck);
    int i = this.type;
    String str1;
    String str2;
    switch (i)
    {
    default: 
      str1 = Integer.toString(i);
      i = this.zzg;
      switch (i)
      {
      default: 
        str2 = Integer.toString(i);
      }
      break;
    }
    for (;;)
    {
      i = this.zzcj;
      str1 = String.valueOf(str3).length() + 81 + String.valueOf(str1).length() + String.valueOf(str2).length() + "ChannelEventParcelable[, channel=" + str3 + ", type=" + str1 + ", closeReason=" + str2 + ", appErrorCode=" + i + "]";
      AppMethodBeat.o(101023);
      return str1;
      str1 = "CHANNEL_OPENED";
      break;
      str1 = "CHANNEL_CLOSED";
      break;
      str1 = "OUTPUT_CLOSED";
      break;
      str1 = "INPUT_CLOSED";
      break;
      str2 = "CLOSE_REASON_DISCONNECTED";
      continue;
      str2 = "CLOSE_REASON_REMOTE_CLOSE";
      continue;
      str2 = "CLOSE_REASON_LOCAL_CLOSE";
      continue;
      str2 = "CLOSE_REASON_NORMAL";
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101022);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzck, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.type);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzg);
    SafeParcelWriter.writeInt(paramParcel, 5, this.zzcj);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(101022);
  }
  
  public final void zza(ChannelApi.ChannelListener paramChannelListener)
  {
    AppMethodBeat.i(101021);
    switch (this.type)
    {
    default: 
      int i = this.type;
      new StringBuilder(25).append("Unknown type: ").append(i);
      AppMethodBeat.o(101021);
      return;
    case 1: 
      paramChannelListener.onChannelOpened(this.zzck);
      AppMethodBeat.o(101021);
      return;
    case 2: 
      paramChannelListener.onChannelClosed(this.zzck, this.zzg, this.zzcj);
      AppMethodBeat.o(101021);
      return;
    case 3: 
      paramChannelListener.onInputClosed(this.zzck, this.zzg, this.zzcj);
      AppMethodBeat.o(101021);
      return;
    }
    paramChannelListener.onOutputClosed(this.zzck, this.zzg, this.zzcj);
    AppMethodBeat.o(101021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzaw
 * JD-Core Version:    0.7.0.1
 */