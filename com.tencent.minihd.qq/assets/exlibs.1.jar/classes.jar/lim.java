import com.tencent.av.AVLog;
import com.tencent.av.ui.VideoControlUI.ConnectInfo;
import com.tencent.qav.activity.QavInviteActivity;

class lim
  implements Runnable
{
  lim(lil paramlil, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (QavInviteActivity.a(this.jdField_a_of_type_Lil.a) == null) {}
    while ((this.jdField_a_of_type_Lil.a.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.a() == null) || (this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_Lil.a.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.a().equals(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    this.jdField_a_of_type_Lil.a.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    AVLog.d("QavInviteActivity", "onDestroyUI exit 1");
    this.jdField_a_of_type_Lil.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lim
 * JD-Core Version:    0.7.0.1
 */