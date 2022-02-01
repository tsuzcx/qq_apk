import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class eau
  extends Handler
{
  public eau(FriendProfileCardActivity paramFriendProfileCardActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject4 = null;
    if (paramMessage.what == 2)
    {
      this.a.a();
      return;
    }
    Object localObject1;
    Object localObject3;
    if (paramMessage.what == 3) {
      if ((paramMessage.obj instanceof Card))
      {
        localObject1 = (Card)paramMessage.obj;
        localObject3 = ((Card)localObject1).uin;
        localObject4 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "MSG_SWITCH_TO_FRIEND, uin = " + (String)localObject1 + ", obj: " + paramMessage.obj + "");
        }
        if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
          break;
        }
        this.a.a(localObject4, (String)localObject1);
        return;
        if ((paramMessage.obj instanceof String))
        {
          localObject1 = (String)paramMessage.obj;
          continue;
          if (paramMessage.what == 4)
          {
            if (paramMessage.arg1 == 1) {}
            for (boolean bool = true;; bool = false)
            {
              if (!(paramMessage.obj instanceof Card)) {
                break label235;
              }
              localObject1 = (Card)paramMessage.obj;
              this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject1);
              this.a.a((Card)localObject1, bool);
              if (paramMessage.arg2 != 1) {
                break;
              }
              FriendProfileCardActivity.b(this.a).setEnabled(FriendProfileCardActivity.a(this.a));
              return;
            }
            label235:
            if (!(paramMessage.obj instanceof ContactCard)) {
              break;
            }
            paramMessage = (ContactCard)paramMessage.obj;
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard = paramMessage;
            this.a.a(paramMessage, bool);
            return;
          }
          if (paramMessage.what == 8)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "handler receive msg MSG_CARD_TEMPLATE_INITED");
            }
            FriendProfileCardActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
            return;
          }
          if (paramMessage.what == 9)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "handler receive msg MSG_CARD_TEMPLATE_INITED_FAIL");
            }
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
              break;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = ProfileCardTemplate.a;
            FriendProfileCardActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
            return;
          }
          if (paramMessage.what == 6)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "handler receive msg MSG_CARD_TEMPLATE_DOWNLOAD_SUCCESS");
            }
            FriendProfileCardActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
            return;
          }
          if (paramMessage.what == 7)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "handler receive msg MSG_CARD_TEMPLATE_DOWNLOAD_FAIL");
            }
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
              break;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = ProfileCardTemplate.a;
            FriendProfileCardActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
            return;
          }
          if (paramMessage.what == 10)
          {
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "initHeaderView timeout");
            }
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_Boolean = true;
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = ProfileCardTemplate.a;
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet = 0;
            this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false);
            return;
          }
          if (paramMessage.what == 11)
          {
            if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView == null) {
              break;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a();
            return;
          }
          if (paramMessage.what == 12)
          {
            if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (ProfileCardTemplate.f != this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId) || (!(paramMessage.obj instanceof Bitmap))) {
              break;
            }
            paramMessage = (Bitmap)paramMessage.obj;
            localObject1 = (FrameLayout)this.a.findViewById(16908290);
            if ((localObject1 == null) || (((FrameLayout)localObject1).getChildCount() <= 0)) {
              break;
            }
            localObject1 = ((FrameLayout)localObject1).getChildAt(0);
            if (localObject1 == null) {
              break;
            }
            paramMessage = new BitmapDrawable(this.a.getResources(), paramMessage);
            paramMessage.setAlpha(0);
            ((View)localObject1).setBackgroundDrawable(paramMessage);
            return;
          }
          if (paramMessage.what != 13) {
            break;
          }
          if ((paramMessage.obj instanceof String)) {
            localObject1 = (String)paramMessage.obj;
          }
          try
          {
            localObject1 = new JSONArray((String)localObject1).getJSONObject(0).getString("text");
            localObject3 = this.a.app.getPreferences().edit();
            ((SharedPreferences.Editor)localObject3).putString("profile_card_other_head_click_text", (String)localObject1);
            ((SharedPreferences.Editor)localObject3).putString("profile_card_other_head_open_time", new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis())));
            ((SharedPreferences.Editor)localObject3).commit();
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("Q.profilecard.FrdProfileCard", 2, "MSG_CARD_TEMPLATE_CUSTOM_TEXT obj: " + paramMessage.obj + "");
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eau
 * JD-Core Version:    0.7.0.1
 */