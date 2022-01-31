package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract interface d
  extends IInterface
{
  public abstract void a(int paramInt, Uri paramUri, boolean paramBoolean, Bundle paramBundle);
  
  public abstract void a(int paramInt, Bundle paramBundle);
  
  public abstract void b(Bundle paramBundle);
  
  public abstract void b(String paramString, Bundle paramBundle);
  
  public abstract void c(String paramString, Bundle paramBundle);
  
  public static abstract class a
    extends Binder
    implements d
  {
    public static d a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.customtabs.ICustomTabsCallback");
      if ((localIInterface != null) && ((localIInterface instanceof d))) {
        return (d)localIInterface;
      }
      return new d.a.a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      Object localObject;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("android.support.customtabs.ICustomTabsCallback");
        return true;
      case 2: 
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          a(paramInt1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 3: 
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
        localObject = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          b((String)localObject, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 4: 
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          b(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 5: 
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
        localObject = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          c((String)localObject, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      }
      paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
      paramInt1 = paramParcel1.readInt();
      boolean bool;
      if (paramParcel1.readInt() != 0)
      {
        localObject = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label352;
        }
        bool = true;
        label310:
        if (paramParcel1.readInt() == 0) {
          break label358;
        }
      }
      label352:
      label358:
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramInt1, (Uri)localObject, bool, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject = null;
        break;
        bool = false;
        break label310;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.customtabs.d
 * JD-Core Version:    0.7.0.1
 */