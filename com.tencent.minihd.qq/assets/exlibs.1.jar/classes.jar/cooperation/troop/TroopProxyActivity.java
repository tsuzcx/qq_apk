package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.QQBasePluginActivity;
import com.tencent.mobileqq.widget.NotRemoveFrameLayout;
import com.tencent.mobileqq.widget.QQProgressDialog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.util.ArrayList;
import mer;

public class TroopProxyActivity
  extends QQBasePluginActivity
{
  public static ArrayList a = new ArrayList();
  public static String f = "key_qun_id";
  
  public static Dialog a(Activity paramActivity)
  {
    paramActivity = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131492923));
    paramActivity.a("正在加载...");
    paramActivity.setOnDismissListener(new mer());
    return paramActivity;
  }
  
  public static Class a(String paramString)
  {
    if (paramString.equals("com.tencent.mobileqq.troop.activity.OpenTroopMemberListActivity")) {
      return TroopGPUProxyActivity.class;
    }
    return TroopProxyActivity.class;
  }
  
  public static void a(Activity paramActivity)
  {
    Dialog localDialog = a(paramActivity);
    a(paramActivity, new Intent(), localDialog, "com.tencent.mobileqq.troop.activity.FavOpenTroopActivity", null, 0);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity", null, 0);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity", null, paramInt);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.jdField_b_of_type_JavaLangString = "troop_plugin.apk";
    localPluginParams.d = "群资料卡";
    localPluginParams.jdField_a_of_type_JavaLangString = paramString2;
    localPluginParams.e = paramString1;
    localPluginParams.jdField_a_of_type_JavaLangClass = a(localPluginParams.e);
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.jdField_a_of_type_AndroidAppDialog = paramDialog;
    paramIntent.putExtra("userQqResources", 1);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    localPluginParams.jdField_b_of_type_Int = paramInt;
    localPluginParams.c = 10000;
    localPluginParams.f = null;
    IPluginManager.a(paramActivity, localPluginParams);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.jdField_b_of_type_JavaLangString = "Test.apk";
    localPluginParams.d = "测试";
    localPluginParams.jdField_a_of_type_JavaLangString = paramString;
    localPluginParams.e = "com.example.test.MainActivity";
    localPluginParams.jdField_a_of_type_JavaLangClass = a(localPluginParams.e);
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.jdField_b_of_type_Int = 0;
    localPluginParams.c = 10000;
    localPluginParams.f = null;
    IPluginManager.a(paramActivity, localPluginParams);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, String paramString, int paramInt)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.troop.activity.OpenTroopInfoActivity", paramString, paramInt);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.troop.activity.TroopFileUploadActivity", null, 0);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent, String paramString, int paramInt)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.troop.activity.OpenTroopMemberListActivity", paramString, paramInt);
  }
  
  protected void allowContainerNotRemove(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof NotRemoveFrameLayout)) {
      ((NotRemoveFrameLayout)paramView).a = paramBoolean;
    }
  }
  
  public String getPluginID()
  {
    return "troop_plugin.apk";
  }
  
  public Class getProxyActivity(String paramString)
  {
    return a(paramString);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    paramIntent.putExtra("from_activity", getClass().getName());
    if (getActivity().getParent() != null) {}
    for (boolean bool = true;; bool = false)
    {
      if (!paramIntent.getExtras().containsKey("is_activity_to_fragment")) {
        paramIntent.putExtra("is_activity_to_fragment", bool);
      }
      super.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.troop.TroopProxyActivity
 * JD-Core Version:    0.7.0.1
 */