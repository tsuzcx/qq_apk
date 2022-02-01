package com.huawei.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public abstract class a$a
  extends Binder
  implements a
{
  public static a i(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.multimedia.audioengine.IHwAudioEngine");
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
      paramParcel2.writeString("com.huawei.multimedia.audioengine.IHwAudioEngine");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioEngine");
      paramParcel1 = akd();
      paramParcel2.writeNoException();
      paramParcel2.writeList(paramParcel1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioEngine");
      boolean bool = lJ(paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    }
    paramParcel1.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioEngine");
    F(paramParcel1.readString(), paramParcel1.readString());
    paramParcel2.writeNoException();
    return true;
  }
  
  static final class a
    implements a
  {
    private IBinder mRemote;
    
    a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    public final void F(String paramString1, String paramString2)
    {
      AppMethodBeat.i(208287);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        this.mRemote.transact(3, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(208287);
      }
    }
    
    public final List akd()
    {
      AppMethodBeat.i(208277);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
        this.mRemote.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        ArrayList localArrayList = localParcel2.readArrayList(getClass().getClassLoader());
        return localArrayList;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(208277);
      }
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
    
    public final boolean lJ(int paramInt)
    {
      boolean bool = false;
      AppMethodBeat.i(208282);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
        localParcel1.writeInt(paramInt);
        this.mRemote.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramInt = localParcel2.readInt();
        if (paramInt != 0) {
          bool = true;
        }
        return bool;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(208282);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.huawei.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */