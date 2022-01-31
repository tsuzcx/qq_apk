package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.internal.wearable.zza;
import com.google.android.gms.internal.wearable.zzc;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzeq
  extends zza
  implements zzep
{
  zzeq(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.wearable.internal.IWearableService");
  }
  
  public final void zza(zzek paramzzek)
  {
    AppMethodBeat.i(71259);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    transactAndReadExceptionReturnVoid(8, localParcel);
    AppMethodBeat.o(71259);
  }
  
  public final void zza(zzek paramzzek, int paramInt)
  {
    AppMethodBeat.i(71267);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeInt(paramInt);
    transactAndReadExceptionReturnVoid(43, localParcel);
    AppMethodBeat.o(71267);
  }
  
  public final void zza(zzek paramzzek, Uri paramUri)
  {
    AppMethodBeat.i(71258);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramUri);
    transactAndReadExceptionReturnVoid(7, localParcel);
    AppMethodBeat.o(71258);
  }
  
  public final void zza(zzek paramzzek, Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(71260);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramUri);
    localParcel.writeInt(paramInt);
    transactAndReadExceptionReturnVoid(40, localParcel);
    AppMethodBeat.o(71260);
  }
  
  public final void zza(zzek paramzzek, Asset paramAsset)
  {
    AppMethodBeat.i(71263);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramAsset);
    transactAndReadExceptionReturnVoid(13, localParcel);
    AppMethodBeat.o(71263);
  }
  
  public final void zza(zzek paramzzek, PutDataRequest paramPutDataRequest)
  {
    AppMethodBeat.i(71257);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramPutDataRequest);
    transactAndReadExceptionReturnVoid(6, localParcel);
    AppMethodBeat.o(71257);
  }
  
  public final void zza(zzek paramzzek, zzd paramzzd)
  {
    AppMethodBeat.i(71270);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramzzd);
    transactAndReadExceptionReturnVoid(16, localParcel);
    AppMethodBeat.o(71270);
  }
  
  public final void zza(zzek paramzzek, zzei paramzzei, String paramString)
  {
    AppMethodBeat.i(71275);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramzzei);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(34, localParcel);
    AppMethodBeat.o(71275);
  }
  
  public final void zza(zzek paramzzek, zzfw paramzzfw)
  {
    AppMethodBeat.i(71271);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramzzfw);
    transactAndReadExceptionReturnVoid(17, localParcel);
    AppMethodBeat.o(71271);
  }
  
  public final void zza(zzek paramzzek, String paramString)
  {
    AppMethodBeat.i(71268);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(46, localParcel);
    AppMethodBeat.o(71268);
  }
  
  public final void zza(zzek paramzzek, String paramString, int paramInt)
  {
    AppMethodBeat.i(71266);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt);
    transactAndReadExceptionReturnVoid(42, localParcel);
    AppMethodBeat.o(71266);
  }
  
  public final void zza(zzek paramzzek, String paramString, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(71277);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    zzc.zza(localParcel, paramParcelFileDescriptor);
    transactAndReadExceptionReturnVoid(38, localParcel);
    AppMethodBeat.o(71277);
  }
  
  public final void zza(zzek paramzzek, String paramString, ParcelFileDescriptor paramParcelFileDescriptor, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(71278);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    zzc.zza(localParcel, paramParcelFileDescriptor);
    localParcel.writeLong(paramLong1);
    localParcel.writeLong(paramLong2);
    transactAndReadExceptionReturnVoid(39, localParcel);
    AppMethodBeat.o(71278);
  }
  
  public final void zza(zzek paramzzek, String paramString1, String paramString2)
  {
    AppMethodBeat.i(71272);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    transactAndReadExceptionReturnVoid(31, localParcel);
    AppMethodBeat.o(71272);
  }
  
  public final void zza(zzek paramzzek, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(71262);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeByteArray(paramArrayOfByte);
    transactAndReadExceptionReturnVoid(12, localParcel);
    AppMethodBeat.o(71262);
  }
  
  public final void zzb(zzek paramzzek)
  {
    AppMethodBeat.i(71264);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    transactAndReadExceptionReturnVoid(14, localParcel);
    AppMethodBeat.o(71264);
  }
  
  public final void zzb(zzek paramzzek, Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(71261);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramUri);
    localParcel.writeInt(paramInt);
    transactAndReadExceptionReturnVoid(41, localParcel);
    AppMethodBeat.o(71261);
  }
  
  public final void zzb(zzek paramzzek, zzei paramzzei, String paramString)
  {
    AppMethodBeat.i(71276);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramzzei);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(35, localParcel);
    AppMethodBeat.o(71276);
  }
  
  public final void zzb(zzek paramzzek, String paramString)
  {
    AppMethodBeat.i(71269);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(47, localParcel);
    AppMethodBeat.o(71269);
  }
  
  public final void zzb(zzek paramzzek, String paramString, int paramInt)
  {
    AppMethodBeat.i(71274);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt);
    transactAndReadExceptionReturnVoid(33, localParcel);
    AppMethodBeat.o(71274);
  }
  
  public final void zzc(zzek paramzzek)
  {
    AppMethodBeat.i(71265);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    transactAndReadExceptionReturnVoid(15, localParcel);
    AppMethodBeat.o(71265);
  }
  
  public final void zzc(zzek paramzzek, String paramString)
  {
    AppMethodBeat.i(71273);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(32, localParcel);
    AppMethodBeat.o(71273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzeq
 * JD-Core Version:    0.7.0.1
 */