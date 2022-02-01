import android.os.RemoteException;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.IPresendPicMgr;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class jmd
{
  public CompressInfo a;
  public String a;
  public boolean a;
  public boolean b = false;
  
  public jmd(PresendPicMgr paramPresendPicMgr, CompressInfo paramCompressInfo)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = a();
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo = paramCompressInfo;
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public String a()
  {
    return "__" + UUID.randomUUID().toString();
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        Logger.a("PresendPicMgr", "PresendReq.cancel", "current PresendReq is " + this);
        this.jdField_a_of_type_Boolean = true;
        boolean bool = this.b;
        if (bool) {
          try
          {
            Logger.a("PresendPicMgr", "PresendReq.cancel", "call cancelUpload");
            PresendPicMgr.a(this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr).a(this.jdField_a_of_type_JavaLangString);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
            continue;
          }
        }
        Logger.a("PresendPicMgr", "PresendReq.cancel", "mIsUpload is false,no need to call cancelUpload");
      }
      finally {}
    }
  }
  
  public void b()
  {
    Logger.a("PresendPicMgr", "PresendReq.compressPic", "current PresendReq is " + this);
    if (this.jdField_a_of_type_Boolean)
    {
      Logger.a("PresendPicMgr", "PresendStatus", "srcPah:" + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c + ",destPath:" + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + " ,canceled:true, peakCompress:false, peakUpload:false");
      return;
    }
    CompressOperator.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
    Logger.a("PresendPicMgr", "PresendStatus", "srcPah:" + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c + ",destPath:" + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false,peakCompress:true,peakUpload:false");
    Logger.a("PresendPicMgr", "PresendReq.compressPic", "call end,current PresendReq is " + this);
  }
  
  public void c()
  {
    try
    {
      Logger.a("PresendPicMgr", "PresendReq.uploadPic", "current PresendReq is " + this);
      if (this.jdField_a_of_type_Boolean) {
        Logger.a("PresendPicMgr", "PresendStatus", "srcPah:" + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c + ",destPath:" + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + " ,canceled:true, peakCompress:true, peakUpload:false");
      }
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString == null)
        {
          Logger.b("PresendPicMgr", "PresendReq.uploadPic", "mCompressInfo.destPath == null! ");
          continue;
        }
        try
        {
          PresendPicMgr.a(this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr).a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_Boolean);
          this.b = true;
          Logger.a("PresendPicMgr", "PresendStatus", "srcPah:" + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c + ",destPath:" + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + " ,canceled:false, peakCompress:true, peakUpload:true");
          Logger.a("PresendPicMgr", "PresendReq.uploadPic", "call end");
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
            }
          }
        }
      }
    }
    finally {}
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPresendReq");
    localStringBuilder.append("\n|-").append("localUUID:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n|-").append("mIsCancel:").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("\n|-").append("mIsUpload:").append(this.b);
    localStringBuilder.append("\n|-").append("mCompressInfo:").append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jmd
 * JD-Core Version:    0.7.0.1
 */