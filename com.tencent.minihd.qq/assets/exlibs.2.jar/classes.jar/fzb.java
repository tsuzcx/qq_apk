import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.qphone.base.util.QLog;

public class fzb
  implements IAIOImageProvider
{
  private IBinder a;
  
  public fzb(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public android.content.Intent a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 6
    //   10: aload 5
    //   12: ldc 27
    //   14: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 5
    //   19: lload_1
    //   20: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   23: aload 5
    //   25: iload_3
    //   26: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   29: aload_0
    //   30: getfield 15	fzb:a	Landroid/os/IBinder;
    //   33: iconst_5
    //   34: aload 5
    //   36: aload 6
    //   38: iconst_0
    //   39: invokeinterface 45 5 0
    //   44: pop
    //   45: aload 6
    //   47: invokevirtual 48	android/os/Parcel:readException	()V
    //   50: aload 6
    //   52: invokevirtual 52	android/os/Parcel:readInt	()I
    //   55: ifeq +31 -> 86
    //   58: getstatic 58	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
    //   61: aload 6
    //   63: invokeinterface 64 2 0
    //   68: checkcast 54	android/content/Intent
    //   71: astore 4
    //   73: aload 6
    //   75: invokevirtual 67	android/os/Parcel:recycle	()V
    //   78: aload 5
    //   80: invokevirtual 67	android/os/Parcel:recycle	()V
    //   83: aload 4
    //   85: areturn
    //   86: aconst_null
    //   87: astore 4
    //   89: goto -16 -> 73
    //   92: astore 4
    //   94: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +16 -> 113
    //   100: ldc 75
    //   102: iconst_2
    //   103: aload 4
    //   105: invokevirtual 79	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   108: aload 4
    //   110: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload 6
    //   115: invokevirtual 67	android/os/Parcel:recycle	()V
    //   118: aload 5
    //   120: invokevirtual 67	android/os/Parcel:recycle	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore 4
    //   127: aload 6
    //   129: invokevirtual 67	android/os/Parcel:recycle	()V
    //   132: aload 5
    //   134: invokevirtual 67	android/os/Parcel:recycle	()V
    //   137: aload 4
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	fzb
    //   0	140	1	paramLong	long
    //   0	140	3	paramInt	int
    //   71	17	4	localIntent	android.content.Intent
    //   92	17	4	localException	java.lang.Exception
    //   125	13	4	localObject	Object
    //   3	130	5	localParcel1	Parcel
    //   8	120	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	73	92	java/lang/Exception
    //   10	73	125	finally
    //   94	113	125	finally
  }
  
  public String a()
  {
    return "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider";
  }
  
  public void a()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      this.a.transact(6, localParcel, null, 1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProvider", 2, localRemoteException.getMessage(), localRemoteException);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      localParcel.writeLong(paramLong);
      localParcel.writeInt(paramInt);
      this.a.transact(7, localParcel, null, 1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProvider", 2, localRemoteException.getMessage(), localRemoteException);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    a(paramLong, paramInt1, paramInt2, false);
  }
  
  /* Error */
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 7
    //   8: aload 7
    //   10: ldc 27
    //   12: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload 7
    //   17: lload_1
    //   18: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   21: aload 7
    //   23: iload_3
    //   24: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   27: aload 7
    //   29: iload 4
    //   31: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   34: iload 5
    //   36: ifeq +31 -> 67
    //   39: aload 7
    //   41: iload 6
    //   43: invokevirtual 95	android/os/Parcel:writeByte	(B)V
    //   46: aload_0
    //   47: getfield 15	fzb:a	Landroid/os/IBinder;
    //   50: iconst_1
    //   51: aload 7
    //   53: aconst_null
    //   54: iconst_1
    //   55: invokeinterface 45 5 0
    //   60: pop
    //   61: aload 7
    //   63: invokevirtual 67	android/os/Parcel:recycle	()V
    //   66: return
    //   67: iconst_0
    //   68: istore 6
    //   70: goto -31 -> 39
    //   73: astore 8
    //   75: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +16 -> 94
    //   81: ldc 75
    //   83: iconst_2
    //   84: aload 8
    //   86: invokevirtual 86	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   89: aload 8
    //   91: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   94: aload 7
    //   96: invokevirtual 67	android/os/Parcel:recycle	()V
    //   99: return
    //   100: astore 8
    //   102: aload 7
    //   104: invokevirtual 67	android/os/Parcel:recycle	()V
    //   107: aload 8
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	fzb
    //   0	110	1	paramLong	long
    //   0	110	3	paramInt1	int
    //   0	110	4	paramInt2	int
    //   0	110	5	paramBoolean	boolean
    //   1	68	6	b	byte
    //   6	97	7	localParcel	Parcel
    //   73	17	8	localRemoteException	RemoteException
    //   100	8	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	34	73	android/os/RemoteException
    //   39	61	73	android/os/RemoteException
    //   8	34	100	finally
    //   39	61	100	finally
    //   75	94	100	finally
  }
  
  public void a(IAIOImageProviderCallBack paramIAIOImageProviderCallBack)
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      if (paramIAIOImageProviderCallBack != null) {
        localIBinder = paramIAIOImageProviderCallBack.asBinder();
      }
      localParcel.writeStrongBinder(localIBinder);
      this.a.transact(4, localParcel, null, 1);
      return;
    }
    catch (RemoteException paramIAIOImageProviderCallBack)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProvider", 2, paramIAIOImageProviderCallBack.getMessage(), paramIAIOImageProviderCallBack);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      localParcel.writeString(paramString);
      localParcel.writeInt(paramInt);
      this.a.transact(8, localParcel, null, 1);
      return;
    }
    catch (RemoteException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProvider", 2, paramString.getMessage(), paramString);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void b()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      this.a.transact(3, localParcel, null, 1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProvider", 2, localRemoteException.getMessage(), localRemoteException);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      localParcel.writeLong(paramLong);
      localParcel.writeInt(paramInt1);
      localParcel.writeInt(paramInt2);
      this.a.transact(2, localParcel, null, 1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IAIOImageProvider", 2, localRemoteException.getMessage(), localRemoteException);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fzb
 * JD-Core Version:    0.7.0.1
 */