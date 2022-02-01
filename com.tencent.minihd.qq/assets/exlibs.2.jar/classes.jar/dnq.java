import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class dnq
  implements View.OnClickListener
{
  public dnq(ChatHistoryForC2C paramChatHistoryForC2C) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, QQBrowserActivity.class);
    paramView.putExtra("url", ChatHistoryForC2C.a(this.a));
    this.a.startActivity(paramView);
    VipUtils.a(this.a.app, "vip", "0X8004F9C", "0X8004F9C", 0, 0, new String[] { ChatHistoryForC2C.b(this.a) });
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistoryForC2C", 2, "T : 0X8004F9C , userIdentity" + ChatHistoryForC2C.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dnq
 * JD-Core Version:    0.7.0.1
 */