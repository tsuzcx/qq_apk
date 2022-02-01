package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface h
  extends IInterface
{
  public abstract long a(p paramp);
  
  public abstract void a(n paramn);
  
  public abstract boolean a(long paramLong, int paramInt, k paramk);
  
  public abstract boolean a(i parami);
  
  public abstract boolean a(s params);
  
  public abstract boolean a(String paramString, boolean paramBoolean, q paramq);
  
  public abstract boolean b(int paramInt, j paramj);
  
  public abstract boolean b(long paramLong, int paramInt, k paramk);
  
  public abstract boolean b(long paramLong, byte[] paramArrayOfByte, t paramt);
  
  public abstract boolean b(i parami);
  
  public abstract boolean c(int paramInt, j paramj);
  
  public abstract boolean d(int paramInt, j paramj);
  
  public abstract long[] dGg();
  
  public abstract boolean e(int paramInt, j paramj);
  
  public abstract boolean lI(long paramLong);
  
  public abstract boolean lJ(long paramLong);
  
  public abstract boolean lK(long paramLong);
  
  public abstract boolean lL(long paramLong);
  
  public abstract void setChannelSessionKey(long paramLong, byte[] paramArrayOfByte);
  
  public static abstract class a
    extends Binder
    implements h
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
    }
    
    public static h E(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof h))) {
        return (h)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static h dGk()
    {
      return a.yvp;
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      Object localObject1 = null;
      Object localObject4 = null;
      Object localObject2 = null;
      Object localObject3 = null;
      int j = 0;
      int k = 0;
      int m = 0;
      int n = 0;
      int i1 = 0;
      int i2 = 0;
      int i3 = 0;
      int i4 = 0;
      int i5 = 0;
      int i6 = 0;
      int i7 = 0;
      int i8 = 0;
      int i9 = 0;
      int i = 0;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        bool = b(paramParcel1.readInt(), j.a.G(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        if (bool) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        bool = c(paramParcel1.readInt(), j.a.G(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        paramParcel1 = dGg();
        paramParcel2.writeNoException();
        paramParcel2.writeLongArray(paramParcel1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        bool = a(paramParcel1.readLong(), paramParcel1.readInt(), k.a.H(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        bool = lI(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        bool = lJ(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        l = a(p.a.K(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        bool = lK(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramInt1 = n;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        bool = a(i.a.F(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramInt1 = i1;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        bool = b(i.a.F(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramInt1 = i2;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        paramParcel1 = paramParcel1.readStrongBinder();
        if (paramParcel1 == null) {
          paramParcel1 = localObject3;
        }
        for (;;)
        {
          a(paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceInvoker_AIDL");
          if ((localObject1 != null) && ((localObject1 instanceof n))) {
            paramParcel1 = (n)localObject1;
          } else {
            paramParcel1 = new n.a.a(paramParcel1);
          }
        }
      case 12: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        setChannelSessionKey(paramParcel1.readLong(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        localObject2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          bool = true;
          paramParcel1 = paramParcel1.readStrongBinder();
          if (paramParcel1 != null) {
            break label793;
          }
          paramParcel1 = (Parcel)localObject1;
        }
        for (;;)
        {
          bool = a((String)localObject2, bool, paramParcel1);
          paramParcel2.writeNoException();
          paramInt1 = i3;
          if (bool) {
            paramInt1 = 1;
          }
          paramParcel2.writeInt(paramInt1);
          return true;
          bool = false;
          break;
          localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
          if ((localObject1 != null) && ((localObject1 instanceof q))) {
            paramParcel1 = (q)localObject1;
          } else {
            paramParcel1 = new q.a.a(paramParcel1);
          }
        }
      case 14: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        bool = d(paramParcel1.readInt(), j.a.G(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramInt1 = i4;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        bool = e(paramParcel1.readInt(), j.a.G(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramInt1 = i5;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        bool = b(paramParcel1.readLong(), paramParcel1.readInt(), k.a.H(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramInt1 = i6;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        bool = lL(paramParcel1.readLong());
        paramParcel2.writeNoException();
        paramInt1 = i7;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 18: 
        label793:
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        paramParcel1 = paramParcel1.readStrongBinder();
        if (paramParcel1 == null) {
          paramParcel1 = localObject4;
        }
        for (;;)
        {
          bool = a(paramParcel1);
          paramParcel2.writeNoException();
          paramInt1 = i8;
          if (bool) {
            paramInt1 = 1;
          }
          paramParcel2.writeInt(paramInt1);
          return true;
          localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
          if ((localObject1 != null) && ((localObject1 instanceof s))) {
            paramParcel1 = (s)localObject1;
          } else {
            paramParcel1 = new s.a.a(paramParcel1);
          }
        }
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      long l = paramParcel1.readLong();
      localObject1 = paramParcel1.createByteArray();
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = (Parcel)localObject2;
      }
      for (;;)
      {
        bool = b(l, (byte[])localObject1, paramParcel1);
        paramParcel2.writeNoException();
        paramInt1 = i9;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
        localObject2 = paramParcel1.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnSendEnd_AIDL");
        if ((localObject2 != null) && ((localObject2 instanceof t))) {
          paramParcel1 = (t)localObject2;
        } else {
          paramParcel1 = new t.a.a(paramParcel1);
        }
      }
    }
    
    static final class a
      implements h
    {
      public static h yvp;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final long a(p paramp)
      {
        AppMethodBeat.i(23666);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
          if (paramp != null) {}
          for (IBinder localIBinder = paramp.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(7, localParcel1, localParcel2, 0)) || (h.a.dGk() == null)) {
              break;
            }
            l = h.a.dGk().a(paramp);
            return l;
          }
          localParcel2.readException();
          long l = localParcel2.readLong();
          return l;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(23666);
        }
      }
      
      public final void a(n paramn)
      {
        AppMethodBeat.i(23670);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
          if (paramn != null) {}
          for (IBinder localIBinder = paramn.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(11, localParcel1, localParcel2, 0)) || (h.a.dGk() == null)) {
              break;
            }
            h.a.dGk().a(paramn);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(23670);
        }
      }
      
      public final boolean a(long paramLong, int paramInt, k paramk)
      {
        boolean bool = false;
        AppMethodBeat.i(23663);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
          localParcel1.writeLong(paramLong);
          localParcel1.writeInt(paramInt);
          if (paramk != null) {}
          for (IBinder localIBinder = paramk.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(4, localParcel1, localParcel2, 0)) || (h.a.dGk() == null)) {
              break;
            }
            bool = h.a.dGk().a(paramLong, paramInt, paramk);
            return bool;
          }
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
          AppMethodBeat.o(23663);
        }
      }
      
      public final boolean a(i parami)
      {
        boolean bool = false;
        AppMethodBeat.i(23668);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
          if (parami != null) {}
          for (IBinder localIBinder = parami.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(9, localParcel1, localParcel2, 0)) || (h.a.dGk() == null)) {
              break;
            }
            bool = h.a.dGk().a(parami);
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
          AppMethodBeat.o(23668);
        }
      }
      
      public final boolean a(s params)
      {
        boolean bool = false;
        AppMethodBeat.i(23677);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
          if (params != null) {}
          for (IBinder localIBinder = params.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(18, localParcel1, localParcel2, 0)) || (h.a.dGk() == null)) {
              break;
            }
            bool = h.a.dGk().a(params);
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
          AppMethodBeat.o(23677);
        }
      }
      
      /* Error */
      public final boolean a(String paramString, boolean paramBoolean, q paramq)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 5
        //   3: sipush 23672
        //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 7
        //   14: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   17: astore 8
        //   19: aload 7
        //   21: ldc 36
        //   23: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   26: aload 7
        //   28: aload_1
        //   29: invokevirtual 113	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   32: iload_2
        //   33: ifeq +87 -> 120
        //   36: iconst_1
        //   37: istore 4
        //   39: aload 7
        //   41: iload 4
        //   43: invokevirtual 88	android/os/Parcel:writeInt	(I)V
        //   46: aload_3
        //   47: ifnull +79 -> 126
        //   50: aload_3
        //   51: invokeinterface 116 1 0
        //   56: astore 6
        //   58: aload 7
        //   60: aload 6
        //   62: invokevirtual 49	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   65: aload_0
        //   66: getfield 20	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
        //   69: bipush 13
        //   71: aload 7
        //   73: aload 8
        //   75: iconst_0
        //   76: invokeinterface 55 5 0
        //   81: ifne +51 -> 132
        //   84: invokestatic 59	com/tencent/mm/plugin/exdevice/service/h$a:dGk	()Lcom/tencent/mm/plugin/exdevice/service/h;
        //   87: ifnull +45 -> 132
        //   90: invokestatic 59	com/tencent/mm/plugin/exdevice/service/h$a:dGk	()Lcom/tencent/mm/plugin/exdevice/service/h;
        //   93: aload_1
        //   94: iload_2
        //   95: aload_3
        //   96: invokeinterface 118 4 0
        //   101: istore_2
        //   102: aload 8
        //   104: invokevirtual 64	android/os/Parcel:recycle	()V
        //   107: aload 7
        //   109: invokevirtual 64	android/os/Parcel:recycle	()V
        //   112: sipush 23672
        //   115: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   118: iload_2
        //   119: ireturn
        //   120: iconst_0
        //   121: istore 4
        //   123: goto -84 -> 39
        //   126: aconst_null
        //   127: astore 6
        //   129: goto -71 -> 58
        //   132: aload 8
        //   134: invokevirtual 70	android/os/Parcel:readException	()V
        //   137: aload 8
        //   139: invokevirtual 97	android/os/Parcel:readInt	()I
        //   142: istore 4
        //   144: iload 4
        //   146: ifeq +24 -> 170
        //   149: iload 5
        //   151: istore_2
        //   152: aload 8
        //   154: invokevirtual 64	android/os/Parcel:recycle	()V
        //   157: aload 7
        //   159: invokevirtual 64	android/os/Parcel:recycle	()V
        //   162: sipush 23672
        //   165: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   168: iload_2
        //   169: ireturn
        //   170: iconst_0
        //   171: istore_2
        //   172: goto -20 -> 152
        //   175: astore_1
        //   176: aload 8
        //   178: invokevirtual 64	android/os/Parcel:recycle	()V
        //   181: aload 7
        //   183: invokevirtual 64	android/os/Parcel:recycle	()V
        //   186: sipush 23672
        //   189: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   192: aload_1
        //   193: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	194	0	this	a
        //   0	194	1	paramString	String
        //   0	194	2	paramBoolean	boolean
        //   0	194	3	paramq	q
        //   37	108	4	i	int
        //   1	149	5	bool	boolean
        //   56	72	6	localIBinder	IBinder
        //   12	170	7	localParcel1	Parcel
        //   17	160	8	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   19	32	175	finally
        //   39	46	175	finally
        //   50	58	175	finally
        //   58	102	175	finally
        //   132	144	175	finally
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public final boolean b(int paramInt, j paramj)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_3
        //   2: sipush 23660
        //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 5
        //   13: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   16: astore 6
        //   18: aload 5
        //   20: ldc 36
        //   22: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   25: aload 5
        //   27: iload_1
        //   28: invokevirtual 88	android/os/Parcel:writeInt	(I)V
        //   31: aload_2
        //   32: ifnull +71 -> 103
        //   35: aload_2
        //   36: invokeinterface 123 1 0
        //   41: astore 4
        //   43: aload 5
        //   45: aload 4
        //   47: invokevirtual 49	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   50: aload_0
        //   51: getfield 20	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
        //   54: iconst_1
        //   55: aload 5
        //   57: aload 6
        //   59: iconst_0
        //   60: invokeinterface 55 5 0
        //   65: ifne +44 -> 109
        //   68: invokestatic 59	com/tencent/mm/plugin/exdevice/service/h$a:dGk	()Lcom/tencent/mm/plugin/exdevice/service/h;
        //   71: ifnull +38 -> 109
        //   74: invokestatic 59	com/tencent/mm/plugin/exdevice/service/h$a:dGk	()Lcom/tencent/mm/plugin/exdevice/service/h;
        //   77: iload_1
        //   78: aload_2
        //   79: invokeinterface 125 3 0
        //   84: istore_3
        //   85: aload 6
        //   87: invokevirtual 64	android/os/Parcel:recycle	()V
        //   90: aload 5
        //   92: invokevirtual 64	android/os/Parcel:recycle	()V
        //   95: sipush 23660
        //   98: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   101: iload_3
        //   102: ireturn
        //   103: aconst_null
        //   104: astore 4
        //   106: goto -63 -> 43
        //   109: aload 6
        //   111: invokevirtual 70	android/os/Parcel:readException	()V
        //   114: aload 6
        //   116: invokevirtual 97	android/os/Parcel:readInt	()I
        //   119: istore_1
        //   120: iload_1
        //   121: ifeq +21 -> 142
        //   124: aload 6
        //   126: invokevirtual 64	android/os/Parcel:recycle	()V
        //   129: aload 5
        //   131: invokevirtual 64	android/os/Parcel:recycle	()V
        //   134: sipush 23660
        //   137: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   140: iload_3
        //   141: ireturn
        //   142: iconst_0
        //   143: istore_3
        //   144: goto -20 -> 124
        //   147: astore_2
        //   148: aload 6
        //   150: invokevirtual 64	android/os/Parcel:recycle	()V
        //   153: aload 5
        //   155: invokevirtual 64	android/os/Parcel:recycle	()V
        //   158: sipush 23660
        //   161: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   164: aload_2
        //   165: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	166	0	this	a
        //   0	166	1	paramInt	int
        //   0	166	2	paramj	j
        //   1	143	3	bool	boolean
        //   41	64	4	localIBinder	IBinder
        //   11	143	5	localParcel1	Parcel
        //   16	133	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   18	31	147	finally
        //   35	43	147	finally
        //   43	85	147	finally
        //   109	120	147	finally
      }
      
      public final boolean b(long paramLong, int paramInt, k paramk)
      {
        boolean bool = false;
        AppMethodBeat.i(23675);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
          localParcel1.writeLong(paramLong);
          localParcel1.writeInt(paramInt);
          if (paramk != null) {}
          for (IBinder localIBinder = paramk.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(16, localParcel1, localParcel2, 0)) || (h.a.dGk() == null)) {
              break;
            }
            bool = h.a.dGk().b(paramLong, paramInt, paramk);
            return bool;
          }
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
          AppMethodBeat.o(23675);
        }
      }
      
      public final boolean b(long paramLong, byte[] paramArrayOfByte, t paramt)
      {
        boolean bool = false;
        AppMethodBeat.i(23678);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
          localParcel1.writeLong(paramLong);
          localParcel1.writeByteArray(paramArrayOfByte);
          if (paramt != null) {}
          for (IBinder localIBinder = paramt.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(19, localParcel1, localParcel2, 0)) || (h.a.dGk() == null)) {
              break;
            }
            bool = h.a.dGk().b(paramLong, paramArrayOfByte, paramt);
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
          AppMethodBeat.o(23678);
        }
      }
      
      public final boolean b(i parami)
      {
        boolean bool = false;
        AppMethodBeat.i(23669);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
          if (parami != null) {}
          for (IBinder localIBinder = parami.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(10, localParcel1, localParcel2, 0)) || (h.a.dGk() == null)) {
              break;
            }
            bool = h.a.dGk().b(parami);
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
          AppMethodBeat.o(23669);
        }
      }
      
      public final boolean c(int paramInt, j paramj)
      {
        boolean bool = false;
        AppMethodBeat.i(23661);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
          localParcel1.writeInt(paramInt);
          if (paramj != null) {}
          for (IBinder localIBinder = paramj.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(2, localParcel1, localParcel2, 0)) || (h.a.dGk() == null)) {
              break;
            }
            bool = h.a.dGk().c(paramInt, paramj);
            return bool;
          }
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
          AppMethodBeat.o(23661);
        }
      }
      
      public final boolean d(int paramInt, j paramj)
      {
        boolean bool = false;
        AppMethodBeat.i(23673);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
          localParcel1.writeInt(paramInt);
          if (paramj != null) {}
          for (IBinder localIBinder = paramj.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(14, localParcel1, localParcel2, 0)) || (h.a.dGk() == null)) {
              break;
            }
            bool = h.a.dGk().d(paramInt, paramj);
            return bool;
          }
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
          AppMethodBeat.o(23673);
        }
      }
      
      public final long[] dGg()
      {
        AppMethodBeat.i(23662);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (h.a.dGk() != null))
          {
            arrayOfLong = h.a.dGk().dGg();
            return arrayOfLong;
          }
          localParcel2.readException();
          long[] arrayOfLong = localParcel2.createLongArray();
          return arrayOfLong;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(23662);
        }
      }
      
      public final boolean e(int paramInt, j paramj)
      {
        boolean bool = false;
        AppMethodBeat.i(23674);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
          localParcel1.writeInt(paramInt);
          if (paramj != null) {}
          for (IBinder localIBinder = paramj.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(15, localParcel1, localParcel2, 0)) || (h.a.dGk() == null)) {
              break;
            }
            bool = h.a.dGk().e(paramInt, paramj);
            return bool;
          }
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
          AppMethodBeat.o(23674);
        }
      }
      
      public final boolean lI(long paramLong)
      {
        boolean bool = false;
        AppMethodBeat.i(23664);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
          localParcel1.writeLong(paramLong);
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (h.a.dGk() != null))
          {
            bool = h.a.dGk().lI(paramLong);
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
          AppMethodBeat.o(23664);
        }
      }
      
      public final boolean lJ(long paramLong)
      {
        boolean bool = false;
        AppMethodBeat.i(23665);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
          localParcel1.writeLong(paramLong);
          if ((!this.mRemote.transact(6, localParcel1, localParcel2, 0)) && (h.a.dGk() != null))
          {
            bool = h.a.dGk().lJ(paramLong);
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
          AppMethodBeat.o(23665);
        }
      }
      
      public final boolean lK(long paramLong)
      {
        boolean bool = false;
        AppMethodBeat.i(23667);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
          localParcel1.writeLong(paramLong);
          if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (h.a.dGk() != null))
          {
            bool = h.a.dGk().lK(paramLong);
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
          AppMethodBeat.o(23667);
        }
      }
      
      public final boolean lL(long paramLong)
      {
        boolean bool = false;
        AppMethodBeat.i(23676);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
          localParcel1.writeLong(paramLong);
          if ((!this.mRemote.transact(17, localParcel1, localParcel2, 0)) && (h.a.dGk() != null))
          {
            bool = h.a.dGk().lL(paramLong);
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
          AppMethodBeat.o(23676);
        }
      }
      
      public final void setChannelSessionKey(long paramLong, byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(23671);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
          localParcel1.writeLong(paramLong);
          localParcel1.writeByteArray(paramArrayOfByte);
          if ((!this.mRemote.transact(12, localParcel1, localParcel2, 0)) && (h.a.dGk() != null))
          {
            h.a.dGk().setChannelSessionKey(paramLong, paramArrayOfByte);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(23671);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.h
 * JD-Core Version:    0.7.0.1
 */