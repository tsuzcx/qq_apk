import android.text.TextUtils;
import com.tencent.mobileqq.activity.widget.qqmusic.business.session.SessionManager;
import com.tencent.mobileqq.activity.widget.qqmusic.data.Session;
import com.tencent.mobileqq.activity.widget.qqmusic.network.listener.OnResultListener;
import com.tencent.mobileqq.activity.widget.qqmusic.network.response.CommonResponse;
import com.tencent.mobileqq.activity.widget.qqmusic.network.task.TaskBlockManager;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class hdb
  implements OnResultListener
{
  public hdb(SessionManager paramSessionManager) {}
  
  public void a(int paramInt, String paramString)
  {
    MLog.d("SessionManager", "Session onError : " + paramInt);
    TaskBlockManager.a().b();
    SessionManager.a(this.a, 4);
    SessionManager.a(this.a).set(false);
  }
  
  public void a(CommonResponse paramCommonResponse)
  {
    MLog.a("SessionManager", "Session onSuccess");
    SessionManager.a(this.a).set(false);
    paramCommonResponse = paramCommonResponse.a();
    if ((paramCommonResponse == null) || (!(paramCommonResponse instanceof Session)) || (TextUtils.isEmpty(((Session)paramCommonResponse).b())))
    {
      SessionManager.a(this.a, 4);
      return;
    }
    paramCommonResponse = (Session)paramCommonResponse;
    SessionManager.a(this.a, 1);
    this.a.a(paramCommonResponse.c(), false);
    SessionManager.a(this.a).a(paramCommonResponse.b());
    SessionManager.a(this.a).d(paramCommonResponse.a());
    SessionManager.a(this.a).e(paramCommonResponse.e());
    MLog.a("SessionManager", "Session unBlock");
    TaskBlockManager.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hdb
 * JD-Core Version:    0.7.0.1
 */