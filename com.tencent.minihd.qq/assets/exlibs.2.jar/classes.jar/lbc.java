import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import mqq.observer.BusinessObserver;

public class lbc
  implements BusinessObserver
{
  public lbc(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("ssoAccount");
    if (!this.a.app.a().equals(localObject)) {}
    for (;;)
    {
      return;
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      if (paramBoolean)
      {
        localObject = new GetAppInfoProto.GetAppinfoResponse();
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle != null)
          {
            ((GetAppInfoProto.GetAppinfoResponse)localObject).mergeFrom(paramBundle);
            if ((((GetAppInfoProto.GetAppinfoResponse)localObject).has()) && (((GetAppInfoProto.GetAppinfoResponse)localObject).ret.get() == 0))
            {
              paramBundle = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
              paramBundle.what = 3;
              paramBundle.obj = localObject;
              this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramBundle);
              return;
            }
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lbc
 * JD-Core Version:    0.7.0.1
 */