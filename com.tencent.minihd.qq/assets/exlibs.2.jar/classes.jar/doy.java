import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;

public class doy
  implements IIconListener
{
  public doy(ChatSettingActivity paramChatSettingActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((this.a.jdField_a_of_type_AndroidWidgetTextView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null) && (this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.b == paramInt1) && (paramBitmap != null) && (paramInt2 == 200)) {
      ChatSettingActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.a.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     doy
 * JD-Core Version:    0.7.0.1
 */