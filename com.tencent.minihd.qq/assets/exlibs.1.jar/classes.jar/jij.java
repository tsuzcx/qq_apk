import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.widget.QQToast;

public class jij
  extends Handler
{
  public jij(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1000: 
    case 1001: 
    case 11: 
    case 101: 
      do
      {
        return;
        this.a.a();
        QQToast.a(this.a, 2131369486, 0).b(this.a.getTitleBarHeight());
        return;
        this.a.a.m();
        return;
        NearbyPeopleProfileActivity.a(this.a).c();
        return;
      } while (paramMessage.obj == null);
      NearbyPeopleProfileActivity.a(this.a, (NearbyPeopleCard)paramMessage.obj);
      NearbyPeopleProfileActivity.a(this.a).a(NearbyPeopleProfileActivity.a(this.a), true);
      return;
    case 100: 
      NearbyPeopleProfileActivity.a(this.a).b();
      return;
    }
    NearbyPeopleProfileActivity.a(this.a).a(paramMessage.arg1, paramMessage.arg2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jij
 * JD-Core Version:    0.7.0.1
 */