package com.huawei.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class b$a
  extends Binder
  implements b
{
  public static b j(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
    if ((localIInterface != null) && ((localIInterface instanceof b))) {
      return (b)localIInterface;
    }
    return new a(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool = false;
    int i = 0;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
      bool = ake();
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
      if (paramParcel1.readInt() != 0) {
        bool = true;
      }
      paramInt1 = cA(bool);
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
      paramInt1 = akf();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
      paramInt1 = A(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel1.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
    init(paramParcel1.readString());
    paramParcel2.writeNoException();
    return true;
  }
  
  static final class a
    implements b
  {
    private IBinder mRemote;
    
    a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    public final int A(String paramString, int paramInt)
    {
      AppMethodBeat.i(208297);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        this.mRemote.transact(4, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramInt = localParcel2.readInt();
        return paramInt;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(208297);
      }
    }
    
    /* Error */
    public final boolean ake()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: ldc 68
      //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   10: astore_3
      //   11: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   14: astore 4
      //   16: aload_3
      //   17: ldc 36
      //   19: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   22: aload_0
      //   23: getfield 18	com/huawei/a/a/a/b$a$a:mRemote	Landroid/os/IBinder;
      //   26: iconst_1
      //   27: aload_3
      //   28: aload 4
      //   30: iconst_0
      //   31: invokeinterface 52 5 0
      //   36: pop
      //   37: aload 4
      //   39: invokevirtual 55	android/os/Parcel:readException	()V
      //   42: aload 4
      //   44: invokevirtual 59	android/os/Parcel:readInt	()I
      //   47: istore_1
      //   48: iload_1
      //   49: ifeq +19 -> 68
      //   52: aload 4
      //   54: invokevirtual 62	android/os/Parcel:recycle	()V
      //   57: aload_3
      //   58: invokevirtual 62	android/os/Parcel:recycle	()V
      //   61: ldc 68
      //   63: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   66: iload_2
      //   67: ireturn
      //   68: iconst_0
      //   69: istore_2
      //   70: goto -18 -> 52
      //   73: astore 5
      //   75: aload 4
      //   77: invokevirtual 62	android/os/Parcel:recycle	()V
      //   80: aload_3
      //   81: invokevirtual 62	android/os/Parcel:recycle	()V
      //   84: ldc 68
      //   86: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   89: aload 5
      //   91: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	92	0	this	a
      //   47	2	1	i	int
      //   1	69	2	bool	boolean
      //   10	71	3	localParcel1	Parcel
      //   14	62	4	localParcel2	Parcel
      //   73	17	5	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   16	48	73	finally
    }
    
    public final int akf()
    {
      AppMethodBeat.i(208293);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
        this.mRemote.transact(3, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        return i;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(208293);
      }
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
    
    public final int cA(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(208286);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        this.mRemote.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        i = localParcel2.readInt();
        return i;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(208286);
      }
    }
    
    public final void init(String paramString)
    {
      AppMethodBeat.i(208300);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
        localParcel1.writeString(paramString);
        this.mRemote.transact(5, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(208300);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.huawei.a.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */