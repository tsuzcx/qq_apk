package com.tencent.matrix.openglleak.detector;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.Map;

public abstract interface a
  extends IInterface
{
  public abstract Map ayJ();
  
  public abstract void destory();
  
  public static abstract class a
    extends Binder
    implements a
  {
    public a()
    {
      attachInterface(this, "com.tencent.matrix.openglleak.detector.IOpenglIndexDetector");
    }
    
    public static a ayK()
    {
      return a.eWR;
    }
    
    public static a o(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.matrix.openglleak.detector.IOpenglIndexDetector");
      if ((localIInterface != null) && ((localIInterface instanceof a))) {
        return (a)localIInterface;
      }
      return new a(paramIBinder);
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
        paramParcel2.writeString("com.tencent.matrix.openglleak.detector.IOpenglIndexDetector");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.matrix.openglleak.detector.IOpenglIndexDetector");
        paramParcel1 = ayJ();
        paramParcel2.writeNoException();
        paramParcel2.writeMap(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.matrix.openglleak.detector.IOpenglIndexDetector");
      destory();
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements a
    {
      public static a eWR;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final Map ayJ()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.matrix.openglleak.detector.IOpenglIndexDetector");
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (a.a.ayK() != null))
          {
            localObject1 = a.a.ayK().ayJ();
            return localObject1;
          }
          localParcel2.readException();
          Object localObject1 = localParcel2.readHashMap(getClass().getClassLoader());
          return localObject1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void destory()
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.matrix.openglleak.detector.IOpenglIndexDetector");
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (a.a.ayK() != null))
          {
            a.a.ayK().destory();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.openglleak.detector.a
 * JD-Core Version:    0.7.0.1
 */