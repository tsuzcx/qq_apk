package com.android.vending.billing;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class IInAppBillingService$a
  extends Binder
  implements IInAppBillingService
{
  public IInAppBillingService$a()
  {
    attachInterface(this, "com.android.vending.billing.IInAppBillingService");
  }
  
  public static IInAppBillingService f(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
    if ((localIInterface != null) && ((localIInterface instanceof IInAppBillingService))) {
      return (IInAppBillingService)localIInterface;
    }
    return new a(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.android.vending.billing.IInAppBillingService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
      paramInt1 = b(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
      paramInt1 = paramParcel1.readInt();
      String str1 = paramParcel1.readString();
      String str2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        paramParcel1 = getSkuDetails(paramInt1, str1, str2, paramParcel1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label192;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel1 = null;
        break;
        paramParcel2.writeInt(0);
      }
    case 3: 
      paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
      paramParcel1 = a(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    case 4: 
      label192:
      paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
      paramParcel1 = b(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    }
    paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
    paramInt1 = c(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
    paramParcel2.writeNoException();
    paramParcel2.writeInt(paramInt1);
    return true;
  }
  
  static final class a
    implements IInAppBillingService
  {
    private IBinder mRemote;
    
    a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    /* Error */
    public final Bundle a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      // Byte code:
      //   0: ldc 21
      //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   8: astore 6
      //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   13: astore 7
      //   15: aload 6
      //   17: ldc 35
      //   19: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   22: aload 6
      //   24: iload_1
      //   25: invokevirtual 42	android/os/Parcel:writeInt	(I)V
      //   28: aload 6
      //   30: aload_2
      //   31: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   34: aload 6
      //   36: aload_3
      //   37: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   40: aload 6
      //   42: aload 4
      //   44: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   47: aload 6
      //   49: aload 5
      //   51: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   54: aload_0
      //   55: getfield 18	com/android/vending/billing/IInAppBillingService$a$a:mRemote	Landroid/os/IBinder;
      //   58: iconst_3
      //   59: aload 6
      //   61: aload 7
      //   63: iconst_0
      //   64: invokeinterface 51 5 0
      //   69: pop
      //   70: aload 7
      //   72: invokevirtual 54	android/os/Parcel:readException	()V
      //   75: aload 7
      //   77: invokevirtual 58	android/os/Parcel:readInt	()I
      //   80: ifeq +34 -> 114
      //   83: getstatic 64	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
      //   86: aload 7
      //   88: invokeinterface 70 2 0
      //   93: checkcast 60	android/os/Bundle
      //   96: astore_2
      //   97: aload 7
      //   99: invokevirtual 73	android/os/Parcel:recycle	()V
      //   102: aload 6
      //   104: invokevirtual 73	android/os/Parcel:recycle	()V
      //   107: ldc 21
      //   109: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   112: aload_2
      //   113: areturn
      //   114: aconst_null
      //   115: astore_2
      //   116: goto -19 -> 97
      //   119: astore_2
      //   120: aload 7
      //   122: invokevirtual 73	android/os/Parcel:recycle	()V
      //   125: aload 6
      //   127: invokevirtual 73	android/os/Parcel:recycle	()V
      //   130: ldc 21
      //   132: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   135: aload_2
      //   136: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	137	0	this	a
      //   0	137	1	paramInt	int
      //   0	137	2	paramString1	String
      //   0	137	3	paramString2	String
      //   0	137	4	paramString3	String
      //   0	137	5	paramString4	String
      //   8	118	6	localParcel1	Parcel
      //   13	108	7	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   15	97	119	finally
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
    
    public final int b(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(63280);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        localParcel1.writeInt(paramInt);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        this.mRemote.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramInt = localParcel2.readInt();
        return paramInt;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(63280);
      }
    }
    
    /* Error */
    public final Bundle b(int paramInt, String paramString1, String paramString2, String paramString3)
    {
      // Byte code:
      //   0: ldc 83
      //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   8: astore 5
      //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   13: astore 6
      //   15: aload 5
      //   17: ldc 35
      //   19: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   22: aload 5
      //   24: iload_1
      //   25: invokevirtual 42	android/os/Parcel:writeInt	(I)V
      //   28: aload 5
      //   30: aload_2
      //   31: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   34: aload 5
      //   36: aload_3
      //   37: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   40: aload 5
      //   42: aload 4
      //   44: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   47: aload_0
      //   48: getfield 18	com/android/vending/billing/IInAppBillingService$a$a:mRemote	Landroid/os/IBinder;
      //   51: iconst_4
      //   52: aload 5
      //   54: aload 6
      //   56: iconst_0
      //   57: invokeinterface 51 5 0
      //   62: pop
      //   63: aload 6
      //   65: invokevirtual 54	android/os/Parcel:readException	()V
      //   68: aload 6
      //   70: invokevirtual 58	android/os/Parcel:readInt	()I
      //   73: ifeq +34 -> 107
      //   76: getstatic 64	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
      //   79: aload 6
      //   81: invokeinterface 70 2 0
      //   86: checkcast 60	android/os/Bundle
      //   89: astore_2
      //   90: aload 6
      //   92: invokevirtual 73	android/os/Parcel:recycle	()V
      //   95: aload 5
      //   97: invokevirtual 73	android/os/Parcel:recycle	()V
      //   100: ldc 83
      //   102: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   105: aload_2
      //   106: areturn
      //   107: aconst_null
      //   108: astore_2
      //   109: goto -19 -> 90
      //   112: astore_2
      //   113: aload 6
      //   115: invokevirtual 73	android/os/Parcel:recycle	()V
      //   118: aload 5
      //   120: invokevirtual 73	android/os/Parcel:recycle	()V
      //   123: ldc 83
      //   125: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   128: aload_2
      //   129: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	130	0	this	a
      //   0	130	1	paramInt	int
      //   0	130	2	paramString1	String
      //   0	130	3	paramString2	String
      //   0	130	4	paramString3	String
      //   8	111	5	localParcel1	Parcel
      //   13	101	6	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   15	90	112	finally
    }
    
    public final int c(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(63284);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        localParcel1.writeInt(paramInt);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        this.mRemote.transact(5, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramInt = localParcel2.readInt();
        return paramInt;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(63284);
      }
    }
    
    public final Bundle getSkuDetails(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
    {
      AppMethodBeat.i(63281);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            this.mRemote.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            if (localParcel2.readInt() != 0)
            {
              paramString1 = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
              return paramString1;
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          paramString1 = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(63281);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.android.vending.billing.IInAppBillingService.a
 * JD-Core Version:    0.7.0.1
 */