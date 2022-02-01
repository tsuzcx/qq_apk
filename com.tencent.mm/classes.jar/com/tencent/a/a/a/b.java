package com.tencent.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b
  extends IInterface
{
  public abstract void onActionResult(byte[] paramArrayOfByte);
  
  public static abstract class a
    extends Binder
    implements b
  {
    private static final String DESCRIPTOR = "com.tencent.assistant.sdk.SDKActionCallback";
    static final int TRANSACTION_onActionResult = 1;
    
    public a()
    {
      attachInterface(this, "com.tencent.assistant.sdk.SDKActionCallback");
    }
    
    public static b asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.assistant.sdk.SDKActionCallback");
      if ((localIInterface != null) && ((localIInterface instanceof b))) {
        return (b)localIInterface;
      }
      return new a(paramIBinder);
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
        paramParcel2.writeString("com.tencent.assistant.sdk.SDKActionCallback");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.assistant.sdk.SDKActionCallback");
      onActionResult(paramParcel1.createByteArray());
      return true;
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
      
      public final void onActionResult(byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(101839);
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.assistant.sdk.SDKActionCallback");
          localParcel.writeByteArray(paramArrayOfByte);
          this.mRemote.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
          AppMethodBeat.o(101839);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */