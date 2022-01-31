package com.tencent.mm.plugin.cdndownloader.a;

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
  
  /* Error */
  public final int a(com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo paramCDNTaskInfo)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 28
    //   12: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +51 -> 67
    //   19: aload_3
    //   20: iconst_1
    //   21: invokevirtual 36	android/os/Parcel:writeInt	(I)V
    //   24: aload_1
    //   25: aload_3
    //   26: iconst_0
    //   27: invokevirtual 42	com/tencent/mm/plugin/cdndownloader/ipc/CDNTaskInfo:writeToParcel	(Landroid/os/Parcel;I)V
    //   30: aload_0
    //   31: getfield 18	com/tencent/mm/plugin/cdndownloader/a/a$a$a:mRemote	Landroid/os/IBinder;
    //   34: iconst_1
    //   35: aload_3
    //   36: aload 4
    //   38: iconst_0
    //   39: invokeinterface 48 5 0
    //   44: pop
    //   45: aload 4
    //   47: invokevirtual 51	android/os/Parcel:readException	()V
    //   50: aload 4
    //   52: invokevirtual 55	android/os/Parcel:readInt	()I
    //   55: istore_2
    //   56: aload 4
    //   58: invokevirtual 58	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 58	android/os/Parcel:recycle	()V
    //   65: iload_2
    //   66: ireturn
    //   67: aload_3
    //   68: iconst_0
    //   69: invokevirtual 36	android/os/Parcel:writeInt	(I)V
    //   72: goto -42 -> 30
    //   75: astore_1
    //   76: aload 4
    //   78: invokevirtual 58	android/os/Parcel:recycle	()V
    //   81: aload_3
    //   82: invokevirtual 58	android/os/Parcel:recycle	()V
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	a
    //   0	87	1	paramCDNTaskInfo	com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo
    //   55	11	2	i	int
    //   3	79	3	localParcel1	Parcel
    //   7	70	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	75	finally
    //   19	30	75	finally
    //   30	56	75	finally
    //   67	72	75	finally
  }
  
  /* Error */
  public final void a(b paramb)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 28
    //   11: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 65 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 68	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 18	com/tencent/mm/plugin/cdndownloader/a/a$a$a:mRemote	Landroid/os/IBinder;
    //   34: bipush 6
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 48 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 51	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 58	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 58	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 58	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 58	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	a
    //   0	74	1	paramb	b
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  public final void aDs()
  {
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
    }
  }
  
  public final void aDt()
  {
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
    }
  }
  
  public final void aDu()
  {
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
    }
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  /* Error */
  public final int b(com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo paramCDNTaskInfo)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 28
    //   12: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +51 -> 67
    //   19: aload_3
    //   20: iconst_1
    //   21: invokevirtual 36	android/os/Parcel:writeInt	(I)V
    //   24: aload_1
    //   25: aload_3
    //   26: iconst_0
    //   27: invokevirtual 42	com/tencent/mm/plugin/cdndownloader/ipc/CDNTaskInfo:writeToParcel	(Landroid/os/Parcel;I)V
    //   30: aload_0
    //   31: getfield 18	com/tencent/mm/plugin/cdndownloader/a/a$a$a:mRemote	Landroid/os/IBinder;
    //   34: iconst_2
    //   35: aload_3
    //   36: aload 4
    //   38: iconst_0
    //   39: invokeinterface 48 5 0
    //   44: pop
    //   45: aload 4
    //   47: invokevirtual 51	android/os/Parcel:readException	()V
    //   50: aload 4
    //   52: invokevirtual 55	android/os/Parcel:readInt	()I
    //   55: istore_2
    //   56: aload 4
    //   58: invokevirtual 58	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 58	android/os/Parcel:recycle	()V
    //   65: iload_2
    //   66: ireturn
    //   67: aload_3
    //   68: iconst_0
    //   69: invokevirtual 36	android/os/Parcel:writeInt	(I)V
    //   72: goto -42 -> 30
    //   75: astore_1
    //   76: aload 4
    //   78: invokevirtual 58	android/os/Parcel:recycle	()V
    //   81: aload_3
    //   82: invokevirtual 58	android/os/Parcel:recycle	()V
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	a
    //   0	87	1	paramCDNTaskInfo	com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo
    //   55	11	2	i	int
    //   3	79	3	localParcel1	Parcel
    //   7	70	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	75	finally
    //   19	30	75	finally
    //   30	56	75	finally
    //   67	72	75	finally
  }
  
  /* Error */
  public final void b(b paramb)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 28
    //   11: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 65 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 68	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 18	com/tencent/mm/plugin/cdndownloader/a/a$a$a:mRemote	Landroid/os/IBinder;
    //   34: bipush 7
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 48 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 51	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 58	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 58	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 58	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 58	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	a
    //   0	74	1	paramb	b
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  public final void pi(int paramInt)
  {
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
    }
  }
  
  public final boolean zf(String paramString)
  {
    boolean bool = false;
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
    }
  }
  
  public final boolean zg(String paramString)
  {
    boolean bool = false;
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
    }
  }
  
  /* Error */
  public final com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState zh(String paramString)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 28
    //   11: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_2
    //   15: aload_1
    //   16: invokevirtual 78	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 18	com/tencent/mm/plugin/cdndownloader/a/a$a$a:mRemote	Landroid/os/IBinder;
    //   23: iconst_5
    //   24: aload_2
    //   25: aload_3
    //   26: iconst_0
    //   27: invokeinterface 48 5 0
    //   32: pop
    //   33: aload_3
    //   34: invokevirtual 51	android/os/Parcel:readException	()V
    //   37: aload_3
    //   38: invokevirtual 55	android/os/Parcel:readInt	()I
    //   41: ifeq +26 -> 67
    //   44: getstatic 87	com/tencent/mm/plugin/cdndownloader/ipc/CDNTaskState:CREATOR	Landroid/os/Parcelable$Creator;
    //   47: aload_3
    //   48: invokeinterface 93 2 0
    //   53: checkcast 83	com/tencent/mm/plugin/cdndownloader/ipc/CDNTaskState
    //   56: astore_1
    //   57: aload_3
    //   58: invokevirtual 58	android/os/Parcel:recycle	()V
    //   61: aload_2
    //   62: invokevirtual 58	android/os/Parcel:recycle	()V
    //   65: aload_1
    //   66: areturn
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -12 -> 57
    //   72: astore_1
    //   73: aload_3
    //   74: invokevirtual 58	android/os/Parcel:recycle	()V
    //   77: aload_2
    //   78: invokevirtual 58	android/os/Parcel:recycle	()V
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	a
    //   0	83	1	paramString	String
    //   3	75	2	localParcel1	Parcel
    //   7	67	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	57	72	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */