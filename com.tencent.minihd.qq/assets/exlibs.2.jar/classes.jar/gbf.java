import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import mqq.observer.BusinessObserver;

public class gbf
  implements BusinessObserver
{
  public gbf(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramInt = paramBundle.getInt("update_type");
      if (paramInt != 2) {}
    }
    else
    {
      return;
    }
    if (paramInt == 1) {
      PublicAccountChatPie.a(this.a).a();
    }
    PublicAccountChatPie.a(this.a).sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gbf
 * JD-Core Version:    0.7.0.1
 */