import android.graphics.Rect;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.widgets.ScannerView;

public class cnh
  implements Runnable
{
  public cnh(ScannerActivity paramScannerActivity) {}
  
  public void run()
  {
    Rect localRect = this.a.a();
    this.a.a.setViewFinder(localRect.left, localRect.top, localRect.right, localRect.bottom);
    if (!this.a.f) {
      this.a.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cnh
 * JD-Core Version:    0.7.0.1
 */