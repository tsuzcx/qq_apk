package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class a$a
  extends Binder
  implements a
{
  public static a aN()
  {
    return a.co;
  }
  
  public static a b(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
    if ((localIInterface != null) && ((localIInterface instanceof a))) {
      return (a)localIInterface;
    }
    return new a(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("android.support.v4.app.INotificationSideChannel");
      return true;
    case 1: 
      paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
      paramParcel2 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      String str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Notification)Notification.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel2, paramInt1, str, paramParcel1);
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
      c(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString());
      return true;
    }
    paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
    n(paramParcel1.readString());
    return true;
  }
  
  static final class a
    implements a
  {
    public static a co;
    private IBinder mRemote;
    
    a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    public final void a(String paramString1, int paramInt, String paramString2, Notification paramNotification)
    {
      Parcel localParcel = Parcel.obtain();
      try
      {
        localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
        localParcel.writeString(paramString1);
        localParcel.writeInt(paramInt);
        localParcel.writeString(paramString2);
        if (paramNotification != null)
        {
          localParcel.writeInt(1);
          paramNotification.writeToParcel(localParcel, 0);
        }
        while ((!this.mRemote.transact(1, localParcel, null, 1)) && (a.a.aN() != null))
        {
          a.a.aN().a(paramString1, paramInt, paramString2, paramNotification);
          return;
          localParcel.writeInt(0);
        }
      }
      finally
      {
        localParcel.recycle();
      }
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
    
    public final void c(String paramString1, int paramInt, String paramString2)
    {
      Parcel localParcel = Parcel.obtain();
      try
      {
        localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
        localParcel.writeString(paramString1);
        localParcel.writeInt(paramInt);
        localParcel.writeString(paramString2);
        if ((!this.mRemote.transact(2, localParcel, null, 1)) && (a.a.aN() != null))
        {
          a.a.aN().c(paramString1, paramInt, paramString2);
          return;
        }
        return;
      }
      finally
      {
        localParcel.recycle();
      }
    }
    
    public final void n(String paramString)
    {
      Parcel localParcel = Parcel.obtain();
      try
      {
        localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
        localParcel.writeString(paramString);
        if ((!this.mRemote.transact(3, localParcel, null, 1)) && (a.a.aN() != null))
        {
          a.a.aN().n(paramString);
          return;
        }
        return;
      }
      finally
      {
        localParcel.recycle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.app.a.a
 * JD-Core Version:    0.7.0.1
 */