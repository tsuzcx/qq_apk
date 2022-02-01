package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class zzfa
  extends zzn
  implements zzey
{
  zzfa(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
  }
  
  public final List<zzjx> zza(zzdz paramzzdz, boolean paramBoolean)
  {
    AppMethodBeat.i(1287);
    Object localObject = obtainAndWriteInterfaceToken();
    zzp.zza((Parcel)localObject, paramzzdz);
    zzp.zza((Parcel)localObject, paramBoolean);
    paramzzdz = transactAndReadException(7, (Parcel)localObject);
    localObject = paramzzdz.createTypedArrayList(zzjx.CREATOR);
    paramzzdz.recycle();
    AppMethodBeat.o(1287);
    return localObject;
  }
  
  public final List<zzed> zza(String paramString1, String paramString2, zzdz paramzzdz)
  {
    AppMethodBeat.i(1295);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzp.zza(localParcel, paramzzdz);
    paramString1 = transactAndReadException(16, localParcel);
    paramString2 = paramString1.createTypedArrayList(zzed.CREATOR);
    paramString1.recycle();
    AppMethodBeat.o(1295);
    return paramString2;
  }
  
  public final List<zzjx> zza(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(1294);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeString(paramString3);
    zzp.zza(localParcel, paramBoolean);
    paramString1 = transactAndReadException(15, localParcel);
    paramString2 = paramString1.createTypedArrayList(zzjx.CREATOR);
    paramString1.recycle();
    AppMethodBeat.o(1294);
    return paramString2;
  }
  
  public final List<zzjx> zza(String paramString1, String paramString2, boolean paramBoolean, zzdz paramzzdz)
  {
    AppMethodBeat.i(1293);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzp.zza(localParcel, paramBoolean);
    zzp.zza(localParcel, paramzzdz);
    paramString1 = transactAndReadException(14, localParcel);
    paramString2 = paramString1.createTypedArrayList(zzjx.CREATOR);
    paramString1.recycle();
    AppMethodBeat.o(1293);
    return paramString2;
  }
  
  public final void zza(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(1289);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeLong(paramLong);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeString(paramString3);
    transactAndReadExceptionReturnVoid(10, localParcel);
    AppMethodBeat.o(1289);
  }
  
  public final void zza(zzdz paramzzdz)
  {
    AppMethodBeat.i(1284);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzp.zza(localParcel, paramzzdz);
    transactAndReadExceptionReturnVoid(4, localParcel);
    AppMethodBeat.o(1284);
  }
  
  public final void zza(zzed paramzzed, zzdz paramzzdz)
  {
    AppMethodBeat.i(1291);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzp.zza(localParcel, paramzzed);
    zzp.zza(localParcel, paramzzdz);
    transactAndReadExceptionReturnVoid(12, localParcel);
    AppMethodBeat.o(1291);
  }
  
  public final void zza(zzeu paramzzeu, zzdz paramzzdz)
  {
    AppMethodBeat.i(1282);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzp.zza(localParcel, paramzzeu);
    zzp.zza(localParcel, paramzzdz);
    transactAndReadExceptionReturnVoid(1, localParcel);
    AppMethodBeat.o(1282);
  }
  
  public final void zza(zzeu paramzzeu, String paramString1, String paramString2)
  {
    AppMethodBeat.i(1285);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzp.zza(localParcel, paramzzeu);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    transactAndReadExceptionReturnVoid(5, localParcel);
    AppMethodBeat.o(1285);
  }
  
  public final void zza(zzjx paramzzjx, zzdz paramzzdz)
  {
    AppMethodBeat.i(1283);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzp.zza(localParcel, paramzzjx);
    zzp.zza(localParcel, paramzzdz);
    transactAndReadExceptionReturnVoid(2, localParcel);
    AppMethodBeat.o(1283);
  }
  
  public final byte[] zza(zzeu paramzzeu, String paramString)
  {
    AppMethodBeat.i(1288);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzp.zza(localParcel, paramzzeu);
    localParcel.writeString(paramString);
    paramzzeu = transactAndReadException(9, localParcel);
    paramString = paramzzeu.createByteArray();
    paramzzeu.recycle();
    AppMethodBeat.o(1288);
    return paramString;
  }
  
  public final void zzb(zzdz paramzzdz)
  {
    AppMethodBeat.i(1286);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzp.zza(localParcel, paramzzdz);
    transactAndReadExceptionReturnVoid(6, localParcel);
    AppMethodBeat.o(1286);
  }
  
  public final void zzb(zzed paramzzed)
  {
    AppMethodBeat.i(1292);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzp.zza(localParcel, paramzzed);
    transactAndReadExceptionReturnVoid(13, localParcel);
    AppMethodBeat.o(1292);
  }
  
  public final String zzc(zzdz paramzzdz)
  {
    AppMethodBeat.i(1290);
    Object localObject = obtainAndWriteInterfaceToken();
    zzp.zza((Parcel)localObject, paramzzdz);
    paramzzdz = transactAndReadException(11, (Parcel)localObject);
    localObject = paramzzdz.readString();
    paramzzdz.recycle();
    AppMethodBeat.o(1290);
    return localObject;
  }
  
  public final void zzd(zzdz paramzzdz)
  {
    AppMethodBeat.i(1297);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzp.zza(localParcel, paramzzdz);
    transactAndReadExceptionReturnVoid(18, localParcel);
    AppMethodBeat.o(1297);
  }
  
  public final List<zzed> zze(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(1296);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeString(paramString3);
    paramString1 = transactAndReadException(17, localParcel);
    paramString2 = paramString1.createTypedArrayList(zzed.CREATOR);
    paramString1.recycle();
    AppMethodBeat.o(1296);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfa
 * JD-Core Version:    0.7.0.1
 */