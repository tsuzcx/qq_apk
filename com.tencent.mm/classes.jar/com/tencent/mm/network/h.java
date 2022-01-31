package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface h
  extends IInterface
{
  public abstract void networkAnalysisCallBack(int paramInt1, int paramInt2, boolean paramBoolean, String paramString);
  
  public static abstract class a
    extends Binder
    implements h
  {
    public a()
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
    
    private static final class a
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
      public final void networkAnalysisCallBack(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 5
        //   3: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: aload 6
        //   15: ldc 31
        //   17: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 6
        //   22: iload_1
        //   23: invokevirtual 39	android/os/Parcel:writeInt	(I)V
        //   26: aload 6
        //   28: iload_2
        //   29: invokevirtual 39	android/os/Parcel:writeInt	(I)V
        //   32: iload_3
        //   33: ifeq +51 -> 84
        //   36: iload 5
        //   38: istore_1
        //   39: aload 6
        //   41: iload_1
        //   42: invokevirtual 39	android/os/Parcel:writeInt	(I)V
        //   45: aload 6
        //   47: aload 4
        //   49: invokevirtual 42	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   52: aload_0
        //   53: getfield 18	com/tencent/mm/network/h$a$a:mRemote	Landroid/os/IBinder;
        //   56: iconst_1
        //   57: aload 6
        //   59: aload 7
        //   61: iconst_0
        //   62: invokeinterface 48 5 0
        //   67: pop
        //   68: aload 7
        //   70: invokevirtual 51	android/os/Parcel:readException	()V
        //   73: aload 7
        //   75: invokevirtual 54	android/os/Parcel:recycle	()V
        //   78: aload 6
        //   80: invokevirtual 54	android/os/Parcel:recycle	()V
        //   83: return
        //   84: iconst_0
        //   85: istore_1
        //   86: goto -47 -> 39
        //   89: astore 4
        //   91: aload 7
        //   93: invokevirtual 54	android/os/Parcel:recycle	()V
        //   96: aload 6
        //   98: invokevirtual 54	android/os/Parcel:recycle	()V
        //   101: aload 4
        //   103: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	104	0	this	a
        //   0	104	1	paramInt1	int
        //   0	104	2	paramInt2	int
        //   0	104	3	paramBoolean	boolean
        //   0	104	4	paramString	String
        //   1	36	5	i	int
        //   6	91	6	localParcel1	Parcel
        //   11	81	7	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	32	89	finally
        //   39	73	89	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.h
 * JD-Core Version:    0.7.0.1
 */