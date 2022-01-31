package com.tencent.mm.plugin.gallery.stub;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
  extends IInterface
{
  public abstract int MV();
  
  public abstract int MW();
  
  public abstract int MY();
  
  public abstract int PD(String paramString);
  
  public abstract void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2);
  
  public abstract void aK(int paramInt, String paramString);
  
  public abstract void bEm();
  
  public abstract boolean hT(boolean paramBoolean);
  
  static final class a$a
    implements a
  {
    private IBinder mRemote;
    
    a$a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    public final int MV()
    {
      AppMethodBeat.i(21356);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
        this.mRemote.transact(6, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        return i;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(21356);
      }
    }
    
    public final int MW()
    {
      AppMethodBeat.i(21355);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
        this.mRemote.transact(5, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        return i;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(21355);
      }
    }
    
    public final int MY()
    {
      AppMethodBeat.i(21353);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
        this.mRemote.transact(3, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        return i;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(21353);
      }
    }
    
    public final int PD(String paramString)
    {
      AppMethodBeat.i(21358);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
        localParcel1.writeString(paramString);
        this.mRemote.transact(8, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        return i;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(21358);
      }
    }
    
    /* Error */
    public final void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 7
      //   3: sipush 21354
      //   6: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   12: astore 8
      //   14: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   17: astore 9
      //   19: aload 8
      //   21: ldc 35
      //   23: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   26: aload 8
      //   28: aload_1
      //   29: invokevirtual 64	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   32: aload 8
      //   34: aload_2
      //   35: invokevirtual 64	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   38: iload_3
      //   39: ifeq +74 -> 113
      //   42: iconst_1
      //   43: istore 6
      //   45: aload 8
      //   47: iload 6
      //   49: invokevirtual 68	android/os/Parcel:writeInt	(I)V
      //   52: aload 8
      //   54: iload 4
      //   56: invokevirtual 68	android/os/Parcel:writeInt	(I)V
      //   59: iload 5
      //   61: ifeq +58 -> 119
      //   64: iload 7
      //   66: istore 4
      //   68: aload 8
      //   70: iload 4
      //   72: invokevirtual 68	android/os/Parcel:writeInt	(I)V
      //   75: aload_0
      //   76: getfield 18	com/tencent/mm/plugin/gallery/stub/a$a$a:mRemote	Landroid/os/IBinder;
      //   79: iconst_4
      //   80: aload 8
      //   82: aload 9
      //   84: iconst_0
      //   85: invokeinterface 45 5 0
      //   90: pop
      //   91: aload 9
      //   93: invokevirtual 48	android/os/Parcel:readException	()V
      //   96: aload 9
      //   98: invokevirtual 54	android/os/Parcel:recycle	()V
      //   101: aload 8
      //   103: invokevirtual 54	android/os/Parcel:recycle	()V
      //   106: sipush 21354
      //   109: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   112: return
      //   113: iconst_0
      //   114: istore 6
      //   116: goto -71 -> 45
      //   119: iconst_0
      //   120: istore 4
      //   122: goto -54 -> 68
      //   125: astore_1
      //   126: aload 9
      //   128: invokevirtual 54	android/os/Parcel:recycle	()V
      //   131: aload 8
      //   133: invokevirtual 54	android/os/Parcel:recycle	()V
      //   136: sipush 21354
      //   139: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   142: aload_1
      //   143: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	144	0	this	a
      //   0	144	1	paramString1	String
      //   0	144	2	paramString2	String
      //   0	144	3	paramBoolean1	boolean
      //   0	144	4	paramInt	int
      //   0	144	5	paramBoolean2	boolean
      //   43	72	6	i	int
      //   1	64	7	j	int
      //   12	120	8	localParcel1	Parcel
      //   17	110	9	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   19	38	125	finally
      //   45	59	125	finally
      //   68	96	125	finally
    }
    
    public final void aK(int paramInt, String paramString)
    {
      AppMethodBeat.i(21351);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
        localParcel1.writeInt(paramInt);
        localParcel1.writeString(paramString);
        this.mRemote.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(21351);
      }
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
    
    public final void bEm()
    {
      AppMethodBeat.i(21352);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
        this.mRemote.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(21352);
      }
    }
    
    /* Error */
    public final boolean hT(boolean paramBoolean)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_3
      //   2: sipush 21357
      //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   11: astore 4
      //   13: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   16: astore 5
      //   18: aload 4
      //   20: ldc 35
      //   22: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   25: iload_1
      //   26: ifeq +63 -> 89
      //   29: iconst_1
      //   30: istore_2
      //   31: aload 4
      //   33: iload_2
      //   34: invokevirtual 68	android/os/Parcel:writeInt	(I)V
      //   37: aload_0
      //   38: getfield 18	com/tencent/mm/plugin/gallery/stub/a$a$a:mRemote	Landroid/os/IBinder;
      //   41: bipush 7
      //   43: aload 4
      //   45: aload 5
      //   47: iconst_0
      //   48: invokeinterface 45 5 0
      //   53: pop
      //   54: aload 5
      //   56: invokevirtual 48	android/os/Parcel:readException	()V
      //   59: aload 5
      //   61: invokevirtual 51	android/os/Parcel:readInt	()I
      //   64: istore_2
      //   65: iload_2
      //   66: ifeq +28 -> 94
      //   69: iload_3
      //   70: istore_1
      //   71: aload 5
      //   73: invokevirtual 54	android/os/Parcel:recycle	()V
      //   76: aload 4
      //   78: invokevirtual 54	android/os/Parcel:recycle	()V
      //   81: sipush 21357
      //   84: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   87: iload_1
      //   88: ireturn
      //   89: iconst_0
      //   90: istore_2
      //   91: goto -60 -> 31
      //   94: iconst_0
      //   95: istore_1
      //   96: goto -25 -> 71
      //   99: astore 6
      //   101: aload 5
      //   103: invokevirtual 54	android/os/Parcel:recycle	()V
      //   106: aload 4
      //   108: invokevirtual 54	android/os/Parcel:recycle	()V
      //   111: sipush 21357
      //   114: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   117: aload 6
      //   119: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	120	0	this	a
      //   0	120	1	paramBoolean	boolean
      //   30	61	2	i	int
      //   1	69	3	bool	boolean
      //   11	96	4	localParcel1	Parcel
      //   16	86	5	localParcel2	Parcel
      //   99	19	6	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   18	25	99	finally
      //   31	65	99	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.stub.a
 * JD-Core Version:    0.7.0.1
 */