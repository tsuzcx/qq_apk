import android.os.IBinder;
import android.os.Parcel;
import com.tencent.qav.ipc.IQavCallback;

public class ljd
  implements IQavCallback
{
  private IBinder a;
  
  public ljd(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public android.graphics.Bitmap a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 25
    //   12: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: iload_1
    //   17: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   20: aload_3
    //   21: aload_2
    //   22: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 15	ljd:a	Landroid/os/IBinder;
    //   29: iconst_2
    //   30: aload_3
    //   31: aload 4
    //   33: iconst_0
    //   34: invokeinterface 42 5 0
    //   39: pop
    //   40: aload 4
    //   42: invokevirtual 45	android/os/Parcel:readException	()V
    //   45: aload 4
    //   47: invokevirtual 49	android/os/Parcel:readInt	()I
    //   50: ifeq +28 -> 78
    //   53: getstatic 55	android/graphics/Bitmap:CREATOR	Landroid/os/Parcelable$Creator;
    //   56: aload 4
    //   58: invokeinterface 61 2 0
    //   63: checkcast 51	android/graphics/Bitmap
    //   66: astore_2
    //   67: aload 4
    //   69: invokevirtual 64	android/os/Parcel:recycle	()V
    //   72: aload_3
    //   73: invokevirtual 64	android/os/Parcel:recycle	()V
    //   76: aload_2
    //   77: areturn
    //   78: aconst_null
    //   79: astore_2
    //   80: goto -13 -> 67
    //   83: astore_2
    //   84: aload 4
    //   86: invokevirtual 64	android/os/Parcel:recycle	()V
    //   89: aload_3
    //   90: invokevirtual 64	android/os/Parcel:recycle	()V
    //   93: aload_2
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	ljd
    //   0	95	1	paramInt	int
    //   0	95	2	paramString	String
    //   3	87	3	localParcel1	Parcel
    //   7	78	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	67	83	finally
  }
  
  public String a()
  {
    return "com.tencent.qav.ipc.IQavCallback";
  }
  
  public String a(int paramInt, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qav.ipc.IQavCallback");
      localParcel1.writeInt(paramInt);
      localParcel1.writeString(paramString);
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void a(com.tencent.qav.ipc.QavMsgRecord paramQavMsgRecord)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 76	com/tencent/qav/ipc/QavMsgRecord:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	ljd:a	Landroid/os/IBinder;
    //   33: bipush 6
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 42 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 45	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 64	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 64	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 64	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 64	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	ljd
    //   0	76	1	paramQavMsgRecord	com.tencent.qav.ipc.QavMsgRecord
    //   3	68	2	localParcel1	Parcel
    //   7	60	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	65	finally
    //   18	29	65	finally
    //   29	48	65	finally
    //   57	62	65	finally
  }
  
  /* Error */
  public void a(com.tencent.qav.ipc.QavState paramQavState)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +41 -> 56
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 80	com/tencent/qav/ipc/QavState:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	ljd:a	Landroid/os/IBinder;
    //   33: iconst_3
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 42 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 45	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 64	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 64	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 64	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 64	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	ljd
    //   0	75	1	paramQavState	com.tencent.qav.ipc.QavState
    //   3	67	2	localParcel1	Parcel
    //   7	59	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	64	finally
    //   18	29	64	finally
    //   29	47	64	finally
    //   56	61	64	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  /* Error */
  public void b(com.tencent.qav.ipc.QavState paramQavState)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +41 -> 56
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 80	com/tencent/qav/ipc/QavState:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	ljd:a	Landroid/os/IBinder;
    //   33: iconst_4
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 42 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 45	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 64	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 64	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 64	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 64	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	ljd
    //   0	75	1	paramQavState	com.tencent.qav.ipc.QavState
    //   3	67	2	localParcel1	Parcel
    //   7	59	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	64	finally
    //   18	29	64	finally
    //   29	47	64	finally
    //   56	61	64	finally
  }
  
  /* Error */
  public void c(com.tencent.qav.ipc.QavState paramQavState)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +41 -> 56
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 80	com/tencent/qav/ipc/QavState:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	ljd:a	Landroid/os/IBinder;
    //   33: iconst_5
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 42 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 45	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 64	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 64	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 64	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 64	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	ljd
    //   0	75	1	paramQavState	com.tencent.qav.ipc.QavState
    //   3	67	2	localParcel1	Parcel
    //   7	59	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	64	finally
    //   18	29	64	finally
    //   29	47	64	finally
    //   56	61	64	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ljd
 * JD-Core Version:    0.7.0.1
 */