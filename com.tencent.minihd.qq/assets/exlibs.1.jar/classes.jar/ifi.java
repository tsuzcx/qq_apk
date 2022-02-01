import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.emoticon.SogouEmojiTaskController;
import com.tencent.qphone.base.util.QLog;

public class ifi
  implements DialogInterface.OnDismissListener
{
  public ifi(SogouEmojiTaskController paramSogouEmojiTaskController) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(SogouEmojiTaskController.jdField_a_of_type_JavaLangString, 2, "func onDismiss begins, mCurTaskId:" + this.a.jdField_a_of_type_Int);
    }
    this.a.a(this.a.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d(SogouEmojiTaskController.jdField_a_of_type_JavaLangString, 2, "func onDismiss ends");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ifi
 * JD-Core Version:    0.7.0.1
 */