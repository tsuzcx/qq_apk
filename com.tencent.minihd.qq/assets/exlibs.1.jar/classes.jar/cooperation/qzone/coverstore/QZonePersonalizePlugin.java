package cooperation.qzone.coverstore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mbp;

public class QZonePersonalizePlugin
  extends WebViewPlugin
{
  public static final String a;
  public static final String b = "QZoneCardLogic";
  private BroadcastReceiver a;
  
  static
  {
    jdField_a_of_type_JavaLangString = QZonePersonalizePlugin.class.getSimpleName();
  }
  
  public QZonePersonalizePlugin()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new mbp(this);
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("QZoneCardPreDownload");
    localIntentFilter.addAction("action_facade_qzone2js");
    BaseApplication.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public void b()
  {
    BaseApplication.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleJsRequest \n url: " + paramString1 + "\n pkgName:" + paramString2 + "\n method:" + paramString3);
    }
    if (paramString2.equals("qzcardstorre"))
    {
      if (paramString3.equals("setcard")) {
        QZoneCardJsHandleLogic.b(this.mRuntime, paramVarArgs);
      }
      while (paramString3.equals("closecardpreview")) {
        return true;
      }
      if (paramString3.equals("setcardfinish")) {
        QZoneCardJsHandleLogic.a(this.mRuntime, paramVarArgs);
      }
      if (paramString3.equals("downloadcard"))
      {
        QZoneCardJsHandleLogic.c(this.mRuntime, paramVarArgs);
        return true;
      }
    }
    else
    {
      if (!paramString2.equals("QzAvatar")) {
        break label193;
      }
      if (!paramString3.equals("downloadAvatar")) {
        break label157;
      }
      QZoneFacadeJsHandleLogic.a(paramVarArgs);
    }
    label157:
    label193:
    do
    {
      do
      {
        for (;;)
        {
          return false;
          if (paramString3.equals("setAvatar")) {
            QZoneFacadeJsHandleLogic.a(this.mRuntime);
          } else if (paramString3.equals("openVip")) {
            QZoneFacadeJsHandleLogic.a();
          }
        }
      } while (!paramString2.equals("Qzone"));
      if (paramString3.equals("OpenPersonalize"))
      {
        QZonePersonalizeJsHandleLogic.a(this.mRuntime, paramVarArgs);
        return true;
      }
    } while (!paramString3.equals("CleanZebraNum"));
    QZoneZebraAlbumJsHandleLogic.a(this.mRuntime, paramVarArgs);
    return true;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.coverstore.QZonePersonalizePlugin
 * JD-Core Version:    0.7.0.1
 */