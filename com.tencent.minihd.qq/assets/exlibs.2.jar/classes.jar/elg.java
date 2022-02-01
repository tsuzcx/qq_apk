import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class elg
  extends Handler
{
  public elg(NearPeopleFilterActivity paramNearPeopleFilterActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000)
    {
      this.a.c();
      QQToast.a(BaseApplication.getContext(), 2131369486, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     elg
 * JD-Core Version:    0.7.0.1
 */