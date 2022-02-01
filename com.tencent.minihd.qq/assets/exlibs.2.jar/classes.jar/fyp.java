import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;

public class fyp
  implements ActionSheet.OnButtonClickListener
{
  public fyp(AIOImageListScene paramAIOImageListScene, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(AIOImageListScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getResources().getString(2131369006))) {
          break label81;
        }
        AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene);
        AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene, "Multi_Forward_Contacts", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a.size());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      label81:
      if (paramView.equals(AIOImageListScene.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getResources().getString(2131368342)))
      {
        if (LocalMultiProcConfig.a(AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene) + "__qzone_pic_permission__" + AIOImageListScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), -1, Long.valueOf(AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene)).longValue()) == 0)
        {
          paramView = new QQCustomDialog(AIOImageListScene.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), 2131558902);
          paramView.setContentView(2130903216);
          paramView.setTitle(AIOImageListScene.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getString(2131363508));
          paramView.setMessage(AIOImageListScene.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getString(2131363510));
          paramView.setNegativeButton(AIOImageListScene.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getString(2131363511), new fyq(this));
          paramView.setCanceledOnTouchOutside(false);
          paramView.setCancelable(false);
          paramView.show();
          QZoneClickReport.a(AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), "40", "1");
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a.size() > 20)
        {
          QQToast.a(AIOImageListScene.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), 2131368343, 0).a();
        }
        else
        {
          AIOImageListScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene);
        }
      }
      else if (paramView.equals(AIOImageListScene.j(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getResources().getString(2131368333))) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a.size() > 20) {
          QQToast.a(AIOImageListScene.k(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), 2131368343, 0).a();
        } else {
          AIOImageListScene.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fyp
 * JD-Core Version:    0.7.0.1
 */