package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface q
  extends IInterface
{
  public abstract void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public static abstract class a
    extends Binder
    implements q
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.network.IOnReportKV_AIDL");
    }
    
    public static q bjI()
    {
      return a.jDY;
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
        paramParcel2.writeString("com.tencent.mm.network.IOnReportKV_AIDL");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.network.IOnReportKV_AIDL");
      long l = paramParcel1.readLong();
      String str = paramParcel1.readString();
      boolean bool1;
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label108;
        }
      }
      label108:
      for (boolean bool2 = true;; bool2 = false)
      {
        a(l, str, bool1, bool2);
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
      }
    }
    
    static final class a
      implements q
    {
      public static q jDY;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
      {
        int j = 1;
        AppMethodBeat.i(132748);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IOnReportKV_AIDL");
          localParcel1.writeLong(paramLong);
          localParcel1.writeString(paramString);
          if (paramBoolean1)
          {
            i = 1;
            localParcel1.writeInt(i);
            if (!paramBoolean2) {
              break label128;
            }
          }
          label128:
          for (int i = j;; i = 0)
          {
            localParcel1.writeInt(i);
            if ((this.mRemote.transact(1, localParcel1, localParcel2, 0)) || (q.a.bjI() == null)) {
              break label134;
            }
            q.a.bjI().a(paramLong, paramString, paramBoolean1, paramBoolean2);
            return;
            i = 0;
            break;
          }
          label134:
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132748);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.q
 * JD-Core Version:    0.7.0.1
 */