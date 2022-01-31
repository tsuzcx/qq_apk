package com.tencent.mm.plugin.exdevice.service;

import android.os.IBinder;
import android.os.Parcel;

final class h$a$a
  implements h
{
  private IBinder mRemote;
  
  h$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  /* Error */
  public final long a(p paramp)
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
    //   35: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
    //   38: bipush 7
    //   40: aload 4
    //   42: aload 5
    //   44: iconst_0
    //   45: invokeinterface 47 5 0
    //   50: pop
    //   51: aload 5
    //   53: invokevirtual 50	android/os/Parcel:readException	()V
    //   56: aload 5
    //   58: invokevirtual 54	android/os/Parcel:readLong	()J
    //   61: lstore_2
    //   62: aload 5
    //   64: invokevirtual 57	android/os/Parcel:recycle	()V
    //   67: aload 4
    //   69: invokevirtual 57	android/os/Parcel:recycle	()V
    //   72: lload_2
    //   73: lreturn
    //   74: aconst_null
    //   75: astore_1
    //   76: goto -48 -> 28
    //   79: astore_1
    //   80: aload 5
    //   82: invokevirtual 57	android/os/Parcel:recycle	()V
    //   85: aload 4
    //   87: invokevirtual 57	android/os/Parcel:recycle	()V
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	a
    //   0	92	1	paramp	p
    //   61	12	2	l	long
    //   3	83	4	localParcel1	Parcel
    //   8	73	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	79	finally
    //   21	28	79	finally
    //   28	62	79	finally
  }
  
  /* Error */
  public final void a(n paramn)
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
    //   19: invokeinterface 61 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
    //   34: bipush 11
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 47 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 50	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 57	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 57	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 57	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 57	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	a
    //   0	74	1	paramn	n
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  /* Error */
  public final boolean a(long paramLong, int paramInt, k paramk)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 6
    //   8: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 7
    //   13: aload 6
    //   15: ldc 28
    //   17: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload 6
    //   22: lload_1
    //   23: invokevirtual 66	android/os/Parcel:writeLong	(J)V
    //   26: aload 6
    //   28: iload_3
    //   29: invokevirtual 70	android/os/Parcel:writeInt	(I)V
    //   32: aload 4
    //   34: ifnull +66 -> 100
    //   37: aload 4
    //   39: invokeinterface 73 1 0
    //   44: astore 4
    //   46: aload 6
    //   48: aload 4
    //   50: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   53: aload_0
    //   54: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
    //   57: iconst_4
    //   58: aload 6
    //   60: aload 7
    //   62: iconst_0
    //   63: invokeinterface 47 5 0
    //   68: pop
    //   69: aload 7
    //   71: invokevirtual 50	android/os/Parcel:readException	()V
    //   74: aload 7
    //   76: invokevirtual 77	android/os/Parcel:readInt	()I
    //   79: istore_3
    //   80: iload_3
    //   81: ifeq +6 -> 87
    //   84: iconst_1
    //   85: istore 5
    //   87: aload 7
    //   89: invokevirtual 57	android/os/Parcel:recycle	()V
    //   92: aload 6
    //   94: invokevirtual 57	android/os/Parcel:recycle	()V
    //   97: iload 5
    //   99: ireturn
    //   100: aconst_null
    //   101: astore 4
    //   103: goto -57 -> 46
    //   106: astore 4
    //   108: aload 7
    //   110: invokevirtual 57	android/os/Parcel:recycle	()V
    //   113: aload 6
    //   115: invokevirtual 57	android/os/Parcel:recycle	()V
    //   118: aload 4
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	a
    //   0	121	1	paramLong	long
    //   0	121	3	paramInt	int
    //   0	121	4	paramk	k
    //   1	97	5	bool	boolean
    //   6	108	6	localParcel1	Parcel
    //   11	98	7	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	32	106	finally
    //   37	46	106	finally
    //   46	80	106	finally
  }
  
  /* Error */
  public final boolean a(i parami)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 28
    //   16: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: ifnull +62 -> 82
    //   23: aload_1
    //   24: invokeinterface 81 1 0
    //   29: astore_1
    //   30: aload 4
    //   32: aload_1
    //   33: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_0
    //   37: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
    //   40: bipush 9
    //   42: aload 4
    //   44: aload 5
    //   46: iconst_0
    //   47: invokeinterface 47 5 0
    //   52: pop
    //   53: aload 5
    //   55: invokevirtual 50	android/os/Parcel:readException	()V
    //   58: aload 5
    //   60: invokevirtual 77	android/os/Parcel:readInt	()I
    //   63: istore_2
    //   64: iload_2
    //   65: ifeq +5 -> 70
    //   68: iconst_1
    //   69: istore_3
    //   70: aload 5
    //   72: invokevirtual 57	android/os/Parcel:recycle	()V
    //   75: aload 4
    //   77: invokevirtual 57	android/os/Parcel:recycle	()V
    //   80: iload_3
    //   81: ireturn
    //   82: aconst_null
    //   83: astore_1
    //   84: goto -54 -> 30
    //   87: astore_1
    //   88: aload 5
    //   90: invokevirtual 57	android/os/Parcel:recycle	()V
    //   93: aload 4
    //   95: invokevirtual 57	android/os/Parcel:recycle	()V
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	a
    //   0	100	1	parami	i
    //   63	2	2	i	int
    //   1	80	3	bool	boolean
    //   5	89	4	localParcel1	Parcel
    //   10	79	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   12	19	87	finally
    //   23	30	87	finally
    //   30	64	87	finally
  }
  
  /* Error */
  public final boolean a(s params)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 28
    //   16: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: ifnull +62 -> 82
    //   23: aload_1
    //   24: invokeinterface 85 1 0
    //   29: astore_1
    //   30: aload 4
    //   32: aload_1
    //   33: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_0
    //   37: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
    //   40: bipush 18
    //   42: aload 4
    //   44: aload 5
    //   46: iconst_0
    //   47: invokeinterface 47 5 0
    //   52: pop
    //   53: aload 5
    //   55: invokevirtual 50	android/os/Parcel:readException	()V
    //   58: aload 5
    //   60: invokevirtual 77	android/os/Parcel:readInt	()I
    //   63: istore_2
    //   64: iload_2
    //   65: ifeq +5 -> 70
    //   68: iconst_1
    //   69: istore_3
    //   70: aload 5
    //   72: invokevirtual 57	android/os/Parcel:recycle	()V
    //   75: aload 4
    //   77: invokevirtual 57	android/os/Parcel:recycle	()V
    //   80: iload_3
    //   81: ireturn
    //   82: aconst_null
    //   83: astore_1
    //   84: goto -54 -> 30
    //   87: astore_1
    //   88: aload 5
    //   90: invokevirtual 57	android/os/Parcel:recycle	()V
    //   93: aload 4
    //   95: invokevirtual 57	android/os/Parcel:recycle	()V
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	a
    //   0	100	1	params	s
    //   63	2	2	i	int
    //   1	80	3	bool	boolean
    //   5	89	4	localParcel1	Parcel
    //   10	79	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   12	19	87	finally
    //   23	30	87	finally
    //   30	64	87	finally
  }
  
  /* Error */
  public final boolean a(java.lang.String paramString, boolean paramBoolean, q paramq)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 6
    //   8: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 7
    //   13: aload 6
    //   15: ldc 28
    //   17: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload 6
    //   22: aload_1
    //   23: invokevirtual 89	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   26: iload_2
    //   27: ifeq +79 -> 106
    //   30: iconst_1
    //   31: istore 4
    //   33: aload 6
    //   35: iload 4
    //   37: invokevirtual 70	android/os/Parcel:writeInt	(I)V
    //   40: aload_3
    //   41: ifnull +71 -> 112
    //   44: aload_3
    //   45: invokeinterface 92 1 0
    //   50: astore_1
    //   51: aload 6
    //   53: aload_1
    //   54: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   57: aload_0
    //   58: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
    //   61: bipush 13
    //   63: aload 6
    //   65: aload 7
    //   67: iconst_0
    //   68: invokeinterface 47 5 0
    //   73: pop
    //   74: aload 7
    //   76: invokevirtual 50	android/os/Parcel:readException	()V
    //   79: aload 7
    //   81: invokevirtual 77	android/os/Parcel:readInt	()I
    //   84: istore 4
    //   86: iload 4
    //   88: ifeq +29 -> 117
    //   91: iload 5
    //   93: istore_2
    //   94: aload 7
    //   96: invokevirtual 57	android/os/Parcel:recycle	()V
    //   99: aload 6
    //   101: invokevirtual 57	android/os/Parcel:recycle	()V
    //   104: iload_2
    //   105: ireturn
    //   106: iconst_0
    //   107: istore 4
    //   109: goto -76 -> 33
    //   112: aconst_null
    //   113: astore_1
    //   114: goto -63 -> 51
    //   117: iconst_0
    //   118: istore_2
    //   119: goto -25 -> 94
    //   122: astore_1
    //   123: aload 7
    //   125: invokevirtual 57	android/os/Parcel:recycle	()V
    //   128: aload 6
    //   130: invokevirtual 57	android/os/Parcel:recycle	()V
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	a
    //   0	135	1	paramString	java.lang.String
    //   0	135	2	paramBoolean	boolean
    //   0	135	3	paramq	q
    //   31	77	4	i	int
    //   1	91	5	bool	boolean
    //   6	123	6	localParcel1	Parcel
    //   11	113	7	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	26	122	finally
    //   33	40	122	finally
    //   44	51	122	finally
    //   51	86	122	finally
  }
  
  public final long[] aMa()
  {
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
    }
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
    //   2: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 28
    //   16: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload 4
    //   21: iload_1
    //   22: invokevirtual 70	android/os/Parcel:writeInt	(I)V
    //   25: aload_2
    //   26: ifnull +59 -> 85
    //   29: aload_2
    //   30: invokeinterface 102 1 0
    //   35: astore_2
    //   36: aload 4
    //   38: aload_2
    //   39: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   42: aload_0
    //   43: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
    //   46: iconst_1
    //   47: aload 4
    //   49: aload 5
    //   51: iconst_0
    //   52: invokeinterface 47 5 0
    //   57: pop
    //   58: aload 5
    //   60: invokevirtual 50	android/os/Parcel:readException	()V
    //   63: aload 5
    //   65: invokevirtual 77	android/os/Parcel:readInt	()I
    //   68: istore_1
    //   69: iload_1
    //   70: ifeq +20 -> 90
    //   73: aload 5
    //   75: invokevirtual 57	android/os/Parcel:recycle	()V
    //   78: aload 4
    //   80: invokevirtual 57	android/os/Parcel:recycle	()V
    //   83: iload_3
    //   84: ireturn
    //   85: aconst_null
    //   86: astore_2
    //   87: goto -51 -> 36
    //   90: iconst_0
    //   91: istore_3
    //   92: goto -19 -> 73
    //   95: astore_2
    //   96: aload 5
    //   98: invokevirtual 57	android/os/Parcel:recycle	()V
    //   101: aload 4
    //   103: invokevirtual 57	android/os/Parcel:recycle	()V
    //   106: aload_2
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	a
    //   0	108	1	paramInt	int
    //   0	108	2	paramj	j
    //   1	91	3	bool	boolean
    //   5	97	4	localParcel1	Parcel
    //   10	87	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   12	25	95	finally
    //   29	36	95	finally
    //   36	69	95	finally
  }
  
  /* Error */
  public final boolean b(long paramLong, int paramInt, k paramk)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 6
    //   8: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 7
    //   13: aload 6
    //   15: ldc 28
    //   17: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload 6
    //   22: lload_1
    //   23: invokevirtual 66	android/os/Parcel:writeLong	(J)V
    //   26: aload 6
    //   28: iload_3
    //   29: invokevirtual 70	android/os/Parcel:writeInt	(I)V
    //   32: aload 4
    //   34: ifnull +67 -> 101
    //   37: aload 4
    //   39: invokeinterface 73 1 0
    //   44: astore 4
    //   46: aload 6
    //   48: aload 4
    //   50: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   53: aload_0
    //   54: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
    //   57: bipush 16
    //   59: aload 6
    //   61: aload 7
    //   63: iconst_0
    //   64: invokeinterface 47 5 0
    //   69: pop
    //   70: aload 7
    //   72: invokevirtual 50	android/os/Parcel:readException	()V
    //   75: aload 7
    //   77: invokevirtual 77	android/os/Parcel:readInt	()I
    //   80: istore_3
    //   81: iload_3
    //   82: ifeq +6 -> 88
    //   85: iconst_1
    //   86: istore 5
    //   88: aload 7
    //   90: invokevirtual 57	android/os/Parcel:recycle	()V
    //   93: aload 6
    //   95: invokevirtual 57	android/os/Parcel:recycle	()V
    //   98: iload 5
    //   100: ireturn
    //   101: aconst_null
    //   102: astore 4
    //   104: goto -58 -> 46
    //   107: astore 4
    //   109: aload 7
    //   111: invokevirtual 57	android/os/Parcel:recycle	()V
    //   114: aload 6
    //   116: invokevirtual 57	android/os/Parcel:recycle	()V
    //   119: aload 4
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	a
    //   0	122	1	paramLong	long
    //   0	122	3	paramInt	int
    //   0	122	4	paramk	k
    //   1	98	5	bool	boolean
    //   6	109	6	localParcel1	Parcel
    //   11	99	7	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	32	107	finally
    //   37	46	107	finally
    //   46	81	107	finally
  }
  
  /* Error */
  public final boolean b(long paramLong, byte[] paramArrayOfByte, t paramt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 7
    //   8: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 8
    //   13: aload 7
    //   15: ldc 28
    //   17: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload 7
    //   22: lload_1
    //   23: invokevirtual 66	android/os/Parcel:writeLong	(J)V
    //   26: aload 7
    //   28: aload_3
    //   29: invokevirtual 107	android/os/Parcel:writeByteArray	([B)V
    //   32: aload 4
    //   34: ifnull +67 -> 101
    //   37: aload 4
    //   39: invokeinterface 110 1 0
    //   44: astore_3
    //   45: aload 7
    //   47: aload_3
    //   48: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   51: aload_0
    //   52: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
    //   55: bipush 19
    //   57: aload 7
    //   59: aload 8
    //   61: iconst_0
    //   62: invokeinterface 47 5 0
    //   67: pop
    //   68: aload 8
    //   70: invokevirtual 50	android/os/Parcel:readException	()V
    //   73: aload 8
    //   75: invokevirtual 77	android/os/Parcel:readInt	()I
    //   78: istore 5
    //   80: iload 5
    //   82: ifeq +6 -> 88
    //   85: iconst_1
    //   86: istore 6
    //   88: aload 8
    //   90: invokevirtual 57	android/os/Parcel:recycle	()V
    //   93: aload 7
    //   95: invokevirtual 57	android/os/Parcel:recycle	()V
    //   98: iload 6
    //   100: ireturn
    //   101: aconst_null
    //   102: astore_3
    //   103: goto -58 -> 45
    //   106: astore_3
    //   107: aload 8
    //   109: invokevirtual 57	android/os/Parcel:recycle	()V
    //   112: aload 7
    //   114: invokevirtual 57	android/os/Parcel:recycle	()V
    //   117: aload_3
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	a
    //   0	119	1	paramLong	long
    //   0	119	3	paramArrayOfByte	byte[]
    //   0	119	4	paramt	t
    //   78	3	5	i	int
    //   1	98	6	bool	boolean
    //   6	107	7	localParcel1	Parcel
    //   11	97	8	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	32	106	finally
    //   37	45	106	finally
    //   45	80	106	finally
  }
  
  /* Error */
  public final boolean b(i parami)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 28
    //   16: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: ifnull +62 -> 82
    //   23: aload_1
    //   24: invokeinterface 81 1 0
    //   29: astore_1
    //   30: aload 4
    //   32: aload_1
    //   33: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_0
    //   37: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
    //   40: bipush 10
    //   42: aload 4
    //   44: aload 5
    //   46: iconst_0
    //   47: invokeinterface 47 5 0
    //   52: pop
    //   53: aload 5
    //   55: invokevirtual 50	android/os/Parcel:readException	()V
    //   58: aload 5
    //   60: invokevirtual 77	android/os/Parcel:readInt	()I
    //   63: istore_2
    //   64: iload_2
    //   65: ifeq +5 -> 70
    //   68: iconst_1
    //   69: istore_3
    //   70: aload 5
    //   72: invokevirtual 57	android/os/Parcel:recycle	()V
    //   75: aload 4
    //   77: invokevirtual 57	android/os/Parcel:recycle	()V
    //   80: iload_3
    //   81: ireturn
    //   82: aconst_null
    //   83: astore_1
    //   84: goto -54 -> 30
    //   87: astore_1
    //   88: aload 5
    //   90: invokevirtual 57	android/os/Parcel:recycle	()V
    //   93: aload 4
    //   95: invokevirtual 57	android/os/Parcel:recycle	()V
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	a
    //   0	100	1	parami	i
    //   63	2	2	i	int
    //   1	80	3	bool	boolean
    //   5	89	4	localParcel1	Parcel
    //   10	79	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   12	19	87	finally
    //   23	30	87	finally
    //   30	64	87	finally
  }
  
  /* Error */
  public final boolean c(int paramInt, j paramj)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 28
    //   16: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload 4
    //   21: iload_1
    //   22: invokevirtual 70	android/os/Parcel:writeInt	(I)V
    //   25: aload_2
    //   26: ifnull +61 -> 87
    //   29: aload_2
    //   30: invokeinterface 102 1 0
    //   35: astore_2
    //   36: aload 4
    //   38: aload_2
    //   39: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   42: aload_0
    //   43: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
    //   46: iconst_2
    //   47: aload 4
    //   49: aload 5
    //   51: iconst_0
    //   52: invokeinterface 47 5 0
    //   57: pop
    //   58: aload 5
    //   60: invokevirtual 50	android/os/Parcel:readException	()V
    //   63: aload 5
    //   65: invokevirtual 77	android/os/Parcel:readInt	()I
    //   68: istore_1
    //   69: iload_1
    //   70: ifeq +5 -> 75
    //   73: iconst_1
    //   74: istore_3
    //   75: aload 5
    //   77: invokevirtual 57	android/os/Parcel:recycle	()V
    //   80: aload 4
    //   82: invokevirtual 57	android/os/Parcel:recycle	()V
    //   85: iload_3
    //   86: ireturn
    //   87: aconst_null
    //   88: astore_2
    //   89: goto -53 -> 36
    //   92: astore_2
    //   93: aload 5
    //   95: invokevirtual 57	android/os/Parcel:recycle	()V
    //   98: aload 4
    //   100: invokevirtual 57	android/os/Parcel:recycle	()V
    //   103: aload_2
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	a
    //   0	105	1	paramInt	int
    //   0	105	2	paramj	j
    //   1	85	3	bool	boolean
    //   5	94	4	localParcel1	Parcel
    //   10	84	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   12	25	92	finally
    //   29	36	92	finally
    //   36	69	92	finally
  }
  
  /* Error */
  public final boolean d(int paramInt, j paramj)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 28
    //   16: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload 4
    //   21: iload_1
    //   22: invokevirtual 70	android/os/Parcel:writeInt	(I)V
    //   25: aload_2
    //   26: ifnull +62 -> 88
    //   29: aload_2
    //   30: invokeinterface 102 1 0
    //   35: astore_2
    //   36: aload 4
    //   38: aload_2
    //   39: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   42: aload_0
    //   43: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
    //   46: bipush 14
    //   48: aload 4
    //   50: aload 5
    //   52: iconst_0
    //   53: invokeinterface 47 5 0
    //   58: pop
    //   59: aload 5
    //   61: invokevirtual 50	android/os/Parcel:readException	()V
    //   64: aload 5
    //   66: invokevirtual 77	android/os/Parcel:readInt	()I
    //   69: istore_1
    //   70: iload_1
    //   71: ifeq +5 -> 76
    //   74: iconst_1
    //   75: istore_3
    //   76: aload 5
    //   78: invokevirtual 57	android/os/Parcel:recycle	()V
    //   81: aload 4
    //   83: invokevirtual 57	android/os/Parcel:recycle	()V
    //   86: iload_3
    //   87: ireturn
    //   88: aconst_null
    //   89: astore_2
    //   90: goto -54 -> 36
    //   93: astore_2
    //   94: aload 5
    //   96: invokevirtual 57	android/os/Parcel:recycle	()V
    //   99: aload 4
    //   101: invokevirtual 57	android/os/Parcel:recycle	()V
    //   104: aload_2
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	a
    //   0	106	1	paramInt	int
    //   0	106	2	paramj	j
    //   1	86	3	bool	boolean
    //   5	95	4	localParcel1	Parcel
    //   10	85	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   12	25	93	finally
    //   29	36	93	finally
    //   36	70	93	finally
  }
  
  public final boolean dZ(long paramLong)
  {
    boolean bool = false;
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
    }
  }
  
  /* Error */
  public final boolean e(int paramInt, j paramj)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 28
    //   16: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload 4
    //   21: iload_1
    //   22: invokevirtual 70	android/os/Parcel:writeInt	(I)V
    //   25: aload_2
    //   26: ifnull +62 -> 88
    //   29: aload_2
    //   30: invokeinterface 102 1 0
    //   35: astore_2
    //   36: aload 4
    //   38: aload_2
    //   39: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   42: aload_0
    //   43: getfield 18	com/tencent/mm/plugin/exdevice/service/h$a$a:mRemote	Landroid/os/IBinder;
    //   46: bipush 15
    //   48: aload 4
    //   50: aload 5
    //   52: iconst_0
    //   53: invokeinterface 47 5 0
    //   58: pop
    //   59: aload 5
    //   61: invokevirtual 50	android/os/Parcel:readException	()V
    //   64: aload 5
    //   66: invokevirtual 77	android/os/Parcel:readInt	()I
    //   69: istore_1
    //   70: iload_1
    //   71: ifeq +5 -> 76
    //   74: iconst_1
    //   75: istore_3
    //   76: aload 5
    //   78: invokevirtual 57	android/os/Parcel:recycle	()V
    //   81: aload 4
    //   83: invokevirtual 57	android/os/Parcel:recycle	()V
    //   86: iload_3
    //   87: ireturn
    //   88: aconst_null
    //   89: astore_2
    //   90: goto -54 -> 36
    //   93: astore_2
    //   94: aload 5
    //   96: invokevirtual 57	android/os/Parcel:recycle	()V
    //   99: aload 4
    //   101: invokevirtual 57	android/os/Parcel:recycle	()V
    //   104: aload_2
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	a
    //   0	106	1	paramInt	int
    //   0	106	2	paramj	j
    //   1	86	3	bool	boolean
    //   5	95	4	localParcel1	Parcel
    //   10	85	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   12	25	93	finally
    //   29	36	93	finally
    //   36	70	93	finally
  }
  
  public final boolean ea(long paramLong)
  {
    boolean bool = false;
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
    }
  }
  
  public final boolean eb(long paramLong)
  {
    boolean bool = false;
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
    }
  }
  
  public final boolean ec(long paramLong)
  {
    boolean bool = false;
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
    }
  }
  
  public final void setChannelSessionKey(long paramLong, byte[] paramArrayOfByte)
  {
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.h.a.a
 * JD-Core Version:    0.7.0.1
 */