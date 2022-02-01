import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.SogouEmoji;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx.OnPrivateIMECommandListener;
import java.util.ArrayList;

public class div
  implements XEditTextEx.OnPrivateIMECommandListener
{
  public div(BaseChatPie paramBaseChatPie) {}
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "onPrivateIMECommand(), action:" + paramString);
    }
    Object localObject1;
    if ((!TextUtils.isEmpty(paramString)) && (paramBundle != null) && (InputMethodUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)))
    {
      if (!"com.sogou.inputmethod.expression".equals(paramString)) {
        break label241;
      }
      paramString = paramBundle.getString("SOGOU_EXP_PATH");
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "onPrivateIMECommand(), path:" + paramString);
      }
      if (!TextUtils.isEmpty(paramString))
      {
        paramBundle = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SendPhotoActivity.class);
        paramBundle.putExtra("uin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramBundle.putExtra("uintype", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramBundle.putExtra("troop_uin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(paramString);
        paramBundle.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject1);
        paramBundle.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1034);
        paramBundle.putExtra("PicContants.NEED_COMPRESS", false);
        paramBundle.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramBundle);
      }
    }
    label241:
    do
    {
      return true;
      if ("com.sogou.inputmethod.appid".equals(paramString))
      {
        localObject1 = paramBundle.getString("SOGOU_APP_ID");
        Object localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        paramString = AuthorityUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject2, (String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivity", 2, "onPrivateIMECommand(), appId:" + (String)localObject1 + "selfUin:" + (String)localObject2 + "openId:" + paramString);
        }
        localObject1 = (InputMethodManager)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("SOGOU_OPENID", paramString);
        ((InputMethodManager)localObject1).sendAppPrivateCommand(this.a.jdField_a_of_type_AndroidWidgetEditText, "com.tencent.mobileqq.sogou.openid", (Bundle)localObject2);
        paramString = paramBundle.getStringArrayList("EXP_ALL_PACKID");
        if (BaseChatPie.a(this.a) == null) {
          BaseChatPie.a(this.a, new SogouEmoji(this.a));
        }
        BaseChatPie.a(this.a).a(paramString);
        return true;
      }
    } while (!"com.sogou.inputmethod.qqexp".equals(paramString));
    int i = paramBundle.getInt("PACKAGE_ID");
    paramString = paramBundle.getString("EXP_ID");
    paramBundle = paramBundle.getString("EXP_PATH");
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "onPrivateIMECommand(), packId:" + i + ",exprId:" + paramString + ",ePath:" + paramBundle);
    }
    if (BaseChatPie.a(this.a) == null) {
      BaseChatPie.a(this.a, new SogouEmoji(this.a));
    }
    BaseChatPie.a(this.a).a(i, paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     div
 * JD-Core Version:    0.7.0.1
 */