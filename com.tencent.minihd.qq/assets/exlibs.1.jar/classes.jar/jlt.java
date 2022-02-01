import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mobileqq.pic.IPresendPicMgr;
import java.util.List;

public class jlt
  implements IPresendPicMgr
{
  private IBinder a;
  
  public jlt(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public String a()
  {
    return "com.tencent.mobileqq.pic.IPresendPicMgr";
  }
  
  public List a(List paramList)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPresendPicMgr");
      localParcel1.writeStringList(paramList);
      this.a.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramList = localParcel2.createStringArrayList();
      return paramList;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPresendPicMgr");
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPresendPicMgr");
      localParcel1.writeString(paramString);
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 5
    //   8: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 6
    //   13: aload 5
    //   15: ldc 19
    //   17: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload 5
    //   22: aload_1
    //   23: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   26: aload 5
    //   28: aload_2
    //   29: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   32: iload_3
    //   33: ifeq +42 -> 75
    //   36: aload 5
    //   38: iload 4
    //   40: invokevirtual 58	android/os/Parcel:writeInt	(I)V
    //   43: aload_0
    //   44: getfield 15	jlt:a	Landroid/os/IBinder;
    //   47: iconst_1
    //   48: aload 5
    //   50: aload 6
    //   52: iconst_0
    //   53: invokeinterface 40 5 0
    //   58: pop
    //   59: aload 6
    //   61: invokevirtual 43	android/os/Parcel:readException	()V
    //   64: aload 6
    //   66: invokevirtual 50	android/os/Parcel:recycle	()V
    //   69: aload 5
    //   71: invokevirtual 50	android/os/Parcel:recycle	()V
    //   74: return
    //   75: iconst_0
    //   76: istore 4
    //   78: goto -42 -> 36
    //   81: astore_1
    //   82: aload 6
    //   84: invokevirtual 50	android/os/Parcel:recycle	()V
    //   87: aload 5
    //   89: invokevirtual 50	android/os/Parcel:recycle	()V
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	jlt
    //   0	94	1	paramString1	String
    //   0	94	2	paramString2	String
    //   0	94	3	paramBoolean	boolean
    //   1	76	4	i	int
    //   6	82	5	localParcel1	Parcel
    //   11	72	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	32	81	finally
    //   36	64	81	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPresendPicMgr");
      this.a.transact(4, localParcel1, localParcel2, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jlt
 * JD-Core Version:    0.7.0.1
 */