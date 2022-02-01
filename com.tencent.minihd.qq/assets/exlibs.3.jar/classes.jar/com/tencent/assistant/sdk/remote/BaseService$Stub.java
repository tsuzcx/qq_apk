package com.tencent.assistant.sdk.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class BaseService$Stub
  extends Binder
  implements BaseService
{
  protected static final String DESCRIPTOR = "com.tencent.assistant.sdk.remote.BaseService";
  
  public BaseService$Stub()
  {
    attachInterface(this, "com.tencent.assistant.sdk.remote.BaseService");
  }
  
  public static BaseService asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.assistant.sdk.remote.BaseService");
    if ((localIInterface != null) && ((localIInterface instanceof BaseService))) {
      return (BaseService)localIInterface;
    }
    return new BaseService.Stub.Proxy(paramIBinder);
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
      paramParcel2.writeString("com.tencent.assistant.sdk.remote.BaseService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.assistant.sdk.remote.BaseService");
      paramInt1 = registerActionCallback(paramParcel1.readString(), paramParcel1.readString(), SDKActionCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.assistant.sdk.remote.BaseService");
      paramInt1 = unregisterActionCallback(SDKActionCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.assistant.sdk.remote.BaseService");
      paramParcel1 = sendSyncData(paramParcel1.readString(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.assistant.sdk.remote.BaseService");
    sendAsyncData(paramParcel1.readString(), paramParcel1.createByteArray());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.assistant.sdk.remote.BaseService.Stub
 * JD-Core Version:    0.7.0.1
 */