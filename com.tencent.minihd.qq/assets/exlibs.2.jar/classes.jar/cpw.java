import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.util.OfflineUpdateStatus;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import java.util.HashMap;

public class cpw
  implements View.OnClickListener
{
  public cpw(OfflinePlugin paramOfflinePlugin) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.mRuntime.a();
    if (paramView == null) {}
    OfflineUpdateStatus localOfflineUpdateStatus;
    do
    {
      do
      {
        do
        {
          return;
        } while ((OfflinePlugin.jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty(OfflinePlugin.b(this.a))));
        localOfflineUpdateStatus = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.b(this.a));
      } while (localOfflineUpdateStatus == null);
      if (localOfflineUpdateStatus.b() == 3)
      {
        localOfflineUpdateStatus.a();
        this.a.a();
        localOfflineUpdateStatus.b(4);
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.remove(OfflinePlugin.b(this.a));
        return;
      }
    } while (localOfflineUpdateStatus.b() != 0);
    HtmlOffline.a(paramView.getApplicationContext(), OfflinePlugin.b(this.a), localOfflineUpdateStatus.jdField_f_of_type_JavaLangString, localOfflineUpdateStatus.jdField_f_of_type_Int, localOfflineUpdateStatus);
    localOfflineUpdateStatus.b(1);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(OfflinePlugin.a(this.a), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cpw
 * JD-Core Version:    0.7.0.1
 */