import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.app.QavChatHandler;
import com.tencent.av.ui.VideoControlUI.ConnectInfo;
import com.tencent.qav.activity.QavInviteActivity;
import com.tencent.qav.bussiness.QavBussinessObserver;

public class lil
  extends QavBussinessObserver
{
  public lil(QavInviteActivity paramQavInviteActivity) {}
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.a())) {
      this.a.jdField_a_of_type_Boolean = true;
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    QavChatHandler.a().b().post(new lim(this, paramString, paramBoolean));
  }
  
  public void b(String paramString, int paramInt)
  {
    super.b(paramString, paramInt);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lil
 * JD-Core Version:    0.7.0.1
 */