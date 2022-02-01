package com.tencent.mm.ipcinvoker.b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class a$a
  extends Binder
  implements a
{
  public a$a()
  {
    attachInterface(this, "com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
  }
  
  public static a k(IBinder paramIBinder)
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
      paramParcel1 = f((Bundle)localObject, paramParcel1.readString());
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
    private IBinder mRemote;
    
    a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    /* Error */
    public final void a(Bundle paramBundle, String paramString, b paramb)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: ldc 21
      //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   11: astore 5
      //   13: aload 5
      //   15: ldc 35
      //   17: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   20: aload_1
      //   21: ifnull +68 -> 89
      //   24: aload 5
      //   26: iconst_1
      //   27: invokevirtual 42	android/os/Parcel:writeInt	(I)V
      //   30: aload_1
      //   31: aload 5
      //   33: iconst_0
      //   34: invokevirtual 48	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
      //   37: aload 5
      //   39: aload_2
      //   40: invokevirtual 51	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   43: aload 4
      //   45: astore_1
      //   46: aload_3
      //   47: ifnull +10 -> 57
      //   50: aload_3
      //   51: invokeinterface 57 1 0
      //   56: astore_1
      //   57: aload 5
      //   59: aload_1
      //   60: invokevirtual 60	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   63: aload_0
      //   64: getfield 18	com/tencent/mm/ipcinvoker/b/a$a$a:mRemote	Landroid/os/IBinder;
      //   67: iconst_1
      //   68: aload 5
      //   70: aconst_null
      //   71: iconst_1
      //   72: invokeinterface 66 5 0
      //   77: pop
      //   78: aload 5
      //   80: invokevirtual 69	android/os/Parcel:recycle	()V
      //   83: ldc 21
      //   85: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   88: return
      //   89: aload 5
      //   91: iconst_0
      //   92: invokevirtual 42	android/os/Parcel:writeInt	(I)V
      //   95: goto -58 -> 37
      //   98: astore_1
      //   99: aload 5
      //   101: invokevirtual 69	android/os/Parcel:recycle	()V
      //   104: ldc 21
      //   106: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   109: aload_1
      //   110: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	111	0	this	a
      //   0	111	1	paramBundle	Bundle
      //   0	111	2	paramString	String
      //   0	111	3	paramb	b
      //   1	43	4	localObject	Object
      //   11	89	5	localParcel	Parcel
      // Exception table:
      //   from	to	target	type
      //   13	20	98	finally
      //   24	37	98	finally
      //   37	43	98	finally
      //   50	57	98	finally
      //   57	78	98	finally
      //   89	95	98	finally
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
    
    public final Bundle f(Bundle paramBundle, String paramString)
    {
      AppMethodBeat.i(158782);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            localParcel1.writeString(paramString);
            this.mRemote.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            if (localParcel2.readInt() != 0)
            {
              paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
              return paramBundle;
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          paramBundle = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(158782);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.b.a.a
 * JD-Core Version:    0.7.0.1
 */