import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

public class hlx
  extends Thread
{
  public hlx(MessageRoamManager paramMessageRoamManager, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    if (MessageRoamManager.a(this.a).a() != null)
    {
      SharedPreferences localSharedPreferences = MessageRoamManager.a(this.a).getApplication().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0);
      String str = Base64.encodeToString(MessageRoamManager.a(this.a), 0);
      localSharedPreferences.edit().putString("vip_message_roam_passwordmd5" + MessageRoamManager.a(this.a).a(), str).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hlx
 * JD-Core Version:    0.7.0.1
 */