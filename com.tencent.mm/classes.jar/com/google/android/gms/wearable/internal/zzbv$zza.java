package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzbv$zza
  extends Binder
  implements zzbv
{
  public zzbv$zza()
  {
    attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
  }
  
  public static zzbv zzfC(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
    if ((localIInterface != null) && ((localIInterface instanceof zzbv))) {
      return (zzbv)localIInterface;
    }
    return new zzbv.zza.zza(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.wearable.internal.IWearableListener");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      paramParcel2 = localObject1;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (DataHolder)DataHolder.CREATOR.createFromParcel(paramParcel1);
      }
      zzaq(paramParcel2);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      paramParcel2 = localObject2;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (zzbz)zzbz.CREATOR.createFromParcel(paramParcel1);
      }
      zza(paramParcel2);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      paramParcel2 = localObject3;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (zzcc)zzcc.CREATOR.createFromParcel(paramParcel1);
      }
      zza(paramParcel2);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      paramParcel2 = localObject4;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (zzcc)zzcc.CREATOR.createFromParcel(paramParcel1);
      }
      zzb(paramParcel2);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      onConnectedNodes(paramParcel1.createTypedArrayList(zzcc.CREATOR));
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      paramParcel2 = localObject5;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (zzk)zzk.CREATOR.createFromParcel(paramParcel1);
      }
      zza(paramParcel2);
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      paramParcel2 = localObject6;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (zzs)zzs.CREATOR.createFromParcel(paramParcel1);
      }
      zza(paramParcel2);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      paramParcel2 = localObject7;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (zzo)zzo.CREATOR.createFromParcel(paramParcel1);
      }
      zza(paramParcel2);
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
    paramParcel2 = localObject8;
    if (paramParcel1.readInt() != 0) {
      paramParcel2 = (zzh)zzh.CREATOR.createFromParcel(paramParcel1);
    }
    zza(paramParcel2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbv.zza
 * JD-Core Version:    0.7.0.1
 */