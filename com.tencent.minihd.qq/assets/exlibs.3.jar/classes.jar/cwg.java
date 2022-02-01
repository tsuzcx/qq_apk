import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.util.concurrent.atomic.AtomicLong;

public class cwg
  implements ThreadPool.Job, Comparable
{
  private static final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private final ThreadPool.Job jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$Job;
  private final boolean jdField_a_of_type_Boolean;
  
  public cwg(ThreadPool.Job paramJob, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$Job = paramJob;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
  }
  
  private int b(cwg paramcwg)
  {
    int i;
    if (this.jdField_a_of_type_Long < paramcwg.jdField_a_of_type_Long) {
      i = -1;
    }
    while (this.jdField_a_of_type_Boolean)
    {
      return i;
      if (this.jdField_a_of_type_Long > paramcwg.jdField_a_of_type_Long) {
        i = 1;
      } else {
        i = 0;
      }
    }
    return -i;
  }
  
  public int a(cwg paramcwg)
  {
    if (this.jdField_a_of_type_Int > paramcwg.jdField_a_of_type_Int) {
      return -1;
    }
    if (this.jdField_a_of_type_Int < paramcwg.jdField_a_of_type_Int) {
      return 1;
    }
    return b(paramcwg);
  }
  
  public Object a(ThreadPool.JobContext paramJobContext)
  {
    try
    {
      String str = Thread.currentThread().getName();
      str = str.substring(0, str.indexOf(" sub:") + " sub:".length());
      Thread.currentThread().setName(str + this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$Job.getClass().toString());
      label58:
      return this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$Job.a(paramJobContext);
    }
    catch (Exception localException)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cwg
 * JD-Core Version:    0.7.0.1
 */