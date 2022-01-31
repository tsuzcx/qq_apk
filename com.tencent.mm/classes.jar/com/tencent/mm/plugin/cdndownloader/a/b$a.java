package com.tencent.mm.plugin.cdndownloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b$a
  extends Binder
  implements b
{
  public b$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
  }
  
  public static b s(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
    if ((localIInterface != null) && ((localIInterface instanceof b))) {
      return (b)localIInterface;
    }
    return new b.a.a(paramIBinder);
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
      paramParcel2.writeString("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
      e(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
    s(paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readLong());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.a.b.a
 * JD-Core Version:    0.7.0.1
 */