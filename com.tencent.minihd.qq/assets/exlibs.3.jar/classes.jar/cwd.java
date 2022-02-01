import com.tencent.component.network.utils.thread.AsyncTask;
import com.tencent.component.network.utils.thread.a.a;
import java.util.concurrent.Executor;

public class cwd
  implements Executor
{
  final a jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAA = new a();
  Runnable jdField_a_of_type_JavaLangRunnable;
  
  protected void a()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAA.poll();
      this.jdField_a_of_type_JavaLangRunnable = localRunnable;
      if (localRunnable != null) {
        AsyncTask.a.execute(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
    }
    finally {}
  }
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAA.offer(new cwq(this, paramRunnable));
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        a();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cwd
 * JD-Core Version:    0.7.0.1
 */