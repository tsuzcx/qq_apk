import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QzonePerformanceTracer;

public class mdu
  implements View.OnClickListener
{
  public mdu(QzonePerformanceTracer paramQzonePerformanceTracer) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QzonePerformanceTracer.a(), 2, "mOnTraceClickListener onclick");
    }
    QzonePerformanceTracer.a(this.a, true);
    this.a.b();
    QzonePerformanceTracer.b(this.a).setVisibility(8);
    QzonePerformanceTracer.c(this.a).setVisibility(8);
    QzonePerformanceTracer.d(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mdu
 * JD-Core Version:    0.7.0.1
 */