package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface j
  extends IInterface
{
  public abstract void networkAnalysisCallBack(int paramInt1, int paramInt2, boolean paramBoolean, String paramString);
  
  public static abstract class a
    extends Binder
    implements j
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
    }
    
    public static j bjB()
    {
      return a.jDT;
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
      implements j
    {
      public static j jDT;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final void networkAnalysisCallBack(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
      {
        int i = 1;
        AppMethodBeat.i(132739);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          if (paramBoolean) {}
          for (;;)
          {
            localParcel1.writeInt(i);
            localParcel1.writeString(paramString);
            if ((this.mRemote.transact(1, localParcel1, localParcel2, 0)) || (j.a.bjB() == null)) {
              break;
            }
            j.a.bjB().networkAnalysisCallBack(paramInt1, paramInt2, paramBoolean, paramString);
            return;
            i = 0;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132739);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.j
 * JD-Core Version:    0.7.0.1
 */