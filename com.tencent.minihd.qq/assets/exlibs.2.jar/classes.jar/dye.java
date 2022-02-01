import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.ForwardHandlerActivity;

public class dye
  implements DialogInterface.OnClickListener
{
  public dye(ForwardHandlerActivity paramForwardHandlerActivity, AsyncTask paramAsyncTask, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Integer[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dye
 * JD-Core Version:    0.7.0.1
 */