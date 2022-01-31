package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;

public abstract class zzabb$zza
  extends Binder
  implements zzabb
{
  public zzabb$zza()
  {
    attachInterface(this, "com.google.android.gms.common.api.internal.IStatusCallback");
  }
  
  public static zzabb zzbp(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
    if ((localIInterface != null) && ((localIInterface instanceof zzabb))) {
      return (zzabb)localIInterface;
    }
    return new zza(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.common.api.internal.IStatusCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.common.api.internal.IStatusCallback");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      zzp(paramParcel1);
      return true;
    }
  }
  
  private static class zza
    implements zzabb
  {
    private IBinder zzrk;
    
    zza(IBinder paramIBinder)
    {
      this.zzrk = paramIBinder;
    }
    
    public IBinder asBinder()
    {
      return this.zzrk;
    }
    
    /* Error */
    public void zzp(Status paramStatus)
    {
      // Byte code:
      //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: aload_2
      //   5: ldc 31
      //   7: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   10: aload_1
      //   11: ifnull +33 -> 44
      //   14: aload_2
      //   15: iconst_1
      //   16: invokevirtual 39	android/os/Parcel:writeInt	(I)V
      //   19: aload_1
      //   20: aload_2
      //   21: iconst_0
      //   22: invokevirtual 45	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
      //   25: aload_0
      //   26: getfield 18	com/google/android/gms/internal/zzabb$zza$zza:zzrk	Landroid/os/IBinder;
      //   29: iconst_1
      //   30: aload_2
      //   31: aconst_null
      //   32: iconst_1
      //   33: invokeinterface 51 5 0
      //   38: pop
      //   39: aload_2
      //   40: invokevirtual 54	android/os/Parcel:recycle	()V
      //   43: return
      //   44: aload_2
      //   45: iconst_0
      //   46: invokevirtual 39	android/os/Parcel:writeInt	(I)V
      //   49: goto -24 -> 25
      //   52: astore_1
      //   53: aload_2
      //   54: invokevirtual 54	android/os/Parcel:recycle	()V
      //   57: aload_1
      //   58: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	59	0	this	zza
      //   0	59	1	paramStatus	Status
      //   3	51	2	localParcel	Parcel
      // Exception table:
      //   from	to	target	type
      //   4	10	52	finally
      //   14	25	52	finally
      //   25	39	52	finally
      //   44	49	52	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzabb.zza
 * JD-Core Version:    0.7.0.1
 */