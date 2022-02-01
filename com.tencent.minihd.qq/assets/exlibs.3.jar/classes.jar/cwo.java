import android.os.Process;
import com.tencent.component.network.utils.thread.AsyncTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class cwo
  extends cwe
{
  public cwo(AsyncTask paramAsyncTask)
  {
    super(null);
  }
  
  public Object call()
  {
    AsyncTask.a(this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask).set(true);
    Process.setThreadPriority(10);
    return AsyncTask.a(this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask, this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask.a(this.jdField_a_of_type_ArrayOfJavaLangObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cwo
 * JD-Core Version:    0.7.0.1
 */