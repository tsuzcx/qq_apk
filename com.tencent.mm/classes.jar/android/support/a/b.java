package android.support.a;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract interface b
  extends IInterface
{
  public abstract boolean R();
  
  public abstract Bundle S();
  
  public abstract boolean a(a parama);
  
  public abstract boolean b(a parama);
  
  public abstract boolean c(a parama);
  
  public abstract boolean d(a parama);
  
  public abstract int e(a parama);
  
  public abstract boolean f(a parama);
  
  public static abstract class a
    extends Binder
    implements b
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
        bool = R();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        bool = a(a.a.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        locala = a.a.a(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          Uri.CREATOR.createFromParcel(paramParcel1);
        }
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1.createTypedArrayList(Bundle.CREATOR);
        bool = b(locala);
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
        paramParcel1 = S();
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
        locala = a.a.a(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        bool = c(locala);
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        locala = a.a.a(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          Uri.CREATOR.createFromParcel(paramParcel1);
        }
        bool = d(locala);
        paramParcel2.writeNoException();
        paramInt1 = n;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
        locala = a.a.a(paramParcel1.readStrongBinder());
        paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = e(locala);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
      a locala = a.a.a(paramParcel1.readStrongBinder());
      paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {
        Uri.CREATOR.createFromParcel(paramParcel1);
      }
      if (paramParcel1.readInt() != 0) {
        Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      boolean bool = f(locala);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.a.b
 * JD-Core Version:    0.7.0.1
 */