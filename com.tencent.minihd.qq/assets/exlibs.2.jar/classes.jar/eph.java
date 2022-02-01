import android.app.Application;
import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.qcall.LightalkSwitchHanlder;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

public class eph
  implements CompoundButton.OnCheckedChangeListener
{
  public eph(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject;
    if (((paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (paramCompoundButton == this.a.b.a()) || (paramCompoundButton == PermisionPrivacyActivity.b(this.a)) || (paramCompoundButton == PermisionPrivacyActivity.a(this.a)) || (paramCompoundButton == this.a.c.a()) || (paramCompoundButton == this.a.g.a()) || (paramCompoundButton == this.a.i.a())) && (!NetworkUtil.e(this.a.getActivity())))
    {
      this.a.a(2131367135, 1);
      localObject = this.a;
      if (!paramBoolean)
      {
        paramBoolean = true;
        PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject, paramCompoundButton, paramBoolean);
      }
    }
    label519:
    label847:
    label1246:
    do
    {
      do
      {
        do
        {
          return;
          paramBoolean = false;
          break;
          if (paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
          {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("对附近的人可见");
            if (paramBoolean) {}
            for (i = 1;; i = 0)
            {
              ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Visible_nearby", 0, i, String.valueOf(i), "", "", "");
              this.a.a(paramBoolean);
              this.a.app.b(paramBoolean, false);
              return;
            }
          }
          if (paramCompoundButton == this.a.b.a())
          {
            this.a.b.setContentDescription("允许附近的人赞我");
            if (paramBoolean) {}
            for (i = 1;; i = 0)
            {
              ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Nearby_likeme", 0, i, String.valueOf(i), "", "", "");
              this.a.app.e(true, paramBoolean);
              return;
            }
          }
          if (paramCompoundButton == this.a.jdField_a_of_type_AndroidWidgetCompoundButton)
          {
            if (!NetworkUtil.e(this.a.app.getApplication().getApplicationContext()))
            {
              QQToast.a(this.a.getApplicationContext(), 2131367328, 1).a();
              this.a.jdField_a_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(null);
              paramCompoundButton = this.a.jdField_a_of_type_AndroidWidgetCompoundButton;
              if (this.a.app.f() == 1) {}
              for (paramBoolean = true;; paramBoolean = false)
              {
                paramCompoundButton.setChecked(paramBoolean);
                this.a.jdField_a_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.a.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
                return;
              }
            }
            if (paramBoolean)
            {
              i = 1;
              ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, String.valueOf(i), "", "", "");
              this.a.a(this.a.getApplication().getResources().getString(2131368580));
              if (!paramBoolean) {
                break label519;
              }
            }
            for (i = 1;; i = 0)
            {
              this.a.app.g(i);
              return;
              i = 0;
              break;
            }
          }
          if (paramCompoundButton == PermisionPrivacyActivity.b(this.a))
          {
            if (paramBoolean) {}
            for (i = 1;; i = 0)
            {
              ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Visible_same", 0, i, String.valueOf(i), "", "", "");
              this.a.app.c(paramBoolean, false);
              this.a.b(paramBoolean);
              return;
            }
          }
          if (paramCompoundButton == PermisionPrivacyActivity.a(this.a))
          {
            if (paramBoolean) {}
            for (i = 1;; i = 0)
            {
              ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Same_likeme", 0, i, String.valueOf(i), "", "", "");
              this.a.app.e(false, paramBoolean);
              return;
            }
          }
          if (paramCompoundButton == this.a.f.a())
          {
            if (paramBoolean) {}
            for (i = 1;; i = 0)
            {
              ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_signature_qzone", 0, i, String.valueOf(i), "", "", "");
              if ((!NetworkUtil.e(this.a.getActivity())) || (PermisionPrivacyActivity.a(this.a) == null)) {
                break;
              }
              this.a.f.setContentDescription("个性签名同步到说说");
              PermisionPrivacyActivity.a(this.a).a(paramBoolean);
              return;
            }
            paramCompoundButton = this.a;
            if (PermisionPrivacyActivity.a(this.a) != null)
            {
              i = 2131367135;
              PermisionPrivacyActivity.a(paramCompoundButton, i);
              paramCompoundButton = this.a;
              localObject = this.a.f.a();
              if (paramBoolean) {
                break label847;
              }
            }
            for (paramBoolean = true;; paramBoolean = false)
            {
              PermisionPrivacyActivity.a(paramCompoundButton, (CompoundButton)localObject, paramBoolean);
              return;
              i = 2131368455;
              break;
            }
          }
          if (paramCompoundButton == this.a.e.a())
          {
            this.a.e.setContentDescription("可通过系统通讯录发起QQ聊天");
            ((ContactSyncManager)this.a.app.getManager(40)).a(paramBoolean);
            return;
          }
          if (paramCompoundButton == this.a.c.a())
          {
            this.a.c.setContentDescription("向好友展示网络状态");
            PermisionPrivacyActivity.a(this.a, this.a.c.a(), paramBoolean);
            this.a.app.d(paramBoolean, true);
            return;
          }
          if (paramCompoundButton != this.a.g.a()) {
            break label1090;
          }
          PermisionPrivacyActivity.a(this.a, this.a.g.a(), paramBoolean);
          this.a.g.setContentDescription("接收约会消息");
          this.a.c(paramBoolean);
          paramCompoundButton = (DatingHandler)this.a.app.a(40);
        } while (paramCompoundButton == null);
        if (paramBoolean) {}
        for (b = 0;; b = 1)
        {
          paramCompoundButton.a(b);
          if ((!this.a.isResume()) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) || (this.a.isFinishing())) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131366988, 1000);
          return;
        }
        if (paramCompoundButton != this.a.i.a()) {
          break label1284;
        }
        PermisionPrivacyActivity.a(this.a, this.a.i.a(), paramBoolean);
        this.a.i.setContentDescription("接收来电消息");
        if (!paramBoolean) {
          break label1246;
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004E71", "0X8004E71", 0, 0, "", "", "", "");
        paramCompoundButton = (LightalkSwitchHanlder)this.a.app.a(54);
      } while (paramCompoundButton == null);
      if (paramBoolean) {}
      for (byte b = 0;; b = 1)
      {
        paramCompoundButton.a(b);
        if ((!this.a.isResume()) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) || (this.a.isFinishing())) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131366988, 1000);
        return;
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004E72", "0X8004E72", 0, 0, "", "", "", "");
        break label1168;
      }
      if (paramCompoundButton == this.a.h.a())
      {
        PermisionPrivacyActivity.a(this.a, this.a.h.a(), paramBoolean);
        PermisionPrivacyActivity.a(this.a).a(paramBoolean, true);
        return;
      }
    } while (paramCompoundButton != this.a.d.a());
    label1090:
    paramCompoundButton = this.a.app;
    label1168:
    if (paramBoolean) {}
    label1284:
    for (int i = 1;; i = 0)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "0X800487E", "0X800487E", 0, 0, String.valueOf(i), "", "", "");
      if (!NetworkUtil.e(this.a.getActivity())) {
        break;
      }
      this.a.d.setContentDescription("连续登录天数对他人可见");
      ((CardHandler)this.a.app.a(2)).c(paramBoolean);
      return;
    }
    paramCompoundButton = this.a;
    if (PermisionPrivacyActivity.a(this.a) != null)
    {
      i = 2131367135;
      PermisionPrivacyActivity.a(paramCompoundButton, i);
      paramCompoundButton = this.a;
      localObject = this.a.d.a();
      if (paramBoolean) {
        break label1501;
      }
    }
    label1501:
    for (paramBoolean = true;; paramBoolean = false)
    {
      PermisionPrivacyActivity.a(paramCompoundButton, (CompoundButton)localObject, paramBoolean);
      return;
      i = 2131368455;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eph
 * JD-Core Version:    0.7.0.1
 */