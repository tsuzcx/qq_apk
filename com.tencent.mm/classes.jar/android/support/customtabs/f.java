package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract interface f
  extends IInterface
{
  public abstract void a(d paramd, Bundle paramBundle);
  
  public abstract void a(d paramd, String paramString, Bundle paramBundle);
  
  public static abstract class a
    extends Binder
    implements f
  {
    public a()
    {
      attachInterface(this, "android.support.customtabs.IPostMessageService");
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      Object localObject1 = null;
      d locald = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("android.support.customtabs.IPostMessageService");
        return true;
      case 2: 
        paramParcel1.enforceInterface("android.support.customtabs.IPostMessageService");
        localObject2 = d.a.a(paramParcel1.readStrongBinder());
        localObject1 = locald;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a((d)localObject2, (Bundle)localObject1);
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("android.support.customtabs.IPostMessageService");
      locald = d.a.a(paramParcel1.readStrongBinder());
      Object localObject2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      a(locald, (String)localObject2, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.customtabs.f
 * JD-Core Version:    0.7.0.1
 */