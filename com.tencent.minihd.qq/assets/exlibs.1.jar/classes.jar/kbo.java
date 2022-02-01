import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.mobileqq.troop.activity.AudioRecordActivity;
import com.tencent.mobileqq.troop.activity.ExtendGridView;
import com.tencent.mobileqq.troop.activity.TroopBarImagePreviewAdapter;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class kbo
  extends Handler
{
  public kbo(AbsPublishActivity paramAbsPublishActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = false;
    if (this.a.isFinishing()) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  switch (paramMessage.what)
                  {
                  default: 
                    return;
                  }
                } while (this.a.a(1));
                this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName());
                return;
                this.a.b(false);
                if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
                  this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
                }
                AbsPublishActivity.a(this.a).setEnabled(true);
                this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
                this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
                QQToast.a(this.a, 2131363937, 1).b(this.a.getTitleBarHeight());
              } while (!(paramMessage.obj instanceof String));
              paramMessage = (String)paramMessage.obj;
              this.a.b.remove(paramMessage);
              return;
              if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
                this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
              }
              this.a.b(false);
              this.a.k();
              return;
              this.a.b(false);
              if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
                this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
              }
              AbsPublishActivity.b(this.a).setEnabled(true);
              this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
              this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
              QQToast.a(this.a, 2131363937, 1).b(this.a.getTitleBarHeight());
              return;
            } while (this.a.a(2));
            if ((!this.a.permissionManager.checkPermission("android.permission.RECORD_AUDIO")) || (!this.a.permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")))
            {
              this.a.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.RECORD_AUDIO", 400), PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 100) }).requests(new kbp(this));
              return;
            }
            paramMessage = new Intent();
            paramMessage.putExtra("audio_max_length", this.a.S);
            if (this.a.af != null)
            {
              paramMessage.putExtra("from", "publish");
              paramMessage.putExtra("bid", this.a.af);
              paramMessage.putExtra("fromflag", this.a.ac);
              TroopBarUtils.a(this.a.ad, this.a.ae, "Clk_record", this.a.af, this.a.ac, "", "");
            }
            paramMessage.setClass(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AudioRecordActivity.class);
            this.a.startActivityForResult(paramMessage, 1003);
            return;
          } while (this.a.a(4));
          this.a.l();
        } while (this.a.af == null);
        TroopBarUtils.a(this.a.ad, this.a.ae, "Clk_music", this.a.af, this.a.ac, "", "");
        return;
      } while (this.a.a(8));
      this.a.b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName());
      TroopBarUtils.a(this.a.ad, this.a.ae, "Clk_video", this.a.af, this.a.ac, "", "");
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(this.a.b);
      paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter;
      if (this.a.b.size() < 9) {
        bool = true;
      }
      paramMessage.a(bool, true);
    } while (this.a.b.size() <= 0);
    this.a.a(4);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setCurType(4);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo = null;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = null;
    return;
    this.a.a(3, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kbo
 * JD-Core Version:    0.7.0.1
 */