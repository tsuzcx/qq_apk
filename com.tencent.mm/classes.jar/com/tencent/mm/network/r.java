package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.h.a;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.a;

public abstract interface r
  extends IInterface
{
  public abstract void a(d paramd, j paramj, int paramInt1, int paramInt2);
  
  public abstract void a(j paramj, int paramInt1, int paramInt2);
  
  public abstract void a(j paramj, int paramInt1, int paramInt2, String paramString);
  
  public abstract h aFi();
  
  public abstract i aFj();
  
  public abstract int aFk();
  
  public abstract boolean getIsLongPolling();
  
  public abstract boolean getIsUserCmd();
  
  public abstract int getLongPollingTimeout();
  
  public abstract int getMMReqRespHash();
  
  public abstract int getNewExtFlags();
  
  public abstract int getOptions();
  
  public abstract int getTimeOut();
  
  public abstract byte[] getTransHeader();
  
  public abstract int getType();
  
  public abstract String getUri();
  
  public abstract boolean isSingleSession();
  
  public abstract void setConnectionInfo(String paramString);
  
  public static abstract class a
    extends Binder
    implements r
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.network.IReqResp_AIDL");
    }
    
    public static r p(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.network.IReqResp_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof r))) {
        return (r)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      i locali = null;
      h localh = null;
      int j = 0;
      int i = 0;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.network.IReqResp_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramInt1 = getType();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramParcel1 = getUri();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        locali = aFj();
        paramParcel2.writeNoException();
        paramParcel1 = localh;
        if (locali != null) {
          paramParcel1 = locali.asBinder();
        }
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        localh = aFi();
        paramParcel2.writeNoException();
        paramParcel1 = locali;
        if (localh != null) {
          paramParcel1 = localh.asBinder();
        }
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        a(j.a.o(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramInt1 = getMMReqRespHash();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        bool = getIsUserCmd();
        paramParcel2.writeNoException();
        if (bool) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramInt1 = getOptions();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        setConnectionInfo(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        a(j.a.o(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        a(d.a.l(paramParcel1.readStrongBinder()), j.a.o(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramInt1 = aFk();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramInt1 = getTimeOut();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        bool = isSingleSession();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        bool = getIsLongPolling();
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramInt1 = getLongPollingTimeout();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
        paramInt1 = getNewExtFlags();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
      paramParcel1 = getTransHeader();
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    }
    
    static final class a
      implements r
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public final void a(d paramd, j paramj, int paramInt1, int paramInt2)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: ldc 21
        //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   16: astore 7
        //   18: aload 6
        //   20: ldc 35
        //   22: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   25: aload_1
        //   26: ifnull +87 -> 113
        //   29: aload_1
        //   30: invokeinterface 45 1 0
        //   35: astore_1
        //   36: aload 6
        //   38: aload_1
        //   39: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   42: aload 5
        //   44: astore_1
        //   45: aload_2
        //   46: ifnull +10 -> 56
        //   49: aload_2
        //   50: invokeinterface 51 1 0
        //   55: astore_1
        //   56: aload 6
        //   58: aload_1
        //   59: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   62: aload 6
        //   64: iload_3
        //   65: invokevirtual 54	android/os/Parcel:writeInt	(I)V
        //   68: aload 6
        //   70: iload 4
        //   72: invokevirtual 54	android/os/Parcel:writeInt	(I)V
        //   75: aload_0
        //   76: getfield 18	com/tencent/mm/network/r$a$a:mRemote	Landroid/os/IBinder;
        //   79: bipush 11
        //   81: aload 6
        //   83: aload 7
        //   85: iconst_0
        //   86: invokeinterface 60 5 0
        //   91: pop
        //   92: aload 7
        //   94: invokevirtual 63	android/os/Parcel:readException	()V
        //   97: aload 7
        //   99: invokevirtual 66	android/os/Parcel:recycle	()V
        //   102: aload 6
        //   104: invokevirtual 66	android/os/Parcel:recycle	()V
        //   107: ldc 21
        //   109: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   112: return
        //   113: aconst_null
        //   114: astore_1
        //   115: goto -79 -> 36
        //   118: astore_1
        //   119: aload 7
        //   121: invokevirtual 66	android/os/Parcel:recycle	()V
        //   124: aload 6
        //   126: invokevirtual 66	android/os/Parcel:recycle	()V
        //   129: ldc 21
        //   131: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   134: aload_1
        //   135: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	136	0	this	a
        //   0	136	1	paramd	d
        //   0	136	2	paramj	j
        //   0	136	3	paramInt1	int
        //   0	136	4	paramInt2	int
        //   1	42	5	localObject	Object
        //   11	114	6	localParcel1	Parcel
        //   16	104	7	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   18	25	118	finally
        //   29	36	118	finally
        //   36	42	118	finally
        //   49	56	118	finally
        //   56	97	118	finally
      }
      
      /* Error */
      public final void a(j paramj, int paramInt1, int paramInt2)
      {
        // Byte code:
        //   0: ldc 71
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 4
        //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 5
        //   15: aload 4
        //   17: ldc 35
        //   19: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload_1
        //   23: ifnull +65 -> 88
        //   26: aload_1
        //   27: invokeinterface 51 1 0
        //   32: astore_1
        //   33: aload 4
        //   35: aload_1
        //   36: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 4
        //   41: iload_2
        //   42: invokevirtual 54	android/os/Parcel:writeInt	(I)V
        //   45: aload 4
        //   47: iload_3
        //   48: invokevirtual 54	android/os/Parcel:writeInt	(I)V
        //   51: aload_0
        //   52: getfield 18	com/tencent/mm/network/r$a$a:mRemote	Landroid/os/IBinder;
        //   55: iconst_5
        //   56: aload 4
        //   58: aload 5
        //   60: iconst_0
        //   61: invokeinterface 60 5 0
        //   66: pop
        //   67: aload 5
        //   69: invokevirtual 63	android/os/Parcel:readException	()V
        //   72: aload 5
        //   74: invokevirtual 66	android/os/Parcel:recycle	()V
        //   77: aload 4
        //   79: invokevirtual 66	android/os/Parcel:recycle	()V
        //   82: ldc 71
        //   84: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   87: return
        //   88: aconst_null
        //   89: astore_1
        //   90: goto -57 -> 33
        //   93: astore_1
        //   94: aload 5
        //   96: invokevirtual 66	android/os/Parcel:recycle	()V
        //   99: aload 4
        //   101: invokevirtual 66	android/os/Parcel:recycle	()V
        //   104: ldc 71
        //   106: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   109: aload_1
        //   110: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	111	0	this	a
        //   0	111	1	paramj	j
        //   0	111	2	paramInt1	int
        //   0	111	3	paramInt2	int
        //   8	92	4	localParcel1	Parcel
        //   13	82	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	22	93	finally
        //   26	33	93	finally
        //   33	72	93	finally
      }
      
      /* Error */
      public final void a(j paramj, int paramInt1, int paramInt2, String paramString)
      {
        // Byte code:
        //   0: ldc 73
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 6
        //   15: aload 5
        //   17: ldc 35
        //   19: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload_1
        //   23: ifnull +73 -> 96
        //   26: aload_1
        //   27: invokeinterface 51 1 0
        //   32: astore_1
        //   33: aload 5
        //   35: aload_1
        //   36: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 5
        //   41: iload_2
        //   42: invokevirtual 54	android/os/Parcel:writeInt	(I)V
        //   45: aload 5
        //   47: iload_3
        //   48: invokevirtual 54	android/os/Parcel:writeInt	(I)V
        //   51: aload 5
        //   53: aload 4
        //   55: invokevirtual 76	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   58: aload_0
        //   59: getfield 18	com/tencent/mm/network/r$a$a:mRemote	Landroid/os/IBinder;
        //   62: bipush 10
        //   64: aload 5
        //   66: aload 6
        //   68: iconst_0
        //   69: invokeinterface 60 5 0
        //   74: pop
        //   75: aload 6
        //   77: invokevirtual 63	android/os/Parcel:readException	()V
        //   80: aload 6
        //   82: invokevirtual 66	android/os/Parcel:recycle	()V
        //   85: aload 5
        //   87: invokevirtual 66	android/os/Parcel:recycle	()V
        //   90: ldc 73
        //   92: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   95: return
        //   96: aconst_null
        //   97: astore_1
        //   98: goto -65 -> 33
        //   101: astore_1
        //   102: aload 6
        //   104: invokevirtual 66	android/os/Parcel:recycle	()V
        //   107: aload 5
        //   109: invokevirtual 66	android/os/Parcel:recycle	()V
        //   112: ldc 73
        //   114: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   117: aload_1
        //   118: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	119	0	this	a
        //   0	119	1	paramj	j
        //   0	119	2	paramInt1	int
        //   0	119	3	paramInt2	int
        //   0	119	4	paramString	String
        //   8	100	5	localParcel1	Parcel
        //   13	90	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	22	101	finally
        //   26	33	101	finally
        //   33	80	101	finally
      }
      
      public final h aFi()
      {
        AppMethodBeat.i(132760);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          h localh = h.a.I(localParcel2.readStrongBinder());
          return localh;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132760);
        }
      }
      
      public final i aFj()
      {
        AppMethodBeat.i(132759);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          i locali = i.a.J(localParcel2.readStrongBinder());
          return locali;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132759);
        }
      }
      
      public final int aFk()
      {
        AppMethodBeat.i(132768);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          this.mRemote.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132768);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final boolean getIsLongPolling()
      {
        boolean bool = false;
        AppMethodBeat.i(189845);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          this.mRemote.transact(15, localParcel1, localParcel2, 0);
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
          AppMethodBeat.o(189845);
        }
      }
      
      public final boolean getIsUserCmd()
      {
        boolean bool = false;
        AppMethodBeat.i(132763);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
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
          AppMethodBeat.o(132763);
        }
      }
      
      public final int getLongPollingTimeout()
      {
        AppMethodBeat.i(189846);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          this.mRemote.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(189846);
        }
      }
      
      public final int getMMReqRespHash()
      {
        AppMethodBeat.i(132762);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132762);
        }
      }
      
      public final int getNewExtFlags()
      {
        AppMethodBeat.i(189847);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          this.mRemote.transact(17, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(189847);
        }
      }
      
      public final int getOptions()
      {
        AppMethodBeat.i(132764);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132764);
        }
      }
      
      public final int getTimeOut()
      {
        AppMethodBeat.i(132769);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          this.mRemote.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132769);
        }
      }
      
      public final byte[] getTransHeader()
      {
        AppMethodBeat.i(189848);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          this.mRemote.transact(18, localParcel1, localParcel2, 0);
          localParcel2.readException();
          byte[] arrayOfByte = localParcel2.createByteArray();
          return arrayOfByte;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(189848);
        }
      }
      
      public final int getType()
      {
        AppMethodBeat.i(132757);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132757);
        }
      }
      
      public final String getUri()
      {
        AppMethodBeat.i(132758);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132758);
        }
      }
      
      public final boolean isSingleSession()
      {
        boolean bool = false;
        AppMethodBeat.i(132770);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          this.mRemote.transact(14, localParcel1, localParcel2, 0);
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
          AppMethodBeat.o(132770);
        }
      }
      
      public final void setConnectionInfo(String paramString)
      {
        AppMethodBeat.i(132765);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
          localParcel1.writeString(paramString);
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132765);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.r
 * JD-Core Version:    0.7.0.1
 */