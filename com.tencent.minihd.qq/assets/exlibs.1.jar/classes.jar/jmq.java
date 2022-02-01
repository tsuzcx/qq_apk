import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profile.ProfileCardWebviewPlugin;
import com.tencent.mobileqq.profile.VipProfileCardDownLoadInfo;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class jmq
  implements Runnable
{
  public jmq(ProfileCardWebviewPlugin paramProfileCardWebviewPlugin, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.b.set(1);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.mRuntime.a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.mRuntime.a();
    if ((localObject1 == null) || (localObject2 == null)) {}
    int i;
    do
    {
      return;
      Object localObject3 = ((Activity)localObject2).getApplicationContext();
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) != null) && (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g != VipProfileCardDownLoadInfo.d)) {
        ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g = VipProfileCardDownLoadInfo.jdField_b_of_type_JavaLangInteger;
      }
      localObject2 = new jmr(this);
      localObject3 = new File(ProfileCardUtil.c((Context)localObject3) + ProfileCardUtil.e(this.jdField_a_of_type_JavaLangString));
      localObject3 = new DownloadTask(this.jdField_a_of_type_JavaLangString, (File)localObject3);
      ((DownloadTask)localObject3).e = "profileCardDownload";
      ((DownloadTask)localObject3).d = "VIP_profilecard";
      ((DownloadTask)localObject3).a = 1;
      ((DownloadTask)localObject3).a((DownloadListener)localObject2);
      ProfileCardWebviewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin);
      i = DownloaderFactory.a((DownloadTask)localObject3, (AppInterface)localObject1);
      ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).f = Integer.valueOf(i);
    } while (i == 0);
    ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g = VipProfileCardDownLoadInfo.c;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.b.set(0);
    localObject1 = ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_b_of_type_JavaLangString;
    localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("result", i);
      ((JSONObject)localObject2).put("message", "httperr");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.a((String)localObject1, ((JSONObject)localObject2).toString());
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jmq
 * JD-Core Version:    0.7.0.1
 */