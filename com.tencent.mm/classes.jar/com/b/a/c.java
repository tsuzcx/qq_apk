package com.b.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface c
  extends IInterface
{
  public abstract int a(b paramb, int[] paramArrayOfInt, byte[] paramArrayOfByte);
  
  public abstract int a(b paramb, int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt);
  
  public abstract void a(b paramb);
  
  public abstract boolean a(b paramb, int paramInt);
  
  public abstract boolean a(b paramb, int paramInt, boolean paramBoolean);
  
  public abstract String b(b paramb, int paramInt);
  
  public abstract void b(b paramb);
  
  public abstract int[] c(b paramb);
  
  public abstract int[] c(b paramb, int paramInt);
  
  public abstract boolean cj(String paramString);
  
  public abstract int d(b paramb, int paramInt);
  
  public abstract long d(b paramb);
  
  public abstract byte[] e(b paramb);
  
  public abstract boolean gc(int paramInt);
  
  public abstract int gd(int paramInt);
  
  public abstract int[] zQ();
  
  public static abstract class a
    extends Binder
    implements c
  {
    public static c i(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.securitymgr.IAuthenticationService");
      if ((localIInterface != null) && ((localIInterface instanceof c))) {
        return (c)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      int k = 0;
      int m = 0;
      int i = 0;
      int j = 0;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.huawei.securitymgr.IAuthenticationService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
        bool = a(b.a.h(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
        paramInt1 = a(b.a.h(paramParcel1.readStrongBinder()), paramParcel1.createIntArray(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
        a(b.a.h(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
        b(b.a.h(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
        paramParcel1 = c(b.a.h(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeIntArray(paramParcel1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
        paramParcel1 = zQ();
        paramParcel2.writeNoException();
        paramParcel2.writeIntArray(paramParcel1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
        bool = gc(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
        paramInt1 = gd(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
        bool = cj(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
        paramParcel1 = b(b.a.h(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
        paramParcel1 = c(b.a.h(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeIntArray(paramParcel1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
        paramInt1 = d(b.a.h(paramParcel1.readStrongBinder()), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
        b localb = b.a.h(paramParcel1.readStrongBinder());
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {}
        for (bool = true;; bool = false)
        {
          bool = a(localb, paramInt1, bool);
          paramParcel2.writeNoException();
          paramInt1 = i;
          if (bool) {
            paramInt1 = 1;
          }
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 14: 
        paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
        long l = d(b.a.h(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
        paramInt1 = a(b.a.h(paramParcel1.readStrongBinder()), paramParcel1.createIntArray(), paramParcel1.createByteArray(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
      paramParcel1 = e(b.a.h(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    }
    
    static final class a
      implements c
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public final int a(b paramb, int[] paramArrayOfInt, byte[] paramArrayOfByte)
      {
        // Byte code:
        //   0: ldc 21
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 6
        //   15: aload 5
        //   17: ldc 35
        //   19: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload_1
        //   23: ifnull +74 -> 97
        //   26: aload_1
        //   27: invokeinterface 45 1 0
        //   32: astore_1
        //   33: aload 5
        //   35: aload_1
        //   36: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 5
        //   41: aload_2
        //   42: invokevirtual 52	android/os/Parcel:writeIntArray	([I)V
        //   45: aload 5
        //   47: aload_3
        //   48: invokevirtual 56	android/os/Parcel:writeByteArray	([B)V
        //   51: aload_0
        //   52: getfield 18	com/b/a/c$a$a:mRemote	Landroid/os/IBinder;
        //   55: iconst_2
        //   56: aload 5
        //   58: aload 6
        //   60: iconst_0
        //   61: invokeinterface 62 5 0
        //   66: pop
        //   67: aload 6
        //   69: invokevirtual 65	android/os/Parcel:readException	()V
        //   72: aload 6
        //   74: invokevirtual 69	android/os/Parcel:readInt	()I
        //   77: istore 4
        //   79: aload 6
        //   81: invokevirtual 72	android/os/Parcel:recycle	()V
        //   84: aload 5
        //   86: invokevirtual 72	android/os/Parcel:recycle	()V
        //   89: ldc 21
        //   91: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   94: iload 4
        //   96: ireturn
        //   97: aconst_null
        //   98: astore_1
        //   99: goto -66 -> 33
        //   102: astore_1
        //   103: aload 6
        //   105: invokevirtual 72	android/os/Parcel:recycle	()V
        //   108: aload 5
        //   110: invokevirtual 72	android/os/Parcel:recycle	()V
        //   113: ldc 21
        //   115: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   118: aload_1
        //   119: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	120	0	this	a
        //   0	120	1	paramb	b
        //   0	120	2	paramArrayOfInt	int[]
        //   0	120	3	paramArrayOfByte	byte[]
        //   77	18	4	i	int
        //   8	101	5	localParcel1	Parcel
        //   13	91	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	22	102	finally
        //   26	33	102	finally
        //   33	79	102	finally
      }
      
      /* Error */
      public final int a(b paramb, int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt)
      {
        // Byte code:
        //   0: ldc 77
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 6
        //   15: aload 5
        //   17: ldc 35
        //   19: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload_1
        //   23: ifnull +82 -> 105
        //   26: aload_1
        //   27: invokeinterface 45 1 0
        //   32: astore_1
        //   33: aload 5
        //   35: aload_1
        //   36: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload 5
        //   41: aload_2
        //   42: invokevirtual 52	android/os/Parcel:writeIntArray	([I)V
        //   45: aload 5
        //   47: aload_3
        //   48: invokevirtual 56	android/os/Parcel:writeByteArray	([B)V
        //   51: aload 5
        //   53: iload 4
        //   55: invokevirtual 80	android/os/Parcel:writeInt	(I)V
        //   58: aload_0
        //   59: getfield 18	com/b/a/c$a$a:mRemote	Landroid/os/IBinder;
        //   62: bipush 15
        //   64: aload 5
        //   66: aload 6
        //   68: iconst_0
        //   69: invokeinterface 62 5 0
        //   74: pop
        //   75: aload 6
        //   77: invokevirtual 65	android/os/Parcel:readException	()V
        //   80: aload 6
        //   82: invokevirtual 69	android/os/Parcel:readInt	()I
        //   85: istore 4
        //   87: aload 6
        //   89: invokevirtual 72	android/os/Parcel:recycle	()V
        //   92: aload 5
        //   94: invokevirtual 72	android/os/Parcel:recycle	()V
        //   97: ldc 77
        //   99: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   102: iload 4
        //   104: ireturn
        //   105: aconst_null
        //   106: astore_1
        //   107: goto -74 -> 33
        //   110: astore_1
        //   111: aload 6
        //   113: invokevirtual 72	android/os/Parcel:recycle	()V
        //   116: aload 5
        //   118: invokevirtual 72	android/os/Parcel:recycle	()V
        //   121: ldc 77
        //   123: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   126: aload_1
        //   127: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	128	0	this	a
        //   0	128	1	paramb	b
        //   0	128	2	paramArrayOfInt	int[]
        //   0	128	3	paramArrayOfByte	byte[]
        //   0	128	4	paramInt	int
        //   8	109	5	localParcel1	Parcel
        //   13	99	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	22	110	finally
        //   26	33	110	finally
        //   33	87	110	finally
      }
      
      /* Error */
      public final void a(b paramb)
      {
        // Byte code:
        //   0: ldc 82
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 35
        //   16: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +47 -> 67
        //   23: aload_1
        //   24: invokeinterface 45 1 0
        //   29: astore_1
        //   30: aload_2
        //   31: aload_1
        //   32: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_0
        //   36: getfield 18	com/b/a/c$a$a:mRemote	Landroid/os/IBinder;
        //   39: iconst_3
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokeinterface 62 5 0
        //   48: pop
        //   49: aload_3
        //   50: invokevirtual 65	android/os/Parcel:readException	()V
        //   53: aload_3
        //   54: invokevirtual 72	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 72	android/os/Parcel:recycle	()V
        //   61: ldc 82
        //   63: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   66: return
        //   67: aconst_null
        //   68: astore_1
        //   69: goto -39 -> 30
        //   72: astore_1
        //   73: aload_3
        //   74: invokevirtual 72	android/os/Parcel:recycle	()V
        //   77: aload_2
        //   78: invokevirtual 72	android/os/Parcel:recycle	()V
        //   81: ldc 82
        //   83: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   86: aload_1
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	a
        //   0	88	1	paramb	b
        //   8	70	2	localParcel1	Parcel
        //   12	62	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	19	72	finally
        //   23	30	72	finally
        //   30	53	72	finally
      }
      
      /* Error */
      public final boolean a(b paramb, int paramInt)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_3
        //   2: ldc 84
        //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 4
        //   12: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   15: astore 5
        //   17: aload 4
        //   19: ldc 35
        //   21: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   24: aload_1
        //   25: ifnull +70 -> 95
        //   28: aload_1
        //   29: invokeinterface 45 1 0
        //   34: astore_1
        //   35: aload 4
        //   37: aload_1
        //   38: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   41: aload 4
        //   43: iload_2
        //   44: invokevirtual 80	android/os/Parcel:writeInt	(I)V
        //   47: aload_0
        //   48: getfield 18	com/b/a/c$a$a:mRemote	Landroid/os/IBinder;
        //   51: iconst_1
        //   52: aload 4
        //   54: aload 5
        //   56: iconst_0
        //   57: invokeinterface 62 5 0
        //   62: pop
        //   63: aload 5
        //   65: invokevirtual 65	android/os/Parcel:readException	()V
        //   68: aload 5
        //   70: invokevirtual 69	android/os/Parcel:readInt	()I
        //   73: istore_2
        //   74: iload_2
        //   75: ifeq +25 -> 100
        //   78: aload 5
        //   80: invokevirtual 72	android/os/Parcel:recycle	()V
        //   83: aload 4
        //   85: invokevirtual 72	android/os/Parcel:recycle	()V
        //   88: ldc 84
        //   90: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   93: iload_3
        //   94: ireturn
        //   95: aconst_null
        //   96: astore_1
        //   97: goto -62 -> 35
        //   100: iconst_0
        //   101: istore_3
        //   102: goto -24 -> 78
        //   105: astore_1
        //   106: aload 5
        //   108: invokevirtual 72	android/os/Parcel:recycle	()V
        //   111: aload 4
        //   113: invokevirtual 72	android/os/Parcel:recycle	()V
        //   116: ldc 84
        //   118: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   121: aload_1
        //   122: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	123	0	this	a
        //   0	123	1	paramb	b
        //   0	123	2	paramInt	int
        //   1	101	3	bool	boolean
        //   10	102	4	localParcel1	Parcel
        //   15	92	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   17	24	105	finally
        //   28	35	105	finally
        //   35	74	105	finally
      }
      
      /* Error */
      public final boolean a(b paramb, int paramInt, boolean paramBoolean)
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 4
        //   3: ldc 86
        //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 5
        //   13: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   16: astore 6
        //   18: aload 5
        //   20: ldc 35
        //   22: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   25: aload_1
        //   26: ifnull +86 -> 112
        //   29: aload_1
        //   30: invokeinterface 45 1 0
        //   35: astore_1
        //   36: aload 5
        //   38: aload_1
        //   39: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   42: aload 5
        //   44: iload_2
        //   45: invokevirtual 80	android/os/Parcel:writeInt	(I)V
        //   48: iload_3
        //   49: ifeq +68 -> 117
        //   52: iconst_1
        //   53: istore_2
        //   54: aload 5
        //   56: iload_2
        //   57: invokevirtual 80	android/os/Parcel:writeInt	(I)V
        //   60: aload_0
        //   61: getfield 18	com/b/a/c$a$a:mRemote	Landroid/os/IBinder;
        //   64: bipush 13
        //   66: aload 5
        //   68: aload 6
        //   70: iconst_0
        //   71: invokeinterface 62 5 0
        //   76: pop
        //   77: aload 6
        //   79: invokevirtual 65	android/os/Parcel:readException	()V
        //   82: aload 6
        //   84: invokevirtual 69	android/os/Parcel:readInt	()I
        //   87: istore_2
        //   88: iload_2
        //   89: ifeq +33 -> 122
        //   92: iload 4
        //   94: istore_3
        //   95: aload 6
        //   97: invokevirtual 72	android/os/Parcel:recycle	()V
        //   100: aload 5
        //   102: invokevirtual 72	android/os/Parcel:recycle	()V
        //   105: ldc 86
        //   107: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   110: iload_3
        //   111: ireturn
        //   112: aconst_null
        //   113: astore_1
        //   114: goto -78 -> 36
        //   117: iconst_0
        //   118: istore_2
        //   119: goto -65 -> 54
        //   122: iconst_0
        //   123: istore_3
        //   124: goto -29 -> 95
        //   127: astore_1
        //   128: aload 6
        //   130: invokevirtual 72	android/os/Parcel:recycle	()V
        //   133: aload 5
        //   135: invokevirtual 72	android/os/Parcel:recycle	()V
        //   138: ldc 86
        //   140: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   143: aload_1
        //   144: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	145	0	this	a
        //   0	145	1	paramb	b
        //   0	145	2	paramInt	int
        //   0	145	3	paramBoolean	boolean
        //   1	92	4	bool	boolean
        //   11	123	5	localParcel1	Parcel
        //   16	113	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   18	25	127	finally
        //   29	36	127	finally
        //   36	48	127	finally
        //   54	88	127	finally
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public final String b(b paramb, int paramInt)
      {
        // Byte code:
        //   0: ldc 89
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 35
        //   17: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +63 -> 84
        //   24: aload_1
        //   25: invokeinterface 45 1 0
        //   30: astore_1
        //   31: aload_3
        //   32: aload_1
        //   33: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload_3
        //   37: iload_2
        //   38: invokevirtual 80	android/os/Parcel:writeInt	(I)V
        //   41: aload_0
        //   42: getfield 18	com/b/a/c$a$a:mRemote	Landroid/os/IBinder;
        //   45: bipush 10
        //   47: aload_3
        //   48: aload 4
        //   50: iconst_0
        //   51: invokeinterface 62 5 0
        //   56: pop
        //   57: aload 4
        //   59: invokevirtual 65	android/os/Parcel:readException	()V
        //   62: aload 4
        //   64: invokevirtual 93	android/os/Parcel:readString	()Ljava/lang/String;
        //   67: astore_1
        //   68: aload 4
        //   70: invokevirtual 72	android/os/Parcel:recycle	()V
        //   73: aload_3
        //   74: invokevirtual 72	android/os/Parcel:recycle	()V
        //   77: ldc 89
        //   79: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   82: aload_1
        //   83: areturn
        //   84: aconst_null
        //   85: astore_1
        //   86: goto -55 -> 31
        //   89: astore_1
        //   90: aload 4
        //   92: invokevirtual 72	android/os/Parcel:recycle	()V
        //   95: aload_3
        //   96: invokevirtual 72	android/os/Parcel:recycle	()V
        //   99: ldc 89
        //   101: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   104: aload_1
        //   105: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	106	0	this	a
        //   0	106	1	paramb	b
        //   0	106	2	paramInt	int
        //   8	88	3	localParcel1	Parcel
        //   12	79	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	20	89	finally
        //   24	31	89	finally
        //   31	68	89	finally
      }
      
      /* Error */
      public final void b(b paramb)
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
        //   20: ifnull +47 -> 67
        //   23: aload_1
        //   24: invokeinterface 45 1 0
        //   29: astore_1
        //   30: aload_2
        //   31: aload_1
        //   32: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_0
        //   36: getfield 18	com/b/a/c$a$a:mRemote	Landroid/os/IBinder;
        //   39: iconst_4
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokeinterface 62 5 0
        //   48: pop
        //   49: aload_3
        //   50: invokevirtual 65	android/os/Parcel:readException	()V
        //   53: aload_3
        //   54: invokevirtual 72	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 72	android/os/Parcel:recycle	()V
        //   61: ldc 94
        //   63: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   66: return
        //   67: aconst_null
        //   68: astore_1
        //   69: goto -39 -> 30
        //   72: astore_1
        //   73: aload_3
        //   74: invokevirtual 72	android/os/Parcel:recycle	()V
        //   77: aload_2
        //   78: invokevirtual 72	android/os/Parcel:recycle	()V
        //   81: ldc 94
        //   83: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   86: aload_1
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	a
        //   0	88	1	paramb	b
        //   8	70	2	localParcel1	Parcel
        //   12	62	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	19	72	finally
        //   23	30	72	finally
        //   30	53	72	finally
      }
      
      /* Error */
      public final int[] c(b paramb)
      {
        // Byte code:
        //   0: ldc 97
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 35
        //   16: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +53 -> 73
        //   23: aload_1
        //   24: invokeinterface 45 1 0
        //   29: astore_1
        //   30: aload_2
        //   31: aload_1
        //   32: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_0
        //   36: getfield 18	com/b/a/c$a$a:mRemote	Landroid/os/IBinder;
        //   39: iconst_5
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokeinterface 62 5 0
        //   48: pop
        //   49: aload_3
        //   50: invokevirtual 65	android/os/Parcel:readException	()V
        //   53: aload_3
        //   54: invokevirtual 101	android/os/Parcel:createIntArray	()[I
        //   57: astore_1
        //   58: aload_3
        //   59: invokevirtual 72	android/os/Parcel:recycle	()V
        //   62: aload_2
        //   63: invokevirtual 72	android/os/Parcel:recycle	()V
        //   66: ldc 97
        //   68: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   71: aload_1
        //   72: areturn
        //   73: aconst_null
        //   74: astore_1
        //   75: goto -45 -> 30
        //   78: astore_1
        //   79: aload_3
        //   80: invokevirtual 72	android/os/Parcel:recycle	()V
        //   83: aload_2
        //   84: invokevirtual 72	android/os/Parcel:recycle	()V
        //   87: ldc 97
        //   89: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   92: aload_1
        //   93: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	94	0	this	a
        //   0	94	1	paramb	b
        //   8	76	2	localParcel1	Parcel
        //   12	68	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	19	78	finally
        //   23	30	78	finally
        //   30	58	78	finally
      }
      
      /* Error */
      public final int[] c(b paramb, int paramInt)
      {
        // Byte code:
        //   0: ldc 103
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 35
        //   17: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +63 -> 84
        //   24: aload_1
        //   25: invokeinterface 45 1 0
        //   30: astore_1
        //   31: aload_3
        //   32: aload_1
        //   33: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload_3
        //   37: iload_2
        //   38: invokevirtual 80	android/os/Parcel:writeInt	(I)V
        //   41: aload_0
        //   42: getfield 18	com/b/a/c$a$a:mRemote	Landroid/os/IBinder;
        //   45: bipush 11
        //   47: aload_3
        //   48: aload 4
        //   50: iconst_0
        //   51: invokeinterface 62 5 0
        //   56: pop
        //   57: aload 4
        //   59: invokevirtual 65	android/os/Parcel:readException	()V
        //   62: aload 4
        //   64: invokevirtual 101	android/os/Parcel:createIntArray	()[I
        //   67: astore_1
        //   68: aload 4
        //   70: invokevirtual 72	android/os/Parcel:recycle	()V
        //   73: aload_3
        //   74: invokevirtual 72	android/os/Parcel:recycle	()V
        //   77: ldc 103
        //   79: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   82: aload_1
        //   83: areturn
        //   84: aconst_null
        //   85: astore_1
        //   86: goto -55 -> 31
        //   89: astore_1
        //   90: aload 4
        //   92: invokevirtual 72	android/os/Parcel:recycle	()V
        //   95: aload_3
        //   96: invokevirtual 72	android/os/Parcel:recycle	()V
        //   99: ldc 103
        //   101: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   104: aload_1
        //   105: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	106	0	this	a
        //   0	106	1	paramb	b
        //   0	106	2	paramInt	int
        //   8	88	3	localParcel1	Parcel
        //   12	79	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	20	89	finally
        //   24	31	89	finally
        //   31	68	89	finally
      }
      
      public final boolean cj(String paramString)
      {
        boolean bool = false;
        AppMethodBeat.i(88771);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
          localParcel1.writeString(paramString);
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
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
          AppMethodBeat.o(88771);
        }
      }
      
      /* Error */
      public final int d(b paramb, int paramInt)
      {
        // Byte code:
        //   0: ldc 112
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 35
        //   17: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: ifnull +63 -> 84
        //   24: aload_1
        //   25: invokeinterface 45 1 0
        //   30: astore_1
        //   31: aload_3
        //   32: aload_1
        //   33: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload_3
        //   37: iload_2
        //   38: invokevirtual 80	android/os/Parcel:writeInt	(I)V
        //   41: aload_0
        //   42: getfield 18	com/b/a/c$a$a:mRemote	Landroid/os/IBinder;
        //   45: bipush 12
        //   47: aload_3
        //   48: aload 4
        //   50: iconst_0
        //   51: invokeinterface 62 5 0
        //   56: pop
        //   57: aload 4
        //   59: invokevirtual 65	android/os/Parcel:readException	()V
        //   62: aload 4
        //   64: invokevirtual 69	android/os/Parcel:readInt	()I
        //   67: istore_2
        //   68: aload 4
        //   70: invokevirtual 72	android/os/Parcel:recycle	()V
        //   73: aload_3
        //   74: invokevirtual 72	android/os/Parcel:recycle	()V
        //   77: ldc 112
        //   79: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   82: iload_2
        //   83: ireturn
        //   84: aconst_null
        //   85: astore_1
        //   86: goto -55 -> 31
        //   89: astore_1
        //   90: aload 4
        //   92: invokevirtual 72	android/os/Parcel:recycle	()V
        //   95: aload_3
        //   96: invokevirtual 72	android/os/Parcel:recycle	()V
        //   99: ldc 112
        //   101: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   104: aload_1
        //   105: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	106	0	this	a
        //   0	106	1	paramb	b
        //   0	106	2	paramInt	int
        //   8	88	3	localParcel1	Parcel
        //   12	79	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	20	89	finally
        //   24	31	89	finally
        //   31	68	89	finally
      }
      
      /* Error */
      public final long d(b paramb)
      {
        // Byte code:
        //   0: ldc 114
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 4
        //   10: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   13: astore 5
        //   15: aload 4
        //   17: ldc 35
        //   19: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload_1
        //   23: ifnull +61 -> 84
        //   26: aload_1
        //   27: invokeinterface 45 1 0
        //   32: astore_1
        //   33: aload 4
        //   35: aload_1
        //   36: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   39: aload_0
        //   40: getfield 18	com/b/a/c$a$a:mRemote	Landroid/os/IBinder;
        //   43: bipush 14
        //   45: aload 4
        //   47: aload 5
        //   49: iconst_0
        //   50: invokeinterface 62 5 0
        //   55: pop
        //   56: aload 5
        //   58: invokevirtual 65	android/os/Parcel:readException	()V
        //   61: aload 5
        //   63: invokevirtual 118	android/os/Parcel:readLong	()J
        //   66: lstore_2
        //   67: aload 5
        //   69: invokevirtual 72	android/os/Parcel:recycle	()V
        //   72: aload 4
        //   74: invokevirtual 72	android/os/Parcel:recycle	()V
        //   77: ldc 114
        //   79: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   82: lload_2
        //   83: lreturn
        //   84: aconst_null
        //   85: astore_1
        //   86: goto -53 -> 33
        //   89: astore_1
        //   90: aload 5
        //   92: invokevirtual 72	android/os/Parcel:recycle	()V
        //   95: aload 4
        //   97: invokevirtual 72	android/os/Parcel:recycle	()V
        //   100: ldc 114
        //   102: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   105: aload_1
        //   106: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	107	0	this	a
        //   0	107	1	paramb	b
        //   66	17	2	l	long
        //   8	88	4	localParcel1	Parcel
        //   13	78	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   15	22	89	finally
        //   26	33	89	finally
        //   33	67	89	finally
      }
      
      /* Error */
      public final byte[] e(b paramb)
      {
        // Byte code:
        //   0: ldc 121
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 35
        //   16: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +54 -> 74
        //   23: aload_1
        //   24: invokeinterface 45 1 0
        //   29: astore_1
        //   30: aload_2
        //   31: aload_1
        //   32: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   35: aload_0
        //   36: getfield 18	com/b/a/c$a$a:mRemote	Landroid/os/IBinder;
        //   39: bipush 16
        //   41: aload_2
        //   42: aload_3
        //   43: iconst_0
        //   44: invokeinterface 62 5 0
        //   49: pop
        //   50: aload_3
        //   51: invokevirtual 65	android/os/Parcel:readException	()V
        //   54: aload_3
        //   55: invokevirtual 125	android/os/Parcel:createByteArray	()[B
        //   58: astore_1
        //   59: aload_3
        //   60: invokevirtual 72	android/os/Parcel:recycle	()V
        //   63: aload_2
        //   64: invokevirtual 72	android/os/Parcel:recycle	()V
        //   67: ldc 121
        //   69: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   72: aload_1
        //   73: areturn
        //   74: aconst_null
        //   75: astore_1
        //   76: goto -46 -> 30
        //   79: astore_1
        //   80: aload_3
        //   81: invokevirtual 72	android/os/Parcel:recycle	()V
        //   84: aload_2
        //   85: invokevirtual 72	android/os/Parcel:recycle	()V
        //   88: ldc 121
        //   90: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   93: aload_1
        //   94: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	95	0	this	a
        //   0	95	1	paramb	b
        //   8	77	2	localParcel1	Parcel
        //   12	69	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	19	79	finally
        //   23	30	79	finally
        //   30	59	79	finally
      }
      
      public final boolean gc(int paramInt)
      {
        boolean bool = false;
        AppMethodBeat.i(88769);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
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
          AppMethodBeat.o(88769);
        }
      }
      
      public final int gd(int paramInt)
      {
        AppMethodBeat.i(88770);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(88770);
        }
      }
      
      public final int[] zQ()
      {
        AppMethodBeat.i(88768);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int[] arrayOfInt = localParcel2.createIntArray();
          return arrayOfInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(88768);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.b.a.c
 * JD-Core Version:    0.7.0.1
 */