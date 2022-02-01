import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;

class dlq
  implements DialogInterface.OnCancelListener
{
  dlq(dlp paramdlp) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dlq
 * JD-Core Version:    0.7.0.1
 */