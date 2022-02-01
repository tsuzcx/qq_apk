import android.os.Bundle;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class dzm
  implements BusinessObserver
{
  public dzm(ForwardOperations paramForwardOperations) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    synchronized (ForwardOperations.jdField_a_of_type_JavaLangObject)
    {
      this.a.e = false;
      if (paramBoolean) {}
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
          localGetAppinfoResponse.mergeFrom(paramBundle);
          this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse = localGetAppinfoResponse;
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOperations", 2, "get appinfo time = " + (System.currentTimeMillis() - this.a.b));
          }
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOperations", 2, paramBundle.getMessage());
          }
        }
      }
      ForwardOperations.jdField_a_of_type_JavaLangObject.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     dzm
 * JD-Core Version:    0.7.0.1
 */