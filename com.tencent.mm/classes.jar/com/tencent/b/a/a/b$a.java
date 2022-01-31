package com.tencent.b.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b$a
  extends Binder
  implements b
{
  private static final String DESCRIPTOR = "com.tencent.assistant.sdk.SDKActionCallback";
  static final int TRANSACTION_onActionResult = 1;
  
  public b$a()
  {
    attachInterface(this, "com.tencent.assistant.sdk.SDKActionCallback");
  }
  
  public static b asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.assistant.sdk.SDKActionCallback");
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
      paramParcel2.writeString("com.tencent.assistant.sdk.SDKActionCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.assistant.sdk.SDKActionCallback");
    onActionResult(paramParcel1.createByteArray());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.b.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */