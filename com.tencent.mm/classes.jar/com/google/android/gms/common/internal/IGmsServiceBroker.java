package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract interface IGmsServiceBroker
  extends IInterface
{
  public abstract void getService(IGmsCallbacks paramIGmsCallbacks, GetServiceRequest paramGetServiceRequest);
  
  public static abstract class Stub
    extends Binder
    implements IGmsServiceBroker
  {
    public Stub()
    {
      attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
    }
    
    public static IGmsServiceBroker asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      if ((localIInterface != null) && ((localIInterface instanceof IGmsServiceBroker))) {
        return (IGmsServiceBroker)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    protected void getLegacyService(int paramInt1, IGmsCallbacks paramIGmsCallbacks, int paramInt2, String paramString1, String paramString2, String[] paramArrayOfString, Bundle paramBundle, IBinder paramIBinder, String paramString3, String paramString4)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      if (paramInt1 > 16777215) {
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      IGmsCallbacks localIGmsCallbacks = IGmsCallbacks.Stub.asInterface(paramParcel1.readStrongBinder());
      if (paramInt1 == 46) {
        if (paramParcel1.readInt() == 0) {
          break label684;
        }
      }
      label679:
      label684:
      for (paramParcel1 = (GetServiceRequest)GetServiceRequest.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        getService(localIGmsCallbacks, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        if (paramInt1 == 47) {
          if (paramParcel1.readInt() == 0) {
            break label679;
          }
        }
        for (paramParcel1 = (ValidateAccountRequest)ValidateAccountRequest.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          validateAccount(localIGmsCallbacks, paramParcel1);
          break;
          paramInt2 = paramParcel1.readInt();
          if (paramInt1 != 4) {}
          for (String str4 = paramParcel1.readString();; str4 = null)
          {
            label312:
            String str1;
            String str2;
            IBinder localIBinder;
            String[] arrayOfString;
            String str3;
            switch (paramInt1)
            {
            case 3: 
            case 4: 
            case 21: 
            case 22: 
            case 24: 
            case 26: 
            case 28: 
            case 29: 
            case 31: 
            case 32: 
            case 33: 
            case 35: 
            case 36: 
            case 39: 
            case 40: 
            case 42: 
            default: 
              str1 = null;
              str2 = null;
              localIBinder = null;
              paramParcel1 = null;
              arrayOfString = null;
              str3 = null;
            }
            for (;;)
            {
              getLegacyService(paramInt1, localIGmsCallbacks, paramInt2, str4, str3, arrayOfString, paramParcel1, localIBinder, str2, str1);
              break;
              localIBinder = paramParcel1.readStrongBinder();
              if (paramParcel1.readInt() != 0)
              {
                paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
                str1 = null;
                str2 = null;
                arrayOfString = null;
                str3 = null;
                continue;
                str2 = paramParcel1.readString();
                arrayOfString = paramParcel1.createStringArray();
                str3 = paramParcel1.readString();
                if (paramParcel1.readInt() != 0)
                {
                  paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
                  str1 = null;
                  localIBinder = null;
                  continue;
                  str3 = paramParcel1.readString();
                  arrayOfString = paramParcel1.createStringArray();
                  str2 = paramParcel1.readString();
                  localIBinder = paramParcel1.readStrongBinder();
                  str1 = paramParcel1.readString();
                  if (paramParcel1.readInt() != 0)
                  {
                    paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
                    continue;
                    arrayOfString = paramParcel1.createStringArray();
                    str3 = paramParcel1.readString();
                    if (paramParcel1.readInt() != 0)
                    {
                      paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
                      str1 = null;
                      str2 = null;
                      localIBinder = null;
                      continue;
                      str3 = paramParcel1.readString();
                      arrayOfString = paramParcel1.createStringArray();
                      str1 = null;
                      str2 = null;
                      localIBinder = null;
                      paramParcel1 = null;
                      continue;
                      str3 = paramParcel1.readString();
                      str1 = null;
                      str2 = null;
                      localIBinder = null;
                      paramParcel1 = null;
                      arrayOfString = null;
                      continue;
                      if (paramParcel1.readInt() == 0) {
                        break label312;
                      }
                      paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
                      str1 = null;
                      str2 = null;
                      localIBinder = null;
                      arrayOfString = null;
                      str3 = null;
                      continue;
                    }
                    str1 = null;
                    str2 = null;
                    localIBinder = null;
                    paramParcel1 = null;
                    continue;
                  }
                  paramParcel1 = null;
                  continue;
                }
                str1 = null;
                localIBinder = null;
                paramParcel1 = null;
                continue;
              }
              str1 = null;
              str2 = null;
              paramParcel1 = null;
              arrayOfString = null;
              str3 = null;
            }
          }
        }
      }
    }
    
    protected void validateAccount(IGmsCallbacks paramIGmsCallbacks, ValidateAccountRequest paramValidateAccountRequest)
    {
      throw new UnsupportedOperationException();
    }
    
    static final class zza
      implements IGmsServiceBroker
    {
      private final IBinder zza;
      
      zza(IBinder paramIBinder)
      {
        this.zza = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return this.zza;
      }
      
      /* Error */
      public final void getService(IGmsCallbacks paramIGmsCallbacks, GetServiceRequest paramGetServiceRequest)
      {
        // Byte code:
        //   0: ldc 24
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 38
        //   17: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +66 -> 87
        //   24: aload_1
        //   25: invokeinterface 46 1 0
        //   30: astore_1
        //   31: aload_3
        //   32: aload_1
        //   33: invokevirtual 49	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload_2
        //   37: ifnull +55 -> 92
        //   40: aload_3
        //   41: iconst_1
        //   42: invokevirtual 52	android/os/Parcel:writeInt	(I)V
        //   45: aload_2
        //   46: aload_3
        //   47: iconst_0
        //   48: invokevirtual 58	com/google/android/gms/common/internal/GetServiceRequest:writeToParcel	(Landroid/os/Parcel;I)V
        //   51: aload_0
        //   52: getfield 18	com/google/android/gms/common/internal/IGmsServiceBroker$Stub$zza:zza	Landroid/os/IBinder;
        //   55: bipush 46
        //   57: aload_3
        //   58: aload 4
        //   60: iconst_0
        //   61: invokeinterface 64 5 0
        //   66: pop
        //   67: aload 4
        //   69: invokevirtual 67	android/os/Parcel:readException	()V
        //   72: aload 4
        //   74: invokevirtual 70	android/os/Parcel:recycle	()V
        //   77: aload_3
        //   78: invokevirtual 70	android/os/Parcel:recycle	()V
        //   81: ldc 24
        //   83: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   86: return
        //   87: aconst_null
        //   88: astore_1
        //   89: goto -58 -> 31
        //   92: aload_3
        //   93: iconst_0
        //   94: invokevirtual 52	android/os/Parcel:writeInt	(I)V
        //   97: goto -46 -> 51
        //   100: astore_1
        //   101: aload 4
        //   103: invokevirtual 70	android/os/Parcel:recycle	()V
        //   106: aload_3
        //   107: invokevirtual 70	android/os/Parcel:recycle	()V
        //   110: ldc 24
        //   112: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   115: aload_1
        //   116: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	117	0	this	zza
        //   0	117	1	paramIGmsCallbacks	IGmsCallbacks
        //   0	117	2	paramGetServiceRequest	GetServiceRequest
        //   8	99	3	localParcel1	Parcel
        //   12	90	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	20	100	finally
        //   24	31	100	finally
        //   31	36	100	finally
        //   40	51	100	finally
        //   51	72	100	finally
        //   92	97	100	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.IGmsServiceBroker
 * JD-Core Version:    0.7.0.1
 */