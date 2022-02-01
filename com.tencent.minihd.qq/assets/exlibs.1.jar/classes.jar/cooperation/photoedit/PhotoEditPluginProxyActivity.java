package cooperation.photoedit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;

public class PhotoEditPluginProxyActivity
  extends PluginProxyActivity
{
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramContext = (IPluginManager)paramQQAppInterface.getManager(26);
    if (paramContext != null)
    {
      paramContext = paramContext.a("PhotoEdit.apk");
      if ((paramContext != null) && (paramContext.mState == 4))
      {
        paramContext = new Intent("com.photoedit.intent.action.START_PROCESS");
        IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
        localPluginParams.b = "PhotoEdit.apk";
        localPluginParams.d = "高级编辑插件";
        localPluginParams.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
        localPluginParams.e = "com.photoedit.app.PhotoEditBootReceiver";
        localPluginParams.jdField_a_of_type_AndroidContentIntent = paramContext;
        IPluginManager.a(paramQQAppInterface.a(), localPluginParams);
      }
    }
  }
  
  public String getPluginID()
  {
    return "PhotoEdit.apk";
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.photoedit.PhotoEditPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */