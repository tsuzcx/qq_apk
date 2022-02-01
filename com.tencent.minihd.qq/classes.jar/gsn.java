import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

public class gsn
  extends Handler
{
  public gsn(PhotoCropForPortraitActivity paramPhotoCropForPortraitActivity, int paramInt1, int paramInt2, ExtensionInfo paramExtensionInfo) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (-1 != paramMessage.what) {
      return;
    }
    paramMessage = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Int * 1.257D), (int)(this.b * 1.481D));
    paramMessage.addRule(14);
    paramMessage.topMargin = (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_AndroidViewViewGroup.getHeight() / 2 - (int)(this.b / 2 * 1.705D));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView, paramMessage);
    ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.app.getManager(45)).a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView, 6, PendantInfo.k);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gsn
 * JD-Core Version:    0.7.0.1
 */