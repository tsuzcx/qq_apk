import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.jsp.DataApiPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import java.io.IOException;

public class jcg
  implements Runnable
{
  public jcg(DataApiPlugin paramDataApiPlugin, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2, String paramString3) {}
  
  public void run()
  {
    i = 200;
    Object localObject1 = null;
    try
    {
      localObject2 = HttpUtil.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.jdField_b_of_type_AndroidOsBundle);
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject2;
        i = 0;
        localIOException.printStackTrace();
      }
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqJspDataApiPlugin.mRuntime.a();
    if ((!TextUtils.isEmpty(this.c)) && (localObject2 != null)) {
      ((Activity)localObject2).runOnUiThread(new jch(this, (Activity)localObject2, localObject1, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jcg
 * JD-Core Version:    0.7.0.1
 */