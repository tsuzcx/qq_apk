package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.wearable.zza;
import com.google.android.gms.internal.wearable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class zzeo
  extends zza
  implements zzem
{
  zzeo(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.wearable.internal.IWearableListener");
  }
  
  public final void onConnectedNodes(List<zzfo> paramList)
  {
    AppMethodBeat.i(71252);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeTypedList(paramList);
    transactOneway(5, localParcel);
    AppMethodBeat.o(71252);
  }
  
  public final void zza(DataHolder paramDataHolder)
  {
    AppMethodBeat.i(71248);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramDataHolder);
    transactOneway(1, localParcel);
    AppMethodBeat.o(71248);
  }
  
  public final void zza(zzah paramzzah)
  {
    AppMethodBeat.i(71255);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzah);
    transactOneway(8, localParcel);
    AppMethodBeat.o(71255);
  }
  
  public final void zza(zzaw paramzzaw)
  {
    AppMethodBeat.i(71254);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzaw);
    transactOneway(7, localParcel);
    AppMethodBeat.o(71254);
  }
  
  public final void zza(zzfe paramzzfe)
  {
    AppMethodBeat.i(71249);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzfe);
    transactOneway(2, localParcel);
    AppMethodBeat.o(71249);
  }
  
  public final void zza(zzfo paramzzfo)
  {
    AppMethodBeat.i(71250);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzfo);
    transactOneway(3, localParcel);
    AppMethodBeat.o(71250);
  }
  
  public final void zza(zzi paramzzi)
  {
    AppMethodBeat.i(71256);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzi);
    transactOneway(9, localParcel);
    AppMethodBeat.o(71256);
  }
  
  public final void zza(zzl paramzzl)
  {
    AppMethodBeat.i(71253);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzl);
    transactOneway(6, localParcel);
    AppMethodBeat.o(71253);
  }
  
  public final void zzb(zzfo paramzzfo)
  {
    AppMethodBeat.i(71251);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzfo);
    transactOneway(4, localParcel);
    AppMethodBeat.o(71251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzeo
 * JD-Core Version:    0.7.0.1
 */