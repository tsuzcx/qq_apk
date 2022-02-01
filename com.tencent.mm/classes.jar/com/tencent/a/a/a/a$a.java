package com.tencent.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class a$a
  extends Binder
  implements a
{
  public static a j(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.assistant.sdk.BaseService");
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
      paramParcel2.writeString("com.tencent.assistant.sdk.BaseService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.assistant.sdk.BaseService");
      paramInt1 = a(paramParcel1.readString(), paramParcel1.readString(), b.a.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.assistant.sdk.BaseService");
      paramInt1 = a(b.a.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.assistant.sdk.BaseService");
      paramParcel1 = b(paramParcel1.readString(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.assistant.sdk.BaseService");
    c(paramParcel1.readString(), paramParcel1.createByteArray());
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
    
    /* Error */
    public final int a(b paramb)
    {
      // Byte code:
      //   0: ldc 21
      //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   8: astore_3
      //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   12: astore 4
      //   14: aload_3
      //   15: ldc 35
      //   17: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   20: aload_1
      //   21: ifnull +57 -> 78
      //   24: aload_1
      //   25: invokeinterface 45 1 0
      //   30: astore_1
      //   31: aload_3
      //   32: aload_1
      //   33: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   36: aload_0
      //   37: getfield 18	com/tencent/a/a/a/a$a$a:mRemote	Landroid/os/IBinder;
      //   40: iconst_2
      //   41: aload_3
      //   42: aload 4
      //   44: iconst_0
      //   45: invokeinterface 54 5 0
      //   50: pop
      //   51: aload 4
      //   53: invokevirtual 57	android/os/Parcel:readException	()V
      //   56: aload 4
      //   58: invokevirtual 61	android/os/Parcel:readInt	()I
      //   61: istore_2
      //   62: aload 4
      //   64: invokevirtual 64	android/os/Parcel:recycle	()V
      //   67: aload_3
      //   68: invokevirtual 64	android/os/Parcel:recycle	()V
      //   71: ldc 21
      //   73: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   76: iload_2
      //   77: ireturn
      //   78: aconst_null
      //   79: astore_1
      //   80: goto -49 -> 31
      //   83: astore_1
      //   84: aload 4
      //   86: invokevirtual 64	android/os/Parcel:recycle	()V
      //   89: aload_3
      //   90: invokevirtual 64	android/os/Parcel:recycle	()V
      //   93: ldc 21
      //   95: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   98: aload_1
      //   99: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	100	0	this	a
      //   0	100	1	paramb	b
      //   61	16	2	i	int
      //   8	82	3	localParcel1	Parcel
      //   12	73	4	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   14	20	83	finally
      //   24	31	83	finally
      //   31	62	83	finally
    }
    
    /* Error */
    public final int a(String paramString1, String paramString2, b paramb)
    {
      // Byte code:
      //   0: ldc 69
      //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   8: astore 5
      //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   13: astore 6
      //   15: aload 5
      //   17: ldc 35
      //   19: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   22: aload 5
      //   24: aload_1
      //   25: invokevirtual 72	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   28: aload 5
      //   30: aload_2
      //   31: invokevirtual 72	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   34: aload_3
      //   35: ifnull +62 -> 97
      //   38: aload_3
      //   39: invokeinterface 45 1 0
      //   44: astore_1
      //   45: aload 5
      //   47: aload_1
      //   48: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   51: aload_0
      //   52: getfield 18	com/tencent/a/a/a/a$a$a:mRemote	Landroid/os/IBinder;
      //   55: iconst_1
      //   56: aload 5
      //   58: aload 6
      //   60: iconst_0
      //   61: invokeinterface 54 5 0
      //   66: pop
      //   67: aload 6
      //   69: invokevirtual 57	android/os/Parcel:readException	()V
      //   72: aload 6
      //   74: invokevirtual 61	android/os/Parcel:readInt	()I
      //   77: istore 4
      //   79: aload 6
      //   81: invokevirtual 64	android/os/Parcel:recycle	()V
      //   84: aload 5
      //   86: invokevirtual 64	android/os/Parcel:recycle	()V
      //   89: ldc 69
      //   91: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   94: iload 4
      //   96: ireturn
      //   97: aconst_null
      //   98: astore_1
      //   99: goto -54 -> 45
      //   102: astore_1
      //   103: aload 6
      //   105: invokevirtual 64	android/os/Parcel:recycle	()V
      //   108: aload 5
      //   110: invokevirtual 64	android/os/Parcel:recycle	()V
      //   113: ldc 69
      //   115: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   118: aload_1
      //   119: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	120	0	this	a
      //   0	120	1	paramString1	String
      //   0	120	2	paramString2	String
      //   0	120	3	paramb	b
      //   77	18	4	i	int
      //   8	101	5	localParcel1	Parcel
      //   13	91	6	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   15	34	102	finally
      //   38	45	102	finally
      //   45	79	102	finally
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
    
    public final byte[] b(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(101837);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.assistant.sdk.BaseService");
        localParcel1.writeString(paramString);
        localParcel1.writeByteArray(paramArrayOfByte);
        this.mRemote.transact(3, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramString = localParcel2.createByteArray();
        return paramString;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(101837);
      }
    }
    
    public final void c(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(101838);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.assistant.sdk.BaseService");
        localParcel1.writeString(paramString);
        localParcel1.writeByteArray(paramArrayOfByte);
        this.mRemote.transact(4, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(101838);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */