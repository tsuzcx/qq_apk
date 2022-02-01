import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;

public class fzd
  implements ICompressionCallBack
{
  private IBinder a;
  
  public fzd(IBinder paramIBinder)
  {
    this.jdField_a_of_type_AndroidOsIBinder = paramIBinder;
  }
  
  public String a()
  {
    return "com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack";
  }
  
  public void a(CompressInfo paramCompressInfo)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
      localParcel.writeParcelable(paramCompressInfo, 1);
      this.jdField_a_of_type_AndroidOsIBinder.transact(1, localParcel, null, 1);
      return;
    }
    catch (RemoteException paramCompressInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, paramCompressInfo.getMessage(), paramCompressInfo);
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
    return this.jdField_a_of_type_AndroidOsIBinder;
  }
  
  public void b(CompressInfo paramCompressInfo)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
      localParcel.writeParcelable(paramCompressInfo, 1);
      this.jdField_a_of_type_AndroidOsIBinder.transact(2, localParcel, null, 1);
      return;
    }
    catch (RemoteException paramCompressInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, paramCompressInfo.getMessage(), paramCompressInfo);
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void c(CompressInfo paramCompressInfo)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
      localParcel.writeParcelable(paramCompressInfo, 1);
      this.jdField_a_of_type_AndroidOsIBinder.transact(3, localParcel, null, 1);
      return;
    }
    catch (RemoteException paramCompressInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, paramCompressInfo.getMessage(), paramCompressInfo);
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
 * Qualified Name:     fzd
 * JD-Core Version:    0.7.0.1
 */