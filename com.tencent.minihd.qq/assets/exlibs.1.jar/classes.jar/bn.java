import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import com.dataline.activities.LiteActivity;

public class bn
  implements DialogInterface.OnClickListener
{
  public bn(LiteActivity paramLiteActivity, AsyncTask paramAsyncTask, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Integer[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bn
 * JD-Core Version:    0.7.0.1
 */