package cooperation.qqfav.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.qphone.base.util.QLog;

public class QfavJumpActivity
  extends JumpActivity
{
  public static final char a = '\024';
  public static final String a = "qqfav|QfavJumpActivity";
  public static final String b = "qqfav_extra_pic_share";
  public static final String c = "qqfav_extra_only_pic";
  public static final String d = "qqfav_extra_multi_pic";
  public static final String e = "qqfav_extra_from_sdk_share";
  public static final String f = "qqfav_extra_from_system_share";
  public static final String g = "qqfav_extra_multi_pic_path_list";
  public static final String h = "qqfav_extra_mixed_msg";
  public static final int i = 0;
  public static final String i = "qqfav_extra_richmedia_title";
  public static final int j = 1;
  private static final String j = "sTARGET_PACKAGE_NAME";
  public static final int k = 2;
  private static final String k = "sTARGET_CLASS_NAME";
  public static final int l = 3;
  private static final String l = "INTERNAL_JUMP";
  private static final int m = 1;
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramIntent);
    localIntent.setClassName("com.tencent.minihd.qq", "cooperation.qqfav.widget.QfavJumpActivity");
    if (paramIntent.getComponent() != null)
    {
      localIntent.putExtra("sTARGET_CLASS_NAME", paramIntent.getComponent().getClassName());
      localIntent.putExtra("sTARGET_PACKAGE_NAME", paramIntent.getComponent().getPackageName());
    }
    localIntent.putExtra("INTERNAL_JUMP", true);
    paramContext.startActivity(localIntent);
  }
  
  protected boolean a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    if (paramIntent.getBooleanExtra("INTERNAL_JUMP", false))
    {
      paramIntent.removeExtra("INTERNAL_JUMP");
      return b(paramIntent);
    }
    paramIntent.putExtra("qqfav_extra_from_system_share", true);
    return false;
  }
  
  protected boolean b(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("sTARGET_CLASS_NAME");
    String str2 = paramIntent.getStringExtra("sTARGET_PACKAGE_NAME");
    if (!"cooperation.qqfav.widget.LocationDetailActivity".equals(str1))
    {
      QLog.e("qqfav|QfavJumpActivity", 1, "handleInternalJump|invalid jump. pkg=" + str2 + ",cls=" + str1);
      return true;
    }
    paramIntent.removeExtra("sTARGET_PACKAGE_NAME");
    paramIntent.removeExtra("sTARGET_CLASS_NAME");
    if ("cooperation.qqfav.widget.LocationDetailActivity".equals(str1)) {
      new QQMapActivityProxy(this.app.getAccount());
    }
    paramIntent = new Intent(paramIntent);
    paramIntent.setClassName(str2, str1);
    startActivity(paramIntent);
    return true;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavJumpActivity
 * JD-Core Version:    0.7.0.1
 */