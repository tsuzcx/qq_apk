package com.tencent.mm.ipcinvoker.b;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract interface a
  extends IInterface
{
  public abstract void a(Bundle paramBundle, String paramString, b paramb);
  
  public abstract Bundle e(Bundle paramBundle, String paramString);
  
  private static final class a$a
    implements a
  {
    private IBinder mRemote;
    
    a$a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    /* Error */
    public final void a(Bundle paramBundle, String paramString, b paramb)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   6: astore 5
      //   8: aload 5
      //   10: ldc 28
      //   12: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   15: aload_1
      //   16: ifnull +63 -> 79
      //   19: aload 5
      //   21: iconst_1
      //   22: invokevirtual 36	android/os/Parcel:writeInt	(I)V
      //   25: aload_1
      //   26: aload 5
      //   28: iconst_0
      //   29: invokevirtual 42	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
      //   32: aload 5
      //   34: aload_2
      //   35: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   38: aload 4
      //   40: astore_1
      //   41: aload_3
      //   42: ifnull +10 -> 52
      //   45: aload_3
      //   46: invokeinterface 51 1 0
      //   51: astore_1
      //   52: aload 5
      //   54: aload_1
      //   55: invokevirtual 54	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   58: aload_0
      //   59: getfield 18	com/tencent/mm/ipcinvoker/b/a$a$a:mRemote	Landroid/os/IBinder;
      //   62: iconst_1
      //   63: aload 5
      //   65: aconst_null
      //   66: iconst_1
      //   67: invokeinterface 60 5 0
      //   72: pop
      //   73: aload 5
      //   75: invokevirtual 63	android/os/Parcel:recycle	()V
      //   78: return
      //   79: aload 5
      //   81: iconst_0
      //   82: invokevirtual 36	android/os/Parcel:writeInt	(I)V
      //   85: goto -53 -> 32
      //   88: astore_1
      //   89: aload 5
      //   91: invokevirtual 63	android/os/Parcel:recycle	()V
      //   94: aload_1
      //   95: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	96	0	this	a
      //   0	96	1	paramBundle	Bundle
      //   0	96	2	paramString	String
      //   0	96	3	paramb	b
      //   1	38	4	localObject	Object
      //   6	84	5	localParcel	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	15	88	finally
      //   19	32	88	finally
      //   32	38	88	finally
      //   45	52	88	finally
      //   52	73	88	finally
      //   79	85	88	finally
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
    
    public final Bundle e(Bundle paramBundle, String paramString)
    {
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
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.b.a
 * JD-Core Version:    0.7.0.1
 */