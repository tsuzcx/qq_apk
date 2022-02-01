import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QzonePerformanceTracer;

public class mds
  implements View.OnClickListener
{
  public mds(QzonePerformanceTracer paramQzonePerformanceTracer) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QzonePerformanceTracer.a(), 2, "mOnCloseTraceClickListener onclick");
    }
    QzonePerformanceTracer.c(this.a);
    QzonePerformanceTracer.a(this.a, false);
    QzonePerformanceTracer.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mds
 * JD-Core Version:    0.7.0.1
 */