import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troop.activity.AbsReplyActivity;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class kcn
  extends Handler
{
  public kcn(AbsReplyActivity paramAbsReplyActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        case 1002: 
        default: 
          return;
        case 1001: 
          this.a.b(false);
          if ((this.a.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
            this.a.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          }
          QQToast.a(this.a, 2131363938, 1).b(this.a.getTitleBarHeight());
        }
      } while (!(paramMessage.obj instanceof String));
      paramMessage = (String)paramMessage.obj;
      int i = this.a.jdField_b_of_type_JavaUtilArrayList.indexOf(paramMessage);
      this.a.jdField_b_of_type_JavaUtilArrayList.remove(i);
      return;
      if ((this.a.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.a.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      this.a.b(false);
      this.a.k();
      return;
      this.a.b(false);
      if ((this.a.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.a.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131363937, 1).b(this.a.getTitleBarHeight());
      return;
      if ((paramMessage.obj instanceof String))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a((String)paramMessage.obj);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo = null;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = null;
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a(this.a.jdField_b_of_type_JavaUtilArrayList);
    } while (this.a.jdField_b_of_type_JavaUtilArrayList.size() <= 0);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo = null;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = null;
    return;
    this.a.jdField_b_of_type_JavaUtilArrayList.clear();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
    AbsReplyActivity.a(this.a, 4);
    return;
    this.a.a(3, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kcn
 * JD-Core Version:    0.7.0.1
 */