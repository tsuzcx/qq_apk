import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class dnj
  implements View.OnClickListener
{
  public dnj(ChatHistoryForC2C paramChatHistoryForC2C) {}
  
  public void onClick(View paramView)
  {
    VipUtils.a(this.a.app, "vip", "0X8004FAD", "0X8004FAD", 0, 0, new String[] { ChatHistoryForC2C.b(this.a) });
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistoryForC2C", 2, "点击删除按钮的 ，T ：0X8004FAD ， userIdentity" + ChatHistoryForC2C.b(this.a));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = ((MessageRoamManager)this.a.app.getManager(86)).a(this.a.c, this.a.a, localStringBuilder);
    Object localObject = null;
    paramView = localObject;
    if (localStringBuilder != null)
    {
      paramView = localObject;
      if (localStringBuilder.length() > 0) {
        paramView = localStringBuilder.toString();
      }
    }
    if (i > 0)
    {
      this.a.a(paramView);
      return;
    }
    this.a.b(this.a.getString(2131367019));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dnj
 * JD-Core Version:    0.7.0.1
 */