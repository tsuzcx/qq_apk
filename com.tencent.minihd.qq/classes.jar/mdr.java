import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QzonePerformanceTracer;

public class mdr
  implements View.OnClickListener
{
  public mdr(QzonePerformanceTracer paramQzonePerformanceTracer) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QzonePerformanceTracer.a(), 2, "mOnFinishTraceClickListener onclick");
    }
    QzonePerformanceTracer.a(this.a, false);
    QzonePerformanceTracer.b(this.a).setVisibility(0);
    QzonePerformanceTracer.c(this.a).setVisibility(0);
    QzonePerformanceTracer.d(this.a).setVisibility(8);
    QzonePerformanceTracer.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mdr
 * JD-Core Version:    0.7.0.1
 */