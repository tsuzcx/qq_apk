import android.graphics.Bitmap;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.ipc.IQavCallback;
import com.tencent.qav.ipc.IQavService.Stub;
import com.tencent.qav.ipc.QavCallbackWrapper;
import com.tencent.qav.ipc.QavService;

public class ljj
  extends IQavService.Stub
{
  private ljj(QavService paramQavService) {}
  
  public void a(IQavCallback paramIQavCallback)
  {
    QavCallbackWrapper localQavCallbackWrapper = QavBussinessCtrl.a().a();
    if (localQavCallbackWrapper != null) {
      localQavCallbackWrapper.a(paramIQavCallback);
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    paramString = QavBussinessCtrl.a().a();
    if (paramString != null) {
      paramString.a(paramBitmap);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = QavBussinessCtrl.a().a();
    if (paramString1 != null) {
      paramString1.a(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ljj
 * JD-Core Version:    0.7.0.1
 */