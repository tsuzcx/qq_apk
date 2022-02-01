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
        //   0: sipush 4695
        //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   6: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   9: astore_3
        //   10: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 4
        //   15: aload_3
        //   16: ldc 37
        //   18: invokevirtual 41	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   21: aload_1
        //   22: ifnull +67 -> 89
        //   25: aload_1
        //   26: invokeinterface 45 1 0
        //   31: astore_1
        //   32: aload_3
        //   33: aload_1
        //   34: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   37: aload_2
        //   38: ifnull +56 -> 94
        //   41: aload_3
        //   42: iconst_1
        //   43: invokevirtual 51	android/os/Parcel:writeInt	(I)V
        //   46: aload_2
        //   47: aload_3
        //   48: iconst_0
        //   49: invokevirtual 57	com/google/android/gms/common/internal/GetServiceRequest:writeToParcel	(Landroid/os/Parcel;I)V
        //   52: aload_0
        //   53: getfield 18	com/google/android/gms/common/internal/IGmsServiceBroker$Stub$zza:zza	Landroid/os/IBinder;
        //   56: bipush 46
        //   58: aload_3
        //   59: aload 4
        //   61: iconst_0
        //   62: invokeinterface 63 5 0
        //   67: pop
        //   68: aload 4
        //   70: invokevirtual 66	android/os/Parcel:readException	()V
        //   73: aload 4
        //   75: invokevirtual 69	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: invokevirtual 69	android/os/Parcel:recycle	()V
        //   82: sipush 4695
        //   85: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   88: return
        //   89: aconst_null
        //   90: astore_1
        //   91: goto -59 -> 32
        //   94: aload_3
        //   95: iconst_0
        //   96: invokevirtual 51	android/os/Parcel:writeInt	(I)V
        //   99: goto -47 -> 52
        //   102: astore_1
        //   103: aload 4
        //   105: invokevirtual 69	android/os/Parcel:recycle	()V
        //   108: aload_3
        //   109: invokevirtual 69	android/os/Parcel:recycle	()V
        //   112: sipush 4695
        //   115: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   118: aload_1
        //   119: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	120	0	this	zza
        //   0	120	1	paramIGmsCallbacks	IGmsCallbacks
        //   0	120	2	paramGetServiceRequest	GetServiceRequest
        //   9	100	3	localParcel1	Parcel
        //   13	91	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	21	102	finally
        //   25	32	102	finally
        //   32	37	102	finally
        //   41	52	102	finally
        //   52	73	102	finally
        //   94	99	102	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.IGmsServiceBroker
 * JD-Core Version:    0.7.0.1
 */