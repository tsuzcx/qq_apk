package com.tencent.mm.ipcinvoker.b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
  extends IInterface
{
  public abstract void a(Bundle paramBundle, String paramString, b paramb);
  
  public abstract Bundle e(Bundle paramBundle, String paramString);
  
  public static abstract class a
    extends Binder
    implements a
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
    }
    
    public static a ayh()
    {
      return a.hnr;
    }
    
    public static a l(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
      if ((localIInterface != null) && ((localIInterface instanceof a))) {
        return (a)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      Object localObject = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
        String str;
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          str = paramParcel1.readString();
          paramParcel1 = paramParcel1.readStrongBinder();
          if (paramParcel1 != null) {
            break label117;
          }
          paramParcel1 = (Parcel)localObject;
        }
        for (;;)
        {
          a(paramParcel2, str, paramParcel1);
          return true;
          paramParcel2 = null;
          break;
          label117:
          localObject = paramParcel1.queryLocalInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
          if ((localObject != null) && ((localObject instanceof b))) {
            paramParcel1 = (b)localObject;
          } else {
            paramParcel1 = new b.a.a(paramParcel1);
          }
        }
      }
      paramParcel1.enforceInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
      if (paramParcel1.readInt() != 0)
      {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        paramParcel1 = e((Bundle)localObject, paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label226;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        localObject = null;
        break;
        label226:
        paramParcel2.writeInt(0);
      }
    }
    
    static final class a
      implements a
    {
      public static a hnr;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void a(Bundle paramBundle, String paramString, b paramb)
      {
        IBinder localIBinder = null;
        AppMethodBeat.i(158781);
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
          if (paramBundle != null)
          {
            localParcel.writeInt(1);
            paramBundle.writeToParcel(localParcel, 0);
          }
          for (;;)
          {
            localParcel.writeString(paramString);
            if (paramb != null) {
              localIBinder = paramb.asBinder();
            }
            localParcel.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(1, localParcel, null, 1)) || (a.a.ayh() == null)) {
              break;
            }
            a.a.ayh().a(paramBundle, paramString, paramb);
            return;
            localParcel.writeInt(0);
          }
          localParcel.recycle();
        }
        finally
        {
          localParcel.recycle();
          AppMethodBeat.o(158781);
        }
        AppMethodBeat.o(158781);
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final Bundle e(Bundle paramBundle, String paramString)
      {
        AppMethodBeat.i(158782);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          for (;;)
          {
            localParcel1.writeString(paramString);
            if ((this.mRemote.transact(2, localParcel1, localParcel2, 0)) || (a.a.ayh() == null)) {
              break;
            }
            paramBundle = a.a.ayh().e(paramBundle, paramString);
            return paramBundle;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(158782);
        }
        if (localParcel2.readInt() != 0) {}
        for (paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);; paramBundle = null)
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(158782);
          return paramBundle;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.b.a
 * JD-Core Version:    0.7.0.1
 */