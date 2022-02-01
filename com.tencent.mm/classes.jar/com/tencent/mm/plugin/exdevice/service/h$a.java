package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class h$a
  extends Binder
  implements h
{
  public h$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
  }
  
  public static h v(IBinder paramIBinder)
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
      bool = b(paramParcel1.readInt(), j.a.x(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = c(paramParcel1.readInt(), j.a.x(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      paramParcel1 = bZV();
      paramParcel2.writeNoException();
      paramParcel2.writeLongArray(paramParcel1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = a(paramParcel1.readLong(), paramParcel1.readInt(), k.a.y(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = oZ(paramParcel1.readLong());
      paramParcel2.writeNoException();
      paramInt1 = k;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = pa(paramParcel1.readLong());
      paramParcel2.writeNoException();
      paramInt1 = m;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      l = a(p.a.B(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = pb(paramParcel1.readLong());
      paramParcel2.writeNoException();
      paramInt1 = n;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = a(i.a.w(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = i1;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = b(i.a.w(paramParcel1.readStrongBinder()));
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
      bool = d(paramParcel1.readInt(), j.a.x(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = i4;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = e(paramParcel1.readInt(), j.a.x(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = i5;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = b(paramParcel1.readLong(), paramParcel1.readInt(), k.a.y(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = i6;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
      bool = pc(paramParcel1.readLong());
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
    private IBinder mRemote;
    
    a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    /* Error */
    public final long a(p paramp)
    {
      // Byte code:
      //   0: sipush 23666
      //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   9: astore 4
      //   11: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   14: astore 5
      //   16: aload 4
      //   18: ldc 34
      //   20: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   23: aload_1
      //   24: ifnull +62 -> 86
      //   27: aload_1
      //   28: invokeinterface 44 1 0
      //   33: astore_1
      //   34: aload 4
      //   36: aload_1
      //   37: invokevirtual 47	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   40: aload_0
      //   41: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
      //   44: bipush 7
      //   46: aload 4
      //   48: aload 5
      //   50: iconst_0
      //   51: invokeinterface 53 5 0
      //   56: pop
      //   57: aload 5
      //   59: invokevirtual 56	android/os/Parcel:readException	()V
      //   62: aload 5
      //   64: invokevirtual 60	android/os/Parcel:readLong	()J
      //   67: lstore_2
      //   68: aload 5
      //   70: invokevirtual 63	android/os/Parcel:recycle	()V
      //   73: aload 4
      //   75: invokevirtual 63	android/os/Parcel:recycle	()V
      //   78: sipush 23666
      //   81: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   84: lload_2
      //   85: lreturn
      //   86: aconst_null
      //   87: astore_1
      //   88: goto -54 -> 34
      //   91: astore_1
      //   92: aload 5
      //   94: invokevirtual 63	android/os/Parcel:recycle	()V
      //   97: aload 4
      //   99: invokevirtual 63	android/os/Parcel:recycle	()V
      //   102: sipush 23666
      //   105: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   108: aload_1
      //   109: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	110	0	this	a
      //   0	110	1	paramp	p
      //   67	18	2	l	long
      //   9	89	4	localParcel1	Parcel
      //   14	79	5	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   16	23	91	finally
      //   27	34	91	finally
      //   34	68	91	finally
    }
    
    /* Error */
    public final void a(n paramn)
    {
      // Byte code:
      //   0: sipush 23670
      //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   9: astore_2
      //   10: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   13: astore_3
      //   14: aload_2
      //   15: ldc 34
      //   17: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   20: aload_1
      //   21: ifnull +49 -> 70
      //   24: aload_1
      //   25: invokeinterface 70 1 0
      //   30: astore_1
      //   31: aload_2
      //   32: aload_1
      //   33: invokevirtual 47	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   36: aload_0
      //   37: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
      //   40: bipush 11
      //   42: aload_2
      //   43: aload_3
      //   44: iconst_0
      //   45: invokeinterface 53 5 0
      //   50: pop
      //   51: aload_3
      //   52: invokevirtual 56	android/os/Parcel:readException	()V
      //   55: aload_3
      //   56: invokevirtual 63	android/os/Parcel:recycle	()V
      //   59: aload_2
      //   60: invokevirtual 63	android/os/Parcel:recycle	()V
      //   63: sipush 23670
      //   66: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   69: return
      //   70: aconst_null
      //   71: astore_1
      //   72: goto -41 -> 31
      //   75: astore_1
      //   76: aload_3
      //   77: invokevirtual 63	android/os/Parcel:recycle	()V
      //   80: aload_2
      //   81: invokevirtual 63	android/os/Parcel:recycle	()V
      //   84: sipush 23670
      //   87: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   90: aload_1
      //   91: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	92	0	this	a
      //   0	92	1	paramn	n
      //   9	72	2	localParcel1	Parcel
      //   13	64	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   14	20	75	finally
      //   24	31	75	finally
      //   31	55	75	finally
    }
    
    /* Error */
    public final boolean a(long paramLong, int paramInt, k paramk)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 5
      //   3: sipush 23663
      //   6: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   12: astore 6
      //   14: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   17: astore 7
      //   19: aload 6
      //   21: ldc 34
      //   23: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   26: aload 6
      //   28: lload_1
      //   29: invokevirtual 75	android/os/Parcel:writeLong	(J)V
      //   32: aload 6
      //   34: iload_3
      //   35: invokevirtual 78	android/os/Parcel:writeInt	(I)V
      //   38: aload 4
      //   40: ifnull +72 -> 112
      //   43: aload 4
      //   45: invokeinterface 81 1 0
      //   50: astore 4
      //   52: aload 6
      //   54: aload 4
      //   56: invokevirtual 47	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   59: aload_0
      //   60: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
      //   63: iconst_4
      //   64: aload 6
      //   66: aload 7
      //   68: iconst_0
      //   69: invokeinterface 53 5 0
      //   74: pop
      //   75: aload 7
      //   77: invokevirtual 56	android/os/Parcel:readException	()V
      //   80: aload 7
      //   82: invokevirtual 85	android/os/Parcel:readInt	()I
      //   85: istore_3
      //   86: iload_3
      //   87: ifeq +6 -> 93
      //   90: iconst_1
      //   91: istore 5
      //   93: aload 7
      //   95: invokevirtual 63	android/os/Parcel:recycle	()V
      //   98: aload 6
      //   100: invokevirtual 63	android/os/Parcel:recycle	()V
      //   103: sipush 23663
      //   106: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   109: iload 5
      //   111: ireturn
      //   112: aconst_null
      //   113: astore 4
      //   115: goto -63 -> 52
      //   118: astore 4
      //   120: aload 7
      //   122: invokevirtual 63	android/os/Parcel:recycle	()V
      //   125: aload 6
      //   127: invokevirtual 63	android/os/Parcel:recycle	()V
      //   130: sipush 23663
      //   133: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   136: aload 4
      //   138: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	139	0	this	a
      //   0	139	1	paramLong	long
      //   0	139	3	paramInt	int
      //   0	139	4	paramk	k
      //   1	109	5	bool	boolean
      //   12	114	6	localParcel1	Parcel
      //   17	104	7	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   19	38	118	finally
      //   43	52	118	finally
      //   52	86	118	finally
    }
    
    /* Error */
    public final boolean a(i parami)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: sipush 23668
      //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   11: astore 4
      //   13: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   16: astore 5
      //   18: aload 4
      //   20: ldc 34
      //   22: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   25: aload_1
      //   26: ifnull +68 -> 94
      //   29: aload_1
      //   30: invokeinterface 89 1 0
      //   35: astore_1
      //   36: aload 4
      //   38: aload_1
      //   39: invokevirtual 47	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   42: aload_0
      //   43: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
      //   46: bipush 9
      //   48: aload 4
      //   50: aload 5
      //   52: iconst_0
      //   53: invokeinterface 53 5 0
      //   58: pop
      //   59: aload 5
      //   61: invokevirtual 56	android/os/Parcel:readException	()V
      //   64: aload 5
      //   66: invokevirtual 85	android/os/Parcel:readInt	()I
      //   69: istore_2
      //   70: iload_2
      //   71: ifeq +5 -> 76
      //   74: iconst_1
      //   75: istore_3
      //   76: aload 5
      //   78: invokevirtual 63	android/os/Parcel:recycle	()V
      //   81: aload 4
      //   83: invokevirtual 63	android/os/Parcel:recycle	()V
      //   86: sipush 23668
      //   89: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   92: iload_3
      //   93: ireturn
      //   94: aconst_null
      //   95: astore_1
      //   96: goto -60 -> 36
      //   99: astore_1
      //   100: aload 5
      //   102: invokevirtual 63	android/os/Parcel:recycle	()V
      //   105: aload 4
      //   107: invokevirtual 63	android/os/Parcel:recycle	()V
      //   110: sipush 23668
      //   113: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   116: aload_1
      //   117: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	118	0	this	a
      //   0	118	1	parami	i
      //   69	2	2	i	int
      //   1	92	3	bool	boolean
      //   11	95	4	localParcel1	Parcel
      //   16	85	5	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   18	25	99	finally
      //   29	36	99	finally
      //   36	70	99	finally
    }
    
    /* Error */
    public final boolean a(s params)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: sipush 23677
      //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   11: astore 4
      //   13: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   16: astore 5
      //   18: aload 4
      //   20: ldc 34
      //   22: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   25: aload_1
      //   26: ifnull +68 -> 94
      //   29: aload_1
      //   30: invokeinterface 93 1 0
      //   35: astore_1
      //   36: aload 4
      //   38: aload_1
      //   39: invokevirtual 47	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   42: aload_0
      //   43: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
      //   46: bipush 18
      //   48: aload 4
      //   50: aload 5
      //   52: iconst_0
      //   53: invokeinterface 53 5 0
      //   58: pop
      //   59: aload 5
      //   61: invokevirtual 56	android/os/Parcel:readException	()V
      //   64: aload 5
      //   66: invokevirtual 85	android/os/Parcel:readInt	()I
      //   69: istore_2
      //   70: iload_2
      //   71: ifeq +5 -> 76
      //   74: iconst_1
      //   75: istore_3
      //   76: aload 5
      //   78: invokevirtual 63	android/os/Parcel:recycle	()V
      //   81: aload 4
      //   83: invokevirtual 63	android/os/Parcel:recycle	()V
      //   86: sipush 23677
      //   89: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   92: iload_3
      //   93: ireturn
      //   94: aconst_null
      //   95: astore_1
      //   96: goto -60 -> 36
      //   99: astore_1
      //   100: aload 5
      //   102: invokevirtual 63	android/os/Parcel:recycle	()V
      //   105: aload 4
      //   107: invokevirtual 63	android/os/Parcel:recycle	()V
      //   110: sipush 23677
      //   113: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   116: aload_1
      //   117: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	118	0	this	a
      //   0	118	1	params	s
      //   69	2	2	i	int
      //   1	92	3	bool	boolean
      //   11	95	4	localParcel1	Parcel
      //   16	85	5	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   18	25	99	finally
      //   29	36	99	finally
      //   36	70	99	finally
    }
    
    /* Error */
    public final boolean a(String paramString, boolean paramBoolean, q paramq)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 5
      //   3: sipush 23672
      //   6: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   12: astore 6
      //   14: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   17: astore 7
      //   19: aload 6
      //   21: ldc 34
      //   23: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   26: aload 6
      //   28: aload_1
      //   29: invokevirtual 97	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   32: iload_2
      //   33: ifeq +85 -> 118
      //   36: iconst_1
      //   37: istore 4
      //   39: aload 6
      //   41: iload 4
      //   43: invokevirtual 78	android/os/Parcel:writeInt	(I)V
      //   46: aload_3
      //   47: ifnull +77 -> 124
      //   50: aload_3
      //   51: invokeinterface 100 1 0
      //   56: astore_1
      //   57: aload 6
      //   59: aload_1
      //   60: invokevirtual 47	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   63: aload_0
      //   64: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
      //   67: bipush 13
      //   69: aload 6
      //   71: aload 7
      //   73: iconst_0
      //   74: invokeinterface 53 5 0
      //   79: pop
      //   80: aload 7
      //   82: invokevirtual 56	android/os/Parcel:readException	()V
      //   85: aload 7
      //   87: invokevirtual 85	android/os/Parcel:readInt	()I
      //   90: istore 4
      //   92: iload 4
      //   94: ifeq +35 -> 129
      //   97: iload 5
      //   99: istore_2
      //   100: aload 7
      //   102: invokevirtual 63	android/os/Parcel:recycle	()V
      //   105: aload 6
      //   107: invokevirtual 63	android/os/Parcel:recycle	()V
      //   110: sipush 23672
      //   113: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   116: iload_2
      //   117: ireturn
      //   118: iconst_0
      //   119: istore 4
      //   121: goto -82 -> 39
      //   124: aconst_null
      //   125: astore_1
      //   126: goto -69 -> 57
      //   129: iconst_0
      //   130: istore_2
      //   131: goto -31 -> 100
      //   134: astore_1
      //   135: aload 7
      //   137: invokevirtual 63	android/os/Parcel:recycle	()V
      //   140: aload 6
      //   142: invokevirtual 63	android/os/Parcel:recycle	()V
      //   145: sipush 23672
      //   148: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   151: aload_1
      //   152: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	153	0	this	a
      //   0	153	1	paramString	String
      //   0	153	2	paramBoolean	boolean
      //   0	153	3	paramq	q
      //   37	83	4	i	int
      //   1	97	5	bool	boolean
      //   12	129	6	localParcel1	Parcel
      //   17	119	7	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   19	32	134	finally
      //   39	46	134	finally
      //   50	57	134	finally
      //   57	92	134	finally
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
      //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   11: astore 4
      //   13: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   16: astore 5
      //   18: aload 4
      //   20: ldc 34
      //   22: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   25: aload 4
      //   27: iload_1
      //   28: invokevirtual 78	android/os/Parcel:writeInt	(I)V
      //   31: aload_2
      //   32: ifnull +65 -> 97
      //   35: aload_2
      //   36: invokeinterface 105 1 0
      //   41: astore_2
      //   42: aload 4
      //   44: aload_2
      //   45: invokevirtual 47	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   48: aload_0
      //   49: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
      //   52: iconst_1
      //   53: aload 4
      //   55: aload 5
      //   57: iconst_0
      //   58: invokeinterface 53 5 0
      //   63: pop
      //   64: aload 5
      //   66: invokevirtual 56	android/os/Parcel:readException	()V
      //   69: aload 5
      //   71: invokevirtual 85	android/os/Parcel:readInt	()I
      //   74: istore_1
      //   75: iload_1
      //   76: ifeq +26 -> 102
      //   79: aload 5
      //   81: invokevirtual 63	android/os/Parcel:recycle	()V
      //   84: aload 4
      //   86: invokevirtual 63	android/os/Parcel:recycle	()V
      //   89: sipush 23660
      //   92: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   95: iload_3
      //   96: ireturn
      //   97: aconst_null
      //   98: astore_2
      //   99: goto -57 -> 42
      //   102: iconst_0
      //   103: istore_3
      //   104: goto -25 -> 79
      //   107: astore_2
      //   108: aload 5
      //   110: invokevirtual 63	android/os/Parcel:recycle	()V
      //   113: aload 4
      //   115: invokevirtual 63	android/os/Parcel:recycle	()V
      //   118: sipush 23660
      //   121: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   124: aload_2
      //   125: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	126	0	this	a
      //   0	126	1	paramInt	int
      //   0	126	2	paramj	j
      //   1	103	3	bool	boolean
      //   11	103	4	localParcel1	Parcel
      //   16	93	5	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   18	31	107	finally
      //   35	42	107	finally
      //   42	75	107	finally
    }
    
    /* Error */
    public final boolean b(long paramLong, int paramInt, k paramk)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 5
      //   3: sipush 23675
      //   6: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   12: astore 6
      //   14: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   17: astore 7
      //   19: aload 6
      //   21: ldc 34
      //   23: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   26: aload 6
      //   28: lload_1
      //   29: invokevirtual 75	android/os/Parcel:writeLong	(J)V
      //   32: aload 6
      //   34: iload_3
      //   35: invokevirtual 78	android/os/Parcel:writeInt	(I)V
      //   38: aload 4
      //   40: ifnull +73 -> 113
      //   43: aload 4
      //   45: invokeinterface 81 1 0
      //   50: astore 4
      //   52: aload 6
      //   54: aload 4
      //   56: invokevirtual 47	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   59: aload_0
      //   60: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
      //   63: bipush 16
      //   65: aload 6
      //   67: aload 7
      //   69: iconst_0
      //   70: invokeinterface 53 5 0
      //   75: pop
      //   76: aload 7
      //   78: invokevirtual 56	android/os/Parcel:readException	()V
      //   81: aload 7
      //   83: invokevirtual 85	android/os/Parcel:readInt	()I
      //   86: istore_3
      //   87: iload_3
      //   88: ifeq +6 -> 94
      //   91: iconst_1
      //   92: istore 5
      //   94: aload 7
      //   96: invokevirtual 63	android/os/Parcel:recycle	()V
      //   99: aload 6
      //   101: invokevirtual 63	android/os/Parcel:recycle	()V
      //   104: sipush 23675
      //   107: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   110: iload 5
      //   112: ireturn
      //   113: aconst_null
      //   114: astore 4
      //   116: goto -64 -> 52
      //   119: astore 4
      //   121: aload 7
      //   123: invokevirtual 63	android/os/Parcel:recycle	()V
      //   126: aload 6
      //   128: invokevirtual 63	android/os/Parcel:recycle	()V
      //   131: sipush 23675
      //   134: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   137: aload 4
      //   139: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	140	0	this	a
      //   0	140	1	paramLong	long
      //   0	140	3	paramInt	int
      //   0	140	4	paramk	k
      //   1	110	5	bool	boolean
      //   12	115	6	localParcel1	Parcel
      //   17	105	7	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   19	38	119	finally
      //   43	52	119	finally
      //   52	87	119	finally
    }
    
    /* Error */
    public final boolean b(long paramLong, byte[] paramArrayOfByte, t paramt)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 6
      //   3: sipush 23678
      //   6: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   12: astore 7
      //   14: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   17: astore 8
      //   19: aload 7
      //   21: ldc 34
      //   23: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   26: aload 7
      //   28: lload_1
      //   29: invokevirtual 75	android/os/Parcel:writeLong	(J)V
      //   32: aload 7
      //   34: aload_3
      //   35: invokevirtual 110	android/os/Parcel:writeByteArray	([B)V
      //   38: aload 4
      //   40: ifnull +73 -> 113
      //   43: aload 4
      //   45: invokeinterface 113 1 0
      //   50: astore_3
      //   51: aload 7
      //   53: aload_3
      //   54: invokevirtual 47	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   57: aload_0
      //   58: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
      //   61: bipush 19
      //   63: aload 7
      //   65: aload 8
      //   67: iconst_0
      //   68: invokeinterface 53 5 0
      //   73: pop
      //   74: aload 8
      //   76: invokevirtual 56	android/os/Parcel:readException	()V
      //   79: aload 8
      //   81: invokevirtual 85	android/os/Parcel:readInt	()I
      //   84: istore 5
      //   86: iload 5
      //   88: ifeq +6 -> 94
      //   91: iconst_1
      //   92: istore 6
      //   94: aload 8
      //   96: invokevirtual 63	android/os/Parcel:recycle	()V
      //   99: aload 7
      //   101: invokevirtual 63	android/os/Parcel:recycle	()V
      //   104: sipush 23678
      //   107: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   110: iload 6
      //   112: ireturn
      //   113: aconst_null
      //   114: astore_3
      //   115: goto -64 -> 51
      //   118: astore_3
      //   119: aload 8
      //   121: invokevirtual 63	android/os/Parcel:recycle	()V
      //   124: aload 7
      //   126: invokevirtual 63	android/os/Parcel:recycle	()V
      //   129: sipush 23678
      //   132: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   135: aload_3
      //   136: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	137	0	this	a
      //   0	137	1	paramLong	long
      //   0	137	3	paramArrayOfByte	byte[]
      //   0	137	4	paramt	t
      //   84	3	5	i	int
      //   1	110	6	bool	boolean
      //   12	113	7	localParcel1	Parcel
      //   17	103	8	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   19	38	118	finally
      //   43	51	118	finally
      //   51	86	118	finally
    }
    
    /* Error */
    public final boolean b(i parami)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: sipush 23669
      //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   11: astore 4
      //   13: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   16: astore 5
      //   18: aload 4
      //   20: ldc 34
      //   22: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   25: aload_1
      //   26: ifnull +68 -> 94
      //   29: aload_1
      //   30: invokeinterface 89 1 0
      //   35: astore_1
      //   36: aload 4
      //   38: aload_1
      //   39: invokevirtual 47	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   42: aload_0
      //   43: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
      //   46: bipush 10
      //   48: aload 4
      //   50: aload 5
      //   52: iconst_0
      //   53: invokeinterface 53 5 0
      //   58: pop
      //   59: aload 5
      //   61: invokevirtual 56	android/os/Parcel:readException	()V
      //   64: aload 5
      //   66: invokevirtual 85	android/os/Parcel:readInt	()I
      //   69: istore_2
      //   70: iload_2
      //   71: ifeq +5 -> 76
      //   74: iconst_1
      //   75: istore_3
      //   76: aload 5
      //   78: invokevirtual 63	android/os/Parcel:recycle	()V
      //   81: aload 4
      //   83: invokevirtual 63	android/os/Parcel:recycle	()V
      //   86: sipush 23669
      //   89: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   92: iload_3
      //   93: ireturn
      //   94: aconst_null
      //   95: astore_1
      //   96: goto -60 -> 36
      //   99: astore_1
      //   100: aload 5
      //   102: invokevirtual 63	android/os/Parcel:recycle	()V
      //   105: aload 4
      //   107: invokevirtual 63	android/os/Parcel:recycle	()V
      //   110: sipush 23669
      //   113: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   116: aload_1
      //   117: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	118	0	this	a
      //   0	118	1	parami	i
      //   69	2	2	i	int
      //   1	92	3	bool	boolean
      //   11	95	4	localParcel1	Parcel
      //   16	85	5	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   18	25	99	finally
      //   29	36	99	finally
      //   36	70	99	finally
    }
    
    public final long[] bZV()
    {
      AppMethodBeat.i(23662);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        this.mRemote.transact(3, localParcel1, localParcel2, 0);
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
    
    /* Error */
    public final boolean c(int paramInt, j paramj)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: sipush 23661
      //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   11: astore 4
      //   13: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   16: astore 5
      //   18: aload 4
      //   20: ldc 34
      //   22: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   25: aload 4
      //   27: iload_1
      //   28: invokevirtual 78	android/os/Parcel:writeInt	(I)V
      //   31: aload_2
      //   32: ifnull +67 -> 99
      //   35: aload_2
      //   36: invokeinterface 105 1 0
      //   41: astore_2
      //   42: aload 4
      //   44: aload_2
      //   45: invokevirtual 47	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   48: aload_0
      //   49: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
      //   52: iconst_2
      //   53: aload 4
      //   55: aload 5
      //   57: iconst_0
      //   58: invokeinterface 53 5 0
      //   63: pop
      //   64: aload 5
      //   66: invokevirtual 56	android/os/Parcel:readException	()V
      //   69: aload 5
      //   71: invokevirtual 85	android/os/Parcel:readInt	()I
      //   74: istore_1
      //   75: iload_1
      //   76: ifeq +5 -> 81
      //   79: iconst_1
      //   80: istore_3
      //   81: aload 5
      //   83: invokevirtual 63	android/os/Parcel:recycle	()V
      //   86: aload 4
      //   88: invokevirtual 63	android/os/Parcel:recycle	()V
      //   91: sipush 23661
      //   94: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   97: iload_3
      //   98: ireturn
      //   99: aconst_null
      //   100: astore_2
      //   101: goto -59 -> 42
      //   104: astore_2
      //   105: aload 5
      //   107: invokevirtual 63	android/os/Parcel:recycle	()V
      //   110: aload 4
      //   112: invokevirtual 63	android/os/Parcel:recycle	()V
      //   115: sipush 23661
      //   118: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   121: aload_2
      //   122: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	123	0	this	a
      //   0	123	1	paramInt	int
      //   0	123	2	paramj	j
      //   1	97	3	bool	boolean
      //   11	100	4	localParcel1	Parcel
      //   16	90	5	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   18	31	104	finally
      //   35	42	104	finally
      //   42	75	104	finally
    }
    
    /* Error */
    public final boolean d(int paramInt, j paramj)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: sipush 23673
      //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   11: astore 4
      //   13: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   16: astore 5
      //   18: aload 4
      //   20: ldc 34
      //   22: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   25: aload 4
      //   27: iload_1
      //   28: invokevirtual 78	android/os/Parcel:writeInt	(I)V
      //   31: aload_2
      //   32: ifnull +68 -> 100
      //   35: aload_2
      //   36: invokeinterface 105 1 0
      //   41: astore_2
      //   42: aload 4
      //   44: aload_2
      //   45: invokevirtual 47	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   48: aload_0
      //   49: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
      //   52: bipush 14
      //   54: aload 4
      //   56: aload 5
      //   58: iconst_0
      //   59: invokeinterface 53 5 0
      //   64: pop
      //   65: aload 5
      //   67: invokevirtual 56	android/os/Parcel:readException	()V
      //   70: aload 5
      //   72: invokevirtual 85	android/os/Parcel:readInt	()I
      //   75: istore_1
      //   76: iload_1
      //   77: ifeq +5 -> 82
      //   80: iconst_1
      //   81: istore_3
      //   82: aload 5
      //   84: invokevirtual 63	android/os/Parcel:recycle	()V
      //   87: aload 4
      //   89: invokevirtual 63	android/os/Parcel:recycle	()V
      //   92: sipush 23673
      //   95: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   98: iload_3
      //   99: ireturn
      //   100: aconst_null
      //   101: astore_2
      //   102: goto -60 -> 42
      //   105: astore_2
      //   106: aload 5
      //   108: invokevirtual 63	android/os/Parcel:recycle	()V
      //   111: aload 4
      //   113: invokevirtual 63	android/os/Parcel:recycle	()V
      //   116: sipush 23673
      //   119: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   122: aload_2
      //   123: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	124	0	this	a
      //   0	124	1	paramInt	int
      //   0	124	2	paramj	j
      //   1	98	3	bool	boolean
      //   11	101	4	localParcel1	Parcel
      //   16	91	5	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   18	31	105	finally
      //   35	42	105	finally
      //   42	76	105	finally
    }
    
    /* Error */
    public final boolean e(int paramInt, j paramj)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: sipush 23674
      //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   11: astore 4
      //   13: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   16: astore 5
      //   18: aload 4
      //   20: ldc 34
      //   22: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   25: aload 4
      //   27: iload_1
      //   28: invokevirtual 78	android/os/Parcel:writeInt	(I)V
      //   31: aload_2
      //   32: ifnull +68 -> 100
      //   35: aload_2
      //   36: invokeinterface 105 1 0
      //   41: astore_2
      //   42: aload 4
      //   44: aload_2
      //   45: invokevirtual 47	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   48: aload_0
      //   49: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
      //   52: bipush 15
      //   54: aload 4
      //   56: aload 5
      //   58: iconst_0
      //   59: invokeinterface 53 5 0
      //   64: pop
      //   65: aload 5
      //   67: invokevirtual 56	android/os/Parcel:readException	()V
      //   70: aload 5
      //   72: invokevirtual 85	android/os/Parcel:readInt	()I
      //   75: istore_1
      //   76: iload_1
      //   77: ifeq +5 -> 82
      //   80: iconst_1
      //   81: istore_3
      //   82: aload 5
      //   84: invokevirtual 63	android/os/Parcel:recycle	()V
      //   87: aload 4
      //   89: invokevirtual 63	android/os/Parcel:recycle	()V
      //   92: sipush 23674
      //   95: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   98: iload_3
      //   99: ireturn
      //   100: aconst_null
      //   101: astore_2
      //   102: goto -60 -> 42
      //   105: astore_2
      //   106: aload 5
      //   108: invokevirtual 63	android/os/Parcel:recycle	()V
      //   111: aload 4
      //   113: invokevirtual 63	android/os/Parcel:recycle	()V
      //   116: sipush 23674
      //   119: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   122: aload_2
      //   123: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	124	0	this	a
      //   0	124	1	paramInt	int
      //   0	124	2	paramj	j
      //   1	98	3	bool	boolean
      //   11	101	4	localParcel1	Parcel
      //   16	91	5	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   18	31	105	finally
      //   35	42	105	finally
      //   42	76	105	finally
    }
    
    public final boolean oZ(long paramLong)
    {
      boolean bool = false;
      AppMethodBeat.i(23664);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        localParcel1.writeLong(paramLong);
        this.mRemote.transact(5, localParcel1, localParcel2, 0);
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
    
    public final boolean pa(long paramLong)
    {
      boolean bool = false;
      AppMethodBeat.i(23665);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        localParcel1.writeLong(paramLong);
        this.mRemote.transact(6, localParcel1, localParcel2, 0);
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
    
    public final boolean pb(long paramLong)
    {
      boolean bool = false;
      AppMethodBeat.i(23667);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        localParcel1.writeLong(paramLong);
        this.mRemote.transact(8, localParcel1, localParcel2, 0);
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
    
    public final boolean pc(long paramLong)
    {
      boolean bool = false;
      AppMethodBeat.i(23676);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        localParcel1.writeLong(paramLong);
        this.mRemote.transact(17, localParcel1, localParcel2, 0);
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
        this.mRemote.transact(12, localParcel1, localParcel2, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.h.a
 * JD-Core Version:    0.7.0.1
 */