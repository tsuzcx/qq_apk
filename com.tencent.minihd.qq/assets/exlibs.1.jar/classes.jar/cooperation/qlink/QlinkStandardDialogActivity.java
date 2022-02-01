package cooperation.qlink;

import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import lyl;
import lym;
import lyn;
import lyo;
import lyp;
import lyq;
import lyr;

public class QlinkStandardDialogActivity
  extends BaseActivity
{
  public static final int a = 4;
  static final String jdField_a_of_type_JavaLangString = "QlinkStandardDialogActivity";
  public static final int b = 7;
  public static final int c = 8;
  public static final int d = 9;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new lyr(this);
  final DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new lyl(this);
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  String b;
  
  private void a()
  {
    Object localObject = new lym(this);
    localObject = DialogUtil.a(this, 230, getString(2131364942), getString(2131364908), 2131364906, 2131364906, (DialogInterface.OnClickListener)localObject, null);
    ((QQCustomDialog)localObject).setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    ((QQCustomDialog)localObject).show();
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = new lyn(this);
    lyo locallyo = new lyo(this);
    if (paramBoolean) {}
    for (int i = 2131364913;; i = 2131364912)
    {
      localObject = DialogUtil.a(this, 230, getString(2131364942), getString(2131364909), 2131364907, i, locallyo, (DialogInterface.OnClickListener)localObject);
      ((QQCustomDialog)localObject).setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      ((QQCustomDialog)localObject).show();
      return;
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    lyp locallyp = new lyp(this);
    lyq locallyq = new lyq(this);
    String str = paramString2;
    if (paramString1 != null)
    {
      str = paramString2;
      if (paramString1.equalsIgnoreCase(paramString2))
      {
        FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
        str = paramString2;
        if (localFriendManager != null) {
          str = localFriendManager.c(paramString1);
        }
      }
    }
    if (paramBoolean) {}
    for (paramString1 = getString(2131364914) + str + getString(2131364915) + paramInt + getString(2131364916) + paramString3 + getString(2131364917) + paramString4 + "。";; paramString1 = getString(2131364918) + str + getString(2131364919) + paramInt + getString(2131364920) + paramString3 + getString(2131364921) + paramString4 + "。")
    {
      paramString1 = DialogUtil.a(this, 230, getString(2131364942), paramString1, 2131364922, 2131364923, locallyq, locallyp);
      paramString1.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      paramString1.show();
      return;
    }
  }
  
  private void b()
  {
    QQProxyForQlink.a(this, 5, null);
    finish();
  }
  
  protected void doOnDestroy()
  {
    this.app.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.doOnDestroy();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = SplashActivity.sTopActivity;
    super.onCreate(paramBundle);
    setTitle(null);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.qlink.finishdlg");
    this.app.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    switch (getIntent().getIntExtra("str_type", 0))
    {
    default: 
      finish();
      return;
    case 7: 
      a(getIntent().getBooleanExtra("param_send", false));
      return;
    case 8: 
      a(getIntent().getBooleanExtra("param_send", false), getIntent().getStringExtra("param_uin"), getIntent().getStringExtra("param_nick"), getIntent().getIntExtra("param_transcount", 0), getIntent().getStringExtra("param_jsliuliang"), getIntent().getStringExtra("param_pjspeed"));
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkStandardDialogActivity
 * JD-Core Version:    0.7.0.1
 */