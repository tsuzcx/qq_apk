package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class h$a
  extends Binder
  implements h
{
  public h$a()
  {
    attachInterface(this, "com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
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
      paramParcel2.writeString("com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
    paramInt1 = paramParcel1.readInt();
    paramInt2 = paramParcel1.readInt();
    if (paramParcel1.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      networkAnalysisCallBack(paramInt1, paramInt2, bool, paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
  }
  
  static final class a
    implements h
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
    public final void networkAnalysisCallBack(int paramInt1, int paramInt2, boolean paramBoolean, java.lang.String paramString)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 5
      //   3: ldc 24
      //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   11: astore 6
      //   13: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   16: astore 7
      //   18: aload 6
      //   20: ldc 38
      //   22: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   25: aload 6
      //   27: iload_1
      //   28: invokevirtual 45	android/os/Parcel:writeInt	(I)V
      //   31: aload 6
      //   33: iload_2
      //   34: invokevirtual 45	android/os/Parcel:writeInt	(I)V
      //   37: iload_3
      //   38: ifeq +56 -> 94
      //   41: iload 5
      //   43: istore_1
      //   44: aload 6
      //   46: iload_1
      //   47: invokevirtual 45	android/os/Parcel:writeInt	(I)V
      //   50: aload 6
      //   52: aload 4
      //   54: invokevirtual 48	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   57: aload_0
      //   58: getfield 18	com/tencent/mm/network/h$a$a:mRemote	Landroid/os/IBinder;
      //   61: iconst_1
      //   62: aload 6
      //   64: aload 7
      //   66: iconst_0
      //   67: invokeinterface 54 5 0
      //   72: pop
      //   73: aload 7
      //   75: invokevirtual 57	android/os/Parcel:readException	()V
      //   78: aload 7
      //   80: invokevirtual 60	android/os/Parcel:recycle	()V
      //   83: aload 6
      //   85: invokevirtual 60	android/os/Parcel:recycle	()V
      //   88: ldc 24
      //   90: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   93: return
      //   94: iconst_0
      //   95: istore_1
      //   96: goto -52 -> 44
      //   99: astore 4
      //   101: aload 7
      //   103: invokevirtual 60	android/os/Parcel:recycle	()V
      //   106: aload 6
      //   108: invokevirtual 60	android/os/Parcel:recycle	()V
      //   111: ldc 24
      //   113: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   116: aload 4
      //   118: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	119	0	this	a
      //   0	119	1	paramInt1	int
      //   0	119	2	paramInt2	int
      //   0	119	3	paramBoolean	boolean
      //   0	119	4	paramString	java.lang.String
      //   1	41	5	i	int
      //   11	96	6	localParcel1	Parcel
      //   16	86	7	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   18	37	99	finally
      //   44	78	99	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.network.h.a
 * JD-Core Version:    0.7.0.1
 */