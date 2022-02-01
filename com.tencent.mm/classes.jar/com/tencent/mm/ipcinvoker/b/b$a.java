package com.tencent.mm.ipcinvoker.b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class b$a
  extends Binder
  implements b
{
  public b$a()
  {
    attachInterface(this, "com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
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
      paramParcel2.writeString("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      q(paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
  
  static final class a
    implements b
  {
    private IBinder mRemote;
    
    a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
    
    /* Error */
    public final void q(Bundle paramBundle)
    {
      // Byte code:
      //   0: ldc 24
      //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   8: astore_2
      //   9: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   12: astore_3
      //   13: aload_2
      //   14: ldc 38
      //   16: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   19: aload_1
      //   20: ifnull +46 -> 66
      //   23: aload_2
      //   24: iconst_1
      //   25: invokevirtual 45	android/os/Parcel:writeInt	(I)V
      //   28: aload_1
      //   29: aload_2
      //   30: iconst_0
      //   31: invokevirtual 51	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
      //   34: aload_0
      //   35: getfield 18	com/tencent/mm/ipcinvoker/b/b$a$a:mRemote	Landroid/os/IBinder;
      //   38: iconst_1
      //   39: aload_2
      //   40: aload_3
      //   41: iconst_0
      //   42: invokeinterface 57 5 0
      //   47: pop
      //   48: aload_3
      //   49: invokevirtual 60	android/os/Parcel:readException	()V
      //   52: aload_3
      //   53: invokevirtual 63	android/os/Parcel:recycle	()V
      //   56: aload_2
      //   57: invokevirtual 63	android/os/Parcel:recycle	()V
      //   60: ldc 24
      //   62: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   65: return
      //   66: aload_2
      //   67: iconst_0
      //   68: invokevirtual 45	android/os/Parcel:writeInt	(I)V
      //   71: goto -37 -> 34
      //   74: astore_1
      //   75: aload_3
      //   76: invokevirtual 63	android/os/Parcel:recycle	()V
      //   79: aload_2
      //   80: invokevirtual 63	android/os/Parcel:recycle	()V
      //   83: ldc 24
      //   85: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   88: aload_1
      //   89: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	90	0	this	a
      //   0	90	1	paramBundle	Bundle
      //   8	72	2	localParcel1	Parcel
      //   12	64	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   13	19	74	finally
      //   23	34	74	finally
      //   34	52	74	finally
      //   66	71	74	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.b.b.a
 * JD-Core Version:    0.7.0.1
 */