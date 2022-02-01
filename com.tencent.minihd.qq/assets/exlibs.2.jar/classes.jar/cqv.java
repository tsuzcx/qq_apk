import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.qphone.base.util.QLog;

public class cqv
  extends Thread
  implements Camera.AutoFocusCallback
{
  static final long jdField_a_of_type_Long = 3000L;
  static final long b = 2500L;
  Camera jdField_a_of_type_AndroidHardwareCamera;
  Handler jdField_a_of_type_AndroidOsHandler;
  protected Runnable a;
  
  public cqv(ScannerView paramScannerView, Camera paramCamera)
  {
    this.jdField_a_of_type_JavaLangRunnable = new cqw(this);
    this.jdField_a_of_type_AndroidHardwareCamera = paramCamera;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public void a()
  {
    try
    {
      if ((ScannerView.b(this.jdField_a_of_type_ComTencentBizWidgetsScannerView)) && (this.jdField_a_of_type_AndroidHardwareCamera != null) && (ScannerView.c(this.jdField_a_of_type_ComTencentBizWidgetsScannerView)))
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2500L);
        this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(this);
        ScannerView.a(this.jdField_a_of_type_ComTencentBizWidgetsScannerView, false);
      }
      return;
    }
    finally {}
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(ScannerView.a, 4, "onAutoFocus");
    }
    ScannerView.a(this.jdField_a_of_type_ComTencentBizWidgetsScannerView, true);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void run()
  {
    try
    {
      if (ScannerView.a(this.jdField_a_of_type_ComTencentBizWidgetsScannerView)) {
        ScannerView.b(this.jdField_a_of_type_ComTencentBizWidgetsScannerView, false);
      }
      for (;;)
      {
        try
        {
          a();
        }
        catch (RuntimeException localRuntimeException1) {}
        break;
        Thread.sleep(3000L);
      }
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
        ScannerView.a(this.jdField_a_of_type_ComTencentBizWidgetsScannerView, true);
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidHardwareCamera = null;
        return;
      }
      catch (RuntimeException localRuntimeException2)
      {
        break label77;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      if (ScannerView.b(this.jdField_a_of_type_ComTencentBizWidgetsScannerView)) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cqv
 * JD-Core Version:    0.7.0.1
 */