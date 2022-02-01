package cooperation.qzone;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.lang.reflect.Field;
import mbj;

public class TranslucentActivity
  extends Activity
{
  public static int a(Activity paramActivity)
  {
    Object localObject1 = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
    int j = ((Rect)localObject1).top;
    int i = j;
    if (j == 0) {}
    try
    {
      localObject1 = Class.forName("com.android.internal.R$dimen");
      Object localObject2 = ((Class)localObject1).newInstance();
      i = Integer.parseInt(((Class)localObject1).getField("status_bar_height").get(localObject2).toString());
      i = paramActivity.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception paramActivity) {}
    return j;
  }
  
  private void a(Intent paramIntent)
  {
    QQProgressDialog localQQProgressDialog;
    if (!((IPluginManager)((QQAppInterface)BaseApplicationImpl.a().a()).getManager(26)).isPlugininstalled("qzone_plugin.apk"))
    {
      localQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131492923));
      localQQProgressDialog.a("正在加载...");
      localQQProgressDialog.setOnDismissListener(new mbj(this));
    }
    for (;;)
    {
      String str = QzonePluginProxyActivity.a(paramIntent);
      paramIntent.putExtra("userQqResources", 1);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
      localPluginParams.jdField_b_of_type_JavaLangString = "qzone_plugin.apk";
      localPluginParams.d = "QZone";
      localPluginParams.jdField_a_of_type_JavaLangString = "";
      localPluginParams.e = str;
      localPluginParams.jdField_a_of_type_JavaLangClass = QzonePluginProxyActivity.class;
      localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localPluginParams.jdField_b_of_type_Int = -1;
      localPluginParams.jdField_a_of_type_AndroidAppDialog = localQQProgressDialog;
      localPluginParams.c = 10000;
      localPluginParams.f = null;
      IPluginManager.a(this, localPluginParams);
      if (localQQProgressDialog == null) {
        finish();
      }
      return;
      localQQProgressDialog = null;
    }
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (!TextUtils.isEmpty(QzonePluginProxyActivity.a(paramBundle))) {
      a(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.TranslucentActivity
 * JD-Core Version:    0.7.0.1
 */