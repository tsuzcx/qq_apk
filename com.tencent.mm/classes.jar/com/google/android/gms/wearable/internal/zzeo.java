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
    AppMethodBeat.i(101235);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeTypedList(paramList);
    transactOneway(5, localParcel);
    AppMethodBeat.o(101235);
  }
  
  public final void zza(DataHolder paramDataHolder)
  {
    AppMethodBeat.i(101231);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramDataHolder);
    transactOneway(1, localParcel);
    AppMethodBeat.o(101231);
  }
  
  public final void zza(zzah paramzzah)
  {
    AppMethodBeat.i(101238);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzah);
    transactOneway(8, localParcel);
    AppMethodBeat.o(101238);
  }
  
  public final void zza(zzaw paramzzaw)
  {
    AppMethodBeat.i(101237);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzaw);
    transactOneway(7, localParcel);
    AppMethodBeat.o(101237);
  }
  
  public final void zza(zzfe paramzzfe)
  {
    AppMethodBeat.i(101232);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzfe);
    transactOneway(2, localParcel);
    AppMethodBeat.o(101232);
  }
  
  public final void zza(zzfo paramzzfo)
  {
    AppMethodBeat.i(101233);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzfo);
    transactOneway(3, localParcel);
    AppMethodBeat.o(101233);
  }
  
  public final void zza(zzi paramzzi)
  {
    AppMethodBeat.i(101239);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzi);
    transactOneway(9, localParcel);
    AppMethodBeat.o(101239);
  }
  
  public final void zza(zzl paramzzl)
  {
    AppMethodBeat.i(101236);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzl);
    transactOneway(6, localParcel);
    AppMethodBeat.o(101236);
  }
  
  public final void zzb(zzfo paramzzfo)
  {
    AppMethodBeat.i(101234);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzfo);
    transactOneway(4, localParcel);
    AppMethodBeat.o(101234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzeo
 * JD-Core Version:    0.7.0.1
 */