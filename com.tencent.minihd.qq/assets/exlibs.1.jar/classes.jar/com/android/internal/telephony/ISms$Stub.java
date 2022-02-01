package com.android.internal.telephony;

import a;
import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class ISms$Stub
  extends Binder
  implements ISms
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "com.android.internal.telephony.ISms";
  static final int b = 2;
  static final int c = 3;
  static final int d = 4;
  static final int e = 5;
  static final int f = 6;
  static final int g = 7;
  static final int h = 8;
  
  public ISms$Stub()
  {
    attachInterface(this, "com.android.internal.telephony.ISms");
  }
  
  public static ISms a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.android.internal.telephony.ISms");
    if ((localIInterface != null) && ((localIInterface instanceof ISms))) {
      return (ISms)localIInterface;
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
    int j = 0;
    int k = 0;
    int m = 0;
    int i = 0;
    String str1;
    String str2;
    PendingIntent localPendingIntent;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.android.internal.telephony.ISms");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISms");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISms");
      bool = a(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISms");
      bool = a(paramParcel1.readInt(), paramParcel1.createByteArray(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISms");
      str1 = paramParcel1.readString();
      str2 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      byte[] arrayOfByte = paramParcel1.createByteArray();
      if (paramParcel1.readInt() != 0) {}
      for (localPendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent = null)
      {
        if (paramParcel1.readInt() != 0) {
          localObject = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        }
        a(str1, str2, paramInt1, arrayOfByte, localPendingIntent, (PendingIntent)localObject);
        paramParcel2.writeNoException();
        return true;
      }
    case 5: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISms");
      localObject = paramParcel1.readString();
      str1 = paramParcel1.readString();
      str2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        localPendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label418;
        }
      }
      for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((String)localObject, str1, str2, localPendingIntent, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localPendingIntent = null;
        break;
      }
    case 6: 
      paramParcel1.enforceInterface("com.android.internal.telephony.ISms");
      a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArrayList(), paramParcel1.createTypedArrayList(PendingIntent.CREATOR), paramParcel1.createTypedArrayList(PendingIntent.CREATOR));
      paramParcel2.writeNoException();
      return true;
    case 7: 
      label418:
      paramParcel1.enforceInterface("com.android.internal.telephony.ISms");
      bool = a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramInt1 = k;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel1.enforceInterface("com.android.internal.telephony.ISms");
    boolean bool = b(paramParcel1.readInt());
    paramParcel2.writeNoException();
    paramInt1 = m;
    if (bool) {
      paramInt1 = 1;
    }
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.android.internal.telephony.ISms.Stub
 * JD-Core Version:    0.7.0.1
 */