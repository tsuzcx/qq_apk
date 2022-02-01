import com.tencent.av.AVLog;
import com.tencent.av.ui.VideoControlUI.ConnectInfo;
import com.tencent.qav.activity.QavChatActivity;

class lii
  implements Runnable
{
  lii(lig paramlig, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (QavChatActivity.a(this.jdField_a_of_type_Lig.a) == null) {}
    while ((QavChatActivity.a(this.jdField_a_of_type_Lig.a).a() == null) || (this.jdField_a_of_type_JavaLangString == null) || (!QavChatActivity.a(this.jdField_a_of_type_Lig.a).a().equals(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    this.jdField_a_of_type_Lig.a.b = this.jdField_a_of_type_Boolean;
    AVLog.d("QavChatActivity", "onDestroyUI exit 1");
    this.jdField_a_of_type_Lig.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lii
 * JD-Core Version:    0.7.0.1
 */