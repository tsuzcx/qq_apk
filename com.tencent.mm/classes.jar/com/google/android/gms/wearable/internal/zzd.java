package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator="AddListenerRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzd
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzd> CREATOR;
  @SafeParcelable.Field(getter="getListenerAsBinder", id=2, type="android.os.IBinder")
  private final zzem zzaz;
  @SafeParcelable.Field(id=3)
  private final IntentFilter[] zzba;
  @Nullable
  @SafeParcelable.Field(id=4)
  private final String zzbb;
  @Nullable
  @SafeParcelable.Field(id=5)
  private final String zzbc;
  
  static
  {
    AppMethodBeat.i(101169);
    CREATOR = new zze();
    AppMethodBeat.o(101169);
  }
  
  @SafeParcelable.Constructor
  zzd(@SafeParcelable.Param(id=2) IBinder paramIBinder, @SafeParcelable.Param(id=3) IntentFilter[] paramArrayOfIntentFilter, @SafeParcelable.Param(id=4) @Nullable String paramString1, @SafeParcelable.Param(id=5) @Nullable String paramString2)
  {
    AppMethodBeat.i(101166);
    if (paramIBinder != null) {
      if (paramIBinder == null) {
        paramIBinder = localIInterface;
      }
    }
    for (this.zzaz = paramIBinder;; this.zzaz = null)
    {
      this.zzba = paramArrayOfIntentFilter;
      this.zzbb = paramString1;
      this.zzbc = paramString2;
      AppMethodBeat.o(101166);
      return;
      localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
      if ((localIInterface instanceof zzem))
      {
        paramIBinder = (zzem)localIInterface;
        break;
      }
      paramIBinder = new zzeo(paramIBinder);
      break;
    }
  }
  
  public zzd(zzhk paramzzhk)
  {
    AppMethodBeat.i(101167);
    this.zzaz = paramzzhk;
    this.zzba = paramzzhk.zze();
    this.zzbb = paramzzhk.zzf();
    this.zzbc = null;
    AppMethodBeat.o(101167);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101168);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    if (this.zzaz == null) {}
    for (IBinder localIBinder = null;; localIBinder = this.zzaz.asBinder())
    {
      SafeParcelWriter.writeIBinder(paramParcel, 2, localIBinder, false);
      SafeParcelWriter.writeTypedArray(paramParcel, 3, this.zzba, paramInt, false);
      SafeParcelWriter.writeString(paramParcel, 4, this.zzbb, false);
      SafeParcelWriter.writeString(paramParcel, 5, this.zzbc, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
      AppMethodBeat.o(101168);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzd
 * JD-Core Version:    0.7.0.1
 */