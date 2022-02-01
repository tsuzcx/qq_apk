import android.text.TextUtils;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.QZoneManagerImp;

public class egf
  extends FriendListObserver
{
  public egf(Leba paramLeba) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    while ((QZoneManagerImp)this.a.app.getManager(9) == null) {
      return;
    }
    Leba.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     egf
 * JD-Core Version:    0.7.0.1
 */