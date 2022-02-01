import android.content.Intent;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public class gti
  implements Runnable
{
  public gti(SendPhotoActivity paramSendPhotoActivity, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.a();
      label7:
      this.jdField_a_of_type_AndroidContentIntent.putExtra(AlbumConstants.i, 2);
      if (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("extra_image_sender_tag")) {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("extra_image_sender_tag", "SendPhotoActivity.handlePhoto");
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("param_selNum", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.b.size());
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.setResult(-1, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.getIntent());
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.finish();
      if (!SendPhotoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity))
      {
        if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("friend_forward_photo", false)) {
          break label183;
        }
        if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("forward_photo_no_nav", false)) {
          break label142;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.finish();
      }
      for (;;)
      {
        Utils.a(BaseApplication.getContext(), SendPhotoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity));
        return;
        label142:
        Object localObject = new Intent("Common_BroadcastReceiver");
        ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidContentIntent.getExtras());
        ((Intent)localObject).putExtra("friend_forward_photo", true);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.sendBroadcast((Intent)localObject);
        continue;
        label183:
        localObject = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
        this.jdField_a_of_type_AndroidContentIntent.setClassName(str, (String)localObject);
        this.jdField_a_of_type_AndroidContentIntent.addFlags(603979776);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity.startActivity(this.jdField_a_of_type_AndroidContentIntent);
      }
    }
    catch (Exception localException)
    {
      break label7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gti
 * JD-Core Version:    0.7.0.1
 */