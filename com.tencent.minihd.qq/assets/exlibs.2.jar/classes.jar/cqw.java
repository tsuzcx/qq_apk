import android.hardware.Camera;
import com.tencent.biz.widgets.ScannerView;

class cqw
  implements Runnable
{
  cqw(cqv paramcqv) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidHardwareCamera == null) {
      return;
    }
    try
    {
      this.a.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
      label21:
      ScannerView.a(this.a.jdField_a_of_type_ComTencentBizWidgetsScannerView, true);
      return;
    }
    catch (Exception localException)
    {
      break label21;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cqw
 * JD-Core Version:    0.7.0.1
 */