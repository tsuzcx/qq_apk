package cooperation.qlink;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileProvider7Helper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;
import java.util.Iterator;
import lyj;
import lyk;

public class QlinkShareJumpActivity
  extends BaseActivity
{
  private static final int jdField_a_of_type_Int = 4096;
  private static final int b = 4097;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  private String a(Uri paramUri)
  {
    return FileProvider7Helper.getRealPathFromContentURI(this, paramUri);
  }
  
  private ArrayList a()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (this.jdField_a_of_type_JavaLangString.equals("android.intent.action.SEND"))
    {
      localObject = (Uri)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      if (localObject == null) {
        return null;
      }
      localObject = a((Uri)localObject);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    for (;;)
    {
      return localArrayList;
      localObject = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = a((Uri)((Iterator)localObject).next());
          if (str != null) {
            localArrayList.add(str);
          }
        }
      }
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList = a();
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      DialogUtil.a(this, 230, getString(2131364942), getString(2131364990), 2131364906, 2131364906, new lyj(this), null).show();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 50)
      {
        DialogUtil.a(this, 230, getString(2131364942), getString(2131364991), 2131364906, 2131364906, new lyk(this), null).show();
        return;
      }
    } while ((a()) || (a(false)));
    b();
  }
  
  private boolean a()
  {
    Intent localIntent1 = getIntent();
    if (localIntent1.getExtras() == null) {
      new Bundle();
    }
    if (!this.app.isLogin())
    {
      Intent localIntent2 = new Intent(this, LoginActivity.class);
      localIntent2.addFlags(67371008);
      localIntent2.putExtra("qlink_share_intent_data", localIntent1);
      localIntent2.putExtra("from_register_guide", true);
      startActivity(localIntent2);
      finish();
      overridePendingTransition(0, 0);
      return true;
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    Intent localIntent = getIntent();
    Object localObject2 = localIntent.getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if ((GesturePWDUtils.getJumpLock(this, this.app.a())) && ((paramBoolean) || (!GesturePWDUtils.getAppForground(this))))
    {
      localObject2 = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      ((Intent)localObject2).putExtra("key_gesture_from_jumpactivity", true);
      ((Intent)localObject2).setAction(localIntent.getAction());
      ((Intent)localObject2).putExtra("isActionSend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras(localIntent);
      startActivityForResult((Intent)localObject2, 4097);
      return true;
    }
    return false;
  }
  
  private void b()
  {
    c();
    finish();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      this.app.a().a("0X8004F47", this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("string_filepaths", this.jdField_a_of_type_JavaUtilArrayList);
    ArrayList localArrayList = FMDataCache.b();
    if (localArrayList != null) {}
    for (int i = localArrayList.size();; i = 0)
    {
      localBundle.putInt("string_beforeshare_selectedfile_count", i);
      QQProxyForQlink.a(this, 10, localBundle);
      return;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 4097)
      {
        b();
        return;
      }
      finish();
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_JavaLangString = paramBundle.getAction();
      this.jdField_a_of_type_AndroidOsBundle = paramBundle.getExtras();
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((this.jdField_a_of_type_JavaLangString.equals("android.intent.action.SEND")) || (this.jdField_a_of_type_JavaLangString.equals("android.intent.action.SEND_MULTIPLE"))))
      {
        if (paramBundle.getBooleanExtra("qlink_share_login_suc_flag", false))
        {
          if (!a(true)) {
            b();
          }
          return true;
        }
        a();
        return true;
      }
    }
    finish();
    overridePendingTransition(0, 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkShareJumpActivity
 * JD-Core Version:    0.7.0.1
 */