package com.tencent.mm.plugin.gallery.stub;

import android.os.IBinder;
import android.os.Parcel;

final class a$a$a
  implements a
{
  private IBinder mRemote;
  
  a$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public final int Ag()
  {
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
    }
  }
  
  public final int Ah()
  {
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
    }
  }
  
  public final int Aj()
  {
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
    }
  }
  
  public final int Es(String paramString)
  {
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
    }
  }
  
  /* Error */
  public final void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 8
    //   8: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 9
    //   13: aload 8
    //   15: ldc 29
    //   17: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload 8
    //   22: aload_1
    //   23: invokevirtual 55	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   26: aload 8
    //   28: aload_2
    //   29: invokevirtual 55	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   32: iload_3
    //   33: ifeq +68 -> 101
    //   36: iconst_1
    //   37: istore 6
    //   39: aload 8
    //   41: iload 6
    //   43: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   46: aload 8
    //   48: iload 4
    //   50: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   53: iload 5
    //   55: ifeq +52 -> 107
    //   58: iload 7
    //   60: istore 4
    //   62: aload 8
    //   64: iload 4
    //   66: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   69: aload_0
    //   70: getfield 18	com/tencent/mm/plugin/gallery/stub/a$a$a:mRemote	Landroid/os/IBinder;
    //   73: iconst_4
    //   74: aload 8
    //   76: aload 9
    //   78: iconst_0
    //   79: invokeinterface 39 5 0
    //   84: pop
    //   85: aload 9
    //   87: invokevirtual 42	android/os/Parcel:readException	()V
    //   90: aload 9
    //   92: invokevirtual 48	android/os/Parcel:recycle	()V
    //   95: aload 8
    //   97: invokevirtual 48	android/os/Parcel:recycle	()V
    //   100: return
    //   101: iconst_0
    //   102: istore 6
    //   104: goto -65 -> 39
    //   107: iconst_0
    //   108: istore 4
    //   110: goto -48 -> 62
    //   113: astore_1
    //   114: aload 9
    //   116: invokevirtual 48	android/os/Parcel:recycle	()V
    //   119: aload 8
    //   121: invokevirtual 48	android/os/Parcel:recycle	()V
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	a
    //   0	126	1	paramString1	String
    //   0	126	2	paramString2	String
    //   0	126	3	paramBoolean1	boolean
    //   0	126	4	paramInt	int
    //   0	126	5	paramBoolean2	boolean
    //   37	66	6	i	int
    //   1	58	7	j	int
    //   6	114	8	localParcel1	Parcel
    //   11	104	9	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	32	113	finally
    //   39	53	113	finally
    //   62	90	113	finally
  }
  
  public final void aXH()
  {
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
    }
  }
  
  public final int aXI()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
      this.mRemote.transact(9, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void aq(int paramInt, String paramString)
  {
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
    }
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  /* Error */
  public final boolean gp(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 29
    //   16: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: iload_1
    //   20: ifeq +57 -> 77
    //   23: iconst_1
    //   24: istore_2
    //   25: aload 4
    //   27: iload_2
    //   28: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   31: aload_0
    //   32: getfield 18	com/tencent/mm/plugin/gallery/stub/a$a$a:mRemote	Landroid/os/IBinder;
    //   35: bipush 7
    //   37: aload 4
    //   39: aload 5
    //   41: iconst_0
    //   42: invokeinterface 39 5 0
    //   47: pop
    //   48: aload 5
    //   50: invokevirtual 42	android/os/Parcel:readException	()V
    //   53: aload 5
    //   55: invokevirtual 45	android/os/Parcel:readInt	()I
    //   58: istore_2
    //   59: iload_2
    //   60: ifeq +22 -> 82
    //   63: iload_3
    //   64: istore_1
    //   65: aload 5
    //   67: invokevirtual 48	android/os/Parcel:recycle	()V
    //   70: aload 4
    //   72: invokevirtual 48	android/os/Parcel:recycle	()V
    //   75: iload_1
    //   76: ireturn
    //   77: iconst_0
    //   78: istore_2
    //   79: goto -54 -> 25
    //   82: iconst_0
    //   83: istore_1
    //   84: goto -19 -> 65
    //   87: astore 6
    //   89: aload 5
    //   91: invokevirtual 48	android/os/Parcel:recycle	()V
    //   94: aload 4
    //   96: invokevirtual 48	android/os/Parcel:recycle	()V
    //   99: aload 6
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	a
    //   0	102	1	paramBoolean	boolean
    //   24	55	2	i	int
    //   1	63	3	bool	boolean
    //   5	90	4	localParcel1	Parcel
    //   10	80	5	localParcel2	Parcel
    //   87	13	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	19	87	finally
    //   25	59	87	finally
  }
  
  public final int rQ(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(10, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      return paramInt;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.stub.a.a.a
 * JD-Core Version:    0.7.0.1
 */