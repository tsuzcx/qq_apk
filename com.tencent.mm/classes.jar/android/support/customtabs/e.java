package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract interface e
  extends IInterface
{
  public abstract boolean a(d paramd);
  
  public abstract boolean af();
  
  public abstract Bundle ao();
  
  public abstract boolean b(d paramd);
  
  public abstract boolean c(d paramd);
  
  public abstract boolean d(d paramd);
  
  public abstract int e(d paramd);
  
  public abstract boolean f(d paramd);
  
  public static abstract class a
    extends Binder
    implements e
  {
    public a()
    {
      attachInterface(this, "android.support.customtabs.ICustomTabsService");
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      int j = 0;
      int k = 0;
      int m = 0;
      int n = 0;
      int i1 = 0;
      int i = 0;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("android.support.customtabs.ICustomTabsService");
        return true;
      case 2: 
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        paramParcel1.readLong();
        bool = af();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        bool = a(d.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        locald = d.a.a(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          Uri.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1.createTypedArrayList(Bundle.CREATOR);
        bool = b(locald);
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = ao();
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 6: 
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        locald = d.a.a(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        bool = c(locald);
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        locald = d.a.a(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          Uri.CREATOR.createFromParcel(paramParcel1);
        }
        bool = d(locald);
        paramParcel2.writeNoException();
        paramInt1 = n;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        locald = d.a.a(paramParcel1.readStrongBinder());
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = e(locald);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
      d locald = d.a.a(paramParcel1.readStrongBinder());
      paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {
        Uri.CREATOR.createFromParcel(paramParcel1);
      }
      if (paramParcel1.readInt() != 0) {
        Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      boolean bool = f(locald);
      paramParcel2.writeNoException();
      paramInt1 = i1;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.customtabs.e
 * JD-Core Version:    0.7.0.1
 */