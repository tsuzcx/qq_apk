import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class dpb
  implements View.OnClickListener
{
  public dpb(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onClick(View paramView)
  {
    ChatBackground.b(this.a, this.a.app.getAccount(), ChatSettingActivity.a(this.a), "null");
    QQToast.a(this.a, 2131367510, 0).a();
    ((TextView)ChatSettingActivity.a(this.a).findViewById(2131297125)).setText(2131370018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dpb
 * JD-Core Version:    0.7.0.1
 */