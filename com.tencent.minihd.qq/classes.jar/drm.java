import android.content.Intent;
import com.tencent.mobileqq.activity.ContactSyncJumpActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class drm
  extends ContactBindObserver
{
  public drm(ContactSyncJumpActivity paramContactSyncJumpActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      int i = ContactSyncJumpActivity.a(this.a).b();
      if ((i == 1) || (i == 2))
      {
        this.a.startActivity(new Intent(this.a, PhoneFrameActivity.class));
        this.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     drm
 * JD-Core Version:    0.7.0.1
 */