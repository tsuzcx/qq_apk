import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.viewplugin.ViewPluginContext;
import com.tencent.biz.viewplugin.ViewPluginManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;

public class cpg
  implements AsyncCallBack
{
  public cpg(ViewPluginManager paramViewPluginManager, long paramLong) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ViewPluginManager", 2, "transToLocalUrl loadMode:" + paramInt + ", time:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ViewPluginManager", 4, "transToLocalUrl transUrl:" + paramString);
    }
    paramString = HtmlOffline.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.e) + this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.e + "/" + this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.f;
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getPreferences(0);
      String str2 = ((SharedPreferences)localObject).getString("SearchViewPluginVersion", "-1");
      String str3 = HtmlOffline.c(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.e);
      String str1 = this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getFilesDir() + "/searchPlugin/opt";
      File localFile = new File(str1);
      if (!str2.equals(str3))
      {
        if (!localFile.exists()) {
          break label355;
        }
        FileUtils.a(localFile.getAbsolutePath());
        ((SharedPreferences)localObject).edit().putString("SearchViewPluginVersion", HtmlOffline.c(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.e)).commit();
        localFile.mkdirs();
      }
      for (;;)
      {
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        localObject = PluginUtils.getPluginLibPath(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.f).getCanonicalPath();
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_JavaLangClassLoader = new DexClassLoader(paramString, str1, (String)localObject, this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClassLoader());
        this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext = new ViewPluginContext(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, paramString, null);
        return;
        label355:
        localFile.mkdirs();
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViewPluginManager", 2, "create classloader failed:" + paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cpg
 * JD-Core Version:    0.7.0.1
 */