import android.text.TextUtils;
import com.tencent.qav.activity.Qav3rdInviteActivity;
import com.tencent.qav.bussiness.QavBussinessObserver;

public class lid
  extends QavBussinessObserver
{
  public lid(Qav3rdInviteActivity paramQav3rdInviteActivity) {}
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.equals(paramString, Qav3rdInviteActivity.a(this.a))) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lid
 * JD-Core Version:    0.7.0.1
 */