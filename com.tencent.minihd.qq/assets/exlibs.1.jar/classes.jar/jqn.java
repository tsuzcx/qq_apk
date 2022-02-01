import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreview;
import com.tencent.mobileqq.richmedia.dc.DataReport;

public class jqn
  extends Handler
{
  public jqn(DCAIOPreview paramDCAIOPreview, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = DataReport.a();
    int j = DCAIOPreview.a(this.a).size();
    int i = 0;
    while (i < j)
    {
      jqo localjqo = (jqo)DCAIOPreview.a(this.a).valueAt(i);
      paramMessage.a(new jqs("Pic.AioPreview", localjqo.a("Pic.AioPreview")));
      paramMessage.a(new jqs("Pic.AioPreview.Preload", localjqo.a("Pic.AioPreview.Preload")));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jqn
 * JD-Core Version:    0.7.0.1
 */