package com.c.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class c$a
  extends Binder
  implements c
{
  public static c h(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.securitymgr.IAuthenticationService");
    if ((localIInterface != null) && ((localIInterface instanceof c))) {
      return (c)localIInterface;
    }
    return new c.a.a(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int k = 0;
    int m = 0;
    int i = 0;
    int j = 0;
    boolean bool;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.huawei.securitymgr.IAuthenticationService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
      bool = a(b.a.g(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
      paramInt1 = a(b.a.g(paramParcel1.readStrongBinder()), paramParcel1.createIntArray(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
      a(b.a.g(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
      b(b.a.g(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
      paramParcel1 = c(b.a.g(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeIntArray(paramParcel1);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
      paramParcel1 = oV();
      paramParcel2.writeNoException();
      paramParcel2.writeIntArray(paramParcel1);
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
      bool = dV(paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramInt1 = k;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
      paramInt1 = dW(paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
      bool = aL(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = m;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
      paramParcel1 = b(b.a.g(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
      paramParcel1 = c(b.a.g(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeIntArray(paramParcel1);
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
      paramInt1 = d(b.a.g(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
      b localb = b.a.g(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (bool = true;; bool = false)
      {
        bool = a(localb, paramInt1, bool);
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 14: 
      paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
      long l = d(b.a.g(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
      paramInt1 = a(b.a.g(paramParcel1.readStrongBinder()), paramParcel1.createIntArray(), paramParcel1.createByteArray(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
    paramParcel1 = e(b.a.g(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    paramParcel2.writeByteArray(paramParcel1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.c.a.c.a
 * JD-Core Version:    0.7.0.1
 */