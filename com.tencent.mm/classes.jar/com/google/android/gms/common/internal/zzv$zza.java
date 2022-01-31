package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class zzv$zza
  extends Binder
  implements zzv
{
  public static zzv zzbu(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
    if ((localIInterface != null) && ((localIInterface instanceof zzv))) {
      return (zzv)localIInterface;
    }
    return new zzv.zza.zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 > 16777215) {
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
    zzu localzzu = zzu.zza.zzbt(paramParcel1.readStrongBinder());
    if (paramInt1 == 46) {
      if (paramParcel1.readInt() == 0) {
        break label684;
      }
    }
    label679:
    label684:
    for (paramParcel1 = (zzj)zzj.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      zza(localzzu, paramParcel1);
      paramParcel2.writeNoException();
      return true;
      if (paramInt1 == 47) {
        if (paramParcel1.readInt() == 0) {
          break label679;
        }
      }
      for (paramParcel1 = (zzan)zzan.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zza(localzzu, paramParcel1);
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
            zza(paramInt1, localzzu, paramInt2, str4, str3, arrayOfString, paramParcel1, localIBinder, str2, str1);
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
  
  protected void zza(int paramInt1, zzu paramzzu, int paramInt2, String paramString1, String paramString2, String[] paramArrayOfString, Bundle paramBundle, IBinder paramIBinder, String paramString3, String paramString4)
  {
    throw new UnsupportedOperationException();
  }
  
  protected void zza(zzu paramzzu, zzan paramzzan)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzv.zza
 * JD-Core Version:    0.7.0.1
 */