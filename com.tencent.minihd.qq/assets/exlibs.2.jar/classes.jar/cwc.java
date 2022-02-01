import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.component.network.utils.thread.AsyncTask;

public class cwc
  extends Handler
{
  public cwc(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    cwa localcwa = (cwa)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      AsyncTask.b(localcwa.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask, localcwa.jdField_a_of_type_ArrayOfJavaLangObject[0]);
      return;
    }
    localcwa.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask.a(localcwa.jdField_a_of_type_ArrayOfJavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cwc
 * JD-Core Version:    0.7.0.1
 */