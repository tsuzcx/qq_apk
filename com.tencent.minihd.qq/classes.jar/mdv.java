import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QzonePerformanceTracer;

public class mdv
  implements View.OnClickListener
{
  public mdv(QzonePerformanceTracer paramQzonePerformanceTracer) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QzonePerformanceTracer.a(), 2, "mOnCloseAndTraceClickListener onclick");
    }
    QzonePerformanceTracer.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d(QzonePerformanceTracer.a(), 2, "mOnCloseAndTraceClickListener send broadcast kill qzone");
    }
    paramView = new Intent("mqq.intent.action.EXIT_com.tencent.minihd.qq");
    BaseApplication.getContext().sendBroadcast(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mdv
 * JD-Core Version:    0.7.0.1
 */