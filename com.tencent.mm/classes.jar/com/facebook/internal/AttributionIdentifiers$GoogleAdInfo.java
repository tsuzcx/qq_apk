package com.facebook.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AttributionIdentifiers$GoogleAdInfo
  implements IInterface
{
  private static final int FIRST_TRANSACTION_CODE = 1;
  private static final int SECOND_TRANSACTION_CODE = 2;
  private IBinder binder;
  
  AttributionIdentifiers$GoogleAdInfo(IBinder paramIBinder)
  {
    this.binder = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return this.binder;
  }
  
  public final String getAdvertiserId()
  {
    AppMethodBeat.i(72232);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      this.binder.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(72232);
    }
  }
  
  /* Error */
  public final boolean isTrackingLimited()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 68
    //   4: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 41	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore_3
    //   11: invokestatic 41	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   14: astore 4
    //   16: aload_3
    //   17: ldc 43
    //   19: invokevirtual 47	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   22: aload_3
    //   23: iconst_1
    //   24: invokevirtual 71	android/os/Parcel:writeInt	(I)V
    //   27: aload_0
    //   28: getfield 23	com/facebook/internal/AttributionIdentifiers$GoogleAdInfo:binder	Landroid/os/IBinder;
    //   31: iconst_2
    //   32: aload_3
    //   33: aload 4
    //   35: iconst_0
    //   36: invokeinterface 53 5 0
    //   41: pop
    //   42: aload 4
    //   44: invokevirtual 56	android/os/Parcel:readException	()V
    //   47: aload 4
    //   49: invokevirtual 75	android/os/Parcel:readInt	()I
    //   52: istore_1
    //   53: iload_1
    //   54: ifeq +19 -> 73
    //   57: aload 4
    //   59: invokevirtual 62	android/os/Parcel:recycle	()V
    //   62: aload_3
    //   63: invokevirtual 62	android/os/Parcel:recycle	()V
    //   66: ldc 68
    //   68: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: iload_2
    //   72: ireturn
    //   73: iconst_0
    //   74: istore_2
    //   75: goto -18 -> 57
    //   78: astore 5
    //   80: aload 4
    //   82: invokevirtual 62	android/os/Parcel:recycle	()V
    //   85: aload_3
    //   86: invokevirtual 62	android/os/Parcel:recycle	()V
    //   89: ldc 68
    //   91: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload 5
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	GoogleAdInfo
    //   52	2	1	i	int
    //   1	74	2	bool	boolean
    //   10	76	3	localParcel1	Parcel
    //   14	67	4	localParcel2	Parcel
    //   78	17	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	53	78	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.internal.AttributionIdentifiers.GoogleAdInfo
 * JD-Core Version:    0.7.0.1
 */