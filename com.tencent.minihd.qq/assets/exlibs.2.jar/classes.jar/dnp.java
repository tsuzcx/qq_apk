import android.app.Dialog;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;

class dnp
  extends Thread
{
  dnp(dno paramdno) {}
  
  public void run()
  {
    ChatHistoryForC2C.a(this.a.a, this.a.a.jdField_c_of_type_JavaLangString, this.a.a.a);
    this.a.a.jdField_c_of_type_AndroidAppDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dnp
 * JD-Core Version:    0.7.0.1
 */