package com.tencent.assistant.sdk.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class SDKActionCallback$Stub
  extends Binder
  implements SDKActionCallback
{
  protected static final String DESCRIPTOR = "com.tencent.assistant.sdk.remote.SDKActionCallback";
  
  public SDKActionCallback$Stub()
  {
    attachInterface(this, "com.tencent.assistant.sdk.remote.SDKActionCallback");
  }
  
  public static SDKActionCallback asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.assistant.sdk.remote.SDKActionCallback");
    if ((localIInterface != null) && ((localIInterface instanceof SDKActionCallback))) {
      return (SDKActionCallback)localIInterface;
    }
    return new SDKActionCallback.Stub.Proxy(paramIBinder);
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
      paramParcel2.writeString("com.tencent.assistant.sdk.remote.SDKActionCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.assistant.sdk.remote.SDKActionCallback");
    onActionResult(paramParcel1.createByteArray());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.assistant.sdk.remote.SDKActionCallback.Stub
 * JD-Core Version:    0.7.0.1
 */