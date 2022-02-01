import android.os.Bundle;
import com.tencent.biz.webviewplugin.SosoPlugin;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.websafe.WebSafe.CheckURLResp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import mqq.observer.BusinessObserver;

public class cqs
  implements BusinessObserver
{
  public cqs(SosoPlugin paramSosoPlugin, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        WebSafe.CheckURLResp localCheckURLResp = new WebSafe.CheckURLResp();
        try
        {
          localCheckURLResp.mergeFrom(paramBundle);
          if ((localCheckURLResp.retcode.has()) && (localCheckURLResp.retcode.get() == 0) && (localCheckURLResp.result.has()))
          {
            paramInt = localCheckURLResp.result.get();
            if (paramInt == 0) {
              if (QLog.isColorLevel()) {
                QLog.d(SosoPlugin.d(this.jdField_a_of_type_ComTencentBizWebviewpluginSosoPlugin), 2, "SSO, SafeSvr.check_url, result = 0, means safe");
              }
            }
            for (;;)
            {
              SosoPlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginSosoPlugin, true);
              return;
              if (paramInt == 2)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(SosoPlugin.e(this.jdField_a_of_type_ComTencentBizWebviewpluginSosoPlugin), 2, "SSO, SafeSvr.check_url, result = 2, means not safe");
                }
                this.jdField_a_of_type_ComTencentBizWebviewpluginSosoPlugin.a.loadUrl("https://pub.idqqimg.com/qqmobile/client/android/forbidden.html?url=" + this.jdField_a_of_type_JavaLangString);
              }
            }
          }
          return;
        }
        catch (InvalidProtocolBufferMicroException paramBundle)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d(SosoPlugin.f(this.jdField_a_of_type_ComTencentBizWebviewpluginSosoPlugin), 4, "SSO, SafeSvr.check_url, InvalidProtocolBufferMicroException: " + paramBundle);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cqs
 * JD-Core Version:    0.7.0.1
 */