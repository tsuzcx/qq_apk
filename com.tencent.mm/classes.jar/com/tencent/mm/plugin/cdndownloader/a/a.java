package com.tencent.mm.plugin.cdndownloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;

public abstract interface a
  extends IInterface
{
  public abstract void AR(int paramInt);
  
  public abstract boolean Zu(String paramString);
  
  public abstract boolean Zv(String paramString);
  
  public abstract CDNTaskState Zw(String paramString);
  
  public abstract int a(CDNTaskInfo paramCDNTaskInfo);
  
  public abstract void a(b paramb);
  
  public abstract int b(CDNTaskInfo paramCDNTaskInfo);
  
  public abstract void b(b paramb);
  
  public abstract void bYQ();
  
  public abstract void bYR();
  
  public abstract void bYS();
  
  public static abstract class a
    extends Binder
    implements a
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
    }
    
    public static a t(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
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
      Object localObject2 = null;
      Object localObject1 = null;
      int i = 0;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        if (paramParcel1.readInt() != 0) {
          localObject1 = (CDNTaskInfo)CDNTaskInfo.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = a((CDNTaskInfo)localObject1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (CDNTaskInfo)CDNTaskInfo.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = b((CDNTaskInfo)localObject1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        bool = Zu(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (bool) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        bool = Zv(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        paramParcel1 = Zw(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        a(b.a.u(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        b(b.a.u(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        AR(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        bYQ();
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        bYR();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
      bYS();
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
      
      public final void AR(int paramInt)
      {
        AppMethodBeat.i(120700);
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
          AppMethodBeat.o(120700);
        }
      }
      
      public final boolean Zu(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(120695);
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
          AppMethodBeat.o(120695);
        }
      }
      
      public final boolean Zv(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(120696);
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
          AppMethodBeat.o(120696);
        }
      }
      
      /* Error */
      public final CDNTaskState Zw(String paramString)
      {
        // Byte code:
        //   0: ldc 72
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 35
        //   16: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_2
        //   20: aload_1
        //   21: invokevirtual 63	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   24: aload_0
        //   25: getfield 18	com/tencent/mm/plugin/cdndownloader/a/a$a$a:mRemote	Landroid/os/IBinder;
        //   28: iconst_5
        //   29: aload_2
        //   30: aload_3
        //   31: iconst_0
        //   32: invokeinterface 48 5 0
        //   37: pop
        //   38: aload_3
        //   39: invokevirtual 51	android/os/Parcel:readException	()V
        //   42: aload_3
        //   43: invokevirtual 67	android/os/Parcel:readInt	()I
        //   46: ifeq +31 -> 77
        //   49: getstatic 78	com/tencent/mm/plugin/cdndownloader/ipc/CDNTaskState:CREATOR	Landroid/os/Parcelable$Creator;
        //   52: aload_3
        //   53: invokeinterface 84 2 0
        //   58: checkcast 74	com/tencent/mm/plugin/cdndownloader/ipc/CDNTaskState
        //   61: astore_1
        //   62: aload_3
        //   63: invokevirtual 54	android/os/Parcel:recycle	()V
        //   66: aload_2
        //   67: invokevirtual 54	android/os/Parcel:recycle	()V
        //   70: ldc 72
        //   72: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   75: aload_1
        //   76: areturn
        //   77: aconst_null
        //   78: astore_1
        //   79: goto -17 -> 62
        //   82: astore_1
        //   83: aload_3
        //   84: invokevirtual 54	android/os/Parcel:recycle	()V
        //   87: aload_2
        //   88: invokevirtual 54	android/os/Parcel:recycle	()V
        //   91: ldc 72
        //   93: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   96: aload_1
        //   97: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	98	0	this	a
        //   0	98	1	paramString	String
        //   8	80	2	localParcel1	Parcel
        //   12	72	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	62	82	finally
      }
      
      /* Error */
      public final int a(CDNTaskInfo paramCDNTaskInfo)
      {
        // Byte code:
        //   0: ldc 86
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 35
        //   17: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +56 -> 77
        //   24: aload_3
        //   25: iconst_1
        //   26: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   29: aload_1
        //   30: aload_3
        //   31: iconst_0
        //   32: invokevirtual 92	com/tencent/mm/plugin/cdndownloader/ipc/CDNTaskInfo:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload_0
        //   36: getfield 18	com/tencent/mm/plugin/cdndownloader/a/a$a$a:mRemote	Landroid/os/IBinder;
        //   39: iconst_1
        //   40: aload_3
        //   41: aload 4
        //   43: iconst_0
        //   44: invokeinterface 48 5 0
        //   49: pop
        //   50: aload 4
        //   52: invokevirtual 51	android/os/Parcel:readException	()V
        //   55: aload 4
        //   57: invokevirtual 67	android/os/Parcel:readInt	()I
        //   60: istore_2
        //   61: aload 4
        //   63: invokevirtual 54	android/os/Parcel:recycle	()V
        //   66: aload_3
        //   67: invokevirtual 54	android/os/Parcel:recycle	()V
        //   70: ldc 86
        //   72: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   75: iload_2
        //   76: ireturn
        //   77: aload_3
        //   78: iconst_0
        //   79: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   82: goto -47 -> 35
        //   85: astore_1
        //   86: aload 4
        //   88: invokevirtual 54	android/os/Parcel:recycle	()V
        //   91: aload_3
        //   92: invokevirtual 54	android/os/Parcel:recycle	()V
        //   95: ldc 86
        //   97: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   100: aload_1
        //   101: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	102	0	this	a
        //   0	102	1	paramCDNTaskInfo	CDNTaskInfo
        //   60	16	2	i	int
        //   8	84	3	localParcel1	Parcel
        //   12	75	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	20	85	finally
        //   24	35	85	finally
        //   35	61	85	finally
        //   77	82	85	finally
      }
      
      /* Error */
      public final void a(b paramb)
      {
        // Byte code:
        //   0: ldc 94
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 35
        //   16: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +48 -> 68
        //   23: aload_1
        //   24: invokeinterface 100 1 0
        //   29: astore_1
        //   30: aload_2
        //   31: aload_1
        //   32: invokevirtual 103	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_0
        //   36: getfield 18	com/tencent/mm/plugin/cdndownloader/a/a$a$a:mRemote	Landroid/os/IBinder;
        //   39: bipush 6
        //   41: aload_2
        //   42: aload_3
        //   43: iconst_0
        //   44: invokeinterface 48 5 0
        //   49: pop
        //   50: aload_3
        //   51: invokevirtual 51	android/os/Parcel:readException	()V
        //   54: aload_3
        //   55: invokevirtual 54	android/os/Parcel:recycle	()V
        //   58: aload_2
        //   59: invokevirtual 54	android/os/Parcel:recycle	()V
        //   62: ldc 94
        //   64: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   67: return
        //   68: aconst_null
        //   69: astore_1
        //   70: goto -40 -> 30
        //   73: astore_1
        //   74: aload_3
        //   75: invokevirtual 54	android/os/Parcel:recycle	()V
        //   78: aload_2
        //   79: invokevirtual 54	android/os/Parcel:recycle	()V
        //   82: ldc 94
        //   84: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   87: aload_1
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramb	b
        //   8	71	2	localParcel1	Parcel
        //   12	63	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	19	73	finally
        //   23	30	73	finally
        //   30	54	73	finally
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public final int b(CDNTaskInfo paramCDNTaskInfo)
      {
        // Byte code:
        //   0: ldc 105
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 35
        //   17: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +56 -> 77
        //   24: aload_3
        //   25: iconst_1
        //   26: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   29: aload_1
        //   30: aload_3
        //   31: iconst_0
        //   32: invokevirtual 92	com/tencent/mm/plugin/cdndownloader/ipc/CDNTaskInfo:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload_0
        //   36: getfield 18	com/tencent/mm/plugin/cdndownloader/a/a$a$a:mRemote	Landroid/os/IBinder;
        //   39: iconst_2
        //   40: aload_3
        //   41: aload 4
        //   43: iconst_0
        //   44: invokeinterface 48 5 0
        //   49: pop
        //   50: aload 4
        //   52: invokevirtual 51	android/os/Parcel:readException	()V
        //   55: aload 4
        //   57: invokevirtual 67	android/os/Parcel:readInt	()I
        //   60: istore_2
        //   61: aload 4
        //   63: invokevirtual 54	android/os/Parcel:recycle	()V
        //   66: aload_3
        //   67: invokevirtual 54	android/os/Parcel:recycle	()V
        //   70: ldc 105
        //   72: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   75: iload_2
        //   76: ireturn
        //   77: aload_3
        //   78: iconst_0
        //   79: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   82: goto -47 -> 35
        //   85: astore_1
        //   86: aload 4
        //   88: invokevirtual 54	android/os/Parcel:recycle	()V
        //   91: aload_3
        //   92: invokevirtual 54	android/os/Parcel:recycle	()V
        //   95: ldc 105
        //   97: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   100: aload_1
        //   101: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	102	0	this	a
        //   0	102	1	paramCDNTaskInfo	CDNTaskInfo
        //   60	16	2	i	int
        //   8	84	3	localParcel1	Parcel
        //   12	75	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	20	85	finally
        //   24	35	85	finally
        //   35	61	85	finally
        //   77	82	85	finally
      }
      
      /* Error */
      public final void b(b paramb)
      {
        // Byte code:
        //   0: ldc 106
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 35
        //   16: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +48 -> 68
        //   23: aload_1
        //   24: invokeinterface 100 1 0
        //   29: astore_1
        //   30: aload_2
        //   31: aload_1
        //   32: invokevirtual 103	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_0
        //   36: getfield 18	com/tencent/mm/plugin/cdndownloader/a/a$a$a:mRemote	Landroid/os/IBinder;
        //   39: bipush 7
        //   41: aload_2
        //   42: aload_3
        //   43: iconst_0
        //   44: invokeinterface 48 5 0
        //   49: pop
        //   50: aload_3
        //   51: invokevirtual 51	android/os/Parcel:readException	()V
        //   54: aload_3
        //   55: invokevirtual 54	android/os/Parcel:recycle	()V
        //   58: aload_2
        //   59: invokevirtual 54	android/os/Parcel:recycle	()V
        //   62: ldc 106
        //   64: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   67: return
        //   68: aconst_null
        //   69: astore_1
        //   70: goto -40 -> 30
        //   73: astore_1
        //   74: aload_3
        //   75: invokevirtual 54	android/os/Parcel:recycle	()V
        //   78: aload_2
        //   79: invokevirtual 54	android/os/Parcel:recycle	()V
        //   82: ldc 106
        //   84: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   87: aload_1
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramb	b
        //   8	71	2	localParcel1	Parcel
        //   12	63	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	19	73	finally
        //   23	30	73	finally
        //   30	54	73	finally
      }
      
      public final void bYQ()
      {
        AppMethodBeat.i(120701);
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
          AppMethodBeat.o(120701);
        }
      }
      
      public final void bYR()
      {
        AppMethodBeat.i(120702);
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
          AppMethodBeat.o(120702);
        }
      }
      
      public final void bYS()
      {
        AppMethodBeat.i(120703);
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
          AppMethodBeat.o(120703);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.a.a
 * JD-Core Version:    0.7.0.1
 */