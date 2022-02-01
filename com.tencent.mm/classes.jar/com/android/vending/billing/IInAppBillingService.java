package com.android.vending.billing;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface IInAppBillingService
  extends IInterface
{
  public abstract Bundle a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract int b(int paramInt, String paramString1, String paramString2);
  
  public abstract Bundle b(int paramInt, String paramString1, String paramString2, String paramString3);
  
  public abstract int c(int paramInt, String paramString1, String paramString2);
  
  public abstract Bundle getSkuDetails(int paramInt, String paramString1, String paramString2, Bundle paramBundle);
  
  public static abstract class a
    extends Binder
    implements IInAppBillingService
  {
    public a()
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
    
    public static IInAppBillingService nU()
    {
      return a.awu;
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
      public static IInAppBillingService awu;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public final Bundle a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
      {
        // Byte code:
        //   0: ldc 23
        //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 6
        //   10: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 7
        //   15: aload 6
        //   17: ldc 37
        //   19: invokevirtual 41	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload 6
        //   24: iload_1
        //   25: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   28: aload 6
        //   30: aload_2
        //   31: invokevirtual 47	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   34: aload 6
        //   36: aload_3
        //   37: invokevirtual 47	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   40: aload 6
        //   42: aload 4
        //   44: invokevirtual 47	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   47: aload 6
        //   49: aload 5
        //   51: invokevirtual 47	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   54: aload_0
        //   55: getfield 20	com/android/vending/billing/IInAppBillingService$a$a:mRemote	Landroid/os/IBinder;
        //   58: iconst_3
        //   59: aload 6
        //   61: aload 7
        //   63: iconst_0
        //   64: invokeinterface 53 5 0
        //   69: ifne +42 -> 111
        //   72: invokestatic 57	com/android/vending/billing/IInAppBillingService$a:nU	()Lcom/android/vending/billing/IInAppBillingService;
        //   75: ifnull +36 -> 111
        //   78: invokestatic 57	com/android/vending/billing/IInAppBillingService$a:nU	()Lcom/android/vending/billing/IInAppBillingService;
        //   81: iload_1
        //   82: aload_2
        //   83: aload_3
        //   84: aload 4
        //   86: aload 5
        //   88: invokeinterface 59 6 0
        //   93: astore_2
        //   94: aload 7
        //   96: invokevirtual 62	android/os/Parcel:recycle	()V
        //   99: aload 6
        //   101: invokevirtual 62	android/os/Parcel:recycle	()V
        //   104: ldc 23
        //   106: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   109: aload_2
        //   110: areturn
        //   111: aload 7
        //   113: invokevirtual 68	android/os/Parcel:readException	()V
        //   116: aload 7
        //   118: invokevirtual 72	android/os/Parcel:readInt	()I
        //   121: ifeq +34 -> 155
        //   124: getstatic 78	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   127: aload 7
        //   129: invokeinterface 84 2 0
        //   134: checkcast 74	android/os/Bundle
        //   137: astore_2
        //   138: aload 7
        //   140: invokevirtual 62	android/os/Parcel:recycle	()V
        //   143: aload 6
        //   145: invokevirtual 62	android/os/Parcel:recycle	()V
        //   148: ldc 23
        //   150: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   153: aload_2
        //   154: areturn
        //   155: aconst_null
        //   156: astore_2
        //   157: goto -19 -> 138
        //   160: astore_2
        //   161: aload 7
        //   163: invokevirtual 62	android/os/Parcel:recycle	()V
        //   166: aload 6
        //   168: invokevirtual 62	android/os/Parcel:recycle	()V
        //   171: ldc 23
        //   173: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   176: aload_2
        //   177: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	178	0	this	a
        //   0	178	1	paramInt	int
        //   0	178	2	paramString1	String
        //   0	178	3	paramString2	String
        //   0	178	4	paramString3	String
        //   0	178	5	paramString4	String
        //   8	159	6	localParcel1	Parcel
        //   13	149	7	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	94	160	finally
        //   111	138	160	finally
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
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (IInAppBillingService.a.nU() != null))
          {
            paramInt = IInAppBillingService.a.nU().b(paramInt, paramString1, paramString2);
            return paramInt;
          }
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
        //   0: ldc 93
        //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 6
        //   15: aload 5
        //   17: ldc 37
        //   19: invokevirtual 41	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload 5
        //   24: iload_1
        //   25: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   28: aload 5
        //   30: aload_2
        //   31: invokevirtual 47	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   34: aload 5
        //   36: aload_3
        //   37: invokevirtual 47	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   40: aload 5
        //   42: aload 4
        //   44: invokevirtual 47	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   47: aload_0
        //   48: getfield 20	com/android/vending/billing/IInAppBillingService$a$a:mRemote	Landroid/os/IBinder;
        //   51: iconst_4
        //   52: aload 5
        //   54: aload 6
        //   56: iconst_0
        //   57: invokeinterface 53 5 0
        //   62: ifne +40 -> 102
        //   65: invokestatic 57	com/android/vending/billing/IInAppBillingService$a:nU	()Lcom/android/vending/billing/IInAppBillingService;
        //   68: ifnull +34 -> 102
        //   71: invokestatic 57	com/android/vending/billing/IInAppBillingService$a:nU	()Lcom/android/vending/billing/IInAppBillingService;
        //   74: iload_1
        //   75: aload_2
        //   76: aload_3
        //   77: aload 4
        //   79: invokeinterface 95 5 0
        //   84: astore_2
        //   85: aload 6
        //   87: invokevirtual 62	android/os/Parcel:recycle	()V
        //   90: aload 5
        //   92: invokevirtual 62	android/os/Parcel:recycle	()V
        //   95: ldc 93
        //   97: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   100: aload_2
        //   101: areturn
        //   102: aload 6
        //   104: invokevirtual 68	android/os/Parcel:readException	()V
        //   107: aload 6
        //   109: invokevirtual 72	android/os/Parcel:readInt	()I
        //   112: ifeq +34 -> 146
        //   115: getstatic 78	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   118: aload 6
        //   120: invokeinterface 84 2 0
        //   125: checkcast 74	android/os/Bundle
        //   128: astore_2
        //   129: aload 6
        //   131: invokevirtual 62	android/os/Parcel:recycle	()V
        //   134: aload 5
        //   136: invokevirtual 62	android/os/Parcel:recycle	()V
        //   139: ldc 93
        //   141: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   144: aload_2
        //   145: areturn
        //   146: aconst_null
        //   147: astore_2
        //   148: goto -19 -> 129
        //   151: astore_2
        //   152: aload 6
        //   154: invokevirtual 62	android/os/Parcel:recycle	()V
        //   157: aload 5
        //   159: invokevirtual 62	android/os/Parcel:recycle	()V
        //   162: ldc 93
        //   164: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   167: aload_2
        //   168: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	169	0	this	a
        //   0	169	1	paramInt	int
        //   0	169	2	paramString1	String
        //   0	169	3	paramString2	String
        //   0	169	4	paramString3	String
        //   8	150	5	localParcel1	Parcel
        //   13	140	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	85	151	finally
        //   102	129	151	finally
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
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (IInAppBillingService.a.nU() != null))
          {
            paramInt = IInAppBillingService.a.nU().c(paramInt, paramString1, paramString2);
            return paramInt;
          }
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
          }
          while ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (IInAppBillingService.a.nU() != null))
          {
            paramString1 = IInAppBillingService.a.nU().getSkuDetails(paramInt, paramString1, paramString2, paramBundle);
            return paramString1;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(63281);
        }
        if (localParcel2.readInt() != 0) {}
        for (paramString1 = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);; paramString1 = null)
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(63281);
          return paramString1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.android.vending.billing.IInAppBillingService
 * JD-Core Version:    0.7.0.1
 */