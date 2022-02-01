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
    AppMethodBeat.i(101242);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    transactAndReadExceptionReturnVoid(8, localParcel);
    AppMethodBeat.o(101242);
  }
  
  public final void zza(zzek paramzzek, int paramInt)
  {
    AppMethodBeat.i(101250);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeInt(paramInt);
    transactAndReadExceptionReturnVoid(43, localParcel);
    AppMethodBeat.o(101250);
  }
  
  public final void zza(zzek paramzzek, Uri paramUri)
  {
    AppMethodBeat.i(101241);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramUri);
    transactAndReadExceptionReturnVoid(7, localParcel);
    AppMethodBeat.o(101241);
  }
  
  public final void zza(zzek paramzzek, Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(101243);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramUri);
    localParcel.writeInt(paramInt);
    transactAndReadExceptionReturnVoid(40, localParcel);
    AppMethodBeat.o(101243);
  }
  
  public final void zza(zzek paramzzek, Asset paramAsset)
  {
    AppMethodBeat.i(101246);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramAsset);
    transactAndReadExceptionReturnVoid(13, localParcel);
    AppMethodBeat.o(101246);
  }
  
  public final void zza(zzek paramzzek, PutDataRequest paramPutDataRequest)
  {
    AppMethodBeat.i(101240);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramPutDataRequest);
    transactAndReadExceptionReturnVoid(6, localParcel);
    AppMethodBeat.o(101240);
  }
  
  public final void zza(zzek paramzzek, zzd paramzzd)
  {
    AppMethodBeat.i(101253);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramzzd);
    transactAndReadExceptionReturnVoid(16, localParcel);
    AppMethodBeat.o(101253);
  }
  
  public final void zza(zzek paramzzek, zzei paramzzei, String paramString)
  {
    AppMethodBeat.i(101258);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramzzei);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(34, localParcel);
    AppMethodBeat.o(101258);
  }
  
  public final void zza(zzek paramzzek, zzfw paramzzfw)
  {
    AppMethodBeat.i(101254);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramzzfw);
    transactAndReadExceptionReturnVoid(17, localParcel);
    AppMethodBeat.o(101254);
  }
  
  public final void zza(zzek paramzzek, String paramString)
  {
    AppMethodBeat.i(101251);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(46, localParcel);
    AppMethodBeat.o(101251);
  }
  
  public final void zza(zzek paramzzek, String paramString, int paramInt)
  {
    AppMethodBeat.i(101249);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt);
    transactAndReadExceptionReturnVoid(42, localParcel);
    AppMethodBeat.o(101249);
  }
  
  public final void zza(zzek paramzzek, String paramString, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(101260);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    zzc.zza(localParcel, paramParcelFileDescriptor);
    transactAndReadExceptionReturnVoid(38, localParcel);
    AppMethodBeat.o(101260);
  }
  
  public final void zza(zzek paramzzek, String paramString, ParcelFileDescriptor paramParcelFileDescriptor, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(101261);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    zzc.zza(localParcel, paramParcelFileDescriptor);
    localParcel.writeLong(paramLong1);
    localParcel.writeLong(paramLong2);
    transactAndReadExceptionReturnVoid(39, localParcel);
    AppMethodBeat.o(101261);
  }
  
  public final void zza(zzek paramzzek, String paramString1, String paramString2)
  {
    AppMethodBeat.i(101255);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    transactAndReadExceptionReturnVoid(31, localParcel);
    AppMethodBeat.o(101255);
  }
  
  public final void zza(zzek paramzzek, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(101245);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeByteArray(paramArrayOfByte);
    transactAndReadExceptionReturnVoid(12, localParcel);
    AppMethodBeat.o(101245);
  }
  
  public final void zzb(zzek paramzzek)
  {
    AppMethodBeat.i(101247);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    transactAndReadExceptionReturnVoid(14, localParcel);
    AppMethodBeat.o(101247);
  }
  
  public final void zzb(zzek paramzzek, Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(101244);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramUri);
    localParcel.writeInt(paramInt);
    transactAndReadExceptionReturnVoid(41, localParcel);
    AppMethodBeat.o(101244);
  }
  
  public final void zzb(zzek paramzzek, zzei paramzzei, String paramString)
  {
    AppMethodBeat.i(101259);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    zzc.zza(localParcel, paramzzei);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(35, localParcel);
    AppMethodBeat.o(101259);
  }
  
  public final void zzb(zzek paramzzek, String paramString)
  {
    AppMethodBeat.i(101252);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(47, localParcel);
    AppMethodBeat.o(101252);
  }
  
  public final void zzb(zzek paramzzek, String paramString, int paramInt)
  {
    AppMethodBeat.i(101257);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt);
    transactAndReadExceptionReturnVoid(33, localParcel);
    AppMethodBeat.o(101257);
  }
  
  public final void zzc(zzek paramzzek)
  {
    AppMethodBeat.i(101248);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    transactAndReadExceptionReturnVoid(15, localParcel);
    AppMethodBeat.o(101248);
  }
  
  public final void zzc(zzek paramzzek, String paramString)
  {
    AppMethodBeat.i(101256);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzek);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(32, localParcel);
    AppMethodBeat.o(101256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzeq
 * JD-Core Version:    0.7.0.1
 */