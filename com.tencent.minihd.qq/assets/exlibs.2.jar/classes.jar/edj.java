import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class edj
  extends FriendListObserver
{
  public edj(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.a.app.a()))) {}
    while (this.a.a == null) {
      return;
    }
    paramString = GesturePWDUnlockActivity.a(this.a, this.a.app.a(), true);
    this.a.a.setImageBitmap(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     edj
 * JD-Core Version:    0.7.0.1
 */