package com.c.a;

import android.os.IBinder;
import android.os.Parcel;

final class c$a$a
  implements c
{
  private IBinder mRemote;
  
  c$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  /* Error */
  public final int a(b paramb, int[] paramArrayOfInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 6
    //   10: aload 5
    //   12: ldc 28
    //   14: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +69 -> 87
    //   21: aload_1
    //   22: invokeinterface 38 1 0
    //   27: astore_1
    //   28: aload 5
    //   30: aload_1
    //   31: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   34: aload 5
    //   36: aload_2
    //   37: invokevirtual 45	android/os/Parcel:writeIntArray	([I)V
    //   40: aload 5
    //   42: aload_3
    //   43: invokevirtual 49	android/os/Parcel:writeByteArray	([B)V
    //   46: aload_0
    //   47: getfield 18	com/c/a/c$a$a:mRemote	Landroid/os/IBinder;
    //   50: iconst_2
    //   51: aload 5
    //   53: aload 6
    //   55: iconst_0
    //   56: invokeinterface 55 5 0
    //   61: pop
    //   62: aload 6
    //   64: invokevirtual 58	android/os/Parcel:readException	()V
    //   67: aload 6
    //   69: invokevirtual 62	android/os/Parcel:readInt	()I
    //   72: istore 4
    //   74: aload 6
    //   76: invokevirtual 65	android/os/Parcel:recycle	()V
    //   79: aload 5
    //   81: invokevirtual 65	android/os/Parcel:recycle	()V
    //   84: iload 4
    //   86: ireturn
    //   87: aconst_null
    //   88: astore_1
    //   89: goto -61 -> 28
    //   92: astore_1
    //   93: aload 6
    //   95: invokevirtual 65	android/os/Parcel:recycle	()V
    //   98: aload 5
    //   100: invokevirtual 65	android/os/Parcel:recycle	()V
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	a
    //   0	105	1	paramb	b
    //   0	105	2	paramArrayOfInt	int[]
    //   0	105	3	paramArrayOfByte	byte[]
    //   72	13	4	i	int
    //   3	96	5	localParcel1	Parcel
    //   8	86	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	92	finally
    //   21	28	92	finally
    //   28	74	92	finally
  }
  
  /* Error */
  public final int a(b paramb, int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 6
    //   10: aload 5
    //   12: ldc 28
    //   14: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +77 -> 95
    //   21: aload_1
    //   22: invokeinterface 38 1 0
    //   27: astore_1
    //   28: aload 5
    //   30: aload_1
    //   31: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   34: aload 5
    //   36: aload_2
    //   37: invokevirtual 45	android/os/Parcel:writeIntArray	([I)V
    //   40: aload 5
    //   42: aload_3
    //   43: invokevirtual 49	android/os/Parcel:writeByteArray	([B)V
    //   46: aload 5
    //   48: iload 4
    //   50: invokevirtual 70	android/os/Parcel:writeInt	(I)V
    //   53: aload_0
    //   54: getfield 18	com/c/a/c$a$a:mRemote	Landroid/os/IBinder;
    //   57: bipush 15
    //   59: aload 5
    //   61: aload 6
    //   63: iconst_0
    //   64: invokeinterface 55 5 0
    //   69: pop
    //   70: aload 6
    //   72: invokevirtual 58	android/os/Parcel:readException	()V
    //   75: aload 6
    //   77: invokevirtual 62	android/os/Parcel:readInt	()I
    //   80: istore 4
    //   82: aload 6
    //   84: invokevirtual 65	android/os/Parcel:recycle	()V
    //   87: aload 5
    //   89: invokevirtual 65	android/os/Parcel:recycle	()V
    //   92: iload 4
    //   94: ireturn
    //   95: aconst_null
    //   96: astore_1
    //   97: goto -69 -> 28
    //   100: astore_1
    //   101: aload 6
    //   103: invokevirtual 65	android/os/Parcel:recycle	()V
    //   106: aload 5
    //   108: invokevirtual 65	android/os/Parcel:recycle	()V
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	a
    //   0	113	1	paramb	b
    //   0	113	2	paramArrayOfInt	int[]
    //   0	113	3	paramArrayOfByte	byte[]
    //   0	113	4	paramInt	int
    //   3	104	5	localParcel1	Parcel
    //   8	94	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	100	finally
    //   21	28	100	finally
    //   28	82	100	finally
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
    //   15: ifnull +42 -> 57
    //   18: aload_1
    //   19: invokeinterface 38 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 18	com/c/a/c$a$a:mRemote	Landroid/os/IBinder;
    //   34: iconst_3
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 55 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 58	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 65	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 65	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -34 -> 25
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 65	android/os/Parcel:recycle	()V
    //   67: aload_2
    //   68: invokevirtual 65	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	a
    //   0	73	1	paramb	b
    //   3	65	2	localParcel1	Parcel
    //   7	57	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	62	finally
    //   18	25	62	finally
    //   25	48	62	finally
  }
  
  /* Error */
  public final boolean a(b paramb, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 28
    //   16: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: ifnull +65 -> 85
    //   23: aload_1
    //   24: invokeinterface 38 1 0
    //   29: astore_1
    //   30: aload 4
    //   32: aload_1
    //   33: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload 4
    //   38: iload_2
    //   39: invokevirtual 70	android/os/Parcel:writeInt	(I)V
    //   42: aload_0
    //   43: getfield 18	com/c/a/c$a$a:mRemote	Landroid/os/IBinder;
    //   46: iconst_1
    //   47: aload 4
    //   49: aload 5
    //   51: iconst_0
    //   52: invokeinterface 55 5 0
    //   57: pop
    //   58: aload 5
    //   60: invokevirtual 58	android/os/Parcel:readException	()V
    //   63: aload 5
    //   65: invokevirtual 62	android/os/Parcel:readInt	()I
    //   68: istore_2
    //   69: iload_2
    //   70: ifeq +20 -> 90
    //   73: aload 5
    //   75: invokevirtual 65	android/os/Parcel:recycle	()V
    //   78: aload 4
    //   80: invokevirtual 65	android/os/Parcel:recycle	()V
    //   83: iload_3
    //   84: ireturn
    //   85: aconst_null
    //   86: astore_1
    //   87: goto -57 -> 30
    //   90: iconst_0
    //   91: istore_3
    //   92: goto -19 -> 73
    //   95: astore_1
    //   96: aload 5
    //   98: invokevirtual 65	android/os/Parcel:recycle	()V
    //   101: aload 4
    //   103: invokevirtual 65	android/os/Parcel:recycle	()V
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	a
    //   0	108	1	paramb	b
    //   0	108	2	paramInt	int
    //   1	91	3	bool	boolean
    //   5	97	4	localParcel1	Parcel
    //   10	87	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   12	19	95	finally
    //   23	30	95	finally
    //   30	69	95	finally
  }
  
  /* Error */
  public final boolean a(b paramb, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 5
    //   8: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 6
    //   13: aload 5
    //   15: ldc 28
    //   17: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: ifnull +81 -> 102
    //   24: aload_1
    //   25: invokeinterface 38 1 0
    //   30: astore_1
    //   31: aload 5
    //   33: aload_1
    //   34: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   37: aload 5
    //   39: iload_2
    //   40: invokevirtual 70	android/os/Parcel:writeInt	(I)V
    //   43: iload_3
    //   44: ifeq +63 -> 107
    //   47: iconst_1
    //   48: istore_2
    //   49: aload 5
    //   51: iload_2
    //   52: invokevirtual 70	android/os/Parcel:writeInt	(I)V
    //   55: aload_0
    //   56: getfield 18	com/c/a/c$a$a:mRemote	Landroid/os/IBinder;
    //   59: bipush 13
    //   61: aload 5
    //   63: aload 6
    //   65: iconst_0
    //   66: invokeinterface 55 5 0
    //   71: pop
    //   72: aload 6
    //   74: invokevirtual 58	android/os/Parcel:readException	()V
    //   77: aload 6
    //   79: invokevirtual 62	android/os/Parcel:readInt	()I
    //   82: istore_2
    //   83: iload_2
    //   84: ifeq +28 -> 112
    //   87: iload 4
    //   89: istore_3
    //   90: aload 6
    //   92: invokevirtual 65	android/os/Parcel:recycle	()V
    //   95: aload 5
    //   97: invokevirtual 65	android/os/Parcel:recycle	()V
    //   100: iload_3
    //   101: ireturn
    //   102: aconst_null
    //   103: astore_1
    //   104: goto -73 -> 31
    //   107: iconst_0
    //   108: istore_2
    //   109: goto -60 -> 49
    //   112: iconst_0
    //   113: istore_3
    //   114: goto -24 -> 90
    //   117: astore_1
    //   118: aload 6
    //   120: invokevirtual 65	android/os/Parcel:recycle	()V
    //   123: aload 5
    //   125: invokevirtual 65	android/os/Parcel:recycle	()V
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	a
    //   0	130	1	paramb	b
    //   0	130	2	paramInt	int
    //   0	130	3	paramBoolean	boolean
    //   1	87	4	bool	boolean
    //   6	118	5	localParcel1	Parcel
    //   11	108	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	20	117	finally
    //   24	31	117	finally
    //   31	43	117	finally
    //   49	83	117	finally
  }
  
  public final boolean aL(String paramString)
  {
    boolean bool = false;
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
    }
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  /* Error */
  public final String b(b paramb, int paramInt)
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
    //   16: ifnull +58 -> 74
    //   19: aload_1
    //   20: invokeinterface 38 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_3
    //   32: iload_2
    //   33: invokevirtual 70	android/os/Parcel:writeInt	(I)V
    //   36: aload_0
    //   37: getfield 18	com/c/a/c$a$a:mRemote	Landroid/os/IBinder;
    //   40: bipush 10
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 55 5 0
    //   51: pop
    //   52: aload 4
    //   54: invokevirtual 58	android/os/Parcel:readException	()V
    //   57: aload 4
    //   59: invokevirtual 84	android/os/Parcel:readString	()Ljava/lang/String;
    //   62: astore_1
    //   63: aload 4
    //   65: invokevirtual 65	android/os/Parcel:recycle	()V
    //   68: aload_3
    //   69: invokevirtual 65	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: areturn
    //   74: aconst_null
    //   75: astore_1
    //   76: goto -50 -> 26
    //   79: astore_1
    //   80: aload 4
    //   82: invokevirtual 65	android/os/Parcel:recycle	()V
    //   85: aload_3
    //   86: invokevirtual 65	android/os/Parcel:recycle	()V
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	a
    //   0	91	1	paramb	b
    //   0	91	2	paramInt	int
    //   3	83	3	localParcel1	Parcel
    //   7	74	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	79	finally
    //   19	26	79	finally
    //   26	63	79	finally
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
    //   15: ifnull +42 -> 57
    //   18: aload_1
    //   19: invokeinterface 38 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 18	com/c/a/c$a$a:mRemote	Landroid/os/IBinder;
    //   34: iconst_4
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 55 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 58	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 65	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 65	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -34 -> 25
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 65	android/os/Parcel:recycle	()V
    //   67: aload_2
    //   68: invokevirtual 65	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	a
    //   0	73	1	paramb	b
    //   3	65	2	localParcel1	Parcel
    //   7	57	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	62	finally
    //   18	25	62	finally
    //   25	48	62	finally
  }
  
  /* Error */
  public final int[] c(b paramb)
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
    //   15: ifnull +48 -> 63
    //   18: aload_1
    //   19: invokeinterface 38 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 18	com/c/a/c$a$a:mRemote	Landroid/os/IBinder;
    //   34: iconst_5
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 55 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 58	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 90	android/os/Parcel:createIntArray	()[I
    //   52: astore_1
    //   53: aload_3
    //   54: invokevirtual 65	android/os/Parcel:recycle	()V
    //   57: aload_2
    //   58: invokevirtual 65	android/os/Parcel:recycle	()V
    //   61: aload_1
    //   62: areturn
    //   63: aconst_null
    //   64: astore_1
    //   65: goto -40 -> 25
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 65	android/os/Parcel:recycle	()V
    //   73: aload_2
    //   74: invokevirtual 65	android/os/Parcel:recycle	()V
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	a
    //   0	79	1	paramb	b
    //   3	71	2	localParcel1	Parcel
    //   7	63	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	68	finally
    //   18	25	68	finally
    //   25	53	68	finally
  }
  
  /* Error */
  public final int[] c(b paramb, int paramInt)
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
    //   16: ifnull +58 -> 74
    //   19: aload_1
    //   20: invokeinterface 38 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_3
    //   32: iload_2
    //   33: invokevirtual 70	android/os/Parcel:writeInt	(I)V
    //   36: aload_0
    //   37: getfield 18	com/c/a/c$a$a:mRemote	Landroid/os/IBinder;
    //   40: bipush 11
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 55 5 0
    //   51: pop
    //   52: aload 4
    //   54: invokevirtual 58	android/os/Parcel:readException	()V
    //   57: aload 4
    //   59: invokevirtual 90	android/os/Parcel:createIntArray	()[I
    //   62: astore_1
    //   63: aload 4
    //   65: invokevirtual 65	android/os/Parcel:recycle	()V
    //   68: aload_3
    //   69: invokevirtual 65	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: areturn
    //   74: aconst_null
    //   75: astore_1
    //   76: goto -50 -> 26
    //   79: astore_1
    //   80: aload 4
    //   82: invokevirtual 65	android/os/Parcel:recycle	()V
    //   85: aload_3
    //   86: invokevirtual 65	android/os/Parcel:recycle	()V
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	a
    //   0	91	1	paramb	b
    //   0	91	2	paramInt	int
    //   3	83	3	localParcel1	Parcel
    //   7	74	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	79	finally
    //   19	26	79	finally
    //   26	63	79	finally
  }
  
  /* Error */
  public final int d(b paramb, int paramInt)
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
    //   16: ifnull +58 -> 74
    //   19: aload_1
    //   20: invokeinterface 38 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_3
    //   32: iload_2
    //   33: invokevirtual 70	android/os/Parcel:writeInt	(I)V
    //   36: aload_0
    //   37: getfield 18	com/c/a/c$a$a:mRemote	Landroid/os/IBinder;
    //   40: bipush 12
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 55 5 0
    //   51: pop
    //   52: aload 4
    //   54: invokevirtual 58	android/os/Parcel:readException	()V
    //   57: aload 4
    //   59: invokevirtual 62	android/os/Parcel:readInt	()I
    //   62: istore_2
    //   63: aload 4
    //   65: invokevirtual 65	android/os/Parcel:recycle	()V
    //   68: aload_3
    //   69: invokevirtual 65	android/os/Parcel:recycle	()V
    //   72: iload_2
    //   73: ireturn
    //   74: aconst_null
    //   75: astore_1
    //   76: goto -50 -> 26
    //   79: astore_1
    //   80: aload 4
    //   82: invokevirtual 65	android/os/Parcel:recycle	()V
    //   85: aload_3
    //   86: invokevirtual 65	android/os/Parcel:recycle	()V
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	a
    //   0	91	1	paramb	b
    //   0	91	2	paramInt	int
    //   3	83	3	localParcel1	Parcel
    //   7	74	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	79	finally
    //   19	26	79	finally
    //   26	63	79	finally
  }
  
  /* Error */
  public final long d(b paramb)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 28
    //   14: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +56 -> 74
    //   21: aload_1
    //   22: invokeinterface 38 1 0
    //   27: astore_1
    //   28: aload 4
    //   30: aload_1
    //   31: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   34: aload_0
    //   35: getfield 18	com/c/a/c$a$a:mRemote	Landroid/os/IBinder;
    //   38: bipush 14
    //   40: aload 4
    //   42: aload 5
    //   44: iconst_0
    //   45: invokeinterface 55 5 0
    //   50: pop
    //   51: aload 5
    //   53: invokevirtual 58	android/os/Parcel:readException	()V
    //   56: aload 5
    //   58: invokevirtual 98	android/os/Parcel:readLong	()J
    //   61: lstore_2
    //   62: aload 5
    //   64: invokevirtual 65	android/os/Parcel:recycle	()V
    //   67: aload 4
    //   69: invokevirtual 65	android/os/Parcel:recycle	()V
    //   72: lload_2
    //   73: lreturn
    //   74: aconst_null
    //   75: astore_1
    //   76: goto -48 -> 28
    //   79: astore_1
    //   80: aload 5
    //   82: invokevirtual 65	android/os/Parcel:recycle	()V
    //   85: aload 4
    //   87: invokevirtual 65	android/os/Parcel:recycle	()V
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	a
    //   0	92	1	paramb	b
    //   61	12	2	l	long
    //   3	83	4	localParcel1	Parcel
    //   8	73	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	79	finally
    //   21	28	79	finally
    //   28	62	79	finally
  }
  
  public final boolean dV(int paramInt)
  {
    boolean bool = false;
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
    }
  }
  
  public final int dW(int paramInt)
  {
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
    }
  }
  
  /* Error */
  public final byte[] e(b paramb)
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
    //   15: ifnull +49 -> 64
    //   18: aload_1
    //   19: invokeinterface 38 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 18	com/c/a/c$a$a:mRemote	Landroid/os/IBinder;
    //   34: bipush 16
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 55 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 58	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 108	android/os/Parcel:createByteArray	()[B
    //   53: astore_1
    //   54: aload_3
    //   55: invokevirtual 65	android/os/Parcel:recycle	()V
    //   58: aload_2
    //   59: invokevirtual 65	android/os/Parcel:recycle	()V
    //   62: aload_1
    //   63: areturn
    //   64: aconst_null
    //   65: astore_1
    //   66: goto -41 -> 25
    //   69: astore_1
    //   70: aload_3
    //   71: invokevirtual 65	android/os/Parcel:recycle	()V
    //   74: aload_2
    //   75: invokevirtual 65	android/os/Parcel:recycle	()V
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	a
    //   0	80	1	paramb	b
    //   3	72	2	localParcel1	Parcel
    //   7	64	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	69	finally
    //   18	25	69	finally
    //   25	54	69	finally
  }
  
  public final int[] oV()
  {
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.c.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */