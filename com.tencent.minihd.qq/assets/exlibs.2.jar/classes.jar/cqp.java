import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class cqp
  extends Handler
{
  private boolean jdField_a_of_type_Boolean;
  
  public cqp(Share paramShare) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((!(paramMessage.obj instanceof Bitmap)) || (this.jdField_a_of_type_Boolean));
      paramMessage = ImageUtil.a((Bitmap)paramMessage.obj, (int)(34.0F * this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_Float));
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramMessage);
      if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.c != null)
      {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.c.findViewById(2131298534).setVisibility(8);
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.c.findViewById(2131298536).setVisibility(0);
      }
    } while (!QLog.isColorLevel());
    QLog.d(Share.b(), 2, "QQBrowserActivity VISIBLE -----------------------");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cqp
 * JD-Core Version:    0.7.0.1
 */