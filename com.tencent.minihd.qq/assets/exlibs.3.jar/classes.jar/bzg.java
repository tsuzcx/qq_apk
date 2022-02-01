import android.os.Handler;
import com.tencent.av.app.QavChatHandler;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.utils.UITools1;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.bussiness.QavBussinessObserver;
import com.tencent.qav.session.QavSession;
import com.tencent.qphone.base.util.QLog;

public class bzg
  extends QavBussinessObserver
{
  public bzg(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void a(long paramLong)
  {
    Object localObject = QavBussinessCtrl.a().a();
    if ((localObject != null) && (((QavSession)localObject).d()))
    {
      localObject = UITools1.a(paramLong / 1000L);
      QLog.d("DoubleVideoCtrlUI", 2, "onUpdateChatTime " + (String)localObject);
      QavChatHandler.a().b().post(new bzi(this, (String)localObject));
    }
  }
  
  public void a(String paramString)
  {
    DoubleVideoCtrlUI.a(this.a, true);
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void b(String paramString)
  {
    paramString = QavBussinessCtrl.a().a();
    if (paramString != null) {
      QavChatHandler.a().b().post(new bzh(this, paramString));
    }
  }
  
  public void c(String paramString)
  {
    DoubleVideoCtrlUI.a(this.a, false);
  }
  
  public void d(String paramString) {}
  
  public void e(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     bzg
 * JD-Core Version:    0.7.0.1
 */