import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.app.QavChatHandler;
import com.tencent.av.ui.VideoControlUI.ConnectInfo;
import com.tencent.qav.activity.QavChatActivity;
import com.tencent.qav.bussiness.QavBussinessObserver;
import com.tencent.qav.ui.C2CVideoLayer;

public class lig
  extends QavBussinessObserver
{
  public lig(QavChatActivity paramQavChatActivity) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    if (!QavChatActivity.a(this.a)) {
      QavChatActivity.a(this.a, true);
    }
  }
  
  public void a(String paramString)
  {
    this.a.c(true);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.equals(paramString, QavChatActivity.a(this.a).a()))
    {
      QavChatActivity.a(this.a).a(false, false, true);
      QavChatActivity.b(this.a, false);
      QavChatActivity.a(this.a);
      this.a.b = true;
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    QavChatHandler.a().b().post(new lii(this, paramString, paramBoolean));
  }
  
  public void b(String paramString)
  {
    QavChatActivity.a(this.a, true);
    QavChatActivity.a(this.a).post(new lih(this));
  }
  
  public void b(String paramString, int paramInt)
  {
    super.b(paramString, paramInt);
    this.a.finish();
  }
  
  public void c(String paramString)
  {
    this.a.c(false);
  }
  
  public void d(String paramString) {}
  
  public void e(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lig
 * JD-Core Version:    0.7.0.1
 */