import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import friendlist.GetOnlineInfoResp;

public class jpb
  extends FriendListObserver
{
  public jpb(QCallDetailActivity paramQCallDetailActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, QCallDetailActivity.a(this.a)))) {
      this.a.runOnUiThread(new jpc(this));
    }
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    this.a.runOnUiThread(new jpd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jpb
 * JD-Core Version:    0.7.0.1
 */