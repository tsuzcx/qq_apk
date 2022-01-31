package com.tencent.mm.plugin.cdndownloader.a;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a$a
  implements a
{
  private IBinder mRemote;
  
  a$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public final boolean IO(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(863);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
      localParcel1.writeString(paramString);
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(863);
    }
  }
  
  public final boolean IP(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(864);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
      localParcel1.writeString(paramString);
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(864);
    }
  }
  
  /* Error */
  public final com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState IQ(String paramString)
  {
    // Byte code:
    //   0: sipush 865
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_2
    //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   13: astore_3
    //   14: aload_2
    //   15: ldc 35
    //   17: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_2
    //   21: aload_1
    //   22: invokevirtual 42	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 18	com/tencent/mm/plugin/cdndownloader/a/a$a$a:mRemote	Landroid/os/IBinder;
    //   29: iconst_5
    //   30: aload_2
    //   31: aload_3
    //   32: iconst_0
    //   33: invokeinterface 48 5 0
    //   38: pop
    //   39: aload_3
    //   40: invokevirtual 51	android/os/Parcel:readException	()V
    //   43: aload_3
    //   44: invokevirtual 55	android/os/Parcel:readInt	()I
    //   47: ifeq +32 -> 79
    //   50: getstatic 70	com/tencent/mm/plugin/cdndownloader/ipc/CDNTaskState:CREATOR	Landroid/os/Parcelable$Creator;
    //   53: aload_3
    //   54: invokeinterface 76 2 0
    //   59: checkcast 66	com/tencent/mm/plugin/cdndownloader/ipc/CDNTaskState
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 58	android/os/Parcel:recycle	()V
    //   67: aload_2
    //   68: invokevirtual 58	android/os/Parcel:recycle	()V
    //   71: sipush 865
    //   74: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_1
    //   78: areturn
    //   79: aconst_null
    //   80: astore_1
    //   81: goto -18 -> 63
    //   84: astore_1
    //   85: aload_3
    //   86: invokevirtual 58	android/os/Parcel:recycle	()V
    //   89: aload_2
    //   90: invokevirtual 58	android/os/Parcel:recycle	()V
    //   93: sipush 865
    //   96: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	a
    //   0	101	1	paramString	String
    //   9	81	2	localParcel1	Parcel
    //   13	73	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   14	63	84	finally
  }
  
  /* Error */
  public final int a(com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo paramCDNTaskInfo)
  {
    // Byte code:
    //   0: sipush 861
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_3
    //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   13: astore 4
    //   15: aload_3
    //   16: ldc 35
    //   18: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   21: aload_1
    //   22: ifnull +57 -> 79
    //   25: aload_3
    //   26: iconst_1
    //   27: invokevirtual 80	android/os/Parcel:writeInt	(I)V
    //   30: aload_1
    //   31: aload_3
    //   32: iconst_0
    //   33: invokevirtual 86	com/tencent/mm/plugin/cdndownloader/ipc/CDNTaskInfo:writeToParcel	(Landroid/os/Parcel;I)V
    //   36: aload_0
    //   37: getfield 18	com/tencent/mm/plugin/cdndownloader/a/a$a$a:mRemote	Landroid/os/IBinder;
    //   40: iconst_1
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 48 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 51	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 55	android/os/Parcel:readInt	()I
    //   61: istore_2
    //   62: aload 4
    //   64: invokevirtual 58	android/os/Parcel:recycle	()V
    //   67: aload_3
    //   68: invokevirtual 58	android/os/Parcel:recycle	()V
    //   71: sipush 861
    //   74: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: iload_2
    //   78: ireturn
    //   79: aload_3
    //   80: iconst_0
    //   81: invokevirtual 80	android/os/Parcel:writeInt	(I)V
    //   84: goto -48 -> 36
    //   87: astore_1
    //   88: aload 4
    //   90: invokevirtual 58	android/os/Parcel:recycle	()V
    //   93: aload_3
    //   94: invokevirtual 58	android/os/Parcel:recycle	()V
    //   97: sipush 861
    //   100: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	a
    //   0	105	1	paramCDNTaskInfo	com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo
    //   61	17	2	i	int
    //   9	85	3	localParcel1	Parcel
    //   13	76	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   15	21	87	finally
    //   25	36	87	finally
    //   36	62	87	finally
    //   79	84	87	finally
  }
  
  /* Error */
  public final void a(b paramb)
  {
    // Byte code:
    //   0: sipush 866
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_2
    //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   13: astore_3
    //   14: aload_2
    //   15: ldc 35
    //   17: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: ifnull +49 -> 70
    //   24: aload_1
    //   25: invokeinterface 93 1 0
    //   30: astore_1
    //   31: aload_2
    //   32: aload_1
    //   33: invokevirtual 96	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_0
    //   37: getfield 18	com/tencent/mm/plugin/cdndownloader/a/a$a$a:mRemote	Landroid/os/IBinder;
    //   40: bipush 6
    //   42: aload_2
    //   43: aload_3
    //   44: iconst_0
    //   45: invokeinterface 48 5 0
    //   50: pop
    //   51: aload_3
    //   52: invokevirtual 51	android/os/Parcel:readException	()V
    //   55: aload_3
    //   56: invokevirtual 58	android/os/Parcel:recycle	()V
    //   59: aload_2
    //   60: invokevirtual 58	android/os/Parcel:recycle	()V
    //   63: sipush 866
    //   66: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: return
    //   70: aconst_null
    //   71: astore_1
    //   72: goto -41 -> 31
    //   75: astore_1
    //   76: aload_3
    //   77: invokevirtual 58	android/os/Parcel:recycle	()V
    //   80: aload_2
    //   81: invokevirtual 58	android/os/Parcel:recycle	()V
    //   84: sipush 866
    //   87: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	a
    //   0	92	1	paramb	b
    //   9	72	2	localParcel1	Parcel
    //   13	64	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   14	20	75	finally
    //   24	31	75	finally
    //   31	55	75	finally
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  /* Error */
  public final int b(com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo paramCDNTaskInfo)
  {
    // Byte code:
    //   0: sipush 862
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_3
    //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   13: astore 4
    //   15: aload_3
    //   16: ldc 35
    //   18: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   21: aload_1
    //   22: ifnull +57 -> 79
    //   25: aload_3
    //   26: iconst_1
    //   27: invokevirtual 80	android/os/Parcel:writeInt	(I)V
    //   30: aload_1
    //   31: aload_3
    //   32: iconst_0
    //   33: invokevirtual 86	com/tencent/mm/plugin/cdndownloader/ipc/CDNTaskInfo:writeToParcel	(Landroid/os/Parcel;I)V
    //   36: aload_0
    //   37: getfield 18	com/tencent/mm/plugin/cdndownloader/a/a$a$a:mRemote	Landroid/os/IBinder;
    //   40: iconst_2
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 48 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 51	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 55	android/os/Parcel:readInt	()I
    //   61: istore_2
    //   62: aload 4
    //   64: invokevirtual 58	android/os/Parcel:recycle	()V
    //   67: aload_3
    //   68: invokevirtual 58	android/os/Parcel:recycle	()V
    //   71: sipush 862
    //   74: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: iload_2
    //   78: ireturn
    //   79: aload_3
    //   80: iconst_0
    //   81: invokevirtual 80	android/os/Parcel:writeInt	(I)V
    //   84: goto -48 -> 36
    //   87: astore_1
    //   88: aload 4
    //   90: invokevirtual 58	android/os/Parcel:recycle	()V
    //   93: aload_3
    //   94: invokevirtual 58	android/os/Parcel:recycle	()V
    //   97: sipush 862
    //   100: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	a
    //   0	105	1	paramCDNTaskInfo	com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo
    //   61	17	2	i	int
    //   9	85	3	localParcel1	Parcel
    //   13	76	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   15	21	87	finally
    //   25	36	87	finally
    //   36	62	87	finally
    //   79	84	87	finally
  }
  
  /* Error */
  public final void b(b paramb)
  {
    // Byte code:
    //   0: sipush 867
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_2
    //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   13: astore_3
    //   14: aload_2
    //   15: ldc 35
    //   17: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: ifnull +49 -> 70
    //   24: aload_1
    //   25: invokeinterface 93 1 0
    //   30: astore_1
    //   31: aload_2
    //   32: aload_1
    //   33: invokevirtual 96	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_0
    //   37: getfield 18	com/tencent/mm/plugin/cdndownloader/a/a$a$a:mRemote	Landroid/os/IBinder;
    //   40: bipush 7
    //   42: aload_2
    //   43: aload_3
    //   44: iconst_0
    //   45: invokeinterface 48 5 0
    //   50: pop
    //   51: aload_3
    //   52: invokevirtual 51	android/os/Parcel:readException	()V
    //   55: aload_3
    //   56: invokevirtual 58	android/os/Parcel:recycle	()V
    //   59: aload_2
    //   60: invokevirtual 58	android/os/Parcel:recycle	()V
    //   63: sipush 867
    //   66: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: return
    //   70: aconst_null
    //   71: astore_1
    //   72: goto -41 -> 31
    //   75: astore_1
    //   76: aload_3
    //   77: invokevirtual 58	android/os/Parcel:recycle	()V
    //   80: aload_2
    //   81: invokevirtual 58	android/os/Parcel:recycle	()V
    //   84: sipush 867
    //   87: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	a
    //   0	92	1	paramb	b
    //   9	72	2	localParcel1	Parcel
    //   13	64	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   14	20	75	finally
    //   24	31	75	finally
    //   31	55	75	finally
  }
  
  public final void bfP()
  {
    AppMethodBeat.i(869);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
      this.mRemote.transact(9, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(869);
    }
  }
  
  public final void bfQ()
  {
    AppMethodBeat.i(870);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
      this.mRemote.transact(10, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(870);
    }
  }
  
  public final void bfR()
  {
    AppMethodBeat.i(871);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
      this.mRemote.transact(11, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(871);
    }
  }
  
  public final void tx(int paramInt)
  {
    AppMethodBeat.i(868);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(868);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */