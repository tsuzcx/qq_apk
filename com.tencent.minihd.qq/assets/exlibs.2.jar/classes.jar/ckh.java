import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantSettingActivity;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantSettingAdapter;

public class ckh
  extends Handler
{
  public ckh(PubAccountAssistantSettingActivity paramPubAccountAssistantSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    PubAccountAssistantSettingActivity.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ckh
 * JD-Core Version:    0.7.0.1
 */