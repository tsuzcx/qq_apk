import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class drb
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public drb(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onGlobalLayout()
  {
    if (this.a.az >= 0) {
      ChatSettingForTroop.a(this.a, this.a.az);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     drb
 * JD-Core Version:    0.7.0.1
 */