package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.network.a.b.a.a;
import com.tencent.mm.protocal.ab;
import com.tencent.mm.protocal.ab.a.a;
import java.util.ArrayList;
import java.util.List;

public abstract class f$a
  extends Binder
  implements f
{
  public f$a()
  {
    attachInterface(this, "com.tencent.mm.network.IDispatcher_AIDL");
  }
  
  public static f m(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.network.IDispatcher_AIDL");
    if ((localIInterface != null) && ((localIInterface instanceof f))) {
      return (f)localIInterface;
    }
    return new a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    r localr = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject1 = null;
    boolean bool2 = false;
    boolean bool3 = false;
    int i = 0;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool8 = false;
    boolean bool9 = false;
    boolean bool10 = false;
    boolean bool11 = false;
    boolean bool12 = false;
    boolean bool1 = false;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mm.network.IDispatcher_AIDL");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      localr = r.a.p(paramParcel1.readStrongBinder());
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = (Parcel)localObject1;
      }
      for (;;)
      {
        paramInt1 = a(localr, paramParcel1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
        localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.network.IOnGYNetEnd_AIDL");
        if ((localObject1 != null) && ((localObject1 instanceof l))) {
          paramParcel1 = (l)localObject1;
        } else {
          paramParcel1 = new l.a.a(paramParcel1);
        }
      }
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      cancel(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      localObject1 = aLx();
      paramParcel2.writeNoException();
      paramParcel1 = localr;
      if (localObject1 != null) {
        paramParcel1 = ((d)localObject1).asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      reset();
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = localObject2;
      }
      for (;;)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
        if ((localObject1 != null) && ((localObject1 instanceof ab))) {
          paramParcel1 = (ab)localObject1;
        } else {
          paramParcel1 = new ab.a.a(paramParcel1);
        }
      }
    case 6: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      a(bool1, paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createIntArray(), paramParcel1.createIntArray(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bool1 = bool2;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      paramParcel1 = getIPsString(bool1);
      paramParcel2.writeNoException();
      paramParcel2.writeStringArray(paramParcel1);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramParcel1 = getNetworkServerIp();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bool1 = bool3;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      eD(bool1);
      paramParcel2.writeNoException();
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      f(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      setNewDnsDebugHost(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      aLy();
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bool1 = aBL();
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = localObject3;
      }
      for (;;)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
        if ((localObject1 != null) && ((localObject1 instanceof b))) {
          paramParcel1 = (b)localObject1;
        } else {
          paramParcel1 = new b.a.a(paramParcel1);
        }
      }
    case 15: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      As(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      localObject1 = aLz();
      paramParcel2.writeNoException();
      paramParcel1 = localObject4;
      if (localObject1 != null) {
        paramParcel1 = ((i)localObject1).asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramParcel1 = paramParcel1.readString();
      localObject1 = new ArrayList();
      paramInt1 = getHostByName(paramParcel1, (List)localObject1);
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      paramParcel2.writeStringList((List)localObject1);
      return true;
    case 18: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bool1 = bool4;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      paramParcel1 = new ArrayList();
      paramInt1 = a(bool1, paramParcel1);
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      paramParcel2.writeStringList(paramParcel1);
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      localObject1 = paramParcel1.readString();
      bool1 = bool5;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      paramParcel1 = new ArrayList();
      paramInt1 = a((String)localObject1, bool1, paramParcel1);
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      paramParcel2.writeStringList(paramParcel1);
      return true;
    case 20: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      reportFailIp(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 21: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      setHostInfo(paramParcel1.createStringArray(), paramParcel1.createStringArray(), paramParcel1.createIntArray());
      paramParcel2.writeNoException();
      return true;
    case 22: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      addHostInfo(paramParcel1.createStringArray(), paramParcel1.createStringArray(), paramParcel1.createIntArray());
      paramParcel2.writeNoException();
      return true;
    case 23: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramInt1 = paramParcel1.readInt();
      localObject1 = paramParcel1.readString();
      paramInt2 = paramParcel1.readInt();
      bool1 = bool6;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      a(paramInt1, (String)localObject1, paramInt2, bool1);
      paramParcel2.writeNoException();
      return true;
    case 24: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      d(paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 25: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      aCb();
      paramParcel2.writeNoException();
      return true;
    case 26: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramParcel1 = getIspId();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 27: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramInt1 = i(paramParcel1.readInt(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 28: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      setSignallingStrategy(paramParcel1.readLong(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 29: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      keepSignalling();
      paramParcel2.writeNoException();
      return true;
    case 30: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      stopSignalling();
      paramParcel2.writeNoException();
      return true;
    case 31: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = localObject5;
      }
      for (;;)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.network.IOnReportKV_AIDL");
        if ((localObject1 != null) && ((localObject1 instanceof o))) {
          paramParcel1 = (o)localObject1;
        } else {
          paramParcel1 = new o.a.a(paramParcel1);
        }
      }
    case 32: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = localObject6;
      }
      for (;;)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.network.IWorkerCallback_AIDL");
        if ((localObject1 != null) && ((localObject1 instanceof s))) {
          paramParcel1 = (s)localObject1;
        } else {
          paramParcel1 = new s.a.a(paramParcel1);
        }
      }
    case 33: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = localObject7;
      }
      for (;;)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.network.IIpxxCallback_AIDL");
        if ((localObject1 != null) && ((localObject1 instanceof g))) {
          paramParcel1 = (g)localObject1;
        } else {
          paramParcel1 = new g.a.a(paramParcel1);
        }
      }
    case 34: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      At(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 35: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bool1 = bool7;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      eE(bool1);
      paramParcel2.writeNoException();
      return true;
    case 36: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bool1 = bool8;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      eF(bool1);
      paramParcel2.writeNoException();
      return true;
    case 37: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bool1 = bool9;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      eG(bool1);
      paramParcel2.writeNoException();
      return true;
    case 38: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      aCc();
      paramParcel2.writeNoException();
      return true;
    case 39: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = localObject8;
      }
      for (;;)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
        if ((localObject1 != null) && ((localObject1 instanceof h))) {
          paramParcel1 = (h)localObject1;
        } else {
          paramParcel1 = new h.a.a(paramParcel1);
        }
      }
    case 40: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      Au(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 41: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bool1 = bool10;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      reportV6Status(bool1);
      paramParcel2.writeNoException();
      return true;
    case 42: 
      paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
      bool1 = bool11;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      forceUseV6(bool1);
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
    bool1 = bool12;
    if (paramParcel1.readInt() != 0) {
      bool1 = true;
    }
    switchProcessActiveState(bool1);
    paramParcel2.writeNoException();
    return true;
  }
  
  static final class a
    implements f
  {
    private IBinder mRemote;
    
    a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    public final void As(String paramString)
    {
      AppMethodBeat.i(132712);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString);
        this.mRemote.transact(15, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132712);
      }
    }
    
    public final void At(String paramString)
    {
      AppMethodBeat.i(132731);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString);
        this.mRemote.transact(34, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132731);
      }
    }
    
    public final void Au(String paramString)
    {
      AppMethodBeat.i(132737);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString);
        this.mRemote.transact(40, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132737);
      }
    }
    
    /* Error */
    public final int a(r paramr, l paraml)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: ldc 63
      //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   11: astore 5
      //   13: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   16: astore 6
      //   18: aload 5
      //   20: ldc 36
      //   22: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   25: aload_1
      //   26: ifnull +80 -> 106
      //   29: aload_1
      //   30: invokeinterface 69 1 0
      //   35: astore_1
      //   36: aload 5
      //   38: aload_1
      //   39: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   42: aload 4
      //   44: astore_1
      //   45: aload_2
      //   46: ifnull +10 -> 56
      //   49: aload_2
      //   50: invokeinterface 75 1 0
      //   55: astore_1
      //   56: aload 5
      //   58: aload_1
      //   59: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   62: aload_0
      //   63: getfield 18	com/tencent/mm/network/f$a$a:mRemote	Landroid/os/IBinder;
      //   66: iconst_1
      //   67: aload 5
      //   69: aload 6
      //   71: iconst_0
      //   72: invokeinterface 48 5 0
      //   77: pop
      //   78: aload 6
      //   80: invokevirtual 51	android/os/Parcel:readException	()V
      //   83: aload 6
      //   85: invokevirtual 79	android/os/Parcel:readInt	()I
      //   88: istore_3
      //   89: aload 6
      //   91: invokevirtual 54	android/os/Parcel:recycle	()V
      //   94: aload 5
      //   96: invokevirtual 54	android/os/Parcel:recycle	()V
      //   99: ldc 63
      //   101: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   104: iload_3
      //   105: ireturn
      //   106: aconst_null
      //   107: astore_1
      //   108: goto -72 -> 36
      //   111: astore_1
      //   112: aload 6
      //   114: invokevirtual 54	android/os/Parcel:recycle	()V
      //   117: aload 5
      //   119: invokevirtual 54	android/os/Parcel:recycle	()V
      //   122: ldc 63
      //   124: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   127: aload_1
      //   128: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	129	0	this	a
      //   0	129	1	paramr	r
      //   0	129	2	paraml	l
      //   88	17	3	i	int
      //   1	42	4	localObject	Object
      //   11	107	5	localParcel1	Parcel
      //   16	97	6	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   18	25	111	finally
      //   29	36	111	finally
      //   36	42	111	finally
      //   49	56	111	finally
      //   56	89	111	finally
    }
    
    public final int a(String paramString, boolean paramBoolean, List<String> paramList)
    {
      int i = 0;
      AppMethodBeat.i(132716);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString);
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        this.mRemote.transact(19, localParcel1, localParcel2, 0);
        localParcel2.readException();
        i = localParcel2.readInt();
        localParcel2.readStringList(paramList);
        return i;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132716);
      }
    }
    
    public final int a(boolean paramBoolean, List<String> paramList)
    {
      int i = 0;
      AppMethodBeat.i(132715);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        this.mRemote.transact(18, localParcel1, localParcel2, 0);
        localParcel2.readException();
        i = localParcel2.readInt();
        localParcel2.readStringList(paramList);
        return i;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132715);
      }
    }
    
    public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(132720);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeInt(paramInt1);
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt2);
        paramInt1 = i;
        if (paramBoolean) {
          paramInt1 = 1;
        }
        localParcel1.writeInt(paramInt1);
        this.mRemote.transact(23, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132720);
      }
    }
    
    /* Error */
    public final void a(b paramb)
    {
      // Byte code:
      //   0: ldc 97
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   8: astore_2
      //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   12: astore_3
      //   13: aload_2
      //   14: ldc 36
      //   16: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   19: aload_1
      //   20: ifnull +48 -> 68
      //   23: aload_1
      //   24: invokeinterface 100 1 0
      //   29: astore_1
      //   30: aload_2
      //   31: aload_1
      //   32: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   35: aload_0
      //   36: getfield 18	com/tencent/mm/network/f$a$a:mRemote	Landroid/os/IBinder;
      //   39: bipush 14
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
      //   62: ldc 97
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
      //   82: ldc 97
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
    
    /* Error */
    public final void a(g paramg)
    {
      // Byte code:
      //   0: ldc 102
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   8: astore_2
      //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   12: astore_3
      //   13: aload_2
      //   14: ldc 36
      //   16: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   19: aload_1
      //   20: ifnull +48 -> 68
      //   23: aload_1
      //   24: invokeinterface 105 1 0
      //   29: astore_1
      //   30: aload_2
      //   31: aload_1
      //   32: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   35: aload_0
      //   36: getfield 18	com/tencent/mm/network/f$a$a:mRemote	Landroid/os/IBinder;
      //   39: bipush 33
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
      //   62: ldc 102
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
      //   82: ldc 102
      //   84: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   87: aload_1
      //   88: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	89	0	this	a
      //   0	89	1	paramg	g
      //   8	71	2	localParcel1	Parcel
      //   12	63	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   13	19	73	finally
      //   23	30	73	finally
      //   30	54	73	finally
    }
    
    /* Error */
    public final void a(h paramh)
    {
      // Byte code:
      //   0: ldc 107
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   8: astore_2
      //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   12: astore_3
      //   13: aload_2
      //   14: ldc 36
      //   16: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   19: aload_1
      //   20: ifnull +48 -> 68
      //   23: aload_1
      //   24: invokeinterface 110 1 0
      //   29: astore_1
      //   30: aload_2
      //   31: aload_1
      //   32: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   35: aload_0
      //   36: getfield 18	com/tencent/mm/network/f$a$a:mRemote	Landroid/os/IBinder;
      //   39: bipush 39
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
      //   62: ldc 107
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
      //   82: ldc 107
      //   84: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   87: aload_1
      //   88: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	89	0	this	a
      //   0	89	1	paramh	h
      //   8	71	2	localParcel1	Parcel
      //   12	63	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   13	19	73	finally
      //   23	30	73	finally
      //   30	54	73	finally
    }
    
    /* Error */
    public final void a(o paramo)
    {
      // Byte code:
      //   0: ldc 112
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   8: astore_2
      //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   12: astore_3
      //   13: aload_2
      //   14: ldc 36
      //   16: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   19: aload_1
      //   20: ifnull +48 -> 68
      //   23: aload_1
      //   24: invokeinterface 115 1 0
      //   29: astore_1
      //   30: aload_2
      //   31: aload_1
      //   32: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   35: aload_0
      //   36: getfield 18	com/tencent/mm/network/f$a$a:mRemote	Landroid/os/IBinder;
      //   39: bipush 31
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
      //   62: ldc 112
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
      //   82: ldc 112
      //   84: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   87: aload_1
      //   88: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	89	0	this	a
      //   0	89	1	paramo	o
      //   8	71	2	localParcel1	Parcel
      //   12	63	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   13	19	73	finally
      //   23	30	73	finally
      //   30	54	73	finally
    }
    
    /* Error */
    public final void a(s params)
    {
      // Byte code:
      //   0: ldc 117
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   8: astore_2
      //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   12: astore_3
      //   13: aload_2
      //   14: ldc 36
      //   16: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   19: aload_1
      //   20: ifnull +48 -> 68
      //   23: aload_1
      //   24: invokeinterface 120 1 0
      //   29: astore_1
      //   30: aload_2
      //   31: aload_1
      //   32: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   35: aload_0
      //   36: getfield 18	com/tencent/mm/network/f$a$a:mRemote	Landroid/os/IBinder;
      //   39: bipush 32
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
      //   62: ldc 117
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
      //   82: ldc 117
      //   84: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   87: aload_1
      //   88: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	89	0	this	a
      //   0	89	1	params	s
      //   8	71	2	localParcel1	Parcel
      //   12	63	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   13	19	73	finally
      //   23	30	73	finally
      //   30	54	73	finally
    }
    
    /* Error */
    public final void a(ab paramab)
    {
      // Byte code:
      //   0: ldc 122
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   8: astore_2
      //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   12: astore_3
      //   13: aload_2
      //   14: ldc 36
      //   16: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   19: aload_1
      //   20: ifnull +47 -> 67
      //   23: aload_1
      //   24: invokeinterface 125 1 0
      //   29: astore_1
      //   30: aload_2
      //   31: aload_1
      //   32: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   35: aload_0
      //   36: getfield 18	com/tencent/mm/network/f$a$a:mRemote	Landroid/os/IBinder;
      //   39: iconst_5
      //   40: aload_2
      //   41: aload_3
      //   42: iconst_0
      //   43: invokeinterface 48 5 0
      //   48: pop
      //   49: aload_3
      //   50: invokevirtual 51	android/os/Parcel:readException	()V
      //   53: aload_3
      //   54: invokevirtual 54	android/os/Parcel:recycle	()V
      //   57: aload_2
      //   58: invokevirtual 54	android/os/Parcel:recycle	()V
      //   61: ldc 122
      //   63: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   66: return
      //   67: aconst_null
      //   68: astore_1
      //   69: goto -39 -> 30
      //   72: astore_1
      //   73: aload_3
      //   74: invokevirtual 54	android/os/Parcel:recycle	()V
      //   77: aload_2
      //   78: invokevirtual 54	android/os/Parcel:recycle	()V
      //   81: ldc 122
      //   83: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   86: aload_1
      //   87: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	88	0	this	a
      //   0	88	1	paramab	ab
      //   8	70	2	localParcel1	Parcel
      //   12	62	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   13	19	72	finally
      //   23	30	72	finally
      //   30	53	72	finally
    }
    
    public final void a(boolean paramBoolean, String paramString1, String paramString2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, String paramString3, String paramString4)
    {
      int i = 0;
      AppMethodBeat.i(132703);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeIntArray(paramArrayOfInt1);
        localParcel1.writeIntArray(paramArrayOfInt2);
        localParcel1.writeInt(paramInt1);
        localParcel1.writeInt(paramInt2);
        localParcel1.writeString(paramString3);
        localParcel1.writeString(paramString4);
        this.mRemote.transact(6, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132703);
      }
    }
    
    public final boolean aBL()
    {
      boolean bool = false;
      AppMethodBeat.i(132710);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        this.mRemote.transact(13, localParcel1, localParcel2, 0);
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
        AppMethodBeat.o(132710);
      }
    }
    
    public final void aCb()
    {
      AppMethodBeat.i(132722);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        this.mRemote.transact(25, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132722);
      }
    }
    
    public final void aCc()
    {
      AppMethodBeat.i(132735);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        this.mRemote.transact(38, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132735);
      }
    }
    
    public final d aLx()
    {
      AppMethodBeat.i(132700);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        this.mRemote.transact(3, localParcel1, localParcel2, 0);
        localParcel2.readException();
        d locald = d.a.l(localParcel2.readStrongBinder());
        return locald;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132700);
      }
    }
    
    public final void aLy()
    {
      AppMethodBeat.i(132709);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        this.mRemote.transact(12, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132709);
      }
    }
    
    public final i aLz()
    {
      AppMethodBeat.i(132713);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        this.mRemote.transact(16, localParcel1, localParcel2, 0);
        localParcel2.readException();
        i locali = i.a.n(localParcel2.readStrongBinder());
        return locali;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132713);
      }
    }
    
    public final void addHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(132719);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeStringArray(paramArrayOfString1);
        localParcel1.writeStringArray(paramArrayOfString2);
        localParcel1.writeIntArray(paramArrayOfInt);
        this.mRemote.transact(22, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132719);
      }
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
    
    public final void cancel(int paramInt)
    {
      AppMethodBeat.i(132699);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeInt(paramInt);
        this.mRemote.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132699);
      }
    }
    
    public final void d(String paramString1, long paramLong, String paramString2)
    {
      AppMethodBeat.i(132721);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString1);
        localParcel1.writeLong(paramLong);
        localParcel1.writeString(paramString2);
        this.mRemote.transact(24, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132721);
      }
    }
    
    public final void eD(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(132706);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        this.mRemote.transact(9, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132706);
      }
    }
    
    public final void eE(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(132732);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        this.mRemote.transact(35, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132732);
      }
    }
    
    public final void eF(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(132733);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        this.mRemote.transact(36, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132733);
      }
    }
    
    public final void eG(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(132734);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        this.mRemote.transact(37, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132734);
      }
    }
    
    public final void f(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(132707);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeString(paramString3);
        localParcel1.writeString(paramString4);
        this.mRemote.transact(10, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132707);
      }
    }
    
    public final void forceUseV6(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(176846);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        this.mRemote.transact(42, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(176846);
      }
    }
    
    public final int getHostByName(String paramString, List<String> paramList)
    {
      AppMethodBeat.i(132714);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString);
        this.mRemote.transact(17, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        localParcel2.readStringList(paramList);
        return i;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132714);
      }
    }
    
    public final String[] getIPsString(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(132704);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        this.mRemote.transact(7, localParcel1, localParcel2, 0);
        localParcel2.readException();
        String[] arrayOfString = localParcel2.createStringArray();
        return arrayOfString;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132704);
      }
    }
    
    public final String getIspId()
    {
      AppMethodBeat.i(132723);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        this.mRemote.transact(26, localParcel1, localParcel2, 0);
        localParcel2.readException();
        String str = localParcel2.readString();
        return str;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132723);
      }
    }
    
    public final String getNetworkServerIp()
    {
      AppMethodBeat.i(132705);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        this.mRemote.transact(8, localParcel1, localParcel2, 0);
        localParcel2.readException();
        String str = localParcel2.readString();
        return str;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132705);
      }
    }
    
    public final int i(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(132724);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeInt(paramInt);
        localParcel1.writeByteArray(paramArrayOfByte);
        this.mRemote.transact(27, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramInt = localParcel2.readInt();
        return paramInt;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132724);
      }
    }
    
    public final void keepSignalling()
    {
      AppMethodBeat.i(132726);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        this.mRemote.transact(29, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132726);
      }
    }
    
    public final void reportFailIp(String paramString)
    {
      AppMethodBeat.i(132717);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString);
        this.mRemote.transact(20, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132717);
      }
    }
    
    public final void reportV6Status(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(176845);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        this.mRemote.transact(41, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(176845);
      }
    }
    
    public final void reset()
    {
      AppMethodBeat.i(132701);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        this.mRemote.transact(4, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132701);
      }
    }
    
    public final void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(132718);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeStringArray(paramArrayOfString1);
        localParcel1.writeStringArray(paramArrayOfString2);
        localParcel1.writeIntArray(paramArrayOfInt);
        this.mRemote.transact(21, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132718);
      }
    }
    
    public final void setNewDnsDebugHost(String paramString1, String paramString2)
    {
      AppMethodBeat.i(132708);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        this.mRemote.transact(11, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132708);
      }
    }
    
    public final void setSignallingStrategy(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(132725);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        localParcel1.writeLong(paramLong1);
        localParcel1.writeLong(paramLong2);
        this.mRemote.transact(28, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132725);
      }
    }
    
    public final void stopSignalling()
    {
      AppMethodBeat.i(132727);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        this.mRemote.transact(30, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(132727);
      }
    }
    
    public final void switchProcessActiveState(boolean paramBoolean)
    {
      int i = 0;
      AppMethodBeat.i(206889);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        this.mRemote.transact(43, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(206889);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.f.a
 * JD-Core Version:    0.7.0.1
 */