import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class kvt
  implements Runnable
{
  kvt(kvs paramkvs) {}
  
  public void run()
  {
    try
    {
      this.a.b();
      if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 5000L);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(kvs.jdField_a_of_type_JavaLangString, 2, "filterTask", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kvt
 * JD-Core Version:    0.7.0.1
 */