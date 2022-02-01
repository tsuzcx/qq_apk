import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.VideoControlUI.ConnectInfo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qav.activity.QavInviteActivity;

class lit
  implements Runnable
{
  lit(lis paramlis, Bitmap paramBitmap, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if ((this.jdField_a_of_type_Lis.a.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Lis.a.jdField_a_of_type_AndroidWidgetTextView != null))
      {
        this.jdField_a_of_type_Lis.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_a_of_type_Lis.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Lis.a.d = true;
      }
      return;
    }
    if (this.jdField_a_of_type_Lis.a.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_Lis.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.a());
    }
    if (this.jdField_a_of_type_Lis.a.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_Lis.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Lis.a.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.a());
    }
    this.jdField_a_of_type_Lis.a.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lit
 * JD-Core Version:    0.7.0.1
 */