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
    AppMethodBeat.i(17668);
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
      AppMethodBeat.o(17668);
    }
  }
  
  /* Error */
  public final boolean isTrackingLimited()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: sipush 17669
    //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 40	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore_3
    //   12: invokestatic 40	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   15: astore 4
    //   17: aload_3
    //   18: ldc 42
    //   20: invokevirtual 46	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   23: aload_3
    //   24: iconst_1
    //   25: invokevirtual 69	android/os/Parcel:writeInt	(I)V
    //   28: aload_0
    //   29: getfield 23	com/facebook/internal/AttributionIdentifiers$GoogleAdInfo:binder	Landroid/os/IBinder;
    //   32: iconst_2
    //   33: aload_3
    //   34: aload 4
    //   36: iconst_0
    //   37: invokeinterface 52 5 0
    //   42: pop
    //   43: aload 4
    //   45: invokevirtual 55	android/os/Parcel:readException	()V
    //   48: aload 4
    //   50: invokevirtual 73	android/os/Parcel:readInt	()I
    //   53: istore_1
    //   54: iload_1
    //   55: ifeq +20 -> 75
    //   58: aload 4
    //   60: invokevirtual 61	android/os/Parcel:recycle	()V
    //   63: aload_3
    //   64: invokevirtual 61	android/os/Parcel:recycle	()V
    //   67: sipush 17669
    //   70: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: iload_2
    //   74: ireturn
    //   75: iconst_0
    //   76: istore_2
    //   77: goto -19 -> 58
    //   80: astore 5
    //   82: aload 4
    //   84: invokevirtual 61	android/os/Parcel:recycle	()V
    //   87: aload_3
    //   88: invokevirtual 61	android/os/Parcel:recycle	()V
    //   91: sipush 17669
    //   94: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload 5
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	GoogleAdInfo
    //   53	2	1	i	int
    //   1	76	2	bool	boolean
    //   11	77	3	localParcel1	Parcel
    //   15	68	4	localParcel2	Parcel
    //   80	18	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	54	80	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.internal.AttributionIdentifiers.GoogleAdInfo
 * JD-Core Version:    0.7.0.1
 */