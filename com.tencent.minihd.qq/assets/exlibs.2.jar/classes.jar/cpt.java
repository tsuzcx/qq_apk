import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.OfflineUpdateStatus;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class cpt
  extends Handler
{
  public cpt(OfflinePlugin paramOfflinePlugin) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.jdField_a_of_type_Boolean) {}
    label32:
    label379:
    do
    {
      do
      {
        do
        {
          return;
          Object localObject1;
          switch (paramMessage.what)
          {
          default: 
            if (paramMessage.arg1 == 1)
            {
              this.a.c = paramMessage.arg2;
              localObject1 = (String)paramMessage.obj;
              this.a.mRuntime.a().a((String)localObject1);
              this.a.mRuntime.a().requestFocus();
              if (QLog.isColorLevel()) {
                QLog.i(OfflinePlugin.a(this.a), 2, "mCheckupHandler loadUrl start");
              }
              this.a.a((String)localObject1);
            }
            break;
          }
          for (;;)
          {
            for (;;)
            {
              Object localObject3 = this.a.mRuntime.a();
              if ((localObject3 == null) || (!(localObject3 instanceof QQBrowserActivity))) {
                break;
              }
              if (paramMessage.arg1 != 4) {
                break label379;
              }
              if ((OfflinePlugin.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(OfflinePlugin.b(this.a)))) {
                break;
              }
              localObject1 = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.b(this.a));
              this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramMessage.arg2);
              this.a.jdField_a_of_type_AndroidWidgetTextView.setText(((OfflineUpdateStatus)localObject1).e + paramMessage.arg2 + "%");
              return;
              try
              {
                for (;;)
                {
                  localObject3 = (Object[])paramMessage.obj;
                  localObject1 = (JsBridgeListener)localObject3[0];
                  try
                  {
                    localObject3 = (String)localObject3[1];
                    ((JsBridgeListener)localObject1).a(" { retcode: 0, data: " + Util.b((String)localObject3) + " }");
                  }
                  catch (Exception localException3) {}
                }
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  OfflineUpdateStatus localOfflineUpdateStatus;
                  Object localObject2 = null;
                }
              }
            }
            if (localObject1 == null) {
              break label32;
            }
            ((JsBridgeListener)localObject1).a(" { retcode: -1, msg: 'error' }");
            break label32;
            if (paramMessage.arg1 == 2)
            {
              if (QLog.isDevelopLevel()) {
                QLog.i(OfflinePlugin.a(this.a), 4, "checkOfflineUpBack refresh current url");
              }
              this.a.b();
            }
            else if (paramMessage.arg1 == 3)
            {
              try
              {
                localObject1 = (JSONObject)paramMessage.obj;
                OfflinePlugin.a(this.a, (JSONObject)localObject1);
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
              }
            }
          }
        } while ((paramMessage.arg1 != 5) || (OfflinePlugin.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(OfflinePlugin.b(this.a))));
        localOfflineUpdateStatus = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.b(this.a));
      } while (localOfflineUpdateStatus == null);
      if (paramMessage.arg2 != 0) {
        break;
      }
      localOfflineUpdateStatus.b(3);
    } while (localException3 == null);
    paramMessage = localException3.getResources().getDrawable(2130838112);
    paramMessage.setBounds(0, 0, 40, 40);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramMessage, null, null, null);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(localOfflineUpdateStatus.d);
    this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    return;
    if ((paramMessage.arg2 == 5) || (paramMessage.arg2 == 7))
    {
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localOfflineUpdateStatus.b(4);
      return;
    }
    QRUtils.a(1, 2131363744);
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    localOfflineUpdateStatus.b(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cpt
 * JD-Core Version:    0.7.0.1
 */