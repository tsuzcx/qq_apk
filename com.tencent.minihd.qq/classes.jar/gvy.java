import android.content.Intent;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;

public class gvy
  implements Runnable
{
  public gvy(ContactsInnerFrame paramContactsInnerFrame) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.a.a, PhoneFrameActivity.class);
    localIntent.putExtra("call_by_select_member", true);
    localIntent.putExtra("key_req_type", 1);
    this.a.a.startActivityForResult(localIntent, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gvy
 * JD-Core Version:    0.7.0.1
 */