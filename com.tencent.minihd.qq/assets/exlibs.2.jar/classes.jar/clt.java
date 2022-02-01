import android.graphics.drawable.Drawable;
import com.tencent.biz.qrcode.activity.LoginManagerActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class clt
  extends Thread
{
  public clt(LoginManagerActivity paramLoginManagerActivity, String paramString) {}
  
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_ComTencentBizQrcodeActivityLoginManagerActivity.app.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQrcodeActivityLoginManagerActivity.runOnUiThread(new clu(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     clt
 * JD-Core Version:    0.7.0.1
 */