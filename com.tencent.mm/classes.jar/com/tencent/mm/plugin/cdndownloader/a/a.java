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
  public abstract void Is(int paramInt);
  
  public abstract int a(CDNTaskInfo paramCDNTaskInfo);
  
  public abstract void a(b paramb);
  
  public abstract boolean asf(String paramString);
  
  public abstract boolean asg(String paramString);
  
  public abstract CDNTaskState ash(String paramString);
  
  public abstract int b(CDNTaskInfo paramCDNTaskInfo);
  
  public abstract void b(b paramb);
  
  public abstract void cMp();
  
  public abstract void cMq();
  
  public abstract void cMr();
  
  public static abstract class a
    extends Binder
    implements a
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
    }
    
    public static a cMs()
    {
      return a.tLf;
    }
    
    public static a x(IBinder paramIBinder)
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
        bool = asf(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (bool) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        bool = asg(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        paramParcel1 = ash(paramParcel1.readString());
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
        a(b.a.y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        b(b.a.y(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        Is(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        cMp();
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        cMq();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
      cMr();
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements a
    {
      public static a tLf;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void Is(int paramInt)
      {
        AppMethodBeat.i(120700);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (a.a.cMs() != null))
          {
            a.a.cMs().Is(paramInt);
            return;
          }
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
      
      public final int a(CDNTaskInfo paramCDNTaskInfo)
      {
        AppMethodBeat.i(120693);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
          if (paramCDNTaskInfo != null)
          {
            localParcel1.writeInt(1);
            paramCDNTaskInfo.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (a.a.cMs() != null))
          {
            i = a.a.cMs().a(paramCDNTaskInfo);
            return i;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(120693);
        }
        int i = localParcel2.readInt();
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(120693);
        return i;
      }
      
      public final void a(b paramb)
      {
        AppMethodBeat.i(120698);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
          if (paramb != null) {}
          for (IBinder localIBinder = paramb.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(6, localParcel1, localParcel2, 0)) || (a.a.cMs() == null)) {
              break;
            }
            a.a.cMs().a(paramb);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(120698);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final boolean asf(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(120695);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (a.a.cMs() != null))
          {
            bool = a.a.cMs().asf(paramString);
            return bool;
          }
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
      
      public final boolean asg(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(120696);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (a.a.cMs() != null))
          {
            bool = a.a.cMs().asg(paramString);
            return bool;
          }
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
      public final CDNTaskState ash(String paramString)
      {
        // Byte code:
        //   0: ldc 107
        //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 37
        //   16: invokevirtual 41	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_2
        //   20: aload_1
        //   21: invokevirtual 98	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   24: aload_0
        //   25: getfield 20	com/tencent/mm/plugin/cdndownloader/a/a$a$a:mRemote	Landroid/os/IBinder;
        //   28: iconst_5
        //   29: aload_2
        //   30: aload_3
        //   31: iconst_0
        //   32: invokeinterface 50 5 0
        //   37: ifne +34 -> 71
        //   40: invokestatic 54	com/tencent/mm/plugin/cdndownloader/a/a$a:cMs	()Lcom/tencent/mm/plugin/cdndownloader/a/a;
        //   43: ifnull +28 -> 71
        //   46: invokestatic 54	com/tencent/mm/plugin/cdndownloader/a/a$a:cMs	()Lcom/tencent/mm/plugin/cdndownloader/a/a;
        //   49: aload_1
        //   50: invokeinterface 109 2 0
        //   55: astore_1
        //   56: aload_3
        //   57: invokevirtual 59	android/os/Parcel:recycle	()V
        //   60: aload_2
        //   61: invokevirtual 59	android/os/Parcel:recycle	()V
        //   64: ldc 107
        //   66: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   69: aload_1
        //   70: areturn
        //   71: aload_3
        //   72: invokevirtual 65	android/os/Parcel:readException	()V
        //   75: aload_3
        //   76: invokevirtual 79	android/os/Parcel:readInt	()I
        //   79: ifeq +31 -> 110
        //   82: getstatic 115	com/tencent/mm/plugin/cdndownloader/ipc/CDNTaskState:CREATOR	Landroid/os/Parcelable$Creator;
        //   85: aload_3
        //   86: invokeinterface 121 2 0
        //   91: checkcast 111	com/tencent/mm/plugin/cdndownloader/ipc/CDNTaskState
        //   94: astore_1
        //   95: aload_3
        //   96: invokevirtual 59	android/os/Parcel:recycle	()V
        //   99: aload_2
        //   100: invokevirtual 59	android/os/Parcel:recycle	()V
        //   103: ldc 107
        //   105: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   108: aload_1
        //   109: areturn
        //   110: aconst_null
        //   111: astore_1
        //   112: goto -17 -> 95
        //   115: astore_1
        //   116: aload_3
        //   117: invokevirtual 59	android/os/Parcel:recycle	()V
        //   120: aload_2
        //   121: invokevirtual 59	android/os/Parcel:recycle	()V
        //   124: ldc 107
        //   126: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   129: aload_1
        //   130: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	131	0	this	a
        //   0	131	1	paramString	String
        //   8	113	2	localParcel1	Parcel
        //   12	105	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	56	115	finally
        //   71	95	115	finally
      }
      
      public final int b(CDNTaskInfo paramCDNTaskInfo)
      {
        AppMethodBeat.i(120694);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
          if (paramCDNTaskInfo != null)
          {
            localParcel1.writeInt(1);
            paramCDNTaskInfo.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (a.a.cMs() != null))
          {
            i = a.a.cMs().b(paramCDNTaskInfo);
            return i;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(120694);
        }
        int i = localParcel2.readInt();
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(120694);
        return i;
      }
      
      public final void b(b paramb)
      {
        AppMethodBeat.i(120699);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
          if (paramb != null) {}
          for (IBinder localIBinder = paramb.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(7, localParcel1, localParcel2, 0)) || (a.a.cMs() == null)) {
              break;
            }
            a.a.cMs().b(paramb);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(120699);
        }
      }
      
      public final void cMp()
      {
        AppMethodBeat.i(120701);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
          if ((!this.mRemote.transact(9, localParcel1, localParcel2, 0)) && (a.a.cMs() != null))
          {
            a.a.cMs().cMp();
            return;
          }
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
      
      public final void cMq()
      {
        AppMethodBeat.i(120702);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
          if ((!this.mRemote.transact(10, localParcel1, localParcel2, 0)) && (a.a.cMs() != null))
          {
            a.a.cMs().cMq();
            return;
          }
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
      
      public final void cMr()
      {
        AppMethodBeat.i(120703);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
          if ((!this.mRemote.transact(11, localParcel1, localParcel2, 0)) && (a.a.cMs() != null))
          {
            a.a.cMs().cMr();
            return;
          }
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