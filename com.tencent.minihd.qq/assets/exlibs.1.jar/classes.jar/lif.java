import android.content.Intent;
import com.tencent.qav.activity.Qav3rdInviteActivity;
import com.tencent.qav.activity.QavChatActivity;

public class lif
  implements Runnable
{
  public lif(Qav3rdInviteActivity paramQav3rdInviteActivity, boolean paramBoolean) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentQavActivityQav3rdInviteActivity, QavChatActivity.class);
    localIntent.addFlags(262144);
    localIntent.putExtra("key_peer_uin", Qav3rdInviteActivity.a(this.jdField_a_of_type_ComTencentQavActivityQav3rdInviteActivity));
    localIntent.putExtra("key_only_audio", this.jdField_a_of_type_Boolean);
    localIntent.putExtra("key_is_receiver", true);
    this.jdField_a_of_type_ComTencentQavActivityQav3rdInviteActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lif
 * JD-Core Version:    0.7.0.1
 */