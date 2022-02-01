import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QzonePerformanceTracer;

public class mdw
  implements Runnable
{
  public mdw(QzonePerformanceTracer paramQzonePerformanceTracer) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(QzonePerformanceTracer.a(), 2, "QzonePerformanceTracer: asyncStopTrace runnable run");
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mdw
 * JD-Core Version:    0.7.0.1
 */